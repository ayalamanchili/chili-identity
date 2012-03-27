package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_app_title_barxml implements JET2Template {

    public _jet_app_title_barxml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<TextView");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  xmlns:android=\"http://schemas.android.com/apk/res/android\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  android:id=\"@+id/");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 4, 20)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("_title_text\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  android:text=\"This is my new title\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  android:layout_width=\"fill_parent\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  android:layout_height=\"fill_parent\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("   />");  //$NON-NLS-1$        
    }
}
