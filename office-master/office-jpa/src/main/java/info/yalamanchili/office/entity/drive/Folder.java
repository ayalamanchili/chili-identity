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
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author yphanikumar
 */
@Entity
public class Folder extends AbstractEntity {

    protected String name;
    protected String description;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    protected List<Folder> children;
    @ManyToOne(fetch=FetchType.LAZY)
    @ForeignKey(name = "FK_ParentFolder_ChildrenFolders")
    protected Folder parent;

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

    public Folder getParent() {
        return parent;
    }

    public void setParent(Folder parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Folder{" + "name=" + name + ", description=" + description + '}';
    }
}
