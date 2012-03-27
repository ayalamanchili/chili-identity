package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_read_panelyjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_read_panelyjava() {
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
    private static final TagInfo _td_c_setVariable_6_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            6, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_14_1 = new TagInfo("f:message", //$NON-NLS-1$
            14, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_16_1 = new TagInfo("f:message", //$NON-NLS-1$
            16, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_18_1 = new TagInfo("f:message", //$NON-NLS-1$
            18, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_20_1 = new TagInfo("f:message", //$NON-NLS-1$
            20, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_24_1 = new TagInfo("f:message", //$NON-NLS-1$
            24, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_29_1 = new TagInfo("f:message", //$NON-NLS-1$
            29, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_35_1 = new TagInfo("f:message", //$NON-NLS-1$
            35, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_39_4 = new TagInfo("c:if", //$NON-NLS-1$
            39, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_40_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            40, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_41_5 = new TagInfo("c:choose", //$NON-NLS-1$
            41, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_42_6 = new TagInfo("c:when", //$NON-NLS-1$
            42, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_44_6 = new TagInfo("c:when", //$NON-NLS-1$
            44, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_46_6 = new TagInfo("c:when", //$NON-NLS-1$
            46, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_48_6 = new TagInfo("c:when", //$NON-NLS-1$
            48, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_50_6 = new TagInfo("c:when", //$NON-NLS-1$
            50, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_52_6 = new TagInfo("c:when", //$NON-NLS-1$
            52, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_54_6 = new TagInfo("c:when", //$NON-NLS-1$
            54, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_56_6 = new TagInfo("c:when", //$NON-NLS-1$
            56, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_59_6 = new TagInfo("c:when", //$NON-NLS-1$
            59, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_61_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            61, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_62_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            62, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_63_10 = new TagInfo("c:if", //$NON-NLS-1$
            63, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_72_4 = new TagInfo("c:if", //$NON-NLS-1$
            72, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_73_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            73, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_74_5 = new TagInfo("c:choose", //$NON-NLS-1$
            74, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_75_6 = new TagInfo("c:when", //$NON-NLS-1$
            75, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_77_6 = new TagInfo("c:when", //$NON-NLS-1$
            77, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_79_6 = new TagInfo("c:when", //$NON-NLS-1$
            79, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_81_6 = new TagInfo("c:when", //$NON-NLS-1$
            81, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_83_6 = new TagInfo("c:when", //$NON-NLS-1$
            83, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_85_6 = new TagInfo("c:when", //$NON-NLS-1$
            85, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_87_6 = new TagInfo("c:when", //$NON-NLS-1$
            87, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_89_6 = new TagInfo("c:when", //$NON-NLS-1$
            89, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_92_6 = new TagInfo("c:when", //$NON-NLS-1$
            92, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_94_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            94, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_95_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            95, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_96_10 = new TagInfo("c:if", //$NON-NLS-1$
            96, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_105_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            105, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_106_5 = new TagInfo("c:choose", //$NON-NLS-1$
            106, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_107_6 = new TagInfo("c:when", //$NON-NLS-1$
            107, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_109_6 = new TagInfo("c:when", //$NON-NLS-1$
            109, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_6 = new TagInfo("c:when", //$NON-NLS-1$
            111, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_113_6 = new TagInfo("c:when", //$NON-NLS-1$
            113, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_115_6 = new TagInfo("c:when", //$NON-NLS-1$
            115, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_117_6 = new TagInfo("c:when", //$NON-NLS-1$
            117, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_119_6 = new TagInfo("c:when", //$NON-NLS-1$
            119, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_121_6 = new TagInfo("c:when", //$NON-NLS-1$
            121, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_124_6 = new TagInfo("c:when", //$NON-NLS-1$
            124, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_126_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            126, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_127_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            127, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_128_10 = new TagInfo("c:if", //$NON-NLS-1$
            128, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_136_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            136, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_137_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            137, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_138_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            138, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_139_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            139, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_141_9 = new TagInfo("c:if", //$NON-NLS-1$
            141, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_143_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            143, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_144_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            144, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_146_17 = new TagInfo("c:if", //$NON-NLS-1$
            146, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_148_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            148, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_149_19 = new TagInfo("c:if", //$NON-NLS-1$
            149, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_152_19 = new TagInfo("c:if", //$NON-NLS-1$
            152, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_153_21 = new TagInfo("c:if", //$NON-NLS-1$
            153, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_155_18 = new TagInfo("c:if", //$NON-NLS-1$
            155, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_169_1 = new TagInfo("f:message", //$NON-NLS-1$
            169, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_175_1 = new TagInfo("f:message", //$NON-NLS-1$
            175, 1,
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
    private static final TagInfo _td_c_if_185_2 = new TagInfo("c:if", //$NON-NLS-1$
            185, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_186_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            186, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_187_5 = new TagInfo("c:choose", //$NON-NLS-1$
            187, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_188_6 = new TagInfo("c:when", //$NON-NLS-1$
            188, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_190_6 = new TagInfo("c:when", //$NON-NLS-1$
            190, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_192_6 = new TagInfo("c:when", //$NON-NLS-1$
            192, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_194_6 = new TagInfo("c:when", //$NON-NLS-1$
            194, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_196_6 = new TagInfo("c:when", //$NON-NLS-1$
            196, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_198_6 = new TagInfo("c:when", //$NON-NLS-1$
            198, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_200_6 = new TagInfo("c:when", //$NON-NLS-1$
            200, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_202_6 = new TagInfo("c:when", //$NON-NLS-1$
            202, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_204_6 = new TagInfo("c:when", //$NON-NLS-1$
            204, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_206_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            206, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_207_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            207, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_208_10 = new TagInfo("c:if", //$NON-NLS-1$
            208, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_217_2 = new TagInfo("c:if", //$NON-NLS-1$
            217, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_218_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            218, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_219_5 = new TagInfo("c:choose", //$NON-NLS-1$
            219, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_220_6 = new TagInfo("c:when", //$NON-NLS-1$
            220, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_222_6 = new TagInfo("c:when", //$NON-NLS-1$
            222, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_224_6 = new TagInfo("c:when", //$NON-NLS-1$
            224, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_226_6 = new TagInfo("c:when", //$NON-NLS-1$
            226, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_228_6 = new TagInfo("c:when", //$NON-NLS-1$
            228, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_230_6 = new TagInfo("c:when", //$NON-NLS-1$
            230, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_232_6 = new TagInfo("c:when", //$NON-NLS-1$
            232, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_234_6 = new TagInfo("c:when", //$NON-NLS-1$
            234, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_236_6 = new TagInfo("c:when", //$NON-NLS-1$
            236, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_238_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            238, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_239_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            239, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_240_10 = new TagInfo("c:if", //$NON-NLS-1$
            240, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_249_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            249, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
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
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_281_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            281, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_282_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            282, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_283_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            283, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_285_9 = new TagInfo("c:if", //$NON-NLS-1$
            285, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_287_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            287, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_288_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            288, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_290_17 = new TagInfo("c:if", //$NON-NLS-1$
            290, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_292_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            292, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_293_19 = new TagInfo("c:if", //$NON-NLS-1$
            293, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_296_19 = new TagInfo("c:if", //$NON-NLS-1$
            296, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_297_21 = new TagInfo("c:if", //$NON-NLS-1$
            297, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_299_18 = new TagInfo("c:if", //$NON-NLS-1$
            299, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_313_1 = new TagInfo("f:message", //$NON-NLS-1$
            313, 1,
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
                RuntimeTagElement _jettag_c_setVariable_6_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_6_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_6_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_6_1.setTagInfo(_td_c_setVariable_6_1);
                _jettag_c_setVariable_6_1.doStart(context, out);
                _jettag_c_setVariable_6_1.doEnd();
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 7, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 7, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.ReadCompositey;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.utils.Alignment;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.fields.DataType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.rf.GenericRequest;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.OptionsComposite.OptionsCompositeType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 13, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 13, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 13, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_14_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_14_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_14_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_14_1.setTagInfo(_td_f_message_14_1);
                _jettag_f_message_14_1.doStart(context, out);
                JET2Writer _jettag_f_message_14_1_saved_out = out;
                while (_jettag_f_message_14_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_14_1.handleBodyContent(out);
                }
                out = _jettag_f_message_14_1_saved_out;
                _jettag_f_message_14_1.doEnd();
                out.write(NL);         
                out.write("public class Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 15, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely extends ReadCompositey<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 15, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy> {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_16_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_16_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_16_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_16_1.setTagInfo(_td_f_message_16_1);
                _jettag_f_message_16_1.doStart(context, out);
                JET2Writer _jettag_f_message_16_1_saved_out = out;
                while (_jettag_f_message_16_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_16_1.handleBodyContent(out);
                }
                out = _jettag_f_message_16_1_saved_out;
                _jettag_f_message_16_1.doEnd();
                out.write(NL);         
                out.write("private static Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 17, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 17, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_18_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_18_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_18_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_18_1.setTagInfo(_td_f_message_18_1);
                _jettag_f_message_18_1.doStart(context, out);
                JET2Writer _jettag_f_message_18_1_saved_out = out;
                while (_jettag_f_message_18_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_18_1.handleBodyContent(out);
                }
                out = _jettag_f_message_18_1_saved_out;
                _jettag_f_message_18_1.doEnd();
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 19, 2)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("OptionsPanel options = new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 19, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("OptionsPanel(OptionsCompositeType.CRUD);");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_20_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_20_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_20_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_20_1.setTagInfo(_td_f_message_20_1);
                _jettag_f_message_20_1.doStart(context, out);
                JET2Writer _jettag_f_message_20_1_saved_out = out;
                while (_jettag_f_message_20_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_20_1.handleBodyContent(out);
                }
                out = _jettag_f_message_20_1_saved_out;
                _jettag_f_message_20_1.doEnd();
                out.write(NL);         
                out.write("\tpublic static Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 21, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely instance() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 22, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_24_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_24_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_24_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_24_1.setTagInfo(_td_f_message_24_1);
                _jettag_f_message_24_1.doStart(context, out);
                JET2Writer _jettag_f_message_24_1_saved_out = out;
                while (_jettag_f_message_24_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_24_1.handleBodyContent(out);
                }
                out = _jettag_f_message_24_1_saved_out;
                _jettag_f_message_24_1.doEnd();
                out.write(NL);         
                out.write("\tpublic Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 25, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panely(Long id) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tread");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 26, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel = this;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitReadComposite(id, \"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 27, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 27, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 27, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\", ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 27, 93)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.constants);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_29_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_29_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_29_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_29_1.setTagInfo(_td_f_message_29_1);
                _jettag_f_message_29_1.doStart(context, out);
                JET2Writer _jettag_f_message_29_1_saved_out = out;
                while (_jettag_f_message_29_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_29_1.handleBodyContent(out);
                }
                out = _jettag_f_message_29_1_saved_out;
                _jettag_f_message_29_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tpublic GenericRequest<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 31, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy> getRequest() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 32, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().requestFactory.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 32, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Request();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_35_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_35_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_35_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_35_1.setTagInfo(_td_f_message_35_1);
                _jettag_f_message_35_1.doStart(context, out);
                JET2Writer _jettag_f_message_35_1_saved_out = out;
                while (_jettag_f_message_35_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_35_1.handleBodyContent(out);
                }
                out = _jettag_f_message_35_1_saved_out;
                _jettag_f_message_35_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void populateFieldsFromProxy(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 37, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 37, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(") {");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_39_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_39_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_39_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_39_4.setTagInfo(_td_c_if_39_4);
                _jettag_c_if_39_4.doStart(context, out);
                while (_jettag_c_if_39_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_40_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_40_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_40_4.setRuntimeParent(_jettag_c_if_39_4);
                    _jettag_c_iterate_40_4.setTagInfo(_td_c_iterate_40_4);
                    _jettag_c_iterate_40_4.doStart(context, out);
                    while (_jettag_c_iterate_40_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_41_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_41_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_41_5.setRuntimeParent(_jettag_c_iterate_40_4);
                        _jettag_c_choose_41_5.setTagInfo(_td_c_choose_41_5);
                        _jettag_c_choose_41_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_41_5_saved_out = out;
                        while (_jettag_c_choose_41_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_42_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_42_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_42_6.setRuntimeParent(_jettag_c_choose_41_5);
                            _jettag_c_when_42_6.setTagInfo(_td_c_when_42_6);
                            _jettag_c_when_42_6.doStart(context, out);
                            JET2Writer _jettag_c_when_42_6_saved_out = out;
                            while (_jettag_c_when_42_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 42, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 42, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 42, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_42_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_42_6_saved_out;
                            _jettag_c_when_42_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_44_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_44_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_44_6.setRuntimeParent(_jettag_c_choose_41_5);
                            _jettag_c_when_44_6.setTagInfo(_td_c_when_44_6);
                            _jettag_c_when_44_6.doStart(context, out);
                            JET2Writer _jettag_c_when_44_6_saved_out = out;
                            while (_jettag_c_when_44_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 44, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 44, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 44, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_44_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_44_6_saved_out;
                            _jettag_c_when_44_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_46_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_46_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_46_6.setRuntimeParent(_jettag_c_choose_41_5);
                            _jettag_c_when_46_6.setTagInfo(_td_c_when_46_6);
                            _jettag_c_when_46_6.doStart(context, out);
                            JET2Writer _jettag_c_when_46_6_saved_out = out;
                            while (_jettag_c_when_46_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 46, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 46, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 46, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_46_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_46_6_saved_out;
                            _jettag_c_when_46_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_48_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_48_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_48_6.setRuntimeParent(_jettag_c_choose_41_5);
                            _jettag_c_when_48_6.setTagInfo(_td_c_when_48_6);
                            _jettag_c_when_48_6.doStart(context, out);
                            JET2Writer _jettag_c_when_48_6_saved_out = out;
                            while (_jettag_c_when_48_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 48, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 48, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 48, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_48_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_48_6_saved_out;
                            _jettag_c_when_48_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_50_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_50_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_50_6.setRuntimeParent(_jettag_c_choose_41_5);
                            _jettag_c_when_50_6.setTagInfo(_td_c_when_50_6);
                            _jettag_c_when_50_6.doStart(context, out);
                            JET2Writer _jettag_c_when_50_6_saved_out = out;
                            while (_jettag_c_when_50_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 50, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 50, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 50, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_50_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_50_6_saved_out;
                            _jettag_c_when_50_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_52_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_52_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_52_6.setRuntimeParent(_jettag_c_choose_41_5);
                            _jettag_c_when_52_6.setTagInfo(_td_c_when_52_6);
                            _jettag_c_when_52_6.doStart(context, out);
                            JET2Writer _jettag_c_when_52_6_saved_out = out;
                            while (_jettag_c_when_52_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 52, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 52, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 52, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_52_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_52_6_saved_out;
                            _jettag_c_when_52_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_54_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_54_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_54_6.setRuntimeParent(_jettag_c_choose_41_5);
                            _jettag_c_when_54_6.setTagInfo(_td_c_when_54_6);
                            _jettag_c_when_54_6.doStart(context, out);
                            JET2Writer _jettag_c_when_54_6_saved_out = out;
                            while (_jettag_c_when_54_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 54, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 54, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 54, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),true); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_54_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_54_6_saved_out;
                            _jettag_c_when_54_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_56_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_56_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_56_6.setRuntimeParent(_jettag_c_choose_41_5);
                            _jettag_c_when_56_6.setTagInfo(_td_c_when_56_6);
                            _jettag_c_when_56_6.doStart(context, out);
                            JET2Writer _jettag_c_when_56_6_saved_out = out;
                            while (_jettag_c_when_56_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 56, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 56, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Welcome.constants");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\t\t\t\t\t.imagesTargetDirectory() + ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 57, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 57, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),\"400\",\"400\"); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_56_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_56_6_saved_out;
                            _jettag_c_when_56_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_59_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_59_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_59_6.setRuntimeParent(_jettag_c_choose_41_5);
                            _jettag_c_when_59_6.setTagInfo(_td_c_when_59_6);
                            _jettag_c_when_59_6.doStart(context, out);
                            JET2Writer _jettag_c_when_59_6_saved_out = out;
                            while (_jettag_c_when_59_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" setRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 59, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 59, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 59, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_59_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_59_6_saved_out;
                            _jettag_c_when_59_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_61_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_61_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_61_7.setRuntimeParent(_jettag_c_choose_41_5);
                            _jettag_c_otherwise_61_7.setTagInfo(_td_c_otherwise_61_7);
                            _jettag_c_otherwise_61_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_61_7_saved_out = out;
                            while (_jettag_c_otherwise_61_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_62_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_62_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_62_8.setRuntimeParent(_jettag_c_otherwise_61_7);
                                _jettag_c_iterate_62_8.setTagInfo(_td_c_iterate_62_8);
                                _jettag_c_iterate_62_8.doStart(context, out);
                                while (_jettag_c_iterate_62_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_63_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_63_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_63_10.setRuntimeParent(_jettag_c_iterate_62_8);
                                    _jettag_c_if_63_10.setTagInfo(_td_c_if_63_10);
                                    _jettag_c_if_63_10.doStart(context, out);
                                    while (_jettag_c_if_63_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tsetEnumFeild(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 64, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 64, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".get");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 64, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("().toString());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_63_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_63_10.doEnd();
                                    _jettag_c_iterate_62_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_62_8.doEnd();
                                _jettag_c_otherwise_61_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_61_7_saved_out;
                            _jettag_c_otherwise_61_7.doEnd();
                            _jettag_c_choose_41_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_41_5_saved_out;
                        _jettag_c_choose_41_5.doEnd();
                        _jettag_c_iterate_40_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_40_4.doEnd();
                    _jettag_c_if_39_4.handleBodyContent(out);
                }
                _jettag_c_if_39_4.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_72_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_72_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_72_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_72_4.setTagInfo(_td_c_if_72_4);
                _jettag_c_if_72_4.doStart(context, out);
                while (_jettag_c_if_72_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_73_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_73_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_73_4.setRuntimeParent(_jettag_c_if_72_4);
                    _jettag_c_iterate_73_4.setTagInfo(_td_c_iterate_73_4);
                    _jettag_c_iterate_73_4.doStart(context, out);
                    while (_jettag_c_iterate_73_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_74_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_74_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_74_5.setRuntimeParent(_jettag_c_iterate_73_4);
                        _jettag_c_choose_74_5.setTagInfo(_td_c_choose_74_5);
                        _jettag_c_choose_74_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_74_5_saved_out = out;
                        while (_jettag_c_choose_74_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_75_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_75_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_75_6.setRuntimeParent(_jettag_c_choose_74_5);
                            _jettag_c_when_75_6.setTagInfo(_td_c_when_75_6);
                            _jettag_c_when_75_6.doStart(context, out);
                            JET2Writer _jettag_c_when_75_6_saved_out = out;
                            while (_jettag_c_when_75_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 75, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 75, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 75, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_75_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_75_6_saved_out;
                            _jettag_c_when_75_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_77_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_77_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_77_6.setRuntimeParent(_jettag_c_choose_74_5);
                            _jettag_c_when_77_6.setTagInfo(_td_c_when_77_6);
                            _jettag_c_when_77_6.doStart(context, out);
                            JET2Writer _jettag_c_when_77_6_saved_out = out;
                            while (_jettag_c_when_77_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 77, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 77, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 77, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_77_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_77_6_saved_out;
                            _jettag_c_when_77_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_79_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_79_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_79_6.setRuntimeParent(_jettag_c_choose_74_5);
                            _jettag_c_when_79_6.setTagInfo(_td_c_when_79_6);
                            _jettag_c_when_79_6.doStart(context, out);
                            JET2Writer _jettag_c_when_79_6_saved_out = out;
                            while (_jettag_c_when_79_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 79, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 79, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 79, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_79_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_79_6_saved_out;
                            _jettag_c_when_79_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_81_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_81_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_81_6.setRuntimeParent(_jettag_c_choose_74_5);
                            _jettag_c_when_81_6.setTagInfo(_td_c_when_81_6);
                            _jettag_c_when_81_6.doStart(context, out);
                            JET2Writer _jettag_c_when_81_6_saved_out = out;
                            while (_jettag_c_when_81_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 81, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 81, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 81, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_81_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_81_6_saved_out;
                            _jettag_c_when_81_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_83_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_83_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_83_6.setRuntimeParent(_jettag_c_choose_74_5);
                            _jettag_c_when_83_6.setTagInfo(_td_c_when_83_6);
                            _jettag_c_when_83_6.doStart(context, out);
                            JET2Writer _jettag_c_when_83_6_saved_out = out;
                            while (_jettag_c_when_83_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 83, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 83, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 83, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_83_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_83_6_saved_out;
                            _jettag_c_when_83_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_85_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_85_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_85_6.setRuntimeParent(_jettag_c_choose_74_5);
                            _jettag_c_when_85_6.setTagInfo(_td_c_when_85_6);
                            _jettag_c_when_85_6.doStart(context, out);
                            JET2Writer _jettag_c_when_85_6_saved_out = out;
                            while (_jettag_c_when_85_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 85, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 85, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 85, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_85_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_85_6_saved_out;
                            _jettag_c_when_85_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_87_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_87_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_87_6.setRuntimeParent(_jettag_c_choose_74_5);
                            _jettag_c_when_87_6.setTagInfo(_td_c_when_87_6);
                            _jettag_c_when_87_6.doStart(context, out);
                            JET2Writer _jettag_c_when_87_6_saved_out = out;
                            while (_jettag_c_when_87_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 87, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 87, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 87, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),true); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_87_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_87_6_saved_out;
                            _jettag_c_when_87_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_89_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_89_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_89_6.setRuntimeParent(_jettag_c_choose_74_5);
                            _jettag_c_when_89_6.setTagInfo(_td_c_when_89_6);
                            _jettag_c_when_89_6.doStart(context, out);
                            JET2Writer _jettag_c_when_89_6_saved_out = out;
                            while (_jettag_c_when_89_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 89, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 89, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Welcome.constants");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\t\t\t\t\t.imagesTargetDirectory() + ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 90, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 90, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),\"400\",\"400\"); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_89_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_89_6_saved_out;
                            _jettag_c_when_89_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_92_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_92_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_92_6.setRuntimeParent(_jettag_c_choose_74_5);
                            _jettag_c_when_92_6.setTagInfo(_td_c_when_92_6);
                            _jettag_c_when_92_6.doStart(context, out);
                            JET2Writer _jettag_c_when_92_6_saved_out = out;
                            while (_jettag_c_when_92_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" setRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 92, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 92, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 92, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_92_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_92_6_saved_out;
                            _jettag_c_when_92_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_94_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_94_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_94_7.setRuntimeParent(_jettag_c_choose_74_5);
                            _jettag_c_otherwise_94_7.setTagInfo(_td_c_otherwise_94_7);
                            _jettag_c_otherwise_94_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_94_7_saved_out = out;
                            while (_jettag_c_otherwise_94_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_95_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_95_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_95_8.setRuntimeParent(_jettag_c_otherwise_94_7);
                                _jettag_c_iterate_95_8.setTagInfo(_td_c_iterate_95_8);
                                _jettag_c_iterate_95_8.doStart(context, out);
                                while (_jettag_c_iterate_95_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_96_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_96_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_96_10.setRuntimeParent(_jettag_c_iterate_95_8);
                                    _jettag_c_if_96_10.setTagInfo(_td_c_if_96_10);
                                    _jettag_c_if_96_10.doStart(context, out);
                                    while (_jettag_c_if_96_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tsetEnumFeild(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 97, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 97, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".get");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 97, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("().toString());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_96_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_96_10.doEnd();
                                    _jettag_c_iterate_95_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_95_8.doEnd();
                                _jettag_c_otherwise_94_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_94_7_saved_out;
                            _jettag_c_otherwise_94_7.doEnd();
                            _jettag_c_choose_74_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_74_5_saved_out;
                        _jettag_c_choose_74_5.doEnd();
                        _jettag_c_iterate_73_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_73_4.doEnd();
                    _jettag_c_if_72_4.handleBodyContent(out);
                }
                _jettag_c_if_72_4.doEnd();
                // process base class
                RuntimeTagElement _jettag_c_iterate_105_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_105_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_105_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_105_4.setTagInfo(_td_c_iterate_105_4);
                _jettag_c_iterate_105_4.doStart(context, out);
                while (_jettag_c_iterate_105_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_106_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_106_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_106_5.setRuntimeParent(_jettag_c_iterate_105_4);
                    _jettag_c_choose_106_5.setTagInfo(_td_c_choose_106_5);
                    _jettag_c_choose_106_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_106_5_saved_out = out;
                    while (_jettag_c_choose_106_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_107_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_107_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_107_6.setRuntimeParent(_jettag_c_choose_106_5);
                        _jettag_c_when_107_6.setTagInfo(_td_c_when_107_6);
                        _jettag_c_when_107_6.doStart(context, out);
                        JET2Writer _jettag_c_when_107_6_saved_out = out;
                        while (_jettag_c_when_107_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 107, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 107, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 107, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_107_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_107_6_saved_out;
                        _jettag_c_when_107_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_109_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_109_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_109_6.setRuntimeParent(_jettag_c_choose_106_5);
                        _jettag_c_when_109_6.setTagInfo(_td_c_when_109_6);
                        _jettag_c_when_109_6.doStart(context, out);
                        JET2Writer _jettag_c_when_109_6_saved_out = out;
                        while (_jettag_c_when_109_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 109, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 109, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 109, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_109_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_109_6_saved_out;
                        _jettag_c_when_109_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_111_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_111_6.setRuntimeParent(_jettag_c_choose_106_5);
                        _jettag_c_when_111_6.setTagInfo(_td_c_when_111_6);
                        _jettag_c_when_111_6.doStart(context, out);
                        JET2Writer _jettag_c_when_111_6_saved_out = out;
                        while (_jettag_c_when_111_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 111, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 111, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 111, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_111_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_111_6_saved_out;
                        _jettag_c_when_111_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_113_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_113_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_113_6.setRuntimeParent(_jettag_c_choose_106_5);
                        _jettag_c_when_113_6.setTagInfo(_td_c_when_113_6);
                        _jettag_c_when_113_6.doStart(context, out);
                        JET2Writer _jettag_c_when_113_6_saved_out = out;
                        while (_jettag_c_when_113_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 113, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 113, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 113, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_113_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_113_6_saved_out;
                        _jettag_c_when_113_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_115_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_115_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_115_6.setRuntimeParent(_jettag_c_choose_106_5);
                        _jettag_c_when_115_6.setTagInfo(_td_c_when_115_6);
                        _jettag_c_when_115_6.doStart(context, out);
                        JET2Writer _jettag_c_when_115_6_saved_out = out;
                        while (_jettag_c_when_115_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 115, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 115, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 115, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_115_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_115_6_saved_out;
                        _jettag_c_when_115_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_117_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_117_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_117_6.setRuntimeParent(_jettag_c_choose_106_5);
                        _jettag_c_when_117_6.setTagInfo(_td_c_when_117_6);
                        _jettag_c_when_117_6.doStart(context, out);
                        JET2Writer _jettag_c_when_117_6_saved_out = out;
                        while (_jettag_c_when_117_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 117, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 117, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 117, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_117_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_117_6_saved_out;
                        _jettag_c_when_117_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_119_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_119_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_119_6.setRuntimeParent(_jettag_c_choose_106_5);
                        _jettag_c_when_119_6.setTagInfo(_td_c_when_119_6);
                        _jettag_c_when_119_6.doStart(context, out);
                        JET2Writer _jettag_c_when_119_6_saved_out = out;
                        while (_jettag_c_when_119_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 119, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 119, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 119, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(),true); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_119_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_119_6_saved_out;
                        _jettag_c_when_119_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_121_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_121_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_121_6.setRuntimeParent(_jettag_c_choose_106_5);
                        _jettag_c_when_121_6.setTagInfo(_td_c_when_121_6);
                        _jettag_c_when_121_6.doStart(context, out);
                        JET2Writer _jettag_c_when_121_6_saved_out = out;
                        while (_jettag_c_when_121_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setImageField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 121, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 121, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("Welcome.constants");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t.imagesTargetDirectory() + ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 122, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 122, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(),\"400\",\"400\"); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_121_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_121_6_saved_out;
                        _jettag_c_when_121_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_124_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_124_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_124_6.setRuntimeParent(_jettag_c_choose_106_5);
                        _jettag_c_when_124_6.setTagInfo(_td_c_when_124_6);
                        _jettag_c_when_124_6.doStart(context, out);
                        JET2Writer _jettag_c_when_124_6_saved_out = out;
                        while (_jettag_c_when_124_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" setRichTextField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 124, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 124, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 124, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_124_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_124_6_saved_out;
                        _jettag_c_when_124_6.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_126_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_126_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_126_7.setRuntimeParent(_jettag_c_choose_106_5);
                        _jettag_c_otherwise_126_7.setTagInfo(_td_c_otherwise_126_7);
                        _jettag_c_otherwise_126_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_126_7_saved_out = out;
                        while (_jettag_c_otherwise_126_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_127_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_127_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_127_8.setRuntimeParent(_jettag_c_otherwise_126_7);
                            _jettag_c_iterate_127_8.setTagInfo(_td_c_iterate_127_8);
                            _jettag_c_iterate_127_8.doStart(context, out);
                            while (_jettag_c_iterate_127_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_128_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_128_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_128_10.setRuntimeParent(_jettag_c_iterate_127_8);
                                _jettag_c_if_128_10.setTagInfo(_td_c_if_128_10);
                                _jettag_c_if_128_10.doStart(context, out);
                                while (_jettag_c_if_128_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\tsetEnumFeild(\"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 129, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 129, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".get");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 129, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("().toString());");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_128_10.handleBodyContent(out);
                                }
                                _jettag_c_if_128_10.doEnd();
                                _jettag_c_iterate_127_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_127_8.doEnd();
                            _jettag_c_otherwise_126_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_126_7_saved_out;
                        _jettag_c_otherwise_126_7.doEnd();
                        _jettag_c_choose_106_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_106_5_saved_out;
                    _jettag_c_choose_106_5.doEnd();
                    _jettag_c_iterate_105_4.handleBodyContent(out);
                }
                _jettag_c_iterate_105_4.doEnd();
                // process dropdowns one to one and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_136_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_136_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_136_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_136_4.setTagInfo(_td_c_iterate_136_4);
                _jettag_c_iterate_136_4.doStart(context, out);
                while (_jettag_c_iterate_136_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_137_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_137_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_137_5.setRuntimeParent(_jettag_c_iterate_136_4);
                    _jettag_c_iterate_137_5.setTagInfo(_td_c_iterate_137_5);
                    _jettag_c_iterate_137_5.doStart(context, out);
                    while (_jettag_c_iterate_137_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_138_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_138_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_138_6.setRuntimeParent(_jettag_c_iterate_137_5);
                        _jettag_c_iterate_138_6.setTagInfo(_td_c_iterate_138_6);
                        _jettag_c_iterate_138_6.doStart(context, out);
                        while (_jettag_c_iterate_138_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_139_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_139_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_139_7.setRuntimeParent(_jettag_c_iterate_138_6);
                            _jettag_c_setVariable_139_7.setTagInfo(_td_c_setVariable_139_7);
                            _jettag_c_setVariable_139_7.doStart(context, out);
                            _jettag_c_setVariable_139_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_141_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_141_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_141_9.setRuntimeParent(_jettag_c_iterate_138_6);
                            _jettag_c_if_141_9.setTagInfo(_td_c_if_141_9);
                            _jettag_c_if_141_9.doStart(context, out);
                            while (_jettag_c_if_141_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_143_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_143_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_143_15.setRuntimeParent(_jettag_c_if_141_9);
                                _jettag_c_iterate_143_15.setTagInfo(_td_c_iterate_143_15);
                                _jettag_c_iterate_143_15.doStart(context, out);
                                while (_jettag_c_iterate_143_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_144_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_144_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_144_15.setRuntimeParent(_jettag_c_iterate_143_15);
                                    _jettag_c_setVariable_144_15.setTagInfo(_td_c_setVariable_144_15);
                                    _jettag_c_setVariable_144_15.doStart(context, out);
                                    _jettag_c_setVariable_144_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_146_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_146_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_146_17.setRuntimeParent(_jettag_c_iterate_143_15);
                                    _jettag_c_if_146_17.setTagInfo(_td_c_if_146_17);
                                    _jettag_c_if_146_17.doStart(context, out);
                                    while (_jettag_c_if_146_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_148_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_148_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_148_18.setRuntimeParent(_jettag_c_if_146_17);
                                        _jettag_c_iterate_148_18.setTagInfo(_td_c_iterate_148_18);
                                        _jettag_c_iterate_148_18.doStart(context, out);
                                        while (_jettag_c_iterate_148_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_149_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_149_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_149_19.setRuntimeParent(_jettag_c_iterate_148_18);
                                            _jettag_c_if_149_19.setTagInfo(_td_c_if_149_19);
                                            _jettag_c_if_149_19.doStart(context, out);
                                            while (_jettag_c_if_149_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_152_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_152_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_152_19.setRuntimeParent(_jettag_c_if_149_19);
                                                _jettag_c_if_152_19.setTagInfo(_td_c_if_152_19);
                                                _jettag_c_if_152_19.doStart(context, out);
                                                while (_jettag_c_if_152_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_153_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_153_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_153_21.setRuntimeParent(_jettag_c_if_152_19);
                                                    _jettag_c_if_153_21.setTagInfo(_td_c_if_153_21);
                                                    _jettag_c_if_153_21.doStart(context, out);
                                                    while (_jettag_c_if_153_21.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_155_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_155_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_155_18.setRuntimeParent(_jettag_c_if_153_21);
                                                        _jettag_c_if_155_18.setTagInfo(_td_c_if_155_18);
                                                        _jettag_c_if_155_18.doStart(context, out);
                                                        while (_jettag_c_if_155_18.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\tsetDropDownField(\"");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 156, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("\", ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 156, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 156, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("());");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_155_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_155_18.doEnd();
                                                        _jettag_c_if_153_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_153_21.doEnd();
                                                    _jettag_c_if_152_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_152_19.doEnd();
                                                _jettag_c_if_149_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_149_19.doEnd();
                                            _jettag_c_iterate_148_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_148_18.doEnd();
                                        _jettag_c_if_146_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_146_17.doEnd();
                                    _jettag_c_iterate_143_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_143_15.doEnd();
                                _jettag_c_if_141_9.handleBodyContent(out);
                            }
                            _jettag_c_if_141_9.doEnd();
                            _jettag_c_iterate_138_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_138_6.doEnd();
                        _jettag_c_iterate_137_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_137_5.doEnd();
                    _jettag_c_iterate_136_4.handleBodyContent(out);
                }
                _jettag_c_iterate_136_4.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_169_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_169_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_169_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_169_1.setTagInfo(_td_f_message_169_1);
                _jettag_f_message_169_1.doStart(context, out);
                JET2Writer _jettag_f_message_169_1_saved_out = out;
                while (_jettag_f_message_169_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_169_1.handleBodyContent(out);
                }
                out = _jettag_f_message_169_1_saved_out;
                _jettag_f_message_169_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_175_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_175_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_175_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_175_1.setTagInfo(_td_f_message_175_1);
                _jettag_f_message_175_1.doStart(context, out);
                JET2Writer _jettag_f_message_175_1_saved_out = out;
                while (_jettag_f_message_175_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_175_1.handleBodyContent(out);
                }
                out = _jettag_f_message_175_1_saved_out;
                _jettag_f_message_175_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void addWidgetsBeforeCaptionPanel() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tbasePanel.add(options);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void addWidgets() {");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_185_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_185_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_185_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_185_2.setTagInfo(_td_c_if_185_2);
                _jettag_c_if_185_2.doStart(context, out);
                while (_jettag_c_if_185_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_186_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_186_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_186_5.setRuntimeParent(_jettag_c_if_185_2);
                    _jettag_c_iterate_186_5.setTagInfo(_td_c_iterate_186_5);
                    _jettag_c_iterate_186_5.doStart(context, out);
                    while (_jettag_c_iterate_186_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_187_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_187_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_187_5.setRuntimeParent(_jettag_c_iterate_186_5);
                        _jettag_c_choose_187_5.setTagInfo(_td_c_choose_187_5);
                        _jettag_c_choose_187_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_187_5_saved_out = out;
                        while (_jettag_c_choose_187_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_188_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_188_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_188_6.setRuntimeParent(_jettag_c_choose_187_5);
                            _jettag_c_when_188_6.setTagInfo(_td_c_when_188_6);
                            _jettag_c_when_188_6.doStart(context, out);
                            JET2Writer _jettag_c_when_188_6_saved_out = out;
                            while (_jettag_c_when_188_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 188, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 188, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_188_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_188_6_saved_out;
                            _jettag_c_when_188_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_190_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_190_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_190_6.setRuntimeParent(_jettag_c_choose_187_5);
                            _jettag_c_when_190_6.setTagInfo(_td_c_when_190_6);
                            _jettag_c_when_190_6.doStart(context, out);
                            JET2Writer _jettag_c_when_190_6_saved_out = out;
                            while (_jettag_c_when_190_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 190, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 190, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_190_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_190_6_saved_out;
                            _jettag_c_when_190_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_192_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_192_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_192_6.setRuntimeParent(_jettag_c_choose_187_5);
                            _jettag_c_when_192_6.setTagInfo(_td_c_when_192_6);
                            _jettag_c_when_192_6.doStart(context, out);
                            JET2Writer _jettag_c_when_192_6_saved_out = out;
                            while (_jettag_c_when_192_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 192, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 192, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_192_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_192_6_saved_out;
                            _jettag_c_when_192_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_194_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_194_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_194_6.setRuntimeParent(_jettag_c_choose_187_5);
                            _jettag_c_when_194_6.setTagInfo(_td_c_when_194_6);
                            _jettag_c_when_194_6.doStart(context, out);
                            JET2Writer _jettag_c_when_194_6_saved_out = out;
                            while (_jettag_c_when_194_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 194, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 194, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_194_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_194_6_saved_out;
                            _jettag_c_when_194_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_196_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_196_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_196_6.setRuntimeParent(_jettag_c_choose_187_5);
                            _jettag_c_when_196_6.setTagInfo(_td_c_when_196_6);
                            _jettag_c_when_196_6.doStart(context, out);
                            JET2Writer _jettag_c_when_196_6_saved_out = out;
                            while (_jettag_c_when_196_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 196, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 196, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_196_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_196_6_saved_out;
                            _jettag_c_when_196_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_198_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_198_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_198_6.setRuntimeParent(_jettag_c_choose_187_5);
                            _jettag_c_when_198_6.setTagInfo(_td_c_when_198_6);
                            _jettag_c_when_198_6.doStart(context, out);
                            JET2Writer _jettag_c_when_198_6_saved_out = out;
                            while (_jettag_c_when_198_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 198, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 198, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_198_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_198_6_saved_out;
                            _jettag_c_when_198_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_200_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_200_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_200_6.setRuntimeParent(_jettag_c_choose_187_5);
                            _jettag_c_when_200_6.setTagInfo(_td_c_when_200_6);
                            _jettag_c_when_200_6.doStart(context, out);
                            JET2Writer _jettag_c_when_200_6_saved_out = out;
                            while (_jettag_c_when_200_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 200, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 200, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_200_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_200_6_saved_out;
                            _jettag_c_when_200_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_202_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_202_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_202_6.setRuntimeParent(_jettag_c_choose_187_5);
                            _jettag_c_when_202_6.setTagInfo(_td_c_when_202_6);
                            _jettag_c_when_202_6.doStart(context, out);
                            JET2Writer _jettag_c_when_202_6_saved_out = out;
                            while (_jettag_c_when_202_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 202, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 202, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_202_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_202_6_saved_out;
                            _jettag_c_when_202_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_204_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_204_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_204_6.setRuntimeParent(_jettag_c_choose_187_5);
                            _jettag_c_when_204_6.setTagInfo(_td_c_when_204_6);
                            _jettag_c_when_204_6.doStart(context, out);
                            JET2Writer _jettag_c_when_204_6_saved_out = out;
                            while (_jettag_c_when_204_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 204, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 204, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_204_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_204_6_saved_out;
                            _jettag_c_when_204_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_206_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_206_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_206_7.setRuntimeParent(_jettag_c_choose_187_5);
                            _jettag_c_otherwise_206_7.setTagInfo(_td_c_otherwise_206_7);
                            _jettag_c_otherwise_206_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_206_7_saved_out = out;
                            while (_jettag_c_otherwise_206_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_207_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_207_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_207_8.setRuntimeParent(_jettag_c_otherwise_206_7);
                                _jettag_c_iterate_207_8.setTagInfo(_td_c_iterate_207_8);
                                _jettag_c_iterate_207_8.doStart(context, out);
                                while (_jettag_c_iterate_207_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_208_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_208_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_208_10.setRuntimeParent(_jettag_c_iterate_207_8);
                                    _jettag_c_if_208_10.setTagInfo(_td_c_if_208_10);
                                    _jettag_c_if_208_10.doStart(context, out);
                                    while (_jettag_c_if_208_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 209, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", true, ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 209, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(", \"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 209, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 209, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".class.getName());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_208_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_208_10.doEnd();
                                    _jettag_c_iterate_207_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_207_8.doEnd();
                                _jettag_c_otherwise_206_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_206_7_saved_out;
                            _jettag_c_otherwise_206_7.doEnd();
                            _jettag_c_choose_187_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_187_5_saved_out;
                        _jettag_c_choose_187_5.doEnd();
                        _jettag_c_iterate_186_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_186_5.doEnd();
                    _jettag_c_if_185_2.handleBodyContent(out);
                }
                _jettag_c_if_185_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_217_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_217_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_217_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_217_2.setTagInfo(_td_c_if_217_2);
                _jettag_c_if_217_2.doStart(context, out);
                while (_jettag_c_if_217_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_218_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_218_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_218_5.setRuntimeParent(_jettag_c_if_217_2);
                    _jettag_c_iterate_218_5.setTagInfo(_td_c_iterate_218_5);
                    _jettag_c_iterate_218_5.doStart(context, out);
                    while (_jettag_c_iterate_218_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_219_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_219_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_219_5.setRuntimeParent(_jettag_c_iterate_218_5);
                        _jettag_c_choose_219_5.setTagInfo(_td_c_choose_219_5);
                        _jettag_c_choose_219_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_219_5_saved_out = out;
                        while (_jettag_c_choose_219_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_220_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_220_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_220_6.setRuntimeParent(_jettag_c_choose_219_5);
                            _jettag_c_when_220_6.setTagInfo(_td_c_when_220_6);
                            _jettag_c_when_220_6.doStart(context, out);
                            JET2Writer _jettag_c_when_220_6_saved_out = out;
                            while (_jettag_c_when_220_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 220, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 220, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_220_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_220_6_saved_out;
                            _jettag_c_when_220_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_222_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_222_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_222_6.setRuntimeParent(_jettag_c_choose_219_5);
                            _jettag_c_when_222_6.setTagInfo(_td_c_when_222_6);
                            _jettag_c_when_222_6.doStart(context, out);
                            JET2Writer _jettag_c_when_222_6_saved_out = out;
                            while (_jettag_c_when_222_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 222, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 222, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_222_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_222_6_saved_out;
                            _jettag_c_when_222_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_224_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_224_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_224_6.setRuntimeParent(_jettag_c_choose_219_5);
                            _jettag_c_when_224_6.setTagInfo(_td_c_when_224_6);
                            _jettag_c_when_224_6.doStart(context, out);
                            JET2Writer _jettag_c_when_224_6_saved_out = out;
                            while (_jettag_c_when_224_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 224, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 224, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_224_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_224_6_saved_out;
                            _jettag_c_when_224_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_226_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_226_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_226_6.setRuntimeParent(_jettag_c_choose_219_5);
                            _jettag_c_when_226_6.setTagInfo(_td_c_when_226_6);
                            _jettag_c_when_226_6.doStart(context, out);
                            JET2Writer _jettag_c_when_226_6_saved_out = out;
                            while (_jettag_c_when_226_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 226, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 226, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_226_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_226_6_saved_out;
                            _jettag_c_when_226_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_228_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_228_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_228_6.setRuntimeParent(_jettag_c_choose_219_5);
                            _jettag_c_when_228_6.setTagInfo(_td_c_when_228_6);
                            _jettag_c_when_228_6.doStart(context, out);
                            JET2Writer _jettag_c_when_228_6_saved_out = out;
                            while (_jettag_c_when_228_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 228, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 228, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_228_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_228_6_saved_out;
                            _jettag_c_when_228_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_230_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_230_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_230_6.setRuntimeParent(_jettag_c_choose_219_5);
                            _jettag_c_when_230_6.setTagInfo(_td_c_when_230_6);
                            _jettag_c_when_230_6.doStart(context, out);
                            JET2Writer _jettag_c_when_230_6_saved_out = out;
                            while (_jettag_c_when_230_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 230, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 230, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_230_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_230_6_saved_out;
                            _jettag_c_when_230_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_232_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_232_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_232_6.setRuntimeParent(_jettag_c_choose_219_5);
                            _jettag_c_when_232_6.setTagInfo(_td_c_when_232_6);
                            _jettag_c_when_232_6.doStart(context, out);
                            JET2Writer _jettag_c_when_232_6_saved_out = out;
                            while (_jettag_c_when_232_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 232, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 232, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_232_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_232_6_saved_out;
                            _jettag_c_when_232_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_234_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_234_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_234_6.setRuntimeParent(_jettag_c_choose_219_5);
                            _jettag_c_when_234_6.setTagInfo(_td_c_when_234_6);
                            _jettag_c_when_234_6.doStart(context, out);
                            JET2Writer _jettag_c_when_234_6_saved_out = out;
                            while (_jettag_c_when_234_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 234, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 234, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_234_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_234_6_saved_out;
                            _jettag_c_when_234_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_236_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_236_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_236_6.setRuntimeParent(_jettag_c_choose_219_5);
                            _jettag_c_when_236_6.setTagInfo(_td_c_when_236_6);
                            _jettag_c_when_236_6.doStart(context, out);
                            JET2Writer _jettag_c_when_236_6_saved_out = out;
                            while (_jettag_c_when_236_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 236, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 236, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_236_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_236_6_saved_out;
                            _jettag_c_when_236_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_238_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_238_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_238_7.setRuntimeParent(_jettag_c_choose_219_5);
                            _jettag_c_otherwise_238_7.setTagInfo(_td_c_otherwise_238_7);
                            _jettag_c_otherwise_238_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_238_7_saved_out = out;
                            while (_jettag_c_otherwise_238_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_239_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_239_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_239_8.setRuntimeParent(_jettag_c_otherwise_238_7);
                                _jettag_c_iterate_239_8.setTagInfo(_td_c_iterate_239_8);
                                _jettag_c_iterate_239_8.doStart(context, out);
                                while (_jettag_c_iterate_239_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_240_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_240_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_240_10.setRuntimeParent(_jettag_c_iterate_239_8);
                                    _jettag_c_if_240_10.setTagInfo(_td_c_if_240_10);
                                    _jettag_c_if_240_10.doStart(context, out);
                                    while (_jettag_c_if_240_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 241, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", true, ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 241, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(", \"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 241, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 241, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".class.getName());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_240_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_240_10.doEnd();
                                    _jettag_c_iterate_239_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_239_8.doEnd();
                                _jettag_c_otherwise_238_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_238_7_saved_out;
                            _jettag_c_otherwise_238_7.doEnd();
                            _jettag_c_choose_219_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_219_5_saved_out;
                        _jettag_c_choose_219_5.doEnd();
                        _jettag_c_iterate_218_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_218_5.doEnd();
                    _jettag_c_if_217_2.handleBodyContent(out);
                }
                _jettag_c_if_217_2.doEnd();
                // process baseClass
                RuntimeTagElement _jettag_c_iterate_249_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_249_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_249_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_249_4.setTagInfo(_td_c_iterate_249_4);
                _jettag_c_iterate_249_4.doStart(context, out);
                while (_jettag_c_iterate_249_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_250_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_250_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_250_5.setRuntimeParent(_jettag_c_iterate_249_4);
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
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 251, 76)); //$NON-NLS-1$ //$NON-NLS-2$
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
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 253, 77)); //$NON-NLS-1$ //$NON-NLS-2$
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
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 255, 74)); //$NON-NLS-1$ //$NON-NLS-2$
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
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 257, 77)); //$NON-NLS-1$ //$NON-NLS-2$
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
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 259, 74)); //$NON-NLS-1$ //$NON-NLS-2$
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
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 261, 75)); //$NON-NLS-1$ //$NON-NLS-2$
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
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 263, 75)); //$NON-NLS-1$ //$NON-NLS-2$
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
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 265, 78)); //$NON-NLS-1$ //$NON-NLS-2$
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
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 267, 78)); //$NON-NLS-1$ //$NON-NLS-2$
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
                                    out.write("\", true, ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 272, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(", \"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 272, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 272, 101)); //$NON-NLS-1$ //$NON-NLS-2$
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
                    _jettag_c_iterate_249_4.handleBodyContent(out);
                }
                _jettag_c_iterate_249_4.doEnd();
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process dropdowns one to one and many to one 
                RuntimeTagElement _jettag_c_iterate_280_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_280_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_280_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_280_4.setTagInfo(_td_c_iterate_280_4);
                _jettag_c_iterate_280_4.doStart(context, out);
                while (_jettag_c_iterate_280_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_281_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_281_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_281_5.setRuntimeParent(_jettag_c_iterate_280_4);
                    _jettag_c_iterate_281_5.setTagInfo(_td_c_iterate_281_5);
                    _jettag_c_iterate_281_5.doStart(context, out);
                    while (_jettag_c_iterate_281_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_282_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_282_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_282_6.setRuntimeParent(_jettag_c_iterate_281_5);
                        _jettag_c_iterate_282_6.setTagInfo(_td_c_iterate_282_6);
                        _jettag_c_iterate_282_6.doStart(context, out);
                        while (_jettag_c_iterate_282_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_283_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_283_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_283_7.setRuntimeParent(_jettag_c_iterate_282_6);
                            _jettag_c_setVariable_283_7.setTagInfo(_td_c_setVariable_283_7);
                            _jettag_c_setVariable_283_7.doStart(context, out);
                            _jettag_c_setVariable_283_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_285_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_285_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_285_9.setRuntimeParent(_jettag_c_iterate_282_6);
                            _jettag_c_if_285_9.setTagInfo(_td_c_if_285_9);
                            _jettag_c_if_285_9.doStart(context, out);
                            while (_jettag_c_if_285_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_287_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_287_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_287_15.setRuntimeParent(_jettag_c_if_285_9);
                                _jettag_c_iterate_287_15.setTagInfo(_td_c_iterate_287_15);
                                _jettag_c_iterate_287_15.doStart(context, out);
                                while (_jettag_c_iterate_287_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_288_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_288_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_288_15.setRuntimeParent(_jettag_c_iterate_287_15);
                                    _jettag_c_setVariable_288_15.setTagInfo(_td_c_setVariable_288_15);
                                    _jettag_c_setVariable_288_15.doStart(context, out);
                                    _jettag_c_setVariable_288_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_290_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_290_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_290_17.setRuntimeParent(_jettag_c_iterate_287_15);
                                    _jettag_c_if_290_17.setTagInfo(_td_c_if_290_17);
                                    _jettag_c_if_290_17.doStart(context, out);
                                    while (_jettag_c_if_290_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_292_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_292_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_292_18.setRuntimeParent(_jettag_c_if_290_17);
                                        _jettag_c_iterate_292_18.setTagInfo(_td_c_iterate_292_18);
                                        _jettag_c_iterate_292_18.doStart(context, out);
                                        while (_jettag_c_iterate_292_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_293_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_293_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_293_19.setRuntimeParent(_jettag_c_iterate_292_18);
                                            _jettag_c_if_293_19.setTagInfo(_td_c_if_293_19);
                                            _jettag_c_if_293_19.doStart(context, out);
                                            while (_jettag_c_if_293_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_296_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_296_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_296_19.setRuntimeParent(_jettag_c_if_293_19);
                                                _jettag_c_if_296_19.setTagInfo(_td_c_if_296_19);
                                                _jettag_c_if_296_19.doStart(context, out);
                                                while (_jettag_c_if_296_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_297_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_297_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_297_21.setRuntimeParent(_jettag_c_if_296_19);
                                                    _jettag_c_if_297_21.setTagInfo(_td_c_if_297_21);
                                                    _jettag_c_if_297_21.doStart(context, out);
                                                    while (_jettag_c_if_297_21.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_299_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_299_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_299_18.setRuntimeParent(_jettag_c_if_297_21);
                                                        _jettag_c_if_299_18.setTagInfo(_td_c_if_299_18);
                                                        _jettag_c_if_299_18.doStart(context, out);
                                                        while (_jettag_c_if_299_18.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\taddField(\"");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 300, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("\", true, true , DataType.DROPDOWN_FIELD);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_299_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_299_18.doEnd();
                                                        _jettag_c_if_297_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_297_21.doEnd();
                                                    _jettag_c_if_296_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_296_19.doEnd();
                                                _jettag_c_if_293_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_293_19.doEnd();
                                            _jettag_c_iterate_292_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_292_18.doEnd();
                                        _jettag_c_if_290_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_290_17.doEnd();
                                    _jettag_c_iterate_287_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_287_15.doEnd();
                                _jettag_c_if_285_9.handleBodyContent(out);
                            }
                            _jettag_c_if_285_9.doEnd();
                            _jettag_c_iterate_282_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_282_6.doEnd();
                        _jettag_c_iterate_281_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_281_5.doEnd();
                    _jettag_c_iterate_280_4.handleBodyContent(out);
                }
                _jettag_c_iterate_280_4.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_313_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_313_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_313_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_313_1.setTagInfo(_td_f_message_313_1);
                _jettag_f_message_313_1.doStart(context, out);
                JET2Writer _jettag_f_message_313_1_saved_out = out;
                while (_jettag_f_message_313_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_313_1.handleBodyContent(out);
                }
                out = _jettag_f_message_313_1_saved_out;
                _jettag_f_message_313_1.doEnd();
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
