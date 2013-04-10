package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;

import java.util.logging.Logger;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import info.yalamanchili.office.client.resources.OfficeImages;

//TODO add File/ImageUploadPanel support for this (merge)
public class ImageField extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ImageField.class.getName());
    FlowPanel panel = new FlowPanel();
    Label label = new Label();
    Image image = new Image();
    protected String entityId;
    protected String url;
    protected boolean validUrl;

    public ImageField(String labelName, String url, String entityId, final int width, final int height, boolean showLabel) {
        this.url = url;
        this.entityId = entityId;
        validUrl = validUrl();
        label.setText(labelName);
        label.setVisible(showLabel);
        setPixelSize(width, height);
        image.addStyleName("imageField-Image");
        logger.info("ddd" + url);
        if (validUrl) {
            url = OfficeWelcome.config.getFileDownloadUrl() + url + "&entityId=" + entityId;
            image.setUrl(url);
        } else {
            setDefaultImage(width, height);
        }
        //TODO is this ever happening? do it beeter
        image.addErrorHandler(new ErrorHandler() {
            public void onError(ErrorEvent event) {
                setDefaultImage(width, height);
            }
        });
        init(panel);
    }

    protected boolean validUrl() {
        if (url == null || url.trim().length() < 1) {
            return false;
        }
        int startIndex = url.indexOf("entityId_");
        if (startIndex > 0 && url.trim().length() > (startIndex + "entityId_".length())) {
            return true;
        }
        return false;
    }

    protected void setDefaultImage(int width, int height) {
        if (width == 50 && height == 50) {
            image.setResource(OfficeImages.INSTANCE.defaultImage_50_50());
            return;
        }
        image.setResource(OfficeImages.INSTANCE.defaultImage());
    }

    public void setPixelSize(int width, int height) {
        image.setPixelSize(width, height);
    }

    public void setImage(String url) {
        image.setUrl(OfficeWelcome.config.getFileDownloadUrl() + url);
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        image.addClickHandler(this);
    }

    @Override
    protected void addWidgets() {
        panel.add(label);
        panel.add(image);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(image)) {
            if (validUrl) {
                new GenericPopup(new Image(OfficeWelcome.config.getFileDownloadUrl() + url + "&entityId=" + entityId)).show();
            }
        }
    }
}
