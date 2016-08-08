/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.help;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;
import fr.hd3d.html5.video.client.VideoSource;
import fr.hd3d.html5.video.client.VideoSource.VideoType;
import fr.hd3d.html5.video.client.VideoWidget;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author yphanikumar
 */
public class HelpHome extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(HelpHome.class.getName());
    protected FlowPanel panel = new FlowPanel();
    protected final String videosLinkPrefix = "help/videos/";
    protected final String mp4 = "mp4";
    protected final String webm = "webm";
    protected final String ogg = "ogg";
    protected final String flv = "flv";
    protected final String fullVideo = "full";
    protected final String rolesVideo = "roles";
    protected final String myofficeVideo = "myoffice";
    protected final String adminVideo = "admin";
    protected final String notificationsVideo = "notifications";
    protected final String socialVideo = "social";
    protected final String driveVideo = "drive";
    protected final String bulkimportVideo = "bulkimport";
    protected final String accountresetVideo = "account_reset";
    protected final String defaultImage = "help/videos/default.png";
    protected final String onboardingVideo = "onboarding";
    protected ClickableLink portalDocumentationSite = new ClickableLink("Portal Documentation");
    protected ClickableLink fullVideoL = new ClickableLink("Portal Full Demo");
    protected ClickableLink rolesVideoL = new ClickableLink("Portal Roles Demo");
    protected ClickableLink myofficeVideoL = new ClickableLink("Portal My Office Demo");
    protected ClickableLink onboardingVideoL = new ClickableLink("Portal Employee Onboarding Demo");
    protected ClickableLink adminVideoL = new ClickableLink("Portal Admin Demo");
    protected ClickableLink notificationsVideoL = new ClickableLink("Portal Notifications Demo");
    protected ClickableLink socialVideoL = new ClickableLink("Portal Social Demo");
    protected ClickableLink driveVideoL = new ClickableLink("Portal Drive Demo");
    protected ClickableLink bulkimportVideoL = new ClickableLink("Portal BulkImport Demo");
    protected ClickableLink accountresetVideoL = new ClickableLink("Portal AccountReset Demo");

    public HelpHome() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        portalDocumentationSite.addClickHandler(this);
        rolesVideoL.addClickHandler(this);
        myofficeVideoL.addClickHandler(this);
        adminVideoL.addClickHandler(this);
        notificationsVideoL.addClickHandler(this);
        socialVideoL.addClickHandler(this);
        driveVideoL.addClickHandler(this);
        bulkimportVideoL.addClickHandler(this);
        accountresetVideoL.addClickHandler(this);
        onboardingVideoL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        portalDocumentationSite.addStyleName("helpVideoLink");
    }

    @Override
    protected void addWidgets() {
        panel.add(portalDocumentationSite);
        panel.add(fullVideoL);
        panel.add(rolesVideoL);
        panel.add(myofficeVideoL);
        panel.add(adminVideoL);
        panel.add(notificationsVideoL);
        panel.add(socialVideoL);
        panel.add(driveVideoL);
        panel.add(bulkimportVideoL);
        panel.add(accountresetVideoL);
        panel.add(onboardingVideoL);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(portalDocumentationSite)) {
            Window.open(OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl(), "", "");
        }
        if (event.getSource().equals(fullVideoL)) {
            new GenericPopup(getFullVideoWidget()).show();
        }
        if (event.getSource().equals(rolesVideoL)) {
            new GenericPopup(getRolesVideoWidget()).show();
        }
        if (event.getSource().equals(myofficeVideoL)) {
            new GenericPopup(getMyOfficeVideoWidget()).show();
        }
        if (event.getSource().equals(adminVideoL)) {
            new GenericPopup(getAdminVideoWidget()).show();
        }
        if (event.getSource().equals(notificationsVideoL)) {
            new GenericPopup(getNotificationsVideoWidget()).show();
        }
        if (event.getSource().equals(socialVideoL)) {
            new GenericPopup(getSocialVideoWidget()).show();
        }
        if (event.getSource().equals(driveVideoL)) {
            new GenericPopup(getDriveVideoWidget()).show();
        }
        if (event.getSource().equals(bulkimportVideoL)) {
            new GenericPopup(getBulkImportVideoWidget()).show();
        }
        if (event.getSource().equals(accountresetVideoL)) {
            new GenericPopup(getAccountResetVideoWidget()).show();
        }
        if (event.getSource().equals(onboardingVideoL)) {
            new GenericPopup(getOnboardingVideoWidget()).show();
        }
    }

    protected VideoWidget getFullVideoWidget() {
        VideoWidget videoPlayer = new VideoWidget(false, true, ChiliClientConfig.instance().getFileDownloadUrl() + defaultImage);
        List<VideoSource> sources = new ArrayList<VideoSource>();
        sources.add(new VideoSource(ChiliClientConfig.instance().getFileDownloadUrl() + videosLinkPrefix + webm + "/" + fullVideo + "."
                + webm, VideoType.WEBM));
        videoPlayer.setSources(sources);
        videoPlayer.setPixelSize(500, 400);
        return videoPlayer;
    }

    protected VideoWidget getRolesVideoWidget() {
        VideoWidget videoPlayer = new VideoWidget(false, true, ChiliClientConfig.instance().getFileDownloadUrl() + defaultImage);
        List<VideoSource> sources = new ArrayList<VideoSource>();
        sources.add(new VideoSource(ChiliClientConfig.instance().getFileDownloadUrl() + videosLinkPrefix + webm + "/" + rolesVideo + "."
                + webm, VideoType.WEBM));
        videoPlayer.setSources(sources);
        videoPlayer.setPixelSize(500, 400);
        return videoPlayer;
    }

    protected VideoWidget getMyOfficeVideoWidget() {
        VideoWidget videoPlayer = new VideoWidget(false, true, ChiliClientConfig.instance().getFileDownloadUrl() + defaultImage);
        List<VideoSource> sources = new ArrayList<VideoSource>();
        sources.add(new VideoSource(ChiliClientConfig.instance().getFileDownloadUrl() + videosLinkPrefix + webm + "/" + myofficeVideo + "."
                + webm, VideoType.WEBM));
        videoPlayer.setSources(sources);
        videoPlayer.setPixelSize(500, 400);
        return videoPlayer;
    }

    protected VideoWidget getAdminVideoWidget() {
        VideoWidget videoPlayer = new VideoWidget(false, true, ChiliClientConfig.instance().getFileDownloadUrl() + defaultImage);
        List<VideoSource> sources = new ArrayList<VideoSource>();
        sources.add(new VideoSource(ChiliClientConfig.instance().getFileDownloadUrl() + videosLinkPrefix + webm + "/" + adminVideo + "."
                + webm, VideoType.WEBM));
        videoPlayer.setSources(sources);
        videoPlayer.setPixelSize(500, 400);
        return videoPlayer;
    }

    protected VideoWidget getNotificationsVideoWidget() {
        VideoWidget videoPlayer = new VideoWidget(false, true, ChiliClientConfig.instance().getFileDownloadUrl() + defaultImage);
        List<VideoSource> sources = new ArrayList<VideoSource>();
        sources.add(new VideoSource(ChiliClientConfig.instance().getFileDownloadUrl() + videosLinkPrefix + webm + "/" + notificationsVideo + "."
                + webm, VideoType.WEBM));
        videoPlayer.setSources(sources);
        videoPlayer.setPixelSize(500, 400);
        return videoPlayer;
    }

    protected VideoWidget getSocialVideoWidget() {
        VideoWidget videoPlayer = new VideoWidget(false, true, ChiliClientConfig.instance().getFileDownloadUrl() + defaultImage);
        List<VideoSource> sources = new ArrayList<VideoSource>();
        sources.add(new VideoSource(ChiliClientConfig.instance().getFileDownloadUrl() + videosLinkPrefix + webm + "/" + socialVideo + "."
                + webm, VideoType.WEBM));
        videoPlayer.setSources(sources);
        videoPlayer.setPixelSize(500, 400);
        return videoPlayer;
    }

    protected VideoWidget getDriveVideoWidget() {
        VideoWidget videoPlayer = new VideoWidget(false, true, ChiliClientConfig.instance().getFileDownloadUrl() + defaultImage);
        List<VideoSource> sources = new ArrayList<VideoSource>();
        sources.add(new VideoSource(ChiliClientConfig.instance().getFileDownloadUrl() + videosLinkPrefix + webm + "/" + driveVideo + "."
                + webm, VideoType.WEBM));
        videoPlayer.setSources(sources);
        videoPlayer.setPixelSize(500, 400);
        return videoPlayer;
    }

    protected VideoWidget getBulkImportVideoWidget() {
        VideoWidget videoPlayer = new VideoWidget(false, true, ChiliClientConfig.instance().getFileDownloadUrl() + defaultImage);
        List<VideoSource> sources = new ArrayList<VideoSource>();
        sources.add(new VideoSource(ChiliClientConfig.instance().getFileDownloadUrl() + videosLinkPrefix + webm + "/" + bulkimportVideo + "."
                + webm, VideoType.WEBM));
        videoPlayer.setSources(sources);
        videoPlayer.setPixelSize(500, 400);
        return videoPlayer;
    }

    protected VideoWidget getAccountResetVideoWidget() {
        VideoWidget videoPlayer = new VideoWidget(false, true, ChiliClientConfig.instance().getFileDownloadUrl() + defaultImage);
        List<VideoSource> sources = new ArrayList<VideoSource>();
        sources.add(new VideoSource(ChiliClientConfig.instance().getFileDownloadUrl() + videosLinkPrefix + webm + "/" + accountresetVideo + "."
                + webm, VideoType.WEBM));
        videoPlayer.setSources(sources);
        videoPlayer.setPixelSize(500, 400);
        return videoPlayer;
    }
    
    protected VideoWidget getOnboardingVideoWidget() {
        VideoWidget videoPlayer = new VideoWidget(false, true, ChiliClientConfig.instance().getFileDownloadUrl() + defaultImage);
        List<VideoSource> sources = new ArrayList<VideoSource>();
        sources.add(new VideoSource(ChiliClientConfig.instance().getFileDownloadUrl() + videosLinkPrefix + webm + "/" + onboardingVideo + "."
                + webm, VideoType.WEBM));
        videoPlayer.setSources(sources);
        videoPlayer.setPixelSize(500, 400);
        return videoPlayer;
    }
}
