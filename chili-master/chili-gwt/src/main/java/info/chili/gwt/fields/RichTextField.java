package info.chili.gwt.fields;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.widgets.RichTextToolBar;

import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import info.chili.gwt.utils.Alignment;
import java.util.logging.Logger;

public class RichTextField extends BaseField {

    private Logger logger = Logger.getLogger(RichTextField.class.getName());
    public RichTextArea area = new RichTextArea();
    public RichTextToolBar bar = new RichTextToolBar(area);

    public RichTextField(ConstantsWithLookup constants, String attributeName, String className, Boolean readOnly, Boolean isRequired, Alignment alignment) {
        super(constants, attributeName, className, readOnly, isRequired, alignment);
        configureAddMainWidget();
        setReadOnly(readOnly);
        //ie richtextarea focus fix
        Scheduler.get().scheduleFinally(new ScheduledCommand() {
            @Override
            public void execute() {
                area.setFocus(true);
            }
        });
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            @Override
            public void execute() {
                area.setFocus(false);
            }
        });
    }

    //TODO depreciate this 
    @UiConstructor
    @Deprecated
    public RichTextField(ConstantsWithLookup constants, String attributeName, String className, Boolean readOnly, Boolean isRequired) {
        super(constants, attributeName, className, readOnly, isRequired);
        configureAddMainWidget();
        setReadOnly(readOnly);
        Scheduler.get().scheduleFinally(new ScheduledCommand() {
            @Override
            public void execute() {
                area.setFocus(true);
            }
        });
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {
            @Override
            public void execute() {
                area.setFocus(false);
            }
        });
    }

    @Override
    protected void configureAddMainWidget() {
        area.ensureDebugId(className + "_" + attributeName + "_TB");
        area.addStyleName("y-gwt-RichTextEditor");
        bar.addStyleName("y-gwt-RichTexttoolBar");
        if (panel instanceof FlowPanel) {
            ((FlowPanel) panel).insert(bar, 1);
        } else if (panel instanceof HorizontalPanel) {
            ((HorizontalPanel) panel).insert(bar, 1);
        }
        fieldPanel.insert(area, 0);
    }

    public String getValue() {
        return area.getText();
    }

    public void setValue(String value) {
        area.setText(value);
    }

    public void setHtml(String html) {
        area.setHTML(html);
    }

    public String getHtml() {
        return area.getHTML();
    }

    @Override
    public void validate() {
        clearMessage();
    }

    public void setWidth(String width) {
        fieldPanel.setWidth(width);
        area.setWidth(width);
    }

    public void setHeightAndWidth(String height, String width) {
        area.setHeight(height);
        area.setWidth(width);
        fieldPanel.setWidth(width);
    }

    @Override
    public void setReadOnly(Boolean readOnly) {
        bar.setVisible(!readOnly);
        area.setEnabled(!readOnly);
    }

    @Override
    public void focus(boolean focus) {
        area.setFocus(true);
    }
}
