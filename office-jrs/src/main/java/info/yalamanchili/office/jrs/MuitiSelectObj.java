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
public class MuitiSelectObj {

    protected Map<String, String> available;
    protected Set<String> selected;

    public MuitiSelectObj() {
    }

    public Map<String, String> getAvailable() {
        return available;
    }

    public void setAvailable(Map<String, String> available) {
        this.available = available;
    }

    public Set<String> getSelected() {
        return selected;
    }

    public void setSelected(Set<String> selected) {
        this.selected = selected;
    }

    public void addAvailable(String key, String value) {
        if (getAvailable() == null) {
            available = new HashMap<String, String>();
        }
        available.put(key, value);
    }

    public void addSelected(String key) {
        if (getSelected() == null) {
            selected = new HashSet<String>();
        }
      selected.add(key);
    }

    @Override
    public String toString() {
        return "MuitiSelectObj{" + "available=" + available + ", selected=" + selected + '}';
    }
}
