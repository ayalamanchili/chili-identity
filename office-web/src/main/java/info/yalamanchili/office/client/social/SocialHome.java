package info.yalamanchili.office.client.social;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class SocialHome extends Composite { 
	public   FlowPanel panel = new FlowPanel();
        

    public SocialHome() {
        initWidget(panel);
        panel.add(new EmployeePostsHome());
    }
}
