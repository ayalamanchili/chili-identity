/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.question;

import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllQuestionCommentsPanel extends ALComposite {
    
    private static Logger logger = Logger.getLogger(ReadAllQuestionCommentsPanel.class.getName());
    protected FlowPanel basePanel = new FlowPanel();
    protected DisclosurePanel disclosurePanel;
    protected FlowPanel panel = new FlowPanel();
    protected String url;
    
    public ReadAllQuestionCommentsPanel(String title, String url) {
        this.url = url;
        disclosurePanel = new DisclosurePanel(title);
        init(basePanel);
    }
    
    @Override
    protected void addListeners() {
        disclosurePanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                panel.clear();
                loadData();
            }
        });
        
    }
    
    protected void loadData() {
        HttpService.HttpServiceAsync.instance().doGet(url, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        logger.info(arg0);
                    }
                });
    }
    
    protected void populateData() {
        
    }
    
    @Override
    protected void configure() {
        
    }
    
    @Override
    protected void addWidgets() {
        basePanel.add(disclosurePanel);
        disclosurePanel.setContent(panel);
    }
    
}
