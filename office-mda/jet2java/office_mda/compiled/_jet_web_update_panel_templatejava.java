package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_update_panel_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_update_panel_templatejava() {
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
    private static final TagInfo _td_c_if_8_2 = new TagInfo("c:if", //$NON-NLS-1$
            8, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_9_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            9, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_10_5 = new TagInfo("c:choose", //$NON-NLS-1$
            10, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_11_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            11, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_12_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            12, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_13_10 = new TagInfo("c:if", //$NON-NLS-1$
            13, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_22_2 = new TagInfo("c:if", //$NON-NLS-1$
            22, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_23_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            23, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_24_5 = new TagInfo("c:choose", //$NON-NLS-1$
            24, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_25_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            25, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_26_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            26, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_27_10 = new TagInfo("c:if", //$NON-NLS-1$
            27, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_36_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            36, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_37_5 = new TagInfo("c:choose", //$NON-NLS-1$
            37, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_38_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            38, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_39_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            39, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_40_10 = new TagInfo("c:if", //$NON-NLS-1$
            40, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_55_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            55, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_56_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            56, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_57_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            57, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_58_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            58, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_60_6 = new TagInfo("c:if", //$NON-NLS-1$
            60, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_62_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            62, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_63_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            63, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_65_14 = new TagInfo("c:if", //$NON-NLS-1$
            65, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
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
    private static final TagInfo _td_c_if_71_16 = new TagInfo("c:if", //$NON-NLS-1$
            71, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_72_18 = new TagInfo("c:if", //$NON-NLS-1$
            72, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_75_18 = new TagInfo("c:if", //$NON-NLS-1$
            75, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_76_18 = new TagInfo("c:if", //$NON-NLS-1$
            76, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_90_1 = new TagInfo("f:message", //$NON-NLS-1$
            90, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_94_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            94, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_95_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            95, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_96_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            96, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_97_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            97, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_99_6 = new TagInfo("c:if", //$NON-NLS-1$
            99, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_101_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            101, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_102_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            102, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_104_14 = new TagInfo("c:if", //$NON-NLS-1$
            104, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_106_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            106, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_107_16 = new TagInfo("c:if", //$NON-NLS-1$
            107, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_111_16 = new TagInfo("c:if", //$NON-NLS-1$
            111, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_112_18 = new TagInfo("c:if", //$NON-NLS-1$
            112, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_114_18 = new TagInfo("c:if", //$NON-NLS-1$
            114, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_115_1 = new TagInfo("f:message", //$NON-NLS-1$
            115, 1,
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
    private static final TagInfo _td_c_if_138_4 = new TagInfo("c:if", //$NON-NLS-1$
            138, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_139_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            139, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_140_5 = new TagInfo("c:choose", //$NON-NLS-1$
            140, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_141_6 = new TagInfo("c:when", //$NON-NLS-1$
            141, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_143_6 = new TagInfo("c:when", //$NON-NLS-1$
            143, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_145_6 = new TagInfo("c:when", //$NON-NLS-1$
            145, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_147_6 = new TagInfo("c:when", //$NON-NLS-1$
            147, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_149_6 = new TagInfo("c:when", //$NON-NLS-1$
            149, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_151_6 = new TagInfo("c:when", //$NON-NLS-1$
            151, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_153_6 = new TagInfo("c:when", //$NON-NLS-1$
            153, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_155_6 = new TagInfo("c:when", //$NON-NLS-1$
            155, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_157_6 = new TagInfo("c:when", //$NON-NLS-1$
            157, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_159_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            159, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_160_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            160, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_161_10 = new TagInfo("c:if", //$NON-NLS-1$
            161, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_170_4 = new TagInfo("c:if", //$NON-NLS-1$
            170, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_171_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            171, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_172_5 = new TagInfo("c:choose", //$NON-NLS-1$
            172, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_173_6 = new TagInfo("c:when", //$NON-NLS-1$
            173, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_175_6 = new TagInfo("c:when", //$NON-NLS-1$
            175, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_177_6 = new TagInfo("c:when", //$NON-NLS-1$
            177, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_179_6 = new TagInfo("c:when", //$NON-NLS-1$
            179, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_181_6 = new TagInfo("c:when", //$NON-NLS-1$
            181, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_183_6 = new TagInfo("c:when", //$NON-NLS-1$
            183, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_185_6 = new TagInfo("c:when", //$NON-NLS-1$
            185, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_187_6 = new TagInfo("c:when", //$NON-NLS-1$
            187, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_189_6 = new TagInfo("c:when", //$NON-NLS-1$
            189, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_191_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            191, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_192_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            192, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_193_10 = new TagInfo("c:if", //$NON-NLS-1$
            193, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_202_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            202, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_203_5 = new TagInfo("c:choose", //$NON-NLS-1$
            203, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_204_6 = new TagInfo("c:when", //$NON-NLS-1$
            204, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_206_6 = new TagInfo("c:when", //$NON-NLS-1$
            206, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_208_6 = new TagInfo("c:when", //$NON-NLS-1$
            208, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_210_6 = new TagInfo("c:when", //$NON-NLS-1$
            210, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_212_6 = new TagInfo("c:when", //$NON-NLS-1$
            212, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_214_6 = new TagInfo("c:when", //$NON-NLS-1$
            214, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_216_6 = new TagInfo("c:when", //$NON-NLS-1$
            216, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
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
    private static final TagInfo _td_c_otherwise_222_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            222, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_223_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            223, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_224_10 = new TagInfo("c:if", //$NON-NLS-1$
            224, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_234_1 = new TagInfo("f:message", //$NON-NLS-1$
            234, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_238_2 = new TagInfo("c:if", //$NON-NLS-1$
            238, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_239_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            239, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_240_4 = new TagInfo("c:choose", //$NON-NLS-1$
            240, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_241_5 = new TagInfo("c:when", //$NON-NLS-1$
            241, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_243_5 = new TagInfo("c:when", //$NON-NLS-1$
            243, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_245_5 = new TagInfo("c:when", //$NON-NLS-1$
            245, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_247_5 = new TagInfo("c:when", //$NON-NLS-1$
            247, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_249_5 = new TagInfo("c:when", //$NON-NLS-1$
            249, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_251_5 = new TagInfo("c:when", //$NON-NLS-1$
            251, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_253_5 = new TagInfo("c:when", //$NON-NLS-1$
            253, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_255_5 = new TagInfo("c:when", //$NON-NLS-1$
            255, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_257_5 = new TagInfo("c:when", //$NON-NLS-1$
            257, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_259_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            259, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_260_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            260, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_261_10 = new TagInfo("c:if", //$NON-NLS-1$
            261, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_270_2 = new TagInfo("c:if", //$NON-NLS-1$
            270, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_271_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            271, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_272_4 = new TagInfo("c:choose", //$NON-NLS-1$
            272, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_273_5 = new TagInfo("c:when", //$NON-NLS-1$
            273, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_275_5 = new TagInfo("c:when", //$NON-NLS-1$
            275, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_277_5 = new TagInfo("c:when", //$NON-NLS-1$
            277, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_279_5 = new TagInfo("c:when", //$NON-NLS-1$
            279, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_281_5 = new TagInfo("c:when", //$NON-NLS-1$
            281, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_283_5 = new TagInfo("c:when", //$NON-NLS-1$
            283, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_285_5 = new TagInfo("c:when", //$NON-NLS-1$
            285, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_287_5 = new TagInfo("c:when", //$NON-NLS-1$
            287, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_289_5 = new TagInfo("c:when", //$NON-NLS-1$
            289, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_291_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            291, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_292_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            292, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_293_10 = new TagInfo("c:if", //$NON-NLS-1$
            293, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_302_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            302, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_303_4 = new TagInfo("c:choose", //$NON-NLS-1$
            303, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_304_5 = new TagInfo("c:when", //$NON-NLS-1$
            304, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_306_5 = new TagInfo("c:when", //$NON-NLS-1$
            306, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_308_5 = new TagInfo("c:when", //$NON-NLS-1$
            308, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_310_5 = new TagInfo("c:when", //$NON-NLS-1$
            310, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_312_5 = new TagInfo("c:when", //$NON-NLS-1$
            312, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_314_5 = new TagInfo("c:when", //$NON-NLS-1$
            314, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_316_5 = new TagInfo("c:when", //$NON-NLS-1$
            316, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_318_5 = new TagInfo("c:when", //$NON-NLS-1$
            318, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_320_5 = new TagInfo("c:when", //$NON-NLS-1$
            320, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_322_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            322, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_323_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            323, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_324_10 = new TagInfo("c:if", //$NON-NLS-1$
            324, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_333_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            333, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_334_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            334, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_335_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            335, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_336_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            336, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_338_9 = new TagInfo("c:if", //$NON-NLS-1$
            338, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_340_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            340, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_341_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            341, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_343_17 = new TagInfo("c:if", //$NON-NLS-1$
            343, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_345_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            345, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_346_19 = new TagInfo("c:if", //$NON-NLS-1$
            346, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_349_19 = new TagInfo("c:if", //$NON-NLS-1$
            349, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_350_21 = new TagInfo("c:if", //$NON-NLS-1$
            350, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_352_18 = new TagInfo("c:if", //$NON-NLS-1$
            352, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_368_1 = new TagInfo("f:message", //$NON-NLS-1$
            368, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_378_1 = new TagInfo("f:message", //$NON-NLS-1$
            378, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_384_1 = new TagInfo("f:message", //$NON-NLS-1$
            384, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_390_1 = new TagInfo("f:message", //$NON-NLS-1$
            390, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_394_2 = new TagInfo("c:if", //$NON-NLS-1$
            394, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_395_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            395, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_396_5 = new TagInfo("c:choose", //$NON-NLS-1$
            396, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_397_6 = new TagInfo("c:when", //$NON-NLS-1$
            397, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_399_6 = new TagInfo("c:when", //$NON-NLS-1$
            399, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_401_6 = new TagInfo("c:when", //$NON-NLS-1$
            401, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_403_6 = new TagInfo("c:when", //$NON-NLS-1$
            403, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_405_6 = new TagInfo("c:when", //$NON-NLS-1$
            405, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_407_6 = new TagInfo("c:when", //$NON-NLS-1$
            407, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_409_6 = new TagInfo("c:when", //$NON-NLS-1$
            409, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_411_6 = new TagInfo("c:when", //$NON-NLS-1$
            411, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_413_6 = new TagInfo("c:when", //$NON-NLS-1$
            413, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_415_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            415, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_416_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            416, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_417_10 = new TagInfo("c:if", //$NON-NLS-1$
            417, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_426_2 = new TagInfo("c:if", //$NON-NLS-1$
            426, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_427_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            427, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_428_5 = new TagInfo("c:choose", //$NON-NLS-1$
            428, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_429_6 = new TagInfo("c:when", //$NON-NLS-1$
            429, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_431_6 = new TagInfo("c:when", //$NON-NLS-1$
            431, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_433_6 = new TagInfo("c:when", //$NON-NLS-1$
            433, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_435_6 = new TagInfo("c:when", //$NON-NLS-1$
            435, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_437_6 = new TagInfo("c:when", //$NON-NLS-1$
            437, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_439_6 = new TagInfo("c:when", //$NON-NLS-1$
            439, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_441_6 = new TagInfo("c:when", //$NON-NLS-1$
            441, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_443_6 = new TagInfo("c:when", //$NON-NLS-1$
            443, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_445_6 = new TagInfo("c:when", //$NON-NLS-1$
            445, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_447_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            447, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_448_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            448, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_449_10 = new TagInfo("c:if", //$NON-NLS-1$
            449, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_458_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            458, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_459_5 = new TagInfo("c:choose", //$NON-NLS-1$
            459, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_460_6 = new TagInfo("c:when", //$NON-NLS-1$
            460, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_462_6 = new TagInfo("c:when", //$NON-NLS-1$
            462, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_464_6 = new TagInfo("c:when", //$NON-NLS-1$
            464, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_466_6 = new TagInfo("c:when", //$NON-NLS-1$
            466, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_468_6 = new TagInfo("c:when", //$NON-NLS-1$
            468, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_470_6 = new TagInfo("c:when", //$NON-NLS-1$
            470, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_472_6 = new TagInfo("c:when", //$NON-NLS-1$
            472, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_474_6 = new TagInfo("c:when", //$NON-NLS-1$
            474, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_476_6 = new TagInfo("c:when", //$NON-NLS-1$
            476, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_478_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            478, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_479_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            479, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_480_10 = new TagInfo("c:if", //$NON-NLS-1$
            480, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_488_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            488, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_489_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            489, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_490_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            490, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_491_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            491, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_493_9 = new TagInfo("c:if", //$NON-NLS-1$
            493, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_495_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            495, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_496_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            496, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_498_17 = new TagInfo("c:if", //$NON-NLS-1$
            498, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_500_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            500, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_501_19 = new TagInfo("c:if", //$NON-NLS-1$
            501, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_504_19 = new TagInfo("c:if", //$NON-NLS-1$
            504, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_505_21 = new TagInfo("c:if", //$NON-NLS-1$
            505, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_507_18 = new TagInfo("c:if", //$NON-NLS-1$
            507, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_521_1 = new TagInfo("f:message", //$NON-NLS-1$
            521, 1,
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
                out.write("package ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 5, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 5, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                //process enums from base and lavel1,2 parents 
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_8_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_8_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_8_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_8_2.setTagInfo(_td_c_if_8_2);
                _jettag_c_if_8_2.doStart(context, out);
                while (_jettag_c_if_8_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_9_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_9_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_9_5.setRuntimeParent(_jettag_c_if_8_2);
                    _jettag_c_iterate_9_5.setTagInfo(_td_c_iterate_9_5);
                    _jettag_c_iterate_9_5.doStart(context, out);
                    while (_jettag_c_iterate_9_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_10_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_10_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_10_5.setRuntimeParent(_jettag_c_iterate_9_5);
                        _jettag_c_choose_10_5.setTagInfo(_td_c_choose_10_5);
                        _jettag_c_choose_10_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_10_5_saved_out = out;
                        while (_jettag_c_choose_10_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_otherwise_11_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_11_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_11_7.setRuntimeParent(_jettag_c_choose_10_5);
                            _jettag_c_otherwise_11_7.setTagInfo(_td_c_otherwise_11_7);
                            _jettag_c_otherwise_11_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_11_7_saved_out = out;
                            while (_jettag_c_otherwise_11_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_12_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_12_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_12_8.setRuntimeParent(_jettag_c_otherwise_11_7);
                                _jettag_c_iterate_12_8.setTagInfo(_td_c_iterate_12_8);
                                _jettag_c_iterate_12_8.doStart(context, out);
                                while (_jettag_c_iterate_12_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_13_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_13_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_13_10.setRuntimeParent(_jettag_c_iterate_12_8);
                                    _jettag_c_if_13_10.setTagInfo(_td_c_if_13_10);
                                    _jettag_c_if_13_10.doStart(context, out);
                                    while (_jettag_c_if_13_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$groupID}", 14, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".entity.");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 14, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 14, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(";");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_13_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_13_10.doEnd();
                                    _jettag_c_iterate_12_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_12_8.doEnd();
                                _jettag_c_otherwise_11_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_11_7_saved_out;
                            _jettag_c_otherwise_11_7.doEnd();
                            _jettag_c_choose_10_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_10_5_saved_out;
                        _jettag_c_choose_10_5.doEnd();
                        _jettag_c_iterate_9_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_9_5.doEnd();
                    _jettag_c_if_8_2.handleBodyContent(out);
                }
                _jettag_c_if_8_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_22_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_22_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_22_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_22_2.setTagInfo(_td_c_if_22_2);
                _jettag_c_if_22_2.doStart(context, out);
                while (_jettag_c_if_22_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_23_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_23_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_23_5.setRuntimeParent(_jettag_c_if_22_2);
                    _jettag_c_iterate_23_5.setTagInfo(_td_c_iterate_23_5);
                    _jettag_c_iterate_23_5.doStart(context, out);
                    while (_jettag_c_iterate_23_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_24_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_24_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_24_5.setRuntimeParent(_jettag_c_iterate_23_5);
                        _jettag_c_choose_24_5.setTagInfo(_td_c_choose_24_5);
                        _jettag_c_choose_24_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_24_5_saved_out = out;
                        while (_jettag_c_choose_24_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_otherwise_25_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_25_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_25_7.setRuntimeParent(_jettag_c_choose_24_5);
                            _jettag_c_otherwise_25_7.setTagInfo(_td_c_otherwise_25_7);
                            _jettag_c_otherwise_25_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_25_7_saved_out = out;
                            while (_jettag_c_otherwise_25_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_26_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_26_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_26_8.setRuntimeParent(_jettag_c_otherwise_25_7);
                                _jettag_c_iterate_26_8.setTagInfo(_td_c_iterate_26_8);
                                _jettag_c_iterate_26_8.doStart(context, out);
                                while (_jettag_c_iterate_26_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_27_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_27_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_27_10.setRuntimeParent(_jettag_c_iterate_26_8);
                                    _jettag_c_if_27_10.setTagInfo(_td_c_if_27_10);
                                    _jettag_c_if_27_10.doStart(context, out);
                                    while (_jettag_c_if_27_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$groupID}", 28, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".entity.");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 28, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 28, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(";");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_27_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_27_10.doEnd();
                                    _jettag_c_iterate_26_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_26_8.doEnd();
                                _jettag_c_otherwise_25_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_25_7_saved_out;
                            _jettag_c_otherwise_25_7.doEnd();
                            _jettag_c_choose_24_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_24_5_saved_out;
                        _jettag_c_choose_24_5.doEnd();
                        _jettag_c_iterate_23_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_23_5.doEnd();
                    _jettag_c_if_22_2.handleBodyContent(out);
                }
                _jettag_c_if_22_2.doEnd();
                //process premitive data types of base current class 
                RuntimeTagElement _jettag_c_iterate_36_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_36_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_36_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_36_4.setTagInfo(_td_c_iterate_36_4);
                _jettag_c_iterate_36_4.doStart(context, out);
                while (_jettag_c_iterate_36_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_37_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_37_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_37_5.setRuntimeParent(_jettag_c_iterate_36_4);
                    _jettag_c_choose_37_5.setTagInfo(_td_c_choose_37_5);
                    _jettag_c_choose_37_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_37_5_saved_out = out;
                    while (_jettag_c_choose_37_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_otherwise_38_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_38_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_38_7.setRuntimeParent(_jettag_c_choose_37_5);
                        _jettag_c_otherwise_38_7.setTagInfo(_td_c_otherwise_38_7);
                        _jettag_c_otherwise_38_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_38_7_saved_out = out;
                        while (_jettag_c_otherwise_38_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_39_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_39_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_39_8.setRuntimeParent(_jettag_c_otherwise_38_7);
                            _jettag_c_iterate_39_8.setTagInfo(_td_c_iterate_39_8);
                            _jettag_c_iterate_39_8.doStart(context, out);
                            while (_jettag_c_iterate_39_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_40_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_40_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_40_10.setRuntimeParent(_jettag_c_iterate_39_8);
                                _jettag_c_if_40_10.setTagInfo(_td_c_if_40_10);
                                _jettag_c_if_40_10.doStart(context, out);
                                while (_jettag_c_if_40_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$groupID}", 41, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".entity.");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 41, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 41, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(";");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_40_10.handleBodyContent(out);
                                }
                                _jettag_c_if_40_10.doEnd();
                                _jettag_c_iterate_39_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_39_8.doEnd();
                            _jettag_c_otherwise_38_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_38_7_saved_out;
                        _jettag_c_otherwise_38_7.doEnd();
                        _jettag_c_choose_37_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_37_5_saved_out;
                    _jettag_c_choose_37_5.doEnd();
                    _jettag_c_iterate_36_4.handleBodyContent(out);
                }
                _jettag_c_iterate_36_4.doEnd();
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 47, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 47, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 47, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 48, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 48, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.UpdateComposite;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.widgets.ResponseStatusWidget;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.fields.DataType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                // process dropdowns one tone and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_55_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_55_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_55_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_55_1.setTagInfo(_td_c_iterate_55_1);
                _jettag_c_iterate_55_1.doStart(context, out);
                while (_jettag_c_iterate_55_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_56_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_56_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_56_2.setRuntimeParent(_jettag_c_iterate_55_1);
                    _jettag_c_iterate_56_2.setTagInfo(_td_c_iterate_56_2);
                    _jettag_c_iterate_56_2.doStart(context, out);
                    while (_jettag_c_iterate_56_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_57_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_57_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_57_3.setRuntimeParent(_jettag_c_iterate_56_2);
                        _jettag_c_iterate_57_3.setTagInfo(_td_c_iterate_57_3);
                        _jettag_c_iterate_57_3.doStart(context, out);
                        while (_jettag_c_iterate_57_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_58_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_58_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_58_4.setRuntimeParent(_jettag_c_iterate_57_3);
                            _jettag_c_setVariable_58_4.setTagInfo(_td_c_setVariable_58_4);
                            _jettag_c_setVariable_58_4.doStart(context, out);
                            _jettag_c_setVariable_58_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_60_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_60_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_60_6.setRuntimeParent(_jettag_c_iterate_57_3);
                            _jettag_c_if_60_6.setTagInfo(_td_c_if_60_6);
                            _jettag_c_if_60_6.doStart(context, out);
                            while (_jettag_c_if_60_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_62_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_62_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_62_12.setRuntimeParent(_jettag_c_if_60_6);
                                _jettag_c_iterate_62_12.setTagInfo(_td_c_iterate_62_12);
                                _jettag_c_iterate_62_12.doStart(context, out);
                                while (_jettag_c_iterate_62_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_63_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_63_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_63_12.setRuntimeParent(_jettag_c_iterate_62_12);
                                    _jettag_c_setVariable_63_12.setTagInfo(_td_c_setVariable_63_12);
                                    _jettag_c_setVariable_63_12.doStart(context, out);
                                    _jettag_c_setVariable_63_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_65_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_65_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_65_14.setRuntimeParent(_jettag_c_iterate_62_12);
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
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_71_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_71_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_71_16.setRuntimeParent(_jettag_c_if_68_16);
                                                _jettag_c_if_71_16.setTagInfo(_td_c_if_71_16);
                                                _jettag_c_if_71_16.doStart(context, out);
                                                while (_jettag_c_if_71_16.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_72_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_72_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_72_18.setRuntimeParent(_jettag_c_if_71_16);
                                                    _jettag_c_if_72_18.setTagInfo(_td_c_if_72_18);
                                                    _jettag_c_if_72_18.doStart(context, out);
                                                    while (_jettag_c_if_72_18.okToProcessBody()) {
                                                        out.write("  \t\t\t\t\t    \t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 73, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 73, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 73, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".Select");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 73, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Panel;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        //check for one to one 
                                                        RuntimeTagElement _jettag_c_if_75_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_75_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_75_18.setRuntimeParent(_jettag_c_if_72_18);
                                                        _jettag_c_if_75_18.setTagInfo(_td_c_if_75_18);
                                                        _jettag_c_if_75_18.doStart(context, out);
                                                        while (_jettag_c_if_75_18.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_76_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_76_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_76_18.setRuntimeParent(_jettag_c_if_75_18);
                                                            _jettag_c_if_76_18.setTagInfo(_td_c_if_76_18);
                                                            _jettag_c_if_76_18.doStart(context, out);
                                                            while (_jettag_c_if_76_18.okToProcessBody()) {
                                                                out.write("  \t\t\t\t\t    \t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 77, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".client.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 77, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 77, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".Select");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 77, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panel;");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_76_18.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_76_18.doEnd();
                                                            _jettag_c_if_75_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_75_18.doEnd();
                                                        _jettag_c_if_72_18.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_72_18.doEnd();
                                                    _jettag_c_if_71_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_71_16.doEnd();
                                                _jettag_c_if_68_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_68_16.doEnd();
                                            _jettag_c_iterate_67_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_67_15.doEnd();
                                        _jettag_c_if_65_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_65_14.doEnd();
                                    _jettag_c_iterate_62_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_62_12.doEnd();
                                _jettag_c_if_60_6.handleBodyContent(out);
                            }
                            _jettag_c_if_60_6.doEnd();
                            _jettag_c_iterate_57_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_57_3.doEnd();
                        _jettag_c_iterate_56_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_56_2.doEnd();
                    _jettag_c_iterate_55_1.handleBodyContent(out);
                }
                _jettag_c_iterate_55_1.doEnd();
                RuntimeTagElement _jettag_f_message_90_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_90_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_90_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_90_1.setTagInfo(_td_f_message_90_1);
                _jettag_f_message_90_1.doStart(context, out);
                JET2Writer _jettag_f_message_90_1_saved_out = out;
                while (_jettag_f_message_90_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_90_1.handleBodyContent(out);
                }
                out = _jettag_f_message_90_1_saved_out;
                _jettag_f_message_90_1.doEnd();
                out.write(NL);         
                out.write("public class Update");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 91, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel extends UpdateComposite<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 91, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                // process dropdowns one tone and many to one 
                RuntimeTagElement _jettag_c_iterate_94_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_94_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_94_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_94_1.setTagInfo(_td_c_iterate_94_1);
                _jettag_c_iterate_94_1.doStart(context, out);
                while (_jettag_c_iterate_94_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_95_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_95_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_95_2.setRuntimeParent(_jettag_c_iterate_94_1);
                    _jettag_c_iterate_95_2.setTagInfo(_td_c_iterate_95_2);
                    _jettag_c_iterate_95_2.doStart(context, out);
                    while (_jettag_c_iterate_95_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_96_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_96_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_96_3.setRuntimeParent(_jettag_c_iterate_95_2);
                        _jettag_c_iterate_96_3.setTagInfo(_td_c_iterate_96_3);
                        _jettag_c_iterate_96_3.doStart(context, out);
                        while (_jettag_c_iterate_96_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_97_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_97_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_97_4.setRuntimeParent(_jettag_c_iterate_96_3);
                            _jettag_c_setVariable_97_4.setTagInfo(_td_c_setVariable_97_4);
                            _jettag_c_setVariable_97_4.doStart(context, out);
                            _jettag_c_setVariable_97_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_99_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_99_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_99_6.setRuntimeParent(_jettag_c_iterate_96_3);
                            _jettag_c_if_99_6.setTagInfo(_td_c_if_99_6);
                            _jettag_c_if_99_6.doStart(context, out);
                            while (_jettag_c_if_99_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_101_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_101_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_101_12.setRuntimeParent(_jettag_c_if_99_6);
                                _jettag_c_iterate_101_12.setTagInfo(_td_c_iterate_101_12);
                                _jettag_c_iterate_101_12.doStart(context, out);
                                while (_jettag_c_iterate_101_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_102_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_102_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_102_12.setRuntimeParent(_jettag_c_iterate_101_12);
                                    _jettag_c_setVariable_102_12.setTagInfo(_td_c_setVariable_102_12);
                                    _jettag_c_setVariable_102_12.doStart(context, out);
                                    _jettag_c_setVariable_102_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_104_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_104_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_104_14.setRuntimeParent(_jettag_c_iterate_101_12);
                                    _jettag_c_if_104_14.setTagInfo(_td_c_if_104_14);
                                    _jettag_c_if_104_14.doStart(context, out);
                                    while (_jettag_c_if_104_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_106_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_106_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_106_15.setRuntimeParent(_jettag_c_if_104_14);
                                        _jettag_c_iterate_106_15.setTagInfo(_td_c_iterate_106_15);
                                        _jettag_c_iterate_106_15.doStart(context, out);
                                        while (_jettag_c_iterate_106_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_107_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_107_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_107_16.setRuntimeParent(_jettag_c_iterate_106_15);
                                            _jettag_c_if_107_16.setTagInfo(_td_c_if_107_16);
                                            _jettag_c_if_107_16.doStart(context, out);
                                            while (_jettag_c_if_107_16.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                // TODO need to check navaigability? 
                                                RuntimeTagElement _jettag_c_if_111_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_111_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_111_16.setRuntimeParent(_jettag_c_if_107_16);
                                                _jettag_c_if_111_16.setTagInfo(_td_c_if_111_16);
                                                _jettag_c_if_111_16.doStart(context, out);
                                                while (_jettag_c_if_111_16.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_112_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_112_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_112_18.setRuntimeParent(_jettag_c_if_111_16);
                                                    _jettag_c_if_112_18.setTagInfo(_td_c_if_112_18);
                                                    _jettag_c_if_112_18.doStart(context, out);
                                                    while (_jettag_c_if_112_18.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_114_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_114_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_114_18.setRuntimeParent(_jettag_c_if_112_18);
                                                        _jettag_c_if_114_18.setTagInfo(_td_c_if_114_18);
                                                        _jettag_c_if_114_18.doStart(context, out);
                                                        while (_jettag_c_if_114_18.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_f_message_115_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_115_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_115_1.setRuntimeParent(_jettag_c_if_114_18);
                                                            _jettag_f_message_115_1.setTagInfo(_td_f_message_115_1);
                                                            _jettag_f_message_115_1.doStart(context, out);
                                                            JET2Writer _jettag_f_message_115_1_saved_out = out;
                                                            while (_jettag_f_message_115_1.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_115_1.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_115_1_saved_out;
                                                            _jettag_f_message_115_1.doEnd();
                                                            out.write("  \t\t\t\t\t    \t\t\t\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("  \t\t\t\t\t    \t\t\t\t\t\t\tSelect");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 116, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 116, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel = new Select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 116, 87)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel(\"");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 116, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("\",");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tRead");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class/@name}", 117, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel.instance().getEntity().get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 117, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("());");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_114_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_114_18.doEnd();
                                                        _jettag_c_if_112_18.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_112_18.doEnd();
                                                    _jettag_c_if_111_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_111_16.doEnd();
                                                _jettag_c_if_107_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_107_16.doEnd();
                                            _jettag_c_iterate_106_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_106_15.doEnd();
                                        _jettag_c_if_104_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_104_14.doEnd();
                                    _jettag_c_iterate_101_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_101_12.doEnd();
                                _jettag_c_if_99_6.handleBodyContent(out);
                            }
                            _jettag_c_if_99_6.doEnd();
                            _jettag_c_iterate_96_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_96_3.doEnd();
                        _jettag_c_iterate_95_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_95_2.doEnd();
                    _jettag_c_iterate_94_1.handleBodyContent(out);
                }
                _jettag_c_iterate_94_1.doEnd();
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
                out.write("\tpublic Update");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 130, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitUpdateComposite(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 131, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getName(), ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 131, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.constants);");  //$NON-NLS-1$        
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
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 135, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" populateEntityOnRender() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tentity = Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 136, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel.instance().getEntity();");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_138_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_138_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_138_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_138_4.setTagInfo(_td_c_if_138_4);
                _jettag_c_if_138_4.doStart(context, out);
                while (_jettag_c_if_138_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_139_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_139_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_139_4.setRuntimeParent(_jettag_c_if_138_4);
                    _jettag_c_iterate_139_4.setTagInfo(_td_c_iterate_139_4);
                    _jettag_c_iterate_139_4.doStart(context, out);
                    while (_jettag_c_iterate_139_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_140_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_140_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_140_5.setRuntimeParent(_jettag_c_iterate_139_4);
                        _jettag_c_choose_140_5.setTagInfo(_td_c_choose_140_5);
                        _jettag_c_choose_140_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_140_5_saved_out = out;
                        while (_jettag_c_choose_140_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_141_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_141_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_141_6.setRuntimeParent(_jettag_c_choose_140_5);
                            _jettag_c_when_141_6.setTagInfo(_td_c_when_141_6);
                            _jettag_c_when_141_6.doStart(context, out);
                            JET2Writer _jettag_c_when_141_6_saved_out = out;
                            while (_jettag_c_when_141_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 141, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 141, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_141_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_141_6_saved_out;
                            _jettag_c_when_141_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_143_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_143_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_143_6.setRuntimeParent(_jettag_c_choose_140_5);
                            _jettag_c_when_143_6.setTagInfo(_td_c_when_143_6);
                            _jettag_c_when_143_6.doStart(context, out);
                            JET2Writer _jettag_c_when_143_6_saved_out = out;
                            while (_jettag_c_when_143_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 143, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 143, 81)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_143_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_143_6_saved_out;
                            _jettag_c_when_143_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_145_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_145_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_145_6.setRuntimeParent(_jettag_c_choose_140_5);
                            _jettag_c_when_145_6.setTagInfo(_td_c_when_145_6);
                            _jettag_c_when_145_6.doStart(context, out);
                            JET2Writer _jettag_c_when_145_6_saved_out = out;
                            while (_jettag_c_when_145_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 145, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 145, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_145_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_145_6_saved_out;
                            _jettag_c_when_145_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_147_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_147_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_147_6.setRuntimeParent(_jettag_c_choose_140_5);
                            _jettag_c_when_147_6.setTagInfo(_td_c_when_147_6);
                            _jettag_c_when_147_6.doStart(context, out);
                            JET2Writer _jettag_c_when_147_6_saved_out = out;
                            while (_jettag_c_when_147_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 147, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 147, 81)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_147_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_147_6_saved_out;
                            _jettag_c_when_147_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_149_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_149_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_149_6.setRuntimeParent(_jettag_c_choose_140_5);
                            _jettag_c_when_149_6.setTagInfo(_td_c_when_149_6);
                            _jettag_c_when_149_6.doStart(context, out);
                            JET2Writer _jettag_c_when_149_6_saved_out = out;
                            while (_jettag_c_when_149_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 149, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 149, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_149_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_149_6_saved_out;
                            _jettag_c_when_149_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_151_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_151_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_151_6.setRuntimeParent(_jettag_c_choose_140_5);
                            _jettag_c_when_151_6.setTagInfo(_td_c_when_151_6);
                            _jettag_c_when_151_6.doStart(context, out);
                            JET2Writer _jettag_c_when_151_6_saved_out = out;
                            while (_jettag_c_when_151_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 151, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 151, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_151_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_151_6_saved_out;
                            _jettag_c_when_151_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_153_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_153_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_153_6.setRuntimeParent(_jettag_c_choose_140_5);
                            _jettag_c_when_153_6.setTagInfo(_td_c_when_153_6);
                            _jettag_c_when_153_6.doStart(context, out);
                            JET2Writer _jettag_c_when_153_6_saved_out = out;
                            while (_jettag_c_when_153_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 153, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 153, 82)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),false); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_153_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_153_6_saved_out;
                            _jettag_c_when_153_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_155_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_155_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_155_6.setRuntimeParent(_jettag_c_choose_140_5);
                            _jettag_c_when_155_6.setTagInfo(_td_c_when_155_6);
                            _jettag_c_when_155_6.doStart(context, out);
                            JET2Writer _jettag_c_when_155_6_saved_out = out;
                            while (_jettag_c_when_155_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 155, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 155, 84)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_155_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_155_6_saved_out;
                            _jettag_c_when_155_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_157_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_157_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_157_6.setRuntimeParent(_jettag_c_choose_140_5);
                            _jettag_c_when_157_6.setTagInfo(_td_c_when_157_6);
                            _jettag_c_when_157_6.doStart(context, out);
                            JET2Writer _jettag_c_when_157_6_saved_out = out;
                            while (_jettag_c_when_157_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 157, 59)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 157, 90)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_157_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_157_6_saved_out;
                            _jettag_c_when_157_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_159_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_159_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_159_7.setRuntimeParent(_jettag_c_choose_140_5);
                            _jettag_c_otherwise_159_7.setTagInfo(_td_c_otherwise_159_7);
                            _jettag_c_otherwise_159_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_159_7_saved_out = out;
                            while (_jettag_c_otherwise_159_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_160_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_160_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_160_8.setRuntimeParent(_jettag_c_otherwise_159_7);
                                _jettag_c_iterate_160_8.setTagInfo(_td_c_iterate_160_8);
                                _jettag_c_iterate_160_8.doStart(context, out);
                                while (_jettag_c_iterate_160_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_161_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_161_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_161_10.setRuntimeParent(_jettag_c_iterate_160_8);
                                    _jettag_c_if_161_10.setTagInfo(_td_c_if_161_10);
                                    _jettag_c_if_161_10.doStart(context, out);
                                    while (_jettag_c_if_161_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tsetEnumFeild(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 162, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", entity.get");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 162, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("().toString());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_161_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_161_10.doEnd();
                                    _jettag_c_iterate_160_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_160_8.doEnd();
                                _jettag_c_otherwise_159_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_159_7_saved_out;
                            _jettag_c_otherwise_159_7.doEnd();
                            _jettag_c_choose_140_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_140_5_saved_out;
                        _jettag_c_choose_140_5.doEnd();
                        _jettag_c_iterate_139_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_139_4.doEnd();
                    _jettag_c_if_138_4.handleBodyContent(out);
                }
                _jettag_c_if_138_4.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_170_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_170_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_170_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_170_4.setTagInfo(_td_c_if_170_4);
                _jettag_c_if_170_4.doStart(context, out);
                while (_jettag_c_if_170_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_171_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_171_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_171_4.setRuntimeParent(_jettag_c_if_170_4);
                    _jettag_c_iterate_171_4.setTagInfo(_td_c_iterate_171_4);
                    _jettag_c_iterate_171_4.doStart(context, out);
                    while (_jettag_c_iterate_171_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_172_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_172_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_172_5.setRuntimeParent(_jettag_c_iterate_171_4);
                        _jettag_c_choose_172_5.setTagInfo(_td_c_choose_172_5);
                        _jettag_c_choose_172_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_172_5_saved_out = out;
                        while (_jettag_c_choose_172_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_173_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_173_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_173_6.setRuntimeParent(_jettag_c_choose_172_5);
                            _jettag_c_when_173_6.setTagInfo(_td_c_when_173_6);
                            _jettag_c_when_173_6.doStart(context, out);
                            JET2Writer _jettag_c_when_173_6_saved_out = out;
                            while (_jettag_c_when_173_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 173, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 173, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_173_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_173_6_saved_out;
                            _jettag_c_when_173_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_175_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_175_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_175_6.setRuntimeParent(_jettag_c_choose_172_5);
                            _jettag_c_when_175_6.setTagInfo(_td_c_when_175_6);
                            _jettag_c_when_175_6.doStart(context, out);
                            JET2Writer _jettag_c_when_175_6_saved_out = out;
                            while (_jettag_c_when_175_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 175, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 175, 81)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_175_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_175_6_saved_out;
                            _jettag_c_when_175_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_177_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_177_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_177_6.setRuntimeParent(_jettag_c_choose_172_5);
                            _jettag_c_when_177_6.setTagInfo(_td_c_when_177_6);
                            _jettag_c_when_177_6.doStart(context, out);
                            JET2Writer _jettag_c_when_177_6_saved_out = out;
                            while (_jettag_c_when_177_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 177, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 177, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_177_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_177_6_saved_out;
                            _jettag_c_when_177_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_179_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_179_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_179_6.setRuntimeParent(_jettag_c_choose_172_5);
                            _jettag_c_when_179_6.setTagInfo(_td_c_when_179_6);
                            _jettag_c_when_179_6.doStart(context, out);
                            JET2Writer _jettag_c_when_179_6_saved_out = out;
                            while (_jettag_c_when_179_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 179, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 179, 81)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_179_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_179_6_saved_out;
                            _jettag_c_when_179_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_181_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_181_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_181_6.setRuntimeParent(_jettag_c_choose_172_5);
                            _jettag_c_when_181_6.setTagInfo(_td_c_when_181_6);
                            _jettag_c_when_181_6.doStart(context, out);
                            JET2Writer _jettag_c_when_181_6_saved_out = out;
                            while (_jettag_c_when_181_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 181, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 181, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_181_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_181_6_saved_out;
                            _jettag_c_when_181_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_183_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_183_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_183_6.setRuntimeParent(_jettag_c_choose_172_5);
                            _jettag_c_when_183_6.setTagInfo(_td_c_when_183_6);
                            _jettag_c_when_183_6.doStart(context, out);
                            JET2Writer _jettag_c_when_183_6_saved_out = out;
                            while (_jettag_c_when_183_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 183, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 183, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_183_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_183_6_saved_out;
                            _jettag_c_when_183_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_185_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_185_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_185_6.setRuntimeParent(_jettag_c_choose_172_5);
                            _jettag_c_when_185_6.setTagInfo(_td_c_when_185_6);
                            _jettag_c_when_185_6.doStart(context, out);
                            JET2Writer _jettag_c_when_185_6_saved_out = out;
                            while (_jettag_c_when_185_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 185, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 185, 82)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),false); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_185_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_185_6_saved_out;
                            _jettag_c_when_185_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_187_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_187_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_187_6.setRuntimeParent(_jettag_c_choose_172_5);
                            _jettag_c_when_187_6.setTagInfo(_td_c_when_187_6);
                            _jettag_c_when_187_6.doStart(context, out);
                            JET2Writer _jettag_c_when_187_6_saved_out = out;
                            while (_jettag_c_when_187_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 187, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 187, 84)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_187_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_187_6_saved_out;
                            _jettag_c_when_187_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_189_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_189_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_189_6.setRuntimeParent(_jettag_c_choose_172_5);
                            _jettag_c_when_189_6.setTagInfo(_td_c_when_189_6);
                            _jettag_c_when_189_6.doStart(context, out);
                            JET2Writer _jettag_c_when_189_6_saved_out = out;
                            while (_jettag_c_when_189_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 189, 59)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",entity.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 189, 90)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_189_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_189_6_saved_out;
                            _jettag_c_when_189_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_191_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_191_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_191_7.setRuntimeParent(_jettag_c_choose_172_5);
                            _jettag_c_otherwise_191_7.setTagInfo(_td_c_otherwise_191_7);
                            _jettag_c_otherwise_191_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_191_7_saved_out = out;
                            while (_jettag_c_otherwise_191_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_192_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_192_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_192_8.setRuntimeParent(_jettag_c_otherwise_191_7);
                                _jettag_c_iterate_192_8.setTagInfo(_td_c_iterate_192_8);
                                _jettag_c_iterate_192_8.doStart(context, out);
                                while (_jettag_c_iterate_192_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_193_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_193_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_193_10.setRuntimeParent(_jettag_c_iterate_192_8);
                                    _jettag_c_if_193_10.setTagInfo(_td_c_if_193_10);
                                    _jettag_c_if_193_10.doStart(context, out);
                                    while (_jettag_c_if_193_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tsetEnumFeild(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 194, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", entity.get");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 194, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("().toString());\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_193_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_193_10.doEnd();
                                    _jettag_c_iterate_192_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_192_8.doEnd();
                                _jettag_c_otherwise_191_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_191_7_saved_out;
                            _jettag_c_otherwise_191_7.doEnd();
                            _jettag_c_choose_172_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_172_5_saved_out;
                        _jettag_c_choose_172_5.doEnd();
                        _jettag_c_iterate_171_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_171_4.doEnd();
                    _jettag_c_if_170_4.handleBodyContent(out);
                }
                _jettag_c_if_170_4.doEnd();
                // process parent class level 0 attributes
                RuntimeTagElement _jettag_c_iterate_202_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_202_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_202_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_202_4.setTagInfo(_td_c_iterate_202_4);
                _jettag_c_iterate_202_4.doStart(context, out);
                while (_jettag_c_iterate_202_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_203_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_203_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_203_5.setRuntimeParent(_jettag_c_iterate_202_4);
                    _jettag_c_choose_203_5.setTagInfo(_td_c_choose_203_5);
                    _jettag_c_choose_203_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_203_5_saved_out = out;
                    while (_jettag_c_choose_203_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_204_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_204_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_204_6.setRuntimeParent(_jettag_c_choose_203_5);
                        _jettag_c_when_204_6.setTagInfo(_td_c_when_204_6);
                        _jettag_c_when_204_6.doStart(context, out);
                        JET2Writer _jettag_c_when_204_6_saved_out = out;
                        while (_jettag_c_when_204_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 204, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 204, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_204_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_204_6_saved_out;
                        _jettag_c_when_204_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_206_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_206_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_206_6.setRuntimeParent(_jettag_c_choose_203_5);
                        _jettag_c_when_206_6.setTagInfo(_td_c_when_206_6);
                        _jettag_c_when_206_6.doStart(context, out);
                        JET2Writer _jettag_c_when_206_6_saved_out = out;
                        while (_jettag_c_when_206_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 206, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 206, 81)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_206_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_206_6_saved_out;
                        _jettag_c_when_206_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_208_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_208_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_208_6.setRuntimeParent(_jettag_c_choose_203_5);
                        _jettag_c_when_208_6.setTagInfo(_td_c_when_208_6);
                        _jettag_c_when_208_6.doStart(context, out);
                        JET2Writer _jettag_c_when_208_6_saved_out = out;
                        while (_jettag_c_when_208_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 208, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 208, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_208_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_208_6_saved_out;
                        _jettag_c_when_208_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_210_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_210_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_210_6.setRuntimeParent(_jettag_c_choose_203_5);
                        _jettag_c_when_210_6.setTagInfo(_td_c_when_210_6);
                        _jettag_c_when_210_6.doStart(context, out);
                        JET2Writer _jettag_c_when_210_6_saved_out = out;
                        while (_jettag_c_when_210_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 210, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 210, 81)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_210_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_210_6_saved_out;
                        _jettag_c_when_210_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_212_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_212_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_212_6.setRuntimeParent(_jettag_c_choose_203_5);
                        _jettag_c_when_212_6.setTagInfo(_td_c_when_212_6);
                        _jettag_c_when_212_6.doStart(context, out);
                        JET2Writer _jettag_c_when_212_6_saved_out = out;
                        while (_jettag_c_when_212_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 212, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 212, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_212_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_212_6_saved_out;
                        _jettag_c_when_212_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_214_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_214_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_214_6.setRuntimeParent(_jettag_c_choose_203_5);
                        _jettag_c_when_214_6.setTagInfo(_td_c_when_214_6);
                        _jettag_c_when_214_6.doStart(context, out);
                        JET2Writer _jettag_c_when_214_6_saved_out = out;
                        while (_jettag_c_when_214_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 214, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 214, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_214_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_214_6_saved_out;
                        _jettag_c_when_214_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_216_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_216_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_216_6.setRuntimeParent(_jettag_c_choose_203_5);
                        _jettag_c_when_216_6.setTagInfo(_td_c_when_216_6);
                        _jettag_c_when_216_6.doStart(context, out);
                        JET2Writer _jettag_c_when_216_6_saved_out = out;
                        while (_jettag_c_when_216_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 216, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 216, 82)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(),false); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_216_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_216_6_saved_out;
                        _jettag_c_when_216_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_218_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_218_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_218_6.setRuntimeParent(_jettag_c_choose_203_5);
                        _jettag_c_when_218_6.setTagInfo(_td_c_when_218_6);
                        _jettag_c_when_218_6.doStart(context, out);
                        JET2Writer _jettag_c_when_218_6_saved_out = out;
                        while (_jettag_c_when_218_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setImageField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 218, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 218, 84)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_218_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_218_6_saved_out;
                        _jettag_c_when_218_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_220_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_220_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_220_6.setRuntimeParent(_jettag_c_choose_203_5);
                        _jettag_c_when_220_6.setTagInfo(_td_c_when_220_6);
                        _jettag_c_when_220_6.doStart(context, out);
                        JET2Writer _jettag_c_when_220_6_saved_out = out;
                        while (_jettag_c_when_220_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setRichTextField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 220, 59)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",entity.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 220, 90)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_220_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_220_6_saved_out;
                        _jettag_c_when_220_6.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_222_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_222_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_222_7.setRuntimeParent(_jettag_c_choose_203_5);
                        _jettag_c_otherwise_222_7.setTagInfo(_td_c_otherwise_222_7);
                        _jettag_c_otherwise_222_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_222_7_saved_out = out;
                        while (_jettag_c_otherwise_222_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_223_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_223_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_223_8.setRuntimeParent(_jettag_c_otherwise_222_7);
                            _jettag_c_iterate_223_8.setTagInfo(_td_c_iterate_223_8);
                            _jettag_c_iterate_223_8.doStart(context, out);
                            while (_jettag_c_iterate_223_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_224_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_224_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_224_10.setRuntimeParent(_jettag_c_iterate_223_8);
                                _jettag_c_if_224_10.setTagInfo(_td_c_if_224_10);
                                _jettag_c_if_224_10.doStart(context, out);
                                while (_jettag_c_if_224_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\tsetEnumFeild(\"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 225, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", entity.get");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 225, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("().toString());\t\t\t\t\t\t");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_224_10.handleBodyContent(out);
                                }
                                _jettag_c_if_224_10.doEnd();
                                _jettag_c_iterate_223_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_223_8.doEnd();
                            _jettag_c_otherwise_222_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_222_7_saved_out;
                        _jettag_c_otherwise_222_7.doEnd();
                        _jettag_c_choose_203_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_203_5_saved_out;
                    _jettag_c_choose_203_5.doEnd();
                    _jettag_c_iterate_202_4.handleBodyContent(out);
                }
                _jettag_c_iterate_202_4.doEnd();
                out.write("\t\t//no need to render dropdowns\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\treturn entity;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_234_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_234_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_234_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_234_1.setTagInfo(_td_f_message_234_1);
                _jettag_f_message_234_1.doStart(context, out);
                JET2Writer _jettag_f_message_234_1_saved_out = out;
                while (_jettag_f_message_234_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_234_1.handleBodyContent(out);
                }
                out = _jettag_f_message_234_1_saved_out;
                _jettag_f_message_234_1.doEnd();
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 236, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" populateEntityOnUpdate(){");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_238_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_238_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_238_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_238_2.setTagInfo(_td_c_if_238_2);
                _jettag_c_if_238_2.doStart(context, out);
                while (_jettag_c_if_238_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_239_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_239_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_239_2.setRuntimeParent(_jettag_c_if_238_2);
                    _jettag_c_iterate_239_2.setTagInfo(_td_c_iterate_239_2);
                    _jettag_c_iterate_239_2.doStart(context, out);
                    while (_jettag_c_iterate_239_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_240_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_240_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_240_4.setRuntimeParent(_jettag_c_iterate_239_2);
                        _jettag_c_choose_240_4.setTagInfo(_td_c_choose_240_4);
                        _jettag_c_choose_240_4.doStart(context, out);
                        JET2Writer _jettag_c_choose_240_4_saved_out = out;
                        while (_jettag_c_choose_240_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_241_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_241_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_241_5.setRuntimeParent(_jettag_c_choose_240_4);
                            _jettag_c_when_241_5.setTagInfo(_td_c_when_241_5);
                            _jettag_c_when_241_5.doStart(context, out);
                            JET2Writer _jettag_c_when_241_5_saved_out = out;
                            while (_jettag_c_when_241_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 241, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getStringField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 241, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_241_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_241_5_saved_out;
                            _jettag_c_when_241_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_243_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_243_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_243_5.setRuntimeParent(_jettag_c_choose_240_4);
                            _jettag_c_when_243_5.setTagInfo(_td_c_when_243_5);
                            _jettag_c_when_243_5.doStart(context, out);
                            JET2Writer _jettag_c_when_243_5_saved_out = out;
                            while (_jettag_c_when_243_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 243, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 243, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_243_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_243_5_saved_out;
                            _jettag_c_when_243_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_245_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_245_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_245_5.setRuntimeParent(_jettag_c_choose_240_4);
                            _jettag_c_when_245_5.setTagInfo(_td_c_when_245_5);
                            _jettag_c_when_245_5.doStart(context, out);
                            JET2Writer _jettag_c_when_245_5_saved_out = out;
                            while (_jettag_c_when_245_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 245, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getDateField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 245, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_245_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_245_5_saved_out;
                            _jettag_c_when_245_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_247_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_247_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_247_5.setRuntimeParent(_jettag_c_choose_240_4);
                            _jettag_c_when_247_5.setTagInfo(_td_c_when_247_5);
                            _jettag_c_when_247_5.doStart(context, out);
                            JET2Writer _jettag_c_when_247_5_saved_out = out;
                            while (_jettag_c_when_247_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 247, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 247, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_247_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_247_5_saved_out;
                            _jettag_c_when_247_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_249_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_249_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_249_5.setRuntimeParent(_jettag_c_choose_240_4);
                            _jettag_c_when_249_5.setTagInfo(_td_c_when_249_5);
                            _jettag_c_when_249_5.doStart(context, out);
                            JET2Writer _jettag_c_when_249_5_saved_out = out;
                            while (_jettag_c_when_249_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 249, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getLongField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 249, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_249_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_249_5_saved_out;
                            _jettag_c_when_249_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_251_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_251_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_251_5.setRuntimeParent(_jettag_c_choose_240_4);
                            _jettag_c_when_251_5.setTagInfo(_td_c_when_251_5);
                            _jettag_c_when_251_5.doStart(context, out);
                            JET2Writer _jettag_c_when_251_5_saved_out = out;
                            while (_jettag_c_when_251_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 251, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getFloatField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 251, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_251_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_251_5_saved_out;
                            _jettag_c_when_251_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_253_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_253_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_253_5.setRuntimeParent(_jettag_c_choose_240_4);
                            _jettag_c_when_253_5.setTagInfo(_td_c_when_253_5);
                            _jettag_c_when_253_5.doStart(context, out);
                            JET2Writer _jettag_c_when_253_5_saved_out = out;
                            while (_jettag_c_when_253_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 253, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 253, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_253_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_253_5_saved_out;
                            _jettag_c_when_253_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_255_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_255_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_255_5.setRuntimeParent(_jettag_c_choose_240_4);
                            _jettag_c_when_255_5.setTagInfo(_td_c_when_255_5);
                            _jettag_c_when_255_5.doStart(context, out);
                            JET2Writer _jettag_c_when_255_5_saved_out = out;
                            while (_jettag_c_when_255_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 255, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 255, 104)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_255_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_255_5_saved_out;
                            _jettag_c_when_255_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_257_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_257_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_257_5.setRuntimeParent(_jettag_c_choose_240_4);
                            _jettag_c_when_257_5.setTagInfo(_td_c_when_257_5);
                            _jettag_c_when_257_5.doStart(context, out);
                            JET2Writer _jettag_c_when_257_5_saved_out = out;
                            while (_jettag_c_when_257_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 257, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 257, 104)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_257_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_257_5_saved_out;
                            _jettag_c_when_257_5.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_259_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_259_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_259_6.setRuntimeParent(_jettag_c_choose_240_4);
                            _jettag_c_otherwise_259_6.setTagInfo(_td_c_otherwise_259_6);
                            _jettag_c_otherwise_259_6.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_259_6_saved_out = out;
                            while (_jettag_c_otherwise_259_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_260_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_260_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_260_8.setRuntimeParent(_jettag_c_otherwise_259_6);
                                _jettag_c_iterate_260_8.setTagInfo(_td_c_iterate_260_8);
                                _jettag_c_iterate_260_8.doStart(context, out);
                                while (_jettag_c_iterate_260_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_261_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_261_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_261_10.setRuntimeParent(_jettag_c_iterate_260_8);
                                    _jettag_c_if_261_10.setTagInfo(_td_c_if_261_10);
                                    _jettag_c_if_261_10.doStart(context, out);
                                    while (_jettag_c_if_261_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tentity.set");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 262, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("(");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 262, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".valueOf(getEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 262, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\")));");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_261_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_261_10.doEnd();
                                    _jettag_c_iterate_260_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_260_8.doEnd();
                                _jettag_c_otherwise_259_6.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_259_6_saved_out;
                            _jettag_c_otherwise_259_6.doEnd();
                            _jettag_c_choose_240_4.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_240_4_saved_out;
                        _jettag_c_choose_240_4.doEnd();
                        _jettag_c_iterate_239_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_239_2.doEnd();
                    _jettag_c_if_238_2.handleBodyContent(out);
                }
                _jettag_c_if_238_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_270_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_270_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_270_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_270_2.setTagInfo(_td_c_if_270_2);
                _jettag_c_if_270_2.doStart(context, out);
                while (_jettag_c_if_270_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_271_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_271_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_271_2.setRuntimeParent(_jettag_c_if_270_2);
                    _jettag_c_iterate_271_2.setTagInfo(_td_c_iterate_271_2);
                    _jettag_c_iterate_271_2.doStart(context, out);
                    while (_jettag_c_iterate_271_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_272_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_272_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_272_4.setRuntimeParent(_jettag_c_iterate_271_2);
                        _jettag_c_choose_272_4.setTagInfo(_td_c_choose_272_4);
                        _jettag_c_choose_272_4.doStart(context, out);
                        JET2Writer _jettag_c_choose_272_4_saved_out = out;
                        while (_jettag_c_choose_272_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_273_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_273_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_273_5.setRuntimeParent(_jettag_c_choose_272_4);
                            _jettag_c_when_273_5.setTagInfo(_td_c_when_273_5);
                            _jettag_c_when_273_5.doStart(context, out);
                            JET2Writer _jettag_c_when_273_5_saved_out = out;
                            while (_jettag_c_when_273_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 273, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getStringField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 273, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_273_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_273_5_saved_out;
                            _jettag_c_when_273_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_275_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_275_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_275_5.setRuntimeParent(_jettag_c_choose_272_4);
                            _jettag_c_when_275_5.setTagInfo(_td_c_when_275_5);
                            _jettag_c_when_275_5.doStart(context, out);
                            JET2Writer _jettag_c_when_275_5_saved_out = out;
                            while (_jettag_c_when_275_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 275, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 275, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_275_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_275_5_saved_out;
                            _jettag_c_when_275_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_277_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_277_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_277_5.setRuntimeParent(_jettag_c_choose_272_4);
                            _jettag_c_when_277_5.setTagInfo(_td_c_when_277_5);
                            _jettag_c_when_277_5.doStart(context, out);
                            JET2Writer _jettag_c_when_277_5_saved_out = out;
                            while (_jettag_c_when_277_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 277, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getDateField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 277, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_277_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_277_5_saved_out;
                            _jettag_c_when_277_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_279_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_279_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_279_5.setRuntimeParent(_jettag_c_choose_272_4);
                            _jettag_c_when_279_5.setTagInfo(_td_c_when_279_5);
                            _jettag_c_when_279_5.doStart(context, out);
                            JET2Writer _jettag_c_when_279_5_saved_out = out;
                            while (_jettag_c_when_279_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 279, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 279, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_279_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_279_5_saved_out;
                            _jettag_c_when_279_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_281_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_281_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_281_5.setRuntimeParent(_jettag_c_choose_272_4);
                            _jettag_c_when_281_5.setTagInfo(_td_c_when_281_5);
                            _jettag_c_when_281_5.doStart(context, out);
                            JET2Writer _jettag_c_when_281_5_saved_out = out;
                            while (_jettag_c_when_281_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 281, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getLongField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 281, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_281_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_281_5_saved_out;
                            _jettag_c_when_281_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_283_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_283_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_283_5.setRuntimeParent(_jettag_c_choose_272_4);
                            _jettag_c_when_283_5.setTagInfo(_td_c_when_283_5);
                            _jettag_c_when_283_5.doStart(context, out);
                            JET2Writer _jettag_c_when_283_5_saved_out = out;
                            while (_jettag_c_when_283_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 283, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getFloatField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 283, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_283_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_283_5_saved_out;
                            _jettag_c_when_283_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_285_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_285_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_285_5.setRuntimeParent(_jettag_c_choose_272_4);
                            _jettag_c_when_285_5.setTagInfo(_td_c_when_285_5);
                            _jettag_c_when_285_5.doStart(context, out);
                            JET2Writer _jettag_c_when_285_5_saved_out = out;
                            while (_jettag_c_when_285_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 285, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 285, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_285_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_285_5_saved_out;
                            _jettag_c_when_285_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_287_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_287_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_287_5.setRuntimeParent(_jettag_c_choose_272_4);
                            _jettag_c_when_287_5.setTagInfo(_td_c_when_287_5);
                            _jettag_c_when_287_5.doStart(context, out);
                            JET2Writer _jettag_c_when_287_5_saved_out = out;
                            while (_jettag_c_when_287_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 287, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 287, 104)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_287_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_287_5_saved_out;
                            _jettag_c_when_287_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_289_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_289_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_289_5.setRuntimeParent(_jettag_c_choose_272_4);
                            _jettag_c_when_289_5.setTagInfo(_td_c_when_289_5);
                            _jettag_c_when_289_5.doStart(context, out);
                            JET2Writer _jettag_c_when_289_5_saved_out = out;
                            while (_jettag_c_when_289_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" entity.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 289, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 289, 104)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_289_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_289_5_saved_out;
                            _jettag_c_when_289_5.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_291_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_291_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_291_6.setRuntimeParent(_jettag_c_choose_272_4);
                            _jettag_c_otherwise_291_6.setTagInfo(_td_c_otherwise_291_6);
                            _jettag_c_otherwise_291_6.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_291_6_saved_out = out;
                            while (_jettag_c_otherwise_291_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_292_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_292_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_292_8.setRuntimeParent(_jettag_c_otherwise_291_6);
                                _jettag_c_iterate_292_8.setTagInfo(_td_c_iterate_292_8);
                                _jettag_c_iterate_292_8.doStart(context, out);
                                while (_jettag_c_iterate_292_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_293_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_293_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_293_10.setRuntimeParent(_jettag_c_iterate_292_8);
                                    _jettag_c_if_293_10.setTagInfo(_td_c_if_293_10);
                                    _jettag_c_if_293_10.doStart(context, out);
                                    while (_jettag_c_if_293_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tentity.set");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 294, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("(");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 294, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".valueOf(getEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 294, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\")));");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_293_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_293_10.doEnd();
                                    _jettag_c_iterate_292_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_292_8.doEnd();
                                _jettag_c_otherwise_291_6.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_291_6_saved_out;
                            _jettag_c_otherwise_291_6.doEnd();
                            _jettag_c_choose_272_4.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_272_4_saved_out;
                        _jettag_c_choose_272_4.doEnd();
                        _jettag_c_iterate_271_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_271_2.doEnd();
                    _jettag_c_if_270_2.handleBodyContent(out);
                }
                _jettag_c_if_270_2.doEnd();
                // process base class attributes
                RuntimeTagElement _jettag_c_iterate_302_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_302_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_302_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_302_2.setTagInfo(_td_c_iterate_302_2);
                _jettag_c_iterate_302_2.doStart(context, out);
                while (_jettag_c_iterate_302_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_303_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_303_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_303_4.setRuntimeParent(_jettag_c_iterate_302_2);
                    _jettag_c_choose_303_4.setTagInfo(_td_c_choose_303_4);
                    _jettag_c_choose_303_4.doStart(context, out);
                    JET2Writer _jettag_c_choose_303_4_saved_out = out;
                    while (_jettag_c_choose_303_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_304_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_304_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_304_5.setRuntimeParent(_jettag_c_choose_303_4);
                        _jettag_c_when_304_5.setTagInfo(_td_c_when_304_5);
                        _jettag_c_when_304_5.doStart(context, out);
                        JET2Writer _jettag_c_when_304_5_saved_out = out;
                        while (_jettag_c_when_304_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" entity.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 304, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getStringField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 304, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_304_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_304_5_saved_out;
                        _jettag_c_when_304_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_306_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_306_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_306_5.setRuntimeParent(_jettag_c_choose_303_4);
                        _jettag_c_when_306_5.setTagInfo(_td_c_when_306_5);
                        _jettag_c_when_306_5.doStart(context, out);
                        JET2Writer _jettag_c_when_306_5_saved_out = out;
                        while (_jettag_c_when_306_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" entity.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 306, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 306, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_306_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_306_5_saved_out;
                        _jettag_c_when_306_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_308_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_308_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_308_5.setRuntimeParent(_jettag_c_choose_303_4);
                        _jettag_c_when_308_5.setTagInfo(_td_c_when_308_5);
                        _jettag_c_when_308_5.doStart(context, out);
                        JET2Writer _jettag_c_when_308_5_saved_out = out;
                        while (_jettag_c_when_308_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" entity.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 308, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getDateField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 308, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_308_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_308_5_saved_out;
                        _jettag_c_when_308_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_310_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_310_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_310_5.setRuntimeParent(_jettag_c_choose_303_4);
                        _jettag_c_when_310_5.setTagInfo(_td_c_when_310_5);
                        _jettag_c_when_310_5.doStart(context, out);
                        JET2Writer _jettag_c_when_310_5_saved_out = out;
                        while (_jettag_c_when_310_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("entity.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 310, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 310, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_310_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_310_5_saved_out;
                        _jettag_c_when_310_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_312_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_312_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_312_5.setRuntimeParent(_jettag_c_choose_303_4);
                        _jettag_c_when_312_5.setTagInfo(_td_c_when_312_5);
                        _jettag_c_when_312_5.doStart(context, out);
                        JET2Writer _jettag_c_when_312_5_saved_out = out;
                        while (_jettag_c_when_312_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" entity.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 312, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getLongField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 312, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_312_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_312_5_saved_out;
                        _jettag_c_when_312_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_314_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_314_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_314_5.setRuntimeParent(_jettag_c_choose_303_4);
                        _jettag_c_when_314_5.setTagInfo(_td_c_when_314_5);
                        _jettag_c_when_314_5.doStart(context, out);
                        JET2Writer _jettag_c_when_314_5_saved_out = out;
                        while (_jettag_c_when_314_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" entity.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 314, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getFloatField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 314, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_314_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_314_5_saved_out;
                        _jettag_c_when_314_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_316_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_316_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_316_5.setRuntimeParent(_jettag_c_choose_303_4);
                        _jettag_c_when_316_5.setTagInfo(_td_c_when_316_5);
                        _jettag_c_when_316_5.doStart(context, out);
                        JET2Writer _jettag_c_when_316_5_saved_out = out;
                        while (_jettag_c_when_316_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" entity.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 316, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getImageField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 316, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_316_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_316_5_saved_out;
                        _jettag_c_when_316_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_318_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_318_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_318_5.setRuntimeParent(_jettag_c_choose_303_4);
                        _jettag_c_when_318_5.setTagInfo(_td_c_when_318_5);
                        _jettag_c_when_318_5.doStart(context, out);
                        JET2Writer _jettag_c_when_318_5_saved_out = out;
                        while (_jettag_c_when_318_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" entity.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 318, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getRichTextField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 318, 104)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_318_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_318_5_saved_out;
                        _jettag_c_when_318_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_320_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_320_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_320_5.setRuntimeParent(_jettag_c_choose_303_4);
                        _jettag_c_when_320_5.setTagInfo(_td_c_when_320_5);
                        _jettag_c_when_320_5.doStart(context, out);
                        JET2Writer _jettag_c_when_320_5_saved_out = out;
                        while (_jettag_c_when_320_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" entity.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 320, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 320, 104)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_320_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_320_5_saved_out;
                        _jettag_c_when_320_5.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_322_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_322_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_322_6.setRuntimeParent(_jettag_c_choose_303_4);
                        _jettag_c_otherwise_322_6.setTagInfo(_td_c_otherwise_322_6);
                        _jettag_c_otherwise_322_6.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_322_6_saved_out = out;
                        while (_jettag_c_otherwise_322_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_323_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_323_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_323_8.setRuntimeParent(_jettag_c_otherwise_322_6);
                            _jettag_c_iterate_323_8.setTagInfo(_td_c_iterate_323_8);
                            _jettag_c_iterate_323_8.doStart(context, out);
                            while (_jettag_c_iterate_323_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_324_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_324_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_324_10.setRuntimeParent(_jettag_c_iterate_323_8);
                                _jettag_c_if_324_10.setTagInfo(_td_c_if_324_10);
                                _jettag_c_if_324_10.doStart(context, out);
                                while (_jettag_c_if_324_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\tentity.set");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 325, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("(");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 325, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".valueOf(getEnumField(\"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 325, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\")));");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_324_10.handleBodyContent(out);
                                }
                                _jettag_c_if_324_10.doEnd();
                                _jettag_c_iterate_323_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_323_8.doEnd();
                            _jettag_c_otherwise_322_6.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_322_6_saved_out;
                        _jettag_c_otherwise_322_6.doEnd();
                        _jettag_c_choose_303_4.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_303_4_saved_out;
                    _jettag_c_choose_303_4.doEnd();
                    _jettag_c_iterate_302_2.handleBodyContent(out);
                }
                _jettag_c_iterate_302_2.doEnd();
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process dropdowns one tone and many to one 
                RuntimeTagElement _jettag_c_iterate_333_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_333_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_333_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_333_4.setTagInfo(_td_c_iterate_333_4);
                _jettag_c_iterate_333_4.doStart(context, out);
                while (_jettag_c_iterate_333_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_334_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_334_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_334_5.setRuntimeParent(_jettag_c_iterate_333_4);
                    _jettag_c_iterate_334_5.setTagInfo(_td_c_iterate_334_5);
                    _jettag_c_iterate_334_5.doStart(context, out);
                    while (_jettag_c_iterate_334_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_335_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_335_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_335_6.setRuntimeParent(_jettag_c_iterate_334_5);
                        _jettag_c_iterate_335_6.setTagInfo(_td_c_iterate_335_6);
                        _jettag_c_iterate_335_6.doStart(context, out);
                        while (_jettag_c_iterate_335_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_336_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_336_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_336_7.setRuntimeParent(_jettag_c_iterate_335_6);
                            _jettag_c_setVariable_336_7.setTagInfo(_td_c_setVariable_336_7);
                            _jettag_c_setVariable_336_7.doStart(context, out);
                            _jettag_c_setVariable_336_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_338_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_338_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_338_9.setRuntimeParent(_jettag_c_iterate_335_6);
                            _jettag_c_if_338_9.setTagInfo(_td_c_if_338_9);
                            _jettag_c_if_338_9.doStart(context, out);
                            while (_jettag_c_if_338_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_340_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_340_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_340_15.setRuntimeParent(_jettag_c_if_338_9);
                                _jettag_c_iterate_340_15.setTagInfo(_td_c_iterate_340_15);
                                _jettag_c_iterate_340_15.doStart(context, out);
                                while (_jettag_c_iterate_340_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_341_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_341_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_341_15.setRuntimeParent(_jettag_c_iterate_340_15);
                                    _jettag_c_setVariable_341_15.setTagInfo(_td_c_setVariable_341_15);
                                    _jettag_c_setVariable_341_15.doStart(context, out);
                                    _jettag_c_setVariable_341_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_343_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_343_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_343_17.setRuntimeParent(_jettag_c_iterate_340_15);
                                    _jettag_c_if_343_17.setTagInfo(_td_c_if_343_17);
                                    _jettag_c_if_343_17.doStart(context, out);
                                    while (_jettag_c_if_343_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_345_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_345_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_345_18.setRuntimeParent(_jettag_c_if_343_17);
                                        _jettag_c_iterate_345_18.setTagInfo(_td_c_iterate_345_18);
                                        _jettag_c_iterate_345_18.doStart(context, out);
                                        while (_jettag_c_iterate_345_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_346_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_346_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_346_19.setRuntimeParent(_jettag_c_iterate_345_18);
                                            _jettag_c_if_346_19.setTagInfo(_td_c_if_346_19);
                                            _jettag_c_if_346_19.doStart(context, out);
                                            while (_jettag_c_if_346_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_349_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_349_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_349_19.setRuntimeParent(_jettag_c_if_346_19);
                                                _jettag_c_if_349_19.setTagInfo(_td_c_if_349_19);
                                                _jettag_c_if_349_19.doStart(context, out);
                                                while (_jettag_c_if_349_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_350_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_350_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_350_21.setRuntimeParent(_jettag_c_if_349_19);
                                                    _jettag_c_if_350_21.setTagInfo(_td_c_if_350_21);
                                                    _jettag_c_if_350_21.doStart(context, out);
                                                    while (_jettag_c_if_350_21.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_352_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_352_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_352_18.setRuntimeParent(_jettag_c_if_350_21);
                                                        _jettag_c_if_352_18.setTagInfo(_td_c_if_352_18);
                                                        _jettag_c_if_352_18.doStart(context, out);
                                                        while (_jettag_c_if_352_18.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\tentity.set");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($class2/@name)}", 353, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("(select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 353, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel.getEntity());");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_352_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_352_18.doEnd();
                                                        _jettag_c_if_350_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_350_21.doEnd();
                                                    _jettag_c_if_349_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_349_19.doEnd();
                                                _jettag_c_if_346_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_346_19.doEnd();
                                            _jettag_c_iterate_345_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_345_18.doEnd();
                                        _jettag_c_if_343_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_343_17.doEnd();
                                    _jettag_c_iterate_340_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_340_15.doEnd();
                                _jettag_c_if_338_9.handleBodyContent(out);
                            }
                            _jettag_c_if_338_9.doEnd();
                            _jettag_c_iterate_335_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_335_6.doEnd();
                        _jettag_c_iterate_334_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_334_5.doEnd();
                    _jettag_c_iterate_333_4.handleBodyContent(out);
                }
                _jettag_c_iterate_333_4.doEnd();
                out.write("\t\treturn entity;\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_368_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_368_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_368_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_368_1.setTagInfo(_td_f_message_368_1);
                _jettag_f_message_368_1.doStart(context, out);
                JET2Writer _jettag_f_message_368_1_saved_out = out;
                while (_jettag_f_message_368_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_368_1.handleBodyContent(out);
                }
                out = _jettag_f_message_368_1_saved_out;
                _jettag_f_message_368_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic void updateButtonClicked() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 371, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 371, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 371, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 371, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync.instance().update(entity,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tnew ALAsyncCallback<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 372, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\tpublic void onResponse(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 373, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" arg0) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tnew ResponseStatusWidget().show(\"updated\");");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t});");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_378_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_378_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_378_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_378_1.setTagInfo(_td_f_message_378_1);
                _jettag_f_message_378_1.doStart(context, out);
                JET2Writer _jettag_f_message_378_1_saved_out = out;
                while (_jettag_f_message_378_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_378_1.handleBodyContent(out);
                }
                out = _jettag_f_message_378_1_saved_out;
                _jettag_f_message_378_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_384_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_384_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_384_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_384_1.setTagInfo(_td_f_message_384_1);
                _jettag_f_message_384_1.doStart(context, out);
                JET2Writer _jettag_f_message_384_1_saved_out = out;
                while (_jettag_f_message_384_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_384_1.handleBodyContent(out);
                }
                out = _jettag_f_message_384_1_saved_out;
                _jettag_f_message_384_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_390_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_390_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_390_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_390_1.setTagInfo(_td_f_message_390_1);
                _jettag_f_message_390_1.doStart(context, out);
                JET2Writer _jettag_f_message_390_1_saved_out = out;
                while (_jettag_f_message_390_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_390_1.handleBodyContent(out);
                }
                out = _jettag_f_message_390_1_saved_out;
                _jettag_f_message_390_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void addWidgets() {");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_394_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_394_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_394_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_394_2.setTagInfo(_td_c_if_394_2);
                _jettag_c_if_394_2.doStart(context, out);
                while (_jettag_c_if_394_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_395_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_395_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_395_5.setRuntimeParent(_jettag_c_if_394_2);
                    _jettag_c_iterate_395_5.setTagInfo(_td_c_iterate_395_5);
                    _jettag_c_iterate_395_5.doStart(context, out);
                    while (_jettag_c_iterate_395_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_396_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_396_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_396_5.setRuntimeParent(_jettag_c_iterate_395_5);
                        _jettag_c_choose_396_5.setTagInfo(_td_c_choose_396_5);
                        _jettag_c_choose_396_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_396_5_saved_out = out;
                        while (_jettag_c_choose_396_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_397_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_397_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_397_6.setRuntimeParent(_jettag_c_choose_396_5);
                            _jettag_c_when_397_6.setTagInfo(_td_c_when_397_6);
                            _jettag_c_when_397_6.doStart(context, out);
                            JET2Writer _jettag_c_when_397_6_saved_out = out;
                            while (_jettag_c_when_397_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 397, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 397, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_397_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_397_6_saved_out;
                            _jettag_c_when_397_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_399_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_399_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_399_6.setRuntimeParent(_jettag_c_choose_396_5);
                            _jettag_c_when_399_6.setTagInfo(_td_c_when_399_6);
                            _jettag_c_when_399_6.doStart(context, out);
                            JET2Writer _jettag_c_when_399_6_saved_out = out;
                            while (_jettag_c_when_399_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 399, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 399, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_399_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_399_6_saved_out;
                            _jettag_c_when_399_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_401_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_401_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_401_6.setRuntimeParent(_jettag_c_choose_396_5);
                            _jettag_c_when_401_6.setTagInfo(_td_c_when_401_6);
                            _jettag_c_when_401_6.doStart(context, out);
                            JET2Writer _jettag_c_when_401_6_saved_out = out;
                            while (_jettag_c_when_401_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 401, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 401, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_401_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_401_6_saved_out;
                            _jettag_c_when_401_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_403_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_403_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_403_6.setRuntimeParent(_jettag_c_choose_396_5);
                            _jettag_c_when_403_6.setTagInfo(_td_c_when_403_6);
                            _jettag_c_when_403_6.doStart(context, out);
                            JET2Writer _jettag_c_when_403_6_saved_out = out;
                            while (_jettag_c_when_403_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 403, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 403, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_403_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_403_6_saved_out;
                            _jettag_c_when_403_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_405_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_405_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_405_6.setRuntimeParent(_jettag_c_choose_396_5);
                            _jettag_c_when_405_6.setTagInfo(_td_c_when_405_6);
                            _jettag_c_when_405_6.doStart(context, out);
                            JET2Writer _jettag_c_when_405_6_saved_out = out;
                            while (_jettag_c_when_405_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 405, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 405, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_405_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_405_6_saved_out;
                            _jettag_c_when_405_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_407_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_407_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_407_6.setRuntimeParent(_jettag_c_choose_396_5);
                            _jettag_c_when_407_6.setTagInfo(_td_c_when_407_6);
                            _jettag_c_when_407_6.doStart(context, out);
                            JET2Writer _jettag_c_when_407_6_saved_out = out;
                            while (_jettag_c_when_407_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 407, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 407, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_407_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_407_6_saved_out;
                            _jettag_c_when_407_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_409_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_409_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_409_6.setRuntimeParent(_jettag_c_choose_396_5);
                            _jettag_c_when_409_6.setTagInfo(_td_c_when_409_6);
                            _jettag_c_when_409_6.doStart(context, out);
                            JET2Writer _jettag_c_when_409_6_saved_out = out;
                            while (_jettag_c_when_409_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 409, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 409, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_409_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_409_6_saved_out;
                            _jettag_c_when_409_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_411_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_411_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_411_6.setRuntimeParent(_jettag_c_choose_396_5);
                            _jettag_c_when_411_6.setTagInfo(_td_c_when_411_6);
                            _jettag_c_when_411_6.doStart(context, out);
                            JET2Writer _jettag_c_when_411_6_saved_out = out;
                            while (_jettag_c_when_411_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 411, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 411, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_411_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_411_6_saved_out;
                            _jettag_c_when_411_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_413_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_413_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_413_6.setRuntimeParent(_jettag_c_choose_396_5);
                            _jettag_c_when_413_6.setTagInfo(_td_c_when_413_6);
                            _jettag_c_when_413_6.doStart(context, out);
                            JET2Writer _jettag_c_when_413_6_saved_out = out;
                            while (_jettag_c_when_413_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 413, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 413, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_413_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_413_6_saved_out;
                            _jettag_c_when_413_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_415_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_415_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_415_7.setRuntimeParent(_jettag_c_choose_396_5);
                            _jettag_c_otherwise_415_7.setTagInfo(_td_c_otherwise_415_7);
                            _jettag_c_otherwise_415_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_415_7_saved_out = out;
                            while (_jettag_c_otherwise_415_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_416_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_416_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_416_8.setRuntimeParent(_jettag_c_otherwise_415_7);
                                _jettag_c_iterate_416_8.setTagInfo(_td_c_iterate_416_8);
                                _jettag_c_iterate_416_8.doStart(context, out);
                                while (_jettag_c_iterate_416_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_417_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_417_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_417_10.setRuntimeParent(_jettag_c_iterate_416_8);
                                    _jettag_c_if_417_10.setTagInfo(_td_c_if_417_10);
                                    _jettag_c_if_417_10.doStart(context, out);
                                    while (_jettag_c_if_417_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 418, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", false, ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 418, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(", \"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 418, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 418, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".class.getName());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_417_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_417_10.doEnd();
                                    _jettag_c_iterate_416_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_416_8.doEnd();
                                _jettag_c_otherwise_415_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_415_7_saved_out;
                            _jettag_c_otherwise_415_7.doEnd();
                            _jettag_c_choose_396_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_396_5_saved_out;
                        _jettag_c_choose_396_5.doEnd();
                        _jettag_c_iterate_395_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_395_5.doEnd();
                    _jettag_c_if_394_2.handleBodyContent(out);
                }
                _jettag_c_if_394_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_426_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_426_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_426_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_426_2.setTagInfo(_td_c_if_426_2);
                _jettag_c_if_426_2.doStart(context, out);
                while (_jettag_c_if_426_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_427_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_427_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_427_5.setRuntimeParent(_jettag_c_if_426_2);
                    _jettag_c_iterate_427_5.setTagInfo(_td_c_iterate_427_5);
                    _jettag_c_iterate_427_5.doStart(context, out);
                    while (_jettag_c_iterate_427_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_428_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_428_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_428_5.setRuntimeParent(_jettag_c_iterate_427_5);
                        _jettag_c_choose_428_5.setTagInfo(_td_c_choose_428_5);
                        _jettag_c_choose_428_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_428_5_saved_out = out;
                        while (_jettag_c_choose_428_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_429_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_429_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_429_6.setRuntimeParent(_jettag_c_choose_428_5);
                            _jettag_c_when_429_6.setTagInfo(_td_c_when_429_6);
                            _jettag_c_when_429_6.doStart(context, out);
                            JET2Writer _jettag_c_when_429_6_saved_out = out;
                            while (_jettag_c_when_429_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 429, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 429, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_429_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_429_6_saved_out;
                            _jettag_c_when_429_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_431_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_431_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_431_6.setRuntimeParent(_jettag_c_choose_428_5);
                            _jettag_c_when_431_6.setTagInfo(_td_c_when_431_6);
                            _jettag_c_when_431_6.doStart(context, out);
                            JET2Writer _jettag_c_when_431_6_saved_out = out;
                            while (_jettag_c_when_431_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 431, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 431, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_431_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_431_6_saved_out;
                            _jettag_c_when_431_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_433_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_433_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_433_6.setRuntimeParent(_jettag_c_choose_428_5);
                            _jettag_c_when_433_6.setTagInfo(_td_c_when_433_6);
                            _jettag_c_when_433_6.doStart(context, out);
                            JET2Writer _jettag_c_when_433_6_saved_out = out;
                            while (_jettag_c_when_433_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 433, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 433, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_433_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_433_6_saved_out;
                            _jettag_c_when_433_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_435_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_435_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_435_6.setRuntimeParent(_jettag_c_choose_428_5);
                            _jettag_c_when_435_6.setTagInfo(_td_c_when_435_6);
                            _jettag_c_when_435_6.doStart(context, out);
                            JET2Writer _jettag_c_when_435_6_saved_out = out;
                            while (_jettag_c_when_435_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 435, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 435, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_435_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_435_6_saved_out;
                            _jettag_c_when_435_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_437_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_437_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_437_6.setRuntimeParent(_jettag_c_choose_428_5);
                            _jettag_c_when_437_6.setTagInfo(_td_c_when_437_6);
                            _jettag_c_when_437_6.doStart(context, out);
                            JET2Writer _jettag_c_when_437_6_saved_out = out;
                            while (_jettag_c_when_437_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 437, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 437, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_437_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_437_6_saved_out;
                            _jettag_c_when_437_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_439_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_439_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_439_6.setRuntimeParent(_jettag_c_choose_428_5);
                            _jettag_c_when_439_6.setTagInfo(_td_c_when_439_6);
                            _jettag_c_when_439_6.doStart(context, out);
                            JET2Writer _jettag_c_when_439_6_saved_out = out;
                            while (_jettag_c_when_439_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 439, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 439, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_439_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_439_6_saved_out;
                            _jettag_c_when_439_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_441_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_441_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_441_6.setRuntimeParent(_jettag_c_choose_428_5);
                            _jettag_c_when_441_6.setTagInfo(_td_c_when_441_6);
                            _jettag_c_when_441_6.doStart(context, out);
                            JET2Writer _jettag_c_when_441_6_saved_out = out;
                            while (_jettag_c_when_441_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 441, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 441, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_441_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_441_6_saved_out;
                            _jettag_c_when_441_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_443_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_443_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_443_6.setRuntimeParent(_jettag_c_choose_428_5);
                            _jettag_c_when_443_6.setTagInfo(_td_c_when_443_6);
                            _jettag_c_when_443_6.doStart(context, out);
                            JET2Writer _jettag_c_when_443_6_saved_out = out;
                            while (_jettag_c_when_443_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 443, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 443, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_443_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_443_6_saved_out;
                            _jettag_c_when_443_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_445_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_445_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_445_6.setRuntimeParent(_jettag_c_choose_428_5);
                            _jettag_c_when_445_6.setTagInfo(_td_c_when_445_6);
                            _jettag_c_when_445_6.doStart(context, out);
                            JET2Writer _jettag_c_when_445_6_saved_out = out;
                            while (_jettag_c_when_445_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 445, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 445, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_445_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_445_6_saved_out;
                            _jettag_c_when_445_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_447_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_447_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_447_7.setRuntimeParent(_jettag_c_choose_428_5);
                            _jettag_c_otherwise_447_7.setTagInfo(_td_c_otherwise_447_7);
                            _jettag_c_otherwise_447_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_447_7_saved_out = out;
                            while (_jettag_c_otherwise_447_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_448_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_448_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_448_8.setRuntimeParent(_jettag_c_otherwise_447_7);
                                _jettag_c_iterate_448_8.setTagInfo(_td_c_iterate_448_8);
                                _jettag_c_iterate_448_8.doStart(context, out);
                                while (_jettag_c_iterate_448_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_449_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_449_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_449_10.setRuntimeParent(_jettag_c_iterate_448_8);
                                    _jettag_c_if_449_10.setTagInfo(_td_c_if_449_10);
                                    _jettag_c_if_449_10.doStart(context, out);
                                    while (_jettag_c_if_449_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 450, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", false, ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 450, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(", \"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 450, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 450, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".class.getName());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_449_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_449_10.doEnd();
                                    _jettag_c_iterate_448_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_448_8.doEnd();
                                _jettag_c_otherwise_447_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_447_7_saved_out;
                            _jettag_c_otherwise_447_7.doEnd();
                            _jettag_c_choose_428_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_428_5_saved_out;
                        _jettag_c_choose_428_5.doEnd();
                        _jettag_c_iterate_427_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_427_5.doEnd();
                    _jettag_c_if_426_2.handleBodyContent(out);
                }
                _jettag_c_if_426_2.doEnd();
                // process base class attributes 
                RuntimeTagElement _jettag_c_iterate_458_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_458_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_458_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_458_4.setTagInfo(_td_c_iterate_458_4);
                _jettag_c_iterate_458_4.doStart(context, out);
                while (_jettag_c_iterate_458_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_459_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_459_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_459_5.setRuntimeParent(_jettag_c_iterate_458_4);
                    _jettag_c_choose_459_5.setTagInfo(_td_c_choose_459_5);
                    _jettag_c_choose_459_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_459_5_saved_out = out;
                    while (_jettag_c_choose_459_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_460_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_460_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_460_6.setRuntimeParent(_jettag_c_choose_459_5);
                        _jettag_c_when_460_6.setTagInfo(_td_c_when_460_6);
                        _jettag_c_when_460_6.doStart(context, out);
                        JET2Writer _jettag_c_when_460_6_saved_out = out;
                        while (_jettag_c_when_460_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 460, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 460, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_460_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_460_6_saved_out;
                        _jettag_c_when_460_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_462_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_462_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_462_6.setRuntimeParent(_jettag_c_choose_459_5);
                        _jettag_c_when_462_6.setTagInfo(_td_c_when_462_6);
                        _jettag_c_when_462_6.doStart(context, out);
                        JET2Writer _jettag_c_when_462_6_saved_out = out;
                        while (_jettag_c_when_462_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 462, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 462, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_462_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_462_6_saved_out;
                        _jettag_c_when_462_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_464_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_464_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_464_6.setRuntimeParent(_jettag_c_choose_459_5);
                        _jettag_c_when_464_6.setTagInfo(_td_c_when_464_6);
                        _jettag_c_when_464_6.doStart(context, out);
                        JET2Writer _jettag_c_when_464_6_saved_out = out;
                        while (_jettag_c_when_464_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 464, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 464, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_464_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_464_6_saved_out;
                        _jettag_c_when_464_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_466_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_466_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_466_6.setRuntimeParent(_jettag_c_choose_459_5);
                        _jettag_c_when_466_6.setTagInfo(_td_c_when_466_6);
                        _jettag_c_when_466_6.doStart(context, out);
                        JET2Writer _jettag_c_when_466_6_saved_out = out;
                        while (_jettag_c_when_466_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 466, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 466, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_466_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_466_6_saved_out;
                        _jettag_c_when_466_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_468_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_468_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_468_6.setRuntimeParent(_jettag_c_choose_459_5);
                        _jettag_c_when_468_6.setTagInfo(_td_c_when_468_6);
                        _jettag_c_when_468_6.doStart(context, out);
                        JET2Writer _jettag_c_when_468_6_saved_out = out;
                        while (_jettag_c_when_468_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 468, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 468, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_468_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_468_6_saved_out;
                        _jettag_c_when_468_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_470_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_470_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_470_6.setRuntimeParent(_jettag_c_choose_459_5);
                        _jettag_c_when_470_6.setTagInfo(_td_c_when_470_6);
                        _jettag_c_when_470_6.doStart(context, out);
                        JET2Writer _jettag_c_when_470_6_saved_out = out;
                        while (_jettag_c_when_470_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 470, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 470, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_470_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_470_6_saved_out;
                        _jettag_c_when_470_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_472_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_472_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_472_6.setRuntimeParent(_jettag_c_choose_459_5);
                        _jettag_c_when_472_6.setTagInfo(_td_c_when_472_6);
                        _jettag_c_when_472_6.doStart(context, out);
                        JET2Writer _jettag_c_when_472_6_saved_out = out;
                        while (_jettag_c_when_472_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 472, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 472, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_472_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_472_6_saved_out;
                        _jettag_c_when_472_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_474_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_474_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_474_6.setRuntimeParent(_jettag_c_choose_459_5);
                        _jettag_c_when_474_6.setTagInfo(_td_c_when_474_6);
                        _jettag_c_when_474_6.doStart(context, out);
                        JET2Writer _jettag_c_when_474_6_saved_out = out;
                        while (_jettag_c_when_474_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 474, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 474, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_474_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_474_6_saved_out;
                        _jettag_c_when_474_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_476_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_476_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_476_6.setRuntimeParent(_jettag_c_choose_459_5);
                        _jettag_c_when_476_6.setTagInfo(_td_c_when_476_6);
                        _jettag_c_when_476_6.doStart(context, out);
                        JET2Writer _jettag_c_when_476_6_saved_out = out;
                        while (_jettag_c_when_476_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 476, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 476, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_476_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_476_6_saved_out;
                        _jettag_c_when_476_6.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_478_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_478_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_478_7.setRuntimeParent(_jettag_c_choose_459_5);
                        _jettag_c_otherwise_478_7.setTagInfo(_td_c_otherwise_478_7);
                        _jettag_c_otherwise_478_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_478_7_saved_out = out;
                        while (_jettag_c_otherwise_478_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_479_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_479_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_479_8.setRuntimeParent(_jettag_c_otherwise_478_7);
                            _jettag_c_iterate_479_8.setTagInfo(_td_c_iterate_479_8);
                            _jettag_c_iterate_479_8.doStart(context, out);
                            while (_jettag_c_iterate_479_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_480_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_480_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_480_10.setRuntimeParent(_jettag_c_iterate_479_8);
                                _jettag_c_if_480_10.setTagInfo(_td_c_if_480_10);
                                _jettag_c_if_480_10.doStart(context, out);
                                while (_jettag_c_if_480_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 481, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", false, ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 481, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(", \"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 481, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 481, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".class.getName());");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_480_10.handleBodyContent(out);
                                }
                                _jettag_c_if_480_10.doEnd();
                                _jettag_c_iterate_479_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_479_8.doEnd();
                            _jettag_c_otherwise_478_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_478_7_saved_out;
                        _jettag_c_otherwise_478_7.doEnd();
                        _jettag_c_choose_459_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_459_5_saved_out;
                    _jettag_c_choose_459_5.doEnd();
                    _jettag_c_iterate_458_4.handleBodyContent(out);
                }
                _jettag_c_iterate_458_4.doEnd();
                // process dropdowns one to one and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_488_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_488_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_488_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_488_4.setTagInfo(_td_c_iterate_488_4);
                _jettag_c_iterate_488_4.doStart(context, out);
                while (_jettag_c_iterate_488_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_489_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_489_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_489_5.setRuntimeParent(_jettag_c_iterate_488_4);
                    _jettag_c_iterate_489_5.setTagInfo(_td_c_iterate_489_5);
                    _jettag_c_iterate_489_5.doStart(context, out);
                    while (_jettag_c_iterate_489_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_490_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_490_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_490_6.setRuntimeParent(_jettag_c_iterate_489_5);
                        _jettag_c_iterate_490_6.setTagInfo(_td_c_iterate_490_6);
                        _jettag_c_iterate_490_6.doStart(context, out);
                        while (_jettag_c_iterate_490_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_491_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_491_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_491_7.setRuntimeParent(_jettag_c_iterate_490_6);
                            _jettag_c_setVariable_491_7.setTagInfo(_td_c_setVariable_491_7);
                            _jettag_c_setVariable_491_7.doStart(context, out);
                            _jettag_c_setVariable_491_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_493_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_493_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_493_9.setRuntimeParent(_jettag_c_iterate_490_6);
                            _jettag_c_if_493_9.setTagInfo(_td_c_if_493_9);
                            _jettag_c_if_493_9.doStart(context, out);
                            while (_jettag_c_if_493_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_495_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_495_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_495_15.setRuntimeParent(_jettag_c_if_493_9);
                                _jettag_c_iterate_495_15.setTagInfo(_td_c_iterate_495_15);
                                _jettag_c_iterate_495_15.doStart(context, out);
                                while (_jettag_c_iterate_495_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_496_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_496_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_496_15.setRuntimeParent(_jettag_c_iterate_495_15);
                                    _jettag_c_setVariable_496_15.setTagInfo(_td_c_setVariable_496_15);
                                    _jettag_c_setVariable_496_15.doStart(context, out);
                                    _jettag_c_setVariable_496_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_498_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_498_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_498_17.setRuntimeParent(_jettag_c_iterate_495_15);
                                    _jettag_c_if_498_17.setTagInfo(_td_c_if_498_17);
                                    _jettag_c_if_498_17.doStart(context, out);
                                    while (_jettag_c_if_498_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_500_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_500_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_500_18.setRuntimeParent(_jettag_c_if_498_17);
                                        _jettag_c_iterate_500_18.setTagInfo(_td_c_iterate_500_18);
                                        _jettag_c_iterate_500_18.doStart(context, out);
                                        while (_jettag_c_iterate_500_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_501_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_501_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_501_19.setRuntimeParent(_jettag_c_iterate_500_18);
                                            _jettag_c_if_501_19.setTagInfo(_td_c_if_501_19);
                                            _jettag_c_if_501_19.doStart(context, out);
                                            while (_jettag_c_if_501_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_504_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_504_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_504_19.setRuntimeParent(_jettag_c_if_501_19);
                                                _jettag_c_if_504_19.setTagInfo(_td_c_if_504_19);
                                                _jettag_c_if_504_19.doStart(context, out);
                                                while (_jettag_c_if_504_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_505_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_505_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_505_21.setRuntimeParent(_jettag_c_if_504_19);
                                                    _jettag_c_if_505_21.setTagInfo(_td_c_if_505_21);
                                                    _jettag_c_if_505_21.doStart(context, out);
                                                    while (_jettag_c_if_505_21.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_507_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_507_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_507_18.setRuntimeParent(_jettag_c_if_505_21);
                                                        _jettag_c_if_507_18.setTagInfo(_td_c_if_507_18);
                                                        _jettag_c_if_507_18.doStart(context, out);
                                                        while (_jettag_c_if_507_18.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\taddDropDown(select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 508, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_507_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_507_18.doEnd();
                                                        _jettag_c_if_505_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_505_21.doEnd();
                                                    _jettag_c_if_504_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_504_19.doEnd();
                                                _jettag_c_if_501_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_501_19.doEnd();
                                            _jettag_c_iterate_500_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_500_18.doEnd();
                                        _jettag_c_if_498_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_498_17.doEnd();
                                    _jettag_c_iterate_495_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_495_15.doEnd();
                                _jettag_c_if_493_9.handleBodyContent(out);
                            }
                            _jettag_c_if_493_9.doEnd();
                            _jettag_c_iterate_490_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_490_6.doEnd();
                        _jettag_c_iterate_489_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_489_5.doEnd();
                    _jettag_c_iterate_488_4.handleBodyContent(out);
                }
                _jettag_c_iterate_488_4.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_521_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_521_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_521_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_521_1.setTagInfo(_td_f_message_521_1);
                _jettag_f_message_521_1.doStart(context, out);
                JET2Writer _jettag_f_message_521_1_saved_out = out;
                while (_jettag_f_message_521_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_521_1.handleBodyContent(out);
                }
                out = _jettag_f_message_521_1_saved_out;
                _jettag_f_message_521_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void configure() {");  //$NON-NLS-1$        
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
