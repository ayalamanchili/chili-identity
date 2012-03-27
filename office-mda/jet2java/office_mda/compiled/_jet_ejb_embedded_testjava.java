package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_ejb_embedded_testjava implements JET2Template {
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_ejb_embedded_testjava() {
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
    private static final TagInfo _td_f_message_15_1 = new TagInfo("f:message", //$NON-NLS-1$
            15, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_19_2 = new TagInfo("f:message", //$NON-NLS-1$
            19, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_23_2 = new TagInfo("f:message", //$NON-NLS-1$
            23, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_30_2 = new TagInfo("f:message", //$NON-NLS-1$
            30, 2,
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
                out.write(".ejb.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 6, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 6, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.arquillian.api.Deployment;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.arquillian.junit.Arquillian;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.shrinkwrap.api.ShrinkWrap;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.shrinkwrap.api.spec.JavaArchive;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.junit.Test;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.junit.runner.RunWith;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.ejb.EJB;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_15_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_15_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_15_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_15_1.setTagInfo(_td_f_message_15_1);
                _jettag_f_message_15_1.doStart(context, out);
                JET2Writer _jettag_f_message_15_1_saved_out = out;
                while (_jettag_f_message_15_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_15_1.handleBodyContent(out);
                }
                out = _jettag_f_message_15_1_saved_out;
                _jettag_f_message_15_1.doEnd();
                out.write(NL);         
                out.write("@RunWith(Arquillian.class)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 17, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceTest {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_19_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_19_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_19_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_19_2.setTagInfo(_td_f_message_19_2);
                _jettag_f_message_19_2.doStart(context, out);
                JET2Writer _jettag_f_message_19_2_saved_out = out;
                while (_jettag_f_message_19_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_19_2.handleBodyContent(out);
                }
                out = _jettag_f_message_19_2_saved_out;
                _jettag_f_message_19_2.doEnd();
                out.write(NL);         
                out.write("\t@EJB");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprivate ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 21, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceBean service;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_23_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_23_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_23_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_23_2.setTagInfo(_td_f_message_23_2);
                _jettag_f_message_23_2.doStart(context, out);
                JET2Writer _jettag_f_message_23_2_saved_out = out;
                while (_jettag_f_message_23_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_23_2.handleBodyContent(out);
                }
                out = _jettag_f_message_23_2_saved_out;
                _jettag_f_message_23_2.doEnd();
                out.write(NL);         
                out.write("\t@Deployment");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic static JavaArchive createTestArchive() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn ShrinkWrap.create(JavaArchive.class, \"test.jar\").addClasses(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 27, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceBean.class, ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 27, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service.class);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_30_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_30_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_30_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_30_2.setTagInfo(_td_f_message_30_2);
                _jettag_f_message_30_2.doStart(context, out);
                JET2Writer _jettag_f_message_30_2_saved_out = out;
                while (_jettag_f_message_30_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_30_2.handleBodyContent(out);
                }
                out = _jettag_f_message_30_2_saved_out;
                _jettag_f_message_30_2.doEnd();
                out.write(NL);         
                out.write("\t@Test");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void testInsert() throws Exception {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}\t");  //$NON-NLS-1$        
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
