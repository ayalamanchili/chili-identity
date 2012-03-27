package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_web_html_templatehtml implements JET2Template {

    public _jet_web_html_templatehtml() {
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
        out.write("\t\t<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<title>");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 6, 11)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("</title>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<script type=\"text/javascript\" language=\"javascript\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\tsrc=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 8, 10)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 8, 22)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 8, 38)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 8, 50)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".nocache.js\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t\t\t</script>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</head>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<body>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t <iframe src=\"javascript:''\" id=\"__gwt_historyFrame\" tabIndex='-1' style=\"position:absolute;width:0;height:0;border:0\"></iframe>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</body>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t</html>");  //$NON-NLS-1$        
    }
}
