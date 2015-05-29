/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client;

/**
 *
 * @author anuyalamanchili
 */
import java.util.logging.Logger;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;

public class SessionTimeoutMonitor {

    private static final Logger log = Logger.getLogger(SessionTimeoutMonitor.class.getName());
    private static SessionTimeoutMonitor instance = new SessionTimeoutMonitor();
    private SessionTimeoutTimer activityTimer;
    private HandlerRegistration activityHandlerRegistration;
    //10 hours -server inactive timeout is set in web.xml
    private static final int TIMEOUT_IN_MINUTES = 600;

    private SessionTimeoutMonitor() {
        int total_timeout = maxSessionTimeoutSeconds();
        int timeout = TIMEOUT_IN_MINUTES * 60;
        if (timeout > total_timeout) {
            timeout = total_timeout / 2;
        }
        int idle = total_timeout - timeout;
        activityTimer = new SessionTimeoutTimer(idle, timeout);
        log.info("Created session timeout monitor for session expiration of " + total_timeout + "sec.");
    }

    private class SessionTimeoutTimer extends Timer {

        private Timer countdownTimer = new Timer() {
            @Override
            public void run() {
                updateTimeRemaining();
            }
        };
        private long startTime = 0;
        private int IDLE_SECONDS = TIMEOUT_IN_MINUTES * 60;
        private int TIMEOUT_SECONDS = TIMEOUT_IN_MINUTES * 60;
        private int reset_count = 0;

        public SessionTimeoutTimer(int idle, int timeout) {
            IDLE_SECONDS = idle;
            TIMEOUT_SECONDS = timeout;
        }

        public void updateTimeRemaining() {
            long time_left = TIMEOUT_SECONDS - (System.currentTimeMillis() - startTime) / 1000;
//            log.info("timeleft........" + time_left);
            if (time_left > 0) {
                int mins = (int) (time_left / 60);
                int secs = (int) (time_left % 60);
                String time_left_str = mins + " min. " + secs + " sec.";
//                html.setHTML("<p>No activity has been detected. You will be logged out in:</p><p style='font-size: 1.2em; font-weight: 700;'>"
//                        + time_left_str + "</p>");
            } else {
                countdownTimer.cancel();
                activityHandlerRegistration.removeHandler();
                onSessionTimeout();
            }
        }

        protected void onSessionTimeout() {
//            if (Window.confirm("Your Session expired due to inactivity. Click OK to continue work.")) {
//                reset(true);
//                HttpService.HttpServiceAsync.instance().doGet(pingUrl(), OfficeWelcome.instance().getHeaders(), true,
//                        new AsyncCallback<String>() {
//                            @Override
//                            public void onSuccess(String arg0) {
//                                new ResponseStatusWidget().show("Session renewed... Please continue");
//                            }
//
//                            @Override
//                            public void onFailure(Throwable caught) {
//                                throw new UnsupportedOperationException("Failed to renew Session. Please make sure you copy paste any unsaved data to notepad and relogin");
//                            }
//                        });
//            } else {
            HttpService.HttpServiceAsync.instance().logout(new ALAsyncCallback<Void>() {
                @Override
                public void onResponse(Void arg0) {
                    Window.Location.reload();
                }
            });
//            }
        }

        private String pingUrl() {
            return OfficeWelcome.constants.root_url() + "admin/ping";
        }

        @Override
        public void run() {
            startTime = System.currentTimeMillis();
            updateTimeRemaining();
            countdownTimer.scheduleRepeating(1 * 1000);
        }

        @Override
        public void schedule(int mseconds) {
            countdownTimer.cancel();
            super.schedule(mseconds);
        }

        public void reset(boolean force) {
            // If reset is called and the timeout warning is showing, or force is set and we've had
            // more than N operations, renew the session.
            if (force && reset_count == 25) {
                // we need to ping the server to prevent timeout.
                //TODO
            }
            schedule(IDLE_SECONDS * 1000);
            if (force) {
                reset_count = ++reset_count % 50;
            }
        }

        @SuppressWarnings("unused")
        public void reset() {
            reset(false);
        }
    };

    public void keepSessionAlive() {
        keepSessionAlive(0);
    }

    /**
     * Does two things: (1) Registers a global javascript method accessible from
     * handwritten javascript for keeping the session alive, (2) Registers a
     * nativepreview event handler for GWT code to monitor user's activity.
     */
    public void initialize() {
        registerKeepSessonAlive();

        activityHandlerRegistration = Event
                .addNativePreviewHandler(new Event.NativePreviewHandler() {
                    @Override
                    public void onPreviewNativeEvent(NativePreviewEvent event) {
                        keepSessionAlive();
                    }
                });
    }

    public int keepSessionAlive(int flag) {
        //log.info("Keep session alive (w/ flag): " + flag);
        activityTimer.reset(flag > 0);
        return flag;
    }

    // TODO: Shouldn't need to be passed in via JS.
    private native int maxSessionTimeoutSeconds() /*-{
     return $wnd.max_session_timeout_seconds;
     }-*/;

    public native void registerKeepSessonAlive() /*-{
     // XXX: Must create a pointer to "this" because it is a keyword and we lose 
     // the actual reference after this method exits.
     var _this = this;
     $wnd.keepSessionAlive = function (flag) { 
     return _this.@info.yalamanchili.office.client.SessionTimeoutMonitor::keepSessionAlive(I)(flag);
     };
     }-*/;

    public static SessionTimeoutMonitor get() {
        return instance;
    }
}
