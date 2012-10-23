/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

/**
 *
 * @author yalamanchili
 */
public interface OfficeImages extends ClientBundle {

    public static final OfficeImages INSTANCE = GWT.create(OfficeImages.class);

    @Source("info/yalamanchili/office/public/office.css")
    @NotStrict
    OfficeCss officeCss();

    @Source("images/default-image.gif")
    @ImageOptions(height = 50, width = 50)
    ImageResource defaultImage_50_50();

    @Source("images/logo.png")
    ImageResource logo();
    
    @Source("images/login_pg_features.png")
    ImageResource loginFeatures();

    @Source("images/default-image.gif")
    ImageResource defaultImage();

    @Source("images/Tab_button.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource tabButton();

    @Source("images/tab_button_click.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource tabButtonClick();

    @Source("images/index_bar.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource indexBar();

    @Source("images/paging_bar.png")
    @ImageOptions(repeatStyle = RepeatStyle.Horizontal)
    ImageResource pagingBar();

    @Source("images/search_bg.png")
    ImageResource searchBG();

    @Source("images/favicon.png")
    ImageResource favicon();

    @Source("images/home_button.png")
    ImageResource homeButton();

    @Source("images/menubar_bg.png")
    ImageResource menuBarBG();

    /*
     * View Icons
     */
    @Source("images/view_icon_16_16.png")
    ImageResource viewIcon_16_16();

    @Source("images/view_h_icon_16_16.png")
    ImageResource viewhIcon_16_16();
    /*
     * Update Edit Icons
     */

    @Source("images/update_icon_16_16.png")
    ImageResource updateIcon_16_16();
    /*
     * Delete Icons
     */

    @Source("images/delete_icon_16_16.png")
    ImageResource deleteIcon_16_16();

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
