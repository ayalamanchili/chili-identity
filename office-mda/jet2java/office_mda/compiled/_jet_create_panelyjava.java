package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_create_panelyjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_create_panelyjava() {
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
    private static final TagInfo _td_c_if_11_2 = new TagInfo("c:if", //$NON-NLS-1$
            11, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_12_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            12, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_13_5 = new TagInfo("c:choose", //$NON-NLS-1$
            13, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_14_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            14, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_15_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            15, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_16_10 = new TagInfo("c:if", //$NON-NLS-1$
            16, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_25_2 = new TagInfo("c:if", //$NON-NLS-1$
            25, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_26_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            26, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_27_5 = new TagInfo("c:choose", //$NON-NLS-1$
            27, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_28_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            28, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_29_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            29, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_30_10 = new TagInfo("c:if", //$NON-NLS-1$
            30, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_39_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            39, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_40_5 = new TagInfo("c:choose", //$NON-NLS-1$
            40, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_41_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            41, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_42_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            42, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_43_10 = new TagInfo("c:if", //$NON-NLS-1$
            43, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_51_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            51, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_52_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            52, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_53_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            53, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_54_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            54, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_56_6 = new TagInfo("c:if", //$NON-NLS-1$
            56, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_59_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            59, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_60_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            60, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_62_14 = new TagInfo("c:if", //$NON-NLS-1$
            62, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_64_14 = new TagInfo("c:if", //$NON-NLS-1$
            64, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
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
    private static final TagInfo _td_c_setVariable_70_16 = new TagInfo("c:setVariable", //$NON-NLS-1$
            70, 16,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_71_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            71, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Generalization", //$NON-NLS-1$
                "generalization", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_72_13 = new TagInfo("c:if", //$NON-NLS-1$
            72, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$generalization/Generalization.parent/Class/@xmi.idref = $class2/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_74_13 = new TagInfo("c:setVariable", //$NON-NLS-1$
            74, 13,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@name", //$NON-NLS-1$
                "isParent", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_79_16 = new TagInfo("c:if", //$NON-NLS-1$
            79, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isParent = $class2/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_85_12 = new TagInfo("c:if", //$NON-NLS-1$
            85, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$isParent = $class2/@xmi.id", //$NON-NLS-1$
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
    private static final TagInfo _td_c_setVariable_108_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            108, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_110_14 = new TagInfo("c:if", //$NON-NLS-1$
            110, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_112_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            112, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_113_16 = new TagInfo("c:if", //$NON-NLS-1$
            113, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_116_16 = new TagInfo("c:if", //$NON-NLS-1$
            116, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_117_18 = new TagInfo("c:if", //$NON-NLS-1$
            117, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_120_18 = new TagInfo("c:if", //$NON-NLS-1$
            120, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_121_18 = new TagInfo("c:if", //$NON-NLS-1$
            121, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_144_1 = new TagInfo("f:message", //$NON-NLS-1$
            144, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_147_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            147, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_148_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            148, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_149_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            149, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_150_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            150, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_152_6 = new TagInfo("c:if", //$NON-NLS-1$
            152, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_154_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            154, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_155_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            155, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_157_14 = new TagInfo("c:if", //$NON-NLS-1$
            157, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_159_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            159, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_160_16 = new TagInfo("c:if", //$NON-NLS-1$
            160, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_163_16 = new TagInfo("c:if", //$NON-NLS-1$
            163, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_164_18 = new TagInfo("c:if", //$NON-NLS-1$
            164, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_166_18 = new TagInfo("c:if", //$NON-NLS-1$
            166, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_167_1 = new TagInfo("f:message", //$NON-NLS-1$
            167, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_181_1 = new TagInfo("f:message", //$NON-NLS-1$
            181, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_187_1 = new TagInfo("f:message", //$NON-NLS-1$
            187, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_193_1 = new TagInfo("f:message", //$NON-NLS-1$
            193, 1,
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
    private static final TagInfo _td_c_if_203_2 = new TagInfo("c:if", //$NON-NLS-1$
            203, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_204_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            204, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_205_5 = new TagInfo("c:choose", //$NON-NLS-1$
            205, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_206_6 = new TagInfo("c:when", //$NON-NLS-1$
            206, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_208_6 = new TagInfo("c:when", //$NON-NLS-1$
            208, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_210_6 = new TagInfo("c:when", //$NON-NLS-1$
            210, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_212_6 = new TagInfo("c:when", //$NON-NLS-1$
            212, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_214_6 = new TagInfo("c:when", //$NON-NLS-1$
            214, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_216_6 = new TagInfo("c:when", //$NON-NLS-1$
            216, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_218_6 = new TagInfo("c:when", //$NON-NLS-1$
            218, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_220_6 = new TagInfo("c:when", //$NON-NLS-1$
            220, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_222_6 = new TagInfo("c:when", //$NON-NLS-1$
            222, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_224_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            224, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_225_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            225, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_226_10 = new TagInfo("c:if", //$NON-NLS-1$
            226, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_235_2 = new TagInfo("c:if", //$NON-NLS-1$
            235, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_236_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            236, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_237_5 = new TagInfo("c:choose", //$NON-NLS-1$
            237, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_238_6 = new TagInfo("c:when", //$NON-NLS-1$
            238, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_240_6 = new TagInfo("c:when", //$NON-NLS-1$
            240, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_242_6 = new TagInfo("c:when", //$NON-NLS-1$
            242, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_244_6 = new TagInfo("c:when", //$NON-NLS-1$
            244, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_246_6 = new TagInfo("c:when", //$NON-NLS-1$
            246, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_248_6 = new TagInfo("c:when", //$NON-NLS-1$
            248, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_250_6 = new TagInfo("c:when", //$NON-NLS-1$
            250, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_252_6 = new TagInfo("c:when", //$NON-NLS-1$
            252, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_254_6 = new TagInfo("c:when", //$NON-NLS-1$
            254, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_256_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            256, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_257_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            257, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_258_10 = new TagInfo("c:if", //$NON-NLS-1$
            258, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_267_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            267, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_268_5 = new TagInfo("c:choose", //$NON-NLS-1$
            268, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_269_6 = new TagInfo("c:when", //$NON-NLS-1$
            269, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_271_6 = new TagInfo("c:when", //$NON-NLS-1$
            271, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_273_6 = new TagInfo("c:when", //$NON-NLS-1$
            273, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_275_6 = new TagInfo("c:when", //$NON-NLS-1$
            275, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_277_6 = new TagInfo("c:when", //$NON-NLS-1$
            277, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_279_6 = new TagInfo("c:when", //$NON-NLS-1$
            279, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_281_6 = new TagInfo("c:when", //$NON-NLS-1$
            281, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_283_6 = new TagInfo("c:when", //$NON-NLS-1$
            283, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_285_6 = new TagInfo("c:when", //$NON-NLS-1$
            285, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_287_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            287, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_288_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            288, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_289_10 = new TagInfo("c:if", //$NON-NLS-1$
            289, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_298_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            298, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_299_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            299, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_300_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            300, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_301_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            301, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_303_9 = new TagInfo("c:if", //$NON-NLS-1$
            303, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_305_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            305, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_306_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            306, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_308_17 = new TagInfo("c:if", //$NON-NLS-1$
            308, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_310_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            310, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_311_19 = new TagInfo("c:if", //$NON-NLS-1$
            311, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_314_19 = new TagInfo("c:if", //$NON-NLS-1$
            314, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_315_21 = new TagInfo("c:if", //$NON-NLS-1$
            315, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_317_18 = new TagInfo("c:if", //$NON-NLS-1$
            317, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_331_1 = new TagInfo("f:message", //$NON-NLS-1$
            331, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_337_2 = new TagInfo("c:if", //$NON-NLS-1$
            337, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_338_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            338, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_339_4 = new TagInfo("c:choose", //$NON-NLS-1$
            339, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_340_5 = new TagInfo("c:when", //$NON-NLS-1$
            340, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_342_5 = new TagInfo("c:when", //$NON-NLS-1$
            342, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_344_5 = new TagInfo("c:when", //$NON-NLS-1$
            344, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_346_5 = new TagInfo("c:when", //$NON-NLS-1$
            346, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_348_5 = new TagInfo("c:when", //$NON-NLS-1$
            348, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_350_5 = new TagInfo("c:when", //$NON-NLS-1$
            350, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_352_5 = new TagInfo("c:when", //$NON-NLS-1$
            352, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_354_5 = new TagInfo("c:when", //$NON-NLS-1$
            354, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_356_5 = new TagInfo("c:when", //$NON-NLS-1$
            356, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_358_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            358, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_359_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            359, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_360_10 = new TagInfo("c:if", //$NON-NLS-1$
            360, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_370_2 = new TagInfo("c:if", //$NON-NLS-1$
            370, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_371_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            371, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_372_4 = new TagInfo("c:choose", //$NON-NLS-1$
            372, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_373_5 = new TagInfo("c:when", //$NON-NLS-1$
            373, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_375_5 = new TagInfo("c:when", //$NON-NLS-1$
            375, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_377_5 = new TagInfo("c:when", //$NON-NLS-1$
            377, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_379_5 = new TagInfo("c:when", //$NON-NLS-1$
            379, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_381_5 = new TagInfo("c:when", //$NON-NLS-1$
            381, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_383_5 = new TagInfo("c:when", //$NON-NLS-1$
            383, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_385_5 = new TagInfo("c:when", //$NON-NLS-1$
            385, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_387_5 = new TagInfo("c:when", //$NON-NLS-1$
            387, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_389_5 = new TagInfo("c:when", //$NON-NLS-1$
            389, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_391_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            391, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_392_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            392, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_393_10 = new TagInfo("c:if", //$NON-NLS-1$
            393, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_402_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            402, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_403_4 = new TagInfo("c:choose", //$NON-NLS-1$
            403, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_404_5 = new TagInfo("c:when", //$NON-NLS-1$
            404, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_406_5 = new TagInfo("c:when", //$NON-NLS-1$
            406, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_408_5 = new TagInfo("c:when", //$NON-NLS-1$
            408, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_410_5 = new TagInfo("c:when", //$NON-NLS-1$
            410, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_412_5 = new TagInfo("c:when", //$NON-NLS-1$
            412, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_414_5 = new TagInfo("c:when", //$NON-NLS-1$
            414, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_416_5 = new TagInfo("c:when", //$NON-NLS-1$
            416, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_418_5 = new TagInfo("c:when", //$NON-NLS-1$
            418, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_420_5 = new TagInfo("c:when", //$NON-NLS-1$
            420, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_422_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            422, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_423_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            423, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_424_10 = new TagInfo("c:if", //$NON-NLS-1$
            424, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_433_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            433, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_434_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            434, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_435_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            435, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_436_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            436, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_438_9 = new TagInfo("c:if", //$NON-NLS-1$
            438, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_440_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            440, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_441_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            441, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_443_17 = new TagInfo("c:if", //$NON-NLS-1$
            443, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_445_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            445, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_446_19 = new TagInfo("c:if", //$NON-NLS-1$
            446, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_449_19 = new TagInfo("c:if", //$NON-NLS-1$
            449, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_450_21 = new TagInfo("c:if", //$NON-NLS-1$
            450, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_452_18 = new TagInfo("c:if", //$NON-NLS-1$
            452, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_467_1 = new TagInfo("f:message", //$NON-NLS-1$
            467, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_473_1 = new TagInfo("f:message", //$NON-NLS-1$
            473, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_481_1 = new TagInfo("f:message", //$NON-NLS-1$
            481, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_485_2 = new TagInfo("c:if", //$NON-NLS-1$
            485, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_487_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            487, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_488_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            488, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_489_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            489, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_490_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            490, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_492_6 = new TagInfo("c:if", //$NON-NLS-1$
            492, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_495_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            495, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_496_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            496, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_498_14 = new TagInfo("c:if", //$NON-NLS-1$
            498, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_500_14 = new TagInfo("c:if", //$NON-NLS-1$
            500, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_502_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            502, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_503_16 = new TagInfo("c:if", //$NON-NLS-1$
            503, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_505_11 = new TagInfo("c:if", //$NON-NLS-1$
            505, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@parent1 = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_506_11 = new TagInfo("c:if", //$NON-NLS-1$
            506, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@hasChildren = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_514_11 = new TagInfo("c:if", //$NON-NLS-1$
            514, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@hasChildren = $class2/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_519_12 = new TagInfo("c:if", //$NON-NLS-1$
            519, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@parent1 = $class2/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_520_12 = new TagInfo("c:if", //$NON-NLS-1$
            520, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class2/@hasChildren = $class2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_539_1 = new TagInfo("f:message", //$NON-NLS-1$
            539, 1,
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
                out.write("package ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 6, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 6, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.ReadAllCompositey.ReadAllTableType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                //process enums from base and lavel1,2 parents 
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_11_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_11_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_11_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_11_2.setTagInfo(_td_c_if_11_2);
                _jettag_c_if_11_2.doStart(context, out);
                while (_jettag_c_if_11_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_12_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_12_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_12_5.setRuntimeParent(_jettag_c_if_11_2);
                    _jettag_c_iterate_12_5.setTagInfo(_td_c_iterate_12_5);
                    _jettag_c_iterate_12_5.doStart(context, out);
                    while (_jettag_c_iterate_12_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_13_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_13_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_13_5.setRuntimeParent(_jettag_c_iterate_12_5);
                        _jettag_c_choose_13_5.setTagInfo(_td_c_choose_13_5);
                        _jettag_c_choose_13_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_13_5_saved_out = out;
                        while (_jettag_c_choose_13_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_otherwise_14_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_14_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_14_7.setRuntimeParent(_jettag_c_choose_13_5);
                            _jettag_c_otherwise_14_7.setTagInfo(_td_c_otherwise_14_7);
                            _jettag_c_otherwise_14_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_14_7_saved_out = out;
                            while (_jettag_c_otherwise_14_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_15_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_15_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_15_8.setRuntimeParent(_jettag_c_otherwise_14_7);
                                _jettag_c_iterate_15_8.setTagInfo(_td_c_iterate_15_8);
                                _jettag_c_iterate_15_8.doStart(context, out);
                                while (_jettag_c_iterate_15_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_16_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_16_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_16_10.setRuntimeParent(_jettag_c_iterate_15_8);
                                    _jettag_c_if_16_10.setTagInfo(_td_c_if_16_10);
                                    _jettag_c_if_16_10.doStart(context, out);
                                    while (_jettag_c_if_16_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$groupID}", 17, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".entity.");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 17, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 17, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(";");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_16_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_16_10.doEnd();
                                    _jettag_c_iterate_15_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_15_8.doEnd();
                                _jettag_c_otherwise_14_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_14_7_saved_out;
                            _jettag_c_otherwise_14_7.doEnd();
                            _jettag_c_choose_13_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_13_5_saved_out;
                        _jettag_c_choose_13_5.doEnd();
                        _jettag_c_iterate_12_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_12_5.doEnd();
                    _jettag_c_if_11_2.handleBodyContent(out);
                }
                _jettag_c_if_11_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_25_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_25_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_25_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_25_2.setTagInfo(_td_c_if_25_2);
                _jettag_c_if_25_2.doStart(context, out);
                while (_jettag_c_if_25_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_26_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_26_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_26_5.setRuntimeParent(_jettag_c_if_25_2);
                    _jettag_c_iterate_26_5.setTagInfo(_td_c_iterate_26_5);
                    _jettag_c_iterate_26_5.doStart(context, out);
                    while (_jettag_c_iterate_26_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_27_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_27_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_27_5.setRuntimeParent(_jettag_c_iterate_26_5);
                        _jettag_c_choose_27_5.setTagInfo(_td_c_choose_27_5);
                        _jettag_c_choose_27_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_27_5_saved_out = out;
                        while (_jettag_c_choose_27_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_otherwise_28_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_28_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_28_7.setRuntimeParent(_jettag_c_choose_27_5);
                            _jettag_c_otherwise_28_7.setTagInfo(_td_c_otherwise_28_7);
                            _jettag_c_otherwise_28_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_28_7_saved_out = out;
                            while (_jettag_c_otherwise_28_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_29_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_29_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_29_8.setRuntimeParent(_jettag_c_otherwise_28_7);
                                _jettag_c_iterate_29_8.setTagInfo(_td_c_iterate_29_8);
                                _jettag_c_iterate_29_8.doStart(context, out);
                                while (_jettag_c_iterate_29_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_30_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_30_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_30_10.setRuntimeParent(_jettag_c_iterate_29_8);
                                    _jettag_c_if_30_10.setTagInfo(_td_c_if_30_10);
                                    _jettag_c_if_30_10.doStart(context, out);
                                    while (_jettag_c_if_30_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$groupID}", 31, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".entity.");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 31, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 31, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(";");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_30_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_30_10.doEnd();
                                    _jettag_c_iterate_29_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_29_8.doEnd();
                                _jettag_c_otherwise_28_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_28_7_saved_out;
                            _jettag_c_otherwise_28_7.doEnd();
                            _jettag_c_choose_27_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_27_5_saved_out;
                        _jettag_c_choose_27_5.doEnd();
                        _jettag_c_iterate_26_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_26_5.doEnd();
                    _jettag_c_if_25_2.handleBodyContent(out);
                }
                _jettag_c_if_25_2.doEnd();
                //process premitive data types of base current class 
                RuntimeTagElement _jettag_c_iterate_39_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_39_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_39_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_39_4.setTagInfo(_td_c_iterate_39_4);
                _jettag_c_iterate_39_4.doStart(context, out);
                while (_jettag_c_iterate_39_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_40_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_40_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_40_5.setRuntimeParent(_jettag_c_iterate_39_4);
                    _jettag_c_choose_40_5.setTagInfo(_td_c_choose_40_5);
                    _jettag_c_choose_40_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_40_5_saved_out = out;
                    while (_jettag_c_choose_40_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_otherwise_41_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_41_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_41_7.setRuntimeParent(_jettag_c_choose_40_5);
                        _jettag_c_otherwise_41_7.setTagInfo(_td_c_otherwise_41_7);
                        _jettag_c_otherwise_41_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_41_7_saved_out = out;
                        while (_jettag_c_otherwise_41_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_42_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_42_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_42_8.setRuntimeParent(_jettag_c_otherwise_41_7);
                            _jettag_c_iterate_42_8.setTagInfo(_td_c_iterate_42_8);
                            _jettag_c_iterate_42_8.doStart(context, out);
                            while (_jettag_c_iterate_42_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_43_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_43_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_43_10.setRuntimeParent(_jettag_c_iterate_42_8);
                                _jettag_c_if_43_10.setTagInfo(_td_c_if_43_10);
                                _jettag_c_if_43_10.doStart(context, out);
                                while (_jettag_c_if_43_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$groupID}", 44, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".entity.");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 44, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 44, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(";");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_43_10.handleBodyContent(out);
                                }
                                _jettag_c_if_43_10.doEnd();
                                _jettag_c_iterate_42_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_42_8.doEnd();
                            _jettag_c_otherwise_41_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_41_7_saved_out;
                        _jettag_c_otherwise_41_7.doEnd();
                        _jettag_c_choose_40_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_40_5_saved_out;
                    _jettag_c_choose_40_5.doEnd();
                    _jettag_c_iterate_39_4.handleBodyContent(out);
                }
                _jettag_c_iterate_39_4.doEnd();
                // process compsition associations
                RuntimeTagElement _jettag_c_iterate_51_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_51_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_51_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_51_2.setTagInfo(_td_c_iterate_51_2);
                _jettag_c_iterate_51_2.doStart(context, out);
                while (_jettag_c_iterate_51_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_52_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_52_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_52_2.setRuntimeParent(_jettag_c_iterate_51_2);
                    _jettag_c_iterate_52_2.setTagInfo(_td_c_iterate_52_2);
                    _jettag_c_iterate_52_2.doStart(context, out);
                    while (_jettag_c_iterate_52_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_53_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_53_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_53_3.setRuntimeParent(_jettag_c_iterate_52_2);
                        _jettag_c_iterate_53_3.setTagInfo(_td_c_iterate_53_3);
                        _jettag_c_iterate_53_3.doStart(context, out);
                        while (_jettag_c_iterate_53_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_54_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_54_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_54_4.setRuntimeParent(_jettag_c_iterate_53_3);
                            _jettag_c_setVariable_54_4.setTagInfo(_td_c_setVariable_54_4);
                            _jettag_c_setVariable_54_4.doStart(context, out);
                            _jettag_c_setVariable_54_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_56_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_56_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_56_6.setRuntimeParent(_jettag_c_iterate_53_3);
                            _jettag_c_if_56_6.setTagInfo(_td_c_if_56_6);
                            _jettag_c_if_56_6.doStart(context, out);
                            while (_jettag_c_if_56_6.okToProcessBody()) {
                                // process only compositions
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_59_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_59_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_59_12.setRuntimeParent(_jettag_c_if_56_6);
                                _jettag_c_iterate_59_12.setTagInfo(_td_c_iterate_59_12);
                                _jettag_c_iterate_59_12.doStart(context, out);
                                while (_jettag_c_iterate_59_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_60_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_60_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_60_12.setRuntimeParent(_jettag_c_iterate_59_12);
                                    _jettag_c_setVariable_60_12.setTagInfo(_td_c_setVariable_60_12);
                                    _jettag_c_setVariable_60_12.doStart(context, out);
                                    _jettag_c_setVariable_60_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_62_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_62_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_62_14.setRuntimeParent(_jettag_c_iterate_59_12);
                                    _jettag_c_if_62_14.setTagInfo(_td_c_if_62_14);
                                    _jettag_c_if_62_14.doStart(context, out);
                                    while (_jettag_c_if_62_14.okToProcessBody()) {
                                        // check if this is a comp
                                        RuntimeTagElement _jettag_c_if_64_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_64_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_64_14.setRuntimeParent(_jettag_c_if_62_14);
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
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    // check if this is a parent
                                                    RuntimeTagElement _jettag_c_setVariable_70_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_70_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_setVariable_70_16.setRuntimeParent(_jettag_c_if_67_16);
                                                    _jettag_c_setVariable_70_16.setTagInfo(_td_c_setVariable_70_16);
                                                    _jettag_c_setVariable_70_16.doStart(context, out);
                                                    _jettag_c_setVariable_70_16.doEnd();
                                                    RuntimeTagElement _jettag_c_iterate_71_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_71_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_71_12.setRuntimeParent(_jettag_c_if_67_16);
                                                    _jettag_c_iterate_71_12.setTagInfo(_td_c_iterate_71_12);
                                                    _jettag_c_iterate_71_12.doStart(context, out);
                                                    while (_jettag_c_iterate_71_12.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_72_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_72_13); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_72_13.setRuntimeParent(_jettag_c_iterate_71_12);
                                                        _jettag_c_if_72_13.setTagInfo(_td_c_if_72_13);
                                                        _jettag_c_if_72_13.doStart(context, out);
                                                        while (_jettag_c_if_72_13.okToProcessBody()) {
                                                            // update flag variable
                                                            RuntimeTagElement _jettag_c_setVariable_74_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_74_13); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_setVariable_74_13.setRuntimeParent(_jettag_c_if_72_13);
                                                            _jettag_c_setVariable_74_13.setTagInfo(_td_c_setVariable_74_13);
                                                            _jettag_c_setVariable_74_13.doStart(context, out);
                                                            _jettag_c_setVariable_74_13.doEnd();
                                                            _jettag_c_if_72_13.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_72_13.doEnd();
                                                        _jettag_c_iterate_71_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_71_12.doEnd();
                                                    // if class is a Parent class
                                                    out.write("\t\t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 78, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".entity.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 78, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 78, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    RuntimeTagElement _jettag_c_if_79_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_79_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_79_16.setRuntimeParent(_jettag_c_if_67_16);
                                                    _jettag_c_if_79_16.setTagInfo(_td_c_if_79_16);
                                                    _jettag_c_if_79_16.doStart(context, out);
                                                    while (_jettag_c_if_79_16.okToProcessBody()) {
                                                        out.write("\t\t\t\t\t\t\t\t    \t\t \timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 80, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 80, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 80, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".TreeAbstract");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 80, 114)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Panely;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t    \t\t \timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 81, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 81, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 81, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 81, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Proxy;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_79_16.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_79_16.doEnd();
                                                    // if class is a regular  class
                                                    out.write("\t\t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 84, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".entity.");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 84, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 84, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(";");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    RuntimeTagElement _jettag_c_if_85_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_85_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_85_12.setRuntimeParent(_jettag_c_if_67_16);
                                                    _jettag_c_if_85_12.setTagInfo(_td_c_if_85_12);
                                                    _jettag_c_if_85_12.doStart(context, out);
                                                    while (_jettag_c_if_85_12.okToProcessBody()) {
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 86, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 86, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 86, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".Tree");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 86, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Panely;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t\t\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 87, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 87, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 87, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 87, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Proxy;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_85_12.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_85_12.doEnd();
                                                    _jettag_c_if_67_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_67_16.doEnd();
                                                _jettag_c_iterate_66_15.handleBodyContent(out);
                                            }
                                            _jettag_c_iterate_66_15.doEnd();
                                            _jettag_c_if_64_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_64_14.doEnd();
                                        _jettag_c_if_62_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_62_14.doEnd();
                                    _jettag_c_iterate_59_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_59_12.doEnd();
                                _jettag_c_if_56_6.handleBodyContent(out);
                            }
                            _jettag_c_if_56_6.doEnd();
                            _jettag_c_iterate_53_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_53_3.doEnd();
                        _jettag_c_iterate_52_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_52_2.doEnd();
                    _jettag_c_iterate_51_2.handleBodyContent(out);
                }
                _jettag_c_iterate_51_2.doEnd();
                out.write(NL);         
                // process dropdowns one tone and many to one 
                RuntimeTagElement _jettag_c_iterate_100_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_100_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_100_1.setRuntimeParent(_jettag_f_bundle_3_1);
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
                                    RuntimeTagElement _jettag_c_setVariable_108_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_108_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_108_12.setRuntimeParent(_jettag_c_iterate_107_12);
                                    _jettag_c_setVariable_108_12.setTagInfo(_td_c_setVariable_108_12);
                                    _jettag_c_setVariable_108_12.doStart(context, out);
                                    _jettag_c_setVariable_108_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_110_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_110_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_110_14.setRuntimeParent(_jettag_c_iterate_107_12);
                                    _jettag_c_if_110_14.setTagInfo(_td_c_if_110_14);
                                    _jettag_c_if_110_14.doStart(context, out);
                                    while (_jettag_c_if_110_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_112_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_112_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_112_15.setRuntimeParent(_jettag_c_if_110_14);
                                        _jettag_c_iterate_112_15.setTagInfo(_td_c_iterate_112_15);
                                        _jettag_c_iterate_112_15.doStart(context, out);
                                        while (_jettag_c_iterate_112_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_113_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_113_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_113_16.setRuntimeParent(_jettag_c_iterate_112_15);
                                            _jettag_c_if_113_16.setTagInfo(_td_c_if_113_16);
                                            _jettag_c_if_113_16.doStart(context, out);
                                            while (_jettag_c_if_113_16.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_116_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_116_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_116_16.setRuntimeParent(_jettag_c_if_113_16);
                                                _jettag_c_if_116_16.setTagInfo(_td_c_if_116_16);
                                                _jettag_c_if_116_16.doStart(context, out);
                                                while (_jettag_c_if_116_16.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_117_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_117_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_117_18.setRuntimeParent(_jettag_c_if_116_16);
                                                    _jettag_c_if_117_18.setTagInfo(_td_c_if_117_18);
                                                    _jettag_c_if_117_18.doStart(context, out);
                                                    while (_jettag_c_if_117_18.okToProcessBody()) {
                                                        out.write("  \t\t\t\t\t    \t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 118, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 118, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 118, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".Select");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 118, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Panely;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        //check for one to one 
                                                        RuntimeTagElement _jettag_c_if_120_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_120_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_120_18.setRuntimeParent(_jettag_c_if_117_18);
                                                        _jettag_c_if_120_18.setTagInfo(_td_c_if_120_18);
                                                        _jettag_c_if_120_18.doStart(context, out);
                                                        while (_jettag_c_if_120_18.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_121_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_121_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_121_18.setRuntimeParent(_jettag_c_if_120_18);
                                                            _jettag_c_if_121_18.setTagInfo(_td_c_if_121_18);
                                                            _jettag_c_if_121_18.doStart(context, out);
                                                            while (_jettag_c_if_121_18.okToProcessBody()) {
                                                                out.write("  \t\t\t\t\t    \t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 122, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".client.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 122, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 122, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".Select");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 122, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panely;");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_121_18.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_121_18.doEnd();
                                                            _jettag_c_if_120_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_120_18.doEnd();
                                                        _jettag_c_if_117_18.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_117_18.doEnd();
                                                    _jettag_c_if_116_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_116_16.doEnd();
                                                _jettag_c_if_113_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_113_16.doEnd();
                                            _jettag_c_iterate_112_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_112_15.doEnd();
                                        _jettag_c_if_110_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_110_14.doEnd();
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
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.CreateCompositey;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.widgets.ResponseStatusWidget;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 139, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 139, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 140, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 140, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 140, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.fields.DataType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.rf.GenericRequest;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_144_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_144_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_144_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_144_1.setTagInfo(_td_f_message_144_1);
                _jettag_f_message_144_1.doStart(context, out);
                JET2Writer _jettag_f_message_144_1_saved_out = out;
                while (_jettag_f_message_144_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_144_1.handleBodyContent(out);
                }
                out = _jettag_f_message_144_1_saved_out;
                _jettag_f_message_144_1.doEnd();
                out.write(NL);         
                out.write("public class Create");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 145, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely extends CreateCompositey<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 145, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy> {");  //$NON-NLS-1$        
                out.write(NL);         
                // process dropdowns one tone and many to one 
                RuntimeTagElement _jettag_c_iterate_147_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_147_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_147_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_147_1.setTagInfo(_td_c_iterate_147_1);
                _jettag_c_iterate_147_1.doStart(context, out);
                while (_jettag_c_iterate_147_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_148_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_148_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_148_2.setRuntimeParent(_jettag_c_iterate_147_1);
                    _jettag_c_iterate_148_2.setTagInfo(_td_c_iterate_148_2);
                    _jettag_c_iterate_148_2.doStart(context, out);
                    while (_jettag_c_iterate_148_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_149_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_149_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_149_3.setRuntimeParent(_jettag_c_iterate_148_2);
                        _jettag_c_iterate_149_3.setTagInfo(_td_c_iterate_149_3);
                        _jettag_c_iterate_149_3.doStart(context, out);
                        while (_jettag_c_iterate_149_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_150_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_150_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_150_4.setRuntimeParent(_jettag_c_iterate_149_3);
                            _jettag_c_setVariable_150_4.setTagInfo(_td_c_setVariable_150_4);
                            _jettag_c_setVariable_150_4.doStart(context, out);
                            _jettag_c_setVariable_150_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_152_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_152_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_152_6.setRuntimeParent(_jettag_c_iterate_149_3);
                            _jettag_c_if_152_6.setTagInfo(_td_c_if_152_6);
                            _jettag_c_if_152_6.doStart(context, out);
                            while (_jettag_c_if_152_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_154_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_154_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_154_12.setRuntimeParent(_jettag_c_if_152_6);
                                _jettag_c_iterate_154_12.setTagInfo(_td_c_iterate_154_12);
                                _jettag_c_iterate_154_12.doStart(context, out);
                                while (_jettag_c_iterate_154_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_155_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_155_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_155_12.setRuntimeParent(_jettag_c_iterate_154_12);
                                    _jettag_c_setVariable_155_12.setTagInfo(_td_c_setVariable_155_12);
                                    _jettag_c_setVariable_155_12.doStart(context, out);
                                    _jettag_c_setVariable_155_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_157_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_157_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_157_14.setRuntimeParent(_jettag_c_iterate_154_12);
                                    _jettag_c_if_157_14.setTagInfo(_td_c_if_157_14);
                                    _jettag_c_if_157_14.doStart(context, out);
                                    while (_jettag_c_if_157_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_159_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_159_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_159_15.setRuntimeParent(_jettag_c_if_157_14);
                                        _jettag_c_iterate_159_15.setTagInfo(_td_c_iterate_159_15);
                                        _jettag_c_iterate_159_15.doStart(context, out);
                                        while (_jettag_c_iterate_159_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_160_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_160_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_160_16.setRuntimeParent(_jettag_c_iterate_159_15);
                                            _jettag_c_if_160_16.setTagInfo(_td_c_if_160_16);
                                            _jettag_c_if_160_16.doStart(context, out);
                                            while (_jettag_c_if_160_16.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_163_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_163_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_163_16.setRuntimeParent(_jettag_c_if_160_16);
                                                _jettag_c_if_163_16.setTagInfo(_td_c_if_163_16);
                                                _jettag_c_if_163_16.doStart(context, out);
                                                while (_jettag_c_if_163_16.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_164_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_164_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_164_18.setRuntimeParent(_jettag_c_if_163_16);
                                                    _jettag_c_if_164_18.setTagInfo(_td_c_if_164_18);
                                                    _jettag_c_if_164_18.doStart(context, out);
                                                    while (_jettag_c_if_164_18.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_166_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_166_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_166_18.setRuntimeParent(_jettag_c_if_164_18);
                                                        _jettag_c_if_166_18.setTagInfo(_td_c_if_166_18);
                                                        _jettag_c_if_166_18.doStart(context, out);
                                                        while (_jettag_c_if_166_18.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_f_message_167_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_167_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_167_1.setRuntimeParent(_jettag_c_if_166_18);
                                                            _jettag_f_message_167_1.setTagInfo(_td_f_message_167_1);
                                                            _jettag_f_message_167_1.doStart(context, out);
                                                            JET2Writer _jettag_f_message_167_1_saved_out = out;
                                                            while (_jettag_f_message_167_1.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_167_1.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_167_1_saved_out;
                                                            _jettag_f_message_167_1.doEnd();
                                                            out.write("  \t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("  \t\t\t\t\t    \t\t\t\t\t\t\tSelect");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 168, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panely select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 168, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel = new Select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 168, 88)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panely(\"");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 168, 112)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("\");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_166_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_166_18.doEnd();
                                                        _jettag_c_if_164_18.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_164_18.doEnd();
                                                    _jettag_c_if_163_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_163_16.doEnd();
                                                _jettag_c_if_160_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_160_16.doEnd();
                                            _jettag_c_iterate_159_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_159_15.doEnd();
                                        _jettag_c_if_157_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_157_14.doEnd();
                                    _jettag_c_iterate_154_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_154_12.doEnd();
                                _jettag_c_if_152_6.handleBodyContent(out);
                            }
                            _jettag_c_if_152_6.doEnd();
                            _jettag_c_iterate_149_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_149_3.doEnd();
                        _jettag_c_iterate_148_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_148_2.doEnd();
                    _jettag_c_iterate_147_1.handleBodyContent(out);
                }
                _jettag_c_iterate_147_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_181_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_181_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_181_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_181_1.setTagInfo(_td_f_message_181_1);
                _jettag_f_message_181_1.doStart(context, out);
                JET2Writer _jettag_f_message_181_1_saved_out = out;
                while (_jettag_f_message_181_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_181_1.handleBodyContent(out);
                }
                out = _jettag_f_message_181_1_saved_out;
                _jettag_f_message_181_1.doEnd();
                out.write(NL);         
                out.write("public Create");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 182, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely(CreateCompositeType type) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tsuper(type);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitCreateComposite(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 184, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getName(), ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 184, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.constants);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_187_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_187_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_187_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_187_1.setTagInfo(_td_f_message_187_1);
                _jettag_f_message_187_1.doStart(context, out);
                JET2Writer _jettag_f_message_187_1_saved_out = out;
                while (_jettag_f_message_187_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_187_1.handleBodyContent(out);
                }
                out = _jettag_f_message_187_1_saved_out;
                _jettag_f_message_187_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_193_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_193_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_193_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_193_1.setTagInfo(_td_f_message_193_1);
                _jettag_f_message_193_1.doStart(context, out);
                JET2Writer _jettag_f_message_193_1_saved_out = out;
                while (_jettag_f_message_193_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_193_1.handleBodyContent(out);
                }
                out = _jettag_f_message_193_1_saved_out;
                _jettag_f_message_193_1.doEnd();
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
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void addWidgets() {");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_203_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_203_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_203_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_203_2.setTagInfo(_td_c_if_203_2);
                _jettag_c_if_203_2.doStart(context, out);
                while (_jettag_c_if_203_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_204_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_204_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_204_5.setRuntimeParent(_jettag_c_if_203_2);
                    _jettag_c_iterate_204_5.setTagInfo(_td_c_iterate_204_5);
                    _jettag_c_iterate_204_5.doStart(context, out);
                    while (_jettag_c_iterate_204_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_205_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_205_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_205_5.setRuntimeParent(_jettag_c_iterate_204_5);
                        _jettag_c_choose_205_5.setTagInfo(_td_c_choose_205_5);
                        _jettag_c_choose_205_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_205_5_saved_out = out;
                        while (_jettag_c_choose_205_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_206_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_206_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_206_6.setRuntimeParent(_jettag_c_choose_205_5);
                            _jettag_c_when_206_6.setTagInfo(_td_c_when_206_6);
                            _jettag_c_when_206_6.doStart(context, out);
                            JET2Writer _jettag_c_when_206_6_saved_out = out;
                            while (_jettag_c_when_206_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 206, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 206, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_206_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_206_6_saved_out;
                            _jettag_c_when_206_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_208_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_208_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_208_6.setRuntimeParent(_jettag_c_choose_205_5);
                            _jettag_c_when_208_6.setTagInfo(_td_c_when_208_6);
                            _jettag_c_when_208_6.doStart(context, out);
                            JET2Writer _jettag_c_when_208_6_saved_out = out;
                            while (_jettag_c_when_208_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 208, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 208, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_208_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_208_6_saved_out;
                            _jettag_c_when_208_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_210_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_210_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_210_6.setRuntimeParent(_jettag_c_choose_205_5);
                            _jettag_c_when_210_6.setTagInfo(_td_c_when_210_6);
                            _jettag_c_when_210_6.doStart(context, out);
                            JET2Writer _jettag_c_when_210_6_saved_out = out;
                            while (_jettag_c_when_210_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 210, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 210, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_210_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_210_6_saved_out;
                            _jettag_c_when_210_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_212_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_212_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_212_6.setRuntimeParent(_jettag_c_choose_205_5);
                            _jettag_c_when_212_6.setTagInfo(_td_c_when_212_6);
                            _jettag_c_when_212_6.doStart(context, out);
                            JET2Writer _jettag_c_when_212_6_saved_out = out;
                            while (_jettag_c_when_212_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 212, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 212, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_212_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_212_6_saved_out;
                            _jettag_c_when_212_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_214_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_214_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_214_6.setRuntimeParent(_jettag_c_choose_205_5);
                            _jettag_c_when_214_6.setTagInfo(_td_c_when_214_6);
                            _jettag_c_when_214_6.doStart(context, out);
                            JET2Writer _jettag_c_when_214_6_saved_out = out;
                            while (_jettag_c_when_214_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 214, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 214, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_214_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_214_6_saved_out;
                            _jettag_c_when_214_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_216_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_216_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_216_6.setRuntimeParent(_jettag_c_choose_205_5);
                            _jettag_c_when_216_6.setTagInfo(_td_c_when_216_6);
                            _jettag_c_when_216_6.doStart(context, out);
                            JET2Writer _jettag_c_when_216_6_saved_out = out;
                            while (_jettag_c_when_216_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 216, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 216, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_216_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_216_6_saved_out;
                            _jettag_c_when_216_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_218_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_218_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_218_6.setRuntimeParent(_jettag_c_choose_205_5);
                            _jettag_c_when_218_6.setTagInfo(_td_c_when_218_6);
                            _jettag_c_when_218_6.doStart(context, out);
                            JET2Writer _jettag_c_when_218_6_saved_out = out;
                            while (_jettag_c_when_218_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 218, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 218, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_218_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_218_6_saved_out;
                            _jettag_c_when_218_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_220_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_220_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_220_6.setRuntimeParent(_jettag_c_choose_205_5);
                            _jettag_c_when_220_6.setTagInfo(_td_c_when_220_6);
                            _jettag_c_when_220_6.doStart(context, out);
                            JET2Writer _jettag_c_when_220_6_saved_out = out;
                            while (_jettag_c_when_220_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 220, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 220, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_220_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_220_6_saved_out;
                            _jettag_c_when_220_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_222_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_222_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_222_6.setRuntimeParent(_jettag_c_choose_205_5);
                            _jettag_c_when_222_6.setTagInfo(_td_c_when_222_6);
                            _jettag_c_when_222_6.doStart(context, out);
                            JET2Writer _jettag_c_when_222_6_saved_out = out;
                            while (_jettag_c_when_222_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 222, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 222, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_222_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_222_6_saved_out;
                            _jettag_c_when_222_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_224_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_224_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_224_7.setRuntimeParent(_jettag_c_choose_205_5);
                            _jettag_c_otherwise_224_7.setTagInfo(_td_c_otherwise_224_7);
                            _jettag_c_otherwise_224_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_224_7_saved_out = out;
                            while (_jettag_c_otherwise_224_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_225_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_225_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_225_8.setRuntimeParent(_jettag_c_otherwise_224_7);
                                _jettag_c_iterate_225_8.setTagInfo(_td_c_iterate_225_8);
                                _jettag_c_iterate_225_8.doStart(context, out);
                                while (_jettag_c_iterate_225_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_226_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_226_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_226_10.setRuntimeParent(_jettag_c_iterate_225_8);
                                    _jettag_c_if_226_10.setTagInfo(_td_c_if_226_10);
                                    _jettag_c_if_226_10.doStart(context, out);
                                    while (_jettag_c_if_226_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 227, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", false, ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 227, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(", \"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 227, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 227, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".class.getName());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_226_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_226_10.doEnd();
                                    _jettag_c_iterate_225_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_225_8.doEnd();
                                _jettag_c_otherwise_224_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_224_7_saved_out;
                            _jettag_c_otherwise_224_7.doEnd();
                            _jettag_c_choose_205_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_205_5_saved_out;
                        _jettag_c_choose_205_5.doEnd();
                        _jettag_c_iterate_204_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_204_5.doEnd();
                    _jettag_c_if_203_2.handleBodyContent(out);
                }
                _jettag_c_if_203_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_235_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_235_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_235_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_235_2.setTagInfo(_td_c_if_235_2);
                _jettag_c_if_235_2.doStart(context, out);
                while (_jettag_c_if_235_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_236_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_236_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_236_5.setRuntimeParent(_jettag_c_if_235_2);
                    _jettag_c_iterate_236_5.setTagInfo(_td_c_iterate_236_5);
                    _jettag_c_iterate_236_5.doStart(context, out);
                    while (_jettag_c_iterate_236_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_237_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_237_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_237_5.setRuntimeParent(_jettag_c_iterate_236_5);
                        _jettag_c_choose_237_5.setTagInfo(_td_c_choose_237_5);
                        _jettag_c_choose_237_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_237_5_saved_out = out;
                        while (_jettag_c_choose_237_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_238_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_238_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_238_6.setRuntimeParent(_jettag_c_choose_237_5);
                            _jettag_c_when_238_6.setTagInfo(_td_c_when_238_6);
                            _jettag_c_when_238_6.doStart(context, out);
                            JET2Writer _jettag_c_when_238_6_saved_out = out;
                            while (_jettag_c_when_238_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 238, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 238, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_238_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_238_6_saved_out;
                            _jettag_c_when_238_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_240_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_240_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_240_6.setRuntimeParent(_jettag_c_choose_237_5);
                            _jettag_c_when_240_6.setTagInfo(_td_c_when_240_6);
                            _jettag_c_when_240_6.doStart(context, out);
                            JET2Writer _jettag_c_when_240_6_saved_out = out;
                            while (_jettag_c_when_240_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 240, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 240, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_240_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_240_6_saved_out;
                            _jettag_c_when_240_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_242_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_242_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_242_6.setRuntimeParent(_jettag_c_choose_237_5);
                            _jettag_c_when_242_6.setTagInfo(_td_c_when_242_6);
                            _jettag_c_when_242_6.doStart(context, out);
                            JET2Writer _jettag_c_when_242_6_saved_out = out;
                            while (_jettag_c_when_242_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 242, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 242, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_242_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_242_6_saved_out;
                            _jettag_c_when_242_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_244_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_244_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_244_6.setRuntimeParent(_jettag_c_choose_237_5);
                            _jettag_c_when_244_6.setTagInfo(_td_c_when_244_6);
                            _jettag_c_when_244_6.doStart(context, out);
                            JET2Writer _jettag_c_when_244_6_saved_out = out;
                            while (_jettag_c_when_244_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 244, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 244, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_244_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_244_6_saved_out;
                            _jettag_c_when_244_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_246_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_246_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_246_6.setRuntimeParent(_jettag_c_choose_237_5);
                            _jettag_c_when_246_6.setTagInfo(_td_c_when_246_6);
                            _jettag_c_when_246_6.doStart(context, out);
                            JET2Writer _jettag_c_when_246_6_saved_out = out;
                            while (_jettag_c_when_246_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 246, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 246, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_246_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_246_6_saved_out;
                            _jettag_c_when_246_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_248_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_248_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_248_6.setRuntimeParent(_jettag_c_choose_237_5);
                            _jettag_c_when_248_6.setTagInfo(_td_c_when_248_6);
                            _jettag_c_when_248_6.doStart(context, out);
                            JET2Writer _jettag_c_when_248_6_saved_out = out;
                            while (_jettag_c_when_248_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 248, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 248, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_248_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_248_6_saved_out;
                            _jettag_c_when_248_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_250_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_250_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_250_6.setRuntimeParent(_jettag_c_choose_237_5);
                            _jettag_c_when_250_6.setTagInfo(_td_c_when_250_6);
                            _jettag_c_when_250_6.doStart(context, out);
                            JET2Writer _jettag_c_when_250_6_saved_out = out;
                            while (_jettag_c_when_250_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 250, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 250, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_250_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_250_6_saved_out;
                            _jettag_c_when_250_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_252_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_252_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_252_6.setRuntimeParent(_jettag_c_choose_237_5);
                            _jettag_c_when_252_6.setTagInfo(_td_c_when_252_6);
                            _jettag_c_when_252_6.doStart(context, out);
                            JET2Writer _jettag_c_when_252_6_saved_out = out;
                            while (_jettag_c_when_252_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 252, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 252, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_252_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_252_6_saved_out;
                            _jettag_c_when_252_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_254_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_254_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_254_6.setRuntimeParent(_jettag_c_choose_237_5);
                            _jettag_c_when_254_6.setTagInfo(_td_c_when_254_6);
                            _jettag_c_when_254_6.doStart(context, out);
                            JET2Writer _jettag_c_when_254_6_saved_out = out;
                            while (_jettag_c_when_254_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 254, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 254, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_254_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_254_6_saved_out;
                            _jettag_c_when_254_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_256_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_256_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_256_7.setRuntimeParent(_jettag_c_choose_237_5);
                            _jettag_c_otherwise_256_7.setTagInfo(_td_c_otherwise_256_7);
                            _jettag_c_otherwise_256_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_256_7_saved_out = out;
                            while (_jettag_c_otherwise_256_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_257_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_257_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_257_8.setRuntimeParent(_jettag_c_otherwise_256_7);
                                _jettag_c_iterate_257_8.setTagInfo(_td_c_iterate_257_8);
                                _jettag_c_iterate_257_8.doStart(context, out);
                                while (_jettag_c_iterate_257_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_258_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_258_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_258_10.setRuntimeParent(_jettag_c_iterate_257_8);
                                    _jettag_c_if_258_10.setTagInfo(_td_c_if_258_10);
                                    _jettag_c_if_258_10.doStart(context, out);
                                    while (_jettag_c_if_258_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 259, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", false, ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 259, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(", \"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 259, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 259, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".class.getName());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_258_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_258_10.doEnd();
                                    _jettag_c_iterate_257_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_257_8.doEnd();
                                _jettag_c_otherwise_256_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_256_7_saved_out;
                            _jettag_c_otherwise_256_7.doEnd();
                            _jettag_c_choose_237_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_237_5_saved_out;
                        _jettag_c_choose_237_5.doEnd();
                        _jettag_c_iterate_236_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_236_5.doEnd();
                    _jettag_c_if_235_2.handleBodyContent(out);
                }
                _jettag_c_if_235_2.doEnd();
                //process premitive data types of base current class 
                RuntimeTagElement _jettag_c_iterate_267_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_267_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_267_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_267_4.setTagInfo(_td_c_iterate_267_4);
                _jettag_c_iterate_267_4.doStart(context, out);
                while (_jettag_c_iterate_267_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_268_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_268_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_268_5.setRuntimeParent(_jettag_c_iterate_267_4);
                    _jettag_c_choose_268_5.setTagInfo(_td_c_choose_268_5);
                    _jettag_c_choose_268_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_268_5_saved_out = out;
                    while (_jettag_c_choose_268_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_269_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_269_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_269_6.setRuntimeParent(_jettag_c_choose_268_5);
                        _jettag_c_when_269_6.setTagInfo(_td_c_when_269_6);
                        _jettag_c_when_269_6.doStart(context, out);
                        JET2Writer _jettag_c_when_269_6_saved_out = out;
                        while (_jettag_c_when_269_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 269, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 269, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_269_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_269_6_saved_out;
                        _jettag_c_when_269_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_271_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_271_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_271_6.setRuntimeParent(_jettag_c_choose_268_5);
                        _jettag_c_when_271_6.setTagInfo(_td_c_when_271_6);
                        _jettag_c_when_271_6.doStart(context, out);
                        JET2Writer _jettag_c_when_271_6_saved_out = out;
                        while (_jettag_c_when_271_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 271, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 271, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_271_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_271_6_saved_out;
                        _jettag_c_when_271_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_273_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_273_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_273_6.setRuntimeParent(_jettag_c_choose_268_5);
                        _jettag_c_when_273_6.setTagInfo(_td_c_when_273_6);
                        _jettag_c_when_273_6.doStart(context, out);
                        JET2Writer _jettag_c_when_273_6_saved_out = out;
                        while (_jettag_c_when_273_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 273, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 273, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_273_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_273_6_saved_out;
                        _jettag_c_when_273_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_275_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_275_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_275_6.setRuntimeParent(_jettag_c_choose_268_5);
                        _jettag_c_when_275_6.setTagInfo(_td_c_when_275_6);
                        _jettag_c_when_275_6.doStart(context, out);
                        JET2Writer _jettag_c_when_275_6_saved_out = out;
                        while (_jettag_c_when_275_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 275, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 275, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_275_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_275_6_saved_out;
                        _jettag_c_when_275_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_277_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_277_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_277_6.setRuntimeParent(_jettag_c_choose_268_5);
                        _jettag_c_when_277_6.setTagInfo(_td_c_when_277_6);
                        _jettag_c_when_277_6.doStart(context, out);
                        JET2Writer _jettag_c_when_277_6_saved_out = out;
                        while (_jettag_c_when_277_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 277, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 277, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_277_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_277_6_saved_out;
                        _jettag_c_when_277_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_279_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_279_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_279_6.setRuntimeParent(_jettag_c_choose_268_5);
                        _jettag_c_when_279_6.setTagInfo(_td_c_when_279_6);
                        _jettag_c_when_279_6.doStart(context, out);
                        JET2Writer _jettag_c_when_279_6_saved_out = out;
                        while (_jettag_c_when_279_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 279, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 279, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_279_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_279_6_saved_out;
                        _jettag_c_when_279_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_281_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_281_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_281_6.setRuntimeParent(_jettag_c_choose_268_5);
                        _jettag_c_when_281_6.setTagInfo(_td_c_when_281_6);
                        _jettag_c_when_281_6.doStart(context, out);
                        JET2Writer _jettag_c_when_281_6_saved_out = out;
                        while (_jettag_c_when_281_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 281, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 281, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_281_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_281_6_saved_out;
                        _jettag_c_when_281_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_283_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_283_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_283_6.setRuntimeParent(_jettag_c_choose_268_5);
                        _jettag_c_when_283_6.setTagInfo(_td_c_when_283_6);
                        _jettag_c_when_283_6.doStart(context, out);
                        JET2Writer _jettag_c_when_283_6_saved_out = out;
                        while (_jettag_c_when_283_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 283, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 283, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_283_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_283_6_saved_out;
                        _jettag_c_when_283_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_285_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_285_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_285_6.setRuntimeParent(_jettag_c_choose_268_5);
                        _jettag_c_when_285_6.setTagInfo(_td_c_when_285_6);
                        _jettag_c_when_285_6.doStart(context, out);
                        JET2Writer _jettag_c_when_285_6_saved_out = out;
                        while (_jettag_c_when_285_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 285, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 285, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_285_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_285_6_saved_out;
                        _jettag_c_when_285_6.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_287_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_287_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_287_7.setRuntimeParent(_jettag_c_choose_268_5);
                        _jettag_c_otherwise_287_7.setTagInfo(_td_c_otherwise_287_7);
                        _jettag_c_otherwise_287_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_287_7_saved_out = out;
                        while (_jettag_c_otherwise_287_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_288_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_288_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_288_8.setRuntimeParent(_jettag_c_otherwise_287_7);
                            _jettag_c_iterate_288_8.setTagInfo(_td_c_iterate_288_8);
                            _jettag_c_iterate_288_8.doStart(context, out);
                            while (_jettag_c_iterate_288_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_289_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_289_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_289_10.setRuntimeParent(_jettag_c_iterate_288_8);
                                _jettag_c_if_289_10.setTagInfo(_td_c_if_289_10);
                                _jettag_c_if_289_10.doStart(context, out);
                                while (_jettag_c_if_289_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 290, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", false, ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 290, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(", \"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 290, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 290, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".class.getName());");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_289_10.handleBodyContent(out);
                                }
                                _jettag_c_if_289_10.doEnd();
                                _jettag_c_iterate_288_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_288_8.doEnd();
                            _jettag_c_otherwise_287_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_287_7_saved_out;
                        _jettag_c_otherwise_287_7.doEnd();
                        _jettag_c_choose_268_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_268_5_saved_out;
                    _jettag_c_choose_268_5.doEnd();
                    _jettag_c_iterate_267_4.handleBodyContent(out);
                }
                _jettag_c_iterate_267_4.doEnd();
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process dropdowns one to one and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_298_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_298_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_298_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_298_4.setTagInfo(_td_c_iterate_298_4);
                _jettag_c_iterate_298_4.doStart(context, out);
                while (_jettag_c_iterate_298_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_299_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_299_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_299_5.setRuntimeParent(_jettag_c_iterate_298_4);
                    _jettag_c_iterate_299_5.setTagInfo(_td_c_iterate_299_5);
                    _jettag_c_iterate_299_5.doStart(context, out);
                    while (_jettag_c_iterate_299_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_300_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_300_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_300_6.setRuntimeParent(_jettag_c_iterate_299_5);
                        _jettag_c_iterate_300_6.setTagInfo(_td_c_iterate_300_6);
                        _jettag_c_iterate_300_6.doStart(context, out);
                        while (_jettag_c_iterate_300_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_301_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_301_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_301_7.setRuntimeParent(_jettag_c_iterate_300_6);
                            _jettag_c_setVariable_301_7.setTagInfo(_td_c_setVariable_301_7);
                            _jettag_c_setVariable_301_7.doStart(context, out);
                            _jettag_c_setVariable_301_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_303_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_303_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_303_9.setRuntimeParent(_jettag_c_iterate_300_6);
                            _jettag_c_if_303_9.setTagInfo(_td_c_if_303_9);
                            _jettag_c_if_303_9.doStart(context, out);
                            while (_jettag_c_if_303_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_305_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_305_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_305_15.setRuntimeParent(_jettag_c_if_303_9);
                                _jettag_c_iterate_305_15.setTagInfo(_td_c_iterate_305_15);
                                _jettag_c_iterate_305_15.doStart(context, out);
                                while (_jettag_c_iterate_305_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_306_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_306_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_306_15.setRuntimeParent(_jettag_c_iterate_305_15);
                                    _jettag_c_setVariable_306_15.setTagInfo(_td_c_setVariable_306_15);
                                    _jettag_c_setVariable_306_15.doStart(context, out);
                                    _jettag_c_setVariable_306_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_308_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_308_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_308_17.setRuntimeParent(_jettag_c_iterate_305_15);
                                    _jettag_c_if_308_17.setTagInfo(_td_c_if_308_17);
                                    _jettag_c_if_308_17.doStart(context, out);
                                    while (_jettag_c_if_308_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_310_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_310_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_310_18.setRuntimeParent(_jettag_c_if_308_17);
                                        _jettag_c_iterate_310_18.setTagInfo(_td_c_iterate_310_18);
                                        _jettag_c_iterate_310_18.doStart(context, out);
                                        while (_jettag_c_iterate_310_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_311_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_311_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_311_19.setRuntimeParent(_jettag_c_iterate_310_18);
                                            _jettag_c_if_311_19.setTagInfo(_td_c_if_311_19);
                                            _jettag_c_if_311_19.doStart(context, out);
                                            while (_jettag_c_if_311_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_314_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_314_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_314_19.setRuntimeParent(_jettag_c_if_311_19);
                                                _jettag_c_if_314_19.setTagInfo(_td_c_if_314_19);
                                                _jettag_c_if_314_19.doStart(context, out);
                                                while (_jettag_c_if_314_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_315_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_315_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_315_21.setRuntimeParent(_jettag_c_if_314_19);
                                                    _jettag_c_if_315_21.setTagInfo(_td_c_if_315_21);
                                                    _jettag_c_if_315_21.doStart(context, out);
                                                    while (_jettag_c_if_315_21.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_317_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_317_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_317_18.setRuntimeParent(_jettag_c_if_315_21);
                                                        _jettag_c_if_317_18.setTagInfo(_td_c_if_317_18);
                                                        _jettag_c_if_317_18.doStart(context, out);
                                                        while (_jettag_c_if_317_18.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\taddDropDown(select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 318, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_317_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_317_18.doEnd();
                                                        _jettag_c_if_315_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_315_21.doEnd();
                                                    _jettag_c_if_314_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_314_19.doEnd();
                                                _jettag_c_if_311_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_311_19.doEnd();
                                            _jettag_c_iterate_310_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_310_18.doEnd();
                                        _jettag_c_if_308_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_308_17.doEnd();
                                    _jettag_c_iterate_305_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_305_15.doEnd();
                                _jettag_c_if_303_9.handleBodyContent(out);
                            }
                            _jettag_c_if_303_9.doEnd();
                            _jettag_c_iterate_300_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_300_6.doEnd();
                        _jettag_c_iterate_299_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_299_5.doEnd();
                    _jettag_c_iterate_298_4.handleBodyContent(out);
                }
                _jettag_c_iterate_298_4.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_331_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_331_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_331_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_331_1.setTagInfo(_td_f_message_331_1);
                _jettag_f_message_331_1.doStart(context, out);
                JET2Writer _jettag_f_message_331_1_saved_out = out;
                while (_jettag_f_message_331_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_331_1.handleBodyContent(out);
                }
                out = _jettag_f_message_331_1_saved_out;
                _jettag_f_message_331_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 333, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy populateEntityFromFields() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\trequest = (GenericRequest< ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 334, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy>)  ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 334, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.requestFactory.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 334, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Request();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tproxy = request.create(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 335, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy.class);");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_337_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_337_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_337_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_337_2.setTagInfo(_td_c_if_337_2);
                _jettag_c_if_337_2.doStart(context, out);
                while (_jettag_c_if_337_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_338_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_338_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_338_3.setRuntimeParent(_jettag_c_if_337_2);
                    _jettag_c_iterate_338_3.setTagInfo(_td_c_iterate_338_3);
                    _jettag_c_iterate_338_3.doStart(context, out);
                    while (_jettag_c_iterate_338_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_339_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_339_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_339_4.setRuntimeParent(_jettag_c_iterate_338_3);
                        _jettag_c_choose_339_4.setTagInfo(_td_c_choose_339_4);
                        _jettag_c_choose_339_4.doStart(context, out);
                        JET2Writer _jettag_c_choose_339_4_saved_out = out;
                        while (_jettag_c_choose_339_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_340_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_340_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_340_5.setRuntimeParent(_jettag_c_choose_339_4);
                            _jettag_c_when_340_5.setTagInfo(_td_c_when_340_5);
                            _jettag_c_when_340_5.doStart(context, out);
                            JET2Writer _jettag_c_when_340_5_saved_out = out;
                            while (_jettag_c_when_340_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 340, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getStringField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 340, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_340_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_340_5_saved_out;
                            _jettag_c_when_340_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_342_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_342_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_342_5.setRuntimeParent(_jettag_c_choose_339_4);
                            _jettag_c_when_342_5.setTagInfo(_td_c_when_342_5);
                            _jettag_c_when_342_5.doStart(context, out);
                            JET2Writer _jettag_c_when_342_5_saved_out = out;
                            while (_jettag_c_when_342_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 342, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 342, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_342_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_342_5_saved_out;
                            _jettag_c_when_342_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_344_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_344_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_344_5.setRuntimeParent(_jettag_c_choose_339_4);
                            _jettag_c_when_344_5.setTagInfo(_td_c_when_344_5);
                            _jettag_c_when_344_5.doStart(context, out);
                            JET2Writer _jettag_c_when_344_5_saved_out = out;
                            while (_jettag_c_when_344_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 344, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getDateField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 344, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_344_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_344_5_saved_out;
                            _jettag_c_when_344_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_346_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_346_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_346_5.setRuntimeParent(_jettag_c_choose_339_4);
                            _jettag_c_when_346_5.setTagInfo(_td_c_when_346_5);
                            _jettag_c_when_346_5.doStart(context, out);
                            JET2Writer _jettag_c_when_346_5_saved_out = out;
                            while (_jettag_c_when_346_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 346, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 346, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_346_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_346_5_saved_out;
                            _jettag_c_when_346_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_348_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_348_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_348_5.setRuntimeParent(_jettag_c_choose_339_4);
                            _jettag_c_when_348_5.setTagInfo(_td_c_when_348_5);
                            _jettag_c_when_348_5.doStart(context, out);
                            JET2Writer _jettag_c_when_348_5_saved_out = out;
                            while (_jettag_c_when_348_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 348, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getLongField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 348, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_348_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_348_5_saved_out;
                            _jettag_c_when_348_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_350_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_350_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_350_5.setRuntimeParent(_jettag_c_choose_339_4);
                            _jettag_c_when_350_5.setTagInfo(_td_c_when_350_5);
                            _jettag_c_when_350_5.doStart(context, out);
                            JET2Writer _jettag_c_when_350_5_saved_out = out;
                            while (_jettag_c_when_350_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 350, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getFloatField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 350, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_350_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_350_5_saved_out;
                            _jettag_c_when_350_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_352_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_352_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_352_5.setRuntimeParent(_jettag_c_choose_339_4);
                            _jettag_c_when_352_5.setTagInfo(_td_c_when_352_5);
                            _jettag_c_when_352_5.doStart(context, out);
                            JET2Writer _jettag_c_when_352_5_saved_out = out;
                            while (_jettag_c_when_352_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 352, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 352, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_352_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_352_5_saved_out;
                            _jettag_c_when_352_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_354_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_354_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_354_5.setRuntimeParent(_jettag_c_choose_339_4);
                            _jettag_c_when_354_5.setTagInfo(_td_c_when_354_5);
                            _jettag_c_when_354_5.doStart(context, out);
                            JET2Writer _jettag_c_when_354_5_saved_out = out;
                            while (_jettag_c_when_354_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 354, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 354, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_354_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_354_5_saved_out;
                            _jettag_c_when_354_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_356_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_356_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_356_5.setRuntimeParent(_jettag_c_choose_339_4);
                            _jettag_c_when_356_5.setTagInfo(_td_c_when_356_5);
                            _jettag_c_when_356_5.doStart(context, out);
                            JET2Writer _jettag_c_when_356_5_saved_out = out;
                            while (_jettag_c_when_356_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 356, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 356, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_356_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_356_5_saved_out;
                            _jettag_c_when_356_5.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_358_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_358_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_358_6.setRuntimeParent(_jettag_c_choose_339_4);
                            _jettag_c_otherwise_358_6.setTagInfo(_td_c_otherwise_358_6);
                            _jettag_c_otherwise_358_6.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_358_6_saved_out = out;
                            while (_jettag_c_otherwise_358_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_359_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_359_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_359_8.setRuntimeParent(_jettag_c_otherwise_358_6);
                                _jettag_c_iterate_359_8.setTagInfo(_td_c_iterate_359_8);
                                _jettag_c_iterate_359_8.doStart(context, out);
                                while (_jettag_c_iterate_359_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_360_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_360_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_360_10.setRuntimeParent(_jettag_c_iterate_359_8);
                                    _jettag_c_if_360_10.setTagInfo(_td_c_if_360_10);
                                    _jettag_c_if_360_10.doStart(context, out);
                                    while (_jettag_c_if_360_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tproxy.set");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 361, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("(");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 361, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".valueOf(getEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 361, 116)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\")));");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_360_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_360_10.doEnd();
                                    _jettag_c_iterate_359_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_359_8.doEnd();
                                _jettag_c_otherwise_358_6.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_358_6_saved_out;
                            _jettag_c_otherwise_358_6.doEnd();
                            _jettag_c_choose_339_4.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_339_4_saved_out;
                        _jettag_c_choose_339_4.doEnd();
                        _jettag_c_iterate_338_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_338_3.doEnd();
                    out.write(NL);         
                    _jettag_c_if_337_2.handleBodyContent(out);
                }
                _jettag_c_if_337_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_370_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_370_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_370_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_370_2.setTagInfo(_td_c_if_370_2);
                _jettag_c_if_370_2.doStart(context, out);
                while (_jettag_c_if_370_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_371_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_371_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_371_3.setRuntimeParent(_jettag_c_if_370_2);
                    _jettag_c_iterate_371_3.setTagInfo(_td_c_iterate_371_3);
                    _jettag_c_iterate_371_3.doStart(context, out);
                    while (_jettag_c_iterate_371_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_372_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_372_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_372_4.setRuntimeParent(_jettag_c_iterate_371_3);
                        _jettag_c_choose_372_4.setTagInfo(_td_c_choose_372_4);
                        _jettag_c_choose_372_4.doStart(context, out);
                        JET2Writer _jettag_c_choose_372_4_saved_out = out;
                        while (_jettag_c_choose_372_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_373_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_373_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_373_5.setRuntimeParent(_jettag_c_choose_372_4);
                            _jettag_c_when_373_5.setTagInfo(_td_c_when_373_5);
                            _jettag_c_when_373_5.doStart(context, out);
                            JET2Writer _jettag_c_when_373_5_saved_out = out;
                            while (_jettag_c_when_373_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 373, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getStringField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 373, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_373_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_373_5_saved_out;
                            _jettag_c_when_373_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_375_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_375_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_375_5.setRuntimeParent(_jettag_c_choose_372_4);
                            _jettag_c_when_375_5.setTagInfo(_td_c_when_375_5);
                            _jettag_c_when_375_5.doStart(context, out);
                            JET2Writer _jettag_c_when_375_5_saved_out = out;
                            while (_jettag_c_when_375_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 375, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 375, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_375_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_375_5_saved_out;
                            _jettag_c_when_375_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_377_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_377_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_377_5.setRuntimeParent(_jettag_c_choose_372_4);
                            _jettag_c_when_377_5.setTagInfo(_td_c_when_377_5);
                            _jettag_c_when_377_5.doStart(context, out);
                            JET2Writer _jettag_c_when_377_5_saved_out = out;
                            while (_jettag_c_when_377_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 377, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getDateField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 377, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_377_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_377_5_saved_out;
                            _jettag_c_when_377_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_379_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_379_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_379_5.setRuntimeParent(_jettag_c_choose_372_4);
                            _jettag_c_when_379_5.setTagInfo(_td_c_when_379_5);
                            _jettag_c_when_379_5.doStart(context, out);
                            JET2Writer _jettag_c_when_379_5_saved_out = out;
                            while (_jettag_c_when_379_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 379, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 379, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_379_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_379_5_saved_out;
                            _jettag_c_when_379_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_381_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_381_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_381_5.setRuntimeParent(_jettag_c_choose_372_4);
                            _jettag_c_when_381_5.setTagInfo(_td_c_when_381_5);
                            _jettag_c_when_381_5.doStart(context, out);
                            JET2Writer _jettag_c_when_381_5_saved_out = out;
                            while (_jettag_c_when_381_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 381, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getLongField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 381, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_381_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_381_5_saved_out;
                            _jettag_c_when_381_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_383_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_383_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_383_5.setRuntimeParent(_jettag_c_choose_372_4);
                            _jettag_c_when_383_5.setTagInfo(_td_c_when_383_5);
                            _jettag_c_when_383_5.doStart(context, out);
                            JET2Writer _jettag_c_when_383_5_saved_out = out;
                            while (_jettag_c_when_383_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 383, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getFloatField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 383, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_383_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_383_5_saved_out;
                            _jettag_c_when_383_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_385_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_385_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_385_5.setRuntimeParent(_jettag_c_choose_372_4);
                            _jettag_c_when_385_5.setTagInfo(_td_c_when_385_5);
                            _jettag_c_when_385_5.doStart(context, out);
                            JET2Writer _jettag_c_when_385_5_saved_out = out;
                            while (_jettag_c_when_385_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 385, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 385, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_385_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_385_5_saved_out;
                            _jettag_c_when_385_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_387_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_387_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_387_5.setRuntimeParent(_jettag_c_choose_372_4);
                            _jettag_c_when_387_5.setTagInfo(_td_c_when_387_5);
                            _jettag_c_when_387_5.doStart(context, out);
                            JET2Writer _jettag_c_when_387_5_saved_out = out;
                            while (_jettag_c_when_387_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 387, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 387, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_387_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_387_5_saved_out;
                            _jettag_c_when_387_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_389_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_389_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_389_5.setRuntimeParent(_jettag_c_choose_372_4);
                            _jettag_c_when_389_5.setTagInfo(_td_c_when_389_5);
                            _jettag_c_when_389_5.doStart(context, out);
                            JET2Writer _jettag_c_when_389_5_saved_out = out;
                            while (_jettag_c_when_389_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 389, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 389, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_389_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_389_5_saved_out;
                            _jettag_c_when_389_5.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_391_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_391_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_391_6.setRuntimeParent(_jettag_c_choose_372_4);
                            _jettag_c_otherwise_391_6.setTagInfo(_td_c_otherwise_391_6);
                            _jettag_c_otherwise_391_6.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_391_6_saved_out = out;
                            while (_jettag_c_otherwise_391_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_392_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_392_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_392_8.setRuntimeParent(_jettag_c_otherwise_391_6);
                                _jettag_c_iterate_392_8.setTagInfo(_td_c_iterate_392_8);
                                _jettag_c_iterate_392_8.doStart(context, out);
                                while (_jettag_c_iterate_392_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_393_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_393_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_393_10.setRuntimeParent(_jettag_c_iterate_392_8);
                                    _jettag_c_if_393_10.setTagInfo(_td_c_if_393_10);
                                    _jettag_c_if_393_10.doStart(context, out);
                                    while (_jettag_c_if_393_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tproxy.set");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 394, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("(");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 394, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".valueOf(getEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 394, 116)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\")));");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_393_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_393_10.doEnd();
                                    _jettag_c_iterate_392_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_392_8.doEnd();
                                _jettag_c_otherwise_391_6.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_391_6_saved_out;
                            _jettag_c_otherwise_391_6.doEnd();
                            _jettag_c_choose_372_4.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_372_4_saved_out;
                        _jettag_c_choose_372_4.doEnd();
                        _jettag_c_iterate_371_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_371_3.doEnd();
                    _jettag_c_if_370_2.handleBodyContent(out);
                }
                _jettag_c_if_370_2.doEnd();
                // process base class 
                RuntimeTagElement _jettag_c_iterate_402_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_402_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_402_3.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_402_3.setTagInfo(_td_c_iterate_402_3);
                _jettag_c_iterate_402_3.doStart(context, out);
                while (_jettag_c_iterate_402_3.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_403_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_403_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_403_4.setRuntimeParent(_jettag_c_iterate_402_3);
                    _jettag_c_choose_403_4.setTagInfo(_td_c_choose_403_4);
                    _jettag_c_choose_403_4.doStart(context, out);
                    JET2Writer _jettag_c_choose_403_4_saved_out = out;
                    while (_jettag_c_choose_403_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_404_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_404_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_404_5.setRuntimeParent(_jettag_c_choose_403_4);
                        _jettag_c_when_404_5.setTagInfo(_td_c_when_404_5);
                        _jettag_c_when_404_5.doStart(context, out);
                        JET2Writer _jettag_c_when_404_5_saved_out = out;
                        while (_jettag_c_when_404_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 404, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getStringField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 404, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_404_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_404_5_saved_out;
                        _jettag_c_when_404_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_406_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_406_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_406_5.setRuntimeParent(_jettag_c_choose_403_4);
                        _jettag_c_when_406_5.setTagInfo(_td_c_when_406_5);
                        _jettag_c_when_406_5.doStart(context, out);
                        JET2Writer _jettag_c_when_406_5_saved_out = out;
                        while (_jettag_c_when_406_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 406, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 406, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_406_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_406_5_saved_out;
                        _jettag_c_when_406_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_408_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_408_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_408_5.setRuntimeParent(_jettag_c_choose_403_4);
                        _jettag_c_when_408_5.setTagInfo(_td_c_when_408_5);
                        _jettag_c_when_408_5.doStart(context, out);
                        JET2Writer _jettag_c_when_408_5_saved_out = out;
                        while (_jettag_c_when_408_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 408, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getDateField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 408, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_408_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_408_5_saved_out;
                        _jettag_c_when_408_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_410_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_410_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_410_5.setRuntimeParent(_jettag_c_choose_403_4);
                        _jettag_c_when_410_5.setTagInfo(_td_c_when_410_5);
                        _jettag_c_when_410_5.doStart(context, out);
                        JET2Writer _jettag_c_when_410_5_saved_out = out;
                        while (_jettag_c_when_410_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 410, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 410, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_410_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_410_5_saved_out;
                        _jettag_c_when_410_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_412_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_412_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_412_5.setRuntimeParent(_jettag_c_choose_403_4);
                        _jettag_c_when_412_5.setTagInfo(_td_c_when_412_5);
                        _jettag_c_when_412_5.doStart(context, out);
                        JET2Writer _jettag_c_when_412_5_saved_out = out;
                        while (_jettag_c_when_412_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 412, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getLongField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 412, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_412_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_412_5_saved_out;
                        _jettag_c_when_412_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_414_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_414_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_414_5.setRuntimeParent(_jettag_c_choose_403_4);
                        _jettag_c_when_414_5.setTagInfo(_td_c_when_414_5);
                        _jettag_c_when_414_5.doStart(context, out);
                        JET2Writer _jettag_c_when_414_5_saved_out = out;
                        while (_jettag_c_when_414_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 414, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getFloatField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 414, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_414_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_414_5_saved_out;
                        _jettag_c_when_414_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_416_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_416_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_416_5.setRuntimeParent(_jettag_c_choose_403_4);
                        _jettag_c_when_416_5.setTagInfo(_td_c_when_416_5);
                        _jettag_c_when_416_5.doStart(context, out);
                        JET2Writer _jettag_c_when_416_5_saved_out = out;
                        while (_jettag_c_when_416_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 416, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getImageField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 416, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_416_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_416_5_saved_out;
                        _jettag_c_when_416_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_418_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_418_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_418_5.setRuntimeParent(_jettag_c_choose_403_4);
                        _jettag_c_when_418_5.setTagInfo(_td_c_when_418_5);
                        _jettag_c_when_418_5.doStart(context, out);
                        JET2Writer _jettag_c_when_418_5_saved_out = out;
                        while (_jettag_c_when_418_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 418, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getRichTextField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 418, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_418_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_418_5_saved_out;
                        _jettag_c_when_418_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_420_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_420_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_420_5.setRuntimeParent(_jettag_c_choose_403_4);
                        _jettag_c_when_420_5.setTagInfo(_td_c_when_420_5);
                        _jettag_c_when_420_5.doStart(context, out);
                        JET2Writer _jettag_c_when_420_5_saved_out = out;
                        while (_jettag_c_when_420_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 420, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 420, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_420_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_420_5_saved_out;
                        _jettag_c_when_420_5.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_422_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_422_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_422_6.setRuntimeParent(_jettag_c_choose_403_4);
                        _jettag_c_otherwise_422_6.setTagInfo(_td_c_otherwise_422_6);
                        _jettag_c_otherwise_422_6.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_422_6_saved_out = out;
                        while (_jettag_c_otherwise_422_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_423_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_423_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_423_8.setRuntimeParent(_jettag_c_otherwise_422_6);
                            _jettag_c_iterate_423_8.setTagInfo(_td_c_iterate_423_8);
                            _jettag_c_iterate_423_8.doStart(context, out);
                            while (_jettag_c_iterate_423_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_424_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_424_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_424_10.setRuntimeParent(_jettag_c_iterate_423_8);
                                _jettag_c_if_424_10.setTagInfo(_td_c_if_424_10);
                                _jettag_c_if_424_10.doStart(context, out);
                                while (_jettag_c_if_424_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\tproxy.set");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 425, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("(");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 425, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".valueOf(getEnumField(\"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 425, 116)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\")));");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_424_10.handleBodyContent(out);
                                }
                                _jettag_c_if_424_10.doEnd();
                                _jettag_c_iterate_423_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_423_8.doEnd();
                            _jettag_c_otherwise_422_6.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_422_6_saved_out;
                        _jettag_c_otherwise_422_6.doEnd();
                        _jettag_c_choose_403_4.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_403_4_saved_out;
                    _jettag_c_choose_403_4.doEnd();
                    _jettag_c_iterate_402_3.handleBodyContent(out);
                }
                _jettag_c_iterate_402_3.doEnd();
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process dropdowns one tone and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_433_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_433_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_433_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_433_4.setTagInfo(_td_c_iterate_433_4);
                _jettag_c_iterate_433_4.doStart(context, out);
                while (_jettag_c_iterate_433_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_434_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_434_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_434_5.setRuntimeParent(_jettag_c_iterate_433_4);
                    _jettag_c_iterate_434_5.setTagInfo(_td_c_iterate_434_5);
                    _jettag_c_iterate_434_5.doStart(context, out);
                    while (_jettag_c_iterate_434_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_435_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_435_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_435_6.setRuntimeParent(_jettag_c_iterate_434_5);
                        _jettag_c_iterate_435_6.setTagInfo(_td_c_iterate_435_6);
                        _jettag_c_iterate_435_6.doStart(context, out);
                        while (_jettag_c_iterate_435_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_436_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_436_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_436_7.setRuntimeParent(_jettag_c_iterate_435_6);
                            _jettag_c_setVariable_436_7.setTagInfo(_td_c_setVariable_436_7);
                            _jettag_c_setVariable_436_7.doStart(context, out);
                            _jettag_c_setVariable_436_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_438_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_438_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_438_9.setRuntimeParent(_jettag_c_iterate_435_6);
                            _jettag_c_if_438_9.setTagInfo(_td_c_if_438_9);
                            _jettag_c_if_438_9.doStart(context, out);
                            while (_jettag_c_if_438_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_440_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_440_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_440_15.setRuntimeParent(_jettag_c_if_438_9);
                                _jettag_c_iterate_440_15.setTagInfo(_td_c_iterate_440_15);
                                _jettag_c_iterate_440_15.doStart(context, out);
                                while (_jettag_c_iterate_440_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_441_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_441_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_441_15.setRuntimeParent(_jettag_c_iterate_440_15);
                                    _jettag_c_setVariable_441_15.setTagInfo(_td_c_setVariable_441_15);
                                    _jettag_c_setVariable_441_15.doStart(context, out);
                                    _jettag_c_setVariable_441_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_443_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_443_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_443_17.setRuntimeParent(_jettag_c_iterate_440_15);
                                    _jettag_c_if_443_17.setTagInfo(_td_c_if_443_17);
                                    _jettag_c_if_443_17.doStart(context, out);
                                    while (_jettag_c_if_443_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_445_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_445_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_445_18.setRuntimeParent(_jettag_c_if_443_17);
                                        _jettag_c_iterate_445_18.setTagInfo(_td_c_iterate_445_18);
                                        _jettag_c_iterate_445_18.doStart(context, out);
                                        while (_jettag_c_iterate_445_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_446_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_446_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_446_19.setRuntimeParent(_jettag_c_iterate_445_18);
                                            _jettag_c_if_446_19.setTagInfo(_td_c_if_446_19);
                                            _jettag_c_if_446_19.doStart(context, out);
                                            while (_jettag_c_if_446_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_449_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_449_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_449_19.setRuntimeParent(_jettag_c_if_446_19);
                                                _jettag_c_if_449_19.setTagInfo(_td_c_if_449_19);
                                                _jettag_c_if_449_19.doStart(context, out);
                                                while (_jettag_c_if_449_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_450_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_450_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_450_21.setRuntimeParent(_jettag_c_if_449_19);
                                                    _jettag_c_if_450_21.setTagInfo(_td_c_if_450_21);
                                                    _jettag_c_if_450_21.doStart(context, out);
                                                    while (_jettag_c_if_450_21.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_452_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_452_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_452_18.setRuntimeParent(_jettag_c_if_450_21);
                                                        _jettag_c_if_452_18.setTagInfo(_td_c_if_452_18);
                                                        _jettag_c_if_452_18.doStart(context, out);
                                                        while (_jettag_c_if_452_18.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\tproxy.set");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($class2/@name)}", 453, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("(select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 453, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel.getProxy());");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_452_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_452_18.doEnd();
                                                        _jettag_c_if_450_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_450_21.doEnd();
                                                    _jettag_c_if_449_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_449_19.doEnd();
                                                _jettag_c_if_446_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_446_19.doEnd();
                                            _jettag_c_iterate_445_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_445_18.doEnd();
                                        _jettag_c_if_443_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_443_17.doEnd();
                                    _jettag_c_iterate_440_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_440_15.doEnd();
                                _jettag_c_if_438_9.handleBodyContent(out);
                            }
                            _jettag_c_if_438_9.doEnd();
                            _jettag_c_iterate_435_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_435_6.doEnd();
                        _jettag_c_iterate_434_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_434_5.doEnd();
                    _jettag_c_iterate_433_4.handleBodyContent(out);
                }
                _jettag_c_iterate_433_4.doEnd();
                out.write("\t\treturn proxy;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_467_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_467_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_467_1.setRuntimeParent(_jettag_f_bundle_3_1);
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
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void configure() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_473_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_473_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_473_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_473_1.setTagInfo(_td_f_message_473_1);
                _jettag_f_message_473_1.doStart(context, out);
                JET2Writer _jettag_f_message_473_1_saved_out = out;
                while (_jettag_f_message_473_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_473_1.handleBodyContent(out);
                }
                out = _jettag_f_message_473_1_saved_out;
                _jettag_f_message_473_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void successfullyCreated() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 476, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().clear();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 477, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tnew ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 478, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanely(ReadAllTableType.READALL));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_481_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_481_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_481_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_481_1.setTagInfo(_td_f_message_481_1);
                _jettag_f_message_481_1.doStart(context, out);
                JET2Writer _jettag_f_message_481_1_saved_out = out;
                while (_jettag_f_message_481_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_481_1.handleBodyContent(out);
                }
                out = _jettag_f_message_481_1_saved_out;
                _jettag_f_message_481_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void setParent() {");  //$NON-NLS-1$        
                out.write(NL);         
                // check to see is this class is a comp first
                RuntimeTagElement _jettag_c_if_485_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_485_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_485_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_485_2.setTagInfo(_td_c_if_485_2);
                _jettag_c_if_485_2.doStart(context, out);
                while (_jettag_c_if_485_2.okToProcessBody()) {
                    // process compsition associations
                    RuntimeTagElement _jettag_c_iterate_487_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_487_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_487_2.setRuntimeParent(_jettag_c_if_485_2);
                    _jettag_c_iterate_487_2.setTagInfo(_td_c_iterate_487_2);
                    _jettag_c_iterate_487_2.doStart(context, out);
                    while (_jettag_c_iterate_487_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_488_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_488_2); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_488_2.setRuntimeParent(_jettag_c_iterate_487_2);
                        _jettag_c_iterate_488_2.setTagInfo(_td_c_iterate_488_2);
                        _jettag_c_iterate_488_2.doStart(context, out);
                        while (_jettag_c_iterate_488_2.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_489_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_489_3); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_489_3.setRuntimeParent(_jettag_c_iterate_488_2);
                            _jettag_c_iterate_489_3.setTagInfo(_td_c_iterate_489_3);
                            _jettag_c_iterate_489_3.doStart(context, out);
                            while (_jettag_c_iterate_489_3.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_490_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_490_4); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_490_4.setRuntimeParent(_jettag_c_iterate_489_3);
                                _jettag_c_setVariable_490_4.setTagInfo(_td_c_setVariable_490_4);
                                _jettag_c_setVariable_490_4.doStart(context, out);
                                _jettag_c_setVariable_490_4.doEnd();
                                // check is the association is corresponding to the class  
                                RuntimeTagElement _jettag_c_if_492_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_492_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_492_6.setRuntimeParent(_jettag_c_iterate_489_3);
                                _jettag_c_if_492_6.setTagInfo(_td_c_if_492_6);
                                _jettag_c_if_492_6.doStart(context, out);
                                while (_jettag_c_if_492_6.okToProcessBody()) {
                                    // process only compositions
                                    // iterate over the iterations ends  
                                    RuntimeTagElement _jettag_c_iterate_495_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_495_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_iterate_495_12.setRuntimeParent(_jettag_c_if_492_6);
                                    _jettag_c_iterate_495_12.setTagInfo(_td_c_iterate_495_12);
                                    _jettag_c_iterate_495_12.doStart(context, out);
                                    while (_jettag_c_iterate_495_12.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_496_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_496_12); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_496_12.setRuntimeParent(_jettag_c_iterate_495_12);
                                        _jettag_c_setVariable_496_12.setTagInfo(_td_c_setVariable_496_12);
                                        _jettag_c_setVariable_496_12.doStart(context, out);
                                        _jettag_c_setVariable_496_12.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_498_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_498_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_498_14.setRuntimeParent(_jettag_c_iterate_495_12);
                                        _jettag_c_if_498_14.setTagInfo(_td_c_if_498_14);
                                        _jettag_c_if_498_14.doStart(context, out);
                                        while (_jettag_c_if_498_14.okToProcessBody()) {
                                            // check if this is a comp
                                            RuntimeTagElement _jettag_c_if_500_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_500_14); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_500_14.setRuntimeParent(_jettag_c_if_498_14);
                                            _jettag_c_if_500_14.setTagInfo(_td_c_if_500_14);
                                            _jettag_c_if_500_14.doStart(context, out);
                                            while (_jettag_c_if_500_14.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_502_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_502_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_502_15.setRuntimeParent(_jettag_c_if_500_14);
                                                _jettag_c_iterate_502_15.setTagInfo(_td_c_iterate_502_15);
                                                _jettag_c_iterate_502_15.doStart(context, out);
                                                while (_jettag_c_iterate_502_15.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_503_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_503_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_503_16.setRuntimeParent(_jettag_c_iterate_502_15);
                                                    _jettag_c_if_503_16.setTagInfo(_td_c_if_503_16);
                                                    _jettag_c_if_503_16.doStart(context, out);
                                                    while (_jettag_c_if_503_16.okToProcessBody()) {
                                                        // check to see if class2 is parent and child
                                                        RuntimeTagElement _jettag_c_if_505_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_505_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_505_11.setRuntimeParent(_jettag_c_if_503_16);
                                                        _jettag_c_if_505_11.setTagInfo(_td_c_if_505_11);
                                                        _jettag_c_if_505_11.doStart(context, out);
                                                        while (_jettag_c_if_505_11.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_506_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_506_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_506_11.setRuntimeParent(_jettag_c_if_505_11);
                                                            _jettag_c_if_506_11.setTagInfo(_td_c_if_506_11);
                                                            _jettag_c_if_506_11.doStart(context, out);
                                                            while (_jettag_c_if_506_11.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\t// this is a issue with gwt rf");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t// http://yalamanchili.info:8080/jira/browse/YCORE-71");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 509, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy parent = ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 509, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.requestFactory.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 509, 91)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Request().create(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 509, 136)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy.class);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\tparent.setId(TreeAbstract");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 510, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panely.instance().getEntity().getId());");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\tproxy.set");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 511, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("(parent);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_506_11.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_506_11.doEnd();
                                                            // has parent and no children
                                                            RuntimeTagElement _jettag_c_if_514_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_514_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_514_11.setRuntimeParent(_jettag_c_if_505_11);
                                                            _jettag_c_if_514_11.setTagInfo(_td_c_if_514_11);
                                                            _jettag_c_if_514_11.doStart(context, out);
                                                            while (_jettag_c_if_514_11.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\tproxy.set");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 515, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("((");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 515, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy)Tree");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 515, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panely.instance().getEntity());");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_514_11.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_514_11.doEnd();
                                                            _jettag_c_if_505_11.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_505_11.doEnd();
                                                        // no parent and has children
                                                        RuntimeTagElement _jettag_c_if_519_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_519_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_519_12.setRuntimeParent(_jettag_c_if_503_16);
                                                        _jettag_c_if_519_12.setTagInfo(_td_c_if_519_12);
                                                        _jettag_c_if_519_12.doStart(context, out);
                                                        while (_jettag_c_if_519_12.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_520_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_520_12); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_520_12.setRuntimeParent(_jettag_c_if_519_12);
                                                            _jettag_c_if_520_12.setTagInfo(_td_c_if_520_12);
                                                            _jettag_c_if_520_12.doStart(context, out);
                                                            while (_jettag_c_if_520_12.okToProcessBody()) {
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t// this is a issue with gwt rf");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t// http://yalamanchili.info:8080/jira/browse/YCORE-71");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 523, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy parent = ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 523, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Welcome.requestFactory.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 523, 92)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Request().create(");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 523, 137)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Proxy.class);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tparent.setId(TreeAbstract");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 524, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panely.instance().getEntity().getId());");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("\t\t\t\t\t\t\t\t\t\t\tproxy.set");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 525, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("(parent);");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_520_12.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_520_12.doEnd();
                                                            _jettag_c_if_519_12.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_519_12.doEnd();
                                                        _jettag_c_if_503_16.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_503_16.doEnd();
                                                    _jettag_c_iterate_502_15.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_502_15.doEnd();
                                                _jettag_c_if_500_14.handleBodyContent(out);
                                            }
                                            _jettag_c_if_500_14.doEnd();
                                            _jettag_c_if_498_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_498_14.doEnd();
                                        _jettag_c_iterate_495_12.handleBodyContent(out);
                                    }
                                    _jettag_c_iterate_495_12.doEnd();
                                    _jettag_c_if_492_6.handleBodyContent(out);
                                }
                                _jettag_c_if_492_6.doEnd();
                                _jettag_c_iterate_489_3.handleBodyContent(out);
                            }
                            _jettag_c_iterate_489_3.doEnd();
                            _jettag_c_iterate_488_2.handleBodyContent(out);
                        }
                        _jettag_c_iterate_488_2.doEnd();
                        _jettag_c_iterate_487_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_487_2.doEnd();
                    _jettag_c_if_485_2.handleBodyContent(out);
                }
                _jettag_c_if_485_2.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_539_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_539_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_539_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_539_1.setTagInfo(_td_f_message_539_1);
                _jettag_f_message_539_1.doStart(context, out);
                JET2Writer _jettag_f_message_539_1_saved_out = out;
                while (_jettag_f_message_539_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_539_1.handleBodyContent(out);
                }
                out = _jettag_f_message_539_1_saved_out;
                _jettag_f_message_539_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void successfullyAdded() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 542, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().clear();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 543, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tnew ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 544, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanely(ReadAllTableType.READALL));");  //$NON-NLS-1$        
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
