/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.JSONUtils;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadCommentPanel extends ALComposite {

    private static Logger logger = Logger.getLogger(ReadCommentPanel.class.getName());
    protected JSONObject comment;
    protected FlowPanel panel = new FlowPanel();
    TextArea commentTA = new TextArea();
    Label statusLabel = new Label();

    public ReadCommentPanel(JSONObject comment) {
        this.comment = comment;
        init(panel);
        populateComment();
    }

    protected final void populateComment() {
        String status = JSONUtils.toString(comment, "userId") + " added a comment - " + DateUtils.getFormatedDate(JSONUtils.toString(comment, "time"), DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM);
        statusLabel.setText(status);
        commentTA.setText(JSONUtils.toString(comment, "fullMessage"));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        commentTA.setWidth("100%");
        commentTA.setEnabled(false);
    }

    @Override
    protected void addWidgets() {
        panel.add(commentTA);
        panel.add(statusLabel);
    }
}
