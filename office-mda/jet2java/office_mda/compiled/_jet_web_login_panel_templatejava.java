package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_login_panel_templatejava implements JET2Template {
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_login_panel_templatejava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_merge_1_1 = new TagInfo("java:merge", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_java_format_2_1 = new TagInfo("java:format", //$NON-NLS-1$
            2, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_bundle_3_1 = new TagInfo("f:bundle", //$NON-NLS-1$
            3, 1,
            new String[] {
                "basename", //$NON-NLS-1$
            },
            new String[] {
                "templates/resources/messages", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_4_1 = new TagInfo("f:message", //$NON-NLS-1$
            4, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_19_1 = new TagInfo("f:message", //$NON-NLS-1$
            19, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_21_1 = new TagInfo("f:message", //$NON-NLS-1$
            21, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_45_1 = new TagInfo("f:message", //$NON-NLS-1$
            45, 1,
            new String[] {
            },
            new String[] {
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_java_merge_1_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "merge", "java:merge", _td_java_merge_1_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_merge_1_1.setRuntimeParent(null);
        _jettag_java_merge_1_1.setTagInfo(_td_java_merge_1_1);
        _jettag_java_merge_1_1.doStart(context, out);
        _jettag_java_merge_1_1.doEnd();
        out.write(NL);         
        RuntimeTagElement _jettag_java_format_2_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "format", "java:format", _td_java_format_2_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_format_2_1.setRuntimeParent(null);
        _jettag_java_format_2_1.setTagInfo(_td_java_format_2_1);
        _jettag_java_format_2_1.doStart(context, out);
        JET2Writer _jettag_java_format_2_1_saved_out = out;
        while (_jettag_java_format_2_1.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(NL);         
            RuntimeTagElement _jettag_f_bundle_3_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "bundle", "f:bundle", _td_f_bundle_3_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_f_bundle_3_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_f_bundle_3_1.setTagInfo(_td_f_bundle_3_1);
            _jettag_f_bundle_3_1.doStart(context, out);
            while (_jettag_f_bundle_3_1.okToProcessBody()) {
                RuntimeTagElement _jettag_f_message_4_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_4_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_4_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_4_1.setTagInfo(_td_f_message_4_1);
                _jettag_f_message_4_1.doStart(context, out);
                JET2Writer _jettag_f_message_4_1_saved_out = out;
                while (_jettag_f_message_4_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("copyright");  //$NON-NLS-1$        
                    _jettag_f_message_4_1.handleBodyContent(out);
                }
                out = _jettag_f_message_4_1_saved_out;
                _jettag_f_message_4_1.doEnd();
                out.write(NL);         
                out.write(NL);         
                out.write("package ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 6, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".client;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import info.yalamanchili.security.gwt.YUser;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.security.gwt.YRole;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.Window;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.widgets.LoginPanelAbstract;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.widgets.ResponseStatusWidget;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.HashSet;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Set;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.security.gwt.AdminService.AdminServiceAsync;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.RootLayoutPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_19_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_19_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_19_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_19_1.setTagInfo(_td_f_message_19_1);
                _jettag_f_message_19_1.doStart(context, out);
                JET2Writer _jettag_f_message_19_1_saved_out = out;
                while (_jettag_f_message_19_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_19_1.handleBodyContent(out);
                }
                out = _jettag_f_message_19_1_saved_out;
                _jettag_f_message_19_1.doEnd();
                out.write(NL);         
                out.write("public class LoginPanel extends LoginPanelAbstract {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_21_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_21_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_21_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_21_1.setTagInfo(_td_f_message_21_1);
                _jettag_f_message_21_1.doStart(context, out);
                JET2Writer _jettag_f_message_21_1_saved_out = out;
                while (_jettag_f_message_21_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_21_1.handleBodyContent(out);
                }
                out = _jettag_f_message_21_1_saved_out;
                _jettag_f_message_21_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void loginClicked() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tAdminServiceAsync.instance().login(usernameTb.getText(),");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tpasswordTb.getText(), new ALAsyncCallback<YUser>() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\tpublic void onResponse(YUser arg0) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tif (arg0 != null) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t\tRootLayoutPanel.get().clear();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t\tnew ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 31, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome().onModuleLoad();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t\tnew ResponseStatusWidget().show(\"login success\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t\tLoginPanel.this.hide();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t} else {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t\tnew ResponseStatusWidget().show(\"login failed\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t});");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_45_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_45_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_45_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_45_1.setTagInfo(_td_f_message_45_1);
                _jettag_f_message_45_1.doStart(context, out);
                JET2Writer _jettag_f_message_45_1_saved_out = out;
                while (_jettag_f_message_45_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_45_1.handleBodyContent(out);
                }
                out = _jettag_f_message_45_1_saved_out;
                _jettag_f_message_45_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void setAutoLogout() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t// TODO Auto-generated method stub");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                _jettag_f_bundle_3_1.handleBodyContent(out);
            }
            _jettag_f_bundle_3_1.doEnd();
            _jettag_java_format_2_1.handleBodyContent(out);
        }
        out = _jettag_java_format_2_1_saved_out;
        _jettag_java_format_2_1.doEnd();
    }
}
