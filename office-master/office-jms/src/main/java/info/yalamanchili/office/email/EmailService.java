/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import com.google.common.base.Strings;
import com.google.common.xml.XmlEscapers;
import info.chili.commons.HtmlUtils;
import info.chili.email.dao.UserEmailPreferenceRuleDao;
import info.chili.exception.FaultEventException;
import info.chili.exception.FaultEventPayload;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.cache.OfficeCacheManager;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.security.SecurityUtils;
import info.yalamanchili.office.template.TemplateService;
import java.io.File;
import java.util.logging.Logger;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;

/**
 *
 * @author yalamanchili
 */
@Component
@Transactional
public class EmailService {

    private static Logger logger = Logger.getLogger(EmailService.class.getName());
    protected JavaMailSender mailSender;
    @Autowired
    protected OfficeServiceConfiguration officeServiceConfiguration;

    @Autowired
    protected OfficeCacheManager officeCacheManager;

    @Async
    @Transactional
    public void sendEmail(final Email email) {
        final Address[] tos = convertToEmailAddress(filterEmails(email, email.getTos()));
        if (tos.length < 1) {
            return;
        }

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                mimeMessage.setRecipients(Message.RecipientType.BCC, tos);
                mimeMessage.setSubject(email.getSubject());
                message.setText(processEmailBodyFromTemplate(email), true);
                processAttchments(message, email);
            }
        };
        try {
            logger.info("sending email:" + email);
            mailSender.send(preparator);
        } catch (MailException ex) {
            logger.info(ex.getMessage());
            ex.printStackTrace();
            throw new FaultEventException(new FaultEventPayload(email, Email.class.getCanonicalName()), false, ex);
        }
    }

    protected String processEmailBodyFromTemplate(Email email) {
        Context emailCtx = new Context();
        Map<String, Object> ctx = email.getContext();
        if (ctx == null) {
            emailCtx.setVariable("email", email);
            cleanEmailHtmlBody(email);
        } else {
            emailCtx.setVariables(ctx);
        }
        return TemplateService.instance().processTemplate(getTemplateName(email), emailCtx);
    }

    protected String getTemplateName(Email email) {
        if (email.getTemplateName() != null) {
            return email.getTemplateName();
        }
        if (email.isRichText()) {
            return "rich_text_email_template.html";
        } else if (email.isHtml()) {
            return "default_html_email_template.html";
        } else {
            return "default_email_template.html";
        }
    }

    protected void cleanEmailHtmlBody(Email email) {
        if (email.isRichText()) {
            email.setBody(HtmlUtils.cleanData(email.getBody()));
        } else {
            //escape & # special chars for task emails
            email.setBody(XmlEscapers.xmlAttributeEscaper().escape(email.getBody()));
        }
    }

    protected void processAttchments(MimeMessageHelper message, Email email) throws MessagingException {
        for (String attachmentName : email.getAttachments()) {
            File attachment = new File(officeServiceConfiguration.getContentManagementLocationRoot() + attachmentName);
            if (attachment.exists()) {
                message.addAttachment(attachment.getName(), attachment);
            }
        }
    }

    private Address[] convertToEmailAddress(Set<String> emails) {
        List<Address> addresses = new ArrayList<>();
        emails.stream().forEach((emailAddress) -> {
            InternetAddress address = null;
            try {
                if (!Strings.isNullOrEmpty(emailAddress)) {
                    address = new InternetAddress(emailAddress, true);
                    address.validate();
                    addresses.add(address);
                }
            } catch (AddressException ex) {
                MailUtils.logExceptionDetials(ex);
                logger.log(Level.WARNING, ex.getMessage());
            }
        });
        return addresses.toArray(new Address[addresses.size()]);
    }

    protected Set<String> filterEmails(Email emailObj, Set<String> emails) {
        Set<String> result = new HashSet<>();
        if (OfficeServiceConfiguration.instance().isFilterEmails()) {
            String testEmailProvider = OfficeServiceConfiguration.instance().getTestEmailProvider();
            emails.stream().filter((email) -> (email.contains(testEmailProvider) || email.contains(OfficeServiceConfiguration.instance().getAdminEmail()))).forEach((email) -> {
                result.add(email);
            });
        } else {
            emails.stream().filter((email) -> (notificationsEnabled(emailObj, email))).forEach((email) -> {
                result.add(email);
            });
        }
        return result;
    }

    public Boolean notificationsEnabled(Email emailObj, String emailAddress) {
        if (officeCacheManager.contains(OfficeCacheKeys.EMAILS, emailAddress)) {
            return (Boolean) officeCacheManager.get(OfficeCacheKeys.EMAILS, emailAddress);
        }
        info.yalamanchili.office.entity.profile.Email email = findEmail(emailAddress);
        if (email != null && email.getContact() instanceof Employee) {
            Employee emp = (Employee) findEmail(emailAddress).getContact();
            //TODO check active?
            if (!emp.getPreferences().getEnableEmailNotifications()) {
                officeCacheManager.put(OfficeCacheKeys.EMAILS, emailAddress, false);
                return false;
            }
            if (disableEmailByRules(emp, emailObj, emailAddress)) {
                return false;
            }

        }
        officeCacheManager.put(OfficeCacheKeys.EMAILS, emailAddress, true);
        return true;
    }

    @Autowired
    protected UserEmailPreferenceRuleDao userEmailPreferenceRuleDao;

    protected boolean disableEmailByRules(Employee emp, Email emailObj, String emailAddress) {
        if (!Strings.isNullOrEmpty(emailObj.getEmailPreferenceRuleId()) && userEmailPreferenceRuleDao.findRuleForUser(emp.getEmployeeId(), emailObj.getEmailPreferenceRuleId()) != null) {
            return true;
        }
        //TODO check process and task related stuff
        return false;
    }

    @PersistenceContext
    protected EntityManager em;

//TODO update to return just emp preferecnes
    public info.yalamanchili.office.entity.profile.Email findEmail(String emailAddress) {
        Query getEmailQ = em.createQuery("from " + info.yalamanchili.office.entity.profile.Email.class.getCanonicalName() + " where emailHash=:emailAddressParam");
        getEmailQ.setParameter("emailAddressParam", SecurityUtils.hash(emailAddress));
        if (getEmailQ.getResultList().size() > 0) {
            info.yalamanchili.office.entity.profile.Email email = (info.yalamanchili.office.entity.profile.Email) getEmailQ.getResultList().get(0);
            return email;
        } else {
            return null;
        }
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public static EmailService instance() {
        return SpringContext.getBean(EmailService.class);
    }
}
