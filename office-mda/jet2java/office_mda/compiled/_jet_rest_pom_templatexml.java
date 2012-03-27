package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_rest_pom_templatexml implements JET2Template {

    public _jet_rest_pom_templatexml() {
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
        out.write("\t\t<groupId>info.yalamanchili.office</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<artifactId>office-master</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<version>1.0-SNAPSHOT</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<relativePath>../office-master/pom.xml</relativePath>");  //$NON-NLS-1$        
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
        out.write("-jrs</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<packaging>jar</packaging>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$version}", 13, 11)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<name>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 14, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-jrs</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<url>http://maven.apache.org</url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<dependencies>");  //$NON-NLS-1$        
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
        out.write("\t\t</dependency>\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>info.yalamanchili.security</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>yalamanchili-security</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 30, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
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
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 36, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>yalamanchili</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>y-common-deps</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 41, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<type>pom</type>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</dependencies>");  //$NON-NLS-1$        
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
        out.write("\t\t\t\t<groupId>org.codehaus.mojo</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>jboss-maven-plugin</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<version>1.4</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<jbossHome>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${JBOSS_HOME}'}", 69, 17)); //$NON-NLS-1$ //$NON-NLS-2$
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
        out.write(context.embeddedExpressionAsString("${$yalamanchili-version}", 121, 25)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</yalamanchili.version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</properties>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</project>");  //$NON-NLS-1$        
    }
}
