/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class MultiSelectObj {

    protected Map<String, String> available;
    protected Set<String> selected;

    public MultiSelectObj() {
    }

    public Map<String, String> getAvailable() {
        if (available == null) {
            this.available = new HashMap<String, String>();
        }
        return available;
    }

    public void setAvailable(Map<String, String> available) {
        this.available = available;
    }

    public Set<String> getSelected() {
        if (selected == null) {
            this.selected = new HashSet<String>();
        }
        return selected;
    }

    public void setSelected(Set<String> selected) {
        this.selected = selected;
    }

    public void addAvailable(String key, String value) {
        getAvailable().put(key, value);
    }

    public void addSelected(String key) {
        getSelected().add(key);
    }

    @Override
    public String toString() {
        return "MuitiSelectObj{" + "available=" + available + ", selected=" + selected + '}';
    }
}
