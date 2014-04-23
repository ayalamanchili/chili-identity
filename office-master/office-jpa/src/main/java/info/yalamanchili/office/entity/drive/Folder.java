/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.entity.drive;

import info.chili.jpa.AbstractEntity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author yphanikumar
 */
@Entity
public class Folder extends AbstractEntity {
    @Transient
    private static final long serialVersionUID = 1L;
    
    @NotEmpty(message = "{folder.not.empty.msg}")
    @Index(name = "FLDR_NM")
    protected String name;
    protected String description;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    protected List<Folder> children;
    @ManyToOne(fetch = FetchType.LAZY)
    @ForeignKey(name = "FK_ParentFolder_ChildrenFolders")
    protected Folder parent;
    @OneToMany(mappedBy = "folder", cascade = CascadeType.ALL)
    protected List<File> files;

    public Folder() {
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

    public List<Folder> getChildren() {
        if (this.children == null) {
            this.children = new ArrayList<Folder>();
        }
        return children;
    }

    public void setChildren(List<Folder> children) {
        this.children = children;
    }

    public void addChild(Folder folder) {
        this.getChildren().add(folder);
        folder.setParent(this);
    }

    public Folder getParent() {
        return parent;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    public List<File> getFiles() {
        if (this.files == null) {
            this.files = new ArrayList<File>();
        }
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public void addFile(File file) {
        this.getFiles().add(file);
        file.setFolder(this);
    }

    @Override
    public String toString() {
        return "Folder{" + "name=" + name + ", description=" + description + '}';
    }
}
