package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_ejb_jarxml_0 implements JET2Template {

    public _jet_ejb_jarxml_0() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<ejb-jar xmlns=\"http://java.sun.com/xml/ns/javaee\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\txsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                            http://java.sun.com/xml/ns/javaee/ejb-jar_3_0.xsd\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tversion=\"3.0\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<assembly-descriptor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<interceptor-binding>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<ejb-name>*</ejb-name>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<interceptor-class>org.jboss.seam.ejb.SeamInterceptor");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</interceptor-class>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t</interceptor-binding>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t</assembly-descriptor>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</ejb-jar>");  //$NON-NLS-1$        
    }
}
