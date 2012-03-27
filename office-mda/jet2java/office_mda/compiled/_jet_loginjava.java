package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;

public class _jet_loginjava implements JET2Template {

    public _jet_loginjava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("package ");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$groupID}", 1, 9)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".android;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("import info.yalamanchili.android.views.EditTextField;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import android.app.Activity;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import android.content.Intent;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import android.os.Bundle;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import android.util.Log;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import android.view.View;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import android.view.View.OnClickListener;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("import android.widget.Button;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("public class Login extends Activity implements OnClickListener {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\tEditTextField username;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tEditTextField password;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tButton login;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t@Override");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tpublic void onCreate(Bundle savedInstanceState) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tsuper.onCreate(savedInstanceState);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tsetContentView(R.layout.login);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tassignFields();");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\t}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\tpublic void onClick(View arg0) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tIntent intent = new Intent(Login.this, ");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 27, 42)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("Main.class);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tstartActivity(intent);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\treturn;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t//Log.d(\"debug\", username.getValue());");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t//HttpHelper.setCredentials(username.getValue(), password.getValue());");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t//new AsyncHttp(this) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t//@Override");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t//protected void onResponse(String result) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t//Intent intent = new Intent(Login.this, ");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 35, 46)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(".class);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t\t//startActivity(intent);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t//}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t//}.execute(HttpHelper.manageURL + \"login\" + \"/\" + username.getValue()");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\t\t//\t+ \"/\" + password.getValue());");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("\tprotected void assignFields() {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tusername = (EditTextField) findViewById(R.id.login_username);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tusername.setLabel(\"Username:\");");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tpassword = (EditTextField) findViewById(R.id.login_password);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tpassword.setLabel(\"Password:\");");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tlogin = (Button) findViewById(R.id.login_login);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t\tlogin.setOnClickListener(this);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
