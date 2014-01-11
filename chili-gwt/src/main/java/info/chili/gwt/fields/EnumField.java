package info.chili.gwt.fields;

import com.google.gwt.i18n.client.ConstantsWithLookup;
import info.chili.gwt.composite.BaseField;

import java.util.logging.Logger;

import com.google.gwt.user.client.ui.ListBox;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import java.util.HashMap;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class EnumField.
 */
public class EnumField extends BaseField {

    Logger logger = Logger.getLogger(EnumField.class.getName());
    protected final ListBox listBox = new ListBox();

    public EnumField(ConstantsWithLookup constants, String attributeName, String className, Boolean readOnly, Boolean isRequired,
            String[] values, Alignment alignment) {
        super(constants, attributeName, className, readOnly, isRequired, alignment);
        configureAddMainWidget();
        for (String value : values) {
            listBox.addItem(JSONUtils.formatEnumString(value), value.toString());
        }
        setReadOnly(readOnly);
    }

    public EnumField(ConstantsWithLookup constants, String attributeName, String className, Boolean readOnly, Boolean isRequired,
            String[] values) {
        super(constants, attributeName, className, readOnly, isRequired);
        configureAddMainWidget();
        for (String value : values) {
            listBox.addItem(JSONUtils.formatEnumString(value), value.toString());
        }
        setReadOnly(readOnly);
    }

    public EnumField(ConstantsWithLookup constants, String attributeName, String className, Boolean readOnly, Boolean isRequired,
            HashMap<String, String> values) {
        super(constants, attributeName, className, readOnly, isRequired);
        configureAddMainWidget();
        for (Map.Entry<String, String> value : values.entrySet()) {
            listBox.addItem(value.getValue(), value.getKey());
        }
        setReadOnly(readOnly);
    }

    public void setValue(String var) {
        listBox.clear();
        listBox.addItem(var);
    }

    public void selectValue(String value) {
        for (int i = 0; i < listBox.getItemCount(); i++) {
            if (listBox.getItemText(i) != null && listBox.getItemText(i).equalsIgnoreCase(value)) {
                listBox.setSelectedIndex(i);
            }
        }
    }

    public String getValue() {
        if (listBox.getSelectedIndex() > 0) {
            return listBox.getValue(listBox.getSelectedIndex());
        } else {
            return null;
        }
    }

    @Override
    protected void configureAddMainWidget() {
        listBox.insertItem("SELECT", 0);
        listBox.ensureDebugId(className + "_" + attributeName + "_LB");
        fieldPanel.insert(listBox, 0);
    }

    public void setReadOnly(Boolean readOnly) {
        listBox.setEnabled(!readOnly);
    }

    public void setSelectedIndex(int index) {
        listBox.setSelectedIndex(index);
    }

    @Override
    public void validate() {
        clearMessage();
    }
}
