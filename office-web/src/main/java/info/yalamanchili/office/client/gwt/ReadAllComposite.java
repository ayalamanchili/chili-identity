package info.yalamanchili.office.client.gwt;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.fields.ListBoxField;
import info.yalamanchili.gwt.utils.Alignment;
import info.yalamanchili.gwt.utils.Utils;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget.OptionsType;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public abstract class ReadAllComposite extends ALComposite implements ClickHandler, ChangeHandler {

    private static Logger logger = Logger.getLogger(ReadAllComposite.class.getName());
    /*
     * Parent entityId if any
     */
    protected String parentId;
    /**
     * The panel.
     */
    protected FlowPanel panel = new FlowPanel();
    /**
     * The paging panel.
     */
    protected HorizontalPanel pagingPanel = new HorizontalPanel();
    /**
     * The table panel.
     */
    protected FlowPanel tablePanel = new FlowPanel();
    /**
     * The table.
     */
    protected FlexTable table = new FlexTable();
    /**
     * The number of records.
     */
    protected Long numberOfRecords = new Long(0);
    /**
     * The page size.
     */
    protected Integer pageSize = 10;// default
    /**
     * The number of pages.
     */
    protected Integer numberOfPages;
    /**
     * The class canonical entityName.
     */
    protected String classCanonicalName;
    /**
     * The constants.
     */
    protected ConstantsWithLookup constants;
    /**
     * The go to page.
     */
    protected ListBoxField goToPage = new ListBoxField("Page: ", Alignment.HORIZONTAL);
    /**
     * The no of results l.
     */
    protected Label noOfResultsL = new Label("Total Results:");
    /*
     * Set of entityId and widgets respectively
     */
    protected Map<String, TableRowOptionsWidget> optionsWidgetMap = new HashMap<String, TableRowOptionsWidget>();

    protected void initTable(String className, ConstantsWithLookup constants) {
        this.classCanonicalName = className;
        this.constants = constants;
        init(panel);
        preFetchTable(0);
    }

    /*
     *
     */
    protected void initTable(String className, JSONArray entities, ConstantsWithLookup constants) {
        this.classCanonicalName = className;
        this.constants = constants;
        init(panel);
        createTableHeader();
        fillData(entities);
    }
    /*
     * (non-Javadoc)
     *
     * @see info.yalamanchili.gwt.composite.ALComposite#configure()
     */

    @Override
    protected void configure() {
        table.addStyleName("y-gwt-Table");
        table.getRowFormatter().addStyleName(0, "y-gwt-TableHeader");
        table.setBorderWidth(1);
        pagingPanel.setSpacing(5);
        pagingPanel.addStyleName("y-gwt-PagingBar");
        panel.addStyleName("y-gwt-ReadAllPanel");
        tablePanel.addStyleName("y-gwt-TablePanel");
    }

    @Override
    protected void addListeners() {
        goToPage.addChangeHandler(this);
        table.addClickHandler(this);
    }

    @Override
    protected void addWidgets() {
        pagingPanel.add(goToPage);
        pagingPanel.add(noOfResultsL);
        tablePanel.add(table);
        panel.add(pagingPanel);
        panel.add(tablePanel);
    }

    /**
     * Inits the load.
     *
     * @param noOfRecords the no of records
     */
    public void initPaging(Long noOfRecords) {
        pageSize = new Integer(10);
        numberOfRecords = noOfRecords;
        noOfResultsL.setText("Total Results:" + noOfRecords.toString());
        createPageLinks();
    }

    /**
     * Creates the page links.
     */
    protected void createPageLinks() {
        if (numberOfPages == null || numberOfPages == 0) {
            numberOfPages = (numberOfRecords.intValue() / pageSize) + 1;
            for (int i = 1; i <= numberOfPages; i++) {
                goToPage.addValue(new Long(i), new Integer(i).toString());
            }
        }
    }

    public abstract void preFetchTable(int start);

    public void postFetchTable(String tableObjString) {
        JSONObject table = (JSONObject) JSONParser.parseLenient(tableObjString);
        if (table.get("size") != null) {
            JSONString size = (JSONString) table.get("size");
            initPaging(new Long(size.stringValue()));
        }
        createTableHeader();
        if (table.get("entities") != null) {
            entities = JSONUtils.toJSONArray(table.get("entities"));
            fillData(entities);
        }
    }
    protected JSONArray entities;

    public abstract void createTableHeader();

    protected void createOptionsWidget(OptionsType type, int row, String id) {
        TableRowOptionsWidget link = new TableRowOptionsWidget(type, id);
        link.setTitle(id);
        link.initListeners(this);
        table.setWidget(row, 0, link);
        optionsWidgetMap.put(String.valueOf(row), link);
    }

    protected String getEntityId(int row) {
        return table.getWidget(row, 0).getTitle();
    }

    protected JSONObject getEntity(String entityId) {
        for (int i = 0; i < entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i);
            if (entityId.equals(JSONUtils.toString(entity, "id"))) {
                return entity;
            }
        }
        return null;
    }

    public abstract void fillData(JSONArray entities);

    public abstract void viewClicked(String entityId);

    public abstract void deleteClicked(String entityId);

    public abstract void updateClicked(String entityId);

    public void onClick(ClickEvent event) {
        Cell src = table.getCellForEvent(event);
        int rowIndex = src.getRowIndex();
        TableRowOptionsWidget rowWidget = optionsWidgetMap.get(String.valueOf(rowIndex));
        if (event.getSource().equals(rowWidget.getReadLink())) {
            viewClicked(rowWidget.entityId);
        }
        if (event.getSource().equals(rowWidget.getUpdateLink())) {
            updateClicked(rowWidget.entityId);
        }
        if (event.getSource().equals(rowWidget.getDeleteLink())) {
            deleteClicked(rowWidget.entityId);
        }
    }

    public void onChange(ChangeEvent event) {
        if (event.getSource() == goToPage.getListBox()) {
            preFetchTable((goToPage.getValue().intValue() * pageSize) - 10);
        }
    }

    // TODO move to pakage gwt.utils.Utils.java
    protected String getKeyValue(String id) {
        return Utils.getKeyValue(id, constants);
    }
}
