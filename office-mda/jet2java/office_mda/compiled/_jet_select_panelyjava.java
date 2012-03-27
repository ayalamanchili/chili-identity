package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_select_panelyjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_select_panelyjava() {
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
    private static final TagInfo _td_c_iterate_17_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            17, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_18_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            18, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_19_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            19, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_21_3 = new TagInfo("c:if", //$NON-NLS-1$
            21, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_22_5 = new TagInfo("c:if", //$NON-NLS-1$
            22, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_24_5 = new TagInfo("c:if", //$NON-NLS-1$
            24, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_25_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            25, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_27_6 = new TagInfo("c:if", //$NON-NLS-1$
            27, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_30_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            30, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_31_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            31, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_33_14 = new TagInfo("c:if", //$NON-NLS-1$
            33, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_35_14 = new TagInfo("c:if", //$NON-NLS-1$
            35, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_37_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            37, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_38_16 = new TagInfo("c:if", //$NON-NLS-1$
            38, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_55_1 = new TagInfo("f:message", //$NON-NLS-1$
            55, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_57_1 = new TagInfo("f:message", //$NON-NLS-1$
            57, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_62_1 = new TagInfo("f:message", //$NON-NLS-1$
            62, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_66_1 = new TagInfo("f:message", //$NON-NLS-1$
            66, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_70_1 = new TagInfo("f:message", //$NON-NLS-1$
            70, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_74_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            74, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_76_3 = new TagInfo("c:choose", //$NON-NLS-1$
            76, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_76_73 = new TagInfo("c:when", //$NON-NLS-1$
            76, 73,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_91_1 = new TagInfo("f:message", //$NON-NLS-1$
            91, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_99_1 = new TagInfo("f:message", //$NON-NLS-1$
            99, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_105_1 = new TagInfo("f:message", //$NON-NLS-1$
            105, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_111_1 = new TagInfo("f:message", //$NON-NLS-1$
            111, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_115_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            115, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_116_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            116, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_117_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            117, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_119_3 = new TagInfo("c:if", //$NON-NLS-1$
            119, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_120_5 = new TagInfo("c:if", //$NON-NLS-1$
            120, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_122_5 = new TagInfo("c:if", //$NON-NLS-1$
            122, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_123_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            123, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_125_6 = new TagInfo("c:if", //$NON-NLS-1$
            125, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_128_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            128, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_129_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            129, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_131_14 = new TagInfo("c:if", //$NON-NLS-1$
            131, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_133_14 = new TagInfo("c:if", //$NON-NLS-1$
            133, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_135_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            135, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_136_16 = new TagInfo("c:if", //$NON-NLS-1$
            136, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_166_1 = new TagInfo("f:message", //$NON-NLS-1$
            166, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_170_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            170, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_171_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            171, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_172_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            172, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_174_3 = new TagInfo("c:if", //$NON-NLS-1$
            174, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_175_5 = new TagInfo("c:if", //$NON-NLS-1$
            175, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_177_5 = new TagInfo("c:if", //$NON-NLS-1$
            177, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_178_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            178, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_180_6 = new TagInfo("c:if", //$NON-NLS-1$
            180, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_183_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            183, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_184_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            184, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_186_14 = new TagInfo("c:if", //$NON-NLS-1$
            186, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_188_14 = new TagInfo("c:if", //$NON-NLS-1$
            188, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_190_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            190, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_191_16 = new TagInfo("c:if", //$NON-NLS-1$
            191, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_221_1 = new TagInfo("f:message", //$NON-NLS-1$
            221, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_227_1 = new TagInfo("f:message", //$NON-NLS-1$
            227, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_233_1 = new TagInfo("f:message", //$NON-NLS-1$
            233, 1,
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
                out.write(context.embeddedExpressionAsString("${$packageName}", 5, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 5, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 6, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 6, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 6, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 7, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 7, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.widgets.ResponseStatusWidget;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.TreePanelCompositey;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.SelectCompositey;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.beans.MultiSelectObjy;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Set;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.SelectComposite;");  //$NON-NLS-1$        
                out.write(NL);         
                // process all many on source and non composites on target
                RuntimeTagElement _jettag_c_iterate_17_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_17_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_17_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_17_2.setTagInfo(_td_c_iterate_17_2);
                _jettag_c_iterate_17_2.doStart(context, out);
                while (_jettag_c_iterate_17_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_18_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_18_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_18_2.setRuntimeParent(_jettag_c_iterate_17_2);
                    _jettag_c_iterate_18_2.setTagInfo(_td_c_iterate_18_2);
                    _jettag_c_iterate_18_2.doStart(context, out);
                    while (_jettag_c_iterate_18_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_19_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_19_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_19_3.setRuntimeParent(_jettag_c_iterate_18_2);
                        _jettag_c_iterate_19_3.setTagInfo(_td_c_iterate_19_3);
                        _jettag_c_iterate_19_3.doStart(context, out);
                        while (_jettag_c_iterate_19_3.okToProcessBody()) {
                            //check if the source is many side 
                            RuntimeTagElement _jettag_c_if_21_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_21_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_21_3.setRuntimeParent(_jettag_c_iterate_19_3);
                            _jettag_c_if_21_3.setTagInfo(_td_c_if_21_3);
                            _jettag_c_if_21_3.doStart(context, out);
                            while (_jettag_c_if_21_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_22_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_22_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_22_5.setRuntimeParent(_jettag_c_if_21_3);
                                _jettag_c_if_22_5.setTagInfo(_td_c_if_22_5);
                                _jettag_c_if_22_5.doStart(context, out);
                                while (_jettag_c_if_22_5.okToProcessBody()) {
                                    // check if the target association is navigable
                                    RuntimeTagElement _jettag_c_if_24_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_24_5); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_24_5.setRuntimeParent(_jettag_c_if_22_5);
                                    _jettag_c_if_24_5.setTagInfo(_td_c_if_24_5);
                                    _jettag_c_if_24_5.doStart(context, out);
                                    while (_jettag_c_if_24_5.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_25_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_25_4); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_25_4.setRuntimeParent(_jettag_c_if_24_5);
                                        _jettag_c_setVariable_25_4.setTagInfo(_td_c_setVariable_25_4);
                                        _jettag_c_setVariable_25_4.doStart(context, out);
                                        _jettag_c_setVariable_25_4.doEnd();
                                        // check is the association is corresponding to the class  
                                        RuntimeTagElement _jettag_c_if_27_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_27_6); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_27_6.setRuntimeParent(_jettag_c_if_24_5);
                                        _jettag_c_if_27_6.setTagInfo(_td_c_if_27_6);
                                        _jettag_c_if_27_6.doStart(context, out);
                                        while (_jettag_c_if_27_6.okToProcessBody()) {
                                            // process only compositions
                                            // iterate over the iterations ends  
                                            RuntimeTagElement _jettag_c_iterate_30_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_30_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_30_12.setRuntimeParent(_jettag_c_if_27_6);
                                            _jettag_c_iterate_30_12.setTagInfo(_td_c_iterate_30_12);
                                            _jettag_c_iterate_30_12.doStart(context, out);
                                            while (_jettag_c_iterate_30_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_31_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_31_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_31_12.setRuntimeParent(_jettag_c_iterate_30_12);
                                                _jettag_c_setVariable_31_12.setTagInfo(_td_c_setVariable_31_12);
                                                _jettag_c_setVariable_31_12.doStart(context, out);
                                                _jettag_c_setVariable_31_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_33_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_33_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_33_14.setRuntimeParent(_jettag_c_iterate_30_12);
                                                _jettag_c_if_33_14.setTagInfo(_td_c_if_33_14);
                                                _jettag_c_if_33_14.doStart(context, out);
                                                while (_jettag_c_if_33_14.okToProcessBody()) {
                                                    // process only non composites on target
                                                    RuntimeTagElement _jettag_c_if_35_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_35_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_35_14.setRuntimeParent(_jettag_c_if_33_14);
                                                    _jettag_c_if_35_14.setTagInfo(_td_c_if_35_14);
                                                    _jettag_c_if_35_14.doStart(context, out);
                                                    while (_jettag_c_if_35_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_37_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_37_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_37_15.setRuntimeParent(_jettag_c_if_35_14);
                                                        _jettag_c_iterate_37_15.setTagInfo(_td_c_iterate_37_15);
                                                        _jettag_c_iterate_37_15.doStart(context, out);
                                                        while (_jettag_c_iterate_37_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_38_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_38_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_38_16.setRuntimeParent(_jettag_c_iterate_37_15);
                                                            _jettag_c_if_38_16.setTagInfo(_td_c_if_38_16);
                                                            _jettag_c_if_38_16.doStart(context, out);
                                                            while (_jettag_c_if_38_16.okToProcessBody()) {
                                                                out.write("import ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$packageName}", 39, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 39, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 39, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy;");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_38_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_38_16.doEnd();
                                                            _jettag_c_iterate_37_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_37_15.doEnd();
                                                        _jettag_c_if_35_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_35_14.doEnd();
                                                    _jettag_c_if_33_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_33_14.doEnd();
                                                _jettag_c_iterate_30_12.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_30_12.doEnd();
                                            _jettag_c_if_27_6.handleBodyContent(out);
                                        }
                                        _jettag_c_if_27_6.doEnd();
                                        _jettag_c_if_24_5.handleBodyContent(out);
                                    }
                                    _jettag_c_if_24_5.doEnd();
                                    _jettag_c_if_22_5.handleBodyContent(out);
                                }
                                _jettag_c_if_22_5.doEnd();
                                _jettag_c_if_21_3.handleBodyContent(out);
                            }
                            _jettag_c_if_21_3.doEnd();
                            _jettag_c_iterate_19_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_19_3.doEnd();
                        _jettag_c_iterate_18_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_18_2.doEnd();
                    _jettag_c_iterate_17_2.handleBodyContent(out);
                }
                _jettag_c_iterate_17_2.doEnd();
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Map;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_55_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_55_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_55_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_55_1.setTagInfo(_td_f_message_55_1);
                _jettag_f_message_55_1.doStart(context, out);
                JET2Writer _jettag_f_message_55_1_saved_out = out;
                while (_jettag_f_message_55_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_55_1.handleBodyContent(out);
                }
                out = _jettag_f_message_55_1_saved_out;
                _jettag_f_message_55_1.doEnd();
                out.write(NL);         
                out.write("public class Select");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 56, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely extends SelectCompositey<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 56, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy> {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_57_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_57_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_57_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_57_1.setTagInfo(_td_f_message_57_1);
                _jettag_f_message_57_1.doStart(context, out);
                JET2Writer _jettag_f_message_57_1_saved_out = out;
                while (_jettag_f_message_57_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_57_1.handleBodyContent(out);
                }
                out = _jettag_f_message_57_1_saved_out;
                _jettag_f_message_57_1.doEnd();
                out.write(NL);         
                out.write("\tpublic Select");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 58, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely(String title, TreePanelCompositey parent,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tMultiSelectObjy obj) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tsuper(title, parent, obj);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_62_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_62_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_62_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_62_1.setTagInfo(_td_f_message_62_1);
                _jettag_f_message_62_1.doStart(context, out);
                JET2Writer _jettag_f_message_62_1_saved_out = out;
                while (_jettag_f_message_62_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_62_1.handleBodyContent(out);
                }
                out = _jettag_f_message_62_1_saved_out;
                _jettag_f_message_62_1.doEnd();
                out.write(NL);         
                out.write("\tpublic Select");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 63, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely(String name) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tsuper(name);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_66_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_66_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_66_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_66_1.setTagInfo(_td_f_message_66_1);
                _jettag_f_message_66_1.doStart(context, out);
                JET2Writer _jettag_f_message_66_1_saved_out = out;
                while (_jettag_f_message_66_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_66_1.handleBodyContent(out);
                }
                out = _jettag_f_message_66_1_saved_out;
                _jettag_f_message_66_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic Select");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 67, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely(String name,");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 67, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy proxy) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tsuper(name,proxy);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_70_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_70_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_70_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_70_1.setTagInfo(_td_f_message_70_1);
                _jettag_f_message_70_1.doStart(context, out);
                JET2Writer _jettag_f_message_70_1_saved_out = out;
                while (_jettag_f_message_70_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_70_1.handleBodyContent(out);
                }
                out = _jettag_f_message_70_1_saved_out;
                _jettag_f_message_70_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void initListBox() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tString[] columns = { ");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_iterate_74_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_74_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_74_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_74_1.setTagInfo(_td_c_iterate_74_1);
                _jettag_c_iterate_74_1.doStart(context, out);
                while (_jettag_c_iterate_74_1.okToProcessBody()) {
                    // processes the premitive Datatypes 
                    out.write("\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_choose_76_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_76_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_76_3.setRuntimeParent(_jettag_c_iterate_74_1);
                    _jettag_c_choose_76_3.setTagInfo(_td_c_choose_76_3);
                    _jettag_c_choose_76_3.doStart(context, out);
                    JET2Writer _jettag_c_choose_76_3_saved_out = out;
                    while (_jettag_c_choose_76_3.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_76_73 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_76_73); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_76_73.setRuntimeParent(_jettag_c_choose_76_3);
                        _jettag_c_when_76_73.setTagInfo(_td_c_when_76_73);
                        _jettag_c_when_76_73.doStart(context, out);
                        JET2Writer _jettag_c_when_76_73_saved_out = out;
                        while (_jettag_c_when_76_73.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 76, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", ");  //$NON-NLS-1$        
                            _jettag_c_when_76_73.handleBodyContent(out);
                        }
                        out = _jettag_c_when_76_73_saved_out;
                        _jettag_c_when_76_73.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_choose_76_3.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_76_3_saved_out;
                    _jettag_c_choose_76_3.doEnd();
                    _jettag_c_iterate_74_1.handleBodyContent(out);
                }
                _jettag_c_iterate_74_1.doEnd();
                out.write("\t };");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 80, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 80, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 80, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 80, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync.instance().getListBoxValues(columns, new ALAsyncCallback<Map<Long, String>>() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\tpublic void onResponse(Map<Long, String> arg0) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tpopulateListBox(arg0);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t});");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_91_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_91_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_91_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_91_1.setTagInfo(_td_f_message_91_1);
                _jettag_f_message_91_1.doStart(context, out);
                JET2Writer _jettag_f_message_91_1_saved_out = out;
                while (_jettag_f_message_91_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_91_1.handleBodyContent(out);
                }
                out = _jettag_f_message_91_1_saved_out;
                _jettag_f_message_91_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void getSelectedProxy(Long id) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 94, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Request request = ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 94, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.requestFactory");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 95, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Request();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tproxy = (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 96, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy) request.findById(id);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_99_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_99_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_99_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_99_1.setTagInfo(_td_f_message_99_1);
                _jettag_f_message_99_1.doStart(context, out);
                JET2Writer _jettag_f_message_99_1_saved_out = out;
                while (_jettag_f_message_99_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_99_1.handleBodyContent(out);
                }
                out = _jettag_f_message_99_1_saved_out;
                _jettag_f_message_99_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void setSelectedProxy(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 100, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy proxy) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tif (proxy.getId() != null)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tlistBox.setItemSelected(valueIndex.get(proxy.getId()), true);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_105_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_105_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_105_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_105_1.setTagInfo(_td_f_message_105_1);
                _jettag_f_message_105_1.doStart(context, out);
                JET2Writer _jettag_f_message_105_1_saved_out = out;
                while (_jettag_f_message_105_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_105_1.handleBodyContent(out);
                }
                out = _jettag_f_message_105_1_saved_out;
                _jettag_f_message_105_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void onAdd() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t// TODO Auto-generated method stub");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_111_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_111_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_111_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_111_1.setTagInfo(_td_f_message_111_1);
                _jettag_f_message_111_1.doStart(context, out);
                JET2Writer _jettag_f_message_111_1_saved_out = out;
                while (_jettag_f_message_111_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_111_1.handleBodyContent(out);
                }
                out = _jettag_f_message_111_1_saved_out;
                _jettag_f_message_111_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void onAddAll(TreePanelCompositey parent, List<Long> ids) {");  //$NON-NLS-1$        
                out.write(NL);         
                // process all many on source and non composites on target
                RuntimeTagElement _jettag_c_iterate_115_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_115_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_115_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_115_2.setTagInfo(_td_c_iterate_115_2);
                _jettag_c_iterate_115_2.doStart(context, out);
                while (_jettag_c_iterate_115_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_116_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_116_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_116_2.setRuntimeParent(_jettag_c_iterate_115_2);
                    _jettag_c_iterate_116_2.setTagInfo(_td_c_iterate_116_2);
                    _jettag_c_iterate_116_2.doStart(context, out);
                    while (_jettag_c_iterate_116_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_117_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_117_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_117_3.setRuntimeParent(_jettag_c_iterate_116_2);
                        _jettag_c_iterate_117_3.setTagInfo(_td_c_iterate_117_3);
                        _jettag_c_iterate_117_3.doStart(context, out);
                        while (_jettag_c_iterate_117_3.okToProcessBody()) {
                            //check if the source is many side 
                            RuntimeTagElement _jettag_c_if_119_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_119_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_119_3.setRuntimeParent(_jettag_c_iterate_117_3);
                            _jettag_c_if_119_3.setTagInfo(_td_c_if_119_3);
                            _jettag_c_if_119_3.doStart(context, out);
                            while (_jettag_c_if_119_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_120_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_120_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_120_5.setRuntimeParent(_jettag_c_if_119_3);
                                _jettag_c_if_120_5.setTagInfo(_td_c_if_120_5);
                                _jettag_c_if_120_5.doStart(context, out);
                                while (_jettag_c_if_120_5.okToProcessBody()) {
                                    // check if the target association is navigable
                                    RuntimeTagElement _jettag_c_if_122_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_122_5); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_122_5.setRuntimeParent(_jettag_c_if_120_5);
                                    _jettag_c_if_122_5.setTagInfo(_td_c_if_122_5);
                                    _jettag_c_if_122_5.doStart(context, out);
                                    while (_jettag_c_if_122_5.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_123_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_123_4); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_123_4.setRuntimeParent(_jettag_c_if_122_5);
                                        _jettag_c_setVariable_123_4.setTagInfo(_td_c_setVariable_123_4);
                                        _jettag_c_setVariable_123_4.doStart(context, out);
                                        _jettag_c_setVariable_123_4.doEnd();
                                        // check is the association is corresponding to the class  
                                        RuntimeTagElement _jettag_c_if_125_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_125_6); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_125_6.setRuntimeParent(_jettag_c_if_122_5);
                                        _jettag_c_if_125_6.setTagInfo(_td_c_if_125_6);
                                        _jettag_c_if_125_6.doStart(context, out);
                                        while (_jettag_c_if_125_6.okToProcessBody()) {
                                            // process only compositions
                                            // iterate over the iterations ends  
                                            RuntimeTagElement _jettag_c_iterate_128_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_128_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_128_12.setRuntimeParent(_jettag_c_if_125_6);
                                            _jettag_c_iterate_128_12.setTagInfo(_td_c_iterate_128_12);
                                            _jettag_c_iterate_128_12.doStart(context, out);
                                            while (_jettag_c_iterate_128_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_129_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_129_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_129_12.setRuntimeParent(_jettag_c_iterate_128_12);
                                                _jettag_c_setVariable_129_12.setTagInfo(_td_c_setVariable_129_12);
                                                _jettag_c_setVariable_129_12.doStart(context, out);
                                                _jettag_c_setVariable_129_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_131_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_131_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_131_14.setRuntimeParent(_jettag_c_iterate_128_12);
                                                _jettag_c_if_131_14.setTagInfo(_td_c_if_131_14);
                                                _jettag_c_if_131_14.doStart(context, out);
                                                while (_jettag_c_if_131_14.okToProcessBody()) {
                                                    // process only non composites on target
                                                    RuntimeTagElement _jettag_c_if_133_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_133_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_133_14.setRuntimeParent(_jettag_c_if_131_14);
                                                    _jettag_c_if_133_14.setTagInfo(_td_c_if_133_14);
                                                    _jettag_c_if_133_14.doStart(context, out);
                                                    while (_jettag_c_if_133_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_135_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_135_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_135_15.setRuntimeParent(_jettag_c_if_133_14);
                                                        _jettag_c_iterate_135_15.setTagInfo(_td_c_iterate_135_15);
                                                        _jettag_c_iterate_135_15.doStart(context, out);
                                                        while (_jettag_c_iterate_135_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_136_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_136_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_136_16.setRuntimeParent(_jettag_c_iterate_135_15);
                                                            _jettag_c_if_136_16.setTagInfo(_td_c_if_136_16);
                                                            _jettag_c_if_136_16.doStart(context, out);
                                                            while (_jettag_c_if_136_16.okToProcessBody()) {
                                                                out.write("//TODO need to check parent realation in case to user AbstractTreePanel instead of TreePanel");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tif (parent.getEntity() instanceof ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 138, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$packageName}", 139, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 139, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 139, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Service.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 139, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("ServiceAsync.instance().add");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 139, 122)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 139, 138)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(((");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 139, 157)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy) parent.getEntity()).getId(),");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tids, new ALAsyncCallback<Void>() {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(Void arg0) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tnew ResponseStatusWidget()");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.show(\"");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 145, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s added to ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 145, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("\");");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t}\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_136_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_136_16.doEnd();
                                                            _jettag_c_iterate_135_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_135_15.doEnd();
                                                        _jettag_c_if_133_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_133_14.doEnd();
                                                    _jettag_c_if_131_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_131_14.doEnd();
                                                _jettag_c_iterate_128_12.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_128_12.doEnd();
                                            _jettag_c_if_125_6.handleBodyContent(out);
                                        }
                                        _jettag_c_if_125_6.doEnd();
                                        _jettag_c_if_122_5.handleBodyContent(out);
                                    }
                                    _jettag_c_if_122_5.doEnd();
                                    _jettag_c_if_120_5.handleBodyContent(out);
                                }
                                _jettag_c_if_120_5.doEnd();
                                _jettag_c_if_119_3.handleBodyContent(out);
                            }
                            _jettag_c_if_119_3.doEnd();
                            _jettag_c_iterate_117_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_117_3.doEnd();
                        _jettag_c_iterate_116_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_116_2.doEnd();
                    _jettag_c_iterate_115_2.handleBodyContent(out);
                }
                _jettag_c_iterate_115_2.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_166_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_166_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_166_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_166_1.setTagInfo(_td_f_message_166_1);
                _jettag_f_message_166_1.doStart(context, out);
                JET2Writer _jettag_f_message_166_1_saved_out = out;
                while (_jettag_f_message_166_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_166_1.handleBodyContent(out);
                }
                out = _jettag_f_message_166_1_saved_out;
                _jettag_f_message_166_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void onRemoveAll(TreePanelCompositey parent, List<Long> ids) {");  //$NON-NLS-1$        
                out.write(NL);         
                // process all many on source and non composites on target
                RuntimeTagElement _jettag_c_iterate_170_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_170_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_170_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_170_2.setTagInfo(_td_c_iterate_170_2);
                _jettag_c_iterate_170_2.doStart(context, out);
                while (_jettag_c_iterate_170_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_171_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_171_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_171_2.setRuntimeParent(_jettag_c_iterate_170_2);
                    _jettag_c_iterate_171_2.setTagInfo(_td_c_iterate_171_2);
                    _jettag_c_iterate_171_2.doStart(context, out);
                    while (_jettag_c_iterate_171_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_172_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_172_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_172_3.setRuntimeParent(_jettag_c_iterate_171_2);
                        _jettag_c_iterate_172_3.setTagInfo(_td_c_iterate_172_3);
                        _jettag_c_iterate_172_3.doStart(context, out);
                        while (_jettag_c_iterate_172_3.okToProcessBody()) {
                            //check if the source is many side 
                            RuntimeTagElement _jettag_c_if_174_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_174_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_174_3.setRuntimeParent(_jettag_c_iterate_172_3);
                            _jettag_c_if_174_3.setTagInfo(_td_c_if_174_3);
                            _jettag_c_if_174_3.doStart(context, out);
                            while (_jettag_c_if_174_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_175_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_175_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_175_5.setRuntimeParent(_jettag_c_if_174_3);
                                _jettag_c_if_175_5.setTagInfo(_td_c_if_175_5);
                                _jettag_c_if_175_5.doStart(context, out);
                                while (_jettag_c_if_175_5.okToProcessBody()) {
                                    // check if the target association is navigable
                                    RuntimeTagElement _jettag_c_if_177_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_177_5); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_177_5.setRuntimeParent(_jettag_c_if_175_5);
                                    _jettag_c_if_177_5.setTagInfo(_td_c_if_177_5);
                                    _jettag_c_if_177_5.doStart(context, out);
                                    while (_jettag_c_if_177_5.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_178_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_178_4); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_178_4.setRuntimeParent(_jettag_c_if_177_5);
                                        _jettag_c_setVariable_178_4.setTagInfo(_td_c_setVariable_178_4);
                                        _jettag_c_setVariable_178_4.doStart(context, out);
                                        _jettag_c_setVariable_178_4.doEnd();
                                        // check is the association is corresponding to the class  
                                        RuntimeTagElement _jettag_c_if_180_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_180_6); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_180_6.setRuntimeParent(_jettag_c_if_177_5);
                                        _jettag_c_if_180_6.setTagInfo(_td_c_if_180_6);
                                        _jettag_c_if_180_6.doStart(context, out);
                                        while (_jettag_c_if_180_6.okToProcessBody()) {
                                            // process only compositions
                                            // iterate over the iterations ends  
                                            RuntimeTagElement _jettag_c_iterate_183_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_183_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_183_12.setRuntimeParent(_jettag_c_if_180_6);
                                            _jettag_c_iterate_183_12.setTagInfo(_td_c_iterate_183_12);
                                            _jettag_c_iterate_183_12.doStart(context, out);
                                            while (_jettag_c_iterate_183_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_184_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_184_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_184_12.setRuntimeParent(_jettag_c_iterate_183_12);
                                                _jettag_c_setVariable_184_12.setTagInfo(_td_c_setVariable_184_12);
                                                _jettag_c_setVariable_184_12.doStart(context, out);
                                                _jettag_c_setVariable_184_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_186_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_186_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_186_14.setRuntimeParent(_jettag_c_iterate_183_12);
                                                _jettag_c_if_186_14.setTagInfo(_td_c_if_186_14);
                                                _jettag_c_if_186_14.doStart(context, out);
                                                while (_jettag_c_if_186_14.okToProcessBody()) {
                                                    // process only non composites on target
                                                    RuntimeTagElement _jettag_c_if_188_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_188_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_188_14.setRuntimeParent(_jettag_c_if_186_14);
                                                    _jettag_c_if_188_14.setTagInfo(_td_c_if_188_14);
                                                    _jettag_c_if_188_14.doStart(context, out);
                                                    while (_jettag_c_if_188_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_190_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_190_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_190_15.setRuntimeParent(_jettag_c_if_188_14);
                                                        _jettag_c_iterate_190_15.setTagInfo(_td_c_iterate_190_15);
                                                        _jettag_c_iterate_190_15.doStart(context, out);
                                                        while (_jettag_c_iterate_190_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_191_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_191_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_191_16.setRuntimeParent(_jettag_c_iterate_190_15);
                                                            _jettag_c_if_191_16.setTagInfo(_td_c_if_191_16);
                                                            _jettag_c_if_191_16.doStart(context, out);
                                                            while (_jettag_c_if_191_16.okToProcessBody()) {
                                                                out.write("//TODO need to check parent realation in case to user AbstractTreePanel instead of TreePanel");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tif (parent.getEntity() instanceof ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 193, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$packageName}", 194, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 194, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 194, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Service.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 194, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("ServiceAsync.instance().remove");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 194, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 194, 141)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(((");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 194, 160)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy) parent.getEntity()).getId(),");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\tids, new ALAsyncCallback<Void>() {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(Void arg0) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tnew ResponseStatusWidget()");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.show(\"");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 200, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s removed from ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 200, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("\");");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t}\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_191_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_191_16.doEnd();
                                                            _jettag_c_iterate_190_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_190_15.doEnd();
                                                        _jettag_c_if_188_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_188_14.doEnd();
                                                    _jettag_c_if_186_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_186_14.doEnd();
                                                _jettag_c_iterate_183_12.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_183_12.doEnd();
                                            _jettag_c_if_180_6.handleBodyContent(out);
                                        }
                                        _jettag_c_if_180_6.doEnd();
                                        _jettag_c_if_177_5.handleBodyContent(out);
                                    }
                                    _jettag_c_if_177_5.doEnd();
                                    _jettag_c_if_175_5.handleBodyContent(out);
                                }
                                _jettag_c_if_175_5.doEnd();
                                _jettag_c_if_174_3.handleBodyContent(out);
                            }
                            _jettag_c_if_174_3.doEnd();
                            _jettag_c_iterate_172_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_172_3.doEnd();
                        _jettag_c_iterate_171_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_171_2.doEnd();
                    _jettag_c_iterate_170_2.handleBodyContent(out);
                }
                _jettag_c_iterate_170_2.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_221_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_221_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_221_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_221_1.setTagInfo(_td_f_message_221_1);
                _jettag_f_message_221_1.doStart(context, out);
                JET2Writer _jettag_f_message_221_1_saved_out = out;
                while (_jettag_f_message_221_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_221_1.handleBodyContent(out);
                }
                out = _jettag_f_message_221_1_saved_out;
                _jettag_f_message_221_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void addListeners() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t// TODO Auto-generated method stub");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_227_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_227_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_227_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_227_1.setTagInfo(_td_f_message_227_1);
                _jettag_f_message_227_1.doStart(context, out);
                JET2Writer _jettag_f_message_227_1_saved_out = out;
                while (_jettag_f_message_227_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_227_1.handleBodyContent(out);
                }
                out = _jettag_f_message_227_1_saved_out;
                _jettag_f_message_227_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void addWidgets() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t// TODO Auto-generated method stub");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_233_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_233_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_233_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_233_1.setTagInfo(_td_f_message_233_1);
                _jettag_f_message_233_1.doStart(context, out);
                JET2Writer _jettag_f_message_233_1_saved_out = out;
                while (_jettag_f_message_233_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_233_1.handleBodyContent(out);
                }
                out = _jettag_f_message_233_1_saved_out;
                _jettag_f_message_233_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void configure() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t// TODO Auto-generated method stub");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
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
        out.write(NL);         
    }
}
