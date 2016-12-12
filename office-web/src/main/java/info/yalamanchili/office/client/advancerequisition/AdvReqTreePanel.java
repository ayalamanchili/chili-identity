/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.advancerequisition;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.transaction.ReadAllTransactionPanel;
import info.yalamanchili.office.client.transaction.TransactionOptionsWidget;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class AdvReqTreePanel extends TreePanelComposite {
    
    private static AdvReqTreePanel instance;
    
    public static AdvReqTreePanel instance() {
        return instance;
    }
    private static Logger logger = Logger.getLogger(AdvReqTreePanel.class.getName());
    
    protected static final String TRANSACTIONS_NODE = "transactions";
    
    public AdvReqTreePanel(String entityId) {
        super(entityId);
        instance = this;
        init("AdvanceRequisition", OfficeWelcome.constants);
    }
    
    @Override
    protected void addListeners() {
    }
    
    @Override
    protected void configure() {
    }
    
    @Override
    public boolean expandTree() {
        return true;
    }
    
    @Override
    protected void addWidgets() {
        addFirstChildLink("Transactions", TRANSACTIONS_NODE);
    }
    
    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (TRANSACTIONS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().expensePanel.entityPanel.clear();
            TabPanel.instance().expensePanel.entityPanel.add(new ReadAllTransactionPanel());
            TabPanel.instance().expensePanel.entityPanel.add(new TransactionOptionsWidget("advancerequisition/transaction/" + getEntityId()));
        }
    }
    
    @Override
    public void loadEntity() {
    }
    
    @Override
    public void showEntity() {
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAdvanceRequisitionPanel(getEntityId()));
    }
}
