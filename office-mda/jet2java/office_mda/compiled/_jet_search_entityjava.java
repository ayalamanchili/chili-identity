package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_search_entityjava implements JET2Template {
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_search_entityjava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_format_1_1 = new TagInfo("java:format", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_java_format_1_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "format", "java:format", _td_java_format_1_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_format_1_1.setRuntimeParent(null);
        _jettag_java_format_1_1.setTagInfo(_td_java_format_1_1);
        _jettag_java_format_1_1.doStart(context, out);
        JET2Writer _jettag_java_format_1_1_saved_out = out;
        while (_jettag_java_format_1_1.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(NL);         
            out.write("package ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 2, 9)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$package/@name}", 2, 29)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 2, 47)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 4, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.R;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.app.Activity;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.os.Bundle;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.util.Log;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.Window;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View.OnClickListener;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.Button;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.EditText;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.TextView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.content.Intent;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("public class Search");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 16, 20)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" extends Activity implements OnClickListener {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tEditText searchText;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tButton searchButton;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onCreate(Bundle savedInstanceState) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsuper.onCreate(savedInstanceState);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\trequestWindowFeature(Window.FEATURE_CUSTOM_TITLE);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsetContentView(R.layout.entity_search);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcustomizeTitle();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsearchText = (EditText) findViewById(R.id.search_text);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsearchButton = (Button) findViewById(R.id.search_button);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsearchButton.setOnClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic void onClick(View arg0) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t\tif (arg0 == searchButton) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tIntent intent = new Intent(this, ReadAll");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 34, 44)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s.class);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tintent.putExtra(\"intent\", \"SEARCH\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tString search = (searchText.getText() != null) ? searchText");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t.getText().toString().trim() : \" \";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tintent.putExtra(\"searchText\", search);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tstartActivity(intent);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic void customizeTitle() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tgetWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tR.layout.automanage_title_bar);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tTextView mytitletext = (TextView) findViewById(R.id.automanage_title_text);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tmytitletext.setText(\"Read ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 48, 29)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" Activity\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
