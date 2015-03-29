/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.ext;

import info.chili.jpa.AbstractHandleEntity;
import info.chili.jpa.validation.Unique;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.Index;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author ayalamanchili
 */
@Entity
@Audited
@XmlRootElement
@XmlType
@Unique(entity = ExternalRef.class, fields = {"externalId","source"}, message = "{external.ref.not.unique.msg}")
public class ExternalRef extends AbstractHandleEntity {

    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @NotEmpty
    @Index(name = "EXT_REF_ID")
    protected String externalId;
    /**
     *
     */
    @NotEmpty
    @Index(name = "EXT_REF_SRC")
    protected String source;

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
