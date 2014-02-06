/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllTicketComments extends ALComposite {
    
    private static Logger logger = Logger.getLogger(ReadAllTicketComments.class.getName());
    protected CaptionPanel capPanel = new CaptionPanel();
    protected FlowPanel panel = new FlowPanel();
    protected String ticketId;
    
    public ReadAllTicketComments(String ticketId) {
        this.ticketId = ticketId;
        init(capPanel);
        panel.add(new CreateTicketCommentPanel(ticketId));
        getComments();
    }
    
    @Override
    protected void addListeners() {
        
    }
    
    @Override
    protected void configure() {
        
    }
    
    @Override
    protected void addWidgets() {
        capPanel.setCaptionHTML("Comments");
        capPanel.setContentWidget(panel);
    }
    
    protected void getComments() {
        HttpService.HttpServiceAsync.instance().doGet(getURL(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        displayComments(arg0);
                    }
                });
    }
    
    protected void displayComments(String commentsResp) {
        logger.info(commentsResp);
        if (JSONParser.parseLenient(commentsResp).isNull() == null) {
            JSONObject resp = (JSONObject) JSONParser.parseLenient(commentsResp);
            JSONArray comments = JSONUtils.toJSONArray(resp.get("ticketComment"));
            for (int i = 0; i < comments.size(); i++) {
                panel.add(new ReadTicketCommentPanel(comments.get(i).isObject()));
            }
        }
    }
    
    protected String getURL() {
        return OfficeWelcome.constants.root_url() + "selfservice/ticket/comments/" + ticketId + "/0/100";
    }
}
