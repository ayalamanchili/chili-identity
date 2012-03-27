package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_gwt_constantsproperties implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_gwt_constantsproperties() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_merge_1_1 = new TagInfo("java:merge", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_9_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            9, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_10_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            10, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "concat($webPackage,$package/@name)", //$NON-NLS-1$
                "packageName", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_11_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            11, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_14_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            14, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_15_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            15, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_16_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            16, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_18_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            18, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
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
    private static final TagInfo _td_c_iterate_26_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            26, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_28_10 = new TagInfo("c:if", //$NON-NLS-1$
            28, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.child/Class/@xmi.idref = $parentClass1/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_29_11 = new TagInfo("c:iterate", //$NON-NLS-1$
            29, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "otherClass", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_30_14 = new TagInfo("c:if", //$NON-NLS-1$
            30, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass/@xmi.id = $generalization/Generalization.parent/Class/@xmi.idref", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_32_14 = new TagInfo("c:setVariable", //$NON-NLS-1$
            32, 14,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$otherClass", //$NON-NLS-1$
                "parentClass2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_43_1 = new TagInfo("c:if", //$NON-NLS-1$
            43, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_44_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            44, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_49_1 = new TagInfo("c:if", //$NON-NLS-1$
            49, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_50_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            50, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_55_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            55, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_java_merge_1_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "merge", "java:merge", _td_java_merge_1_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_merge_1_1.setRuntimeParent(null);
        _jettag_java_merge_1_1.setTagInfo(_td_java_merge_1_1);
        _jettag_java_merge_1_1.doStart(context, out);
        _jettag_java_merge_1_1.doEnd();
        out.write(NL);         
        out.write("imagesTargetDirectory=/pictures/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("sessionTimeout=300000");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("tablePageSize=10");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#GENERAL");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("Table_Action=Action");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("#Class attributes");  //$NON-NLS-1$        
        out.write(NL);         
        // Iterate through packages and classes 
        RuntimeTagElement _jettag_c_iterate_9_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_9_6); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_9_6.setRuntimeParent(null);
        _jettag_c_iterate_9_6.setTagInfo(_td_c_iterate_9_6);
        _jettag_c_iterate_9_6.doStart(context, out);
        while (_jettag_c_iterate_9_6.okToProcessBody()) {
            RuntimeTagElement _jettag_c_setVariable_10_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_10_8); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_10_8.setRuntimeParent(_jettag_c_iterate_9_6);
            _jettag_c_setVariable_10_8.setTagInfo(_td_c_setVariable_10_8);
            _jettag_c_setVariable_10_8.doStart(context, out);
            _jettag_c_setVariable_10_8.doEnd();
            RuntimeTagElement _jettag_c_iterate_11_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_11_8); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_11_8.setRuntimeParent(_jettag_c_iterate_9_6);
            _jettag_c_iterate_11_8.setTagInfo(_td_c_iterate_11_8);
            _jettag_c_iterate_11_8.doStart(context, out);
            while (_jettag_c_iterate_11_8.okToProcessBody()) {
                out.write("#");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 12, 2)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\t    \t\t ");  //$NON-NLS-1$        
                out.write(NL);         
                // process generizations upto 2 levels and get teh parent classes if any
                RuntimeTagElement _jettag_c_setVariable_14_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_14_7); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_14_7.setRuntimeParent(_jettag_c_iterate_11_8);
                _jettag_c_setVariable_14_7.setTagInfo(_td_c_setVariable_14_7);
                _jettag_c_setVariable_14_7.doStart(context, out);
                _jettag_c_setVariable_14_7.doEnd();
                RuntimeTagElement _jettag_c_setVariable_15_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_15_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_15_4.setRuntimeParent(_jettag_c_iterate_11_8);
                _jettag_c_setVariable_15_4.setTagInfo(_td_c_setVariable_15_4);
                _jettag_c_setVariable_15_4.doStart(context, out);
                _jettag_c_setVariable_15_4.doEnd();
                RuntimeTagElement _jettag_c_setVariable_16_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_16_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_16_4.setRuntimeParent(_jettag_c_iterate_11_8);
                _jettag_c_setVariable_16_4.setTagInfo(_td_c_setVariable_16_4);
                _jettag_c_setVariable_16_4.doStart(context, out);
                _jettag_c_setVariable_16_4.doEnd();
                //process generizations 
                RuntimeTagElement _jettag_c_iterate_18_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_18_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_18_4.setRuntimeParent(_jettag_c_iterate_11_8);
                _jettag_c_iterate_18_4.setTagInfo(_td_c_iterate_18_4);
                _jettag_c_iterate_18_4.doStart(context, out);
                while (_jettag_c_iterate_18_4.okToProcessBody()) {
                    // if child class
                    RuntimeTagElement _jettag_c_if_20_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_20_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_20_5.setRuntimeParent(_jettag_c_iterate_18_4);
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
                                // second round to get level 2 
                                RuntimeTagElement _jettag_c_iterate_26_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_26_9); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_26_9.setRuntimeParent(_jettag_c_if_22_9);
                                _jettag_c_iterate_26_9.setTagInfo(_td_c_iterate_26_9);
                                _jettag_c_iterate_26_9.doStart(context, out);
                                while (_jettag_c_iterate_26_9.okToProcessBody()) {
                                    // if child class
                                    RuntimeTagElement _jettag_c_if_28_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_28_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_28_10.setRuntimeParent(_jettag_c_iterate_26_9);
                                    _jettag_c_if_28_10.setTagInfo(_td_c_if_28_10);
                                    _jettag_c_if_28_10.doStart(context, out);
                                    while (_jettag_c_if_28_10.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_iterate_29_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_29_11); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_29_11.setRuntimeParent(_jettag_c_if_28_10);
                                        _jettag_c_iterate_29_11.setTagInfo(_td_c_iterate_29_11);
                                        _jettag_c_iterate_29_11.doStart(context, out);
                                        while (_jettag_c_iterate_29_11.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_30_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_30_14); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_30_14.setRuntimeParent(_jettag_c_iterate_29_11);
                                            _jettag_c_if_30_14.setTagInfo(_td_c_if_30_14);
                                            _jettag_c_if_30_14.doStart(context, out);
                                            while (_jettag_c_if_30_14.okToProcessBody()) {
                                                // get level 2 parent
                                                RuntimeTagElement _jettag_c_setVariable_32_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_32_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_32_14.setRuntimeParent(_jettag_c_if_30_14);
                                                _jettag_c_setVariable_32_14.setTagInfo(_td_c_setVariable_32_14);
                                                _jettag_c_setVariable_32_14.doStart(context, out);
                                                _jettag_c_setVariable_32_14.doEnd();
                                                _jettag_c_if_30_14.handleBodyContent(out);
                                            }
                                            _jettag_c_if_30_14.doEnd();
                                            _jettag_c_iterate_29_11.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_29_11.doEnd();
                                        _jettag_c_if_28_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_28_10.doEnd();
                                    _jettag_c_iterate_26_9.handleBodyContent(out);
                                }
                                _jettag_c_iterate_26_9.doEnd();
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
                    _jettag_c_iterate_18_4.handleBodyContent(out);
                }
                _jettag_c_iterate_18_4.doEnd();
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_43_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_43_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_43_1.setRuntimeParent(_jettag_c_iterate_11_8);
                _jettag_c_if_43_1.setTagInfo(_td_c_if_43_1);
                _jettag_c_if_43_1.doStart(context, out);
                while (_jettag_c_if_43_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_44_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_44_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_44_1.setRuntimeParent(_jettag_c_if_43_1);
                    _jettag_c_iterate_44_1.setTagInfo(_td_c_iterate_44_1);
                    _jettag_c_iterate_44_1.doStart(context, out);
                    while (_jettag_c_iterate_44_1.okToProcessBody()) {
                        out.write(context.embeddedExpressionAsString("${$groupID}", 45, 1)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".entity.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$package/@name}", 45, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$class/@name}", 45, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 45, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("=");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst ($attribute/@name)}", 45, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(NL);         
                        _jettag_c_iterate_44_1.handleBodyContent(out);
                    }
                    _jettag_c_iterate_44_1.doEnd();
                    _jettag_c_if_43_1.handleBodyContent(out);
                }
                _jettag_c_if_43_1.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_49_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_49_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_49_1.setRuntimeParent(_jettag_c_iterate_11_8);
                _jettag_c_if_49_1.setTagInfo(_td_c_if_49_1);
                _jettag_c_if_49_1.doStart(context, out);
                while (_jettag_c_if_49_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_50_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_50_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_50_1.setRuntimeParent(_jettag_c_if_49_1);
                    _jettag_c_iterate_50_1.setTagInfo(_td_c_iterate_50_1);
                    _jettag_c_iterate_50_1.doStart(context, out);
                    while (_jettag_c_iterate_50_1.okToProcessBody()) {
                        out.write(context.embeddedExpressionAsString("${$groupID}", 51, 1)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".entity.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$package/@name}", 51, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$class/@name}", 51, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 51, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("=");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst ($attribute/@name)}", 51, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(NL);         
                        _jettag_c_iterate_50_1.handleBodyContent(out);
                    }
                    _jettag_c_iterate_50_1.doEnd();
                    _jettag_c_if_49_1.handleBodyContent(out);
                }
                _jettag_c_if_49_1.doEnd();
                // process base class attributes
                RuntimeTagElement _jettag_c_iterate_55_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_55_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_55_1.setRuntimeParent(_jettag_c_iterate_11_8);
                _jettag_c_iterate_55_1.setTagInfo(_td_c_iterate_55_1);
                _jettag_c_iterate_55_1.doStart(context, out);
                while (_jettag_c_iterate_55_1.okToProcessBody()) {
                    out.write(context.embeddedExpressionAsString("${$groupID}", 56, 1)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".entity.");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$package/@name}", 56, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 56, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 56, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("=");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${uppercaseFirst ($attribute/@name)}", 56, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(NL);         
                    _jettag_c_iterate_55_1.handleBodyContent(out);
                }
                _jettag_c_iterate_55_1.doEnd();
                out.write("\t    \t");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_c_iterate_11_8.handleBodyContent(out);
            }
            _jettag_c_iterate_11_8.doEnd();
            _jettag_c_iterate_9_6.handleBodyContent(out);
        }
        _jettag_c_iterate_9_6.doEnd();
    }
}
