package info.yalamanchili.office.client.gwt;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitHandler;
import com.google.gwt.user.client.ui.Label;
import info.yalamanchili.gwt.utils.Utils;
import info.yalamanchili.office.client.config.OfficeClientConfig;
import java.util.logging.Logger;

public abstract class FileUploadPanel extends ALComposite implements ClickHandler, SubmitHandler, SubmitCompleteHandler {

    private static Logger logger = Logger.getLogger(FileUploadPanel.class.getName());
    protected String filePrefix;
    protected boolean submitted = false;
    FlowPanel panel = new FlowPanel();
    FormPanel formPanel = new FormPanel();
    Label label = new Label("upload");
    FileUpload fileUpload = new FileUpload();
    Button submit = new Button("Upload");

    public FileUploadPanel(ConstantsWithLookup constants, String attributeName, String className, String filePrefix) {
        instance = this;
        label.setText(Utils.getAttributeLabel(attributeName, className, constants));
        this.filePrefix = filePrefix;
        init(formPanel);
        submit.setVisible(false);
    }

    @Override
    protected void addListeners() {
        submit.addClickHandler(this);
        formPanel.addSubmitHandler(this);
        formPanel.addSubmitCompleteHandler(this);
    }

    @Override
    protected void configure() {
        formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
        formPanel.setMethod(FormPanel.METHOD_POST);
        fileUpload.setName(filePrefix);
        formPanel.setAction(OfficeWelcome.config.getFileUploadUrl());
    }

    @Override
    protected void addWidgets() {
        panel.add(label);
        panel.add(fileUpload);
        panel.add(submit);
        formPanel.add(panel);
    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(submit)) {
            formPanel.submit();
        }
    }

    public void upload(String entityId) {
        setEntityId(entityId);
        formPanel.submit();
    }

    public JSONString getFileName() {
        return new JSONString(filePrefix + "_entityId_" + stripFileName(fileUpload.getFilename()));
    }

    public void setEntityId(String entityId) {
        fileUpload.setName(filePrefix + "_" + entityId + "_");
    }

    public FileUpload getFileUpload() {
        return fileUpload;
    }

    protected String stripFileName(String fileName) {
        if (fileName.lastIndexOf("\\") > 0) {
            return fileName.substring(fileName.lastIndexOf("\\") + 1);
        } else {
            return fileName;
        }

    }
    private static FileUploadPanel instance;

    public static FileUploadPanel instance() {
        return instance;
    }

    public abstract void onUploadComplete();

    @Override
    public void onSubmitComplete(SubmitCompleteEvent event) {
        logger.info("on submit complete");
        onUploadComplete();
    }

    @Override
    public void onSubmit(SubmitEvent event) {
        logger.info("on submit");
    }
}
