package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_gwt_daojava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_entity_gwt_daojava() {
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
    private static final TagInfo _td_c_if_9_1 = new TagInfo("c:if", //$NON-NLS-1$
            9, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_10_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            10, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_11_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            11, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_12_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            12, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_13_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            13, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_14_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            14, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_16_6 = new TagInfo("c:if", //$NON-NLS-1$
            16, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_18_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            18, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_19_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            19, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_21_13 = new TagInfo("c:if", //$NON-NLS-1$
            21, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_23_9 = new TagInfo("c:if", //$NON-NLS-1$
            23, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_24_11 = new TagInfo("c:if", //$NON-NLS-1$
            24, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_26_14 = new TagInfo("c:if", //$NON-NLS-1$
            26, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_28_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            28, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_29_16 = new TagInfo("c:if", //$NON-NLS-1$
            29, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_43_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            43, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_45_1 = new TagInfo("c:if", //$NON-NLS-1$
            45, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_46_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            46, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_47_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            47, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_48_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            48, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_49_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            49, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_50_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            50, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_52_6 = new TagInfo("c:if", //$NON-NLS-1$
            52, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_54_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            54, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_55_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            55, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_57_13 = new TagInfo("c:if", //$NON-NLS-1$
            57, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_59_9 = new TagInfo("c:if", //$NON-NLS-1$
            59, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_60_11 = new TagInfo("c:if", //$NON-NLS-1$
            60, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_62_14 = new TagInfo("c:if", //$NON-NLS-1$
            62, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_64_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            64, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_65_16 = new TagInfo("c:if", //$NON-NLS-1$
            65, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_79_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            79, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_81_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            81, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_82_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            82, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_83_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            83, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_84_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            84, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_86_6 = new TagInfo("c:if", //$NON-NLS-1$
            86, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_88_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            88, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_89_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            89, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_91_13 = new TagInfo("c:if", //$NON-NLS-1$
            91, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_93_9 = new TagInfo("c:if", //$NON-NLS-1$
            93, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_94_11 = new TagInfo("c:if", //$NON-NLS-1$
            94, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_96_14 = new TagInfo("c:if", //$NON-NLS-1$
            96, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_98_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            98, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_99_16 = new TagInfo("c:if", //$NON-NLS-1$
            99, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_114_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            114, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_115_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            115, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_116_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            116, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_117_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            117, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_119_6 = new TagInfo("c:if", //$NON-NLS-1$
            119, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_121_6 = new TagInfo("c:if", //$NON-NLS-1$
            121, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_122_8 = new TagInfo("c:if", //$NON-NLS-1$
            122, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_124_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            124, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_126_12 = new TagInfo("c:if", //$NON-NLS-1$
            126, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_127_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            127, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_129_14 = new TagInfo("c:if", //$NON-NLS-1$
            129, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_131_14 = new TagInfo("c:if", //$NON-NLS-1$
            131, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_133_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            133, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_134_16 = new TagInfo("c:if", //$NON-NLS-1$
            134, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_150_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            150, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_151_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            151, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_152_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            152, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_153_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            153, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_155_6 = new TagInfo("c:if", //$NON-NLS-1$
            155, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_157_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            157, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_159_12 = new TagInfo("c:if", //$NON-NLS-1$
            159, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_160_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            160, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_162_14 = new TagInfo("c:if", //$NON-NLS-1$
            162, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_164_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            164, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_165_16 = new TagInfo("c:if", //$NON-NLS-1$
            165, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_167_12 = new TagInfo("c:if", //$NON-NLS-1$
            167, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@parent1 = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_170_12 = new TagInfo("c:if", //$NON-NLS-1$
            170, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@parent2 = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_200_1 = new TagInfo("c:if", //$NON-NLS-1$
            200, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_215_1 = new TagInfo("f:message", //$NON-NLS-1$
            215, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_305_1 = new TagInfo("c:if", //$NON-NLS-1$
            305, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_306_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            306, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_307_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            307, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_308_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            308, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_309_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            309, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_310_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            310, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_312_6 = new TagInfo("c:if", //$NON-NLS-1$
            312, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_314_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            314, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_315_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            315, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_317_13 = new TagInfo("c:if", //$NON-NLS-1$
            317, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_319_9 = new TagInfo("c:if", //$NON-NLS-1$
            319, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_320_11 = new TagInfo("c:if", //$NON-NLS-1$
            320, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_322_14 = new TagInfo("c:if", //$NON-NLS-1$
            322, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_324_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            324, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_325_16 = new TagInfo("c:if", //$NON-NLS-1$
            325, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_326_1 = new TagInfo("f:message", //$NON-NLS-1$
            326, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_332_17 = new TagInfo("c:if", //$NON-NLS-1$
            332, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_333_1 = new TagInfo("f:message", //$NON-NLS-1$
            333, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_setVariable_350_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            350, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_352_1 = new TagInfo("c:if", //$NON-NLS-1$
            352, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_353_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            353, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_354_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            354, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_355_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            355, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_356_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            356, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_357_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            357, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_359_6 = new TagInfo("c:if", //$NON-NLS-1$
            359, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_361_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            361, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_362_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            362, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_364_13 = new TagInfo("c:if", //$NON-NLS-1$
            364, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_366_9 = new TagInfo("c:if", //$NON-NLS-1$
            366, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_367_11 = new TagInfo("c:if", //$NON-NLS-1$
            367, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_369_14 = new TagInfo("c:if", //$NON-NLS-1$
            369, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_371_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            371, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_372_16 = new TagInfo("c:if", //$NON-NLS-1$
            372, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_373_1 = new TagInfo("f:message", //$NON-NLS-1$
            373, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_379_17 = new TagInfo("c:if", //$NON-NLS-1$
            379, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_380_1 = new TagInfo("f:message", //$NON-NLS-1$
            380, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_setVariable_398_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            398, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_400_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            400, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_401_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            401, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_402_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            402, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_403_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            403, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_405_6 = new TagInfo("c:if", //$NON-NLS-1$
            405, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_407_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            407, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_408_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            408, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_410_13 = new TagInfo("c:if", //$NON-NLS-1$
            410, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_412_9 = new TagInfo("c:if", //$NON-NLS-1$
            412, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_413_11 = new TagInfo("c:if", //$NON-NLS-1$
            413, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_415_14 = new TagInfo("c:if", //$NON-NLS-1$
            415, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_417_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            417, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_418_16 = new TagInfo("c:if", //$NON-NLS-1$
            418, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_419_1 = new TagInfo("f:message", //$NON-NLS-1$
            419, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_425_17 = new TagInfo("c:if", //$NON-NLS-1$
            425, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_426_1 = new TagInfo("f:message", //$NON-NLS-1$
            426, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_445_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            445, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_446_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            446, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_447_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            447, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_448_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            448, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_450_6 = new TagInfo("c:if", //$NON-NLS-1$
            450, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_452_6 = new TagInfo("c:if", //$NON-NLS-1$
            452, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_453_8 = new TagInfo("c:if", //$NON-NLS-1$
            453, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_455_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            455, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_457_12 = new TagInfo("c:if", //$NON-NLS-1$
            457, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_458_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            458, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_460_14 = new TagInfo("c:if", //$NON-NLS-1$
            460, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_462_14 = new TagInfo("c:if", //$NON-NLS-1$
            462, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_464_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            464, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_465_16 = new TagInfo("c:if", //$NON-NLS-1$
            465, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_467_1 = new TagInfo("f:message", //$NON-NLS-1$
            467, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_509_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            509, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_510_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            510, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_511_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            511, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_512_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            512, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_514_6 = new TagInfo("c:if", //$NON-NLS-1$
            514, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_516_6 = new TagInfo("c:if", //$NON-NLS-1$
            516, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_517_8 = new TagInfo("c:if", //$NON-NLS-1$
            517, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_519_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            519, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_521_12 = new TagInfo("c:if", //$NON-NLS-1$
            521, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_522_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            522, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_524_14 = new TagInfo("c:if", //$NON-NLS-1$
            524, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_526_14 = new TagInfo("c:if", //$NON-NLS-1$
            526, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_528_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            528, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_529_16 = new TagInfo("c:if", //$NON-NLS-1$
            529, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_531_1 = new TagInfo("f:message", //$NON-NLS-1$
            531, 1,
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
                out.write(context.embeddedExpressionAsString("${$groupID}", 5, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".server.rf;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                // process all getRelated entities relations
                //process level2 generizations 
                RuntimeTagElement _jettag_c_if_9_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_9_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_9_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_9_1.setTagInfo(_td_c_if_9_1);
                _jettag_c_if_9_1.doStart(context, out);
                while (_jettag_c_if_9_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_10_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_10_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_10_6.setRuntimeParent(_jettag_c_if_9_1);
                    _jettag_c_setVariable_10_6.setTagInfo(_td_c_setVariable_10_6);
                    _jettag_c_setVariable_10_6.doStart(context, out);
                    _jettag_c_setVariable_10_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_11_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_11_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_11_6.setRuntimeParent(_jettag_c_if_9_1);
                    _jettag_c_iterate_11_6.setTagInfo(_td_c_iterate_11_6);
                    _jettag_c_iterate_11_6.doStart(context, out);
                    while (_jettag_c_iterate_11_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_12_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_12_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_12_2.setRuntimeParent(_jettag_c_iterate_11_6);
                        _jettag_c_iterate_12_2.setTagInfo(_td_c_iterate_12_2);
                        _jettag_c_iterate_12_2.doStart(context, out);
                        while (_jettag_c_iterate_12_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_13_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_13_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_13_3.setRuntimeParent(_jettag_c_iterate_12_2);
                            _jettag_c_iterate_13_3.setTagInfo(_td_c_iterate_13_3);
                            _jettag_c_iterate_13_3.doStart(context, out);
                            while (_jettag_c_iterate_13_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_14_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_14_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_14_4.setRuntimeParent(_jettag_c_iterate_13_3);
                                _jettag_c_setVariable_14_4.setTagInfo(_td_c_setVariable_14_4);
                                _jettag_c_setVariable_14_4.doStart(context, out);
                                _jettag_c_setVariable_14_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_16_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_16_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_16_6.setRuntimeParent(_jettag_c_iterate_13_3);
                                _jettag_c_if_16_6.setTagInfo(_td_c_if_16_6);
                                _jettag_c_if_16_6.doStart(context, out);
                                while (_jettag_c_if_16_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_18_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_18_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_18_12.setRuntimeParent(_jettag_c_if_16_6);
                                    _jettag_c_iterate_18_12.setTagInfo(_td_c_iterate_18_12);
                                    _jettag_c_iterate_18_12.doStart(context, out);
                                    while (_jettag_c_iterate_18_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_19_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_19_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_19_12.setRuntimeParent(_jettag_c_iterate_18_12);
                                        _jettag_c_setVariable_19_12.setTagInfo(_td_c_setVariable_19_12);
                                        _jettag_c_setVariable_19_12.doStart(context, out);
                                        _jettag_c_setVariable_19_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_21_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_21_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_21_13.setRuntimeParent(_jettag_c_iterate_18_12);
                                        _jettag_c_if_21_13.setTagInfo(_td_c_if_21_13);
                                        _jettag_c_if_21_13.doStart(context, out);
                                        while (_jettag_c_if_21_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_23_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_23_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_23_9.setRuntimeParent(_jettag_c_if_21_13);
                                            _jettag_c_if_23_9.setTagInfo(_td_c_if_23_9);
                                            _jettag_c_if_23_9.doStart(context, out);
                                            while (_jettag_c_if_23_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_24_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_24_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_24_11.setRuntimeParent(_jettag_c_if_23_9);
                                                _jettag_c_if_24_11.setTagInfo(_td_c_if_24_11);
                                                _jettag_c_if_24_11.doStart(context, out);
                                                while (_jettag_c_if_24_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_26_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_26_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_26_14.setRuntimeParent(_jettag_c_if_24_11);
                                                    _jettag_c_if_26_14.setTagInfo(_td_c_if_26_14);
                                                    _jettag_c_if_26_14.doStart(context, out);
                                                    while (_jettag_c_if_26_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_28_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_28_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_28_15.setRuntimeParent(_jettag_c_if_26_14);
                                                        _jettag_c_iterate_28_15.setTagInfo(_td_c_iterate_28_15);
                                                        _jettag_c_iterate_28_15.doStart(context, out);
                                                        while (_jettag_c_iterate_28_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_29_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_29_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_29_16.setRuntimeParent(_jettag_c_iterate_28_15);
                                                            _jettag_c_if_29_16.setTagInfo(_td_c_if_29_16);
                                                            _jettag_c_if_29_16.doStart(context, out);
                                                            while (_jettag_c_if_29_16.okToProcessBody()) {
                                                                out.write("import ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 30, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".entity.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 30, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 30, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(";");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_29_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_29_16.doEnd();
                                                            _jettag_c_iterate_28_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_28_15.doEnd();
                                                        _jettag_c_if_26_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_26_14.doEnd();
                                                    _jettag_c_if_24_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_24_11.doEnd();
                                                _jettag_c_if_23_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_23_9.doEnd();
                                            _jettag_c_if_21_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_21_13.doEnd();
                                        _jettag_c_iterate_18_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_18_12.doEnd();
                                    _jettag_c_if_16_6.handleBodyContent(out);
                                }
                                _jettag_c_if_16_6.doEnd();
                                _jettag_c_iterate_13_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_13_3.doEnd();
                            _jettag_c_iterate_12_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_12_2.doEnd();
                        _jettag_c_iterate_11_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_11_6.doEnd();
                    _jettag_c_if_9_1.handleBodyContent(out);
                }
                _jettag_c_if_9_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_43_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_43_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_43_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_43_1.setTagInfo(_td_c_setVariable_43_1);
                _jettag_c_setVariable_43_1.doStart(context, out);
                _jettag_c_setVariable_43_1.doEnd();
                //process level 1 generizations 
                RuntimeTagElement _jettag_c_if_45_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_45_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_45_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_45_1.setTagInfo(_td_c_if_45_1);
                _jettag_c_if_45_1.doStart(context, out);
                while (_jettag_c_if_45_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_46_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_46_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_46_6.setRuntimeParent(_jettag_c_if_45_1);
                    _jettag_c_setVariable_46_6.setTagInfo(_td_c_setVariable_46_6);
                    _jettag_c_setVariable_46_6.doStart(context, out);
                    _jettag_c_setVariable_46_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_47_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_47_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_47_6.setRuntimeParent(_jettag_c_if_45_1);
                    _jettag_c_iterate_47_6.setTagInfo(_td_c_iterate_47_6);
                    _jettag_c_iterate_47_6.doStart(context, out);
                    while (_jettag_c_iterate_47_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_48_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_48_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_48_2.setRuntimeParent(_jettag_c_iterate_47_6);
                        _jettag_c_iterate_48_2.setTagInfo(_td_c_iterate_48_2);
                        _jettag_c_iterate_48_2.doStart(context, out);
                        while (_jettag_c_iterate_48_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_49_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_49_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_49_3.setRuntimeParent(_jettag_c_iterate_48_2);
                            _jettag_c_iterate_49_3.setTagInfo(_td_c_iterate_49_3);
                            _jettag_c_iterate_49_3.doStart(context, out);
                            while (_jettag_c_iterate_49_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_50_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_50_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_50_4.setRuntimeParent(_jettag_c_iterate_49_3);
                                _jettag_c_setVariable_50_4.setTagInfo(_td_c_setVariable_50_4);
                                _jettag_c_setVariable_50_4.doStart(context, out);
                                _jettag_c_setVariable_50_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_52_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_52_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_52_6.setRuntimeParent(_jettag_c_iterate_49_3);
                                _jettag_c_if_52_6.setTagInfo(_td_c_if_52_6);
                                _jettag_c_if_52_6.doStart(context, out);
                                while (_jettag_c_if_52_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_54_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_54_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_54_12.setRuntimeParent(_jettag_c_if_52_6);
                                    _jettag_c_iterate_54_12.setTagInfo(_td_c_iterate_54_12);
                                    _jettag_c_iterate_54_12.doStart(context, out);
                                    while (_jettag_c_iterate_54_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_55_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_55_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_55_12.setRuntimeParent(_jettag_c_iterate_54_12);
                                        _jettag_c_setVariable_55_12.setTagInfo(_td_c_setVariable_55_12);
                                        _jettag_c_setVariable_55_12.doStart(context, out);
                                        _jettag_c_setVariable_55_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_57_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_57_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_57_13.setRuntimeParent(_jettag_c_iterate_54_12);
                                        _jettag_c_if_57_13.setTagInfo(_td_c_if_57_13);
                                        _jettag_c_if_57_13.doStart(context, out);
                                        while (_jettag_c_if_57_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_59_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_59_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_59_9.setRuntimeParent(_jettag_c_if_57_13);
                                            _jettag_c_if_59_9.setTagInfo(_td_c_if_59_9);
                                            _jettag_c_if_59_9.doStart(context, out);
                                            while (_jettag_c_if_59_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_60_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_60_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_60_11.setRuntimeParent(_jettag_c_if_59_9);
                                                _jettag_c_if_60_11.setTagInfo(_td_c_if_60_11);
                                                _jettag_c_if_60_11.doStart(context, out);
                                                while (_jettag_c_if_60_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_62_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_62_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_62_14.setRuntimeParent(_jettag_c_if_60_11);
                                                    _jettag_c_if_62_14.setTagInfo(_td_c_if_62_14);
                                                    _jettag_c_if_62_14.doStart(context, out);
                                                    while (_jettag_c_if_62_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_64_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_64_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_64_15.setRuntimeParent(_jettag_c_if_62_14);
                                                        _jettag_c_iterate_64_15.setTagInfo(_td_c_iterate_64_15);
                                                        _jettag_c_iterate_64_15.doStart(context, out);
                                                        while (_jettag_c_iterate_64_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_65_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_65_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_65_16.setRuntimeParent(_jettag_c_iterate_64_15);
                                                            _jettag_c_if_65_16.setTagInfo(_td_c_if_65_16);
                                                            _jettag_c_if_65_16.doStart(context, out);
                                                            while (_jettag_c_if_65_16.okToProcessBody()) {
                                                                out.write("import ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 66, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".entity.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 66, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 66, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(";");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_65_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_65_16.doEnd();
                                                            _jettag_c_iterate_64_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_64_15.doEnd();
                                                        _jettag_c_if_62_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_62_14.doEnd();
                                                    _jettag_c_if_60_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_60_11.doEnd();
                                                _jettag_c_if_59_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_59_9.doEnd();
                                            _jettag_c_if_57_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_57_13.doEnd();
                                        _jettag_c_iterate_54_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_54_12.doEnd();
                                    _jettag_c_if_52_6.handleBodyContent(out);
                                }
                                _jettag_c_if_52_6.doEnd();
                                _jettag_c_iterate_49_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_49_3.doEnd();
                            _jettag_c_iterate_48_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_48_2.doEnd();
                        _jettag_c_iterate_47_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_47_6.doEnd();
                    _jettag_c_if_45_1.handleBodyContent(out);
                }
                _jettag_c_if_45_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_79_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_79_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_79_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_79_1.setTagInfo(_td_c_setVariable_79_1);
                _jettag_c_setVariable_79_1.doStart(context, out);
                _jettag_c_setVariable_79_1.doEnd();
                //level 0 
                RuntimeTagElement _jettag_c_iterate_81_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_81_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_81_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_81_1.setTagInfo(_td_c_iterate_81_1);
                _jettag_c_iterate_81_1.doStart(context, out);
                while (_jettag_c_iterate_81_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_82_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_82_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_82_2.setRuntimeParent(_jettag_c_iterate_81_1);
                    _jettag_c_iterate_82_2.setTagInfo(_td_c_iterate_82_2);
                    _jettag_c_iterate_82_2.doStart(context, out);
                    while (_jettag_c_iterate_82_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_83_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_83_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_83_3.setRuntimeParent(_jettag_c_iterate_82_2);
                        _jettag_c_iterate_83_3.setTagInfo(_td_c_iterate_83_3);
                        _jettag_c_iterate_83_3.doStart(context, out);
                        while (_jettag_c_iterate_83_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_84_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_84_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_84_4.setRuntimeParent(_jettag_c_iterate_83_3);
                            _jettag_c_setVariable_84_4.setTagInfo(_td_c_setVariable_84_4);
                            _jettag_c_setVariable_84_4.doStart(context, out);
                            _jettag_c_setVariable_84_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_86_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_86_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_86_6.setRuntimeParent(_jettag_c_iterate_83_3);
                            _jettag_c_if_86_6.setTagInfo(_td_c_if_86_6);
                            _jettag_c_if_86_6.doStart(context, out);
                            while (_jettag_c_if_86_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_88_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_88_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_88_12.setRuntimeParent(_jettag_c_if_86_6);
                                _jettag_c_iterate_88_12.setTagInfo(_td_c_iterate_88_12);
                                _jettag_c_iterate_88_12.doStart(context, out);
                                while (_jettag_c_iterate_88_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_89_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_89_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_89_12.setRuntimeParent(_jettag_c_iterate_88_12);
                                    _jettag_c_setVariable_89_12.setTagInfo(_td_c_setVariable_89_12);
                                    _jettag_c_setVariable_89_12.doStart(context, out);
                                    _jettag_c_setVariable_89_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_91_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_91_13); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_91_13.setRuntimeParent(_jettag_c_iterate_88_12);
                                    _jettag_c_if_91_13.setTagInfo(_td_c_if_91_13);
                                    _jettag_c_if_91_13.doStart(context, out);
                                    while (_jettag_c_if_91_13.okToProcessBody()) {
                                        // process many on target
                                        RuntimeTagElement _jettag_c_if_93_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_93_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_93_9.setRuntimeParent(_jettag_c_if_91_13);
                                        _jettag_c_if_93_9.setTagInfo(_td_c_if_93_9);
                                        _jettag_c_if_93_9.doStart(context, out);
                                        while (_jettag_c_if_93_9.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_94_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_94_11); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_94_11.setRuntimeParent(_jettag_c_if_93_9);
                                            _jettag_c_if_94_11.setTagInfo(_td_c_if_94_11);
                                            _jettag_c_if_94_11.doStart(context, out);
                                            while (_jettag_c_if_94_11.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_96_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_96_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_96_14.setRuntimeParent(_jettag_c_if_94_11);
                                                _jettag_c_if_96_14.setTagInfo(_td_c_if_96_14);
                                                _jettag_c_if_96_14.doStart(context, out);
                                                while (_jettag_c_if_96_14.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_98_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_98_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_98_15.setRuntimeParent(_jettag_c_if_96_14);
                                                    _jettag_c_iterate_98_15.setTagInfo(_td_c_iterate_98_15);
                                                    _jettag_c_iterate_98_15.doStart(context, out);
                                                    while (_jettag_c_iterate_98_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_99_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_99_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_99_16.setRuntimeParent(_jettag_c_iterate_98_15);
                                                        _jettag_c_if_99_16.setTagInfo(_td_c_if_99_16);
                                                        _jettag_c_if_99_16.doStart(context, out);
                                                        while (_jettag_c_if_99_16.okToProcessBody()) {
                                                            out.write("import ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 100, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".entity.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 100, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 100, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_99_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_99_16.doEnd();
                                                        _jettag_c_iterate_98_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_98_15.doEnd();
                                                    _jettag_c_if_96_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_96_14.doEnd();
                                                _jettag_c_if_94_11.handleBodyContent(out);
                                            }
                                            _jettag_c_if_94_11.doEnd();
                                            _jettag_c_if_93_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_93_9.doEnd();
                                        _jettag_c_if_91_13.handleBodyContent(out);
                                    }
                                    _jettag_c_if_91_13.doEnd();
                                    _jettag_c_iterate_88_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_88_12.doEnd();
                                _jettag_c_if_86_6.handleBodyContent(out);
                            }
                            _jettag_c_if_86_6.doEnd();
                            _jettag_c_iterate_83_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_83_3.doEnd();
                        _jettag_c_iterate_82_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_82_2.doEnd();
                    _jettag_c_iterate_81_1.handleBodyContent(out);
                }
                _jettag_c_iterate_81_1.doEnd();
                out.write(NL);         
                // process all addAll relations
                RuntimeTagElement _jettag_c_iterate_114_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_114_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_114_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_114_1.setTagInfo(_td_c_iterate_114_1);
                _jettag_c_iterate_114_1.doStart(context, out);
                while (_jettag_c_iterate_114_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_115_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_115_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_115_2.setRuntimeParent(_jettag_c_iterate_114_1);
                    _jettag_c_iterate_115_2.setTagInfo(_td_c_iterate_115_2);
                    _jettag_c_iterate_115_2.doStart(context, out);
                    while (_jettag_c_iterate_115_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_116_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_116_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_116_3.setRuntimeParent(_jettag_c_iterate_115_2);
                        _jettag_c_iterate_116_3.setTagInfo(_td_c_iterate_116_3);
                        _jettag_c_iterate_116_3.doStart(context, out);
                        while (_jettag_c_iterate_116_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_117_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_117_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_117_4.setRuntimeParent(_jettag_c_iterate_116_3);
                            _jettag_c_setVariable_117_4.setTagInfo(_td_c_setVariable_117_4);
                            _jettag_c_setVariable_117_4.doStart(context, out);
                            _jettag_c_setVariable_117_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_119_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_119_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_119_6.setRuntimeParent(_jettag_c_iterate_116_3);
                            _jettag_c_if_119_6.setTagInfo(_td_c_if_119_6);
                            _jettag_c_if_119_6.doStart(context, out);
                            while (_jettag_c_if_119_6.okToProcessBody()) {
                                // process only classes with many on source side
                                RuntimeTagElement _jettag_c_if_121_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_121_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_121_6.setRuntimeParent(_jettag_c_if_119_6);
                                _jettag_c_if_121_6.setTagInfo(_td_c_if_121_6);
                                _jettag_c_if_121_6.doStart(context, out);
                                while (_jettag_c_if_121_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_122_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_122_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_122_8.setRuntimeParent(_jettag_c_if_121_6);
                                    _jettag_c_if_122_8.setTagInfo(_td_c_if_122_8);
                                    _jettag_c_if_122_8.doStart(context, out);
                                    while (_jettag_c_if_122_8.okToProcessBody()) {
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_124_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_124_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_124_12.setRuntimeParent(_jettag_c_if_122_8);
                                        _jettag_c_iterate_124_12.setTagInfo(_td_c_iterate_124_12);
                                        _jettag_c_iterate_124_12.doStart(context, out);
                                        while (_jettag_c_iterate_124_12.okToProcessBody()) {
                                            // process only non composites 
                                            RuntimeTagElement _jettag_c_if_126_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_126_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_126_12.setRuntimeParent(_jettag_c_iterate_124_12);
                                            _jettag_c_if_126_12.setTagInfo(_td_c_if_126_12);
                                            _jettag_c_if_126_12.doStart(context, out);
                                            while (_jettag_c_if_126_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_127_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_127_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_127_12.setRuntimeParent(_jettag_c_if_126_12);
                                                _jettag_c_setVariable_127_12.setTagInfo(_td_c_setVariable_127_12);
                                                _jettag_c_setVariable_127_12.doStart(context, out);
                                                _jettag_c_setVariable_127_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_129_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_129_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_129_14.setRuntimeParent(_jettag_c_if_126_12);
                                                _jettag_c_if_129_14.setTagInfo(_td_c_if_129_14);
                                                _jettag_c_if_129_14.doStart(context, out);
                                                while (_jettag_c_if_129_14.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_131_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_131_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_131_14.setRuntimeParent(_jettag_c_if_129_14);
                                                    _jettag_c_if_131_14.setTagInfo(_td_c_if_131_14);
                                                    _jettag_c_if_131_14.doStart(context, out);
                                                    while (_jettag_c_if_131_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_133_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_133_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_133_15.setRuntimeParent(_jettag_c_if_131_14);
                                                        _jettag_c_iterate_133_15.setTagInfo(_td_c_iterate_133_15);
                                                        _jettag_c_iterate_133_15.doStart(context, out);
                                                        while (_jettag_c_iterate_133_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_134_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_134_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_134_16.setRuntimeParent(_jettag_c_iterate_133_15);
                                                            _jettag_c_if_134_16.setTagInfo(_td_c_if_134_16);
                                                            _jettag_c_if_134_16.doStart(context, out);
                                                            while (_jettag_c_if_134_16.okToProcessBody()) {
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 135, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".entity.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 135, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 135, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(";");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_134_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_134_16.doEnd();
                                                            _jettag_c_iterate_133_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_133_15.doEnd();
                                                        _jettag_c_if_131_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_131_14.doEnd();
                                                    _jettag_c_if_129_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_129_14.doEnd();
                                                _jettag_c_if_126_12.handleBodyContent(out);
                                            }
                                            _jettag_c_if_126_12.doEnd();
                                            _jettag_c_iterate_124_12.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_124_12.doEnd();
                                        _jettag_c_if_122_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_122_8.doEnd();
                                    _jettag_c_if_121_6.handleBodyContent(out);
                                }
                                _jettag_c_if_121_6.doEnd();
                                _jettag_c_if_119_6.handleBodyContent(out);
                            }
                            _jettag_c_if_119_6.doEnd();
                            _jettag_c_iterate_116_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_116_3.doEnd();
                        _jettag_c_iterate_115_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_115_2.doEnd();
                    _jettag_c_iterate_114_1.handleBodyContent(out);
                }
                _jettag_c_iterate_114_1.doEnd();
                out.write(NL);         
                // process all merge relations
                RuntimeTagElement _jettag_c_iterate_150_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_150_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_150_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_150_1.setTagInfo(_td_c_iterate_150_1);
                _jettag_c_iterate_150_1.doStart(context, out);
                while (_jettag_c_iterate_150_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_151_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_151_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_151_2.setRuntimeParent(_jettag_c_iterate_150_1);
                    _jettag_c_iterate_151_2.setTagInfo(_td_c_iterate_151_2);
                    _jettag_c_iterate_151_2.doStart(context, out);
                    while (_jettag_c_iterate_151_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_152_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_152_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_152_3.setRuntimeParent(_jettag_c_iterate_151_2);
                        _jettag_c_iterate_152_3.setTagInfo(_td_c_iterate_152_3);
                        _jettag_c_iterate_152_3.doStart(context, out);
                        while (_jettag_c_iterate_152_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_153_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_153_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_153_4.setRuntimeParent(_jettag_c_iterate_152_3);
                            _jettag_c_setVariable_153_4.setTagInfo(_td_c_setVariable_153_4);
                            _jettag_c_setVariable_153_4.doStart(context, out);
                            _jettag_c_setVariable_153_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_155_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_155_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_155_6.setRuntimeParent(_jettag_c_iterate_152_3);
                            _jettag_c_if_155_6.setTagInfo(_td_c_if_155_6);
                            _jettag_c_if_155_6.doStart(context, out);
                            while (_jettag_c_if_155_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_157_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_157_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_157_12.setRuntimeParent(_jettag_c_if_155_6);
                                _jettag_c_iterate_157_12.setTagInfo(_td_c_iterate_157_12);
                                _jettag_c_iterate_157_12.doStart(context, out);
                                while (_jettag_c_iterate_157_12.okToProcessBody()) {
                                    // process only  composites on target
                                    RuntimeTagElement _jettag_c_if_159_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_159_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_159_12.setRuntimeParent(_jettag_c_iterate_157_12);
                                    _jettag_c_if_159_12.setTagInfo(_td_c_if_159_12);
                                    _jettag_c_if_159_12.doStart(context, out);
                                    while (_jettag_c_if_159_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_160_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_160_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_160_12.setRuntimeParent(_jettag_c_if_159_12);
                                        _jettag_c_setVariable_160_12.setTagInfo(_td_c_setVariable_160_12);
                                        _jettag_c_setVariable_160_12.doStart(context, out);
                                        _jettag_c_setVariable_160_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_162_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_162_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_162_14.setRuntimeParent(_jettag_c_if_159_12);
                                        _jettag_c_if_162_14.setTagInfo(_td_c_if_162_14);
                                        _jettag_c_if_162_14.doStart(context, out);
                                        while (_jettag_c_if_162_14.okToProcessBody()) {
                                            // iterate throught all the classes to get the other class on the association
                                            RuntimeTagElement _jettag_c_iterate_164_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_164_15); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_164_15.setRuntimeParent(_jettag_c_if_162_14);
                                            _jettag_c_iterate_164_15.setTagInfo(_td_c_iterate_164_15);
                                            _jettag_c_iterate_164_15.doStart(context, out);
                                            while (_jettag_c_iterate_164_15.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_165_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_165_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_165_16.setRuntimeParent(_jettag_c_iterate_164_15);
                                                _jettag_c_if_165_16.setTagInfo(_td_c_if_165_16);
                                                _jettag_c_if_165_16.doStart(context, out);
                                                while (_jettag_c_if_165_16.okToProcessBody()) {
                                                    out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 166, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".entity.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 166, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 166, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    RuntimeTagElement _jettag_c_if_167_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_167_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_167_12.setRuntimeParent(_jettag_c_if_165_16);
                                                    _jettag_c_if_167_12.setTagInfo(_td_c_if_167_12);
                                                    _jettag_c_if_167_12.doStart(context, out);
                                                    while (_jettag_c_if_167_12.okToProcessBody()) {
                                                        out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 168, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entity.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 168, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@parentClass1Name}", 168, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_167_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_167_12.doEnd();
                                                    RuntimeTagElement _jettag_c_if_170_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_170_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_170_12.setRuntimeParent(_jettag_c_if_165_16);
                                                    _jettag_c_if_170_12.setTagInfo(_td_c_if_170_12);
                                                    _jettag_c_if_170_12.doStart(context, out);
                                                    while (_jettag_c_if_170_12.okToProcessBody()) {
                                                        out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 171, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entity.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 171, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@parentClass2Name}", 171, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_170_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_170_12.doEnd();
                                                    _jettag_c_if_165_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_165_16.doEnd();
                                                _jettag_c_iterate_164_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_164_15.doEnd();
                                            _jettag_c_if_162_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_162_14.doEnd();
                                        _jettag_c_if_159_12.handleBodyContent(out);
                                    }
                                    _jettag_c_if_159_12.doEnd();
                                    _jettag_c_iterate_157_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_157_12.doEnd();
                                _jettag_c_if_155_6.handleBodyContent(out);
                            }
                            _jettag_c_if_155_6.doEnd();
                            _jettag_c_iterate_152_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_152_3.doEnd();
                        _jettag_c_iterate_151_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_151_2.doEnd();
                    _jettag_c_iterate_150_1.handleBodyContent(out);
                }
                _jettag_c_iterate_150_1.doEnd();
                out.write("import info.yalamanchili.requestfactory.GenericDao;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.trace.Trace;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 185, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 185, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 185, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.server.GenericGWTDao;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.beans.TableObj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.server.GWTServletUtils;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.server.GenericGWTDao;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.trace.Trace;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import java.util.HashMap;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.ArrayList;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Map;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.lang.reflect.Method;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.EntityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.Query;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_c_if_200_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_200_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_200_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_200_1.setTagInfo(_td_c_if_200_1);
                _jettag_c_if_200_1.doStart(context, out);
                while (_jettag_c_if_200_1.okToProcessBody()) {
                    out.write("import org.apache.lucene.util.Version;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import info.yalamanchili.commons.DataType;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import info.yalamanchili.commons.ReflectionUtils;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import info.yalamanchili.commons.SearchUtils;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import info.yalamanchili.gwt.beans.MultiSelectObj;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import org.apache.lucene.analysis.standard.StandardAnalyzer;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import org.hibernate.search.FullTextQuery;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_200_1.handleBodyContent(out);
                }
                _jettag_c_if_200_1.doEnd();
                out.write("import org.jboss.seam.ScopeType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.In;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Name;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Scope;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Transactional;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_215_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_215_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_215_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_215_1.setTagInfo(_td_f_message_215_1);
                _jettag_f_message_215_1.doStart(context, out);
                JET2Writer _jettag_f_message_215_1_saved_out = out;
                while (_jettag_f_message_215_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_215_1.handleBodyContent(out);
                }
                out = _jettag_f_message_215_1_saved_out;
                _jettag_f_message_215_1.doEnd();
                out.write(NL);         
                out.write(NL);         
                out.write("@Trace");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Transactional");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Scope(ScopeType.EVENT)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Name(\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 220, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("GWTDao\")");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 221, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("GWTDao extends GenericGWTDao<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 221, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@In(create = true)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected EntityManager em;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 226, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" findById(Long id) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn em.find( ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 227, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class, id);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\tpublic void save(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 230, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tem.merge(entity);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void delete(long id) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tem.remove(id);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 240, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> query(int start, int limit) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tString query = \"from \" + ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 241, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getCanonicalName();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery getEntitites = em.createQuery(query);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tgetEntitites.setFirstResult(start);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t// TODO externalize the max results value");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tgetEntitites.setMaxResults(limit);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn getEntitites.getResultList();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 250, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> search(String searchText) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\torg.apache.lucene.search.Query luceneQuery = SearchUtils");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.getLuceneQuery(searchText, \"id\", new StandardAnalyzer(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tVersion.LUCENE_30), ReflectionUtils.getBeanProperties(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 254, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class, DataType.STRING));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tFullTextQuery query = SearchUtils.getFullTextSession(em)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.createFullTextQuery(luceneQuery, ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 256, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn query.list();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 261, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> search(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 261, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery getEntitiesQuery = em.createQuery(GWTServletUtils");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.getSearchQueryString(entity));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn getEntitiesQuery.getResultList();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic Long size() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tString query = \"select count(entity) from \"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t+ ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 270, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getCanonicalName() + \" entity\";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery getEntitiesSize = em.createQuery(query);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn (Long) getEntitiesSize.getSingleResult();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic List<String> getSuggestionsForName(String name, ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 276, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery query = em.createQuery(GWTServletUtils");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.getSuggestionsQueryForName(name, entity));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn query.getResultList();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic Map<Long, String> getListBoxValues(String[] columns) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tString query = GWTServletUtils.getListBoxResultsQueryString(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 285, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getCanonicalName(), columns);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tMap<Long, String> values = new HashMap<Long, String>();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery getListBoxValues = em.createQuery(query);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tfor (Object obj : getListBoxValues.getResultList()) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tObject[] obs = (Object[]) obj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tvalues.put((Long) obs[0], (String) obs[1]);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn values;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic TableObj<?> getTableObj(int start) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tTableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 297, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> tableObj = new TableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 297, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\ttableObj.setRecords(query(start, 10));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\ttableObj.setNumberOfRecords(size());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn tableObj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                // process all getRelated entities relations
                //process level2 generizations 
                RuntimeTagElement _jettag_c_if_305_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_305_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_305_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_305_1.setTagInfo(_td_c_if_305_1);
                _jettag_c_if_305_1.doStart(context, out);
                while (_jettag_c_if_305_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_306_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_306_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_306_6.setRuntimeParent(_jettag_c_if_305_1);
                    _jettag_c_setVariable_306_6.setTagInfo(_td_c_setVariable_306_6);
                    _jettag_c_setVariable_306_6.doStart(context, out);
                    _jettag_c_setVariable_306_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_307_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_307_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_307_6.setRuntimeParent(_jettag_c_if_305_1);
                    _jettag_c_iterate_307_6.setTagInfo(_td_c_iterate_307_6);
                    _jettag_c_iterate_307_6.doStart(context, out);
                    while (_jettag_c_iterate_307_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_308_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_308_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_308_2.setRuntimeParent(_jettag_c_iterate_307_6);
                        _jettag_c_iterate_308_2.setTagInfo(_td_c_iterate_308_2);
                        _jettag_c_iterate_308_2.doStart(context, out);
                        while (_jettag_c_iterate_308_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_309_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_309_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_309_3.setRuntimeParent(_jettag_c_iterate_308_2);
                            _jettag_c_iterate_309_3.setTagInfo(_td_c_iterate_309_3);
                            _jettag_c_iterate_309_3.doStart(context, out);
                            while (_jettag_c_iterate_309_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_310_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_310_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_310_4.setRuntimeParent(_jettag_c_iterate_309_3);
                                _jettag_c_setVariable_310_4.setTagInfo(_td_c_setVariable_310_4);
                                _jettag_c_setVariable_310_4.doStart(context, out);
                                _jettag_c_setVariable_310_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_312_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_312_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_312_6.setRuntimeParent(_jettag_c_iterate_309_3);
                                _jettag_c_if_312_6.setTagInfo(_td_c_if_312_6);
                                _jettag_c_if_312_6.doStart(context, out);
                                while (_jettag_c_if_312_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_314_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_314_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_314_12.setRuntimeParent(_jettag_c_if_312_6);
                                    _jettag_c_iterate_314_12.setTagInfo(_td_c_iterate_314_12);
                                    _jettag_c_iterate_314_12.doStart(context, out);
                                    while (_jettag_c_iterate_314_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_315_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_315_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_315_12.setRuntimeParent(_jettag_c_iterate_314_12);
                                        _jettag_c_setVariable_315_12.setTagInfo(_td_c_setVariable_315_12);
                                        _jettag_c_setVariable_315_12.doStart(context, out);
                                        _jettag_c_setVariable_315_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_317_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_317_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_317_13.setRuntimeParent(_jettag_c_iterate_314_12);
                                        _jettag_c_if_317_13.setTagInfo(_td_c_if_317_13);
                                        _jettag_c_if_317_13.doStart(context, out);
                                        while (_jettag_c_if_317_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_319_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_319_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_319_9.setRuntimeParent(_jettag_c_if_317_13);
                                            _jettag_c_if_319_9.setTagInfo(_td_c_if_319_9);
                                            _jettag_c_if_319_9.doStart(context, out);
                                            while (_jettag_c_if_319_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_320_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_320_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_320_11.setRuntimeParent(_jettag_c_if_319_9);
                                                _jettag_c_if_320_11.setTagInfo(_td_c_if_320_11);
                                                _jettag_c_if_320_11.doStart(context, out);
                                                while (_jettag_c_if_320_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_322_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_322_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_322_14.setRuntimeParent(_jettag_c_if_320_11);
                                                    _jettag_c_if_322_14.setTagInfo(_td_c_if_322_14);
                                                    _jettag_c_if_322_14.doStart(context, out);
                                                    while (_jettag_c_if_322_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_324_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_324_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_324_15.setRuntimeParent(_jettag_c_if_322_14);
                                                        _jettag_c_iterate_324_15.setTagInfo(_td_c_iterate_324_15);
                                                        _jettag_c_iterate_324_15.doStart(context, out);
                                                        while (_jettag_c_iterate_324_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_325_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_325_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_325_16.setRuntimeParent(_jettag_c_iterate_324_15);
                                                            _jettag_c_if_325_16.setTagInfo(_td_c_if_325_16);
                                                            _jettag_c_if_325_16.doStart(context, out);
                                                            while (_jettag_c_if_325_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_326_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_326_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_326_1.setRuntimeParent(_jettag_c_if_325_16);
                                                                _jettag_f_message_326_1.setTagInfo(_td_f_message_326_1);
                                                                _jettag_f_message_326_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_326_1_saved_out = out;
                                                                while (_jettag_f_message_326_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_326_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_326_1_saved_out;
                                                                _jettag_f_message_326_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\tpublic  List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 327, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("> get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 327, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long entityID) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t//TODO no need for this call user rf???");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\treturn  new ArrayList<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 329, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(">(em.find(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 329, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class, entityID).get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 329, 86)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s());");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                // check to see if the parent side is aggregation or none
                                                                RuntimeTagElement _jettag_c_if_332_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_332_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_332_17.setRuntimeParent(_jettag_c_if_325_16);
                                                                _jettag_c_if_332_17.setTagInfo(_td_c_if_332_17);
                                                                _jettag_c_if_332_17.doStart(context, out);
                                                                while (_jettag_c_if_332_17.okToProcessBody()) {
                                                                    RuntimeTagElement _jettag_f_message_333_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_333_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_333_1.setRuntimeParent(_jettag_c_if_332_17);
                                                                    _jettag_f_message_333_1.setTagInfo(_td_f_message_333_1);
                                                                    _jettag_f_message_333_1.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_333_1_saved_out = out;
                                                                    while (_jettag_f_message_333_1.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_333_1.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_333_1_saved_out;
                                                                    _jettag_f_message_333_1.doEnd();
                                                                    out.write("\t  \t\t\t\t\t  \t\t \t\t\t\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\tpublic MultiSelectObj<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 334, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("> get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 334, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(Long entityID, String[] columns){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\treturn null;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t}");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_332_17.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_332_17.doEnd();
                                                                _jettag_c_if_325_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_325_16.doEnd();
                                                            _jettag_c_iterate_324_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_324_15.doEnd();
                                                        _jettag_c_if_322_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_322_14.doEnd();
                                                    _jettag_c_if_320_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_320_11.doEnd();
                                                _jettag_c_if_319_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_319_9.doEnd();
                                            _jettag_c_if_317_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_317_13.doEnd();
                                        _jettag_c_iterate_314_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_314_12.doEnd();
                                    _jettag_c_if_312_6.handleBodyContent(out);
                                }
                                _jettag_c_if_312_6.doEnd();
                                _jettag_c_iterate_309_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_309_3.doEnd();
                            _jettag_c_iterate_308_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_308_2.doEnd();
                        _jettag_c_iterate_307_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_307_6.doEnd();
                    _jettag_c_if_305_1.handleBodyContent(out);
                }
                _jettag_c_if_305_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_350_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_350_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_350_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_350_1.setTagInfo(_td_c_setVariable_350_1);
                _jettag_c_setVariable_350_1.doStart(context, out);
                _jettag_c_setVariable_350_1.doEnd();
                //process level 1 generizations 
                RuntimeTagElement _jettag_c_if_352_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_352_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_352_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_352_1.setTagInfo(_td_c_if_352_1);
                _jettag_c_if_352_1.doStart(context, out);
                while (_jettag_c_if_352_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_353_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_353_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_353_6.setRuntimeParent(_jettag_c_if_352_1);
                    _jettag_c_setVariable_353_6.setTagInfo(_td_c_setVariable_353_6);
                    _jettag_c_setVariable_353_6.doStart(context, out);
                    _jettag_c_setVariable_353_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_354_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_354_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_354_6.setRuntimeParent(_jettag_c_if_352_1);
                    _jettag_c_iterate_354_6.setTagInfo(_td_c_iterate_354_6);
                    _jettag_c_iterate_354_6.doStart(context, out);
                    while (_jettag_c_iterate_354_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_355_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_355_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_355_2.setRuntimeParent(_jettag_c_iterate_354_6);
                        _jettag_c_iterate_355_2.setTagInfo(_td_c_iterate_355_2);
                        _jettag_c_iterate_355_2.doStart(context, out);
                        while (_jettag_c_iterate_355_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_356_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_356_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_356_3.setRuntimeParent(_jettag_c_iterate_355_2);
                            _jettag_c_iterate_356_3.setTagInfo(_td_c_iterate_356_3);
                            _jettag_c_iterate_356_3.doStart(context, out);
                            while (_jettag_c_iterate_356_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_357_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_357_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_357_4.setRuntimeParent(_jettag_c_iterate_356_3);
                                _jettag_c_setVariable_357_4.setTagInfo(_td_c_setVariable_357_4);
                                _jettag_c_setVariable_357_4.doStart(context, out);
                                _jettag_c_setVariable_357_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_359_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_359_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_359_6.setRuntimeParent(_jettag_c_iterate_356_3);
                                _jettag_c_if_359_6.setTagInfo(_td_c_if_359_6);
                                _jettag_c_if_359_6.doStart(context, out);
                                while (_jettag_c_if_359_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_361_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_361_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_361_12.setRuntimeParent(_jettag_c_if_359_6);
                                    _jettag_c_iterate_361_12.setTagInfo(_td_c_iterate_361_12);
                                    _jettag_c_iterate_361_12.doStart(context, out);
                                    while (_jettag_c_iterate_361_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_362_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_362_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_362_12.setRuntimeParent(_jettag_c_iterate_361_12);
                                        _jettag_c_setVariable_362_12.setTagInfo(_td_c_setVariable_362_12);
                                        _jettag_c_setVariable_362_12.doStart(context, out);
                                        _jettag_c_setVariable_362_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_364_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_364_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_364_13.setRuntimeParent(_jettag_c_iterate_361_12);
                                        _jettag_c_if_364_13.setTagInfo(_td_c_if_364_13);
                                        _jettag_c_if_364_13.doStart(context, out);
                                        while (_jettag_c_if_364_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_366_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_366_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_366_9.setRuntimeParent(_jettag_c_if_364_13);
                                            _jettag_c_if_366_9.setTagInfo(_td_c_if_366_9);
                                            _jettag_c_if_366_9.doStart(context, out);
                                            while (_jettag_c_if_366_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_367_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_367_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_367_11.setRuntimeParent(_jettag_c_if_366_9);
                                                _jettag_c_if_367_11.setTagInfo(_td_c_if_367_11);
                                                _jettag_c_if_367_11.doStart(context, out);
                                                while (_jettag_c_if_367_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_369_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_369_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_369_14.setRuntimeParent(_jettag_c_if_367_11);
                                                    _jettag_c_if_369_14.setTagInfo(_td_c_if_369_14);
                                                    _jettag_c_if_369_14.doStart(context, out);
                                                    while (_jettag_c_if_369_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_371_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_371_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_371_15.setRuntimeParent(_jettag_c_if_369_14);
                                                        _jettag_c_iterate_371_15.setTagInfo(_td_c_iterate_371_15);
                                                        _jettag_c_iterate_371_15.doStart(context, out);
                                                        while (_jettag_c_iterate_371_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_372_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_372_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_372_16.setRuntimeParent(_jettag_c_iterate_371_15);
                                                            _jettag_c_if_372_16.setTagInfo(_td_c_if_372_16);
                                                            _jettag_c_if_372_16.doStart(context, out);
                                                            while (_jettag_c_if_372_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_373_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_373_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_373_1.setRuntimeParent(_jettag_c_if_372_16);
                                                                _jettag_f_message_373_1.setTagInfo(_td_f_message_373_1);
                                                                _jettag_f_message_373_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_373_1_saved_out = out;
                                                                while (_jettag_f_message_373_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_373_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_373_1_saved_out;
                                                                _jettag_f_message_373_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\tpublic  List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 374, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("> get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 374, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long entityID) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t//TODO no need for this call user rf???");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\treturn  new ArrayList<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 376, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(">(em.find(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 376, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class, entityID).get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 376, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s());");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                // check to see if the parent side is aggregation or none
                                                                RuntimeTagElement _jettag_c_if_379_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_379_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_379_17.setRuntimeParent(_jettag_c_if_372_16);
                                                                _jettag_c_if_379_17.setTagInfo(_td_c_if_379_17);
                                                                _jettag_c_if_379_17.doStart(context, out);
                                                                while (_jettag_c_if_379_17.okToProcessBody()) {
                                                                    RuntimeTagElement _jettag_f_message_380_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_380_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_380_1.setRuntimeParent(_jettag_c_if_379_17);
                                                                    _jettag_f_message_380_1.setTagInfo(_td_f_message_380_1);
                                                                    _jettag_f_message_380_1.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_380_1_saved_out = out;
                                                                    while (_jettag_f_message_380_1.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_380_1.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_380_1_saved_out;
                                                                    _jettag_f_message_380_1.doEnd();
                                                                    out.write("\t  \t\t\t\t\t  \t\t \t\t\t\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\tpublic MultiSelectObj<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 381, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("> get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 381, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(Long entityID, String[] columns){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\treturn null;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t}");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_379_17.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_379_17.doEnd();
                                                                out.write("\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_372_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_372_16.doEnd();
                                                            _jettag_c_iterate_371_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_371_15.doEnd();
                                                        _jettag_c_if_369_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_369_14.doEnd();
                                                    _jettag_c_if_367_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_367_11.doEnd();
                                                _jettag_c_if_366_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_366_9.doEnd();
                                            _jettag_c_if_364_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_364_13.doEnd();
                                        _jettag_c_iterate_361_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_361_12.doEnd();
                                    _jettag_c_if_359_6.handleBodyContent(out);
                                }
                                _jettag_c_if_359_6.doEnd();
                                _jettag_c_iterate_356_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_356_3.doEnd();
                            _jettag_c_iterate_355_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_355_2.doEnd();
                        _jettag_c_iterate_354_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_354_6.doEnd();
                    _jettag_c_if_352_1.handleBodyContent(out);
                }
                _jettag_c_if_352_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_398_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_398_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_398_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_398_1.setTagInfo(_td_c_setVariable_398_1);
                _jettag_c_setVariable_398_1.doStart(context, out);
                _jettag_c_setVariable_398_1.doEnd();
                //level 0 
                RuntimeTagElement _jettag_c_iterate_400_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_400_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_400_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_400_1.setTagInfo(_td_c_iterate_400_1);
                _jettag_c_iterate_400_1.doStart(context, out);
                while (_jettag_c_iterate_400_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_401_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_401_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_401_2.setRuntimeParent(_jettag_c_iterate_400_1);
                    _jettag_c_iterate_401_2.setTagInfo(_td_c_iterate_401_2);
                    _jettag_c_iterate_401_2.doStart(context, out);
                    while (_jettag_c_iterate_401_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_402_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_402_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_402_3.setRuntimeParent(_jettag_c_iterate_401_2);
                        _jettag_c_iterate_402_3.setTagInfo(_td_c_iterate_402_3);
                        _jettag_c_iterate_402_3.doStart(context, out);
                        while (_jettag_c_iterate_402_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_403_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_403_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_403_4.setRuntimeParent(_jettag_c_iterate_402_3);
                            _jettag_c_setVariable_403_4.setTagInfo(_td_c_setVariable_403_4);
                            _jettag_c_setVariable_403_4.doStart(context, out);
                            _jettag_c_setVariable_403_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_405_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_405_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_405_6.setRuntimeParent(_jettag_c_iterate_402_3);
                            _jettag_c_if_405_6.setTagInfo(_td_c_if_405_6);
                            _jettag_c_if_405_6.doStart(context, out);
                            while (_jettag_c_if_405_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_407_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_407_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_407_12.setRuntimeParent(_jettag_c_if_405_6);
                                _jettag_c_iterate_407_12.setTagInfo(_td_c_iterate_407_12);
                                _jettag_c_iterate_407_12.doStart(context, out);
                                while (_jettag_c_iterate_407_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_408_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_408_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_408_12.setRuntimeParent(_jettag_c_iterate_407_12);
                                    _jettag_c_setVariable_408_12.setTagInfo(_td_c_setVariable_408_12);
                                    _jettag_c_setVariable_408_12.doStart(context, out);
                                    _jettag_c_setVariable_408_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_410_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_410_13); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_410_13.setRuntimeParent(_jettag_c_iterate_407_12);
                                    _jettag_c_if_410_13.setTagInfo(_td_c_if_410_13);
                                    _jettag_c_if_410_13.doStart(context, out);
                                    while (_jettag_c_if_410_13.okToProcessBody()) {
                                        // process many on target
                                        RuntimeTagElement _jettag_c_if_412_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_412_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_412_9.setRuntimeParent(_jettag_c_if_410_13);
                                        _jettag_c_if_412_9.setTagInfo(_td_c_if_412_9);
                                        _jettag_c_if_412_9.doStart(context, out);
                                        while (_jettag_c_if_412_9.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_413_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_413_11); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_413_11.setRuntimeParent(_jettag_c_if_412_9);
                                            _jettag_c_if_413_11.setTagInfo(_td_c_if_413_11);
                                            _jettag_c_if_413_11.doStart(context, out);
                                            while (_jettag_c_if_413_11.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_415_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_415_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_415_14.setRuntimeParent(_jettag_c_if_413_11);
                                                _jettag_c_if_415_14.setTagInfo(_td_c_if_415_14);
                                                _jettag_c_if_415_14.doStart(context, out);
                                                while (_jettag_c_if_415_14.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_417_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_417_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_417_15.setRuntimeParent(_jettag_c_if_415_14);
                                                    _jettag_c_iterate_417_15.setTagInfo(_td_c_iterate_417_15);
                                                    _jettag_c_iterate_417_15.doStart(context, out);
                                                    while (_jettag_c_iterate_417_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_418_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_418_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_418_16.setRuntimeParent(_jettag_c_iterate_417_15);
                                                        _jettag_c_if_418_16.setTagInfo(_td_c_if_418_16);
                                                        _jettag_c_if_418_16.doStart(context, out);
                                                        while (_jettag_c_if_418_16.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_f_message_419_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_419_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_419_1.setRuntimeParent(_jettag_c_if_418_16);
                                                            _jettag_f_message_419_1.setTagInfo(_td_f_message_419_1);
                                                            _jettag_f_message_419_1.doStart(context, out);
                                                            JET2Writer _jettag_f_message_419_1_saved_out = out;
                                                            while (_jettag_f_message_419_1.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_419_1.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_419_1_saved_out;
                                                            _jettag_f_message_419_1.doEnd();
                                                            out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\tpublic  List<");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 420, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("> get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 420, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s(Long entityID) {");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t//TODO no need for this call user rf???");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\treturn  new ArrayList<");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 422, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(">(em.find(");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class/@name}", 422, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".class, entityID).get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 422, 86)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s());");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t}");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            // check to see if the parent side is aggregation or none
                                                            RuntimeTagElement _jettag_c_if_425_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_425_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_425_17.setRuntimeParent(_jettag_c_if_418_16);
                                                            _jettag_c_if_425_17.setTagInfo(_td_c_if_425_17);
                                                            _jettag_c_if_425_17.doStart(context, out);
                                                            while (_jettag_c_if_425_17.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_426_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_426_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_426_1.setRuntimeParent(_jettag_c_if_425_17);
                                                                _jettag_f_message_426_1.setTagInfo(_td_f_message_426_1);
                                                                _jettag_f_message_426_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_426_1_saved_out = out;
                                                                while (_jettag_f_message_426_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_426_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_426_1_saved_out;
                                                                _jettag_f_message_426_1.doEnd();
                                                                out.write("\t  \t\t\t\t\t  \t\t \t\t\t\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\tpublic MultiSelectObj<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 427, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("> get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 427, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long entityID, String[] columns){");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\treturn null;");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_425_17.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_425_17.doEnd();
                                                            _jettag_c_if_418_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_418_16.doEnd();
                                                        _jettag_c_iterate_417_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_417_15.doEnd();
                                                    _jettag_c_if_415_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_415_14.doEnd();
                                                _jettag_c_if_413_11.handleBodyContent(out);
                                            }
                                            _jettag_c_if_413_11.doEnd();
                                            _jettag_c_if_412_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_412_9.doEnd();
                                        _jettag_c_if_410_13.handleBodyContent(out);
                                    }
                                    _jettag_c_if_410_13.doEnd();
                                    _jettag_c_iterate_407_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_407_12.doEnd();
                                _jettag_c_if_405_6.handleBodyContent(out);
                            }
                            _jettag_c_if_405_6.doEnd();
                            _jettag_c_iterate_402_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_402_3.doEnd();
                        _jettag_c_iterate_401_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_401_2.doEnd();
                    _jettag_c_iterate_400_1.handleBodyContent(out);
                }
                _jettag_c_iterate_400_1.doEnd();
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process all addAll relations
                RuntimeTagElement _jettag_c_iterate_445_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_445_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_445_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_445_1.setTagInfo(_td_c_iterate_445_1);
                _jettag_c_iterate_445_1.doStart(context, out);
                while (_jettag_c_iterate_445_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_446_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_446_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_446_2.setRuntimeParent(_jettag_c_iterate_445_1);
                    _jettag_c_iterate_446_2.setTagInfo(_td_c_iterate_446_2);
                    _jettag_c_iterate_446_2.doStart(context, out);
                    while (_jettag_c_iterate_446_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_447_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_447_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_447_3.setRuntimeParent(_jettag_c_iterate_446_2);
                        _jettag_c_iterate_447_3.setTagInfo(_td_c_iterate_447_3);
                        _jettag_c_iterate_447_3.doStart(context, out);
                        while (_jettag_c_iterate_447_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_448_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_448_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_448_4.setRuntimeParent(_jettag_c_iterate_447_3);
                            _jettag_c_setVariable_448_4.setTagInfo(_td_c_setVariable_448_4);
                            _jettag_c_setVariable_448_4.doStart(context, out);
                            _jettag_c_setVariable_448_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_450_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_450_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_450_6.setRuntimeParent(_jettag_c_iterate_447_3);
                            _jettag_c_if_450_6.setTagInfo(_td_c_if_450_6);
                            _jettag_c_if_450_6.doStart(context, out);
                            while (_jettag_c_if_450_6.okToProcessBody()) {
                                // process only classes with many on source side
                                RuntimeTagElement _jettag_c_if_452_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_452_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_452_6.setRuntimeParent(_jettag_c_if_450_6);
                                _jettag_c_if_452_6.setTagInfo(_td_c_if_452_6);
                                _jettag_c_if_452_6.doStart(context, out);
                                while (_jettag_c_if_452_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_453_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_453_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_453_8.setRuntimeParent(_jettag_c_if_452_6);
                                    _jettag_c_if_453_8.setTagInfo(_td_c_if_453_8);
                                    _jettag_c_if_453_8.doStart(context, out);
                                    while (_jettag_c_if_453_8.okToProcessBody()) {
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_455_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_455_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_455_12.setRuntimeParent(_jettag_c_if_453_8);
                                        _jettag_c_iterate_455_12.setTagInfo(_td_c_iterate_455_12);
                                        _jettag_c_iterate_455_12.doStart(context, out);
                                        while (_jettag_c_iterate_455_12.okToProcessBody()) {
                                            // process only non composites 
                                            RuntimeTagElement _jettag_c_if_457_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_457_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_457_12.setRuntimeParent(_jettag_c_iterate_455_12);
                                            _jettag_c_if_457_12.setTagInfo(_td_c_if_457_12);
                                            _jettag_c_if_457_12.doStart(context, out);
                                            while (_jettag_c_if_457_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_458_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_458_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_458_12.setRuntimeParent(_jettag_c_if_457_12);
                                                _jettag_c_setVariable_458_12.setTagInfo(_td_c_setVariable_458_12);
                                                _jettag_c_setVariable_458_12.doStart(context, out);
                                                _jettag_c_setVariable_458_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_460_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_460_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_460_14.setRuntimeParent(_jettag_c_if_457_12);
                                                _jettag_c_if_460_14.setTagInfo(_td_c_if_460_14);
                                                _jettag_c_if_460_14.doStart(context, out);
                                                while (_jettag_c_if_460_14.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_462_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_462_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_462_14.setRuntimeParent(_jettag_c_if_460_14);
                                                    _jettag_c_if_462_14.setTagInfo(_td_c_if_462_14);
                                                    _jettag_c_if_462_14.doStart(context, out);
                                                    while (_jettag_c_if_462_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_464_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_464_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_464_15.setRuntimeParent(_jettag_c_if_462_14);
                                                        _jettag_c_iterate_464_15.setTagInfo(_td_c_iterate_464_15);
                                                        _jettag_c_iterate_464_15.doStart(context, out);
                                                        while (_jettag_c_iterate_464_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_465_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_465_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_465_16.setRuntimeParent(_jettag_c_iterate_464_15);
                                                            _jettag_c_if_465_16.setTagInfo(_td_c_if_465_16);
                                                            _jettag_c_if_465_16.doStart(context, out);
                                                            while (_jettag_c_if_465_16.okToProcessBody()) {
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t//TODO fix this remove generics");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                RuntimeTagElement _jettag_f_message_467_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_467_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_467_1.setRuntimeParent(_jettag_c_if_465_16);
                                                                _jettag_f_message_467_1.setTagInfo(_td_f_message_467_1);
                                                                _jettag_f_message_467_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_467_1_saved_out = out;
                                                                while (_jettag_f_message_467_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_467_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_467_1_saved_out;
                                                                _jettag_f_message_467_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\tpublic void addAll(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 468, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 468, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(", ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 468, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" children,");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\tList<Long> ids) {\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t// find getter");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tMethod addMethod = null;");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tfor (Method method : ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 472, 33)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".getClass().getMethods()) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\tif (method.getName().equalsIgnoreCase(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\"add\" + children.getClass().getSimpleName())) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\taddMethod = method;");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 478, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" = em.find(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 478, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class,");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 478, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".getId());");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tfor (Long id : ids) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 480, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" child = (");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 480, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(") em.find(children.getClass(), id);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\tif (child == null) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"error find entity with id:\" + id");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \":on:\" + child.getClass().getName());");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\ttry {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\taddMethod.invoke(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 486, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(", child);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t} catch (Exception e) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\te.printStackTrace();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"error calling method:\"");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ addMethod.getName() + \":on:\"");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 491, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".getClass().getSimpleName());");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t} ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_465_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_465_16.doEnd();
                                                            _jettag_c_iterate_464_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_464_15.doEnd();
                                                        _jettag_c_if_462_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_462_14.doEnd();
                                                    _jettag_c_if_460_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_460_14.doEnd();
                                                _jettag_c_if_457_12.handleBodyContent(out);
                                            }
                                            _jettag_c_if_457_12.doEnd();
                                            _jettag_c_iterate_455_12.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_455_12.doEnd();
                                        _jettag_c_if_453_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_453_8.doEnd();
                                    _jettag_c_if_452_6.handleBodyContent(out);
                                }
                                _jettag_c_if_452_6.doEnd();
                                _jettag_c_if_450_6.handleBodyContent(out);
                            }
                            _jettag_c_if_450_6.doEnd();
                            _jettag_c_iterate_447_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_447_3.doEnd();
                        _jettag_c_iterate_446_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_446_2.doEnd();
                    _jettag_c_iterate_445_1.handleBodyContent(out);
                }
                _jettag_c_iterate_445_1.doEnd();
                out.write(NL);         
                // process all removeAll relations
                RuntimeTagElement _jettag_c_iterate_509_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_509_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_509_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_509_1.setTagInfo(_td_c_iterate_509_1);
                _jettag_c_iterate_509_1.doStart(context, out);
                while (_jettag_c_iterate_509_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_510_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_510_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_510_2.setRuntimeParent(_jettag_c_iterate_509_1);
                    _jettag_c_iterate_510_2.setTagInfo(_td_c_iterate_510_2);
                    _jettag_c_iterate_510_2.doStart(context, out);
                    while (_jettag_c_iterate_510_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_511_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_511_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_511_3.setRuntimeParent(_jettag_c_iterate_510_2);
                        _jettag_c_iterate_511_3.setTagInfo(_td_c_iterate_511_3);
                        _jettag_c_iterate_511_3.doStart(context, out);
                        while (_jettag_c_iterate_511_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_512_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_512_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_512_4.setRuntimeParent(_jettag_c_iterate_511_3);
                            _jettag_c_setVariable_512_4.setTagInfo(_td_c_setVariable_512_4);
                            _jettag_c_setVariable_512_4.doStart(context, out);
                            _jettag_c_setVariable_512_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_514_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_514_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_514_6.setRuntimeParent(_jettag_c_iterate_511_3);
                            _jettag_c_if_514_6.setTagInfo(_td_c_if_514_6);
                            _jettag_c_if_514_6.doStart(context, out);
                            while (_jettag_c_if_514_6.okToProcessBody()) {
                                // process only classes with many on source side
                                RuntimeTagElement _jettag_c_if_516_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_516_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_516_6.setRuntimeParent(_jettag_c_if_514_6);
                                _jettag_c_if_516_6.setTagInfo(_td_c_if_516_6);
                                _jettag_c_if_516_6.doStart(context, out);
                                while (_jettag_c_if_516_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_517_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_517_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_517_8.setRuntimeParent(_jettag_c_if_516_6);
                                    _jettag_c_if_517_8.setTagInfo(_td_c_if_517_8);
                                    _jettag_c_if_517_8.doStart(context, out);
                                    while (_jettag_c_if_517_8.okToProcessBody()) {
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_519_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_519_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_519_12.setRuntimeParent(_jettag_c_if_517_8);
                                        _jettag_c_iterate_519_12.setTagInfo(_td_c_iterate_519_12);
                                        _jettag_c_iterate_519_12.doStart(context, out);
                                        while (_jettag_c_iterate_519_12.okToProcessBody()) {
                                            // process only non composites 
                                            RuntimeTagElement _jettag_c_if_521_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_521_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_521_12.setRuntimeParent(_jettag_c_iterate_519_12);
                                            _jettag_c_if_521_12.setTagInfo(_td_c_if_521_12);
                                            _jettag_c_if_521_12.doStart(context, out);
                                            while (_jettag_c_if_521_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_522_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_522_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_522_12.setRuntimeParent(_jettag_c_if_521_12);
                                                _jettag_c_setVariable_522_12.setTagInfo(_td_c_setVariable_522_12);
                                                _jettag_c_setVariable_522_12.doStart(context, out);
                                                _jettag_c_setVariable_522_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_524_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_524_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_524_14.setRuntimeParent(_jettag_c_if_521_12);
                                                _jettag_c_if_524_14.setTagInfo(_td_c_if_524_14);
                                                _jettag_c_if_524_14.doStart(context, out);
                                                while (_jettag_c_if_524_14.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_526_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_526_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_526_14.setRuntimeParent(_jettag_c_if_524_14);
                                                    _jettag_c_if_526_14.setTagInfo(_td_c_if_526_14);
                                                    _jettag_c_if_526_14.doStart(context, out);
                                                    while (_jettag_c_if_526_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_528_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_528_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_528_15.setRuntimeParent(_jettag_c_if_526_14);
                                                        _jettag_c_iterate_528_15.setTagInfo(_td_c_iterate_528_15);
                                                        _jettag_c_iterate_528_15.doStart(context, out);
                                                        while (_jettag_c_iterate_528_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_529_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_529_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_529_16.setRuntimeParent(_jettag_c_iterate_528_15);
                                                            _jettag_c_if_529_16.setTagInfo(_td_c_if_529_16);
                                                            _jettag_c_if_529_16.doStart(context, out);
                                                            while (_jettag_c_if_529_16.okToProcessBody()) {
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t//TODO fix this remove generics");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                RuntimeTagElement _jettag_f_message_531_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_531_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_531_1.setRuntimeParent(_jettag_c_if_529_16);
                                                                _jettag_f_message_531_1.setTagInfo(_td_f_message_531_1);
                                                                _jettag_f_message_531_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_531_1_saved_out = out;
                                                                while (_jettag_f_message_531_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_531_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_531_1_saved_out;
                                                                _jettag_f_message_531_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\tpublic void removeAll(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 532, 33)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 532, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(", ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 532, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" children,");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\tList<Long> ids) {\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 534, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" = em.find(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 534, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class,");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 534, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".getId());");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tfor (Long id : ids) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 536, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" child = (");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 536, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(") em.find(children.getClass(), id);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\tif (child == null) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tthrow new RuntimeException(\"error find entity with id:\" + id");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \":on:\" + child.getClass().getName());");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 541, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 541, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s().remove(child);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t} ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_529_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_529_16.doEnd();
                                                            _jettag_c_iterate_528_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_528_15.doEnd();
                                                        _jettag_c_if_526_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_526_14.doEnd();
                                                    _jettag_c_if_524_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_524_14.doEnd();
                                                _jettag_c_if_521_12.handleBodyContent(out);
                                            }
                                            _jettag_c_if_521_12.doEnd();
                                            _jettag_c_iterate_519_12.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_519_12.doEnd();
                                        _jettag_c_if_517_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_517_8.doEnd();
                                    _jettag_c_if_516_6.handleBodyContent(out);
                                }
                                _jettag_c_if_516_6.doEnd();
                                _jettag_c_if_514_6.handleBodyContent(out);
                            }
                            _jettag_c_if_514_6.doEnd();
                            _jettag_c_iterate_511_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_511_3.doEnd();
                        _jettag_c_iterate_510_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_510_2.doEnd();
                    _jettag_c_iterate_509_1.handleBodyContent(out);
                }
                _jettag_c_iterate_509_1.doEnd();
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
