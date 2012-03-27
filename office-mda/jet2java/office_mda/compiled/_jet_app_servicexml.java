package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_app_servicexml implements JET2Template {

    public _jet_app_servicexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<mbean code=\"org.jboss.varia.property.SystemPropertiesService\" name=\"jboss.util:type=Service,name=");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 1, 99)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  <attribute name=\"Properties\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    file.target.directory=/Users/yphanikumar/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 3, 46)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/pictures.war/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  </attribute>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</mbean>");  //$NON-NLS-1$        
    }
}
