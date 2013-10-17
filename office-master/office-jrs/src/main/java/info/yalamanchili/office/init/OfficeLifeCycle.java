/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OfficeLifeCycle implements SmartLifecycle {

    private volatile boolean isRunning = false;

    @Autowired
    protected OfficeStartup officeStartup;

    @Override
    public boolean isRunning() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void start() {
        System.out
                .println("-------------------Office Startup--------------------------------");
        isRunning = true;
        officeStartup.startup();
    }

    @Override
    public void stop() {
        System.out
                .println("--------------------Office Stopped-------------------------------");
        isRunning = false;
    }

    @Override
    public int getPhase() {
        return 1;
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable arg0) {
        isRunning = false;
    }

}
