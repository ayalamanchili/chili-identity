package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_list_itemxml_0 implements JET2Template {

    public _jet_list_itemxml_0() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<RelativeLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  android:layout_width=\"fill_parent\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  android:layout_height=\"fill_parent\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  <TextView");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:id=\"@+id/list_item_view\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:layout_height=\"fill_parent\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:padding=\"10dp\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:scrollbars=\"vertical\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:fadingEdge=\"vertical\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:layout_alignParentRight=\"true\"/>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</RelativeLayout>");  //$NON-NLS-1$        
    }
}
