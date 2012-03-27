package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_rest_servicejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_entity_rest_servicejava() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_format_1_1 = new TagInfo("java:format", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_setVariable_2_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            2, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_14_1 = new TagInfo("c:if", //$NON-NLS-1$
            14, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_24_1 = new TagInfo("c:if", //$NON-NLS-1$
            24, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_25_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            25, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_27_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            27, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_28_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            28, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_29_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            29, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_30_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            30, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_32_13 = new TagInfo("c:if", //$NON-NLS-1$
            32, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_34_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            34, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_36_18 = new TagInfo("c:if", //$NON-NLS-1$
            36, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_37_18 = new TagInfo("c:if", //$NON-NLS-1$
            37, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_38_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            38, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_40_21 = new TagInfo("c:if", //$NON-NLS-1$
            40, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_42_19 = new TagInfo("c:if", //$NON-NLS-1$
            42, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_44_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            44, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_45_23 = new TagInfo("c:if", //$NON-NLS-1$
            45, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_61_1 = new TagInfo("c:if", //$NON-NLS-1$
            61, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_62_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            62, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_64_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            64, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_65_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            65, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_66_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            66, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_67_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            67, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_69_13 = new TagInfo("c:if", //$NON-NLS-1$
            69, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_71_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            71, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_73_18 = new TagInfo("c:if", //$NON-NLS-1$
            73, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_74_18 = new TagInfo("c:if", //$NON-NLS-1$
            74, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_75_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            75, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_77_21 = new TagInfo("c:if", //$NON-NLS-1$
            77, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_79_19 = new TagInfo("c:if", //$NON-NLS-1$
            79, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_81_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            81, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_82_23 = new TagInfo("c:if", //$NON-NLS-1$
            82, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_98_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            98, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_100_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            100, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_101_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            101, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_102_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            102, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_103_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            103, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_105_6 = new TagInfo("c:if", //$NON-NLS-1$
            105, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_107_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            107, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_109_12 = new TagInfo("c:if", //$NON-NLS-1$
            109, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_110_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            110, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_112_14 = new TagInfo("c:if", //$NON-NLS-1$
            112, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_114_14 = new TagInfo("c:if", //$NON-NLS-1$
            114, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_116_9 = new TagInfo("c:if", //$NON-NLS-1$
            116, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_117_11 = new TagInfo("c:if", //$NON-NLS-1$
            117, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_119_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            119, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_120_16 = new TagInfo("c:if", //$NON-NLS-1$
            120, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_206_1 = new TagInfo("c:if", //$NON-NLS-1$
            206, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_207_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            207, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_209_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            209, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_210_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            210, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_211_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            211, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_212_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            212, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_214_13 = new TagInfo("c:if", //$NON-NLS-1$
            214, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_216_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            216, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_218_18 = new TagInfo("c:if", //$NON-NLS-1$
            218, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_219_18 = new TagInfo("c:if", //$NON-NLS-1$
            219, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_220_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            220, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_222_21 = new TagInfo("c:if", //$NON-NLS-1$
            222, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_224_19 = new TagInfo("c:if", //$NON-NLS-1$
            224, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_226_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            226, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_227_23 = new TagInfo("c:if", //$NON-NLS-1$
            227, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_247_1 = new TagInfo("c:if", //$NON-NLS-1$
            247, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_248_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            248, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_250_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            250, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_251_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            251, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_252_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            252, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_253_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            253, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_255_13 = new TagInfo("c:if", //$NON-NLS-1$
            255, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_257_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            257, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_259_18 = new TagInfo("c:if", //$NON-NLS-1$
            259, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_260_18 = new TagInfo("c:if", //$NON-NLS-1$
            260, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_261_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            261, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_263_21 = new TagInfo("c:if", //$NON-NLS-1$
            263, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_265_19 = new TagInfo("c:if", //$NON-NLS-1$
            265, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_267_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            267, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_268_23 = new TagInfo("c:if", //$NON-NLS-1$
            268, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_288_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            288, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_290_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            290, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_291_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            291, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_292_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            292, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_293_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            293, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_295_6 = new TagInfo("c:if", //$NON-NLS-1$
            295, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_297_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            297, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_299_12 = new TagInfo("c:if", //$NON-NLS-1$
            299, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_300_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            300, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_302_14 = new TagInfo("c:if", //$NON-NLS-1$
            302, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_304_14 = new TagInfo("c:if", //$NON-NLS-1$
            304, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_306_9 = new TagInfo("c:if", //$NON-NLS-1$
            306, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_307_11 = new TagInfo("c:if", //$NON-NLS-1$
            307, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_309_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            309, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_310_16 = new TagInfo("c:if", //$NON-NLS-1$
            310, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_336_1 = new TagInfo("c:if", //$NON-NLS-1$
            336, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
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
            RuntimeTagElement _jettag_c_setVariable_2_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_2_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_2_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_setVariable_2_1.setTagInfo(_td_c_setVariable_2_1);
            _jettag_c_setVariable_2_1.doStart(context, out);
            _jettag_c_setVariable_2_1.doEnd();
            out.write("package ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 3, 9)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".rest.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$package/@name}", 3, 26)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.mapper.BeanMapper;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 5, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".entity.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 5, 27)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 5, 57)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.service.exception.ServiceException;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 8, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".dao.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 8, 24)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 8, 54)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 8, 82)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("DAOLocal;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.ArrayList;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.Collection;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.List;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.dozer.Mapper;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            RuntimeTagElement _jettag_c_if_14_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_14_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_14_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_14_1.setTagInfo(_td_c_if_14_1);
            _jettag_c_if_14_1.doStart(context, out);
            while (_jettag_c_if_14_1.okToProcessBody()) {
                out.write("import info.yalamanchili.commons.DataType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.commons.ReflectionUtils;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.commons.SearchUtils;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.apache.lucene.analysis.standard.StandardAnalyzer;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.hibernate.search.jpa.FullTextEntityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.hibernate.search.jpa.Search;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.apache.lucene.util.Version;");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_c_if_14_1.handleBodyContent(out);
            }
            _jettag_c_if_14_1.doEnd();
            //process level 1 generizations 
            RuntimeTagElement _jettag_c_if_24_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_24_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_24_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_24_1.setTagInfo(_td_c_if_24_1);
            _jettag_c_if_24_1.doStart(context, out);
            while (_jettag_c_if_24_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_setVariable_25_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_25_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_25_6.setRuntimeParent(_jettag_c_if_24_1);
                _jettag_c_setVariable_25_6.setTagInfo(_td_c_setVariable_25_6);
                _jettag_c_setVariable_25_6.doStart(context, out);
                _jettag_c_setVariable_25_6.doEnd();
                // process the assocations for level 1 class 
                RuntimeTagElement _jettag_c_iterate_27_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_27_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_27_8.setRuntimeParent(_jettag_c_if_24_1);
                _jettag_c_iterate_27_8.setTagInfo(_td_c_iterate_27_8);
                _jettag_c_iterate_27_8.doStart(context, out);
                while (_jettag_c_iterate_27_8.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_28_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_28_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_28_9.setRuntimeParent(_jettag_c_iterate_27_8);
                    _jettag_c_iterate_28_9.setTagInfo(_td_c_iterate_28_9);
                    _jettag_c_iterate_28_9.doStart(context, out);
                    while (_jettag_c_iterate_28_9.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_29_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_29_10); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_29_10.setRuntimeParent(_jettag_c_iterate_28_9);
                        _jettag_c_iterate_29_10.setTagInfo(_td_c_iterate_29_10);
                        _jettag_c_iterate_29_10.doStart(context, out);
                        while (_jettag_c_iterate_29_10.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_30_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_30_11); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_30_11.setRuntimeParent(_jettag_c_iterate_29_10);
                            _jettag_c_setVariable_30_11.setTagInfo(_td_c_setVariable_30_11);
                            _jettag_c_setVariable_30_11.doStart(context, out);
                            _jettag_c_setVariable_30_11.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_32_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_32_13); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_32_13.setRuntimeParent(_jettag_c_iterate_29_10);
                            _jettag_c_if_32_13.setTagInfo(_td_c_if_32_13);
                            _jettag_c_if_32_13.doStart(context, out);
                            while (_jettag_c_if_32_13.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_34_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_34_19); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_34_19.setRuntimeParent(_jettag_c_if_32_13);
                                _jettag_c_iterate_34_19.setTagInfo(_td_c_iterate_34_19);
                                _jettag_c_iterate_34_19.doStart(context, out);
                                while (_jettag_c_iterate_34_19.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_36_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_36_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_36_18.setRuntimeParent(_jettag_c_iterate_34_19);
                                    _jettag_c_if_36_18.setTagInfo(_td_c_if_36_18);
                                    _jettag_c_if_36_18.doStart(context, out);
                                    while (_jettag_c_if_36_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_37_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_37_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_37_18.setRuntimeParent(_jettag_c_if_36_18);
                                        _jettag_c_if_37_18.setTagInfo(_td_c_if_37_18);
                                        _jettag_c_if_37_18.doStart(context, out);
                                        while (_jettag_c_if_37_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_38_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_38_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_38_19.setRuntimeParent(_jettag_c_if_37_18);
                                            _jettag_c_setVariable_38_19.setTagInfo(_td_c_setVariable_38_19);
                                            _jettag_c_setVariable_38_19.doStart(context, out);
                                            _jettag_c_setVariable_38_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_40_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_40_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_40_21.setRuntimeParent(_jettag_c_if_37_18);
                                            _jettag_c_if_40_21.setTagInfo(_td_c_if_40_21);
                                            _jettag_c_if_40_21.doStart(context, out);
                                            while (_jettag_c_if_40_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_42_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_42_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_42_19.setRuntimeParent(_jettag_c_if_40_21);
                                                _jettag_c_if_42_19.setTagInfo(_td_c_if_42_19);
                                                _jettag_c_if_42_19.doStart(context, out);
                                                while (_jettag_c_if_42_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_44_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_44_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_44_22.setRuntimeParent(_jettag_c_if_42_19);
                                                    _jettag_c_iterate_44_22.setTagInfo(_td_c_iterate_44_22);
                                                    _jettag_c_iterate_44_22.doStart(context, out);
                                                    while (_jettag_c_iterate_44_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_45_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_45_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_45_23.setRuntimeParent(_jettag_c_iterate_44_22);
                                                        _jettag_c_if_45_23.setTagInfo(_td_c_if_45_23);
                                                        _jettag_c_if_45_23.doStart(context, out);
                                                        while (_jettag_c_if_45_23.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 46, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".entity.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 46, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 46, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_45_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_45_23.doEnd();
                                                        _jettag_c_iterate_44_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_44_22.doEnd();
                                                    _jettag_c_if_42_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_42_19.doEnd();
                                                _jettag_c_if_40_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_40_21.doEnd();
                                            _jettag_c_if_37_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_37_18.doEnd();
                                        _jettag_c_if_36_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_36_18.doEnd();
                                    _jettag_c_iterate_34_19.handleBodyContent(out);
                                }
                                _jettag_c_iterate_34_19.doEnd();
                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_32_13.handleBodyContent(out);
                            }
                            _jettag_c_if_32_13.doEnd();
                            _jettag_c_iterate_29_10.handleBodyContent(out);
                        }
                        _jettag_c_iterate_29_10.doEnd();
                        _jettag_c_iterate_28_9.handleBodyContent(out);
                    }
                    _jettag_c_iterate_28_9.doEnd();
                    _jettag_c_iterate_27_8.handleBodyContent(out);
                }
                _jettag_c_iterate_27_8.doEnd();
                _jettag_c_if_24_1.handleBodyContent(out);
            }
            _jettag_c_if_24_1.doEnd();
            //process level 2 generizations 
            RuntimeTagElement _jettag_c_if_61_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_61_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_61_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_61_1.setTagInfo(_td_c_if_61_1);
            _jettag_c_if_61_1.doStart(context, out);
            while (_jettag_c_if_61_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_setVariable_62_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_62_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_62_6.setRuntimeParent(_jettag_c_if_61_1);
                _jettag_c_setVariable_62_6.setTagInfo(_td_c_setVariable_62_6);
                _jettag_c_setVariable_62_6.doStart(context, out);
                _jettag_c_setVariable_62_6.doEnd();
                // process the assocations for level 1 class 
                RuntimeTagElement _jettag_c_iterate_64_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_64_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_64_8.setRuntimeParent(_jettag_c_if_61_1);
                _jettag_c_iterate_64_8.setTagInfo(_td_c_iterate_64_8);
                _jettag_c_iterate_64_8.doStart(context, out);
                while (_jettag_c_iterate_64_8.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_65_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_65_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_65_9.setRuntimeParent(_jettag_c_iterate_64_8);
                    _jettag_c_iterate_65_9.setTagInfo(_td_c_iterate_65_9);
                    _jettag_c_iterate_65_9.doStart(context, out);
                    while (_jettag_c_iterate_65_9.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_66_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_66_10); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_66_10.setRuntimeParent(_jettag_c_iterate_65_9);
                        _jettag_c_iterate_66_10.setTagInfo(_td_c_iterate_66_10);
                        _jettag_c_iterate_66_10.doStart(context, out);
                        while (_jettag_c_iterate_66_10.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_67_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_67_11); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_67_11.setRuntimeParent(_jettag_c_iterate_66_10);
                            _jettag_c_setVariable_67_11.setTagInfo(_td_c_setVariable_67_11);
                            _jettag_c_setVariable_67_11.doStart(context, out);
                            _jettag_c_setVariable_67_11.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_69_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_69_13); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_69_13.setRuntimeParent(_jettag_c_iterate_66_10);
                            _jettag_c_if_69_13.setTagInfo(_td_c_if_69_13);
                            _jettag_c_if_69_13.doStart(context, out);
                            while (_jettag_c_if_69_13.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_71_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_71_19); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_71_19.setRuntimeParent(_jettag_c_if_69_13);
                                _jettag_c_iterate_71_19.setTagInfo(_td_c_iterate_71_19);
                                _jettag_c_iterate_71_19.doStart(context, out);
                                while (_jettag_c_iterate_71_19.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_73_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_73_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_73_18.setRuntimeParent(_jettag_c_iterate_71_19);
                                    _jettag_c_if_73_18.setTagInfo(_td_c_if_73_18);
                                    _jettag_c_if_73_18.doStart(context, out);
                                    while (_jettag_c_if_73_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_74_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_74_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_74_18.setRuntimeParent(_jettag_c_if_73_18);
                                        _jettag_c_if_74_18.setTagInfo(_td_c_if_74_18);
                                        _jettag_c_if_74_18.doStart(context, out);
                                        while (_jettag_c_if_74_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_75_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_75_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_75_19.setRuntimeParent(_jettag_c_if_74_18);
                                            _jettag_c_setVariable_75_19.setTagInfo(_td_c_setVariable_75_19);
                                            _jettag_c_setVariable_75_19.doStart(context, out);
                                            _jettag_c_setVariable_75_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_77_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_77_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_77_21.setRuntimeParent(_jettag_c_if_74_18);
                                            _jettag_c_if_77_21.setTagInfo(_td_c_if_77_21);
                                            _jettag_c_if_77_21.doStart(context, out);
                                            while (_jettag_c_if_77_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_79_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_79_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_79_19.setRuntimeParent(_jettag_c_if_77_21);
                                                _jettag_c_if_79_19.setTagInfo(_td_c_if_79_19);
                                                _jettag_c_if_79_19.doStart(context, out);
                                                while (_jettag_c_if_79_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_81_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_81_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_81_22.setRuntimeParent(_jettag_c_if_79_19);
                                                    _jettag_c_iterate_81_22.setTagInfo(_td_c_iterate_81_22);
                                                    _jettag_c_iterate_81_22.doStart(context, out);
                                                    while (_jettag_c_iterate_81_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_82_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_82_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_82_23.setRuntimeParent(_jettag_c_iterate_81_22);
                                                        _jettag_c_if_82_23.setTagInfo(_td_c_if_82_23);
                                                        _jettag_c_if_82_23.doStart(context, out);
                                                        while (_jettag_c_if_82_23.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 83, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".entity.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 83, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 83, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_82_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_82_23.doEnd();
                                                        _jettag_c_iterate_81_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_81_22.doEnd();
                                                    _jettag_c_if_79_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_79_19.doEnd();
                                                _jettag_c_if_77_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_77_21.doEnd();
                                            _jettag_c_if_74_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_74_18.doEnd();
                                        _jettag_c_if_73_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_73_18.doEnd();
                                    _jettag_c_iterate_71_19.handleBodyContent(out);
                                }
                                _jettag_c_iterate_71_19.doEnd();
                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_69_13.handleBodyContent(out);
                            }
                            _jettag_c_if_69_13.doEnd();
                            _jettag_c_iterate_66_10.handleBodyContent(out);
                        }
                        _jettag_c_iterate_66_10.doEnd();
                        _jettag_c_iterate_65_9.handleBodyContent(out);
                    }
                    _jettag_c_iterate_65_9.doEnd();
                    _jettag_c_iterate_64_8.handleBodyContent(out);
                }
                _jettag_c_iterate_64_8.doEnd();
                _jettag_c_if_61_1.handleBodyContent(out);
            }
            _jettag_c_if_61_1.doEnd();
            out.write(NL);         
            RuntimeTagElement _jettag_c_setVariable_98_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_98_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_98_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_setVariable_98_1.setTagInfo(_td_c_setVariable_98_1);
            _jettag_c_setVariable_98_1.doStart(context, out);
            _jettag_c_setVariable_98_1.doEnd();
            //process 0 level class relations 
            RuntimeTagElement _jettag_c_iterate_100_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_100_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_100_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_100_1.setTagInfo(_td_c_iterate_100_1);
            _jettag_c_iterate_100_1.doStart(context, out);
            while (_jettag_c_iterate_100_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_101_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_101_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_101_2.setRuntimeParent(_jettag_c_iterate_100_1);
                _jettag_c_iterate_101_2.setTagInfo(_td_c_iterate_101_2);
                _jettag_c_iterate_101_2.doStart(context, out);
                while (_jettag_c_iterate_101_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_102_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_102_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_102_3.setRuntimeParent(_jettag_c_iterate_101_2);
                    _jettag_c_iterate_102_3.setTagInfo(_td_c_iterate_102_3);
                    _jettag_c_iterate_102_3.doStart(context, out);
                    while (_jettag_c_iterate_102_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_103_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_103_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_103_4.setRuntimeParent(_jettag_c_iterate_102_3);
                        _jettag_c_setVariable_103_4.setTagInfo(_td_c_setVariable_103_4);
                        _jettag_c_setVariable_103_4.doStart(context, out);
                        _jettag_c_setVariable_103_4.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_105_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_105_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_105_6.setRuntimeParent(_jettag_c_iterate_102_3);
                        _jettag_c_if_105_6.setTagInfo(_td_c_if_105_6);
                        _jettag_c_if_105_6.doStart(context, out);
                        while (_jettag_c_if_105_6.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_107_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_107_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_107_12.setRuntimeParent(_jettag_c_if_105_6);
                            _jettag_c_iterate_107_12.setTagInfo(_td_c_iterate_107_12);
                            _jettag_c_iterate_107_12.doStart(context, out);
                            while (_jettag_c_iterate_107_12.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_109_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_109_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_109_12.setRuntimeParent(_jettag_c_iterate_107_12);
                                _jettag_c_if_109_12.setTagInfo(_td_c_if_109_12);
                                _jettag_c_if_109_12.doStart(context, out);
                                while (_jettag_c_if_109_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_110_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_110_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_110_12.setRuntimeParent(_jettag_c_if_109_12);
                                    _jettag_c_setVariable_110_12.setTagInfo(_td_c_setVariable_110_12);
                                    _jettag_c_setVariable_110_12.doStart(context, out);
                                    _jettag_c_setVariable_110_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_112_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_112_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_112_14.setRuntimeParent(_jettag_c_if_109_12);
                                    _jettag_c_if_112_14.setTagInfo(_td_c_if_112_14);
                                    _jettag_c_if_112_14.doStart(context, out);
                                    while (_jettag_c_if_112_14.okToProcessBody()) {
                                        // check to see if this is a navigable relation
                                        RuntimeTagElement _jettag_c_if_114_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_114_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_114_14.setRuntimeParent(_jettag_c_if_112_14);
                                        _jettag_c_if_114_14.setTagInfo(_td_c_if_114_14);
                                        _jettag_c_if_114_14.doStart(context, out);
                                        while (_jettag_c_if_114_14.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_116_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_116_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_116_9.setRuntimeParent(_jettag_c_if_114_14);
                                            _jettag_c_if_116_9.setTagInfo(_td_c_if_116_9);
                                            _jettag_c_if_116_9.doStart(context, out);
                                            while (_jettag_c_if_116_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_117_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_117_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_117_11.setRuntimeParent(_jettag_c_if_116_9);
                                                _jettag_c_if_117_11.setTagInfo(_td_c_if_117_11);
                                                _jettag_c_if_117_11.doStart(context, out);
                                                while (_jettag_c_if_117_11.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_119_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_119_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_119_15.setRuntimeParent(_jettag_c_if_117_11);
                                                    _jettag_c_iterate_119_15.setTagInfo(_td_c_iterate_119_15);
                                                    _jettag_c_iterate_119_15.doStart(context, out);
                                                    while (_jettag_c_iterate_119_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_120_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_120_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_120_16.setRuntimeParent(_jettag_c_iterate_119_15);
                                                        _jettag_c_if_120_16.setTagInfo(_td_c_if_120_16);
                                                        _jettag_c_if_120_16.doStart(context, out);
                                                        while (_jettag_c_if_120_16.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 121, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".entity.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 121, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 121, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_120_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_120_16.doEnd();
                                                        _jettag_c_iterate_119_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_119_15.doEnd();
                                                    _jettag_c_if_117_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_117_11.doEnd();
                                                _jettag_c_if_116_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_116_9.doEnd();
                                            _jettag_c_if_114_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_114_14.doEnd();
                                        _jettag_c_if_112_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_112_14.doEnd();
                                    _jettag_c_if_109_12.handleBodyContent(out);
                                }
                                _jettag_c_if_109_12.doEnd();
                                _jettag_c_iterate_107_12.handleBodyContent(out);
                            }
                            _jettag_c_iterate_107_12.doEnd();
                            _jettag_c_if_105_6.handleBodyContent(out);
                        }
                        _jettag_c_if_105_6.doEnd();
                        _jettag_c_iterate_102_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_102_3.doEnd();
                    _jettag_c_iterate_101_2.handleBodyContent(out);
                }
                _jettag_c_iterate_101_2.doEnd();
                _jettag_c_iterate_100_1.handleBodyContent(out);
            }
            _jettag_c_iterate_100_1.doEnd();
            out.write("import javax.persistence.EntityManager;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import javax.persistence.Query;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import javax.ws.rs.Consumes;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import javax.ws.rs.DELETE;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import javax.ws.rs.GET;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import javax.ws.rs.PUT;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import javax.ws.rs.Path;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import javax.ws.rs.PathParam;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import javax.ws.rs.Produces;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.jboss.seam.ScopeType;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.jboss.seam.annotations.Transactional;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.jboss.seam.annotations.Create;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.jboss.seam.annotations.In;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.jboss.seam.annotations.Name;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.jboss.seam.annotations.Scope;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import org.jboss.seam.annotations.security.Restrict;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("@Name(\"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 151, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Resource\")");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("@Path(\"/crud/");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 152, 14)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("\")");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("@Produces(value = { \"application/xml\", \"application/json\" })");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("@Consumes(value = { \"application/xml\", \"application/json\" })");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("@Scope(ScopeType.STATELESS)");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("@Transactional");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("public class ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 157, 14)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Resource {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@In(\"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 159, 7)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Daoy\")");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 160, 12)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("DAOLocal dao;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@In");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected EntityManager em;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@In");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprivate Mapper mapper;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@GET");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Path(\"/read/{id}\")");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t//@Restrict(\"#{s:hasRole('user')}\")");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 171, 9)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" read(@PathParam(\"id\") Long id) throws ServiceException{");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn dao.findById(id);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@PUT");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Path(\"/create\")");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t//@Restrict(\"#{s:hasRole('admin')}\")");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void create(");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 178, 21)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" entity) throws ServiceException{");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdao.save(entity);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@PUT");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Path(\"/update\")");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t//@Restrict(\"#{s:hasRole('admin')}\")");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void update(");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 185, 21)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" object) throws ServiceException{");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 186, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" entity = dao.findById(object.getId());");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tmapper.map(object, entity);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdao.save(entity);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@DELETE");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Path(\"/delete/{id}\")");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t//@Restrict(\"#{s:hasRole('admin')}\")");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void delete(@PathParam(\"id\") Long id) throws ServiceException{");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tdao.delete(id);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@GET");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Path(\"/readall/{offset}/{limit}\")");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic List<");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 200, 14)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("> readAll(@PathParam(\"offset\") int offset,");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t@PathParam(\"limit\") int limit) throws ServiceException{");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn dao.query(offset, limit);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            //process level 1 generizations 
            RuntimeTagElement _jettag_c_if_206_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_206_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_206_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_206_1.setTagInfo(_td_c_if_206_1);
            _jettag_c_if_206_1.doStart(context, out);
            while (_jettag_c_if_206_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_setVariable_207_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_207_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_207_6.setRuntimeParent(_jettag_c_if_206_1);
                _jettag_c_setVariable_207_6.setTagInfo(_td_c_setVariable_207_6);
                _jettag_c_setVariable_207_6.doStart(context, out);
                _jettag_c_setVariable_207_6.doEnd();
                // process the assocations for level 1 class 
                RuntimeTagElement _jettag_c_iterate_209_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_209_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_209_8.setRuntimeParent(_jettag_c_if_206_1);
                _jettag_c_iterate_209_8.setTagInfo(_td_c_iterate_209_8);
                _jettag_c_iterate_209_8.doStart(context, out);
                while (_jettag_c_iterate_209_8.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_210_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_210_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_210_9.setRuntimeParent(_jettag_c_iterate_209_8);
                    _jettag_c_iterate_210_9.setTagInfo(_td_c_iterate_210_9);
                    _jettag_c_iterate_210_9.doStart(context, out);
                    while (_jettag_c_iterate_210_9.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_211_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_211_10); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_211_10.setRuntimeParent(_jettag_c_iterate_210_9);
                        _jettag_c_iterate_211_10.setTagInfo(_td_c_iterate_211_10);
                        _jettag_c_iterate_211_10.doStart(context, out);
                        while (_jettag_c_iterate_211_10.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_212_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_212_11); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_212_11.setRuntimeParent(_jettag_c_iterate_211_10);
                            _jettag_c_setVariable_212_11.setTagInfo(_td_c_setVariable_212_11);
                            _jettag_c_setVariable_212_11.doStart(context, out);
                            _jettag_c_setVariable_212_11.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_214_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_214_13); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_214_13.setRuntimeParent(_jettag_c_iterate_211_10);
                            _jettag_c_if_214_13.setTagInfo(_td_c_if_214_13);
                            _jettag_c_if_214_13.doStart(context, out);
                            while (_jettag_c_if_214_13.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_216_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_216_19); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_216_19.setRuntimeParent(_jettag_c_if_214_13);
                                _jettag_c_iterate_216_19.setTagInfo(_td_c_iterate_216_19);
                                _jettag_c_iterate_216_19.doStart(context, out);
                                while (_jettag_c_iterate_216_19.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_218_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_218_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_218_18.setRuntimeParent(_jettag_c_iterate_216_19);
                                    _jettag_c_if_218_18.setTagInfo(_td_c_if_218_18);
                                    _jettag_c_if_218_18.doStart(context, out);
                                    while (_jettag_c_if_218_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_219_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_219_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_219_18.setRuntimeParent(_jettag_c_if_218_18);
                                        _jettag_c_if_219_18.setTagInfo(_td_c_if_219_18);
                                        _jettag_c_if_219_18.doStart(context, out);
                                        while (_jettag_c_if_219_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_220_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_220_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_220_19.setRuntimeParent(_jettag_c_if_219_18);
                                            _jettag_c_setVariable_220_19.setTagInfo(_td_c_setVariable_220_19);
                                            _jettag_c_setVariable_220_19.doStart(context, out);
                                            _jettag_c_setVariable_220_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_222_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_222_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_222_21.setRuntimeParent(_jettag_c_if_219_18);
                                            _jettag_c_if_222_21.setTagInfo(_td_c_if_222_21);
                                            _jettag_c_if_222_21.doStart(context, out);
                                            while (_jettag_c_if_222_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_224_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_224_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_224_19.setRuntimeParent(_jettag_c_if_222_21);
                                                _jettag_c_if_224_19.setTagInfo(_td_c_if_224_19);
                                                _jettag_c_if_224_19.doStart(context, out);
                                                while (_jettag_c_if_224_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_226_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_226_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_226_22.setRuntimeParent(_jettag_c_if_224_19);
                                                    _jettag_c_iterate_226_22.setTagInfo(_td_c_iterate_226_22);
                                                    _jettag_c_iterate_226_22.doStart(context, out);
                                                    while (_jettag_c_iterate_226_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_227_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_227_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_227_23.setRuntimeParent(_jettag_c_iterate_226_22);
                                                        _jettag_c_if_227_23.setTagInfo(_td_c_if_227_23);
                                                        _jettag_c_if_227_23.doStart(context, out);
                                                        while (_jettag_c_if_227_23.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\t@GET");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Path(\"/read/{id}/");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 229, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s\")");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic Collection<");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 230, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("> get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 230, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s(@PathParam(\"id\") Long id) throws ServiceException{");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\treturn dao.findById(id).get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 231, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s();");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_227_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_227_23.doEnd();
                                                        _jettag_c_iterate_226_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_226_22.doEnd();
                                                    _jettag_c_if_224_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_224_19.doEnd();
                                                _jettag_c_if_222_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_222_21.doEnd();
                                            _jettag_c_if_219_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_219_18.doEnd();
                                        _jettag_c_if_218_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_218_18.doEnd();
                                    _jettag_c_iterate_216_19.handleBodyContent(out);
                                }
                                _jettag_c_iterate_216_19.doEnd();
                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_214_13.handleBodyContent(out);
                            }
                            _jettag_c_if_214_13.doEnd();
                            _jettag_c_iterate_211_10.handleBodyContent(out);
                        }
                        _jettag_c_iterate_211_10.doEnd();
                        _jettag_c_iterate_210_9.handleBodyContent(out);
                    }
                    _jettag_c_iterate_210_9.doEnd();
                    _jettag_c_iterate_209_8.handleBodyContent(out);
                }
                _jettag_c_iterate_209_8.doEnd();
                _jettag_c_if_206_1.handleBodyContent(out);
            }
            _jettag_c_if_206_1.doEnd();
            //process level 2 generizations 
            RuntimeTagElement _jettag_c_if_247_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_247_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_247_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_247_1.setTagInfo(_td_c_if_247_1);
            _jettag_c_if_247_1.doStart(context, out);
            while (_jettag_c_if_247_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_setVariable_248_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_248_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_248_6.setRuntimeParent(_jettag_c_if_247_1);
                _jettag_c_setVariable_248_6.setTagInfo(_td_c_setVariable_248_6);
                _jettag_c_setVariable_248_6.doStart(context, out);
                _jettag_c_setVariable_248_6.doEnd();
                // process the assocations for level 1 class 
                RuntimeTagElement _jettag_c_iterate_250_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_250_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_250_8.setRuntimeParent(_jettag_c_if_247_1);
                _jettag_c_iterate_250_8.setTagInfo(_td_c_iterate_250_8);
                _jettag_c_iterate_250_8.doStart(context, out);
                while (_jettag_c_iterate_250_8.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_251_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_251_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_251_9.setRuntimeParent(_jettag_c_iterate_250_8);
                    _jettag_c_iterate_251_9.setTagInfo(_td_c_iterate_251_9);
                    _jettag_c_iterate_251_9.doStart(context, out);
                    while (_jettag_c_iterate_251_9.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_252_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_252_10); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_252_10.setRuntimeParent(_jettag_c_iterate_251_9);
                        _jettag_c_iterate_252_10.setTagInfo(_td_c_iterate_252_10);
                        _jettag_c_iterate_252_10.doStart(context, out);
                        while (_jettag_c_iterate_252_10.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_253_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_253_11); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_253_11.setRuntimeParent(_jettag_c_iterate_252_10);
                            _jettag_c_setVariable_253_11.setTagInfo(_td_c_setVariable_253_11);
                            _jettag_c_setVariable_253_11.doStart(context, out);
                            _jettag_c_setVariable_253_11.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_255_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_255_13); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_255_13.setRuntimeParent(_jettag_c_iterate_252_10);
                            _jettag_c_if_255_13.setTagInfo(_td_c_if_255_13);
                            _jettag_c_if_255_13.doStart(context, out);
                            while (_jettag_c_if_255_13.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_257_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_257_19); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_257_19.setRuntimeParent(_jettag_c_if_255_13);
                                _jettag_c_iterate_257_19.setTagInfo(_td_c_iterate_257_19);
                                _jettag_c_iterate_257_19.doStart(context, out);
                                while (_jettag_c_iterate_257_19.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_259_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_259_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_259_18.setRuntimeParent(_jettag_c_iterate_257_19);
                                    _jettag_c_if_259_18.setTagInfo(_td_c_if_259_18);
                                    _jettag_c_if_259_18.doStart(context, out);
                                    while (_jettag_c_if_259_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_260_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_260_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_260_18.setRuntimeParent(_jettag_c_if_259_18);
                                        _jettag_c_if_260_18.setTagInfo(_td_c_if_260_18);
                                        _jettag_c_if_260_18.doStart(context, out);
                                        while (_jettag_c_if_260_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_261_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_261_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_261_19.setRuntimeParent(_jettag_c_if_260_18);
                                            _jettag_c_setVariable_261_19.setTagInfo(_td_c_setVariable_261_19);
                                            _jettag_c_setVariable_261_19.doStart(context, out);
                                            _jettag_c_setVariable_261_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_263_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_263_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_263_21.setRuntimeParent(_jettag_c_if_260_18);
                                            _jettag_c_if_263_21.setTagInfo(_td_c_if_263_21);
                                            _jettag_c_if_263_21.doStart(context, out);
                                            while (_jettag_c_if_263_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_265_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_265_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_265_19.setRuntimeParent(_jettag_c_if_263_21);
                                                _jettag_c_if_265_19.setTagInfo(_td_c_if_265_19);
                                                _jettag_c_if_265_19.doStart(context, out);
                                                while (_jettag_c_if_265_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_267_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_267_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_267_22.setRuntimeParent(_jettag_c_if_265_19);
                                                    _jettag_c_iterate_267_22.setTagInfo(_td_c_iterate_267_22);
                                                    _jettag_c_iterate_267_22.doStart(context, out);
                                                    while (_jettag_c_iterate_267_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_268_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_268_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_268_23.setRuntimeParent(_jettag_c_iterate_267_22);
                                                        _jettag_c_if_268_23.setTagInfo(_td_c_if_268_23);
                                                        _jettag_c_if_268_23.doStart(context, out);
                                                        while (_jettag_c_if_268_23.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\t@GET");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Path(\"/read/{id}/");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 270, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s\")");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic Collection<");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 271, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("> get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 271, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s(@PathParam(\"id\") Long id) throws ServiceException{");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\treturn dao.findById(id).get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 272, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s();");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_268_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_268_23.doEnd();
                                                        _jettag_c_iterate_267_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_267_22.doEnd();
                                                    _jettag_c_if_265_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_265_19.doEnd();
                                                _jettag_c_if_263_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_263_21.doEnd();
                                            _jettag_c_if_260_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_260_18.doEnd();
                                        _jettag_c_if_259_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_259_18.doEnd();
                                    _jettag_c_iterate_257_19.handleBodyContent(out);
                                }
                                _jettag_c_iterate_257_19.doEnd();
                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_255_13.handleBodyContent(out);
                            }
                            _jettag_c_if_255_13.doEnd();
                            _jettag_c_iterate_252_10.handleBodyContent(out);
                        }
                        _jettag_c_iterate_252_10.doEnd();
                        _jettag_c_iterate_251_9.handleBodyContent(out);
                    }
                    _jettag_c_iterate_251_9.doEnd();
                    _jettag_c_iterate_250_8.handleBodyContent(out);
                }
                _jettag_c_iterate_250_8.doEnd();
                _jettag_c_if_247_1.handleBodyContent(out);
            }
            _jettag_c_if_247_1.doEnd();
            out.write(NL);         
            RuntimeTagElement _jettag_c_setVariable_288_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_288_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_288_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_setVariable_288_1.setTagInfo(_td_c_setVariable_288_1);
            _jettag_c_setVariable_288_1.doStart(context, out);
            _jettag_c_setVariable_288_1.doEnd();
            //process 0 level class relations 
            RuntimeTagElement _jettag_c_iterate_290_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_290_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_290_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_290_1.setTagInfo(_td_c_iterate_290_1);
            _jettag_c_iterate_290_1.doStart(context, out);
            while (_jettag_c_iterate_290_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_291_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_291_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_291_2.setRuntimeParent(_jettag_c_iterate_290_1);
                _jettag_c_iterate_291_2.setTagInfo(_td_c_iterate_291_2);
                _jettag_c_iterate_291_2.doStart(context, out);
                while (_jettag_c_iterate_291_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_292_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_292_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_292_3.setRuntimeParent(_jettag_c_iterate_291_2);
                    _jettag_c_iterate_292_3.setTagInfo(_td_c_iterate_292_3);
                    _jettag_c_iterate_292_3.doStart(context, out);
                    while (_jettag_c_iterate_292_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_293_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_293_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_293_4.setRuntimeParent(_jettag_c_iterate_292_3);
                        _jettag_c_setVariable_293_4.setTagInfo(_td_c_setVariable_293_4);
                        _jettag_c_setVariable_293_4.doStart(context, out);
                        _jettag_c_setVariable_293_4.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_295_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_295_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_295_6.setRuntimeParent(_jettag_c_iterate_292_3);
                        _jettag_c_if_295_6.setTagInfo(_td_c_if_295_6);
                        _jettag_c_if_295_6.doStart(context, out);
                        while (_jettag_c_if_295_6.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_297_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_297_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_297_12.setRuntimeParent(_jettag_c_if_295_6);
                            _jettag_c_iterate_297_12.setTagInfo(_td_c_iterate_297_12);
                            _jettag_c_iterate_297_12.doStart(context, out);
                            while (_jettag_c_iterate_297_12.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_299_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_299_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_299_12.setRuntimeParent(_jettag_c_iterate_297_12);
                                _jettag_c_if_299_12.setTagInfo(_td_c_if_299_12);
                                _jettag_c_if_299_12.doStart(context, out);
                                while (_jettag_c_if_299_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_300_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_300_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_300_12.setRuntimeParent(_jettag_c_if_299_12);
                                    _jettag_c_setVariable_300_12.setTagInfo(_td_c_setVariable_300_12);
                                    _jettag_c_setVariable_300_12.doStart(context, out);
                                    _jettag_c_setVariable_300_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_302_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_302_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_302_14.setRuntimeParent(_jettag_c_if_299_12);
                                    _jettag_c_if_302_14.setTagInfo(_td_c_if_302_14);
                                    _jettag_c_if_302_14.doStart(context, out);
                                    while (_jettag_c_if_302_14.okToProcessBody()) {
                                        // check to see if this is a navigable relation
                                        RuntimeTagElement _jettag_c_if_304_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_304_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_304_14.setRuntimeParent(_jettag_c_if_302_14);
                                        _jettag_c_if_304_14.setTagInfo(_td_c_if_304_14);
                                        _jettag_c_if_304_14.doStart(context, out);
                                        while (_jettag_c_if_304_14.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_306_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_306_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_306_9.setRuntimeParent(_jettag_c_if_304_14);
                                            _jettag_c_if_306_9.setTagInfo(_td_c_if_306_9);
                                            _jettag_c_if_306_9.doStart(context, out);
                                            while (_jettag_c_if_306_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_307_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_307_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_307_11.setRuntimeParent(_jettag_c_if_306_9);
                                                _jettag_c_if_307_11.setTagInfo(_td_c_if_307_11);
                                                _jettag_c_if_307_11.doStart(context, out);
                                                while (_jettag_c_if_307_11.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_309_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_309_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_309_15.setRuntimeParent(_jettag_c_if_307_11);
                                                    _jettag_c_iterate_309_15.setTagInfo(_td_c_iterate_309_15);
                                                    _jettag_c_iterate_309_15.doStart(context, out);
                                                    while (_jettag_c_iterate_309_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_310_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_310_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_310_16.setRuntimeParent(_jettag_c_iterate_309_15);
                                                        _jettag_c_if_310_16.setTagInfo(_td_c_if_310_16);
                                                        _jettag_c_if_310_16.doStart(context, out);
                                                        while (_jettag_c_if_310_16.okToProcessBody()) {
                                                            out.write("  \t\t\t\t\t  \t\t \t\t\t\t\t\t\t\t\t\t@GET");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t@Path(\"/read/{id}/");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 312, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s\")");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpublic Collection<");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 313, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("> get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 313, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s(@PathParam(\"id\") Long id) throws ServiceException{");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\treturn dao.findById(id).get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 314, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s();");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_310_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_310_16.doEnd();
                                                        _jettag_c_iterate_309_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_309_15.doEnd();
                                                    _jettag_c_if_307_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_307_11.doEnd();
                                                _jettag_c_if_306_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_306_9.doEnd();
                                            _jettag_c_if_304_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_304_14.doEnd();
                                        _jettag_c_if_302_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_302_14.doEnd();
                                    _jettag_c_if_299_12.handleBodyContent(out);
                                }
                                _jettag_c_if_299_12.doEnd();
                                _jettag_c_iterate_297_12.handleBodyContent(out);
                            }
                            _jettag_c_iterate_297_12.doEnd();
                            _jettag_c_if_295_6.handleBodyContent(out);
                        }
                        _jettag_c_if_295_6.doEnd();
                        _jettag_c_iterate_292_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_292_3.doEnd();
                    _jettag_c_iterate_291_2.handleBodyContent(out);
                }
                _jettag_c_iterate_291_2.doEnd();
                _jettag_c_iterate_290_1.handleBodyContent(out);
            }
            _jettag_c_iterate_290_1.doEnd();
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@GET");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Path(\"/count\")");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic Long count() throws ServiceException{");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn dao.size();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            RuntimeTagElement _jettag_c_if_336_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_336_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_336_1.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_336_1.setTagInfo(_td_c_if_336_1);
            _jettag_c_if_336_1.doStart(context, out);
            while (_jettag_c_if_336_1.okToProcessBody()) {
                out.write("\t@GET");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Path(\"/search/{searchText}\")");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 339, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> search(@PathParam(\"searchText\") String searchText) throws ServiceException{");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn dao.search(searchText);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                _jettag_c_if_336_1.handleBodyContent(out);
            }
            _jettag_c_if_336_1.doEnd();
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
