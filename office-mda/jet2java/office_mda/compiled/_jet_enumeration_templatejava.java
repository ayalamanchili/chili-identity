package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_enumeration_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_enumeration_templatejava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
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
    private static final TagInfo _td_java_importsLocation_7_1 = new TagInfo("java:importsLocation", //$NON-NLS-1$
            7, 1,
            new String[] {
                "package", //$NON-NLS-1$
            },
            new String[] {
                "{$package/@name}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_8_1 = new TagInfo("f:message", //$NON-NLS-1$
            8, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_10_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            10, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$enumeration/Enumeration.literal/EnumerationLiteral", //$NON-NLS-1$
                "enumerationlit", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_11_1 = new TagInfo("f:message", //$NON-NLS-1$
            11, 1,
            new String[] {
            },
            new String[] {
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
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
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 5, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" ");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_java_importsLocation_7_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "importsLocation", "java:importsLocation", _td_java_importsLocation_7_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_java_importsLocation_7_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_java_importsLocation_7_1.setTagInfo(_td_java_importsLocation_7_1);
                _jettag_java_importsLocation_7_1.doStart(context, out);
                _jettag_java_importsLocation_7_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_8_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_8_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_8_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_8_1.setTagInfo(_td_f_message_8_1);
                _jettag_f_message_8_1.doStart(context, out);
                JET2Writer _jettag_f_message_8_1_saved_out = out;
                while (_jettag_f_message_8_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_8_1.handleBodyContent(out);
                }
                out = _jettag_f_message_8_1_saved_out;
                _jettag_f_message_8_1.doEnd();
                out.write(NL);         
                out.write("public enum ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$enumeration/@name}", 9, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_iterate_10_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_10_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_10_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_10_1.setTagInfo(_td_c_iterate_10_1);
                _jettag_c_iterate_10_1.doStart(context, out);
                while (_jettag_c_iterate_10_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_f_message_11_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_11_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_11_1.setRuntimeParent(_jettag_c_iterate_10_1);
                    _jettag_f_message_11_1.setTagInfo(_td_f_message_11_1);
                    _jettag_f_message_11_1.doStart(context, out);
                    JET2Writer _jettag_f_message_11_1_saved_out = out;
                    while (_jettag_f_message_11_1.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_11_1.handleBodyContent(out);
                    }
                    out = _jettag_f_message_11_1_saved_out;
                    _jettag_f_message_11_1.doEnd();
                    out.write(NL);         
                    out.write(context.embeddedExpressionAsString("${$enumerationlit/@name}", 12, 1)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(",");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_iterate_10_1.handleBodyContent(out);
                }
                _jettag_c_iterate_10_1.doEnd();
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
