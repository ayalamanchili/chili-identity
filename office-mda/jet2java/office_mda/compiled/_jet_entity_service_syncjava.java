package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_service_syncjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_entity_service_syncjava() {
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
    private static final TagInfo _td_c_setVariable_7_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            7, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_12_1 = new TagInfo("c:if", //$NON-NLS-1$
            12, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_13_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            13, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_14_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            14, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_15_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            15, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_16_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            16, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_17_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            17, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_19_6 = new TagInfo("c:if", //$NON-NLS-1$
            19, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_21_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            21, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_22_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            22, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_24_13 = new TagInfo("c:if", //$NON-NLS-1$
            24, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_26_9 = new TagInfo("c:if", //$NON-NLS-1$
            26, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_27_11 = new TagInfo("c:if", //$NON-NLS-1$
            27, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_29_14 = new TagInfo("c:if", //$NON-NLS-1$
            29, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_31_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            31, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_32_16 = new TagInfo("c:if", //$NON-NLS-1$
            32, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_46_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            46, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_48_1 = new TagInfo("c:if", //$NON-NLS-1$
            48, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_49_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            49, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_50_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            50, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_51_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            51, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_52_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            52, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_53_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            53, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_55_6 = new TagInfo("c:if", //$NON-NLS-1$
            55, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_57_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            57, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_58_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            58, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_60_13 = new TagInfo("c:if", //$NON-NLS-1$
            60, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_62_9 = new TagInfo("c:if", //$NON-NLS-1$
            62, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_63_11 = new TagInfo("c:if", //$NON-NLS-1$
            63, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_65_14 = new TagInfo("c:if", //$NON-NLS-1$
            65, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_67_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            67, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_68_16 = new TagInfo("c:if", //$NON-NLS-1$
            68, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_82_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            82, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_84_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            84, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_85_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            85, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_86_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            86, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_87_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            87, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_89_6 = new TagInfo("c:if", //$NON-NLS-1$
            89, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_91_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            91, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_92_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            92, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_94_13 = new TagInfo("c:if", //$NON-NLS-1$
            94, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_96_9 = new TagInfo("c:if", //$NON-NLS-1$
            96, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_97_11 = new TagInfo("c:if", //$NON-NLS-1$
            97, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_99_14 = new TagInfo("c:if", //$NON-NLS-1$
            99, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_101_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            101, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_102_16 = new TagInfo("c:if", //$NON-NLS-1$
            102, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_117_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            117, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_118_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            118, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_119_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            119, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_120_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            120, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_122_6 = new TagInfo("c:if", //$NON-NLS-1$
            122, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_124_6 = new TagInfo("c:if", //$NON-NLS-1$
            124, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_125_8 = new TagInfo("c:if", //$NON-NLS-1$
            125, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_127_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            127, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_129_12 = new TagInfo("c:if", //$NON-NLS-1$
            129, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_130_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            130, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_132_14 = new TagInfo("c:if", //$NON-NLS-1$
            132, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_134_14 = new TagInfo("c:if", //$NON-NLS-1$
            134, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_136_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            136, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_137_16 = new TagInfo("c:if", //$NON-NLS-1$
            137, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_153_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            153, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_154_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            154, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_155_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            155, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_156_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            156, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_158_6 = new TagInfo("c:if", //$NON-NLS-1$
            158, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_160_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            160, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_162_12 = new TagInfo("c:if", //$NON-NLS-1$
            162, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_163_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            163, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_165_14 = new TagInfo("c:if", //$NON-NLS-1$
            165, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_167_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            167, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_168_16 = new TagInfo("c:if", //$NON-NLS-1$
            168, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_170_12 = new TagInfo("c:if", //$NON-NLS-1$
            170, 12,
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
    private static final TagInfo _td_c_setVariable_186_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            186, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_203_2 = new TagInfo("f:message", //$NON-NLS-1$
            203, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_205_1 = new TagInfo("f:message", //$NON-NLS-1$
            205, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_207_1 = new TagInfo("f:message", //$NON-NLS-1$
            207, 1,
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
    private static final TagInfo _td_f_message_211_1 = new TagInfo("f:message", //$NON-NLS-1$
            211, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_213_1 = new TagInfo("f:message", //$NON-NLS-1$
            213, 1,
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
    private static final TagInfo _td_f_message_219_1 = new TagInfo("f:message", //$NON-NLS-1$
            219, 1,
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
    private static final TagInfo _td_c_if_232_1 = new TagInfo("c:if", //$NON-NLS-1$
            232, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_233_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            233, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_234_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            234, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_235_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            235, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_236_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            236, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_237_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            237, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_239_6 = new TagInfo("c:if", //$NON-NLS-1$
            239, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_241_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            241, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_242_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            242, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_244_13 = new TagInfo("c:if", //$NON-NLS-1$
            244, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_246_9 = new TagInfo("c:if", //$NON-NLS-1$
            246, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_247_11 = new TagInfo("c:if", //$NON-NLS-1$
            247, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_249_14 = new TagInfo("c:if", //$NON-NLS-1$
            249, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_251_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            251, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_252_16 = new TagInfo("c:if", //$NON-NLS-1$
            252, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_253_1 = new TagInfo("f:message", //$NON-NLS-1$
            253, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_256_17 = new TagInfo("c:if", //$NON-NLS-1$
            256, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_257_1 = new TagInfo("f:message", //$NON-NLS-1$
            257, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_setVariable_272_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            272, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_274_1 = new TagInfo("c:if", //$NON-NLS-1$
            274, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_275_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            275, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_276_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            276, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_277_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            277, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_278_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            278, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_279_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            279, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_281_6 = new TagInfo("c:if", //$NON-NLS-1$
            281, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_283_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            283, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_284_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            284, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_286_13 = new TagInfo("c:if", //$NON-NLS-1$
            286, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_288_9 = new TagInfo("c:if", //$NON-NLS-1$
            288, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_289_11 = new TagInfo("c:if", //$NON-NLS-1$
            289, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_291_14 = new TagInfo("c:if", //$NON-NLS-1$
            291, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_293_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            293, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_294_16 = new TagInfo("c:if", //$NON-NLS-1$
            294, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_295_1 = new TagInfo("f:message", //$NON-NLS-1$
            295, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_298_17 = new TagInfo("c:if", //$NON-NLS-1$
            298, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_299_1 = new TagInfo("f:message", //$NON-NLS-1$
            299, 1,
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
    private static final TagInfo _td_c_iterate_430_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            430, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_431_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            431, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_432_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            432, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_433_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            433, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_435_6 = new TagInfo("c:if", //$NON-NLS-1$
            435, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_437_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            437, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_439_12 = new TagInfo("c:if", //$NON-NLS-1$
            439, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_440_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            440, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_442_14 = new TagInfo("c:if", //$NON-NLS-1$
            442, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_444_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            444, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_445_16 = new TagInfo("c:if", //$NON-NLS-1$
            445, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_446_1 = new TagInfo("f:message", //$NON-NLS-1$
            446, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_457_1 = new TagInfo("f:message", //$NON-NLS-1$
            457, 1,
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
                RuntimeTagElement _jettag_c_setVariable_7_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_7_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_7_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_7_1.setTagInfo(_td_c_setVariable_7_1);
                _jettag_c_setVariable_7_1.doStart(context, out);
                _jettag_c_setVariable_7_1.doEnd();
                out.write(NL);         
                out.write(NL);         
                // process all getRelated entities relations
                //process level2 generizations 
                RuntimeTagElement _jettag_c_if_12_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_12_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_12_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_12_1.setTagInfo(_td_c_if_12_1);
                _jettag_c_if_12_1.doStart(context, out);
                while (_jettag_c_if_12_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_13_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_13_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_13_6.setRuntimeParent(_jettag_c_if_12_1);
                    _jettag_c_setVariable_13_6.setTagInfo(_td_c_setVariable_13_6);
                    _jettag_c_setVariable_13_6.doStart(context, out);
                    _jettag_c_setVariable_13_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_14_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_14_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_14_6.setRuntimeParent(_jettag_c_if_12_1);
                    _jettag_c_iterate_14_6.setTagInfo(_td_c_iterate_14_6);
                    _jettag_c_iterate_14_6.doStart(context, out);
                    while (_jettag_c_iterate_14_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_15_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_15_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_15_2.setRuntimeParent(_jettag_c_iterate_14_6);
                        _jettag_c_iterate_15_2.setTagInfo(_td_c_iterate_15_2);
                        _jettag_c_iterate_15_2.doStart(context, out);
                        while (_jettag_c_iterate_15_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_16_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_16_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_16_3.setRuntimeParent(_jettag_c_iterate_15_2);
                            _jettag_c_iterate_16_3.setTagInfo(_td_c_iterate_16_3);
                            _jettag_c_iterate_16_3.doStart(context, out);
                            while (_jettag_c_iterate_16_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_17_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_17_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_17_4.setRuntimeParent(_jettag_c_iterate_16_3);
                                _jettag_c_setVariable_17_4.setTagInfo(_td_c_setVariable_17_4);
                                _jettag_c_setVariable_17_4.doStart(context, out);
                                _jettag_c_setVariable_17_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_19_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_19_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_19_6.setRuntimeParent(_jettag_c_iterate_16_3);
                                _jettag_c_if_19_6.setTagInfo(_td_c_if_19_6);
                                _jettag_c_if_19_6.doStart(context, out);
                                while (_jettag_c_if_19_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_21_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_21_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_21_12.setRuntimeParent(_jettag_c_if_19_6);
                                    _jettag_c_iterate_21_12.setTagInfo(_td_c_iterate_21_12);
                                    _jettag_c_iterate_21_12.doStart(context, out);
                                    while (_jettag_c_iterate_21_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_22_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_22_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_22_12.setRuntimeParent(_jettag_c_iterate_21_12);
                                        _jettag_c_setVariable_22_12.setTagInfo(_td_c_setVariable_22_12);
                                        _jettag_c_setVariable_22_12.doStart(context, out);
                                        _jettag_c_setVariable_22_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_24_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_24_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_24_13.setRuntimeParent(_jettag_c_iterate_21_12);
                                        _jettag_c_if_24_13.setTagInfo(_td_c_if_24_13);
                                        _jettag_c_if_24_13.doStart(context, out);
                                        while (_jettag_c_if_24_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_26_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_26_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_26_9.setRuntimeParent(_jettag_c_if_24_13);
                                            _jettag_c_if_26_9.setTagInfo(_td_c_if_26_9);
                                            _jettag_c_if_26_9.doStart(context, out);
                                            while (_jettag_c_if_26_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_27_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_27_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_27_11.setRuntimeParent(_jettag_c_if_26_9);
                                                _jettag_c_if_27_11.setTagInfo(_td_c_if_27_11);
                                                _jettag_c_if_27_11.doStart(context, out);
                                                while (_jettag_c_if_27_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_29_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_29_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_29_14.setRuntimeParent(_jettag_c_if_27_11);
                                                    _jettag_c_if_29_14.setTagInfo(_td_c_if_29_14);
                                                    _jettag_c_if_29_14.doStart(context, out);
                                                    while (_jettag_c_if_29_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_31_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_31_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_31_15.setRuntimeParent(_jettag_c_if_29_14);
                                                        _jettag_c_iterate_31_15.setTagInfo(_td_c_iterate_31_15);
                                                        _jettag_c_iterate_31_15.doStart(context, out);
                                                        while (_jettag_c_iterate_31_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_32_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_32_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_32_16.setRuntimeParent(_jettag_c_iterate_31_15);
                                                            _jettag_c_if_32_16.setTagInfo(_td_c_if_32_16);
                                                            _jettag_c_if_32_16.doStart(context, out);
                                                            while (_jettag_c_if_32_16.okToProcessBody()) {
                                                                out.write("import ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 33, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".entity.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 33, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 33, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(";");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_32_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_32_16.doEnd();
                                                            _jettag_c_iterate_31_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_31_15.doEnd();
                                                        _jettag_c_if_29_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_29_14.doEnd();
                                                    _jettag_c_if_27_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_27_11.doEnd();
                                                _jettag_c_if_26_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_26_9.doEnd();
                                            _jettag_c_if_24_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_24_13.doEnd();
                                        _jettag_c_iterate_21_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_21_12.doEnd();
                                    _jettag_c_if_19_6.handleBodyContent(out);
                                }
                                _jettag_c_if_19_6.doEnd();
                                _jettag_c_iterate_16_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_16_3.doEnd();
                            _jettag_c_iterate_15_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_15_2.doEnd();
                        _jettag_c_iterate_14_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_14_6.doEnd();
                    _jettag_c_if_12_1.handleBodyContent(out);
                }
                _jettag_c_if_12_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_46_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_46_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_46_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_46_1.setTagInfo(_td_c_setVariable_46_1);
                _jettag_c_setVariable_46_1.doStart(context, out);
                _jettag_c_setVariable_46_1.doEnd();
                //process level 1 generizations 
                RuntimeTagElement _jettag_c_if_48_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_48_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_48_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_48_1.setTagInfo(_td_c_if_48_1);
                _jettag_c_if_48_1.doStart(context, out);
                while (_jettag_c_if_48_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_49_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_49_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_49_6.setRuntimeParent(_jettag_c_if_48_1);
                    _jettag_c_setVariable_49_6.setTagInfo(_td_c_setVariable_49_6);
                    _jettag_c_setVariable_49_6.doStart(context, out);
                    _jettag_c_setVariable_49_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_50_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_50_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_50_6.setRuntimeParent(_jettag_c_if_48_1);
                    _jettag_c_iterate_50_6.setTagInfo(_td_c_iterate_50_6);
                    _jettag_c_iterate_50_6.doStart(context, out);
                    while (_jettag_c_iterate_50_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_51_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_51_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_51_2.setRuntimeParent(_jettag_c_iterate_50_6);
                        _jettag_c_iterate_51_2.setTagInfo(_td_c_iterate_51_2);
                        _jettag_c_iterate_51_2.doStart(context, out);
                        while (_jettag_c_iterate_51_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_52_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_52_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_52_3.setRuntimeParent(_jettag_c_iterate_51_2);
                            _jettag_c_iterate_52_3.setTagInfo(_td_c_iterate_52_3);
                            _jettag_c_iterate_52_3.doStart(context, out);
                            while (_jettag_c_iterate_52_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_53_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_53_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_53_4.setRuntimeParent(_jettag_c_iterate_52_3);
                                _jettag_c_setVariable_53_4.setTagInfo(_td_c_setVariable_53_4);
                                _jettag_c_setVariable_53_4.doStart(context, out);
                                _jettag_c_setVariable_53_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_55_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_55_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_55_6.setRuntimeParent(_jettag_c_iterate_52_3);
                                _jettag_c_if_55_6.setTagInfo(_td_c_if_55_6);
                                _jettag_c_if_55_6.doStart(context, out);
                                while (_jettag_c_if_55_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_57_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_57_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_57_12.setRuntimeParent(_jettag_c_if_55_6);
                                    _jettag_c_iterate_57_12.setTagInfo(_td_c_iterate_57_12);
                                    _jettag_c_iterate_57_12.doStart(context, out);
                                    while (_jettag_c_iterate_57_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_58_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_58_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_58_12.setRuntimeParent(_jettag_c_iterate_57_12);
                                        _jettag_c_setVariable_58_12.setTagInfo(_td_c_setVariable_58_12);
                                        _jettag_c_setVariable_58_12.doStart(context, out);
                                        _jettag_c_setVariable_58_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_60_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_60_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_60_13.setRuntimeParent(_jettag_c_iterate_57_12);
                                        _jettag_c_if_60_13.setTagInfo(_td_c_if_60_13);
                                        _jettag_c_if_60_13.doStart(context, out);
                                        while (_jettag_c_if_60_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_62_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_62_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_62_9.setRuntimeParent(_jettag_c_if_60_13);
                                            _jettag_c_if_62_9.setTagInfo(_td_c_if_62_9);
                                            _jettag_c_if_62_9.doStart(context, out);
                                            while (_jettag_c_if_62_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_63_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_63_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_63_11.setRuntimeParent(_jettag_c_if_62_9);
                                                _jettag_c_if_63_11.setTagInfo(_td_c_if_63_11);
                                                _jettag_c_if_63_11.doStart(context, out);
                                                while (_jettag_c_if_63_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_65_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_65_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_65_14.setRuntimeParent(_jettag_c_if_63_11);
                                                    _jettag_c_if_65_14.setTagInfo(_td_c_if_65_14);
                                                    _jettag_c_if_65_14.doStart(context, out);
                                                    while (_jettag_c_if_65_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_67_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_67_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_67_15.setRuntimeParent(_jettag_c_if_65_14);
                                                        _jettag_c_iterate_67_15.setTagInfo(_td_c_iterate_67_15);
                                                        _jettag_c_iterate_67_15.doStart(context, out);
                                                        while (_jettag_c_iterate_67_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_68_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_68_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_68_16.setRuntimeParent(_jettag_c_iterate_67_15);
                                                            _jettag_c_if_68_16.setTagInfo(_td_c_if_68_16);
                                                            _jettag_c_if_68_16.doStart(context, out);
                                                            while (_jettag_c_if_68_16.okToProcessBody()) {
                                                                out.write("import ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 69, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".entity.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 69, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 69, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(";");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_68_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_68_16.doEnd();
                                                            _jettag_c_iterate_67_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_67_15.doEnd();
                                                        _jettag_c_if_65_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_65_14.doEnd();
                                                    _jettag_c_if_63_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_63_11.doEnd();
                                                _jettag_c_if_62_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_62_9.doEnd();
                                            _jettag_c_if_60_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_60_13.doEnd();
                                        _jettag_c_iterate_57_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_57_12.doEnd();
                                    _jettag_c_if_55_6.handleBodyContent(out);
                                }
                                _jettag_c_if_55_6.doEnd();
                                _jettag_c_iterate_52_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_52_3.doEnd();
                            _jettag_c_iterate_51_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_51_2.doEnd();
                        _jettag_c_iterate_50_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_50_6.doEnd();
                    _jettag_c_if_48_1.handleBodyContent(out);
                }
                _jettag_c_if_48_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_82_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_82_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_82_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_82_1.setTagInfo(_td_c_setVariable_82_1);
                _jettag_c_setVariable_82_1.doStart(context, out);
                _jettag_c_setVariable_82_1.doEnd();
                //level 0 
                RuntimeTagElement _jettag_c_iterate_84_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_84_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_84_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_84_1.setTagInfo(_td_c_iterate_84_1);
                _jettag_c_iterate_84_1.doStart(context, out);
                while (_jettag_c_iterate_84_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_85_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_85_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_85_2.setRuntimeParent(_jettag_c_iterate_84_1);
                    _jettag_c_iterate_85_2.setTagInfo(_td_c_iterate_85_2);
                    _jettag_c_iterate_85_2.doStart(context, out);
                    while (_jettag_c_iterate_85_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_86_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_86_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_86_3.setRuntimeParent(_jettag_c_iterate_85_2);
                        _jettag_c_iterate_86_3.setTagInfo(_td_c_iterate_86_3);
                        _jettag_c_iterate_86_3.doStart(context, out);
                        while (_jettag_c_iterate_86_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_87_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_87_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_87_4.setRuntimeParent(_jettag_c_iterate_86_3);
                            _jettag_c_setVariable_87_4.setTagInfo(_td_c_setVariable_87_4);
                            _jettag_c_setVariable_87_4.doStart(context, out);
                            _jettag_c_setVariable_87_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_89_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_89_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_89_6.setRuntimeParent(_jettag_c_iterate_86_3);
                            _jettag_c_if_89_6.setTagInfo(_td_c_if_89_6);
                            _jettag_c_if_89_6.doStart(context, out);
                            while (_jettag_c_if_89_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_91_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_91_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_91_12.setRuntimeParent(_jettag_c_if_89_6);
                                _jettag_c_iterate_91_12.setTagInfo(_td_c_iterate_91_12);
                                _jettag_c_iterate_91_12.doStart(context, out);
                                while (_jettag_c_iterate_91_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_92_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_92_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_92_12.setRuntimeParent(_jettag_c_iterate_91_12);
                                    _jettag_c_setVariable_92_12.setTagInfo(_td_c_setVariable_92_12);
                                    _jettag_c_setVariable_92_12.doStart(context, out);
                                    _jettag_c_setVariable_92_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_94_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_94_13); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_94_13.setRuntimeParent(_jettag_c_iterate_91_12);
                                    _jettag_c_if_94_13.setTagInfo(_td_c_if_94_13);
                                    _jettag_c_if_94_13.doStart(context, out);
                                    while (_jettag_c_if_94_13.okToProcessBody()) {
                                        // process many on target
                                        RuntimeTagElement _jettag_c_if_96_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_96_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_96_9.setRuntimeParent(_jettag_c_if_94_13);
                                        _jettag_c_if_96_9.setTagInfo(_td_c_if_96_9);
                                        _jettag_c_if_96_9.doStart(context, out);
                                        while (_jettag_c_if_96_9.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_97_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_97_11); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_97_11.setRuntimeParent(_jettag_c_if_96_9);
                                            _jettag_c_if_97_11.setTagInfo(_td_c_if_97_11);
                                            _jettag_c_if_97_11.doStart(context, out);
                                            while (_jettag_c_if_97_11.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_99_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_99_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_99_14.setRuntimeParent(_jettag_c_if_97_11);
                                                _jettag_c_if_99_14.setTagInfo(_td_c_if_99_14);
                                                _jettag_c_if_99_14.doStart(context, out);
                                                while (_jettag_c_if_99_14.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_101_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_101_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_101_15.setRuntimeParent(_jettag_c_if_99_14);
                                                    _jettag_c_iterate_101_15.setTagInfo(_td_c_iterate_101_15);
                                                    _jettag_c_iterate_101_15.doStart(context, out);
                                                    while (_jettag_c_iterate_101_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_102_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_102_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_102_16.setRuntimeParent(_jettag_c_iterate_101_15);
                                                        _jettag_c_if_102_16.setTagInfo(_td_c_if_102_16);
                                                        _jettag_c_if_102_16.doStart(context, out);
                                                        while (_jettag_c_if_102_16.okToProcessBody()) {
                                                            out.write("import ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 103, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".entity.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 103, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 103, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_102_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_102_16.doEnd();
                                                        _jettag_c_iterate_101_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_101_15.doEnd();
                                                    _jettag_c_if_99_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_99_14.doEnd();
                                                _jettag_c_if_97_11.handleBodyContent(out);
                                            }
                                            _jettag_c_if_97_11.doEnd();
                                            _jettag_c_if_96_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_96_9.doEnd();
                                        _jettag_c_if_94_13.handleBodyContent(out);
                                    }
                                    _jettag_c_if_94_13.doEnd();
                                    _jettag_c_iterate_91_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_91_12.doEnd();
                                _jettag_c_if_89_6.handleBodyContent(out);
                            }
                            _jettag_c_if_89_6.doEnd();
                            _jettag_c_iterate_86_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_86_3.doEnd();
                        _jettag_c_iterate_85_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_85_2.doEnd();
                    _jettag_c_iterate_84_1.handleBodyContent(out);
                }
                _jettag_c_iterate_84_1.doEnd();
                out.write(NL);         
                // process all addAll relations
                RuntimeTagElement _jettag_c_iterate_117_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_117_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_117_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_117_1.setTagInfo(_td_c_iterate_117_1);
                _jettag_c_iterate_117_1.doStart(context, out);
                while (_jettag_c_iterate_117_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_118_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_118_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_118_2.setRuntimeParent(_jettag_c_iterate_117_1);
                    _jettag_c_iterate_118_2.setTagInfo(_td_c_iterate_118_2);
                    _jettag_c_iterate_118_2.doStart(context, out);
                    while (_jettag_c_iterate_118_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_119_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_119_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_119_3.setRuntimeParent(_jettag_c_iterate_118_2);
                        _jettag_c_iterate_119_3.setTagInfo(_td_c_iterate_119_3);
                        _jettag_c_iterate_119_3.doStart(context, out);
                        while (_jettag_c_iterate_119_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_120_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_120_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_120_4.setRuntimeParent(_jettag_c_iterate_119_3);
                            _jettag_c_setVariable_120_4.setTagInfo(_td_c_setVariable_120_4);
                            _jettag_c_setVariable_120_4.doStart(context, out);
                            _jettag_c_setVariable_120_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_122_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_122_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_122_6.setRuntimeParent(_jettag_c_iterate_119_3);
                            _jettag_c_if_122_6.setTagInfo(_td_c_if_122_6);
                            _jettag_c_if_122_6.doStart(context, out);
                            while (_jettag_c_if_122_6.okToProcessBody()) {
                                // process only classes with many on source side
                                RuntimeTagElement _jettag_c_if_124_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_124_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_124_6.setRuntimeParent(_jettag_c_if_122_6);
                                _jettag_c_if_124_6.setTagInfo(_td_c_if_124_6);
                                _jettag_c_if_124_6.doStart(context, out);
                                while (_jettag_c_if_124_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_125_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_125_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_125_8.setRuntimeParent(_jettag_c_if_124_6);
                                    _jettag_c_if_125_8.setTagInfo(_td_c_if_125_8);
                                    _jettag_c_if_125_8.doStart(context, out);
                                    while (_jettag_c_if_125_8.okToProcessBody()) {
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_127_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_127_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_127_12.setRuntimeParent(_jettag_c_if_125_8);
                                        _jettag_c_iterate_127_12.setTagInfo(_td_c_iterate_127_12);
                                        _jettag_c_iterate_127_12.doStart(context, out);
                                        while (_jettag_c_iterate_127_12.okToProcessBody()) {
                                            // process only non composites 
                                            RuntimeTagElement _jettag_c_if_129_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_129_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_129_12.setRuntimeParent(_jettag_c_iterate_127_12);
                                            _jettag_c_if_129_12.setTagInfo(_td_c_if_129_12);
                                            _jettag_c_if_129_12.doStart(context, out);
                                            while (_jettag_c_if_129_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_130_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_130_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_130_12.setRuntimeParent(_jettag_c_if_129_12);
                                                _jettag_c_setVariable_130_12.setTagInfo(_td_c_setVariable_130_12);
                                                _jettag_c_setVariable_130_12.doStart(context, out);
                                                _jettag_c_setVariable_130_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_132_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_132_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_132_14.setRuntimeParent(_jettag_c_if_129_12);
                                                _jettag_c_if_132_14.setTagInfo(_td_c_if_132_14);
                                                _jettag_c_if_132_14.doStart(context, out);
                                                while (_jettag_c_if_132_14.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_134_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_134_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_134_14.setRuntimeParent(_jettag_c_if_132_14);
                                                    _jettag_c_if_134_14.setTagInfo(_td_c_if_134_14);
                                                    _jettag_c_if_134_14.doStart(context, out);
                                                    while (_jettag_c_if_134_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_136_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_136_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_136_15.setRuntimeParent(_jettag_c_if_134_14);
                                                        _jettag_c_iterate_136_15.setTagInfo(_td_c_iterate_136_15);
                                                        _jettag_c_iterate_136_15.doStart(context, out);
                                                        while (_jettag_c_iterate_136_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_137_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_137_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_137_16.setRuntimeParent(_jettag_c_iterate_136_15);
                                                            _jettag_c_if_137_16.setTagInfo(_td_c_if_137_16);
                                                            _jettag_c_if_137_16.doStart(context, out);
                                                            while (_jettag_c_if_137_16.okToProcessBody()) {
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 138, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".entity.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 138, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 138, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(";");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_137_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_137_16.doEnd();
                                                            _jettag_c_iterate_136_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_136_15.doEnd();
                                                        _jettag_c_if_134_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_134_14.doEnd();
                                                    _jettag_c_if_132_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_132_14.doEnd();
                                                _jettag_c_if_129_12.handleBodyContent(out);
                                            }
                                            _jettag_c_if_129_12.doEnd();
                                            _jettag_c_iterate_127_12.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_127_12.doEnd();
                                        _jettag_c_if_125_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_125_8.doEnd();
                                    _jettag_c_if_124_6.handleBodyContent(out);
                                }
                                _jettag_c_if_124_6.doEnd();
                                _jettag_c_if_122_6.handleBodyContent(out);
                            }
                            _jettag_c_if_122_6.doEnd();
                            _jettag_c_iterate_119_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_119_3.doEnd();
                        _jettag_c_iterate_118_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_118_2.doEnd();
                    _jettag_c_iterate_117_1.handleBodyContent(out);
                }
                _jettag_c_iterate_117_1.doEnd();
                out.write(NL);         
                // process all merge relations
                RuntimeTagElement _jettag_c_iterate_153_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_153_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_153_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_153_1.setTagInfo(_td_c_iterate_153_1);
                _jettag_c_iterate_153_1.doStart(context, out);
                while (_jettag_c_iterate_153_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_154_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_154_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_154_2.setRuntimeParent(_jettag_c_iterate_153_1);
                    _jettag_c_iterate_154_2.setTagInfo(_td_c_iterate_154_2);
                    _jettag_c_iterate_154_2.doStart(context, out);
                    while (_jettag_c_iterate_154_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_155_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_155_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_155_3.setRuntimeParent(_jettag_c_iterate_154_2);
                        _jettag_c_iterate_155_3.setTagInfo(_td_c_iterate_155_3);
                        _jettag_c_iterate_155_3.doStart(context, out);
                        while (_jettag_c_iterate_155_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_156_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_156_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_156_4.setRuntimeParent(_jettag_c_iterate_155_3);
                            _jettag_c_setVariable_156_4.setTagInfo(_td_c_setVariable_156_4);
                            _jettag_c_setVariable_156_4.doStart(context, out);
                            _jettag_c_setVariable_156_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_158_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_158_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_158_6.setRuntimeParent(_jettag_c_iterate_155_3);
                            _jettag_c_if_158_6.setTagInfo(_td_c_if_158_6);
                            _jettag_c_if_158_6.doStart(context, out);
                            while (_jettag_c_if_158_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_160_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_160_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_160_12.setRuntimeParent(_jettag_c_if_158_6);
                                _jettag_c_iterate_160_12.setTagInfo(_td_c_iterate_160_12);
                                _jettag_c_iterate_160_12.doStart(context, out);
                                while (_jettag_c_iterate_160_12.okToProcessBody()) {
                                    // process only  composites on target
                                    RuntimeTagElement _jettag_c_if_162_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_162_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_162_12.setRuntimeParent(_jettag_c_iterate_160_12);
                                    _jettag_c_if_162_12.setTagInfo(_td_c_if_162_12);
                                    _jettag_c_if_162_12.doStart(context, out);
                                    while (_jettag_c_if_162_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_163_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_163_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_163_12.setRuntimeParent(_jettag_c_if_162_12);
                                        _jettag_c_setVariable_163_12.setTagInfo(_td_c_setVariable_163_12);
                                        _jettag_c_setVariable_163_12.doStart(context, out);
                                        _jettag_c_setVariable_163_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_165_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_165_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_165_14.setRuntimeParent(_jettag_c_if_162_12);
                                        _jettag_c_if_165_14.setTagInfo(_td_c_if_165_14);
                                        _jettag_c_if_165_14.doStart(context, out);
                                        while (_jettag_c_if_165_14.okToProcessBody()) {
                                            // iterate throught all the classes to get the other class on the association
                                            RuntimeTagElement _jettag_c_iterate_167_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_167_15); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_167_15.setRuntimeParent(_jettag_c_if_165_14);
                                            _jettag_c_iterate_167_15.setTagInfo(_td_c_iterate_167_15);
                                            _jettag_c_iterate_167_15.doStart(context, out);
                                            while (_jettag_c_iterate_167_15.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_168_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_168_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_168_16.setRuntimeParent(_jettag_c_iterate_167_15);
                                                _jettag_c_if_168_16.setTagInfo(_td_c_if_168_16);
                                                _jettag_c_if_168_16.doStart(context, out);
                                                while (_jettag_c_if_168_16.okToProcessBody()) {
                                                    out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 169, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".entity.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 169, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 169, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    RuntimeTagElement _jettag_c_if_170_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_170_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_170_12.setRuntimeParent(_jettag_c_if_168_16);
                                                    _jettag_c_if_170_12.setTagInfo(_td_c_if_170_12);
                                                    _jettag_c_if_170_12.doStart(context, out);
                                                    while (_jettag_c_if_170_12.okToProcessBody()) {
                                                        out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 171, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entity.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 171, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@parentClass1Name}", 171, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_170_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_170_12.doEnd();
                                                    RuntimeTagElement _jettag_c_if_173_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_173_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_173_12.setRuntimeParent(_jettag_c_if_168_16);
                                                    _jettag_c_if_173_12.setTagInfo(_td_c_if_173_12);
                                                    _jettag_c_if_173_12.doStart(context, out);
                                                    while (_jettag_c_if_173_12.okToProcessBody()) {
                                                        out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 174, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entity.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 174, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@parentClass2Name}", 174, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_173_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_173_12.doEnd();
                                                    _jettag_c_if_168_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_168_16.doEnd();
                                                _jettag_c_iterate_167_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_167_15.doEnd();
                                            _jettag_c_if_165_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_165_14.doEnd();
                                        _jettag_c_if_162_12.handleBodyContent(out);
                                    }
                                    _jettag_c_if_162_12.doEnd();
                                    _jettag_c_iterate_160_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_160_12.doEnd();
                                _jettag_c_if_158_6.handleBodyContent(out);
                            }
                            _jettag_c_if_158_6.doEnd();
                            _jettag_c_iterate_155_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_155_3.doEnd();
                        _jettag_c_iterate_154_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_154_2.doEnd();
                    _jettag_c_iterate_153_1.handleBodyContent(out);
                }
                _jettag_c_iterate_153_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_c_setVariable_186_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_186_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_186_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_186_1.setTagInfo(_td_c_setVariable_186_1);
                _jettag_c_setVariable_186_1.doStart(context, out);
                _jettag_c_setVariable_186_1.doEnd();
                out.write("import info.yalamanchili.gwt.beans.TableObj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.beans.MultiSelectObjy;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 189, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 189, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 189, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import java.io.Serializable;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Map;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import com.google.gwt.core.client.GWT;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.rpc.RemoteService;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.rpc.ServiceDefTarget;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("/**");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" * This is a GWT service, which will be implemented as a Seam component on the");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" * server (see the server package). GWT uses strongly typed RPC interfaces.");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" */");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_203_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_203_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_203_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_203_2.setTagInfo(_td_f_message_203_2);
                _jettag_f_message_203_2.doStart(context, out);
                JET2Writer _jettag_f_message_203_2_saved_out = out;
                while (_jettag_f_message_203_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_203_2.handleBodyContent(out);
                }
                out = _jettag_f_message_203_2_saved_out;
                _jettag_f_message_203_2.doEnd();
                out.write(NL);         
                out.write("public interface ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 204, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service extends RemoteService {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_205_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_205_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_205_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_205_1.setTagInfo(_td_f_message_205_1);
                _jettag_f_message_205_1.doStart(context, out);
                JET2Writer _jettag_f_message_205_1_saved_out = out;
                while (_jettag_f_message_205_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_205_1.handleBodyContent(out);
                }
                out = _jettag_f_message_205_1_saved_out;
                _jettag_f_message_205_1.doEnd();
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 206, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" create(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 206, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity);");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_207_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_207_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_207_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_207_1.setTagInfo(_td_f_message_207_1);
                _jettag_f_message_207_1.doStart(context, out);
                JET2Writer _jettag_f_message_207_1_saved_out = out;
                while (_jettag_f_message_207_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_207_1.handleBodyContent(out);
                }
                out = _jettag_f_message_207_1_saved_out;
                _jettag_f_message_207_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic  ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 208, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" read( Long id);");  //$NON-NLS-1$        
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
                out.write("\tpublic  ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 210, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" update(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 210, 33)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity);");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_211_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_211_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_211_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_211_1.setTagInfo(_td_f_message_211_1);
                _jettag_f_message_211_1.doStart(context, out);
                JET2Writer _jettag_f_message_211_1_saved_out = out;
                while (_jettag_f_message_211_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_211_1.handleBodyContent(out);
                }
                out = _jettag_f_message_211_1_saved_out;
                _jettag_f_message_211_1.doEnd();
                out.write(NL);         
                out.write("\tpublic  void delete(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 212, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity);");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_213_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_213_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_213_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_213_1.setTagInfo(_td_f_message_213_1);
                _jettag_f_message_213_1.doStart(context, out);
                JET2Writer _jettag_f_message_213_1_saved_out = out;
                while (_jettag_f_message_213_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_213_1.handleBodyContent(out);
                }
                out = _jettag_f_message_213_1_saved_out;
                _jettag_f_message_213_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic TableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 214, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> getTableObj(int start);");  //$NON-NLS-1$        
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
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\tpublic  List<String> getSuggestionsForName(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tString name, ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 218, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity);");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_219_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_219_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_219_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_219_1.setTagInfo(_td_f_message_219_1);
                _jettag_f_message_219_1.doStart(context, out);
                JET2Writer _jettag_f_message_219_1_saved_out = out;
                while (_jettag_f_message_219_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_219_1.handleBodyContent(out);
                }
                out = _jettag_f_message_219_1_saved_out;
                _jettag_f_message_219_1.doEnd();
                out.write(NL);         
                out.write("\tpublic List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 220, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> getEntities(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 220, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity);");  //$NON-NLS-1$        
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
                out.write("\tpublic Map<Long, String> getListBoxValues(String[] columns);");  //$NON-NLS-1$        
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
                    out.write("\tpublic List<");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 226, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("> search(String searchText);");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_224_1.handleBodyContent(out);
                }
                _jettag_c_if_224_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t//TODO need to review which of these are actually needed");  //$NON-NLS-1$        
                out.write(NL);         
                // process all getRelated entities relations
                //process level2 generizations 
                RuntimeTagElement _jettag_c_if_232_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_232_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_232_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_232_1.setTagInfo(_td_c_if_232_1);
                _jettag_c_if_232_1.doStart(context, out);
                while (_jettag_c_if_232_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_233_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_233_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_233_6.setRuntimeParent(_jettag_c_if_232_1);
                    _jettag_c_setVariable_233_6.setTagInfo(_td_c_setVariable_233_6);
                    _jettag_c_setVariable_233_6.doStart(context, out);
                    _jettag_c_setVariable_233_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_234_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_234_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_234_6.setRuntimeParent(_jettag_c_if_232_1);
                    _jettag_c_iterate_234_6.setTagInfo(_td_c_iterate_234_6);
                    _jettag_c_iterate_234_6.doStart(context, out);
                    while (_jettag_c_iterate_234_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_235_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_235_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_235_2.setRuntimeParent(_jettag_c_iterate_234_6);
                        _jettag_c_iterate_235_2.setTagInfo(_td_c_iterate_235_2);
                        _jettag_c_iterate_235_2.doStart(context, out);
                        while (_jettag_c_iterate_235_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_236_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_236_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_236_3.setRuntimeParent(_jettag_c_iterate_235_2);
                            _jettag_c_iterate_236_3.setTagInfo(_td_c_iterate_236_3);
                            _jettag_c_iterate_236_3.doStart(context, out);
                            while (_jettag_c_iterate_236_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_237_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_237_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_237_4.setRuntimeParent(_jettag_c_iterate_236_3);
                                _jettag_c_setVariable_237_4.setTagInfo(_td_c_setVariable_237_4);
                                _jettag_c_setVariable_237_4.doStart(context, out);
                                _jettag_c_setVariable_237_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_239_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_239_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_239_6.setRuntimeParent(_jettag_c_iterate_236_3);
                                _jettag_c_if_239_6.setTagInfo(_td_c_if_239_6);
                                _jettag_c_if_239_6.doStart(context, out);
                                while (_jettag_c_if_239_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_241_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_241_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_241_12.setRuntimeParent(_jettag_c_if_239_6);
                                    _jettag_c_iterate_241_12.setTagInfo(_td_c_iterate_241_12);
                                    _jettag_c_iterate_241_12.doStart(context, out);
                                    while (_jettag_c_iterate_241_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_242_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_242_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_242_12.setRuntimeParent(_jettag_c_iterate_241_12);
                                        _jettag_c_setVariable_242_12.setTagInfo(_td_c_setVariable_242_12);
                                        _jettag_c_setVariable_242_12.doStart(context, out);
                                        _jettag_c_setVariable_242_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_244_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_244_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_244_13.setRuntimeParent(_jettag_c_iterate_241_12);
                                        _jettag_c_if_244_13.setTagInfo(_td_c_if_244_13);
                                        _jettag_c_if_244_13.doStart(context, out);
                                        while (_jettag_c_if_244_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_246_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_246_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_246_9.setRuntimeParent(_jettag_c_if_244_13);
                                            _jettag_c_if_246_9.setTagInfo(_td_c_if_246_9);
                                            _jettag_c_if_246_9.doStart(context, out);
                                            while (_jettag_c_if_246_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_247_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_247_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_247_11.setRuntimeParent(_jettag_c_if_246_9);
                                                _jettag_c_if_247_11.setTagInfo(_td_c_if_247_11);
                                                _jettag_c_if_247_11.doStart(context, out);
                                                while (_jettag_c_if_247_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_249_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_249_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_249_14.setRuntimeParent(_jettag_c_if_247_11);
                                                    _jettag_c_if_249_14.setTagInfo(_td_c_if_249_14);
                                                    _jettag_c_if_249_14.doStart(context, out);
                                                    while (_jettag_c_if_249_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_251_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_251_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_251_15.setRuntimeParent(_jettag_c_if_249_14);
                                                        _jettag_c_iterate_251_15.setTagInfo(_td_c_iterate_251_15);
                                                        _jettag_c_iterate_251_15.doStart(context, out);
                                                        while (_jettag_c_iterate_251_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_252_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_252_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_252_16.setRuntimeParent(_jettag_c_iterate_251_15);
                                                            _jettag_c_if_252_16.setTagInfo(_td_c_if_252_16);
                                                            _jettag_c_if_252_16.doStart(context, out);
                                                            while (_jettag_c_if_252_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_253_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_253_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_253_1.setRuntimeParent(_jettag_c_if_252_16);
                                                                _jettag_f_message_253_1.setTagInfo(_td_f_message_253_1);
                                                                _jettag_f_message_253_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_253_1_saved_out = out;
                                                                while (_jettag_f_message_253_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_253_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_253_1_saved_out;
                                                                _jettag_f_message_253_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("public  List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 254, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("> get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 254, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long entityID);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                // check to see if the parent side is aggregation or none
                                                                RuntimeTagElement _jettag_c_if_256_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_256_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_256_17.setRuntimeParent(_jettag_c_if_252_16);
                                                                _jettag_c_if_256_17.setTagInfo(_td_c_if_256_17);
                                                                _jettag_c_if_256_17.doStart(context, out);
                                                                while (_jettag_c_if_256_17.okToProcessBody()) {
                                                                    RuntimeTagElement _jettag_f_message_257_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_257_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_257_1.setRuntimeParent(_jettag_c_if_256_17);
                                                                    _jettag_f_message_257_1.setTagInfo(_td_f_message_257_1);
                                                                    _jettag_f_message_257_1.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_257_1_saved_out = out;
                                                                    while (_jettag_f_message_257_1.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_257_1.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_257_1_saved_out;
                                                                    _jettag_f_message_257_1.doEnd();
                                                                    out.write("\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\tpublic MultiSelectObjy get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 258, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sMultiSelect(Long entityID, String[] columns);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_256_17.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_256_17.doEnd();
                                                                _jettag_c_if_252_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_252_16.doEnd();
                                                            _jettag_c_iterate_251_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_251_15.doEnd();
                                                        _jettag_c_if_249_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_249_14.doEnd();
                                                    _jettag_c_if_247_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_247_11.doEnd();
                                                _jettag_c_if_246_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_246_9.doEnd();
                                            _jettag_c_if_244_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_244_13.doEnd();
                                        _jettag_c_iterate_241_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_241_12.doEnd();
                                    _jettag_c_if_239_6.handleBodyContent(out);
                                }
                                _jettag_c_if_239_6.doEnd();
                                _jettag_c_iterate_236_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_236_3.doEnd();
                            _jettag_c_iterate_235_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_235_2.doEnd();
                        _jettag_c_iterate_234_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_234_6.doEnd();
                    _jettag_c_if_232_1.handleBodyContent(out);
                }
                _jettag_c_if_232_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_272_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_272_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_272_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_272_1.setTagInfo(_td_c_setVariable_272_1);
                _jettag_c_setVariable_272_1.doStart(context, out);
                _jettag_c_setVariable_272_1.doEnd();
                //process level 1 generizations 
                RuntimeTagElement _jettag_c_if_274_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_274_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_274_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_274_1.setTagInfo(_td_c_if_274_1);
                _jettag_c_if_274_1.doStart(context, out);
                while (_jettag_c_if_274_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_275_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_275_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_275_6.setRuntimeParent(_jettag_c_if_274_1);
                    _jettag_c_setVariable_275_6.setTagInfo(_td_c_setVariable_275_6);
                    _jettag_c_setVariable_275_6.doStart(context, out);
                    _jettag_c_setVariable_275_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_276_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_276_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_276_6.setRuntimeParent(_jettag_c_if_274_1);
                    _jettag_c_iterate_276_6.setTagInfo(_td_c_iterate_276_6);
                    _jettag_c_iterate_276_6.doStart(context, out);
                    while (_jettag_c_iterate_276_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_277_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_277_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_277_2.setRuntimeParent(_jettag_c_iterate_276_6);
                        _jettag_c_iterate_277_2.setTagInfo(_td_c_iterate_277_2);
                        _jettag_c_iterate_277_2.doStart(context, out);
                        while (_jettag_c_iterate_277_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_278_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_278_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_278_3.setRuntimeParent(_jettag_c_iterate_277_2);
                            _jettag_c_iterate_278_3.setTagInfo(_td_c_iterate_278_3);
                            _jettag_c_iterate_278_3.doStart(context, out);
                            while (_jettag_c_iterate_278_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_279_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_279_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_279_4.setRuntimeParent(_jettag_c_iterate_278_3);
                                _jettag_c_setVariable_279_4.setTagInfo(_td_c_setVariable_279_4);
                                _jettag_c_setVariable_279_4.doStart(context, out);
                                _jettag_c_setVariable_279_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_281_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_281_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_281_6.setRuntimeParent(_jettag_c_iterate_278_3);
                                _jettag_c_if_281_6.setTagInfo(_td_c_if_281_6);
                                _jettag_c_if_281_6.doStart(context, out);
                                while (_jettag_c_if_281_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_283_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_283_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_283_12.setRuntimeParent(_jettag_c_if_281_6);
                                    _jettag_c_iterate_283_12.setTagInfo(_td_c_iterate_283_12);
                                    _jettag_c_iterate_283_12.doStart(context, out);
                                    while (_jettag_c_iterate_283_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_284_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_284_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_284_12.setRuntimeParent(_jettag_c_iterate_283_12);
                                        _jettag_c_setVariable_284_12.setTagInfo(_td_c_setVariable_284_12);
                                        _jettag_c_setVariable_284_12.doStart(context, out);
                                        _jettag_c_setVariable_284_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_286_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_286_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_286_13.setRuntimeParent(_jettag_c_iterate_283_12);
                                        _jettag_c_if_286_13.setTagInfo(_td_c_if_286_13);
                                        _jettag_c_if_286_13.doStart(context, out);
                                        while (_jettag_c_if_286_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_288_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_288_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_288_9.setRuntimeParent(_jettag_c_if_286_13);
                                            _jettag_c_if_288_9.setTagInfo(_td_c_if_288_9);
                                            _jettag_c_if_288_9.doStart(context, out);
                                            while (_jettag_c_if_288_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_289_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_289_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_289_11.setRuntimeParent(_jettag_c_if_288_9);
                                                _jettag_c_if_289_11.setTagInfo(_td_c_if_289_11);
                                                _jettag_c_if_289_11.doStart(context, out);
                                                while (_jettag_c_if_289_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_291_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_291_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_291_14.setRuntimeParent(_jettag_c_if_289_11);
                                                    _jettag_c_if_291_14.setTagInfo(_td_c_if_291_14);
                                                    _jettag_c_if_291_14.doStart(context, out);
                                                    while (_jettag_c_if_291_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_293_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_293_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_293_15.setRuntimeParent(_jettag_c_if_291_14);
                                                        _jettag_c_iterate_293_15.setTagInfo(_td_c_iterate_293_15);
                                                        _jettag_c_iterate_293_15.doStart(context, out);
                                                        while (_jettag_c_iterate_293_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_294_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_294_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_294_16.setRuntimeParent(_jettag_c_iterate_293_15);
                                                            _jettag_c_if_294_16.setTagInfo(_td_c_if_294_16);
                                                            _jettag_c_if_294_16.doStart(context, out);
                                                            while (_jettag_c_if_294_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_295_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_295_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_295_1.setRuntimeParent(_jettag_c_if_294_16);
                                                                _jettag_f_message_295_1.setTagInfo(_td_f_message_295_1);
                                                                _jettag_f_message_295_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_295_1_saved_out = out;
                                                                while (_jettag_f_message_295_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_295_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_295_1_saved_out;
                                                                _jettag_f_message_295_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("public  List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 296, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("> get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 296, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long entityID);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                // check to see if the parent side is aggregation or none
                                                                RuntimeTagElement _jettag_c_if_298_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_298_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_298_17.setRuntimeParent(_jettag_c_if_294_16);
                                                                _jettag_c_if_298_17.setTagInfo(_td_c_if_298_17);
                                                                _jettag_c_if_298_17.doStart(context, out);
                                                                while (_jettag_c_if_298_17.okToProcessBody()) {
                                                                    RuntimeTagElement _jettag_f_message_299_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_299_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_299_1.setRuntimeParent(_jettag_c_if_298_17);
                                                                    _jettag_f_message_299_1.setTagInfo(_td_f_message_299_1);
                                                                    _jettag_f_message_299_1.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_299_1_saved_out = out;
                                                                    while (_jettag_f_message_299_1.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_299_1.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_299_1_saved_out;
                                                                    _jettag_f_message_299_1.doEnd();
                                                                    out.write("\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\tpublic MultiSelectObjy get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 300, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sMultiSelect(Long entityID, String[] columns);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_298_17.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_298_17.doEnd();
                                                                _jettag_c_if_294_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_294_16.doEnd();
                                                            _jettag_c_iterate_293_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_293_15.doEnd();
                                                        _jettag_c_if_291_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_291_14.doEnd();
                                                    _jettag_c_if_289_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_289_11.doEnd();
                                                _jettag_c_if_288_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_288_9.doEnd();
                                            _jettag_c_if_286_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_286_13.doEnd();
                                        _jettag_c_iterate_283_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_283_12.doEnd();
                                    _jettag_c_if_281_6.handleBodyContent(out);
                                }
                                _jettag_c_if_281_6.doEnd();
                                _jettag_c_iterate_278_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_278_3.doEnd();
                            _jettag_c_iterate_277_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_277_2.doEnd();
                        _jettag_c_iterate_276_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_276_6.doEnd();
                    _jettag_c_if_274_1.handleBodyContent(out);
                }
                _jettag_c_if_274_1.doEnd();
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
                                                            out.write("public  List<");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 336, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("> get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 336, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s(Long entityID);");  //$NON-NLS-1$        
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
                                                                out.write("\tpublic MultiSelectObjy get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 340, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sMultiSelect(Long entityID, String[] columns);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_338_17.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_338_17.doEnd();
                                                            _jettag_c_if_334_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_334_16.doEnd();
                                                        out.write(" \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
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
                out.write("\t");  //$NON-NLS-1$        
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
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\tpublic void add");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 378, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 378, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 378, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Id,List<Long> ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 378, 111)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s);");  //$NON-NLS-1$        
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
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\tpublic void remove");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 415, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 415, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 415, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Id,List<Long> ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 415, 114)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s);");  //$NON-NLS-1$        
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
                out.write(NL);         
                // process all merge relations
                RuntimeTagElement _jettag_c_iterate_430_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_430_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_430_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_430_1.setTagInfo(_td_c_iterate_430_1);
                _jettag_c_iterate_430_1.doStart(context, out);
                while (_jettag_c_iterate_430_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_431_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_431_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_431_2.setRuntimeParent(_jettag_c_iterate_430_1);
                    _jettag_c_iterate_431_2.setTagInfo(_td_c_iterate_431_2);
                    _jettag_c_iterate_431_2.doStart(context, out);
                    while (_jettag_c_iterate_431_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_432_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_432_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_432_3.setRuntimeParent(_jettag_c_iterate_431_2);
                        _jettag_c_iterate_432_3.setTagInfo(_td_c_iterate_432_3);
                        _jettag_c_iterate_432_3.doStart(context, out);
                        while (_jettag_c_iterate_432_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_433_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_433_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_433_4.setRuntimeParent(_jettag_c_iterate_432_3);
                            _jettag_c_setVariable_433_4.setTagInfo(_td_c_setVariable_433_4);
                            _jettag_c_setVariable_433_4.doStart(context, out);
                            _jettag_c_setVariable_433_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_435_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_435_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_435_6.setRuntimeParent(_jettag_c_iterate_432_3);
                            _jettag_c_if_435_6.setTagInfo(_td_c_if_435_6);
                            _jettag_c_if_435_6.doStart(context, out);
                            while (_jettag_c_if_435_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_437_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_437_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_437_12.setRuntimeParent(_jettag_c_if_435_6);
                                _jettag_c_iterate_437_12.setTagInfo(_td_c_iterate_437_12);
                                _jettag_c_iterate_437_12.doStart(context, out);
                                while (_jettag_c_iterate_437_12.okToProcessBody()) {
                                    // process only  composites on target
                                    RuntimeTagElement _jettag_c_if_439_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_439_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_439_12.setRuntimeParent(_jettag_c_iterate_437_12);
                                    _jettag_c_if_439_12.setTagInfo(_td_c_if_439_12);
                                    _jettag_c_if_439_12.doStart(context, out);
                                    while (_jettag_c_if_439_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_440_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_440_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_440_12.setRuntimeParent(_jettag_c_if_439_12);
                                        _jettag_c_setVariable_440_12.setTagInfo(_td_c_setVariable_440_12);
                                        _jettag_c_setVariable_440_12.doStart(context, out);
                                        _jettag_c_setVariable_440_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_442_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_442_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_442_14.setRuntimeParent(_jettag_c_if_439_12);
                                        _jettag_c_if_442_14.setTagInfo(_td_c_if_442_14);
                                        _jettag_c_if_442_14.doStart(context, out);
                                        while (_jettag_c_if_442_14.okToProcessBody()) {
                                            // iterate throught all the classes to get the other class on the association
                                            RuntimeTagElement _jettag_c_iterate_444_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_444_15); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_444_15.setRuntimeParent(_jettag_c_if_442_14);
                                            _jettag_c_iterate_444_15.setTagInfo(_td_c_iterate_444_15);
                                            _jettag_c_iterate_444_15.doStart(context, out);
                                            while (_jettag_c_iterate_444_15.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_445_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_445_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_445_16.setRuntimeParent(_jettag_c_iterate_444_15);
                                                _jettag_c_if_445_16.setTagInfo(_td_c_if_445_16);
                                                _jettag_c_if_445_16.doStart(context, out);
                                                while (_jettag_c_if_445_16.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_f_message_446_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_446_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_f_message_446_1.setRuntimeParent(_jettag_c_if_445_16);
                                                    _jettag_f_message_446_1.setTagInfo(_td_f_message_446_1);
                                                    _jettag_f_message_446_1.doStart(context, out);
                                                    JET2Writer _jettag_f_message_446_1_saved_out = out;
                                                    while (_jettag_f_message_446_1.okToProcessBody()) {
                                                        out = out.newNestedContentWriter();
                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                        _jettag_f_message_446_1.handleBodyContent(out);
                                                    }
                                                    out = _jettag_f_message_446_1_saved_out;
                                                    _jettag_f_message_446_1.doEnd();
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write(" \t\t\t\t\t\t\t\t\t\tpublic void merge(");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 447, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(" entity, ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 447, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(" child);");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_445_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_445_16.doEnd();
                                                _jettag_c_iterate_444_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_444_15.doEnd();
                                            _jettag_c_if_442_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_442_14.doEnd();
                                        _jettag_c_if_439_12.handleBodyContent(out);
                                    }
                                    _jettag_c_if_439_12.doEnd();
                                    _jettag_c_iterate_437_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_437_12.doEnd();
                                _jettag_c_if_435_6.handleBodyContent(out);
                            }
                            _jettag_c_if_435_6.doEnd();
                            _jettag_c_iterate_432_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_432_3.doEnd();
                        _jettag_c_iterate_431_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_431_2.doEnd();
                    _jettag_c_iterate_430_1.handleBodyContent(out);
                }
                _jettag_c_iterate_430_1.doEnd();
                RuntimeTagElement _jettag_f_message_457_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_457_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_457_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_457_1.setTagInfo(_td_f_message_457_1);
                _jettag_f_message_457_1.doStart(context, out);
                JET2Writer _jettag_f_message_457_1_saved_out = out;
                while (_jettag_f_message_457_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_457_1.handleBodyContent(out);
                }
                out = _jettag_f_message_457_1_saved_out;
                _jettag_f_message_457_1.doEnd();
                out.write(NL);         
                out.write("\tpublic static class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 458, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tprivate static ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 459, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 459, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 459, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync service;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t\tpublic static synchronized ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 461, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 461, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 461, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync instance() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tif (service == null) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tservice = (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 463, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 463, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 463, 60)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync) GWT");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t.create(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 464, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service.class);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tServiceDefTarget endpoint = (ServiceDefTarget) service;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tString moduleRelativeURL = GWT.getModuleBaseURL()");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t+ \"seam/resource/gwt2\";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tendpoint.setServiceEntryPoint(moduleRelativeURL);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\treturn service;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
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
    }
}
