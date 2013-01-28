package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.ClickEvent;

public abstract class CRUDReadAllComposite extends ReadAllComposite<TableRowOptionsWidget> {

    @Override
    protected void createOptionsWidget(TableRowOptionsWidget.OptionsType type, int row, String id) {
        TableRowOptionsWidget link = new TableRowOptionsWidget(type, id);
        link.initListeners(this);
        table.setWidget(row, 0, link);
        optionsWidgetMap.put(String.valueOf(row), link);
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
            deleteClicked(rowOptionsWidget.getEntityId());
        }
    }

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
}
