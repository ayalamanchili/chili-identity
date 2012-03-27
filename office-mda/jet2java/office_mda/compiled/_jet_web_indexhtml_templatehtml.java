package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_web_indexhtml_templatehtml implements JET2Template {

    public _jet_web_indexhtml_templatehtml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\"http://www.w3.org/TR/html4/loose.dtd\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<html>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t<head>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t<meta http-equiv=\"REFRESH\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\tcontent=\"0;url=");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 6, 19)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 6, 31)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 6, 47)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".html\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</head>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</html>");  //$NON-NLS-1$        
    }
}
