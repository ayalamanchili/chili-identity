package info.chili.gwt.composite;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import info.chili.gwt.resources.ChiliImages;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.Utils;
import info.chili.gwt.widgets.ClickableImage;

public abstract class BaseField extends Composite implements BlurHandler {

    public BaseField(ConstantsWithLookup constants, String attributeName, String className, Boolean readOnly, Boolean required, Alignment alignment) {
        this.constants = constants;
        this.readOnly = readOnly;
        this.alignment = alignment;
        this.required = required;
        this.attributeName = attributeName;
        this.className = className;
        //TODO move this to configure metjhod
        if (required) {
            label.setHTML(Utils.getAttributeLabel(attributeName, className, constants) + "<em class='tfRequired'>*</em>");
        } else {
            label.setHTML(Utils.getAttributeLabel(attributeName, className, constants));
        }
        addWidgets();
        configure();
        initWidget(panel);
        moreInfoText = Utils.getMoreInfoLabel(attributeName, className, constants);
        setMoreInfoDescription(Utils.getMoreInfoLabel(attributeName, className, constants));
    }
//TODO depreciate this

    public BaseField(ConstantsWithLookup constants, String attributeName, String className, Boolean readOnly, Boolean required) {
        this(constants, attributeName, className, readOnly, required, Alignment.VERTICAL);
    }

    public String backgroundTextStyle = "backgroundTextStyle";
    public String moreInfoText;

    protected void configure() {
        label.addStyleName("tfFieldHeader");
        label.ensureDebugId(className + "_" + attributeName + "_L");
        message.addStyleName("tfErrorMessage");
        message.ensureDebugId(className + "_" + attributeName + "_L");
        errorIcon.setVisible(false);
    }

    protected void addWidgets() {
        if (Alignment.VERTICAL.equals(alignment)) {
            panel = new FlowPanel();
            panel.addStyleName("baseFieldVertical");
        } else {
            panel = new HorizontalPanel();
            panel.addStyleName("baseFieldHorizontal");
        }
        panel.add(label);
        fieldPanel.add(errorIcon);
        fieldPanel.add(fieldInfoIcon);
        fieldPanel.add(message);
        panel.add(fieldPanel);
    }

    /* used to add main widget to fieldPanel and add style class info */
    protected abstract void configureAddMainWidget();

    /**
     * called for validate on blur
     */
    protected abstract void validate();
    protected ComplexPanel panel;
    //TODO change to flow panel with horizontal allignment
    public HorizontalPanel fieldPanel = new HorizontalPanel();
    protected HTML label = new HTML();
    protected ClickableImage fieldInfoIcon = new ClickableImage("learn more", ChiliImages.INSTANCE.fieldInfoIcon());
    protected ClickableImage errorIcon = new ClickableImage("error", ChiliImages.INSTANCE.fieldErrorIcon());
    protected HTML message = new HTML();
    protected Boolean isValid = false;
    protected Boolean readOnly = false;
    protected Boolean required = false;
    protected ConstantsWithLookup constants;
    protected Alignment alignment = Alignment.VERTICAL;
    // this is actual bean/entity attribute name can be used to validation
    // purposes
    public String attributeName = null;
    public String className = null;

    public ComplexPanel getPanel() {
        return panel;
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    public HTML getLabel() {
        return label;
    }

    public void setLabelText(String name) {
        label.setHTML(name);
    }

    public void setMessage(String text) {
        message.setHTML(text);
        errorIcon.setVisible(true);
    }

    public void clearMessage() {
        errorIcon.setVisible(false);
        message.setHTML("");
    }

    public void addWidgetToFieldPanel(Widget widget) {
        fieldPanel.add(widget);
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        this.isValid = valid;
    }

    public Boolean getReadOnly() {
        return readOnly;
    }

    public abstract void focus(boolean focus);

    public abstract void setReadOnly(Boolean readOnly);

    protected void setMoreInfoDescription(String moreInfo) {
        fieldInfoIcon.setTitle(moreInfo);
    }

    @Override
    public void onBlur(BlurEvent event) {
        clearMessage();
        validate();
    }
}
