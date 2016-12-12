/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.init;

import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.mongo.tests.MongodForTestsFactory;
import de.flapdoodle.embed.process.runtime.Network;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class OfficeLifeCycle implements SmartLifecycle {

    private volatile boolean isRunning = false;

    protected MongodForTestsFactory factory;
    protected MongoClient mongo;

    @Autowired
    protected OfficeStartup officeStartup;

    @Override
    public boolean isRunning() {
        // TODO Auto-generated method stub
        return false;
    }

    MongodExecutable mongodExecutable = null;

    @Override
    public void start() {
        System.out
                .println("-------------------Office Startup--------------------------------");
        isRunning = true;
        OfficeServiceConfiguration config = (OfficeServiceConfiguration) SpringContext.getBean("officeServiceConfiguration");
        if (config.getInitEmbeddedMongo()) {
            try {
                MongodStarter starter = MongodStarter.getDefaultInstance();
                int port = 12345;
                IMongodConfig mongodConfig = new MongodConfigBuilder()
                        .version(Version.Main.V2_6)
                        .net(new Net(port, Network.localhostIsIPv6()))
                        .build();
                mongodExecutable = starter.prepare(mongodConfig);
                MongodProcess mongod = mongodExecutable.start();
            } catch (Exception e) {

            }
        }
        officeStartup.startup();
    }

    @Override
    public void stop() {
        System.out
                .println("--------------------Office Stopped-------------------------------");
        if (mongodExecutable != null) {
            mongodExecutable.stop();
        }
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
    public void stop(Runnable arg0
    ) {
        isRunning = false;
    }

}
