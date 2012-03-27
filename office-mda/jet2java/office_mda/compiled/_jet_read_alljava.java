package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_read_alljava implements JET2Template {
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_read_alljava() {
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
            out.write("import info.yalamanchili.android.http.AsyncHttpGet;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import java.util.ArrayList;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.List;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import org.json.JSONException;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.json.JSONObject;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.json.JSONArray;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import android.content.Intent;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.app.Activity;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.content.Context;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.os.Bundle;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.util.Log;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.LayoutInflater;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View.OnClickListener;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.ViewGroup;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.Window;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.AdapterView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.AdapterView.OnItemClickListener;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.ArrayAdapter;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.LinearLayout;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.ListView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.TextView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 28, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".R;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.Button;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 30, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 30, 28)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Welcome;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.widgets.ReadAllPageBar;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("public class ReadAll");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 33, 21)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s extends Activity implements OnItemClickListener,OnClickListener{");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate Integer pageOffSet = 0;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate ArrayList<JSONObject> ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 35, 32)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s = new ArrayList<JSONObject>();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate ListView ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 36, 19)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("ListView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate Button create;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate Button nextPage;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate Button previousPage;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 40, 10)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 40, 33)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t//TODO move common logic to generic class ReadAllEntity");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onCreate(Bundle savedInstanceState) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsuper.onCreate(savedInstanceState);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\trequestWindowFeature(Window.FEATURE_CUSTOM_TITLE);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsetContentView(R.layout.entity_readall);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcustomizeTitle();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tgetControls();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsetListeners();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tint resID = R.layout.readall_list;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 52, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter = new  ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 52, 45)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter(ReadAll");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 52, 75)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s.this, resID,");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 53, 5)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 54, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("ListView.setAdapter(");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 54, 50)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic void setListeners() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcreate.setOnClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tnextPage.setOnClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tpreviousPage.setOnClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 61, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("ListView.setOnItemClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void getControls() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tReadAllPageBar pageBar=\t(ReadAllPageBar)findViewById(R.id.read_all_page_bar);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcreate=pageBar.getCreateButton();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tnextPage=pageBar.getNextPageButton();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tpreviousPage=pageBar.getPreviousPageButton();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 69, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("ListView = (ListView) findViewById(R.id.readall_listview);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic void customizeTitle(){");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tgetWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 73, 67)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_title_bar);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t     TextView mytitletext = (TextView) findViewById(R.id.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 74, 59)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_title_text);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t     mytitletext.setText(\"Read All ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 75, 37)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s Panel\");\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onItemClick(AdapterView<?> parent, View arg1, int position,");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tlong id) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tJSONObject ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 80, 14)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" = (JSONObject) parent.getItemAtPosition(position);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tIntent intent = new Intent(this, Read");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 81, 40)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".class);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\ttry {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tintent.putExtra(\"id\", ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 83, 26)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".getLong(\"id\"));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t} catch (JSONException e) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t//TODO");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\te.printStackTrace();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}\t\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tstartActivity(intent);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic String getReadALLURL(Integer pageOffSet, Integer pageSize) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 91, 10)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Welcome.baseURL + \"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 91, 55)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("/readall/0/10\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected void loadNextPage() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tpageOffSet = pageOffSet + new Integer(getString(R.string.page_size));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tloadPage(pageOffSet, new Integer(getString(R.string.page_size)));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tprotected void loadPreviousPage() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (pageOffSet >= new Integer(getString(R.string.page_size))) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tpageOffSet = pageOffSet");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t- new Integer(getString(R.string.page_size));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tloadPage(pageOffSet, new Integer(getString(R.string.page_size)));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected void loadPage(int pageOffSet, int pageSize) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tnew AsyncHttpGet(this) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tprotected void onResponse(String result) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\ttry {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\tJSONArray ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 112, 16)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s = new JSONArray(result);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\tint i = 0;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\twhile (!");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 114, 14)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s.isNull(i)) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\tJSONObject ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 115, 18)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" = (JSONObject) ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 115, 61)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("s");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\t\t\t.getJSONObject(i).get(\"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 116, 32)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 117, 7)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter.add(");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 117, 46)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\ti++;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t} catch (Exception e) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t// TODO navigate back notify user?");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\tthrow new RuntimeException(e);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}.execute(getReadALLURL(pageOffSet, pageSize));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onStart() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsuper.onStart();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tLog.d(\"info.yalamacnhili.android\", \"in start\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tmain();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic void main() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 136, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter.clear();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tloadPage(0, new Integer(getString(R.string.page_size)));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onClick(View arg0) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("//TODO support add ....\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (arg0.getId() == create.getId()) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tIntent createIntent = new Intent(this, Create");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 144, 48)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".class);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tstartActivity(createIntent);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (arg0.getId() == nextPage.getId()) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tloadNextPage();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (arg0.getId() == previousPage.getId()) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tloadPreviousPage();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic class ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 155, 15)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter extends ArrayAdapter<JSONObject> {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tint listItemTextView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t\tpublic ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 158, 10)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Adapter(Context context, int textViewResourceId,");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tList<JSONObject> objects) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tsuper(context, textViewResourceId, objects);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tlistItemTextView = textViewResourceId;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tpublic View getView(int position, View convertView, ViewGroup parent) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tLinearLayout todoView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tJSONObject engine = getItem(position);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tif (convertView == null) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\ttodoView = new LinearLayout(getContext());");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tString inflater = Context.LAYOUT_INFLATER_SERVICE;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tLayoutInflater vi = (LayoutInflater) getContext()");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\t.getSystemService(inflater);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tvi.inflate(listItemTextView, todoView, true);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t} else {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\ttodoView = (LinearLayout) convertView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tTextView textViewOne = (TextView) todoView");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t.findViewById(R.id.readall_list_item_one);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\ttextViewOne.setText(engine.toString());");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\treturn todoView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
