package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_test_pomxml implements JET2Template {

    public _jet_test_pomxml() {
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
        out.write("-test</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'{'}", 6, 11)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${$projectName}", 6, 17)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${'.version}'}", 6, 32)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<packaging>jar</packaging>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<name>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 8, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-test</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<url>http://maven.apache.org</url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>info.yalamanchili.project</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 13, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-jpa</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'{'}", 14, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${$projectName}", 14, 19)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(context.embeddedExpressionAsString("${'.version}'}", 14, 34)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>info.yalamanchili</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>y-common-deps");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 20, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>info.yalamanchili.qa</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>yalamanchili-qa</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 25, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>test</scope>");  //$NON-NLS-1$        
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
        out.write("\t\t\t\t<groupId>org.apache.maven.plugins");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>maven-compiler-plugin");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</artifactId>");  //$NON-NLS-1$        
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
        out.write("\t\t\t<!-- not needed if using webdriver");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>org.codehaus.mojo</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>selenium-maven-plugin</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<phase>pre-integration-test</phase>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<goal>start-server</goal>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<background>true</background>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<port>4444</port>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<plugin>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<groupId>org.apache.maven.plugins</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<artifactId>maven-surefire-plugin</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<skip>true</skip>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t\t\t\t<executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t<execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<phase>integration-test</phase>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<goal>test</goal>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</goals>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t<configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t\t<skip>false</skip>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t\t</configuration>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t\t</execution>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t</executions>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</plugin> -->");  //$NON-NLS-1$        
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
        out.write("\t\t<");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 123, 4)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$version}", 123, 28)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 123, 41)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<yalamanchili.version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$yalamanchili-version}", 124, 25)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</yalamanchili.version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</properties>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</project>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
