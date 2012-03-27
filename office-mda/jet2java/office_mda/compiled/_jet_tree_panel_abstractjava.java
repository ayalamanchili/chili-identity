package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_tree_panel_abstractjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_tree_panel_abstractjava() {
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
    private static final TagInfo _td_c_iterate_13_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            13, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_15_2 = new TagInfo("c:if", //$NON-NLS-1$
            15, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_16_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            16, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_17_6 = new TagInfo("c:if", //$NON-NLS-1$
            17, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_18_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            18, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@name", //$NON-NLS-1$
                "parentClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_19_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            19, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
                "isChild", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_25_1 = new TagInfo("c:choose", //$NON-NLS-1$
            25, 1,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$isChild", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_25_31 = new TagInfo("c:when", //$NON-NLS-1$
            25, 31,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_26_1 = new TagInfo("f:message", //$NON-NLS-1$
            26, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_choose_27_65 = new TagInfo("c:choose", //$NON-NLS-1$
            27, 65,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$isChild", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_27_95 = new TagInfo("c:when", //$NON-NLS-1$
            27, 95,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_27_179 = new TagInfo("c:otherwise", //$NON-NLS-1$
            27, 179,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_28_1 = new TagInfo("f:message", //$NON-NLS-1$
            28, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_30_1 = new TagInfo("f:message", //$NON-NLS-1$
            30, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_34_1 = new TagInfo("f:message", //$NON-NLS-1$
            34, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_38_1 = new TagInfo("f:message", //$NON-NLS-1$
            38, 1,
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
    private static final TagInfo _td_f_message_42_1 = new TagInfo("f:message", //$NON-NLS-1$
            42, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_44_1 = new TagInfo("f:message", //$NON-NLS-1$
            44, 1,
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
                out.write("import info.yalamanchili.gwt.composite.TreePanelCompositey;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.web.bindery.requestfactory.shared.Receiver;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                // Check inheritance support
                RuntimeTagElement _jettag_c_iterate_13_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_13_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_13_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_13_1.setTagInfo(_td_c_iterate_13_1);
                _jettag_c_iterate_13_1.doStart(context, out);
                while (_jettag_c_iterate_13_1.okToProcessBody()) {
                    // if child class
                    RuntimeTagElement _jettag_c_if_15_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_15_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_15_2.setRuntimeParent(_jettag_c_iterate_13_1);
                    _jettag_c_if_15_2.setTagInfo(_td_c_if_15_2);
                    _jettag_c_if_15_2.doStart(context, out);
                    while (_jettag_c_if_15_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_16_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_16_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_16_3.setRuntimeParent(_jettag_c_if_15_2);
                        _jettag_c_iterate_16_3.setTagInfo(_td_c_iterate_16_3);
                        _jettag_c_iterate_16_3.doStart(context, out);
                        while (_jettag_c_iterate_16_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_17_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_17_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_17_6.setRuntimeParent(_jettag_c_iterate_16_3);
                            _jettag_c_if_17_6.setTagInfo(_td_c_if_17_6);
                            _jettag_c_if_17_6.doStart(context, out);
                            while (_jettag_c_if_17_6.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_18_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_18_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_18_6.setRuntimeParent(_jettag_c_if_17_6);
                                _jettag_c_setVariable_18_6.setTagInfo(_td_c_setVariable_18_6);
                                _jettag_c_setVariable_18_6.doStart(context, out);
                                _jettag_c_setVariable_18_6.doEnd();
                                RuntimeTagElement _jettag_c_setVariable_19_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_19_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_19_6.setRuntimeParent(_jettag_c_if_17_6);
                                _jettag_c_setVariable_19_6.setTagInfo(_td_c_setVariable_19_6);
                                _jettag_c_setVariable_19_6.doStart(context, out);
                                _jettag_c_setVariable_19_6.doEnd();
                                _jettag_c_if_17_6.handleBodyContent(out);
                            }
                            _jettag_c_if_17_6.doEnd();
                            _jettag_c_iterate_16_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_16_3.doEnd();
                        _jettag_c_if_15_2.handleBodyContent(out);
                    }
                    _jettag_c_if_15_2.doEnd();
                    _jettag_c_iterate_13_1.handleBodyContent(out);
                }
                _jettag_c_iterate_13_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_c_choose_25_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_25_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_25_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_choose_25_1.setTagInfo(_td_c_choose_25_1);
                _jettag_c_choose_25_1.doStart(context, out);
                JET2Writer _jettag_c_choose_25_1_saved_out = out;
                while (_jettag_c_choose_25_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(" ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_25_31 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_25_31); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_25_31.setRuntimeParent(_jettag_c_choose_25_1);
                    _jettag_c_when_25_31.setTagInfo(_td_c_when_25_31);
                    _jettag_c_when_25_31.doStart(context, out);
                    JET2Writer _jettag_c_when_25_31_saved_out = out;
                    while (_jettag_c_when_25_31.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" import ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$groupID}", 25, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".client.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 25, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($parentClass)}", 25, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".TreeAbstract");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$parentClass}", 25, 157)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("Panely; ");  //$NON-NLS-1$        
                        _jettag_c_when_25_31.handleBodyContent(out);
                    }
                    out = _jettag_c_when_25_31_saved_out;
                    _jettag_c_when_25_31.doEnd();
                    out.write("   ");  //$NON-NLS-1$        
                    _jettag_c_choose_25_1.handleBodyContent(out);
                }
                out = _jettag_c_choose_25_1_saved_out;
                _jettag_c_choose_25_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_26_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_26_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_26_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_26_1.setTagInfo(_td_f_message_26_1);
                _jettag_f_message_26_1.doStart(context, out);
                JET2Writer _jettag_f_message_26_1_saved_out = out;
                while (_jettag_f_message_26_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_26_1.handleBodyContent(out);
                }
                out = _jettag_f_message_26_1_saved_out;
                _jettag_f_message_26_1.doEnd();
                out.write(NL);         
                out.write("public abstract class TreeAbstract");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 27, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely extends ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_choose_27_65 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_27_65); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_27_65.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_choose_27_65.setTagInfo(_td_c_choose_27_65);
                _jettag_c_choose_27_65.doStart(context, out);
                JET2Writer _jettag_c_choose_27_65_saved_out = out;
                while (_jettag_c_choose_27_65.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(" ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_27_95 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_27_95); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_27_95.setRuntimeParent(_jettag_c_choose_27_65);
                    _jettag_c_when_27_95.setTagInfo(_td_c_when_27_95);
                    _jettag_c_when_27_95.doStart(context, out);
                    JET2Writer _jettag_c_when_27_95_saved_out = out;
                    while (_jettag_c_when_27_95.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" TreePanelCompositey<");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$class/@name}", 27, 147)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("Proxy> ");  //$NON-NLS-1$        
                        _jettag_c_when_27_95.handleBodyContent(out);
                    }
                    out = _jettag_c_when_27_95_saved_out;
                    _jettag_c_when_27_95.doEnd();
                    out.write(" ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_otherwise_27_179 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_27_179); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_27_179.setRuntimeParent(_jettag_c_choose_27_65);
                    _jettag_c_otherwise_27_179.setTagInfo(_td_c_otherwise_27_179);
                    _jettag_c_otherwise_27_179.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_27_179_saved_out = out;
                    while (_jettag_c_otherwise_27_179.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" TreeAbstract");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$parentClass}", 27, 205)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("Panely");  //$NON-NLS-1$        
                        _jettag_c_otherwise_27_179.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_27_179_saved_out;
                    _jettag_c_otherwise_27_179.doEnd();
                    out.write("  ");  //$NON-NLS-1$        
                    _jettag_c_choose_27_65.handleBodyContent(out);
                }
                out = _jettag_c_choose_27_65_saved_out;
                _jettag_c_choose_27_65.doEnd();
                out.write(" {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_28_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_28_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_28_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_28_1.setTagInfo(_td_f_message_28_1);
                _jettag_f_message_28_1.doStart(context, out);
                JET2Writer _jettag_f_message_28_1_saved_out = out;
                while (_jettag_f_message_28_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_28_1.handleBodyContent(out);
                }
                out = _jettag_f_message_28_1_saved_out;
                _jettag_f_message_28_1.doEnd();
                out.write(NL);         
                out.write("private static TreeAbstract");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 29, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely instance;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_30_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_30_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_30_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_30_1.setTagInfo(_td_f_message_30_1);
                _jettag_f_message_30_1.doStart(context, out);
                JET2Writer _jettag_f_message_30_1_saved_out = out;
                while (_jettag_f_message_30_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_30_1.handleBodyContent(out);
                }
                out = _jettag_f_message_30_1_saved_out;
                _jettag_f_message_30_1.doEnd();
                out.write(NL);         
                out.write("\tpublic static TreeAbstract");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 31, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely instance() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn instance;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_34_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_34_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_34_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_34_1.setTagInfo(_td_f_message_34_1);
                _jettag_f_message_34_1.doStart(context, out);
                JET2Writer _jettag_f_message_34_1_saved_out = out;
                while (_jettag_f_message_34_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_34_1.handleBodyContent(out);
                }
                out = _jettag_f_message_34_1_saved_out;
                _jettag_f_message_34_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic TreeAbstract");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 35, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tinstance=this;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_38_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_38_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_38_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_38_1.setTagInfo(_td_f_message_38_1);
                _jettag_f_message_38_1.doStart(context, out);
                JET2Writer _jettag_f_message_38_1_saved_out = out;
                while (_jettag_f_message_38_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_38_1.handleBodyContent(out);
                }
                out = _jettag_f_message_38_1_saved_out;
                _jettag_f_message_38_1.doEnd();
                out.write(NL);         
                out.write("\tprotected abstract void addListeners();");  //$NON-NLS-1$        
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
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected abstract void addWidgets();");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_42_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_42_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_42_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_42_1.setTagInfo(_td_f_message_42_1);
                _jettag_f_message_42_1.doStart(context, out);
                JET2Writer _jettag_f_message_42_1_saved_out = out;
                while (_jettag_f_message_42_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_42_1.handleBodyContent(out);
                }
                out = _jettag_f_message_42_1_saved_out;
                _jettag_f_message_42_1.doEnd();
                out.write(NL);         
                out.write("\tprotected abstract void configure() ;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_44_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_44_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_44_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_44_1.setTagInfo(_td_f_message_44_1);
                _jettag_f_message_44_1.doStart(context, out);
                JET2Writer _jettag_f_message_44_1_saved_out = out;
                while (_jettag_f_message_44_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_44_1.handleBodyContent(out);
                }
                out = _jettag_f_message_44_1_saved_out;
                _jettag_f_message_44_1.doEnd();
                out.write(NL);         
                out.write("\tpublic abstract void loadProxyAndRequest();");  //$NON-NLS-1$        
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
