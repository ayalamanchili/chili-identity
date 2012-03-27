package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_read_entityjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_read_entityjava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_setVariable_1_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            1, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_java_format_2_1 = new TagInfo("java:format", //$NON-NLS-1$
            2, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_27_1 = new TagInfo("c:if", //$NON-NLS-1$
            27, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_28_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            28, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_30_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            30, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_31_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            31, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_32_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            32, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_33_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            33, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_35_13 = new TagInfo("c:if", //$NON-NLS-1$
            35, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_37_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            37, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_39_18 = new TagInfo("c:if", //$NON-NLS-1$
            39, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_40_18 = new TagInfo("c:if", //$NON-NLS-1$
            40, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_41_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            41, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_43_21 = new TagInfo("c:if", //$NON-NLS-1$
            43, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_45_19 = new TagInfo("c:if", //$NON-NLS-1$
            45, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_47_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            47, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_48_23 = new TagInfo("c:if", //$NON-NLS-1$
            48, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_64_1 = new TagInfo("c:if", //$NON-NLS-1$
            64, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_65_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            65, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_67_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            67, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_68_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            68, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_69_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            69, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_70_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            70, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_72_13 = new TagInfo("c:if", //$NON-NLS-1$
            72, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_74_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            74, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_76_18 = new TagInfo("c:if", //$NON-NLS-1$
            76, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_77_18 = new TagInfo("c:if", //$NON-NLS-1$
            77, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_78_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            78, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_80_21 = new TagInfo("c:if", //$NON-NLS-1$
            80, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_82_19 = new TagInfo("c:if", //$NON-NLS-1$
            82, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_84_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            84, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_85_23 = new TagInfo("c:if", //$NON-NLS-1$
            85, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_101_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            101, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_103_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            103, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_104_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            104, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_105_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            105, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_106_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            106, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_108_6 = new TagInfo("c:if", //$NON-NLS-1$
            108, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_110_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            110, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_112_12 = new TagInfo("c:if", //$NON-NLS-1$
            112, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_113_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            113, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_115_14 = new TagInfo("c:if", //$NON-NLS-1$
            115, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_117_14 = new TagInfo("c:if", //$NON-NLS-1$
            117, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_119_9 = new TagInfo("c:if", //$NON-NLS-1$
            119, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_120_11 = new TagInfo("c:if", //$NON-NLS-1$
            120, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_122_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            122, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_123_16 = new TagInfo("c:if", //$NON-NLS-1$
            123, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_172_2 = new TagInfo("c:if", //$NON-NLS-1$
            172, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_173_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            173, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_181_2 = new TagInfo("c:if", //$NON-NLS-1$
            181, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_182_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            182, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_190_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            190, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_210_1 = new TagInfo("c:if", //$NON-NLS-1$
            210, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_211_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            211, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_213_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            213, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_214_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            214, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_215_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            215, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_216_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            216, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_218_13 = new TagInfo("c:if", //$NON-NLS-1$
            218, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_220_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            220, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_222_18 = new TagInfo("c:if", //$NON-NLS-1$
            222, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_223_18 = new TagInfo("c:if", //$NON-NLS-1$
            223, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_224_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            224, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_226_21 = new TagInfo("c:if", //$NON-NLS-1$
            226, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_228_19 = new TagInfo("c:if", //$NON-NLS-1$
            228, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_230_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            230, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_231_23 = new TagInfo("c:if", //$NON-NLS-1$
            231, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_252_1 = new TagInfo("c:if", //$NON-NLS-1$
            252, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_253_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            253, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_255_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            255, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_256_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            256, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_257_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            257, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_258_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            258, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_260_13 = new TagInfo("c:if", //$NON-NLS-1$
            260, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_262_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            262, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_264_18 = new TagInfo("c:if", //$NON-NLS-1$
            264, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_265_18 = new TagInfo("c:if", //$NON-NLS-1$
            265, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_266_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            266, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_268_21 = new TagInfo("c:if", //$NON-NLS-1$
            268, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_270_19 = new TagInfo("c:if", //$NON-NLS-1$
            270, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_272_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            272, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_273_23 = new TagInfo("c:if", //$NON-NLS-1$
            273, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_294_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            294, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_296_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            296, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_297_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            297, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_298_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            298, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_299_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            299, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_301_6 = new TagInfo("c:if", //$NON-NLS-1$
            301, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_303_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            303, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_305_12 = new TagInfo("c:if", //$NON-NLS-1$
            305, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_306_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            306, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_308_14 = new TagInfo("c:if", //$NON-NLS-1$
            308, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_310_14 = new TagInfo("c:if", //$NON-NLS-1$
            310, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_312_9 = new TagInfo("c:if", //$NON-NLS-1$
            312, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_313_11 = new TagInfo("c:if", //$NON-NLS-1$
            313, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_315_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            315, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_316_16 = new TagInfo("c:if", //$NON-NLS-1$
            316, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_c_setVariable_1_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_1_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_1_1.setRuntimeParent(null);
        _jettag_c_setVariable_1_1.setTagInfo(_td_c_setVariable_1_1);
        _jettag_c_setVariable_1_1.doStart(context, out);
        _jettag_c_setVariable_1_1.doEnd();
        RuntimeTagElement _jettag_java_format_2_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "format", "java:format", _td_java_format_2_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_format_2_1.setRuntimeParent(null);
        _jettag_java_format_2_1.setTagInfo(_td_java_format_2_1);
        _jettag_java_format_2_1.doStart(context, out);
        JET2Writer _jettag_java_format_2_1_saved_out = out;
        while (_jettag_java_format_2_1.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(NL);         
            out.write("package ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 3, 9)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$package/@name}", 3, 29)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 3, 47)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 4, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 4, 28)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Main;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 5, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".entity.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 5, 27)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 5, 57)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.http.HttpHelper;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.app.Activity;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.os.Bundle;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.util.Log;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.views.ViewTextField;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 11, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.R;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.http.AsyncHttpGet;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.content.Intent;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.os.Bundle;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.Menu;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.MenuInflater;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.MenuItem;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.Button;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View.OnClickListener;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.Window;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.TextView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.TextView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.Toast;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            //process level 1 generizations 
            RuntimeTagElement _jettag_c_if_27_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_27_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_27_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_if_27_1.setTagInfo(_td_c_if_27_1);
            _jettag_c_if_27_1.doStart(context, out);
            while (_jettag_c_if_27_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_setVariable_28_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_28_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_28_6.setRuntimeParent(_jettag_c_if_27_1);
                _jettag_c_setVariable_28_6.setTagInfo(_td_c_setVariable_28_6);
                _jettag_c_setVariable_28_6.doStart(context, out);
                _jettag_c_setVariable_28_6.doEnd();
                // process the assocations for level 1 class 
                RuntimeTagElement _jettag_c_iterate_30_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_30_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_30_8.setRuntimeParent(_jettag_c_if_27_1);
                _jettag_c_iterate_30_8.setTagInfo(_td_c_iterate_30_8);
                _jettag_c_iterate_30_8.doStart(context, out);
                while (_jettag_c_iterate_30_8.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_31_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_31_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_31_9.setRuntimeParent(_jettag_c_iterate_30_8);
                    _jettag_c_iterate_31_9.setTagInfo(_td_c_iterate_31_9);
                    _jettag_c_iterate_31_9.doStart(context, out);
                    while (_jettag_c_iterate_31_9.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_32_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_32_10); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_32_10.setRuntimeParent(_jettag_c_iterate_31_9);
                        _jettag_c_iterate_32_10.setTagInfo(_td_c_iterate_32_10);
                        _jettag_c_iterate_32_10.doStart(context, out);
                        while (_jettag_c_iterate_32_10.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_33_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_33_11); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_33_11.setRuntimeParent(_jettag_c_iterate_32_10);
                            _jettag_c_setVariable_33_11.setTagInfo(_td_c_setVariable_33_11);
                            _jettag_c_setVariable_33_11.doStart(context, out);
                            _jettag_c_setVariable_33_11.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_35_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_35_13); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_35_13.setRuntimeParent(_jettag_c_iterate_32_10);
                            _jettag_c_if_35_13.setTagInfo(_td_c_if_35_13);
                            _jettag_c_if_35_13.doStart(context, out);
                            while (_jettag_c_if_35_13.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_37_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_37_19); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_37_19.setRuntimeParent(_jettag_c_if_35_13);
                                _jettag_c_iterate_37_19.setTagInfo(_td_c_iterate_37_19);
                                _jettag_c_iterate_37_19.doStart(context, out);
                                while (_jettag_c_iterate_37_19.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_39_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_39_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_39_18.setRuntimeParent(_jettag_c_iterate_37_19);
                                    _jettag_c_if_39_18.setTagInfo(_td_c_if_39_18);
                                    _jettag_c_if_39_18.doStart(context, out);
                                    while (_jettag_c_if_39_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_40_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_40_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_40_18.setRuntimeParent(_jettag_c_if_39_18);
                                        _jettag_c_if_40_18.setTagInfo(_td_c_if_40_18);
                                        _jettag_c_if_40_18.doStart(context, out);
                                        while (_jettag_c_if_40_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_41_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_41_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_41_19.setRuntimeParent(_jettag_c_if_40_18);
                                            _jettag_c_setVariable_41_19.setTagInfo(_td_c_setVariable_41_19);
                                            _jettag_c_setVariable_41_19.doStart(context, out);
                                            _jettag_c_setVariable_41_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_43_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_43_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_43_21.setRuntimeParent(_jettag_c_if_40_18);
                                            _jettag_c_if_43_21.setTagInfo(_td_c_if_43_21);
                                            _jettag_c_if_43_21.doStart(context, out);
                                            while (_jettag_c_if_43_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_45_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_45_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_45_19.setRuntimeParent(_jettag_c_if_43_21);
                                                _jettag_c_if_45_19.setTagInfo(_td_c_if_45_19);
                                                _jettag_c_if_45_19.doStart(context, out);
                                                while (_jettag_c_if_45_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_47_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_47_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_47_22.setRuntimeParent(_jettag_c_if_45_19);
                                                    _jettag_c_iterate_47_22.setTagInfo(_td_c_iterate_47_22);
                                                    _jettag_c_iterate_47_22.doStart(context, out);
                                                    while (_jettag_c_iterate_47_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_48_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_48_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_48_23.setRuntimeParent(_jettag_c_iterate_47_22);
                                                        _jettag_c_if_48_23.setTagInfo(_td_c_if_48_23);
                                                        _jettag_c_if_48_23.doStart(context, out);
                                                        while (_jettag_c_if_48_23.okToProcessBody()) {
                                                            out.write("import ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 49, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".android.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 49, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 49, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".ReadAll");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 49, 94)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s;");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_48_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_48_23.doEnd();
                                                        _jettag_c_iterate_47_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_47_22.doEnd();
                                                    _jettag_c_if_45_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_45_19.doEnd();
                                                _jettag_c_if_43_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_43_21.doEnd();
                                            _jettag_c_if_40_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_40_18.doEnd();
                                        _jettag_c_if_39_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_39_18.doEnd();
                                    _jettag_c_iterate_37_19.handleBodyContent(out);
                                }
                                _jettag_c_iterate_37_19.doEnd();
                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_35_13.handleBodyContent(out);
                            }
                            _jettag_c_if_35_13.doEnd();
                            _jettag_c_iterate_32_10.handleBodyContent(out);
                        }
                        _jettag_c_iterate_32_10.doEnd();
                        _jettag_c_iterate_31_9.handleBodyContent(out);
                    }
                    _jettag_c_iterate_31_9.doEnd();
                    _jettag_c_iterate_30_8.handleBodyContent(out);
                }
                _jettag_c_iterate_30_8.doEnd();
                _jettag_c_if_27_1.handleBodyContent(out);
            }
            _jettag_c_if_27_1.doEnd();
            //process level 2 generizations 
            RuntimeTagElement _jettag_c_if_64_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_64_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_64_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_if_64_1.setTagInfo(_td_c_if_64_1);
            _jettag_c_if_64_1.doStart(context, out);
            while (_jettag_c_if_64_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_setVariable_65_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_65_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_65_6.setRuntimeParent(_jettag_c_if_64_1);
                _jettag_c_setVariable_65_6.setTagInfo(_td_c_setVariable_65_6);
                _jettag_c_setVariable_65_6.doStart(context, out);
                _jettag_c_setVariable_65_6.doEnd();
                // process the assocations for level 1 class 
                RuntimeTagElement _jettag_c_iterate_67_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_67_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_67_8.setRuntimeParent(_jettag_c_if_64_1);
                _jettag_c_iterate_67_8.setTagInfo(_td_c_iterate_67_8);
                _jettag_c_iterate_67_8.doStart(context, out);
                while (_jettag_c_iterate_67_8.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_68_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_68_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_68_9.setRuntimeParent(_jettag_c_iterate_67_8);
                    _jettag_c_iterate_68_9.setTagInfo(_td_c_iterate_68_9);
                    _jettag_c_iterate_68_9.doStart(context, out);
                    while (_jettag_c_iterate_68_9.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_69_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_69_10); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_69_10.setRuntimeParent(_jettag_c_iterate_68_9);
                        _jettag_c_iterate_69_10.setTagInfo(_td_c_iterate_69_10);
                        _jettag_c_iterate_69_10.doStart(context, out);
                        while (_jettag_c_iterate_69_10.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_70_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_70_11); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_70_11.setRuntimeParent(_jettag_c_iterate_69_10);
                            _jettag_c_setVariable_70_11.setTagInfo(_td_c_setVariable_70_11);
                            _jettag_c_setVariable_70_11.doStart(context, out);
                            _jettag_c_setVariable_70_11.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_72_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_72_13); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_72_13.setRuntimeParent(_jettag_c_iterate_69_10);
                            _jettag_c_if_72_13.setTagInfo(_td_c_if_72_13);
                            _jettag_c_if_72_13.doStart(context, out);
                            while (_jettag_c_if_72_13.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_74_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_74_19); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_74_19.setRuntimeParent(_jettag_c_if_72_13);
                                _jettag_c_iterate_74_19.setTagInfo(_td_c_iterate_74_19);
                                _jettag_c_iterate_74_19.doStart(context, out);
                                while (_jettag_c_iterate_74_19.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_76_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_76_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_76_18.setRuntimeParent(_jettag_c_iterate_74_19);
                                    _jettag_c_if_76_18.setTagInfo(_td_c_if_76_18);
                                    _jettag_c_if_76_18.doStart(context, out);
                                    while (_jettag_c_if_76_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_77_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_77_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_77_18.setRuntimeParent(_jettag_c_if_76_18);
                                        _jettag_c_if_77_18.setTagInfo(_td_c_if_77_18);
                                        _jettag_c_if_77_18.doStart(context, out);
                                        while (_jettag_c_if_77_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_78_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_78_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_78_19.setRuntimeParent(_jettag_c_if_77_18);
                                            _jettag_c_setVariable_78_19.setTagInfo(_td_c_setVariable_78_19);
                                            _jettag_c_setVariable_78_19.doStart(context, out);
                                            _jettag_c_setVariable_78_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_80_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_80_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_80_21.setRuntimeParent(_jettag_c_if_77_18);
                                            _jettag_c_if_80_21.setTagInfo(_td_c_if_80_21);
                                            _jettag_c_if_80_21.doStart(context, out);
                                            while (_jettag_c_if_80_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_82_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_82_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_82_19.setRuntimeParent(_jettag_c_if_80_21);
                                                _jettag_c_if_82_19.setTagInfo(_td_c_if_82_19);
                                                _jettag_c_if_82_19.doStart(context, out);
                                                while (_jettag_c_if_82_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_84_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_84_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_84_22.setRuntimeParent(_jettag_c_if_82_19);
                                                    _jettag_c_iterate_84_22.setTagInfo(_td_c_iterate_84_22);
                                                    _jettag_c_iterate_84_22.doStart(context, out);
                                                    while (_jettag_c_iterate_84_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_85_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_85_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_85_23.setRuntimeParent(_jettag_c_iterate_84_22);
                                                        _jettag_c_if_85_23.setTagInfo(_td_c_if_85_23);
                                                        _jettag_c_if_85_23.doStart(context, out);
                                                        while (_jettag_c_if_85_23.okToProcessBody()) {
                                                            out.write("import ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 86, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".android.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 86, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 86, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".ReadAll");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 86, 94)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s;");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_85_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_85_23.doEnd();
                                                        _jettag_c_iterate_84_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_84_22.doEnd();
                                                    _jettag_c_if_82_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_82_19.doEnd();
                                                _jettag_c_if_80_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_80_21.doEnd();
                                            _jettag_c_if_77_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_77_18.doEnd();
                                        _jettag_c_if_76_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_76_18.doEnd();
                                    _jettag_c_iterate_74_19.handleBodyContent(out);
                                }
                                _jettag_c_iterate_74_19.doEnd();
                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_72_13.handleBodyContent(out);
                            }
                            _jettag_c_if_72_13.doEnd();
                            _jettag_c_iterate_69_10.handleBodyContent(out);
                        }
                        _jettag_c_iterate_69_10.doEnd();
                        _jettag_c_iterate_68_9.handleBodyContent(out);
                    }
                    _jettag_c_iterate_68_9.doEnd();
                    _jettag_c_iterate_67_8.handleBodyContent(out);
                }
                _jettag_c_iterate_67_8.doEnd();
                _jettag_c_if_64_1.handleBodyContent(out);
            }
            _jettag_c_if_64_1.doEnd();
            out.write(NL);         
            RuntimeTagElement _jettag_c_setVariable_101_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_101_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_101_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_setVariable_101_1.setTagInfo(_td_c_setVariable_101_1);
            _jettag_c_setVariable_101_1.doStart(context, out);
            _jettag_c_setVariable_101_1.doEnd();
            //process 0 level class relations 
            RuntimeTagElement _jettag_c_iterate_103_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_103_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_103_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_iterate_103_1.setTagInfo(_td_c_iterate_103_1);
            _jettag_c_iterate_103_1.doStart(context, out);
            while (_jettag_c_iterate_103_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_104_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_104_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_104_2.setRuntimeParent(_jettag_c_iterate_103_1);
                _jettag_c_iterate_104_2.setTagInfo(_td_c_iterate_104_2);
                _jettag_c_iterate_104_2.doStart(context, out);
                while (_jettag_c_iterate_104_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_105_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_105_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_105_3.setRuntimeParent(_jettag_c_iterate_104_2);
                    _jettag_c_iterate_105_3.setTagInfo(_td_c_iterate_105_3);
                    _jettag_c_iterate_105_3.doStart(context, out);
                    while (_jettag_c_iterate_105_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_106_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_106_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_106_4.setRuntimeParent(_jettag_c_iterate_105_3);
                        _jettag_c_setVariable_106_4.setTagInfo(_td_c_setVariable_106_4);
                        _jettag_c_setVariable_106_4.doStart(context, out);
                        _jettag_c_setVariable_106_4.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_108_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_108_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_108_6.setRuntimeParent(_jettag_c_iterate_105_3);
                        _jettag_c_if_108_6.setTagInfo(_td_c_if_108_6);
                        _jettag_c_if_108_6.doStart(context, out);
                        while (_jettag_c_if_108_6.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_110_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_110_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_110_12.setRuntimeParent(_jettag_c_if_108_6);
                            _jettag_c_iterate_110_12.setTagInfo(_td_c_iterate_110_12);
                            _jettag_c_iterate_110_12.doStart(context, out);
                            while (_jettag_c_iterate_110_12.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_112_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_112_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_112_12.setRuntimeParent(_jettag_c_iterate_110_12);
                                _jettag_c_if_112_12.setTagInfo(_td_c_if_112_12);
                                _jettag_c_if_112_12.doStart(context, out);
                                while (_jettag_c_if_112_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_113_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_113_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_113_12.setRuntimeParent(_jettag_c_if_112_12);
                                    _jettag_c_setVariable_113_12.setTagInfo(_td_c_setVariable_113_12);
                                    _jettag_c_setVariable_113_12.doStart(context, out);
                                    _jettag_c_setVariable_113_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_115_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_115_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_115_14.setRuntimeParent(_jettag_c_if_112_12);
                                    _jettag_c_if_115_14.setTagInfo(_td_c_if_115_14);
                                    _jettag_c_if_115_14.doStart(context, out);
                                    while (_jettag_c_if_115_14.okToProcessBody()) {
                                        // check to see if this is a navigable relation
                                        RuntimeTagElement _jettag_c_if_117_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_117_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_117_14.setRuntimeParent(_jettag_c_if_115_14);
                                        _jettag_c_if_117_14.setTagInfo(_td_c_if_117_14);
                                        _jettag_c_if_117_14.doStart(context, out);
                                        while (_jettag_c_if_117_14.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_119_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_119_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_119_9.setRuntimeParent(_jettag_c_if_117_14);
                                            _jettag_c_if_119_9.setTagInfo(_td_c_if_119_9);
                                            _jettag_c_if_119_9.doStart(context, out);
                                            while (_jettag_c_if_119_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_120_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_120_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_120_11.setRuntimeParent(_jettag_c_if_119_9);
                                                _jettag_c_if_120_11.setTagInfo(_td_c_if_120_11);
                                                _jettag_c_if_120_11.doStart(context, out);
                                                while (_jettag_c_if_120_11.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_122_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_122_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_122_15.setRuntimeParent(_jettag_c_if_120_11);
                                                    _jettag_c_iterate_122_15.setTagInfo(_td_c_iterate_122_15);
                                                    _jettag_c_iterate_122_15.doStart(context, out);
                                                    while (_jettag_c_iterate_122_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_123_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_123_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_123_16.setRuntimeParent(_jettag_c_iterate_122_15);
                                                        _jettag_c_if_123_16.setTagInfo(_td_c_if_123_16);
                                                        _jettag_c_if_123_16.doStart(context, out);
                                                        while (_jettag_c_if_123_16.okToProcessBody()) {
                                                            out.write("import ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 124, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".android.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 124, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 124, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".ReadAll");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 124, 94)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s;");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_123_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_123_16.doEnd();
                                                        _jettag_c_iterate_122_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_122_15.doEnd();
                                                    _jettag_c_if_120_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_120_11.doEnd();
                                                _jettag_c_if_119_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_119_9.doEnd();
                                            _jettag_c_if_117_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_117_14.doEnd();
                                        _jettag_c_if_115_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_115_14.doEnd();
                                    _jettag_c_if_112_12.handleBodyContent(out);
                                }
                                _jettag_c_if_112_12.doEnd();
                                _jettag_c_iterate_110_12.handleBodyContent(out);
                            }
                            _jettag_c_iterate_110_12.doEnd();
                            _jettag_c_if_108_6.handleBodyContent(out);
                        }
                        _jettag_c_if_108_6.doEnd();
                        _jettag_c_iterate_105_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_105_3.doEnd();
                    _jettag_c_iterate_104_2.handleBodyContent(out);
                }
                _jettag_c_iterate_104_2.doEnd();
                _jettag_c_iterate_103_1.handleBodyContent(out);
            }
            _jettag_c_iterate_103_1.doEnd();
            out.write(NL);         
            out.write("public class Read");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 138, 18)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" extends Activity implements OnClickListener {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tprotected ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 140, 12)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 140, 28)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected Button done;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected Button update;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected Button delete;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onCreate(Bundle savedInstanceState) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsuper.onCreate(savedInstanceState);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\trequestWindowFeature(Window.FEATURE_CUSTOM_TITLE);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsetContentView(R.layout.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 149, 27)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_read);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcustomizeTitle();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdone = (Button) findViewById(R.id.read_done);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdone.setOnClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tupdate = (Button) findViewById(R.id.read_update);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tupdate.setOnClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdelete = (Button) findViewById(R.id.read_delete);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdelete.setOnClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void customizeTitle(){");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tgetWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 160, 67)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_title_bar);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t     TextView mytitletext = (TextView) findViewById(R.id.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 161, 59)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_title_text);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t     mytitletext.setText(\"Read ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 162, 33)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" Panel\");\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void load(String xml) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tObject result = HttpHelper.xstream.fromXML(xml);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (result instanceof String) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\treturn;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 170, 4)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" = (");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 170, 35)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(") result;");  //$NON-NLS-1$        
            out.write(NL);         
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_172_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_172_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_172_2.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_if_172_2.setTagInfo(_td_c_if_172_2);
            _jettag_c_if_172_2.doStart(context, out);
            while (_jettag_c_if_172_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_173_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_173_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_173_5.setRuntimeParent(_jettag_c_if_172_2);
                _jettag_c_iterate_173_5.setTagInfo(_td_c_iterate_173_5);
                _jettag_c_iterate_173_5.doStart(context, out);
                while (_jettag_c_iterate_173_5.okToProcessBody()) {
                    out.write("\t\t\t\t\t\tViewTextField ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 174, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_textview = (ViewTextField) this.findViewById(R.id.");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 174, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 174, 124)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(");");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 175, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_textview.setLabel(\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 175, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\");");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\tif (");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 176, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".get");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 176, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("() != null)");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 177, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_textview.setValue(");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 177, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".get");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 177, 88)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("().toString());");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_iterate_173_5.handleBodyContent(out);
                }
                _jettag_c_iterate_173_5.doEnd();
                _jettag_c_if_172_2.handleBodyContent(out);
            }
            _jettag_c_if_172_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_181_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_181_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_181_2.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_if_181_2.setTagInfo(_td_c_if_181_2);
            _jettag_c_if_181_2.doStart(context, out);
            while (_jettag_c_if_181_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_182_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_182_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_182_5.setRuntimeParent(_jettag_c_if_181_2);
                _jettag_c_iterate_182_5.setTagInfo(_td_c_iterate_182_5);
                _jettag_c_iterate_182_5.doStart(context, out);
                while (_jettag_c_iterate_182_5.okToProcessBody()) {
                    out.write("\t\t\t\t\t\tViewTextField ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 183, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_textview = (ViewTextField) this.findViewById(R.id.");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 183, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_read_");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 183, 124)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(");");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 184, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_textview.setLabel(\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 184, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\");");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\tif (");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 185, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".get");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 185, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("() != null)");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 186, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("_textview.setValue(");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 186, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".get");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 186, 88)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("().toString());");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_iterate_182_5.handleBodyContent(out);
                }
                _jettag_c_iterate_182_5.doEnd();
                _jettag_c_if_181_2.handleBodyContent(out);
            }
            _jettag_c_if_181_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_190_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_190_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_190_5.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_iterate_190_5.setTagInfo(_td_c_iterate_190_5);
            _jettag_c_iterate_190_5.doStart(context, out);
            while (_jettag_c_iterate_190_5.okToProcessBody()) {
                out.write("\t\t\t\t\t\tViewTextField ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 191, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("_textview = (ViewTextField) this.findViewById(R.id.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 191, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("_read_");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 191, 124)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 192, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("_textview.setLabel(\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 192, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tif (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 193, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".get");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 193, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("() != null)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 194, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("_textview.setValue(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 194, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".get");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 194, 88)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("().toString());");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_c_iterate_190_5.handleBodyContent(out);
            }
            _jettag_c_iterate_190_5.doEnd();
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic boolean onCreateOptionsMenu(Menu menu) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tMenuInflater inflater = getMenuInflater();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tinflater.inflate(R.menu.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 202, 27)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_menu, menu);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn true;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic boolean onOptionsItemSelected(MenuItem item) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tswitch (item.getItemId()) {");  //$NON-NLS-1$        
            out.write(NL);         
            //process level 1 generizations 
            RuntimeTagElement _jettag_c_if_210_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_210_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_210_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_if_210_1.setTagInfo(_td_c_if_210_1);
            _jettag_c_if_210_1.doStart(context, out);
            while (_jettag_c_if_210_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_setVariable_211_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_211_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_211_6.setRuntimeParent(_jettag_c_if_210_1);
                _jettag_c_setVariable_211_6.setTagInfo(_td_c_setVariable_211_6);
                _jettag_c_setVariable_211_6.doStart(context, out);
                _jettag_c_setVariable_211_6.doEnd();
                // process the assocations for level 1 class 
                RuntimeTagElement _jettag_c_iterate_213_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_213_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_213_8.setRuntimeParent(_jettag_c_if_210_1);
                _jettag_c_iterate_213_8.setTagInfo(_td_c_iterate_213_8);
                _jettag_c_iterate_213_8.doStart(context, out);
                while (_jettag_c_iterate_213_8.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_214_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_214_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_214_9.setRuntimeParent(_jettag_c_iterate_213_8);
                    _jettag_c_iterate_214_9.setTagInfo(_td_c_iterate_214_9);
                    _jettag_c_iterate_214_9.doStart(context, out);
                    while (_jettag_c_iterate_214_9.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_215_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_215_10); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_215_10.setRuntimeParent(_jettag_c_iterate_214_9);
                        _jettag_c_iterate_215_10.setTagInfo(_td_c_iterate_215_10);
                        _jettag_c_iterate_215_10.doStart(context, out);
                        while (_jettag_c_iterate_215_10.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_216_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_216_11); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_216_11.setRuntimeParent(_jettag_c_iterate_215_10);
                            _jettag_c_setVariable_216_11.setTagInfo(_td_c_setVariable_216_11);
                            _jettag_c_setVariable_216_11.doStart(context, out);
                            _jettag_c_setVariable_216_11.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_218_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_218_13); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_218_13.setRuntimeParent(_jettag_c_iterate_215_10);
                            _jettag_c_if_218_13.setTagInfo(_td_c_if_218_13);
                            _jettag_c_if_218_13.doStart(context, out);
                            while (_jettag_c_if_218_13.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_220_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_220_19); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_220_19.setRuntimeParent(_jettag_c_if_218_13);
                                _jettag_c_iterate_220_19.setTagInfo(_td_c_iterate_220_19);
                                _jettag_c_iterate_220_19.doStart(context, out);
                                while (_jettag_c_iterate_220_19.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_222_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_222_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_222_18.setRuntimeParent(_jettag_c_iterate_220_19);
                                    _jettag_c_if_222_18.setTagInfo(_td_c_if_222_18);
                                    _jettag_c_if_222_18.doStart(context, out);
                                    while (_jettag_c_if_222_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_223_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_223_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_223_18.setRuntimeParent(_jettag_c_if_222_18);
                                        _jettag_c_if_223_18.setTagInfo(_td_c_if_223_18);
                                        _jettag_c_if_223_18.doStart(context, out);
                                        while (_jettag_c_if_223_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_224_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_224_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_224_19.setRuntimeParent(_jettag_c_if_223_18);
                                            _jettag_c_setVariable_224_19.setTagInfo(_td_c_setVariable_224_19);
                                            _jettag_c_setVariable_224_19.doStart(context, out);
                                            _jettag_c_setVariable_224_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_226_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_226_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_226_21.setRuntimeParent(_jettag_c_if_223_18);
                                            _jettag_c_if_226_21.setTagInfo(_td_c_if_226_21);
                                            _jettag_c_if_226_21.doStart(context, out);
                                            while (_jettag_c_if_226_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_228_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_228_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_228_19.setRuntimeParent(_jettag_c_if_226_21);
                                                _jettag_c_if_228_19.setTagInfo(_td_c_if_228_19);
                                                _jettag_c_if_228_19.doStart(context, out);
                                                while (_jettag_c_if_228_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_230_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_230_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_230_22.setRuntimeParent(_jettag_c_if_228_19);
                                                    _jettag_c_iterate_230_22.setTagInfo(_td_c_iterate_230_22);
                                                    _jettag_c_iterate_230_22.doStart(context, out);
                                                    while (_jettag_c_iterate_230_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_231_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_231_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_231_23.setRuntimeParent(_jettag_c_iterate_230_22);
                                                        _jettag_c_if_231_23.setTagInfo(_td_c_if_231_23);
                                                        _jettag_c_if_231_23.doStart(context, out);
                                                        while (_jettag_c_if_231_23.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcase R.id.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 232, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("_");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 232, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s_menu:");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIntent ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 233, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent = new Intent(this, ReadAll");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 233, 90)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s.class);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 234, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent.putExtra(\"resource\", getReadURL() + \"/");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 234, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s\");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 235, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent.putExtra(\"parent\",");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 235, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstartActivity(");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 236, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbreak;");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_231_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_231_23.doEnd();
                                                        _jettag_c_iterate_230_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_230_22.doEnd();
                                                    _jettag_c_if_228_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_228_19.doEnd();
                                                _jettag_c_if_226_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_226_21.doEnd();
                                            _jettag_c_if_223_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_223_18.doEnd();
                                        _jettag_c_if_222_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_222_18.doEnd();
                                    _jettag_c_iterate_220_19.handleBodyContent(out);
                                }
                                _jettag_c_iterate_220_19.doEnd();
                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_218_13.handleBodyContent(out);
                            }
                            _jettag_c_if_218_13.doEnd();
                            _jettag_c_iterate_215_10.handleBodyContent(out);
                        }
                        _jettag_c_iterate_215_10.doEnd();
                        _jettag_c_iterate_214_9.handleBodyContent(out);
                    }
                    _jettag_c_iterate_214_9.doEnd();
                    _jettag_c_iterate_213_8.handleBodyContent(out);
                }
                _jettag_c_iterate_213_8.doEnd();
                _jettag_c_if_210_1.handleBodyContent(out);
            }
            _jettag_c_if_210_1.doEnd();
            //process level 2 generizations 
            RuntimeTagElement _jettag_c_if_252_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_252_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_252_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_if_252_1.setTagInfo(_td_c_if_252_1);
            _jettag_c_if_252_1.doStart(context, out);
            while (_jettag_c_if_252_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_setVariable_253_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_253_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_253_6.setRuntimeParent(_jettag_c_if_252_1);
                _jettag_c_setVariable_253_6.setTagInfo(_td_c_setVariable_253_6);
                _jettag_c_setVariable_253_6.doStart(context, out);
                _jettag_c_setVariable_253_6.doEnd();
                // process the assocations for level 1 class 
                RuntimeTagElement _jettag_c_iterate_255_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_255_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_255_8.setRuntimeParent(_jettag_c_if_252_1);
                _jettag_c_iterate_255_8.setTagInfo(_td_c_iterate_255_8);
                _jettag_c_iterate_255_8.doStart(context, out);
                while (_jettag_c_iterate_255_8.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_256_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_256_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_256_9.setRuntimeParent(_jettag_c_iterate_255_8);
                    _jettag_c_iterate_256_9.setTagInfo(_td_c_iterate_256_9);
                    _jettag_c_iterate_256_9.doStart(context, out);
                    while (_jettag_c_iterate_256_9.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_257_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_257_10); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_257_10.setRuntimeParent(_jettag_c_iterate_256_9);
                        _jettag_c_iterate_257_10.setTagInfo(_td_c_iterate_257_10);
                        _jettag_c_iterate_257_10.doStart(context, out);
                        while (_jettag_c_iterate_257_10.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_258_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_258_11); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_258_11.setRuntimeParent(_jettag_c_iterate_257_10);
                            _jettag_c_setVariable_258_11.setTagInfo(_td_c_setVariable_258_11);
                            _jettag_c_setVariable_258_11.doStart(context, out);
                            _jettag_c_setVariable_258_11.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_260_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_260_13); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_260_13.setRuntimeParent(_jettag_c_iterate_257_10);
                            _jettag_c_if_260_13.setTagInfo(_td_c_if_260_13);
                            _jettag_c_if_260_13.doStart(context, out);
                            while (_jettag_c_if_260_13.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_262_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_262_19); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_262_19.setRuntimeParent(_jettag_c_if_260_13);
                                _jettag_c_iterate_262_19.setTagInfo(_td_c_iterate_262_19);
                                _jettag_c_iterate_262_19.doStart(context, out);
                                while (_jettag_c_iterate_262_19.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_264_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_264_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_264_18.setRuntimeParent(_jettag_c_iterate_262_19);
                                    _jettag_c_if_264_18.setTagInfo(_td_c_if_264_18);
                                    _jettag_c_if_264_18.doStart(context, out);
                                    while (_jettag_c_if_264_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_265_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_265_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_265_18.setRuntimeParent(_jettag_c_if_264_18);
                                        _jettag_c_if_265_18.setTagInfo(_td_c_if_265_18);
                                        _jettag_c_if_265_18.doStart(context, out);
                                        while (_jettag_c_if_265_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_266_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_266_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_266_19.setRuntimeParent(_jettag_c_if_265_18);
                                            _jettag_c_setVariable_266_19.setTagInfo(_td_c_setVariable_266_19);
                                            _jettag_c_setVariable_266_19.doStart(context, out);
                                            _jettag_c_setVariable_266_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_268_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_268_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_268_21.setRuntimeParent(_jettag_c_if_265_18);
                                            _jettag_c_if_268_21.setTagInfo(_td_c_if_268_21);
                                            _jettag_c_if_268_21.doStart(context, out);
                                            while (_jettag_c_if_268_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_270_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_270_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_270_19.setRuntimeParent(_jettag_c_if_268_21);
                                                _jettag_c_if_270_19.setTagInfo(_td_c_if_270_19);
                                                _jettag_c_if_270_19.doStart(context, out);
                                                while (_jettag_c_if_270_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_272_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_272_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_272_22.setRuntimeParent(_jettag_c_if_270_19);
                                                    _jettag_c_iterate_272_22.setTagInfo(_td_c_iterate_272_22);
                                                    _jettag_c_iterate_272_22.doStart(context, out);
                                                    while (_jettag_c_iterate_272_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_273_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_273_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_273_23.setRuntimeParent(_jettag_c_iterate_272_22);
                                                        _jettag_c_if_273_23.setTagInfo(_td_c_if_273_23);
                                                        _jettag_c_if_273_23.doStart(context, out);
                                                        while (_jettag_c_if_273_23.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcase R.id.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 274, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("_");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 274, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s_menu:");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIntent ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 275, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent = new Intent(this, ReadAll");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 275, 90)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s.class);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 276, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent.putExtra(\"resource\", getReadURL() + \"/");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 276, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s\");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 277, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent.putExtra(\"parent\",");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 277, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstartActivity(");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 278, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbreak;");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_273_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_273_23.doEnd();
                                                        _jettag_c_iterate_272_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_272_22.doEnd();
                                                    _jettag_c_if_270_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_270_19.doEnd();
                                                _jettag_c_if_268_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_268_21.doEnd();
                                            _jettag_c_if_265_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_265_18.doEnd();
                                        _jettag_c_if_264_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_264_18.doEnd();
                                    _jettag_c_iterate_262_19.handleBodyContent(out);
                                }
                                _jettag_c_iterate_262_19.doEnd();
                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_260_13.handleBodyContent(out);
                            }
                            _jettag_c_if_260_13.doEnd();
                            _jettag_c_iterate_257_10.handleBodyContent(out);
                        }
                        _jettag_c_iterate_257_10.doEnd();
                        _jettag_c_iterate_256_9.handleBodyContent(out);
                    }
                    _jettag_c_iterate_256_9.doEnd();
                    _jettag_c_iterate_255_8.handleBodyContent(out);
                }
                _jettag_c_iterate_255_8.doEnd();
                _jettag_c_if_252_1.handleBodyContent(out);
            }
            _jettag_c_if_252_1.doEnd();
            out.write(NL);         
            RuntimeTagElement _jettag_c_setVariable_294_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_294_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_294_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_setVariable_294_1.setTagInfo(_td_c_setVariable_294_1);
            _jettag_c_setVariable_294_1.doStart(context, out);
            _jettag_c_setVariable_294_1.doEnd();
            //process 0 level class relations 
            RuntimeTagElement _jettag_c_iterate_296_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_296_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_296_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_iterate_296_1.setTagInfo(_td_c_iterate_296_1);
            _jettag_c_iterate_296_1.doStart(context, out);
            while (_jettag_c_iterate_296_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_297_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_297_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_297_2.setRuntimeParent(_jettag_c_iterate_296_1);
                _jettag_c_iterate_297_2.setTagInfo(_td_c_iterate_297_2);
                _jettag_c_iterate_297_2.doStart(context, out);
                while (_jettag_c_iterate_297_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_298_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_298_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_298_3.setRuntimeParent(_jettag_c_iterate_297_2);
                    _jettag_c_iterate_298_3.setTagInfo(_td_c_iterate_298_3);
                    _jettag_c_iterate_298_3.doStart(context, out);
                    while (_jettag_c_iterate_298_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_299_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_299_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_299_4.setRuntimeParent(_jettag_c_iterate_298_3);
                        _jettag_c_setVariable_299_4.setTagInfo(_td_c_setVariable_299_4);
                        _jettag_c_setVariable_299_4.doStart(context, out);
                        _jettag_c_setVariable_299_4.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_301_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_301_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_301_6.setRuntimeParent(_jettag_c_iterate_298_3);
                        _jettag_c_if_301_6.setTagInfo(_td_c_if_301_6);
                        _jettag_c_if_301_6.doStart(context, out);
                        while (_jettag_c_if_301_6.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_303_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_303_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_303_12.setRuntimeParent(_jettag_c_if_301_6);
                            _jettag_c_iterate_303_12.setTagInfo(_td_c_iterate_303_12);
                            _jettag_c_iterate_303_12.doStart(context, out);
                            while (_jettag_c_iterate_303_12.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_305_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_305_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_305_12.setRuntimeParent(_jettag_c_iterate_303_12);
                                _jettag_c_if_305_12.setTagInfo(_td_c_if_305_12);
                                _jettag_c_if_305_12.doStart(context, out);
                                while (_jettag_c_if_305_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_306_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_306_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_306_12.setRuntimeParent(_jettag_c_if_305_12);
                                    _jettag_c_setVariable_306_12.setTagInfo(_td_c_setVariable_306_12);
                                    _jettag_c_setVariable_306_12.doStart(context, out);
                                    _jettag_c_setVariable_306_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_308_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_308_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_308_14.setRuntimeParent(_jettag_c_if_305_12);
                                    _jettag_c_if_308_14.setTagInfo(_td_c_if_308_14);
                                    _jettag_c_if_308_14.doStart(context, out);
                                    while (_jettag_c_if_308_14.okToProcessBody()) {
                                        // check to see if this is a navigable relation
                                        RuntimeTagElement _jettag_c_if_310_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_310_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_310_14.setRuntimeParent(_jettag_c_if_308_14);
                                        _jettag_c_if_310_14.setTagInfo(_td_c_if_310_14);
                                        _jettag_c_if_310_14.doStart(context, out);
                                        while (_jettag_c_if_310_14.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_312_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_312_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_312_9.setRuntimeParent(_jettag_c_if_310_14);
                                            _jettag_c_if_312_9.setTagInfo(_td_c_if_312_9);
                                            _jettag_c_if_312_9.doStart(context, out);
                                            while (_jettag_c_if_312_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_313_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_313_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_313_11.setRuntimeParent(_jettag_c_if_312_9);
                                                _jettag_c_if_313_11.setTagInfo(_td_c_if_313_11);
                                                _jettag_c_if_313_11.doStart(context, out);
                                                while (_jettag_c_if_313_11.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_315_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_315_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_315_15.setRuntimeParent(_jettag_c_if_313_11);
                                                    _jettag_c_iterate_315_15.setTagInfo(_td_c_iterate_315_15);
                                                    _jettag_c_iterate_315_15.doStart(context, out);
                                                    while (_jettag_c_iterate_315_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_316_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_316_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_316_16.setRuntimeParent(_jettag_c_iterate_315_15);
                                                        _jettag_c_if_316_16.setTagInfo(_td_c_if_316_16);
                                                        _jettag_c_if_316_16.doStart(context, out);
                                                        while (_jettag_c_if_316_16.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcase R.id.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 317, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("_");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 317, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s_menu:");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIntent ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 318, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent = new Intent(this, ReadAll");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 318, 90)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s.class);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 319, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent.putExtra(\"resource\", getReadURL() + \"/");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 319, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s\");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 320, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent.putExtra(\"parent\",");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 320, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstartActivity(");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 321, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbreak;");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_316_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_316_16.doEnd();
                                                        _jettag_c_iterate_315_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_315_15.doEnd();
                                                    _jettag_c_if_313_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_313_11.doEnd();
                                                _jettag_c_if_312_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_312_9.doEnd();
                                            _jettag_c_if_310_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_310_14.doEnd();
                                        _jettag_c_if_308_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_308_14.doEnd();
                                    _jettag_c_if_305_12.handleBodyContent(out);
                                }
                                _jettag_c_if_305_12.doEnd();
                                _jettag_c_iterate_303_12.handleBodyContent(out);
                            }
                            _jettag_c_iterate_303_12.doEnd();
                            _jettag_c_if_301_6.handleBodyContent(out);
                        }
                        _jettag_c_if_301_6.doEnd();
                        _jettag_c_iterate_298_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_298_3.doEnd();
                    _jettag_c_iterate_297_2.handleBodyContent(out);
                }
                _jettag_c_iterate_297_2.doEnd();
                _jettag_c_iterate_296_1.handleBodyContent(out);
            }
            _jettag_c_iterate_296_1.doEnd();
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn true;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onClick(View arg0) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (arg0 == done) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tfinish();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (arg0 == update) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tIntent intent = new Intent(this, Update");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 344, 43)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".class);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tintent.putExtra(\"entity\", ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 345, 30)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tstartActivity(intent);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tif (arg0 == delete) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tToast.makeText(getApplicationContext(), \"aaa\", Toast.LENGTH_SHORT);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic String getReadURL() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tLong id = getIntent().getLongExtra(\"id\", new Long(1));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\treturn ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 355, 9)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Main.baseURL + \"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 355, 51)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("/read/\" + id;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onStart() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsuper.onStart();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tLog.d(\"info.yalamacnhili.android\", \"in start\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tnew AsyncHttpGet(this) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tprotected void onResponse(String result) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tload(result);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t}.execute(getReadURL());");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_2_1.handleBodyContent(out);
        }
        out = _jettag_java_format_2_1_saved_out;
        _jettag_java_format_2_1.doEnd();
    }
}
