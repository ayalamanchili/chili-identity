package info.yalamanchili.office.client.gwt;

import info.yalamanchili.gwt.composite.ALComposite;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Label;

public class FileUploadPanel extends ALComposite implements ClickHandler {
	FlowPanel panel = new FlowPanel();

	FormPanel formPanel = new FormPanel();
	Label label = new Label("Upload images for listing");
	FileUpload fileUpload = new FileUpload();
	Button submit = new Button("Upload");

	public FileUploadPanel() {
		init(formPanel);
	}

	@Override
	protected void addListeners() {
		submit.addClickHandler(this);
	}

	@Override
	protected void configure() {
		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
		formPanel.setMethod(FormPanel.METHOD_POST);
		fileUpload.setName("Upload Image");
		formPanel.setAction(GWT.getModuleBaseURL() + "upload");
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
			String imagename = fileUpload.getFilename();
			formPanel.submit();
		}

	}

}
