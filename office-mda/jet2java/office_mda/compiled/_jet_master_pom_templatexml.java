package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_master_pom_templatexml implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_master_pom_templatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_if_182_3 = new TagInfo("c:if", //$NON-NLS-1$
            182, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<modelVersion>4.0.0</modelVersion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 5, 11)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 6, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-master</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<packaging>pom</packaging>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$version}", 8, 11)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<name>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 9, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-master</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<url>http://somecompany.com</url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency> ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   \t\t\t<groupId>junit</groupId> ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   \t\t\t<artifactId>junit</artifactId> ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   \t\t\t<version>4.8.1</version> ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   \t\t\t<scope>test</scope> ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency> ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   \t\t\t<groupId>org.jboss.arquillian</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   \t\t\t<artifactId>arquillian-junit</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   \t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${arquillian.version}'}", 21, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   \t\t\t<scope>test</scope>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>yalamanchili</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>y-common-deps</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 27, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<type>pom</type>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>info.yalamanchili.security</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>yalamanchili-security</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 34, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>info.yalamanchili.commons</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>yalamanchili-commons</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 39, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>com.google.gwt</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>gwt-servlet</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${gwt.version}'}", 44, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!--<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>com.google.gwt</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>gwt-user</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${gwtVersion}'}", 49, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency> -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<!-- gilead libraries -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>net.sf.gilead</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>gilead-core</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>1.3.2</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>net.sf.gilead</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>gilead-hibernate</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>1.3.2</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>net.sf.gilead</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>gilead4gwt</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>1.3.2</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!--  bean libs -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>net.sf.beanlib</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>beanlib</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>5.0.2beta</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<exclusions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>cglib</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>cglib</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>xstream</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>xstream</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>asm</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>asm</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>aopalliance</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>aopalliance</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>net.jcip</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>jcip-annotations</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>log4j</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>log4j</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</exclusions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>net.sf.beanlib</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>beanlib-hibernate</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>5.0.2beta</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<exclusions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>org.hibernate</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>hibernate</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>org.springframework</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>spring</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>ehcache</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>ehcache</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>asm</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>asm-attrs</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>antlr</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>antlr</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</exclusions>\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>net.sf.cglib</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>cglib-nodep</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>2.1</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!-- GWT request factory -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>com.google.web.bindery</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>requestfactory-server</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>2.4.0</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<exclusions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>javax.validation</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>validation-api</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</exclusions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!--seam remoting -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>org.jboss.seam</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>jboss-seam-remoting</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>2.2.0.GA</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<exclusions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>org.jboss.seam</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>jboss-seam</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>dom4j</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>dom4j</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>xstream</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>xstream</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>xpp3</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>xpp3_min</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>org.jboss.el</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>jboss-el</artifactId>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</exclusions>\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!-- file upload support -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>org.apache.commons</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>commons-fileupload</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>1.2.1</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>org.apache.commons</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>commons-io</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>1.4</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>\t");  //$NON-NLS-1$        
        out.write(NL);         
        RuntimeTagElement _jettag_c_if_182_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_182_3); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_182_3.setRuntimeParent(null);
        _jettag_c_if_182_3.setTagInfo(_td_c_if_182_3);
        _jettag_c_if_182_3.doStart(context, out);
        while (_jettag_c_if_182_3.okToProcessBody()) {
            out.write("\t\t<dependency>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t<groupId>org.hibernate</groupId>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t<artifactId>hibernate-search</artifactId>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t<version>3.3.0.Final</version>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t<exclusions>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t<groupId>org.hibernate</groupId>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t<artifactId>hibernate-core</artifactId>\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t<groupId>org.hibernate</groupId>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t<artifactId>hibernate-commons-annotations</artifactId>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t<groupId>org.hibernate.javax.persistence</groupId>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t<artifactId>hibernate-jpa-2.0-api</artifactId>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t<groupId>org.slf4j</groupId>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t<artifactId>slf4j-api</artifactId>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t<groupId>jgroups</groupId>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t<artifactId>jgroups</artifactId>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t</exclusions>");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t</dependency>");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_c_if_182_3.handleBodyContent(out);
        }
        _jettag_c_if_182_3.doEnd();
        out.write("\t\t<!-- hibernate ehcache -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!--<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>org.hibernate</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>hibernate-ehcache</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>3.5.5-Final</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<exclusions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>org.hibernate</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>hibernate-core</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</exclusions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency> -->\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!-- this is fro deployment issues with seam and gwt class conflict -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>javax.faces</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>jsf-api</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>1.2_15</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<modules>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<module>../");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 231, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-jpa</module>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<module>../");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 232, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-dao</module>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<module>../");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 233, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-ejb</module>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<module>../");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 234, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-webapp</module>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<module>../");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 235, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-jrs</module>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<module>../");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 236, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-app</module>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</modules>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<plugins>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>org.apache.maven.plugins");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>maven-compiler-plugin");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<version>2.3.2</version>\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<source>1.6</source>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<target>1.6</target>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        \t\t<groupId>org.codehaus.mojo</groupId>\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t                <artifactId>taglist-maven-plugin</artifactId>\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t               \t<version>2.4</version>\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t            </plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</plugins>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<profiles>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t   <profile>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t      <id>server-tests</id>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t      <dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t         <dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t            <groupId>org.jboss.arquillian.container</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t            <artifactId>arquillian-jbossas-remote-6</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t            <version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${arquillian.version}'}", 265, 23)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t         </dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t        <dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t            <groupId>org.jboss.jbossas</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t            <artifactId>jboss-as-client</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t            <version>6.0.0.20100721-M4</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t            <type>pom</type>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t        </dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t      </dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t   </profile>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</profiles>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!-- download artifacts from this repo -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<repositories>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<repository>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<id>yalamanchili.info</id>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<name>yalamanchili.info</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<url>http://yalamanchili.info:8080/nexus/content/groups/public</url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<releases>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<enabled>true</enabled>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</releases>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<snapshots>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<enabled>true</enabled>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</snapshots>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</repository>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</repositories>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!-- download plugins from this repo -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<pluginRepositories>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<pluginRepository>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<id>yalamanchili.info</id>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<name>yalamanchili.info</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<url>http://yalamanchili.info:8080/nexus/content/groups/public</url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<releases>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<enabled>true</enabled>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</releases>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<snapshots>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<enabled>true</enabled>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</snapshots>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</pluginRepository>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</pluginRepositories>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<distributionManagement>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!-- Publish the versioned releases here -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<repository>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<id>yalamanchili.info</id>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<name>yalamanchili.info</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<url>http://yalamanchili.info:8080/nexus/content/repositories/releases</url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</repository>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t\t<!-- Publish the versioned releases here -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<snapshotRepository>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<id>yalamanchili.info</id>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<name>yalamanchili.info</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<url>http://yalamanchili.info:8080/nexus/content/repositories/snapshots</url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</snapshotRepository>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</distributionManagement>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<properties>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 320, 4)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$version}", 320, 28)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 320, 41)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<yalamanchili.version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$yalamanchili-version}", 321, 25)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</yalamanchili.version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<arquillian.version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$arquillian-version}", 322, 23)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</arquillian.version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<gwt.version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$gwt-version}", 323, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</gwt.version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</properties>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</project>");  //$NON-NLS-1$        
    }
}
