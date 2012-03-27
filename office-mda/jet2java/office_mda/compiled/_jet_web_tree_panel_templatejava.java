package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_tree_panel_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_tree_panel_templatejava() {
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
    private static final TagInfo _td_c_setVariable_5_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            5, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_21_1 = new TagInfo("c:if", //$NON-NLS-1$
            21, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_22_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            22, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_25_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            25, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_26_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            26, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_27_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            27, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_28_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            28, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_30_14 = new TagInfo("c:if", //$NON-NLS-1$
            30, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_32_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            32, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_34_18 = new TagInfo("c:if", //$NON-NLS-1$
            34, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_35_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            35, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_37_21 = new TagInfo("c:if", //$NON-NLS-1$
            37, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_39_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            39, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_40_23 = new TagInfo("c:if", //$NON-NLS-1$
            40, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_56_1 = new TagInfo("c:if", //$NON-NLS-1$
            56, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_57_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            57, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_60_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            60, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_61_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            61, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_62_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            62, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_63_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            63, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_65_14 = new TagInfo("c:if", //$NON-NLS-1$
            65, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_67_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            67, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_69_18 = new TagInfo("c:if", //$NON-NLS-1$
            69, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_70_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            70, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_72_21 = new TagInfo("c:if", //$NON-NLS-1$
            72, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_74_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            74, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_75_23 = new TagInfo("c:if", //$NON-NLS-1$
            75, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_91_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            91, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_93_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            93, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_94_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            94, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_95_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            95, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_96_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            96, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_98_6 = new TagInfo("c:if", //$NON-NLS-1$
            98, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_100_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            100, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_102_11 = new TagInfo("c:if", //$NON-NLS-1$
            102, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_103_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            103, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_105_14 = new TagInfo("c:if", //$NON-NLS-1$
            105, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_107_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            107, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_108_16 = new TagInfo("c:if", //$NON-NLS-1$
            108, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_125_1 = new TagInfo("f:message", //$NON-NLS-1$
            125, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_choose_126_47 = new TagInfo("c:choose", //$NON-NLS-1$
            126, 47,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_126_88 = new TagInfo("c:when", //$NON-NLS-1$
            126, 88,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_126_164 = new TagInfo("c:otherwise", //$NON-NLS-1$
            126, 164,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_127_1 = new TagInfo("f:message", //$NON-NLS-1$
            127, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_129_1 = new TagInfo("f:message", //$NON-NLS-1$
            129, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_133_1 = new TagInfo("f:message", //$NON-NLS-1$
            133, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_138_1 = new TagInfo("f:message", //$NON-NLS-1$
            138, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_144_1 = new TagInfo("f:message", //$NON-NLS-1$
            144, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_150_1 = new TagInfo("f:message", //$NON-NLS-1$
            150, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_156_1 = new TagInfo("f:message", //$NON-NLS-1$
            156, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_162_1 = new TagInfo("f:message", //$NON-NLS-1$
            162, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_167_1 = new TagInfo("c:if", //$NON-NLS-1$
            167, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_168_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            168, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_170_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            170, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_171_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            171, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_172_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            172, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_173_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            173, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_175_13 = new TagInfo("c:if", //$NON-NLS-1$
            175, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_177_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            177, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_179_18 = new TagInfo("c:if", //$NON-NLS-1$
            179, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_180_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            180, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_182_21 = new TagInfo("c:if", //$NON-NLS-1$
            182, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_184_19 = new TagInfo("c:if", //$NON-NLS-1$
            184, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_186_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            186, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_187_23 = new TagInfo("c:if", //$NON-NLS-1$
            187, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_190_19 = new TagInfo("c:if", //$NON-NLS-1$
            190, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_209_19 = new TagInfo("c:if", //$NON-NLS-1$
            209, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_211_20 = new TagInfo("c:iterate", //$NON-NLS-1$
            211, 20,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_213_22 = new TagInfo("c:choose", //$NON-NLS-1$
            213, 22,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_213_92 = new TagInfo("c:when", //$NON-NLS-1$
            213, 92,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_243_1 = new TagInfo("c:if", //$NON-NLS-1$
            243, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_244_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            244, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_246_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            246, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_247_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            247, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_248_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            248, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_249_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            249, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_251_13 = new TagInfo("c:if", //$NON-NLS-1$
            251, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_253_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            253, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_255_18 = new TagInfo("c:if", //$NON-NLS-1$
            255, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_256_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            256, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_258_21 = new TagInfo("c:if", //$NON-NLS-1$
            258, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_260_19 = new TagInfo("c:if", //$NON-NLS-1$
            260, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_262_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            262, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_263_23 = new TagInfo("c:if", //$NON-NLS-1$
            263, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_266_19 = new TagInfo("c:if", //$NON-NLS-1$
            266, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_285_19 = new TagInfo("c:if", //$NON-NLS-1$
            285, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_287_20 = new TagInfo("c:iterate", //$NON-NLS-1$
            287, 20,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_289_22 = new TagInfo("c:choose", //$NON-NLS-1$
            289, 22,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_289_92 = new TagInfo("c:when", //$NON-NLS-1$
            289, 92,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_320_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            320, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_322_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            322, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_323_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            323, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_324_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            324, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_325_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            325, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_327_6 = new TagInfo("c:if", //$NON-NLS-1$
            327, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_329_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            329, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_331_12 = new TagInfo("c:if", //$NON-NLS-1$
            331, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_332_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            332, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_334_14 = new TagInfo("c:if", //$NON-NLS-1$
            334, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_336_14 = new TagInfo("c:if", //$NON-NLS-1$
            336, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_338_9 = new TagInfo("c:if", //$NON-NLS-1$
            338, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_339_11 = new TagInfo("c:if", //$NON-NLS-1$
            339, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_341_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            341, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_342_16 = new TagInfo("c:if", //$NON-NLS-1$
            342, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_345_19 = new TagInfo("c:if", //$NON-NLS-1$
            345, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_364_19 = new TagInfo("c:if", //$NON-NLS-1$
            364, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_366_20 = new TagInfo("c:iterate", //$NON-NLS-1$
            366, 20,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_368_22 = new TagInfo("c:choose", //$NON-NLS-1$
            368, 22,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_368_92 = new TagInfo("c:when", //$NON-NLS-1$
            368, 92,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_399_1 = new TagInfo("f:message", //$NON-NLS-1$
            399, 1,
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
                RuntimeTagElement _jettag_c_setVariable_5_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_5_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_5_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_5_1.setTagInfo(_td_c_setVariable_5_1);
                _jettag_c_setVariable_5_1.doStart(context, out);
                _jettag_c_setVariable_5_1.doEnd();
                out.write(NL);         
                out.write(NL);         
                out.write("package ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 8, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 8, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 9, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 9, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 9, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 10, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 10, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.TreePanelComposite;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.widgets.ClickableLink;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.beans.MultiSelectObj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.Window;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.OptionsComposite.OptionsCompositeType;\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write(NL);         
                //process level 1 generizations 
                RuntimeTagElement _jettag_c_if_21_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_21_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_21_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_21_1.setTagInfo(_td_c_if_21_1);
                _jettag_c_if_21_1.doStart(context, out);
                while (_jettag_c_if_21_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_22_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_22_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_22_6.setRuntimeParent(_jettag_c_if_21_1);
                    _jettag_c_setVariable_22_6.setTagInfo(_td_c_setVariable_22_6);
                    _jettag_c_setVariable_22_6.doStart(context, out);
                    _jettag_c_setVariable_22_6.doEnd();
                    out.write("  \t\t\timport ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$groupID}", 23, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".client.");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 23, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($parentClass1/@name)}", 23, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".TreeAbstract");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$parentClass1/@name}", 23, 109)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Panel;");  //$NON-NLS-1$        
                    out.write(NL);         
                    // process the assocations for level 1 class 
                    RuntimeTagElement _jettag_c_iterate_25_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_25_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_25_8.setRuntimeParent(_jettag_c_if_21_1);
                    _jettag_c_iterate_25_8.setTagInfo(_td_c_iterate_25_8);
                    _jettag_c_iterate_25_8.doStart(context, out);
                    while (_jettag_c_iterate_25_8.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_26_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_26_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_26_9.setRuntimeParent(_jettag_c_iterate_25_8);
                        _jettag_c_iterate_26_9.setTagInfo(_td_c_iterate_26_9);
                        _jettag_c_iterate_26_9.doStart(context, out);
                        while (_jettag_c_iterate_26_9.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_27_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_27_10); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_27_10.setRuntimeParent(_jettag_c_iterate_26_9);
                            _jettag_c_iterate_27_10.setTagInfo(_td_c_iterate_27_10);
                            _jettag_c_iterate_27_10.doStart(context, out);
                            while (_jettag_c_iterate_27_10.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_28_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_28_11); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_28_11.setRuntimeParent(_jettag_c_iterate_27_10);
                                _jettag_c_setVariable_28_11.setTagInfo(_td_c_setVariable_28_11);
                                _jettag_c_setVariable_28_11.doStart(context, out);
                                _jettag_c_setVariable_28_11.doEnd();
                                // process only compositions or aggegations
                                RuntimeTagElement _jettag_c_if_30_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_30_14); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_30_14.setRuntimeParent(_jettag_c_iterate_27_10);
                                _jettag_c_if_30_14.setTagInfo(_td_c_if_30_14);
                                _jettag_c_if_30_14.doStart(context, out);
                                while (_jettag_c_if_30_14.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_32_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_32_19); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_32_19.setRuntimeParent(_jettag_c_if_30_14);
                                    _jettag_c_iterate_32_19.setTagInfo(_td_c_iterate_32_19);
                                    _jettag_c_iterate_32_19.doStart(context, out);
                                    while (_jettag_c_iterate_32_19.okToProcessBody()) {
                                        // process only non composits or non aggregations and 
                                        RuntimeTagElement _jettag_c_if_34_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_34_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_34_18.setRuntimeParent(_jettag_c_iterate_32_19);
                                        _jettag_c_if_34_18.setTagInfo(_td_c_if_34_18);
                                        _jettag_c_if_34_18.doStart(context, out);
                                        while (_jettag_c_if_34_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_35_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_35_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_35_19.setRuntimeParent(_jettag_c_if_34_18);
                                            _jettag_c_setVariable_35_19.setTagInfo(_td_c_setVariable_35_19);
                                            _jettag_c_setVariable_35_19.doStart(context, out);
                                            _jettag_c_setVariable_35_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_37_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_37_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_37_21.setRuntimeParent(_jettag_c_if_34_18);
                                            _jettag_c_if_37_21.setTagInfo(_td_c_if_37_21);
                                            _jettag_c_if_37_21.doStart(context, out);
                                            while (_jettag_c_if_37_21.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_39_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_39_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_39_22.setRuntimeParent(_jettag_c_if_37_21);
                                                _jettag_c_iterate_39_22.setTagInfo(_td_c_iterate_39_22);
                                                _jettag_c_iterate_39_22.doStart(context, out);
                                                while (_jettag_c_iterate_39_22.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_40_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_40_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_40_23.setRuntimeParent(_jettag_c_iterate_39_22);
                                                    _jettag_c_if_40_23.setTagInfo(_td_c_if_40_23);
                                                    _jettag_c_if_40_23.doStart(context, out);
                                                    while (_jettag_c_if_40_23.okToProcessBody()) {
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 41, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entity.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 41, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 41, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 42, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 42, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 42, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".ReadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 42, 115)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sPanel;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 43, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 43, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 43, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 43, 108)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("OptionsPanel;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 44, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 44, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 44, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".Select");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 44, 114)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Panel;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_40_23.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_40_23.doEnd();
                                                    _jettag_c_iterate_39_22.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_39_22.doEnd();
                                                _jettag_c_if_37_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_37_21.doEnd();
                                            _jettag_c_if_34_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_34_18.doEnd();
                                        _jettag_c_iterate_32_19.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_32_19.doEnd();
                                    _jettag_c_if_30_14.handleBodyContent(out);
                                }
                                _jettag_c_if_30_14.doEnd();
                                _jettag_c_iterate_27_10.handleBodyContent(out);
                            }
                            _jettag_c_iterate_27_10.doEnd();
                            _jettag_c_iterate_26_9.handleBodyContent(out);
                        }
                        _jettag_c_iterate_26_9.doEnd();
                        _jettag_c_iterate_25_8.handleBodyContent(out);
                    }
                    _jettag_c_iterate_25_8.doEnd();
                    _jettag_c_if_21_1.handleBodyContent(out);
                }
                _jettag_c_if_21_1.doEnd();
                //process level 2 generizations 
                RuntimeTagElement _jettag_c_if_56_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_56_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_56_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_56_1.setTagInfo(_td_c_if_56_1);
                _jettag_c_if_56_1.doStart(context, out);
                while (_jettag_c_if_56_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_57_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_57_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_57_6.setRuntimeParent(_jettag_c_if_56_1);
                    _jettag_c_setVariable_57_6.setTagInfo(_td_c_setVariable_57_6);
                    _jettag_c_setVariable_57_6.doStart(context, out);
                    _jettag_c_setVariable_57_6.doEnd();
                    out.write("  \t\t\timport ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$groupID}", 58, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".client.");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 58, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($parentClass2/@name)}", 58, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".TreeAbstract");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$parentClass2/@name}", 58, 109)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Panel;");  //$NON-NLS-1$        
                    out.write(NL);         
                    // process the assocations for level 2 class 
                    RuntimeTagElement _jettag_c_iterate_60_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_60_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_60_8.setRuntimeParent(_jettag_c_if_56_1);
                    _jettag_c_iterate_60_8.setTagInfo(_td_c_iterate_60_8);
                    _jettag_c_iterate_60_8.doStart(context, out);
                    while (_jettag_c_iterate_60_8.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_61_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_61_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_61_9.setRuntimeParent(_jettag_c_iterate_60_8);
                        _jettag_c_iterate_61_9.setTagInfo(_td_c_iterate_61_9);
                        _jettag_c_iterate_61_9.doStart(context, out);
                        while (_jettag_c_iterate_61_9.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_62_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_62_10); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_62_10.setRuntimeParent(_jettag_c_iterate_61_9);
                            _jettag_c_iterate_62_10.setTagInfo(_td_c_iterate_62_10);
                            _jettag_c_iterate_62_10.doStart(context, out);
                            while (_jettag_c_iterate_62_10.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_63_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_63_11); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_63_11.setRuntimeParent(_jettag_c_iterate_62_10);
                                _jettag_c_setVariable_63_11.setTagInfo(_td_c_setVariable_63_11);
                                _jettag_c_setVariable_63_11.doStart(context, out);
                                _jettag_c_setVariable_63_11.doEnd();
                                // process only compositions or aggegations
                                RuntimeTagElement _jettag_c_if_65_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_65_14); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_65_14.setRuntimeParent(_jettag_c_iterate_62_10);
                                _jettag_c_if_65_14.setTagInfo(_td_c_if_65_14);
                                _jettag_c_if_65_14.doStart(context, out);
                                while (_jettag_c_if_65_14.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_67_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_67_19); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_67_19.setRuntimeParent(_jettag_c_if_65_14);
                                    _jettag_c_iterate_67_19.setTagInfo(_td_c_iterate_67_19);
                                    _jettag_c_iterate_67_19.doStart(context, out);
                                    while (_jettag_c_iterate_67_19.okToProcessBody()) {
                                        // process only non composits or non aggregations and 
                                        RuntimeTagElement _jettag_c_if_69_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_69_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_69_18.setRuntimeParent(_jettag_c_iterate_67_19);
                                        _jettag_c_if_69_18.setTagInfo(_td_c_if_69_18);
                                        _jettag_c_if_69_18.doStart(context, out);
                                        while (_jettag_c_if_69_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_70_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_70_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_70_19.setRuntimeParent(_jettag_c_if_69_18);
                                            _jettag_c_setVariable_70_19.setTagInfo(_td_c_setVariable_70_19);
                                            _jettag_c_setVariable_70_19.doStart(context, out);
                                            _jettag_c_setVariable_70_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_72_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_72_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_72_21.setRuntimeParent(_jettag_c_if_69_18);
                                            _jettag_c_if_72_21.setTagInfo(_td_c_if_72_21);
                                            _jettag_c_if_72_21.doStart(context, out);
                                            while (_jettag_c_if_72_21.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_74_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_74_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_74_22.setRuntimeParent(_jettag_c_if_72_21);
                                                _jettag_c_iterate_74_22.setTagInfo(_td_c_iterate_74_22);
                                                _jettag_c_iterate_74_22.doStart(context, out);
                                                while (_jettag_c_iterate_74_22.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_75_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_75_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_75_23.setRuntimeParent(_jettag_c_iterate_74_22);
                                                    _jettag_c_if_75_23.setTagInfo(_td_c_if_75_23);
                                                    _jettag_c_if_75_23.doStart(context, out);
                                                    while (_jettag_c_if_75_23.okToProcessBody()) {
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 76, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entity.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 76, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 76, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 77, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 77, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 77, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".ReadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 77, 115)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sPanel;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 78, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 78, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 78, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 78, 108)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("OptionsPanel;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 79, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 79, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 79, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".Select");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 79, 114)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Panel;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_75_23.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_75_23.doEnd();
                                                    _jettag_c_iterate_74_22.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_74_22.doEnd();
                                                _jettag_c_if_72_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_72_21.doEnd();
                                            _jettag_c_if_69_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_69_18.doEnd();
                                        _jettag_c_iterate_67_19.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_67_19.doEnd();
                                    _jettag_c_if_65_14.handleBodyContent(out);
                                }
                                _jettag_c_if_65_14.doEnd();
                                _jettag_c_iterate_62_10.handleBodyContent(out);
                            }
                            _jettag_c_iterate_62_10.doEnd();
                            _jettag_c_iterate_61_9.handleBodyContent(out);
                        }
                        _jettag_c_iterate_61_9.doEnd();
                        _jettag_c_iterate_60_8.handleBodyContent(out);
                    }
                    _jettag_c_iterate_60_8.doEnd();
                    _jettag_c_if_56_1.handleBodyContent(out);
                }
                _jettag_c_if_56_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_c_setVariable_91_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_91_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_91_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_91_1.setTagInfo(_td_c_setVariable_91_1);
                _jettag_c_setVariable_91_1.doStart(context, out);
                _jettag_c_setVariable_91_1.doEnd();
                //process 0 level class relations 
                RuntimeTagElement _jettag_c_iterate_93_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_93_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_93_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_93_1.setTagInfo(_td_c_iterate_93_1);
                _jettag_c_iterate_93_1.doStart(context, out);
                while (_jettag_c_iterate_93_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_94_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_94_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_94_2.setRuntimeParent(_jettag_c_iterate_93_1);
                    _jettag_c_iterate_94_2.setTagInfo(_td_c_iterate_94_2);
                    _jettag_c_iterate_94_2.doStart(context, out);
                    while (_jettag_c_iterate_94_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_95_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_95_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_95_3.setRuntimeParent(_jettag_c_iterate_94_2);
                        _jettag_c_iterate_95_3.setTagInfo(_td_c_iterate_95_3);
                        _jettag_c_iterate_95_3.doStart(context, out);
                        while (_jettag_c_iterate_95_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_96_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_96_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_96_4.setRuntimeParent(_jettag_c_iterate_95_3);
                            _jettag_c_setVariable_96_4.setTagInfo(_td_c_setVariable_96_4);
                            _jettag_c_setVariable_96_4.doStart(context, out);
                            _jettag_c_setVariable_96_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_98_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_98_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_98_6.setRuntimeParent(_jettag_c_iterate_95_3);
                            _jettag_c_if_98_6.setTagInfo(_td_c_if_98_6);
                            _jettag_c_if_98_6.doStart(context, out);
                            while (_jettag_c_if_98_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_100_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_100_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_100_12.setRuntimeParent(_jettag_c_if_98_6);
                                _jettag_c_iterate_100_12.setTagInfo(_td_c_iterate_100_12);
                                _jettag_c_iterate_100_12.doStart(context, out);
                                while (_jettag_c_iterate_100_12.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_102_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_102_11); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_102_11.setRuntimeParent(_jettag_c_iterate_100_12);
                                    _jettag_c_if_102_11.setTagInfo(_td_c_if_102_11);
                                    _jettag_c_if_102_11.doStart(context, out);
                                    while (_jettag_c_if_102_11.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_103_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_103_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_103_12.setRuntimeParent(_jettag_c_if_102_11);
                                        _jettag_c_setVariable_103_12.setTagInfo(_td_c_setVariable_103_12);
                                        _jettag_c_setVariable_103_12.doStart(context, out);
                                        _jettag_c_setVariable_103_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_105_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_105_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_105_14.setRuntimeParent(_jettag_c_if_102_11);
                                        _jettag_c_if_105_14.setTagInfo(_td_c_if_105_14);
                                        _jettag_c_if_105_14.doStart(context, out);
                                        while (_jettag_c_if_105_14.okToProcessBody()) {
                                            // iterate throught all the classes to get the other class on the association
                                            RuntimeTagElement _jettag_c_iterate_107_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_107_15); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_107_15.setRuntimeParent(_jettag_c_if_105_14);
                                            _jettag_c_iterate_107_15.setTagInfo(_td_c_iterate_107_15);
                                            _jettag_c_iterate_107_15.doStart(context, out);
                                            while (_jettag_c_iterate_107_15.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_108_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_108_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_108_16.setRuntimeParent(_jettag_c_iterate_107_15);
                                                _jettag_c_if_108_16.setTagInfo(_td_c_if_108_16);
                                                _jettag_c_if_108_16.doStart(context, out);
                                                while (_jettag_c_if_108_16.okToProcessBody()) {
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 109, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".entity.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 109, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 109, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 110, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".client.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 110, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 110, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".ReadAll");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 110, 109)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("sPanel;");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 111, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".client.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 111, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 111, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 111, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("OptionsPanel;");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 112, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".client.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 112, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 112, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".Select");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 112, 108)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("Panel;");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_108_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_108_16.doEnd();
                                                _jettag_c_iterate_107_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_107_15.doEnd();
                                            _jettag_c_if_105_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_105_14.doEnd();
                                        _jettag_c_if_102_11.handleBodyContent(out);
                                    }
                                    _jettag_c_if_102_11.doEnd();
                                    _jettag_c_iterate_100_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_100_12.doEnd();
                                _jettag_c_if_98_6.handleBodyContent(out);
                            }
                            _jettag_c_if_98_6.doEnd();
                            _jettag_c_iterate_95_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_95_3.doEnd();
                        _jettag_c_iterate_94_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_94_2.doEnd();
                    _jettag_c_iterate_93_1.handleBodyContent(out);
                }
                _jettag_c_iterate_93_1.doEnd();
                out.write("import com.google.gwt.event.dom.client.ClickEvent;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.DockPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.TreeItem;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_125_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_125_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_125_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_125_1.setTagInfo(_td_f_message_125_1);
                _jettag_f_message_125_1.doStart(context, out);
                JET2Writer _jettag_f_message_125_1_saved_out = out;
                while (_jettag_f_message_125_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_125_1.handleBodyContent(out);
                }
                out = _jettag_f_message_125_1_saved_out;
                _jettag_f_message_125_1.doEnd();
                out.write(NL);         
                out.write("public class Tree");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 126, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel extends ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_choose_126_47 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_126_47); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_126_47.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_choose_126_47.setTagInfo(_td_c_choose_126_47);
                _jettag_c_choose_126_47.doStart(context, out);
                JET2Writer _jettag_c_choose_126_47_saved_out = out;
                while (_jettag_c_choose_126_47.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(" ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_126_88 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_126_88); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_126_88.setRuntimeParent(_jettag_c_choose_126_47);
                    _jettag_c_when_126_88.setTagInfo(_td_c_when_126_88);
                    _jettag_c_when_126_88.doStart(context, out);
                    JET2Writer _jettag_c_when_126_88_saved_out = out;
                    while (_jettag_c_when_126_88.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" TreePanelComposite<");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$class/@name}", 126, 137)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("> ");  //$NON-NLS-1$        
                        _jettag_c_when_126_88.handleBodyContent(out);
                    }
                    out = _jettag_c_when_126_88_saved_out;
                    _jettag_c_when_126_88.doEnd();
                    out.write(" ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_otherwise_126_164 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_126_164); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_126_164.setRuntimeParent(_jettag_c_choose_126_47);
                    _jettag_c_otherwise_126_164.setTagInfo(_td_c_otherwise_126_164);
                    _jettag_c_otherwise_126_164.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_126_164_saved_out = out;
                    while (_jettag_c_otherwise_126_164.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" TreeAbstract");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$parentClass1/@name}", 126, 190)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("Panel");  //$NON-NLS-1$        
                        _jettag_c_otherwise_126_164.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_126_164_saved_out;
                    _jettag_c_otherwise_126_164.doEnd();
                    out.write("  ");  //$NON-NLS-1$        
                    _jettag_c_choose_126_47.handleBodyContent(out);
                }
                out = _jettag_c_choose_126_47_saved_out;
                _jettag_c_choose_126_47.doEnd();
                out.write(" {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_127_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_127_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_127_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_127_1.setTagInfo(_td_f_message_127_1);
                _jettag_f_message_127_1.doStart(context, out);
                JET2Writer _jettag_f_message_127_1_saved_out = out;
                while (_jettag_f_message_127_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_127_1.handleBodyContent(out);
                }
                out = _jettag_f_message_127_1_saved_out;
                _jettag_f_message_127_1.doEnd();
                out.write(NL);         
                out.write("\tprivate static Tree");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 128, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel instance;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_129_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_129_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_129_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_129_1.setTagInfo(_td_f_message_129_1);
                _jettag_f_message_129_1.doStart(context, out);
                JET2Writer _jettag_f_message_129_1_saved_out = out;
                while (_jettag_f_message_129_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_129_1.handleBodyContent(out);
                }
                out = _jettag_f_message_129_1_saved_out;
                _jettag_f_message_129_1.doEnd();
                out.write(NL);         
                out.write("\tpublic static Tree");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 130, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel instance() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn instance;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_133_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_133_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_133_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_133_1.setTagInfo(_td_f_message_133_1);
                _jettag_f_message_133_1.doStart(context, out);
                JET2Writer _jettag_f_message_133_1_saved_out = out;
                while (_jettag_f_message_133_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_133_1.handleBodyContent(out);
                }
                out = _jettag_f_message_133_1_saved_out;
                _jettag_f_message_133_1.doEnd();
                out.write(NL);         
                out.write("\tpublic Tree");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 134, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinstance=this;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitTreePanelComposite(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 136, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getName());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_138_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_138_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_138_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_138_1.setTagInfo(_td_f_message_138_1);
                _jettag_f_message_138_1.doStart(context, out);
                JET2Writer _jettag_f_message_138_1_saved_out = out;
                while (_jettag_f_message_138_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_138_1.handleBodyContent(out);
                }
                out = _jettag_f_message_138_1_saved_out;
                _jettag_f_message_138_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_144_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_144_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_144_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_144_1.setTagInfo(_td_f_message_144_1);
                _jettag_f_message_144_1.doStart(context, out);
                JET2Writer _jettag_f_message_144_1_saved_out = out;
                while (_jettag_f_message_144_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_144_1.handleBodyContent(out);
                }
                out = _jettag_f_message_144_1_saved_out;
                _jettag_f_message_144_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_150_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_150_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_150_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_150_1.setTagInfo(_td_f_message_150_1);
                _jettag_f_message_150_1.doStart(context, out);
                JET2Writer _jettag_f_message_150_1_saved_out = out;
                while (_jettag_f_message_150_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_150_1.handleBodyContent(out);
                }
                out = _jettag_f_message_150_1_saved_out;
                _jettag_f_message_150_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_156_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_156_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_156_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_156_1.setTagInfo(_td_f_message_156_1);
                _jettag_f_message_156_1.doStart(context, out);
                JET2Writer _jettag_f_message_156_1_saved_out = out;
                while (_jettag_f_message_156_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_156_1.handleBodyContent(out);
                }
                out = _jettag_f_message_156_1_saved_out;
                _jettag_f_message_156_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 158, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" loadEntity() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 159, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel.instance().getEntity();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_162_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_162_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_162_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_162_1.setTagInfo(_td_f_message_162_1);
                _jettag_f_message_162_1.doStart(context, out);
                JET2Writer _jettag_f_message_162_1_saved_out = out;
                while (_jettag_f_message_162_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_162_1.handleBodyContent(out);
                }
                out = _jettag_f_message_162_1_saved_out;
                _jettag_f_message_162_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void treeNodeSelected(final String link) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                //process level 1 generizations 
                RuntimeTagElement _jettag_c_if_167_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_167_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_167_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_167_1.setTagInfo(_td_c_if_167_1);
                _jettag_c_if_167_1.doStart(context, out);
                while (_jettag_c_if_167_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_168_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_168_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_168_6.setRuntimeParent(_jettag_c_if_167_1);
                    _jettag_c_setVariable_168_6.setTagInfo(_td_c_setVariable_168_6);
                    _jettag_c_setVariable_168_6.doStart(context, out);
                    _jettag_c_setVariable_168_6.doEnd();
                    // process the assocations for level 1 class 
                    RuntimeTagElement _jettag_c_iterate_170_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_170_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_170_8.setRuntimeParent(_jettag_c_if_167_1);
                    _jettag_c_iterate_170_8.setTagInfo(_td_c_iterate_170_8);
                    _jettag_c_iterate_170_8.doStart(context, out);
                    while (_jettag_c_iterate_170_8.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_171_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_171_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_171_9.setRuntimeParent(_jettag_c_iterate_170_8);
                        _jettag_c_iterate_171_9.setTagInfo(_td_c_iterate_171_9);
                        _jettag_c_iterate_171_9.doStart(context, out);
                        while (_jettag_c_iterate_171_9.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_172_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_172_10); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_172_10.setRuntimeParent(_jettag_c_iterate_171_9);
                            _jettag_c_iterate_172_10.setTagInfo(_td_c_iterate_172_10);
                            _jettag_c_iterate_172_10.doStart(context, out);
                            while (_jettag_c_iterate_172_10.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_173_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_173_11); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_173_11.setRuntimeParent(_jettag_c_iterate_172_10);
                                _jettag_c_setVariable_173_11.setTagInfo(_td_c_setVariable_173_11);
                                _jettag_c_setVariable_173_11.doStart(context, out);
                                _jettag_c_setVariable_173_11.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_175_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_175_13); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_175_13.setRuntimeParent(_jettag_c_iterate_172_10);
                                _jettag_c_if_175_13.setTagInfo(_td_c_if_175_13);
                                _jettag_c_if_175_13.doStart(context, out);
                                while (_jettag_c_if_175_13.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_177_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_177_19); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_177_19.setRuntimeParent(_jettag_c_if_175_13);
                                    _jettag_c_iterate_177_19.setTagInfo(_td_c_iterate_177_19);
                                    _jettag_c_iterate_177_19.doStart(context, out);
                                    while (_jettag_c_iterate_177_19.okToProcessBody()) {
                                        // process only non composits or non aggregations and 
                                        RuntimeTagElement _jettag_c_if_179_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_179_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_179_18.setRuntimeParent(_jettag_c_iterate_177_19);
                                        _jettag_c_if_179_18.setTagInfo(_td_c_if_179_18);
                                        _jettag_c_if_179_18.doStart(context, out);
                                        while (_jettag_c_if_179_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_180_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_180_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_180_19.setRuntimeParent(_jettag_c_if_179_18);
                                            _jettag_c_setVariable_180_19.setTagInfo(_td_c_setVariable_180_19);
                                            _jettag_c_setVariable_180_19.doStart(context, out);
                                            _jettag_c_setVariable_180_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_182_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_182_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_182_21.setRuntimeParent(_jettag_c_if_179_18);
                                            _jettag_c_if_182_21.setTagInfo(_td_c_if_182_21);
                                            _jettag_c_if_182_21.doStart(context, out);
                                            while (_jettag_c_if_182_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_184_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_184_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_184_19.setRuntimeParent(_jettag_c_if_182_21);
                                                _jettag_c_if_184_19.setTagInfo(_td_c_if_184_19);
                                                _jettag_c_if_184_19.doStart(context, out);
                                                while (_jettag_c_if_184_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_186_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_186_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_186_22.setRuntimeParent(_jettag_c_if_184_19);
                                                    _jettag_c_iterate_186_22.setTagInfo(_td_c_iterate_186_22);
                                                    _jettag_c_iterate_186_22.doStart(context, out);
                                                    while (_jettag_c_iterate_186_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_187_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_187_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_187_23.setRuntimeParent(_jettag_c_iterate_186_22);
                                                        _jettag_c_if_187_23.setTagInfo(_td_c_if_187_23);
                                                        _jettag_c_if_187_23.doStart(context, out);
                                                        while (_jettag_c_if_187_23.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\tif (");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 188, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".class.getName().contains(link)) {");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            //for composite add 
                                                            RuntimeTagElement _jettag_c_if_190_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_190_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_190_19.setRuntimeParent(_jettag_c_if_187_23);
                                                            _jettag_c_if_190_19.setTagInfo(_td_c_if_190_19);
                                                            _jettag_c_if_190_19.doStart(context, out);
                                                            while (_jettag_c_if_190_19.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$packageName}", 191, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 191, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 191, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Service.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 191, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("ServiceAsync.instance().get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 191, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tentity.getId(),new ALAsyncCallback<List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 192, 60)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(">>() {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 194, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("> arg0) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tReadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 195, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel readAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 195, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel= new ReadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 195, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel(arg0);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\treadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 196, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel.parentTree = Tree");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 196, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panel.this;");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\treadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 197, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel.parentTreeClass = link;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 198, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.clear();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 200, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel().add(readAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 200, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 201, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tnew ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 202, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("OptionsPanel(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOptionsCompositeType.ADD));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_190_19.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_190_19.doEnd();
                                                            //for non composite add_all 
                                                            RuntimeTagElement _jettag_c_if_209_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_209_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_209_19.setRuntimeParent(_jettag_c_if_187_23);
                                                            _jettag_c_if_209_19.setTagInfo(_td_c_if_209_19);
                                                            _jettag_c_if_209_19.doStart(context, out);
                                                            while (_jettag_c_if_209_19.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tString[] ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 210, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Columns = { ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                RuntimeTagElement _jettag_c_iterate_211_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_211_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_iterate_211_20.setRuntimeParent(_jettag_c_if_209_19);
                                                                _jettag_c_iterate_211_20.setTagInfo(_td_c_iterate_211_20);
                                                                _jettag_c_iterate_211_20.doStart(context, out);
                                                                while (_jettag_c_iterate_211_20.okToProcessBody()) {
                                                                    // processes the premitive Datatypes 
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_c_choose_213_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_213_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_c_choose_213_22.setRuntimeParent(_jettag_c_iterate_211_20);
                                                                    _jettag_c_choose_213_22.setTagInfo(_td_c_choose_213_22);
                                                                    _jettag_c_choose_213_22.doStart(context, out);
                                                                    JET2Writer _jettag_c_choose_213_22_saved_out = out;
                                                                    while (_jettag_c_choose_213_22.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write(" ");  //$NON-NLS-1$        
                                                                        RuntimeTagElement _jettag_c_when_213_92 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_213_92); //$NON-NLS-1$ //$NON-NLS-2$
                                                                        _jettag_c_when_213_92.setRuntimeParent(_jettag_c_choose_213_22);
                                                                        _jettag_c_when_213_92.setTagInfo(_td_c_when_213_92);
                                                                        _jettag_c_when_213_92.doStart(context, out);
                                                                        JET2Writer _jettag_c_when_213_92_saved_out = out;
                                                                        while (_jettag_c_when_213_92.okToProcessBody()) {
                                                                            out = out.newNestedContentWriter();
                                                                            out.write(" \"");  //$NON-NLS-1$        
                                                                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 213, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                            out.write("\", ");  //$NON-NLS-1$        
                                                                            _jettag_c_when_213_92.handleBodyContent(out);
                                                                        }
                                                                        out = _jettag_c_when_213_92_saved_out;
                                                                        _jettag_c_when_213_92.doEnd();
                                                                        out.write(" ");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        _jettag_c_choose_213_22.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_c_choose_213_22_saved_out;
                                                                    _jettag_c_choose_213_22.doEnd();
                                                                    _jettag_c_iterate_211_20.handleBodyContent(out);
                                                                }
                                                                _jettag_c_iterate_211_20.doEnd();
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t };");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$packageName}", 217, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 217, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 217, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Service.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 217, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("ServiceAsync.instance().get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 217, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tentity.getId(),");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 218, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Columns,new ALAsyncCallback<MultiSelectObj<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 218, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(">>() {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(MultiSelectObj<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 220, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("> arg0) {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 221, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.clear();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 223, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel().add(new ReadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 223, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel(arg0.getSelectedObjs()));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 224, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel().add(new Select");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 224, 105)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panel(\"Select ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 224, 135)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s\",Tree");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 224, 158)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panel.instance(),arg0.getAvailable(),arg0.getSelected()));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_209_19.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_209_19.doEnd();
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_187_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_187_23.doEnd();
                                                        _jettag_c_iterate_186_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_186_22.doEnd();
                                                    _jettag_c_if_184_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_184_19.doEnd();
                                                _jettag_c_if_182_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_182_21.doEnd();
                                            _jettag_c_if_179_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_179_18.doEnd();
                                        _jettag_c_iterate_177_19.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_177_19.doEnd();
                                    out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_175_13.handleBodyContent(out);
                                }
                                _jettag_c_if_175_13.doEnd();
                                _jettag_c_iterate_172_10.handleBodyContent(out);
                            }
                            _jettag_c_iterate_172_10.doEnd();
                            _jettag_c_iterate_171_9.handleBodyContent(out);
                        }
                        _jettag_c_iterate_171_9.doEnd();
                        _jettag_c_iterate_170_8.handleBodyContent(out);
                    }
                    _jettag_c_iterate_170_8.doEnd();
                    _jettag_c_if_167_1.handleBodyContent(out);
                }
                _jettag_c_if_167_1.doEnd();
                //process level 2 generizations 
                RuntimeTagElement _jettag_c_if_243_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_243_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_243_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_243_1.setTagInfo(_td_c_if_243_1);
                _jettag_c_if_243_1.doStart(context, out);
                while (_jettag_c_if_243_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_244_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_244_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_244_6.setRuntimeParent(_jettag_c_if_243_1);
                    _jettag_c_setVariable_244_6.setTagInfo(_td_c_setVariable_244_6);
                    _jettag_c_setVariable_244_6.doStart(context, out);
                    _jettag_c_setVariable_244_6.doEnd();
                    // process the assocations for level 1 class 
                    RuntimeTagElement _jettag_c_iterate_246_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_246_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_246_8.setRuntimeParent(_jettag_c_if_243_1);
                    _jettag_c_iterate_246_8.setTagInfo(_td_c_iterate_246_8);
                    _jettag_c_iterate_246_8.doStart(context, out);
                    while (_jettag_c_iterate_246_8.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_247_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_247_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_247_9.setRuntimeParent(_jettag_c_iterate_246_8);
                        _jettag_c_iterate_247_9.setTagInfo(_td_c_iterate_247_9);
                        _jettag_c_iterate_247_9.doStart(context, out);
                        while (_jettag_c_iterate_247_9.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_248_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_248_10); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_248_10.setRuntimeParent(_jettag_c_iterate_247_9);
                            _jettag_c_iterate_248_10.setTagInfo(_td_c_iterate_248_10);
                            _jettag_c_iterate_248_10.doStart(context, out);
                            while (_jettag_c_iterate_248_10.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_249_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_249_11); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_249_11.setRuntimeParent(_jettag_c_iterate_248_10);
                                _jettag_c_setVariable_249_11.setTagInfo(_td_c_setVariable_249_11);
                                _jettag_c_setVariable_249_11.doStart(context, out);
                                _jettag_c_setVariable_249_11.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_251_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_251_13); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_251_13.setRuntimeParent(_jettag_c_iterate_248_10);
                                _jettag_c_if_251_13.setTagInfo(_td_c_if_251_13);
                                _jettag_c_if_251_13.doStart(context, out);
                                while (_jettag_c_if_251_13.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_253_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_253_19); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_253_19.setRuntimeParent(_jettag_c_if_251_13);
                                    _jettag_c_iterate_253_19.setTagInfo(_td_c_iterate_253_19);
                                    _jettag_c_iterate_253_19.doStart(context, out);
                                    while (_jettag_c_iterate_253_19.okToProcessBody()) {
                                        // process only non composits or non aggregations and 
                                        RuntimeTagElement _jettag_c_if_255_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_255_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_255_18.setRuntimeParent(_jettag_c_iterate_253_19);
                                        _jettag_c_if_255_18.setTagInfo(_td_c_if_255_18);
                                        _jettag_c_if_255_18.doStart(context, out);
                                        while (_jettag_c_if_255_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_256_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_256_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_256_19.setRuntimeParent(_jettag_c_if_255_18);
                                            _jettag_c_setVariable_256_19.setTagInfo(_td_c_setVariable_256_19);
                                            _jettag_c_setVariable_256_19.doStart(context, out);
                                            _jettag_c_setVariable_256_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_258_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_258_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_258_21.setRuntimeParent(_jettag_c_if_255_18);
                                            _jettag_c_if_258_21.setTagInfo(_td_c_if_258_21);
                                            _jettag_c_if_258_21.doStart(context, out);
                                            while (_jettag_c_if_258_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_260_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_260_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_260_19.setRuntimeParent(_jettag_c_if_258_21);
                                                _jettag_c_if_260_19.setTagInfo(_td_c_if_260_19);
                                                _jettag_c_if_260_19.doStart(context, out);
                                                while (_jettag_c_if_260_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_262_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_262_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_262_22.setRuntimeParent(_jettag_c_if_260_19);
                                                    _jettag_c_iterate_262_22.setTagInfo(_td_c_iterate_262_22);
                                                    _jettag_c_iterate_262_22.doStart(context, out);
                                                    while (_jettag_c_iterate_262_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_263_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_263_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_263_23.setRuntimeParent(_jettag_c_iterate_262_22);
                                                        _jettag_c_if_263_23.setTagInfo(_td_c_if_263_23);
                                                        _jettag_c_if_263_23.doStart(context, out);
                                                        while (_jettag_c_if_263_23.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\tif (");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 264, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".class.getName().contains(link)) {");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            //for composite add 
                                                            RuntimeTagElement _jettag_c_if_266_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_266_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_266_19.setRuntimeParent(_jettag_c_if_263_23);
                                                            _jettag_c_if_266_19.setTagInfo(_td_c_if_266_19);
                                                            _jettag_c_if_266_19.doStart(context, out);
                                                            while (_jettag_c_if_266_19.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$packageName}", 267, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 267, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 267, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Service.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 267, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("ServiceAsync.instance().get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 267, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tentity.getId(),new ALAsyncCallback<List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 268, 60)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(">>() {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 270, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("> arg0) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tReadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 271, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel readAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 271, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel= new ReadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 271, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel(arg0);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\treadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 272, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel.parentTree = Tree");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 272, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panel.this;");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\treadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 273, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel.parentTreeClass = link;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 274, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.clear();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 276, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel().add(readAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 276, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 277, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tnew ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 278, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("OptionsPanel(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOptionsCompositeType.ADD));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_266_19.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_266_19.doEnd();
                                                            //for non composite add_all 
                                                            RuntimeTagElement _jettag_c_if_285_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_285_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_285_19.setRuntimeParent(_jettag_c_if_263_23);
                                                            _jettag_c_if_285_19.setTagInfo(_td_c_if_285_19);
                                                            _jettag_c_if_285_19.doStart(context, out);
                                                            while (_jettag_c_if_285_19.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tString[] ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 286, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Columns = { ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                RuntimeTagElement _jettag_c_iterate_287_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_287_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_iterate_287_20.setRuntimeParent(_jettag_c_if_285_19);
                                                                _jettag_c_iterate_287_20.setTagInfo(_td_c_iterate_287_20);
                                                                _jettag_c_iterate_287_20.doStart(context, out);
                                                                while (_jettag_c_iterate_287_20.okToProcessBody()) {
                                                                    // processes the premitive Datatypes 
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_c_choose_289_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_289_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_c_choose_289_22.setRuntimeParent(_jettag_c_iterate_287_20);
                                                                    _jettag_c_choose_289_22.setTagInfo(_td_c_choose_289_22);
                                                                    _jettag_c_choose_289_22.doStart(context, out);
                                                                    JET2Writer _jettag_c_choose_289_22_saved_out = out;
                                                                    while (_jettag_c_choose_289_22.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write(" ");  //$NON-NLS-1$        
                                                                        RuntimeTagElement _jettag_c_when_289_92 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_289_92); //$NON-NLS-1$ //$NON-NLS-2$
                                                                        _jettag_c_when_289_92.setRuntimeParent(_jettag_c_choose_289_22);
                                                                        _jettag_c_when_289_92.setTagInfo(_td_c_when_289_92);
                                                                        _jettag_c_when_289_92.doStart(context, out);
                                                                        JET2Writer _jettag_c_when_289_92_saved_out = out;
                                                                        while (_jettag_c_when_289_92.okToProcessBody()) {
                                                                            out = out.newNestedContentWriter();
                                                                            out.write(" \"");  //$NON-NLS-1$        
                                                                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 289, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                            out.write("\", ");  //$NON-NLS-1$        
                                                                            _jettag_c_when_289_92.handleBodyContent(out);
                                                                        }
                                                                        out = _jettag_c_when_289_92_saved_out;
                                                                        _jettag_c_when_289_92.doEnd();
                                                                        out.write(" ");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        _jettag_c_choose_289_22.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_c_choose_289_22_saved_out;
                                                                    _jettag_c_choose_289_22.doEnd();
                                                                    _jettag_c_iterate_287_20.handleBodyContent(out);
                                                                }
                                                                _jettag_c_iterate_287_20.doEnd();
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t };");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$packageName}", 293, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 293, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 293, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Service.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 293, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("ServiceAsync.instance().get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 293, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tentity.getId(),");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 294, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Columns,new ALAsyncCallback<MultiSelectObj<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 294, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(">>() {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(MultiSelectObj<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 296, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("> arg0) {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 297, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.clear();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 299, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel().add(new ReadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 299, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel(arg0.getSelectedObjs()));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 300, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel().add(new Select");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 300, 105)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panel(\"Select ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 300, 135)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s\",Tree");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 300, 158)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panel.instance(),arg0.getAvailable(),arg0.getSelected()));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_285_19.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_285_19.doEnd();
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write(NL);         
                                                            _jettag_c_if_263_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_263_23.doEnd();
                                                        _jettag_c_iterate_262_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_262_22.doEnd();
                                                    _jettag_c_if_260_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_260_19.doEnd();
                                                _jettag_c_if_258_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_258_21.doEnd();
                                            _jettag_c_if_255_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_255_18.doEnd();
                                        _jettag_c_iterate_253_19.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_253_19.doEnd();
                                    out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_251_13.handleBodyContent(out);
                                }
                                _jettag_c_if_251_13.doEnd();
                                _jettag_c_iterate_248_10.handleBodyContent(out);
                            }
                            _jettag_c_iterate_248_10.doEnd();
                            _jettag_c_iterate_247_9.handleBodyContent(out);
                        }
                        _jettag_c_iterate_247_9.doEnd();
                        _jettag_c_iterate_246_8.handleBodyContent(out);
                    }
                    _jettag_c_iterate_246_8.doEnd();
                    _jettag_c_if_243_1.handleBodyContent(out);
                }
                _jettag_c_if_243_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_c_setVariable_320_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_320_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_320_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_320_1.setTagInfo(_td_c_setVariable_320_1);
                _jettag_c_setVariable_320_1.doStart(context, out);
                _jettag_c_setVariable_320_1.doEnd();
                //process 0 level class relations 
                RuntimeTagElement _jettag_c_iterate_322_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_322_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_322_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_322_1.setTagInfo(_td_c_iterate_322_1);
                _jettag_c_iterate_322_1.doStart(context, out);
                while (_jettag_c_iterate_322_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_323_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_323_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_323_2.setRuntimeParent(_jettag_c_iterate_322_1);
                    _jettag_c_iterate_323_2.setTagInfo(_td_c_iterate_323_2);
                    _jettag_c_iterate_323_2.doStart(context, out);
                    while (_jettag_c_iterate_323_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_324_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_324_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_324_3.setRuntimeParent(_jettag_c_iterate_323_2);
                        _jettag_c_iterate_324_3.setTagInfo(_td_c_iterate_324_3);
                        _jettag_c_iterate_324_3.doStart(context, out);
                        while (_jettag_c_iterate_324_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_325_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_325_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_325_4.setRuntimeParent(_jettag_c_iterate_324_3);
                            _jettag_c_setVariable_325_4.setTagInfo(_td_c_setVariable_325_4);
                            _jettag_c_setVariable_325_4.doStart(context, out);
                            _jettag_c_setVariable_325_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_327_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_327_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_327_6.setRuntimeParent(_jettag_c_iterate_324_3);
                            _jettag_c_if_327_6.setTagInfo(_td_c_if_327_6);
                            _jettag_c_if_327_6.doStart(context, out);
                            while (_jettag_c_if_327_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_329_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_329_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_329_12.setRuntimeParent(_jettag_c_if_327_6);
                                _jettag_c_iterate_329_12.setTagInfo(_td_c_iterate_329_12);
                                _jettag_c_iterate_329_12.doStart(context, out);
                                while (_jettag_c_iterate_329_12.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_331_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_331_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_331_12.setRuntimeParent(_jettag_c_iterate_329_12);
                                    _jettag_c_if_331_12.setTagInfo(_td_c_if_331_12);
                                    _jettag_c_if_331_12.doStart(context, out);
                                    while (_jettag_c_if_331_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_332_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_332_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_332_12.setRuntimeParent(_jettag_c_if_331_12);
                                        _jettag_c_setVariable_332_12.setTagInfo(_td_c_setVariable_332_12);
                                        _jettag_c_setVariable_332_12.doStart(context, out);
                                        _jettag_c_setVariable_332_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_334_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_334_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_334_14.setRuntimeParent(_jettag_c_if_331_12);
                                        _jettag_c_if_334_14.setTagInfo(_td_c_if_334_14);
                                        _jettag_c_if_334_14.doStart(context, out);
                                        while (_jettag_c_if_334_14.okToProcessBody()) {
                                            // check to see if this is a navigable relation
                                            RuntimeTagElement _jettag_c_if_336_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_336_14); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_336_14.setRuntimeParent(_jettag_c_if_334_14);
                                            _jettag_c_if_336_14.setTagInfo(_td_c_if_336_14);
                                            _jettag_c_if_336_14.doStart(context, out);
                                            while (_jettag_c_if_336_14.okToProcessBody()) {
                                                // process many on target
                                                RuntimeTagElement _jettag_c_if_338_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_338_9); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_338_9.setRuntimeParent(_jettag_c_if_336_14);
                                                _jettag_c_if_338_9.setTagInfo(_td_c_if_338_9);
                                                _jettag_c_if_338_9.doStart(context, out);
                                                while (_jettag_c_if_338_9.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_339_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_339_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_339_11.setRuntimeParent(_jettag_c_if_338_9);
                                                    _jettag_c_if_339_11.setTagInfo(_td_c_if_339_11);
                                                    _jettag_c_if_339_11.doStart(context, out);
                                                    while (_jettag_c_if_339_11.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_341_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_341_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_341_15.setRuntimeParent(_jettag_c_if_339_11);
                                                        _jettag_c_iterate_341_15.setTagInfo(_td_c_iterate_341_15);
                                                        _jettag_c_iterate_341_15.doStart(context, out);
                                                        while (_jettag_c_iterate_341_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_342_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_342_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_342_16.setRuntimeParent(_jettag_c_iterate_341_15);
                                                            _jettag_c_if_342_16.setTagInfo(_td_c_if_342_16);
                                                            _jettag_c_if_342_16.doStart(context, out);
                                                            while (_jettag_c_if_342_16.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\tif (");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 343, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class.getName().contains(link)) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                //for composite add 
                                                                RuntimeTagElement _jettag_c_if_345_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_345_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_345_19.setRuntimeParent(_jettag_c_if_342_16);
                                                                _jettag_c_if_345_19.setTagInfo(_td_c_if_345_19);
                                                                _jettag_c_if_345_19.doStart(context, out);
                                                                while (_jettag_c_if_345_19.okToProcessBody()) {
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$packageName}", 346, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(".");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 346, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(".");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 346, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Service.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 346, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("ServiceAsync.instance().get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 346, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tentity.getId(),new ALAsyncCallback<List<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 347, 60)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">>() {");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(List<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 349, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("> arg0) {");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tReadAll");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 350, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sPanel readAll");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 350, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sPanel= new ReadAll");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 350, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sPanel(arg0);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\treadAll");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 351, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sPanel.parentTree = Tree");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 351, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Panel.this;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\treadAll");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 352, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sPanel.parentTreeClass = link;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 353, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Welcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.clear();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 355, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Welcome.instance().getEntityPanel().add(readAll");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 355, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sPanel);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 356, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tnew ");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 357, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("OptionsPanel(");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOptionsCompositeType.ADD));");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_345_19.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_345_19.doEnd();
                                                                //for non composite add_all 
                                                                RuntimeTagElement _jettag_c_if_364_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_364_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_364_19.setRuntimeParent(_jettag_c_if_342_16);
                                                                _jettag_c_if_364_19.setTagInfo(_td_c_if_364_19);
                                                                _jettag_c_if_364_19.doStart(context, out);
                                                                while (_jettag_c_if_364_19.okToProcessBody()) {
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tString[] ");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 365, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Columns = { ");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    RuntimeTagElement _jettag_c_iterate_366_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_366_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_c_iterate_366_20.setRuntimeParent(_jettag_c_if_364_19);
                                                                    _jettag_c_iterate_366_20.setTagInfo(_td_c_iterate_366_20);
                                                                    _jettag_c_iterate_366_20.doStart(context, out);
                                                                    while (_jettag_c_iterate_366_20.okToProcessBody()) {
                                                                        // processes the premitive Datatypes 
                                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ");  //$NON-NLS-1$        
                                                                        RuntimeTagElement _jettag_c_choose_368_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_368_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                                        _jettag_c_choose_368_22.setRuntimeParent(_jettag_c_iterate_366_20);
                                                                        _jettag_c_choose_368_22.setTagInfo(_td_c_choose_368_22);
                                                                        _jettag_c_choose_368_22.doStart(context, out);
                                                                        JET2Writer _jettag_c_choose_368_22_saved_out = out;
                                                                        while (_jettag_c_choose_368_22.okToProcessBody()) {
                                                                            out = out.newNestedContentWriter();
                                                                            out.write(" ");  //$NON-NLS-1$        
                                                                            RuntimeTagElement _jettag_c_when_368_92 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_368_92); //$NON-NLS-1$ //$NON-NLS-2$
                                                                            _jettag_c_when_368_92.setRuntimeParent(_jettag_c_choose_368_22);
                                                                            _jettag_c_when_368_92.setTagInfo(_td_c_when_368_92);
                                                                            _jettag_c_when_368_92.doStart(context, out);
                                                                            JET2Writer _jettag_c_when_368_92_saved_out = out;
                                                                            while (_jettag_c_when_368_92.okToProcessBody()) {
                                                                                out = out.newNestedContentWriter();
                                                                                out.write(" \"");  //$NON-NLS-1$        
                                                                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 368, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                                out.write("\", ");  //$NON-NLS-1$        
                                                                                _jettag_c_when_368_92.handleBodyContent(out);
                                                                            }
                                                                            out = _jettag_c_when_368_92_saved_out;
                                                                            _jettag_c_when_368_92.doEnd();
                                                                            out.write(" ");  //$NON-NLS-1$        
                                                                            out.write(NL);         
                                                                            _jettag_c_choose_368_22.handleBodyContent(out);
                                                                        }
                                                                        out = _jettag_c_choose_368_22_saved_out;
                                                                        _jettag_c_choose_368_22.doEnd();
                                                                        _jettag_c_iterate_366_20.handleBodyContent(out);
                                                                    }
                                                                    _jettag_c_iterate_366_20.doEnd();
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t };");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$packageName}", 372, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(".");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 372, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(".");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 372, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Service.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 372, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("ServiceAsync.instance().get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 372, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tentity.getId(),");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 373, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Columns,new ALAsyncCallback<MultiSelectObj<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 373, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">>() {");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(MultiSelectObj<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 375, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("> arg0) {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 376, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Welcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.clear();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 378, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Welcome.instance().getEntityPanel().add(new ReadAll");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 378, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sPanel(arg0.getSelectedObjs()));");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 379, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Welcome.instance().getEntityPanel().add(new Select");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 379, 105)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Panel(\"Select ");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 379, 135)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s\",Tree");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 379, 158)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Panel.instance(),arg0.getAvailable(),arg0.getSelected()));");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_364_19.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_364_19.doEnd();
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write(NL);         
                                                                _jettag_c_if_342_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_342_16.doEnd();
                                                            _jettag_c_iterate_341_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_341_15.doEnd();
                                                        _jettag_c_if_339_11.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_339_11.doEnd();
                                                    _jettag_c_if_338_9.handleBodyContent(out);
                                                }
                                                _jettag_c_if_338_9.doEnd();
                                                _jettag_c_if_336_14.handleBodyContent(out);
                                            }
                                            _jettag_c_if_336_14.doEnd();
                                            _jettag_c_if_334_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_334_14.doEnd();
                                        _jettag_c_if_331_12.handleBodyContent(out);
                                    }
                                    _jettag_c_if_331_12.doEnd();
                                    _jettag_c_iterate_329_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_329_12.doEnd();
                                _jettag_c_if_327_6.handleBodyContent(out);
                            }
                            _jettag_c_if_327_6.doEnd();
                            _jettag_c_iterate_324_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_324_3.doEnd();
                        _jettag_c_iterate_323_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_323_2.doEnd();
                    _jettag_c_iterate_322_1.handleBodyContent(out);
                }
                _jettag_c_iterate_322_1.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_399_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_399_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_399_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_399_1.setTagInfo(_td_f_message_399_1);
                _jettag_f_message_399_1.doStart(context, out);
                JET2Writer _jettag_f_message_399_1_saved_out = out;
                while (_jettag_f_message_399_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_399_1.handleBodyContent(out);
                }
                out = _jettag_f_message_399_1_saved_out;
                _jettag_f_message_399_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void showEntity() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
