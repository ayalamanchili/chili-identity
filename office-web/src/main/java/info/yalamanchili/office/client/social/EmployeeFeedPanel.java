package info.yalamanchili.office.client.social;

import info.yalamanchili.gwt.composite.ALComposite;

import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPanel;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

public class EmployeeFeedPanel extends ALComposite {

    private static Logger logger = Logger.getLogger(EmployeeFeedPanel.class.getName());
    FlowPanel mainPanel = new FlowPanel();

    public EmployeeFeedPanel() {
        init(mainPanel);
    }

    protected void loadEmployeePosts() {
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeFeedURL(0, 10), OfficeWelcome.instance().getHeaders(),
                true, new ALAsyncCallback<String>() {

            @Override
            public void onResponse(String result) {
                logger.info(result);

            }
        });
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
    }

    protected String getEmployeeFeedURL(Integer start, Integer limit) {
        return OfficeWelcome.instance().constants.root_url() + "social/employeefeed/" + start.toString() + "/" + limit.toString();
    }
}
