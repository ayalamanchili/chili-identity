package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_service_impljava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_entity_service_impljava() {
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
    private static final TagInfo _td_c_if_8_1 = new TagInfo("c:if", //$NON-NLS-1$
            8, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_30_1 = new TagInfo("c:if", //$NON-NLS-1$
            30, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_31_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            31, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_32_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            32, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_33_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            33, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_34_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            34, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_35_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            35, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_37_6 = new TagInfo("c:if", //$NON-NLS-1$
            37, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_39_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            39, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_40_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            40, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_42_13 = new TagInfo("c:if", //$NON-NLS-1$
            42, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_44_9 = new TagInfo("c:if", //$NON-NLS-1$
            44, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_45_11 = new TagInfo("c:if", //$NON-NLS-1$
            45, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_47_14 = new TagInfo("c:if", //$NON-NLS-1$
            47, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_49_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            49, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_50_16 = new TagInfo("c:if", //$NON-NLS-1$
            50, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_64_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            64, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_66_1 = new TagInfo("c:if", //$NON-NLS-1$
            66, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_67_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            67, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_68_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            68, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_69_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            69, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_70_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            70, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_71_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            71, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_73_6 = new TagInfo("c:if", //$NON-NLS-1$
            73, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_75_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            75, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_76_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            76, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_78_13 = new TagInfo("c:if", //$NON-NLS-1$
            78, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_80_9 = new TagInfo("c:if", //$NON-NLS-1$
            80, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_81_11 = new TagInfo("c:if", //$NON-NLS-1$
            81, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_83_14 = new TagInfo("c:if", //$NON-NLS-1$
            83, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_85_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            85, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_86_16 = new TagInfo("c:if", //$NON-NLS-1$
            86, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_100_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            100, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_102_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            102, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_103_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            103, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_104_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            104, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_105_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            105, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_107_6 = new TagInfo("c:if", //$NON-NLS-1$
            107, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_109_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            109, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
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
    private static final TagInfo _td_c_if_112_13 = new TagInfo("c:if", //$NON-NLS-1$
            112, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_114_9 = new TagInfo("c:if", //$NON-NLS-1$
            114, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_115_11 = new TagInfo("c:if", //$NON-NLS-1$
            115, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_117_14 = new TagInfo("c:if", //$NON-NLS-1$
            117, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
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
    private static final TagInfo _td_c_iterate_135_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            135, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_136_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            136, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_137_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            137, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_138_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            138, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_140_6 = new TagInfo("c:if", //$NON-NLS-1$
            140, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_142_6 = new TagInfo("c:if", //$NON-NLS-1$
            142, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_143_8 = new TagInfo("c:if", //$NON-NLS-1$
            143, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_145_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            145, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_147_12 = new TagInfo("c:if", //$NON-NLS-1$
            147, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_148_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            148, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_150_14 = new TagInfo("c:if", //$NON-NLS-1$
            150, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_152_14 = new TagInfo("c:if", //$NON-NLS-1$
            152, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_154_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            154, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_155_16 = new TagInfo("c:if", //$NON-NLS-1$
            155, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_171_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            171, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_172_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            172, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_173_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            173, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_174_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            174, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_176_6 = new TagInfo("c:if", //$NON-NLS-1$
            176, 6,
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
    private static final TagInfo _td_c_if_180_12 = new TagInfo("c:if", //$NON-NLS-1$
            180, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_181_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            181, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_183_14 = new TagInfo("c:if", //$NON-NLS-1$
            183, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
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
    private static final TagInfo _td_c_if_188_12 = new TagInfo("c:if", //$NON-NLS-1$
            188, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@parent1 = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_191_12 = new TagInfo("c:if", //$NON-NLS-1$
            191, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@parent2 = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_230_1 = new TagInfo("f:message", //$NON-NLS-1$
            230, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_232_1 = new TagInfo("f:message", //$NON-NLS-1$
            232, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_235_1 = new TagInfo("f:message", //$NON-NLS-1$
            235, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_239_1 = new TagInfo("f:message", //$NON-NLS-1$
            239, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_242_1 = new TagInfo("f:message", //$NON-NLS-1$
            242, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_245_1 = new TagInfo("f:message", //$NON-NLS-1$
            245, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_248_1 = new TagInfo("f:message", //$NON-NLS-1$
            248, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_254_1 = new TagInfo("f:message", //$NON-NLS-1$
            254, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_260_1 = new TagInfo("f:message", //$NON-NLS-1$
            260, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_269_1 = new TagInfo("f:message", //$NON-NLS-1$
            269, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_275_1 = new TagInfo("f:message", //$NON-NLS-1$
            275, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_285_1 = new TagInfo("c:if", //$NON-NLS-1$
            285, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_286_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            286, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_287_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            287, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_288_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            288, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_289_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            289, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_290_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            290, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_292_6 = new TagInfo("c:if", //$NON-NLS-1$
            292, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_294_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            294, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_295_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            295, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_297_13 = new TagInfo("c:if", //$NON-NLS-1$
            297, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_299_9 = new TagInfo("c:if", //$NON-NLS-1$
            299, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_300_11 = new TagInfo("c:if", //$NON-NLS-1$
            300, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_302_14 = new TagInfo("c:if", //$NON-NLS-1$
            302, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_304_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            304, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_305_16 = new TagInfo("c:if", //$NON-NLS-1$
            305, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_306_1 = new TagInfo("f:message", //$NON-NLS-1$
            306, 1,
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
    private static final TagInfo _td_c_setVariable_346_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            346, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_348_1 = new TagInfo("c:if", //$NON-NLS-1$
            348, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_349_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            349, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_350_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            350, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_351_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            351, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_352_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            352, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_353_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            353, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_355_6 = new TagInfo("c:if", //$NON-NLS-1$
            355, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_357_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            357, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_358_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            358, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_360_13 = new TagInfo("c:if", //$NON-NLS-1$
            360, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_362_9 = new TagInfo("c:if", //$NON-NLS-1$
            362, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_363_11 = new TagInfo("c:if", //$NON-NLS-1$
            363, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_365_14 = new TagInfo("c:if", //$NON-NLS-1$
            365, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_367_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            367, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_368_16 = new TagInfo("c:if", //$NON-NLS-1$
            368, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_369_1 = new TagInfo("f:message", //$NON-NLS-1$
            369, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_380_17 = new TagInfo("c:if", //$NON-NLS-1$
            380, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_381_1 = new TagInfo("f:message", //$NON-NLS-1$
            381, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_setVariable_410_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            410, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_412_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            412, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_413_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            413, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_414_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            414, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_415_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            415, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_417_6 = new TagInfo("c:if", //$NON-NLS-1$
            417, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_419_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            419, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_420_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            420, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_422_13 = new TagInfo("c:if", //$NON-NLS-1$
            422, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_424_9 = new TagInfo("c:if", //$NON-NLS-1$
            424, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_425_11 = new TagInfo("c:if", //$NON-NLS-1$
            425, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_427_14 = new TagInfo("c:if", //$NON-NLS-1$
            427, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_429_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            429, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_430_16 = new TagInfo("c:if", //$NON-NLS-1$
            430, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_431_1 = new TagInfo("f:message", //$NON-NLS-1$
            431, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_442_17 = new TagInfo("c:if", //$NON-NLS-1$
            442, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_443_1 = new TagInfo("f:message", //$NON-NLS-1$
            443, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_473_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            473, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_474_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            474, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_475_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            475, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_476_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            476, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_478_6 = new TagInfo("c:if", //$NON-NLS-1$
            478, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_480_6 = new TagInfo("c:if", //$NON-NLS-1$
            480, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_481_8 = new TagInfo("c:if", //$NON-NLS-1$
            481, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_483_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            483, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_485_12 = new TagInfo("c:if", //$NON-NLS-1$
            485, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_486_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            486, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_488_14 = new TagInfo("c:if", //$NON-NLS-1$
            488, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_490_14 = new TagInfo("c:if", //$NON-NLS-1$
            490, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_492_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            492, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_493_16 = new TagInfo("c:if", //$NON-NLS-1$
            493, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_495_1 = new TagInfo("f:message", //$NON-NLS-1$
            495, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_523_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            523, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_524_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            524, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_525_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            525, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_526_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            526, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_528_6 = new TagInfo("c:if", //$NON-NLS-1$
            528, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_530_6 = new TagInfo("c:if", //$NON-NLS-1$
            530, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_531_8 = new TagInfo("c:if", //$NON-NLS-1$
            531, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_533_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            533, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_535_12 = new TagInfo("c:if", //$NON-NLS-1$
            535, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_536_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            536, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_538_14 = new TagInfo("c:if", //$NON-NLS-1$
            538, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_540_14 = new TagInfo("c:if", //$NON-NLS-1$
            540, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_542_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            542, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_543_16 = new TagInfo("c:if", //$NON-NLS-1$
            543, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_545_1 = new TagInfo("f:message", //$NON-NLS-1$
            545, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_572_1 = new TagInfo("f:message", //$NON-NLS-1$
            572, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_584_1 = new TagInfo("f:message", //$NON-NLS-1$
            584, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_598_1 = new TagInfo("f:message", //$NON-NLS-1$
            598, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_608_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            608, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_609_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            609, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_610_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            610, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_611_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            611, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_613_6 = new TagInfo("c:if", //$NON-NLS-1$
            613, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_615_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            615, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_617_12 = new TagInfo("c:if", //$NON-NLS-1$
            617, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_618_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            618, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_620_14 = new TagInfo("c:if", //$NON-NLS-1$
            620, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_622_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            622, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_623_16 = new TagInfo("c:if", //$NON-NLS-1$
            623, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_624_1 = new TagInfo("f:message", //$NON-NLS-1$
            624, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_641_1 = new TagInfo("c:if", //$NON-NLS-1$
            641, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_642_1 = new TagInfo("f:message", //$NON-NLS-1$
            642, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_661_1 = new TagInfo("f:message", //$NON-NLS-1$
            661, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_675_1 = new TagInfo("f:message", //$NON-NLS-1$
            675, 1,
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
                out.write(".server;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_c_if_8_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_8_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_8_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_8_1.setTagInfo(_td_c_if_8_1);
                _jettag_c_if_8_1.doStart(context, out);
                while (_jettag_c_if_8_1.okToProcessBody()) {
                    out.write("import info.yalamanchili.commons.DataType;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import info.yalamanchili.commons.ReflectionUtils;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import info.yalamanchili.commons.SearchUtils;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import info.yalamanchili.gwt.beans.MultiSelectObjy;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import org.apache.lucene.analysis.standard.StandardAnalyzer;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import org.hibernate.search.FullTextQuery;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_8_1.handleBodyContent(out);
                }
                _jettag_c_if_8_1.doEnd();
                out.write("import java.util.HashMap;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Properties;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.HashSet;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Set;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.ejb.EJB;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.apache.lucene.util.Version;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Transactional;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 23, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".ejb.GenericServiceLocal;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.apache.commons.logging.Log;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.apache.commons.logging.LogFactory;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.server.GWTServletUtils;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.Query;");  //$NON-NLS-1$        
                out.write(NL);         
                // process all getRelated entities relations
                //process level2 generizations 
                RuntimeTagElement _jettag_c_if_30_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_30_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_30_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_30_1.setTagInfo(_td_c_if_30_1);
                _jettag_c_if_30_1.doStart(context, out);
                while (_jettag_c_if_30_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_31_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_31_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_31_6.setRuntimeParent(_jettag_c_if_30_1);
                    _jettag_c_setVariable_31_6.setTagInfo(_td_c_setVariable_31_6);
                    _jettag_c_setVariable_31_6.doStart(context, out);
                    _jettag_c_setVariable_31_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_32_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_32_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_32_6.setRuntimeParent(_jettag_c_if_30_1);
                    _jettag_c_iterate_32_6.setTagInfo(_td_c_iterate_32_6);
                    _jettag_c_iterate_32_6.doStart(context, out);
                    while (_jettag_c_iterate_32_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_33_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_33_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_33_2.setRuntimeParent(_jettag_c_iterate_32_6);
                        _jettag_c_iterate_33_2.setTagInfo(_td_c_iterate_33_2);
                        _jettag_c_iterate_33_2.doStart(context, out);
                        while (_jettag_c_iterate_33_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_34_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_34_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_34_3.setRuntimeParent(_jettag_c_iterate_33_2);
                            _jettag_c_iterate_34_3.setTagInfo(_td_c_iterate_34_3);
                            _jettag_c_iterate_34_3.doStart(context, out);
                            while (_jettag_c_iterate_34_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_35_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_35_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_35_4.setRuntimeParent(_jettag_c_iterate_34_3);
                                _jettag_c_setVariable_35_4.setTagInfo(_td_c_setVariable_35_4);
                                _jettag_c_setVariable_35_4.doStart(context, out);
                                _jettag_c_setVariable_35_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_37_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_37_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_37_6.setRuntimeParent(_jettag_c_iterate_34_3);
                                _jettag_c_if_37_6.setTagInfo(_td_c_if_37_6);
                                _jettag_c_if_37_6.doStart(context, out);
                                while (_jettag_c_if_37_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_39_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_39_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_39_12.setRuntimeParent(_jettag_c_if_37_6);
                                    _jettag_c_iterate_39_12.setTagInfo(_td_c_iterate_39_12);
                                    _jettag_c_iterate_39_12.doStart(context, out);
                                    while (_jettag_c_iterate_39_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_40_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_40_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_40_12.setRuntimeParent(_jettag_c_iterate_39_12);
                                        _jettag_c_setVariable_40_12.setTagInfo(_td_c_setVariable_40_12);
                                        _jettag_c_setVariable_40_12.doStart(context, out);
                                        _jettag_c_setVariable_40_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_42_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_42_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_42_13.setRuntimeParent(_jettag_c_iterate_39_12);
                                        _jettag_c_if_42_13.setTagInfo(_td_c_if_42_13);
                                        _jettag_c_if_42_13.doStart(context, out);
                                        while (_jettag_c_if_42_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_44_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_44_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_44_9.setRuntimeParent(_jettag_c_if_42_13);
                                            _jettag_c_if_44_9.setTagInfo(_td_c_if_44_9);
                                            _jettag_c_if_44_9.doStart(context, out);
                                            while (_jettag_c_if_44_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_45_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_45_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_45_11.setRuntimeParent(_jettag_c_if_44_9);
                                                _jettag_c_if_45_11.setTagInfo(_td_c_if_45_11);
                                                _jettag_c_if_45_11.doStart(context, out);
                                                while (_jettag_c_if_45_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_47_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_47_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_47_14.setRuntimeParent(_jettag_c_if_45_11);
                                                    _jettag_c_if_47_14.setTagInfo(_td_c_if_47_14);
                                                    _jettag_c_if_47_14.doStart(context, out);
                                                    while (_jettag_c_if_47_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_49_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_49_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_49_15.setRuntimeParent(_jettag_c_if_47_14);
                                                        _jettag_c_iterate_49_15.setTagInfo(_td_c_iterate_49_15);
                                                        _jettag_c_iterate_49_15.doStart(context, out);
                                                        while (_jettag_c_iterate_49_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_50_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_50_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_50_16.setRuntimeParent(_jettag_c_iterate_49_15);
                                                            _jettag_c_if_50_16.setTagInfo(_td_c_if_50_16);
                                                            _jettag_c_if_50_16.doStart(context, out);
                                                            while (_jettag_c_if_50_16.okToProcessBody()) {
                                                                out.write("import ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 51, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".entity.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 51, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 51, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(";");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_50_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_50_16.doEnd();
                                                            _jettag_c_iterate_49_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_49_15.doEnd();
                                                        _jettag_c_if_47_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_47_14.doEnd();
                                                    _jettag_c_if_45_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_45_11.doEnd();
                                                _jettag_c_if_44_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_44_9.doEnd();
                                            _jettag_c_if_42_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_42_13.doEnd();
                                        _jettag_c_iterate_39_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_39_12.doEnd();
                                    _jettag_c_if_37_6.handleBodyContent(out);
                                }
                                _jettag_c_if_37_6.doEnd();
                                _jettag_c_iterate_34_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_34_3.doEnd();
                            _jettag_c_iterate_33_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_33_2.doEnd();
                        _jettag_c_iterate_32_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_32_6.doEnd();
                    _jettag_c_if_30_1.handleBodyContent(out);
                }
                _jettag_c_if_30_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_64_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_64_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_64_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_64_1.setTagInfo(_td_c_setVariable_64_1);
                _jettag_c_setVariable_64_1.doStart(context, out);
                _jettag_c_setVariable_64_1.doEnd();
                //process level 1 generizations 
                RuntimeTagElement _jettag_c_if_66_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_66_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_66_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_66_1.setTagInfo(_td_c_if_66_1);
                _jettag_c_if_66_1.doStart(context, out);
                while (_jettag_c_if_66_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_67_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_67_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_67_6.setRuntimeParent(_jettag_c_if_66_1);
                    _jettag_c_setVariable_67_6.setTagInfo(_td_c_setVariable_67_6);
                    _jettag_c_setVariable_67_6.doStart(context, out);
                    _jettag_c_setVariable_67_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_68_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_68_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_68_6.setRuntimeParent(_jettag_c_if_66_1);
                    _jettag_c_iterate_68_6.setTagInfo(_td_c_iterate_68_6);
                    _jettag_c_iterate_68_6.doStart(context, out);
                    while (_jettag_c_iterate_68_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_69_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_69_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_69_2.setRuntimeParent(_jettag_c_iterate_68_6);
                        _jettag_c_iterate_69_2.setTagInfo(_td_c_iterate_69_2);
                        _jettag_c_iterate_69_2.doStart(context, out);
                        while (_jettag_c_iterate_69_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_70_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_70_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_70_3.setRuntimeParent(_jettag_c_iterate_69_2);
                            _jettag_c_iterate_70_3.setTagInfo(_td_c_iterate_70_3);
                            _jettag_c_iterate_70_3.doStart(context, out);
                            while (_jettag_c_iterate_70_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_71_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_71_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_71_4.setRuntimeParent(_jettag_c_iterate_70_3);
                                _jettag_c_setVariable_71_4.setTagInfo(_td_c_setVariable_71_4);
                                _jettag_c_setVariable_71_4.doStart(context, out);
                                _jettag_c_setVariable_71_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_73_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_73_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_73_6.setRuntimeParent(_jettag_c_iterate_70_3);
                                _jettag_c_if_73_6.setTagInfo(_td_c_if_73_6);
                                _jettag_c_if_73_6.doStart(context, out);
                                while (_jettag_c_if_73_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_75_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_75_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_75_12.setRuntimeParent(_jettag_c_if_73_6);
                                    _jettag_c_iterate_75_12.setTagInfo(_td_c_iterate_75_12);
                                    _jettag_c_iterate_75_12.doStart(context, out);
                                    while (_jettag_c_iterate_75_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_76_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_76_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_76_12.setRuntimeParent(_jettag_c_iterate_75_12);
                                        _jettag_c_setVariable_76_12.setTagInfo(_td_c_setVariable_76_12);
                                        _jettag_c_setVariable_76_12.doStart(context, out);
                                        _jettag_c_setVariable_76_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_78_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_78_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_78_13.setRuntimeParent(_jettag_c_iterate_75_12);
                                        _jettag_c_if_78_13.setTagInfo(_td_c_if_78_13);
                                        _jettag_c_if_78_13.doStart(context, out);
                                        while (_jettag_c_if_78_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_80_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_80_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_80_9.setRuntimeParent(_jettag_c_if_78_13);
                                            _jettag_c_if_80_9.setTagInfo(_td_c_if_80_9);
                                            _jettag_c_if_80_9.doStart(context, out);
                                            while (_jettag_c_if_80_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_81_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_81_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_81_11.setRuntimeParent(_jettag_c_if_80_9);
                                                _jettag_c_if_81_11.setTagInfo(_td_c_if_81_11);
                                                _jettag_c_if_81_11.doStart(context, out);
                                                while (_jettag_c_if_81_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_83_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_83_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_83_14.setRuntimeParent(_jettag_c_if_81_11);
                                                    _jettag_c_if_83_14.setTagInfo(_td_c_if_83_14);
                                                    _jettag_c_if_83_14.doStart(context, out);
                                                    while (_jettag_c_if_83_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_85_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_85_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_85_15.setRuntimeParent(_jettag_c_if_83_14);
                                                        _jettag_c_iterate_85_15.setTagInfo(_td_c_iterate_85_15);
                                                        _jettag_c_iterate_85_15.doStart(context, out);
                                                        while (_jettag_c_iterate_85_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_86_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_86_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_86_16.setRuntimeParent(_jettag_c_iterate_85_15);
                                                            _jettag_c_if_86_16.setTagInfo(_td_c_if_86_16);
                                                            _jettag_c_if_86_16.doStart(context, out);
                                                            while (_jettag_c_if_86_16.okToProcessBody()) {
                                                                out.write("import ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 87, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".entity.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 87, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 87, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(";");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_86_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_86_16.doEnd();
                                                            _jettag_c_iterate_85_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_85_15.doEnd();
                                                        _jettag_c_if_83_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_83_14.doEnd();
                                                    _jettag_c_if_81_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_81_11.doEnd();
                                                _jettag_c_if_80_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_80_9.doEnd();
                                            _jettag_c_if_78_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_78_13.doEnd();
                                        _jettag_c_iterate_75_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_75_12.doEnd();
                                    _jettag_c_if_73_6.handleBodyContent(out);
                                }
                                _jettag_c_if_73_6.doEnd();
                                _jettag_c_iterate_70_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_70_3.doEnd();
                            _jettag_c_iterate_69_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_69_2.doEnd();
                        _jettag_c_iterate_68_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_68_6.doEnd();
                    _jettag_c_if_66_1.handleBodyContent(out);
                }
                _jettag_c_if_66_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_100_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_100_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_100_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_100_1.setTagInfo(_td_c_setVariable_100_1);
                _jettag_c_setVariable_100_1.doStart(context, out);
                _jettag_c_setVariable_100_1.doEnd();
                //level 0 
                RuntimeTagElement _jettag_c_iterate_102_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_102_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_102_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_102_1.setTagInfo(_td_c_iterate_102_1);
                _jettag_c_iterate_102_1.doStart(context, out);
                while (_jettag_c_iterate_102_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_103_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_103_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_103_2.setRuntimeParent(_jettag_c_iterate_102_1);
                    _jettag_c_iterate_103_2.setTagInfo(_td_c_iterate_103_2);
                    _jettag_c_iterate_103_2.doStart(context, out);
                    while (_jettag_c_iterate_103_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_104_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_104_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_104_3.setRuntimeParent(_jettag_c_iterate_103_2);
                        _jettag_c_iterate_104_3.setTagInfo(_td_c_iterate_104_3);
                        _jettag_c_iterate_104_3.doStart(context, out);
                        while (_jettag_c_iterate_104_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_105_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_105_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_105_4.setRuntimeParent(_jettag_c_iterate_104_3);
                            _jettag_c_setVariable_105_4.setTagInfo(_td_c_setVariable_105_4);
                            _jettag_c_setVariable_105_4.doStart(context, out);
                            _jettag_c_setVariable_105_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_107_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_107_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_107_6.setRuntimeParent(_jettag_c_iterate_104_3);
                            _jettag_c_if_107_6.setTagInfo(_td_c_if_107_6);
                            _jettag_c_if_107_6.doStart(context, out);
                            while (_jettag_c_if_107_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_109_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_109_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_109_12.setRuntimeParent(_jettag_c_if_107_6);
                                _jettag_c_iterate_109_12.setTagInfo(_td_c_iterate_109_12);
                                _jettag_c_iterate_109_12.doStart(context, out);
                                while (_jettag_c_iterate_109_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_110_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_110_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_110_12.setRuntimeParent(_jettag_c_iterate_109_12);
                                    _jettag_c_setVariable_110_12.setTagInfo(_td_c_setVariable_110_12);
                                    _jettag_c_setVariable_110_12.doStart(context, out);
                                    _jettag_c_setVariable_110_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_112_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_112_13); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_112_13.setRuntimeParent(_jettag_c_iterate_109_12);
                                    _jettag_c_if_112_13.setTagInfo(_td_c_if_112_13);
                                    _jettag_c_if_112_13.doStart(context, out);
                                    while (_jettag_c_if_112_13.okToProcessBody()) {
                                        // process many on target
                                        RuntimeTagElement _jettag_c_if_114_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_114_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_114_9.setRuntimeParent(_jettag_c_if_112_13);
                                        _jettag_c_if_114_9.setTagInfo(_td_c_if_114_9);
                                        _jettag_c_if_114_9.doStart(context, out);
                                        while (_jettag_c_if_114_9.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_115_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_115_11); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_115_11.setRuntimeParent(_jettag_c_if_114_9);
                                            _jettag_c_if_115_11.setTagInfo(_td_c_if_115_11);
                                            _jettag_c_if_115_11.doStart(context, out);
                                            while (_jettag_c_if_115_11.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_117_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_117_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_117_14.setRuntimeParent(_jettag_c_if_115_11);
                                                _jettag_c_if_117_14.setTagInfo(_td_c_if_117_14);
                                                _jettag_c_if_117_14.doStart(context, out);
                                                while (_jettag_c_if_117_14.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_119_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_119_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_119_15.setRuntimeParent(_jettag_c_if_117_14);
                                                    _jettag_c_iterate_119_15.setTagInfo(_td_c_iterate_119_15);
                                                    _jettag_c_iterate_119_15.doStart(context, out);
                                                    while (_jettag_c_iterate_119_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_120_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_120_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_120_16.setRuntimeParent(_jettag_c_iterate_119_15);
                                                        _jettag_c_if_120_16.setTagInfo(_td_c_if_120_16);
                                                        _jettag_c_if_120_16.doStart(context, out);
                                                        while (_jettag_c_if_120_16.okToProcessBody()) {
                                                            out.write("import ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 121, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".entity.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 121, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 121, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_120_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_120_16.doEnd();
                                                        _jettag_c_iterate_119_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_119_15.doEnd();
                                                    _jettag_c_if_117_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_117_14.doEnd();
                                                _jettag_c_if_115_11.handleBodyContent(out);
                                            }
                                            _jettag_c_if_115_11.doEnd();
                                            _jettag_c_if_114_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_114_9.doEnd();
                                        _jettag_c_if_112_13.handleBodyContent(out);
                                    }
                                    _jettag_c_if_112_13.doEnd();
                                    _jettag_c_iterate_109_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_109_12.doEnd();
                                _jettag_c_if_107_6.handleBodyContent(out);
                            }
                            _jettag_c_if_107_6.doEnd();
                            _jettag_c_iterate_104_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_104_3.doEnd();
                        _jettag_c_iterate_103_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_103_2.doEnd();
                    _jettag_c_iterate_102_1.handleBodyContent(out);
                }
                _jettag_c_iterate_102_1.doEnd();
                out.write(NL);         
                // process all addAll relations
                RuntimeTagElement _jettag_c_iterate_135_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_135_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_135_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_135_1.setTagInfo(_td_c_iterate_135_1);
                _jettag_c_iterate_135_1.doStart(context, out);
                while (_jettag_c_iterate_135_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_136_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_136_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_136_2.setRuntimeParent(_jettag_c_iterate_135_1);
                    _jettag_c_iterate_136_2.setTagInfo(_td_c_iterate_136_2);
                    _jettag_c_iterate_136_2.doStart(context, out);
                    while (_jettag_c_iterate_136_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_137_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_137_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_137_3.setRuntimeParent(_jettag_c_iterate_136_2);
                        _jettag_c_iterate_137_3.setTagInfo(_td_c_iterate_137_3);
                        _jettag_c_iterate_137_3.doStart(context, out);
                        while (_jettag_c_iterate_137_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_138_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_138_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_138_4.setRuntimeParent(_jettag_c_iterate_137_3);
                            _jettag_c_setVariable_138_4.setTagInfo(_td_c_setVariable_138_4);
                            _jettag_c_setVariable_138_4.doStart(context, out);
                            _jettag_c_setVariable_138_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_140_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_140_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_140_6.setRuntimeParent(_jettag_c_iterate_137_3);
                            _jettag_c_if_140_6.setTagInfo(_td_c_if_140_6);
                            _jettag_c_if_140_6.doStart(context, out);
                            while (_jettag_c_if_140_6.okToProcessBody()) {
                                // process only classes with many on source side
                                RuntimeTagElement _jettag_c_if_142_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_142_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_142_6.setRuntimeParent(_jettag_c_if_140_6);
                                _jettag_c_if_142_6.setTagInfo(_td_c_if_142_6);
                                _jettag_c_if_142_6.doStart(context, out);
                                while (_jettag_c_if_142_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_143_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_143_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_143_8.setRuntimeParent(_jettag_c_if_142_6);
                                    _jettag_c_if_143_8.setTagInfo(_td_c_if_143_8);
                                    _jettag_c_if_143_8.doStart(context, out);
                                    while (_jettag_c_if_143_8.okToProcessBody()) {
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_145_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_145_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_145_12.setRuntimeParent(_jettag_c_if_143_8);
                                        _jettag_c_iterate_145_12.setTagInfo(_td_c_iterate_145_12);
                                        _jettag_c_iterate_145_12.doStart(context, out);
                                        while (_jettag_c_iterate_145_12.okToProcessBody()) {
                                            // process only non composites 
                                            RuntimeTagElement _jettag_c_if_147_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_147_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_147_12.setRuntimeParent(_jettag_c_iterate_145_12);
                                            _jettag_c_if_147_12.setTagInfo(_td_c_if_147_12);
                                            _jettag_c_if_147_12.doStart(context, out);
                                            while (_jettag_c_if_147_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_148_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_148_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_148_12.setRuntimeParent(_jettag_c_if_147_12);
                                                _jettag_c_setVariable_148_12.setTagInfo(_td_c_setVariable_148_12);
                                                _jettag_c_setVariable_148_12.doStart(context, out);
                                                _jettag_c_setVariable_148_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_150_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_150_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_150_14.setRuntimeParent(_jettag_c_if_147_12);
                                                _jettag_c_if_150_14.setTagInfo(_td_c_if_150_14);
                                                _jettag_c_if_150_14.doStart(context, out);
                                                while (_jettag_c_if_150_14.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_152_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_152_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_152_14.setRuntimeParent(_jettag_c_if_150_14);
                                                    _jettag_c_if_152_14.setTagInfo(_td_c_if_152_14);
                                                    _jettag_c_if_152_14.doStart(context, out);
                                                    while (_jettag_c_if_152_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_154_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_154_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_154_15.setRuntimeParent(_jettag_c_if_152_14);
                                                        _jettag_c_iterate_154_15.setTagInfo(_td_c_iterate_154_15);
                                                        _jettag_c_iterate_154_15.doStart(context, out);
                                                        while (_jettag_c_iterate_154_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_155_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_155_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_155_16.setRuntimeParent(_jettag_c_iterate_154_15);
                                                            _jettag_c_if_155_16.setTagInfo(_td_c_if_155_16);
                                                            _jettag_c_if_155_16.doStart(context, out);
                                                            while (_jettag_c_if_155_16.okToProcessBody()) {
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\timport ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 156, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".entity.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 156, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 156, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(";");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_155_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_155_16.doEnd();
                                                            _jettag_c_iterate_154_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_154_15.doEnd();
                                                        _jettag_c_if_152_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_152_14.doEnd();
                                                    _jettag_c_if_150_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_150_14.doEnd();
                                                _jettag_c_if_147_12.handleBodyContent(out);
                                            }
                                            _jettag_c_if_147_12.doEnd();
                                            _jettag_c_iterate_145_12.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_145_12.doEnd();
                                        _jettag_c_if_143_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_143_8.doEnd();
                                    _jettag_c_if_142_6.handleBodyContent(out);
                                }
                                _jettag_c_if_142_6.doEnd();
                                _jettag_c_if_140_6.handleBodyContent(out);
                            }
                            _jettag_c_if_140_6.doEnd();
                            _jettag_c_iterate_137_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_137_3.doEnd();
                        _jettag_c_iterate_136_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_136_2.doEnd();
                    _jettag_c_iterate_135_1.handleBodyContent(out);
                }
                _jettag_c_iterate_135_1.doEnd();
                out.write(NL);         
                // process all merge relations
                RuntimeTagElement _jettag_c_iterate_171_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_171_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_171_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_171_1.setTagInfo(_td_c_iterate_171_1);
                _jettag_c_iterate_171_1.doStart(context, out);
                while (_jettag_c_iterate_171_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_172_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_172_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_172_2.setRuntimeParent(_jettag_c_iterate_171_1);
                    _jettag_c_iterate_172_2.setTagInfo(_td_c_iterate_172_2);
                    _jettag_c_iterate_172_2.doStart(context, out);
                    while (_jettag_c_iterate_172_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_173_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_173_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_173_3.setRuntimeParent(_jettag_c_iterate_172_2);
                        _jettag_c_iterate_173_3.setTagInfo(_td_c_iterate_173_3);
                        _jettag_c_iterate_173_3.doStart(context, out);
                        while (_jettag_c_iterate_173_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_174_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_174_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_174_4.setRuntimeParent(_jettag_c_iterate_173_3);
                            _jettag_c_setVariable_174_4.setTagInfo(_td_c_setVariable_174_4);
                            _jettag_c_setVariable_174_4.doStart(context, out);
                            _jettag_c_setVariable_174_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_176_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_176_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_176_6.setRuntimeParent(_jettag_c_iterate_173_3);
                            _jettag_c_if_176_6.setTagInfo(_td_c_if_176_6);
                            _jettag_c_if_176_6.doStart(context, out);
                            while (_jettag_c_if_176_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_178_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_178_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_178_12.setRuntimeParent(_jettag_c_if_176_6);
                                _jettag_c_iterate_178_12.setTagInfo(_td_c_iterate_178_12);
                                _jettag_c_iterate_178_12.doStart(context, out);
                                while (_jettag_c_iterate_178_12.okToProcessBody()) {
                                    // process only  composites on target
                                    RuntimeTagElement _jettag_c_if_180_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_180_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_180_12.setRuntimeParent(_jettag_c_iterate_178_12);
                                    _jettag_c_if_180_12.setTagInfo(_td_c_if_180_12);
                                    _jettag_c_if_180_12.doStart(context, out);
                                    while (_jettag_c_if_180_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_181_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_181_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_181_12.setRuntimeParent(_jettag_c_if_180_12);
                                        _jettag_c_setVariable_181_12.setTagInfo(_td_c_setVariable_181_12);
                                        _jettag_c_setVariable_181_12.doStart(context, out);
                                        _jettag_c_setVariable_181_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_183_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_183_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_183_14.setRuntimeParent(_jettag_c_if_180_12);
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
                                                    out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 187, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".entity.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 187, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 187, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    RuntimeTagElement _jettag_c_if_188_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_188_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_188_12.setRuntimeParent(_jettag_c_if_186_16);
                                                    _jettag_c_if_188_12.setTagInfo(_td_c_if_188_12);
                                                    _jettag_c_if_188_12.doStart(context, out);
                                                    while (_jettag_c_if_188_12.okToProcessBody()) {
                                                        out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 189, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entity.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 189, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@parentClass1Name}", 189, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_188_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_188_12.doEnd();
                                                    RuntimeTagElement _jettag_c_if_191_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_191_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_191_12.setRuntimeParent(_jettag_c_if_186_16);
                                                    _jettag_c_if_191_12.setTagInfo(_td_c_if_191_12);
                                                    _jettag_c_if_191_12.doStart(context, out);
                                                    while (_jettag_c_if_191_12.okToProcessBody()) {
                                                        out.write(" \t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 192, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entity.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 192, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@parentClass2Name}", 192, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_191_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_191_12.doEnd();
                                                    _jettag_c_if_186_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_186_16.doEnd();
                                                _jettag_c_iterate_185_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_185_15.doEnd();
                                            _jettag_c_if_183_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_183_14.doEnd();
                                        _jettag_c_if_180_12.handleBodyContent(out);
                                    }
                                    _jettag_c_if_180_12.doEnd();
                                    _jettag_c_iterate_178_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_178_12.doEnd();
                                _jettag_c_if_176_6.handleBodyContent(out);
                            }
                            _jettag_c_if_176_6.doEnd();
                            _jettag_c_iterate_173_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_173_3.doEnd();
                        _jettag_c_iterate_172_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_172_2.doEnd();
                    _jettag_c_iterate_171_1.handleBodyContent(out);
                }
                _jettag_c_iterate_171_1.doEnd();
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 204, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".ejb.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 204, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 204, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 204, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceLocal;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 205, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 205, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 205, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import java.io.Serializable;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.lang.reflect.Method;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.HashMap;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.ArrayList;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Map;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.EntityManager;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Create;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.In;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Name;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.beans.TableObj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.remoting.WebRemote;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import org.jboss.seam.annotations.Scope;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import org.jboss.seam.ScopeType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.trace.Trace;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.server.GileadService;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("@Trace");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Transactional");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Scope(ScopeType.SESSION)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("@Name(\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 229, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 229, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 229, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service\")");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_230_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_230_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_230_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_230_1.setTagInfo(_td_f_message_230_1);
                _jettag_f_message_230_1.doStart(context, out);
                JET2Writer _jettag_f_message_230_1_saved_out = out;
                while (_jettag_f_message_230_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_230_1.handleBodyContent(out);
                }
                out = _jettag_f_message_230_1_saved_out;
                _jettag_f_message_230_1.doEnd();
                out.write(NL);         
                out.write("public class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 231, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceImpl extends GileadService implements ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 231, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 231, 90)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 231, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_232_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_232_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_232_1.setRuntimeParent(_jettag_f_bundle_3_1);
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
                out.write(NL);         
                out.write("\tprivate static final Log log = LogFactory");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t.getLog(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 234, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceImpl.class);");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_235_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_235_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_235_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_235_1.setTagInfo(_td_f_message_235_1);
                _jettag_f_message_235_1.doStart(context, out);
                JET2Writer _jettag_f_message_235_1_saved_out = out;
                while (_jettag_f_message_235_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_235_1.handleBodyContent(out);
                }
                out = _jettag_f_message_235_1_saved_out;
                _jettag_f_message_235_1.doEnd();
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 236, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceImpl() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tsuper(\"java:/");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$projectName}", 237, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_239_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_239_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_239_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_239_1.setTagInfo(_td_f_message_239_1);
                _jettag_f_message_239_1.doStart(context, out);
                JET2Writer _jettag_f_message_239_1_saved_out = out;
                while (_jettag_f_message_239_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_239_1.handleBodyContent(out);
                }
                out = _jettag_f_message_239_1_saved_out;
                _jettag_f_message_239_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t//@In(create = true)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t//protected GenericServiceLocal genericServiceBean;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_242_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_242_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_242_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_242_1.setTagInfo(_td_f_message_242_1);
                _jettag_f_message_242_1.doStart(context, out);
                JET2Writer _jettag_f_message_242_1_saved_out = out;
                while (_jettag_f_message_242_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_242_1.handleBodyContent(out);
                }
                out = _jettag_f_message_242_1_saved_out;
                _jettag_f_message_242_1.doEnd();
                out.write(NL);         
                out.write("\t//@In(create = true)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t//protected ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 244, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceLocal ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 244, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceBean;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_245_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_245_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_245_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_245_1.setTagInfo(_td_f_message_245_1);
                _jettag_f_message_245_1.doStart(context, out);
                JET2Writer _jettag_f_message_245_1_saved_out = out;
                while (_jettag_f_message_245_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_245_1.handleBodyContent(out);
                }
                out = _jettag_f_message_245_1_saved_out;
                _jettag_f_message_245_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@In(create = true)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected EntityManager em;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_248_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_248_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_248_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_248_1.setTagInfo(_td_f_message_248_1);
                _jettag_f_message_248_1.doStart(context, out);
                JET2Writer _jettag_f_message_248_1_saved_out = out;
                while (_jettag_f_message_248_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_248_1.handleBodyContent(out);
                }
                out = _jettag_f_message_248_1_saved_out;
                _jettag_f_message_248_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@WebRemote");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 251, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" create(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 251, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn  (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 252, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(") getBeanManager().clone(em.merge(entity));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_254_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_254_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_254_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_254_1.setTagInfo(_td_f_message_254_1);
                _jettag_f_message_254_1.doStart(context, out);
                JET2Writer _jettag_f_message_254_1_saved_out = out;
                while (_jettag_f_message_254_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_254_1.handleBodyContent(out);
                }
                out = _jettag_f_message_254_1_saved_out;
                _jettag_f_message_254_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@WebRemote");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void delete(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 257, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tem.remove(em.find(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 258, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class, entity.getId()));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_260_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_260_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_260_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_260_1.setTagInfo(_td_f_message_260_1);
                _jettag_f_message_260_1.doStart(context, out);
                JET2Writer _jettag_f_message_260_1_saved_out = out;
                while (_jettag_f_message_260_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_260_1.handleBodyContent(out);
                }
                out = _jettag_f_message_260_1_saved_out;
                _jettag_f_message_260_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@WebRemote");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic TableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 263, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> getTableObj( int start) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tTableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 264, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> tableObj = new TableObj<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 264, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\ttableObj.setRecords(getEntities(start));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\ttableObj.setNumberOfRecords(getEntitySize());");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn tableObj;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_269_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_269_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_269_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_269_1.setTagInfo(_td_f_message_269_1);
                _jettag_f_message_269_1.doStart(context, out);
                JET2Writer _jettag_f_message_269_1_saved_out = out;
                while (_jettag_f_message_269_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_269_1.handleBodyContent(out);
                }
                out = _jettag_f_message_269_1_saved_out;
                _jettag_f_message_269_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@WebRemote");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 272, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" read( Long id) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 273, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(") getBeanManager().clone(em.find(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 273, 59)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class, id));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_275_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_275_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_275_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_275_1.setTagInfo(_td_f_message_275_1);
                _jettag_f_message_275_1.doStart(context, out);
                JET2Writer _jettag_f_message_275_1_saved_out = out;
                while (_jettag_f_message_275_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_275_1.handleBodyContent(out);
                }
                out = _jettag_f_message_275_1_saved_out;
                _jettag_f_message_275_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@WebRemote");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 278, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" update(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 278, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tem.merge(getBeanManager().merge(entity));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn entity;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                // process all getRelated entities relations
                //process level2 generizations 
                RuntimeTagElement _jettag_c_if_285_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_285_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_285_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_285_1.setTagInfo(_td_c_if_285_1);
                _jettag_c_if_285_1.doStart(context, out);
                while (_jettag_c_if_285_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_286_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_286_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_286_6.setRuntimeParent(_jettag_c_if_285_1);
                    _jettag_c_setVariable_286_6.setTagInfo(_td_c_setVariable_286_6);
                    _jettag_c_setVariable_286_6.doStart(context, out);
                    _jettag_c_setVariable_286_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_287_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_287_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_287_6.setRuntimeParent(_jettag_c_if_285_1);
                    _jettag_c_iterate_287_6.setTagInfo(_td_c_iterate_287_6);
                    _jettag_c_iterate_287_6.doStart(context, out);
                    while (_jettag_c_iterate_287_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_288_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_288_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_288_2.setRuntimeParent(_jettag_c_iterate_287_6);
                        _jettag_c_iterate_288_2.setTagInfo(_td_c_iterate_288_2);
                        _jettag_c_iterate_288_2.doStart(context, out);
                        while (_jettag_c_iterate_288_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_289_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_289_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_289_3.setRuntimeParent(_jettag_c_iterate_288_2);
                            _jettag_c_iterate_289_3.setTagInfo(_td_c_iterate_289_3);
                            _jettag_c_iterate_289_3.doStart(context, out);
                            while (_jettag_c_iterate_289_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_290_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_290_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_290_4.setRuntimeParent(_jettag_c_iterate_289_3);
                                _jettag_c_setVariable_290_4.setTagInfo(_td_c_setVariable_290_4);
                                _jettag_c_setVariable_290_4.doStart(context, out);
                                _jettag_c_setVariable_290_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_292_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_292_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_292_6.setRuntimeParent(_jettag_c_iterate_289_3);
                                _jettag_c_if_292_6.setTagInfo(_td_c_if_292_6);
                                _jettag_c_if_292_6.doStart(context, out);
                                while (_jettag_c_if_292_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_294_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_294_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_294_12.setRuntimeParent(_jettag_c_if_292_6);
                                    _jettag_c_iterate_294_12.setTagInfo(_td_c_iterate_294_12);
                                    _jettag_c_iterate_294_12.doStart(context, out);
                                    while (_jettag_c_iterate_294_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_295_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_295_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_295_12.setRuntimeParent(_jettag_c_iterate_294_12);
                                        _jettag_c_setVariable_295_12.setTagInfo(_td_c_setVariable_295_12);
                                        _jettag_c_setVariable_295_12.doStart(context, out);
                                        _jettag_c_setVariable_295_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_297_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_297_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_297_13.setRuntimeParent(_jettag_c_iterate_294_12);
                                        _jettag_c_if_297_13.setTagInfo(_td_c_if_297_13);
                                        _jettag_c_if_297_13.doStart(context, out);
                                        while (_jettag_c_if_297_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_299_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_299_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_299_9.setRuntimeParent(_jettag_c_if_297_13);
                                            _jettag_c_if_299_9.setTagInfo(_td_c_if_299_9);
                                            _jettag_c_if_299_9.doStart(context, out);
                                            while (_jettag_c_if_299_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_300_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_300_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_300_11.setRuntimeParent(_jettag_c_if_299_9);
                                                _jettag_c_if_300_11.setTagInfo(_td_c_if_300_11);
                                                _jettag_c_if_300_11.doStart(context, out);
                                                while (_jettag_c_if_300_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_302_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_302_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_302_14.setRuntimeParent(_jettag_c_if_300_11);
                                                    _jettag_c_if_302_14.setTagInfo(_td_c_if_302_14);
                                                    _jettag_c_if_302_14.doStart(context, out);
                                                    while (_jettag_c_if_302_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_304_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_304_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_304_15.setRuntimeParent(_jettag_c_if_302_14);
                                                        _jettag_c_iterate_304_15.setTagInfo(_td_c_iterate_304_15);
                                                        _jettag_c_iterate_304_15.doStart(context, out);
                                                        while (_jettag_c_iterate_304_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_305_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_305_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_305_16.setRuntimeParent(_jettag_c_iterate_304_15);
                                                            _jettag_c_if_305_16.setTagInfo(_td_c_if_305_16);
                                                            _jettag_c_if_305_16.doStart(context, out);
                                                            while (_jettag_c_if_305_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_306_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_306_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_306_1.setRuntimeParent(_jettag_c_if_305_16);
                                                                _jettag_f_message_306_1.setTagInfo(_td_f_message_306_1);
                                                                _jettag_f_message_306_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_306_1_saved_out = out;
                                                                while (_jettag_f_message_306_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_306_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_306_1_saved_out;
                                                                _jettag_f_message_306_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t@WebRemote");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\tpublic  List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 309, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("> get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 309, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long entityID) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\tList<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 310, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("> res = new ArrayList<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 310, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(">();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\tfor (");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 311, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" obj : em.find(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 311, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class, entityID).get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 311, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s()) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\tres.add((");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 312, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(") getBeanManager().clone(obj));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\treturn res;\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                // check to see if the parent side is aggregation or none
                                                                RuntimeTagElement _jettag_c_if_317_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_317_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_317_17.setRuntimeParent(_jettag_c_if_305_16);
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
                                                                    out.write("\t@Override");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t@WebRemote\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\tpublic MultiSelectObjy get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 321, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sMultiSelect(Long entityID, String[] columns){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 322, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(" entity = em.find(");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 322, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(".class, entityID);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\tSet<Long> ids = new HashSet<Long>();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\tMultiSelectObjy obj = new MultiSelectObjy();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\tobj.setAvailable(GWTServletUtils.getListBoxValues(");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 325, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(".class,");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\tcolumns, em));");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\tfor (");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 327, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(" child : entity.get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 327, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s()) {");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\tids.add(child.getId());");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t}");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\tobj.setSelected(ids);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\treturn obj;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t}");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_317_17.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_317_17.doEnd();
                                                                _jettag_c_if_305_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_305_16.doEnd();
                                                            _jettag_c_iterate_304_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_304_15.doEnd();
                                                        _jettag_c_if_302_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_302_14.doEnd();
                                                    _jettag_c_if_300_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_300_11.doEnd();
                                                _jettag_c_if_299_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_299_9.doEnd();
                                            _jettag_c_if_297_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_297_13.doEnd();
                                        _jettag_c_iterate_294_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_294_12.doEnd();
                                    _jettag_c_if_292_6.handleBodyContent(out);
                                }
                                _jettag_c_if_292_6.doEnd();
                                _jettag_c_iterate_289_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_289_3.doEnd();
                            _jettag_c_iterate_288_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_288_2.doEnd();
                        _jettag_c_iterate_287_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_287_6.doEnd();
                    _jettag_c_if_285_1.handleBodyContent(out);
                }
                _jettag_c_if_285_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_346_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_346_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_346_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_346_1.setTagInfo(_td_c_setVariable_346_1);
                _jettag_c_setVariable_346_1.doStart(context, out);
                _jettag_c_setVariable_346_1.doEnd();
                //process level 1 generizations 
                RuntimeTagElement _jettag_c_if_348_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_348_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_348_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_348_1.setTagInfo(_td_c_if_348_1);
                _jettag_c_if_348_1.doStart(context, out);
                while (_jettag_c_if_348_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_349_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_349_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_349_6.setRuntimeParent(_jettag_c_if_348_1);
                    _jettag_c_setVariable_349_6.setTagInfo(_td_c_setVariable_349_6);
                    _jettag_c_setVariable_349_6.doStart(context, out);
                    _jettag_c_setVariable_349_6.doEnd();
                    RuntimeTagElement _jettag_c_iterate_350_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_350_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_350_6.setRuntimeParent(_jettag_c_if_348_1);
                    _jettag_c_iterate_350_6.setTagInfo(_td_c_iterate_350_6);
                    _jettag_c_iterate_350_6.doStart(context, out);
                    while (_jettag_c_iterate_350_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_351_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_351_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_351_2.setRuntimeParent(_jettag_c_iterate_350_6);
                        _jettag_c_iterate_351_2.setTagInfo(_td_c_iterate_351_2);
                        _jettag_c_iterate_351_2.doStart(context, out);
                        while (_jettag_c_iterate_351_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_352_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_352_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_352_3.setRuntimeParent(_jettag_c_iterate_351_2);
                            _jettag_c_iterate_352_3.setTagInfo(_td_c_iterate_352_3);
                            _jettag_c_iterate_352_3.doStart(context, out);
                            while (_jettag_c_iterate_352_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_353_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_353_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_353_4.setRuntimeParent(_jettag_c_iterate_352_3);
                                _jettag_c_setVariable_353_4.setTagInfo(_td_c_setVariable_353_4);
                                _jettag_c_setVariable_353_4.doStart(context, out);
                                _jettag_c_setVariable_353_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_355_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_355_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_355_6.setRuntimeParent(_jettag_c_iterate_352_3);
                                _jettag_c_if_355_6.setTagInfo(_td_c_if_355_6);
                                _jettag_c_if_355_6.doStart(context, out);
                                while (_jettag_c_if_355_6.okToProcessBody()) {
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_357_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_357_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_357_12.setRuntimeParent(_jettag_c_if_355_6);
                                    _jettag_c_iterate_357_12.setTagInfo(_td_c_iterate_357_12);
                                    _jettag_c_iterate_357_12.doStart(context, out);
                                    while (_jettag_c_iterate_357_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_358_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_358_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_358_12.setRuntimeParent(_jettag_c_iterate_357_12);
                                        _jettag_c_setVariable_358_12.setTagInfo(_td_c_setVariable_358_12);
                                        _jettag_c_setVariable_358_12.doStart(context, out);
                                        _jettag_c_setVariable_358_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_360_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_360_13); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_360_13.setRuntimeParent(_jettag_c_iterate_357_12);
                                        _jettag_c_if_360_13.setTagInfo(_td_c_if_360_13);
                                        _jettag_c_if_360_13.doStart(context, out);
                                        while (_jettag_c_if_360_13.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_362_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_362_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_362_9.setRuntimeParent(_jettag_c_if_360_13);
                                            _jettag_c_if_362_9.setTagInfo(_td_c_if_362_9);
                                            _jettag_c_if_362_9.doStart(context, out);
                                            while (_jettag_c_if_362_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_363_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_363_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_363_11.setRuntimeParent(_jettag_c_if_362_9);
                                                _jettag_c_if_363_11.setTagInfo(_td_c_if_363_11);
                                                _jettag_c_if_363_11.doStart(context, out);
                                                while (_jettag_c_if_363_11.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_365_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_365_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_365_14.setRuntimeParent(_jettag_c_if_363_11);
                                                    _jettag_c_if_365_14.setTagInfo(_td_c_if_365_14);
                                                    _jettag_c_if_365_14.doStart(context, out);
                                                    while (_jettag_c_if_365_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_367_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_367_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_367_15.setRuntimeParent(_jettag_c_if_365_14);
                                                        _jettag_c_iterate_367_15.setTagInfo(_td_c_iterate_367_15);
                                                        _jettag_c_iterate_367_15.doStart(context, out);
                                                        while (_jettag_c_iterate_367_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_368_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_368_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_368_16.setRuntimeParent(_jettag_c_iterate_367_15);
                                                            _jettag_c_if_368_16.setTagInfo(_td_c_if_368_16);
                                                            _jettag_c_if_368_16.doStart(context, out);
                                                            while (_jettag_c_if_368_16.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_369_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_369_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_369_1.setRuntimeParent(_jettag_c_if_368_16);
                                                                _jettag_f_message_369_1.setTagInfo(_td_f_message_369_1);
                                                                _jettag_f_message_369_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_369_1_saved_out = out;
                                                                while (_jettag_f_message_369_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_369_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_369_1_saved_out;
                                                                _jettag_f_message_369_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t@WebRemote");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\tpublic  List<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 372, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("> get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 372, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long entityID) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\tList<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 373, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("> res = new ArrayList<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 373, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(">();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\tfor (");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 374, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" obj : em.find(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 374, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class, entityID).get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 374, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s()) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\tres.add((");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 375, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(") getBeanManager().clone(obj));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\treturn res;\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                // check to see if the parent side is aggregation or none
                                                                RuntimeTagElement _jettag_c_if_380_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_380_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_380_17.setRuntimeParent(_jettag_c_if_368_16);
                                                                _jettag_c_if_380_17.setTagInfo(_td_c_if_380_17);
                                                                _jettag_c_if_380_17.doStart(context, out);
                                                                while (_jettag_c_if_380_17.okToProcessBody()) {
                                                                    RuntimeTagElement _jettag_f_message_381_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_381_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_381_1.setRuntimeParent(_jettag_c_if_380_17);
                                                                    _jettag_f_message_381_1.setTagInfo(_td_f_message_381_1);
                                                                    _jettag_f_message_381_1.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_381_1_saved_out = out;
                                                                    while (_jettag_f_message_381_1.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_381_1.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_381_1_saved_out;
                                                                    _jettag_f_message_381_1.doEnd();
                                                                    out.write("\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t@Override");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t@WebRemote\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\tpublic MultiSelectObjy get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 384, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("sMultiSelect(Long entityID, String[] columns){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 385, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(" entity = em.find(");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 385, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(".class, entityID);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\tSet<Long> ids = new HashSet<Long>();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\tMultiSelectObjy obj = new MultiSelectObjy();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\tobj.setAvailable(GWTServletUtils.getListBoxValues(");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 388, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(".class,");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\tcolumns, em));");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\tfor (");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 390, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(" child : entity.get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 390, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s()) {");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\tids.add(child.getId());");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t}");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\tobj.setSelected(ids);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\treturn obj;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t}");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_380_17.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_380_17.doEnd();
                                                                out.write("\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_368_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_368_16.doEnd();
                                                            _jettag_c_iterate_367_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_367_15.doEnd();
                                                        _jettag_c_if_365_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_365_14.doEnd();
                                                    _jettag_c_if_363_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_363_11.doEnd();
                                                _jettag_c_if_362_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_362_9.doEnd();
                                            _jettag_c_if_360_13.handleBodyContent(out);
                                        }
                                        _jettag_c_if_360_13.doEnd();
                                        _jettag_c_iterate_357_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_357_12.doEnd();
                                    _jettag_c_if_355_6.handleBodyContent(out);
                                }
                                _jettag_c_if_355_6.doEnd();
                                _jettag_c_iterate_352_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_352_3.doEnd();
                            _jettag_c_iterate_351_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_351_2.doEnd();
                        _jettag_c_iterate_350_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_350_6.doEnd();
                    _jettag_c_if_348_1.handleBodyContent(out);
                }
                _jettag_c_if_348_1.doEnd();
                RuntimeTagElement _jettag_c_setVariable_410_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_410_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_410_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_410_1.setTagInfo(_td_c_setVariable_410_1);
                _jettag_c_setVariable_410_1.doStart(context, out);
                _jettag_c_setVariable_410_1.doEnd();
                //level 0 
                RuntimeTagElement _jettag_c_iterate_412_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_412_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_412_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_412_1.setTagInfo(_td_c_iterate_412_1);
                _jettag_c_iterate_412_1.doStart(context, out);
                while (_jettag_c_iterate_412_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_413_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_413_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_413_2.setRuntimeParent(_jettag_c_iterate_412_1);
                    _jettag_c_iterate_413_2.setTagInfo(_td_c_iterate_413_2);
                    _jettag_c_iterate_413_2.doStart(context, out);
                    while (_jettag_c_iterate_413_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_414_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_414_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_414_3.setRuntimeParent(_jettag_c_iterate_413_2);
                        _jettag_c_iterate_414_3.setTagInfo(_td_c_iterate_414_3);
                        _jettag_c_iterate_414_3.doStart(context, out);
                        while (_jettag_c_iterate_414_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_415_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_415_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_415_4.setRuntimeParent(_jettag_c_iterate_414_3);
                            _jettag_c_setVariable_415_4.setTagInfo(_td_c_setVariable_415_4);
                            _jettag_c_setVariable_415_4.doStart(context, out);
                            _jettag_c_setVariable_415_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_417_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_417_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_417_6.setRuntimeParent(_jettag_c_iterate_414_3);
                            _jettag_c_if_417_6.setTagInfo(_td_c_if_417_6);
                            _jettag_c_if_417_6.doStart(context, out);
                            while (_jettag_c_if_417_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_419_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_419_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_419_12.setRuntimeParent(_jettag_c_if_417_6);
                                _jettag_c_iterate_419_12.setTagInfo(_td_c_iterate_419_12);
                                _jettag_c_iterate_419_12.doStart(context, out);
                                while (_jettag_c_iterate_419_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_420_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_420_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_420_12.setRuntimeParent(_jettag_c_iterate_419_12);
                                    _jettag_c_setVariable_420_12.setTagInfo(_td_c_setVariable_420_12);
                                    _jettag_c_setVariable_420_12.doStart(context, out);
                                    _jettag_c_setVariable_420_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_422_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_422_13); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_422_13.setRuntimeParent(_jettag_c_iterate_419_12);
                                    _jettag_c_if_422_13.setTagInfo(_td_c_if_422_13);
                                    _jettag_c_if_422_13.doStart(context, out);
                                    while (_jettag_c_if_422_13.okToProcessBody()) {
                                        // process many on target
                                        RuntimeTagElement _jettag_c_if_424_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_424_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_424_9.setRuntimeParent(_jettag_c_if_422_13);
                                        _jettag_c_if_424_9.setTagInfo(_td_c_if_424_9);
                                        _jettag_c_if_424_9.doStart(context, out);
                                        while (_jettag_c_if_424_9.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_425_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_425_11); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_425_11.setRuntimeParent(_jettag_c_if_424_9);
                                            _jettag_c_if_425_11.setTagInfo(_td_c_if_425_11);
                                            _jettag_c_if_425_11.doStart(context, out);
                                            while (_jettag_c_if_425_11.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_427_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_427_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_427_14.setRuntimeParent(_jettag_c_if_425_11);
                                                _jettag_c_if_427_14.setTagInfo(_td_c_if_427_14);
                                                _jettag_c_if_427_14.doStart(context, out);
                                                while (_jettag_c_if_427_14.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_429_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_429_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_429_15.setRuntimeParent(_jettag_c_if_427_14);
                                                    _jettag_c_iterate_429_15.setTagInfo(_td_c_iterate_429_15);
                                                    _jettag_c_iterate_429_15.doStart(context, out);
                                                    while (_jettag_c_iterate_429_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_430_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_430_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_430_16.setRuntimeParent(_jettag_c_iterate_429_15);
                                                        _jettag_c_if_430_16.setTagInfo(_td_c_if_430_16);
                                                        _jettag_c_if_430_16.doStart(context, out);
                                                        while (_jettag_c_if_430_16.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_f_message_431_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_431_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_431_1.setRuntimeParent(_jettag_c_if_430_16);
                                                            _jettag_f_message_431_1.setTagInfo(_td_f_message_431_1);
                                                            _jettag_f_message_431_1.doStart(context, out);
                                                            JET2Writer _jettag_f_message_431_1_saved_out = out;
                                                            while (_jettag_f_message_431_1.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_431_1.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_431_1_saved_out;
                                                            _jettag_f_message_431_1.doEnd();
                                                            out.write("  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t@Override");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t@WebRemote");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\tpublic  List<");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 434, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("> get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 434, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s(Long entityID) {");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\tList<");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 435, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("> res = new ArrayList<");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 435, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(">();");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\tfor (");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 436, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(" obj : em.find(");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class/@name}", 436, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".class, entityID).get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 436, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s()) {");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\tres.add((");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 437, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(") getBeanManager().clone(obj));");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t}");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\treturn res;\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t}");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            // check to see if the parent side is aggregation or none
                                                            RuntimeTagElement _jettag_c_if_442_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_442_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_442_17.setRuntimeParent(_jettag_c_if_430_16);
                                                            _jettag_c_if_442_17.setTagInfo(_td_c_if_442_17);
                                                            _jettag_c_if_442_17.doStart(context, out);
                                                            while (_jettag_c_if_442_17.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_f_message_443_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_443_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_443_1.setRuntimeParent(_jettag_c_if_442_17);
                                                                _jettag_f_message_443_1.setTagInfo(_td_f_message_443_1);
                                                                _jettag_f_message_443_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_443_1_saved_out = out;
                                                                while (_jettag_f_message_443_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_443_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_443_1_saved_out;
                                                                _jettag_f_message_443_1.doEnd();
                                                                out.write("\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t@WebRemote\t  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\tpublic MultiSelectObjy get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 446, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sMultiSelect(Long entityID, String[] columns){");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 447, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" entity = em.find(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 447, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class, entityID);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\tSet<Long> ids = new HashSet<Long>();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\tMultiSelectObjy obj = new MultiSelectObjy();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\tobj.setAvailable(GWTServletUtils.getListBoxValues(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 450, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class,");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\tcolumns, em));");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\tfor (");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 452, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" child : entity.get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 452, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s()) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\tids.add(child.getId());");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\tobj.setSelected(ids);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\treturn obj;");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_442_17.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_442_17.doEnd();
                                                            _jettag_c_if_430_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_430_16.doEnd();
                                                        _jettag_c_iterate_429_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_429_15.doEnd();
                                                    _jettag_c_if_427_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_427_14.doEnd();
                                                _jettag_c_if_425_11.handleBodyContent(out);
                                            }
                                            _jettag_c_if_425_11.doEnd();
                                            _jettag_c_if_424_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_424_9.doEnd();
                                        _jettag_c_if_422_13.handleBodyContent(out);
                                    }
                                    _jettag_c_if_422_13.doEnd();
                                    _jettag_c_iterate_419_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_419_12.doEnd();
                                _jettag_c_if_417_6.handleBodyContent(out);
                            }
                            _jettag_c_if_417_6.doEnd();
                            _jettag_c_iterate_414_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_414_3.doEnd();
                        _jettag_c_iterate_413_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_413_2.doEnd();
                    _jettag_c_iterate_412_1.handleBodyContent(out);
                }
                _jettag_c_iterate_412_1.doEnd();
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process all addAll relations
                RuntimeTagElement _jettag_c_iterate_473_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_473_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_473_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_473_1.setTagInfo(_td_c_iterate_473_1);
                _jettag_c_iterate_473_1.doStart(context, out);
                while (_jettag_c_iterate_473_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_474_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_474_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_474_2.setRuntimeParent(_jettag_c_iterate_473_1);
                    _jettag_c_iterate_474_2.setTagInfo(_td_c_iterate_474_2);
                    _jettag_c_iterate_474_2.doStart(context, out);
                    while (_jettag_c_iterate_474_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_475_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_475_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_475_3.setRuntimeParent(_jettag_c_iterate_474_2);
                        _jettag_c_iterate_475_3.setTagInfo(_td_c_iterate_475_3);
                        _jettag_c_iterate_475_3.doStart(context, out);
                        while (_jettag_c_iterate_475_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_476_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_476_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_476_4.setRuntimeParent(_jettag_c_iterate_475_3);
                            _jettag_c_setVariable_476_4.setTagInfo(_td_c_setVariable_476_4);
                            _jettag_c_setVariable_476_4.doStart(context, out);
                            _jettag_c_setVariable_476_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_478_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_478_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_478_6.setRuntimeParent(_jettag_c_iterate_475_3);
                            _jettag_c_if_478_6.setTagInfo(_td_c_if_478_6);
                            _jettag_c_if_478_6.doStart(context, out);
                            while (_jettag_c_if_478_6.okToProcessBody()) {
                                // process only classes with many on source side
                                RuntimeTagElement _jettag_c_if_480_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_480_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_480_6.setRuntimeParent(_jettag_c_if_478_6);
                                _jettag_c_if_480_6.setTagInfo(_td_c_if_480_6);
                                _jettag_c_if_480_6.doStart(context, out);
                                while (_jettag_c_if_480_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_481_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_481_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_481_8.setRuntimeParent(_jettag_c_if_480_6);
                                    _jettag_c_if_481_8.setTagInfo(_td_c_if_481_8);
                                    _jettag_c_if_481_8.doStart(context, out);
                                    while (_jettag_c_if_481_8.okToProcessBody()) {
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_483_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_483_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_483_12.setRuntimeParent(_jettag_c_if_481_8);
                                        _jettag_c_iterate_483_12.setTagInfo(_td_c_iterate_483_12);
                                        _jettag_c_iterate_483_12.doStart(context, out);
                                        while (_jettag_c_iterate_483_12.okToProcessBody()) {
                                            // process only non composites 
                                            RuntimeTagElement _jettag_c_if_485_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_485_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_485_12.setRuntimeParent(_jettag_c_iterate_483_12);
                                            _jettag_c_if_485_12.setTagInfo(_td_c_if_485_12);
                                            _jettag_c_if_485_12.doStart(context, out);
                                            while (_jettag_c_if_485_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_486_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_486_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_486_12.setRuntimeParent(_jettag_c_if_485_12);
                                                _jettag_c_setVariable_486_12.setTagInfo(_td_c_setVariable_486_12);
                                                _jettag_c_setVariable_486_12.doStart(context, out);
                                                _jettag_c_setVariable_486_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_488_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_488_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_488_14.setRuntimeParent(_jettag_c_if_485_12);
                                                _jettag_c_if_488_14.setTagInfo(_td_c_if_488_14);
                                                _jettag_c_if_488_14.doStart(context, out);
                                                while (_jettag_c_if_488_14.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_490_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_490_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_490_14.setRuntimeParent(_jettag_c_if_488_14);
                                                    _jettag_c_if_490_14.setTagInfo(_td_c_if_490_14);
                                                    _jettag_c_if_490_14.doStart(context, out);
                                                    while (_jettag_c_if_490_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_492_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_492_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_492_15.setRuntimeParent(_jettag_c_if_490_14);
                                                        _jettag_c_iterate_492_15.setTagInfo(_td_c_iterate_492_15);
                                                        _jettag_c_iterate_492_15.doStart(context, out);
                                                        while (_jettag_c_iterate_492_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_493_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_493_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_493_16.setRuntimeParent(_jettag_c_iterate_492_15);
                                                            _jettag_c_if_493_16.setTagInfo(_td_c_if_493_16);
                                                            _jettag_c_if_493_16.doStart(context, out);
                                                            while (_jettag_c_if_493_16.okToProcessBody()) {
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t//TODO fix this remove generics");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                RuntimeTagElement _jettag_f_message_495_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_495_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_495_1.setRuntimeParent(_jettag_c_if_493_16);
                                                                _jettag_f_message_495_1.setTagInfo(_td_f_message_495_1);
                                                                _jettag_f_message_495_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_495_1_saved_out = out;
                                                                while (_jettag_f_message_495_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_495_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_495_1_saved_out;
                                                                _jettag_f_message_495_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t@WebRemote");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\tpublic void add");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 498, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 498, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 498, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Id,List<Long> ids) {\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 499, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 499, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" = em.find(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 499, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class,");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 499, 90)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Id);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tfor (Long id : ids) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 501, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" child = (");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 501, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(") em.find(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 501, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class, id);");  //$NON-NLS-1$        
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
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 506, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".add");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 506, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("(child);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t} ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_493_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_493_16.doEnd();
                                                            _jettag_c_iterate_492_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_492_15.doEnd();
                                                        _jettag_c_if_490_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_490_14.doEnd();
                                                    _jettag_c_if_488_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_488_14.doEnd();
                                                _jettag_c_if_485_12.handleBodyContent(out);
                                            }
                                            _jettag_c_if_485_12.doEnd();
                                            _jettag_c_iterate_483_12.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_483_12.doEnd();
                                        _jettag_c_if_481_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_481_8.doEnd();
                                    _jettag_c_if_480_6.handleBodyContent(out);
                                }
                                _jettag_c_if_480_6.doEnd();
                                _jettag_c_if_478_6.handleBodyContent(out);
                            }
                            _jettag_c_if_478_6.doEnd();
                            _jettag_c_iterate_475_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_475_3.doEnd();
                        _jettag_c_iterate_474_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_474_2.doEnd();
                    _jettag_c_iterate_473_1.handleBodyContent(out);
                }
                _jettag_c_iterate_473_1.doEnd();
                out.write(NL);         
                // process all removeAll relations
                RuntimeTagElement _jettag_c_iterate_523_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_523_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_523_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_523_1.setTagInfo(_td_c_iterate_523_1);
                _jettag_c_iterate_523_1.doStart(context, out);
                while (_jettag_c_iterate_523_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_524_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_524_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_524_2.setRuntimeParent(_jettag_c_iterate_523_1);
                    _jettag_c_iterate_524_2.setTagInfo(_td_c_iterate_524_2);
                    _jettag_c_iterate_524_2.doStart(context, out);
                    while (_jettag_c_iterate_524_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_525_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_525_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_525_3.setRuntimeParent(_jettag_c_iterate_524_2);
                        _jettag_c_iterate_525_3.setTagInfo(_td_c_iterate_525_3);
                        _jettag_c_iterate_525_3.doStart(context, out);
                        while (_jettag_c_iterate_525_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_526_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_526_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_526_4.setRuntimeParent(_jettag_c_iterate_525_3);
                            _jettag_c_setVariable_526_4.setTagInfo(_td_c_setVariable_526_4);
                            _jettag_c_setVariable_526_4.doStart(context, out);
                            _jettag_c_setVariable_526_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_528_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_528_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_528_6.setRuntimeParent(_jettag_c_iterate_525_3);
                            _jettag_c_if_528_6.setTagInfo(_td_c_if_528_6);
                            _jettag_c_if_528_6.doStart(context, out);
                            while (_jettag_c_if_528_6.okToProcessBody()) {
                                // process only classes with many on source side
                                RuntimeTagElement _jettag_c_if_530_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_530_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_530_6.setRuntimeParent(_jettag_c_if_528_6);
                                _jettag_c_if_530_6.setTagInfo(_td_c_if_530_6);
                                _jettag_c_if_530_6.doStart(context, out);
                                while (_jettag_c_if_530_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_531_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_531_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_531_8.setRuntimeParent(_jettag_c_if_530_6);
                                    _jettag_c_if_531_8.setTagInfo(_td_c_if_531_8);
                                    _jettag_c_if_531_8.doStart(context, out);
                                    while (_jettag_c_if_531_8.okToProcessBody()) {
                                        // iterate over the iterations ends  
                                        RuntimeTagElement _jettag_c_iterate_533_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_533_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_533_12.setRuntimeParent(_jettag_c_if_531_8);
                                        _jettag_c_iterate_533_12.setTagInfo(_td_c_iterate_533_12);
                                        _jettag_c_iterate_533_12.doStart(context, out);
                                        while (_jettag_c_iterate_533_12.okToProcessBody()) {
                                            // process only non composites 
                                            RuntimeTagElement _jettag_c_if_535_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_535_12); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_535_12.setRuntimeParent(_jettag_c_iterate_533_12);
                                            _jettag_c_if_535_12.setTagInfo(_td_c_if_535_12);
                                            _jettag_c_if_535_12.doStart(context, out);
                                            while (_jettag_c_if_535_12.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_setVariable_536_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_536_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_setVariable_536_12.setRuntimeParent(_jettag_c_if_535_12);
                                                _jettag_c_setVariable_536_12.setTagInfo(_td_c_setVariable_536_12);
                                                _jettag_c_setVariable_536_12.doStart(context, out);
                                                _jettag_c_setVariable_536_12.doEnd();
                                                // get the end secondary end with other class  
                                                RuntimeTagElement _jettag_c_if_538_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_538_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_538_14.setRuntimeParent(_jettag_c_if_535_12);
                                                _jettag_c_if_538_14.setTagInfo(_td_c_if_538_14);
                                                _jettag_c_if_538_14.doStart(context, out);
                                                while (_jettag_c_if_538_14.okToProcessBody()) {
                                                    // check to see if this is a navigable relation
                                                    RuntimeTagElement _jettag_c_if_540_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_540_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_540_14.setRuntimeParent(_jettag_c_if_538_14);
                                                    _jettag_c_if_540_14.setTagInfo(_td_c_if_540_14);
                                                    _jettag_c_if_540_14.doStart(context, out);
                                                    while (_jettag_c_if_540_14.okToProcessBody()) {
                                                        // iterate throught all the classes to get the other class on the association
                                                        RuntimeTagElement _jettag_c_iterate_542_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_542_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_iterate_542_15.setRuntimeParent(_jettag_c_if_540_14);
                                                        _jettag_c_iterate_542_15.setTagInfo(_td_c_iterate_542_15);
                                                        _jettag_c_iterate_542_15.doStart(context, out);
                                                        while (_jettag_c_iterate_542_15.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_543_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_543_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_543_16.setRuntimeParent(_jettag_c_iterate_542_15);
                                                            _jettag_c_if_543_16.setTagInfo(_td_c_if_543_16);
                                                            _jettag_c_if_543_16.doStart(context, out);
                                                            while (_jettag_c_if_543_16.okToProcessBody()) {
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t//TODO fix this remove generics");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                RuntimeTagElement _jettag_f_message_545_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_545_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_f_message_545_1.setRuntimeParent(_jettag_c_if_543_16);
                                                                _jettag_f_message_545_1.setTagInfo(_td_f_message_545_1);
                                                                _jettag_f_message_545_1.doStart(context, out);
                                                                JET2Writer _jettag_f_message_545_1_saved_out = out;
                                                                while (_jettag_f_message_545_1.okToProcessBody()) {
                                                                    out = out.newNestedContentWriter();
                                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                                    _jettag_f_message_545_1.handleBodyContent(out);
                                                                }
                                                                out = _jettag_f_message_545_1_saved_out;
                                                                _jettag_f_message_545_1.doEnd();
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("  \t\t\t\t\t  \t\t \t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t@WebRemote");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\tpublic void remove");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 548, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 548, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s(Long ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 548, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Id,List<Long> ids) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 549, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 549, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" = em.find(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 549, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class,");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 549, 90)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Id);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tfor (Long id : ids) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 551, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(" child = (");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 551, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(") em.find(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 551, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".class, id);");  //$NON-NLS-1$        
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
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 556, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".get");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 556, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s().remove(child);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t} ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_543_16.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_543_16.doEnd();
                                                            _jettag_c_iterate_542_15.handleBodyContent(out);
                                                        }
                                                        _jettag_c_iterate_542_15.doEnd();
                                                        _jettag_c_if_540_14.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_540_14.doEnd();
                                                    _jettag_c_if_538_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_538_14.doEnd();
                                                _jettag_c_if_535_12.handleBodyContent(out);
                                            }
                                            _jettag_c_if_535_12.doEnd();
                                            _jettag_c_iterate_533_12.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_533_12.doEnd();
                                        _jettag_c_if_531_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_531_8.doEnd();
                                    _jettag_c_if_530_6.handleBodyContent(out);
                                }
                                _jettag_c_if_530_6.doEnd();
                                _jettag_c_if_528_6.handleBodyContent(out);
                            }
                            _jettag_c_if_528_6.doEnd();
                            _jettag_c_iterate_525_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_525_3.doEnd();
                        _jettag_c_iterate_524_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_524_2.doEnd();
                    _jettag_c_iterate_523_1.handleBodyContent(out);
                }
                _jettag_c_iterate_523_1.doEnd();
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_572_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_572_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_572_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_572_1.setTagInfo(_td_f_message_572_1);
                _jettag_f_message_572_1.doStart(context, out);
                JET2Writer _jettag_f_message_572_1_saved_out = out;
                while (_jettag_f_message_572_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_572_1.handleBodyContent(out);
                }
                out = _jettag_f_message_572_1_saved_out;
                _jettag_f_message_572_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@WebRemote");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 575, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> getEntities(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 575, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tList<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 576, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> entities = new ArrayList<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 576, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery getEntities = em.createQuery(GWTServletUtils");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.getSearchQueryString(entity));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tfor (Object obj : getEntities.getResultList()) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tentities.add((");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 580, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(") getBeanManager().clone(obj));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn entities;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_584_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_584_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_584_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_584_1.setTagInfo(_td_f_message_584_1);
                _jettag_f_message_584_1.doStart(context, out);
                JET2Writer _jettag_f_message_584_1_saved_out = out;
                while (_jettag_f_message_584_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_584_1.handleBodyContent(out);
                }
                out = _jettag_f_message_584_1_saved_out;
                _jettag_f_message_584_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@WebRemote");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic  Map<Long, String> getListBoxValues(String[] columns) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tString query = GWTServletUtils.getListBoxResultsQueryString(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 588, 63)); //$NON-NLS-1$ //$NON-NLS-2$
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
                RuntimeTagElement _jettag_f_message_598_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_598_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_598_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_598_1.setTagInfo(_td_f_message_598_1);
                _jettag_f_message_598_1.doStart(context, out);
                JET2Writer _jettag_f_message_598_1_saved_out = out;
                while (_jettag_f_message_598_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_598_1.handleBodyContent(out);
                }
                out = _jettag_f_message_598_1_saved_out;
                _jettag_f_message_598_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@WebRemote");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic List<String> getSuggestionsForName(String name, ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 601, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery query = em.createQuery(GWTServletUtils.getSuggestionsQueryForName(name, entity));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn query.getResultList();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process all merge relations
                RuntimeTagElement _jettag_c_iterate_608_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_608_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_608_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_608_1.setTagInfo(_td_c_iterate_608_1);
                _jettag_c_iterate_608_1.doStart(context, out);
                while (_jettag_c_iterate_608_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_609_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_609_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_609_2.setRuntimeParent(_jettag_c_iterate_608_1);
                    _jettag_c_iterate_609_2.setTagInfo(_td_c_iterate_609_2);
                    _jettag_c_iterate_609_2.doStart(context, out);
                    while (_jettag_c_iterate_609_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_610_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_610_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_610_3.setRuntimeParent(_jettag_c_iterate_609_2);
                        _jettag_c_iterate_610_3.setTagInfo(_td_c_iterate_610_3);
                        _jettag_c_iterate_610_3.doStart(context, out);
                        while (_jettag_c_iterate_610_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_611_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_611_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_611_4.setRuntimeParent(_jettag_c_iterate_610_3);
                            _jettag_c_setVariable_611_4.setTagInfo(_td_c_setVariable_611_4);
                            _jettag_c_setVariable_611_4.doStart(context, out);
                            _jettag_c_setVariable_611_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_613_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_613_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_613_6.setRuntimeParent(_jettag_c_iterate_610_3);
                            _jettag_c_if_613_6.setTagInfo(_td_c_if_613_6);
                            _jettag_c_if_613_6.doStart(context, out);
                            while (_jettag_c_if_613_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_615_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_615_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_615_12.setRuntimeParent(_jettag_c_if_613_6);
                                _jettag_c_iterate_615_12.setTagInfo(_td_c_iterate_615_12);
                                _jettag_c_iterate_615_12.doStart(context, out);
                                while (_jettag_c_iterate_615_12.okToProcessBody()) {
                                    // process only  composites on target
                                    RuntimeTagElement _jettag_c_if_617_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_617_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_617_12.setRuntimeParent(_jettag_c_iterate_615_12);
                                    _jettag_c_if_617_12.setTagInfo(_td_c_if_617_12);
                                    _jettag_c_if_617_12.doStart(context, out);
                                    while (_jettag_c_if_617_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_618_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_618_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_618_12.setRuntimeParent(_jettag_c_if_617_12);
                                        _jettag_c_setVariable_618_12.setTagInfo(_td_c_setVariable_618_12);
                                        _jettag_c_setVariable_618_12.doStart(context, out);
                                        _jettag_c_setVariable_618_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_620_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_620_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_620_14.setRuntimeParent(_jettag_c_if_617_12);
                                        _jettag_c_if_620_14.setTagInfo(_td_c_if_620_14);
                                        _jettag_c_if_620_14.doStart(context, out);
                                        while (_jettag_c_if_620_14.okToProcessBody()) {
                                            // iterate throught all the classes to get the other class on the association
                                            RuntimeTagElement _jettag_c_iterate_622_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_622_15); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_622_15.setRuntimeParent(_jettag_c_if_620_14);
                                            _jettag_c_iterate_622_15.setTagInfo(_td_c_iterate_622_15);
                                            _jettag_c_iterate_622_15.doStart(context, out);
                                            while (_jettag_c_iterate_622_15.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_623_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_623_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_623_16.setRuntimeParent(_jettag_c_iterate_622_15);
                                                _jettag_c_if_623_16.setTagInfo(_td_c_if_623_16);
                                                _jettag_c_if_623_16.doStart(context, out);
                                                while (_jettag_c_if_623_16.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_f_message_624_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_624_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_f_message_624_1.setRuntimeParent(_jettag_c_if_623_16);
                                                    _jettag_f_message_624_1.setTagInfo(_td_f_message_624_1);
                                                    _jettag_f_message_624_1.doStart(context, out);
                                                    JET2Writer _jettag_f_message_624_1_saved_out = out;
                                                    while (_jettag_f_message_624_1.okToProcessBody()) {
                                                        out = out.newNestedContentWriter();
                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                        _jettag_f_message_624_1.handleBodyContent(out);
                                                    }
                                                    out = _jettag_f_message_624_1_saved_out;
                                                    _jettag_f_message_624_1.doEnd();
                                                    out.write(" \t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("\t@Override");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("\t@WebRemote");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("\tpublic  void merge(");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 627, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(" entity, ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 627, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(" child) {");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("\t\tentity.set");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 628, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("(em.find(");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 628, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".class, child.getId()));");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("\t\tem.merge(entity);");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("\t}");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_623_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_623_16.doEnd();
                                                _jettag_c_iterate_622_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_622_15.doEnd();
                                            _jettag_c_if_620_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_620_14.doEnd();
                                        _jettag_c_if_617_12.handleBodyContent(out);
                                    }
                                    _jettag_c_if_617_12.doEnd();
                                    _jettag_c_iterate_615_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_615_12.doEnd();
                                _jettag_c_if_613_6.handleBodyContent(out);
                            }
                            _jettag_c_if_613_6.doEnd();
                            _jettag_c_iterate_610_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_610_3.doEnd();
                        _jettag_c_iterate_609_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_609_2.doEnd();
                    _jettag_c_iterate_608_1.handleBodyContent(out);
                }
                _jettag_c_iterate_608_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_c_if_641_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_641_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_641_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_641_1.setTagInfo(_td_c_if_641_1);
                _jettag_c_if_641_1.doStart(context, out);
                while (_jettag_c_if_641_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_f_message_642_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_642_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_642_1.setRuntimeParent(_jettag_c_if_641_1);
                    _jettag_f_message_642_1.setTagInfo(_td_f_message_642_1);
                    _jettag_f_message_642_1.doStart(context, out);
                    JET2Writer _jettag_f_message_642_1_saved_out = out;
                    while (_jettag_f_message_642_1.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_642_1.handleBodyContent(out);
                    }
                    out = _jettag_f_message_642_1_saved_out;
                    _jettag_f_message_642_1.doEnd();
                    out.write(NL);         
                    out.write("\t@Override");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t@WebRemote");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\tpublic List<");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 645, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("> search(String searchText) {");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\tList<");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 646, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("> results = new ArrayList<");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 646, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(">();");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\torg.apache.lucene.search.Query luceneQuery = SearchUtils");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t.getLuceneQuery(searchText, \"id\", new StandardAnalyzer(Version.LUCENE_30),");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\tReflectionUtils.getBeanProperties(");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 649, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".class,");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t\t\tDataType.STRING));");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\tFullTextQuery query = SearchUtils.getFullTextSession(em)");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t.createFullTextQuery(luceneQuery,  ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 652, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".class);");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\tfor (Object obj : query.list()) {");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\tresults.add((");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 654, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(") getBeanManager().clone((obj)));");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t}");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\treturn results;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t}");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_641_1.handleBodyContent(out);
                }
                _jettag_c_if_641_1.doEnd();
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_661_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_661_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_661_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_661_1.setTagInfo(_td_f_message_661_1);
                _jettag_f_message_661_1.doStart(context, out);
                JET2Writer _jettag_f_message_661_1_saved_out = out;
                while (_jettag_f_message_661_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_661_1.handleBodyContent(out);
                }
                out = _jettag_f_message_661_1_saved_out;
                _jettag_f_message_661_1.doEnd();
                out.write(NL);         
                out.write("\tpublic <T extends Serializable> List<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 662, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> getEntities(int start) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tList<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 663, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> entities = new ArrayList<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 663, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tString query = \"from \" + ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 664, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getCanonicalName();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery getEntitites = em.createQuery(query);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tgetEntitites.setFirstResult(start);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t// TODO externalize the max results value");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tgetEntitites.setMaxResults(10);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tfor (Object obj : getEntitites.getResultList()) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 670, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" clone = (");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 670, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(") getBeanManager().clone(obj);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\tentities.add(clone);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn entities;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_675_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_675_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_675_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_675_1.setTagInfo(_td_f_message_675_1);
                _jettag_f_message_675_1.doStart(context, out);
                JET2Writer _jettag_f_message_675_1_saved_out = out;
                while (_jettag_f_message_675_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_675_1.handleBodyContent(out);
                }
                out = _jettag_f_message_675_1_saved_out;
                _jettag_f_message_675_1.doEnd();
                out.write(NL);         
                out.write("\tpublic <T extends Serializable> Long getEntitySize() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tString query = \"select count(entity) from \"");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t+ ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 678, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getCanonicalName() + \" entity\";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tQuery getEntitiesSize = em.createQuery(query);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn (Long) getEntitiesSize.getSingleResult();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
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
