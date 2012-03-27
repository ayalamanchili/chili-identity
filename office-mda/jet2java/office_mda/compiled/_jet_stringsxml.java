package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_stringsxml implements JET2Template {

    public _jet_stringsxml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<resources>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <string name=\"app_name\">");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 3, 29)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</string>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("     <string name=\"base_url\">http://10.0.2.2/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 4, 46)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-soa-");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$version}", 4, 66)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/seam/resource/restv1/</string>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("     <string name=\"page_size\">10</string>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</resources>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
