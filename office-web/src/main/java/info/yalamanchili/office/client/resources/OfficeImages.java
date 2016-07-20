/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
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

    @Source("images/nav-logo.png")
    ImageResource logo();
    
    @Source("images/logo.png")
    ImageResource logoTest();
    
    @Source("images/cgs-logo.png")
    ImageResource cgsLogo();
    
    @Source("images/techPillars-logo.png")
    ImageResource techPillarsLogo();

    @Source("images/loginFeaturesImage.png")
    ImageResource loginFeatures();

    @Source("images/loginCenterImage.png")
    ImageResource loginCenter();

    @Source("images/forgot_password_icon.png")
    ImageResource forgotPassword();

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

    @Source("images/file_attachment_icon.png")
    ImageResource fileAttachmentIcon();

    @Source("images/search_bg.png")
    ImageResource searchBG();

    @Source("images/favicon.png")
    ImageResource favicon();

    @Source("images/home_button.png")
    ImageResource homeButton();

    @Source("images/menubar_bg.png")
    ImageResource menuBarBG();

    /*
     * close icons
     */
    @Source("images/close_icon_24_24.png")
    ImageResource closeIcon_24_24();

    @Source("images/close_icon_16_16.png")
    ImageResource closeIcon_16_16();
    
     @Source("images/close_grey_16_16.png")
    ImageResource closeIcon_grey_16_16();

    @Source("images/like_icon_16_16.png")
    ImageResource likeIcon_16_16();

    @Source("images/reply_icon_16_16.png")
    ImageResource replyIcon_16_16();

    @Source("images/star.png")
    ImageResource star();

    @Source("images/empty_star.png")
    ImageResource empty_star();
}
