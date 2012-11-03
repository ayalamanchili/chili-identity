/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.help;

import com.google.gwt.user.client.ui.FlowPanel;
import fr.hd3d.html5.video.client.VideoSource;
import fr.hd3d.html5.video.client.VideoSource.VideoType;
import fr.hd3d.html5.video.client.VideoWidget;
import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.config.OfficeWebConfiguration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yphanikumar
 */
public class HelpHome extends ALComposite {

    protected FlowPanel panel = new FlowPanel();

    public HelpHome() {
        init(panel);
    }

    protected VideoWidget getInternalUserVideoWidget() {
        VideoWidget videoPlayer = new VideoWidget(false, true, OfficeWelcome.config.getFileDownloadUrl() + "help/videos/default.png");
        List<VideoSource> sources = new ArrayList<VideoSource>();
        sources.add(new VideoSource(OfficeWelcome.config.getFileDownloadUrl() + "help/videos/portal_internal_employee_demo.mp4"));
        videoPlayer.setSources(sources);
        videoPlayer.setPixelSize(500, 400);
        return videoPlayer;
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        panel.add(getInternalUserVideoWidget());
    }
}
