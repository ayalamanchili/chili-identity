package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_tree_panelyjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_tree_panelyjava() {
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
    private static final TagInfo _td_c_if_57_1 = new TagInfo("c:if", //$NON-NLS-1$
            57, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_58_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            58, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_61_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            61, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_62_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            62, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_63_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            63, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_64_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            64, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_66_14 = new TagInfo("c:if", //$NON-NLS-1$
            66, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_68_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            68, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_70_18 = new TagInfo("c:if", //$NON-NLS-1$
            70, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_71_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            71, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_73_21 = new TagInfo("c:if", //$NON-NLS-1$
            73, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_75_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            75, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_76_23 = new TagInfo("c:if", //$NON-NLS-1$
            76, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_93_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            93, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_95_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            95, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_96_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            96, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_97_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            97, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_98_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            98, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_100_6 = new TagInfo("c:if", //$NON-NLS-1$
            100, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_102_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            102, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_104_11 = new TagInfo("c:if", //$NON-NLS-1$
            104, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_105_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            105, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_107_14 = new TagInfo("c:if", //$NON-NLS-1$
            107, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_109_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            109, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_110_16 = new TagInfo("c:if", //$NON-NLS-1$
            110, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_128_1 = new TagInfo("f:message", //$NON-NLS-1$
            128, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_choose_129_48 = new TagInfo("c:choose", //$NON-NLS-1$
            129, 48,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_129_89 = new TagInfo("c:when", //$NON-NLS-1$
            129, 89,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_129_171 = new TagInfo("c:otherwise", //$NON-NLS-1$
            129, 171,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_130_1 = new TagInfo("f:message", //$NON-NLS-1$
            130, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_132_1 = new TagInfo("f:message", //$NON-NLS-1$
            132, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_134_1 = new TagInfo("f:message", //$NON-NLS-1$
            134, 1,
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
    private static final TagInfo _td_f_message_143_1 = new TagInfo("f:message", //$NON-NLS-1$
            143, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_149_1 = new TagInfo("f:message", //$NON-NLS-1$
            149, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_155_1 = new TagInfo("f:message", //$NON-NLS-1$
            155, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_161_1 = new TagInfo("f:message", //$NON-NLS-1$
            161, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_168_1 = new TagInfo("f:message", //$NON-NLS-1$
            168, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_173_1 = new TagInfo("c:if", //$NON-NLS-1$
            173, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_174_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            174, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_176_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            176, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_177_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            177, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_178_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            178, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_179_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            179, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_181_13 = new TagInfo("c:if", //$NON-NLS-1$
            181, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_183_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            183, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_185_18 = new TagInfo("c:if", //$NON-NLS-1$
            185, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_186_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            186, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_188_21 = new TagInfo("c:if", //$NON-NLS-1$
            188, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_190_19 = new TagInfo("c:if", //$NON-NLS-1$
            190, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_192_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            192, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_193_23 = new TagInfo("c:if", //$NON-NLS-1$
            193, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_196_19 = new TagInfo("c:if", //$NON-NLS-1$
            196, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_216_19 = new TagInfo("c:if", //$NON-NLS-1$
            216, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_218_20 = new TagInfo("c:iterate", //$NON-NLS-1$
            218, 20,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_220_22 = new TagInfo("c:choose", //$NON-NLS-1$
            220, 22,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_220_92 = new TagInfo("c:when", //$NON-NLS-1$
            220, 92,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_249_1 = new TagInfo("c:if", //$NON-NLS-1$
            249, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_250_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            250, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_252_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            252, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_253_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            253, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_254_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            254, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_255_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            255, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_257_13 = new TagInfo("c:if", //$NON-NLS-1$
            257, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_259_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            259, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_261_18 = new TagInfo("c:if", //$NON-NLS-1$
            261, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_262_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            262, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_264_21 = new TagInfo("c:if", //$NON-NLS-1$
            264, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_266_19 = new TagInfo("c:if", //$NON-NLS-1$
            266, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_268_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            268, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_269_23 = new TagInfo("c:if", //$NON-NLS-1$
            269, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_272_19 = new TagInfo("c:if", //$NON-NLS-1$
            272, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_292_19 = new TagInfo("c:if", //$NON-NLS-1$
            292, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_294_20 = new TagInfo("c:iterate", //$NON-NLS-1$
            294, 20,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_296_22 = new TagInfo("c:choose", //$NON-NLS-1$
            296, 22,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_296_92 = new TagInfo("c:when", //$NON-NLS-1$
            296, 92,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_326_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            326, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_328_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            328, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_329_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            329, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_330_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            330, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_331_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            331, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_333_6 = new TagInfo("c:if", //$NON-NLS-1$
            333, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_335_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            335, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_337_12 = new TagInfo("c:if", //$NON-NLS-1$
            337, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_338_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            338, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_340_14 = new TagInfo("c:if", //$NON-NLS-1$
            340, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_342_14 = new TagInfo("c:if", //$NON-NLS-1$
            342, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_344_9 = new TagInfo("c:if", //$NON-NLS-1$
            344, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_345_11 = new TagInfo("c:if", //$NON-NLS-1$
            345, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_347_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            347, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_348_16 = new TagInfo("c:if", //$NON-NLS-1$
            348, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_351_19 = new TagInfo("c:if", //$NON-NLS-1$
            351, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_371_19 = new TagInfo("c:if", //$NON-NLS-1$
            371, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_373_20 = new TagInfo("c:iterate", //$NON-NLS-1$
            373, 20,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_375_22 = new TagInfo("c:choose", //$NON-NLS-1$
            375, 22,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_375_92 = new TagInfo("c:when", //$NON-NLS-1$
            375, 92,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_405_1 = new TagInfo("f:message", //$NON-NLS-1$
            405, 1,
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
                out.write(context.embeddedExpressionAsString("${$webPackage}", 9, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 9, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.TreePanelCompositey;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.widgets.ClickableLink;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.beans.MultiSelectObjy;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.Window;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.rf.GenericRequest;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.OptionsComposite.OptionsCompositeType;\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.web.bindery.requestfactory.shared.Receiver;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 19, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 19, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 19, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
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
                    out.write("Panely;");  //$NON-NLS-1$        
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
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 42, 108)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Proxy;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 43, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 43, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 43, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".ReadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 43, 115)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sPanely;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 44, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 44, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 44, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 44, 108)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("OptionsPanel;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 45, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 45, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 45, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".Select");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 45, 114)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Panely;\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t");  //$NON-NLS-1$        
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
                RuntimeTagElement _jettag_c_if_57_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_57_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_57_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_57_1.setTagInfo(_td_c_if_57_1);
                _jettag_c_if_57_1.doStart(context, out);
                while (_jettag_c_if_57_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_58_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_58_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_58_6.setRuntimeParent(_jettag_c_if_57_1);
                    _jettag_c_setVariable_58_6.setTagInfo(_td_c_setVariable_58_6);
                    _jettag_c_setVariable_58_6.doStart(context, out);
                    _jettag_c_setVariable_58_6.doEnd();
                    out.write("  \t\t\timport ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$groupID}", 59, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".client.");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 59, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($parentClass2/@name)}", 59, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".TreeAbstract");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$parentClass2/@name}", 59, 109)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Panely;");  //$NON-NLS-1$        
                    out.write(NL);         
                    // process the assocations for level 2 class 
                    RuntimeTagElement _jettag_c_iterate_61_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_61_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_61_8.setRuntimeParent(_jettag_c_if_57_1);
                    _jettag_c_iterate_61_8.setTagInfo(_td_c_iterate_61_8);
                    _jettag_c_iterate_61_8.doStart(context, out);
                    while (_jettag_c_iterate_61_8.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_62_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_62_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_62_9.setRuntimeParent(_jettag_c_iterate_61_8);
                        _jettag_c_iterate_62_9.setTagInfo(_td_c_iterate_62_9);
                        _jettag_c_iterate_62_9.doStart(context, out);
                        while (_jettag_c_iterate_62_9.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_63_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_63_10); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_63_10.setRuntimeParent(_jettag_c_iterate_62_9);
                            _jettag_c_iterate_63_10.setTagInfo(_td_c_iterate_63_10);
                            _jettag_c_iterate_63_10.doStart(context, out);
                            while (_jettag_c_iterate_63_10.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_64_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_64_11); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_64_11.setRuntimeParent(_jettag_c_iterate_63_10);
                                _jettag_c_setVariable_64_11.setTagInfo(_td_c_setVariable_64_11);
                                _jettag_c_setVariable_64_11.doStart(context, out);
                                _jettag_c_setVariable_64_11.doEnd();
                                // process only compositions or aggegations
                                RuntimeTagElement _jettag_c_if_66_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_66_14); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_66_14.setRuntimeParent(_jettag_c_iterate_63_10);
                                _jettag_c_if_66_14.setTagInfo(_td_c_if_66_14);
                                _jettag_c_if_66_14.doStart(context, out);
                                while (_jettag_c_if_66_14.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_68_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_68_19); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_68_19.setRuntimeParent(_jettag_c_if_66_14);
                                    _jettag_c_iterate_68_19.setTagInfo(_td_c_iterate_68_19);
                                    _jettag_c_iterate_68_19.doStart(context, out);
                                    while (_jettag_c_iterate_68_19.okToProcessBody()) {
                                        // process only non composits or non aggregations and 
                                        RuntimeTagElement _jettag_c_if_70_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_70_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_70_18.setRuntimeParent(_jettag_c_iterate_68_19);
                                        _jettag_c_if_70_18.setTagInfo(_td_c_if_70_18);
                                        _jettag_c_if_70_18.doStart(context, out);
                                        while (_jettag_c_if_70_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_71_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_71_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_71_19.setRuntimeParent(_jettag_c_if_70_18);
                                            _jettag_c_setVariable_71_19.setTagInfo(_td_c_setVariable_71_19);
                                            _jettag_c_setVariable_71_19.doStart(context, out);
                                            _jettag_c_setVariable_71_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_73_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_73_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_73_21.setRuntimeParent(_jettag_c_if_70_18);
                                            _jettag_c_if_73_21.setTagInfo(_td_c_if_73_21);
                                            _jettag_c_if_73_21.doStart(context, out);
                                            while (_jettag_c_if_73_21.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_75_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_75_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_75_22.setRuntimeParent(_jettag_c_if_73_21);
                                                _jettag_c_iterate_75_22.setTagInfo(_td_c_iterate_75_22);
                                                _jettag_c_iterate_75_22.doStart(context, out);
                                                while (_jettag_c_iterate_75_22.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_76_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_76_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_76_23.setRuntimeParent(_jettag_c_iterate_75_22);
                                                    _jettag_c_if_76_23.setTagInfo(_td_c_if_76_23);
                                                    _jettag_c_if_76_23.doStart(context, out);
                                                    while (_jettag_c_if_76_23.okToProcessBody()) {
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 77, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entity.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 77, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 77, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 78, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 78, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 78, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 78, 108)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Proxy;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 79, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 79, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 79, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".ReadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 79, 115)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sPanely;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 80, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 80, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 80, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 80, 108)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("OptionsPanel;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 81, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 81, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 81, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".Select");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 81, 114)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Panely;\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_76_23.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_76_23.doEnd();
                                                    _jettag_c_iterate_75_22.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_75_22.doEnd();
                                                _jettag_c_if_73_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_73_21.doEnd();
                                            _jettag_c_if_70_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_70_18.doEnd();
                                        _jettag_c_iterate_68_19.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_68_19.doEnd();
                                    _jettag_c_if_66_14.handleBodyContent(out);
                                }
                                _jettag_c_if_66_14.doEnd();
                                _jettag_c_iterate_63_10.handleBodyContent(out);
                            }
                            _jettag_c_iterate_63_10.doEnd();
                            _jettag_c_iterate_62_9.handleBodyContent(out);
                        }
                        _jettag_c_iterate_62_9.doEnd();
                        _jettag_c_iterate_61_8.handleBodyContent(out);
                    }
                    _jettag_c_iterate_61_8.doEnd();
                    _jettag_c_if_57_1.handleBodyContent(out);
                }
                _jettag_c_if_57_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_c_setVariable_93_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_93_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_93_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_93_1.setTagInfo(_td_c_setVariable_93_1);
                _jettag_c_setVariable_93_1.doStart(context, out);
                _jettag_c_setVariable_93_1.doEnd();
                //process 0 level class relations 
                RuntimeTagElement _jettag_c_iterate_95_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_95_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_95_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_95_1.setTagInfo(_td_c_iterate_95_1);
                _jettag_c_iterate_95_1.doStart(context, out);
                while (_jettag_c_iterate_95_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_96_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_96_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_96_2.setRuntimeParent(_jettag_c_iterate_95_1);
                    _jettag_c_iterate_96_2.setTagInfo(_td_c_iterate_96_2);
                    _jettag_c_iterate_96_2.doStart(context, out);
                    while (_jettag_c_iterate_96_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_97_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_97_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_97_3.setRuntimeParent(_jettag_c_iterate_96_2);
                        _jettag_c_iterate_97_3.setTagInfo(_td_c_iterate_97_3);
                        _jettag_c_iterate_97_3.doStart(context, out);
                        while (_jettag_c_iterate_97_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_98_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_98_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_98_4.setRuntimeParent(_jettag_c_iterate_97_3);
                            _jettag_c_setVariable_98_4.setTagInfo(_td_c_setVariable_98_4);
                            _jettag_c_setVariable_98_4.doStart(context, out);
                            _jettag_c_setVariable_98_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_100_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_100_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_100_6.setRuntimeParent(_jettag_c_iterate_97_3);
                            _jettag_c_if_100_6.setTagInfo(_td_c_if_100_6);
                            _jettag_c_if_100_6.doStart(context, out);
                            while (_jettag_c_if_100_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_102_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_102_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_102_12.setRuntimeParent(_jettag_c_if_100_6);
                                _jettag_c_iterate_102_12.setTagInfo(_td_c_iterate_102_12);
                                _jettag_c_iterate_102_12.doStart(context, out);
                                while (_jettag_c_iterate_102_12.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_104_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_104_11); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_104_11.setRuntimeParent(_jettag_c_iterate_102_12);
                                    _jettag_c_if_104_11.setTagInfo(_td_c_if_104_11);
                                    _jettag_c_if_104_11.doStart(context, out);
                                    while (_jettag_c_if_104_11.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_105_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_105_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_105_12.setRuntimeParent(_jettag_c_if_104_11);
                                        _jettag_c_setVariable_105_12.setTagInfo(_td_c_setVariable_105_12);
                                        _jettag_c_setVariable_105_12.doStart(context, out);
                                        _jettag_c_setVariable_105_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_107_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_107_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_107_14.setRuntimeParent(_jettag_c_if_104_11);
                                        _jettag_c_if_107_14.setTagInfo(_td_c_if_107_14);
                                        _jettag_c_if_107_14.doStart(context, out);
                                        while (_jettag_c_if_107_14.okToProcessBody()) {
                                            // iterate throught all the classes to get the other class on the association
                                            RuntimeTagElement _jettag_c_iterate_109_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_109_15); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_109_15.setRuntimeParent(_jettag_c_if_107_14);
                                            _jettag_c_iterate_109_15.setTagInfo(_td_c_iterate_109_15);
                                            _jettag_c_iterate_109_15.doStart(context, out);
                                            while (_jettag_c_iterate_109_15.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_110_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_110_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_110_16.setRuntimeParent(_jettag_c_iterate_109_15);
                                                _jettag_c_if_110_16.setTagInfo(_td_c_if_110_16);
                                                _jettag_c_if_110_16.doStart(context, out);
                                                while (_jettag_c_if_110_16.okToProcessBody()) {
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 111, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".entity.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 111, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 111, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 112, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".client.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 112, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 112, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 112, 108)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("Proxy;");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 113, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".client.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 113, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 113, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".ReadAll");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 113, 115)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("sPanely;");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 114, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".client.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 114, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 114, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 114, 108)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("OptionsPanel;");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 115, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".client.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 115, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 115, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".Select");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 115, 114)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("Panely;");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_110_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_110_16.doEnd();
                                                _jettag_c_iterate_109_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_109_15.doEnd();
                                            _jettag_c_if_107_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_107_14.doEnd();
                                        _jettag_c_if_104_11.handleBodyContent(out);
                                    }
                                    _jettag_c_if_104_11.doEnd();
                                    _jettag_c_iterate_102_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_102_12.doEnd();
                                _jettag_c_if_100_6.handleBodyContent(out);
                            }
                            _jettag_c_if_100_6.doEnd();
                            _jettag_c_iterate_97_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_97_3.doEnd();
                        _jettag_c_iterate_96_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_96_2.doEnd();
                    _jettag_c_iterate_95_1.handleBodyContent(out);
                }
                _jettag_c_iterate_95_1.doEnd();
                out.write("import com.google.gwt.event.dom.client.ClickEvent;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.DockPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.TreeItem;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_128_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_128_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_128_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_128_1.setTagInfo(_td_f_message_128_1);
                _jettag_f_message_128_1.doStart(context, out);
                JET2Writer _jettag_f_message_128_1_saved_out = out;
                while (_jettag_f_message_128_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_128_1.handleBodyContent(out);
                }
                out = _jettag_f_message_128_1_saved_out;
                _jettag_f_message_128_1.doEnd();
                out.write(NL);         
                out.write("public class Tree");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 129, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely extends ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_choose_129_48 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_129_48); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_129_48.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_choose_129_48.setTagInfo(_td_c_choose_129_48);
                _jettag_c_choose_129_48.doStart(context, out);
                JET2Writer _jettag_c_choose_129_48_saved_out = out;
                while (_jettag_c_choose_129_48.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(" ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_129_89 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_129_89); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_129_89.setRuntimeParent(_jettag_c_choose_129_48);
                    _jettag_c_when_129_89.setTagInfo(_td_c_when_129_89);
                    _jettag_c_when_129_89.doStart(context, out);
                    JET2Writer _jettag_c_when_129_89_saved_out = out;
                    while (_jettag_c_when_129_89.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" TreePanelCompositey<");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$class/@name}", 129, 139)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("Proxy> ");  //$NON-NLS-1$        
                        _jettag_c_when_129_89.handleBodyContent(out);
                    }
                    out = _jettag_c_when_129_89_saved_out;
                    _jettag_c_when_129_89.doEnd();
                    out.write(" ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_otherwise_129_171 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_129_171); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_129_171.setRuntimeParent(_jettag_c_choose_129_48);
                    _jettag_c_otherwise_129_171.setTagInfo(_td_c_otherwise_129_171);
                    _jettag_c_otherwise_129_171.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_129_171_saved_out = out;
                    while (_jettag_c_otherwise_129_171.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" TreeAbstract");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$parentClass1/@name}", 129, 197)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("Panely");  //$NON-NLS-1$        
                        _jettag_c_otherwise_129_171.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_129_171_saved_out;
                    _jettag_c_otherwise_129_171.doEnd();
                    out.write("  ");  //$NON-NLS-1$        
                    _jettag_c_choose_129_48.handleBodyContent(out);
                }
                out = _jettag_c_choose_129_48_saved_out;
                _jettag_c_choose_129_48.doEnd();
                out.write(" {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_130_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_130_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_130_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_130_1.setTagInfo(_td_f_message_130_1);
                _jettag_f_message_130_1.doStart(context, out);
                JET2Writer _jettag_f_message_130_1_saved_out = out;
                while (_jettag_f_message_130_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_130_1.handleBodyContent(out);
                }
                out = _jettag_f_message_130_1_saved_out;
                _jettag_f_message_130_1.doEnd();
                out.write(NL);         
                out.write("\tprotected ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 131, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Request request;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_132_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_132_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_132_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_132_1.setTagInfo(_td_f_message_132_1);
                _jettag_f_message_132_1.doStart(context, out);
                JET2Writer _jettag_f_message_132_1_saved_out = out;
                while (_jettag_f_message_132_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_132_1.handleBodyContent(out);
                }
                out = _jettag_f_message_132_1_saved_out;
                _jettag_f_message_132_1.doEnd();
                out.write(NL);         
                out.write("\tprivate static Tree");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 133, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely instance;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_134_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_134_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_134_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_134_1.setTagInfo(_td_f_message_134_1);
                _jettag_f_message_134_1.doStart(context, out);
                JET2Writer _jettag_f_message_134_1_saved_out = out;
                while (_jettag_f_message_134_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_134_1.handleBodyContent(out);
                }
                out = _jettag_f_message_134_1_saved_out;
                _jettag_f_message_134_1.doEnd();
                out.write(NL);         
                out.write("\tpublic static Tree");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 135, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely instance() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn instance;");  //$NON-NLS-1$        
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
                out.write("\tpublic Tree");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 139, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinstance=this;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitTreePanelComposite(\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 141, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 141, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 141, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_143_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_143_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_143_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_143_1.setTagInfo(_td_f_message_143_1);
                _jettag_f_message_143_1.doStart(context, out);
                JET2Writer _jettag_f_message_143_1_saved_out = out;
                while (_jettag_f_message_143_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_143_1.handleBodyContent(out);
                }
                out = _jettag_f_message_143_1_saved_out;
                _jettag_f_message_143_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_149_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_149_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_149_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_149_1.setTagInfo(_td_f_message_149_1);
                _jettag_f_message_149_1.doStart(context, out);
                JET2Writer _jettag_f_message_149_1_saved_out = out;
                while (_jettag_f_message_149_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_149_1.handleBodyContent(out);
                }
                out = _jettag_f_message_149_1_saved_out;
                _jettag_f_message_149_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_155_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_155_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_155_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_155_1.setTagInfo(_td_f_message_155_1);
                _jettag_f_message_155_1.doStart(context, out);
                JET2Writer _jettag_f_message_155_1_saved_out = out;
                while (_jettag_f_message_155_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_155_1.handleBodyContent(out);
                }
                out = _jettag_f_message_155_1_saved_out;
                _jettag_f_message_155_1.doEnd();
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
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void loadProxyAndRequest() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tproxy = Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 164, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely.instance().getEntity();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\trequest = ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 165, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.requestFactory.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 165, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Request();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_168_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_168_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_168_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_168_1.setTagInfo(_td_f_message_168_1);
                _jettag_f_message_168_1.doStart(context, out);
                JET2Writer _jettag_f_message_168_1_saved_out = out;
                while (_jettag_f_message_168_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_168_1.handleBodyContent(out);
                }
                out = _jettag_f_message_168_1_saved_out;
                _jettag_f_message_168_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void treeNodeSelected(final String link) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                //process level 1 generizations 
                RuntimeTagElement _jettag_c_if_173_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_173_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_173_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_173_1.setTagInfo(_td_c_if_173_1);
                _jettag_c_if_173_1.doStart(context, out);
                while (_jettag_c_if_173_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_174_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_174_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_174_6.setRuntimeParent(_jettag_c_if_173_1);
                    _jettag_c_setVariable_174_6.setTagInfo(_td_c_setVariable_174_6);
                    _jettag_c_setVariable_174_6.doStart(context, out);
                    _jettag_c_setVariable_174_6.doEnd();
                    // process the assocations for level 1 class 
                    RuntimeTagElement _jettag_c_iterate_176_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_176_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_176_8.setRuntimeParent(_jettag_c_if_173_1);
                    _jettag_c_iterate_176_8.setTagInfo(_td_c_iterate_176_8);
                    _jettag_c_iterate_176_8.doStart(context, out);
                    while (_jettag_c_iterate_176_8.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_177_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_177_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_177_9.setRuntimeParent(_jettag_c_iterate_176_8);
                        _jettag_c_iterate_177_9.setTagInfo(_td_c_iterate_177_9);
                        _jettag_c_iterate_177_9.doStart(context, out);
                        while (_jettag_c_iterate_177_9.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_178_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_178_10); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_178_10.setRuntimeParent(_jettag_c_iterate_177_9);
                            _jettag_c_iterate_178_10.setTagInfo(_td_c_iterate_178_10);
                            _jettag_c_iterate_178_10.doStart(context, out);
                            while (_jettag_c_iterate_178_10.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_179_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_179_11); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_179_11.setRuntimeParent(_jettag_c_iterate_178_10);
                                _jettag_c_setVariable_179_11.setTagInfo(_td_c_setVariable_179_11);
                                _jettag_c_setVariable_179_11.doStart(context, out);
                                _jettag_c_setVariable_179_11.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_181_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_181_13); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_181_13.setRuntimeParent(_jettag_c_iterate_178_10);
                                _jettag_c_if_181_13.setTagInfo(_td_c_if_181_13);
                                _jettag_c_if_181_13.doStart(context, out);
                                while (_jettag_c_if_181_13.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_183_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_183_19); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_183_19.setRuntimeParent(_jettag_c_if_181_13);
                                    _jettag_c_iterate_183_19.setTagInfo(_td_c_iterate_183_19);
                                    _jettag_c_iterate_183_19.doStart(context, out);
                                    while (_jettag_c_iterate_183_19.okToProcessBody()) {
                                        // process only non composits or non aggregations and 
                                        RuntimeTagElement _jettag_c_if_185_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_185_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_185_18.setRuntimeParent(_jettag_c_iterate_183_19);
                                        _jettag_c_if_185_18.setTagInfo(_td_c_if_185_18);
                                        _jettag_c_if_185_18.doStart(context, out);
                                        while (_jettag_c_if_185_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_186_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_186_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_186_19.setRuntimeParent(_jettag_c_if_185_18);
                                            _jettag_c_setVariable_186_19.setTagInfo(_td_c_setVariable_186_19);
                                            _jettag_c_setVariable_186_19.doStart(context, out);
                                            _jettag_c_setVariable_186_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_188_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_188_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_188_21.setRuntimeParent(_jettag_c_if_185_18);
                                            _jettag_c_if_188_21.setTagInfo(_td_c_if_188_21);
                                            _jettag_c_if_188_21.doStart(context, out);
                                            while (_jettag_c_if_188_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_190_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_190_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_190_19.setRuntimeParent(_jettag_c_if_188_21);
                                                _jettag_c_if_190_19.setTagInfo(_td_c_if_190_19);
                                                _jettag_c_if_190_19.doStart(context, out);
                                                while (_jettag_c_if_190_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_192_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_192_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_192_22.setRuntimeParent(_jettag_c_if_190_19);
                                                    _jettag_c_iterate_192_22.setTagInfo(_td_c_iterate_192_22);
                                                    _jettag_c_iterate_192_22.doStart(context, out);
                                                    while (_jettag_c_iterate_192_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_193_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_193_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_193_23.setRuntimeParent(_jettag_c_iterate_192_22);
                                                        _jettag_c_if_193_23.setTagInfo(_td_c_if_193_23);
                                                        _jettag_c_if_193_23.doStart(context, out);
                                                        while (_jettag_c_if_193_23.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\tif (");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 194, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".class.getName().contains(link)) {");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            //for composite add 
                                                            RuntimeTagElement _jettag_c_if_196_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_196_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_196_19.setRuntimeParent(_jettag_c_if_193_23);
                                                            _jettag_c_if_196_19.setTagInfo(_td_c_if_196_19);
                                                            _jettag_c_if_196_19.doStart(context, out);
                                                            while (_jettag_c_if_196_19.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trequest.get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 198, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(proxy.getId()).fire(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tnew Receiver<List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 199, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy>>() {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onSuccess(List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 202, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy> arg0) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tReadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 203, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanely readAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 203, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel= new ReadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 203, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanely(arg0);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\treadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 204, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel.parentTreeClass = link;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 205, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.clear();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 207, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel().add(readAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 207, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 208, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tnew ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 209, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("OptionsPanel(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOptionsCompositeType.ADD));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_196_19.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_196_19.doEnd();
                                                            //for non composite add_all 
                                                            RuntimeTagElement _jettag_c_if_216_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_216_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_216_19.setRuntimeParent(_jettag_c_if_193_23);
                                                            _jettag_c_if_216_19.setTagInfo(_td_c_if_216_19);
                                                            _jettag_c_if_216_19.doStart(context, out);
                                                            while (_jettag_c_if_216_19.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tString[] ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 217, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Columns = { ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                RuntimeTagElement _jettag_c_iterate_218_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_218_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_iterate_218_20.setRuntimeParent(_jettag_c_if_216_19);
                                                                _jettag_c_iterate_218_20.setTagInfo(_td_c_iterate_218_20);
                                                                _jettag_c_iterate_218_20.doStart(context, out);
                                                                while (_jettag_c_iterate_218_20.okToProcessBody()) {
                                                                    // processes the premitive Datatypes 
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_c_choose_220_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_220_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_c_choose_220_22.setRuntimeParent(_jettag_c_iterate_218_20);
                                                                    _jettag_c_choose_220_22.setTagInfo(_td_c_choose_220_22);
                                                                    _jettag_c_choose_220_22.doStart(context, out);
                                                                    JET2Writer _jettag_c_choose_220_22_saved_out = out;
                                                                    while (_jettag_c_choose_220_22.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write(" ");  //$NON-NLS-1$        
                                                                        RuntimeTagElement _jettag_c_when_220_92 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_220_92); //$NON-NLS-1$ //$NON-NLS-2$
                                                                        _jettag_c_when_220_92.setRuntimeParent(_jettag_c_choose_220_22);
                                                                        _jettag_c_when_220_92.setTagInfo(_td_c_when_220_92);
                                                                        _jettag_c_when_220_92.doStart(context, out);
                                                                        JET2Writer _jettag_c_when_220_92_saved_out = out;
                                                                        while (_jettag_c_when_220_92.okToProcessBody()) {
                                                                            out = out.newNestedContentWriter();
                                                                            out.write(" \"");  //$NON-NLS-1$        
                                                                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 220, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                            out.write("\", ");  //$NON-NLS-1$        
                                                                            _jettag_c_when_220_92.handleBodyContent(out);
                                                                        }
                                                                        out = _jettag_c_when_220_92_saved_out;
                                                                        _jettag_c_when_220_92.doEnd();
                                                                        out.write(" ");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        _jettag_c_choose_220_22.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_c_choose_220_22_saved_out;
                                                                    _jettag_c_choose_220_22.doEnd();
                                                                    _jettag_c_iterate_218_20.handleBodyContent(out);
                                                                }
                                                                _jettag_c_iterate_218_20.doEnd();
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t };");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$packageName}", 224, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 224, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 224, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Service.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 224, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("ServiceAsync.instance().get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 224, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sMultiSelect(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tentity.getId(),");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 225, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Columns,new ALAsyncCallback<MultiSelectObjy>() {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(MultiSelectObjy arg0) {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 228, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.clear();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 230, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel()..add(new Select");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 230, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panely(\"");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 230, 130)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s\",Tree");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 230, 153)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panely.this,arg0));\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_216_19.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_216_19.doEnd();
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_193_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_193_23.doEnd();
                                                        _jettag_c_iterate_192_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_192_22.doEnd();
                                                    _jettag_c_if_190_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_190_19.doEnd();
                                                _jettag_c_if_188_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_188_21.doEnd();
                                            _jettag_c_if_185_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_185_18.doEnd();
                                        _jettag_c_iterate_183_19.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_183_19.doEnd();
                                    out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_181_13.handleBodyContent(out);
                                }
                                _jettag_c_if_181_13.doEnd();
                                _jettag_c_iterate_178_10.handleBodyContent(out);
                            }
                            _jettag_c_iterate_178_10.doEnd();
                            _jettag_c_iterate_177_9.handleBodyContent(out);
                        }
                        _jettag_c_iterate_177_9.doEnd();
                        _jettag_c_iterate_176_8.handleBodyContent(out);
                    }
                    _jettag_c_iterate_176_8.doEnd();
                    _jettag_c_if_173_1.handleBodyContent(out);
                }
                _jettag_c_if_173_1.doEnd();
                //process level 2 generizations 
                RuntimeTagElement _jettag_c_if_249_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_249_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_249_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_249_1.setTagInfo(_td_c_if_249_1);
                _jettag_c_if_249_1.doStart(context, out);
                while (_jettag_c_if_249_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_250_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_250_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_250_6.setRuntimeParent(_jettag_c_if_249_1);
                    _jettag_c_setVariable_250_6.setTagInfo(_td_c_setVariable_250_6);
                    _jettag_c_setVariable_250_6.doStart(context, out);
                    _jettag_c_setVariable_250_6.doEnd();
                    // process the assocations for level 1 class 
                    RuntimeTagElement _jettag_c_iterate_252_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_252_8); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_252_8.setRuntimeParent(_jettag_c_if_249_1);
                    _jettag_c_iterate_252_8.setTagInfo(_td_c_iterate_252_8);
                    _jettag_c_iterate_252_8.doStart(context, out);
                    while (_jettag_c_iterate_252_8.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_253_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_253_9); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_253_9.setRuntimeParent(_jettag_c_iterate_252_8);
                        _jettag_c_iterate_253_9.setTagInfo(_td_c_iterate_253_9);
                        _jettag_c_iterate_253_9.doStart(context, out);
                        while (_jettag_c_iterate_253_9.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_254_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_254_10); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_254_10.setRuntimeParent(_jettag_c_iterate_253_9);
                            _jettag_c_iterate_254_10.setTagInfo(_td_c_iterate_254_10);
                            _jettag_c_iterate_254_10.doStart(context, out);
                            while (_jettag_c_iterate_254_10.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_255_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_255_11); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_255_11.setRuntimeParent(_jettag_c_iterate_254_10);
                                _jettag_c_setVariable_255_11.setTagInfo(_td_c_setVariable_255_11);
                                _jettag_c_setVariable_255_11.doStart(context, out);
                                _jettag_c_setVariable_255_11.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_257_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_257_13); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_257_13.setRuntimeParent(_jettag_c_iterate_254_10);
                                _jettag_c_if_257_13.setTagInfo(_td_c_if_257_13);
                                _jettag_c_if_257_13.doStart(context, out);
                                while (_jettag_c_if_257_13.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_259_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_259_19); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_259_19.setRuntimeParent(_jettag_c_if_257_13);
                                    _jettag_c_iterate_259_19.setTagInfo(_td_c_iterate_259_19);
                                    _jettag_c_iterate_259_19.doStart(context, out);
                                    while (_jettag_c_iterate_259_19.okToProcessBody()) {
                                        // process only non composits or non aggregations and 
                                        RuntimeTagElement _jettag_c_if_261_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_261_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_261_18.setRuntimeParent(_jettag_c_iterate_259_19);
                                        _jettag_c_if_261_18.setTagInfo(_td_c_if_261_18);
                                        _jettag_c_if_261_18.doStart(context, out);
                                        while (_jettag_c_if_261_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_262_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_262_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_262_19.setRuntimeParent(_jettag_c_if_261_18);
                                            _jettag_c_setVariable_262_19.setTagInfo(_td_c_setVariable_262_19);
                                            _jettag_c_setVariable_262_19.doStart(context, out);
                                            _jettag_c_setVariable_262_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_264_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_264_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_264_21.setRuntimeParent(_jettag_c_if_261_18);
                                            _jettag_c_if_264_21.setTagInfo(_td_c_if_264_21);
                                            _jettag_c_if_264_21.doStart(context, out);
                                            while (_jettag_c_if_264_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_266_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_266_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_266_19.setRuntimeParent(_jettag_c_if_264_21);
                                                _jettag_c_if_266_19.setTagInfo(_td_c_if_266_19);
                                                _jettag_c_if_266_19.doStart(context, out);
                                                while (_jettag_c_if_266_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_268_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_268_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_268_22.setRuntimeParent(_jettag_c_if_266_19);
                                                    _jettag_c_iterate_268_22.setTagInfo(_td_c_iterate_268_22);
                                                    _jettag_c_iterate_268_22.doStart(context, out);
                                                    while (_jettag_c_iterate_268_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_269_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_269_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_269_23.setRuntimeParent(_jettag_c_iterate_268_22);
                                                        _jettag_c_if_269_23.setTagInfo(_td_c_if_269_23);
                                                        _jettag_c_if_269_23.doStart(context, out);
                                                        while (_jettag_c_if_269_23.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\tif (");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 270, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".class.getName().contains(link)) {");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            //for composite add 
                                                            RuntimeTagElement _jettag_c_if_272_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_272_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_272_19.setRuntimeParent(_jettag_c_if_269_23);
                                                            _jettag_c_if_272_19.setTagInfo(_td_c_if_272_19);
                                                            _jettag_c_if_272_19.doStart(context, out);
                                                            while (_jettag_c_if_272_19.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trequest.get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 274, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(proxy.getId()).fire(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tnew Receiver<List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 275, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy>>() {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onSuccess(List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 278, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy> arg0) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tReadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 279, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanely readAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 279, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel= new ReadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 279, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanely(arg0);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\treadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 280, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel.parentTreeClass = link;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 281, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.clear();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 283, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel().add(readAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 283, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 284, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tnew ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 285, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("OptionsPanel(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOptionsCompositeType.ADD));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_272_19.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_272_19.doEnd();
                                                            //for non composite add_all 
                                                            RuntimeTagElement _jettag_c_if_292_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_292_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_292_19.setRuntimeParent(_jettag_c_if_269_23);
                                                            _jettag_c_if_292_19.setTagInfo(_td_c_if_292_19);
                                                            _jettag_c_if_292_19.doStart(context, out);
                                                            while (_jettag_c_if_292_19.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tString[] ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 293, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Columns = { ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                RuntimeTagElement _jettag_c_iterate_294_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_294_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_iterate_294_20.setRuntimeParent(_jettag_c_if_292_19);
                                                                _jettag_c_iterate_294_20.setTagInfo(_td_c_iterate_294_20);
                                                                _jettag_c_iterate_294_20.doStart(context, out);
                                                                while (_jettag_c_iterate_294_20.okToProcessBody()) {
                                                                    // processes the premitive Datatypes 
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_c_choose_296_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_296_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_c_choose_296_22.setRuntimeParent(_jettag_c_iterate_294_20);
                                                                    _jettag_c_choose_296_22.setTagInfo(_td_c_choose_296_22);
                                                                    _jettag_c_choose_296_22.doStart(context, out);
                                                                    JET2Writer _jettag_c_choose_296_22_saved_out = out;
                                                                    while (_jettag_c_choose_296_22.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write(" ");  //$NON-NLS-1$        
                                                                        RuntimeTagElement _jettag_c_when_296_92 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_296_92); //$NON-NLS-1$ //$NON-NLS-2$
                                                                        _jettag_c_when_296_92.setRuntimeParent(_jettag_c_choose_296_22);
                                                                        _jettag_c_when_296_92.setTagInfo(_td_c_when_296_92);
                                                                        _jettag_c_when_296_92.doStart(context, out);
                                                                        JET2Writer _jettag_c_when_296_92_saved_out = out;
                                                                        while (_jettag_c_when_296_92.okToProcessBody()) {
                                                                            out = out.newNestedContentWriter();
                                                                            out.write(" \"");  //$NON-NLS-1$        
                                                                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 296, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                            out.write("\", ");  //$NON-NLS-1$        
                                                                            _jettag_c_when_296_92.handleBodyContent(out);
                                                                        }
                                                                        out = _jettag_c_when_296_92_saved_out;
                                                                        _jettag_c_when_296_92.doEnd();
                                                                        out.write(" ");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        _jettag_c_choose_296_22.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_c_choose_296_22_saved_out;
                                                                    _jettag_c_choose_296_22.doEnd();
                                                                    _jettag_c_iterate_294_20.handleBodyContent(out);
                                                                }
                                                                _jettag_c_iterate_294_20.doEnd();
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t };");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$packageName}", 300, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 300, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 300, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Service.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 300, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("ServiceAsync.instance().get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 300, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sMultiSelect(");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tproxy.getId(),");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 301, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Columns,new ALAsyncCallback<MultiSelectObjy>() {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(MultiSelectObjy arg0) {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 304, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.clear();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 306, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.instance().getEntityPanel()..add(new Select");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 306, 105)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panely(\"");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 306, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s\",Tree");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 306, 152)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panely.this,arg0));\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_292_19.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_292_19.doEnd();
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write(NL);         
                                                            _jettag_c_if_269_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_269_23.doEnd();
                                                        _jettag_c_iterate_268_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_268_22.doEnd();
                                                    _jettag_c_if_266_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_266_19.doEnd();
                                                _jettag_c_if_264_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_264_21.doEnd();
                                            _jettag_c_if_261_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_261_18.doEnd();
                                        _jettag_c_iterate_259_19.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_259_19.doEnd();
                                    out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_257_13.handleBodyContent(out);
                                }
                                _jettag_c_if_257_13.doEnd();
                                _jettag_c_iterate_254_10.handleBodyContent(out);
                            }
                            _jettag_c_iterate_254_10.doEnd();
                            _jettag_c_iterate_253_9.handleBodyContent(out);
                        }
                        _jettag_c_iterate_253_9.doEnd();
                        _jettag_c_iterate_252_8.handleBodyContent(out);
                    }
                    _jettag_c_iterate_252_8.doEnd();
                    _jettag_c_if_249_1.handleBodyContent(out);
                }
                _jettag_c_if_249_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_c_setVariable_326_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_326_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_326_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_326_1.setTagInfo(_td_c_setVariable_326_1);
                _jettag_c_setVariable_326_1.doStart(context, out);
                _jettag_c_setVariable_326_1.doEnd();
                //process 0 level class relations 
                RuntimeTagElement _jettag_c_iterate_328_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_328_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_328_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_328_1.setTagInfo(_td_c_iterate_328_1);
                _jettag_c_iterate_328_1.doStart(context, out);
                while (_jettag_c_iterate_328_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_329_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_329_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_329_2.setRuntimeParent(_jettag_c_iterate_328_1);
                    _jettag_c_iterate_329_2.setTagInfo(_td_c_iterate_329_2);
                    _jettag_c_iterate_329_2.doStart(context, out);
                    while (_jettag_c_iterate_329_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_330_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_330_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_330_3.setRuntimeParent(_jettag_c_iterate_329_2);
                        _jettag_c_iterate_330_3.setTagInfo(_td_c_iterate_330_3);
                        _jettag_c_iterate_330_3.doStart(context, out);
                        while (_jettag_c_iterate_330_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_331_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_331_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_331_4.setRuntimeParent(_jettag_c_iterate_330_3);
                            _jettag_c_setVariable_331_4.setTagInfo(_td_c_setVariable_331_4);
                            _jettag_c_setVariable_331_4.doStart(context, out);
                            _jettag_c_setVariable_331_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_333_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_333_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_333_6.setRuntimeParent(_jettag_c_iterate_330_3);
                            _jettag_c_if_333_6.setTagInfo(_td_c_if_333_6);
                            _jettag_c_if_333_6.doStart(context, out);
                            while (_jettag_c_if_333_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_335_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_335_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_335_12.setRuntimeParent(_jettag_c_if_333_6);
                                _jettag_c_iterate_335_12.setTagInfo(_td_c_iterate_335_12);
                                _jettag_c_iterate_335_12.doStart(context, out);
                                while (_jettag_c_iterate_335_12.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_337_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_337_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_337_12.setRuntimeParent(_jettag_c_iterate_335_12);
                                    _jettag_c_if_337_12.setTagInfo(_td_c_if_337_12);
                                    _jettag_c_if_337_12.doStart(context, out);
                                    while (_jettag_c_if_337_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_338_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_338_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_338_12.setRuntimeParent(_jettag_c_if_337_12);
                                        _jettag_c_setVariable_338_12.setTagInfo(_td_c_setVariable_338_12);
                                        _jettag_c_setVariable_338_12.doStart(context, out);
                                        _jettag_c_setVariable_338_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_340_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_340_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_340_14.setRuntimeParent(_jettag_c_if_337_12);
                                        _jettag_c_if_340_14.setTagInfo(_td_c_if_340_14);
                                        _jettag_c_if_340_14.doStart(context, out);
                                        while (_jettag_c_if_340_14.okToProcessBody()) {
                                            // check to see if this is a navigable relation
                                            RuntimeTagElement _jettag_c_if_342_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_342_14); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_342_14.setRuntimeParent(_jettag_c_if_340_14);
                                            _jettag_c_if_342_14.setTagInfo(_td_c_if_342_14);
                                            _jettag_c_if_342_14.doStart(context, out);
                                            while (_jettag_c_if_342_14.okToProcessBody()) {
                                                // process many on target
                                                RuntimeTagElement _jettag_c_if_344_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_344_9); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_344_9.setRuntimeParent(_jettag_c_if_342_14);
                                                _jettag_c_if_344_9.setTagInfo(_td_c_if_344_9);
                                                _jettag_c_if_344_9.doStart(context, out);
                                                while (_jettag_c_if_344_9.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_345_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_345_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_345_11.setRuntimeParent(_jettag_c_if_344_9);
                                                    _jettag_c_if_345_11.setTagInfo(_td_c_if_345_11);
                                                    _jettag_c_if_345_11.doStart(context, out);
                                                    while (_jettag_c_if_345_11.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_347_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_347_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_347_15.setRuntimeParent(_jettag_c_if_345_11);
                                                        _jettag_c_iterate_347_15.setTagInfo(_td_c_iterate_347_15);
                                                        _jettag_c_iterate_347_15.doStart(context, out);
                                                        while (_jettag_c_iterate_347_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_348_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_348_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_348_16.setRuntimeParent(_jettag_c_iterate_347_15);
                                                            _jettag_c_if_348_16.setTagInfo(_td_c_if_348_16);
                                                            _jettag_c_if_348_16.doStart(context, out);
                                                            while (_jettag_c_if_348_16.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\tif (");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 349, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class.getName().contains(link)) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                //for composite add 
                                                                RuntimeTagElement _jettag_c_if_351_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_351_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_351_19.setRuntimeParent(_jettag_c_if_348_16);
                                                                _jettag_c_if_351_19.setTagInfo(_td_c_if_351_19);
                                                                _jettag_c_if_351_19.doStart(context, out);
                                                                while (_jettag_c_if_351_19.okToProcessBody()) {
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trequest.get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 353, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(proxy.getId()).fire(");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tnew Receiver<List<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 354, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Proxy>>() {");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onSuccess(List<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 357, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Proxy> arg0) {");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tReadAll");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 358, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sPanely readAll");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 358, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sPanel= new ReadAll");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 358, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sPanely(arg0);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\treadAll");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 359, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sPanel.parentTreeClass = link;\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 360, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Welcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.clear();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 362, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Welcome.instance().getEntityPanel().add(readAll");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 362, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sPanel);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 363, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tnew ");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 364, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("OptionsPanel(");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOptionsCompositeType.ADD));");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_351_19.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_351_19.doEnd();
                                                                //for non composite add_all 
                                                                RuntimeTagElement _jettag_c_if_371_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_371_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_371_19.setRuntimeParent(_jettag_c_if_348_16);
                                                                _jettag_c_if_371_19.setTagInfo(_td_c_if_371_19);
                                                                _jettag_c_if_371_19.doStart(context, out);
                                                                while (_jettag_c_if_371_19.okToProcessBody()) {
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tString[] ");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 372, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Columns = { ");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    RuntimeTagElement _jettag_c_iterate_373_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_373_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_c_iterate_373_20.setRuntimeParent(_jettag_c_if_371_19);
                                                                    _jettag_c_iterate_373_20.setTagInfo(_td_c_iterate_373_20);
                                                                    _jettag_c_iterate_373_20.doStart(context, out);
                                                                    while (_jettag_c_iterate_373_20.okToProcessBody()) {
                                                                        // processes the premitive Datatypes 
                                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ");  //$NON-NLS-1$        
                                                                        RuntimeTagElement _jettag_c_choose_375_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_375_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                                        _jettag_c_choose_375_22.setRuntimeParent(_jettag_c_iterate_373_20);
                                                                        _jettag_c_choose_375_22.setTagInfo(_td_c_choose_375_22);
                                                                        _jettag_c_choose_375_22.doStart(context, out);
                                                                        JET2Writer _jettag_c_choose_375_22_saved_out = out;
                                                                        while (_jettag_c_choose_375_22.okToProcessBody()) {
                                                                            out = out.newNestedContentWriter();
                                                                            out.write(" ");  //$NON-NLS-1$        
                                                                            RuntimeTagElement _jettag_c_when_375_92 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_375_92); //$NON-NLS-1$ //$NON-NLS-2$
                                                                            _jettag_c_when_375_92.setRuntimeParent(_jettag_c_choose_375_22);
                                                                            _jettag_c_when_375_92.setTagInfo(_td_c_when_375_92);
                                                                            _jettag_c_when_375_92.doStart(context, out);
                                                                            JET2Writer _jettag_c_when_375_92_saved_out = out;
                                                                            while (_jettag_c_when_375_92.okToProcessBody()) {
                                                                                out = out.newNestedContentWriter();
                                                                                out.write(" \"");  //$NON-NLS-1$        
                                                                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 375, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                                out.write("\", ");  //$NON-NLS-1$        
                                                                                _jettag_c_when_375_92.handleBodyContent(out);
                                                                            }
                                                                            out = _jettag_c_when_375_92_saved_out;
                                                                            _jettag_c_when_375_92.doEnd();
                                                                            out.write(" ");  //$NON-NLS-1$        
                                                                            out.write(NL);         
                                                                            _jettag_c_choose_375_22.handleBodyContent(out);
                                                                        }
                                                                        out = _jettag_c_choose_375_22_saved_out;
                                                                        _jettag_c_choose_375_22.doEnd();
                                                                        _jettag_c_iterate_373_20.handleBodyContent(out);
                                                                    }
                                                                    _jettag_c_iterate_373_20.doEnd();
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t };");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$packageName}", 379, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(".");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 379, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(".");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 379, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Service.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 379, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("ServiceAsync.instance().get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 379, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sMultiSelect(");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tproxy.getId(),");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 380, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Columns,new ALAsyncCallback<MultiSelectObjy>() {");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(MultiSelectObjy arg0) {\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 383, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Welcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.clear();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 385, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Welcome.instance().getEntityPanel().add(new Select");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 385, 104)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Panely(\"");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 385, 128)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s\",Tree");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 385, 151)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Panely.this,arg0));");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_371_19.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_371_19.doEnd();
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write(NL);         
                                                                _jettag_c_if_348_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_348_16.doEnd();
                                                            _jettag_c_iterate_347_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_347_15.doEnd();
                                                        _jettag_c_if_345_11.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_345_11.doEnd();
                                                    _jettag_c_if_344_9.handleBodyContent(out);
                                                }
                                                _jettag_c_if_344_9.doEnd();
                                                _jettag_c_if_342_14.handleBodyContent(out);
                                            }
                                            _jettag_c_if_342_14.doEnd();
                                            _jettag_c_if_340_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_340_14.doEnd();
                                        _jettag_c_if_337_12.handleBodyContent(out);
                                    }
                                    _jettag_c_if_337_12.doEnd();
                                    _jettag_c_iterate_335_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_335_12.doEnd();
                                _jettag_c_if_333_6.handleBodyContent(out);
                            }
                            _jettag_c_if_333_6.doEnd();
                            _jettag_c_iterate_330_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_330_3.doEnd();
                        _jettag_c_iterate_329_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_329_2.doEnd();
                    _jettag_c_iterate_328_1.handleBodyContent(out);
                }
                _jettag_c_iterate_328_1.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_405_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_405_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_405_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_405_1.setTagInfo(_td_f_message_405_1);
                _jettag_f_message_405_1.doStart(context, out);
                JET2Writer _jettag_f_message_405_1_saved_out = out;
                while (_jettag_f_message_405_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_405_1.handleBodyContent(out);
                }
                out = _jettag_f_message_405_1_saved_out;
                _jettag_f_message_405_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void showProxy() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
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
