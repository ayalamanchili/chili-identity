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
import info.yalamanchili.office.entity.profile.invite.InvitationType;
import info.yalamanchili.office.entity.profile.invite.InviteCode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.StringUtils;
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

    public InviteCodeTable getCode(int start, int limit) {
        InviteCodeTable res = new InviteCodeTable();
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "expiryDate"));
        for (InviteCode inviteCode : mongoTemplate.find(query.limit(limit).skip(start), InviteCode.class)) {
            InviteCodeDto dto = new InviteCodeDto();
            dto.setInvitationCode(StringUtils.join(inviteCode.getInvitationCode(), ", "));
            dto.setExpiryDate(inviteCode.getExpiryDate());
            dto.setValidFromDate(inviteCode.getValidFromDate());
            dto.setEmail(inviteCode.getEmail());
            dto.setInvitationType(inviteCode.getInviteType().getInvitationType());
            res.getEntities().add(dto);
        }
        res.setSize(mongoTemplate.count(query, InviteCode.class));
        return res;
    }

    public List<InviteCodeDto> searchCode(InviteCodeDto search) {
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
            dto.setInvitationCode(StringUtils.join(inviteCode.getInvitationCode(), ", "));
            dto.setExpiryDate(inviteCode.getExpiryDate());
            dto.setValidFromDate(inviteCode.getValidFromDate());
            dto.setEmail(inviteCode.getEmail());
            dto.setInvitationType(inviteCode.getInviteType().getInvitationType());
            res.add(dto);
        }
        return res;
    }

    @XmlRootElement
    @XmlType
    public static class InviteCodeDto implements java.io.Serializable {

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
