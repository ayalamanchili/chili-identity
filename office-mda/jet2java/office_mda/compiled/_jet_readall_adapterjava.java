package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_readall_adapterjava implements JET2Template {
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_readall_adapterjava() {
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
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 5, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.R;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 6, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".entity.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 6, 27)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 6, 57)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.List;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.content.Context;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.LayoutInflater;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.ViewGroup;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.ArrayAdapter;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.LinearLayout;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.TextView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("public class ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 16, 14)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter extends ArrayAdapter<");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 16, 58)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("> {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tint listItemTextView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 19, 9)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter(Context context, int textViewResourceId, List<");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 19, 78)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("> objects) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsuper(context, textViewResourceId, objects);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tlistItemTextView = textViewResourceId;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic View getView(int position, View convertView, ViewGroup parent) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tLinearLayout todoView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 27, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 27, 19)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" = getItem(position);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (convertView == null) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\ttodoView = new LinearLayout(getContext());");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tString inflater = Context.LAYOUT_INFLATER_SERVICE;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tLayoutInflater vi = (LayoutInflater) getContext().getSystemService(");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\tinflater);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tvi.inflate(listItemTextView, todoView, true);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t} else {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\ttodoView = (LinearLayout) convertView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tTextView textViewOne = (TextView) todoView.findViewById(R.id.readall_list_item_one);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tTextView textViewTwo = (TextView) todoView.findViewById(R.id.readall_list_item_two);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\ttextViewOne.setText(");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 39, 23)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".toString());");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn todoView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
