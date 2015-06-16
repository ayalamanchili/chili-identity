/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UploadCorporateStatusReportPanel extends Composite {

    FlowPanel panel = new FlowPanel();
    public static Logger logger = Logger.getLogger(UploadCorporateStatusReportPanel.class.getName());

    public UploadCorporateStatusReportPanel() {
        initWidget(panel);
        final FormPanel form = new FormPanel();
        form.setAction(OfficeWelcome.instance().getOfficeClientConfig().getFileConverterUrl());
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);
        FileUpload upload = new FileUpload();
        upload.setName("uploadFormElement");
        form.add(upload);

        // Add a 'submit' button.
        panel.add(form);
        panel.add(new Button("Submit", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                form.submit();
            }
        }));
        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(SubmitCompleteEvent event) {
                logger.info(event.getResults());
                CreateCorporateStatusReportPanel.instance().setHtml(event.getResults());
                GenericPopup.instance().hide();
            }
        });

    }

}
