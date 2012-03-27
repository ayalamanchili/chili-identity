package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_pomxml_1 implements JET2Template {

    public _jet_pomxml_1() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

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
        out.write("    <groupId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 5, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 6, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-android</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<packaging>apk</packaging>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$version}", 8, 11)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<name>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 9, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-android</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t<dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>com.google.android</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>android</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>2.2.1</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>info.yalamanchili.android</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>yalamanchili-android</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 21, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<type>apklib</type>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t<build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<plugins>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>com.jayway.maven.plugins.android.generation2</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>maven-android-plugin</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<version>2.9.0-beta-5</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<androidManifestFile>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${project.basedir}'}", 33, 27)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/AndroidManifest.xml</androidManifestFile>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<assetsDirectory>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${project.basedir}'}", 34, 23)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/assets</assetsDirectory>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<resourceDirectory>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${project.basedir}'}", 35, 25)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/res</resourceDirectory>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<nativeLibrariesDirectory>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${project.basedir}'}", 36, 32)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/src/main/native</nativeLibrariesDirectory>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<sdk>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<platform>8</platform>");  //$NON-NLS-1$        
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
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>maven-compiler-plugin</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<version>2.3.2</version>");  //$NON-NLS-1$        
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
        out.write(context.embeddedExpressionAsString("${$yalamanchili-version}", 100, 25)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</yalamanchili.version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</properties>\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</project>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
