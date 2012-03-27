package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_webapp_pom_templatexml implements JET2Template {

    public _jet_webapp_pom_templatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<modelVersion>4.0.0</modelVersion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 4, 11)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 5, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-webapp</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<packaging>war</packaging>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$version}", 7, 11)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<name>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 8, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-webapp</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<url>http://maven.apache.org</url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 12, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 13, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-ejb</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${'}", 14, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${'project.version}'}", 14, 20)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 18, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 19, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-jpa</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${'}", 20, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${'project.version}'}", 20, 20)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 24, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 25, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-dao</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${'}", 26, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${'project.version}'}", 26, 20)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>com.google.gwt</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>gwt-dev</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${gwt.version}'}", 32, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
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
        out.write(context.embeddedExpressionAsString("${'${gwt.version}'}", 38, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>com.google.gwt</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>gwt-user</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${gwt.version}'}", 44, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
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
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 50, 13)); //$NON-NLS-1$ //$NON-NLS-2$
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
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 57, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!-- GWT request factory -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>com.google.web.bindery</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>requestfactory-server</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>2.4.0</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!-- needed for gwt hosted mode START -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!--<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>org.hibernate</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>hibernate-validator</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>3.1.0.GA</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>org.jboss.el</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>jboss-el</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>1.0_02.CR5</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>javassist</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>javassist</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>3.11.0.GA</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>-->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!-- needed for gwt hosted mode END -->\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<outputDirectory>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${project.build.directory}/${project.build.finalName}'}", 86, 19)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/WEB-INF/classes</outputDirectory>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<defaultGoal>package</defaultGoal>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<plugins>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>org.apache.maven.plugins</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>maven-war-plugin</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<version>2.0</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>org.apache.maven.plugins</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>maven-compiler-plugin</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<version>2.3.2</version>");  //$NON-NLS-1$        
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
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>org.codehaus.mojo</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>gwt-maven-plugin");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${gwt.plugin.version}'}", 107, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<logLevel>INFO</logLevel>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<compileTargets>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<value> ");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 113, 15)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 113, 27)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</value>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</compileTargets>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<runTarget>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 116, 7)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".html");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</runTarget>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<style>DETAILED</style>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<noServer>false</noServer>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<!-- use only for dev-->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<draftCompile>true</draftCompile>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<soyc>false</soyc>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<extraJvmArgs>-Xmx512m</extraJvmArgs>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<!-- target dir for generated interfaces-->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<generateDirectory>src/main/java</generateDirectory>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<i18nConstantsWithLookupBundle>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 127, 7)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".client.internalization.");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 127, 42)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Constants");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</i18nConstantsWithLookupBundle>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<i18nMessagesBundle>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 130, 7)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".client.internalization.");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 130, 42)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Messages");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</i18nMessagesBundle>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<gwtVersion>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${gwtVersion}'}", 132, 18)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</gwtVersion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<!--<goal>mergewebxml</goal> -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<goal>i18n</goal>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<goal>compile</goal>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<!--\t\t<goal>test</goal> -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>org.bsc.maven</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>maven-processor-plugin</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<version>2.0.5</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<id>process</id>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<goal>process</goal>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<phase>generate-sources</phase>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<groupId>com.google.web.bindery</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<artifactId>requestfactory-apt</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${gwt.version}'}", 162, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</plugin>\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</plugins>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</build>");  //$NON-NLS-1$        
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
        out.write("\t</distributionManagement>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<properties>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<yalamanchili.version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$yalamanchili-version}", 212, 25)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</yalamanchili.version>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<gwt.version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$gwt-version}", 213, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</gwt.version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<gwt.plugin.version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$gwt-plugin-version}", 214, 23)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</gwt.plugin.version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</properties>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</project>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
