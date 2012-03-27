package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_tree_abstract_panel_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_tree_abstract_panel_templatejava() {
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
    private static final TagInfo _td_c_setVariable_5_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            5, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_6_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            6, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "isChild", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_12_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            12, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_14_2 = new TagInfo("c:if", //$NON-NLS-1$
            14, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_15_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            15, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_16_6 = new TagInfo("c:if", //$NON-NLS-1$
            16, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_17_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            17, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@name", //$NON-NLS-1$
                "parentClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_18_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            18, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
                "isChild", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_24_1 = new TagInfo("c:choose", //$NON-NLS-1$
            24, 1,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$isChild", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_24_31 = new TagInfo("c:when", //$NON-NLS-1$
            24, 31,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_25_1 = new TagInfo("f:message", //$NON-NLS-1$
            25, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_choose_26_64 = new TagInfo("c:choose", //$NON-NLS-1$
            26, 64,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$isChild", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_26_94 = new TagInfo("c:when", //$NON-NLS-1$
            26, 94,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_26_172 = new TagInfo("c:otherwise", //$NON-NLS-1$
            26, 172,
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
    private static final TagInfo _td_f_message_29_1 = new TagInfo("f:message", //$NON-NLS-1$
            29, 1,
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
    private static final TagInfo _td_f_message_37_1 = new TagInfo("f:message", //$NON-NLS-1$
            37, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_39_1 = new TagInfo("f:message", //$NON-NLS-1$
            39, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_41_1 = new TagInfo("f:message", //$NON-NLS-1$
            41, 1,
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
                RuntimeTagElement _jettag_c_setVariable_5_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_5_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_5_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_5_1.setTagInfo(_td_c_setVariable_5_1);
                _jettag_c_setVariable_5_1.doStart(context, out);
                _jettag_c_setVariable_5_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_6_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_6_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_6_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_6_1.setTagInfo(_td_c_setVariable_6_1);
                _jettag_c_setVariable_6_1.doStart(context, out);
                _jettag_c_setVariable_6_1.doEnd();
                out.write("package ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 7, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 7, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 8, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 8, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 8, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.TreePanelComposite;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                // Check inheritance support
                RuntimeTagElement _jettag_c_iterate_12_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_12_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_12_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_12_1.setTagInfo(_td_c_iterate_12_1);
                _jettag_c_iterate_12_1.doStart(context, out);
                while (_jettag_c_iterate_12_1.okToProcessBody()) {
                    // if child class
                    RuntimeTagElement _jettag_c_if_14_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_14_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_14_2.setRuntimeParent(_jettag_c_iterate_12_1);
                    _jettag_c_if_14_2.setTagInfo(_td_c_if_14_2);
                    _jettag_c_if_14_2.doStart(context, out);
                    while (_jettag_c_if_14_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_15_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_15_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_15_3.setRuntimeParent(_jettag_c_if_14_2);
                        _jettag_c_iterate_15_3.setTagInfo(_td_c_iterate_15_3);
                        _jettag_c_iterate_15_3.doStart(context, out);
                        while (_jettag_c_iterate_15_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_16_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_16_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_16_6.setRuntimeParent(_jettag_c_iterate_15_3);
                            _jettag_c_if_16_6.setTagInfo(_td_c_if_16_6);
                            _jettag_c_if_16_6.doStart(context, out);
                            while (_jettag_c_if_16_6.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_17_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_17_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_17_6.setRuntimeParent(_jettag_c_if_16_6);
                                _jettag_c_setVariable_17_6.setTagInfo(_td_c_setVariable_17_6);
                                _jettag_c_setVariable_17_6.doStart(context, out);
                                _jettag_c_setVariable_17_6.doEnd();
                                RuntimeTagElement _jettag_c_setVariable_18_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_18_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_18_6.setRuntimeParent(_jettag_c_if_16_6);
                                _jettag_c_setVariable_18_6.setTagInfo(_td_c_setVariable_18_6);
                                _jettag_c_setVariable_18_6.doStart(context, out);
                                _jettag_c_setVariable_18_6.doEnd();
                                _jettag_c_if_16_6.handleBodyContent(out);
                            }
                            _jettag_c_if_16_6.doEnd();
                            _jettag_c_iterate_15_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_15_3.doEnd();
                        _jettag_c_if_14_2.handleBodyContent(out);
                    }
                    _jettag_c_if_14_2.doEnd();
                    _jettag_c_iterate_12_1.handleBodyContent(out);
                }
                _jettag_c_iterate_12_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_c_choose_24_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_24_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_24_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_choose_24_1.setTagInfo(_td_c_choose_24_1);
                _jettag_c_choose_24_1.doStart(context, out);
                JET2Writer _jettag_c_choose_24_1_saved_out = out;
                while (_jettag_c_choose_24_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(" ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_24_31 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_24_31); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_24_31.setRuntimeParent(_jettag_c_choose_24_1);
                    _jettag_c_when_24_31.setTagInfo(_td_c_when_24_31);
                    _jettag_c_when_24_31.doStart(context, out);
                    JET2Writer _jettag_c_when_24_31_saved_out = out;
                    while (_jettag_c_when_24_31.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" import ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$groupID}", 24, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".client.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 24, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($parentClass)}", 24, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".TreeAbstract");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$parentClass}", 24, 157)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("Panel; ");  //$NON-NLS-1$        
                        _jettag_c_when_24_31.handleBodyContent(out);
                    }
                    out = _jettag_c_when_24_31_saved_out;
                    _jettag_c_when_24_31.doEnd();
                    out.write("   ");  //$NON-NLS-1$        
                    _jettag_c_choose_24_1.handleBodyContent(out);
                }
                out = _jettag_c_choose_24_1_saved_out;
                _jettag_c_choose_24_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_25_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_25_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_25_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_25_1.setTagInfo(_td_f_message_25_1);
                _jettag_f_message_25_1.doStart(context, out);
                JET2Writer _jettag_f_message_25_1_saved_out = out;
                while (_jettag_f_message_25_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_25_1.handleBodyContent(out);
                }
                out = _jettag_f_message_25_1_saved_out;
                _jettag_f_message_25_1.doEnd();
                out.write(NL);         
                out.write("public abstract class TreeAbstract");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 26, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel extends ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_choose_26_64 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_26_64); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_26_64.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_choose_26_64.setTagInfo(_td_c_choose_26_64);
                _jettag_c_choose_26_64.doStart(context, out);
                JET2Writer _jettag_c_choose_26_64_saved_out = out;
                while (_jettag_c_choose_26_64.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(" ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_26_94 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_26_94); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_26_94.setRuntimeParent(_jettag_c_choose_26_64);
                    _jettag_c_when_26_94.setTagInfo(_td_c_when_26_94);
                    _jettag_c_when_26_94.doStart(context, out);
                    JET2Writer _jettag_c_when_26_94_saved_out = out;
                    while (_jettag_c_when_26_94.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" TreePanelComposite<");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$class/@name}", 26, 145)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("> ");  //$NON-NLS-1$        
                        _jettag_c_when_26_94.handleBodyContent(out);
                    }
                    out = _jettag_c_when_26_94_saved_out;
                    _jettag_c_when_26_94.doEnd();
                    out.write(" ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_otherwise_26_172 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_26_172); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_26_172.setRuntimeParent(_jettag_c_choose_26_64);
                    _jettag_c_otherwise_26_172.setTagInfo(_td_c_otherwise_26_172);
                    _jettag_c_otherwise_26_172.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_26_172_saved_out = out;
                    while (_jettag_c_otherwise_26_172.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" TreeAbstract");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$parentClass}", 26, 198)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("Panel");  //$NON-NLS-1$        
                        _jettag_c_otherwise_26_172.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_26_172_saved_out;
                    _jettag_c_otherwise_26_172.doEnd();
                    out.write("  ");  //$NON-NLS-1$        
                    _jettag_c_choose_26_64.handleBodyContent(out);
                }
                out = _jettag_c_choose_26_64_saved_out;
                _jettag_c_choose_26_64.doEnd();
                out.write(" {");  //$NON-NLS-1$        
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
                out.write("private static TreeAbstract");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 28, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel instance;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_29_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_29_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_29_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_29_1.setTagInfo(_td_f_message_29_1);
                _jettag_f_message_29_1.doStart(context, out);
                JET2Writer _jettag_f_message_29_1_saved_out = out;
                while (_jettag_f_message_29_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_29_1.handleBodyContent(out);
                }
                out = _jettag_f_message_29_1_saved_out;
                _jettag_f_message_29_1.doEnd();
                out.write(NL);         
                out.write("\tpublic static TreeAbstract");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 30, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel instance() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn instance;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic TreeAbstract");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 34, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tinstance=this;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_37_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_37_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_37_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_37_1.setTagInfo(_td_f_message_37_1);
                _jettag_f_message_37_1.doStart(context, out);
                JET2Writer _jettag_f_message_37_1_saved_out = out;
                while (_jettag_f_message_37_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_37_1.handleBodyContent(out);
                }
                out = _jettag_f_message_37_1_saved_out;
                _jettag_f_message_37_1.doEnd();
                out.write(NL);         
                out.write("\tprotected abstract void addListeners();");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_39_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_39_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_39_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_39_1.setTagInfo(_td_f_message_39_1);
                _jettag_f_message_39_1.doStart(context, out);
                JET2Writer _jettag_f_message_39_1_saved_out = out;
                while (_jettag_f_message_39_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_39_1.handleBodyContent(out);
                }
                out = _jettag_f_message_39_1_saved_out;
                _jettag_f_message_39_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected abstract void addWidgets();");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_41_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_41_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_41_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_41_1.setTagInfo(_td_f_message_41_1);
                _jettag_f_message_41_1.doStart(context, out);
                JET2Writer _jettag_f_message_41_1_saved_out = out;
                while (_jettag_f_message_41_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_41_1.handleBodyContent(out);
                }
                out = _jettag_f_message_41_1_saved_out;
                _jettag_f_message_41_1.doEnd();
                out.write(NL);         
                out.write("\tprotected abstract void configure() ;");  //$NON-NLS-1$        
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
                out.write("\tpublic abstract ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 44, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" loadEntity();");  //$NON-NLS-1$        
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
