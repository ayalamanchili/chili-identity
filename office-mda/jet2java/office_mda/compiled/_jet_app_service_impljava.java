package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_app_service_impljava implements JET2Template {
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_app_service_impljava() {
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
    private static final TagInfo _td_f_message_27_1 = new TagInfo("f:message", //$NON-NLS-1$
            27, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_33_1 = new TagInfo("f:message", //$NON-NLS-1$
            33, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_36_1 = new TagInfo("f:message", //$NON-NLS-1$
            36, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_40_1 = new TagInfo("f:message", //$NON-NLS-1$
            40, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_43_1 = new TagInfo("f:message", //$NON-NLS-1$
            43, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_46_1 = new TagInfo("f:message", //$NON-NLS-1$
            46, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_49_1 = new TagInfo("f:message", //$NON-NLS-1$
            49, 1,
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
                out.write("package ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 5, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".server;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.apache.commons.logging.Log;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.apache.commons.logging.LogFactory;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.trace.Trace;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import javax.persistence.EntityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.security.management.IdentityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Observer;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Create;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.In;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Name;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.remoting.WebRemote;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.security.Identity;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.security.auth.login.LoginException;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Transactional;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.Query;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.security.gwt.YUser;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.security.gwt.YRole;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.server.GileadService;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Scope;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.ScopeType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_27_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_27_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_27_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_27_1.setTagInfo(_td_f_message_27_1);
                _jettag_f_message_27_1.doStart(context, out);
                JET2Writer _jettag_f_message_27_1_saved_out = out;
                while (_jettag_f_message_27_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_27_1.handleBodyContent(out);
                }
                out = _jettag_f_message_27_1_saved_out;
                _jettag_f_message_27_1.doEnd();
                out.write(NL);         
                out.write("@Trace");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Transactional");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Scope(ScopeType.SESSION)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Name(\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 31, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("rpc.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 31, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service\")");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 32, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceImpl extends GileadService implements ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 32, 85)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("rpc.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 32, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_33_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_33_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_33_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_33_1.setTagInfo(_td_f_message_33_1);
                _jettag_f_message_33_1.doStart(context, out);
                JET2Writer _jettag_f_message_33_1_saved_out = out;
                while (_jettag_f_message_33_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_33_1.handleBodyContent(out);
                }
                out = _jettag_f_message_33_1_saved_out;
                _jettag_f_message_33_1.doEnd();
                out.write(NL);         
                out.write("\tprivate static final Log log = LogFactory");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t.getLog(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 35, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceImpl.class);");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_36_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_36_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_36_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_36_1.setTagInfo(_td_f_message_36_1);
                _jettag_f_message_36_1.doStart(context, out);
                JET2Writer _jettag_f_message_36_1_saved_out = out;
                while (_jettag_f_message_36_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_36_1.handleBodyContent(out);
                }
                out = _jettag_f_message_36_1_saved_out;
                _jettag_f_message_36_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 37, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceImpl() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tsuper(\"java:/");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$projectName}", 38, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_40_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_40_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_40_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_40_1.setTagInfo(_td_f_message_40_1);
                _jettag_f_message_40_1.doStart(context, out);
                JET2Writer _jettag_f_message_40_1_saved_out = out;
                while (_jettag_f_message_40_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_40_1.handleBodyContent(out);
                }
                out = _jettag_f_message_40_1_saved_out;
                _jettag_f_message_40_1.doEnd();
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@In(create = true)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected EntityManager yem;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_43_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_43_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_43_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_43_1.setTagInfo(_td_f_message_43_1);
                _jettag_f_message_43_1.doStart(context, out);
                JET2Writer _jettag_f_message_43_1_saved_out = out;
                while (_jettag_f_message_43_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_43_1.handleBodyContent(out);
                }
                out = _jettag_f_message_43_1_saved_out;
                _jettag_f_message_43_1.doEnd();
                out.write(NL);         
                out.write("\t@In(create = true)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected Identity identity;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_46_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_46_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_46_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_46_1.setTagInfo(_td_f_message_46_1);
                _jettag_f_message_46_1.doStart(context, out);
                JET2Writer _jettag_f_message_46_1_saved_out = out;
                while (_jettag_f_message_46_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_46_1.handleBodyContent(out);
                }
                out = _jettag_f_message_46_1_saved_out;
                _jettag_f_message_46_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@In(create = true)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected IdentityManager identityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_49_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_49_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_49_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_49_1.setTagInfo(_td_f_message_49_1);
                _jettag_f_message_49_1.doStart(context, out);
                JET2Writer _jettag_f_message_49_1_saved_out = out;
                while (_jettag_f_message_49_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_49_1.handleBodyContent(out);
                }
                out = _jettag_f_message_49_1_saved_out;
                _jettag_f_message_49_1.doEnd();
                out.write(NL);         
                out.write(NL);         
                out.write("}");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_f_bundle_3_1.handleBodyContent(out);
            }
            _jettag_f_bundle_3_1.doEnd();
            _jettag_java_format_2_1.handleBodyContent(out);
        }
        out = _jettag_java_format_2_1_saved_out;
        _jettag_java_format_2_1.doEnd();
        out.write(NL);         
    }
}
