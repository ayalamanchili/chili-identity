/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.invite;

import com.google.common.base.Strings;
import info.chili.email.Email;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.invite.InviteCodeDao;
import info.yalamanchili.office.dao.profile.immigration.ImmigrationCaseDao;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.profile.invite.InvitationType;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import info.yalamanchili.office.jms.MessagingService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rohith.Vallabhaneni
 */
@Component
@Scope("prototype")
@Transactional
public class InviteCodeService {

    @Autowired
    protected MongoOperations mongoTemplate;
    @Autowired
    public InviteCodeDao inviteCodeDao;

    public static InviteCodeService instance() {
        return SpringContext.getBean(InviteCodeService.class);
    }

    public InviteCodeTable getCaseInviteCodes(Long caseId, int start, int limit) {
        ImmigrationCase iCase = ImmigrationCaseDao.instance().findById(caseId);
        InviteCodeTable res = new InviteCodeTable();
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "expiryDate"));
        mongoTemplate.find(query.limit(limit).skip(start), InviteCode.class).stream().filter((inviteCode) -> (inviteCode.getEmail().equals(iCase.getEmail()) && inviteCode.getInviteType() != null && inviteCode.getInviteType().getInvitationType().equals(InvitationType.H1B_Questionnaire))).map((inviteCode) -> {
            InviteCodeDto dto = new InviteCodeDto();
            dto.setId(inviteCode.getId());
            dto.setInvitationCode(inviteCode.getInvitationCode());
            dto.setExpiryDate(inviteCode.getExpiryDate());
            dto.setValidFromDate(inviteCode.getValidFromDate());
            dto.setEmail(inviteCode.getEmail());
            if (inviteCode.getInviteType() != null) {
                dto.setInvitationType(inviteCode.getInviteType().getInvitationType());
                
            }
            return dto;
        }).forEach((dto) -> {
            res.getEntities().add(dto);
        });
        res.setSize(Long.valueOf(res.getEntities().size()));
        return res;
    }

    public InviteCodeTable getInviteCodes(int start, int limit) {
        InviteCodeTable res = new InviteCodeTable();
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "expiryDate"));
        for (InviteCode inviteCode : mongoTemplate.find(query.limit(limit).skip(start), InviteCode.class)) {
            InviteCodeDto dto = new InviteCodeDto();
            dto.setId(inviteCode.getId());
            dto.setInvitationCode(inviteCode.getInvitationCode());
            dto.setExpiryDate(inviteCode.getExpiryDate());
            dto.setValidFromDate(inviteCode.getValidFromDate());
            dto.setEmail(inviteCode.getEmail());
            if (inviteCode.getInviteType() != null) {
                dto.setInvitationType(inviteCode.getInviteType().getInvitationType());

            }
            res.getEntities().add(dto);
        }
        res.setSize(mongoTemplate.count(query, InviteCode.class));
        return res;
    }

    public List<InviteCodeDto> searchInviteCodes(InviteCodeDto search) {
        List<InviteCodeDto> res = new ArrayList();
        Query query = new Query();
        if (!Strings.isNullOrEmpty(search.getInvitationCode())) {
            query.addCriteria(Criteria.where("invitationCode").regex(search.getInvitationCode(), "i"));
        }
        if (!Strings.isNullOrEmpty(search.getEmail())) {
            query.addCriteria(Criteria.where("email").regex(search.getEmail(), "i"));
        }
        query.with(new Sort(Sort.Direction.DESC, "expiryDate"));
        for (InviteCode inviteCode : mongoTemplate.find(query.limit(100), InviteCode.class)) {
            InviteCodeDto dto = new InviteCodeDto();
            dto.setId(inviteCode.getId());
            dto.setInvitationCode(inviteCode.getInvitationCode());
            dto.setExpiryDate(inviteCode.getExpiryDate());
            dto.setValidFromDate(inviteCode.getValidFromDate());
            dto.setEmail(inviteCode.getEmail());
            if (inviteCode.getInviteType().getInvitationType() != null) {
                dto.setInvitationType(inviteCode.getInviteType().getInvitationType());
            }
            res.add(dto);
        }
        return res;
    }

    public void sendExpiryDateAlertNotification() {
        List<InviteCode> inviteCodes = inviteCodeDao.query();
        if (inviteCodes.size() > 0) {
            int reminderDays = 3;
            for (InviteCode inviteCode : inviteCodes) {
                Email email = new Email();
                if (DateUtils.isSameDay(DateUtils.addDays(new Date(), reminderDays), inviteCode.getExpiryDate())) {
                    email.addTo(inviteCode.getEmail());
                    email.setHtml(Boolean.TRUE);
                    email.setRichText(Boolean.TRUE);
                    email.setSubject("Invitation Link about to expire: " + inviteCode.getInviteType().getDescription());
                    String messageText = " <b>Your Invitation Link is About to"
                            + " expire in 3 days! Please go to the below url and"
                            + " complete it as soon as possible.  </b> </br> "
                            + OfficeServiceConfiguration.instance().getPortalWebUrl()
                            + "?inviteCode=" + inviteCode.getInvitationCode();
                    email.setBody(messageText);
                    MessagingService.instance().sendEmail(email);
                }
            }

        }
    }

    @XmlRootElement
    @XmlType
    public static class InviteCodeDto implements java.io.Serializable {

        protected String id;
        protected String invitationCode;
        protected Date expiryDate;
        protected Date validFromDate;
        protected String email;

        protected InvitationType invitationType;

        /**
         * @return the invitationCode
         */
        public String getInvitationCode() {
            return invitationCode;
        }

        /**
         * @param invitationCode the invitationCode to set
         */
        public void setInvitationCode(String invitationCode) {
            this.invitationCode = invitationCode;
        }

        /**
         * @return the expiryDate
         */
        public Date getExpiryDate() {
            return expiryDate;
        }

        /**
         * @param expiryDate the expiryDate to set
         */
        public void setExpiryDate(Date expiryDate) {
            this.expiryDate = expiryDate;
        }

        /**
         * @return the validFromDate
         */
        public Date getValidFromDate() {
            return validFromDate;
        }

        /**
         * @param validFromDate the validFromDate to set
         */
        public void setValidFromDate(Date validFromDate) {
            this.validFromDate = validFromDate;
        }

        /**
         * @return the email
         */
        public String getEmail() {
            return email;
        }

        /**
         * @param email the email to set
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         * @return the invitationType
         */
        public InvitationType getInvitationType() {
            return invitationType;
        }

        /**
         * @param invitationType
         */
        public void setInvitationType(InvitationType invitationType) {
            this.invitationType = invitationType;
        }

        /**
         * @return the id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(String id) {
            this.id = id;
        }
    }

    @XmlRootElement
    @XmlType
    public static class InviteCodeTable implements java.io.Serializable {

        protected Long size;
        protected List<InviteCodeDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<InviteCodeDto> getEntities() {
            if (this.entities == null) {
                this.entities = new ArrayList<>();
            }
            return entities;
        }

        public void setEntities(List<InviteCodeDto> entities) {
            this.entities = entities;
        }
    }
}