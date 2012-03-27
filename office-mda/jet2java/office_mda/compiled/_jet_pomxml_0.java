package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_pomxml_0 implements JET2Template {

    public _jet_pomxml_0() {
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
        out.write("-dao</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<packaging>jar</packaging>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<name>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 13, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-dao</name>");  //$NON-NLS-1$        
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
        out.write("\t</dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<plugins>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</plugins>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</project>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
