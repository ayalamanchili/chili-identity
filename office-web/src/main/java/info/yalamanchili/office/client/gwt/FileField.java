/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.gwt;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import info.chili.gwt.utils.Utils;
import info.chili.gwt.widgets.ClickableLink;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class FileField extends ClickableLink implements ClickHandler {

    private static Logger logger = Logger.getLogger(FileField.class.getName());
    protected String fileUrl;

    public FileField(String name, String fileUrl) {
        super(name);
        this.fileUrl = fileUrl;
        this.addClickHandler(this);
    }

    public FileField(String fileUrl) {
        super(Utils.getFileNameFromUrl(fileUrl));
        this.fileUrl = fileUrl;
        this.addClickHandler(this);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(this)) {
            logger.info("file url:" + fileUrl);
            Window.open(fileUrl, "_blank", "");
        }
    }
}
