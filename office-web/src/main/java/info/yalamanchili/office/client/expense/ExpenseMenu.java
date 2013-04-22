/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author Prashanthi
 */
public class ExpenseMenu extends Composite {

    MenuBar expenseMenuBar = new MenuBar(false);

    public ExpenseMenu() {
        initWidget(expenseMenuBar);
        configureExpenseMenu();
    }

    protected void configureExpenseMenu() {
        MenuBar menu = new MenuBar(true);
        expenseMenuBar.addItem("Expense", ecpenseMaintainenceCmd);
        expenseMenuBar.addItem("ExpenseCategories", ecpenseCategoriesMaintainenceCmd);

        expenseMenuBar.addStyleName("entityMenuBar");
    }
    Command ecpenseMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
//            TabPanel.instance().getExpensePanel().entityPanel.add(new ());
//            TabPanel.instance().getExpensePanel().sidePanelTop.add(new ());
        }
    };
    Command ecpenseCategoriesMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
//            TabPanel.instance().getExpensePanel().entityPanel.add(new ());
//            TabPanel.instance().getExpensePanel().sidePanelTop.add(new ());
        }
    };
}
