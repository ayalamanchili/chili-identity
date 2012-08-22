/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;

/**
 *
 * @author yalamanchili
 */
public interface OfficeImages extends ClientBundle {

    public static final OfficeImages INSTANCE = GWT.create(OfficeImages.class);

    @Source("images/default-image.gif")
    @ImageOptions(height = 50, width = 50)
    ImageResource defaultImage_50_50();

    @Source("images/default-image.gif")
    ImageResource defaultImage();
    /*
     * View Icons
     */

    @Source("images/view_icon_32_32.png")
    ImageResource viewIcon_32_32();

    @Source("images/view_icon_16_16.png")
    ImageResource viewIcon_16_16();
    /*
     * close icons
     */

    @Source("images/close_icon_24_24.png")
    ImageResource closeIcon_24_24();

    @Source("images/close_icon_16_16.png")
    ImageResource closeIcon_16_16();
}
