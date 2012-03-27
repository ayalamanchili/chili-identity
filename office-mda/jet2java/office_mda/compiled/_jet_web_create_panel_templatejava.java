package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_create_panel_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_create_panel_templatejava() {
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
    private static final TagInfo _td_c_if_10_2 = new TagInfo("c:if", //$NON-NLS-1$
            10, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_11_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            11, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_12_5 = new TagInfo("c:choose", //$NON-NLS-1$
            12, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_13_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            13, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_14_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            14, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_15_10 = new TagInfo("c:if", //$NON-NLS-1$
            15, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_24_2 = new TagInfo("c:if", //$NON-NLS-1$
            24, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_25_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            25, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_26_5 = new TagInfo("c:choose", //$NON-NLS-1$
            26, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_27_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            27, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_28_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            28, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_29_10 = new TagInfo("c:if", //$NON-NLS-1$
            29, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_38_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            38, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_39_5 = new TagInfo("c:choose", //$NON-NLS-1$
            39, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_40_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            40, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_41_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            41, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_42_10 = new TagInfo("c:if", //$NON-NLS-1$
            42, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_50_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            50, 2,
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
    private static final TagInfo _td_c_iterate_58_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            58, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_59_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            59, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_61_14 = new TagInfo("c:if", //$NON-NLS-1$
            61, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_63_14 = new TagInfo("c:if", //$NON-NLS-1$
            63, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_65_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            65, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_66_16 = new TagInfo("c:if", //$NON-NLS-1$
            66, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_69_16 = new TagInfo("c:setVariable", //$NON-NLS-1$
            69, 16,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_70_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            70, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_71_13 = new TagInfo("c:if", //$NON-NLS-1$
            71, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.parent/Class/@xmi.idref = $class2/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_73_13 = new TagInfo("c:setVariable", //$NON-NLS-1$
            73, 13,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@name", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_78_16 = new TagInfo("c:if", //$NON-NLS-1$
            78, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isParent = $class2/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_83_12 = new TagInfo("c:if", //$NON-NLS-1$
            83, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isParent = $class2/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_97_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            97, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_98_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            98, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_99_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            99, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_100_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            100, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_102_6 = new TagInfo("c:if", //$NON-NLS-1$
            102, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_104_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            104, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
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
    private static final TagInfo _td_c_if_113_16 = new TagInfo("c:if", //$NON-NLS-1$
            113, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_114_18 = new TagInfo("c:if", //$NON-NLS-1$
            114, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_117_18 = new TagInfo("c:if", //$NON-NLS-1$
            117, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_118_18 = new TagInfo("c:if", //$NON-NLS-1$
            118, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_140_1 = new TagInfo("f:message", //$NON-NLS-1$
            140, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_143_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            143, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_144_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            144, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_145_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            145, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_146_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            146, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_148_6 = new TagInfo("c:if", //$NON-NLS-1$
            148, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_150_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            150, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_151_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            151, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_153_14 = new TagInfo("c:if", //$NON-NLS-1$
            153, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_155_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            155, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_156_16 = new TagInfo("c:if", //$NON-NLS-1$
            156, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_159_16 = new TagInfo("c:if", //$NON-NLS-1$
            159, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_160_18 = new TagInfo("c:if", //$NON-NLS-1$
            160, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_162_18 = new TagInfo("c:if", //$NON-NLS-1$
            162, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_163_1 = new TagInfo("f:message", //$NON-NLS-1$
            163, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_177_1 = new TagInfo("f:message", //$NON-NLS-1$
            177, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_184_1 = new TagInfo("f:message", //$NON-NLS-1$
            184, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_187_3 = new TagInfo("c:if", //$NON-NLS-1$
            187, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_200_1 = new TagInfo("f:message", //$NON-NLS-1$
            200, 1,
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
    private static final TagInfo _td_f_message_212_1 = new TagInfo("f:message", //$NON-NLS-1$
            212, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_216_2 = new TagInfo("c:if", //$NON-NLS-1$
            216, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_217_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            217, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_218_5 = new TagInfo("c:choose", //$NON-NLS-1$
            218, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_219_6 = new TagInfo("c:when", //$NON-NLS-1$
            219, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_221_6 = new TagInfo("c:when", //$NON-NLS-1$
            221, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_223_6 = new TagInfo("c:when", //$NON-NLS-1$
            223, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_225_6 = new TagInfo("c:when", //$NON-NLS-1$
            225, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_227_6 = new TagInfo("c:when", //$NON-NLS-1$
            227, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_229_6 = new TagInfo("c:when", //$NON-NLS-1$
            229, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_231_6 = new TagInfo("c:when", //$NON-NLS-1$
            231, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_233_6 = new TagInfo("c:when", //$NON-NLS-1$
            233, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_235_6 = new TagInfo("c:when", //$NON-NLS-1$
            235, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_237_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            237, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_238_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            238, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_239_10 = new TagInfo("c:if", //$NON-NLS-1$
            239, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_248_2 = new TagInfo("c:if", //$NON-NLS-1$
            248, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_249_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            249, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_250_5 = new TagInfo("c:choose", //$NON-NLS-1$
            250, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_251_6 = new TagInfo("c:when", //$NON-NLS-1$
            251, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_253_6 = new TagInfo("c:when", //$NON-NLS-1$
            253, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_255_6 = new TagInfo("c:when", //$NON-NLS-1$
            255, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_257_6 = new TagInfo("c:when", //$NON-NLS-1$
            257, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_259_6 = new TagInfo("c:when", //$NON-NLS-1$
            259, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_261_6 = new TagInfo("c:when", //$NON-NLS-1$
            261, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_263_6 = new TagInfo("c:when", //$NON-NLS-1$
            263, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_265_6 = new TagInfo("c:when", //$NON-NLS-1$
            265, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_267_6 = new TagInfo("c:when", //$NON-NLS-1$
            267, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_269_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            269, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_270_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            270, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_271_10 = new TagInfo("c:if", //$NON-NLS-1$
            271, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_280_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            280, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_281_5 = new TagInfo("c:choose", //$NON-NLS-1$
            281, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_282_6 = new TagInfo("c:when", //$NON-NLS-1$
            282, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_284_6 = new TagInfo("c:when", //$NON-NLS-1$
            284, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_286_6 = new TagInfo("c:when", //$NON-NLS-1$
            286, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_288_6 = new TagInfo("c:when", //$NON-NLS-1$
            288, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_290_6 = new TagInfo("c:when", //$NON-NLS-1$
            290, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_292_6 = new TagInfo("c:when", //$NON-NLS-1$
            292, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_294_6 = new TagInfo("c:when", //$NON-NLS-1$
            294, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_296_6 = new TagInfo("c:when", //$NON-NLS-1$
            296, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_298_6 = new TagInfo("c:when", //$NON-NLS-1$
            298, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_300_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            300, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_301_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            301, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_302_10 = new TagInfo("c:if", //$NON-NLS-1$
            302, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_311_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            311, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_312_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            312, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_313_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            313, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_314_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            314, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_316_9 = new TagInfo("c:if", //$NON-NLS-1$
            316, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_318_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            318, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_319_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            319, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_321_17 = new TagInfo("c:if", //$NON-NLS-1$
            321, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_323_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            323, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_324_19 = new TagInfo("c:if", //$NON-NLS-1$
            324, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_327_19 = new TagInfo("c:if", //$NON-NLS-1$
            327, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_328_21 = new TagInfo("c:if", //$NON-NLS-1$
            328, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_330_18 = new TagInfo("c:if", //$NON-NLS-1$
            330, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_344_1 = new TagInfo("f:message", //$NON-NLS-1$
            344, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_349_2 = new TagInfo("c:if", //$NON-NLS-1$
            349, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_350_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            350, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_351_4 = new TagInfo("c:choose", //$NON-NLS-1$
            351, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_352_5 = new TagInfo("c:when", //$NON-NLS-1$
            352, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_354_5 = new TagInfo("c:when", //$NON-NLS-1$
            354, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_356_5 = new TagInfo("c:when", //$NON-NLS-1$
            356, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_358_5 = new TagInfo("c:when", //$NON-NLS-1$
            358, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_360_5 = new TagInfo("c:when", //$NON-NLS-1$
            360, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_362_5 = new TagInfo("c:when", //$NON-NLS-1$
            362, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_364_5 = new TagInfo("c:when", //$NON-NLS-1$
            364, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_366_5 = new TagInfo("c:when", //$NON-NLS-1$
            366, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_368_5 = new TagInfo("c:when", //$NON-NLS-1$
            368, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_370_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            370, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_371_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            371, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_372_10 = new TagInfo("c:if", //$NON-NLS-1$
            372, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_382_2 = new TagInfo("c:if", //$NON-NLS-1$
            382, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_383_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            383, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_384_4 = new TagInfo("c:choose", //$NON-NLS-1$
            384, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_385_5 = new TagInfo("c:when", //$NON-NLS-1$
            385, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_387_5 = new TagInfo("c:when", //$NON-NLS-1$
            387, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_389_5 = new TagInfo("c:when", //$NON-NLS-1$
            389, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_391_5 = new TagInfo("c:when", //$NON-NLS-1$
            391, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_393_5 = new TagInfo("c:when", //$NON-NLS-1$
            393, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_395_5 = new TagInfo("c:when", //$NON-NLS-1$
            395, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_397_5 = new TagInfo("c:when", //$NON-NLS-1$
            397, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_399_5 = new TagInfo("c:when", //$NON-NLS-1$
            399, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_401_5 = new TagInfo("c:when", //$NON-NLS-1$
            401, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_403_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            403, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_404_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            404, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_405_10 = new TagInfo("c:if", //$NON-NLS-1$
            405, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_414_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            414, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_415_4 = new TagInfo("c:choose", //$NON-NLS-1$
            415, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_416_5 = new TagInfo("c:when", //$NON-NLS-1$
            416, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_418_5 = new TagInfo("c:when", //$NON-NLS-1$
            418, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_420_5 = new TagInfo("c:when", //$NON-NLS-1$
            420, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_422_5 = new TagInfo("c:when", //$NON-NLS-1$
            422, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_424_5 = new TagInfo("c:when", //$NON-NLS-1$
            424, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_426_5 = new TagInfo("c:when", //$NON-NLS-1$
            426, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_428_5 = new TagInfo("c:when", //$NON-NLS-1$
            428, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_430_5 = new TagInfo("c:when", //$NON-NLS-1$
            430, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_432_5 = new TagInfo("c:when", //$NON-NLS-1$
            432, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_434_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            434, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_435_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            435, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_436_10 = new TagInfo("c:if", //$NON-NLS-1$
            436, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_445_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            445, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_446_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            446, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_447_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            447, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_448_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            448, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_450_9 = new TagInfo("c:if", //$NON-NLS-1$
            450, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_452_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            452, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_453_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            453, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_455_17 = new TagInfo("c:if", //$NON-NLS-1$
            455, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_457_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            457, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_458_19 = new TagInfo("c:if", //$NON-NLS-1$
            458, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_461_19 = new TagInfo("c:if", //$NON-NLS-1$
            461, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_462_21 = new TagInfo("c:if", //$NON-NLS-1$
            462, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_464_18 = new TagInfo("c:if", //$NON-NLS-1$
            464, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_479_1 = new TagInfo("f:message", //$NON-NLS-1$
            479, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_484_1 = new TagInfo("f:message", //$NON-NLS-1$
            484, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_488_2 = new TagInfo("c:if", //$NON-NLS-1$
            488, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_490_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            490, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_491_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            491, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_492_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            492, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_493_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            493, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_495_6 = new TagInfo("c:if", //$NON-NLS-1$
            495, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_498_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            498, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_499_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            499, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_501_14 = new TagInfo("c:if", //$NON-NLS-1$
            501, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_503_14 = new TagInfo("c:if", //$NON-NLS-1$
            503, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_505_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            505, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_506_16 = new TagInfo("c:if", //$NON-NLS-1$
            506, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_508_11 = new TagInfo("c:if", //$NON-NLS-1$
            508, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@parent1 = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_509_11 = new TagInfo("c:if", //$NON-NLS-1$
            509, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@hasChildren = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_523_11 = new TagInfo("c:if", //$NON-NLS-1$
            523, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@hasChildren = $class2/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_538_12 = new TagInfo("c:if", //$NON-NLS-1$
            538, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@parent1 = $class2/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_539_12 = new TagInfo("c:if", //$NON-NLS-1$
            539, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@hasChildren = $class2/@name)", //$NON-NLS-1$
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
                out.write("package ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 6, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 6, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 7, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 7, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 7, 59)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanel.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 7, 81)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("TableType;");  //$NON-NLS-1$        
                out.write(NL);         
                //process enums from base and lavel1,2 parents 
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_10_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_10_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_10_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_10_2.setTagInfo(_td_c_if_10_2);
                _jettag_c_if_10_2.doStart(context, out);
                while (_jettag_c_if_10_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_11_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_11_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_11_5.setRuntimeParent(_jettag_c_if_10_2);
                    _jettag_c_iterate_11_5.setTagInfo(_td_c_iterate_11_5);
                    _jettag_c_iterate_11_5.doStart(context, out);
                    while (_jettag_c_iterate_11_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_12_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_12_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_12_5.setRuntimeParent(_jettag_c_iterate_11_5);
                        _jettag_c_choose_12_5.setTagInfo(_td_c_choose_12_5);
                        _jettag_c_choose_12_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_12_5_saved_out = out;
                        while (_jettag_c_choose_12_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_otherwise_13_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_13_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_13_7.setRuntimeParent(_jettag_c_choose_12_5);
                            _jettag_c_otherwise_13_7.setTagInfo(_td_c_otherwise_13_7);
                            _jettag_c_otherwise_13_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_13_7_saved_out = out;
                            while (_jettag_c_otherwise_13_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_14_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_14_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_14_8.setRuntimeParent(_jettag_c_otherwise_13_7);
                                _jettag_c_iterate_14_8.setTagInfo(_td_c_iterate_14_8);
                                _jettag_c_iterate_14_8.doStart(context, out);
                                while (_jettag_c_iterate_14_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_15_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_15_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_15_10.setRuntimeParent(_jettag_c_iterate_14_8);
                                    _jettag_c_if_15_10.setTagInfo(_td_c_if_15_10);
                                    _jettag_c_if_15_10.doStart(context, out);
                                    while (_jettag_c_if_15_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$groupID}", 16, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".entity.");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 16, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 16, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(";");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_15_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_15_10.doEnd();
                                    _jettag_c_iterate_14_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_14_8.doEnd();
                                _jettag_c_otherwise_13_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_13_7_saved_out;
                            _jettag_c_otherwise_13_7.doEnd();
                            _jettag_c_choose_12_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_12_5_saved_out;
                        _jettag_c_choose_12_5.doEnd();
                        _jettag_c_iterate_11_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_11_5.doEnd();
                    _jettag_c_if_10_2.handleBodyContent(out);
                }
                _jettag_c_if_10_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_24_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_24_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_24_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_24_2.setTagInfo(_td_c_if_24_2);
                _jettag_c_if_24_2.doStart(context, out);
                while (_jettag_c_if_24_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_25_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_25_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_25_5.setRuntimeParent(_jettag_c_if_24_2);
                    _jettag_c_iterate_25_5.setTagInfo(_td_c_iterate_25_5);
                    _jettag_c_iterate_25_5.doStart(context, out);
                    while (_jettag_c_iterate_25_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_26_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_26_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_26_5.setRuntimeParent(_jettag_c_iterate_25_5);
                        _jettag_c_choose_26_5.setTagInfo(_td_c_choose_26_5);
                        _jettag_c_choose_26_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_26_5_saved_out = out;
                        while (_jettag_c_choose_26_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_otherwise_27_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_27_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_27_7.setRuntimeParent(_jettag_c_choose_26_5);
                            _jettag_c_otherwise_27_7.setTagInfo(_td_c_otherwise_27_7);
                            _jettag_c_otherwise_27_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_27_7_saved_out = out;
                            while (_jettag_c_otherwise_27_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_28_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_28_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_28_8.setRuntimeParent(_jettag_c_otherwise_27_7);
                                _jettag_c_iterate_28_8.setTagInfo(_td_c_iterate_28_8);
                                _jettag_c_iterate_28_8.doStart(context, out);
                                while (_jettag_c_iterate_28_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_29_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_29_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_29_10.setRuntimeParent(_jettag_c_iterate_28_8);
                                    _jettag_c_if_29_10.setTagInfo(_td_c_if_29_10);
                                    _jettag_c_if_29_10.doStart(context, out);
                                    while (_jettag_c_if_29_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$groupID}", 30, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".entity.");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 30, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 30, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(";");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_29_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_29_10.doEnd();
                                    _jettag_c_iterate_28_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_28_8.doEnd();
                                _jettag_c_otherwise_27_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_27_7_saved_out;
                            _jettag_c_otherwise_27_7.doEnd();
                            _jettag_c_choose_26_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_26_5_saved_out;
                        _jettag_c_choose_26_5.doEnd();
                        _jettag_c_iterate_25_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_25_5.doEnd();
                    _jettag_c_if_24_2.handleBodyContent(out);
                }
                _jettag_c_if_24_2.doEnd();
                //process premitive data types of base current class 
                RuntimeTagElement _jettag_c_iterate_38_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_38_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_38_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_38_4.setTagInfo(_td_c_iterate_38_4);
                _jettag_c_iterate_38_4.doStart(context, out);
                while (_jettag_c_iterate_38_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_39_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_39_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_39_5.setRuntimeParent(_jettag_c_iterate_38_4);
                    _jettag_c_choose_39_5.setTagInfo(_td_c_choose_39_5);
                    _jettag_c_choose_39_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_39_5_saved_out = out;
                    while (_jettag_c_choose_39_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_otherwise_40_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_40_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_40_7.setRuntimeParent(_jettag_c_choose_39_5);
                        _jettag_c_otherwise_40_7.setTagInfo(_td_c_otherwise_40_7);
                        _jettag_c_otherwise_40_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_40_7_saved_out = out;
                        while (_jettag_c_otherwise_40_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_41_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_41_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_41_8.setRuntimeParent(_jettag_c_otherwise_40_7);
                            _jettag_c_iterate_41_8.setTagInfo(_td_c_iterate_41_8);
                            _jettag_c_iterate_41_8.doStart(context, out);
                            while (_jettag_c_iterate_41_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_42_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_42_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_42_10.setRuntimeParent(_jettag_c_iterate_41_8);
                                _jettag_c_if_42_10.setTagInfo(_td_c_if_42_10);
                                _jettag_c_if_42_10.doStart(context, out);
                                while (_jettag_c_if_42_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$groupID}", 43, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".entity.");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 43, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 43, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(";");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_42_10.handleBodyContent(out);
                                }
                                _jettag_c_if_42_10.doEnd();
                                _jettag_c_iterate_41_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_41_8.doEnd();
                            _jettag_c_otherwise_40_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_40_7_saved_out;
                        _jettag_c_otherwise_40_7.doEnd();
                        _jettag_c_choose_39_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_39_5_saved_out;
                    _jettag_c_choose_39_5.doEnd();
                    _jettag_c_iterate_38_4.handleBodyContent(out);
                }
                _jettag_c_iterate_38_4.doEnd();
                // process compsition associations
                RuntimeTagElement _jettag_c_iterate_50_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_50_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_50_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_50_2.setTagInfo(_td_c_iterate_50_2);
                _jettag_c_iterate_50_2.doStart(context, out);
                while (_jettag_c_iterate_50_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_51_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_51_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_51_2.setRuntimeParent(_jettag_c_iterate_50_2);
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
                                // process only compositions
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_58_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_58_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_58_12.setRuntimeParent(_jettag_c_if_55_6);
                                _jettag_c_iterate_58_12.setTagInfo(_td_c_iterate_58_12);
                                _jettag_c_iterate_58_12.doStart(context, out);
                                while (_jettag_c_iterate_58_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_59_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_59_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_59_12.setRuntimeParent(_jettag_c_iterate_58_12);
                                    _jettag_c_setVariable_59_12.setTagInfo(_td_c_setVariable_59_12);
                                    _jettag_c_setVariable_59_12.doStart(context, out);
                                    _jettag_c_setVariable_59_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_61_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_61_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_61_14.setRuntimeParent(_jettag_c_iterate_58_12);
                                    _jettag_c_if_61_14.setTagInfo(_td_c_if_61_14);
                                    _jettag_c_if_61_14.doStart(context, out);
                                    while (_jettag_c_if_61_14.okToProcessBody()) {
                                        // check if this is a comp
                                        RuntimeTagElement _jettag_c_if_63_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_63_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_63_14.setRuntimeParent(_jettag_c_if_61_14);
                                        _jettag_c_if_63_14.setTagInfo(_td_c_if_63_14);
                                        _jettag_c_if_63_14.doStart(context, out);
                                        while (_jettag_c_if_63_14.okToProcessBody()) {
                                            // iterate throught all the classes to get the other class on the association
                                            RuntimeTagElement _jettag_c_iterate_65_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_65_15); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_iterate_65_15.setRuntimeParent(_jettag_c_if_63_14);
                                            _jettag_c_iterate_65_15.setTagInfo(_td_c_iterate_65_15);
                                            _jettag_c_iterate_65_15.doStart(context, out);
                                            while (_jettag_c_iterate_65_15.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_66_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_66_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_66_16.setRuntimeParent(_jettag_c_iterate_65_15);
                                                _jettag_c_if_66_16.setTagInfo(_td_c_if_66_16);
                                                _jettag_c_if_66_16.doStart(context, out);
                                                while (_jettag_c_if_66_16.okToProcessBody()) {
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    // check if this is a parent
                                                    RuntimeTagElement _jettag_c_setVariable_69_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_69_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_setVariable_69_16.setRuntimeParent(_jettag_c_if_66_16);
                                                    _jettag_c_setVariable_69_16.setTagInfo(_td_c_setVariable_69_16);
                                                    _jettag_c_setVariable_69_16.doStart(context, out);
                                                    _jettag_c_setVariable_69_16.doEnd();
                                                    RuntimeTagElement _jettag_c_iterate_70_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_70_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_70_12.setRuntimeParent(_jettag_c_if_66_16);
                                                    _jettag_c_iterate_70_12.setTagInfo(_td_c_iterate_70_12);
                                                    _jettag_c_iterate_70_12.doStart(context, out);
                                                    while (_jettag_c_iterate_70_12.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_71_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_71_13); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_71_13.setRuntimeParent(_jettag_c_iterate_70_12);
                                                        _jettag_c_if_71_13.setTagInfo(_td_c_if_71_13);
                                                        _jettag_c_if_71_13.doStart(context, out);
                                                        while (_jettag_c_if_71_13.okToProcessBody()) {
                                                            // update flag variable
                                                            RuntimeTagElement _jettag_c_setVariable_73_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_73_13); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_setVariable_73_13.setRuntimeParent(_jettag_c_if_71_13);
                                                            _jettag_c_setVariable_73_13.setTagInfo(_td_c_setVariable_73_13);
                                                            _jettag_c_setVariable_73_13.doStart(context, out);
                                                            _jettag_c_setVariable_73_13.doEnd();
                                                            _jettag_c_if_71_13.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_71_13.doEnd();
                                                        _jettag_c_iterate_70_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_70_12.doEnd();
                                                    // if class is a Parent class
                                                    out.write("\t\t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 77, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".entity.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 77, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 77, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    RuntimeTagElement _jettag_c_if_78_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_78_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_78_16.setRuntimeParent(_jettag_c_if_66_16);
                                                    _jettag_c_if_78_16.setTagInfo(_td_c_if_78_16);
                                                    _jettag_c_if_78_16.doStart(context, out);
                                                    while (_jettag_c_if_78_16.okToProcessBody()) {
                                                        out.write("\t\t\t\t\t\t\t\t    \t\t \timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 79, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 79, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 79, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".TreeAbstract");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 79, 114)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Panel;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_78_16.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_78_16.doEnd();
                                                    // if class is a regular  class
                                                    out.write("\t\t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 82, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".entity.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 82, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 82, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    RuntimeTagElement _jettag_c_if_83_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_83_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_83_12.setRuntimeParent(_jettag_c_if_66_16);
                                                    _jettag_c_if_83_12.setTagInfo(_td_c_if_83_12);
                                                    _jettag_c_if_83_12.doStart(context, out);
                                                    while (_jettag_c_if_83_12.okToProcessBody()) {
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 84, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 84, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 84, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".Tree");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 84, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Panel;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_83_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_83_12.doEnd();
                                                    _jettag_c_if_66_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_66_16.doEnd();
                                                _jettag_c_iterate_65_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_65_15.doEnd();
                                            _jettag_c_if_63_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_63_14.doEnd();
                                        _jettag_c_if_61_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_61_14.doEnd();
                                    _jettag_c_iterate_58_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_58_12.doEnd();
                                _jettag_c_if_55_6.handleBodyContent(out);
                            }
                            _jettag_c_if_55_6.doEnd();
                            _jettag_c_iterate_52_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_52_3.doEnd();
                        _jettag_c_iterate_51_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_51_2.doEnd();
                    _jettag_c_iterate_50_2.handleBodyContent(out);
                }
                _jettag_c_iterate_50_2.doEnd();
                out.write(NL);         
                // process dropdowns one tone and many to one 
                RuntimeTagElement _jettag_c_iterate_97_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_97_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_97_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_97_1.setTagInfo(_td_c_iterate_97_1);
                _jettag_c_iterate_97_1.doStart(context, out);
                while (_jettag_c_iterate_97_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_98_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_98_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_98_2.setRuntimeParent(_jettag_c_iterate_97_1);
                    _jettag_c_iterate_98_2.setTagInfo(_td_c_iterate_98_2);
                    _jettag_c_iterate_98_2.doStart(context, out);
                    while (_jettag_c_iterate_98_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_99_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_99_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_99_3.setRuntimeParent(_jettag_c_iterate_98_2);
                        _jettag_c_iterate_99_3.setTagInfo(_td_c_iterate_99_3);
                        _jettag_c_iterate_99_3.doStart(context, out);
                        while (_jettag_c_iterate_99_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_100_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_100_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_100_4.setRuntimeParent(_jettag_c_iterate_99_3);
                            _jettag_c_setVariable_100_4.setTagInfo(_td_c_setVariable_100_4);
                            _jettag_c_setVariable_100_4.doStart(context, out);
                            _jettag_c_setVariable_100_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_102_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_102_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_102_6.setRuntimeParent(_jettag_c_iterate_99_3);
                            _jettag_c_if_102_6.setTagInfo(_td_c_if_102_6);
                            _jettag_c_if_102_6.doStart(context, out);
                            while (_jettag_c_if_102_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_104_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_104_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_104_12.setRuntimeParent(_jettag_c_if_102_6);
                                _jettag_c_iterate_104_12.setTagInfo(_td_c_iterate_104_12);
                                _jettag_c_iterate_104_12.doStart(context, out);
                                while (_jettag_c_iterate_104_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_105_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_105_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_105_12.setRuntimeParent(_jettag_c_iterate_104_12);
                                    _jettag_c_setVariable_105_12.setTagInfo(_td_c_setVariable_105_12);
                                    _jettag_c_setVariable_105_12.doStart(context, out);
                                    _jettag_c_setVariable_105_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_107_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_107_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_107_14.setRuntimeParent(_jettag_c_iterate_104_12);
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
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_113_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_113_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_113_16.setRuntimeParent(_jettag_c_if_110_16);
                                                _jettag_c_if_113_16.setTagInfo(_td_c_if_113_16);
                                                _jettag_c_if_113_16.doStart(context, out);
                                                while (_jettag_c_if_113_16.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_114_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_114_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_114_18.setRuntimeParent(_jettag_c_if_113_16);
                                                    _jettag_c_if_114_18.setTagInfo(_td_c_if_114_18);
                                                    _jettag_c_if_114_18.doStart(context, out);
                                                    while (_jettag_c_if_114_18.okToProcessBody()) {
                                                        out.write("  \t\t\t\t\t    \t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 115, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 115, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 115, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".Select");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 115, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Panel;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        //check for one to one 
                                                        RuntimeTagElement _jettag_c_if_117_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_117_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_117_18.setRuntimeParent(_jettag_c_if_114_18);
                                                        _jettag_c_if_117_18.setTagInfo(_td_c_if_117_18);
                                                        _jettag_c_if_117_18.doStart(context, out);
                                                        while (_jettag_c_if_117_18.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_118_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_118_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_118_18.setRuntimeParent(_jettag_c_if_117_18);
                                                            _jettag_c_if_118_18.setTagInfo(_td_c_if_118_18);
                                                            _jettag_c_if_118_18.doStart(context, out);
                                                            while (_jettag_c_if_118_18.okToProcessBody()) {
                                                                out.write("  \t\t\t\t\t    \t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 119, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".client.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 119, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 119, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".Select");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 119, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panel;");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_118_18.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_118_18.doEnd();
                                                            _jettag_c_if_117_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_117_18.doEnd();
                                                        _jettag_c_if_114_18.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_114_18.doEnd();
                                                    _jettag_c_if_113_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_113_16.doEnd();
                                                _jettag_c_if_110_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_110_16.doEnd();
                                            _jettag_c_iterate_109_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_109_15.doEnd();
                                        _jettag_c_if_107_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_107_14.doEnd();
                                    _jettag_c_iterate_104_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_104_12.doEnd();
                                _jettag_c_if_102_6.handleBodyContent(out);
                            }
                            _jettag_c_if_102_6.doEnd();
                            _jettag_c_iterate_99_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_99_3.doEnd();
                        _jettag_c_iterate_98_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_98_2.doEnd();
                    _jettag_c_iterate_97_1.handleBodyContent(out);
                }
                _jettag_c_iterate_97_1.doEnd();
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.CreateComposite;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.widgets.ResponseStatusWidget;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 136, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 136, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 136, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 137, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 137, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.fields.DataType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_140_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_140_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_140_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_140_1.setTagInfo(_td_f_message_140_1);
                _jettag_f_message_140_1.doStart(context, out);
                JET2Writer _jettag_f_message_140_1_saved_out = out;
                while (_jettag_f_message_140_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_140_1.handleBodyContent(out);
                }
                out = _jettag_f_message_140_1_saved_out;
                _jettag_f_message_140_1.doEnd();
                out.write(NL);         
                out.write("public class Create");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 141, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel extends CreateComposite<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 141, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> {");  //$NON-NLS-1$        
                out.write(NL);         
                // process dropdowns one tone and many to one 
                RuntimeTagElement _jettag_c_iterate_143_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_143_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_143_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_143_1.setTagInfo(_td_c_iterate_143_1);
                _jettag_c_iterate_143_1.doStart(context, out);
                while (_jettag_c_iterate_143_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_144_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_144_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_144_2.setRuntimeParent(_jettag_c_iterate_143_1);
                    _jettag_c_iterate_144_2.setTagInfo(_td_c_iterate_144_2);
                    _jettag_c_iterate_144_2.doStart(context, out);
                    while (_jettag_c_iterate_144_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_145_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_145_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_145_3.setRuntimeParent(_jettag_c_iterate_144_2);
                        _jettag_c_iterate_145_3.setTagInfo(_td_c_iterate_145_3);
                        _jettag_c_iterate_145_3.doStart(context, out);
                        while (_jettag_c_iterate_145_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_146_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_146_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_146_4.setRuntimeParent(_jettag_c_iterate_145_3);
                            _jettag_c_setVariable_146_4.setTagInfo(_td_c_setVariable_146_4);
                            _jettag_c_setVariable_146_4.doStart(context, out);
                            _jettag_c_setVariable_146_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_148_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_148_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_148_6.setRuntimeParent(_jettag_c_iterate_145_3);
                            _jettag_c_if_148_6.setTagInfo(_td_c_if_148_6);
                            _jettag_c_if_148_6.doStart(context, out);
                            while (_jettag_c_if_148_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_150_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_150_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_150_12.setRuntimeParent(_jettag_c_if_148_6);
                                _jettag_c_iterate_150_12.setTagInfo(_td_c_iterate_150_12);
                                _jettag_c_iterate_150_12.doStart(context, out);
                                while (_jettag_c_iterate_150_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_151_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_151_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_151_12.setRuntimeParent(_jettag_c_iterate_150_12);
                                    _jettag_c_setVariable_151_12.setTagInfo(_td_c_setVariable_151_12);
                                    _jettag_c_setVariable_151_12.doStart(context, out);
                                    _jettag_c_setVariable_151_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_153_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_153_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_153_14.setRuntimeParent(_jettag_c_iterate_150_12);
                                    _jettag_c_if_153_14.setTagInfo(_td_c_if_153_14);
                                    _jettag_c_if_153_14.doStart(context, out);
                                    while (_jettag_c_if_153_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_155_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_155_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_155_15.setRuntimeParent(_jettag_c_if_153_14);
                                        _jettag_c_iterate_155_15.setTagInfo(_td_c_iterate_155_15);
                                        _jettag_c_iterate_155_15.doStart(context, out);
                                        while (_jettag_c_iterate_155_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_156_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_156_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_156_16.setRuntimeParent(_jettag_c_iterate_155_15);
                                            _jettag_c_if_156_16.setTagInfo(_td_c_if_156_16);
                                            _jettag_c_if_156_16.doStart(context, out);
                                            while (_jettag_c_if_156_16.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_159_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_159_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_159_16.setRuntimeParent(_jettag_c_if_156_16);
                                                _jettag_c_if_159_16.setTagInfo(_td_c_if_159_16);
                                                _jettag_c_if_159_16.doStart(context, out);
                                                while (_jettag_c_if_159_16.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_160_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_160_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_160_18.setRuntimeParent(_jettag_c_if_159_16);
                                                    _jettag_c_if_160_18.setTagInfo(_td_c_if_160_18);
                                                    _jettag_c_if_160_18.doStart(context, out);
                                                    while (_jettag_c_if_160_18.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_162_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_162_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_162_18.setRuntimeParent(_jettag_c_if_160_18);
                                                        _jettag_c_if_162_18.setTagInfo(_td_c_if_162_18);
                                                        _jettag_c_if_162_18.doStart(context, out);
                                                        while (_jettag_c_if_162_18.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_f_message_163_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_163_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_163_1.setRuntimeParent(_jettag_c_if_162_18);
                                                            _jettag_f_message_163_1.setTagInfo(_td_f_message_163_1);
                                                            _jettag_f_message_163_1.doStart(context, out);
                                                            JET2Writer _jettag_f_message_163_1_saved_out = out;
                                                            while (_jettag_f_message_163_1.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_163_1.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_163_1_saved_out;
                                                            _jettag_f_message_163_1.doEnd();
                                                            out.write("  \t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("  \t\t\t\t\t    \t\t\t\t\t\t\tSelect");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 164, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 164, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel = new Select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 164, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel(\"");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 164, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("\");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_162_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_162_18.doEnd();
                                                        _jettag_c_if_160_18.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_160_18.doEnd();
                                                    _jettag_c_if_159_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_159_16.doEnd();
                                                _jettag_c_if_156_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_156_16.doEnd();
                                            _jettag_c_iterate_155_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_155_15.doEnd();
                                        _jettag_c_if_153_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_153_14.doEnd();
                                    _jettag_c_iterate_150_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_150_12.doEnd();
                                _jettag_c_if_148_6.handleBodyContent(out);
                            }
                            _jettag_c_if_148_6.doEnd();
                            _jettag_c_iterate_145_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_145_3.doEnd();
                        _jettag_c_iterate_144_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_144_2.doEnd();
                    _jettag_c_iterate_143_1.handleBodyContent(out);
                }
                _jettag_c_iterate_143_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_177_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_177_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_177_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_177_1.setTagInfo(_td_f_message_177_1);
                _jettag_f_message_177_1.doStart(context, out);
                JET2Writer _jettag_f_message_177_1_saved_out = out;
                while (_jettag_f_message_177_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_177_1.handleBodyContent(out);
                }
                out = _jettag_f_message_177_1_saved_out;
                _jettag_f_message_177_1.doEnd();
                out.write(NL);         
                out.write("public Create");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 178, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel(CreateCompositeType type) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tsuper(type);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitCreateComposite(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 180, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getName(), ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 180, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.constants);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_184_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_184_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_184_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_184_1.setTagInfo(_td_f_message_184_1);
                _jettag_f_message_184_1.doStart(context, out);
                JET2Writer _jettag_f_message_184_1_saved_out = out;
                while (_jettag_f_message_184_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_184_1.handleBodyContent(out);
                }
                out = _jettag_f_message_184_1_saved_out;
                _jettag_f_message_184_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void createButtonClicked() {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_if_187_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_187_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_187_3.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_187_3.setTagInfo(_td_c_if_187_3);
                _jettag_c_if_187_3.doStart(context, out);
                while (_jettag_c_if_187_3.okToProcessBody()) {
                    out.write("\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$packageName}", 188, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 188, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 188, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Service.");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 188, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("ServiceAsync.instance().create(entity,");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\tnew ALAsyncCallback<");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 189, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(">() {");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\tpublic void onResponse(");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 190, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(" arg0) {");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\tnew ResponseStatusWidget().show(\"created\");");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 192, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Welcome.instance().getEntityPanel().clear();");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 193, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t\tnew ReadAll");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 194, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("sPanel(");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 194, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TableType.READALL));");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t\t\t});");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write(NL);         
                    _jettag_c_if_187_3.handleBodyContent(out);
                }
                _jettag_c_if_187_3.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_200_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_200_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_200_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_200_1.setTagInfo(_td_f_message_200_1);
                _jettag_f_message_200_1.doStart(context, out);
                JET2Writer _jettag_f_message_200_1_saved_out = out;
                while (_jettag_f_message_200_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_200_1.handleBodyContent(out);
                }
                out = _jettag_f_message_200_1_saved_out;
                _jettag_f_message_200_1.doEnd();
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
                out.write("\tprotected void addWidgetsBeforeCaptionPanel() {");  //$NON-NLS-1$        
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
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_216_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_216_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_216_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_216_2.setTagInfo(_td_c_if_216_2);
                _jettag_c_if_216_2.doStart(context, out);
                while (_jettag_c_if_216_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_217_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_217_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_217_5.setRuntimeParent(_jettag_c_if_216_2);
                    _jettag_c_iterate_217_5.setTagInfo(_td_c_iterate_217_5);
                    _jettag_c_iterate_217_5.doStart(context, out);
                    while (_jettag_c_iterate_217_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_218_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_218_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_218_5.setRuntimeParent(_jettag_c_iterate_217_5);
                        _jettag_c_choose_218_5.setTagInfo(_td_c_choose_218_5);
                        _jettag_c_choose_218_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_218_5_saved_out = out;
                        while (_jettag_c_choose_218_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_219_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_219_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_219_6.setRuntimeParent(_jettag_c_choose_218_5);
                            _jettag_c_when_219_6.setTagInfo(_td_c_when_219_6);
                            _jettag_c_when_219_6.doStart(context, out);
                            JET2Writer _jettag_c_when_219_6_saved_out = out;
                            while (_jettag_c_when_219_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 219, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 219, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_219_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_219_6_saved_out;
                            _jettag_c_when_219_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_221_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_221_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_221_6.setRuntimeParent(_jettag_c_choose_218_5);
                            _jettag_c_when_221_6.setTagInfo(_td_c_when_221_6);
                            _jettag_c_when_221_6.doStart(context, out);
                            JET2Writer _jettag_c_when_221_6_saved_out = out;
                            while (_jettag_c_when_221_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 221, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 221, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_221_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_221_6_saved_out;
                            _jettag_c_when_221_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_223_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_223_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_223_6.setRuntimeParent(_jettag_c_choose_218_5);
                            _jettag_c_when_223_6.setTagInfo(_td_c_when_223_6);
                            _jettag_c_when_223_6.doStart(context, out);
                            JET2Writer _jettag_c_when_223_6_saved_out = out;
                            while (_jettag_c_when_223_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 223, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 223, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_223_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_223_6_saved_out;
                            _jettag_c_when_223_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_225_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_225_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_225_6.setRuntimeParent(_jettag_c_choose_218_5);
                            _jettag_c_when_225_6.setTagInfo(_td_c_when_225_6);
                            _jettag_c_when_225_6.doStart(context, out);
                            JET2Writer _jettag_c_when_225_6_saved_out = out;
                            while (_jettag_c_when_225_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 225, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 225, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_225_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_225_6_saved_out;
                            _jettag_c_when_225_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_227_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_227_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_227_6.setRuntimeParent(_jettag_c_choose_218_5);
                            _jettag_c_when_227_6.setTagInfo(_td_c_when_227_6);
                            _jettag_c_when_227_6.doStart(context, out);
                            JET2Writer _jettag_c_when_227_6_saved_out = out;
                            while (_jettag_c_when_227_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 227, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 227, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_227_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_227_6_saved_out;
                            _jettag_c_when_227_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_229_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_229_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_229_6.setRuntimeParent(_jettag_c_choose_218_5);
                            _jettag_c_when_229_6.setTagInfo(_td_c_when_229_6);
                            _jettag_c_when_229_6.doStart(context, out);
                            JET2Writer _jettag_c_when_229_6_saved_out = out;
                            while (_jettag_c_when_229_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 229, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 229, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_229_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_229_6_saved_out;
                            _jettag_c_when_229_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_231_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_231_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_231_6.setRuntimeParent(_jettag_c_choose_218_5);
                            _jettag_c_when_231_6.setTagInfo(_td_c_when_231_6);
                            _jettag_c_when_231_6.doStart(context, out);
                            JET2Writer _jettag_c_when_231_6_saved_out = out;
                            while (_jettag_c_when_231_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 231, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 231, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_231_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_231_6_saved_out;
                            _jettag_c_when_231_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_233_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_233_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_233_6.setRuntimeParent(_jettag_c_choose_218_5);
                            _jettag_c_when_233_6.setTagInfo(_td_c_when_233_6);
                            _jettag_c_when_233_6.doStart(context, out);
                            JET2Writer _jettag_c_when_233_6_saved_out = out;
                            while (_jettag_c_when_233_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 233, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 233, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_233_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_233_6_saved_out;
                            _jettag_c_when_233_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_235_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_235_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_235_6.setRuntimeParent(_jettag_c_choose_218_5);
                            _jettag_c_when_235_6.setTagInfo(_td_c_when_235_6);
                            _jettag_c_when_235_6.doStart(context, out);
                            JET2Writer _jettag_c_when_235_6_saved_out = out;
                            while (_jettag_c_when_235_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 235, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 235, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_235_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_235_6_saved_out;
                            _jettag_c_when_235_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_237_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_237_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_237_7.setRuntimeParent(_jettag_c_choose_218_5);
                            _jettag_c_otherwise_237_7.setTagInfo(_td_c_otherwise_237_7);
                            _jettag_c_otherwise_237_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_237_7_saved_out = out;
                            while (_jettag_c_otherwise_237_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_238_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_238_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_238_8.setRuntimeParent(_jettag_c_otherwise_237_7);
                                _jettag_c_iterate_238_8.setTagInfo(_td_c_iterate_238_8);
                                _jettag_c_iterate_238_8.doStart(context, out);
                                while (_jettag_c_iterate_238_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_239_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_239_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_239_10.setRuntimeParent(_jettag_c_iterate_238_8);
                                    _jettag_c_if_239_10.setTagInfo(_td_c_if_239_10);
                                    _jettag_c_if_239_10.doStart(context, out);
                                    while (_jettag_c_if_239_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 240, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", false, ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 240, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(", \"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 240, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 240, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".class.getName());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_239_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_239_10.doEnd();
                                    _jettag_c_iterate_238_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_238_8.doEnd();
                                _jettag_c_otherwise_237_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_237_7_saved_out;
                            _jettag_c_otherwise_237_7.doEnd();
                            _jettag_c_choose_218_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_218_5_saved_out;
                        _jettag_c_choose_218_5.doEnd();
                        _jettag_c_iterate_217_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_217_5.doEnd();
                    _jettag_c_if_216_2.handleBodyContent(out);
                }
                _jettag_c_if_216_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_248_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_248_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_248_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_248_2.setTagInfo(_td_c_if_248_2);
                _jettag_c_if_248_2.doStart(context, out);
                while (_jettag_c_if_248_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_249_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_249_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_249_5.setRuntimeParent(_jettag_c_if_248_2);
                    _jettag_c_iterate_249_5.setTagInfo(_td_c_iterate_249_5);
                    _jettag_c_iterate_249_5.doStart(context, out);
                    while (_jettag_c_iterate_249_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_250_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_250_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_250_5.setRuntimeParent(_jettag_c_iterate_249_5);
                        _jettag_c_choose_250_5.setTagInfo(_td_c_choose_250_5);
                        _jettag_c_choose_250_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_250_5_saved_out = out;
                        while (_jettag_c_choose_250_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_251_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_251_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_251_6.setRuntimeParent(_jettag_c_choose_250_5);
                            _jettag_c_when_251_6.setTagInfo(_td_c_when_251_6);
                            _jettag_c_when_251_6.doStart(context, out);
                            JET2Writer _jettag_c_when_251_6_saved_out = out;
                            while (_jettag_c_when_251_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 251, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 251, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_251_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_251_6_saved_out;
                            _jettag_c_when_251_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_253_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_253_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_253_6.setRuntimeParent(_jettag_c_choose_250_5);
                            _jettag_c_when_253_6.setTagInfo(_td_c_when_253_6);
                            _jettag_c_when_253_6.doStart(context, out);
                            JET2Writer _jettag_c_when_253_6_saved_out = out;
                            while (_jettag_c_when_253_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 253, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 253, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_253_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_253_6_saved_out;
                            _jettag_c_when_253_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_255_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_255_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_255_6.setRuntimeParent(_jettag_c_choose_250_5);
                            _jettag_c_when_255_6.setTagInfo(_td_c_when_255_6);
                            _jettag_c_when_255_6.doStart(context, out);
                            JET2Writer _jettag_c_when_255_6_saved_out = out;
                            while (_jettag_c_when_255_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 255, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 255, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_255_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_255_6_saved_out;
                            _jettag_c_when_255_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_257_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_257_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_257_6.setRuntimeParent(_jettag_c_choose_250_5);
                            _jettag_c_when_257_6.setTagInfo(_td_c_when_257_6);
                            _jettag_c_when_257_6.doStart(context, out);
                            JET2Writer _jettag_c_when_257_6_saved_out = out;
                            while (_jettag_c_when_257_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 257, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 257, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_257_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_257_6_saved_out;
                            _jettag_c_when_257_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_259_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_259_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_259_6.setRuntimeParent(_jettag_c_choose_250_5);
                            _jettag_c_when_259_6.setTagInfo(_td_c_when_259_6);
                            _jettag_c_when_259_6.doStart(context, out);
                            JET2Writer _jettag_c_when_259_6_saved_out = out;
                            while (_jettag_c_when_259_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 259, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 259, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_259_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_259_6_saved_out;
                            _jettag_c_when_259_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_261_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_261_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_261_6.setRuntimeParent(_jettag_c_choose_250_5);
                            _jettag_c_when_261_6.setTagInfo(_td_c_when_261_6);
                            _jettag_c_when_261_6.doStart(context, out);
                            JET2Writer _jettag_c_when_261_6_saved_out = out;
                            while (_jettag_c_when_261_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 261, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 261, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_261_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_261_6_saved_out;
                            _jettag_c_when_261_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_263_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_263_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_263_6.setRuntimeParent(_jettag_c_choose_250_5);
                            _jettag_c_when_263_6.setTagInfo(_td_c_when_263_6);
                            _jettag_c_when_263_6.doStart(context, out);
                            JET2Writer _jettag_c_when_263_6_saved_out = out;
                            while (_jettag_c_when_263_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 263, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 263, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_263_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_263_6_saved_out;
                            _jettag_c_when_263_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_265_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_265_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_265_6.setRuntimeParent(_jettag_c_choose_250_5);
                            _jettag_c_when_265_6.setTagInfo(_td_c_when_265_6);
                            _jettag_c_when_265_6.doStart(context, out);
                            JET2Writer _jettag_c_when_265_6_saved_out = out;
                            while (_jettag_c_when_265_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 265, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 265, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_265_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_265_6_saved_out;
                            _jettag_c_when_265_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_267_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_267_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_267_6.setRuntimeParent(_jettag_c_choose_250_5);
                            _jettag_c_when_267_6.setTagInfo(_td_c_when_267_6);
                            _jettag_c_when_267_6.doStart(context, out);
                            JET2Writer _jettag_c_when_267_6_saved_out = out;
                            while (_jettag_c_when_267_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 267, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 267, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_267_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_267_6_saved_out;
                            _jettag_c_when_267_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_269_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_269_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_269_7.setRuntimeParent(_jettag_c_choose_250_5);
                            _jettag_c_otherwise_269_7.setTagInfo(_td_c_otherwise_269_7);
                            _jettag_c_otherwise_269_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_269_7_saved_out = out;
                            while (_jettag_c_otherwise_269_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_270_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_270_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_270_8.setRuntimeParent(_jettag_c_otherwise_269_7);
                                _jettag_c_iterate_270_8.setTagInfo(_td_c_iterate_270_8);
                                _jettag_c_iterate_270_8.doStart(context, out);
                                while (_jettag_c_iterate_270_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_271_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_271_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_271_10.setRuntimeParent(_jettag_c_iterate_270_8);
                                    _jettag_c_if_271_10.setTagInfo(_td_c_if_271_10);
                                    _jettag_c_if_271_10.doStart(context, out);
                                    while (_jettag_c_if_271_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 272, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", false, ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 272, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(", \"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 272, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 272, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".class.getName());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_271_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_271_10.doEnd();
                                    _jettag_c_iterate_270_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_270_8.doEnd();
                                _jettag_c_otherwise_269_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_269_7_saved_out;
                            _jettag_c_otherwise_269_7.doEnd();
                            _jettag_c_choose_250_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_250_5_saved_out;
                        _jettag_c_choose_250_5.doEnd();
                        _jettag_c_iterate_249_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_249_5.doEnd();
                    _jettag_c_if_248_2.handleBodyContent(out);
                }
                _jettag_c_if_248_2.doEnd();
                //process premitive data types of base current class 
                RuntimeTagElement _jettag_c_iterate_280_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_280_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_280_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_280_4.setTagInfo(_td_c_iterate_280_4);
                _jettag_c_iterate_280_4.doStart(context, out);
                while (_jettag_c_iterate_280_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_281_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_281_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_281_5.setRuntimeParent(_jettag_c_iterate_280_4);
                    _jettag_c_choose_281_5.setTagInfo(_td_c_choose_281_5);
                    _jettag_c_choose_281_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_281_5_saved_out = out;
                    while (_jettag_c_choose_281_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_282_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_282_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_282_6.setRuntimeParent(_jettag_c_choose_281_5);
                        _jettag_c_when_282_6.setTagInfo(_td_c_when_282_6);
                        _jettag_c_when_282_6.doStart(context, out);
                        JET2Writer _jettag_c_when_282_6_saved_out = out;
                        while (_jettag_c_when_282_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 282, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 282, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_282_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_282_6_saved_out;
                        _jettag_c_when_282_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_284_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_284_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_284_6.setRuntimeParent(_jettag_c_choose_281_5);
                        _jettag_c_when_284_6.setTagInfo(_td_c_when_284_6);
                        _jettag_c_when_284_6.doStart(context, out);
                        JET2Writer _jettag_c_when_284_6_saved_out = out;
                        while (_jettag_c_when_284_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 284, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 284, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_284_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_284_6_saved_out;
                        _jettag_c_when_284_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_286_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_286_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_286_6.setRuntimeParent(_jettag_c_choose_281_5);
                        _jettag_c_when_286_6.setTagInfo(_td_c_when_286_6);
                        _jettag_c_when_286_6.doStart(context, out);
                        JET2Writer _jettag_c_when_286_6_saved_out = out;
                        while (_jettag_c_when_286_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 286, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 286, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_286_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_286_6_saved_out;
                        _jettag_c_when_286_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_288_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_288_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_288_6.setRuntimeParent(_jettag_c_choose_281_5);
                        _jettag_c_when_288_6.setTagInfo(_td_c_when_288_6);
                        _jettag_c_when_288_6.doStart(context, out);
                        JET2Writer _jettag_c_when_288_6_saved_out = out;
                        while (_jettag_c_when_288_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 288, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 288, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_288_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_288_6_saved_out;
                        _jettag_c_when_288_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_290_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_290_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_290_6.setRuntimeParent(_jettag_c_choose_281_5);
                        _jettag_c_when_290_6.setTagInfo(_td_c_when_290_6);
                        _jettag_c_when_290_6.doStart(context, out);
                        JET2Writer _jettag_c_when_290_6_saved_out = out;
                        while (_jettag_c_when_290_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 290, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 290, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_290_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_290_6_saved_out;
                        _jettag_c_when_290_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_292_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_292_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_292_6.setRuntimeParent(_jettag_c_choose_281_5);
                        _jettag_c_when_292_6.setTagInfo(_td_c_when_292_6);
                        _jettag_c_when_292_6.doStart(context, out);
                        JET2Writer _jettag_c_when_292_6_saved_out = out;
                        while (_jettag_c_when_292_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 292, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 292, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_292_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_292_6_saved_out;
                        _jettag_c_when_292_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_294_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_294_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_294_6.setRuntimeParent(_jettag_c_choose_281_5);
                        _jettag_c_when_294_6.setTagInfo(_td_c_when_294_6);
                        _jettag_c_when_294_6.doStart(context, out);
                        JET2Writer _jettag_c_when_294_6_saved_out = out;
                        while (_jettag_c_when_294_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 294, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 294, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_294_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_294_6_saved_out;
                        _jettag_c_when_294_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_296_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_296_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_296_6.setRuntimeParent(_jettag_c_choose_281_5);
                        _jettag_c_when_296_6.setTagInfo(_td_c_when_296_6);
                        _jettag_c_when_296_6.doStart(context, out);
                        JET2Writer _jettag_c_when_296_6_saved_out = out;
                        while (_jettag_c_when_296_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 296, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 296, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_296_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_296_6_saved_out;
                        _jettag_c_when_296_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_298_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_298_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_298_6.setRuntimeParent(_jettag_c_choose_281_5);
                        _jettag_c_when_298_6.setTagInfo(_td_c_when_298_6);
                        _jettag_c_when_298_6.doStart(context, out);
                        JET2Writer _jettag_c_when_298_6_saved_out = out;
                        while (_jettag_c_when_298_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 298, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 298, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_298_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_298_6_saved_out;
                        _jettag_c_when_298_6.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_300_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_300_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_300_7.setRuntimeParent(_jettag_c_choose_281_5);
                        _jettag_c_otherwise_300_7.setTagInfo(_td_c_otherwise_300_7);
                        _jettag_c_otherwise_300_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_300_7_saved_out = out;
                        while (_jettag_c_otherwise_300_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_301_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_301_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_301_8.setRuntimeParent(_jettag_c_otherwise_300_7);
                            _jettag_c_iterate_301_8.setTagInfo(_td_c_iterate_301_8);
                            _jettag_c_iterate_301_8.doStart(context, out);
                            while (_jettag_c_iterate_301_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_302_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_302_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_302_10.setRuntimeParent(_jettag_c_iterate_301_8);
                                _jettag_c_if_302_10.setTagInfo(_td_c_if_302_10);
                                _jettag_c_if_302_10.doStart(context, out);
                                while (_jettag_c_if_302_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 303, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", false, ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 303, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(", \"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 303, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 303, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".class.getName());");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_302_10.handleBodyContent(out);
                                }
                                _jettag_c_if_302_10.doEnd();
                                _jettag_c_iterate_301_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_301_8.doEnd();
                            _jettag_c_otherwise_300_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_300_7_saved_out;
                        _jettag_c_otherwise_300_7.doEnd();
                        _jettag_c_choose_281_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_281_5_saved_out;
                    _jettag_c_choose_281_5.doEnd();
                    _jettag_c_iterate_280_4.handleBodyContent(out);
                }
                _jettag_c_iterate_280_4.doEnd();
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process dropdowns one to one and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_311_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_311_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_311_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_311_4.setTagInfo(_td_c_iterate_311_4);
                _jettag_c_iterate_311_4.doStart(context, out);
                while (_jettag_c_iterate_311_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_312_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_312_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_312_5.setRuntimeParent(_jettag_c_iterate_311_4);
                    _jettag_c_iterate_312_5.setTagInfo(_td_c_iterate_312_5);
                    _jettag_c_iterate_312_5.doStart(context, out);
                    while (_jettag_c_iterate_312_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_313_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_313_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_313_6.setRuntimeParent(_jettag_c_iterate_312_5);
                        _jettag_c_iterate_313_6.setTagInfo(_td_c_iterate_313_6);
                        _jettag_c_iterate_313_6.doStart(context, out);
                        while (_jettag_c_iterate_313_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_314_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_314_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_314_7.setRuntimeParent(_jettag_c_iterate_313_6);
                            _jettag_c_setVariable_314_7.setTagInfo(_td_c_setVariable_314_7);
                            _jettag_c_setVariable_314_7.doStart(context, out);
                            _jettag_c_setVariable_314_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_316_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_316_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_316_9.setRuntimeParent(_jettag_c_iterate_313_6);
                            _jettag_c_if_316_9.setTagInfo(_td_c_if_316_9);
                            _jettag_c_if_316_9.doStart(context, out);
                            while (_jettag_c_if_316_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_318_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_318_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_318_15.setRuntimeParent(_jettag_c_if_316_9);
                                _jettag_c_iterate_318_15.setTagInfo(_td_c_iterate_318_15);
                                _jettag_c_iterate_318_15.doStart(context, out);
                                while (_jettag_c_iterate_318_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_319_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_319_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_319_15.setRuntimeParent(_jettag_c_iterate_318_15);
                                    _jettag_c_setVariable_319_15.setTagInfo(_td_c_setVariable_319_15);
                                    _jettag_c_setVariable_319_15.doStart(context, out);
                                    _jettag_c_setVariable_319_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_321_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_321_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_321_17.setRuntimeParent(_jettag_c_iterate_318_15);
                                    _jettag_c_if_321_17.setTagInfo(_td_c_if_321_17);
                                    _jettag_c_if_321_17.doStart(context, out);
                                    while (_jettag_c_if_321_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_323_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_323_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_323_18.setRuntimeParent(_jettag_c_if_321_17);
                                        _jettag_c_iterate_323_18.setTagInfo(_td_c_iterate_323_18);
                                        _jettag_c_iterate_323_18.doStart(context, out);
                                        while (_jettag_c_iterate_323_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_324_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_324_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_324_19.setRuntimeParent(_jettag_c_iterate_323_18);
                                            _jettag_c_if_324_19.setTagInfo(_td_c_if_324_19);
                                            _jettag_c_if_324_19.doStart(context, out);
                                            while (_jettag_c_if_324_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_327_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_327_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_327_19.setRuntimeParent(_jettag_c_if_324_19);
                                                _jettag_c_if_327_19.setTagInfo(_td_c_if_327_19);
                                                _jettag_c_if_327_19.doStart(context, out);
                                                while (_jettag_c_if_327_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_328_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_328_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_328_21.setRuntimeParent(_jettag_c_if_327_19);
                                                    _jettag_c_if_328_21.setTagInfo(_td_c_if_328_21);
                                                    _jettag_c_if_328_21.doStart(context, out);
                                                    while (_jettag_c_if_328_21.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_330_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_330_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_330_18.setRuntimeParent(_jettag_c_if_328_21);
                                                        _jettag_c_if_330_18.setTagInfo(_td_c_if_330_18);
                                                        _jettag_c_if_330_18.doStart(context, out);
                                                        while (_jettag_c_if_330_18.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\taddDropDown(select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 331, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_330_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_330_18.doEnd();
                                                        _jettag_c_if_328_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_328_21.doEnd();
                                                    _jettag_c_if_327_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_327_19.doEnd();
                                                _jettag_c_if_324_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_324_19.doEnd();
                                            _jettag_c_iterate_323_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_323_18.doEnd();
                                        _jettag_c_if_321_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_321_17.doEnd();
                                    _jettag_c_iterate_318_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_318_15.doEnd();
                                _jettag_c_if_316_9.handleBodyContent(out);
                            }
                            _jettag_c_if_316_9.doEnd();
                            _jettag_c_iterate_313_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_313_6.doEnd();
                        _jettag_c_iterate_312_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_312_5.doEnd();
                    _jettag_c_iterate_311_4.handleBodyContent(out);
                }
                _jettag_c_iterate_311_4.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_344_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_344_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_344_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_344_1.setTagInfo(_td_f_message_344_1);
                _jettag_f_message_344_1.doStart(context, out);
                JET2Writer _jettag_f_message_344_1_saved_out = out;
                while (_jettag_f_message_344_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_344_1.handleBodyContent(out);
                }
                out = _jettag_f_message_344_1_saved_out;
                _jettag_f_message_344_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 346, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" populateEntityFromFields() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 347, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 347, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" = new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 347, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("();");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_349_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_349_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_349_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_349_2.setTagInfo(_td_c_if_349_2);
                _jettag_c_if_349_2.doStart(context, out);
                while (_jettag_c_if_349_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_350_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_350_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_350_3.setRuntimeParent(_jettag_c_if_349_2);
                    _jettag_c_iterate_350_3.setTagInfo(_td_c_iterate_350_3);
                    _jettag_c_iterate_350_3.doStart(context, out);
                    while (_jettag_c_iterate_350_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_351_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_351_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_351_4.setRuntimeParent(_jettag_c_iterate_350_3);
                        _jettag_c_choose_351_4.setTagInfo(_td_c_choose_351_4);
                        _jettag_c_choose_351_4.doStart(context, out);
                        JET2Writer _jettag_c_choose_351_4_saved_out = out;
                        while (_jettag_c_choose_351_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_352_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_352_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_352_5.setRuntimeParent(_jettag_c_choose_351_4);
                            _jettag_c_when_352_5.setTagInfo(_td_c_when_352_5);
                            _jettag_c_when_352_5.doStart(context, out);
                            JET2Writer _jettag_c_when_352_5_saved_out = out;
                            while (_jettag_c_when_352_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 352, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 352, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getStringField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 352, 121)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_352_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_352_5_saved_out;
                            _jettag_c_when_352_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_354_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_354_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_354_5.setRuntimeParent(_jettag_c_choose_351_4);
                            _jettag_c_when_354_5.setTagInfo(_td_c_when_354_5);
                            _jettag_c_when_354_5.doStart(context, out);
                            JET2Writer _jettag_c_when_354_5_saved_out = out;
                            while (_jettag_c_when_354_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 354, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 354, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 354, 123)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_354_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_354_5_saved_out;
                            _jettag_c_when_354_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_356_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_356_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_356_5.setRuntimeParent(_jettag_c_choose_351_4);
                            _jettag_c_when_356_5.setTagInfo(_td_c_when_356_5);
                            _jettag_c_when_356_5.doStart(context, out);
                            JET2Writer _jettag_c_when_356_5_saved_out = out;
                            while (_jettag_c_when_356_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 356, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 356, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getDateField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 356, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_356_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_356_5_saved_out;
                            _jettag_c_when_356_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_358_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_358_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_358_5.setRuntimeParent(_jettag_c_choose_351_4);
                            _jettag_c_when_358_5.setTagInfo(_td_c_when_358_5);
                            _jettag_c_when_358_5.doStart(context, out);
                            JET2Writer _jettag_c_when_358_5_saved_out = out;
                            while (_jettag_c_when_358_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 358, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 358, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 358, 122)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_358_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_358_5_saved_out;
                            _jettag_c_when_358_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_360_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_360_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_360_5.setRuntimeParent(_jettag_c_choose_351_4);
                            _jettag_c_when_360_5.setTagInfo(_td_c_when_360_5);
                            _jettag_c_when_360_5.doStart(context, out);
                            JET2Writer _jettag_c_when_360_5_saved_out = out;
                            while (_jettag_c_when_360_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 360, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 360, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getLongField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 360, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_360_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_360_5_saved_out;
                            _jettag_c_when_360_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_362_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_362_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_362_5.setRuntimeParent(_jettag_c_choose_351_4);
                            _jettag_c_when_362_5.setTagInfo(_td_c_when_362_5);
                            _jettag_c_when_362_5.doStart(context, out);
                            JET2Writer _jettag_c_when_362_5_saved_out = out;
                            while (_jettag_c_when_362_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 362, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 362, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getFloatField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 362, 119)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_362_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_362_5_saved_out;
                            _jettag_c_when_362_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_364_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_364_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_364_5.setRuntimeParent(_jettag_c_choose_351_4);
                            _jettag_c_when_364_5.setTagInfo(_td_c_when_364_5);
                            _jettag_c_when_364_5.doStart(context, out);
                            JET2Writer _jettag_c_when_364_5_saved_out = out;
                            while (_jettag_c_when_364_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 364, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 364, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 364, 119)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_364_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_364_5_saved_out;
                            _jettag_c_when_364_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_366_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_366_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_366_5.setRuntimeParent(_jettag_c_choose_351_4);
                            _jettag_c_when_366_5.setTagInfo(_td_c_when_366_5);
                            _jettag_c_when_366_5.doStart(context, out);
                            JET2Writer _jettag_c_when_366_5_saved_out = out;
                            while (_jettag_c_when_366_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 366, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 366, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 366, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_366_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_366_5_saved_out;
                            _jettag_c_when_366_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_368_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_368_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_368_5.setRuntimeParent(_jettag_c_choose_351_4);
                            _jettag_c_when_368_5.setTagInfo(_td_c_when_368_5);
                            _jettag_c_when_368_5.doStart(context, out);
                            JET2Writer _jettag_c_when_368_5_saved_out = out;
                            while (_jettag_c_when_368_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 368, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 368, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 368, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_368_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_368_5_saved_out;
                            _jettag_c_when_368_5.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_370_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_370_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_370_6.setRuntimeParent(_jettag_c_choose_351_4);
                            _jettag_c_otherwise_370_6.setTagInfo(_td_c_otherwise_370_6);
                            _jettag_c_otherwise_370_6.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_370_6_saved_out = out;
                            while (_jettag_c_otherwise_370_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_371_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_371_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_371_8.setRuntimeParent(_jettag_c_otherwise_370_6);
                                _jettag_c_iterate_371_8.setTagInfo(_td_c_iterate_371_8);
                                _jettag_c_iterate_371_8.doStart(context, out);
                                while (_jettag_c_iterate_371_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_372_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_372_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_372_10.setRuntimeParent(_jettag_c_iterate_371_8);
                                    _jettag_c_if_372_10.setTagInfo(_td_c_if_372_10);
                                    _jettag_c_if_372_10.doStart(context, out);
                                    while (_jettag_c_if_372_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 373, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".set");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 373, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("(");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 373, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".valueOf(getEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 373, 138)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\")));");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_372_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_372_10.doEnd();
                                    _jettag_c_iterate_371_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_371_8.doEnd();
                                _jettag_c_otherwise_370_6.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_370_6_saved_out;
                            _jettag_c_otherwise_370_6.doEnd();
                            _jettag_c_choose_351_4.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_351_4_saved_out;
                        _jettag_c_choose_351_4.doEnd();
                        _jettag_c_iterate_350_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_350_3.doEnd();
                    out.write(NL);         
                    _jettag_c_if_349_2.handleBodyContent(out);
                }
                _jettag_c_if_349_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_382_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_382_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_382_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_382_2.setTagInfo(_td_c_if_382_2);
                _jettag_c_if_382_2.doStart(context, out);
                while (_jettag_c_if_382_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_383_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_383_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_383_3.setRuntimeParent(_jettag_c_if_382_2);
                    _jettag_c_iterate_383_3.setTagInfo(_td_c_iterate_383_3);
                    _jettag_c_iterate_383_3.doStart(context, out);
                    while (_jettag_c_iterate_383_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_384_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_384_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_384_4.setRuntimeParent(_jettag_c_iterate_383_3);
                        _jettag_c_choose_384_4.setTagInfo(_td_c_choose_384_4);
                        _jettag_c_choose_384_4.doStart(context, out);
                        JET2Writer _jettag_c_choose_384_4_saved_out = out;
                        while (_jettag_c_choose_384_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_385_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_385_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_385_5.setRuntimeParent(_jettag_c_choose_384_4);
                            _jettag_c_when_385_5.setTagInfo(_td_c_when_385_5);
                            _jettag_c_when_385_5.doStart(context, out);
                            JET2Writer _jettag_c_when_385_5_saved_out = out;
                            while (_jettag_c_when_385_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 385, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 385, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getStringField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 385, 121)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_385_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_385_5_saved_out;
                            _jettag_c_when_385_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_387_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_387_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_387_5.setRuntimeParent(_jettag_c_choose_384_4);
                            _jettag_c_when_387_5.setTagInfo(_td_c_when_387_5);
                            _jettag_c_when_387_5.doStart(context, out);
                            JET2Writer _jettag_c_when_387_5_saved_out = out;
                            while (_jettag_c_when_387_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 387, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 387, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 387, 123)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_387_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_387_5_saved_out;
                            _jettag_c_when_387_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_389_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_389_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_389_5.setRuntimeParent(_jettag_c_choose_384_4);
                            _jettag_c_when_389_5.setTagInfo(_td_c_when_389_5);
                            _jettag_c_when_389_5.doStart(context, out);
                            JET2Writer _jettag_c_when_389_5_saved_out = out;
                            while (_jettag_c_when_389_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 389, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 389, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getDateField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 389, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_389_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_389_5_saved_out;
                            _jettag_c_when_389_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_391_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_391_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_391_5.setRuntimeParent(_jettag_c_choose_384_4);
                            _jettag_c_when_391_5.setTagInfo(_td_c_when_391_5);
                            _jettag_c_when_391_5.doStart(context, out);
                            JET2Writer _jettag_c_when_391_5_saved_out = out;
                            while (_jettag_c_when_391_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 391, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 391, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 391, 122)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_391_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_391_5_saved_out;
                            _jettag_c_when_391_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_393_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_393_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_393_5.setRuntimeParent(_jettag_c_choose_384_4);
                            _jettag_c_when_393_5.setTagInfo(_td_c_when_393_5);
                            _jettag_c_when_393_5.doStart(context, out);
                            JET2Writer _jettag_c_when_393_5_saved_out = out;
                            while (_jettag_c_when_393_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 393, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 393, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getLongField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 393, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_393_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_393_5_saved_out;
                            _jettag_c_when_393_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_395_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_395_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_395_5.setRuntimeParent(_jettag_c_choose_384_4);
                            _jettag_c_when_395_5.setTagInfo(_td_c_when_395_5);
                            _jettag_c_when_395_5.doStart(context, out);
                            JET2Writer _jettag_c_when_395_5_saved_out = out;
                            while (_jettag_c_when_395_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 395, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 395, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getFloatField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 395, 119)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_395_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_395_5_saved_out;
                            _jettag_c_when_395_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_397_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_397_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_397_5.setRuntimeParent(_jettag_c_choose_384_4);
                            _jettag_c_when_397_5.setTagInfo(_td_c_when_397_5);
                            _jettag_c_when_397_5.doStart(context, out);
                            JET2Writer _jettag_c_when_397_5_saved_out = out;
                            while (_jettag_c_when_397_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 397, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 397, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 397, 119)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_397_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_397_5_saved_out;
                            _jettag_c_when_397_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_399_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_399_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_399_5.setRuntimeParent(_jettag_c_choose_384_4);
                            _jettag_c_when_399_5.setTagInfo(_td_c_when_399_5);
                            _jettag_c_when_399_5.doStart(context, out);
                            JET2Writer _jettag_c_when_399_5_saved_out = out;
                            while (_jettag_c_when_399_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 399, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 399, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 399, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_399_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_399_5_saved_out;
                            _jettag_c_when_399_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_401_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_401_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_401_5.setRuntimeParent(_jettag_c_choose_384_4);
                            _jettag_c_when_401_5.setTagInfo(_td_c_when_401_5);
                            _jettag_c_when_401_5.doStart(context, out);
                            JET2Writer _jettag_c_when_401_5_saved_out = out;
                            while (_jettag_c_when_401_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 401, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 401, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 401, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_401_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_401_5_saved_out;
                            _jettag_c_when_401_5.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_403_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_403_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_403_6.setRuntimeParent(_jettag_c_choose_384_4);
                            _jettag_c_otherwise_403_6.setTagInfo(_td_c_otherwise_403_6);
                            _jettag_c_otherwise_403_6.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_403_6_saved_out = out;
                            while (_jettag_c_otherwise_403_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_404_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_404_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_404_8.setRuntimeParent(_jettag_c_otherwise_403_6);
                                _jettag_c_iterate_404_8.setTagInfo(_td_c_iterate_404_8);
                                _jettag_c_iterate_404_8.doStart(context, out);
                                while (_jettag_c_iterate_404_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_405_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_405_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_405_10.setRuntimeParent(_jettag_c_iterate_404_8);
                                    _jettag_c_if_405_10.setTagInfo(_td_c_if_405_10);
                                    _jettag_c_if_405_10.doStart(context, out);
                                    while (_jettag_c_if_405_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 406, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".set");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 406, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("(");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 406, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".valueOf(getEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 406, 138)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\")));");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_405_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_405_10.doEnd();
                                    _jettag_c_iterate_404_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_404_8.doEnd();
                                _jettag_c_otherwise_403_6.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_403_6_saved_out;
                            _jettag_c_otherwise_403_6.doEnd();
                            _jettag_c_choose_384_4.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_384_4_saved_out;
                        _jettag_c_choose_384_4.doEnd();
                        _jettag_c_iterate_383_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_383_3.doEnd();
                    _jettag_c_if_382_2.handleBodyContent(out);
                }
                _jettag_c_if_382_2.doEnd();
                // process base class 
                RuntimeTagElement _jettag_c_iterate_414_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_414_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_414_3.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_414_3.setTagInfo(_td_c_iterate_414_3);
                _jettag_c_iterate_414_3.doStart(context, out);
                while (_jettag_c_iterate_414_3.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_415_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_415_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_415_4.setRuntimeParent(_jettag_c_iterate_414_3);
                    _jettag_c_choose_415_4.setTagInfo(_td_c_choose_415_4);
                    _jettag_c_choose_415_4.doStart(context, out);
                    JET2Writer _jettag_c_choose_415_4_saved_out = out;
                    while (_jettag_c_choose_415_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_416_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_416_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_416_5.setRuntimeParent(_jettag_c_choose_415_4);
                        _jettag_c_when_416_5.setTagInfo(_td_c_when_416_5);
                        _jettag_c_when_416_5.doStart(context, out);
                        JET2Writer _jettag_c_when_416_5_saved_out = out;
                        while (_jettag_c_when_416_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 416, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 416, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getStringField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 416, 121)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_416_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_416_5_saved_out;
                        _jettag_c_when_416_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_418_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_418_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_418_5.setRuntimeParent(_jettag_c_choose_415_4);
                        _jettag_c_when_418_5.setTagInfo(_td_c_when_418_5);
                        _jettag_c_when_418_5.doStart(context, out);
                        JET2Writer _jettag_c_when_418_5_saved_out = out;
                        while (_jettag_c_when_418_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 418, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 418, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 418, 123)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_418_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_418_5_saved_out;
                        _jettag_c_when_418_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_420_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_420_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_420_5.setRuntimeParent(_jettag_c_choose_415_4);
                        _jettag_c_when_420_5.setTagInfo(_td_c_when_420_5);
                        _jettag_c_when_420_5.doStart(context, out);
                        JET2Writer _jettag_c_when_420_5_saved_out = out;
                        while (_jettag_c_when_420_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 420, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 420, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getDateField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 420, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_420_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_420_5_saved_out;
                        _jettag_c_when_420_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_422_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_422_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_422_5.setRuntimeParent(_jettag_c_choose_415_4);
                        _jettag_c_when_422_5.setTagInfo(_td_c_when_422_5);
                        _jettag_c_when_422_5.doStart(context, out);
                        JET2Writer _jettag_c_when_422_5_saved_out = out;
                        while (_jettag_c_when_422_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 422, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 422, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 422, 122)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_422_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_422_5_saved_out;
                        _jettag_c_when_422_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_424_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_424_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_424_5.setRuntimeParent(_jettag_c_choose_415_4);
                        _jettag_c_when_424_5.setTagInfo(_td_c_when_424_5);
                        _jettag_c_when_424_5.doStart(context, out);
                        JET2Writer _jettag_c_when_424_5_saved_out = out;
                        while (_jettag_c_when_424_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 424, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 424, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getLongField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 424, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_424_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_424_5_saved_out;
                        _jettag_c_when_424_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_426_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_426_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_426_5.setRuntimeParent(_jettag_c_choose_415_4);
                        _jettag_c_when_426_5.setTagInfo(_td_c_when_426_5);
                        _jettag_c_when_426_5.doStart(context, out);
                        JET2Writer _jettag_c_when_426_5_saved_out = out;
                        while (_jettag_c_when_426_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 426, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 426, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getFloatField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 426, 119)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_426_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_426_5_saved_out;
                        _jettag_c_when_426_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_428_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_428_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_428_5.setRuntimeParent(_jettag_c_choose_415_4);
                        _jettag_c_when_428_5.setTagInfo(_td_c_when_428_5);
                        _jettag_c_when_428_5.doStart(context, out);
                        JET2Writer _jettag_c_when_428_5_saved_out = out;
                        while (_jettag_c_when_428_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 428, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 428, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getImageField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 428, 119)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_428_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_428_5_saved_out;
                        _jettag_c_when_428_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_430_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_430_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_430_5.setRuntimeParent(_jettag_c_choose_415_4);
                        _jettag_c_when_430_5.setTagInfo(_td_c_when_430_5);
                        _jettag_c_when_430_5.doStart(context, out);
                        JET2Writer _jettag_c_when_430_5_saved_out = out;
                        while (_jettag_c_when_430_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 430, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 430, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getRichTextField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 430, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_430_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_430_5_saved_out;
                        _jettag_c_when_430_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_432_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_432_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_432_5.setRuntimeParent(_jettag_c_choose_415_4);
                        _jettag_c_when_432_5.setTagInfo(_td_c_when_432_5);
                        _jettag_c_when_432_5.doStart(context, out);
                        JET2Writer _jettag_c_when_432_5_saved_out = out;
                        while (_jettag_c_when_432_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 432, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 432, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 432, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_432_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_432_5_saved_out;
                        _jettag_c_when_432_5.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_434_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_434_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_434_6.setRuntimeParent(_jettag_c_choose_415_4);
                        _jettag_c_otherwise_434_6.setTagInfo(_td_c_otherwise_434_6);
                        _jettag_c_otherwise_434_6.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_434_6_saved_out = out;
                        while (_jettag_c_otherwise_434_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_435_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_435_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_435_8.setRuntimeParent(_jettag_c_otherwise_434_6);
                            _jettag_c_iterate_435_8.setTagInfo(_td_c_iterate_435_8);
                            _jettag_c_iterate_435_8.doStart(context, out);
                            while (_jettag_c_iterate_435_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_436_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_436_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_436_10.setRuntimeParent(_jettag_c_iterate_435_8);
                                _jettag_c_if_436_10.setTagInfo(_td_c_if_436_10);
                                _jettag_c_if_436_10.doStart(context, out);
                                while (_jettag_c_if_436_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 437, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".set");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 437, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("(");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 437, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".valueOf(getEnumField(\"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 437, 138)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\")));");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_436_10.handleBodyContent(out);
                                }
                                _jettag_c_if_436_10.doEnd();
                                _jettag_c_iterate_435_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_435_8.doEnd();
                            _jettag_c_otherwise_434_6.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_434_6_saved_out;
                        _jettag_c_otherwise_434_6.doEnd();
                        _jettag_c_choose_415_4.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_415_4_saved_out;
                    _jettag_c_choose_415_4.doEnd();
                    _jettag_c_iterate_414_3.handleBodyContent(out);
                }
                _jettag_c_iterate_414_3.doEnd();
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process dropdowns one tone and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_445_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_445_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_445_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_445_4.setTagInfo(_td_c_iterate_445_4);
                _jettag_c_iterate_445_4.doStart(context, out);
                while (_jettag_c_iterate_445_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_446_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_446_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_446_5.setRuntimeParent(_jettag_c_iterate_445_4);
                    _jettag_c_iterate_446_5.setTagInfo(_td_c_iterate_446_5);
                    _jettag_c_iterate_446_5.doStart(context, out);
                    while (_jettag_c_iterate_446_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_447_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_447_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_447_6.setRuntimeParent(_jettag_c_iterate_446_5);
                        _jettag_c_iterate_447_6.setTagInfo(_td_c_iterate_447_6);
                        _jettag_c_iterate_447_6.doStart(context, out);
                        while (_jettag_c_iterate_447_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_448_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_448_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_448_7.setRuntimeParent(_jettag_c_iterate_447_6);
                            _jettag_c_setVariable_448_7.setTagInfo(_td_c_setVariable_448_7);
                            _jettag_c_setVariable_448_7.doStart(context, out);
                            _jettag_c_setVariable_448_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_450_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_450_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_450_9.setRuntimeParent(_jettag_c_iterate_447_6);
                            _jettag_c_if_450_9.setTagInfo(_td_c_if_450_9);
                            _jettag_c_if_450_9.doStart(context, out);
                            while (_jettag_c_if_450_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_452_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_452_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_452_15.setRuntimeParent(_jettag_c_if_450_9);
                                _jettag_c_iterate_452_15.setTagInfo(_td_c_iterate_452_15);
                                _jettag_c_iterate_452_15.doStart(context, out);
                                while (_jettag_c_iterate_452_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_453_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_453_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_453_15.setRuntimeParent(_jettag_c_iterate_452_15);
                                    _jettag_c_setVariable_453_15.setTagInfo(_td_c_setVariable_453_15);
                                    _jettag_c_setVariable_453_15.doStart(context, out);
                                    _jettag_c_setVariable_453_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_455_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_455_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_455_17.setRuntimeParent(_jettag_c_iterate_452_15);
                                    _jettag_c_if_455_17.setTagInfo(_td_c_if_455_17);
                                    _jettag_c_if_455_17.doStart(context, out);
                                    while (_jettag_c_if_455_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_457_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_457_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_457_18.setRuntimeParent(_jettag_c_if_455_17);
                                        _jettag_c_iterate_457_18.setTagInfo(_td_c_iterate_457_18);
                                        _jettag_c_iterate_457_18.doStart(context, out);
                                        while (_jettag_c_iterate_457_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_458_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_458_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_458_19.setRuntimeParent(_jettag_c_iterate_457_18);
                                            _jettag_c_if_458_19.setTagInfo(_td_c_if_458_19);
                                            _jettag_c_if_458_19.doStart(context, out);
                                            while (_jettag_c_if_458_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_461_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_461_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_461_19.setRuntimeParent(_jettag_c_if_458_19);
                                                _jettag_c_if_461_19.setTagInfo(_td_c_if_461_19);
                                                _jettag_c_if_461_19.doStart(context, out);
                                                while (_jettag_c_if_461_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_462_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_462_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_462_21.setRuntimeParent(_jettag_c_if_461_19);
                                                    _jettag_c_if_462_21.setTagInfo(_td_c_if_462_21);
                                                    _jettag_c_if_462_21.doStart(context, out);
                                                    while (_jettag_c_if_462_21.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_464_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_464_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_464_18.setRuntimeParent(_jettag_c_if_462_21);
                                                        _jettag_c_if_464_18.setTagInfo(_td_c_if_464_18);
                                                        _jettag_c_if_464_18.doStart(context, out);
                                                        while (_jettag_c_if_464_18.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 465, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".set");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($class2/@name)}", 465, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("(select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 465, 92)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel.getEntity());");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_464_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_464_18.doEnd();
                                                        _jettag_c_if_462_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_462_21.doEnd();
                                                    _jettag_c_if_461_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_461_19.doEnd();
                                                _jettag_c_if_458_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_458_19.doEnd();
                                            _jettag_c_iterate_457_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_457_18.doEnd();
                                        _jettag_c_if_455_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_455_17.doEnd();
                                    _jettag_c_iterate_452_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_452_15.doEnd();
                                _jettag_c_if_450_9.handleBodyContent(out);
                            }
                            _jettag_c_if_450_9.doEnd();
                            _jettag_c_iterate_447_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_447_6.doEnd();
                        _jettag_c_iterate_446_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_446_5.doEnd();
                    _jettag_c_iterate_445_4.handleBodyContent(out);
                }
                _jettag_c_iterate_445_4.doEnd();
                out.write("\t\treturn ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 477, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_479_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_479_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_479_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_479_1.setTagInfo(_td_f_message_479_1);
                _jettag_f_message_479_1.doStart(context, out);
                JET2Writer _jettag_f_message_479_1_saved_out = out;
                while (_jettag_f_message_479_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_479_1.handleBodyContent(out);
                }
                out = _jettag_f_message_479_1_saved_out;
                _jettag_f_message_479_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void configure() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_484_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_484_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_484_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_484_1.setTagInfo(_td_f_message_484_1);
                _jettag_f_message_484_1.doStart(context, out);
                JET2Writer _jettag_f_message_484_1_saved_out = out;
                while (_jettag_f_message_484_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_484_1.handleBodyContent(out);
                }
                out = _jettag_f_message_484_1_saved_out;
                _jettag_f_message_484_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void addButtonClicked() {");  //$NON-NLS-1$        
                out.write(NL);         
                // check to see is this class is a comp first
                RuntimeTagElement _jettag_c_if_488_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_488_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_488_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_488_2.setTagInfo(_td_c_if_488_2);
                _jettag_c_if_488_2.doStart(context, out);
                while (_jettag_c_if_488_2.okToProcessBody()) {
                    // process compsition associations
                    RuntimeTagElement _jettag_c_iterate_490_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_490_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_490_2.setRuntimeParent(_jettag_c_if_488_2);
                    _jettag_c_iterate_490_2.setTagInfo(_td_c_iterate_490_2);
                    _jettag_c_iterate_490_2.doStart(context, out);
                    while (_jettag_c_iterate_490_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_491_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_491_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_491_2.setRuntimeParent(_jettag_c_iterate_490_2);
                        _jettag_c_iterate_491_2.setTagInfo(_td_c_iterate_491_2);
                        _jettag_c_iterate_491_2.doStart(context, out);
                        while (_jettag_c_iterate_491_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_492_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_492_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_492_3.setRuntimeParent(_jettag_c_iterate_491_2);
                            _jettag_c_iterate_492_3.setTagInfo(_td_c_iterate_492_3);
                            _jettag_c_iterate_492_3.doStart(context, out);
                            while (_jettag_c_iterate_492_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_493_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_493_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_493_4.setRuntimeParent(_jettag_c_iterate_492_3);
                                _jettag_c_setVariable_493_4.setTagInfo(_td_c_setVariable_493_4);
                                _jettag_c_setVariable_493_4.doStart(context, out);
                                _jettag_c_setVariable_493_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_495_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_495_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_495_6.setRuntimeParent(_jettag_c_iterate_492_3);
                                _jettag_c_if_495_6.setTagInfo(_td_c_if_495_6);
                                _jettag_c_if_495_6.doStart(context, out);
                                while (_jettag_c_if_495_6.okToProcessBody()) {
                                    // process only compositions
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_498_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_498_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_498_12.setRuntimeParent(_jettag_c_if_495_6);
                                    _jettag_c_iterate_498_12.setTagInfo(_td_c_iterate_498_12);
                                    _jettag_c_iterate_498_12.doStart(context, out);
                                    while (_jettag_c_iterate_498_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_499_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_499_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_499_12.setRuntimeParent(_jettag_c_iterate_498_12);
                                        _jettag_c_setVariable_499_12.setTagInfo(_td_c_setVariable_499_12);
                                        _jettag_c_setVariable_499_12.doStart(context, out);
                                        _jettag_c_setVariable_499_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_501_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_501_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_501_14.setRuntimeParent(_jettag_c_iterate_498_12);
                                        _jettag_c_if_501_14.setTagInfo(_td_c_if_501_14);
                                        _jettag_c_if_501_14.doStart(context, out);
                                        while (_jettag_c_if_501_14.okToProcessBody()) {
                                            // check if this is a comp
                                            RuntimeTagElement _jettag_c_if_503_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_503_14); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_503_14.setRuntimeParent(_jettag_c_if_501_14);
                                            _jettag_c_if_503_14.setTagInfo(_td_c_if_503_14);
                                            _jettag_c_if_503_14.doStart(context, out);
                                            while (_jettag_c_if_503_14.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_505_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_505_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_505_15.setRuntimeParent(_jettag_c_if_503_14);
                                                _jettag_c_iterate_505_15.setTagInfo(_td_c_iterate_505_15);
                                                _jettag_c_iterate_505_15.doStart(context, out);
                                                while (_jettag_c_iterate_505_15.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_506_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_506_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_506_16.setRuntimeParent(_jettag_c_iterate_505_15);
                                                    _jettag_c_if_506_16.setTagInfo(_td_c_if_506_16);
                                                    _jettag_c_if_506_16.doStart(context, out);
                                                    while (_jettag_c_if_506_16.okToProcessBody()) {
                                                        // check to see if class2 is parent and child
                                                        RuntimeTagElement _jettag_c_if_508_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_508_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_508_11.setRuntimeParent(_jettag_c_if_506_16);
                                                        _jettag_c_if_508_11.setTagInfo(_td_c_if_508_11);
                                                        _jettag_c_if_508_11.doStart(context, out);
                                                        while (_jettag_c_if_508_11.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_509_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_509_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_509_11.setRuntimeParent(_jettag_c_if_508_11);
                                                            _jettag_c_if_509_11.setTagInfo(_td_c_if_509_11);
                                                            _jettag_c_if_509_11.doStart(context, out);
                                                            while (_jettag_c_if_509_11.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$packageName}", 510, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 510, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 510, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Service.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 510, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("ServiceAsync.instance().merge(entity,");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 511, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(") TreeAbstract");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 511, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panel.instance().getEntity(),");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tnew ALAsyncCallback<java.lang.Void>() {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(Void arg0) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tnew ResponseStatusWidget().show(\"added\");");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tReadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 517, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel.instance.refresh();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_509_11.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_509_11.doEnd();
                                                            // has parent and no children
                                                            RuntimeTagElement _jettag_c_if_523_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_523_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_523_11.setRuntimeParent(_jettag_c_if_508_11);
                                                            _jettag_c_if_523_11.setTagInfo(_td_c_if_523_11);
                                                            _jettag_c_if_523_11.doStart(context, out);
                                                            while (_jettag_c_if_523_11.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$packageName}", 524, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 524, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 524, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Service.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 524, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("ServiceAsync.instance().merge(entity,");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 525, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(") Tree");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 525, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panel.instance().getEntity(),");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tnew ALAsyncCallback<java.lang.Void>() {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(Void arg0) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tnew ResponseStatusWidget().show(\"added\");");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tReadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 531, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel.instance.refresh();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_523_11.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_523_11.doEnd();
                                                            _jettag_c_if_508_11.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_508_11.doEnd();
                                                        // no parent and has children
                                                        RuntimeTagElement _jettag_c_if_538_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_538_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_538_12.setRuntimeParent(_jettag_c_if_506_16);
                                                        _jettag_c_if_538_12.setTagInfo(_td_c_if_538_12);
                                                        _jettag_c_if_538_12.doStart(context, out);
                                                        while (_jettag_c_if_538_12.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_539_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_539_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_539_12.setRuntimeParent(_jettag_c_if_538_12);
                                                            _jettag_c_if_539_12.setTagInfo(_td_c_if_539_12);
                                                            _jettag_c_if_539_12.doStart(context, out);
                                                            while (_jettag_c_if_539_12.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\t \t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$packageName}", 540, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 540, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 540, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Service.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 540, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("ServiceAsync.instance().merge(entity,");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t TreeAbstract");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 541, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panel.instance().getEntity(),");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tnew ALAsyncCallback<java.lang.Void>() {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t@Override");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tpublic void onResponse(Void arg0) {");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tnew ResponseStatusWidget().show(\"added\");");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tReadAll");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 547, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("sPanel.instance.refresh();");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t});");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_539_12.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_539_12.doEnd();
                                                            _jettag_c_if_538_12.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_538_12.doEnd();
                                                        _jettag_c_if_506_16.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_506_16.doEnd();
                                                    _jettag_c_iterate_505_15.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_505_15.doEnd();
                                                _jettag_c_if_503_14.handleBodyContent(out);
                                            }
                                            _jettag_c_if_503_14.doEnd();
                                            _jettag_c_if_501_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_501_14.doEnd();
                                        _jettag_c_iterate_498_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_498_12.doEnd();
                                    _jettag_c_if_495_6.handleBodyContent(out);
                                }
                                _jettag_c_if_495_6.doEnd();
                                _jettag_c_iterate_492_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_492_3.doEnd();
                            _jettag_c_iterate_491_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_491_2.doEnd();
                        _jettag_c_iterate_490_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_490_2.doEnd();
                    _jettag_c_if_488_2.handleBodyContent(out);
                }
                _jettag_c_if_488_2.doEnd();
                out.write("\t}\t");  //$NON-NLS-1$        
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
