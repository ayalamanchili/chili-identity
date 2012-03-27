package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_update_panelyjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_update_panelyjava() {
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
    private static final TagInfo _td_c_iterate_56_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            56, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_57_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            57, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_58_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            58, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_59_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            59, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_61_6 = new TagInfo("c:if", //$NON-NLS-1$
            61, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_63_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            63, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_64_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            64, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_66_14 = new TagInfo("c:if", //$NON-NLS-1$
            66, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_68_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            68, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_69_16 = new TagInfo("c:if", //$NON-NLS-1$
            69, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_72_16 = new TagInfo("c:if", //$NON-NLS-1$
            72, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_73_18 = new TagInfo("c:if", //$NON-NLS-1$
            73, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_76_18 = new TagInfo("c:if", //$NON-NLS-1$
            76, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_77_18 = new TagInfo("c:if", //$NON-NLS-1$
            77, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_91_1 = new TagInfo("f:message", //$NON-NLS-1$
            91, 1,
            new String[] {
            },
            new String[] {
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
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
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
    private static final TagInfo _td_c_if_112_16 = new TagInfo("c:if", //$NON-NLS-1$
            112, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_113_18 = new TagInfo("c:if", //$NON-NLS-1$
            113, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_115_18 = new TagInfo("c:if", //$NON-NLS-1$
            115, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_116_1 = new TagInfo("f:message", //$NON-NLS-1$
            116, 1,
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
    private static final TagInfo _td_f_message_134_1 = new TagInfo("f:message", //$NON-NLS-1$
            134, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_139_4 = new TagInfo("c:if", //$NON-NLS-1$
            139, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_140_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            140, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_141_5 = new TagInfo("c:choose", //$NON-NLS-1$
            141, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_142_6 = new TagInfo("c:when", //$NON-NLS-1$
            142, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_144_6 = new TagInfo("c:when", //$NON-NLS-1$
            144, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_146_6 = new TagInfo("c:when", //$NON-NLS-1$
            146, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_148_6 = new TagInfo("c:when", //$NON-NLS-1$
            148, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_150_6 = new TagInfo("c:when", //$NON-NLS-1$
            150, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_152_6 = new TagInfo("c:when", //$NON-NLS-1$
            152, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_154_6 = new TagInfo("c:when", //$NON-NLS-1$
            154, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_156_6 = new TagInfo("c:when", //$NON-NLS-1$
            156, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_158_6 = new TagInfo("c:when", //$NON-NLS-1$
            158, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_160_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            160, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_161_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            161, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_162_10 = new TagInfo("c:if", //$NON-NLS-1$
            162, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_171_4 = new TagInfo("c:if", //$NON-NLS-1$
            171, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_172_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            172, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_173_5 = new TagInfo("c:choose", //$NON-NLS-1$
            173, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_174_6 = new TagInfo("c:when", //$NON-NLS-1$
            174, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_176_6 = new TagInfo("c:when", //$NON-NLS-1$
            176, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_178_6 = new TagInfo("c:when", //$NON-NLS-1$
            178, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_180_6 = new TagInfo("c:when", //$NON-NLS-1$
            180, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_182_6 = new TagInfo("c:when", //$NON-NLS-1$
            182, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_184_6 = new TagInfo("c:when", //$NON-NLS-1$
            184, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_186_6 = new TagInfo("c:when", //$NON-NLS-1$
            186, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_188_6 = new TagInfo("c:when", //$NON-NLS-1$
            188, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_190_6 = new TagInfo("c:when", //$NON-NLS-1$
            190, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_192_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            192, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_193_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            193, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_194_10 = new TagInfo("c:if", //$NON-NLS-1$
            194, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_203_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            203, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_204_5 = new TagInfo("c:choose", //$NON-NLS-1$
            204, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_205_6 = new TagInfo("c:when", //$NON-NLS-1$
            205, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_207_6 = new TagInfo("c:when", //$NON-NLS-1$
            207, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_209_6 = new TagInfo("c:when", //$NON-NLS-1$
            209, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_211_6 = new TagInfo("c:when", //$NON-NLS-1$
            211, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_213_6 = new TagInfo("c:when", //$NON-NLS-1$
            213, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_215_6 = new TagInfo("c:when", //$NON-NLS-1$
            215, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_217_6 = new TagInfo("c:when", //$NON-NLS-1$
            217, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_219_6 = new TagInfo("c:when", //$NON-NLS-1$
            219, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_221_6 = new TagInfo("c:when", //$NON-NLS-1$
            221, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_223_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            223, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_224_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            224, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_225_10 = new TagInfo("c:if", //$NON-NLS-1$
            225, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_235_1 = new TagInfo("f:message", //$NON-NLS-1$
            235, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_241_2 = new TagInfo("c:if", //$NON-NLS-1$
            241, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_242_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            242, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_243_4 = new TagInfo("c:choose", //$NON-NLS-1$
            243, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_244_5 = new TagInfo("c:when", //$NON-NLS-1$
            244, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_246_5 = new TagInfo("c:when", //$NON-NLS-1$
            246, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_248_5 = new TagInfo("c:when", //$NON-NLS-1$
            248, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_250_5 = new TagInfo("c:when", //$NON-NLS-1$
            250, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_252_5 = new TagInfo("c:when", //$NON-NLS-1$
            252, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_254_5 = new TagInfo("c:when", //$NON-NLS-1$
            254, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_256_5 = new TagInfo("c:when", //$NON-NLS-1$
            256, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_258_5 = new TagInfo("c:when", //$NON-NLS-1$
            258, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_260_5 = new TagInfo("c:when", //$NON-NLS-1$
            260, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_262_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            262, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_263_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            263, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_264_10 = new TagInfo("c:if", //$NON-NLS-1$
            264, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_273_2 = new TagInfo("c:if", //$NON-NLS-1$
            273, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_274_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            274, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_275_4 = new TagInfo("c:choose", //$NON-NLS-1$
            275, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_276_5 = new TagInfo("c:when", //$NON-NLS-1$
            276, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_278_5 = new TagInfo("c:when", //$NON-NLS-1$
            278, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_280_5 = new TagInfo("c:when", //$NON-NLS-1$
            280, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_282_5 = new TagInfo("c:when", //$NON-NLS-1$
            282, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_284_5 = new TagInfo("c:when", //$NON-NLS-1$
            284, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_286_5 = new TagInfo("c:when", //$NON-NLS-1$
            286, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_288_5 = new TagInfo("c:when", //$NON-NLS-1$
            288, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_290_5 = new TagInfo("c:when", //$NON-NLS-1$
            290, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_292_5 = new TagInfo("c:when", //$NON-NLS-1$
            292, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_294_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            294, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_295_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            295, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_296_10 = new TagInfo("c:if", //$NON-NLS-1$
            296, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_305_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            305, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_306_4 = new TagInfo("c:choose", //$NON-NLS-1$
            306, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_307_5 = new TagInfo("c:when", //$NON-NLS-1$
            307, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_309_5 = new TagInfo("c:when", //$NON-NLS-1$
            309, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_311_5 = new TagInfo("c:when", //$NON-NLS-1$
            311, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_313_5 = new TagInfo("c:when", //$NON-NLS-1$
            313, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_315_5 = new TagInfo("c:when", //$NON-NLS-1$
            315, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_317_5 = new TagInfo("c:when", //$NON-NLS-1$
            317, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_319_5 = new TagInfo("c:when", //$NON-NLS-1$
            319, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_321_5 = new TagInfo("c:when", //$NON-NLS-1$
            321, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_323_5 = new TagInfo("c:when", //$NON-NLS-1$
            323, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_325_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            325, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_326_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            326, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_327_10 = new TagInfo("c:if", //$NON-NLS-1$
            327, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_336_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            336, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_337_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            337, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_338_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            338, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_339_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            339, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_341_9 = new TagInfo("c:if", //$NON-NLS-1$
            341, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_343_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            343, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_344_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            344, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_346_17 = new TagInfo("c:if", //$NON-NLS-1$
            346, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_348_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            348, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_349_19 = new TagInfo("c:if", //$NON-NLS-1$
            349, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_352_19 = new TagInfo("c:if", //$NON-NLS-1$
            352, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_353_21 = new TagInfo("c:if", //$NON-NLS-1$
            353, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_355_18 = new TagInfo("c:if", //$NON-NLS-1$
            355, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_371_2 = new TagInfo("f:message", //$NON-NLS-1$
            371, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_380_1 = new TagInfo("f:message", //$NON-NLS-1$
            380, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_386_1 = new TagInfo("f:message", //$NON-NLS-1$
            386, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_392_1 = new TagInfo("f:message", //$NON-NLS-1$
            392, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_396_2 = new TagInfo("c:if", //$NON-NLS-1$
            396, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_397_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            397, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_398_5 = new TagInfo("c:choose", //$NON-NLS-1$
            398, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_399_6 = new TagInfo("c:when", //$NON-NLS-1$
            399, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_401_6 = new TagInfo("c:when", //$NON-NLS-1$
            401, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_403_6 = new TagInfo("c:when", //$NON-NLS-1$
            403, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_405_6 = new TagInfo("c:when", //$NON-NLS-1$
            405, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_407_6 = new TagInfo("c:when", //$NON-NLS-1$
            407, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_409_6 = new TagInfo("c:when", //$NON-NLS-1$
            409, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_411_6 = new TagInfo("c:when", //$NON-NLS-1$
            411, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_413_6 = new TagInfo("c:when", //$NON-NLS-1$
            413, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_415_6 = new TagInfo("c:when", //$NON-NLS-1$
            415, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_417_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            417, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_418_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            418, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_419_10 = new TagInfo("c:if", //$NON-NLS-1$
            419, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_428_2 = new TagInfo("c:if", //$NON-NLS-1$
            428, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_429_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            429, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_430_5 = new TagInfo("c:choose", //$NON-NLS-1$
            430, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_431_6 = new TagInfo("c:when", //$NON-NLS-1$
            431, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_433_6 = new TagInfo("c:when", //$NON-NLS-1$
            433, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_435_6 = new TagInfo("c:when", //$NON-NLS-1$
            435, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_437_6 = new TagInfo("c:when", //$NON-NLS-1$
            437, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_439_6 = new TagInfo("c:when", //$NON-NLS-1$
            439, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_441_6 = new TagInfo("c:when", //$NON-NLS-1$
            441, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_443_6 = new TagInfo("c:when", //$NON-NLS-1$
            443, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_445_6 = new TagInfo("c:when", //$NON-NLS-1$
            445, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_447_6 = new TagInfo("c:when", //$NON-NLS-1$
            447, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_449_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            449, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_450_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            450, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_451_10 = new TagInfo("c:if", //$NON-NLS-1$
            451, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_460_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            460, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_461_5 = new TagInfo("c:choose", //$NON-NLS-1$
            461, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_462_6 = new TagInfo("c:when", //$NON-NLS-1$
            462, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_464_6 = new TagInfo("c:when", //$NON-NLS-1$
            464, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_466_6 = new TagInfo("c:when", //$NON-NLS-1$
            466, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_468_6 = new TagInfo("c:when", //$NON-NLS-1$
            468, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_470_6 = new TagInfo("c:when", //$NON-NLS-1$
            470, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_472_6 = new TagInfo("c:when", //$NON-NLS-1$
            472, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_474_6 = new TagInfo("c:when", //$NON-NLS-1$
            474, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_476_6 = new TagInfo("c:when", //$NON-NLS-1$
            476, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_478_6 = new TagInfo("c:when", //$NON-NLS-1$
            478, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_480_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            480, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_481_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            481, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_482_10 = new TagInfo("c:if", //$NON-NLS-1$
            482, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_490_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            490, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_491_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            491, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_492_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            492, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_493_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            493, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_495_9 = new TagInfo("c:if", //$NON-NLS-1$
            495, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_497_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            497, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_498_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            498, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_500_17 = new TagInfo("c:if", //$NON-NLS-1$
            500, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_502_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            502, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_503_19 = new TagInfo("c:if", //$NON-NLS-1$
            503, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_506_19 = new TagInfo("c:if", //$NON-NLS-1$
            506, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_507_21 = new TagInfo("c:if", //$NON-NLS-1$
            507, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_509_18 = new TagInfo("c:if", //$NON-NLS-1$
            509, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_523_1 = new TagInfo("f:message", //$NON-NLS-1$
            523, 1,
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
                out.write("import info.yalamanchili.gwt.widgets.ResponseStatusWidget;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.ReadAllCompositey.ReadAllTableType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.UpdateCompositey;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.fields.DataType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.rf.GenericRequest;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                // process dropdowns one tone and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_56_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_56_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_56_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_56_1.setTagInfo(_td_c_iterate_56_1);
                _jettag_c_iterate_56_1.doStart(context, out);
                while (_jettag_c_iterate_56_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_57_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_57_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_57_2.setRuntimeParent(_jettag_c_iterate_56_1);
                    _jettag_c_iterate_57_2.setTagInfo(_td_c_iterate_57_2);
                    _jettag_c_iterate_57_2.doStart(context, out);
                    while (_jettag_c_iterate_57_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_58_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_58_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_58_3.setRuntimeParent(_jettag_c_iterate_57_2);
                        _jettag_c_iterate_58_3.setTagInfo(_td_c_iterate_58_3);
                        _jettag_c_iterate_58_3.doStart(context, out);
                        while (_jettag_c_iterate_58_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_59_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_59_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_59_4.setRuntimeParent(_jettag_c_iterate_58_3);
                            _jettag_c_setVariable_59_4.setTagInfo(_td_c_setVariable_59_4);
                            _jettag_c_setVariable_59_4.doStart(context, out);
                            _jettag_c_setVariable_59_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_61_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_61_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_61_6.setRuntimeParent(_jettag_c_iterate_58_3);
                            _jettag_c_if_61_6.setTagInfo(_td_c_if_61_6);
                            _jettag_c_if_61_6.doStart(context, out);
                            while (_jettag_c_if_61_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_63_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_63_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_63_12.setRuntimeParent(_jettag_c_if_61_6);
                                _jettag_c_iterate_63_12.setTagInfo(_td_c_iterate_63_12);
                                _jettag_c_iterate_63_12.doStart(context, out);
                                while (_jettag_c_iterate_63_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_64_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_64_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_64_12.setRuntimeParent(_jettag_c_iterate_63_12);
                                    _jettag_c_setVariable_64_12.setTagInfo(_td_c_setVariable_64_12);
                                    _jettag_c_setVariable_64_12.doStart(context, out);
                                    _jettag_c_setVariable_64_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_66_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_66_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_66_14.setRuntimeParent(_jettag_c_iterate_63_12);
                                    _jettag_c_if_66_14.setTagInfo(_td_c_if_66_14);
                                    _jettag_c_if_66_14.doStart(context, out);
                                    while (_jettag_c_if_66_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_68_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_68_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_68_15.setRuntimeParent(_jettag_c_if_66_14);
                                        _jettag_c_iterate_68_15.setTagInfo(_td_c_iterate_68_15);
                                        _jettag_c_iterate_68_15.doStart(context, out);
                                        while (_jettag_c_iterate_68_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_69_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_69_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_69_16.setRuntimeParent(_jettag_c_iterate_68_15);
                                            _jettag_c_if_69_16.setTagInfo(_td_c_if_69_16);
                                            _jettag_c_if_69_16.doStart(context, out);
                                            while (_jettag_c_if_69_16.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_72_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_72_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_72_16.setRuntimeParent(_jettag_c_if_69_16);
                                                _jettag_c_if_72_16.setTagInfo(_td_c_if_72_16);
                                                _jettag_c_if_72_16.doStart(context, out);
                                                while (_jettag_c_if_72_16.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_73_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_73_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_73_18.setRuntimeParent(_jettag_c_if_72_16);
                                                    _jettag_c_if_73_18.setTagInfo(_td_c_if_73_18);
                                                    _jettag_c_if_73_18.doStart(context, out);
                                                    while (_jettag_c_if_73_18.okToProcessBody()) {
                                                        out.write("  \t\t\t\t\t    \t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$groupID}", 74, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".client.");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 74, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 74, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".Select");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 74, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Panely;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        //check for one to one 
                                                        RuntimeTagElement _jettag_c_if_76_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_76_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_76_18.setRuntimeParent(_jettag_c_if_73_18);
                                                        _jettag_c_if_76_18.setTagInfo(_td_c_if_76_18);
                                                        _jettag_c_if_76_18.doStart(context, out);
                                                        while (_jettag_c_if_76_18.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_c_if_77_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_77_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_77_18.setRuntimeParent(_jettag_c_if_76_18);
                                                            _jettag_c_if_77_18.setTagInfo(_td_c_if_77_18);
                                                            _jettag_c_if_77_18.doStart(context, out);
                                                            while (_jettag_c_if_77_18.okToProcessBody()) {
                                                                out.write("  \t\t\t\t\t    \t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$groupID}", 78, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".client.");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 78, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 78, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(".Select");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 78, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("Panely;");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_77_18.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_77_18.doEnd();
                                                            _jettag_c_if_76_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_76_18.doEnd();
                                                        _jettag_c_if_73_18.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_73_18.doEnd();
                                                    _jettag_c_if_72_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_72_16.doEnd();
                                                _jettag_c_if_69_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_69_16.doEnd();
                                            _jettag_c_iterate_68_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_68_15.doEnd();
                                        _jettag_c_if_66_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_66_14.doEnd();
                                    _jettag_c_iterate_63_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_63_12.doEnd();
                                _jettag_c_if_61_6.handleBodyContent(out);
                            }
                            _jettag_c_if_61_6.doEnd();
                            _jettag_c_iterate_58_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_58_3.doEnd();
                        _jettag_c_iterate_57_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_57_2.doEnd();
                    _jettag_c_iterate_56_1.handleBodyContent(out);
                }
                _jettag_c_iterate_56_1.doEnd();
                RuntimeTagElement _jettag_f_message_91_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_91_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_91_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_91_1.setTagInfo(_td_f_message_91_1);
                _jettag_f_message_91_1.doStart(context, out);
                JET2Writer _jettag_f_message_91_1_saved_out = out;
                while (_jettag_f_message_91_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_91_1.handleBodyContent(out);
                }
                out = _jettag_f_message_91_1_saved_out;
                _jettag_f_message_91_1.doEnd();
                out.write(NL);         
                out.write("public class Update");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 92, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely extends UpdateCompositey<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 92, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy> {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                // process dropdowns one tone and many to one 
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
                                    RuntimeTagElement _jettag_c_setVariable_103_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_103_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_103_12.setRuntimeParent(_jettag_c_iterate_102_12);
                                    _jettag_c_setVariable_103_12.setTagInfo(_td_c_setVariable_103_12);
                                    _jettag_c_setVariable_103_12.doStart(context, out);
                                    _jettag_c_setVariable_103_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_105_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_105_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_105_14.setRuntimeParent(_jettag_c_iterate_102_12);
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
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                // TODO need to check navaigability? 
                                                RuntimeTagElement _jettag_c_if_112_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_112_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_112_16.setRuntimeParent(_jettag_c_if_108_16);
                                                _jettag_c_if_112_16.setTagInfo(_td_c_if_112_16);
                                                _jettag_c_if_112_16.doStart(context, out);
                                                while (_jettag_c_if_112_16.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_113_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_113_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_113_18.setRuntimeParent(_jettag_c_if_112_16);
                                                    _jettag_c_if_113_18.setTagInfo(_td_c_if_113_18);
                                                    _jettag_c_if_113_18.doStart(context, out);
                                                    while (_jettag_c_if_113_18.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_115_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_115_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_115_18.setRuntimeParent(_jettag_c_if_113_18);
                                                        _jettag_c_if_115_18.setTagInfo(_td_c_if_115_18);
                                                        _jettag_c_if_115_18.doStart(context, out);
                                                        while (_jettag_c_if_115_18.okToProcessBody()) {
                                                            RuntimeTagElement _jettag_f_message_116_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_116_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_116_1.setRuntimeParent(_jettag_c_if_115_18);
                                                            _jettag_f_message_116_1.setTagInfo(_td_f_message_116_1);
                                                            _jettag_f_message_116_1.doStart(context, out);
                                                            JET2Writer _jettag_f_message_116_1_saved_out = out;
                                                            while (_jettag_f_message_116_1.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_116_1.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_116_1_saved_out;
                                                            _jettag_f_message_116_1.doEnd();
                                                            out.write("  \t\t\t\t\t    \t\t\t\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("  \t\t\t\t\t    \t\t\t\t\t\t\tSelect");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 117, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panely select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 117, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel = new Select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 117, 88)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panely(\"");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 117, 112)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("\",");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tRead");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class/@name}", 118, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panely.instance().getEntity().get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 118, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("());");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_115_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_115_18.doEnd();
                                                        _jettag_c_if_113_18.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_113_18.doEnd();
                                                    _jettag_c_if_112_16.handleBodyContent(out);
                                                }
                                                _jettag_c_if_112_16.doEnd();
                                                _jettag_c_if_108_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_108_16.doEnd();
                                            _jettag_c_iterate_107_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_107_15.doEnd();
                                        _jettag_c_if_105_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_105_14.doEnd();
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
                out.write("\tpublic Update");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 131, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitUpdateComposite(\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 132, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 132, 43)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 132, 73)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\", ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 132, 91)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.constants);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 136, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy populateEntityOnRender() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tproxy = Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 137, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely.instance().getEntity();");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_139_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_139_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_139_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_139_4.setTagInfo(_td_c_if_139_4);
                _jettag_c_if_139_4.doStart(context, out);
                while (_jettag_c_if_139_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_140_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_140_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_140_4.setRuntimeParent(_jettag_c_if_139_4);
                    _jettag_c_iterate_140_4.setTagInfo(_td_c_iterate_140_4);
                    _jettag_c_iterate_140_4.doStart(context, out);
                    while (_jettag_c_iterate_140_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_141_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_141_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_141_5.setRuntimeParent(_jettag_c_iterate_140_4);
                        _jettag_c_choose_141_5.setTagInfo(_td_c_choose_141_5);
                        _jettag_c_choose_141_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_141_5_saved_out = out;
                        while (_jettag_c_choose_141_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_142_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_142_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_142_6.setRuntimeParent(_jettag_c_choose_141_5);
                            _jettag_c_when_142_6.setTagInfo(_td_c_when_142_6);
                            _jettag_c_when_142_6.doStart(context, out);
                            JET2Writer _jettag_c_when_142_6_saved_out = out;
                            while (_jettag_c_when_142_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 142, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 142, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_142_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_142_6_saved_out;
                            _jettag_c_when_142_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_144_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_144_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_144_6.setRuntimeParent(_jettag_c_choose_141_5);
                            _jettag_c_when_144_6.setTagInfo(_td_c_when_144_6);
                            _jettag_c_when_144_6.doStart(context, out);
                            JET2Writer _jettag_c_when_144_6_saved_out = out;
                            while (_jettag_c_when_144_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 144, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 144, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_144_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_144_6_saved_out;
                            _jettag_c_when_144_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_146_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_146_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_146_6.setRuntimeParent(_jettag_c_choose_141_5);
                            _jettag_c_when_146_6.setTagInfo(_td_c_when_146_6);
                            _jettag_c_when_146_6.doStart(context, out);
                            JET2Writer _jettag_c_when_146_6_saved_out = out;
                            while (_jettag_c_when_146_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 146, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 146, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_146_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_146_6_saved_out;
                            _jettag_c_when_146_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_148_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_148_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_148_6.setRuntimeParent(_jettag_c_choose_141_5);
                            _jettag_c_when_148_6.setTagInfo(_td_c_when_148_6);
                            _jettag_c_when_148_6.doStart(context, out);
                            JET2Writer _jettag_c_when_148_6_saved_out = out;
                            while (_jettag_c_when_148_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 148, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 148, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_148_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_148_6_saved_out;
                            _jettag_c_when_148_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_150_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_150_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_150_6.setRuntimeParent(_jettag_c_choose_141_5);
                            _jettag_c_when_150_6.setTagInfo(_td_c_when_150_6);
                            _jettag_c_when_150_6.doStart(context, out);
                            JET2Writer _jettag_c_when_150_6_saved_out = out;
                            while (_jettag_c_when_150_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 150, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 150, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_150_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_150_6_saved_out;
                            _jettag_c_when_150_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_152_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_152_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_152_6.setRuntimeParent(_jettag_c_choose_141_5);
                            _jettag_c_when_152_6.setTagInfo(_td_c_when_152_6);
                            _jettag_c_when_152_6.doStart(context, out);
                            JET2Writer _jettag_c_when_152_6_saved_out = out;
                            while (_jettag_c_when_152_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 152, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 152, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_152_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_152_6_saved_out;
                            _jettag_c_when_152_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_154_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_154_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_154_6.setRuntimeParent(_jettag_c_choose_141_5);
                            _jettag_c_when_154_6.setTagInfo(_td_c_when_154_6);
                            _jettag_c_when_154_6.doStart(context, out);
                            JET2Writer _jettag_c_when_154_6_saved_out = out;
                            while (_jettag_c_when_154_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 154, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 154, 81)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),false); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_154_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_154_6_saved_out;
                            _jettag_c_when_154_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_156_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_156_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_156_6.setRuntimeParent(_jettag_c_choose_141_5);
                            _jettag_c_when_156_6.setTagInfo(_td_c_when_156_6);
                            _jettag_c_when_156_6.doStart(context, out);
                            JET2Writer _jettag_c_when_156_6_saved_out = out;
                            while (_jettag_c_when_156_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 156, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 156, 83)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_156_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_156_6_saved_out;
                            _jettag_c_when_156_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_158_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_158_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_158_6.setRuntimeParent(_jettag_c_choose_141_5);
                            _jettag_c_when_158_6.setTagInfo(_td_c_when_158_6);
                            _jettag_c_when_158_6.doStart(context, out);
                            JET2Writer _jettag_c_when_158_6_saved_out = out;
                            while (_jettag_c_when_158_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 158, 59)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 158, 89)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_158_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_158_6_saved_out;
                            _jettag_c_when_158_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_160_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_160_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_160_7.setRuntimeParent(_jettag_c_choose_141_5);
                            _jettag_c_otherwise_160_7.setTagInfo(_td_c_otherwise_160_7);
                            _jettag_c_otherwise_160_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_160_7_saved_out = out;
                            while (_jettag_c_otherwise_160_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_161_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_161_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_161_8.setRuntimeParent(_jettag_c_otherwise_160_7);
                                _jettag_c_iterate_161_8.setTagInfo(_td_c_iterate_161_8);
                                _jettag_c_iterate_161_8.doStart(context, out);
                                while (_jettag_c_iterate_161_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_162_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_162_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_162_10.setRuntimeParent(_jettag_c_iterate_161_8);
                                    _jettag_c_if_162_10.setTagInfo(_td_c_if_162_10);
                                    _jettag_c_if_162_10.doStart(context, out);
                                    while (_jettag_c_if_162_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tsetEnumFeild(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 163, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", proxy.get");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 163, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("().toString());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_162_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_162_10.doEnd();
                                    _jettag_c_iterate_161_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_161_8.doEnd();
                                _jettag_c_otherwise_160_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_160_7_saved_out;
                            _jettag_c_otherwise_160_7.doEnd();
                            _jettag_c_choose_141_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_141_5_saved_out;
                        _jettag_c_choose_141_5.doEnd();
                        _jettag_c_iterate_140_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_140_4.doEnd();
                    _jettag_c_if_139_4.handleBodyContent(out);
                }
                _jettag_c_if_139_4.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_171_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_171_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_171_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_171_4.setTagInfo(_td_c_if_171_4);
                _jettag_c_if_171_4.doStart(context, out);
                while (_jettag_c_if_171_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_172_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_172_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_172_4.setRuntimeParent(_jettag_c_if_171_4);
                    _jettag_c_iterate_172_4.setTagInfo(_td_c_iterate_172_4);
                    _jettag_c_iterate_172_4.doStart(context, out);
                    while (_jettag_c_iterate_172_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_173_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_173_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_173_5.setRuntimeParent(_jettag_c_iterate_172_4);
                        _jettag_c_choose_173_5.setTagInfo(_td_c_choose_173_5);
                        _jettag_c_choose_173_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_173_5_saved_out = out;
                        while (_jettag_c_choose_173_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_174_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_174_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_174_6.setRuntimeParent(_jettag_c_choose_173_5);
                            _jettag_c_when_174_6.setTagInfo(_td_c_when_174_6);
                            _jettag_c_when_174_6.doStart(context, out);
                            JET2Writer _jettag_c_when_174_6_saved_out = out;
                            while (_jettag_c_when_174_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 174, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 174, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_174_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_174_6_saved_out;
                            _jettag_c_when_174_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_176_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_176_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_176_6.setRuntimeParent(_jettag_c_choose_173_5);
                            _jettag_c_when_176_6.setTagInfo(_td_c_when_176_6);
                            _jettag_c_when_176_6.doStart(context, out);
                            JET2Writer _jettag_c_when_176_6_saved_out = out;
                            while (_jettag_c_when_176_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 176, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 176, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_176_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_176_6_saved_out;
                            _jettag_c_when_176_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_178_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_178_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_178_6.setRuntimeParent(_jettag_c_choose_173_5);
                            _jettag_c_when_178_6.setTagInfo(_td_c_when_178_6);
                            _jettag_c_when_178_6.doStart(context, out);
                            JET2Writer _jettag_c_when_178_6_saved_out = out;
                            while (_jettag_c_when_178_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 178, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 178, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_178_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_178_6_saved_out;
                            _jettag_c_when_178_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_180_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_180_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_180_6.setRuntimeParent(_jettag_c_choose_173_5);
                            _jettag_c_when_180_6.setTagInfo(_td_c_when_180_6);
                            _jettag_c_when_180_6.doStart(context, out);
                            JET2Writer _jettag_c_when_180_6_saved_out = out;
                            while (_jettag_c_when_180_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 180, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 180, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_180_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_180_6_saved_out;
                            _jettag_c_when_180_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_182_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_182_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_182_6.setRuntimeParent(_jettag_c_choose_173_5);
                            _jettag_c_when_182_6.setTagInfo(_td_c_when_182_6);
                            _jettag_c_when_182_6.doStart(context, out);
                            JET2Writer _jettag_c_when_182_6_saved_out = out;
                            while (_jettag_c_when_182_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 182, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 182, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_182_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_182_6_saved_out;
                            _jettag_c_when_182_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_184_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_184_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_184_6.setRuntimeParent(_jettag_c_choose_173_5);
                            _jettag_c_when_184_6.setTagInfo(_td_c_when_184_6);
                            _jettag_c_when_184_6.doStart(context, out);
                            JET2Writer _jettag_c_when_184_6_saved_out = out;
                            while (_jettag_c_when_184_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 184, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 184, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_184_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_184_6_saved_out;
                            _jettag_c_when_184_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_186_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_186_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_186_6.setRuntimeParent(_jettag_c_choose_173_5);
                            _jettag_c_when_186_6.setTagInfo(_td_c_when_186_6);
                            _jettag_c_when_186_6.doStart(context, out);
                            JET2Writer _jettag_c_when_186_6_saved_out = out;
                            while (_jettag_c_when_186_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 186, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 186, 81)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),false); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_186_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_186_6_saved_out;
                            _jettag_c_when_186_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_188_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_188_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_188_6.setRuntimeParent(_jettag_c_choose_173_5);
                            _jettag_c_when_188_6.setTagInfo(_td_c_when_188_6);
                            _jettag_c_when_188_6.doStart(context, out);
                            JET2Writer _jettag_c_when_188_6_saved_out = out;
                            while (_jettag_c_when_188_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 188, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 188, 83)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_188_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_188_6_saved_out;
                            _jettag_c_when_188_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_190_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_190_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_190_6.setRuntimeParent(_jettag_c_choose_173_5);
                            _jettag_c_when_190_6.setTagInfo(_td_c_when_190_6);
                            _jettag_c_when_190_6.doStart(context, out);
                            JET2Writer _jettag_c_when_190_6_saved_out = out;
                            while (_jettag_c_when_190_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 190, 59)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",proxy.get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 190, 89)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_190_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_190_6_saved_out;
                            _jettag_c_when_190_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_192_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_192_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_192_7.setRuntimeParent(_jettag_c_choose_173_5);
                            _jettag_c_otherwise_192_7.setTagInfo(_td_c_otherwise_192_7);
                            _jettag_c_otherwise_192_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_192_7_saved_out = out;
                            while (_jettag_c_otherwise_192_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_193_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_193_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_193_8.setRuntimeParent(_jettag_c_otherwise_192_7);
                                _jettag_c_iterate_193_8.setTagInfo(_td_c_iterate_193_8);
                                _jettag_c_iterate_193_8.doStart(context, out);
                                while (_jettag_c_iterate_193_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_194_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_194_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_194_10.setRuntimeParent(_jettag_c_iterate_193_8);
                                    _jettag_c_if_194_10.setTagInfo(_td_c_if_194_10);
                                    _jettag_c_if_194_10.doStart(context, out);
                                    while (_jettag_c_if_194_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tsetEnumFeild(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 195, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", proxy.get");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 195, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("().toString());\t\t\t\t\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_194_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_194_10.doEnd();
                                    _jettag_c_iterate_193_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_193_8.doEnd();
                                _jettag_c_otherwise_192_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_192_7_saved_out;
                            _jettag_c_otherwise_192_7.doEnd();
                            _jettag_c_choose_173_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_173_5_saved_out;
                        _jettag_c_choose_173_5.doEnd();
                        _jettag_c_iterate_172_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_172_4.doEnd();
                    _jettag_c_if_171_4.handleBodyContent(out);
                }
                _jettag_c_if_171_4.doEnd();
                // process parent class level 0 attributes
                RuntimeTagElement _jettag_c_iterate_203_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_203_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_203_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_203_4.setTagInfo(_td_c_iterate_203_4);
                _jettag_c_iterate_203_4.doStart(context, out);
                while (_jettag_c_iterate_203_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_204_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_204_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_204_5.setRuntimeParent(_jettag_c_iterate_203_4);
                    _jettag_c_choose_204_5.setTagInfo(_td_c_choose_204_5);
                    _jettag_c_choose_204_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_204_5_saved_out = out;
                    while (_jettag_c_choose_204_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_205_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_205_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_205_6.setRuntimeParent(_jettag_c_choose_204_5);
                        _jettag_c_when_205_6.setTagInfo(_td_c_when_205_6);
                        _jettag_c_when_205_6.doStart(context, out);
                        JET2Writer _jettag_c_when_205_6_saved_out = out;
                        while (_jettag_c_when_205_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 205, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",proxy.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 205, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_205_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_205_6_saved_out;
                        _jettag_c_when_205_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_207_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_207_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_207_6.setRuntimeParent(_jettag_c_choose_204_5);
                        _jettag_c_when_207_6.setTagInfo(_td_c_when_207_6);
                        _jettag_c_when_207_6.doStart(context, out);
                        JET2Writer _jettag_c_when_207_6_saved_out = out;
                        while (_jettag_c_when_207_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 207, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",proxy.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 207, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_207_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_207_6_saved_out;
                        _jettag_c_when_207_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_209_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_209_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_209_6.setRuntimeParent(_jettag_c_choose_204_5);
                        _jettag_c_when_209_6.setTagInfo(_td_c_when_209_6);
                        _jettag_c_when_209_6.doStart(context, out);
                        JET2Writer _jettag_c_when_209_6_saved_out = out;
                        while (_jettag_c_when_209_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 209, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",proxy.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 209, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_209_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_209_6_saved_out;
                        _jettag_c_when_209_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_211_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_211_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_211_6.setRuntimeParent(_jettag_c_choose_204_5);
                        _jettag_c_when_211_6.setTagInfo(_td_c_when_211_6);
                        _jettag_c_when_211_6.doStart(context, out);
                        JET2Writer _jettag_c_when_211_6_saved_out = out;
                        while (_jettag_c_when_211_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 211, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",proxy.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 211, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_211_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_211_6_saved_out;
                        _jettag_c_when_211_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_213_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_213_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_213_6.setRuntimeParent(_jettag_c_choose_204_5);
                        _jettag_c_when_213_6.setTagInfo(_td_c_when_213_6);
                        _jettag_c_when_213_6.doStart(context, out);
                        JET2Writer _jettag_c_when_213_6_saved_out = out;
                        while (_jettag_c_when_213_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 213, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",proxy.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 213, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_213_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_213_6_saved_out;
                        _jettag_c_when_213_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_215_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_215_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_215_6.setRuntimeParent(_jettag_c_choose_204_5);
                        _jettag_c_when_215_6.setTagInfo(_td_c_when_215_6);
                        _jettag_c_when_215_6.doStart(context, out);
                        JET2Writer _jettag_c_when_215_6_saved_out = out;
                        while (_jettag_c_when_215_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 215, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",proxy.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 215, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_215_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_215_6_saved_out;
                        _jettag_c_when_215_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_217_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_217_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_217_6.setRuntimeParent(_jettag_c_choose_204_5);
                        _jettag_c_when_217_6.setTagInfo(_td_c_when_217_6);
                        _jettag_c_when_217_6.doStart(context, out);
                        JET2Writer _jettag_c_when_217_6_saved_out = out;
                        while (_jettag_c_when_217_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 217, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",proxy.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 217, 81)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(),false); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_217_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_217_6_saved_out;
                        _jettag_c_when_217_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_219_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_219_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_219_6.setRuntimeParent(_jettag_c_choose_204_5);
                        _jettag_c_when_219_6.setTagInfo(_td_c_when_219_6);
                        _jettag_c_when_219_6.doStart(context, out);
                        JET2Writer _jettag_c_when_219_6_saved_out = out;
                        while (_jettag_c_when_219_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setImageField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 219, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",proxy.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 219, 83)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_219_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_219_6_saved_out;
                        _jettag_c_when_219_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_221_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_221_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_221_6.setRuntimeParent(_jettag_c_choose_204_5);
                        _jettag_c_when_221_6.setTagInfo(_td_c_when_221_6);
                        _jettag_c_when_221_6.doStart(context, out);
                        JET2Writer _jettag_c_when_221_6_saved_out = out;
                        while (_jettag_c_when_221_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setRichTextField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 221, 59)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",proxy.get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 221, 89)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_221_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_221_6_saved_out;
                        _jettag_c_when_221_6.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_223_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_223_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_223_7.setRuntimeParent(_jettag_c_choose_204_5);
                        _jettag_c_otherwise_223_7.setTagInfo(_td_c_otherwise_223_7);
                        _jettag_c_otherwise_223_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_223_7_saved_out = out;
                        while (_jettag_c_otherwise_223_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_224_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_224_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_224_8.setRuntimeParent(_jettag_c_otherwise_223_7);
                            _jettag_c_iterate_224_8.setTagInfo(_td_c_iterate_224_8);
                            _jettag_c_iterate_224_8.doStart(context, out);
                            while (_jettag_c_iterate_224_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_225_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_225_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_225_10.setRuntimeParent(_jettag_c_iterate_224_8);
                                _jettag_c_if_225_10.setTagInfo(_td_c_if_225_10);
                                _jettag_c_if_225_10.doStart(context, out);
                                while (_jettag_c_if_225_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\tsetEnumFeild(\"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 226, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", proxy.get");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 226, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("().toString());\t\t\t\t\t\t");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_225_10.handleBodyContent(out);
                                }
                                _jettag_c_if_225_10.doEnd();
                                _jettag_c_iterate_224_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_224_8.doEnd();
                            _jettag_c_otherwise_223_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_223_7_saved_out;
                        _jettag_c_otherwise_223_7.doEnd();
                        _jettag_c_choose_204_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_204_5_saved_out;
                    _jettag_c_choose_204_5.doEnd();
                    _jettag_c_iterate_203_4.handleBodyContent(out);
                }
                _jettag_c_iterate_203_4.doEnd();
                out.write("\t\t//no need to render dropdowns\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\treturn proxy;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t}");  //$NON-NLS-1$        
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
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 237, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy populateEntityOnUpdate(){");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\trequest = (GenericRequest<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 238, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy>) ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 238, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.requestFactory");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 239, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Request();");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_241_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_241_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_241_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_241_2.setTagInfo(_td_c_if_241_2);
                _jettag_c_if_241_2.doStart(context, out);
                while (_jettag_c_if_241_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_242_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_242_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_242_2.setRuntimeParent(_jettag_c_if_241_2);
                    _jettag_c_iterate_242_2.setTagInfo(_td_c_iterate_242_2);
                    _jettag_c_iterate_242_2.doStart(context, out);
                    while (_jettag_c_iterate_242_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_243_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_243_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_243_4.setRuntimeParent(_jettag_c_iterate_242_2);
                        _jettag_c_choose_243_4.setTagInfo(_td_c_choose_243_4);
                        _jettag_c_choose_243_4.doStart(context, out);
                        JET2Writer _jettag_c_choose_243_4_saved_out = out;
                        while (_jettag_c_choose_243_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_244_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_244_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_244_5.setRuntimeParent(_jettag_c_choose_243_4);
                            _jettag_c_when_244_5.setTagInfo(_td_c_when_244_5);
                            _jettag_c_when_244_5.doStart(context, out);
                            JET2Writer _jettag_c_when_244_5_saved_out = out;
                            while (_jettag_c_when_244_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 244, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getStringField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 244, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_244_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_244_5_saved_out;
                            _jettag_c_when_244_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_246_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_246_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_246_5.setRuntimeParent(_jettag_c_choose_243_4);
                            _jettag_c_when_246_5.setTagInfo(_td_c_when_246_5);
                            _jettag_c_when_246_5.doStart(context, out);
                            JET2Writer _jettag_c_when_246_5_saved_out = out;
                            while (_jettag_c_when_246_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 246, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 246, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_246_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_246_5_saved_out;
                            _jettag_c_when_246_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_248_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_248_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_248_5.setRuntimeParent(_jettag_c_choose_243_4);
                            _jettag_c_when_248_5.setTagInfo(_td_c_when_248_5);
                            _jettag_c_when_248_5.doStart(context, out);
                            JET2Writer _jettag_c_when_248_5_saved_out = out;
                            while (_jettag_c_when_248_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 248, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getDateField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 248, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_248_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_248_5_saved_out;
                            _jettag_c_when_248_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_250_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_250_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_250_5.setRuntimeParent(_jettag_c_choose_243_4);
                            _jettag_c_when_250_5.setTagInfo(_td_c_when_250_5);
                            _jettag_c_when_250_5.doStart(context, out);
                            JET2Writer _jettag_c_when_250_5_saved_out = out;
                            while (_jettag_c_when_250_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 250, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 250, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_250_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_250_5_saved_out;
                            _jettag_c_when_250_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_252_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_252_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_252_5.setRuntimeParent(_jettag_c_choose_243_4);
                            _jettag_c_when_252_5.setTagInfo(_td_c_when_252_5);
                            _jettag_c_when_252_5.doStart(context, out);
                            JET2Writer _jettag_c_when_252_5_saved_out = out;
                            while (_jettag_c_when_252_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 252, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getLongField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 252, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_252_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_252_5_saved_out;
                            _jettag_c_when_252_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_254_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_254_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_254_5.setRuntimeParent(_jettag_c_choose_243_4);
                            _jettag_c_when_254_5.setTagInfo(_td_c_when_254_5);
                            _jettag_c_when_254_5.doStart(context, out);
                            JET2Writer _jettag_c_when_254_5_saved_out = out;
                            while (_jettag_c_when_254_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 254, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getFloatField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 254, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_254_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_254_5_saved_out;
                            _jettag_c_when_254_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_256_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_256_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_256_5.setRuntimeParent(_jettag_c_choose_243_4);
                            _jettag_c_when_256_5.setTagInfo(_td_c_when_256_5);
                            _jettag_c_when_256_5.doStart(context, out);
                            JET2Writer _jettag_c_when_256_5_saved_out = out;
                            while (_jettag_c_when_256_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 256, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 256, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_256_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_256_5_saved_out;
                            _jettag_c_when_256_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_258_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_258_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_258_5.setRuntimeParent(_jettag_c_choose_243_4);
                            _jettag_c_when_258_5.setTagInfo(_td_c_when_258_5);
                            _jettag_c_when_258_5.doStart(context, out);
                            JET2Writer _jettag_c_when_258_5_saved_out = out;
                            while (_jettag_c_when_258_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 258, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 258, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_258_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_258_5_saved_out;
                            _jettag_c_when_258_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_260_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_260_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_260_5.setRuntimeParent(_jettag_c_choose_243_4);
                            _jettag_c_when_260_5.setTagInfo(_td_c_when_260_5);
                            _jettag_c_when_260_5.doStart(context, out);
                            JET2Writer _jettag_c_when_260_5_saved_out = out;
                            while (_jettag_c_when_260_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 260, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 260, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_260_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_260_5_saved_out;
                            _jettag_c_when_260_5.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_262_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_262_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_262_6.setRuntimeParent(_jettag_c_choose_243_4);
                            _jettag_c_otherwise_262_6.setTagInfo(_td_c_otherwise_262_6);
                            _jettag_c_otherwise_262_6.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_262_6_saved_out = out;
                            while (_jettag_c_otherwise_262_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_263_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_263_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_263_8.setRuntimeParent(_jettag_c_otherwise_262_6);
                                _jettag_c_iterate_263_8.setTagInfo(_td_c_iterate_263_8);
                                _jettag_c_iterate_263_8.doStart(context, out);
                                while (_jettag_c_iterate_263_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_264_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_264_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_264_10.setRuntimeParent(_jettag_c_iterate_263_8);
                                    _jettag_c_if_264_10.setTagInfo(_td_c_if_264_10);
                                    _jettag_c_if_264_10.doStart(context, out);
                                    while (_jettag_c_if_264_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tproxy.set");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 265, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("(");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 265, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".valueOf(getEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 265, 116)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\")));");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_264_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_264_10.doEnd();
                                    _jettag_c_iterate_263_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_263_8.doEnd();
                                _jettag_c_otherwise_262_6.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_262_6_saved_out;
                            _jettag_c_otherwise_262_6.doEnd();
                            _jettag_c_choose_243_4.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_243_4_saved_out;
                        _jettag_c_choose_243_4.doEnd();
                        _jettag_c_iterate_242_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_242_2.doEnd();
                    _jettag_c_if_241_2.handleBodyContent(out);
                }
                _jettag_c_if_241_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_273_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_273_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_273_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_273_2.setTagInfo(_td_c_if_273_2);
                _jettag_c_if_273_2.doStart(context, out);
                while (_jettag_c_if_273_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_274_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_274_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_274_2.setRuntimeParent(_jettag_c_if_273_2);
                    _jettag_c_iterate_274_2.setTagInfo(_td_c_iterate_274_2);
                    _jettag_c_iterate_274_2.doStart(context, out);
                    while (_jettag_c_iterate_274_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_275_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_275_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_275_4.setRuntimeParent(_jettag_c_iterate_274_2);
                        _jettag_c_choose_275_4.setTagInfo(_td_c_choose_275_4);
                        _jettag_c_choose_275_4.doStart(context, out);
                        JET2Writer _jettag_c_choose_275_4_saved_out = out;
                        while (_jettag_c_choose_275_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_276_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_276_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_276_5.setRuntimeParent(_jettag_c_choose_275_4);
                            _jettag_c_when_276_5.setTagInfo(_td_c_when_276_5);
                            _jettag_c_when_276_5.doStart(context, out);
                            JET2Writer _jettag_c_when_276_5_saved_out = out;
                            while (_jettag_c_when_276_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 276, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getStringField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 276, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_276_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_276_5_saved_out;
                            _jettag_c_when_276_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_278_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_278_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_278_5.setRuntimeParent(_jettag_c_choose_275_4);
                            _jettag_c_when_278_5.setTagInfo(_td_c_when_278_5);
                            _jettag_c_when_278_5.doStart(context, out);
                            JET2Writer _jettag_c_when_278_5_saved_out = out;
                            while (_jettag_c_when_278_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 278, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 278, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_278_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_278_5_saved_out;
                            _jettag_c_when_278_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_280_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_280_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_280_5.setRuntimeParent(_jettag_c_choose_275_4);
                            _jettag_c_when_280_5.setTagInfo(_td_c_when_280_5);
                            _jettag_c_when_280_5.doStart(context, out);
                            JET2Writer _jettag_c_when_280_5_saved_out = out;
                            while (_jettag_c_when_280_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 280, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getDateField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 280, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_280_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_280_5_saved_out;
                            _jettag_c_when_280_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_282_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_282_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_282_5.setRuntimeParent(_jettag_c_choose_275_4);
                            _jettag_c_when_282_5.setTagInfo(_td_c_when_282_5);
                            _jettag_c_when_282_5.doStart(context, out);
                            JET2Writer _jettag_c_when_282_5_saved_out = out;
                            while (_jettag_c_when_282_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 282, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 282, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_282_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_282_5_saved_out;
                            _jettag_c_when_282_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_284_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_284_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_284_5.setRuntimeParent(_jettag_c_choose_275_4);
                            _jettag_c_when_284_5.setTagInfo(_td_c_when_284_5);
                            _jettag_c_when_284_5.doStart(context, out);
                            JET2Writer _jettag_c_when_284_5_saved_out = out;
                            while (_jettag_c_when_284_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 284, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getLongField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 284, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_284_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_284_5_saved_out;
                            _jettag_c_when_284_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_286_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_286_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_286_5.setRuntimeParent(_jettag_c_choose_275_4);
                            _jettag_c_when_286_5.setTagInfo(_td_c_when_286_5);
                            _jettag_c_when_286_5.doStart(context, out);
                            JET2Writer _jettag_c_when_286_5_saved_out = out;
                            while (_jettag_c_when_286_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 286, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getFloatField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 286, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_286_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_286_5_saved_out;
                            _jettag_c_when_286_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_288_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_288_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_288_5.setRuntimeParent(_jettag_c_choose_275_4);
                            _jettag_c_when_288_5.setTagInfo(_td_c_when_288_5);
                            _jettag_c_when_288_5.doStart(context, out);
                            JET2Writer _jettag_c_when_288_5_saved_out = out;
                            while (_jettag_c_when_288_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 288, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 288, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_288_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_288_5_saved_out;
                            _jettag_c_when_288_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_290_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_290_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_290_5.setRuntimeParent(_jettag_c_choose_275_4);
                            _jettag_c_when_290_5.setTagInfo(_td_c_when_290_5);
                            _jettag_c_when_290_5.doStart(context, out);
                            JET2Writer _jettag_c_when_290_5_saved_out = out;
                            while (_jettag_c_when_290_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 290, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 290, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_290_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_290_5_saved_out;
                            _jettag_c_when_290_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_292_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_292_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_292_5.setRuntimeParent(_jettag_c_choose_275_4);
                            _jettag_c_when_292_5.setTagInfo(_td_c_when_292_5);
                            _jettag_c_when_292_5.doStart(context, out);
                            JET2Writer _jettag_c_when_292_5_saved_out = out;
                            while (_jettag_c_when_292_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" proxy.set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 292, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 292, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_292_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_292_5_saved_out;
                            _jettag_c_when_292_5.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_294_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_294_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_294_6.setRuntimeParent(_jettag_c_choose_275_4);
                            _jettag_c_otherwise_294_6.setTagInfo(_td_c_otherwise_294_6);
                            _jettag_c_otherwise_294_6.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_294_6_saved_out = out;
                            while (_jettag_c_otherwise_294_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_295_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_295_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_295_8.setRuntimeParent(_jettag_c_otherwise_294_6);
                                _jettag_c_iterate_295_8.setTagInfo(_td_c_iterate_295_8);
                                _jettag_c_iterate_295_8.doStart(context, out);
                                while (_jettag_c_iterate_295_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_296_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_296_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_296_10.setRuntimeParent(_jettag_c_iterate_295_8);
                                    _jettag_c_if_296_10.setTagInfo(_td_c_if_296_10);
                                    _jettag_c_if_296_10.doStart(context, out);
                                    while (_jettag_c_if_296_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tproxy.set");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 297, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("(");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 297, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".valueOf(getEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 297, 116)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\")));");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_296_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_296_10.doEnd();
                                    _jettag_c_iterate_295_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_295_8.doEnd();
                                _jettag_c_otherwise_294_6.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_294_6_saved_out;
                            _jettag_c_otherwise_294_6.doEnd();
                            _jettag_c_choose_275_4.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_275_4_saved_out;
                        _jettag_c_choose_275_4.doEnd();
                        _jettag_c_iterate_274_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_274_2.doEnd();
                    _jettag_c_if_273_2.handleBodyContent(out);
                }
                _jettag_c_if_273_2.doEnd();
                // process base class attributes
                RuntimeTagElement _jettag_c_iterate_305_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_305_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_305_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_305_2.setTagInfo(_td_c_iterate_305_2);
                _jettag_c_iterate_305_2.doStart(context, out);
                while (_jettag_c_iterate_305_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_306_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_306_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_306_4.setRuntimeParent(_jettag_c_iterate_305_2);
                    _jettag_c_choose_306_4.setTagInfo(_td_c_choose_306_4);
                    _jettag_c_choose_306_4.doStart(context, out);
                    JET2Writer _jettag_c_choose_306_4_saved_out = out;
                    while (_jettag_c_choose_306_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_307_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_307_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_307_5.setRuntimeParent(_jettag_c_choose_306_4);
                        _jettag_c_when_307_5.setTagInfo(_td_c_when_307_5);
                        _jettag_c_when_307_5.doStart(context, out);
                        JET2Writer _jettag_c_when_307_5_saved_out = out;
                        while (_jettag_c_when_307_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 307, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getStringField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 307, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_307_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_307_5_saved_out;
                        _jettag_c_when_307_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_309_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_309_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_309_5.setRuntimeParent(_jettag_c_choose_306_4);
                        _jettag_c_when_309_5.setTagInfo(_td_c_when_309_5);
                        _jettag_c_when_309_5.doStart(context, out);
                        JET2Writer _jettag_c_when_309_5_saved_out = out;
                        while (_jettag_c_when_309_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 309, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 309, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_309_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_309_5_saved_out;
                        _jettag_c_when_309_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_311_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_311_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_311_5.setRuntimeParent(_jettag_c_choose_306_4);
                        _jettag_c_when_311_5.setTagInfo(_td_c_when_311_5);
                        _jettag_c_when_311_5.doStart(context, out);
                        JET2Writer _jettag_c_when_311_5_saved_out = out;
                        while (_jettag_c_when_311_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 311, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getDateField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 311, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_311_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_311_5_saved_out;
                        _jettag_c_when_311_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_313_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_313_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_313_5.setRuntimeParent(_jettag_c_choose_306_4);
                        _jettag_c_when_313_5.setTagInfo(_td_c_when_313_5);
                        _jettag_c_when_313_5.doStart(context, out);
                        JET2Writer _jettag_c_when_313_5_saved_out = out;
                        while (_jettag_c_when_313_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 313, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 313, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_313_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_313_5_saved_out;
                        _jettag_c_when_313_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_315_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_315_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_315_5.setRuntimeParent(_jettag_c_choose_306_4);
                        _jettag_c_when_315_5.setTagInfo(_td_c_when_315_5);
                        _jettag_c_when_315_5.doStart(context, out);
                        JET2Writer _jettag_c_when_315_5_saved_out = out;
                        while (_jettag_c_when_315_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 315, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getLongField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 315, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_315_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_315_5_saved_out;
                        _jettag_c_when_315_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_317_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_317_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_317_5.setRuntimeParent(_jettag_c_choose_306_4);
                        _jettag_c_when_317_5.setTagInfo(_td_c_when_317_5);
                        _jettag_c_when_317_5.doStart(context, out);
                        JET2Writer _jettag_c_when_317_5_saved_out = out;
                        while (_jettag_c_when_317_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 317, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getFloatField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 317, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_317_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_317_5_saved_out;
                        _jettag_c_when_317_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_319_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_319_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_319_5.setRuntimeParent(_jettag_c_choose_306_4);
                        _jettag_c_when_319_5.setTagInfo(_td_c_when_319_5);
                        _jettag_c_when_319_5.doStart(context, out);
                        JET2Writer _jettag_c_when_319_5_saved_out = out;
                        while (_jettag_c_when_319_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 319, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getImageField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 319, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_319_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_319_5_saved_out;
                        _jettag_c_when_319_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_321_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_321_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_321_5.setRuntimeParent(_jettag_c_choose_306_4);
                        _jettag_c_when_321_5.setTagInfo(_td_c_when_321_5);
                        _jettag_c_when_321_5.doStart(context, out);
                        JET2Writer _jettag_c_when_321_5_saved_out = out;
                        while (_jettag_c_when_321_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 321, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getRichTextField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 321, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_321_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_321_5_saved_out;
                        _jettag_c_when_321_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_323_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_323_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_323_5.setRuntimeParent(_jettag_c_choose_306_4);
                        _jettag_c_when_323_5.setTagInfo(_td_c_when_323_5);
                        _jettag_c_when_323_5.doStart(context, out);
                        JET2Writer _jettag_c_when_323_5_saved_out = out;
                        while (_jettag_c_when_323_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" proxy.set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 323, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 323, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_323_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_323_5_saved_out;
                        _jettag_c_when_323_5.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_325_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_325_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_325_6.setRuntimeParent(_jettag_c_choose_306_4);
                        _jettag_c_otherwise_325_6.setTagInfo(_td_c_otherwise_325_6);
                        _jettag_c_otherwise_325_6.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_325_6_saved_out = out;
                        while (_jettag_c_otherwise_325_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_326_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_326_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_326_8.setRuntimeParent(_jettag_c_otherwise_325_6);
                            _jettag_c_iterate_326_8.setTagInfo(_td_c_iterate_326_8);
                            _jettag_c_iterate_326_8.doStart(context, out);
                            while (_jettag_c_iterate_326_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_327_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_327_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_327_10.setRuntimeParent(_jettag_c_iterate_326_8);
                                _jettag_c_if_327_10.setTagInfo(_td_c_if_327_10);
                                _jettag_c_if_327_10.doStart(context, out);
                                while (_jettag_c_if_327_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\tproxy.set");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 328, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("(");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 328, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".valueOf(getEnumField(\"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 328, 116)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\")));");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_327_10.handleBodyContent(out);
                                }
                                _jettag_c_if_327_10.doEnd();
                                _jettag_c_iterate_326_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_326_8.doEnd();
                            _jettag_c_otherwise_325_6.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_325_6_saved_out;
                        _jettag_c_otherwise_325_6.doEnd();
                        _jettag_c_choose_306_4.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_306_4_saved_out;
                    _jettag_c_choose_306_4.doEnd();
                    _jettag_c_iterate_305_2.handleBodyContent(out);
                }
                _jettag_c_iterate_305_2.doEnd();
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process dropdowns one tone and many to one 
                RuntimeTagElement _jettag_c_iterate_336_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_336_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_336_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_336_4.setTagInfo(_td_c_iterate_336_4);
                _jettag_c_iterate_336_4.doStart(context, out);
                while (_jettag_c_iterate_336_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_337_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_337_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_337_5.setRuntimeParent(_jettag_c_iterate_336_4);
                    _jettag_c_iterate_337_5.setTagInfo(_td_c_iterate_337_5);
                    _jettag_c_iterate_337_5.doStart(context, out);
                    while (_jettag_c_iterate_337_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_338_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_338_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_338_6.setRuntimeParent(_jettag_c_iterate_337_5);
                        _jettag_c_iterate_338_6.setTagInfo(_td_c_iterate_338_6);
                        _jettag_c_iterate_338_6.doStart(context, out);
                        while (_jettag_c_iterate_338_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_339_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_339_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_339_7.setRuntimeParent(_jettag_c_iterate_338_6);
                            _jettag_c_setVariable_339_7.setTagInfo(_td_c_setVariable_339_7);
                            _jettag_c_setVariable_339_7.doStart(context, out);
                            _jettag_c_setVariable_339_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_341_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_341_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_341_9.setRuntimeParent(_jettag_c_iterate_338_6);
                            _jettag_c_if_341_9.setTagInfo(_td_c_if_341_9);
                            _jettag_c_if_341_9.doStart(context, out);
                            while (_jettag_c_if_341_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_343_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_343_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_343_15.setRuntimeParent(_jettag_c_if_341_9);
                                _jettag_c_iterate_343_15.setTagInfo(_td_c_iterate_343_15);
                                _jettag_c_iterate_343_15.doStart(context, out);
                                while (_jettag_c_iterate_343_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_344_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_344_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_344_15.setRuntimeParent(_jettag_c_iterate_343_15);
                                    _jettag_c_setVariable_344_15.setTagInfo(_td_c_setVariable_344_15);
                                    _jettag_c_setVariable_344_15.doStart(context, out);
                                    _jettag_c_setVariable_344_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_346_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_346_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_346_17.setRuntimeParent(_jettag_c_iterate_343_15);
                                    _jettag_c_if_346_17.setTagInfo(_td_c_if_346_17);
                                    _jettag_c_if_346_17.doStart(context, out);
                                    while (_jettag_c_if_346_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_348_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_348_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_348_18.setRuntimeParent(_jettag_c_if_346_17);
                                        _jettag_c_iterate_348_18.setTagInfo(_td_c_iterate_348_18);
                                        _jettag_c_iterate_348_18.doStart(context, out);
                                        while (_jettag_c_iterate_348_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_349_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_349_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_349_19.setRuntimeParent(_jettag_c_iterate_348_18);
                                            _jettag_c_if_349_19.setTagInfo(_td_c_if_349_19);
                                            _jettag_c_if_349_19.doStart(context, out);
                                            while (_jettag_c_if_349_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_352_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_352_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_352_19.setRuntimeParent(_jettag_c_if_349_19);
                                                _jettag_c_if_352_19.setTagInfo(_td_c_if_352_19);
                                                _jettag_c_if_352_19.doStart(context, out);
                                                while (_jettag_c_if_352_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_353_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_353_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_353_21.setRuntimeParent(_jettag_c_if_352_19);
                                                    _jettag_c_if_353_21.setTagInfo(_td_c_if_353_21);
                                                    _jettag_c_if_353_21.doStart(context, out);
                                                    while (_jettag_c_if_353_21.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_355_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_355_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_355_18.setRuntimeParent(_jettag_c_if_353_21);
                                                        _jettag_c_if_355_18.setTagInfo(_td_c_if_355_18);
                                                        _jettag_c_if_355_18.doStart(context, out);
                                                        while (_jettag_c_if_355_18.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\tproxy.set");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($class2/@name)}", 356, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("(select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 356, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel.getProxy());");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_355_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_355_18.doEnd();
                                                        _jettag_c_if_353_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_353_21.doEnd();
                                                    _jettag_c_if_352_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_352_19.doEnd();
                                                _jettag_c_if_349_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_349_19.doEnd();
                                            _jettag_c_iterate_348_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_348_18.doEnd();
                                        _jettag_c_if_346_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_346_17.doEnd();
                                    _jettag_c_iterate_343_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_343_15.doEnd();
                                _jettag_c_if_341_9.handleBodyContent(out);
                            }
                            _jettag_c_if_341_9.doEnd();
                            _jettag_c_iterate_338_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_338_6.doEnd();
                        _jettag_c_iterate_337_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_337_5.doEnd();
                    _jettag_c_iterate_336_4.handleBodyContent(out);
                }
                _jettag_c_iterate_336_4.doEnd();
                out.write("\t\treturn proxy;\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_371_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_371_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_371_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_371_2.setTagInfo(_td_f_message_371_2);
                _jettag_f_message_371_2.doStart(context, out);
                JET2Writer _jettag_f_message_371_2_saved_out = out;
                while (_jettag_f_message_371_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_371_2.handleBodyContent(out);
                }
                out = _jettag_f_message_371_2_saved_out;
                _jettag_f_message_371_2.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void successfullyUpdated() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tAutomanageWelcome.instance().getEntityPanel().clear();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tAutomanageWelcome.instance().getEntityPanel()");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t.add(new ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 376, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanely(ReadAllTableType.READALL));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_380_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_380_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_380_1.setRuntimeParent(_jettag_f_bundle_3_1);
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
                RuntimeTagElement _jettag_f_message_386_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_386_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_386_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_386_1.setTagInfo(_td_f_message_386_1);
                _jettag_f_message_386_1.doStart(context, out);
                JET2Writer _jettag_f_message_386_1_saved_out = out;
                while (_jettag_f_message_386_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_386_1.handleBodyContent(out);
                }
                out = _jettag_f_message_386_1_saved_out;
                _jettag_f_message_386_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_392_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_392_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_392_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_392_1.setTagInfo(_td_f_message_392_1);
                _jettag_f_message_392_1.doStart(context, out);
                JET2Writer _jettag_f_message_392_1_saved_out = out;
                while (_jettag_f_message_392_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_392_1.handleBodyContent(out);
                }
                out = _jettag_f_message_392_1_saved_out;
                _jettag_f_message_392_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void addWidgets() {");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_396_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_396_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_396_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_396_2.setTagInfo(_td_c_if_396_2);
                _jettag_c_if_396_2.doStart(context, out);
                while (_jettag_c_if_396_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_397_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_397_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_397_5.setRuntimeParent(_jettag_c_if_396_2);
                    _jettag_c_iterate_397_5.setTagInfo(_td_c_iterate_397_5);
                    _jettag_c_iterate_397_5.doStart(context, out);
                    while (_jettag_c_iterate_397_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_398_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_398_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_398_5.setRuntimeParent(_jettag_c_iterate_397_5);
                        _jettag_c_choose_398_5.setTagInfo(_td_c_choose_398_5);
                        _jettag_c_choose_398_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_398_5_saved_out = out;
                        while (_jettag_c_choose_398_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_399_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_399_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_399_6.setRuntimeParent(_jettag_c_choose_398_5);
                            _jettag_c_when_399_6.setTagInfo(_td_c_when_399_6);
                            _jettag_c_when_399_6.doStart(context, out);
                            JET2Writer _jettag_c_when_399_6_saved_out = out;
                            while (_jettag_c_when_399_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 399, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 399, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_399_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_399_6_saved_out;
                            _jettag_c_when_399_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_401_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_401_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_401_6.setRuntimeParent(_jettag_c_choose_398_5);
                            _jettag_c_when_401_6.setTagInfo(_td_c_when_401_6);
                            _jettag_c_when_401_6.doStart(context, out);
                            JET2Writer _jettag_c_when_401_6_saved_out = out;
                            while (_jettag_c_when_401_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 401, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 401, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_401_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_401_6_saved_out;
                            _jettag_c_when_401_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_403_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_403_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_403_6.setRuntimeParent(_jettag_c_choose_398_5);
                            _jettag_c_when_403_6.setTagInfo(_td_c_when_403_6);
                            _jettag_c_when_403_6.doStart(context, out);
                            JET2Writer _jettag_c_when_403_6_saved_out = out;
                            while (_jettag_c_when_403_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 403, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 403, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_403_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_403_6_saved_out;
                            _jettag_c_when_403_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_405_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_405_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_405_6.setRuntimeParent(_jettag_c_choose_398_5);
                            _jettag_c_when_405_6.setTagInfo(_td_c_when_405_6);
                            _jettag_c_when_405_6.doStart(context, out);
                            JET2Writer _jettag_c_when_405_6_saved_out = out;
                            while (_jettag_c_when_405_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 405, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 405, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_405_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_405_6_saved_out;
                            _jettag_c_when_405_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_407_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_407_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_407_6.setRuntimeParent(_jettag_c_choose_398_5);
                            _jettag_c_when_407_6.setTagInfo(_td_c_when_407_6);
                            _jettag_c_when_407_6.doStart(context, out);
                            JET2Writer _jettag_c_when_407_6_saved_out = out;
                            while (_jettag_c_when_407_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 407, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 407, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_407_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_407_6_saved_out;
                            _jettag_c_when_407_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_409_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_409_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_409_6.setRuntimeParent(_jettag_c_choose_398_5);
                            _jettag_c_when_409_6.setTagInfo(_td_c_when_409_6);
                            _jettag_c_when_409_6.doStart(context, out);
                            JET2Writer _jettag_c_when_409_6_saved_out = out;
                            while (_jettag_c_when_409_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 409, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 409, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_409_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_409_6_saved_out;
                            _jettag_c_when_409_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_411_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_411_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_411_6.setRuntimeParent(_jettag_c_choose_398_5);
                            _jettag_c_when_411_6.setTagInfo(_td_c_when_411_6);
                            _jettag_c_when_411_6.doStart(context, out);
                            JET2Writer _jettag_c_when_411_6_saved_out = out;
                            while (_jettag_c_when_411_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 411, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 411, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_411_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_411_6_saved_out;
                            _jettag_c_when_411_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_413_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_413_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_413_6.setRuntimeParent(_jettag_c_choose_398_5);
                            _jettag_c_when_413_6.setTagInfo(_td_c_when_413_6);
                            _jettag_c_when_413_6.doStart(context, out);
                            JET2Writer _jettag_c_when_413_6_saved_out = out;
                            while (_jettag_c_when_413_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 413, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 413, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_413_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_413_6_saved_out;
                            _jettag_c_when_413_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_415_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_415_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_415_6.setRuntimeParent(_jettag_c_choose_398_5);
                            _jettag_c_when_415_6.setTagInfo(_td_c_when_415_6);
                            _jettag_c_when_415_6.doStart(context, out);
                            JET2Writer _jettag_c_when_415_6_saved_out = out;
                            while (_jettag_c_when_415_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 415, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 415, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_415_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_415_6_saved_out;
                            _jettag_c_when_415_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_417_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_417_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_417_7.setRuntimeParent(_jettag_c_choose_398_5);
                            _jettag_c_otherwise_417_7.setTagInfo(_td_c_otherwise_417_7);
                            _jettag_c_otherwise_417_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_417_7_saved_out = out;
                            while (_jettag_c_otherwise_417_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_418_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_418_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_418_8.setRuntimeParent(_jettag_c_otherwise_417_7);
                                _jettag_c_iterate_418_8.setTagInfo(_td_c_iterate_418_8);
                                _jettag_c_iterate_418_8.doStart(context, out);
                                while (_jettag_c_iterate_418_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_419_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_419_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_419_10.setRuntimeParent(_jettag_c_iterate_418_8);
                                    _jettag_c_if_419_10.setTagInfo(_td_c_if_419_10);
                                    _jettag_c_if_419_10.doStart(context, out);
                                    while (_jettag_c_if_419_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 420, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", false, ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 420, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(", \"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 420, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 420, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".class.getName());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_419_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_419_10.doEnd();
                                    _jettag_c_iterate_418_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_418_8.doEnd();
                                _jettag_c_otherwise_417_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_417_7_saved_out;
                            _jettag_c_otherwise_417_7.doEnd();
                            _jettag_c_choose_398_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_398_5_saved_out;
                        _jettag_c_choose_398_5.doEnd();
                        _jettag_c_iterate_397_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_397_5.doEnd();
                    _jettag_c_if_396_2.handleBodyContent(out);
                }
                _jettag_c_if_396_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_428_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_428_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_428_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_428_2.setTagInfo(_td_c_if_428_2);
                _jettag_c_if_428_2.doStart(context, out);
                while (_jettag_c_if_428_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_429_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_429_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_429_5.setRuntimeParent(_jettag_c_if_428_2);
                    _jettag_c_iterate_429_5.setTagInfo(_td_c_iterate_429_5);
                    _jettag_c_iterate_429_5.doStart(context, out);
                    while (_jettag_c_iterate_429_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_430_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_430_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_430_5.setRuntimeParent(_jettag_c_iterate_429_5);
                        _jettag_c_choose_430_5.setTagInfo(_td_c_choose_430_5);
                        _jettag_c_choose_430_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_430_5_saved_out = out;
                        while (_jettag_c_choose_430_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_431_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_431_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_431_6.setRuntimeParent(_jettag_c_choose_430_5);
                            _jettag_c_when_431_6.setTagInfo(_td_c_when_431_6);
                            _jettag_c_when_431_6.doStart(context, out);
                            JET2Writer _jettag_c_when_431_6_saved_out = out;
                            while (_jettag_c_when_431_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 431, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 431, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_431_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_431_6_saved_out;
                            _jettag_c_when_431_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_433_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_433_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_433_6.setRuntimeParent(_jettag_c_choose_430_5);
                            _jettag_c_when_433_6.setTagInfo(_td_c_when_433_6);
                            _jettag_c_when_433_6.doStart(context, out);
                            JET2Writer _jettag_c_when_433_6_saved_out = out;
                            while (_jettag_c_when_433_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 433, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 433, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_433_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_433_6_saved_out;
                            _jettag_c_when_433_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_435_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_435_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_435_6.setRuntimeParent(_jettag_c_choose_430_5);
                            _jettag_c_when_435_6.setTagInfo(_td_c_when_435_6);
                            _jettag_c_when_435_6.doStart(context, out);
                            JET2Writer _jettag_c_when_435_6_saved_out = out;
                            while (_jettag_c_when_435_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 435, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 435, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_435_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_435_6_saved_out;
                            _jettag_c_when_435_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_437_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_437_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_437_6.setRuntimeParent(_jettag_c_choose_430_5);
                            _jettag_c_when_437_6.setTagInfo(_td_c_when_437_6);
                            _jettag_c_when_437_6.doStart(context, out);
                            JET2Writer _jettag_c_when_437_6_saved_out = out;
                            while (_jettag_c_when_437_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 437, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 437, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_437_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_437_6_saved_out;
                            _jettag_c_when_437_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_439_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_439_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_439_6.setRuntimeParent(_jettag_c_choose_430_5);
                            _jettag_c_when_439_6.setTagInfo(_td_c_when_439_6);
                            _jettag_c_when_439_6.doStart(context, out);
                            JET2Writer _jettag_c_when_439_6_saved_out = out;
                            while (_jettag_c_when_439_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 439, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 439, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_439_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_439_6_saved_out;
                            _jettag_c_when_439_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_441_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_441_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_441_6.setRuntimeParent(_jettag_c_choose_430_5);
                            _jettag_c_when_441_6.setTagInfo(_td_c_when_441_6);
                            _jettag_c_when_441_6.doStart(context, out);
                            JET2Writer _jettag_c_when_441_6_saved_out = out;
                            while (_jettag_c_when_441_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 441, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 441, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_441_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_441_6_saved_out;
                            _jettag_c_when_441_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_443_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_443_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_443_6.setRuntimeParent(_jettag_c_choose_430_5);
                            _jettag_c_when_443_6.setTagInfo(_td_c_when_443_6);
                            _jettag_c_when_443_6.doStart(context, out);
                            JET2Writer _jettag_c_when_443_6_saved_out = out;
                            while (_jettag_c_when_443_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 443, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 443, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_443_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_443_6_saved_out;
                            _jettag_c_when_443_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_445_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_445_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_445_6.setRuntimeParent(_jettag_c_choose_430_5);
                            _jettag_c_when_445_6.setTagInfo(_td_c_when_445_6);
                            _jettag_c_when_445_6.doStart(context, out);
                            JET2Writer _jettag_c_when_445_6_saved_out = out;
                            while (_jettag_c_when_445_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 445, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 445, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_445_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_445_6_saved_out;
                            _jettag_c_when_445_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_447_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_447_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_447_6.setRuntimeParent(_jettag_c_choose_430_5);
                            _jettag_c_when_447_6.setTagInfo(_td_c_when_447_6);
                            _jettag_c_when_447_6.doStart(context, out);
                            JET2Writer _jettag_c_when_447_6_saved_out = out;
                            while (_jettag_c_when_447_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 447, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 447, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_447_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_447_6_saved_out;
                            _jettag_c_when_447_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_449_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_449_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_449_7.setRuntimeParent(_jettag_c_choose_430_5);
                            _jettag_c_otherwise_449_7.setTagInfo(_td_c_otherwise_449_7);
                            _jettag_c_otherwise_449_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_449_7_saved_out = out;
                            while (_jettag_c_otherwise_449_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_450_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_450_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_450_8.setRuntimeParent(_jettag_c_otherwise_449_7);
                                _jettag_c_iterate_450_8.setTagInfo(_td_c_iterate_450_8);
                                _jettag_c_iterate_450_8.doStart(context, out);
                                while (_jettag_c_iterate_450_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_451_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_451_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_451_10.setRuntimeParent(_jettag_c_iterate_450_8);
                                    _jettag_c_if_451_10.setTagInfo(_td_c_if_451_10);
                                    _jettag_c_if_451_10.doStart(context, out);
                                    while (_jettag_c_if_451_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 452, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", false, ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 452, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(", \"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 452, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 452, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".class.getName());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_451_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_451_10.doEnd();
                                    _jettag_c_iterate_450_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_450_8.doEnd();
                                _jettag_c_otherwise_449_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_449_7_saved_out;
                            _jettag_c_otherwise_449_7.doEnd();
                            _jettag_c_choose_430_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_430_5_saved_out;
                        _jettag_c_choose_430_5.doEnd();
                        _jettag_c_iterate_429_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_429_5.doEnd();
                    _jettag_c_if_428_2.handleBodyContent(out);
                }
                _jettag_c_if_428_2.doEnd();
                // process base class attributes 
                RuntimeTagElement _jettag_c_iterate_460_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_460_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_460_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_460_4.setTagInfo(_td_c_iterate_460_4);
                _jettag_c_iterate_460_4.doStart(context, out);
                while (_jettag_c_iterate_460_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_461_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_461_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_461_5.setRuntimeParent(_jettag_c_iterate_460_4);
                    _jettag_c_choose_461_5.setTagInfo(_td_c_choose_461_5);
                    _jettag_c_choose_461_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_461_5_saved_out = out;
                    while (_jettag_c_choose_461_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_462_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_462_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_462_6.setRuntimeParent(_jettag_c_choose_461_5);
                        _jettag_c_when_462_6.setTagInfo(_td_c_when_462_6);
                        _jettag_c_when_462_6.doStart(context, out);
                        JET2Writer _jettag_c_when_462_6_saved_out = out;
                        while (_jettag_c_when_462_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 462, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 462, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_462_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_462_6_saved_out;
                        _jettag_c_when_462_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_464_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_464_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_464_6.setRuntimeParent(_jettag_c_choose_461_5);
                        _jettag_c_when_464_6.setTagInfo(_td_c_when_464_6);
                        _jettag_c_when_464_6.doStart(context, out);
                        JET2Writer _jettag_c_when_464_6_saved_out = out;
                        while (_jettag_c_when_464_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 464, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 464, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_464_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_464_6_saved_out;
                        _jettag_c_when_464_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_466_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_466_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_466_6.setRuntimeParent(_jettag_c_choose_461_5);
                        _jettag_c_when_466_6.setTagInfo(_td_c_when_466_6);
                        _jettag_c_when_466_6.doStart(context, out);
                        JET2Writer _jettag_c_when_466_6_saved_out = out;
                        while (_jettag_c_when_466_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 466, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 466, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_466_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_466_6_saved_out;
                        _jettag_c_when_466_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_468_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_468_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_468_6.setRuntimeParent(_jettag_c_choose_461_5);
                        _jettag_c_when_468_6.setTagInfo(_td_c_when_468_6);
                        _jettag_c_when_468_6.doStart(context, out);
                        JET2Writer _jettag_c_when_468_6_saved_out = out;
                        while (_jettag_c_when_468_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 468, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 468, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_468_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_468_6_saved_out;
                        _jettag_c_when_468_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_470_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_470_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_470_6.setRuntimeParent(_jettag_c_choose_461_5);
                        _jettag_c_when_470_6.setTagInfo(_td_c_when_470_6);
                        _jettag_c_when_470_6.doStart(context, out);
                        JET2Writer _jettag_c_when_470_6_saved_out = out;
                        while (_jettag_c_when_470_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 470, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 470, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_470_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_470_6_saved_out;
                        _jettag_c_when_470_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_472_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_472_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_472_6.setRuntimeParent(_jettag_c_choose_461_5);
                        _jettag_c_when_472_6.setTagInfo(_td_c_when_472_6);
                        _jettag_c_when_472_6.doStart(context, out);
                        JET2Writer _jettag_c_when_472_6_saved_out = out;
                        while (_jettag_c_when_472_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 472, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 472, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_472_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_472_6_saved_out;
                        _jettag_c_when_472_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_474_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_474_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_474_6.setRuntimeParent(_jettag_c_choose_461_5);
                        _jettag_c_when_474_6.setTagInfo(_td_c_when_474_6);
                        _jettag_c_when_474_6.doStart(context, out);
                        JET2Writer _jettag_c_when_474_6_saved_out = out;
                        while (_jettag_c_when_474_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 474, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 474, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_474_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_474_6_saved_out;
                        _jettag_c_when_474_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_476_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_476_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_476_6.setRuntimeParent(_jettag_c_choose_461_5);
                        _jettag_c_when_476_6.setTagInfo(_td_c_when_476_6);
                        _jettag_c_when_476_6.doStart(context, out);
                        JET2Writer _jettag_c_when_476_6_saved_out = out;
                        while (_jettag_c_when_476_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 476, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 476, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_476_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_476_6_saved_out;
                        _jettag_c_when_476_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_478_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_478_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_478_6.setRuntimeParent(_jettag_c_choose_461_5);
                        _jettag_c_when_478_6.setTagInfo(_td_c_when_478_6);
                        _jettag_c_when_478_6.doStart(context, out);
                        JET2Writer _jettag_c_when_478_6_saved_out = out;
                        while (_jettag_c_when_478_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 478, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 478, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_478_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_478_6_saved_out;
                        _jettag_c_when_478_6.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_480_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_480_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_480_7.setRuntimeParent(_jettag_c_choose_461_5);
                        _jettag_c_otherwise_480_7.setTagInfo(_td_c_otherwise_480_7);
                        _jettag_c_otherwise_480_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_480_7_saved_out = out;
                        while (_jettag_c_otherwise_480_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_481_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_481_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_481_8.setRuntimeParent(_jettag_c_otherwise_480_7);
                            _jettag_c_iterate_481_8.setTagInfo(_td_c_iterate_481_8);
                            _jettag_c_iterate_481_8.doStart(context, out);
                            while (_jettag_c_iterate_481_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_482_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_482_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_482_10.setRuntimeParent(_jettag_c_iterate_481_8);
                                _jettag_c_if_482_10.setTagInfo(_td_c_if_482_10);
                                _jettag_c_if_482_10.doStart(context, out);
                                while (_jettag_c_if_482_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 483, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", false, ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 483, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(", \"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 483, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 483, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".class.getName());");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_482_10.handleBodyContent(out);
                                }
                                _jettag_c_if_482_10.doEnd();
                                _jettag_c_iterate_481_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_481_8.doEnd();
                            _jettag_c_otherwise_480_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_480_7_saved_out;
                        _jettag_c_otherwise_480_7.doEnd();
                        _jettag_c_choose_461_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_461_5_saved_out;
                    _jettag_c_choose_461_5.doEnd();
                    _jettag_c_iterate_460_4.handleBodyContent(out);
                }
                _jettag_c_iterate_460_4.doEnd();
                // process dropdowns one to one and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_490_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_490_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_490_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_490_4.setTagInfo(_td_c_iterate_490_4);
                _jettag_c_iterate_490_4.doStart(context, out);
                while (_jettag_c_iterate_490_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_491_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_491_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_491_5.setRuntimeParent(_jettag_c_iterate_490_4);
                    _jettag_c_iterate_491_5.setTagInfo(_td_c_iterate_491_5);
                    _jettag_c_iterate_491_5.doStart(context, out);
                    while (_jettag_c_iterate_491_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_492_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_492_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_492_6.setRuntimeParent(_jettag_c_iterate_491_5);
                        _jettag_c_iterate_492_6.setTagInfo(_td_c_iterate_492_6);
                        _jettag_c_iterate_492_6.doStart(context, out);
                        while (_jettag_c_iterate_492_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_493_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_493_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_493_7.setRuntimeParent(_jettag_c_iterate_492_6);
                            _jettag_c_setVariable_493_7.setTagInfo(_td_c_setVariable_493_7);
                            _jettag_c_setVariable_493_7.doStart(context, out);
                            _jettag_c_setVariable_493_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_495_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_495_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_495_9.setRuntimeParent(_jettag_c_iterate_492_6);
                            _jettag_c_if_495_9.setTagInfo(_td_c_if_495_9);
                            _jettag_c_if_495_9.doStart(context, out);
                            while (_jettag_c_if_495_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_497_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_497_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_497_15.setRuntimeParent(_jettag_c_if_495_9);
                                _jettag_c_iterate_497_15.setTagInfo(_td_c_iterate_497_15);
                                _jettag_c_iterate_497_15.doStart(context, out);
                                while (_jettag_c_iterate_497_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_498_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_498_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_498_15.setRuntimeParent(_jettag_c_iterate_497_15);
                                    _jettag_c_setVariable_498_15.setTagInfo(_td_c_setVariable_498_15);
                                    _jettag_c_setVariable_498_15.doStart(context, out);
                                    _jettag_c_setVariable_498_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_500_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_500_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_500_17.setRuntimeParent(_jettag_c_iterate_497_15);
                                    _jettag_c_if_500_17.setTagInfo(_td_c_if_500_17);
                                    _jettag_c_if_500_17.doStart(context, out);
                                    while (_jettag_c_if_500_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_502_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_502_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_502_18.setRuntimeParent(_jettag_c_if_500_17);
                                        _jettag_c_iterate_502_18.setTagInfo(_td_c_iterate_502_18);
                                        _jettag_c_iterate_502_18.doStart(context, out);
                                        while (_jettag_c_iterate_502_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_503_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_503_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_503_19.setRuntimeParent(_jettag_c_iterate_502_18);
                                            _jettag_c_if_503_19.setTagInfo(_td_c_if_503_19);
                                            _jettag_c_if_503_19.doStart(context, out);
                                            while (_jettag_c_if_503_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_506_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_506_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_506_19.setRuntimeParent(_jettag_c_if_503_19);
                                                _jettag_c_if_506_19.setTagInfo(_td_c_if_506_19);
                                                _jettag_c_if_506_19.doStart(context, out);
                                                while (_jettag_c_if_506_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_507_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_507_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_507_21.setRuntimeParent(_jettag_c_if_506_19);
                                                    _jettag_c_if_507_21.setTagInfo(_td_c_if_507_21);
                                                    _jettag_c_if_507_21.doStart(context, out);
                                                    while (_jettag_c_if_507_21.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_509_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_509_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_509_18.setRuntimeParent(_jettag_c_if_507_21);
                                                        _jettag_c_if_509_18.setTagInfo(_td_c_if_509_18);
                                                        _jettag_c_if_509_18.doStart(context, out);
                                                        while (_jettag_c_if_509_18.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\taddDropDown(select");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 510, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Panel);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_509_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_509_18.doEnd();
                                                        _jettag_c_if_507_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_507_21.doEnd();
                                                    _jettag_c_if_506_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_506_19.doEnd();
                                                _jettag_c_if_503_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_503_19.doEnd();
                                            _jettag_c_iterate_502_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_502_18.doEnd();
                                        _jettag_c_if_500_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_500_17.doEnd();
                                    _jettag_c_iterate_497_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_497_15.doEnd();
                                _jettag_c_if_495_9.handleBodyContent(out);
                            }
                            _jettag_c_if_495_9.doEnd();
                            _jettag_c_iterate_492_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_492_6.doEnd();
                        _jettag_c_iterate_491_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_491_5.doEnd();
                    _jettag_c_iterate_490_4.handleBodyContent(out);
                }
                _jettag_c_iterate_490_4.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_523_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_523_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_523_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_523_1.setTagInfo(_td_f_message_523_1);
                _jettag_f_message_523_1.doStart(context, out);
                JET2Writer _jettag_f_message_523_1_saved_out = out;
                while (_jettag_f_message_523_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_523_1.handleBodyContent(out);
                }
                out = _jettag_f_message_523_1_saved_out;
                _jettag_f_message_523_1.doEnd();
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
