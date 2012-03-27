package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_envproperties implements JET2Template {

    public _jet_envproperties() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("selinium-host=192.168.2.9");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("selinium-port=4444");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("browser=*firefox");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("app-base-url=http://localhost:8080/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("app-root-page=");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 5, 15)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("-webapp/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 5, 38)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 5, 50)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 5, 66)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".html");  //$NON-NLS-1$        
    }
}
