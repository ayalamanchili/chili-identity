package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_entity_enum_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_entity_enum_templatejava() {
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
    private static final TagInfo _td_f_message_6_1 = new TagInfo("f:message", //$NON-NLS-1$
            6, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_8_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            8, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_9_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            9, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($webPackage,$package/@name)", //$NON-NLS-1$
                "packageName", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_10_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            10, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_11_8 = new TagInfo("f:message", //$NON-NLS-1$
            11, 8,
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
                out.write(".client;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_6_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_6_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_6_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_6_1.setTagInfo(_td_f_message_6_1);
                _jettag_f_message_6_1.doStart(context, out);
                JET2Writer _jettag_f_message_6_1_saved_out = out;
                while (_jettag_f_message_6_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_6_1.handleBodyContent(out);
                }
                out = _jettag_f_message_6_1_saved_out;
                _jettag_f_message_6_1.doEnd();
                out.write(NL);         
                out.write("public enum Entity {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_iterate_8_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_8_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_8_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_8_2.setTagInfo(_td_c_iterate_8_2);
                _jettag_c_iterate_8_2.doStart(context, out);
                while (_jettag_c_iterate_8_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_9_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_9_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_9_8.setRuntimeParent(_jettag_c_iterate_8_2);
                    _jettag_c_setVariable_9_8.setTagInfo(_td_c_setVariable_9_8);
                    _jettag_c_setVariable_9_8.doStart(context, out);
                    _jettag_c_setVariable_9_8.doEnd();
                    RuntimeTagElement _jettag_c_iterate_10_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_10_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_10_8.setRuntimeParent(_jettag_c_iterate_8_2);
                    _jettag_c_iterate_10_8.setTagInfo(_td_c_iterate_10_8);
                    _jettag_c_iterate_10_8.doStart(context, out);
                    while (_jettag_c_iterate_10_8.okToProcessBody()) {
                        out.write("    \t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_f_message_11_8 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_11_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_f_message_11_8.setRuntimeParent(_jettag_c_iterate_10_8);
                        _jettag_f_message_11_8.setTagInfo(_td_f_message_11_8);
                        _jettag_f_message_11_8.doStart(context, out);
                        JET2Writer _jettag_f_message_11_8_saved_out = out;
                        while (_jettag_f_message_11_8.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("generated.comment");  //$NON-NLS-1$        
                            _jettag_f_message_11_8.handleBodyContent(out);
                        }
                        out = _jettag_f_message_11_8_saved_out;
                        _jettag_f_message_11_8.doEnd();
                        out.write(NL);         
                        out.write("    \t\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($class/@name)}", 12, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(",");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_iterate_10_8.handleBodyContent(out);
                    }
                    _jettag_c_iterate_10_8.doEnd();
                    _jettag_c_iterate_8_2.handleBodyContent(out);
                }
                _jettag_c_iterate_8_2.doEnd();
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
