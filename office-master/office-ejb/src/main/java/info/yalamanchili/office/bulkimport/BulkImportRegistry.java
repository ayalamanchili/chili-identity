/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bulkimport;

import info.chili.spring.SpringContext;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class BulkImportRegistry {

    public Map<String, String> adapterMap = new HashMap<String, String>();

    public void register(String key, String componentName) {
        adapterMap.put(key, componentName);
    }

    public void getAllBeans() {
        SpringContext.getApplicationContext().getBeanNamesForType(null);
    }

    public static BulkImportRegistry instance() {
        return SpringContext.getBean(BulkImportRegistry.class);
    }
}
