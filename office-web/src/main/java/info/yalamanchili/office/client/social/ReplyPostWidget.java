package info.yalamanchili.office.client.social;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RichTextArea;
import info.yalamanchili.gwt.callback.ALAsyncCallback;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

public class ReplyPostWidget extends ALComposite implements ClickHandler {
    
    private static Logger logger = Logger.getLogger(ReplyPostWidget.class.getName());
    FlowPanel mainPanel = new FlowPanel();
    RichTextArea postBodyArea = new RichTextArea();
    Button replyB = new Button("Post");
    protected String parentPostId;
    
    protected ReplyPostWidget(String parentPostId) {
        init(mainPanel);
        this.parentPostId = parentPostId;
    }
    
    @Override
    protected void addListeners() {
        
        replyB.addClickHandler(this);
    }
    
    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }
    
    @Override
    protected void addWidgets() {
        mainPanel.add(postBodyArea);
        mainPanel.add(replyB);
    }
    
    @Override
    public void onClick(ClickEvent arg0) {
        JSONObject replyEntity = new JSONObject();
        replyEntity.put("postContent", new JSONString(postBodyArea.getText()));
        replyEntity.put("postTimeStamp", new JSONString("2012-06-18T09:38:44.291-04:00"));
        HttpServiceAsync.instance().doPut(getPostReplyURL(parentPostId), replyEntity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("reply posted");
                        TabPanel.instance().myOfficePanel.entityPanel.clear();
                        TabPanel.instance().myOfficePanel.entityPanel.add(new SocialHome());
                    }
                });
        
    }
    
    public String getPostReplyURL(String parentPostId) {
        //update this to be correct url path
        return OfficeWelcome.constants.root_url() + "social/addreply/"
                + parentPostId;
        
    }
}
