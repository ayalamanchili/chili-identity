package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_app_request_factoryjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_app_request_factoryjava() {
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
    private static final TagInfo _td_c_iterate_7_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            7, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_8_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            8, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($webPackage,$package/@name)", //$NON-NLS-1$
                "packageName", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_9_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            9, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_15_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            15, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_16_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            16, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($webPackage,$package/@name)", //$NON-NLS-1$
                "packageName", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_17_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            17, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_18_8 = new TagInfo("f:message", //$NON-NLS-1$
            18, 8,
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
                out.write(".client;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.web.bindery.requestfactory.shared.RequestFactory;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_iterate_7_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_7_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_7_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_7_1.setTagInfo(_td_c_iterate_7_1);
                _jettag_c_iterate_7_1.doStart(context, out);
                while (_jettag_c_iterate_7_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_8_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_8_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_8_6.setRuntimeParent(_jettag_c_iterate_7_1);
                    _jettag_c_setVariable_8_6.setTagInfo(_td_c_setVariable_8_6);
                    _jettag_c_setVariable_8_6.doStart(context, out);
                    _jettag_c_setVariable_8_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_9_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_9_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_9_6.setRuntimeParent(_jettag_c_iterate_7_1);
                    _jettag_c_iterate_9_6.setTagInfo(_td_c_iterate_9_6);
                    _jettag_c_iterate_9_6.doStart(context, out);
                    while (_jettag_c_iterate_9_6.okToProcessBody()) {
                        out.write("import ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$groupID}", 10, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".client.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 10, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 10, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$class/@name}", 10, 85)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("Request;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_iterate_9_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_9_6.doEnd();
                    _jettag_c_iterate_7_1.handleBodyContent(out);
                }
                _jettag_c_iterate_7_1.doEnd();
                out.write(NL);         
                out.write("public interface ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 14, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("RequestFactory extends RequestFactory {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_iterate_15_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_15_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_15_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_15_1.setTagInfo(_td_c_iterate_15_1);
                _jettag_c_iterate_15_1.doStart(context, out);
                while (_jettag_c_iterate_15_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_16_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_16_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_16_6.setRuntimeParent(_jettag_c_iterate_15_1);
                    _jettag_c_setVariable_16_6.setTagInfo(_td_c_setVariable_16_6);
                    _jettag_c_setVariable_16_6.doStart(context, out);
                    _jettag_c_setVariable_16_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_17_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_17_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_17_6.setRuntimeParent(_jettag_c_iterate_15_1);
                    _jettag_c_iterate_17_6.setTagInfo(_td_c_iterate_17_6);
                    _jettag_c_iterate_17_6.doStart(context, out);
                    while (_jettag_c_iterate_17_6.okToProcessBody()) {
                        out.write("    \t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_f_message_18_8 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_18_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_f_message_18_8.setRuntimeParent(_jettag_c_iterate_17_6);
                        _jettag_f_message_18_8.setTagInfo(_td_f_message_18_8);
                        _jettag_f_message_18_8.doStart(context, out);
                        JET2Writer _jettag_f_message_18_8_saved_out = out;
                        while (_jettag_f_message_18_8.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("generated.comment");  //$NON-NLS-1$        
                            _jettag_f_message_18_8.handleBodyContent(out);
                        }
                        out = _jettag_f_message_18_8_saved_out;
                        _jettag_f_message_18_8.doEnd();
                        out.write(NL);         
                        out.write("    \t\t\t ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$class/@name}", 19, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("Request ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 19, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("Request();");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_iterate_17_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_17_6.doEnd();
                    _jettag_c_iterate_15_1.handleBodyContent(out);
                }
                _jettag_c_iterate_15_1.doEnd();
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
