/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UploadCorporateStatusReportPanel extends Composite {

    CaptionPanel main = new CaptionPanel();
    FlowPanel panel = new FlowPanel();
    public static Logger logger = Logger.getLogger(UploadCorporateStatusReportPanel.class.getName());
    HTML info = new HTML("<h4>&nbsp;</h4>\n"
            + "\n"
            + "<ul>\n"
            + "	<li>\n"
            + "	<pre>\n"
            + "Preferred format : 2007 XLSX and DOCX But we also support: .doc, .docx, .xls, .xlsx formats.</pre>\n"
            + "	</li>\n"
            + "	<li>\n"
            + "	<pre>\n"
            + "Since microsoft docs are not HTML based format you may loose some formatting when importing.</pre>\n"
            + "	</li>\n"
            + "	<li>\n"
            + "	<pre>\n"
            + "This a experimental utility to import data from your excel and word documents.</pre>\n"
            + "\n"
            + "	<hr />\n"
            + "	<p>&nbsp;</p>\n"
            + "	</li>\n"
            + "</ul>\n"
            + "\n"
            + "<p>&nbsp;</p>");

    public UploadCorporateStatusReportPanel() {
        initWidget(main);
        main.setCaptionHTML("Import Report");
        main.setContentWidget(panel);
        final FormPanel form = new FormPanel();
        form.setAction(OfficeWelcome.instance().getOfficeClientConfig().getFileConverterUrl());
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.setMethod(FormPanel.METHOD_POST);
        FileUpload upload = new FileUpload();
        upload.setName("uploadFormElement");
        form.add(upload);

        panel.add(info);
        panel.add(form);
        panel.add(new Button("Import", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                form.submit();
            }
        }));
        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(SubmitCompleteEvent event) {
                if (event.getResults().isEmpty()) {
                    Window.alert("Formart not supported");
                }
                CreateCorporateStatusReportPanel.instance().setHtml(event.getResults());
                GenericPopup.instance().hide();

            }
        });

    }

}
