package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_android_manifestxml implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_android_manifestxml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_iterate_16_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            16, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_17_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            17, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("<manifest xmlns:android=\"http://schemas.android.com/apk/res/android\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    package=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 3, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:versionCode=\"1\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    android:versionName=\"1.0-SNAPSHOT\" >");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("    <application android:label=\"@string/app_name\" >");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        <activity android:name=\"info.yalamanchili.android.views.DateWidget\" >");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        </activity>    ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        <activity android:name=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 10, 33)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".android.");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 10, 53)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Welcome\" >");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            <intent-filter >");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                <action android:name=\"android.intent.action.MAIN\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                <category android:name=\"android.intent.category.LAUNCHER\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            </intent-filter>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        </activity>");  //$NON-NLS-1$        
        out.write(NL);         
        RuntimeTagElement _jettag_c_iterate_16_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_16_9); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_16_9.setRuntimeParent(null);
        _jettag_c_iterate_16_9.setTagInfo(_td_c_iterate_16_9);
        _jettag_c_iterate_16_9.doStart(context, out);
        while (_jettag_c_iterate_16_9.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_17_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_17_7); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_17_7.setRuntimeParent(_jettag_c_iterate_16_9);
            _jettag_c_iterate_17_7.setTagInfo(_td_c_iterate_17_7);
            _jettag_c_iterate_17_7.doStart(context, out);
            while (_jettag_c_iterate_17_7.okToProcessBody()) {
                out.write("    \t\t <activity android:name=\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 18, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".android.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 18, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 18, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 18, 105)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("s\"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("                  android:label=\"@string/app_name\">");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("              </activity>     ");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("    \t\t <activity android:name=\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 21, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".android.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 21, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 21, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".Create");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 21, 104)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("                  android:label=\"@string/app_name\">                  ");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("      \t\t </activity>");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("    \t\t <activity android:name=\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 24, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".android.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 24, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 24, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 24, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("                  android:label=\"@string/app_name\">                  ");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("      \t\t </activity>  ");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("    \t\t <activity android:name=\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 27, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".android.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 27, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 27, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".Update");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 27, 104)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("                  android:label=\"@string/app_name\">                  ");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("      \t\t </activity>       \t\t     \t\t ");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_c_iterate_17_7.handleBodyContent(out);
            }
            _jettag_c_iterate_17_7.doEnd();
            _jettag_c_iterate_16_9.handleBodyContent(out);
        }
        _jettag_c_iterate_16_9.doEnd();
        out.write("    </application>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <uses-permission android:name=\"android.permission.INTERNET\" >");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    </uses-permission>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("</manifest>");  //$NON-NLS-1$        
    }
}
