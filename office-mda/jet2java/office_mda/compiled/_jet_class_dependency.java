package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_class_dependency implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_class_dependency() {
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
    private static final TagInfo _td_c_iterate_4_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            4, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_6_8 = new TagInfo("c:set", //$NON-NLS-1$
            6, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "isDependent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_7_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            7, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "isComposite", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_8_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            8, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_9_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            9, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_10_8 = new TagInfo("c:if", //$NON-NLS-1$
            10, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isAbstract = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_12_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            12, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_13_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            13, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_14_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            14, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_15_9 = new TagInfo("c:setVariable", //$NON-NLS-1$
            15, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_17_11 = new TagInfo("c:if", //$NON-NLS-1$
            17, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_19_17 = new TagInfo("c:iterate", //$NON-NLS-1$
            19, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_20_17 = new TagInfo("c:setVariable", //$NON-NLS-1$
            20, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_21_17 = new TagInfo("c:if", //$NON-NLS-1$
            21, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_23_17 = new TagInfo("c:if", //$NON-NLS-1$
            23, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_25_17 = new TagInfo("c:setVariable", //$NON-NLS-1$
            25, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
                "isComposite", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_35_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            35, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_36_6 = new TagInfo("c:if", //$NON-NLS-1$
            36, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.parent/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_38_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            38, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_42_8 = new TagInfo("c:if", //$NON-NLS-1$
            42, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isComposite = $class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_43_8 = new TagInfo("c:if", //$NON-NLS-1$
            43, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isParent = $class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_44_9 = new TagInfo("c:set", //$NON-NLS-1$
            44, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "isDependent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_47_8 = new TagInfo("c:if", //$NON-NLS-1$
            47, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($isComposite = $class/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_48_8 = new TagInfo("c:if", //$NON-NLS-1$
            48, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isParent = $class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_set_49_9 = new TagInfo("c:set", //$NON-NLS-1$
            49, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "name", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "isDependent", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        // Iterate through packages and classes and check if a class is a dependent or not 
        RuntimeTagElement _jettag_c_iterate_2_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_2_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_2_1.setRuntimeParent(null);
        _jettag_c_iterate_2_1.setTagInfo(_td_c_iterate_2_1);
        _jettag_c_iterate_2_1.doStart(context, out);
        while (_jettag_c_iterate_2_1.okToProcessBody()) {
            // iterate through class and add only non composite children and non parent
            RuntimeTagElement _jettag_c_iterate_4_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_4_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_4_5.setRuntimeParent(_jettag_c_iterate_2_1);
            _jettag_c_iterate_4_5.setTagInfo(_td_c_iterate_4_5);
            _jettag_c_iterate_4_5.doStart(context, out);
            while (_jettag_c_iterate_4_5.okToProcessBody()) {
                // Flag varibles
                out.write("    \t\t ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_set_6_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_6_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_set_6_8.setRuntimeParent(_jettag_c_iterate_4_5);
                _jettag_c_set_6_8.setTagInfo(_td_c_set_6_8);
                _jettag_c_set_6_8.doStart(context, out);
                JET2Writer _jettag_c_set_6_8_saved_out = out;
                while (_jettag_c_set_6_8.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("null");  //$NON-NLS-1$        
                    _jettag_c_set_6_8.handleBodyContent(out);
                }
                out = _jettag_c_set_6_8_saved_out;
                _jettag_c_set_6_8.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_c_setVariable_7_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_7_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_7_8.setRuntimeParent(_jettag_c_iterate_4_5);
                _jettag_c_setVariable_7_8.setTagInfo(_td_c_setVariable_7_8);
                _jettag_c_setVariable_7_8.doStart(context, out);
                _jettag_c_setVariable_7_8.doEnd();
                RuntimeTagElement _jettag_c_setVariable_8_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_8_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_8_8.setRuntimeParent(_jettag_c_iterate_4_5);
                _jettag_c_setVariable_8_8.setTagInfo(_td_c_setVariable_8_8);
                _jettag_c_setVariable_8_8.doStart(context, out);
                _jettag_c_setVariable_8_8.doEnd();
                RuntimeTagElement _jettag_c_setVariable_9_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_9_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_9_8.setRuntimeParent(_jettag_c_iterate_4_5);
                _jettag_c_setVariable_9_8.setTagInfo(_td_c_setVariable_9_8);
                _jettag_c_setVariable_9_8.doStart(context, out);
                _jettag_c_setVariable_9_8.doEnd();
                RuntimeTagElement _jettag_c_if_10_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_10_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_10_8.setRuntimeParent(_jettag_c_iterate_4_5);
                _jettag_c_if_10_8.setTagInfo(_td_c_if_10_8);
                _jettag_c_if_10_8.doStart(context, out);
                while (_jettag_c_if_10_8.okToProcessBody()) {
                    // process all associations to eliminate composite children
                    RuntimeTagElement _jettag_c_iterate_12_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_12_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_12_6.setRuntimeParent(_jettag_c_if_10_8);
                    _jettag_c_iterate_12_6.setTagInfo(_td_c_iterate_12_6);
                    _jettag_c_iterate_12_6.doStart(context, out);
                    while (_jettag_c_iterate_12_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_13_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_13_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_13_7.setRuntimeParent(_jettag_c_iterate_12_6);
                        _jettag_c_iterate_13_7.setTagInfo(_td_c_iterate_13_7);
                        _jettag_c_iterate_13_7.doStart(context, out);
                        while (_jettag_c_iterate_13_7.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_14_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_14_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_14_8.setRuntimeParent(_jettag_c_iterate_13_7);
                            _jettag_c_iterate_14_8.setTagInfo(_td_c_iterate_14_8);
                            _jettag_c_iterate_14_8.doStart(context, out);
                            while (_jettag_c_iterate_14_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_15_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_15_9); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_15_9.setRuntimeParent(_jettag_c_iterate_14_8);
                                _jettag_c_setVariable_15_9.setTagInfo(_td_c_setVariable_15_9);
                                _jettag_c_setVariable_15_9.doStart(context, out);
                                _jettag_c_setVariable_15_9.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_17_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_17_11); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_17_11.setRuntimeParent(_jettag_c_iterate_14_8);
                                _jettag_c_if_17_11.setTagInfo(_td_c_if_17_11);
                                _jettag_c_if_17_11.doStart(context, out);
                                while (_jettag_c_if_17_11.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_19_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_19_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_19_17.setRuntimeParent(_jettag_c_if_17_11);
                                    _jettag_c_iterate_19_17.setTagInfo(_td_c_iterate_19_17);
                                    _jettag_c_iterate_19_17.doStart(context, out);
                                    while (_jettag_c_iterate_19_17.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_20_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_20_17); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_20_17.setRuntimeParent(_jettag_c_iterate_19_17);
                                        _jettag_c_setVariable_20_17.setTagInfo(_td_c_setVariable_20_17);
                                        _jettag_c_setVariable_20_17.doStart(context, out);
                                        _jettag_c_setVariable_20_17.doEnd();
                                        RuntimeTagElement _jettag_c_if_21_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_21_17); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_21_17.setRuntimeParent(_jettag_c_iterate_19_17);
                                        _jettag_c_if_21_17.setTagInfo(_td_c_if_21_17);
                                        _jettag_c_if_21_17.doStart(context, out);
                                        while (_jettag_c_if_21_17.okToProcessBody()) {
                                            // process only non compositions
                                            RuntimeTagElement _jettag_c_if_23_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_23_17); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_23_17.setRuntimeParent(_jettag_c_if_21_17);
                                            _jettag_c_if_23_17.setTagInfo(_td_c_if_23_17);
                                            _jettag_c_if_23_17.doStart(context, out);
                                            while (_jettag_c_if_23_17.okToProcessBody()) {
                                                // update flag variable
                                                RuntimeTagElement _jettag_c_setVariable_25_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_25_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_25_17.setRuntimeParent(_jettag_c_if_23_17);
                                                _jettag_c_setVariable_25_17.setTagInfo(_td_c_setVariable_25_17);
                                                _jettag_c_setVariable_25_17.doStart(context, out);
                                                _jettag_c_setVariable_25_17.doEnd();
                                                _jettag_c_if_23_17.handleBodyContent(out);
                                            }
                                            _jettag_c_if_23_17.doEnd();
                                            _jettag_c_if_21_17.handleBodyContent(out);
                                        }
                                        _jettag_c_if_21_17.doEnd();
                                        _jettag_c_iterate_19_17.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_19_17.doEnd();
                                    _jettag_c_if_17_11.handleBodyContent(out);
                                }
                                _jettag_c_if_17_11.doEnd();
                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_iterate_14_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_14_8.doEnd();
                            _jettag_c_iterate_13_7.handleBodyContent(out);
                        }
                        _jettag_c_iterate_13_7.doEnd();
                        _jettag_c_iterate_12_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_12_6.doEnd();
                    // process all generizations to eliminate all parent classes
                    RuntimeTagElement _jettag_c_iterate_35_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_35_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_35_5.setRuntimeParent(_jettag_c_if_10_8);
                    _jettag_c_iterate_35_5.setTagInfo(_td_c_iterate_35_5);
                    _jettag_c_iterate_35_5.doStart(context, out);
                    while (_jettag_c_iterate_35_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_36_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_36_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_36_6.setRuntimeParent(_jettag_c_iterate_35_5);
                        _jettag_c_if_36_6.setTagInfo(_td_c_if_36_6);
                        _jettag_c_if_36_6.doStart(context, out);
                        while (_jettag_c_if_36_6.okToProcessBody()) {
                            // update flag variable
                            RuntimeTagElement _jettag_c_setVariable_38_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_38_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_38_6.setRuntimeParent(_jettag_c_if_36_6);
                            _jettag_c_setVariable_38_6.setTagInfo(_td_c_setVariable_38_6);
                            _jettag_c_setVariable_38_6.doStart(context, out);
                            _jettag_c_setVariable_38_6.doEnd();
                            _jettag_c_if_36_6.handleBodyContent(out);
                        }
                        _jettag_c_if_36_6.doEnd();
                        _jettag_c_iterate_35_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_35_5.doEnd();
                    // check for flag varibles and add menu item class
                    RuntimeTagElement _jettag_c_if_42_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_42_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_42_8.setRuntimeParent(_jettag_c_if_10_8);
                    _jettag_c_if_42_8.setTagInfo(_td_c_if_42_8);
                    _jettag_c_if_42_8.doStart(context, out);
                    while (_jettag_c_if_42_8.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_43_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_43_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_43_8.setRuntimeParent(_jettag_c_if_42_8);
                        _jettag_c_if_43_8.setTagInfo(_td_c_if_43_8);
                        _jettag_c_if_43_8.doStart(context, out);
                        while (_jettag_c_if_43_8.okToProcessBody()) {
                            out.write("    \t\t \t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_set_44_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_44_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_set_44_9.setRuntimeParent(_jettag_c_if_43_8);
                            _jettag_c_set_44_9.setTagInfo(_td_c_set_44_9);
                            _jettag_c_set_44_9.doStart(context, out);
                            JET2Writer _jettag_c_set_44_9_saved_out = out;
                            while (_jettag_c_set_44_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("false");  //$NON-NLS-1$        
                                _jettag_c_set_44_9.handleBodyContent(out);
                            }
                            out = _jettag_c_set_44_9_saved_out;
                            _jettag_c_set_44_9.doEnd();
                            out.write(NL);         
                            _jettag_c_if_43_8.handleBodyContent(out);
                        }
                        _jettag_c_if_43_8.doEnd();
                        _jettag_c_if_42_8.handleBodyContent(out);
                    }
                    _jettag_c_if_42_8.doEnd();
                    RuntimeTagElement _jettag_c_if_47_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_47_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_47_8.setRuntimeParent(_jettag_c_if_10_8);
                    _jettag_c_if_47_8.setTagInfo(_td_c_if_47_8);
                    _jettag_c_if_47_8.doStart(context, out);
                    while (_jettag_c_if_47_8.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_48_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_48_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_48_8.setRuntimeParent(_jettag_c_if_47_8);
                        _jettag_c_if_48_8.setTagInfo(_td_c_if_48_8);
                        _jettag_c_if_48_8.doStart(context, out);
                        while (_jettag_c_if_48_8.okToProcessBody()) {
                            out.write("    \t\t \t");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_set_49_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "set", "c:set", _td_c_set_49_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_set_49_9.setRuntimeParent(_jettag_c_if_48_8);
                            _jettag_c_set_49_9.setTagInfo(_td_c_set_49_9);
                            _jettag_c_set_49_9.doStart(context, out);
                            JET2Writer _jettag_c_set_49_9_saved_out = out;
                            while (_jettag_c_set_49_9.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("true");  //$NON-NLS-1$        
                                _jettag_c_set_49_9.handleBodyContent(out);
                            }
                            out = _jettag_c_set_49_9_saved_out;
                            _jettag_c_set_49_9.doEnd();
                            out.write(NL);         
                            _jettag_c_if_48_8.handleBodyContent(out);
                        }
                        _jettag_c_if_48_8.doEnd();
                        _jettag_c_if_47_8.handleBodyContent(out);
                    }
                    _jettag_c_if_47_8.doEnd();
                    _jettag_c_if_10_8.handleBodyContent(out);
                }
                _jettag_c_if_10_8.doEnd();
                _jettag_c_iterate_4_5.handleBodyContent(out);
            }
            _jettag_c_iterate_4_5.doEnd();
            _jettag_c_iterate_2_1.handleBodyContent(out);
        }
        _jettag_c_iterate_2_1.doEnd();
    }
}
