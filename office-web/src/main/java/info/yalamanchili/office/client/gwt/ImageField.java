package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;

import java.util.logging.Logger;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import info.yalamanchili.office.client.resources.OfficeImages;

//TODO add File/ImageUploadPanel support for this (merge)
public class ImageField extends ALComposite {

    private static Logger logger = Logger.getLogger(ImageField.class.getName());
    FlowPanel panel = new FlowPanel();
    Label label = new Label();
    Image image = new Image();

    public ImageField(String labelName, String url, final int width, final int height, boolean showLabel) {
        if (url == null || url.trim().length() < 1) {
            setDefaultImage(width, height);
        }
        label.setText(labelName);
        label.setVisible(showLabel);
        setPixelSize(width, height);
        image.setUrl(OfficeWelcome.constants.file_download_url() + url);
        image.addErrorHandler(new ErrorHandler() {

            public void onError(ErrorEvent event) {
                setDefaultImage(width, height);
            }
        });
        init(panel);
    }

    protected void setDefaultImage(int width, int height) {
        if (width == 50 && height == 50) {
            image.setResource(OfficeImages.INSTANCE.defaultImage_w_50_h_50());
        }
        image.setResource(OfficeImages.INSTANCE.defaultImage());
    }

    public void setPixelSize(int width, int height) {
        image.setPixelSize(width, height);
    }

    public void setImage(String url) {
        image.setUrl(OfficeWelcome.constants.file_download_url() + url);
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
        panel.add(label);
        panel.add(image);
    }
}
