package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_pomxml implements JET2Template {

    public _jet_pomxml() {
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
        out.write("-types</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$version}", 6, 11)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<name>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 7, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-types</name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<url>http://maven.apache.org</url>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<dependency>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<groupId>yalamanchili</groupId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<artifactId>y-common-deps</artifactId>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${'${yalamanchili.version}'}", 13, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<type>pom</type>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<scope>provided</scope>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</dependency>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</dependencies>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</build>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<properties>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<yalamanchili.version>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$yalamanchili-version}", 22, 25)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</yalamanchili.version>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</properties>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</project>");  //$NON-NLS-1$        
    }
}
