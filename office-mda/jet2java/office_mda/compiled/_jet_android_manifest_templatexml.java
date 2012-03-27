package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_android_manifest_templatexml implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_android_manifest_templatexml() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_iterate_17_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            17, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_18_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            18, 7,
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
        out.write("      package=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 3, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".android\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      android:versionCode=\"1\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      android:versionName=\"1.0\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <application android:label=\"@string/app_name\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        <activity android:name=\".Login\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                  android:label=\"@string/app_name\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            <intent-filter>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                <action android:name=\"android.intent.action.MAIN\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                <category android:name=\"android.intent.category.LAUNCHER\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("            </intent-filter>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        </activity>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t<activity android:name=\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 14, 28)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".android.AutomanageMain\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("                  android:label=\"@string/app_name\">");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("      \t\t </activity>        ");  //$NON-NLS-1$        
        out.write(NL);         
        RuntimeTagElement _jettag_c_iterate_17_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_17_9); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_17_9.setRuntimeParent(null);
        _jettag_c_iterate_17_9.setTagInfo(_td_c_iterate_17_9);
        _jettag_c_iterate_17_9.doStart(context, out);
        while (_jettag_c_iterate_17_9.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_18_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_18_7); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_18_7.setRuntimeParent(_jettag_c_iterate_17_9);
            _jettag_c_iterate_18_7.setTagInfo(_td_c_iterate_18_7);
            _jettag_c_iterate_18_7.doStart(context, out);
            while (_jettag_c_iterate_18_7.okToProcessBody()) {
                out.write("    \t\t <activity android:name=\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 19, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".android.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 19, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 19, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 19, 105)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("s\"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("                  android:label=\"@string/app_name\">");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("      \t\t </activity>");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("      \t\t <activity android:name=\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 22, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".android.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 22, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 22, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 22, 104)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("                  android:label=\"@string/app_name\">");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("      \t\t </activity>");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("      \t\t <activity android:name=\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 25, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".android.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 25, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 25, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".Create");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 25, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("                  android:label=\"@string/app_name\">");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("      \t\t </activity>");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("      \t\t <activity android:name=\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 28, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".android.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 28, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 28, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".Update");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 28, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("                  android:label=\"@string/app_name\">");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("      \t\t </activity>      \t\t ");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("      \t\t <activity android:name=\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 31, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".android.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 31, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 31, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".Search");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 31, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("                  android:label=\"@string/app_name\">");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("      \t\t </activity>");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_c_iterate_18_7.handleBodyContent(out);
            }
            _jettag_c_iterate_18_7.doEnd();
            _jettag_c_iterate_17_9.handleBodyContent(out);
        }
        _jettag_c_iterate_17_9.doEnd();
        out.write(NL);         
        out.write("    </application>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <uses-permission android:name=\"android.permission.INTERNET\"></uses-permission>");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    <uses-sdk android:minSdkVersion=\"6\" />");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("</manifest>");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
