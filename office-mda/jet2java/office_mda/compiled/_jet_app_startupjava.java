package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_app_startupjava implements JET2Template {
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_app_startupjava() {
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
    private static final TagInfo _td_f_message_17_1 = new TagInfo("f:message", //$NON-NLS-1$
            17, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_23_1 = new TagInfo("f:message", //$NON-NLS-1$
            23, 1,
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
                out.write(NL);         
                out.write("import javax.persistence.EntityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import org.jboss.seam.ScopeType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.In;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Name;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Observer;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Scope;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Startup;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Transactional;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.async.Asynchronous;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_17_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_17_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_17_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_17_1.setTagInfo(_td_f_message_17_1);
                _jettag_f_message_17_1.doStart(context, out);
                JET2Writer _jettag_f_message_17_1_saved_out = out;
                while (_jettag_f_message_17_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_17_1.handleBodyContent(out);
                }
                out = _jettag_f_message_17_1_saved_out;
                _jettag_f_message_17_1.doEnd();
                out.write(NL);         
                out.write("@Name(\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 18, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Startup\")");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Scope(ScopeType.APPLICATION)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("//@startup not needed?");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("//@Startup");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 22, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Startup {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_23_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_23_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_23_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_23_1.setTagInfo(_td_f_message_23_1);
                _jettag_f_message_23_1.doStart(context, out);
                JET2Writer _jettag_f_message_23_1_saved_out = out;
                while (_jettag_f_message_23_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_23_1.handleBodyContent(out);
                }
                out = _jettag_f_message_23_1_saved_out;
                _jettag_f_message_23_1.doEnd();
                out.write(NL);         
                out.write("@In(create = true)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected EntityManager em;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_27_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_27_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_27_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_27_1.setTagInfo(_td_f_message_27_1);
                _jettag_f_message_27_1.doStart(context, out);
                JET2Writer _jettag_f_message_27_1_saved_out = out;
                while (_jettag_f_message_27_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_27_1.handleBodyContent(out);
                }
                out = _jettag_f_message_27_1_saved_out;
                _jettag_f_message_27_1.doEnd();
                out.write(NL);         
                out.write("\t// TODO fix issue");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t/*");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t * http://code.google.com/p/yalamanchili/issues/detail?id=127&q=hibernate%20");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t * search");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t */");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Observer(\"org.jboss.seam.postInitialization\")");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Transactional");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void searchIndexBuilder() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t/*try {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tSearchUtils.getFullTextSession(em).createIndexer()");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t.batchSizeToLoadObjects(25).cacheMode(CacheMode.NORMAL)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t.threadsToLoadObjects(5).threadsForSubsequentFetching(20)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t.startAndWait();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t} catch (InterruptedException e) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\te.printStackTrace();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t} */");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
    }
}
