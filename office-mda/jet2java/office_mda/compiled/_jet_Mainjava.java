package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_Mainjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_Mainjava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_format_1_1 = new TagInfo("java:format", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_8_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            8, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_10_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            10, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_12_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            12, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "isComposite", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_13_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            13, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_14_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            14, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_15_8 = new TagInfo("c:if", //$NON-NLS-1$
            15, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isAbstract = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_17_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            17, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_18_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            18, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_19_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            19, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_20_9 = new TagInfo("c:setVariable", //$NON-NLS-1$
            20, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_22_11 = new TagInfo("c:if", //$NON-NLS-1$
            22, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_26_17 = new TagInfo("c:iterate", //$NON-NLS-1$
            26, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_27_17 = new TagInfo("c:setVariable", //$NON-NLS-1$
            27, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_28_17 = new TagInfo("c:if", //$NON-NLS-1$
            28, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_30_17 = new TagInfo("c:if", //$NON-NLS-1$
            30, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_32_17 = new TagInfo("c:setVariable", //$NON-NLS-1$
            32, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
                "isComposite", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_42_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            42, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_43_6 = new TagInfo("c:if", //$NON-NLS-1$
            43, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.parent/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_45_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            45, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_49_8 = new TagInfo("c:if", //$NON-NLS-1$
            49, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isComposite = $class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_50_8 = new TagInfo("c:if", //$NON-NLS-1$
            50, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isParent = $class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_100_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            100, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package", //$NON-NLS-1$
                "package", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_102_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            102, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_104_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            104, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "isComposite", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_105_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            105, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_106_8 = new TagInfo("c:setVariable", //$NON-NLS-1$
            106, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_107_8 = new TagInfo("c:if", //$NON-NLS-1$
            107, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isAbstract = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_109_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            109, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_110_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            110, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_111_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            111, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_112_9 = new TagInfo("c:setVariable", //$NON-NLS-1$
            112, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_114_11 = new TagInfo("c:if", //$NON-NLS-1$
            114, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_118_17 = new TagInfo("c:iterate", //$NON-NLS-1$
            118, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_119_17 = new TagInfo("c:setVariable", //$NON-NLS-1$
            119, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_120_17 = new TagInfo("c:if", //$NON-NLS-1$
            120, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_122_17 = new TagInfo("c:if", //$NON-NLS-1$
            122, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_124_17 = new TagInfo("c:setVariable", //$NON-NLS-1$
            124, 17,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
                "isComposite", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_134_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            134, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_135_6 = new TagInfo("c:if", //$NON-NLS-1$
            135, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.parent/Class/@xmi.idref = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_137_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            137, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_141_8 = new TagInfo("c:if", //$NON-NLS-1$
            141, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isComposite = $class/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_142_8 = new TagInfo("c:if", //$NON-NLS-1$
            142, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isParent = $class/@xmi.id", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_java_format_1_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "format", "java:format", _td_java_format_1_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_format_1_1.setRuntimeParent(null);
        _jettag_java_format_1_1.setTagInfo(_td_java_format_1_1);
        _jettag_java_format_1_1.doStart(context, out);
        JET2Writer _jettag_java_format_1_1_saved_out = out;
        while (_jettag_java_format_1_1.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(NL);         
            out.write("package ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 2, 9)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import java.util.ArrayList;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.HashMap;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.Map;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            RuntimeTagElement _jettag_c_iterate_8_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_8_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_8_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_8_2.setTagInfo(_td_c_iterate_8_2);
            _jettag_c_iterate_8_2.doStart(context, out);
            while (_jettag_c_iterate_8_2.okToProcessBody()) {
                // iterate through class and add only non composite children and non parent
                RuntimeTagElement _jettag_c_iterate_10_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_10_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_10_5.setRuntimeParent(_jettag_c_iterate_8_2);
                _jettag_c_iterate_10_5.setTagInfo(_td_c_iterate_10_5);
                _jettag_c_iterate_10_5.doStart(context, out);
                while (_jettag_c_iterate_10_5.okToProcessBody()) {
                    // Flag varibles
                    RuntimeTagElement _jettag_c_setVariable_12_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_12_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_12_8.setRuntimeParent(_jettag_c_iterate_10_5);
                    _jettag_c_setVariable_12_8.setTagInfo(_td_c_setVariable_12_8);
                    _jettag_c_setVariable_12_8.doStart(context, out);
                    _jettag_c_setVariable_12_8.doEnd();
                    RuntimeTagElement _jettag_c_setVariable_13_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_13_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_13_8.setRuntimeParent(_jettag_c_iterate_10_5);
                    _jettag_c_setVariable_13_8.setTagInfo(_td_c_setVariable_13_8);
                    _jettag_c_setVariable_13_8.doStart(context, out);
                    _jettag_c_setVariable_13_8.doEnd();
                    RuntimeTagElement _jettag_c_setVariable_14_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_14_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_14_8.setRuntimeParent(_jettag_c_iterate_10_5);
                    _jettag_c_setVariable_14_8.setTagInfo(_td_c_setVariable_14_8);
                    _jettag_c_setVariable_14_8.doStart(context, out);
                    _jettag_c_setVariable_14_8.doEnd();
                    RuntimeTagElement _jettag_c_if_15_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_15_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_15_8.setRuntimeParent(_jettag_c_iterate_10_5);
                    _jettag_c_if_15_8.setTagInfo(_td_c_if_15_8);
                    _jettag_c_if_15_8.doStart(context, out);
                    while (_jettag_c_if_15_8.okToProcessBody()) {
                        // process all associations to eliminate composite children
                        RuntimeTagElement _jettag_c_iterate_17_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_17_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_17_6.setRuntimeParent(_jettag_c_if_15_8);
                        _jettag_c_iterate_17_6.setTagInfo(_td_c_iterate_17_6);
                        _jettag_c_iterate_17_6.doStart(context, out);
                        while (_jettag_c_iterate_17_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_18_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_18_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_18_7.setRuntimeParent(_jettag_c_iterate_17_6);
                            _jettag_c_iterate_18_7.setTagInfo(_td_c_iterate_18_7);
                            _jettag_c_iterate_18_7.doStart(context, out);
                            while (_jettag_c_iterate_18_7.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_19_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_19_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_19_8.setRuntimeParent(_jettag_c_iterate_18_7);
                                _jettag_c_iterate_19_8.setTagInfo(_td_c_iterate_19_8);
                                _jettag_c_iterate_19_8.doStart(context, out);
                                while (_jettag_c_iterate_19_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_20_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_20_9); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_20_9.setRuntimeParent(_jettag_c_iterate_19_8);
                                    _jettag_c_setVariable_20_9.setTagInfo(_td_c_setVariable_20_9);
                                    _jettag_c_setVariable_20_9.doStart(context, out);
                                    _jettag_c_setVariable_20_9.doEnd();
                                    // check is the association is corresponding to the class  
                                    RuntimeTagElement _jettag_c_if_22_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_22_11); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_22_11.setRuntimeParent(_jettag_c_iterate_19_8);
                                    _jettag_c_if_22_11.setTagInfo(_td_c_if_22_11);
                                    _jettag_c_if_22_11.doStart(context, out);
                                    while (_jettag_c_if_22_11.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        out.write("\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_26_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_26_17); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_26_17.setRuntimeParent(_jettag_c_if_22_11);
                                        _jettag_c_iterate_26_17.setTagInfo(_td_c_iterate_26_17);
                                        _jettag_c_iterate_26_17.doStart(context, out);
                                        while (_jettag_c_iterate_26_17.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_27_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_27_17); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_27_17.setRuntimeParent(_jettag_c_iterate_26_17);
                                            _jettag_c_setVariable_27_17.setTagInfo(_td_c_setVariable_27_17);
                                            _jettag_c_setVariable_27_17.doStart(context, out);
                                            _jettag_c_setVariable_27_17.doEnd();
                                            RuntimeTagElement _jettag_c_if_28_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_28_17); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_28_17.setRuntimeParent(_jettag_c_iterate_26_17);
                                            _jettag_c_if_28_17.setTagInfo(_td_c_if_28_17);
                                            _jettag_c_if_28_17.doStart(context, out);
                                            while (_jettag_c_if_28_17.okToProcessBody()) {
                                                // process only non compositions
                                                RuntimeTagElement _jettag_c_if_30_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_30_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_30_17.setRuntimeParent(_jettag_c_if_28_17);
                                                _jettag_c_if_30_17.setTagInfo(_td_c_if_30_17);
                                                _jettag_c_if_30_17.doStart(context, out);
                                                while (_jettag_c_if_30_17.okToProcessBody()) {
                                                    // update flag variable
                                                    RuntimeTagElement _jettag_c_setVariable_32_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_32_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_setVariable_32_17.setRuntimeParent(_jettag_c_if_30_17);
                                                    _jettag_c_setVariable_32_17.setTagInfo(_td_c_setVariable_32_17);
                                                    _jettag_c_setVariable_32_17.doStart(context, out);
                                                    _jettag_c_setVariable_32_17.doEnd();
                                                    _jettag_c_if_30_17.handleBodyContent(out);
                                                }
                                                _jettag_c_if_30_17.doEnd();
                                                _jettag_c_if_28_17.handleBodyContent(out);
                                            }
                                            _jettag_c_if_28_17.doEnd();
                                            _jettag_c_iterate_26_17.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_26_17.doEnd();
                                        _jettag_c_if_22_11.handleBodyContent(out);
                                    }
                                    _jettag_c_if_22_11.doEnd();
                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_iterate_19_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_19_8.doEnd();
                                _jettag_c_iterate_18_7.handleBodyContent(out);
                            }
                            _jettag_c_iterate_18_7.doEnd();
                            _jettag_c_iterate_17_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_17_6.doEnd();
                        // process all generizations to eliminate all parent classes
                        RuntimeTagElement _jettag_c_iterate_42_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_42_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_42_5.setRuntimeParent(_jettag_c_if_15_8);
                        _jettag_c_iterate_42_5.setTagInfo(_td_c_iterate_42_5);
                        _jettag_c_iterate_42_5.doStart(context, out);
                        while (_jettag_c_iterate_42_5.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_43_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_43_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_43_6.setRuntimeParent(_jettag_c_iterate_42_5);
                            _jettag_c_if_43_6.setTagInfo(_td_c_if_43_6);
                            _jettag_c_if_43_6.doStart(context, out);
                            while (_jettag_c_if_43_6.okToProcessBody()) {
                                // update flag variable
                                RuntimeTagElement _jettag_c_setVariable_45_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_45_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_45_6.setRuntimeParent(_jettag_c_if_43_6);
                                _jettag_c_setVariable_45_6.setTagInfo(_td_c_setVariable_45_6);
                                _jettag_c_setVariable_45_6.doStart(context, out);
                                _jettag_c_setVariable_45_6.doEnd();
                                _jettag_c_if_43_6.handleBodyContent(out);
                            }
                            _jettag_c_if_43_6.doEnd();
                            _jettag_c_iterate_42_5.handleBodyContent(out);
                        }
                        _jettag_c_iterate_42_5.doEnd();
                        // check for flag varibles and add menu item class
                        RuntimeTagElement _jettag_c_if_49_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_49_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_49_8.setRuntimeParent(_jettag_c_if_15_8);
                        _jettag_c_if_49_8.setTagInfo(_td_c_if_49_8);
                        _jettag_c_if_49_8.doStart(context, out);
                        while (_jettag_c_if_49_8.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_50_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_50_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_50_8.setRuntimeParent(_jettag_c_if_49_8);
                            _jettag_c_if_50_8.setTagInfo(_td_c_if_50_8);
                            _jettag_c_if_50_8.doStart(context, out);
                            while (_jettag_c_if_50_8.okToProcessBody()) {
                                out.write("    \t\t \timport ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$groupID}", 51, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".android.");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$package/@name}", 51, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 51, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".ReadAll");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$class/@name}", 51, 89)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("s;");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_50_8.handleBodyContent(out);
                            }
                            _jettag_c_if_50_8.doEnd();
                            _jettag_c_if_49_8.handleBodyContent(out);
                        }
                        _jettag_c_if_49_8.doEnd();
                        _jettag_c_if_15_8.handleBodyContent(out);
                    }
                    _jettag_c_if_15_8.doEnd();
                    _jettag_c_iterate_10_5.handleBodyContent(out);
                }
                _jettag_c_iterate_10_5.doEnd();
                _jettag_c_iterate_8_2.handleBodyContent(out);
            }
            _jettag_c_iterate_8_2.doEnd();
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.app.ListActivity;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.content.Intent;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.os.Bundle;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.util.Log;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.Menu;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.MenuInflater;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.MenuItem;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.ListView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.SimpleAdapter;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.http.HttpHelper;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.http.AsyncHttpGet;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("/**");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(" * HelloFlashlight is a sample application for the usage of the Maven Android Plugin.");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(" * The code is trivial and not the focus of this example and therefore not really documented.");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(" */");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("public class ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 74, 14)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Main extends ListActivity {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic static String baseURL = \"http://10.0.2.2:8080/");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 76, 55)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("-webapp/seam/resource/restv1/crud/\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic static String manageURL = \"http://10.0.2.2:8080/");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 77, 57)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("-webapp/seam/resource/restv1/manage/\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate SimpleAdapter notes;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("    @Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("    public void onCreate(Bundle savedInstanceState) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("        super.onCreate(savedInstanceState);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("      \tnotes = new SimpleAdapter(this, getData(), R.layout.list_item,");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tnew String[] { \"text\" }, new int[] { R.id.list_item_view });");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsetListAdapter(notes);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("        ");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected void onListItemClick(ListView l, View v, int position, long id) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tMap map = (Map) l.getItemAtPosition(position);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tIntent intent = (Intent) map.get(\"intent\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tstartActivity(intent);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write(NL);         
            out.write("\tprotected ArrayList<HashMap<String, Object>> getData() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(NL);         
            RuntimeTagElement _jettag_c_iterate_100_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_100_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_100_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_100_2.setTagInfo(_td_c_iterate_100_2);
            _jettag_c_iterate_100_2.doStart(context, out);
            while (_jettag_c_iterate_100_2.okToProcessBody()) {
                // iterate through class and add only non composite children and non parent
                RuntimeTagElement _jettag_c_iterate_102_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_102_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_102_5.setRuntimeParent(_jettag_c_iterate_100_2);
                _jettag_c_iterate_102_5.setTagInfo(_td_c_iterate_102_5);
                _jettag_c_iterate_102_5.doStart(context, out);
                while (_jettag_c_iterate_102_5.okToProcessBody()) {
                    // Flag varibles
                    RuntimeTagElement _jettag_c_setVariable_104_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_104_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_104_8.setRuntimeParent(_jettag_c_iterate_102_5);
                    _jettag_c_setVariable_104_8.setTagInfo(_td_c_setVariable_104_8);
                    _jettag_c_setVariable_104_8.doStart(context, out);
                    _jettag_c_setVariable_104_8.doEnd();
                    RuntimeTagElement _jettag_c_setVariable_105_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_105_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_105_8.setRuntimeParent(_jettag_c_iterate_102_5);
                    _jettag_c_setVariable_105_8.setTagInfo(_td_c_setVariable_105_8);
                    _jettag_c_setVariable_105_8.doStart(context, out);
                    _jettag_c_setVariable_105_8.doEnd();
                    RuntimeTagElement _jettag_c_setVariable_106_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_106_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_106_8.setRuntimeParent(_jettag_c_iterate_102_5);
                    _jettag_c_setVariable_106_8.setTagInfo(_td_c_setVariable_106_8);
                    _jettag_c_setVariable_106_8.doStart(context, out);
                    _jettag_c_setVariable_106_8.doEnd();
                    RuntimeTagElement _jettag_c_if_107_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_107_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_107_8.setRuntimeParent(_jettag_c_iterate_102_5);
                    _jettag_c_if_107_8.setTagInfo(_td_c_if_107_8);
                    _jettag_c_if_107_8.doStart(context, out);
                    while (_jettag_c_if_107_8.okToProcessBody()) {
                        // process all associations to eliminate composite children
                        RuntimeTagElement _jettag_c_iterate_109_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_109_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_109_6.setRuntimeParent(_jettag_c_if_107_8);
                        _jettag_c_iterate_109_6.setTagInfo(_td_c_iterate_109_6);
                        _jettag_c_iterate_109_6.doStart(context, out);
                        while (_jettag_c_iterate_109_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_110_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_110_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_110_7.setRuntimeParent(_jettag_c_iterate_109_6);
                            _jettag_c_iterate_110_7.setTagInfo(_td_c_iterate_110_7);
                            _jettag_c_iterate_110_7.doStart(context, out);
                            while (_jettag_c_iterate_110_7.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_111_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_111_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_111_8.setRuntimeParent(_jettag_c_iterate_110_7);
                                _jettag_c_iterate_111_8.setTagInfo(_td_c_iterate_111_8);
                                _jettag_c_iterate_111_8.doStart(context, out);
                                while (_jettag_c_iterate_111_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_112_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_112_9); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_112_9.setRuntimeParent(_jettag_c_iterate_111_8);
                                    _jettag_c_setVariable_112_9.setTagInfo(_td_c_setVariable_112_9);
                                    _jettag_c_setVariable_112_9.doStart(context, out);
                                    _jettag_c_setVariable_112_9.doEnd();
                                    // check is the association is corresponding to the class  
                                    RuntimeTagElement _jettag_c_if_114_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_114_11); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_114_11.setRuntimeParent(_jettag_c_iterate_111_8);
                                    _jettag_c_if_114_11.setTagInfo(_td_c_if_114_11);
                                    _jettag_c_if_114_11.doStart(context, out);
                                    while (_jettag_c_if_114_11.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        out.write("\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_118_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_118_17); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_118_17.setRuntimeParent(_jettag_c_if_114_11);
                                        _jettag_c_iterate_118_17.setTagInfo(_td_c_iterate_118_17);
                                        _jettag_c_iterate_118_17.doStart(context, out);
                                        while (_jettag_c_iterate_118_17.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_119_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_119_17); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_119_17.setRuntimeParent(_jettag_c_iterate_118_17);
                                            _jettag_c_setVariable_119_17.setTagInfo(_td_c_setVariable_119_17);
                                            _jettag_c_setVariable_119_17.doStart(context, out);
                                            _jettag_c_setVariable_119_17.doEnd();
                                            RuntimeTagElement _jettag_c_if_120_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_120_17); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_120_17.setRuntimeParent(_jettag_c_iterate_118_17);
                                            _jettag_c_if_120_17.setTagInfo(_td_c_if_120_17);
                                            _jettag_c_if_120_17.doStart(context, out);
                                            while (_jettag_c_if_120_17.okToProcessBody()) {
                                                // process only non compositions
                                                RuntimeTagElement _jettag_c_if_122_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_122_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_122_17.setRuntimeParent(_jettag_c_if_120_17);
                                                _jettag_c_if_122_17.setTagInfo(_td_c_if_122_17);
                                                _jettag_c_if_122_17.doStart(context, out);
                                                while (_jettag_c_if_122_17.okToProcessBody()) {
                                                    // update flag variable
                                                    RuntimeTagElement _jettag_c_setVariable_124_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_124_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_setVariable_124_17.setRuntimeParent(_jettag_c_if_122_17);
                                                    _jettag_c_setVariable_124_17.setTagInfo(_td_c_setVariable_124_17);
                                                    _jettag_c_setVariable_124_17.doStart(context, out);
                                                    _jettag_c_setVariable_124_17.doEnd();
                                                    _jettag_c_if_122_17.handleBodyContent(out);
                                                }
                                                _jettag_c_if_122_17.doEnd();
                                                _jettag_c_if_120_17.handleBodyContent(out);
                                            }
                                            _jettag_c_if_120_17.doEnd();
                                            _jettag_c_iterate_118_17.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_118_17.doEnd();
                                        _jettag_c_if_114_11.handleBodyContent(out);
                                    }
                                    _jettag_c_if_114_11.doEnd();
                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_iterate_111_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_111_8.doEnd();
                                _jettag_c_iterate_110_7.handleBodyContent(out);
                            }
                            _jettag_c_iterate_110_7.doEnd();
                            _jettag_c_iterate_109_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_109_6.doEnd();
                        // process all generizations to eliminate all parent classes
                        RuntimeTagElement _jettag_c_iterate_134_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_134_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_134_5.setRuntimeParent(_jettag_c_if_107_8);
                        _jettag_c_iterate_134_5.setTagInfo(_td_c_iterate_134_5);
                        _jettag_c_iterate_134_5.doStart(context, out);
                        while (_jettag_c_iterate_134_5.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_135_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_135_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_135_6.setRuntimeParent(_jettag_c_iterate_134_5);
                            _jettag_c_if_135_6.setTagInfo(_td_c_if_135_6);
                            _jettag_c_if_135_6.doStart(context, out);
                            while (_jettag_c_if_135_6.okToProcessBody()) {
                                // update flag variable
                                RuntimeTagElement _jettag_c_setVariable_137_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_137_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_137_6.setRuntimeParent(_jettag_c_if_135_6);
                                _jettag_c_setVariable_137_6.setTagInfo(_td_c_setVariable_137_6);
                                _jettag_c_setVariable_137_6.doStart(context, out);
                                _jettag_c_setVariable_137_6.doEnd();
                                _jettag_c_if_135_6.handleBodyContent(out);
                            }
                            _jettag_c_if_135_6.doEnd();
                            _jettag_c_iterate_134_5.handleBodyContent(out);
                        }
                        _jettag_c_iterate_134_5.doEnd();
                        // check for flag varibles and add menu item class
                        RuntimeTagElement _jettag_c_if_141_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_141_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_141_8.setRuntimeParent(_jettag_c_if_107_8);
                        _jettag_c_if_141_8.setTagInfo(_td_c_if_141_8);
                        _jettag_c_if_141_8.doStart(context, out);
                        while (_jettag_c_if_141_8.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_142_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_142_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_142_8.setRuntimeParent(_jettag_c_if_141_8);
                            _jettag_c_if_142_8.setTagInfo(_td_c_if_142_8);
                            _jettag_c_if_142_8.doStart(context, out);
                            while (_jettag_c_if_142_8.okToProcessBody()) {
                                out.write("    \t\t \tHashMap<String, Object> ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 143, 33)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Maintainence = new HashMap<String, Object>();");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 144, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Maintainence.put(\"text\", \"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$class/@name}", 144, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(" Maintainence\");");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\tIntent ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 145, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Intent = new Intent(this, ReadAll");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$class/@name}", 145, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("s.class);");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\t");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 146, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Maintainence.put(\"intent\", ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 146, 59)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Intent);");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\tlist.add(");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 147, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Maintainence);");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_142_8.handleBodyContent(out);
                            }
                            _jettag_c_if_142_8.doEnd();
                            _jettag_c_if_141_8.handleBodyContent(out);
                        }
                        _jettag_c_if_141_8.doEnd();
                        out.write("\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_if_107_8.handleBodyContent(out);
                    }
                    _jettag_c_if_107_8.doEnd();
                    _jettag_c_iterate_102_5.handleBodyContent(out);
                }
                _jettag_c_iterate_102_5.doEnd();
                _jettag_c_iterate_100_2.handleBodyContent(out);
            }
            _jettag_c_iterate_100_2.doEnd();
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn list;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t} ");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic boolean onCreateOptionsMenu(Menu menu) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tMenuInflater inflater = getMenuInflater();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tinflater.inflate(R.menu.main_menu, menu);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn true;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic boolean onOptionsItemSelected(MenuItem item) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tswitch (item.getItemId()) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcase R.id.menu_main_logout:");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tlogout();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\treturn true;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcase R.id.menu_main_exit:");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\texit();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\treturn true;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdefault:");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\treturn super.onOptionsItemSelected(item);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic void logout() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tnew AsyncHttpGet(this) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tprotected void onResponse(String result) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tfinish();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}.execute(");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 185, 13)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Main.manageURL + \"logout\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic void exit() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tnew AsyncHttpGet(this) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tprotected void onResponse(String result) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tfinish();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}.execute(");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 194, 13)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Main.manageURL + \"logout\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}       ");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
