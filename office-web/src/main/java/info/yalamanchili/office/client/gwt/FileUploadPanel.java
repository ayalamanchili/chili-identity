package info.yalamanchili.office.client.gwt;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Label;

public class FileUploadPanel extends ALComposite implements ClickHandler {

    protected String filePrefix;
    FlowPanel panel = new FlowPanel();
    FormPanel formPanel = new FormPanel();
    Label label = new Label("upload");
    FileUpload fileUpload = new FileUpload();
    Button submit = new Button("Upload");

    public FileUploadPanel(String labelName, String filePrefix) {
        label.setText(labelName);
        this.filePrefix = filePrefix;
        init(formPanel);
        submit.setVisible(false);
    }

    @Override
    protected void addListeners() {
        submit.addClickHandler(this);
    }

    @Override
    protected void configure() {
        formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
        formPanel.setMethod(FormPanel.METHOD_POST);
        fileUpload.setName(filePrefix);
        formPanel.setAction(OfficeWelcome.constants.file_upload_url());
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
}
