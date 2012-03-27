package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_jpa_gwtxmltemplatexml implements JET2Template {

    public _jet_jpa_gwtxmltemplatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<module>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<inherits name=\"com.google.gwt.user.User\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<source path='entity' />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("</module>");  //$NON-NLS-1$        
    }
}
