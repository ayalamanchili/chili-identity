package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_class_associations implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_class_associations() {
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
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_3_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            3, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection/AssociationEnd", //$NON-NLS-1$
                "association_end1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_5_2 = new TagInfo("c:setVariable", //$NON-NLS-1$
            5, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_end1/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "class1_ID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_6_2 = new TagInfo("c:set", //$NON-NLS-1$
            6, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$association", //$NON-NLS-1$
                "class1XMIID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_8_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            8, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_9_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            9, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_10_4 = new TagInfo("c:if", //$NON-NLS-1$
            10, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class1_ID = $class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_11_4 = new TagInfo("c:set", //$NON-NLS-1$
            11, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$association", //$NON-NLS-1$
                "class1Name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_16_4 = new TagInfo("c:if", //$NON-NLS-1$
            16, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_end1/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = '1'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_17_4 = new TagInfo("c:if", //$NON-NLS-1$
            17, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_end1/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = '1'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_18_4 = new TagInfo("c:set", //$NON-NLS-1$
            18, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$association", //$NON-NLS-1$
                "class1Cardinality", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_21_4 = new TagInfo("c:if", //$NON-NLS-1$
            21, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_end1/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = '0'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_22_4 = new TagInfo("c:if", //$NON-NLS-1$
            22, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_end1/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = '-1'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_23_4 = new TagInfo("c:set", //$NON-NLS-1$
            23, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$association", //$NON-NLS-1$
                "class1Cardinality", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_27_4 = new TagInfo("c:set", //$NON-NLS-1$
            27, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$association", //$NON-NLS-1$
                "class1Type", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_29_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            29, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection/AssociationEnd", //$NON-NLS-1$
                "association_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_31_3 = new TagInfo("c:if", //$NON-NLS-1$
            31, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_end1/@xmi.id = $association_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_33_3 = new TagInfo("c:setVariable", //$NON-NLS-1$
            33, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "class2_ID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_34_3 = new TagInfo("c:set", //$NON-NLS-1$
            34, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$association", //$NON-NLS-1$
                "class2XMIID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_36_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            36, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_37_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            37, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_38_5 = new TagInfo("c:if", //$NON-NLS-1$
            38, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2_ID = $class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_39_5 = new TagInfo("c:set", //$NON-NLS-1$
            39, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$association", //$NON-NLS-1$
                "class2Name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_44_5 = new TagInfo("c:if", //$NON-NLS-1$
            44, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = '1'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_45_5 = new TagInfo("c:if", //$NON-NLS-1$
            45, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = '1'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_46_5 = new TagInfo("c:set", //$NON-NLS-1$
            46, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$association", //$NON-NLS-1$
                "class2Cardinality", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_49_5 = new TagInfo("c:if", //$NON-NLS-1$
            49, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = '0'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_50_5 = new TagInfo("c:if", //$NON-NLS-1$
            50, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = '-1'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_51_5 = new TagInfo("c:set", //$NON-NLS-1$
            51, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$association", //$NON-NLS-1$
                "class2Cardinality", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_55_5 = new TagInfo("c:set", //$NON-NLS-1$
            55, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$association", //$NON-NLS-1$
                "class2Type", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        // process associations
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
                //process  class1 of the association 
                RuntimeTagElement _jettag_c_setVariable_5_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_5_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_5_2.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_setVariable_5_2.setTagInfo(_td_c_setVariable_5_2);
                _jettag_c_setVariable_5_2.doStart(context, out);
                _jettag_c_setVariable_5_2.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_set_6_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_6_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_set_6_2.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_set_6_2.setTagInfo(_td_c_set_6_2);
                _jettag_c_set_6_2.doStart(context, out);
                JET2Writer _jettag_c_set_6_2_saved_out = out;
                while (_jettag_c_set_6_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(context.embeddedExpressionAsString("${$class1_ID}", 6, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_set_6_2.handleBodyContent(out);
                }
                out = _jettag_c_set_6_2_saved_out;
                _jettag_c_set_6_2.doEnd();
                out.write(NL);         
                //iterated over classes to get the class name from xmi.id 
                RuntimeTagElement _jettag_c_iterate_8_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_8_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_8_3.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_iterate_8_3.setTagInfo(_td_c_iterate_8_3);
                _jettag_c_iterate_8_3.doStart(context, out);
                while (_jettag_c_iterate_8_3.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_9_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_9_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_9_4.setRuntimeParent(_jettag_c_iterate_8_3);
                    _jettag_c_iterate_9_4.setTagInfo(_td_c_iterate_9_4);
                    _jettag_c_iterate_9_4.doStart(context, out);
                    while (_jettag_c_iterate_9_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_10_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_10_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_10_4.setRuntimeParent(_jettag_c_iterate_9_4);
                        _jettag_c_if_10_4.setTagInfo(_td_c_if_10_4);
                        _jettag_c_if_10_4.doStart(context, out);
                        while (_jettag_c_if_10_4.okToProcessBody()) {
                            out.write("\t\t\t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_set_11_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_11_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_set_11_4.setRuntimeParent(_jettag_c_if_10_4);
                            _jettag_c_set_11_4.setTagInfo(_td_c_set_11_4);
                            _jettag_c_set_11_4.doStart(context, out);
                            JET2Writer _jettag_c_set_11_4_saved_out = out;
                            while (_jettag_c_set_11_4.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(context.embeddedExpressionAsString("${$class/@name}", 11, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_set_11_4.handleBodyContent(out);
                            }
                            out = _jettag_c_set_11_4_saved_out;
                            _jettag_c_set_11_4.doEnd();
                            out.write(NL);         
                            _jettag_c_if_10_4.handleBodyContent(out);
                        }
                        _jettag_c_if_10_4.doEnd();
                        _jettag_c_iterate_9_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_9_4.doEnd();
                    _jettag_c_iterate_8_3.handleBodyContent(out);
                }
                _jettag_c_iterate_8_3.doEnd();
                //get class multiplicity range information 
                RuntimeTagElement _jettag_c_if_16_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_16_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_16_4.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_if_16_4.setTagInfo(_td_c_if_16_4);
                _jettag_c_if_16_4.doStart(context, out);
                while (_jettag_c_if_16_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_if_17_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_17_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_17_4.setRuntimeParent(_jettag_c_if_16_4);
                    _jettag_c_if_17_4.setTagInfo(_td_c_if_17_4);
                    _jettag_c_if_17_4.doStart(context, out);
                    while (_jettag_c_if_17_4.okToProcessBody()) {
                        out.write("\t\t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_set_18_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_18_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_set_18_4.setRuntimeParent(_jettag_c_if_17_4);
                        _jettag_c_set_18_4.setTagInfo(_td_c_set_18_4);
                        _jettag_c_set_18_4.doStart(context, out);
                        JET2Writer _jettag_c_set_18_4_saved_out = out;
                        while (_jettag_c_set_18_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("OneToOne");  //$NON-NLS-1$        
                            _jettag_c_set_18_4.handleBodyContent(out);
                        }
                        out = _jettag_c_set_18_4_saved_out;
                        _jettag_c_set_18_4.doEnd();
                        out.write(NL);         
                        _jettag_c_if_17_4.handleBodyContent(out);
                    }
                    _jettag_c_if_17_4.doEnd();
                    _jettag_c_if_16_4.handleBodyContent(out);
                }
                _jettag_c_if_16_4.doEnd();
                RuntimeTagElement _jettag_c_if_21_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_21_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_21_4.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_if_21_4.setTagInfo(_td_c_if_21_4);
                _jettag_c_if_21_4.doStart(context, out);
                while (_jettag_c_if_21_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_if_22_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_22_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_22_4.setRuntimeParent(_jettag_c_if_21_4);
                    _jettag_c_if_22_4.setTagInfo(_td_c_if_22_4);
                    _jettag_c_if_22_4.doStart(context, out);
                    while (_jettag_c_if_22_4.okToProcessBody()) {
                        out.write("\t\t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_set_23_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_23_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_set_23_4.setRuntimeParent(_jettag_c_if_22_4);
                        _jettag_c_set_23_4.setTagInfo(_td_c_set_23_4);
                        _jettag_c_set_23_4.doStart(context, out);
                        JET2Writer _jettag_c_set_23_4_saved_out = out;
                        while (_jettag_c_set_23_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("ZeroToMany");  //$NON-NLS-1$        
                            _jettag_c_set_23_4.handleBodyContent(out);
                        }
                        out = _jettag_c_set_23_4_saved_out;
                        _jettag_c_set_23_4.doEnd();
                        out.write(NL);         
                        _jettag_c_if_22_4.handleBodyContent(out);
                    }
                    _jettag_c_if_22_4.doEnd();
                    _jettag_c_if_21_4.handleBodyContent(out);
                }
                _jettag_c_if_21_4.doEnd();
                //process class association types 
                out.write("\t\t\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_set_27_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_27_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_set_27_4.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_set_27_4.setTagInfo(_td_c_set_27_4);
                _jettag_c_set_27_4.doStart(context, out);
                JET2Writer _jettag_c_set_27_4_saved_out = out;
                while (_jettag_c_set_27_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(context.embeddedExpressionAsString("${$association_end1/@aggregation}", 27, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_set_27_4.handleBodyContent(out);
                }
                out = _jettag_c_set_27_4_saved_out;
                _jettag_c_set_27_4.doEnd();
                out.write("\t\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                // iterate over the ends to get class 2
                RuntimeTagElement _jettag_c_iterate_29_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_29_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_29_3.setRuntimeParent(_jettag_c_iterate_3_2);
                _jettag_c_iterate_29_3.setTagInfo(_td_c_iterate_29_3);
                _jettag_c_iterate_29_3.doStart(context, out);
                while (_jettag_c_iterate_29_3.okToProcessBody()) {
                    //test to get second end of association 
                    RuntimeTagElement _jettag_c_if_31_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_31_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_31_3.setRuntimeParent(_jettag_c_iterate_29_3);
                    _jettag_c_if_31_3.setTagInfo(_td_c_if_31_3);
                    _jettag_c_if_31_3.doStart(context, out);
                    while (_jettag_c_if_31_3.okToProcessBody()) {
                        // process class 2 of associaton
                        RuntimeTagElement _jettag_c_setVariable_33_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_33_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_33_3.setRuntimeParent(_jettag_c_if_31_3);
                        _jettag_c_setVariable_33_3.setTagInfo(_td_c_setVariable_33_3);
                        _jettag_c_setVariable_33_3.doStart(context, out);
                        _jettag_c_setVariable_33_3.doEnd();
                        out.write("\t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_set_34_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_34_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_set_34_3.setRuntimeParent(_jettag_c_if_31_3);
                        _jettag_c_set_34_3.setTagInfo(_td_c_set_34_3);
                        _jettag_c_set_34_3.doStart(context, out);
                        JET2Writer _jettag_c_set_34_3_saved_out = out;
                        while (_jettag_c_set_34_3.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(context.embeddedExpressionAsString("${$class2_ID}", 34, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_set_34_3.handleBodyContent(out);
                        }
                        out = _jettag_c_set_34_3_saved_out;
                        _jettag_c_set_34_3.doEnd();
                        out.write(NL);         
                        //iterated over classes to get the class name from xmi.id 
                        RuntimeTagElement _jettag_c_iterate_36_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_36_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_36_4.setRuntimeParent(_jettag_c_if_31_3);
                        _jettag_c_iterate_36_4.setTagInfo(_td_c_iterate_36_4);
                        _jettag_c_iterate_36_4.doStart(context, out);
                        while (_jettag_c_iterate_36_4.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_37_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_37_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_37_5.setRuntimeParent(_jettag_c_iterate_36_4);
                            _jettag_c_iterate_37_5.setTagInfo(_td_c_iterate_37_5);
                            _jettag_c_iterate_37_5.doStart(context, out);
                            while (_jettag_c_iterate_37_5.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_38_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_38_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_38_5.setRuntimeParent(_jettag_c_iterate_37_5);
                                _jettag_c_if_38_5.setTagInfo(_td_c_if_38_5);
                                _jettag_c_if_38_5.doStart(context, out);
                                while (_jettag_c_if_38_5.okToProcessBody()) {
                                    out.write("\t\t\t\t");  //$NON-NLS-1$        
                                    RuntimeTagElement _jettag_c_set_39_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_39_5); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_set_39_5.setRuntimeParent(_jettag_c_if_38_5);
                                    _jettag_c_set_39_5.setTagInfo(_td_c_set_39_5);
                                    _jettag_c_set_39_5.doStart(context, out);
                                    JET2Writer _jettag_c_set_39_5_saved_out = out;
                                    while (_jettag_c_set_39_5.okToProcessBody()) {
                                        out = out.newNestedContentWriter();
                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 39, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_set_39_5.handleBodyContent(out);
                                    }
                                    out = _jettag_c_set_39_5_saved_out;
                                    _jettag_c_set_39_5.doEnd();
                                    out.write(NL);         
                                    _jettag_c_if_38_5.handleBodyContent(out);
                                }
                                _jettag_c_if_38_5.doEnd();
                                _jettag_c_iterate_37_5.handleBodyContent(out);
                            }
                            _jettag_c_iterate_37_5.doEnd();
                            _jettag_c_iterate_36_4.handleBodyContent(out);
                        }
                        _jettag_c_iterate_36_4.doEnd();
                        //get class multiplicity range information 
                        RuntimeTagElement _jettag_c_if_44_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_44_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_44_5.setRuntimeParent(_jettag_c_if_31_3);
                        _jettag_c_if_44_5.setTagInfo(_td_c_if_44_5);
                        _jettag_c_if_44_5.doStart(context, out);
                        while (_jettag_c_if_44_5.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_45_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_45_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_45_5.setRuntimeParent(_jettag_c_if_44_5);
                            _jettag_c_if_45_5.setTagInfo(_td_c_if_45_5);
                            _jettag_c_if_45_5.doStart(context, out);
                            while (_jettag_c_if_45_5.okToProcessBody()) {
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_c_set_46_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_46_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_set_46_5.setRuntimeParent(_jettag_c_if_45_5);
                                _jettag_c_set_46_5.setTagInfo(_td_c_set_46_5);
                                _jettag_c_set_46_5.doStart(context, out);
                                JET2Writer _jettag_c_set_46_5_saved_out = out;
                                while (_jettag_c_set_46_5.okToProcessBody()) {
                                    out = out.newNestedContentWriter();
                                    out.write("OneToOne");  //$NON-NLS-1$        
                                    _jettag_c_set_46_5.handleBodyContent(out);
                                }
                                out = _jettag_c_set_46_5_saved_out;
                                _jettag_c_set_46_5.doEnd();
                                out.write(NL);         
                                _jettag_c_if_45_5.handleBodyContent(out);
                            }
                            _jettag_c_if_45_5.doEnd();
                            _jettag_c_if_44_5.handleBodyContent(out);
                        }
                        _jettag_c_if_44_5.doEnd();
                        RuntimeTagElement _jettag_c_if_49_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_49_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_49_5.setRuntimeParent(_jettag_c_if_31_3);
                        _jettag_c_if_49_5.setTagInfo(_td_c_if_49_5);
                        _jettag_c_if_49_5.doStart(context, out);
                        while (_jettag_c_if_49_5.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_50_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_50_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_50_5.setRuntimeParent(_jettag_c_if_49_5);
                            _jettag_c_if_50_5.setTagInfo(_td_c_if_50_5);
                            _jettag_c_if_50_5.doStart(context, out);
                            while (_jettag_c_if_50_5.okToProcessBody()) {
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                RuntimeTagElement _jettag_c_set_51_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_51_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_set_51_5.setRuntimeParent(_jettag_c_if_50_5);
                                _jettag_c_set_51_5.setTagInfo(_td_c_set_51_5);
                                _jettag_c_set_51_5.doStart(context, out);
                                JET2Writer _jettag_c_set_51_5_saved_out = out;
                                while (_jettag_c_set_51_5.okToProcessBody()) {
                                    out = out.newNestedContentWriter();
                                    out.write("ZeroToMany");  //$NON-NLS-1$        
                                    _jettag_c_set_51_5.handleBodyContent(out);
                                }
                                out = _jettag_c_set_51_5_saved_out;
                                _jettag_c_set_51_5.doEnd();
                                out.write(NL);         
                                _jettag_c_if_50_5.handleBodyContent(out);
                            }
                            _jettag_c_if_50_5.doEnd();
                            _jettag_c_if_49_5.handleBodyContent(out);
                        }
                        _jettag_c_if_49_5.doEnd();
                        //process class association types 
                        out.write("\t\t\t\t");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_set_55_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_55_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_set_55_5.setRuntimeParent(_jettag_c_if_31_3);
                        _jettag_c_set_55_5.setTagInfo(_td_c_set_55_5);
                        _jettag_c_set_55_5.doStart(context, out);
                        JET2Writer _jettag_c_set_55_5_saved_out = out;
                        while (_jettag_c_set_55_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(context.embeddedExpressionAsString("${$association_end2/@aggregation}", 55, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_set_55_5.handleBodyContent(out);
                        }
                        out = _jettag_c_set_55_5_saved_out;
                        _jettag_c_set_55_5.doEnd();
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_if_31_3.handleBodyContent(out);
                    }
                    _jettag_c_if_31_3.doEnd();
                    _jettag_c_iterate_29_3.handleBodyContent(out);
                }
                _jettag_c_iterate_29_3.doEnd();
                _jettag_c_iterate_3_2.handleBodyContent(out);
            }
            _jettag_c_iterate_3_2.doEnd();
            _jettag_c_iterate_2_1.handleBodyContent(out);
        }
        _jettag_c_iterate_2_1.doEnd();
    }
}
