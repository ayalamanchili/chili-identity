package info.chili.gwt.fields;

import info.chili.gwt.composite.BaseFieldWithTextBox;

import java.math.BigDecimal;

import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Window;
import info.chili.gwt.utils.Alignment;

public class CurrencyField extends BaseFieldWithTextBox {
    // TODO add Local info to constructor

    protected static NumberFormat fmt = NumberFormat.getCurrencyFormat();

    public CurrencyField(ConstantsWithLookup constants, String attributeName, String className, Boolean readOnly, Boolean isRequired, Alignment alignment) {
        super(constants, attributeName, className, readOnly, isRequired, alignment);
    }

    @Deprecated
    public CurrencyField(ConstantsWithLookup constants, String attributeName, String className, Boolean readOnly, Boolean isRequired) {
        super(constants, attributeName, className, readOnly, isRequired);
    }

    public BigDecimal getCurrency() {
        BigDecimal value = null;
        if (textbox.getText() == null || textbox.getText().trim().equals("")) {
            return null;
        }
        try {
            value = new BigDecimal(textbox.getText());
        } catch (NumberFormatException e) {
            Window.alert("please enter a valid amount");
            return null;
        }
        return value;
    }

    public void setValue(BigDecimal var, boolean format) {
        if (var != null) {
            if (format) {
                textbox.setText(fmt.format(var));
            } else {
                textbox.setText(var.toString());
            }
        }
    }

    public static String format(BigDecimal value) {
        return (value == null) ? "" : fmt.format(value);
    }

    @Override
    public void onKeyPress(KeyPressEvent event) {
        Integer eventValue = (int) event.getCharCode();
        // TODO check is the entered key is number or dot
        if (!(Character.isDigit(event.getCharCode()) || eventValue.equals(new Integer(46)))) {
            setMessage("invalid value");
            textbox.cancelKey();
        } else {
            clearMessage();
        }

    }

    @Override
    public void onKeyUp(KeyUpEvent arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onKeyDown(KeyDownEvent arg0) {
        // TODO Auto-generated method stub
    }
    // TODO
    // check validation on loose focus?
}
