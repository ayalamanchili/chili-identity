package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_select_panel_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_select_panel_templatejava() {
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
    private static final TagInfo _td_c_iterate_15_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            15, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_16_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            16, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_17_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            17, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_19_3 = new TagInfo("c:if", //$NON-NLS-1$
            19, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_20_5 = new TagInfo("c:if", //$NON-NLS-1$
            20, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_22_5 = new TagInfo("c:if", //$NON-NLS-1$
            22, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_23_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            23, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_25_6 = new TagInfo("c:if", //$NON-NLS-1$
            25, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_28_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            28, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_29_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            29, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_31_14 = new TagInfo("c:if", //$NON-NLS-1$
            31, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_33_14 = new TagInfo("c:if", //$NON-NLS-1$
            33, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_35_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            35, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_36_16 = new TagInfo("c:if", //$NON-NLS-1$
            36, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_53_1 = new TagInfo("f:message", //$NON-NLS-1$
            53, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_55_1 = new TagInfo("f:message", //$NON-NLS-1$
            55, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_60_1 = new TagInfo("f:message", //$NON-NLS-1$
            60, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_64_1 = new TagInfo("f:message", //$NON-NLS-1$
            64, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_68_1 = new TagInfo("f:message", //$NON-NLS-1$
            68, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_72_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            72, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_74_3 = new TagInfo("c:choose", //$NON-NLS-1$
            74, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_74_73 = new TagInfo("c:when", //$NON-NLS-1$
            74, 73,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_89_1 = new TagInfo("f:message", //$NON-NLS-1$
            89, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_104_1 = new TagInfo("f:message", //$NON-NLS-1$
            104, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_110_1 = new TagInfo("f:message", //$NON-NLS-1$
            110, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_116_1 = new TagInfo("f:message", //$NON-NLS-1$
            116, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_120_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            120, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_121_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            121, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_122_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            122, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_124_3 = new TagInfo("c:if", //$NON-NLS-1$
            124, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_125_5 = new TagInfo("c:if", //$NON-NLS-1$
            125, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_127_5 = new TagInfo("c:if", //$NON-NLS-1$
            127, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_128_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            128, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_130_6 = new TagInfo("c:if", //$NON-NLS-1$
            130, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_133_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            133, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_134_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            134, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_136_14 = new TagInfo("c:if", //$NON-NLS-1$
            136, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_138_14 = new TagInfo("c:if", //$NON-NLS-1$
            138, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_140_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            140, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_141_16 = new TagInfo("c:if", //$NON-NLS-1$
            141, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_161_1 = new TagInfo("f:message", //$NON-NLS-1$
            161, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_165_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            165, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_166_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            166, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_167_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            167, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_169_3 = new TagInfo("c:if", //$NON-NLS-1$
            169, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_170_5 = new TagInfo("c:if", //$NON-NLS-1$
            170, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_172_5 = new TagInfo("c:if", //$NON-NLS-1$
            172, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_173_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            173, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_175_6 = new TagInfo("c:if", //$NON-NLS-1$
            175, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_178_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            178, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_179_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            179, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_181_14 = new TagInfo("c:if", //$NON-NLS-1$
            181, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_183_14 = new TagInfo("c:if", //$NON-NLS-1$
            183, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_185_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            185, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_186_16 = new TagInfo("c:if", //$NON-NLS-1$
            186, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_206_1 = new TagInfo("f:message", //$NON-NLS-1$
            206, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_212_1 = new TagInfo("f:message", //$NON-NLS-1$
            212, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_218_1 = new TagInfo("f:message", //$NON-NLS-1$
            218, 1,
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
                out.write("import info.yalamanchili.gwt.composite.TreePanelComposite;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Set;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.SelectComposite;");  //$NON-NLS-1$        
                out.write(NL);         
                // process all many on source and non composites on target
                RuntimeTagElement _jettag_c_iterate_15_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_15_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_15_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_15_2.setTagInfo(_td_c_iterate_15_2);
                _jettag_c_iterate_15_2.doStart(context, out);
                while (_jettag_c_iterate_15_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_16_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_16_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_16_2.setRuntimeParent(_jettag_c_iterate_15_2);
                    _jettag_c_iterate_16_2.setTagInfo(_td_c_iterate_16_2);
                    _jettag_c_iterate_16_2.doStart(context, out);
                    while (_jettag_c_iterate_16_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_17_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_17_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_17_3.setRuntimeParent(_jettag_c_iterate_16_2);
                        _jettag_c_iterate_17_3.setTagInfo(_td_c_iterate_17_3);
                        _jettag_c_iterate_17_3.doStart(context, out);
                        while (_jettag_c_iterate_17_3.okToProcessBody()) {
                            //check if the source is many side 
                            RuntimeTagElement _jettag_c_if_19_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_19_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_19_3.setRuntimeParent(_jettag_c_iterate_17_3);
                            _jettag_c_if_19_3.setTagInfo(_td_c_if_19_3);
                            _jettag_c_if_19_3.doStart(context, out);
                            while (_jettag_c_if_19_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_20_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_20_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_20_5.setRuntimeParent(_jettag_c_if_19_3);
                                _jettag_c_if_20_5.setTagInfo(_td_c_if_20_5);
                                _jettag_c_if_20_5.doStart(context, out);
                                while (_jettag_c_if_20_5.okToProcessBody()) {
                                    // check if the target association is navigable
                                    RuntimeTagElement _jettag_c_if_22_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_22_5); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_22_5.setRuntimeParent(_jettag_c_if_20_5);
                                    _jettag_c_if_22_5.setTagInfo(_td_c_if_22_5);
                                    _jettag_c_if_22_5.doStart(context, out);
                                    while (_jettag_c_if_22_5.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_23_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_23_4); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_23_4.setRuntimeParent(_jettag_c_if_22_5);
                                        _jettag_c_setVariable_23_4.setTagInfo(_td_c_setVariable_23_4);
                                        _jettag_c_setVariable_23_4.doStart(context, out);
                                        _jettag_c_setVariable_23_4.doEnd();
                                        // check is the association is corresponding to the class  
                                        RuntimeTagElement _jettag_c_if_25_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_25_6); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_25_6.setRuntimeParent(_jettag_c_if_22_5);
                                        _jettag_c_if_25_6.setTagInfo(_td_c_if_25_6);
                                        _jettag_c_if_25_6.doStart(context, out);
                                        while (_jettag_c_if_25_6.okToProcessBody()) {
                                            // process only compositions
                                            // iterate over the iterations ends  
                                            RuntimeTagElement _jettag_c_iterate_28_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_28_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_28_12.setRuntimeParent(_jettag_c_if_25_6);
                                            _jettag_c_iterate_28_12.setTagInfo(_td_c_iterate_28_12);
                                            _jettag_c_iterate_28_12.doStart(context, out);
                                            while (_jettag_c_iterate_28_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_29_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_29_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_29_12.setRuntimeParent(_jettag_c_iterate_28_12);
                                                _jettag_c_setVariable_29_12.setTagInfo(_td_c_setVariable_29_12);
                                                _jettag_c_setVariable_29_12.doStart(context, out);
                                                _jettag_c_setVariable_29_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_31_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_31_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_31_14.setRuntimeParent(_jettag_c_iterate_28_12);
                                                _jettag_c_if_31_14.setTagInfo(_td_c_if_31_14);
                                                _jettag_c_if_31_14.doStart(context, out);
                                                while (_jettag_c_if_31_14.okToProcessBody()) {
                                                    // process only non composites on target
                                                    RuntimeTagElement _jettag_c_if_33_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_33_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_33_14.setRuntimeParent(_jettag_c_if_31_14);
                                                    _jettag_c_if_33_14.setTagInfo(_td_c_if_33_14);
                                                    _jettag_c_if_33_14.doStart(context, out);
                                                    while (_jettag_c_if_33_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_35_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_35_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_35_15.setRuntimeParent(_jettag_c_if_33_14);
                                                        _jettag_c_iterate_35_15.setTagInfo(_td_c_iterate_35_15);
                                                        _jettag_c_iterate_35_15.doStart(context, out);
                                                        while (_jettag_c_iterate_35_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_36_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_36_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_36_16.setRuntimeParent(_jettag_c_iterate_35_15);
                                                            _jettag_c_if_36_16.setTagInfo(_td_c_if_36_16);
                                                            _jettag_c_if_36_16.doStart(context, out);
                                                            while (_jettag_c_if_36_16.okToProcessBody()) {
                                                                out.write("import ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 37, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".entity.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 37, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 37, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(";");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_36_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_36_16.doEnd();
                                                            _jettag_c_iterate_35_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_35_15.doEnd();
                                                        _jettag_c_if_33_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_33_14.doEnd();
                                                    _jettag_c_if_31_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_31_14.doEnd();
                                                _jettag_c_iterate_28_12.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_28_12.doEnd();
                                            _jettag_c_if_25_6.handleBodyContent(out);
                                        }
                                        _jettag_c_if_25_6.doEnd();
                                        _jettag_c_if_22_5.handleBodyContent(out);
                                    }
                                    _jettag_c_if_22_5.doEnd();
                                    _jettag_c_if_20_5.handleBodyContent(out);
                                }
                                _jettag_c_if_20_5.doEnd();
                                _jettag_c_if_19_3.handleBodyContent(out);
                            }
                            _jettag_c_if_19_3.doEnd();
                            _jettag_c_iterate_17_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_17_3.doEnd();
                        _jettag_c_iterate_16_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_16_2.doEnd();
                    _jettag_c_iterate_15_2.handleBodyContent(out);
                }
                _jettag_c_iterate_15_2.doEnd();
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Map;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_53_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_53_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_53_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_53_1.setTagInfo(_td_f_message_53_1);
                _jettag_f_message_53_1.doStart(context, out);
                JET2Writer _jettag_f_message_53_1_saved_out = out;
                while (_jettag_f_message_53_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_53_1.handleBodyContent(out);
                }
                out = _jettag_f_message_53_1_saved_out;
                _jettag_f_message_53_1.doEnd();
                out.write(NL);         
                out.write("public class Select");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 54, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel extends SelectComposite<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 54, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_55_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_55_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_55_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_55_1.setTagInfo(_td_f_message_55_1);
                _jettag_f_message_55_1.doStart(context, out);
                JET2Writer _jettag_f_message_55_1_saved_out = out;
                while (_jettag_f_message_55_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_55_1.handleBodyContent(out);
                }
                out = _jettag_f_message_55_1_saved_out;
                _jettag_f_message_55_1.doEnd();
                out.write(NL);         
                out.write("\tpublic Select");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 56, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel(String title, TreePanelComposite parent,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tMap<Long, String> available, Set<Long> selected) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tsuper(title, parent, available, selected);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_60_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_60_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_60_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_60_1.setTagInfo(_td_f_message_60_1);
                _jettag_f_message_60_1.doStart(context, out);
                JET2Writer _jettag_f_message_60_1_saved_out = out;
                while (_jettag_f_message_60_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_60_1.handleBodyContent(out);
                }
                out = _jettag_f_message_60_1_saved_out;
                _jettag_f_message_60_1.doEnd();
                out.write(NL);         
                out.write("\tpublic Select");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 61, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel(String name) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tsuper(name);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_64_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_64_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_64_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_64_1.setTagInfo(_td_f_message_64_1);
                _jettag_f_message_64_1.doStart(context, out);
                JET2Writer _jettag_f_message_64_1_saved_out = out;
                while (_jettag_f_message_64_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_64_1.handleBodyContent(out);
                }
                out = _jettag_f_message_64_1_saved_out;
                _jettag_f_message_64_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic Select");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 65, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel(String name,");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 65, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tsuper(name,entity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_68_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_68_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_68_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_68_1.setTagInfo(_td_f_message_68_1);
                _jettag_f_message_68_1.doStart(context, out);
                JET2Writer _jettag_f_message_68_1_saved_out = out;
                while (_jettag_f_message_68_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_68_1.handleBodyContent(out);
                }
                out = _jettag_f_message_68_1_saved_out;
                _jettag_f_message_68_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void initListBox() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tString[] columns = { ");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_iterate_72_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_72_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_72_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_72_1.setTagInfo(_td_c_iterate_72_1);
                _jettag_c_iterate_72_1.doStart(context, out);
                while (_jettag_c_iterate_72_1.okToProcessBody()) {
                    // processes the premitive Datatypes 
                    out.write("\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_choose_74_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_74_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_74_3.setRuntimeParent(_jettag_c_iterate_72_1);
                    _jettag_c_choose_74_3.setTagInfo(_td_c_choose_74_3);
                    _jettag_c_choose_74_3.doStart(context, out);
                    JET2Writer _jettag_c_choose_74_3_saved_out = out;
                    while (_jettag_c_choose_74_3.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_74_73 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_74_73); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_74_73.setRuntimeParent(_jettag_c_choose_74_3);
                        _jettag_c_when_74_73.setTagInfo(_td_c_when_74_73);
                        _jettag_c_when_74_73.doStart(context, out);
                        JET2Writer _jettag_c_when_74_73_saved_out = out;
                        while (_jettag_c_when_74_73.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 74, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", ");  //$NON-NLS-1$        
                            _jettag_c_when_74_73.handleBodyContent(out);
                        }
                        out = _jettag_c_when_74_73_saved_out;
                        _jettag_c_when_74_73.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_choose_74_3.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_74_3_saved_out;
                    _jettag_c_choose_74_3.doEnd();
                    _jettag_c_iterate_72_1.handleBodyContent(out);
                }
                _jettag_c_iterate_72_1.doEnd();
                out.write("\t };");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 78, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 78, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 78, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 78, 70)); //$NON-NLS-1$ //$NON-NLS-2$
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
                RuntimeTagElement _jettag_f_message_89_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_89_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_89_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_89_1.setTagInfo(_td_f_message_89_1);
                _jettag_f_message_89_1.doStart(context, out);
                JET2Writer _jettag_f_message_89_1_saved_out = out;
                while (_jettag_f_message_89_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_89_1.handleBodyContent(out);
                }
                out = _jettag_f_message_89_1_saved_out;
                _jettag_f_message_89_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void getSelectedEntity(Long id) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 92, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 92, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 92, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 92, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync.instance().read(id,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tnew ALAsyncCallback<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 93, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\t\t\t\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\tpublic void onResponse(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 96, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" res) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tentity = res;");  //$NON-NLS-1$        
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
                RuntimeTagElement _jettag_f_message_104_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_104_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_104_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_104_1.setTagInfo(_td_f_message_104_1);
                _jettag_f_message_104_1.doStart(context, out);
                JET2Writer _jettag_f_message_104_1_saved_out = out;
                while (_jettag_f_message_104_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_104_1.handleBodyContent(out);
                }
                out = _jettag_f_message_104_1_saved_out;
                _jettag_f_message_104_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void setSelectedEntity(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 105, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tif (entity.getId() != null)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tlistBox.setItemSelected(valueIndex.get(entity.getId()), true);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_110_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_110_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_110_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_110_1.setTagInfo(_td_f_message_110_1);
                _jettag_f_message_110_1.doStart(context, out);
                JET2Writer _jettag_f_message_110_1_saved_out = out;
                while (_jettag_f_message_110_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_110_1.handleBodyContent(out);
                }
                out = _jettag_f_message_110_1_saved_out;
                _jettag_f_message_110_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_116_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_116_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_116_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_116_1.setTagInfo(_td_f_message_116_1);
                _jettag_f_message_116_1.doStart(context, out);
                JET2Writer _jettag_f_message_116_1_saved_out = out;
                while (_jettag_f_message_116_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_116_1.handleBodyContent(out);
                }
                out = _jettag_f_message_116_1_saved_out;
                _jettag_f_message_116_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void onAddAll(TreePanelComposite parent, List<Long> ids) {");  //$NON-NLS-1$        
                out.write(NL);         
                // process all many on source and non composites on target
                RuntimeTagElement _jettag_c_iterate_120_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_120_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_120_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_120_2.setTagInfo(_td_c_iterate_120_2);
                _jettag_c_iterate_120_2.doStart(context, out);
                while (_jettag_c_iterate_120_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_121_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_121_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_121_2.setRuntimeParent(_jettag_c_iterate_120_2);
                    _jettag_c_iterate_121_2.setTagInfo(_td_c_iterate_121_2);
                    _jettag_c_iterate_121_2.doStart(context, out);
                    while (_jettag_c_iterate_121_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_122_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_122_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_122_3.setRuntimeParent(_jettag_c_iterate_121_2);
                        _jettag_c_iterate_122_3.setTagInfo(_td_c_iterate_122_3);
                        _jettag_c_iterate_122_3.doStart(context, out);
                        while (_jettag_c_iterate_122_3.okToProcessBody()) {
                            //check if the source is many side 
                            RuntimeTagElement _jettag_c_if_124_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_124_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_124_3.setRuntimeParent(_jettag_c_iterate_122_3);
                            _jettag_c_if_124_3.setTagInfo(_td_c_if_124_3);
                            _jettag_c_if_124_3.doStart(context, out);
                            while (_jettag_c_if_124_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_125_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_125_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_125_5.setRuntimeParent(_jettag_c_if_124_3);
                                _jettag_c_if_125_5.setTagInfo(_td_c_if_125_5);
                                _jettag_c_if_125_5.doStart(context, out);
                                while (_jettag_c_if_125_5.okToProcessBody()) {
                                    // check if the target association is navigable
                                    RuntimeTagElement _jettag_c_if_127_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_127_5); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_127_5.setRuntimeParent(_jettag_c_if_125_5);
                                    _jettag_c_if_127_5.setTagInfo(_td_c_if_127_5);
                                    _jettag_c_if_127_5.doStart(context, out);
                                    while (_jettag_c_if_127_5.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_128_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_128_4); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_128_4.setRuntimeParent(_jettag_c_if_127_5);
                                        _jettag_c_setVariable_128_4.setTagInfo(_td_c_setVariable_128_4);
                                        _jettag_c_setVariable_128_4.doStart(context, out);
                                        _jettag_c_setVariable_128_4.doEnd();
                                        // check is the association is corresponding to the class  
                                        RuntimeTagElement _jettag_c_if_130_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_130_6); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_130_6.setRuntimeParent(_jettag_c_if_127_5);
                                        _jettag_c_if_130_6.setTagInfo(_td_c_if_130_6);
                                        _jettag_c_if_130_6.doStart(context, out);
                                        while (_jettag_c_if_130_6.okToProcessBody()) {
                                            // process only compositions
                                            // iterate over the iterations ends  
                                            RuntimeTagElement _jettag_c_iterate_133_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_133_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_133_12.setRuntimeParent(_jettag_c_if_130_6);
                                            _jettag_c_iterate_133_12.setTagInfo(_td_c_iterate_133_12);
                                            _jettag_c_iterate_133_12.doStart(context, out);
                                            while (_jettag_c_iterate_133_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_134_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_134_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_134_12.setRuntimeParent(_jettag_c_iterate_133_12);
                                                _jettag_c_setVariable_134_12.setTagInfo(_td_c_setVariable_134_12);
                                                _jettag_c_setVariable_134_12.doStart(context, out);
                                                _jettag_c_setVariable_134_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_136_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_136_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_136_14.setRuntimeParent(_jettag_c_iterate_133_12);
                                                _jettag_c_if_136_14.setTagInfo(_td_c_if_136_14);
                                                _jettag_c_if_136_14.doStart(context, out);
                                                while (_jettag_c_if_136_14.okToProcessBody()) {
                                                    // process only non composites on target
                                                    RuntimeTagElement _jettag_c_if_138_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_138_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_138_14.setRuntimeParent(_jettag_c_if_136_14);
                                                    _jettag_c_if_138_14.setTagInfo(_td_c_if_138_14);
                                                    _jettag_c_if_138_14.doStart(context, out);
                                                    while (_jettag_c_if_138_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_140_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_140_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_140_15.setRuntimeParent(_jettag_c_if_138_14);
                                                        _jettag_c_iterate_140_15.setTagInfo(_td_c_iterate_140_15);
                                                        _jettag_c_iterate_140_15.doStart(context, out);
                                                        while (_jettag_c_iterate_140_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_141_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_141_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_141_16.setRuntimeParent(_jettag_c_iterate_140_15);
                                                            _jettag_c_if_141_16.setTagInfo(_td_c_if_141_16);
                                                            _jettag_c_if_141_16.doStart(context, out);
                                                            while (_jettag_c_if_141_16.okToProcessBody()) {
                                                                out.write("//TODO need to check parent realation in case to user AbstractTreePanel instead of TreePanel");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tif (parent.getEntity() instanceof ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 143, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(") {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t}\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_141_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_141_16.doEnd();
                                                            _jettag_c_iterate_140_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_140_15.doEnd();
                                                        _jettag_c_if_138_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_138_14.doEnd();
                                                    _jettag_c_if_136_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_136_14.doEnd();
                                                _jettag_c_iterate_133_12.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_133_12.doEnd();
                                            _jettag_c_if_130_6.handleBodyContent(out);
                                        }
                                        _jettag_c_if_130_6.doEnd();
                                        _jettag_c_if_127_5.handleBodyContent(out);
                                    }
                                    _jettag_c_if_127_5.doEnd();
                                    _jettag_c_if_125_5.handleBodyContent(out);
                                }
                                _jettag_c_if_125_5.doEnd();
                                _jettag_c_if_124_3.handleBodyContent(out);
                            }
                            _jettag_c_if_124_3.doEnd();
                            _jettag_c_iterate_122_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_122_3.doEnd();
                        _jettag_c_iterate_121_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_121_2.doEnd();
                    _jettag_c_iterate_120_2.handleBodyContent(out);
                }
                _jettag_c_iterate_120_2.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_161_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_161_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_161_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_161_1.setTagInfo(_td_f_message_161_1);
                _jettag_f_message_161_1.doStart(context, out);
                JET2Writer _jettag_f_message_161_1_saved_out = out;
                while (_jettag_f_message_161_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_161_1.handleBodyContent(out);
                }
                out = _jettag_f_message_161_1_saved_out;
                _jettag_f_message_161_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void onRemoveAll(TreePanelComposite parent, List<Long> ids) {");  //$NON-NLS-1$        
                out.write(NL);         
                // process all many on source and non composites on target
                RuntimeTagElement _jettag_c_iterate_165_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_165_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_165_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_165_2.setTagInfo(_td_c_iterate_165_2);
                _jettag_c_iterate_165_2.doStart(context, out);
                while (_jettag_c_iterate_165_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_166_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_166_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_166_2.setRuntimeParent(_jettag_c_iterate_165_2);
                    _jettag_c_iterate_166_2.setTagInfo(_td_c_iterate_166_2);
                    _jettag_c_iterate_166_2.doStart(context, out);
                    while (_jettag_c_iterate_166_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_167_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_167_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_167_3.setRuntimeParent(_jettag_c_iterate_166_2);
                        _jettag_c_iterate_167_3.setTagInfo(_td_c_iterate_167_3);
                        _jettag_c_iterate_167_3.doStart(context, out);
                        while (_jettag_c_iterate_167_3.okToProcessBody()) {
                            //check if the source is many side 
                            RuntimeTagElement _jettag_c_if_169_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_169_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_169_3.setRuntimeParent(_jettag_c_iterate_167_3);
                            _jettag_c_if_169_3.setTagInfo(_td_c_if_169_3);
                            _jettag_c_if_169_3.doStart(context, out);
                            while (_jettag_c_if_169_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_170_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_170_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_170_5.setRuntimeParent(_jettag_c_if_169_3);
                                _jettag_c_if_170_5.setTagInfo(_td_c_if_170_5);
                                _jettag_c_if_170_5.doStart(context, out);
                                while (_jettag_c_if_170_5.okToProcessBody()) {
                                    // check if the target association is navigable
                                    RuntimeTagElement _jettag_c_if_172_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_172_5); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_172_5.setRuntimeParent(_jettag_c_if_170_5);
                                    _jettag_c_if_172_5.setTagInfo(_td_c_if_172_5);
                                    _jettag_c_if_172_5.doStart(context, out);
                                    while (_jettag_c_if_172_5.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_173_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_173_4); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_173_4.setRuntimeParent(_jettag_c_if_172_5);
                                        _jettag_c_setVariable_173_4.setTagInfo(_td_c_setVariable_173_4);
                                        _jettag_c_setVariable_173_4.doStart(context, out);
                                        _jettag_c_setVariable_173_4.doEnd();
                                        // check is the association is corresponding to the class  
                                        RuntimeTagElement _jettag_c_if_175_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_175_6); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_175_6.setRuntimeParent(_jettag_c_if_172_5);
                                        _jettag_c_if_175_6.setTagInfo(_td_c_if_175_6);
                                        _jettag_c_if_175_6.doStart(context, out);
                                        while (_jettag_c_if_175_6.okToProcessBody()) {
                                            // process only compositions
                                            // iterate over the iterations ends  
                                            RuntimeTagElement _jettag_c_iterate_178_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_178_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_178_12.setRuntimeParent(_jettag_c_if_175_6);
                                            _jettag_c_iterate_178_12.setTagInfo(_td_c_iterate_178_12);
                                            _jettag_c_iterate_178_12.doStart(context, out);
                                            while (_jettag_c_iterate_178_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_179_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_179_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_179_12.setRuntimeParent(_jettag_c_iterate_178_12);
                                                _jettag_c_setVariable_179_12.setTagInfo(_td_c_setVariable_179_12);
                                                _jettag_c_setVariable_179_12.doStart(context, out);
                                                _jettag_c_setVariable_179_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_181_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_181_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_181_14.setRuntimeParent(_jettag_c_iterate_178_12);
                                                _jettag_c_if_181_14.setTagInfo(_td_c_if_181_14);
                                                _jettag_c_if_181_14.doStart(context, out);
                                                while (_jettag_c_if_181_14.okToProcessBody()) {
                                                    // process only non composites on target
                                                    RuntimeTagElement _jettag_c_if_183_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_183_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_183_14.setRuntimeParent(_jettag_c_if_181_14);
                                                    _jettag_c_if_183_14.setTagInfo(_td_c_if_183_14);
                                                    _jettag_c_if_183_14.doStart(context, out);
                                                    while (_jettag_c_if_183_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_185_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_185_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_185_15.setRuntimeParent(_jettag_c_if_183_14);
                                                        _jettag_c_iterate_185_15.setTagInfo(_td_c_iterate_185_15);
                                                        _jettag_c_iterate_185_15.doStart(context, out);
                                                        while (_jettag_c_iterate_185_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_186_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_186_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_186_16.setRuntimeParent(_jettag_c_iterate_185_15);
                                                            _jettag_c_if_186_16.setTagInfo(_td_c_if_186_16);
                                                            _jettag_c_if_186_16.doStart(context, out);
                                                            while (_jettag_c_if_186_16.okToProcessBody()) {
                                                                out.write("//TODO need to check parent realation in case to user AbstractTreePanel instead of TreePanel");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tif (parent.getEntity() instanceof ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 188, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(") {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t}\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_186_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_186_16.doEnd();
                                                            _jettag_c_iterate_185_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_185_15.doEnd();
                                                        _jettag_c_if_183_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_183_14.doEnd();
                                                    _jettag_c_if_181_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_181_14.doEnd();
                                                _jettag_c_iterate_178_12.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_178_12.doEnd();
                                            _jettag_c_if_175_6.handleBodyContent(out);
                                        }
                                        _jettag_c_if_175_6.doEnd();
                                        _jettag_c_if_172_5.handleBodyContent(out);
                                    }
                                    _jettag_c_if_172_5.doEnd();
                                    _jettag_c_if_170_5.handleBodyContent(out);
                                }
                                _jettag_c_if_170_5.doEnd();
                                _jettag_c_if_169_3.handleBodyContent(out);
                            }
                            _jettag_c_if_169_3.doEnd();
                            _jettag_c_iterate_167_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_167_3.doEnd();
                        _jettag_c_iterate_166_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_166_2.doEnd();
                    _jettag_c_iterate_165_2.handleBodyContent(out);
                }
                _jettag_c_iterate_165_2.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_206_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_206_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_206_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_206_1.setTagInfo(_td_f_message_206_1);
                _jettag_f_message_206_1.doStart(context, out);
                JET2Writer _jettag_f_message_206_1_saved_out = out;
                while (_jettag_f_message_206_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_206_1.handleBodyContent(out);
                }
                out = _jettag_f_message_206_1_saved_out;
                _jettag_f_message_206_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_212_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_212_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_212_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_212_1.setTagInfo(_td_f_message_212_1);
                _jettag_f_message_212_1.doStart(context, out);
                JET2Writer _jettag_f_message_212_1_saved_out = out;
                while (_jettag_f_message_212_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_212_1.handleBodyContent(out);
                }
                out = _jettag_f_message_212_1_saved_out;
                _jettag_f_message_212_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_218_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_218_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_218_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_218_1.setTagInfo(_td_f_message_218_1);
                _jettag_f_message_218_1.doStart(context, out);
                JET2Writer _jettag_f_message_218_1_saved_out = out;
                while (_jettag_f_message_218_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_218_1.handleBodyContent(out);
                }
                out = _jettag_f_message_218_1_saved_out;
                _jettag_f_message_218_1.doEnd();
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
