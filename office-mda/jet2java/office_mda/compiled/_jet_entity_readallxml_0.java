package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_entity_readallxml_0 implements JET2Template {

    public _jet_entity_readallxml_0() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  android:orientation=\"vertical\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  android:layout_width=\"fill_parent\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  android:layout_height=\"fill_parent\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  <info.yalamanchili.android.widgets.ReadAllPageBar");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t        android:id=\"@+id/read_all_page_bar\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t        android:layout_width=\"wrap_content\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t        android:layout_height=\"wrap_content\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t        />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  <ListView  ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:id=\"@+id/readall_listview\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:layout_width=\"fill_parent\" ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:layout_height=\"wrap_content\" ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("  />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</LinearLayout>");  //$NON-NLS-1$        
    }
}
