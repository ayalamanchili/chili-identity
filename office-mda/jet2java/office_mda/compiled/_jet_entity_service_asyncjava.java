package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_service_asyncjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_entity_service_asyncjava() {
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
    private static final TagInfo _td_c_if_16_1 = new TagInfo("c:if", //$NON-NLS-1$
            16, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_17_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            17, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_18_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            18, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_19_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            19, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_20_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            20, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_21_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            21, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_23_6 = new TagInfo("c:if", //$NON-NLS-1$
            23, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_25_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            25, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_26_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            26, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_28_13 = new TagInfo("c:if", //$NON-NLS-1$
            28, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_30_9 = new TagInfo("c:if", //$NON-NLS-1$
            30, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_31_11 = new TagInfo("c:if", //$NON-NLS-1$
            31, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_33_14 = new TagInfo("c:if", //$NON-NLS-1$
            33, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
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
    private static final TagInfo _td_c_setVariable_50_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            50, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_52_1 = new TagInfo("c:if", //$NON-NLS-1$
            52, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_53_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            53, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_54_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            54, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_55_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            55, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_56_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            56, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_57_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            57, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_59_6 = new TagInfo("c:if", //$NON-NLS-1$
            59, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_61_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            61, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_62_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            62, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_64_13 = new TagInfo("c:if", //$NON-NLS-1$
            64, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_66_9 = new TagInfo("c:if", //$NON-NLS-1$
            66, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_67_11 = new TagInfo("c:if", //$NON-NLS-1$
            67, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_69_14 = new TagInfo("c:if", //$NON-NLS-1$
            69, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_71_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            71, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_72_16 = new TagInfo("c:if", //$NON-NLS-1$
            72, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_86_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            86, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_88_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            88, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_89_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            89, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_90_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            90, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_91_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            91, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_93_6 = new TagInfo("c:if", //$NON-NLS-1$
            93, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_95_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            95, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_96_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            96, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_98_13 = new TagInfo("c:if", //$NON-NLS-1$
            98, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_100_9 = new TagInfo("c:if", //$NON-NLS-1$
            100, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_101_11 = new TagInfo("c:if", //$NON-NLS-1$
            101, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_103_14 = new TagInfo("c:if", //$NON-NLS-1$
            103, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_105_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            105, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_106_16 = new TagInfo("c:if", //$NON-NLS-1$
            106, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_121_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            121, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_122_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            122, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_123_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            123, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_124_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            124, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_126_6 = new TagInfo("c:if", //$NON-NLS-1$
            126, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_128_6 = new TagInfo("c:if", //$NON-NLS-1$
            128, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_129_8 = new TagInfo("c:if", //$NON-NLS-1$
            129, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_131_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            131, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_133_12 = new TagInfo("c:if", //$NON-NLS-1$
            133, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
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
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_138_14 = new TagInfo("c:if", //$NON-NLS-1$
            138, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
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
    private static final TagInfo _td_c_iterate_157_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            157, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_158_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            158, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_159_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            159, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_160_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            160, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_162_6 = new TagInfo("c:if", //$NON-NLS-1$
            162, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_164_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            164, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_166_12 = new TagInfo("c:if", //$NON-NLS-1$
            166, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_167_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            167, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_169_14 = new TagInfo("c:if", //$NON-NLS-1$
            169, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_171_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            171, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_172_16 = new TagInfo("c:if", //$NON-NLS-1$
            172, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_174_12 = new TagInfo("c:if", //$NON-NLS-1$
            174, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@parent1 = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_177_12 = new TagInfo("c:if", //$NON-NLS-1$
            177, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@parent2 = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_197_2 = new TagInfo("f:message", //$NON-NLS-1$
            197, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_199_1 = new TagInfo("f:message", //$NON-NLS-1$
            199, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_203_1 = new TagInfo("f:message", //$NON-NLS-1$
            203, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_206_1 = new TagInfo("f:message", //$NON-NLS-1$
            206, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_209_1 = new TagInfo("f:message", //$NON-NLS-1$
            209, 1,
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
    private static final TagInfo _td_f_message_215_1 = new TagInfo("f:message", //$NON-NLS-1$
            215, 1,
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
    private static final TagInfo _td_f_message_221_1 = new TagInfo("f:message", //$NON-NLS-1$
            221, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_224_1 = new TagInfo("c:if", //$NON-NLS-1$
            224, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_225_1 = new TagInfo("f:message", //$NON-NLS-1$
            225, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_231_1 = new TagInfo("c:if", //$NON-NLS-1$
            231, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_232_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            232, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_233_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            233, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_234_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            234, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_235_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            235, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_236_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            236, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_238_6 = new TagInfo("c:if", //$NON-NLS-1$
            238, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_240_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            240, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_241_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            241, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_243_13 = new TagInfo("c:if", //$NON-NLS-1$
            243, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_245_9 = new TagInfo("c:if", //$NON-NLS-1$
            245, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_246_11 = new TagInfo("c:if", //$NON-NLS-1$
            246, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_248_14 = new TagInfo("c:if", //$NON-NLS-1$
            248, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_250_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            250, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_251_16 = new TagInfo("c:if", //$NON-NLS-1$
            251, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_252_1 = new TagInfo("f:message", //$NON-NLS-1$
            252, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_255_17 = new TagInfo("c:if", //$NON-NLS-1$
            255, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_256_1 = new TagInfo("f:message", //$NON-NLS-1$
            256, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_setVariable_271_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            271, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_273_1 = new TagInfo("c:if", //$NON-NLS-1$
            273, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_274_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            274, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_275_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            275, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_276_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            276, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_277_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            277, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_278_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            278, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_280_6 = new TagInfo("c:if", //$NON-NLS-1$
            280, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_282_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            282, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_283_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            283, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_285_13 = new TagInfo("c:if", //$NON-NLS-1$
            285, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_287_9 = new TagInfo("c:if", //$NON-NLS-1$
            287, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_288_11 = new TagInfo("c:if", //$NON-NLS-1$
            288, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_290_14 = new TagInfo("c:if", //$NON-NLS-1$
            290, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_292_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            292, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_293_16 = new TagInfo("c:if", //$NON-NLS-1$
            293, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_294_1 = new TagInfo("f:message", //$NON-NLS-1$
            294, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_297_17 = new TagInfo("c:if", //$NON-NLS-1$
            297, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_298_1 = new TagInfo("f:message", //$NON-NLS-1$
            298, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_setVariable_314_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            314, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_316_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            316, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_317_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            317, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_318_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            318, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_319_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            319, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_321_6 = new TagInfo("c:if", //$NON-NLS-1$
            321, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_323_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            323, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_324_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            324, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_326_13 = new TagInfo("c:if", //$NON-NLS-1$
            326, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_328_9 = new TagInfo("c:if", //$NON-NLS-1$
            328, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_329_11 = new TagInfo("c:if", //$NON-NLS-1$
            329, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_331_14 = new TagInfo("c:if", //$NON-NLS-1$
            331, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_333_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            333, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_334_16 = new TagInfo("c:if", //$NON-NLS-1$
            334, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_335_1 = new TagInfo("f:message", //$NON-NLS-1$
            335, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_338_17 = new TagInfo("c:if", //$NON-NLS-1$
            338, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_339_1 = new TagInfo("f:message", //$NON-NLS-1$
            339, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_356_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            356, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_357_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            357, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_358_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            358, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_359_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            359, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_361_6 = new TagInfo("c:if", //$NON-NLS-1$
            361, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_363_6 = new TagInfo("c:if", //$NON-NLS-1$
            363, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_364_8 = new TagInfo("c:if", //$NON-NLS-1$
            364, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_366_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            366, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_368_12 = new TagInfo("c:if", //$NON-NLS-1$
            368, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_369_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            369, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_371_14 = new TagInfo("c:if", //$NON-NLS-1$
            371, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_373_14 = new TagInfo("c:if", //$NON-NLS-1$
            373, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_375_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            375, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_376_16 = new TagInfo("c:if", //$NON-NLS-1$
            376, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_377_1 = new TagInfo("f:message", //$NON-NLS-1$
            377, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_393_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            393, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_394_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            394, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_395_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            395, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_396_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            396, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_398_6 = new TagInfo("c:if", //$NON-NLS-1$
            398, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_400_6 = new TagInfo("c:if", //$NON-NLS-1$
            400, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_401_8 = new TagInfo("c:if", //$NON-NLS-1$
            401, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_403_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            403, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_405_12 = new TagInfo("c:if", //$NON-NLS-1$
            405, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_406_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            406, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_408_14 = new TagInfo("c:if", //$NON-NLS-1$
            408, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_410_14 = new TagInfo("c:if", //$NON-NLS-1$
            410, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_412_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            412, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_413_16 = new TagInfo("c:if", //$NON-NLS-1$
            413, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_414_1 = new TagInfo("f:message", //$NON-NLS-1$
            414, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_431_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            431, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_432_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            432, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_433_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            433, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_434_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            434, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_436_6 = new TagInfo("c:if", //$NON-NLS-1$
            436, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_438_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            438, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_440_12 = new TagInfo("c:if", //$NON-NLS-1$
            440, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_441_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            441, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_443_14 = new TagInfo("c:if", //$NON-NLS-1$
            443, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_445_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            445, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_446_16 = new TagInfo("c:if", //$NON-NLS-1$
            446, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_447_1 = new TagInfo("f:message", //$NON-NLS-1$
            447, 1,
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
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.beans.TableObj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.beans.MultiSelectObjy;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 9, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 9, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 9, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.io.Serializable;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Map;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                // process all getRelated entities relations
                //process level2 generizations 
                RuntimeTagElement _jettag_c_if_16_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_16_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_16_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_16_1.setTagInfo(_td_c_if_16_1);
                _jettag_c_if_16_1.doStart(context, out);
                while (_jettag_c_if_16_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_17_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_17_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_17_6.setRuntimeParent(_jettag_c_if_16_1);
                    _jettag_c_setVariable_17_6.setTagInfo(_td_c_setVariable_17_6);
                    _jettag_c_setVariable_17_6.doStart(context, out);
                    _jettag_c_setVariable_17_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_18_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_18_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_18_6.setRuntimeParent(_jettag_c_if_16_1);
                    _jettag_c_iterate_18_6.setTagInfo(_td_c_iterate_18_6);
                    _jettag_c_iterate_18_6.doStart(context, out);
                    while (_jettag_c_iterate_18_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_19_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_19_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_19_2.setRuntimeParent(_jettag_c_iterate_18_6);
                        _jettag_c_iterate_19_2.setTagInfo(_td_c_iterate_19_2);
                        _jettag_c_iterate_19_2.doStart(context, out);
                        while (_jettag_c_iterate_19_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_20_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_20_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_20_3.setRuntimeParent(_jettag_c_iterate_19_2);
                            _jettag_c_iterate_20_3.setTagInfo(_td_c_iterate_20_3);
                            _jettag_c_iterate_20_3.doStart(context, out);
                            while (_jettag_c_iterate_20_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_21_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_21_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_21_4.setRuntimeParent(_jettag_c_iterate_20_3);
                                _jettag_c_setVariable_21_4.setTagInfo(_td_c_setVariable_21_4);
                                _jettag_c_setVariable_21_4.doStart(context, out);
                                _jettag_c_setVariable_21_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_23_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_23_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_23_6.setRuntimeParent(_jettag_c_iterate_20_3);
                                _jettag_c_if_23_6.setTagInfo(_td_c_if_23_6);
                                _jettag_c_if_23_6.doStart(context, out);
                                while (_jettag_c_if_23_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_25_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_25_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_25_12.setRuntimeParent(_jettag_c_if_23_6);
                                    _jettag_c_iterate_25_12.setTagInfo(_td_c_iterate_25_12);
                                    _jettag_c_iterate_25_12.doStart(context, out);
                                    while (_jettag_c_iterate_25_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_26_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_26_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_26_12.setRuntimeParent(_jettag_c_iterate_25_12);
                                        _jettag_c_setVariable_26_12.setTagInfo(_td_c_setVariable_26_12);
                                        _jettag_c_setVariable_26_12.doStart(context, out);
                                        _jettag_c_setVariable_26_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_28_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_28_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_28_13.setRuntimeParent(_jettag_c_iterate_25_12);
                                        _jettag_c_if_28_13.setTagInfo(_td_c_if_28_13);
                                        _jettag_c_if_28_13.doStart(context, out);
                                        while (_jettag_c_if_28_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_30_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_30_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_30_9.setRuntimeParent(_jettag_c_if_28_13);
                                            _jettag_c_if_30_9.setTagInfo(_td_c_if_30_9);
                                            _jettag_c_if_30_9.doStart(context, out);
                                            while (_jettag_c_if_30_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_31_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_31_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_31_11.setRuntimeParent(_jettag_c_if_30_9);
                                                _jettag_c_if_31_11.setTagInfo(_td_c_if_31_11);
                                                _jettag_c_if_31_11.doStart(context, out);
                                                while (_jettag_c_if_31_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_33_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_33_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_33_14.setRuntimeParent(_jettag_c_if_31_11);
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
                                                    _jettag_c_if_31_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_31_11.doEnd();
                                                _jettag_c_if_30_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_30_9.doEnd();
                                            _jettag_c_if_28_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_28_13.doEnd();
                                        _jettag_c_iterate_25_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_25_12.doEnd();
                                    _jettag_c_if_23_6.handleBodyContent(out);
                                }
                                _jettag_c_if_23_6.doEnd();
                                _jettag_c_iterate_20_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_20_3.doEnd();
                            _jettag_c_iterate_19_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_19_2.doEnd();
                        _jettag_c_iterate_18_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_18_6.doEnd();
                    _jettag_c_if_16_1.handleBodyContent(out);
                }
                _jettag_c_if_16_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_50_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_50_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_50_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_50_1.setTagInfo(_td_c_setVariable_50_1);
                _jettag_c_setVariable_50_1.doStart(context, out);
                _jettag_c_setVariable_50_1.doEnd();
                //process level 1 generizations 
                RuntimeTagElement _jettag_c_if_52_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_52_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_52_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_52_1.setTagInfo(_td_c_if_52_1);
                _jettag_c_if_52_1.doStart(context, out);
                while (_jettag_c_if_52_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_53_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_53_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_53_6.setRuntimeParent(_jettag_c_if_52_1);
                    _jettag_c_setVariable_53_6.setTagInfo(_td_c_setVariable_53_6);
                    _jettag_c_setVariable_53_6.doStart(context, out);
                    _jettag_c_setVariable_53_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_54_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_54_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_54_6.setRuntimeParent(_jettag_c_if_52_1);
                    _jettag_c_iterate_54_6.setTagInfo(_td_c_iterate_54_6);
                    _jettag_c_iterate_54_6.doStart(context, out);
                    while (_jettag_c_iterate_54_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_55_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_55_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_55_2.setRuntimeParent(_jettag_c_iterate_54_6);
                        _jettag_c_iterate_55_2.setTagInfo(_td_c_iterate_55_2);
                        _jettag_c_iterate_55_2.doStart(context, out);
                        while (_jettag_c_iterate_55_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_56_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_56_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_56_3.setRuntimeParent(_jettag_c_iterate_55_2);
                            _jettag_c_iterate_56_3.setTagInfo(_td_c_iterate_56_3);
                            _jettag_c_iterate_56_3.doStart(context, out);
                            while (_jettag_c_iterate_56_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_57_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_57_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_57_4.setRuntimeParent(_jettag_c_iterate_56_3);
                                _jettag_c_setVariable_57_4.setTagInfo(_td_c_setVariable_57_4);
                                _jettag_c_setVariable_57_4.doStart(context, out);
                                _jettag_c_setVariable_57_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_59_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_59_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_59_6.setRuntimeParent(_jettag_c_iterate_56_3);
                                _jettag_c_if_59_6.setTagInfo(_td_c_if_59_6);
                                _jettag_c_if_59_6.doStart(context, out);
                                while (_jettag_c_if_59_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_61_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_61_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_61_12.setRuntimeParent(_jettag_c_if_59_6);
                                    _jettag_c_iterate_61_12.setTagInfo(_td_c_iterate_61_12);
                                    _jettag_c_iterate_61_12.doStart(context, out);
                                    while (_jettag_c_iterate_61_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_62_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_62_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_62_12.setRuntimeParent(_jettag_c_iterate_61_12);
                                        _jettag_c_setVariable_62_12.setTagInfo(_td_c_setVariable_62_12);
                                        _jettag_c_setVariable_62_12.doStart(context, out);
                                        _jettag_c_setVariable_62_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_64_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_64_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_64_13.setRuntimeParent(_jettag_c_iterate_61_12);
                                        _jettag_c_if_64_13.setTagInfo(_td_c_if_64_13);
                                        _jettag_c_if_64_13.doStart(context, out);
                                        while (_jettag_c_if_64_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_66_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_66_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_66_9.setRuntimeParent(_jettag_c_if_64_13);
                                            _jettag_c_if_66_9.setTagInfo(_td_c_if_66_9);
                                            _jettag_c_if_66_9.doStart(context, out);
                                            while (_jettag_c_if_66_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_67_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_67_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_67_11.setRuntimeParent(_jettag_c_if_66_9);
                                                _jettag_c_if_67_11.setTagInfo(_td_c_if_67_11);
                                                _jettag_c_if_67_11.doStart(context, out);
                                                while (_jettag_c_if_67_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_69_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_69_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_69_14.setRuntimeParent(_jettag_c_if_67_11);
                                                    _jettag_c_if_69_14.setTagInfo(_td_c_if_69_14);
                                                    _jettag_c_if_69_14.doStart(context, out);
                                                    while (_jettag_c_if_69_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_71_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_71_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_71_15.setRuntimeParent(_jettag_c_if_69_14);
                                                        _jettag_c_iterate_71_15.setTagInfo(_td_c_iterate_71_15);
                                                        _jettag_c_iterate_71_15.doStart(context, out);
                                                        while (_jettag_c_iterate_71_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_72_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_72_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_72_16.setRuntimeParent(_jettag_c_iterate_71_15);
                                                            _jettag_c_if_72_16.setTagInfo(_td_c_if_72_16);
                                                            _jettag_c_if_72_16.doStart(context, out);
                                                            while (_jettag_c_if_72_16.okToProcessBody()) {
                                                                out.write("import ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 73, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".entity.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 73, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 73, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(";");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_72_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_72_16.doEnd();
                                                            _jettag_c_iterate_71_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_71_15.doEnd();
                                                        _jettag_c_if_69_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_69_14.doEnd();
                                                    _jettag_c_if_67_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_67_11.doEnd();
                                                _jettag_c_if_66_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_66_9.doEnd();
                                            _jettag_c_if_64_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_64_13.doEnd();
                                        _jettag_c_iterate_61_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_61_12.doEnd();
                                    _jettag_c_if_59_6.handleBodyContent(out);
                                }
                                _jettag_c_if_59_6.doEnd();
                                _jettag_c_iterate_56_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_56_3.doEnd();
                            _jettag_c_iterate_55_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_55_2.doEnd();
                        _jettag_c_iterate_54_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_54_6.doEnd();
                    _jettag_c_if_52_1.handleBodyContent(out);
                }
                _jettag_c_if_52_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_86_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_86_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_86_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_86_1.setTagInfo(_td_c_setVariable_86_1);
                _jettag_c_setVariable_86_1.doStart(context, out);
                _jettag_c_setVariable_86_1.doEnd();
                //level 0 
                RuntimeTagElement _jettag_c_iterate_88_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_88_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_88_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_88_1.setTagInfo(_td_c_iterate_88_1);
                _jettag_c_iterate_88_1.doStart(context, out);
                while (_jettag_c_iterate_88_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_89_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_89_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_89_2.setRuntimeParent(_jettag_c_iterate_88_1);
                    _jettag_c_iterate_89_2.setTagInfo(_td_c_iterate_89_2);
                    _jettag_c_iterate_89_2.doStart(context, out);
                    while (_jettag_c_iterate_89_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_90_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_90_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_90_3.setRuntimeParent(_jettag_c_iterate_89_2);
                        _jettag_c_iterate_90_3.setTagInfo(_td_c_iterate_90_3);
                        _jettag_c_iterate_90_3.doStart(context, out);
                        while (_jettag_c_iterate_90_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_91_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_91_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_91_4.setRuntimeParent(_jettag_c_iterate_90_3);
                            _jettag_c_setVariable_91_4.setTagInfo(_td_c_setVariable_91_4);
                            _jettag_c_setVariable_91_4.doStart(context, out);
                            _jettag_c_setVariable_91_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_93_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_93_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_93_6.setRuntimeParent(_jettag_c_iterate_90_3);
                            _jettag_c_if_93_6.setTagInfo(_td_c_if_93_6);
                            _jettag_c_if_93_6.doStart(context, out);
                            while (_jettag_c_if_93_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_95_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_95_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_95_12.setRuntimeParent(_jettag_c_if_93_6);
                                _jettag_c_iterate_95_12.setTagInfo(_td_c_iterate_95_12);
                                _jettag_c_iterate_95_12.doStart(context, out);
                                while (_jettag_c_iterate_95_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_96_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_96_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_96_12.setRuntimeParent(_jettag_c_iterate_95_12);
                                    _jettag_c_setVariable_96_12.setTagInfo(_td_c_setVariable_96_12);
                                    _jettag_c_setVariable_96_12.doStart(context, out);
                                    _jettag_c_setVariable_96_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_98_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_98_13); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_98_13.setRuntimeParent(_jettag_c_iterate_95_12);
                                    _jettag_c_if_98_13.setTagInfo(_td_c_if_98_13);
                                    _jettag_c_if_98_13.doStart(context, out);
                                    while (_jettag_c_if_98_13.okToProcessBody()) {
                                        // process many on target
                                        RuntimeTagElement _jettag_c_if_100_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_100_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_100_9.setRuntimeParent(_jettag_c_if_98_13);
                                        _jettag_c_if_100_9.setTagInfo(_td_c_if_100_9);
                                        _jettag_c_if_100_9.doStart(context, out);
                                        while (_jettag_c_if_100_9.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_101_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_101_11); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_101_11.setRuntimeParent(_jettag_c_if_100_9);
                                            _jettag_c_if_101_11.setTagInfo(_td_c_if_101_11);
                                            _jettag_c_if_101_11.doStart(context, out);
                                            while (_jettag_c_if_101_11.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_103_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_103_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_103_14.setRuntimeParent(_jettag_c_if_101_11);
                                                _jettag_c_if_103_14.setTagInfo(_td_c_if_103_14);
                                                _jettag_c_if_103_14.doStart(context, out);
                                                while (_jettag_c_if_103_14.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_105_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_105_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_105_15.setRuntimeParent(_jettag_c_if_103_14);
                                                    _jettag_c_iterate_105_15.setTagInfo(_td_c_iterate_105_15);
                                                    _jettag_c_iterate_105_15.doStart(context, out);
                                                    while (_jettag_c_iterate_105_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_106_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_106_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_106_16.setRuntimeParent(_jettag_c_iterate_105_15);
                                                        _jettag_c_if_106_16.setTagInfo(_td_c_if_106_16);
                                                        _jettag_c_if_106_16.doStart(context, out);
                                                        while (_jettag_c_if_106_16.okToProcessBody()) {
                                                            out.write("import ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 107, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".entity.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 107, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 107, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_106_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_106_16.doEnd();
                                                        _jettag_c_iterate_105_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_105_15.doEnd();
                                                    _jettag_c_if_103_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_103_14.doEnd();
                                                _jettag_c_if_101_11.handleBodyContent(out);
                                            }
                                            _jettag_c_if_101_11.doEnd();
                                            _jettag_c_if_100_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_100_9.doEnd();
                                        _jettag_c_if_98_13.handleBodyContent(out);
                                    }
                                    _jettag_c_if_98_13.doEnd();
                                    _jettag_c_iterate_95_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_95_12.doEnd();
                                _jettag_c_if_93_6.handleBodyContent(out);
                            }
                            _jettag_c_if_93_6.doEnd();
                            _jettag_c_iterate_90_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_90_3.doEnd();
                        _jettag_c_iterate_89_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_89_2.doEnd();
                    _jettag_c_iterate_88_1.handleBodyContent(out);
                }
                _jettag_c_iterate_88_1.doEnd();
                out.write(NL);         
                // process all addAll relations
                RuntimeTagElement _jettag_c_iterate_121_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_121_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_121_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_121_1.setTagInfo(_td_c_iterate_121_1);
                _jettag_c_iterate_121_1.doStart(context, out);
                while (_jettag_c_iterate_121_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_122_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_122_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_122_2.setRuntimeParent(_jettag_c_iterate_121_1);
                    _jettag_c_iterate_122_2.setTagInfo(_td_c_iterate_122_2);
                    _jettag_c_iterate_122_2.doStart(context, out);
                    while (_jettag_c_iterate_122_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_123_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_123_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_123_3.setRuntimeParent(_jettag_c_iterate_122_2);
                        _jettag_c_iterate_123_3.setTagInfo(_td_c_iterate_123_3);
                        _jettag_c_iterate_123_3.doStart(context, out);
                        while (_jettag_c_iterate_123_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_124_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_124_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_124_4.setRuntimeParent(_jettag_c_iterate_123_3);
                            _jettag_c_setVariable_124_4.setTagInfo(_td_c_setVariable_124_4);
                            _jettag_c_setVariable_124_4.doStart(context, out);
                            _jettag_c_setVariable_124_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_126_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_126_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_126_6.setRuntimeParent(_jettag_c_iterate_123_3);
                            _jettag_c_if_126_6.setTagInfo(_td_c_if_126_6);
                            _jettag_c_if_126_6.doStart(context, out);
                            while (_jettag_c_if_126_6.okToProcessBody()) {
                                // process only classes with many on source side
                                RuntimeTagElement _jettag_c_if_128_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_128_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_128_6.setRuntimeParent(_jettag_c_if_126_6);
                                _jettag_c_if_128_6.setTagInfo(_td_c_if_128_6);
                                _jettag_c_if_128_6.doStart(context, out);
                                while (_jettag_c_if_128_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_129_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_129_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_129_8.setRuntimeParent(_jettag_c_if_128_6);
                                    _jettag_c_if_129_8.setTagInfo(_td_c_if_129_8);
                                    _jettag_c_if_129_8.doStart(context, out);
                                    while (_jettag_c_if_129_8.okToProcessBody()) {
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_131_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_131_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_131_12.setRuntimeParent(_jettag_c_if_129_8);
                                        _jettag_c_iterate_131_12.setTagInfo(_td_c_iterate_131_12);
                                        _jettag_c_iterate_131_12.doStart(context, out);
                                        while (_jettag_c_iterate_131_12.okToProcessBody()) {
                                            // process only non composites 
                                            RuntimeTagElement _jettag_c_if_133_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_133_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_133_12.setRuntimeParent(_jettag_c_iterate_131_12);
                                            _jettag_c_if_133_12.setTagInfo(_td_c_if_133_12);
                                            _jettag_c_if_133_12.doStart(context, out);
                                            while (_jettag_c_if_133_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_134_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_134_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_134_12.setRuntimeParent(_jettag_c_if_133_12);
                                                _jettag_c_setVariable_134_12.setTagInfo(_td_c_setVariable_134_12);
                                                _jettag_c_setVariable_134_12.doStart(context, out);
                                                _jettag_c_setVariable_134_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_136_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_136_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_136_14.setRuntimeParent(_jettag_c_if_133_12);
                                                _jettag_c_if_136_14.setTagInfo(_td_c_if_136_14);
                                                _jettag_c_if_136_14.doStart(context, out);
                                                while (_jettag_c_if_136_14.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
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
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 142, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".entity.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 142, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 142, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(";");  //$NON-NLS-1$        
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
                                                _jettag_c_if_133_12.handleBodyContent(out);
                                            }
                                            _jettag_c_if_133_12.doEnd();
                                            _jettag_c_iterate_131_12.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_131_12.doEnd();
                                        _jettag_c_if_129_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_129_8.doEnd();
                                    _jettag_c_if_128_6.handleBodyContent(out);
                                }
                                _jettag_c_if_128_6.doEnd();
                                _jettag_c_if_126_6.handleBodyContent(out);
                            }
                            _jettag_c_if_126_6.doEnd();
                            _jettag_c_iterate_123_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_123_3.doEnd();
                        _jettag_c_iterate_122_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_122_2.doEnd();
                    _jettag_c_iterate_121_1.handleBodyContent(out);
                }
                _jettag_c_iterate_121_1.doEnd();
                out.write(NL);         
                // process all merge relations
                RuntimeTagElement _jettag_c_iterate_157_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_157_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_157_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_157_1.setTagInfo(_td_c_iterate_157_1);
                _jettag_c_iterate_157_1.doStart(context, out);
                while (_jettag_c_iterate_157_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_158_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_158_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_158_2.setRuntimeParent(_jettag_c_iterate_157_1);
                    _jettag_c_iterate_158_2.setTagInfo(_td_c_iterate_158_2);
                    _jettag_c_iterate_158_2.doStart(context, out);
                    while (_jettag_c_iterate_158_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_159_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_159_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_159_3.setRuntimeParent(_jettag_c_iterate_158_2);
                        _jettag_c_iterate_159_3.setTagInfo(_td_c_iterate_159_3);
                        _jettag_c_iterate_159_3.doStart(context, out);
                        while (_jettag_c_iterate_159_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_160_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_160_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_160_4.setRuntimeParent(_jettag_c_iterate_159_3);
                            _jettag_c_setVariable_160_4.setTagInfo(_td_c_setVariable_160_4);
                            _jettag_c_setVariable_160_4.doStart(context, out);
                            _jettag_c_setVariable_160_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_162_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_162_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_162_6.setRuntimeParent(_jettag_c_iterate_159_3);
                            _jettag_c_if_162_6.setTagInfo(_td_c_if_162_6);
                            _jettag_c_if_162_6.doStart(context, out);
                            while (_jettag_c_if_162_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_164_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_164_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_164_12.setRuntimeParent(_jettag_c_if_162_6);
                                _jettag_c_iterate_164_12.setTagInfo(_td_c_iterate_164_12);
                                _jettag_c_iterate_164_12.doStart(context, out);
                                while (_jettag_c_iterate_164_12.okToProcessBody()) {
                                    // process only  composites on target
                                    RuntimeTagElement _jettag_c_if_166_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_166_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_166_12.setRuntimeParent(_jettag_c_iterate_164_12);
                                    _jettag_c_if_166_12.setTagInfo(_td_c_if_166_12);
                                    _jettag_c_if_166_12.doStart(context, out);
                                    while (_jettag_c_if_166_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_167_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_167_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_167_12.setRuntimeParent(_jettag_c_if_166_12);
                                        _jettag_c_setVariable_167_12.setTagInfo(_td_c_setVariable_167_12);
                                        _jettag_c_setVariable_167_12.doStart(context, out);
                                        _jettag_c_setVariable_167_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_169_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_169_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_169_14.setRuntimeParent(_jettag_c_if_166_12);
                                        _jettag_c_if_169_14.setTagInfo(_td_c_if_169_14);
                                        _jettag_c_if_169_14.doStart(context, out);
                                        while (_jettag_c_if_169_14.okToProcessBody()) {
                                            // iterate throught all the classes to get the other class on the association
                                            RuntimeTagElement _jettag_c_iterate_171_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_171_15); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_171_15.setRuntimeParent(_jettag_c_if_169_14);
                                            _jettag_c_iterate_171_15.setTagInfo(_td_c_iterate_171_15);
                                            _jettag_c_iterate_171_15.doStart(context, out);
                                            while (_jettag_c_iterate_171_15.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_172_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_172_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_172_16.setRuntimeParent(_jettag_c_iterate_171_15);
                                                _jettag_c_if_172_16.setTagInfo(_td_c_if_172_16);
                                                _jettag_c_if_172_16.doStart(context, out);
                                                while (_jettag_c_if_172_16.okToProcessBody()) {
                                                    out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 173, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".entity.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 173, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 173, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    RuntimeTagElement _jettag_c_if_174_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_174_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_174_12.setRuntimeParent(_jettag_c_if_172_16);
                                                    _jettag_c_if_174_12.setTagInfo(_td_c_if_174_12);
                                                    _jettag_c_if_174_12.doStart(context, out);
                                                    while (_jettag_c_if_174_12.okToProcessBody()) {
                                                        out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 175, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entity.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 175, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@parentClass1Name}", 175, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_174_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_174_12.doEnd();
                                                    RuntimeTagElement _jettag_c_if_177_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_177_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_177_12.setRuntimeParent(_jettag_c_if_172_16);
                                                    _jettag_c_if_177_12.setTagInfo(_td_c_if_177_12);
                                                    _jettag_c_if_177_12.doStart(context, out);
                                                    while (_jettag_c_if_177_12.okToProcessBody()) {
                                                        out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 178, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entity.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 178, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@parentClass2Name}", 178, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_177_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_177_12.doEnd();
                                                    _jettag_c_if_172_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_172_16.doEnd();
                                                _jettag_c_iterate_171_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_171_15.doEnd();
                                            _jettag_c_if_169_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_169_14.doEnd();
                                        _jettag_c_if_166_12.handleBodyContent(out);
                                    }
                                    _jettag_c_if_166_12.doEnd();
                                    _jettag_c_iterate_164_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_164_12.doEnd();
                                _jettag_c_if_162_6.handleBodyContent(out);
                            }
                            _jettag_c_if_162_6.doEnd();
                            _jettag_c_iterate_159_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_159_3.doEnd();
                        _jettag_c_iterate_158_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_158_2.doEnd();
                    _jettag_c_iterate_157_1.handleBodyContent(out);
                }
                _jettag_c_iterate_157_1.doEnd();
                out.write("import com.google.gwt.user.client.rpc.AsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write(NL);         
                out.write("/**");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" * This is the interface the client code uses. You NEVER implement this");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" * directly, GWT does this for you, and calls are marshalled through to the Sync");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" * equivalent method in MyService on the server (which is a Seam component).");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" */");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_197_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_197_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_197_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_197_2.setTagInfo(_td_f_message_197_2);
                _jettag_f_message_197_2.doStart(context, out);
                JET2Writer _jettag_f_message_197_2_saved_out = out;
                while (_jettag_f_message_197_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_197_2.handleBodyContent(out);
                }
                out = _jettag_f_message_197_2_saved_out;
                _jettag_f_message_197_2.doEnd();
                out.write(NL);         
                out.write("public interface ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 198, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync  {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_199_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_199_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_199_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_199_1.setTagInfo(_td_f_message_199_1);
                _jettag_f_message_199_1.doStart(context, out);
                JET2Writer _jettag_f_message_199_1_saved_out = out;
                while (_jettag_f_message_199_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_199_1.handleBodyContent(out);
                }
                out = _jettag_f_message_199_1_saved_out;
                _jettag_f_message_199_1.doEnd();
                out.write(NL);         
                out.write("\tpublic void create(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 200, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tAsyncCallback<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 201, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> response);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_203_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_203_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_203_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_203_1.setTagInfo(_td_f_message_203_1);
                _jettag_f_message_203_1.doStart(context, out);
                JET2Writer _jettag_f_message_203_1_saved_out = out;
                while (_jettag_f_message_203_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_203_1.handleBodyContent(out);
                }
                out = _jettag_f_message_203_1_saved_out;
                _jettag_f_message_203_1.doEnd();
                out.write(NL);         
                out.write("\tpublic  void read( Long id,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tAsyncCallback<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 205, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> response);");  //$NON-NLS-1$        
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
                out.write("\tpublic void update(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 207, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tAsyncCallback<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 208, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> response);");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_209_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_209_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_209_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_209_1.setTagInfo(_td_f_message_209_1);
                _jettag_f_message_209_1.doStart(context, out);
                JET2Writer _jettag_f_message_209_1_saved_out = out;
                while (_jettag_f_message_209_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_209_1.handleBodyContent(out);
                }
                out = _jettag_f_message_209_1_saved_out;
                _jettag_f_message_209_1.doEnd();
                out.write(NL);         
                out.write("\tpublic void delete(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 210, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tAsyncCallback<java.lang.Void> response);");  //$NON-NLS-1$        
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
                out.write("\tpublic  void getTableObj(int start,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tAsyncCallback<TableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 214, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">> response);");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_215_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_215_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_215_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_215_1.setTagInfo(_td_f_message_215_1);
                _jettag_f_message_215_1.doStart(context, out);
                JET2Writer _jettag_f_message_215_1_saved_out = out;
                while (_jettag_f_message_215_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_215_1.handleBodyContent(out);
                }
                out = _jettag_f_message_215_1_saved_out;
                _jettag_f_message_215_1.doEnd();
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic  void getSuggestionsForName(String name,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 217, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity, AsyncCallback<List<String>> response);");  //$NON-NLS-1$        
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
                out.write("\tpublic  void getEntities(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 219, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tAsyncCallback<List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 220, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">> response);");  //$NON-NLS-1$        
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
                out.write("\tpublic void getListBoxValues(String[] columns, AsyncCallback<Map<Long, String>> response);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_if_224_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_224_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_224_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_224_1.setTagInfo(_td_c_if_224_1);
                _jettag_c_if_224_1.doStart(context, out);
                while (_jettag_c_if_224_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_f_message_225_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_225_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_225_1.setRuntimeParent(_jettag_c_if_224_1);
                    _jettag_f_message_225_1.setTagInfo(_td_f_message_225_1);
                    _jettag_f_message_225_1.doStart(context, out);
                    JET2Writer _jettag_f_message_225_1_saved_out = out;
                    while (_jettag_f_message_225_1.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_225_1.handleBodyContent(out);
                    }
                    out = _jettag_f_message_225_1_saved_out;
                    _jettag_f_message_225_1.doEnd();
                    out.write(NL);         
                    out.write("\tpublic void search(String searchText, AsyncCallback<List<");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 226, 59)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(">> response);");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_224_1.handleBodyContent(out);
                }
                _jettag_c_if_224_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process all getRelated entities relations
                //process level2 generizations 
                RuntimeTagElement _jettag_c_if_231_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_231_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_231_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_231_1.setTagInfo(_td_c_if_231_1);
                _jettag_c_if_231_1.doStart(context, out);
                while (_jettag_c_if_231_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_232_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_232_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_232_6.setRuntimeParent(_jettag_c_if_231_1);
                    _jettag_c_setVariable_232_6.setTagInfo(_td_c_setVariable_232_6);
                    _jettag_c_setVariable_232_6.doStart(context, out);
                    _jettag_c_setVariable_232_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_233_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_233_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_233_6.setRuntimeParent(_jettag_c_if_231_1);
                    _jettag_c_iterate_233_6.setTagInfo(_td_c_iterate_233_6);
                    _jettag_c_iterate_233_6.doStart(context, out);
                    while (_jettag_c_iterate_233_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_234_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_234_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_234_2.setRuntimeParent(_jettag_c_iterate_233_6);
                        _jettag_c_iterate_234_2.setTagInfo(_td_c_iterate_234_2);
                        _jettag_c_iterate_234_2.doStart(context, out);
                        while (_jettag_c_iterate_234_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_235_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_235_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_235_3.setRuntimeParent(_jettag_c_iterate_234_2);
                            _jettag_c_iterate_235_3.setTagInfo(_td_c_iterate_235_3);
                            _jettag_c_iterate_235_3.doStart(context, out);
                            while (_jettag_c_iterate_235_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_236_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_236_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_236_4.setRuntimeParent(_jettag_c_iterate_235_3);
                                _jettag_c_setVariable_236_4.setTagInfo(_td_c_setVariable_236_4);
                                _jettag_c_setVariable_236_4.doStart(context, out);
                                _jettag_c_setVariable_236_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_238_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_238_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_238_6.setRuntimeParent(_jettag_c_iterate_235_3);
                                _jettag_c_if_238_6.setTagInfo(_td_c_if_238_6);
                                _jettag_c_if_238_6.doStart(context, out);
                                while (_jettag_c_if_238_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_240_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_240_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_240_12.setRuntimeParent(_jettag_c_if_238_6);
                                    _jettag_c_iterate_240_12.setTagInfo(_td_c_iterate_240_12);
                                    _jettag_c_iterate_240_12.doStart(context, out);
                                    while (_jettag_c_iterate_240_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_241_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_241_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_241_12.setRuntimeParent(_jettag_c_iterate_240_12);
                                        _jettag_c_setVariable_241_12.setTagInfo(_td_c_setVariable_241_12);
                                        _jettag_c_setVariable_241_12.doStart(context, out);
                                        _jettag_c_setVariable_241_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_243_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_243_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_243_13.setRuntimeParent(_jettag_c_iterate_240_12);
                                        _jettag_c_if_243_13.setTagInfo(_td_c_if_243_13);
                                        _jettag_c_if_243_13.doStart(context, out);
                                        while (_jettag_c_if_243_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_245_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_245_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_245_9.setRuntimeParent(_jettag_c_if_243_13);
                                            _jettag_c_if_245_9.setTagInfo(_td_c_if_245_9);
                                            _jettag_c_if_245_9.doStart(context, out);
                                            while (_jettag_c_if_245_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_246_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_246_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_246_11.setRuntimeParent(_jettag_c_if_245_9);
                                                _jettag_c_if_246_11.setTagInfo(_td_c_if_246_11);
                                                _jettag_c_if_246_11.doStart(context, out);
                                                while (_jettag_c_if_246_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_248_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_248_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_248_14.setRuntimeParent(_jettag_c_if_246_11);
                                                    _jettag_c_if_248_14.setTagInfo(_td_c_if_248_14);
                                                    _jettag_c_if_248_14.doStart(context, out);
                                                    while (_jettag_c_if_248_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_250_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_250_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_250_15.setRuntimeParent(_jettag_c_if_248_14);
                                                        _jettag_c_iterate_250_15.setTagInfo(_td_c_iterate_250_15);
                                                        _jettag_c_iterate_250_15.doStart(context, out);
                                                        while (_jettag_c_iterate_250_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_251_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_251_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_251_16.setRuntimeParent(_jettag_c_iterate_250_15);
                                                            _jettag_c_if_251_16.setTagInfo(_td_c_if_251_16);
                                                            _jettag_c_if_251_16.doStart(context, out);
                                                            while (_jettag_c_if_251_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_252_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_252_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_252_1.setRuntimeParent(_jettag_c_if_251_16);
                                                                _jettag_f_message_252_1.setTagInfo(_td_f_message_252_1);
                                                                _jettag_f_message_252_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_252_1_saved_out = out;
                                                                while (_jettag_f_message_252_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_252_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_252_1_saved_out;
                                                                _jettag_f_message_252_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("public void get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 253, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long entityID,AsyncCallback<List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 253, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(">> response);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                // check to see if the parent side is aggregation or none
                                                                RuntimeTagElement _jettag_c_if_255_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_255_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_255_17.setRuntimeParent(_jettag_c_if_251_16);
                                                                _jettag_c_if_255_17.setTagInfo(_td_c_if_255_17);
                                                                _jettag_c_if_255_17.doStart(context, out);
                                                                while (_jettag_c_if_255_17.okToProcessBody()) {
                                                                    RuntimeTagElement _jettag_f_message_256_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_256_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_256_1.setRuntimeParent(_jettag_c_if_255_17);
                                                                    _jettag_f_message_256_1.setTagInfo(_td_f_message_256_1);
                                                                    _jettag_f_message_256_1.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_256_1_saved_out = out;
                                                                    while (_jettag_f_message_256_1.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_256_1.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_256_1_saved_out;
                                                                    _jettag_f_message_256_1.doEnd();
                                                                    out.write("\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\tpublic void get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 257, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sMultiSelect(Long entityID, String[] columns,AsyncCallback<MultiSelectObjy> response);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_255_17.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_255_17.doEnd();
                                                                _jettag_c_if_251_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_251_16.doEnd();
                                                            _jettag_c_iterate_250_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_250_15.doEnd();
                                                        _jettag_c_if_248_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_248_14.doEnd();
                                                    _jettag_c_if_246_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_246_11.doEnd();
                                                _jettag_c_if_245_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_245_9.doEnd();
                                            _jettag_c_if_243_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_243_13.doEnd();
                                        _jettag_c_iterate_240_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_240_12.doEnd();
                                    _jettag_c_if_238_6.handleBodyContent(out);
                                }
                                _jettag_c_if_238_6.doEnd();
                                _jettag_c_iterate_235_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_235_3.doEnd();
                            _jettag_c_iterate_234_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_234_2.doEnd();
                        _jettag_c_iterate_233_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_233_6.doEnd();
                    _jettag_c_if_231_1.handleBodyContent(out);
                }
                _jettag_c_if_231_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_271_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_271_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_271_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_271_1.setTagInfo(_td_c_setVariable_271_1);
                _jettag_c_setVariable_271_1.doStart(context, out);
                _jettag_c_setVariable_271_1.doEnd();
                //process level 1 generizations 
                RuntimeTagElement _jettag_c_if_273_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_273_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_273_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_273_1.setTagInfo(_td_c_if_273_1);
                _jettag_c_if_273_1.doStart(context, out);
                while (_jettag_c_if_273_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_274_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_274_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_274_6.setRuntimeParent(_jettag_c_if_273_1);
                    _jettag_c_setVariable_274_6.setTagInfo(_td_c_setVariable_274_6);
                    _jettag_c_setVariable_274_6.doStart(context, out);
                    _jettag_c_setVariable_274_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_275_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_275_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_275_6.setRuntimeParent(_jettag_c_if_273_1);
                    _jettag_c_iterate_275_6.setTagInfo(_td_c_iterate_275_6);
                    _jettag_c_iterate_275_6.doStart(context, out);
                    while (_jettag_c_iterate_275_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_276_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_276_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_276_2.setRuntimeParent(_jettag_c_iterate_275_6);
                        _jettag_c_iterate_276_2.setTagInfo(_td_c_iterate_276_2);
                        _jettag_c_iterate_276_2.doStart(context, out);
                        while (_jettag_c_iterate_276_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_277_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_277_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_277_3.setRuntimeParent(_jettag_c_iterate_276_2);
                            _jettag_c_iterate_277_3.setTagInfo(_td_c_iterate_277_3);
                            _jettag_c_iterate_277_3.doStart(context, out);
                            while (_jettag_c_iterate_277_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_278_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_278_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_278_4.setRuntimeParent(_jettag_c_iterate_277_3);
                                _jettag_c_setVariable_278_4.setTagInfo(_td_c_setVariable_278_4);
                                _jettag_c_setVariable_278_4.doStart(context, out);
                                _jettag_c_setVariable_278_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_280_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_280_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_280_6.setRuntimeParent(_jettag_c_iterate_277_3);
                                _jettag_c_if_280_6.setTagInfo(_td_c_if_280_6);
                                _jettag_c_if_280_6.doStart(context, out);
                                while (_jettag_c_if_280_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_282_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_282_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_282_12.setRuntimeParent(_jettag_c_if_280_6);
                                    _jettag_c_iterate_282_12.setTagInfo(_td_c_iterate_282_12);
                                    _jettag_c_iterate_282_12.doStart(context, out);
                                    while (_jettag_c_iterate_282_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_283_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_283_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_283_12.setRuntimeParent(_jettag_c_iterate_282_12);
                                        _jettag_c_setVariable_283_12.setTagInfo(_td_c_setVariable_283_12);
                                        _jettag_c_setVariable_283_12.doStart(context, out);
                                        _jettag_c_setVariable_283_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_285_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_285_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_285_13.setRuntimeParent(_jettag_c_iterate_282_12);
                                        _jettag_c_if_285_13.setTagInfo(_td_c_if_285_13);
                                        _jettag_c_if_285_13.doStart(context, out);
                                        while (_jettag_c_if_285_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_287_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_287_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_287_9.setRuntimeParent(_jettag_c_if_285_13);
                                            _jettag_c_if_287_9.setTagInfo(_td_c_if_287_9);
                                            _jettag_c_if_287_9.doStart(context, out);
                                            while (_jettag_c_if_287_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_288_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_288_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_288_11.setRuntimeParent(_jettag_c_if_287_9);
                                                _jettag_c_if_288_11.setTagInfo(_td_c_if_288_11);
                                                _jettag_c_if_288_11.doStart(context, out);
                                                while (_jettag_c_if_288_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_290_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_290_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_290_14.setRuntimeParent(_jettag_c_if_288_11);
                                                    _jettag_c_if_290_14.setTagInfo(_td_c_if_290_14);
                                                    _jettag_c_if_290_14.doStart(context, out);
                                                    while (_jettag_c_if_290_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_292_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_292_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_292_15.setRuntimeParent(_jettag_c_if_290_14);
                                                        _jettag_c_iterate_292_15.setTagInfo(_td_c_iterate_292_15);
                                                        _jettag_c_iterate_292_15.doStart(context, out);
                                                        while (_jettag_c_iterate_292_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_293_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_293_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_293_16.setRuntimeParent(_jettag_c_iterate_292_15);
                                                            _jettag_c_if_293_16.setTagInfo(_td_c_if_293_16);
                                                            _jettag_c_if_293_16.doStart(context, out);
                                                            while (_jettag_c_if_293_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_294_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_294_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_294_1.setRuntimeParent(_jettag_c_if_293_16);
                                                                _jettag_f_message_294_1.setTagInfo(_td_f_message_294_1);
                                                                _jettag_f_message_294_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_294_1_saved_out = out;
                                                                while (_jettag_f_message_294_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_294_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_294_1_saved_out;
                                                                _jettag_f_message_294_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("public void get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 295, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long entityID,AsyncCallback<List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 295, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(">> response);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                // check to see if the parent side is aggregation or none
                                                                RuntimeTagElement _jettag_c_if_297_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_297_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_297_17.setRuntimeParent(_jettag_c_if_293_16);
                                                                _jettag_c_if_297_17.setTagInfo(_td_c_if_297_17);
                                                                _jettag_c_if_297_17.doStart(context, out);
                                                                while (_jettag_c_if_297_17.okToProcessBody()) {
                                                                    RuntimeTagElement _jettag_f_message_298_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_298_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_298_1.setRuntimeParent(_jettag_c_if_297_17);
                                                                    _jettag_f_message_298_1.setTagInfo(_td_f_message_298_1);
                                                                    _jettag_f_message_298_1.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_298_1_saved_out = out;
                                                                    while (_jettag_f_message_298_1.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_298_1.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_298_1_saved_out;
                                                                    _jettag_f_message_298_1.doEnd();
                                                                    out.write("\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\tpublic void get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 299, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sMultiSelect(Long entityID, String[] columns,AsyncCallback<MultiSelectObjy> response);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_297_17.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_297_17.doEnd();
                                                                _jettag_c_if_293_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_293_16.doEnd();
                                                            out.write("   \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_iterate_292_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_292_15.doEnd();
                                                        _jettag_c_if_290_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_290_14.doEnd();
                                                    _jettag_c_if_288_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_288_11.doEnd();
                                                _jettag_c_if_287_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_287_9.doEnd();
                                            _jettag_c_if_285_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_285_13.doEnd();
                                        _jettag_c_iterate_282_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_282_12.doEnd();
                                    _jettag_c_if_280_6.handleBodyContent(out);
                                }
                                _jettag_c_if_280_6.doEnd();
                                _jettag_c_iterate_277_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_277_3.doEnd();
                            _jettag_c_iterate_276_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_276_2.doEnd();
                        _jettag_c_iterate_275_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_275_6.doEnd();
                    _jettag_c_if_273_1.handleBodyContent(out);
                }
                _jettag_c_if_273_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_314_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_314_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_314_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_314_1.setTagInfo(_td_c_setVariable_314_1);
                _jettag_c_setVariable_314_1.doStart(context, out);
                _jettag_c_setVariable_314_1.doEnd();
                //level 0 
                RuntimeTagElement _jettag_c_iterate_316_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_316_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_316_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_316_1.setTagInfo(_td_c_iterate_316_1);
                _jettag_c_iterate_316_1.doStart(context, out);
                while (_jettag_c_iterate_316_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_317_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_317_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_317_2.setRuntimeParent(_jettag_c_iterate_316_1);
                    _jettag_c_iterate_317_2.setTagInfo(_td_c_iterate_317_2);
                    _jettag_c_iterate_317_2.doStart(context, out);
                    while (_jettag_c_iterate_317_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_318_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_318_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_318_3.setRuntimeParent(_jettag_c_iterate_317_2);
                        _jettag_c_iterate_318_3.setTagInfo(_td_c_iterate_318_3);
                        _jettag_c_iterate_318_3.doStart(context, out);
                        while (_jettag_c_iterate_318_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_319_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_319_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_319_4.setRuntimeParent(_jettag_c_iterate_318_3);
                            _jettag_c_setVariable_319_4.setTagInfo(_td_c_setVariable_319_4);
                            _jettag_c_setVariable_319_4.doStart(context, out);
                            _jettag_c_setVariable_319_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_321_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_321_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_321_6.setRuntimeParent(_jettag_c_iterate_318_3);
                            _jettag_c_if_321_6.setTagInfo(_td_c_if_321_6);
                            _jettag_c_if_321_6.doStart(context, out);
                            while (_jettag_c_if_321_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_323_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_323_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_323_12.setRuntimeParent(_jettag_c_if_321_6);
                                _jettag_c_iterate_323_12.setTagInfo(_td_c_iterate_323_12);
                                _jettag_c_iterate_323_12.doStart(context, out);
                                while (_jettag_c_iterate_323_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_324_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_324_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_324_12.setRuntimeParent(_jettag_c_iterate_323_12);
                                    _jettag_c_setVariable_324_12.setTagInfo(_td_c_setVariable_324_12);
                                    _jettag_c_setVariable_324_12.doStart(context, out);
                                    _jettag_c_setVariable_324_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_326_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_326_13); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_326_13.setRuntimeParent(_jettag_c_iterate_323_12);
                                    _jettag_c_if_326_13.setTagInfo(_td_c_if_326_13);
                                    _jettag_c_if_326_13.doStart(context, out);
                                    while (_jettag_c_if_326_13.okToProcessBody()) {
                                        // process many on target
                                        RuntimeTagElement _jettag_c_if_328_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_328_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_328_9.setRuntimeParent(_jettag_c_if_326_13);
                                        _jettag_c_if_328_9.setTagInfo(_td_c_if_328_9);
                                        _jettag_c_if_328_9.doStart(context, out);
                                        while (_jettag_c_if_328_9.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_329_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_329_11); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_329_11.setRuntimeParent(_jettag_c_if_328_9);
                                            _jettag_c_if_329_11.setTagInfo(_td_c_if_329_11);
                                            _jettag_c_if_329_11.doStart(context, out);
                                            while (_jettag_c_if_329_11.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_331_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_331_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_331_14.setRuntimeParent(_jettag_c_if_329_11);
                                                _jettag_c_if_331_14.setTagInfo(_td_c_if_331_14);
                                                _jettag_c_if_331_14.doStart(context, out);
                                                while (_jettag_c_if_331_14.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_333_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_333_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_333_15.setRuntimeParent(_jettag_c_if_331_14);
                                                    _jettag_c_iterate_333_15.setTagInfo(_td_c_iterate_333_15);
                                                    _jettag_c_iterate_333_15.doStart(context, out);
                                                    while (_jettag_c_iterate_333_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_334_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_334_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_334_16.setRuntimeParent(_jettag_c_iterate_333_15);
                                                        _jettag_c_if_334_16.setTagInfo(_td_c_if_334_16);
                                                        _jettag_c_if_334_16.doStart(context, out);
                                                        while (_jettag_c_if_334_16.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_f_message_335_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_335_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_335_1.setRuntimeParent(_jettag_c_if_334_16);
                                                            _jettag_f_message_335_1.setTagInfo(_td_f_message_335_1);
                                                            _jettag_f_message_335_1.doStart(context, out);
                                                            JET2Writer _jettag_f_message_335_1_saved_out = out;
                                                            while (_jettag_f_message_335_1.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_335_1.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_335_1_saved_out;
                                                            _jettag_f_message_335_1.doEnd();
                                                            out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("public void get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 336, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s(Long entityID,AsyncCallback<List<");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 336, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(">> response);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            // check to see if the parent side is aggregation or none
                                                            RuntimeTagElement _jettag_c_if_338_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_338_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_338_17.setRuntimeParent(_jettag_c_if_334_16);
                                                            _jettag_c_if_338_17.setTagInfo(_td_c_if_338_17);
                                                            _jettag_c_if_338_17.doStart(context, out);
                                                            while (_jettag_c_if_338_17.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_339_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_339_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_339_1.setRuntimeParent(_jettag_c_if_338_17);
                                                                _jettag_f_message_339_1.setTagInfo(_td_f_message_339_1);
                                                                _jettag_f_message_339_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_339_1_saved_out = out;
                                                                while (_jettag_f_message_339_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_339_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_339_1_saved_out;
                                                                _jettag_f_message_339_1.doEnd();
                                                                out.write("\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\tpublic void get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 340, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sMultiSelect(Long entityID, String[] columns,AsyncCallback<MultiSelectObjy> response);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_338_17.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_338_17.doEnd();
                                                            _jettag_c_if_334_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_334_16.doEnd();
                                                        out.write("  \t\t\t\t\t  \t\t \t\t\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_iterate_333_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_333_15.doEnd();
                                                    _jettag_c_if_331_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_331_14.doEnd();
                                                _jettag_c_if_329_11.handleBodyContent(out);
                                            }
                                            _jettag_c_if_329_11.doEnd();
                                            _jettag_c_if_328_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_328_9.doEnd();
                                        _jettag_c_if_326_13.handleBodyContent(out);
                                    }
                                    _jettag_c_if_326_13.doEnd();
                                    _jettag_c_iterate_323_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_323_12.doEnd();
                                _jettag_c_if_321_6.handleBodyContent(out);
                            }
                            _jettag_c_if_321_6.doEnd();
                            _jettag_c_iterate_318_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_318_3.doEnd();
                        _jettag_c_iterate_317_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_317_2.doEnd();
                    _jettag_c_iterate_316_1.handleBodyContent(out);
                }
                _jettag_c_iterate_316_1.doEnd();
                out.write(NL);         
                // process all addAll relations
                RuntimeTagElement _jettag_c_iterate_356_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_356_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_356_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_356_1.setTagInfo(_td_c_iterate_356_1);
                _jettag_c_iterate_356_1.doStart(context, out);
                while (_jettag_c_iterate_356_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_357_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_357_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_357_2.setRuntimeParent(_jettag_c_iterate_356_1);
                    _jettag_c_iterate_357_2.setTagInfo(_td_c_iterate_357_2);
                    _jettag_c_iterate_357_2.doStart(context, out);
                    while (_jettag_c_iterate_357_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_358_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_358_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_358_3.setRuntimeParent(_jettag_c_iterate_357_2);
                        _jettag_c_iterate_358_3.setTagInfo(_td_c_iterate_358_3);
                        _jettag_c_iterate_358_3.doStart(context, out);
                        while (_jettag_c_iterate_358_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_359_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_359_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_359_4.setRuntimeParent(_jettag_c_iterate_358_3);
                            _jettag_c_setVariable_359_4.setTagInfo(_td_c_setVariable_359_4);
                            _jettag_c_setVariable_359_4.doStart(context, out);
                            _jettag_c_setVariable_359_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_361_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_361_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_361_6.setRuntimeParent(_jettag_c_iterate_358_3);
                            _jettag_c_if_361_6.setTagInfo(_td_c_if_361_6);
                            _jettag_c_if_361_6.doStart(context, out);
                            while (_jettag_c_if_361_6.okToProcessBody()) {
                                // process only classes with many on source side
                                RuntimeTagElement _jettag_c_if_363_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_363_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_363_6.setRuntimeParent(_jettag_c_if_361_6);
                                _jettag_c_if_363_6.setTagInfo(_td_c_if_363_6);
                                _jettag_c_if_363_6.doStart(context, out);
                                while (_jettag_c_if_363_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_364_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_364_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_364_8.setRuntimeParent(_jettag_c_if_363_6);
                                    _jettag_c_if_364_8.setTagInfo(_td_c_if_364_8);
                                    _jettag_c_if_364_8.doStart(context, out);
                                    while (_jettag_c_if_364_8.okToProcessBody()) {
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_366_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_366_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_366_12.setRuntimeParent(_jettag_c_if_364_8);
                                        _jettag_c_iterate_366_12.setTagInfo(_td_c_iterate_366_12);
                                        _jettag_c_iterate_366_12.doStart(context, out);
                                        while (_jettag_c_iterate_366_12.okToProcessBody()) {
                                            // process only non composites 
                                            RuntimeTagElement _jettag_c_if_368_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_368_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_368_12.setRuntimeParent(_jettag_c_iterate_366_12);
                                            _jettag_c_if_368_12.setTagInfo(_td_c_if_368_12);
                                            _jettag_c_if_368_12.doStart(context, out);
                                            while (_jettag_c_if_368_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_369_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_369_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_369_12.setRuntimeParent(_jettag_c_if_368_12);
                                                _jettag_c_setVariable_369_12.setTagInfo(_td_c_setVariable_369_12);
                                                _jettag_c_setVariable_369_12.doStart(context, out);
                                                _jettag_c_setVariable_369_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_371_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_371_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_371_14.setRuntimeParent(_jettag_c_if_368_12);
                                                _jettag_c_if_371_14.setTagInfo(_td_c_if_371_14);
                                                _jettag_c_if_371_14.doStart(context, out);
                                                while (_jettag_c_if_371_14.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_373_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_373_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_373_14.setRuntimeParent(_jettag_c_if_371_14);
                                                    _jettag_c_if_373_14.setTagInfo(_td_c_if_373_14);
                                                    _jettag_c_if_373_14.doStart(context, out);
                                                    while (_jettag_c_if_373_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_375_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_375_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_375_15.setRuntimeParent(_jettag_c_if_373_14);
                                                        _jettag_c_iterate_375_15.setTagInfo(_td_c_iterate_375_15);
                                                        _jettag_c_iterate_375_15.doStart(context, out);
                                                        while (_jettag_c_iterate_375_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_376_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_376_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_376_16.setRuntimeParent(_jettag_c_iterate_375_15);
                                                            _jettag_c_if_376_16.setTagInfo(_td_c_if_376_16);
                                                            _jettag_c_if_376_16.doStart(context, out);
                                                            while (_jettag_c_if_376_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_377_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_377_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_377_1.setRuntimeParent(_jettag_c_if_376_16);
                                                                _jettag_f_message_377_1.setTagInfo(_td_f_message_377_1);
                                                                _jettag_f_message_377_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_377_1_saved_out = out;
                                                                while (_jettag_f_message_377_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_377_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_377_1_saved_out;
                                                                _jettag_f_message_377_1.doEnd();
                                                                out.write("  \t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\tpublic void add");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 378, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 378, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 378, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Id,List<Long> ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 378, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s, AsyncCallback<java.lang.Void> response);\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_376_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_376_16.doEnd();
                                                            _jettag_c_iterate_375_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_375_15.doEnd();
                                                        _jettag_c_if_373_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_373_14.doEnd();
                                                    _jettag_c_if_371_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_371_14.doEnd();
                                                _jettag_c_if_368_12.handleBodyContent(out);
                                            }
                                            _jettag_c_if_368_12.doEnd();
                                            _jettag_c_iterate_366_12.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_366_12.doEnd();
                                        _jettag_c_if_364_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_364_8.doEnd();
                                    _jettag_c_if_363_6.handleBodyContent(out);
                                }
                                _jettag_c_if_363_6.doEnd();
                                _jettag_c_if_361_6.handleBodyContent(out);
                            }
                            _jettag_c_if_361_6.doEnd();
                            _jettag_c_iterate_358_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_358_3.doEnd();
                        _jettag_c_iterate_357_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_357_2.doEnd();
                    _jettag_c_iterate_356_1.handleBodyContent(out);
                }
                _jettag_c_iterate_356_1.doEnd();
                out.write(NL);         
                // process all removeAll relations
                RuntimeTagElement _jettag_c_iterate_393_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_393_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_393_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_393_1.setTagInfo(_td_c_iterate_393_1);
                _jettag_c_iterate_393_1.doStart(context, out);
                while (_jettag_c_iterate_393_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_394_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_394_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_394_2.setRuntimeParent(_jettag_c_iterate_393_1);
                    _jettag_c_iterate_394_2.setTagInfo(_td_c_iterate_394_2);
                    _jettag_c_iterate_394_2.doStart(context, out);
                    while (_jettag_c_iterate_394_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_395_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_395_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_395_3.setRuntimeParent(_jettag_c_iterate_394_2);
                        _jettag_c_iterate_395_3.setTagInfo(_td_c_iterate_395_3);
                        _jettag_c_iterate_395_3.doStart(context, out);
                        while (_jettag_c_iterate_395_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_396_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_396_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_396_4.setRuntimeParent(_jettag_c_iterate_395_3);
                            _jettag_c_setVariable_396_4.setTagInfo(_td_c_setVariable_396_4);
                            _jettag_c_setVariable_396_4.doStart(context, out);
                            _jettag_c_setVariable_396_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_398_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_398_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_398_6.setRuntimeParent(_jettag_c_iterate_395_3);
                            _jettag_c_if_398_6.setTagInfo(_td_c_if_398_6);
                            _jettag_c_if_398_6.doStart(context, out);
                            while (_jettag_c_if_398_6.okToProcessBody()) {
                                // process only classes with many on source side
                                RuntimeTagElement _jettag_c_if_400_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_400_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_400_6.setRuntimeParent(_jettag_c_if_398_6);
                                _jettag_c_if_400_6.setTagInfo(_td_c_if_400_6);
                                _jettag_c_if_400_6.doStart(context, out);
                                while (_jettag_c_if_400_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_401_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_401_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_401_8.setRuntimeParent(_jettag_c_if_400_6);
                                    _jettag_c_if_401_8.setTagInfo(_td_c_if_401_8);
                                    _jettag_c_if_401_8.doStart(context, out);
                                    while (_jettag_c_if_401_8.okToProcessBody()) {
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_403_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_403_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_403_12.setRuntimeParent(_jettag_c_if_401_8);
                                        _jettag_c_iterate_403_12.setTagInfo(_td_c_iterate_403_12);
                                        _jettag_c_iterate_403_12.doStart(context, out);
                                        while (_jettag_c_iterate_403_12.okToProcessBody()) {
                                            // process only non composites 
                                            RuntimeTagElement _jettag_c_if_405_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_405_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_405_12.setRuntimeParent(_jettag_c_iterate_403_12);
                                            _jettag_c_if_405_12.setTagInfo(_td_c_if_405_12);
                                            _jettag_c_if_405_12.doStart(context, out);
                                            while (_jettag_c_if_405_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_406_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_406_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_406_12.setRuntimeParent(_jettag_c_if_405_12);
                                                _jettag_c_setVariable_406_12.setTagInfo(_td_c_setVariable_406_12);
                                                _jettag_c_setVariable_406_12.doStart(context, out);
                                                _jettag_c_setVariable_406_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_408_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_408_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_408_14.setRuntimeParent(_jettag_c_if_405_12);
                                                _jettag_c_if_408_14.setTagInfo(_td_c_if_408_14);
                                                _jettag_c_if_408_14.doStart(context, out);
                                                while (_jettag_c_if_408_14.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_410_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_410_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_410_14.setRuntimeParent(_jettag_c_if_408_14);
                                                    _jettag_c_if_410_14.setTagInfo(_td_c_if_410_14);
                                                    _jettag_c_if_410_14.doStart(context, out);
                                                    while (_jettag_c_if_410_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_412_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_412_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_412_15.setRuntimeParent(_jettag_c_if_410_14);
                                                        _jettag_c_iterate_412_15.setTagInfo(_td_c_iterate_412_15);
                                                        _jettag_c_iterate_412_15.doStart(context, out);
                                                        while (_jettag_c_iterate_412_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_413_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_413_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_413_16.setRuntimeParent(_jettag_c_iterate_412_15);
                                                            _jettag_c_if_413_16.setTagInfo(_td_c_if_413_16);
                                                            _jettag_c_if_413_16.doStart(context, out);
                                                            while (_jettag_c_if_413_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_414_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_414_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_414_1.setRuntimeParent(_jettag_c_if_413_16);
                                                                _jettag_f_message_414_1.setTagInfo(_td_f_message_414_1);
                                                                _jettag_f_message_414_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_414_1_saved_out = out;
                                                                while (_jettag_f_message_414_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_414_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_414_1_saved_out;
                                                                _jettag_f_message_414_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\tpublic void remove");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 415, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 415, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 415, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Id,List<Long> ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 415, 109)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s, AsyncCallback<java.lang.Void> response);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_413_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_413_16.doEnd();
                                                            _jettag_c_iterate_412_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_412_15.doEnd();
                                                        _jettag_c_if_410_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_410_14.doEnd();
                                                    _jettag_c_if_408_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_408_14.doEnd();
                                                _jettag_c_if_405_12.handleBodyContent(out);
                                            }
                                            _jettag_c_if_405_12.doEnd();
                                            _jettag_c_iterate_403_12.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_403_12.doEnd();
                                        _jettag_c_if_401_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_401_8.doEnd();
                                    _jettag_c_if_400_6.handleBodyContent(out);
                                }
                                _jettag_c_if_400_6.doEnd();
                                _jettag_c_if_398_6.handleBodyContent(out);
                            }
                            _jettag_c_if_398_6.doEnd();
                            _jettag_c_iterate_395_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_395_3.doEnd();
                        _jettag_c_iterate_394_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_394_2.doEnd();
                    _jettag_c_iterate_393_1.handleBodyContent(out);
                }
                _jettag_c_iterate_393_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                // process all merge relations
                RuntimeTagElement _jettag_c_iterate_431_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_431_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_431_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_431_1.setTagInfo(_td_c_iterate_431_1);
                _jettag_c_iterate_431_1.doStart(context, out);
                while (_jettag_c_iterate_431_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_432_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_432_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_432_2.setRuntimeParent(_jettag_c_iterate_431_1);
                    _jettag_c_iterate_432_2.setTagInfo(_td_c_iterate_432_2);
                    _jettag_c_iterate_432_2.doStart(context, out);
                    while (_jettag_c_iterate_432_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_433_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_433_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_433_3.setRuntimeParent(_jettag_c_iterate_432_2);
                        _jettag_c_iterate_433_3.setTagInfo(_td_c_iterate_433_3);
                        _jettag_c_iterate_433_3.doStart(context, out);
                        while (_jettag_c_iterate_433_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_434_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_434_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_434_4.setRuntimeParent(_jettag_c_iterate_433_3);
                            _jettag_c_setVariable_434_4.setTagInfo(_td_c_setVariable_434_4);
                            _jettag_c_setVariable_434_4.doStart(context, out);
                            _jettag_c_setVariable_434_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_436_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_436_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_436_6.setRuntimeParent(_jettag_c_iterate_433_3);
                            _jettag_c_if_436_6.setTagInfo(_td_c_if_436_6);
                            _jettag_c_if_436_6.doStart(context, out);
                            while (_jettag_c_if_436_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_438_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_438_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_438_12.setRuntimeParent(_jettag_c_if_436_6);
                                _jettag_c_iterate_438_12.setTagInfo(_td_c_iterate_438_12);
                                _jettag_c_iterate_438_12.doStart(context, out);
                                while (_jettag_c_iterate_438_12.okToProcessBody()) {
                                    // process only  composites on target
                                    RuntimeTagElement _jettag_c_if_440_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_440_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_440_12.setRuntimeParent(_jettag_c_iterate_438_12);
                                    _jettag_c_if_440_12.setTagInfo(_td_c_if_440_12);
                                    _jettag_c_if_440_12.doStart(context, out);
                                    while (_jettag_c_if_440_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_441_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_441_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_441_12.setRuntimeParent(_jettag_c_if_440_12);
                                        _jettag_c_setVariable_441_12.setTagInfo(_td_c_setVariable_441_12);
                                        _jettag_c_setVariable_441_12.doStart(context, out);
                                        _jettag_c_setVariable_441_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_443_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_443_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_443_14.setRuntimeParent(_jettag_c_if_440_12);
                                        _jettag_c_if_443_14.setTagInfo(_td_c_if_443_14);
                                        _jettag_c_if_443_14.doStart(context, out);
                                        while (_jettag_c_if_443_14.okToProcessBody()) {
                                            // iterate throught all the classes to get the other class on the association
                                            RuntimeTagElement _jettag_c_iterate_445_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_445_15); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_445_15.setRuntimeParent(_jettag_c_if_443_14);
                                            _jettag_c_iterate_445_15.setTagInfo(_td_c_iterate_445_15);
                                            _jettag_c_iterate_445_15.doStart(context, out);
                                            while (_jettag_c_iterate_445_15.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_446_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_446_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_446_16.setRuntimeParent(_jettag_c_iterate_445_15);
                                                _jettag_c_if_446_16.setTagInfo(_td_c_if_446_16);
                                                _jettag_c_if_446_16.doStart(context, out);
                                                while (_jettag_c_if_446_16.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_f_message_447_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_447_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_f_message_447_1.setRuntimeParent(_jettag_c_if_446_16);
                                                    _jettag_f_message_447_1.setTagInfo(_td_f_message_447_1);
                                                    _jettag_f_message_447_1.doStart(context, out);
                                                    JET2Writer _jettag_f_message_447_1_saved_out = out;
                                                    while (_jettag_f_message_447_1.okToProcessBody()) {
                                                        out = out.newNestedContentWriter();
                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                        _jettag_f_message_447_1.handleBodyContent(out);
                                                    }
                                                    out = _jettag_f_message_447_1_saved_out;
                                                    _jettag_f_message_447_1.doEnd();
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write(" \t\t\t\t\t\t\t\t\t\tpublic void merge(");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 448, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(" entity, ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 448, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(" child,AsyncCallback<java.lang.Void> response);");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_446_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_446_16.doEnd();
                                                _jettag_c_iterate_445_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_445_15.doEnd();
                                            _jettag_c_if_443_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_443_14.doEnd();
                                        _jettag_c_if_440_12.handleBodyContent(out);
                                    }
                                    _jettag_c_if_440_12.doEnd();
                                    _jettag_c_iterate_438_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_438_12.doEnd();
                                _jettag_c_if_436_6.handleBodyContent(out);
                            }
                            _jettag_c_if_436_6.doEnd();
                            _jettag_c_iterate_433_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_433_3.doEnd();
                        _jettag_c_iterate_432_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_432_2.doEnd();
                    _jettag_c_iterate_431_1.handleBodyContent(out);
                }
                _jettag_c_iterate_431_1.doEnd();
                out.write("\t\t\t");  //$NON-NLS-1$        
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
