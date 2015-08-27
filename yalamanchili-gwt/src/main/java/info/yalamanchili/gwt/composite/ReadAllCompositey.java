package info.yalamanchili.gwt.composite;

import info.yalamanchili.gwt.fields.ListBoxField;
import info.yalamanchili.gwt.rf.GenericRequest;
import info.yalamanchili.gwt.utils.Alignment;
import info.yalamanchili.gwt.utils.Utils;
import info.yalamanchili.gwt.widgets.ClickableLink;

import java.util.List;
import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLTable.Cell;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.Receiver;

public abstract class ReadAllCompositey<T extends EntityProxy> extends
		ALComposite implements ClickHandler, ChangeHandler {

	protected GenericRequest<T> request;
	private Logger logger = Logger.getLogger(ReadAllCompositey.class.getName());

	public ReadAllTableType tableType;

	/**
	 * @generated
	 */
	public enum ReadAllTableType {
		READALL, READALL_SEARCH
	}

	/** The panel. */
	protected FlowPanel panel = new FlowPanel();

	/** The paging panel. */
	protected HorizontalPanel pagingPanel = new HorizontalPanel();

	/** The table panel. */
	protected FlowPanel tablePanel = new FlowPanel();

	/** The table. */
	protected FlexTable table = new FlexTable();

	/** The number of records. */
	protected Long numberOfRecords = new Long(0);

	/** The page size. */
	protected Integer pageSize = 10;// default

	/** The number of pages. */
	protected Integer numberOfPages;

	/** The class canonical name. */
	protected String classCanonicalName;

	/** The constants. */
	protected ConstantsWithLookup constants;

	/** The go to page. */
	protected ListBoxField goToPage = new ListBoxField("Page: ",
			Alignment.HORIZONTAL);

	/** The no of results l. */
	protected Label noOfResultsL = new Label("Total Results:");

	protected void initTable(String className, ConstantsWithLookup constants) {
		this.classCanonicalName = className;
		this.constants = constants;
		init(panel);
		preFetchTable(0);
	}

	protected void initTable(String className, List<T> proxys,
			ConstantsWithLookup constants) {
		this.classCanonicalName = className;
		this.constants = constants;
		init(panel);
		postFetchTable(proxys);
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
	 * @param noOfRecords
	 *            the no of records
	 */
	public void configurePaging() {
		request.size().fire(new Receiver<Long>() {

			@Override
			public void onSuccess(Long noOfRecords) {
				// TODO get from config
				pageSize = new Integer(10);
				numberOfRecords = noOfRecords;
				noOfResultsL.setText("Total Results:" + noOfRecords.toString());
				createPageLinks();
			}

		});

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

	public abstract GenericRequest<T> getRequest();

	public void preFetchTable(int start) {
		// TODO call just once?
		request = getRequest();
		if (ReadAllTableType.READALL.equals(tableType)) {
			request.query(start, 10).fire(new Receiver<List<T>>() {

				@Override
				public void onSuccess(List<T> proxys) {
					// TODO get limit from config also do pagin init
					postFetchTable(proxys, 10l);
				}

			});
		}
		if (ReadAllTableType.READALL_SEARCH.equals(tableType)) {
			// TODO
		}
	}

	public void postFetchTable(List<T> proxys, Long size) {
		createTableHeader();
		fillData(proxys);
		configurePaging();
	}

	public void postFetchTable(List<T> proxys) {
		createTableHeader();
		fillData(proxys);
		// TODO paging
	}

	public abstract void createTableHeader();

	protected void createViewIcon(int row, Long id) {
		ClickableLink link = new ClickableLink("view");
		link.setTitle(id.toString());
		table.setWidget(row, 0, link);
	}

	protected Long getProxyId(int row) {
		return new Long(table.getWidget(row, 0).getTitle());
	}

	public abstract void fillData(List<T> proxys);

	public abstract void viewClicked(int row, int col);

	public void onClick(ClickEvent event) {
		if (event.getSource() == table) {
			Cell clickedCell = table.getCellForEvent(event);
			if (clickedCell != null && clickedCell.getRowIndex() != 0)
				viewClicked(clickedCell.getRowIndex(),
						clickedCell.getCellIndex());
		}
	}

	public void onChange(ChangeEvent event) {
		if (event.getSource() == goToPage.getListBox()) {
			preFetchTable((goToPage.getValue().intValue() * pageSize) - 10);
		}
	}

	// TODO move to pakage gwt.utils.Utils.java
	protected String getClassValue(String id) {
		return Utils.getAttributeLabel(id, classCanonicalName, constants);
	}

	// TODO move to pakage gwt.utils.Utils.java
	protected String getKeyValue(String id) {
		return Utils.getKeyValue(id, constants);
	}
}
