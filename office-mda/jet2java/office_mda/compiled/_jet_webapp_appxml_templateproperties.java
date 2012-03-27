package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_webapp_appxml_templateproperties implements JET2Template {

    public _jet_webapp_appxml_templateproperties() {
        super();
    }

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write(context.embeddedExpressionAsString("${$projectName}", 1, 1)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".persistence.unit=java:/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$projectName}", 1, 40)); //$NON-NLS-1$ //$NON-NLS-2$
    }
}
