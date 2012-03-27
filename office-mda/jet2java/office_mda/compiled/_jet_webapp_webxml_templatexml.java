package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_webapp_webxml_templatexml implements JET2Template {

    public _jet_webapp_webxml_templatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<web-app version=\"3.0\" xmlns=\"http://java.sun.com/xml/ns/javaee\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!-- Seam -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t<filter>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<filter-name>Seam Filter</filter-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<filter-class>org.jboss.seam.servlet.SeamFilter</filter-class>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</filter>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t<filter-mapping>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<filter-name>Seam Filter</filter-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<url-pattern>*</url-pattern>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</filter-mapping>\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t<listener>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<listener-class>org.jboss.seam.servlet.SeamListener</listener-class>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</listener>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t<servlet>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<servlet-name>Seam Resource Servlet</servlet-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<servlet-class>org.jboss.seam.servlet.SeamResourceServlet</servlet-class>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</servlet>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t<servlet-mapping>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<servlet-name>Seam Resource Servlet</servlet-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<!-- ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<url-pattern>/seam/resource/*</url-pattern>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<url-pattern>/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 32, 17)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 32, 29)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/seam/resource/*</url-pattern>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t</servlet-mapping>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!-- Image/File Upload support y-commons -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<servlet>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<servlet-name>ImageUploadServlet</servlet-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<servlet-class>info.yalamanchili.commons.FileUploadServlet</servlet-class>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</servlet>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<servlet-mapping>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<servlet-name>ImageUploadServlet</servlet-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<url-pattern>/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 43, 17)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 43, 29)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/imageupload</url-pattern>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</servlet-mapping>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(" <!-- GWT request Factory -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t <servlet>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<servlet-name>requestFactoryServlet</servlet-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<servlet-class>info.yalamanchili.requestfactory.SeamRequestFactoryServlet</servlet-class>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" \t\t<init-param>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<param-name>symbolMapsDirectory</param-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<!-- You'll need to compile with -extras and move the symbolMaps directory ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\tto this location if you want stack trace deobfuscation to work -->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<param-value>WEB-INF/classes/symbolMaps/</param-value>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</init-param>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</servlet>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<servlet-mapping>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<servlet-name>requestFactoryServlet</servlet-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<url-pattern>/gwtRequest</url-pattern>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</servlet-mapping>    ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<!--  for rest easy-->");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <servlet-mapping>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("       <servlet-name>Seam Resource Servlet</servlet-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("       <url-pattern>/seam/resource/*</url-pattern>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    </servlet-mapping>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    \t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<context-param>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<param-name>org.jboss.seam.core.init.jndiPattern</param-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<param-value>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 70, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-app-");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$version}", 70, 36)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/#{ejbName}/local</param-value>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</context-param>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t<welcome-file-list>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<welcome-file> index.html </welcome-file>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</welcome-file-list>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</web-app>");  //$NON-NLS-1$        
    }
}
