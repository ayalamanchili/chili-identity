package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_app_pom_templatexml implements JET2Template {

    public _jet_app_pom_templatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<parent>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 4, 12)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 5, 15)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-master</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$version}", 6, 12)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<relativePath>../");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 7, 20)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-master/pom.xml</relativePath>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</parent>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<modelVersion>4.0.0</modelVersion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 10, 11)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 11, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-app</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<packaging>ear</packaging>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<name>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 13, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-app</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<url>http://maven.apache.org</url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 17, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 18, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-jpa</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${'}", 19, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${'project.version}'}", 19, 20)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<type>ejb</type>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 23, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 24, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-dao</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${'}", 25, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${'project.version}'}", 25, 20)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<type>ejb</type>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 29, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 30, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-webapp</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${'}", 31, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${'project.version}'}", 31, 20)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<type>war</type>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 35, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 36, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-jrs</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${'}", 37, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${'project.version}'}", 37, 20)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<type>ejb</type>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 41, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 42, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-ejb</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${'}", 43, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${'project.version}'}", 43, 20)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<type>ejb</type>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<plugins>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>org.apache.maven.plugins</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>maven-ear-plugin</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$ear-plugin-version}", 52, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<unpackTypes>war,ejb</unpackTypes>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<defaultLibBundleDir>lib</defaultLibBundleDir>\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<modules>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<webModule>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 58, 17)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 60, 20)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-webapp</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<contextRoot>/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 61, 22)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-webapp</contextRoot>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</webModule>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</modules>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>org.codehaus.mojo</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>jboss-maven-plugin</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$jboss-maven-plugin-version}", 69, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<jbossHome>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${JBOSS_HOME}'}", 71, 17)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</jbossHome>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<port>8080</port>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<server>default</server>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<unpack>true</unpack>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>org.apache.maven.plugins</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>maven-antrun-plugin</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<phase>install</phase>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<tasks>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t\t<delete");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t\t\tfile=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${jboss.home}'}", 86, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/server/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${jboss.configuration}'}", 86, 42)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/deploy/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${project.artifactId}'}", 86, 77)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${project.version}'}", 86, 104)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".ear\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t\t<copy");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t\t\tfile=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${project.build.directory}'}", 88, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${project.artifactId}'}", 88, 48)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${project.version}'}", 88, 75)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".ear\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t\t\ttodir=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${jboss.home}'}", 89, 17)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/server/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${jboss.configuration}'}", 89, 43)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/deploy\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t</tasks>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<goal>run</goal>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</plugin>\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</plugins>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<properties>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<jboss.home>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${env.JBOSS_HOME}'}", 101, 15)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</jboss.home>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<jboss.configuration>default</jboss.configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</properties>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</project>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
