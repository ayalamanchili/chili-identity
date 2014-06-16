/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.drive;

import info.yalamanchili.office.entity.drive.File;
import java.io.Serializable;
import java.util.Date;
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
@XmlRootElement(name = "File")
@XmlType
public class FileDto implements Serializable {

    protected Long id;
    @NotEmpty(message = "{file.not.empty.msg}")
    protected String name;
    @NotEmpty
    protected String fileUrl;
    protected Date updatedTs;
    protected String updatedBy;
    protected FolderDto folder;

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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Date getUpdatedTs() {
        return updatedTs;
    }

    public void setUpdatedTs(Date updatedTs) {
        this.updatedTs = updatedTs;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @XmlTransient
    public FolderDto getFolder() {
        return folder;
    }

    public void setFolder(FolderDto folder) {
        this.folder = folder;
    }

    public static FileDto map(Mapper mapper, File file) {
        FileDto fileDto = mapper.map(file, FileDto.class);
        return fileDto;
    }

    @XmlRootElement
    @XmlType
    public static class FileTable implements java.io.Serializable{

        protected Long size;
        protected List<FileDto> entities;

        public Long getSize() {
            return size;
        }

        public void setSize(Long size) {
            this.size = size;
        }

        @XmlElement
        public List<FileDto> getEntities() {
            return entities;
        }

        public void setEntities(List<FileDto> entities) {
            this.entities = entities;
        }
    }
}
