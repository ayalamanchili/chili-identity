package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_jbossjmsbeansxml implements JET2Template {

    public _jet_jbossjmsbeansxml() {
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
        out.write("   <bean name=\"jboss.mq:service=JMSProviderLoader,name=JMSProvider\" class=\"org.jboss.jms.jndi.JNDIProviderAdapter\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"factoryRef\">java:/XAConnectionFactory</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"queueFactoryRef\">java:/XAConnectionFactory</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"topicFactoryRef\">java:/XAConnectionFactory</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"properties\" class=\"java.util.Properties\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("               <map keyClass=\"java.lang.String\" valueClass=\"java.lang.String\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                  <entry>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                     <key>java.naming.factory.initial</key>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                     <value>org.jnp.interfaces.LocalOnlyContextFactory</value>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                  </entry>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                  <entry>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                      <key>java.naming.factory.url.pkgs</key>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                      <value>org.jboss.naming:org.jnp.interfaces</value>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                  </entry>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("               </map>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"b1\" class=\"org.jboss.ejb3.embedded.JndiBinder\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"jndiProperties\"><inject bean=\"InitialContextProperties\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"target\"><inject bean=\"jboss.mq:service=JMSProviderLoader,name=JMSProvider\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"bindTo\">java:/DefaultJMSProvider</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"serializable\">true</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"jboss.mq:service=ServerSessionPoolMBean,name=StdJMSPool\" class=\"org.jboss.jms.asf.StdServerSessionPoolFactory\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"name\">StdJMSPool</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"xidFactory\"><inject bean=\"XidFactoryMBean\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"transactionManager\"><inject bean=\"TransactionManager\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"b2\" class=\"org.jboss.ejb3.embedded.JndiBinder\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"jndiProperties\"><inject bean=\"InitialContextProperties\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"target\"><inject bean=\"jboss.mq:service=ServerSessionPoolMBean,name=StdJMSPool\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"bindTo\">java:/StdJMSPool</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"serializable\">false</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"jboss.mq:service=PersistenceManager\" class=\"org.jboss.mq.kernel.JDBC2PersistenceManager\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"transactionManager\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <inject bean=\"TransactionManager\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"datasource\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <inject bean=\"DefaultDS\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"sqlProperties\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("            BLOB_TYPE=OBJECT_BLOB");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            INSERT_TX = INSERT INTO JMS_TRANSACTIONS (TXID) values(?)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            INSERT_MESSAGE = INSERT INTO JMS_MESSAGES (MESSAGEID, DESTINATION, MESSAGEBLOB, TXID, TXOP) VALUES(?,?,?,?,?)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            SELECT_ALL_UNCOMMITED_TXS = SELECT TXID FROM JMS_TRANSACTIONS");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            SELECT_MAX_TX = SELECT MAX(TXID) FROM JMS_MESSAGES");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            SELECT_MESSAGES_IN_DEST = SELECT MESSAGEID, MESSAGEBLOB FROM JMS_MESSAGES WHERE DESTINATION=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            SELECT_MESSAGE = SELECT MESSAGEID, MESSAGEBLOB FROM JMS_MESSAGES WHERE MESSAGEID=? AND DESTINATION=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            MARK_MESSAGE = UPDATE JMS_MESSAGES SET TXID=?, TXOP=? WHERE MESSAGEID=? AND DESTINATION=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            UPDATE_MESSAGE = UPDATE JMS_MESSAGES SET MESSAGEBLOB=? WHERE MESSAGEID=? AND DESTINATION=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            UPDATE_MARKED_MESSAGES = UPDATE JMS_MESSAGES SET TXID=?, TXOP=? WHERE TXOP=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            UPDATE_MARKED_MESSAGES_WITH_TX = UPDATE JMS_MESSAGES SET TXID=?, TXOP=? WHERE TXOP=? AND TXID=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            DELETE_MARKED_MESSAGES_WITH_TX = DELETE FROM JMS_MESSAGES WHERE TXOP=? AND JMS_MESSAGES.TXID IN (SELECT TXID FROM JMS_TRANSACTIONS)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            DELETE_TX = DELETE FROM JMS_TRANSACTIONS WHERE TXID = ?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            DELETE_MARKED_MESSAGES = DELETE FROM JMS_MESSAGES WHERE TXID=? AND TXOP=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            DELETE_MESSAGE = DELETE FROM JMS_MESSAGES WHERE MESSAGEID=? AND DESTINATION=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            CREATE_MESSAGE_TABLE = CREATE CACHED TABLE JMS_MESSAGES ( MESSAGEID INTEGER NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("               DESTINATION VARCHAR(255) NOT NULL, TXID INTEGER, TXOP CHAR(1), \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("               MESSAGEBLOB OBJECT, PRIMARY KEY (MESSAGEID, DESTINATION) )");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            CREATE_IDX_MESSAGE_TXOP_TXID = CREATE INDEX JMS_MESSAGES_TXOP_TXID ON JMS_MESSAGES (TXOP, TXID)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            CREATE_IDX_MESSAGE_DESTINATION = CREATE INDEX JMS_MESSAGES_DESTINATION ON JMS_MESSAGES (DESTINATION)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            CREATE_TX_TABLE = CREATE CACHED TABLE JMS_TRANSACTIONS ( TXID INTEGER, PRIMARY KEY (TXID) )");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            CREATE_TABLES_ON_STARTUP = TRUE");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            DELETE_TEMPORARY_MESSAGES = DELETE FROM JMS_MESSAGES WHERE TXOP='T'");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("      </property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"jboss.mq:service=MessageCache\" class=\"org.jboss.mq.kernel.MessageCache\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"persistenceManager\"><inject bean=\"jboss.mq:service=PersistenceManager\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"highMemoryMark\">50</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"maxMemoryMark\">60</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"jms-rar-WorkManager\" class=\"org.jboss.ejb3.embedded.resource.JBossWorkManager\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"jms-rar-DeploymentInfo\" class=\"org.jboss.ejb3.embedded.resource.Ejb3DeploymentInfo\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <constructor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <parameter class=\"java.lang.String\">jms-ra.rar</parameter>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <parameter class=\"java.lang.String\">javax.jms.MessageListener</parameter>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <parameter class=\"java.lang.String\">org.jboss.resource.adapter.jms.inflow.JmsActivationSpec</parameter>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </constructor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"jboss.jca:name='jms-ra.rar',service=RARDeployment\" class=\"org.jboss.ejb3.embedded.resource.RARDeployment\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   \t<constructor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <parameter class=\"org.jboss.deployment.DeploymentInfo\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            <inject bean=\"jms-rar-DeploymentInfo\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         </parameter>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </constructor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"workManager\"><inject bean=\"jms-rar-WorkManager\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"jboss.mq:service=StateManager\" class=\"org.jboss.mq.kernel.JDBCStateManager\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"transactionManager\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <inject bean=\"TransactionManager\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"datasource\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <inject bean=\"DefaultDS\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"sqlProperties\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("            CREATE_TABLES_ON_STARTUP = TRUE");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            CREATE_USER_TABLE = CREATE TABLE JMS_USERS (USERID VARCHAR(32) NOT NULL, PASSWD VARCHAR(32) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                                                       CLIENTID VARCHAR(128), PRIMARY KEY(USERID))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            CREATE_ROLE_TABLE = CREATE TABLE JMS_ROLES (ROLEID VARCHAR(32) NOT NULL, USERID VARCHAR(32) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                                                       PRIMARY KEY(USERID, ROLEID))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            CREATE_SUBSCRIPTION_TABLE = CREATE TABLE JMS_SUBSCRIPTIONS (CLIENTID VARCHAR(128) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                                                       SUBNAME VARCHAR(128) NOT NULL, TOPIC VARCHAR(255) NOT NULL, \\");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                                                       SELECTOR VARCHAR(255), PRIMARY KEY(CLIENTID, SUBNAME))");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            GET_SUBSCRIPTION = SELECT TOPIC, SELECTOR FROM JMS_SUBSCRIPTIONS WHERE CLIENTID=? AND SUBNAME=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            LOCK_SUBSCRIPTION = SELECT TOPIC, SELECTOR FROM JMS_SUBSCRIPTIONS WHERE CLIENTID=? AND SUBNAME=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            GET_SUBSCRIPTIONS_FOR_TOPIC = SELECT CLIENTID, SUBNAME, SELECTOR FROM JMS_SUBSCRIPTIONS WHERE TOPIC=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            INSERT_SUBSCRIPTION = INSERT INTO JMS_SUBSCRIPTIONS (CLIENTID, SUBNAME, TOPIC, SELECTOR) VALUES(?,?,?,?)");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            UPDATE_SUBSCRIPTION = UPDATE JMS_SUBSCRIPTIONS SET TOPIC=?, SELECTOR=? WHERE CLIENTID=? AND SUBNAME=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            REMOVE_SUBSCRIPTION = DELETE FROM JMS_SUBSCRIPTIONS WHERE CLIENTID=? AND SUBNAME=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            GET_USER_BY_CLIENTID = SELECT USERID, PASSWD, CLIENTID FROM JMS_USERS WHERE CLIENTID=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            GET_USER = SELECT PASSWD, CLIENTID FROM JMS_USERS WHERE USERID=?");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.01 = INSERT INTO JMS_USERS (USERID, PASSWD) VALUES ('guest', 'guest')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.02 = INSERT INTO JMS_USERS (USERID, PASSWD) VALUES ('j2ee', 'j2ee')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.03 = INSERT INTO JMS_USERS (USERID, PASSWD, CLIENTID) VALUES ('john', 'needle', 'DurableSubscriberExample')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.04 = INSERT INTO JMS_USERS (USERID, PASSWD) VALUES ('nobody', 'nobody')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.05 = INSERT INTO JMS_USERS (USERID, PASSWD) VALUES ('dynsub', 'dynsub')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.06 = INSERT INTO JMS_ROLES (ROLEID, USERID) VALUES ('guest','guest')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.07 = INSERT INTO JMS_ROLES (ROLEID, USERID) VALUES ('j2ee','guest')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.08 = INSERT INTO JMS_ROLES (ROLEID, USERID) VALUES ('john','guest')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.09 = INSERT INTO JMS_ROLES (ROLEID, USERID) VALUES ('subscriber','john')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.10 = INSERT INTO JMS_ROLES (ROLEID, USERID) VALUES ('publisher','john')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.11 = INSERT INTO JMS_ROLES (ROLEID, USERID) VALUES ('publisher','dynsub')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.12 = INSERT INTO JMS_ROLES (ROLEID, USERID) VALUES ('durpublisher','john')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.13 = INSERT INTO JMS_ROLES (ROLEID, USERID) VALUES ('durpublisher','dynsub')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            POPULATE.TABLES.14 = INSERT INTO JMS_ROLES (ROLEID, USERID) VALUES ('noacc','nobody')");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("      </property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"BasicQueueParameters\" class=\"org.jboss.mq.server.BasicQueueParameters\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"jboss.mq:service=ThreadPool\" class=\"org.jboss.util.threadpool.BasicThreadPool\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"name\">JMSThread</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"threadGroupName\">JBossMQ Server Threads</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <!-- The max number of threads in the pool -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"maximumPoolSize\">10</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <!-- The max number of tasks before the queue is full -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"maximumQueueSize\">1000</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <!-- The behavior of the pool when a task is added and the queue is full.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      abort - a RuntimeException is thrown");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      run - the calling thread executes the task");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      wait - the calling thread blocks until the queue has room");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      discard - the task is silently discarded without being run");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      discardOldest - check to see if a task is about to complete and enque");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         the new task if possible, else run the task in the calling thread");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"blockingModeString\">run</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"jboss.mq:service=DestinationManager\" class=\"org.jboss.mq.server.JMSDestinationManager\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <constructor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         <parameter class=\"org.jboss.mq.server.BasicQueueParameters\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            <inject bean=\"BasicQueueParameters\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("         </parameter>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      </constructor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"persistenceManager\"><inject bean=\"jboss.mq:service=PersistenceManager\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"messageCache\"><inject bean=\"jboss.mq:service=MessageCache\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"stateManager\"><inject bean=\"jboss.mq:service=StateManager\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"threadPool\"><inject bean=\"jboss.mq:service=ThreadPool\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"threadGroup\"><inject bean=\"jboss.mq:service=ThreadPool\" property=\"threadGroup\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <start method=\"startServer\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <stop method=\"stopServer\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"jboss.mq.destination:service=Queue,name=DLQ\" class=\"org.jboss.mq.kernel.Queue\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("     <property name=\"destinationManagerPojo\"><inject bean=\"jboss.mq:service=DestinationManager\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("     <property name=\"initialContextProperties\"><inject bean=\"InitialContextProperties\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"destinationName\">DLQ</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"jboss.mq:service=Invoker\" class=\"org.jboss.mq.server.JMSServerInvoker\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"next\"><inject bean=\"jboss.mq:service=DestinationManager\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("   <bean name=\"jboss.mq:service=invocationlayer,type=JVM\" class=\"org.jboss.mq.kernel.JVMIL\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"jmsInvoker\"><inject bean=\"jboss.mq:service=Invoker\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("     <property name=\"connectionFactoryJNDIRef\">java:/ConnectionFactory</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("     <property name=\"XAConnectionFactoryJNDIRef\">java:/XAConnectionFactory</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("     <property name=\"pingPeriod\">0</property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      <property name=\"initialContextProperties\"><inject bean=\"InitialContextProperties\"/></property>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   </bean>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("</deployment>");  //$NON-NLS-1$        
    }
}
