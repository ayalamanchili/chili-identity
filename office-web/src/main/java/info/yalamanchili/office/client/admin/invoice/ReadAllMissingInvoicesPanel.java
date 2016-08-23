/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.invoice;

import static com.axeiya.gwtckeditor.client.CKConfig.AVAILABLE_PLUGINS.table;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import static com.google.gwt.user.client.DOM.createButton;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Widget;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.contracts.ReadContractsPanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadAllMissingInvoicesPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllMissingInvoicesPanel.class.getName());
    public static ReadAllMissingInvoicesPanel instance;

    public ReadAllMissingInvoicesPanel(JSONArray array) {
        instance = this;
        initTable("Invoice", array, OfficeWelcome.constants2);
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
    public void preFetchTable(int start) {
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("ItemNumber"));
        table.setText(0, 3, getKeyValue("Inv. Frequency"));
        table.setText(0, 4, getKeyValue("Missing Inv. Period From"));
        table.setText(0, 5, getKeyValue("Missing Inv. Period To"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            table.setText(i, 1, JSONUtils.toString(entity, "employee"));
            table.setText(i, 2, JSONUtils.toString(entity, "itemNumber"));
            table.setText(i, 3, JSONUtils.toString(entity, "invFrequency"));
            table.setText(i, 4, DateUtils.formatDate(JSONUtils.toString(entity, "missingInvPeriodFrom")));
            table.setText(i, 5, DateUtils.formatDate(JSONUtils.toString(entity, "missingInvPeriodTo")));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
    }

    @Override
    public void copyClicked(final String entityId) {
    }
  
    @Override
    protected void configureCreateButton() {
    }

    @Override
    protected void createButtonClicked() {
    }
}
