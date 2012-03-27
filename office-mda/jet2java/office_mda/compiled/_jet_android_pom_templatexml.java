package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_android_pom_templatexml implements JET2Template {

    public _jet_android_pom_templatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <modelVersion>4.0.0</modelVersion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 4, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 5, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-android</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<packaging>apk</packaging>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'{'}", 7, 11)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${$projectName}", 7, 17)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${'.version}'}", 7, 32)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<name>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 8, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-android</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("    <dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        <dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            <groupId>android</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            <artifactId>android</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("           <version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$android-version}", 14, 21)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            <scope>provided</scope>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        </dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        <dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>yalamanchili</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>y-common-deps</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 20, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<type>pom</type>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        <dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>org.codehaus</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>xpp3_min");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$xstream-version}", 28, 12)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>org.codehaus</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>xstream");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$xstream-version}", 34, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>info.yalamanchili.android</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>yalamanchili-android");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 40, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 43, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 44, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-jpa</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'{'}", 45, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${$projectName}", 45, 19)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${'.version}'}", 45, 34)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<exclusions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>info.yalamanchili.gwt</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>yalamanchili-gwt</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>com.google.gwt</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>gwt-servlet</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>com.google.gwt</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>gwt-user</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>org.jboss.seam</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>jboss-seam-remoting</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>org.jboss.seam</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>jboss-seam</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>info.yalamanchili.gwt</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>yalamanchili-gwt</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>info.yalamanchili.commons</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>yalamanchili-commons</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>com.smartgwt</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>smartgwt:jar</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>net.sf.gilead</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>gilead-hibernate</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>net.sf.gilead</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>gilead4gwt</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>net.sf.beanlib</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>beanlib</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>net.sf.beanlib</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>beanlib-hibernate</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>net.sf.cglib</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>cglib-nodep</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>org.apache.commons</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>commons-fileupload</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>org.apache.commons</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>commons-io</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>org.apache.lucene</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>lucene-core</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<groupId>org.hibernate</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<artifactId>hibernate-search</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</exclusion>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</exclusions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    </dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("    <build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        <sourceDirectory>src</sourceDirectory>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        <plugins>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>com.jayway.maven.plugins.android.generation2</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>maven-android-plugin</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<version>2.8.4</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<sdk>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<path>/Users/yphanikumar/android-sdk-mac_86</path>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<platform>2.1</platform>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</sdk>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<deleteConflictingFiles>true</deleteConflictingFiles>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<undeployBeforeDeploy>true</undeployBeforeDeploy>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<extensions>true</extensions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>maven-compiler-plugin</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<source>1.5</source>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<target>1.5</target>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        </plugins>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    </build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <repositories>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<repository>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<id>yalamanchili</id>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<url> http://yalamanchili.googlecode.com/svn/maven2  </url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</repository>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<repository>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<id>jboss</id>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\thttp://repository.jboss.com/maven2/ </url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</repository>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</repositories>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<properties>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 157, 4)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$version}", 157, 28)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 157, 41)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<yalamanchili.version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$yalamanchili-version}", 158, 25)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</yalamanchili.version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</properties>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</project>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
