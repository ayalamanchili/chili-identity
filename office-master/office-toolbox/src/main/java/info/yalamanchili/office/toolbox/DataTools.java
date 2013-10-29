/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.toolbox;

import info.chili.jpa.validation.ValidationUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmailDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jasypt.digest.StringDigester;
import org.jasypt.hibernate.encryptor.HibernatePBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Transactional
public class DataTools {

    private final static Logger logger = Logger.getLogger(DataTools.class.getName());
    @PersistenceContext
    protected EntityManager em;
    @Autowired
    private StringDigester officeStringDigester;
    @Autowired
    private HibernatePBEStringEncryptor hibernateStringEncryptor;
    /*
     * query all emails and merge them to save/populate the email hash field in database
     */

    public void hashEmails() {
        for (Email email : EmailDao.instance().query(0, EmailDao.instance().size().intValue())) {
            email.setEmailHash(officeStringDigester.digest(email.getEmail()));
            email = em.merge(email);
            em.flush();
        }
    }

    public String hash(String str) {
        return officeStringDigester.digest(str);
    }

    public String encrypt(String str) {
        return hibernateStringEncryptor.encrypt(str);
    }

    public String decrypt(String str) {
        return hibernateStringEncryptor.decrypt(str);
    }

    public void fixSSN() {
        for (Employee emp : EmployeeDao.instance().query(0, 1000)) {
            if (emp.getSsn() != null && !emp.getSsn().trim().isEmpty()) {
                if (!validateNumbers(emp.getSsn())) {
                    logger.log(Level.SEVERE, "invalid ssn:{0}", emp.getEmployeeId() + ":" + emp.getSsn());
                }
                if (emp.getSsn().contains("-")) {
                    System.out.println("oldssn" + emp.getSsn());
                    emp.setSsn(emp.getSsn().replace("-", ""));
                    if (ValidationUtils.validate(emp).isEmpty()) {
                        em.merge(emp);
                    } else {
                        logger.log(Level.SEVERE, "validation error:{0}", emp);
                    }

                }
            }
        }
    }

    protected boolean validateNumbers(String str) {
        Pattern digitPattern = Pattern.compile("^(\\d{9})$");
        return digitPattern.matcher(str).matches();
    }

    public static DataTools instance() {
        return SpringContext.getBean(DataTools.class);
    }
}
