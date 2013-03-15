package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.rpc.HttpService;

public abstract class CRUDReadAllComposite extends ReadAllComposite<TableRowOptionsWidget> {

//temp method need to update all implementing sub classes
    protected void createOptionsWidget(TableRowOptionsWidget.OptionsType type, int row, String id) {
        TableRowOptionsWidget rowOptionsWidget = new TableRowOptionsWidget(type, id);
        createOptionsWidget(rowOptionsWidget, row, id);
    }

    @Override
    protected void createOptionsWidget(TableRowOptionsWidget rowOptionsWidget, int row, String id) {
        rowOptionsWidget.initListeners(this);
        table.setWidget(row, 0, rowOptionsWidget);
        optionsWidgetMap.put(String.valueOf(row), rowOptionsWidget);
    }

    @Override
    public void onOptionsSelected(ClickEvent event, TableRowOptionsWidget rowOptionsWidget) {
        if (event.getSource().equals(rowOptionsWidget.getReadLink())) {
            viewClicked(rowOptionsWidget.getEntityId());
        }
        if (event.getSource().equals(rowOptionsWidget.getUpdateLink())) {
            updateClicked(rowOptionsWidget.getEntityId());
        }
        if (event.getSource().equals(rowOptionsWidget.getDeleteLink())) {
            preDelete(rowOptionsWidget.getEntityId());
        }
    }

    public abstract void viewClicked(String entityId);

    public void preDelete(String entityId) {
        if (Window.confirm("Are you sure? you want to Delete")) {
            deleteClicked(entityId);
        }
    }

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
}
