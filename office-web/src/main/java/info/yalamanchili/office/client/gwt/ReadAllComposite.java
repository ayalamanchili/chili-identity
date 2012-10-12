package info.yalamanchili.office.client.gwt;

import info.yalamanchili.gwt.utils.JSONUtils;
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
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.HTMLTable.Cell;

public abstract class ReadAllComposite extends ALComposite implements ClickHandler, ChangeHandler {

    private static Logger logger = Logger.getLogger(ReadAllComposite.class.getName());
    /*
     * Parent entityId if any
     */
    protected String parentId;
    protected FlowPanel basePanel = new FlowPanel();
    protected CaptionPanel captionPanel = new CaptionPanel();
    /**
     * The mainPanel.
     */
    protected FlowPanel mainPanel = new FlowPanel();
    /**
     * The paging mainPanel.
     */
    protected HorizontalPanel pagingPanel = new HorizontalPanel();
    /**
     * The table mainPanel.
     */
    protected FlowPanel tablePanel = new FlowPanel();
    /**
     * The data table.
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
     * create/add button to add new record this is set to not visible by
     * default. To be seen need to override the configure createButton(
     */
    protected Button createButton = new Button("Create");
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
        init(basePanel);
        preFetchTable(0);
    }

    /*
     *
     */
    protected void initTable(String className, JSONArray entities, ConstantsWithLookup constants) {
        this.classCanonicalName = className;
        this.constants = constants;
        this.entities = entities;
        init(basePanel);
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
        configureTable();
        pagingPanel.setSpacing(5);
        captionPanel.addStyleName("readAllCompositeCaptionPanel");
        pagingPanel.addStyleName("y-gwt-PagingBar");
        mainPanel.addStyleName("y-gwt-ReadAllPanel");
        tablePanel.addStyleName("y-gwt-TablePanel");
        configureCreateButton();
    }

    protected void configureTable() {
        table.addStyleName("y-gwt-Table");
        table.getRowFormatter().addStyleName(0, "y-gwt-TableHeader");
        table.setBorderWidth(1);
    }

    @Override
    protected void addListeners() {
        goToPage.addChangeHandler(this);
        table.addClickHandler(this);
        createButton.addClickHandler(this);
    }

    @Override
    protected void addWidgets() {
        pagingPanel.add(goToPage);
        pagingPanel.add(noOfResultsL);
        tablePanel.add(table);
        mainPanel.add(createButton);
        mainPanel.add(pagingPanel);
        mainPanel.add(tablePanel);
        captionPanel.setContentWidget(mainPanel);
        captionPanel.setCaptionHTML(classCanonicalName);
        basePanel.add(captionPanel);
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

    /*
     * Override this and call this in fill data method to call
     * createOptionsWidget based on roles and permissions
     */
    protected abstract void addOptionsWidget(int row, JSONObject entity);

    public abstract void viewClicked(String entityId);

    /*
     * add logic to support deleting the record with the input entityId
     */
    public abstract void deleteClicked(String entityId);

    /*
     * add logic (eg:navigation) on what to happen after succesfuull deleting
     * the row
     */
    public abstract void postDeleteSuccess();

    /**
     * override this to add logic to perform on update row clicked
     */
    public abstract void updateClicked(String entityId);

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createButton)) {
            createButtonClicked();
        }
        Cell src = table.getCellForEvent(event);
        if (src != null) {
            Integer rowIndex = src.getRowIndex();
            if (rowIndex != null) {
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
        }
    }

    /**
     * override this to make the create button visible and update its name etc
     */
    protected void configureCreateButton() {
        createButton.setVisible(false);
    }

    /**
     * override this method to perform logic to handle create button
     */
    protected void createButtonClicked() {
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource() == goToPage.getListBox()) {
            //TODO improve this
            table.removeAllRows();
            configureTable();
            preFetchTable((goToPage.getValue().intValue() * pageSize) - 10);
        }
    }

    // TODO move to pakage gwt.utils.Utils.java
    protected String getKeyValue(String id) {
        return Utils.getKeyValue(id, constants);
    }

    public void refresh() {
        table.removeAllRows();
        preFetchTable(0);
    }
}
