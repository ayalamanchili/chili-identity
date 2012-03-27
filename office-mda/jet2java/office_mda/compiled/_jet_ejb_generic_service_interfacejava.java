package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_ejb_generic_service_interfacejava implements JET2Template {
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_ejb_generic_service_interfacejava() {
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
    private static final TagInfo _td_f_message_10_1 = new TagInfo("f:message", //$NON-NLS-1$
            10, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_13_1 = new TagInfo("f:message", //$NON-NLS-1$
            13, 1,
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
                out.write(".ejb;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.io.Serializable;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_10_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_10_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_10_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_10_1.setTagInfo(_td_f_message_10_1);
                _jettag_f_message_10_1.doStart(context, out);
                JET2Writer _jettag_f_message_10_1_saved_out = out;
                while (_jettag_f_message_10_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_10_1.handleBodyContent(out);
                }
                out = _jettag_f_message_10_1_saved_out;
                _jettag_f_message_10_1.doEnd();
                out.write(NL);         
                out.write("public interface GenericService {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_13_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_13_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_13_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_13_1.setTagInfo(_td_f_message_13_1);
                _jettag_f_message_13_1.doStart(context, out);
                JET2Writer _jettag_f_message_13_1_saved_out = out;
                while (_jettag_f_message_13_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_13_1.handleBodyContent(out);
                }
                out = _jettag_f_message_13_1_saved_out;
                _jettag_f_message_13_1.doEnd();
                out.write(NL);         
                out.write("public <T extends Serializable> List<String> getSuggestionsForName(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tString name, T entity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_17_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_17_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_17_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_17_1.setTagInfo(_td_f_message_17_1);
                _jettag_f_message_17_1.doStart(context, out);
                JET2Writer _jettag_f_message_17_1_saved_out = out;
                while (_jettag_f_message_17_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_17_1.handleBodyContent(out);
                }
                out = _jettag_f_message_17_1_saved_out;
                _jettag_f_message_17_1.doEnd();
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public <T extends Serializable> List<T> getRelatedEntities(Long entityID,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tClass sourceClass, T target);");  //$NON-NLS-1$        
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
