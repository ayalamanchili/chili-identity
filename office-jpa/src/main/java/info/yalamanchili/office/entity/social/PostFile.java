/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.social;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.FileType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.envers.Audited;

/**
 *
 * @author ayalamanchili
 */
@Entity
@Audited
@XmlRootElement
@XmlType
public class PostFile extends AbstractEntity {

    protected String fileURL;
    protected FileType fileType;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ForeignKey(name = "FK_Post_PostFiles")
    protected Post post;

    public PostFile() {
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "PostFile{" + "fileURL=" + fileURL + ", fileType=" + fileType + '}';
    }
}
