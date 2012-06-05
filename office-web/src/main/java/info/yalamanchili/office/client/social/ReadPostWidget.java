package info.yalamanchili.office.client.social;

import com.google.gwt.user.client.ui.CaptionPanel;
import info.yalamanchili.gwt.composite.ALComposite;

import com.google.gwt.user.client.ui.RichTextArea;

public class ReadPostWidget extends ALComposite {

    CaptionPanel panel = new CaptionPanel();
    RichTextArea body = new RichTextArea();

    public ReadPostWidget(String headerHtml, String bodyHtml) {
        init(panel);
        panel.setCaptionText(headerHtml);
        panel.setContentWidget(body);
        body.setHTML(bodyHtml);
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
}
