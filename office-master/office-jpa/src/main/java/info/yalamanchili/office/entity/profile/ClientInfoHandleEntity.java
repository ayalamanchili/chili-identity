/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.profile;

import info.chili.jpa.AbstractHandleEntity;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author radhika.mukkala
 */
@Indexed
@XmlRootElement
@Entity
@Audited
public class ClientInfoHandleEntity extends AbstractHandleEntity {
}