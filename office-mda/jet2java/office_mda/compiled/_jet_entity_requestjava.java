package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_requestjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_entity_requestjava() {
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
    private static final TagInfo _td_c_setVariable_6_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            6, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_11_1 = new TagInfo("c:if", //$NON-NLS-1$
            11, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_12_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            12, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_13_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            13, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_14_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            14, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_15_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            15, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_16_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            16, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_18_6 = new TagInfo("c:if", //$NON-NLS-1$
            18, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_20_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            20, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_21_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            21, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_23_13 = new TagInfo("c:if", //$NON-NLS-1$
            23, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_25_9 = new TagInfo("c:if", //$NON-NLS-1$
            25, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_26_11 = new TagInfo("c:if", //$NON-NLS-1$
            26, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_28_14 = new TagInfo("c:if", //$NON-NLS-1$
            28, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_30_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            30, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_31_16 = new TagInfo("c:if", //$NON-NLS-1$
            31, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_45_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            45, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_47_1 = new TagInfo("c:if", //$NON-NLS-1$
            47, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_48_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            48, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_49_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            49, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_50_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            50, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_51_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            51, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_52_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            52, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_54_6 = new TagInfo("c:if", //$NON-NLS-1$
            54, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_56_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            56, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_57_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            57, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_59_13 = new TagInfo("c:if", //$NON-NLS-1$
            59, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_61_9 = new TagInfo("c:if", //$NON-NLS-1$
            61, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_62_11 = new TagInfo("c:if", //$NON-NLS-1$
            62, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_64_14 = new TagInfo("c:if", //$NON-NLS-1$
            64, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_66_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            66, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_67_16 = new TagInfo("c:if", //$NON-NLS-1$
            67, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_81_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            81, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_83_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            83, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_84_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            84, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_85_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            85, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_86_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            86, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_88_6 = new TagInfo("c:if", //$NON-NLS-1$
            88, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_90_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            90, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_91_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            91, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_93_13 = new TagInfo("c:if", //$NON-NLS-1$
            93, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_95_9 = new TagInfo("c:if", //$NON-NLS-1$
            95, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_96_11 = new TagInfo("c:if", //$NON-NLS-1$
            96, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_98_14 = new TagInfo("c:if", //$NON-NLS-1$
            98, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_100_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            100, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_101_16 = new TagInfo("c:if", //$NON-NLS-1$
            101, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_116_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            116, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_117_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            117, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_118_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            118, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_119_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            119, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_121_6 = new TagInfo("c:if", //$NON-NLS-1$
            121, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_123_6 = new TagInfo("c:if", //$NON-NLS-1$
            123, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_124_8 = new TagInfo("c:if", //$NON-NLS-1$
            124, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_126_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            126, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_128_12 = new TagInfo("c:if", //$NON-NLS-1$
            128, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
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
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_133_14 = new TagInfo("c:if", //$NON-NLS-1$
            133, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
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
    private static final TagInfo _td_c_iterate_152_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            152, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_153_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            153, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_154_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            154, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_155_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            155, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_157_6 = new TagInfo("c:if", //$NON-NLS-1$
            157, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_159_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            159, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_161_12 = new TagInfo("c:if", //$NON-NLS-1$
            161, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_162_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            162, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_164_14 = new TagInfo("c:if", //$NON-NLS-1$
            164, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_166_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            166, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_167_16 = new TagInfo("c:if", //$NON-NLS-1$
            167, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_169_12 = new TagInfo("c:if", //$NON-NLS-1$
            169, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@parent1 = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_173_12 = new TagInfo("c:if", //$NON-NLS-1$
            173, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@parent2 = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_187_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            187, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_211_1 = new TagInfo("c:if", //$NON-NLS-1$
            211, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_212_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            212, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_213_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            213, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_214_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            214, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_215_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            215, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_216_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            216, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_218_6 = new TagInfo("c:if", //$NON-NLS-1$
            218, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_220_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            220, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_221_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            221, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_223_13 = new TagInfo("c:if", //$NON-NLS-1$
            223, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_225_9 = new TagInfo("c:if", //$NON-NLS-1$
            225, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_226_11 = new TagInfo("c:if", //$NON-NLS-1$
            226, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_228_14 = new TagInfo("c:if", //$NON-NLS-1$
            228, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_230_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            230, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_231_16 = new TagInfo("c:if", //$NON-NLS-1$
            231, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_232_1 = new TagInfo("f:message", //$NON-NLS-1$
            232, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_235_17 = new TagInfo("c:if", //$NON-NLS-1$
            235, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_236_1 = new TagInfo("f:message", //$NON-NLS-1$
            236, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_setVariable_251_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            251, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_253_1 = new TagInfo("c:if", //$NON-NLS-1$
            253, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_254_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            254, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_255_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            255, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_256_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            256, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_257_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            257, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_258_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            258, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_260_6 = new TagInfo("c:if", //$NON-NLS-1$
            260, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_262_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            262, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_263_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            263, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_265_13 = new TagInfo("c:if", //$NON-NLS-1$
            265, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_267_9 = new TagInfo("c:if", //$NON-NLS-1$
            267, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_268_11 = new TagInfo("c:if", //$NON-NLS-1$
            268, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_270_14 = new TagInfo("c:if", //$NON-NLS-1$
            270, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_272_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            272, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_273_16 = new TagInfo("c:if", //$NON-NLS-1$
            273, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_274_1 = new TagInfo("f:message", //$NON-NLS-1$
            274, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_277_17 = new TagInfo("c:if", //$NON-NLS-1$
            277, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_278_1 = new TagInfo("f:message", //$NON-NLS-1$
            278, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_setVariable_293_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            293, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_295_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            295, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_296_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            296, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_297_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            297, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_298_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            298, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_300_6 = new TagInfo("c:if", //$NON-NLS-1$
            300, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_302_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            302, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_303_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            303, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_305_13 = new TagInfo("c:if", //$NON-NLS-1$
            305, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_307_9 = new TagInfo("c:if", //$NON-NLS-1$
            307, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_308_11 = new TagInfo("c:if", //$NON-NLS-1$
            308, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_310_14 = new TagInfo("c:if", //$NON-NLS-1$
            310, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_312_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            312, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_313_16 = new TagInfo("c:if", //$NON-NLS-1$
            313, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_314_1 = new TagInfo("f:message", //$NON-NLS-1$
            314, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_317_17 = new TagInfo("c:if", //$NON-NLS-1$
            317, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_318_1 = new TagInfo("f:message", //$NON-NLS-1$
            318, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_335_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            335, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_336_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            336, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_337_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            337, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_338_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            338, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_340_6 = new TagInfo("c:if", //$NON-NLS-1$
            340, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_342_6 = new TagInfo("c:if", //$NON-NLS-1$
            342, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_343_8 = new TagInfo("c:if", //$NON-NLS-1$
            343, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_345_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            345, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_347_12 = new TagInfo("c:if", //$NON-NLS-1$
            347, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_348_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            348, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_350_14 = new TagInfo("c:if", //$NON-NLS-1$
            350, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_352_14 = new TagInfo("c:if", //$NON-NLS-1$
            352, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_354_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            354, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_355_16 = new TagInfo("c:if", //$NON-NLS-1$
            355, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_356_1 = new TagInfo("f:message", //$NON-NLS-1$
            356, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_372_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            372, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_373_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            373, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_374_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            374, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_375_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            375, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_377_6 = new TagInfo("c:if", //$NON-NLS-1$
            377, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_379_6 = new TagInfo("c:if", //$NON-NLS-1$
            379, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_380_8 = new TagInfo("c:if", //$NON-NLS-1$
            380, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_382_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            382, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_384_12 = new TagInfo("c:if", //$NON-NLS-1$
            384, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_385_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            385, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_387_14 = new TagInfo("c:if", //$NON-NLS-1$
            387, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_389_14 = new TagInfo("c:if", //$NON-NLS-1$
            389, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_391_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            391, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_392_16 = new TagInfo("c:if", //$NON-NLS-1$
            392, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_393_1 = new TagInfo("f:message", //$NON-NLS-1$
            393, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_409_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            409, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_410_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            410, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_411_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            411, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_412_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            412, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_414_6 = new TagInfo("c:if", //$NON-NLS-1$
            414, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_416_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            416, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_418_12 = new TagInfo("c:if", //$NON-NLS-1$
            418, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_419_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            419, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_421_14 = new TagInfo("c:if", //$NON-NLS-1$
            421, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_423_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            423, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_424_16 = new TagInfo("c:if", //$NON-NLS-1$
            424, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_425_1 = new TagInfo("f:message", //$NON-NLS-1$
            425, 1,
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
                RuntimeTagElement _jettag_c_setVariable_6_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_6_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_6_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_6_1.setTagInfo(_td_c_setVariable_6_1);
                _jettag_c_setVariable_6_1.doStart(context, out);
                _jettag_c_setVariable_6_1.doEnd();
                out.write(NL);         
                out.write(NL);         
                // process all getRelated entities relations
                //process level2 generizations 
                RuntimeTagElement _jettag_c_if_11_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_11_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_11_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_11_1.setTagInfo(_td_c_if_11_1);
                _jettag_c_if_11_1.doStart(context, out);
                while (_jettag_c_if_11_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_12_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_12_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_12_6.setRuntimeParent(_jettag_c_if_11_1);
                    _jettag_c_setVariable_12_6.setTagInfo(_td_c_setVariable_12_6);
                    _jettag_c_setVariable_12_6.doStart(context, out);
                    _jettag_c_setVariable_12_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_13_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_13_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_13_6.setRuntimeParent(_jettag_c_if_11_1);
                    _jettag_c_iterate_13_6.setTagInfo(_td_c_iterate_13_6);
                    _jettag_c_iterate_13_6.doStart(context, out);
                    while (_jettag_c_iterate_13_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_14_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_14_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_14_2.setRuntimeParent(_jettag_c_iterate_13_6);
                        _jettag_c_iterate_14_2.setTagInfo(_td_c_iterate_14_2);
                        _jettag_c_iterate_14_2.doStart(context, out);
                        while (_jettag_c_iterate_14_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_15_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_15_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_15_3.setRuntimeParent(_jettag_c_iterate_14_2);
                            _jettag_c_iterate_15_3.setTagInfo(_td_c_iterate_15_3);
                            _jettag_c_iterate_15_3.doStart(context, out);
                            while (_jettag_c_iterate_15_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_16_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_16_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_16_4.setRuntimeParent(_jettag_c_iterate_15_3);
                                _jettag_c_setVariable_16_4.setTagInfo(_td_c_setVariable_16_4);
                                _jettag_c_setVariable_16_4.doStart(context, out);
                                _jettag_c_setVariable_16_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_18_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_18_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_18_6.setRuntimeParent(_jettag_c_iterate_15_3);
                                _jettag_c_if_18_6.setTagInfo(_td_c_if_18_6);
                                _jettag_c_if_18_6.doStart(context, out);
                                while (_jettag_c_if_18_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_20_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_20_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_20_12.setRuntimeParent(_jettag_c_if_18_6);
                                    _jettag_c_iterate_20_12.setTagInfo(_td_c_iterate_20_12);
                                    _jettag_c_iterate_20_12.doStart(context, out);
                                    while (_jettag_c_iterate_20_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_21_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_21_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_21_12.setRuntimeParent(_jettag_c_iterate_20_12);
                                        _jettag_c_setVariable_21_12.setTagInfo(_td_c_setVariable_21_12);
                                        _jettag_c_setVariable_21_12.doStart(context, out);
                                        _jettag_c_setVariable_21_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_23_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_23_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_23_13.setRuntimeParent(_jettag_c_iterate_20_12);
                                        _jettag_c_if_23_13.setTagInfo(_td_c_if_23_13);
                                        _jettag_c_if_23_13.doStart(context, out);
                                        while (_jettag_c_if_23_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_25_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_25_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_25_9.setRuntimeParent(_jettag_c_if_23_13);
                                            _jettag_c_if_25_9.setTagInfo(_td_c_if_25_9);
                                            _jettag_c_if_25_9.doStart(context, out);
                                            while (_jettag_c_if_25_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_26_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_26_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_26_11.setRuntimeParent(_jettag_c_if_25_9);
                                                _jettag_c_if_26_11.setTagInfo(_td_c_if_26_11);
                                                _jettag_c_if_26_11.doStart(context, out);
                                                while (_jettag_c_if_26_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_28_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_28_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_28_14.setRuntimeParent(_jettag_c_if_26_11);
                                                    _jettag_c_if_28_14.setTagInfo(_td_c_if_28_14);
                                                    _jettag_c_if_28_14.doStart(context, out);
                                                    while (_jettag_c_if_28_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_30_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_30_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_30_15.setRuntimeParent(_jettag_c_if_28_14);
                                                        _jettag_c_iterate_30_15.setTagInfo(_td_c_iterate_30_15);
                                                        _jettag_c_iterate_30_15.doStart(context, out);
                                                        while (_jettag_c_iterate_30_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_31_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_31_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_31_16.setRuntimeParent(_jettag_c_iterate_30_15);
                                                            _jettag_c_if_31_16.setTagInfo(_td_c_if_31_16);
                                                            _jettag_c_if_31_16.doStart(context, out);
                                                            while (_jettag_c_if_31_16.okToProcessBody()) {
                                                                out.write("import ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 32, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".client.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 32, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 32, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 32, 86)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy;");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_31_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_31_16.doEnd();
                                                            _jettag_c_iterate_30_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_30_15.doEnd();
                                                        _jettag_c_if_28_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_28_14.doEnd();
                                                    _jettag_c_if_26_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_26_11.doEnd();
                                                _jettag_c_if_25_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_25_9.doEnd();
                                            _jettag_c_if_23_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_23_13.doEnd();
                                        _jettag_c_iterate_20_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_20_12.doEnd();
                                    _jettag_c_if_18_6.handleBodyContent(out);
                                }
                                _jettag_c_if_18_6.doEnd();
                                _jettag_c_iterate_15_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_15_3.doEnd();
                            _jettag_c_iterate_14_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_14_2.doEnd();
                        _jettag_c_iterate_13_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_13_6.doEnd();
                    _jettag_c_if_11_1.handleBodyContent(out);
                }
                _jettag_c_if_11_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_45_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_45_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_45_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_45_1.setTagInfo(_td_c_setVariable_45_1);
                _jettag_c_setVariable_45_1.doStart(context, out);
                _jettag_c_setVariable_45_1.doEnd();
                //process level 1 generizations 
                RuntimeTagElement _jettag_c_if_47_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_47_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_47_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_47_1.setTagInfo(_td_c_if_47_1);
                _jettag_c_if_47_1.doStart(context, out);
                while (_jettag_c_if_47_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_48_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_48_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_48_6.setRuntimeParent(_jettag_c_if_47_1);
                    _jettag_c_setVariable_48_6.setTagInfo(_td_c_setVariable_48_6);
                    _jettag_c_setVariable_48_6.doStart(context, out);
                    _jettag_c_setVariable_48_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_49_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_49_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_49_6.setRuntimeParent(_jettag_c_if_47_1);
                    _jettag_c_iterate_49_6.setTagInfo(_td_c_iterate_49_6);
                    _jettag_c_iterate_49_6.doStart(context, out);
                    while (_jettag_c_iterate_49_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_50_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_50_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_50_2.setRuntimeParent(_jettag_c_iterate_49_6);
                        _jettag_c_iterate_50_2.setTagInfo(_td_c_iterate_50_2);
                        _jettag_c_iterate_50_2.doStart(context, out);
                        while (_jettag_c_iterate_50_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_51_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_51_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_51_3.setRuntimeParent(_jettag_c_iterate_50_2);
                            _jettag_c_iterate_51_3.setTagInfo(_td_c_iterate_51_3);
                            _jettag_c_iterate_51_3.doStart(context, out);
                            while (_jettag_c_iterate_51_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_52_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_52_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_52_4.setRuntimeParent(_jettag_c_iterate_51_3);
                                _jettag_c_setVariable_52_4.setTagInfo(_td_c_setVariable_52_4);
                                _jettag_c_setVariable_52_4.doStart(context, out);
                                _jettag_c_setVariable_52_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_54_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_54_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_54_6.setRuntimeParent(_jettag_c_iterate_51_3);
                                _jettag_c_if_54_6.setTagInfo(_td_c_if_54_6);
                                _jettag_c_if_54_6.doStart(context, out);
                                while (_jettag_c_if_54_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_56_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_56_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_56_12.setRuntimeParent(_jettag_c_if_54_6);
                                    _jettag_c_iterate_56_12.setTagInfo(_td_c_iterate_56_12);
                                    _jettag_c_iterate_56_12.doStart(context, out);
                                    while (_jettag_c_iterate_56_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_57_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_57_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_57_12.setRuntimeParent(_jettag_c_iterate_56_12);
                                        _jettag_c_setVariable_57_12.setTagInfo(_td_c_setVariable_57_12);
                                        _jettag_c_setVariable_57_12.doStart(context, out);
                                        _jettag_c_setVariable_57_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_59_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_59_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_59_13.setRuntimeParent(_jettag_c_iterate_56_12);
                                        _jettag_c_if_59_13.setTagInfo(_td_c_if_59_13);
                                        _jettag_c_if_59_13.doStart(context, out);
                                        while (_jettag_c_if_59_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_61_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_61_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_61_9.setRuntimeParent(_jettag_c_if_59_13);
                                            _jettag_c_if_61_9.setTagInfo(_td_c_if_61_9);
                                            _jettag_c_if_61_9.doStart(context, out);
                                            while (_jettag_c_if_61_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_62_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_62_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_62_11.setRuntimeParent(_jettag_c_if_61_9);
                                                _jettag_c_if_62_11.setTagInfo(_td_c_if_62_11);
                                                _jettag_c_if_62_11.doStart(context, out);
                                                while (_jettag_c_if_62_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_64_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_64_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_64_14.setRuntimeParent(_jettag_c_if_62_11);
                                                    _jettag_c_if_64_14.setTagInfo(_td_c_if_64_14);
                                                    _jettag_c_if_64_14.doStart(context, out);
                                                    while (_jettag_c_if_64_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_66_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_66_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_66_15.setRuntimeParent(_jettag_c_if_64_14);
                                                        _jettag_c_iterate_66_15.setTagInfo(_td_c_iterate_66_15);
                                                        _jettag_c_iterate_66_15.doStart(context, out);
                                                        while (_jettag_c_iterate_66_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_67_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_67_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_67_16.setRuntimeParent(_jettag_c_iterate_66_15);
                                                            _jettag_c_if_67_16.setTagInfo(_td_c_if_67_16);
                                                            _jettag_c_if_67_16.doStart(context, out);
                                                            while (_jettag_c_if_67_16.okToProcessBody()) {
                                                                out.write("import ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 68, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".client.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 68, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 68, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 68, 86)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy;");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_67_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_67_16.doEnd();
                                                            _jettag_c_iterate_66_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_66_15.doEnd();
                                                        _jettag_c_if_64_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_64_14.doEnd();
                                                    _jettag_c_if_62_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_62_11.doEnd();
                                                _jettag_c_if_61_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_61_9.doEnd();
                                            _jettag_c_if_59_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_59_13.doEnd();
                                        _jettag_c_iterate_56_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_56_12.doEnd();
                                    _jettag_c_if_54_6.handleBodyContent(out);
                                }
                                _jettag_c_if_54_6.doEnd();
                                _jettag_c_iterate_51_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_51_3.doEnd();
                            _jettag_c_iterate_50_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_50_2.doEnd();
                        _jettag_c_iterate_49_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_49_6.doEnd();
                    _jettag_c_if_47_1.handleBodyContent(out);
                }
                _jettag_c_if_47_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_81_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_81_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_81_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_81_1.setTagInfo(_td_c_setVariable_81_1);
                _jettag_c_setVariable_81_1.doStart(context, out);
                _jettag_c_setVariable_81_1.doEnd();
                //level 0 
                RuntimeTagElement _jettag_c_iterate_83_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_83_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_83_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_83_1.setTagInfo(_td_c_iterate_83_1);
                _jettag_c_iterate_83_1.doStart(context, out);
                while (_jettag_c_iterate_83_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_84_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_84_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_84_2.setRuntimeParent(_jettag_c_iterate_83_1);
                    _jettag_c_iterate_84_2.setTagInfo(_td_c_iterate_84_2);
                    _jettag_c_iterate_84_2.doStart(context, out);
                    while (_jettag_c_iterate_84_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_85_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_85_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_85_3.setRuntimeParent(_jettag_c_iterate_84_2);
                        _jettag_c_iterate_85_3.setTagInfo(_td_c_iterate_85_3);
                        _jettag_c_iterate_85_3.doStart(context, out);
                        while (_jettag_c_iterate_85_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_86_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_86_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_86_4.setRuntimeParent(_jettag_c_iterate_85_3);
                            _jettag_c_setVariable_86_4.setTagInfo(_td_c_setVariable_86_4);
                            _jettag_c_setVariable_86_4.doStart(context, out);
                            _jettag_c_setVariable_86_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_88_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_88_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_88_6.setRuntimeParent(_jettag_c_iterate_85_3);
                            _jettag_c_if_88_6.setTagInfo(_td_c_if_88_6);
                            _jettag_c_if_88_6.doStart(context, out);
                            while (_jettag_c_if_88_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_90_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_90_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_90_12.setRuntimeParent(_jettag_c_if_88_6);
                                _jettag_c_iterate_90_12.setTagInfo(_td_c_iterate_90_12);
                                _jettag_c_iterate_90_12.doStart(context, out);
                                while (_jettag_c_iterate_90_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_91_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_91_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_91_12.setRuntimeParent(_jettag_c_iterate_90_12);
                                    _jettag_c_setVariable_91_12.setTagInfo(_td_c_setVariable_91_12);
                                    _jettag_c_setVariable_91_12.doStart(context, out);
                                    _jettag_c_setVariable_91_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_93_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_93_13); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_93_13.setRuntimeParent(_jettag_c_iterate_90_12);
                                    _jettag_c_if_93_13.setTagInfo(_td_c_if_93_13);
                                    _jettag_c_if_93_13.doStart(context, out);
                                    while (_jettag_c_if_93_13.okToProcessBody()) {
                                        // process many on target
                                        RuntimeTagElement _jettag_c_if_95_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_95_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_95_9.setRuntimeParent(_jettag_c_if_93_13);
                                        _jettag_c_if_95_9.setTagInfo(_td_c_if_95_9);
                                        _jettag_c_if_95_9.doStart(context, out);
                                        while (_jettag_c_if_95_9.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_96_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_96_11); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_96_11.setRuntimeParent(_jettag_c_if_95_9);
                                            _jettag_c_if_96_11.setTagInfo(_td_c_if_96_11);
                                            _jettag_c_if_96_11.doStart(context, out);
                                            while (_jettag_c_if_96_11.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_98_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_98_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_98_14.setRuntimeParent(_jettag_c_if_96_11);
                                                _jettag_c_if_98_14.setTagInfo(_td_c_if_98_14);
                                                _jettag_c_if_98_14.doStart(context, out);
                                                while (_jettag_c_if_98_14.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_100_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_100_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_100_15.setRuntimeParent(_jettag_c_if_98_14);
                                                    _jettag_c_iterate_100_15.setTagInfo(_td_c_iterate_100_15);
                                                    _jettag_c_iterate_100_15.doStart(context, out);
                                                    while (_jettag_c_iterate_100_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_101_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_101_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_101_16.setRuntimeParent(_jettag_c_iterate_100_15);
                                                        _jettag_c_if_101_16.setTagInfo(_td_c_if_101_16);
                                                        _jettag_c_if_101_16.doStart(context, out);
                                                        while (_jettag_c_if_101_16.okToProcessBody()) {
                                                            out.write("import ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 102, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".client.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 102, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 102, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 102, 86)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Proxy;");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_101_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_101_16.doEnd();
                                                        _jettag_c_iterate_100_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_100_15.doEnd();
                                                    _jettag_c_if_98_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_98_14.doEnd();
                                                _jettag_c_if_96_11.handleBodyContent(out);
                                            }
                                            _jettag_c_if_96_11.doEnd();
                                            _jettag_c_if_95_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_95_9.doEnd();
                                        _jettag_c_if_93_13.handleBodyContent(out);
                                    }
                                    _jettag_c_if_93_13.doEnd();
                                    _jettag_c_iterate_90_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_90_12.doEnd();
                                _jettag_c_if_88_6.handleBodyContent(out);
                            }
                            _jettag_c_if_88_6.doEnd();
                            _jettag_c_iterate_85_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_85_3.doEnd();
                        _jettag_c_iterate_84_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_84_2.doEnd();
                    _jettag_c_iterate_83_1.handleBodyContent(out);
                }
                _jettag_c_iterate_83_1.doEnd();
                out.write(NL);         
                // process all addAll relations
                RuntimeTagElement _jettag_c_iterate_116_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_116_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_116_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_116_1.setTagInfo(_td_c_iterate_116_1);
                _jettag_c_iterate_116_1.doStart(context, out);
                while (_jettag_c_iterate_116_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_117_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_117_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_117_2.setRuntimeParent(_jettag_c_iterate_116_1);
                    _jettag_c_iterate_117_2.setTagInfo(_td_c_iterate_117_2);
                    _jettag_c_iterate_117_2.doStart(context, out);
                    while (_jettag_c_iterate_117_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_118_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_118_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_118_3.setRuntimeParent(_jettag_c_iterate_117_2);
                        _jettag_c_iterate_118_3.setTagInfo(_td_c_iterate_118_3);
                        _jettag_c_iterate_118_3.doStart(context, out);
                        while (_jettag_c_iterate_118_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_119_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_119_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_119_4.setRuntimeParent(_jettag_c_iterate_118_3);
                            _jettag_c_setVariable_119_4.setTagInfo(_td_c_setVariable_119_4);
                            _jettag_c_setVariable_119_4.doStart(context, out);
                            _jettag_c_setVariable_119_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_121_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_121_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_121_6.setRuntimeParent(_jettag_c_iterate_118_3);
                            _jettag_c_if_121_6.setTagInfo(_td_c_if_121_6);
                            _jettag_c_if_121_6.doStart(context, out);
                            while (_jettag_c_if_121_6.okToProcessBody()) {
                                // process only classes with many on source side
                                RuntimeTagElement _jettag_c_if_123_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_123_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_123_6.setRuntimeParent(_jettag_c_if_121_6);
                                _jettag_c_if_123_6.setTagInfo(_td_c_if_123_6);
                                _jettag_c_if_123_6.doStart(context, out);
                                while (_jettag_c_if_123_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_124_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_124_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_124_8.setRuntimeParent(_jettag_c_if_123_6);
                                    _jettag_c_if_124_8.setTagInfo(_td_c_if_124_8);
                                    _jettag_c_if_124_8.doStart(context, out);
                                    while (_jettag_c_if_124_8.okToProcessBody()) {
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_126_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_126_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_126_12.setRuntimeParent(_jettag_c_if_124_8);
                                        _jettag_c_iterate_126_12.setTagInfo(_td_c_iterate_126_12);
                                        _jettag_c_iterate_126_12.doStart(context, out);
                                        while (_jettag_c_iterate_126_12.okToProcessBody()) {
                                            // process only non composites 
                                            RuntimeTagElement _jettag_c_if_128_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_128_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_128_12.setRuntimeParent(_jettag_c_iterate_126_12);
                                            _jettag_c_if_128_12.setTagInfo(_td_c_if_128_12);
                                            _jettag_c_if_128_12.doStart(context, out);
                                            while (_jettag_c_if_128_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_129_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_129_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_129_12.setRuntimeParent(_jettag_c_if_128_12);
                                                _jettag_c_setVariable_129_12.setTagInfo(_td_c_setVariable_129_12);
                                                _jettag_c_setVariable_129_12.doStart(context, out);
                                                _jettag_c_setVariable_129_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_131_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_131_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_131_14.setRuntimeParent(_jettag_c_if_128_12);
                                                _jettag_c_if_131_14.setTagInfo(_td_c_if_131_14);
                                                _jettag_c_if_131_14.doStart(context, out);
                                                while (_jettag_c_if_131_14.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
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
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 137, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".client.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 137, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 137, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 137, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy;");  //$NON-NLS-1$        
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
                                                _jettag_c_if_128_12.handleBodyContent(out);
                                            }
                                            _jettag_c_if_128_12.doEnd();
                                            _jettag_c_iterate_126_12.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_126_12.doEnd();
                                        _jettag_c_if_124_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_124_8.doEnd();
                                    _jettag_c_if_123_6.handleBodyContent(out);
                                }
                                _jettag_c_if_123_6.doEnd();
                                _jettag_c_if_121_6.handleBodyContent(out);
                            }
                            _jettag_c_if_121_6.doEnd();
                            _jettag_c_iterate_118_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_118_3.doEnd();
                        _jettag_c_iterate_117_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_117_2.doEnd();
                    _jettag_c_iterate_116_1.handleBodyContent(out);
                }
                _jettag_c_iterate_116_1.doEnd();
                out.write(NL);         
                // process all merge relations
                RuntimeTagElement _jettag_c_iterate_152_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_152_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_152_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_152_1.setTagInfo(_td_c_iterate_152_1);
                _jettag_c_iterate_152_1.doStart(context, out);
                while (_jettag_c_iterate_152_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_153_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_153_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_153_2.setRuntimeParent(_jettag_c_iterate_152_1);
                    _jettag_c_iterate_153_2.setTagInfo(_td_c_iterate_153_2);
                    _jettag_c_iterate_153_2.doStart(context, out);
                    while (_jettag_c_iterate_153_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_154_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_154_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_154_3.setRuntimeParent(_jettag_c_iterate_153_2);
                        _jettag_c_iterate_154_3.setTagInfo(_td_c_iterate_154_3);
                        _jettag_c_iterate_154_3.doStart(context, out);
                        while (_jettag_c_iterate_154_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_155_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_155_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_155_4.setRuntimeParent(_jettag_c_iterate_154_3);
                            _jettag_c_setVariable_155_4.setTagInfo(_td_c_setVariable_155_4);
                            _jettag_c_setVariable_155_4.doStart(context, out);
                            _jettag_c_setVariable_155_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_157_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_157_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_157_6.setRuntimeParent(_jettag_c_iterate_154_3);
                            _jettag_c_if_157_6.setTagInfo(_td_c_if_157_6);
                            _jettag_c_if_157_6.doStart(context, out);
                            while (_jettag_c_if_157_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_159_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_159_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_159_12.setRuntimeParent(_jettag_c_if_157_6);
                                _jettag_c_iterate_159_12.setTagInfo(_td_c_iterate_159_12);
                                _jettag_c_iterate_159_12.doStart(context, out);
                                while (_jettag_c_iterate_159_12.okToProcessBody()) {
                                    // process only  composites on target
                                    RuntimeTagElement _jettag_c_if_161_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_161_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_161_12.setRuntimeParent(_jettag_c_iterate_159_12);
                                    _jettag_c_if_161_12.setTagInfo(_td_c_if_161_12);
                                    _jettag_c_if_161_12.doStart(context, out);
                                    while (_jettag_c_if_161_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_162_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_162_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_162_12.setRuntimeParent(_jettag_c_if_161_12);
                                        _jettag_c_setVariable_162_12.setTagInfo(_td_c_setVariable_162_12);
                                        _jettag_c_setVariable_162_12.doStart(context, out);
                                        _jettag_c_setVariable_162_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_164_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_164_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_164_14.setRuntimeParent(_jettag_c_if_161_12);
                                        _jettag_c_if_164_14.setTagInfo(_td_c_if_164_14);
                                        _jettag_c_if_164_14.doStart(context, out);
                                        while (_jettag_c_if_164_14.okToProcessBody()) {
                                            // iterate throught all the classes to get the other class on the association
                                            RuntimeTagElement _jettag_c_iterate_166_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_166_15); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_166_15.setRuntimeParent(_jettag_c_if_164_14);
                                            _jettag_c_iterate_166_15.setTagInfo(_td_c_iterate_166_15);
                                            _jettag_c_iterate_166_15.doStart(context, out);
                                            while (_jettag_c_iterate_166_15.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_167_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_167_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_167_16.setRuntimeParent(_jettag_c_iterate_166_15);
                                                _jettag_c_if_167_16.setTagInfo(_td_c_if_167_16);
                                                _jettag_c_if_167_16.doStart(context, out);
                                                while (_jettag_c_if_167_16.okToProcessBody()) {
                                                    out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 168, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".entity.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 168, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 168, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    RuntimeTagElement _jettag_c_if_169_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_169_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_169_12.setRuntimeParent(_jettag_c_if_167_16);
                                                    _jettag_c_if_169_12.setTagInfo(_td_c_if_169_12);
                                                    _jettag_c_if_169_12.doStart(context, out);
                                                    while (_jettag_c_if_169_12.okToProcessBody()) {
                                                        out.write(" \t\t\t\t\t\t\t\t\t\t//TODO check code gen");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 171, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 171, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 171, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".*;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_169_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_169_12.doEnd();
                                                    RuntimeTagElement _jettag_c_if_173_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_173_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_173_12.setRuntimeParent(_jettag_c_if_167_16);
                                                    _jettag_c_if_173_12.setTagInfo(_td_c_if_173_12);
                                                    _jettag_c_if_173_12.doStart(context, out);
                                                    while (_jettag_c_if_173_12.okToProcessBody()) {
                                                        out.write(" \t\t\t\t\t\t\t\t\t\t//TODO check codegen");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 175, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 175, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 175, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".*;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_173_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_173_12.doEnd();
                                                    _jettag_c_if_167_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_167_16.doEnd();
                                                _jettag_c_iterate_166_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_166_15.doEnd();
                                            _jettag_c_if_164_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_164_14.doEnd();
                                        _jettag_c_if_161_12.handleBodyContent(out);
                                    }
                                    _jettag_c_if_161_12.doEnd();
                                    _jettag_c_iterate_159_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_159_12.doEnd();
                                _jettag_c_if_157_6.handleBodyContent(out);
                            }
                            _jettag_c_if_157_6.doEnd();
                            _jettag_c_iterate_154_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_154_3.doEnd();
                        _jettag_c_iterate_153_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_153_2.doEnd();
                    _jettag_c_iterate_152_1.handleBodyContent(out);
                }
                _jettag_c_iterate_152_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_c_setVariable_187_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_187_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_187_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_187_1.setTagInfo(_td_c_setVariable_187_1);
                _jettag_c_setVariable_187_1.doStart(context, out);
                _jettag_c_setVariable_187_1.doEnd();
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.rf.GenericRequest;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 191, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".server.rf.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 191, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("GWTDao;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.requestfactory.RequestFactoryDaoLocator;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import com.google.web.bindery.requestfactory.shared.Request;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.web.bindery.requestfactory.shared.RequestContext;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.web.bindery.requestfactory.shared.Service;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("@Service(value = ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 198, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("GWTDao.class, locator = RequestFactoryDaoLocator.class)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public interface ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 199, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Request extends GenericRequest< ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 199, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy> {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tRequest<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 200, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy> findById(Long id);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\tRequest<Void> save(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 202, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy entity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tRequest<List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 204, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy>> query(int start, int limit);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\tRequest<Long> size();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("//TODO need to review which of these are actually needed");  //$NON-NLS-1$        
                out.write(NL);         
                // process all getRelated entities relations
                //process level2 generizations 
                RuntimeTagElement _jettag_c_if_211_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_211_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_211_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_211_1.setTagInfo(_td_c_if_211_1);
                _jettag_c_if_211_1.doStart(context, out);
                while (_jettag_c_if_211_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_212_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_212_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_212_6.setRuntimeParent(_jettag_c_if_211_1);
                    _jettag_c_setVariable_212_6.setTagInfo(_td_c_setVariable_212_6);
                    _jettag_c_setVariable_212_6.doStart(context, out);
                    _jettag_c_setVariable_212_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_213_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_213_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_213_6.setRuntimeParent(_jettag_c_if_211_1);
                    _jettag_c_iterate_213_6.setTagInfo(_td_c_iterate_213_6);
                    _jettag_c_iterate_213_6.doStart(context, out);
                    while (_jettag_c_iterate_213_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_214_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_214_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_214_2.setRuntimeParent(_jettag_c_iterate_213_6);
                        _jettag_c_iterate_214_2.setTagInfo(_td_c_iterate_214_2);
                        _jettag_c_iterate_214_2.doStart(context, out);
                        while (_jettag_c_iterate_214_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_215_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_215_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_215_3.setRuntimeParent(_jettag_c_iterate_214_2);
                            _jettag_c_iterate_215_3.setTagInfo(_td_c_iterate_215_3);
                            _jettag_c_iterate_215_3.doStart(context, out);
                            while (_jettag_c_iterate_215_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_216_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_216_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_216_4.setRuntimeParent(_jettag_c_iterate_215_3);
                                _jettag_c_setVariable_216_4.setTagInfo(_td_c_setVariable_216_4);
                                _jettag_c_setVariable_216_4.doStart(context, out);
                                _jettag_c_setVariable_216_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_218_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_218_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_218_6.setRuntimeParent(_jettag_c_iterate_215_3);
                                _jettag_c_if_218_6.setTagInfo(_td_c_if_218_6);
                                _jettag_c_if_218_6.doStart(context, out);
                                while (_jettag_c_if_218_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_220_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_220_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_220_12.setRuntimeParent(_jettag_c_if_218_6);
                                    _jettag_c_iterate_220_12.setTagInfo(_td_c_iterate_220_12);
                                    _jettag_c_iterate_220_12.doStart(context, out);
                                    while (_jettag_c_iterate_220_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_221_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_221_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_221_12.setRuntimeParent(_jettag_c_iterate_220_12);
                                        _jettag_c_setVariable_221_12.setTagInfo(_td_c_setVariable_221_12);
                                        _jettag_c_setVariable_221_12.doStart(context, out);
                                        _jettag_c_setVariable_221_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_223_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_223_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_223_13.setRuntimeParent(_jettag_c_iterate_220_12);
                                        _jettag_c_if_223_13.setTagInfo(_td_c_if_223_13);
                                        _jettag_c_if_223_13.doStart(context, out);
                                        while (_jettag_c_if_223_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_225_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_225_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_225_9.setRuntimeParent(_jettag_c_if_223_13);
                                            _jettag_c_if_225_9.setTagInfo(_td_c_if_225_9);
                                            _jettag_c_if_225_9.doStart(context, out);
                                            while (_jettag_c_if_225_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_226_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_226_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_226_11.setRuntimeParent(_jettag_c_if_225_9);
                                                _jettag_c_if_226_11.setTagInfo(_td_c_if_226_11);
                                                _jettag_c_if_226_11.doStart(context, out);
                                                while (_jettag_c_if_226_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_228_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_228_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_228_14.setRuntimeParent(_jettag_c_if_226_11);
                                                    _jettag_c_if_228_14.setTagInfo(_td_c_if_228_14);
                                                    _jettag_c_if_228_14.doStart(context, out);
                                                    while (_jettag_c_if_228_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_230_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_230_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_230_15.setRuntimeParent(_jettag_c_if_228_14);
                                                        _jettag_c_iterate_230_15.setTagInfo(_td_c_iterate_230_15);
                                                        _jettag_c_iterate_230_15.doStart(context, out);
                                                        while (_jettag_c_iterate_230_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_231_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_231_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_231_16.setRuntimeParent(_jettag_c_iterate_230_15);
                                                            _jettag_c_if_231_16.setTagInfo(_td_c_if_231_16);
                                                            _jettag_c_if_231_16.doStart(context, out);
                                                            while (_jettag_c_if_231_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_232_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_232_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_232_1.setRuntimeParent(_jettag_c_if_231_16);
                                                                _jettag_f_message_232_1.setTagInfo(_td_f_message_232_1);
                                                                _jettag_f_message_232_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_232_1_saved_out = out;
                                                                while (_jettag_f_message_232_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_232_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_232_1_saved_out;
                                                                _jettag_f_message_232_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("public   Request<List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 233, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy>> get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 233, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long entityID);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                // check to see if the parent side is aggregation or none
                                                                RuntimeTagElement _jettag_c_if_235_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_235_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_235_17.setRuntimeParent(_jettag_c_if_231_16);
                                                                _jettag_c_if_235_17.setTagInfo(_td_c_if_235_17);
                                                                _jettag_c_if_235_17.doStart(context, out);
                                                                while (_jettag_c_if_235_17.okToProcessBody()) {
                                                                    RuntimeTagElement _jettag_f_message_236_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_236_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_236_1.setRuntimeParent(_jettag_c_if_235_17);
                                                                    _jettag_f_message_236_1.setTagInfo(_td_f_message_236_1);
                                                                    _jettag_f_message_236_1.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_236_1_saved_out = out;
                                                                    while (_jettag_f_message_236_1.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_236_1.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_236_1_saved_out;
                                                                    _jettag_f_message_236_1.doEnd();
                                                                    out.write("\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("//public MultiSelectObj<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 237, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Proxy> get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 237, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(Long entityID, String[] columns);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_235_17.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_235_17.doEnd();
                                                                _jettag_c_if_231_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_231_16.doEnd();
                                                            _jettag_c_iterate_230_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_230_15.doEnd();
                                                        _jettag_c_if_228_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_228_14.doEnd();
                                                    _jettag_c_if_226_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_226_11.doEnd();
                                                _jettag_c_if_225_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_225_9.doEnd();
                                            _jettag_c_if_223_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_223_13.doEnd();
                                        _jettag_c_iterate_220_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_220_12.doEnd();
                                    _jettag_c_if_218_6.handleBodyContent(out);
                                }
                                _jettag_c_if_218_6.doEnd();
                                _jettag_c_iterate_215_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_215_3.doEnd();
                            _jettag_c_iterate_214_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_214_2.doEnd();
                        _jettag_c_iterate_213_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_213_6.doEnd();
                    _jettag_c_if_211_1.handleBodyContent(out);
                }
                _jettag_c_if_211_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_251_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_251_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_251_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_251_1.setTagInfo(_td_c_setVariable_251_1);
                _jettag_c_setVariable_251_1.doStart(context, out);
                _jettag_c_setVariable_251_1.doEnd();
                //process level 1 generizations 
                RuntimeTagElement _jettag_c_if_253_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_253_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_253_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_253_1.setTagInfo(_td_c_if_253_1);
                _jettag_c_if_253_1.doStart(context, out);
                while (_jettag_c_if_253_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_254_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_254_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_254_6.setRuntimeParent(_jettag_c_if_253_1);
                    _jettag_c_setVariable_254_6.setTagInfo(_td_c_setVariable_254_6);
                    _jettag_c_setVariable_254_6.doStart(context, out);
                    _jettag_c_setVariable_254_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_255_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_255_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_255_6.setRuntimeParent(_jettag_c_if_253_1);
                    _jettag_c_iterate_255_6.setTagInfo(_td_c_iterate_255_6);
                    _jettag_c_iterate_255_6.doStart(context, out);
                    while (_jettag_c_iterate_255_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_256_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_256_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_256_2.setRuntimeParent(_jettag_c_iterate_255_6);
                        _jettag_c_iterate_256_2.setTagInfo(_td_c_iterate_256_2);
                        _jettag_c_iterate_256_2.doStart(context, out);
                        while (_jettag_c_iterate_256_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_257_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_257_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_257_3.setRuntimeParent(_jettag_c_iterate_256_2);
                            _jettag_c_iterate_257_3.setTagInfo(_td_c_iterate_257_3);
                            _jettag_c_iterate_257_3.doStart(context, out);
                            while (_jettag_c_iterate_257_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_258_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_258_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_258_4.setRuntimeParent(_jettag_c_iterate_257_3);
                                _jettag_c_setVariable_258_4.setTagInfo(_td_c_setVariable_258_4);
                                _jettag_c_setVariable_258_4.doStart(context, out);
                                _jettag_c_setVariable_258_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_260_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_260_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_260_6.setRuntimeParent(_jettag_c_iterate_257_3);
                                _jettag_c_if_260_6.setTagInfo(_td_c_if_260_6);
                                _jettag_c_if_260_6.doStart(context, out);
                                while (_jettag_c_if_260_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_262_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_262_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_262_12.setRuntimeParent(_jettag_c_if_260_6);
                                    _jettag_c_iterate_262_12.setTagInfo(_td_c_iterate_262_12);
                                    _jettag_c_iterate_262_12.doStart(context, out);
                                    while (_jettag_c_iterate_262_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_263_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_263_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_263_12.setRuntimeParent(_jettag_c_iterate_262_12);
                                        _jettag_c_setVariable_263_12.setTagInfo(_td_c_setVariable_263_12);
                                        _jettag_c_setVariable_263_12.doStart(context, out);
                                        _jettag_c_setVariable_263_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_265_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_265_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_265_13.setRuntimeParent(_jettag_c_iterate_262_12);
                                        _jettag_c_if_265_13.setTagInfo(_td_c_if_265_13);
                                        _jettag_c_if_265_13.doStart(context, out);
                                        while (_jettag_c_if_265_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_267_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_267_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_267_9.setRuntimeParent(_jettag_c_if_265_13);
                                            _jettag_c_if_267_9.setTagInfo(_td_c_if_267_9);
                                            _jettag_c_if_267_9.doStart(context, out);
                                            while (_jettag_c_if_267_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_268_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_268_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_268_11.setRuntimeParent(_jettag_c_if_267_9);
                                                _jettag_c_if_268_11.setTagInfo(_td_c_if_268_11);
                                                _jettag_c_if_268_11.doStart(context, out);
                                                while (_jettag_c_if_268_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_270_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_270_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_270_14.setRuntimeParent(_jettag_c_if_268_11);
                                                    _jettag_c_if_270_14.setTagInfo(_td_c_if_270_14);
                                                    _jettag_c_if_270_14.doStart(context, out);
                                                    while (_jettag_c_if_270_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_272_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_272_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_272_15.setRuntimeParent(_jettag_c_if_270_14);
                                                        _jettag_c_iterate_272_15.setTagInfo(_td_c_iterate_272_15);
                                                        _jettag_c_iterate_272_15.doStart(context, out);
                                                        while (_jettag_c_iterate_272_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_273_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_273_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_273_16.setRuntimeParent(_jettag_c_iterate_272_15);
                                                            _jettag_c_if_273_16.setTagInfo(_td_c_if_273_16);
                                                            _jettag_c_if_273_16.doStart(context, out);
                                                            while (_jettag_c_if_273_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_274_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_274_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_274_1.setRuntimeParent(_jettag_c_if_273_16);
                                                                _jettag_f_message_274_1.setTagInfo(_td_f_message_274_1);
                                                                _jettag_f_message_274_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_274_1_saved_out = out;
                                                                while (_jettag_f_message_274_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_274_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_274_1_saved_out;
                                                                _jettag_f_message_274_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("public  Request<List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 275, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy>> get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 275, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long entityID);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                // check to see if the parent side is aggregation or none
                                                                RuntimeTagElement _jettag_c_if_277_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_277_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_277_17.setRuntimeParent(_jettag_c_if_273_16);
                                                                _jettag_c_if_277_17.setTagInfo(_td_c_if_277_17);
                                                                _jettag_c_if_277_17.doStart(context, out);
                                                                while (_jettag_c_if_277_17.okToProcessBody()) {
                                                                    RuntimeTagElement _jettag_f_message_278_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_278_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_278_1.setRuntimeParent(_jettag_c_if_277_17);
                                                                    _jettag_f_message_278_1.setTagInfo(_td_f_message_278_1);
                                                                    _jettag_f_message_278_1.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_278_1_saved_out = out;
                                                                    while (_jettag_f_message_278_1.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_278_1.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_278_1_saved_out;
                                                                    _jettag_f_message_278_1.doEnd();
                                                                    out.write("\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("//public MultiSelectObj<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 279, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Proxy> get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 279, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(Long entityID, String[] columns);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_277_17.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_277_17.doEnd();
                                                                _jettag_c_if_273_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_273_16.doEnd();
                                                            _jettag_c_iterate_272_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_272_15.doEnd();
                                                        _jettag_c_if_270_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_270_14.doEnd();
                                                    _jettag_c_if_268_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_268_11.doEnd();
                                                _jettag_c_if_267_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_267_9.doEnd();
                                            _jettag_c_if_265_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_265_13.doEnd();
                                        _jettag_c_iterate_262_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_262_12.doEnd();
                                    _jettag_c_if_260_6.handleBodyContent(out);
                                }
                                _jettag_c_if_260_6.doEnd();
                                _jettag_c_iterate_257_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_257_3.doEnd();
                            _jettag_c_iterate_256_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_256_2.doEnd();
                        _jettag_c_iterate_255_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_255_6.doEnd();
                    _jettag_c_if_253_1.handleBodyContent(out);
                }
                _jettag_c_if_253_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_293_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_293_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_293_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_293_1.setTagInfo(_td_c_setVariable_293_1);
                _jettag_c_setVariable_293_1.doStart(context, out);
                _jettag_c_setVariable_293_1.doEnd();
                //level 0 
                RuntimeTagElement _jettag_c_iterate_295_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_295_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_295_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_295_1.setTagInfo(_td_c_iterate_295_1);
                _jettag_c_iterate_295_1.doStart(context, out);
                while (_jettag_c_iterate_295_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_296_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_296_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_296_2.setRuntimeParent(_jettag_c_iterate_295_1);
                    _jettag_c_iterate_296_2.setTagInfo(_td_c_iterate_296_2);
                    _jettag_c_iterate_296_2.doStart(context, out);
                    while (_jettag_c_iterate_296_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_297_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_297_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_297_3.setRuntimeParent(_jettag_c_iterate_296_2);
                        _jettag_c_iterate_297_3.setTagInfo(_td_c_iterate_297_3);
                        _jettag_c_iterate_297_3.doStart(context, out);
                        while (_jettag_c_iterate_297_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_298_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_298_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_298_4.setRuntimeParent(_jettag_c_iterate_297_3);
                            _jettag_c_setVariable_298_4.setTagInfo(_td_c_setVariable_298_4);
                            _jettag_c_setVariable_298_4.doStart(context, out);
                            _jettag_c_setVariable_298_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_300_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_300_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_300_6.setRuntimeParent(_jettag_c_iterate_297_3);
                            _jettag_c_if_300_6.setTagInfo(_td_c_if_300_6);
                            _jettag_c_if_300_6.doStart(context, out);
                            while (_jettag_c_if_300_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_302_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_302_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_302_12.setRuntimeParent(_jettag_c_if_300_6);
                                _jettag_c_iterate_302_12.setTagInfo(_td_c_iterate_302_12);
                                _jettag_c_iterate_302_12.doStart(context, out);
                                while (_jettag_c_iterate_302_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_303_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_303_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_303_12.setRuntimeParent(_jettag_c_iterate_302_12);
                                    _jettag_c_setVariable_303_12.setTagInfo(_td_c_setVariable_303_12);
                                    _jettag_c_setVariable_303_12.doStart(context, out);
                                    _jettag_c_setVariable_303_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_305_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_305_13); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_305_13.setRuntimeParent(_jettag_c_iterate_302_12);
                                    _jettag_c_if_305_13.setTagInfo(_td_c_if_305_13);
                                    _jettag_c_if_305_13.doStart(context, out);
                                    while (_jettag_c_if_305_13.okToProcessBody()) {
                                        // process many on target
                                        RuntimeTagElement _jettag_c_if_307_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_307_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_307_9.setRuntimeParent(_jettag_c_if_305_13);
                                        _jettag_c_if_307_9.setTagInfo(_td_c_if_307_9);
                                        _jettag_c_if_307_9.doStart(context, out);
                                        while (_jettag_c_if_307_9.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_308_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_308_11); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_308_11.setRuntimeParent(_jettag_c_if_307_9);
                                            _jettag_c_if_308_11.setTagInfo(_td_c_if_308_11);
                                            _jettag_c_if_308_11.doStart(context, out);
                                            while (_jettag_c_if_308_11.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_310_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_310_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_310_14.setRuntimeParent(_jettag_c_if_308_11);
                                                _jettag_c_if_310_14.setTagInfo(_td_c_if_310_14);
                                                _jettag_c_if_310_14.doStart(context, out);
                                                while (_jettag_c_if_310_14.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_312_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_312_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_312_15.setRuntimeParent(_jettag_c_if_310_14);
                                                    _jettag_c_iterate_312_15.setTagInfo(_td_c_iterate_312_15);
                                                    _jettag_c_iterate_312_15.doStart(context, out);
                                                    while (_jettag_c_iterate_312_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_313_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_313_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_313_16.setRuntimeParent(_jettag_c_iterate_312_15);
                                                        _jettag_c_if_313_16.setTagInfo(_td_c_if_313_16);
                                                        _jettag_c_if_313_16.doStart(context, out);
                                                        while (_jettag_c_if_313_16.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_f_message_314_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_314_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_314_1.setRuntimeParent(_jettag_c_if_313_16);
                                                            _jettag_f_message_314_1.setTagInfo(_td_f_message_314_1);
                                                            _jettag_f_message_314_1.doStart(context, out);
                                                            JET2Writer _jettag_f_message_314_1_saved_out = out;
                                                            while (_jettag_f_message_314_1.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_314_1.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_314_1_saved_out;
                                                            _jettag_f_message_314_1.doEnd();
                                                            out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("public   Request<List<");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 315, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Proxy>> get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 315, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s(Long entityID);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            // check to see if the parent side is aggregation or none
                                                            RuntimeTagElement _jettag_c_if_317_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_317_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_317_17.setRuntimeParent(_jettag_c_if_313_16);
                                                            _jettag_c_if_317_17.setTagInfo(_td_c_if_317_17);
                                                            _jettag_c_if_317_17.doStart(context, out);
                                                            while (_jettag_c_if_317_17.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_318_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_318_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_318_1.setRuntimeParent(_jettag_c_if_317_17);
                                                                _jettag_f_message_318_1.setTagInfo(_td_f_message_318_1);
                                                                _jettag_f_message_318_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_318_1_saved_out = out;
                                                                while (_jettag_f_message_318_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_318_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_318_1_saved_out;
                                                                _jettag_f_message_318_1.doEnd();
                                                                out.write("\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("//public MultiSelectObj<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 319, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy> get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 319, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long entityID, String[] columns);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_317_17.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_317_17.doEnd();
                                                            _jettag_c_if_313_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_313_16.doEnd();
                                                        out.write(" \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_iterate_312_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_312_15.doEnd();
                                                    _jettag_c_if_310_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_310_14.doEnd();
                                                _jettag_c_if_308_11.handleBodyContent(out);
                                            }
                                            _jettag_c_if_308_11.doEnd();
                                            _jettag_c_if_307_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_307_9.doEnd();
                                        _jettag_c_if_305_13.handleBodyContent(out);
                                    }
                                    _jettag_c_if_305_13.doEnd();
                                    _jettag_c_iterate_302_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_302_12.doEnd();
                                _jettag_c_if_300_6.handleBodyContent(out);
                            }
                            _jettag_c_if_300_6.doEnd();
                            _jettag_c_iterate_297_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_297_3.doEnd();
                        _jettag_c_iterate_296_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_296_2.doEnd();
                    _jettag_c_iterate_295_1.handleBodyContent(out);
                }
                _jettag_c_iterate_295_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process all addAll relations
                RuntimeTagElement _jettag_c_iterate_335_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_335_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_335_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_335_1.setTagInfo(_td_c_iterate_335_1);
                _jettag_c_iterate_335_1.doStart(context, out);
                while (_jettag_c_iterate_335_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_336_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_336_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_336_2.setRuntimeParent(_jettag_c_iterate_335_1);
                    _jettag_c_iterate_336_2.setTagInfo(_td_c_iterate_336_2);
                    _jettag_c_iterate_336_2.doStart(context, out);
                    while (_jettag_c_iterate_336_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_337_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_337_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_337_3.setRuntimeParent(_jettag_c_iterate_336_2);
                        _jettag_c_iterate_337_3.setTagInfo(_td_c_iterate_337_3);
                        _jettag_c_iterate_337_3.doStart(context, out);
                        while (_jettag_c_iterate_337_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_338_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_338_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_338_4.setRuntimeParent(_jettag_c_iterate_337_3);
                            _jettag_c_setVariable_338_4.setTagInfo(_td_c_setVariable_338_4);
                            _jettag_c_setVariable_338_4.doStart(context, out);
                            _jettag_c_setVariable_338_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_340_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_340_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_340_6.setRuntimeParent(_jettag_c_iterate_337_3);
                            _jettag_c_if_340_6.setTagInfo(_td_c_if_340_6);
                            _jettag_c_if_340_6.doStart(context, out);
                            while (_jettag_c_if_340_6.okToProcessBody()) {
                                // process only classes with many on source side
                                RuntimeTagElement _jettag_c_if_342_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_342_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_342_6.setRuntimeParent(_jettag_c_if_340_6);
                                _jettag_c_if_342_6.setTagInfo(_td_c_if_342_6);
                                _jettag_c_if_342_6.doStart(context, out);
                                while (_jettag_c_if_342_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_343_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_343_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_343_8.setRuntimeParent(_jettag_c_if_342_6);
                                    _jettag_c_if_343_8.setTagInfo(_td_c_if_343_8);
                                    _jettag_c_if_343_8.doStart(context, out);
                                    while (_jettag_c_if_343_8.okToProcessBody()) {
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_345_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_345_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_345_12.setRuntimeParent(_jettag_c_if_343_8);
                                        _jettag_c_iterate_345_12.setTagInfo(_td_c_iterate_345_12);
                                        _jettag_c_iterate_345_12.doStart(context, out);
                                        while (_jettag_c_iterate_345_12.okToProcessBody()) {
                                            // process only non composites 
                                            RuntimeTagElement _jettag_c_if_347_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_347_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_347_12.setRuntimeParent(_jettag_c_iterate_345_12);
                                            _jettag_c_if_347_12.setTagInfo(_td_c_if_347_12);
                                            _jettag_c_if_347_12.doStart(context, out);
                                            while (_jettag_c_if_347_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_348_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_348_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_348_12.setRuntimeParent(_jettag_c_if_347_12);
                                                _jettag_c_setVariable_348_12.setTagInfo(_td_c_setVariable_348_12);
                                                _jettag_c_setVariable_348_12.doStart(context, out);
                                                _jettag_c_setVariable_348_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_350_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_350_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_350_14.setRuntimeParent(_jettag_c_if_347_12);
                                                _jettag_c_if_350_14.setTagInfo(_td_c_if_350_14);
                                                _jettag_c_if_350_14.doStart(context, out);
                                                while (_jettag_c_if_350_14.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_352_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_352_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_352_14.setRuntimeParent(_jettag_c_if_350_14);
                                                    _jettag_c_if_352_14.setTagInfo(_td_c_if_352_14);
                                                    _jettag_c_if_352_14.doStart(context, out);
                                                    while (_jettag_c_if_352_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_354_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_354_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_354_15.setRuntimeParent(_jettag_c_if_352_14);
                                                        _jettag_c_iterate_354_15.setTagInfo(_td_c_iterate_354_15);
                                                        _jettag_c_iterate_354_15.doStart(context, out);
                                                        while (_jettag_c_iterate_354_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_355_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_355_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_355_16.setRuntimeParent(_jettag_c_iterate_354_15);
                                                            _jettag_c_if_355_16.setTagInfo(_td_c_if_355_16);
                                                            _jettag_c_if_355_16.doStart(context, out);
                                                            while (_jettag_c_if_355_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_356_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_356_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_356_1.setRuntimeParent(_jettag_c_if_355_16);
                                                                _jettag_f_message_356_1.setTagInfo(_td_f_message_356_1);
                                                                _jettag_f_message_356_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_356_1_saved_out = out;
                                                                while (_jettag_f_message_356_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_356_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_356_1_saved_out;
                                                                _jettag_f_message_356_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("//public void addAll(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 357, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 357, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(", ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 357, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" children,List<Long> childrenIds);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_355_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_355_16.doEnd();
                                                            _jettag_c_iterate_354_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_354_15.doEnd();
                                                        _jettag_c_if_352_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_352_14.doEnd();
                                                    _jettag_c_if_350_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_350_14.doEnd();
                                                _jettag_c_if_347_12.handleBodyContent(out);
                                            }
                                            _jettag_c_if_347_12.doEnd();
                                            _jettag_c_iterate_345_12.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_345_12.doEnd();
                                        _jettag_c_if_343_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_343_8.doEnd();
                                    _jettag_c_if_342_6.handleBodyContent(out);
                                }
                                _jettag_c_if_342_6.doEnd();
                                _jettag_c_if_340_6.handleBodyContent(out);
                            }
                            _jettag_c_if_340_6.doEnd();
                            _jettag_c_iterate_337_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_337_3.doEnd();
                        _jettag_c_iterate_336_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_336_2.doEnd();
                    _jettag_c_iterate_335_1.handleBodyContent(out);
                }
                _jettag_c_iterate_335_1.doEnd();
                out.write(NL);         
                // process all removeAll relations
                RuntimeTagElement _jettag_c_iterate_372_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_372_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_372_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_372_1.setTagInfo(_td_c_iterate_372_1);
                _jettag_c_iterate_372_1.doStart(context, out);
                while (_jettag_c_iterate_372_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_373_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_373_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_373_2.setRuntimeParent(_jettag_c_iterate_372_1);
                    _jettag_c_iterate_373_2.setTagInfo(_td_c_iterate_373_2);
                    _jettag_c_iterate_373_2.doStart(context, out);
                    while (_jettag_c_iterate_373_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_374_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_374_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_374_3.setRuntimeParent(_jettag_c_iterate_373_2);
                        _jettag_c_iterate_374_3.setTagInfo(_td_c_iterate_374_3);
                        _jettag_c_iterate_374_3.doStart(context, out);
                        while (_jettag_c_iterate_374_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_375_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_375_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_375_4.setRuntimeParent(_jettag_c_iterate_374_3);
                            _jettag_c_setVariable_375_4.setTagInfo(_td_c_setVariable_375_4);
                            _jettag_c_setVariable_375_4.doStart(context, out);
                            _jettag_c_setVariable_375_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_377_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_377_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_377_6.setRuntimeParent(_jettag_c_iterate_374_3);
                            _jettag_c_if_377_6.setTagInfo(_td_c_if_377_6);
                            _jettag_c_if_377_6.doStart(context, out);
                            while (_jettag_c_if_377_6.okToProcessBody()) {
                                // process only classes with many on source side
                                RuntimeTagElement _jettag_c_if_379_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_379_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_379_6.setRuntimeParent(_jettag_c_if_377_6);
                                _jettag_c_if_379_6.setTagInfo(_td_c_if_379_6);
                                _jettag_c_if_379_6.doStart(context, out);
                                while (_jettag_c_if_379_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_380_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_380_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_380_8.setRuntimeParent(_jettag_c_if_379_6);
                                    _jettag_c_if_380_8.setTagInfo(_td_c_if_380_8);
                                    _jettag_c_if_380_8.doStart(context, out);
                                    while (_jettag_c_if_380_8.okToProcessBody()) {
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_382_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_382_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_382_12.setRuntimeParent(_jettag_c_if_380_8);
                                        _jettag_c_iterate_382_12.setTagInfo(_td_c_iterate_382_12);
                                        _jettag_c_iterate_382_12.doStart(context, out);
                                        while (_jettag_c_iterate_382_12.okToProcessBody()) {
                                            // process only non composites 
                                            RuntimeTagElement _jettag_c_if_384_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_384_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_384_12.setRuntimeParent(_jettag_c_iterate_382_12);
                                            _jettag_c_if_384_12.setTagInfo(_td_c_if_384_12);
                                            _jettag_c_if_384_12.doStart(context, out);
                                            while (_jettag_c_if_384_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_385_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_385_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_385_12.setRuntimeParent(_jettag_c_if_384_12);
                                                _jettag_c_setVariable_385_12.setTagInfo(_td_c_setVariable_385_12);
                                                _jettag_c_setVariable_385_12.doStart(context, out);
                                                _jettag_c_setVariable_385_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_387_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_387_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_387_14.setRuntimeParent(_jettag_c_if_384_12);
                                                _jettag_c_if_387_14.setTagInfo(_td_c_if_387_14);
                                                _jettag_c_if_387_14.doStart(context, out);
                                                while (_jettag_c_if_387_14.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_389_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_389_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_389_14.setRuntimeParent(_jettag_c_if_387_14);
                                                    _jettag_c_if_389_14.setTagInfo(_td_c_if_389_14);
                                                    _jettag_c_if_389_14.doStart(context, out);
                                                    while (_jettag_c_if_389_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_391_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_391_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_391_15.setRuntimeParent(_jettag_c_if_389_14);
                                                        _jettag_c_iterate_391_15.setTagInfo(_td_c_iterate_391_15);
                                                        _jettag_c_iterate_391_15.doStart(context, out);
                                                        while (_jettag_c_iterate_391_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_392_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_392_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_392_16.setRuntimeParent(_jettag_c_iterate_391_15);
                                                            _jettag_c_if_392_16.setTagInfo(_td_c_if_392_16);
                                                            _jettag_c_if_392_16.doStart(context, out);
                                                            while (_jettag_c_if_392_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_393_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_393_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_393_1.setRuntimeParent(_jettag_c_if_392_16);
                                                                _jettag_f_message_393_1.setTagInfo(_td_f_message_393_1);
                                                                _jettag_f_message_393_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_393_1_saved_out = out;
                                                                while (_jettag_f_message_393_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_393_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_393_1_saved_out;
                                                                _jettag_f_message_393_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("//public void removeAll(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 394, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 394, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(", ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 394, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" children,List<Long> childrenIds);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_392_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_392_16.doEnd();
                                                            _jettag_c_iterate_391_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_391_15.doEnd();
                                                        _jettag_c_if_389_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_389_14.doEnd();
                                                    _jettag_c_if_387_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_387_14.doEnd();
                                                _jettag_c_if_384_12.handleBodyContent(out);
                                            }
                                            _jettag_c_if_384_12.doEnd();
                                            _jettag_c_iterate_382_12.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_382_12.doEnd();
                                        _jettag_c_if_380_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_380_8.doEnd();
                                    _jettag_c_if_379_6.handleBodyContent(out);
                                }
                                _jettag_c_if_379_6.doEnd();
                                _jettag_c_if_377_6.handleBodyContent(out);
                            }
                            _jettag_c_if_377_6.doEnd();
                            _jettag_c_iterate_374_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_374_3.doEnd();
                        _jettag_c_iterate_373_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_373_2.doEnd();
                    _jettag_c_iterate_372_1.handleBodyContent(out);
                }
                _jettag_c_iterate_372_1.doEnd();
                out.write(NL);         
                // process all merge relations
                RuntimeTagElement _jettag_c_iterate_409_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_409_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_409_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_409_1.setTagInfo(_td_c_iterate_409_1);
                _jettag_c_iterate_409_1.doStart(context, out);
                while (_jettag_c_iterate_409_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_410_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_410_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_410_2.setRuntimeParent(_jettag_c_iterate_409_1);
                    _jettag_c_iterate_410_2.setTagInfo(_td_c_iterate_410_2);
                    _jettag_c_iterate_410_2.doStart(context, out);
                    while (_jettag_c_iterate_410_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_411_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_411_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_411_3.setRuntimeParent(_jettag_c_iterate_410_2);
                        _jettag_c_iterate_411_3.setTagInfo(_td_c_iterate_411_3);
                        _jettag_c_iterate_411_3.doStart(context, out);
                        while (_jettag_c_iterate_411_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_412_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_412_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_412_4.setRuntimeParent(_jettag_c_iterate_411_3);
                            _jettag_c_setVariable_412_4.setTagInfo(_td_c_setVariable_412_4);
                            _jettag_c_setVariable_412_4.doStart(context, out);
                            _jettag_c_setVariable_412_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_414_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_414_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_414_6.setRuntimeParent(_jettag_c_iterate_411_3);
                            _jettag_c_if_414_6.setTagInfo(_td_c_if_414_6);
                            _jettag_c_if_414_6.doStart(context, out);
                            while (_jettag_c_if_414_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_416_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_416_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_416_12.setRuntimeParent(_jettag_c_if_414_6);
                                _jettag_c_iterate_416_12.setTagInfo(_td_c_iterate_416_12);
                                _jettag_c_iterate_416_12.doStart(context, out);
                                while (_jettag_c_iterate_416_12.okToProcessBody()) {
                                    // process only  composites on target
                                    RuntimeTagElement _jettag_c_if_418_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_418_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_418_12.setRuntimeParent(_jettag_c_iterate_416_12);
                                    _jettag_c_if_418_12.setTagInfo(_td_c_if_418_12);
                                    _jettag_c_if_418_12.doStart(context, out);
                                    while (_jettag_c_if_418_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_419_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_419_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_419_12.setRuntimeParent(_jettag_c_if_418_12);
                                        _jettag_c_setVariable_419_12.setTagInfo(_td_c_setVariable_419_12);
                                        _jettag_c_setVariable_419_12.doStart(context, out);
                                        _jettag_c_setVariable_419_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_421_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_421_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_421_14.setRuntimeParent(_jettag_c_if_418_12);
                                        _jettag_c_if_421_14.setTagInfo(_td_c_if_421_14);
                                        _jettag_c_if_421_14.doStart(context, out);
                                        while (_jettag_c_if_421_14.okToProcessBody()) {
                                            // iterate throught all the classes to get the other class on the association
                                            RuntimeTagElement _jettag_c_iterate_423_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_423_15); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_423_15.setRuntimeParent(_jettag_c_if_421_14);
                                            _jettag_c_iterate_423_15.setTagInfo(_td_c_iterate_423_15);
                                            _jettag_c_iterate_423_15.doStart(context, out);
                                            while (_jettag_c_iterate_423_15.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_424_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_424_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_424_16.setRuntimeParent(_jettag_c_iterate_423_15);
                                                _jettag_c_if_424_16.setTagInfo(_td_c_if_424_16);
                                                _jettag_c_if_424_16.doStart(context, out);
                                                while (_jettag_c_if_424_16.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_f_message_425_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_425_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_f_message_425_1.setRuntimeParent(_jettag_c_if_424_16);
                                                    _jettag_f_message_425_1.setTagInfo(_td_f_message_425_1);
                                                    _jettag_f_message_425_1.doStart(context, out);
                                                    JET2Writer _jettag_f_message_425_1_saved_out = out;
                                                    while (_jettag_f_message_425_1.okToProcessBody()) {
                                                        out = out.newNestedContentWriter();
                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                        _jettag_f_message_425_1.handleBodyContent(out);
                                                    }
                                                    out = _jettag_f_message_425_1_saved_out;
                                                    _jettag_f_message_425_1.doEnd();
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("//public void merge(");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 426, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(" entity, ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 426, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(" child);");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_424_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_424_16.doEnd();
                                                _jettag_c_iterate_423_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_423_15.doEnd();
                                            _jettag_c_if_421_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_421_14.doEnd();
                                        _jettag_c_if_418_12.handleBodyContent(out);
                                    }
                                    _jettag_c_if_418_12.doEnd();
                                    _jettag_c_iterate_416_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_416_12.doEnd();
                                _jettag_c_if_414_6.handleBodyContent(out);
                            }
                            _jettag_c_if_414_6.doEnd();
                            _jettag_c_iterate_411_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_411_3.doEnd();
                        _jettag_c_iterate_410_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_410_2.doEnd();
                    _jettag_c_iterate_409_1.handleBodyContent(out);
                }
                _jettag_c_iterate_409_1.doEnd();
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
