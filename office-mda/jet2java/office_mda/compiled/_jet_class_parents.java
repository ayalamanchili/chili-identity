package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_class_parents implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_class_parents() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_iterate_2_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            2, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_3_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            3, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_5_7 = new TagInfo("c:set", //$NON-NLS-1$
            5, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass1Name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_6_7 = new TagInfo("c:set", //$NON-NLS-1$
            6, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass2Name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_7_7 = new TagInfo("c:set", //$NON-NLS-1$
            7, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass1XMIID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_8_7 = new TagInfo("c:set", //$NON-NLS-1$
            8, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass2XMIID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_9_7 = new TagInfo("c:set", //$NON-NLS-1$
            9, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "hasChildren", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_10_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            10, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_11_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            11, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_12_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            12, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_14_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            14, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_16_4 = new TagInfo("c:if", //$NON-NLS-1$
            16, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.parent/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_17_4 = new TagInfo("c:set", //$NON-NLS-1$
            17, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "hasChildren", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_20_5 = new TagInfo("c:if", //$NON-NLS-1$
            20, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_21_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            21, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_22_9 = new TagInfo("c:if", //$NON-NLS-1$
            22, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_24_9 = new TagInfo("c:setVariable", //$NON-NLS-1$
            24, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass", //$NON-NLS-1$
                "parentClass1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_25_9 = new TagInfo("c:set", //$NON-NLS-1$
            25, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass1Name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_26_9 = new TagInfo("c:set", //$NON-NLS-1$
            26, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass1XMIID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_28_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            28, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_30_10 = new TagInfo("c:if", //$NON-NLS-1$
            30, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $parentClass1/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_31_11 = new TagInfo("c:iterate", //$NON-NLS-1$
            31, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_32_14 = new TagInfo("c:if", //$NON-NLS-1$
            32, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_34_14 = new TagInfo("c:setVariable", //$NON-NLS-1$
            34, 14,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_35_14 = new TagInfo("c:set", //$NON-NLS-1$
            35, 14,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass2Name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_36_14 = new TagInfo("c:set", //$NON-NLS-1$
            36, 14,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass2XMIID", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        // Iterate through packages and classes and set class relations for parent 1 and parent2
        RuntimeTagElement _jettag_c_iterate_2_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_2_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_2_1.setRuntimeParent(null);
        _jettag_c_iterate_2_1.setTagInfo(_td_c_iterate_2_1);
        _jettag_c_iterate_2_1.doStart(context, out);
        while (_jettag_c_iterate_2_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_3_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_3_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_3_2.setRuntimeParent(_jettag_c_iterate_2_1);
            _jettag_c_iterate_3_2.setTagInfo(_td_c_iterate_3_2);
            _jettag_c_iterate_3_2.doStart(context, out);
            while (_jettag_c_iterate_3_2.okToProcessBody()) {
                // process generizations upto 2 levels and get the parent classes if any
                out.write("    \t\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_set_5_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_5_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_set_5_7.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_set_5_7.setTagInfo(_td_c_set_5_7);
                _jettag_c_set_5_7.doStart(context, out);
                JET2Writer _jettag_c_set_5_7_saved_out = out;
                while (_jettag_c_set_5_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 5, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_set_5_7.handleBodyContent(out);
                }
                out = _jettag_c_set_5_7_saved_out;
                _jettag_c_set_5_7.doEnd();
                out.write(NL);         
                out.write("    \t\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_set_6_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_6_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_set_6_7.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_set_6_7.setTagInfo(_td_c_set_6_7);
                _jettag_c_set_6_7.doStart(context, out);
                JET2Writer _jettag_c_set_6_7_saved_out = out;
                while (_jettag_c_set_6_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 6, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_set_6_7.handleBodyContent(out);
                }
                out = _jettag_c_set_6_7_saved_out;
                _jettag_c_set_6_7.doEnd();
                out.write(NL);         
                out.write("    \t\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_set_7_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_7_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_set_7_7.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_set_7_7.setTagInfo(_td_c_set_7_7);
                _jettag_c_set_7_7.doStart(context, out);
                JET2Writer _jettag_c_set_7_7_saved_out = out;
                while (_jettag_c_set_7_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(context.embeddedExpressionAsString("${$class/@xmi.id}", 7, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_set_7_7.handleBodyContent(out);
                }
                out = _jettag_c_set_7_7_saved_out;
                _jettag_c_set_7_7.doEnd();
                out.write(NL);         
                out.write("    \t\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_set_8_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_8_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_set_8_7.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_set_8_7.setTagInfo(_td_c_set_8_7);
                _jettag_c_set_8_7.doStart(context, out);
                JET2Writer _jettag_c_set_8_7_saved_out = out;
                while (_jettag_c_set_8_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(context.embeddedExpressionAsString("${$class/@xmi.id}", 8, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_set_8_7.handleBodyContent(out);
                }
                out = _jettag_c_set_8_7_saved_out;
                _jettag_c_set_8_7.doEnd();
                out.write(NL);         
                out.write("    \t\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_set_9_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_9_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_set_9_7.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_set_9_7.setTagInfo(_td_c_set_9_7);
                _jettag_c_set_9_7.doStart(context, out);
                JET2Writer _jettag_c_set_9_7_saved_out = out;
                while (_jettag_c_set_9_7.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 9, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_set_9_7.handleBodyContent(out);
                }
                out = _jettag_c_set_9_7_saved_out;
                _jettag_c_set_9_7.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_c_setVariable_10_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_10_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_10_7.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_setVariable_10_7.setTagInfo(_td_c_setVariable_10_7);
                _jettag_c_setVariable_10_7.doStart(context, out);
                _jettag_c_setVariable_10_7.doEnd();
                RuntimeTagElement _jettag_c_setVariable_11_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_11_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_11_4.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_setVariable_11_4.setTagInfo(_td_c_setVariable_11_4);
                _jettag_c_setVariable_11_4.doStart(context, out);
                _jettag_c_setVariable_11_4.doEnd();
                RuntimeTagElement _jettag_c_setVariable_12_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_12_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_12_4.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_setVariable_12_4.setTagInfo(_td_c_setVariable_12_4);
                _jettag_c_setVariable_12_4.doStart(context, out);
                _jettag_c_setVariable_12_4.doEnd();
                //process generizations 
                RuntimeTagElement _jettag_c_iterate_14_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_14_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_14_4.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_iterate_14_4.setTagInfo(_td_c_iterate_14_4);
                _jettag_c_iterate_14_4.doStart(context, out);
                while (_jettag_c_iterate_14_4.okToProcessBody()) {
                    // check is this has children then check haschildren to @xmiidref
                    RuntimeTagElement _jettag_c_if_16_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_16_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_16_4.setRuntimeParent(_jettag_c_iterate_14_4);
                    _jettag_c_if_16_4.setTagInfo(_td_c_if_16_4);
                    _jettag_c_if_16_4.doStart(context, out);
                    while (_jettag_c_if_16_4.okToProcessBody()) {
                        out.write("\t\t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_set_17_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_17_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_set_17_4.setRuntimeParent(_jettag_c_if_16_4);
                        _jettag_c_set_17_4.setTagInfo(_td_c_set_17_4);
                        _jettag_c_set_17_4.doStart(context, out);
                        JET2Writer _jettag_c_set_17_4_saved_out = out;
                        while (_jettag_c_set_17_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(context.embeddedExpressionAsString("${$class/@xmi.id}", 17, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_set_17_4.handleBodyContent(out);
                        }
                        out = _jettag_c_set_17_4_saved_out;
                        _jettag_c_set_17_4.doEnd();
                        out.write(NL);         
                        _jettag_c_if_16_4.handleBodyContent(out);
                    }
                    _jettag_c_if_16_4.doEnd();
                    // if child class
                    RuntimeTagElement _jettag_c_if_20_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_20_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_20_5.setRuntimeParent(_jettag_c_iterate_14_4);
                    _jettag_c_if_20_5.setTagInfo(_td_c_if_20_5);
                    _jettag_c_if_20_5.doStart(context, out);
                    while (_jettag_c_if_20_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_21_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_21_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_21_6.setRuntimeParent(_jettag_c_if_20_5);
                        _jettag_c_iterate_21_6.setTagInfo(_td_c_iterate_21_6);
                        _jettag_c_iterate_21_6.doStart(context, out);
                        while (_jettag_c_iterate_21_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_22_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_22_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_22_9.setRuntimeParent(_jettag_c_iterate_21_6);
                            _jettag_c_if_22_9.setTagInfo(_td_c_if_22_9);
                            _jettag_c_if_22_9.doStart(context, out);
                            while (_jettag_c_if_22_9.okToProcessBody()) {
                                // get level 1 parent
                                RuntimeTagElement _jettag_c_setVariable_24_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_24_9); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_24_9.setRuntimeParent(_jettag_c_if_22_9);
                                _jettag_c_setVariable_24_9.setTagInfo(_td_c_setVariable_24_9);
                                _jettag_c_setVariable_24_9.doStart(context, out);
                                _jettag_c_setVariable_24_9.doEnd();
                                out.write("\t\t\t  \t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_c_set_25_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_25_9); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_set_25_9.setRuntimeParent(_jettag_c_if_22_9);
                                _jettag_c_set_25_9.setTagInfo(_td_c_set_25_9);
                                _jettag_c_set_25_9.doStart(context, out);
                                JET2Writer _jettag_c_set_25_9_saved_out = out;
                                while (_jettag_c_set_25_9.okToProcessBody()) {
                                    out = out.newNestedContentWriter();
                                    out.write(context.embeddedExpressionAsString("${$otherClass/@name}", 25, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_set_25_9.handleBodyContent(out);
                                }
                                out = _jettag_c_set_25_9_saved_out;
                                _jettag_c_set_25_9.doEnd();
                                out.write(NL);         
                                out.write("\t\t\t  \t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_c_set_26_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_26_9); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_set_26_9.setRuntimeParent(_jettag_c_if_22_9);
                                _jettag_c_set_26_9.setTagInfo(_td_c_set_26_9);
                                _jettag_c_set_26_9.doStart(context, out);
                                JET2Writer _jettag_c_set_26_9_saved_out = out;
                                while (_jettag_c_set_26_9.okToProcessBody()) {
                                    out = out.newNestedContentWriter();
                                    out.write(context.embeddedExpressionAsString("${$otherClass/@xmi.id}", 26, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_set_26_9.handleBodyContent(out);
                                }
                                out = _jettag_c_set_26_9_saved_out;
                                _jettag_c_set_26_9.doEnd();
                                out.write(NL);         
                                // second round to get level 2 
                                RuntimeTagElement _jettag_c_iterate_28_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_28_9); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_28_9.setRuntimeParent(_jettag_c_if_22_9);
                                _jettag_c_iterate_28_9.setTagInfo(_td_c_iterate_28_9);
                                _jettag_c_iterate_28_9.doStart(context, out);
                                while (_jettag_c_iterate_28_9.okToProcessBody()) {
                                    // if child class
                                    RuntimeTagElement _jettag_c_if_30_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_30_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_30_10.setRuntimeParent(_jettag_c_iterate_28_9);
                                    _jettag_c_if_30_10.setTagInfo(_td_c_if_30_10);
                                    _jettag_c_if_30_10.doStart(context, out);
                                    while (_jettag_c_if_30_10.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_iterate_31_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_31_11); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_31_11.setRuntimeParent(_jettag_c_if_30_10);
                                        _jettag_c_iterate_31_11.setTagInfo(_td_c_iterate_31_11);
                                        _jettag_c_iterate_31_11.doStart(context, out);
                                        while (_jettag_c_iterate_31_11.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_32_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_32_14); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_32_14.setRuntimeParent(_jettag_c_iterate_31_11);
                                            _jettag_c_if_32_14.setTagInfo(_td_c_if_32_14);
                                            _jettag_c_if_32_14.doStart(context, out);
                                            while (_jettag_c_if_32_14.okToProcessBody()) {
                                                // get level 2 parent
                                                RuntimeTagElement _jettag_c_setVariable_34_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_34_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_34_14.setRuntimeParent(_jettag_c_if_32_14);
                                                _jettag_c_setVariable_34_14.setTagInfo(_td_c_setVariable_34_14);
                                                _jettag_c_setVariable_34_14.doStart(context, out);
                                                _jettag_c_setVariable_34_14.doEnd();
                                                out.write("\t\t\t\t\t\t\t\t  \t\t\t");  //$NON-NLS-1$        
                                                RuntimeTagElement _jettag_c_set_35_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_35_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_set_35_14.setRuntimeParent(_jettag_c_if_32_14);
                                                _jettag_c_set_35_14.setTagInfo(_td_c_set_35_14);
                                                _jettag_c_set_35_14.doStart(context, out);
                                                JET2Writer _jettag_c_set_35_14_saved_out = out;
                                                while (_jettag_c_set_35_14.okToProcessBody()) {
                                                    out = out.newNestedContentWriter();
                                                    out.write(context.embeddedExpressionAsString("${$otherClass/@name}", 35, 61)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_set_35_14.handleBodyContent(out);
                                                }
                                                out = _jettag_c_set_35_14_saved_out;
                                                _jettag_c_set_35_14.doEnd();
                                                out.write(NL);         
                                                out.write("\t\t\t\t\t\t\t\t  \t\t\t");  //$NON-NLS-1$        
                                                RuntimeTagElement _jettag_c_set_36_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_36_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_set_36_14.setRuntimeParent(_jettag_c_if_32_14);
                                                _jettag_c_set_36_14.setTagInfo(_td_c_set_36_14);
                                                _jettag_c_set_36_14.doStart(context, out);
                                                JET2Writer _jettag_c_set_36_14_saved_out = out;
                                                while (_jettag_c_set_36_14.okToProcessBody()) {
                                                    out = out.newNestedContentWriter();
                                                    out.write(context.embeddedExpressionAsString("${$otherClass/@xmi.id}", 36, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_set_36_14.handleBodyContent(out);
                                                }
                                                out = _jettag_c_set_36_14_saved_out;
                                                _jettag_c_set_36_14.doEnd();
                                                out.write("\t  \t\t\t");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                _jettag_c_if_32_14.handleBodyContent(out);
                                            }
                                            _jettag_c_if_32_14.doEnd();
                                            _jettag_c_iterate_31_11.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_31_11.doEnd();
                                        _jettag_c_if_30_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_30_10.doEnd();
                                    _jettag_c_iterate_28_9.handleBodyContent(out);
                                }
                                _jettag_c_iterate_28_9.doEnd();
                                out.write("\t\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t \t\t\t\t");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_22_9.handleBodyContent(out);
                            }
                            _jettag_c_if_22_9.doEnd();
                            _jettag_c_iterate_21_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_21_6.doEnd();
                        _jettag_c_if_20_5.handleBodyContent(out);
                    }
                    _jettag_c_if_20_5.doEnd();
                    _jettag_c_iterate_14_4.handleBodyContent(out);
                }
                _jettag_c_iterate_14_4.doEnd();
                _jettag_c_iterate_3_2.handleBodyContent(out);
            }
            _jettag_c_iterate_3_2.doEnd();
            _jettag_c_iterate_2_1.handleBodyContent(out);
        }
        _jettag_c_iterate_2_1.doEnd();
    }
}
