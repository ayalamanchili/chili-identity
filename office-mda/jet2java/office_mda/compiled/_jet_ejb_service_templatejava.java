package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_ejb_service_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_ejb_service_templatejava() {
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
    private static final TagInfo _td_c_setVariable_6_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            6, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_13_1 = new TagInfo("f:message", //$NON-NLS-1$
            13, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_16_2 = new TagInfo("f:message", //$NON-NLS-1$
            16, 2,
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
    private static final TagInfo _td_f_message_22_2 = new TagInfo("f:message", //$NON-NLS-1$
            22, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_25_2 = new TagInfo("f:message", //$NON-NLS-1$
            25, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_28_2 = new TagInfo("f:message", //$NON-NLS-1$
            28, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_31_2 = new TagInfo("f:message", //$NON-NLS-1$
            31, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_34_2 = new TagInfo("f:message", //$NON-NLS-1$
            34, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_37_2 = new TagInfo("f:message", //$NON-NLS-1$
            37, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_41_2 = new TagInfo("f:message", //$NON-NLS-1$
            41, 2,
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
                out.write(".ejb.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 5, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 5, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_setVariable_6_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_6_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_6_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_6_1.setTagInfo(_td_c_setVariable_6_1);
                _jettag_c_setVariable_6_1.doStart(context, out);
                _jettag_c_setVariable_6_1.doEnd();
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 7, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 7, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 7, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Map;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.beans.TableObj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.io.Serializable;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_13_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_13_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_13_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_13_1.setTagInfo(_td_f_message_13_1);
                _jettag_f_message_13_1.doStart(context, out);
                JET2Writer _jettag_f_message_13_1_saved_out = out;
                while (_jettag_f_message_13_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_13_1.handleBodyContent(out);
                }
                out = _jettag_f_message_13_1_saved_out;
                _jettag_f_message_13_1.doEnd();
                out.write(NL);         
                out.write("public interface ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 14, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_16_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_16_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_16_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_16_2.setTagInfo(_td_f_message_16_2);
                _jettag_f_message_16_2.doStart(context, out);
                JET2Writer _jettag_f_message_16_2_saved_out = out;
                while (_jettag_f_message_16_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_16_2.handleBodyContent(out);
                }
                out = _jettag_f_message_16_2_saved_out;
                _jettag_f_message_16_2.doEnd();
                out.write(NL);         
                out.write("    public ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 17, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" create(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 17, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("    ");  //$NON-NLS-1$        
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
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 20, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" read(Long id);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_22_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_22_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_22_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_22_2.setTagInfo(_td_f_message_22_2);
                _jettag_f_message_22_2.doStart(context, out);
                JET2Writer _jettag_f_message_22_2_saved_out = out;
                while (_jettag_f_message_22_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_22_2.handleBodyContent(out);
                }
                out = _jettag_f_message_22_2_saved_out;
                _jettag_f_message_22_2.doEnd();
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 23, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" update(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 23, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_25_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_25_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_25_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_25_2.setTagInfo(_td_f_message_25_2);
                _jettag_f_message_25_2.doStart(context, out);
                JET2Writer _jettag_f_message_25_2_saved_out = out;
                while (_jettag_f_message_25_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_25_2.handleBodyContent(out);
                }
                out = _jettag_f_message_25_2_saved_out;
                _jettag_f_message_25_2.doEnd();
                out.write(NL);         
                out.write("\tpublic void delete(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 26, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_28_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_28_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_28_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_28_2.setTagInfo(_td_f_message_28_2);
                _jettag_f_message_28_2.doStart(context, out);
                JET2Writer _jettag_f_message_28_2_saved_out = out;
                while (_jettag_f_message_28_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_28_2.handleBodyContent(out);
                }
                out = _jettag_f_message_28_2_saved_out;
                _jettag_f_message_28_2.doEnd();
                out.write(NL);         
                out.write("\tpublic TableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 29, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> getTableObj(int start);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_31_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_31_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_31_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_31_2.setTagInfo(_td_f_message_31_2);
                _jettag_f_message_31_2.doStart(context, out);
                JET2Writer _jettag_f_message_31_2_saved_out = out;
                while (_jettag_f_message_31_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_31_2.handleBodyContent(out);
                }
                out = _jettag_f_message_31_2_saved_out;
                _jettag_f_message_31_2.doEnd();
                out.write(NL);         
                out.write("\tpublic List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 32, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> getEntities(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 32, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_34_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_34_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_34_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_34_2.setTagInfo(_td_f_message_34_2);
                _jettag_f_message_34_2.doStart(context, out);
                JET2Writer _jettag_f_message_34_2_saved_out = out;
                while (_jettag_f_message_34_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_34_2.handleBodyContent(out);
                }
                out = _jettag_f_message_34_2_saved_out;
                _jettag_f_message_34_2.doEnd();
                out.write(NL);         
                out.write("\tpublic Map<Long, String> getListBoxValues(String[] columns);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_37_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_37_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_37_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_37_2.setTagInfo(_td_f_message_37_2);
                _jettag_f_message_37_2.doStart(context, out);
                JET2Writer _jettag_f_message_37_2_saved_out = out;
                while (_jettag_f_message_37_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_37_2.handleBodyContent(out);
                }
                out = _jettag_f_message_37_2_saved_out;
                _jettag_f_message_37_2.doEnd();
                out.write(NL);         
                out.write("\tpublic <T extends Serializable> void addAll(T parent, T children,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tList<Long> ids);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_41_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_41_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_41_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_41_2.setTagInfo(_td_f_message_41_2);
                _jettag_f_message_41_2.doStart(context, out);
                JET2Writer _jettag_f_message_41_2_saved_out = out;
                while (_jettag_f_message_41_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_41_2.handleBodyContent(out);
                }
                out = _jettag_f_message_41_2_saved_out;
                _jettag_f_message_41_2.doEnd();
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void destroy();");  //$NON-NLS-1$        
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
