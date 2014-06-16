/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.drive;

import info.yalamanchili.office.entity.drive.Folder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.dozer.Mapper;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author yphanikumar
 */
@XmlRootElement(name = "Folder")
@XmlType
public class FolderDto implements Serializable {

    protected Long id;
    @NotEmpty(message = "{folder.not.empty.msg}")
    protected String name;
    protected String description;
    protected FolderDto parent;
    protected List<FolderDto> children;
    protected List<FileDto> files;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public FolderDto getParent() {
        return parent;
    }

    public void setParent(FolderDto parent) {
        this.parent = parent;
    }

    @XmlElement
    public List<FolderDto> getChildren() {
        if (this.children == null) {
            this.children = new ArrayList<FolderDto>();
        }
        return children;
    }

    public void setChildren(List<FolderDto> children) {
        this.children = children;
    }

    @XmlTransient
    public List<FileDto> getFiles() {
        if (this.files == null) {
            this.files = new ArrayList<FileDto>();
        }
        return files;
    }

    public void setFiles(List<FileDto> files) {
        this.files = files;
    }

    public static FolderDto map(Mapper mapper, Folder folder) {
        FolderDto folderDto = mapper.map(folder, FolderDto.class);
        return folderDto;
    }

    @XmlRootElement
    @XmlType
    public static class FolderTable implements java.io.Serializable{

        protected Long size;
        protected List<FolderDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<FolderDto> getEntities() {
            return entities;
        }

        public void setEntities(List<FolderDto> entities) {
            this.entities = entities;
        }
    }
}
