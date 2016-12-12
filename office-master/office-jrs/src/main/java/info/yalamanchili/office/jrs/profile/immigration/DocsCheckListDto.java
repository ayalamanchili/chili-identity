/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.profile.immigration;

import info.chili.service.jrs.types.Entry;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author radhika.mukkala
 */
@XmlRootElement
@XmlType
public class DocsCheckListDto implements Serializable {

    private List<Entry> docsCheckList;

    public List<Entry> getDocsCheckList() {
        return docsCheckList;
    }

    public void setDocsCheckList(List<Entry> docsCheckList) {
        this.docsCheckList = docsCheckList;
    }
}