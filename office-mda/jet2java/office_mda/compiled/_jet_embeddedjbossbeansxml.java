package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_embeddedjbossbeansxml implements JET2Template {

    public _jet_embeddedjbossbeansxml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("<deployment xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            xsi:schemaLocation=\"urn:jboss:bean-deployer bean-deployer_1_0.xsd\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            xmlns=\"urn:jboss:bean-deployer\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <bean name=\"Naming\" class=\"org.jnp.server.SingletonNamingServer\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"InitialContextProperties\" class=\"java.util.Hashtable\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <constructor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <parameter class=\"java.util.Map\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            <map keyClass=\"java.lang.String\" valueClass=\"java.lang.String\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("               <entry>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                  <key>java.naming.factory.initial</key>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                  <value>org.jnp.interfaces.LocalOnlyContextFactory</value>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("               </entry>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("               <entry>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                   <key>java.naming.factory.url.pkgs</key>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                   <value>org.jboss.naming:org.jnp.interfaces</value>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("               </entry>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            </map>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </parameter>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </constructor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"java:comp/Initializer\" class=\"org.jboss.ejb3.embedded.JavaCompInitializer\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"jndiProperties\"><inject bean=\"InitialContextProperties\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"XidFactory\" class=\"org.jboss.tm.XidFactoryImpl\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"XidFactoryMBean\" class=\"org.jboss.ejb3.embedded.XidFactoryMBean\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <constructor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <parameter class=\"org.jboss.tm.XidFactoryBase\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            <inject bean=\"XidFactory\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         </parameter>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </constructor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"TransactionManagerInitializer\" class=\"org.jboss.tm.TransactionManagerInitializer\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"xidFactory\"><inject bean=\"XidFactory\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"initialContextProperties\"><inject bean=\"InitialContextProperties\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"UserTransaction\" class=\"org.jboss.ejb3.embedded.UserTransactionImpl\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <demand>TransactionManagerInitializer</demand>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"UserTransactionBinding\" class=\"org.jboss.ejb3.embedded.JndiBinder\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"jndiProperties\"><inject bean=\"InitialContextProperties\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"target\"><inject bean=\"UserTransaction\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"bindTo\">UserTransaction</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"serializable\">false</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"TransactionManager\" class=\"java.lang.Object\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <constructor factoryMethod=\"getTransactionManager\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <factory bean=\"TransactionManagerInitializer\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </constructor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <bean name=\"CachedConnectionManager\" class=\"org.jboss.resource.connectionmanager.CachedConnectionManagerReference\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"transactionManager\"><inject bean=\"TransactionManager\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <!--");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <bean class=\"org.jboss.jdbc.HypersonicDatabase\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        name=\"jboss:service=Hypersonic,database=localDB\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        <property name=\"database\">localDB</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        <property name=\"inProcessMode\">true</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        <property name=\"dbDataDir\">.</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"DefaultDSBootstrap\" class=\"org.jboss.resource.adapter.jdbc.local.LocalTxDataSource\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"driverClass\">org.hsqldb.jdbcDriver</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"connectionURL\">jdbc:hsqldb:.</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <!--      <property name=\"connectionURL\">jdbc:hsqldb:./hypersonic/localDB</property> -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"userName\">sa</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"jndiName\">java:/DefaultDS</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"minSize\">0</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"maxSize\">10</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"blockingTimeout\">1000</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"idleTimeout\">100000</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"transactionManager\"><inject bean=\"TransactionManager\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"cachedConnectionManager\"><inject bean=\"CachedConnectionManager\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"initialContextProperties\"><inject bean=\"InitialContextProperties\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"DefaultDS\" class=\"java.lang.Object\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <constructor factoryMethod=\"getDatasource\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <factory bean=\"DefaultDSBootstrap\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </constructor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 96, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("DSBootstrap\" class=\"org.jboss.resource.adapter.jdbc.local.LocalTxDataSource\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"driverClass\">org.hsqldb.jdbcDriver</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"connectionURL\">jdbc:hsqldb:.</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <!--      <property name=\"connectionURL\">jdbc:hsqldb:./hypersonic/localDB</property> -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"userName\">sa</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"jndiName\">java:/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 101, 39)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("DS</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"minSize\">0</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"maxSize\">10</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"blockingTimeout\">1000</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"idleTimeout\">100000</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"transactionManager\"><inject bean=\"TransactionManager\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"cachedConnectionManager\"><inject bean=\"CachedConnectionManager\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"initialContextProperties\"><inject bean=\"InitialContextProperties\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 111, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("DS\" class=\"java.lang.Object\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <constructor factoryMethod=\"getDatasource\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <factory bean=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 113, 25)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("DSBootstrap\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </constructor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <!--");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   <bean name=\"TimerServiceFactory\" class=\"org.jboss.ejb3.timerservice.quartz.QuartzTimerServiceFactory\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"properties\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        \torg.quartz.jobStore.class=org.quartz.impl.jdbcjobstore.JobStoreCMT");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            org.quartz.jobStore.nonManagedTXDataSource=myDS");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            org.quartz.jobStore.driverDelegateClass=org.quartz.impl.jdbcjobstore.HSQLDBDelegate");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            org.quartz.jobStore.tablePrefix=QRTZ_");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            org.quartz.jobStore.dataSource=myDS");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t        # To get it to work with hypersonic");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t        # FIXME: this doesn't lock the row");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            org.quartz.jobStore.selectWithLockSQL=SELECT * FROM qrtz_locks WHERE lock_name = ?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        \t# from quartz.properties");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            org.quartz.scheduler.instanceName=JBossEJB3QuartzScheduler");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            org.quartz.scheduler.rmi.export=false");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            org.quartz.scheduler.rmi.proxy=false");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            org.quartz.scheduler.wrapJobExecutionInUserTransaction=false");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            org.quartz.threadPool.class=org.quartz.simpl.SimpleThreadPool");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            org.quartz.threadPool.threadCount=10");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            org.quartz.threadPool.threadPriority=5");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread=true");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        \torg.quartz.jobStore.misfireThreshold=60000");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"dataSource\">java:/DefaultDS</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"sqlProperties\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         CREATE_DB_ON_STARTUP = TRUE");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         CREATE_TABLE_JOB_DETAILS = CREATE TABLE qrtz_job_details(JOB_NAME VARCHAR(80) NOT NULL, JOB_GROUP VARCHAR(80) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            DESCRIPTION VARCHAR(120) NULL, JOB_CLASS_NAME VARCHAR(128) NOT NULL, IS_DURABLE VARCHAR(1) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            IS_VOLATILE VARCHAR(1) NOT NULL, IS_STATEFUL VARCHAR(1) NOT NULL, REQUESTS_RECOVERY VARCHAR(1) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            JOB_DATA BINARY NULL, PRIMARY KEY (JOB_NAME,JOB_GROUP))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         CREATE_TABLE_JOB_LISTENERS = CREATE TABLE qrtz_job_listeners(JOB_NAME VARCHAR(80) NOT NULL, JOB_GROUP VARCHAR(80) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            JOB_LISTENER VARCHAR(80) NOT NULL, PRIMARY KEY (JOB_NAME,JOB_GROUP,JOB_LISTENER), FOREIGN KEY (JOB_NAME,JOB_GROUP) \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            REFERENCES QRTZ_JOB_DETAILS(JOB_NAME,JOB_GROUP))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         CREATE_TABLE_TRIGGERS = CREATE TABLE qrtz_triggers(TRIGGER_NAME VARCHAR(80) NOT NULL, TRIGGER_GROUP VARCHAR(80) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            JOB_NAME VARCHAR(80) NOT NULL, JOB_GROUP VARCHAR(80) NOT NULL, IS_VOLATILE VARCHAR(1) NOT NULL, DESCRIPTION VARCHAR(120) NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            NEXT_FIRE_TIME NUMERIC(13) NULL, PREV_FIRE_TIME NUMERIC(13) NULL, TRIGGER_STATE VARCHAR(16) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            TRIGGER_TYPE VARCHAR(8) NOT NULL, START_TIME NUMERIC(13) NOT NULL, END_TIME NUMERIC(13) NULL, CALENDAR_NAME VARCHAR(80) NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            MISFIRE_INSTR NUMERIC(2) NULL, JOB_DATA BINARY NULL, PRIMARY KEY (TRIGGER_NAME,TRIGGER_GROUP), FOREIGN KEY (JOB_NAME,JOB_GROUP) \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            REFERENCES QRTZ_JOB_DETAILS(JOB_NAME,JOB_GROUP))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         CREATE_TABLE_SIMPLE_TRIGGERS = CREATE TABLE qrtz_simple_triggers(TRIGGER_NAME VARCHAR(80) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            TRIGGER_GROUP VARCHAR(80) NOT NULL, REPEAT_COUNT NUMERIC(7) NOT NULL, REPEAT_INTERVAL NUMERIC(12) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            TIMES_TRIGGERED NUMERIC(7) NOT NULL, PRIMARY KEY (TRIGGER_NAME,TRIGGER_GROUP), FOREIGN KEY (TRIGGER_NAME,TRIGGER_GROUP) \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            REFERENCES QRTZ_TRIGGERS(TRIGGER_NAME,TRIGGER_GROUP))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         CREATE_TABLE_CRON_TRIGGERS = CREATE TABLE qrtz_cron_triggers(TRIGGER_NAME VARCHAR(80) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            TRIGGER_GROUP VARCHAR(80) NOT NULL, CRON_EXPRESSION VARCHAR(80) NOT NULL, TIME_ZONE_ID VARCHAR(80), \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            PRIMARY KEY (TRIGGER_NAME,TRIGGER_GROUP), FOREIGN KEY (TRIGGER_NAME,TRIGGER_GROUP) \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            REFERENCES QRTZ_TRIGGERS(TRIGGER_NAME,TRIGGER_GROUP))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         CREATE_TABLE_BLOB_TRIGGERS = CREATE TABLE qrtz_blob_triggers(TRIGGER_NAME VARCHAR(80) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            TRIGGER_GROUP VARCHAR(80) NOT NULL, BLOB_DATA BINARY NULL, PRIMARY KEY (TRIGGER_NAME,TRIGGER_GROUP), \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            FOREIGN KEY (TRIGGER_NAME,TRIGGER_GROUP) REFERENCES QRTZ_TRIGGERS(TRIGGER_NAME,TRIGGER_GROUP))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         CREATE_TABLE_TRIGGER_LISTENERS = CREATE TABLE qrtz_trigger_listeners(TRIGGER_NAME VARCHAR(80) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            TRIGGER_GROUP VARCHAR(80) NOT NULL, TRIGGER_LISTENER VARCHAR(80) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            PRIMARY KEY (TRIGGER_NAME,TRIGGER_GROUP,TRIGGER_LISTENER), FOREIGN KEY (TRIGGER_NAME,TRIGGER_GROUP) \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            REFERENCES QRTZ_TRIGGERS(TRIGGER_NAME,TRIGGER_GROUP))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         CREATE_TABLE_CALENDARS = CREATE TABLE qrtz_calendars(CALENDAR_NAME VARCHAR(80) NOT NULL, CALENDAR BINARY NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            PRIMARY KEY (CALENDAR_NAME))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         CREATE_TABLE_PAUSED_TRIGGER_GRPS = CREATE TABLE qrtz_paused_trigger_grps(TRIGGER_GROUP VARCHAR(80) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            PRIMARY KEY (TRIGGER_GROUP))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         CREATE_TABLE_FIRED_TRIGGERS = CREATE TABLE qrtz_fired_triggers(ENTRY_ID VARCHAR(95) NOT NULL, TRIGGER_NAME VARCHAR(80) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            TRIGGER_GROUP VARCHAR(80) NOT NULL, IS_VOLATILE VARCHAR(1) NOT NULL, INSTANCE_NAME VARCHAR(80) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            FIRED_TIME NUMERIC(13) NOT NULL, STATE VARCHAR(16) NOT NULL, JOB_NAME VARCHAR(80) NULL, JOB_GROUP VARCHAR(80) NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            IS_STATEFUL VARCHAR(1) NULL, REQUESTS_RECOVERY VARCHAR(1) NULL, PRIMARY KEY (ENTRY_ID))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         CREATE_TABLE_SCHEDULER_STATE = CREATE TABLE qrtz_scheduler_state(INSTANCE_NAME VARCHAR(80) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            LAST_CHECKIN_TIME NUMERIC(13) NOT NULL, CHECKIN_INTERVAL NUMERIC(13) NOT NULL, RECOVERER VARCHAR(80) NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            PRIMARY KEY (INSTANCE_NAME))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         CREATE_TABLE_LOCKS = CREATE TABLE qrtz_locks(LOCK_NAME VARCHAR(40) NOT NULL, PRIMARY KEY (LOCK_NAME))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         INSERT_TRIGGER_ACCESS = INSERT INTO qrtz_locks values('TRIGGER_ACCESS')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         INSERT_JOB_ACCESS = INSERT INTO qrtz_locks values('JOB_ACCESS')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         INSERT_CALENDAR_ACCESS = INSERT INTO qrtz_locks values('CALENDAR_ACCESS')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         INSERT_STATE_ACCESS = INSERT INTO qrtz_locks values('STATE_ACCESS')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         INSERT_MISFIRE_ACCESS = INSERT INTO qrtz_locks values('MISFIRE_ACCESS')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</deployment>");  //$NON-NLS-1$        
    }
}
