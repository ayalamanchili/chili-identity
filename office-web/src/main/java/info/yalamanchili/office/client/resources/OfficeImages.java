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

    @Source("images/logo.png")
    ImageResource logo();

    @Source("images/default-image.gif")
    ImageResource defaultImage();
    /*
     * View Icons
     */

    @Source("images/view_icon_24_24.png")
    ImageResource viewIcon_24_24();
    /*
     * Update Edit Icons
     */

    @Source("images/update_icon_24_24.png")
    ImageResource updateIcon_24_24();
    /*
     * Delete Icons
     */

    @Source("images/delete_icon_24_24.png")
    ImageResource deleteIcon_24_24();

    /*
     * close icons
     */
    @Source("images/close_icon_24_24.png")
    ImageResource closeIcon_24_24();

    @Source("images/close_icon_16_16.png")
    ImageResource closeIcon_16_16();

    @Source("images/like_icon_16_16.png")
    ImageResource likeIcon_16_16();

    @Source("images/reply_icon_16_16.png")
    ImageResource replyIcon_16_16();
}
