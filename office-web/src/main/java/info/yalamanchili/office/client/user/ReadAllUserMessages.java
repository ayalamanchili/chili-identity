/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.user;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.DocumentationWidget;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllUserMessages extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllEmailsPanel.class.getName());
    public static ReadAllUserMessages instance;

    public ReadAllUserMessages(JSONArray msgs) {
        instance = this;
        this.entities = msgs;
        initTable("UserMessages", msgs, OfficeWelcome.constants2);
        pagingPanel.setVisible(false);
        captionPanel.setCaptionHTML("Welcome " + OfficeWelcome.instance().getCurrentUserName() + " you have " + msgs.size() + " new messages please read and acknowledge them.");
    }

    @Override
    public void preFetchTable(int start) {

    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("summary"));
        table.setText(0, 1, getKeyValue("createdDate"));
        table.setText(0, 2, getKeyValue("Details"));
        table.setText(0, 3, getKeyValue("Action"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            table.setText(i, 0, JSONUtils.toString(entity, "summary"));
            table.setText(i, 1, DateUtils.getFormatedDate(JSONUtils.toString(entity, "createdDate"), DateTimeFormat.PredefinedFormat.DATE_SHORT));
            ClickableLink invoiceLink = new ClickableLink("Acknowledge");
            invoiceLink.setTitle(JSONUtils.toString(entity, "id"));
            invoiceLink.addClickHandler((ClickEvent event) -> {
                acknowledge(((ClickableLink) event.getSource()).getTitle(), JSONUtils.toString(entity, "source"), invoiceLink);
            });
            table.setWidget(i, 3, invoiceLink);
            if (entity.containsKey("moreDetailsLink")) {
                ClickableLink detailsL = new ClickableLink("Details");
                detailsL.addClickHandler((ClickEvent event) -> {
                    Window.open(JSONUtils.toString(entity, "moreDetailsLink"), "_blank", "");
                });
                table.setWidget(i, 2, detailsL);
            }
        }
    }

    public void acknowledge(String id, String source, ClickableLink invoiceLink) {
        HttpService.HttpServiceAsync.instance().doGet(getAcknowledgeUrl(id, source), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                new ResponseStatusWidget().show("Message Acknowledged");
                invoiceLink.setVisible(false);
            }
        });
    }

    public String getAcknowledgeUrl(String id, String source) {
        return OfficeWelcome.instance().constants.root_url() + "notifications/user/message/accknowledge/" + source + "/" + id;
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void viewClicked(String entityId) {

    }

    @Override
    public void deleteClicked(String entityId) {
    }

    @Override
    public void postDeleteSuccess() {
    }

    @Override
    public void updateClicked(String entityId) {
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Take me to Portal Home");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        GenericPopup.instance().hide();
        OfficeWelcome.instance().rootLayout.setVisible(true);
    }
}
