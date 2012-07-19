/** 
 * Automanage 
 * Copyright (C) 2011 yalamanchili.info 
 */

package info.yalamanchili.office.entity.profile;

import info.chili.jpa.validation.Unique;
import info.yalamanchili.jpa.AbstractEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @todo add comment for javadoc
 * @author ayalamanchili
 * @generated
 */
@Indexed
@XmlRootElement
@Entity
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"emailType"}))
public class EmailType extends AbstractEntity {
	/**
	 * @generated
	 */
	@Transient
	private static final long serialVersionUID = 9L;

	/**
	 * @generated
	 */
	@Field
	@NotEmpty
        //@Unique(entity = Certification.class, property = "name", message="{emailtype.name.already.exists}")
	protected String emailType;

	/**
	 * @generated
	 */

	@OneToMany(mappedBy = "emailType")
	protected List<Email> emails;

	/**
	 * @generated
	 */
	public EmailType() {
		super();
	}

	/**
	 * @generated
	 */
	public String getEmailType() {
		return emailType;
	}

	/**
	 * @generated
	 */
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	/**
	 * @generated
	 */
	@XmlTransient
	public List<Email> getEmails() {
		if (this.emails == null) {
			this.emails = new ArrayList<Email>();
		}
		return this.emails;
	}

	/**
	 * @generated
	 */
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	/**
	 * @generated
	 */
	public void addEmail(Email entity) {
		if (entity == null) {
			return;
		}
		getEmails().add(entity);
		entity.setEmailType(this);
	}

	/**
	 * @generated
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getEmailType());
		sb.append(":");
		return sb.toString();
	}

}
