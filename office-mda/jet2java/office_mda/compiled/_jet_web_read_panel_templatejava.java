package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_read_panel_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_read_panel_templatejava() {
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
    private static final TagInfo _td_f_message_22_1 = new TagInfo("f:message", //$NON-NLS-1$
            22, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_26_1 = new TagInfo("f:message", //$NON-NLS-1$
            26, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_31_1 = new TagInfo("f:message", //$NON-NLS-1$
            31, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_40_4 = new TagInfo("c:if", //$NON-NLS-1$
            40, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_41_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            41, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_42_5 = new TagInfo("c:choose", //$NON-NLS-1$
            42, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_43_6 = new TagInfo("c:when", //$NON-NLS-1$
            43, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_45_6 = new TagInfo("c:when", //$NON-NLS-1$
            45, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_47_6 = new TagInfo("c:when", //$NON-NLS-1$
            47, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_49_6 = new TagInfo("c:when", //$NON-NLS-1$
            49, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_51_6 = new TagInfo("c:when", //$NON-NLS-1$
            51, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_53_6 = new TagInfo("c:when", //$NON-NLS-1$
            53, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_55_6 = new TagInfo("c:when", //$NON-NLS-1$
            55, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_57_6 = new TagInfo("c:when", //$NON-NLS-1$
            57, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_60_6 = new TagInfo("c:when", //$NON-NLS-1$
            60, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_62_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            62, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_63_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            63, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_64_10 = new TagInfo("c:if", //$NON-NLS-1$
            64, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_73_4 = new TagInfo("c:if", //$NON-NLS-1$
            73, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_74_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            74, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_75_5 = new TagInfo("c:choose", //$NON-NLS-1$
            75, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_76_6 = new TagInfo("c:when", //$NON-NLS-1$
            76, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_78_6 = new TagInfo("c:when", //$NON-NLS-1$
            78, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_80_6 = new TagInfo("c:when", //$NON-NLS-1$
            80, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_82_6 = new TagInfo("c:when", //$NON-NLS-1$
            82, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_84_6 = new TagInfo("c:when", //$NON-NLS-1$
            84, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_86_6 = new TagInfo("c:when", //$NON-NLS-1$
            86, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_88_6 = new TagInfo("c:when", //$NON-NLS-1$
            88, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_90_6 = new TagInfo("c:when", //$NON-NLS-1$
            90, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_93_6 = new TagInfo("c:when", //$NON-NLS-1$
            93, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_95_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            95, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_96_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            96, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_97_10 = new TagInfo("c:if", //$NON-NLS-1$
            97, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_106_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            106, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_107_5 = new TagInfo("c:choose", //$NON-NLS-1$
            107, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_108_6 = new TagInfo("c:when", //$NON-NLS-1$
            108, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_110_6 = new TagInfo("c:when", //$NON-NLS-1$
            110, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_112_6 = new TagInfo("c:when", //$NON-NLS-1$
            112, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_114_6 = new TagInfo("c:when", //$NON-NLS-1$
            114, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_116_6 = new TagInfo("c:when", //$NON-NLS-1$
            116, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_118_6 = new TagInfo("c:when", //$NON-NLS-1$
            118, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_120_6 = new TagInfo("c:when", //$NON-NLS-1$
            120, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_122_6 = new TagInfo("c:when", //$NON-NLS-1$
            122, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_125_6 = new TagInfo("c:when", //$NON-NLS-1$
            125, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_127_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            127, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_128_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            128, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_129_10 = new TagInfo("c:if", //$NON-NLS-1$
            129, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_137_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            137, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_138_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            138, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_139_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            139, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_140_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            140, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_142_9 = new TagInfo("c:if", //$NON-NLS-1$
            142, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_144_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            144, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_145_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            145, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_147_17 = new TagInfo("c:if", //$NON-NLS-1$
            147, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_149_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            149, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_150_19 = new TagInfo("c:if", //$NON-NLS-1$
            150, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_153_19 = new TagInfo("c:if", //$NON-NLS-1$
            153, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_154_21 = new TagInfo("c:if", //$NON-NLS-1$
            154, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_156_18 = new TagInfo("c:if", //$NON-NLS-1$
            156, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_172_1 = new TagInfo("f:message", //$NON-NLS-1$
            172, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_178_1 = new TagInfo("f:message", //$NON-NLS-1$
            178, 1,
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
    private static final TagInfo _td_c_if_188_2 = new TagInfo("c:if", //$NON-NLS-1$
            188, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_189_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            189, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_190_5 = new TagInfo("c:choose", //$NON-NLS-1$
            190, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_191_6 = new TagInfo("c:when", //$NON-NLS-1$
            191, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_193_6 = new TagInfo("c:when", //$NON-NLS-1$
            193, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_195_6 = new TagInfo("c:when", //$NON-NLS-1$
            195, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_197_6 = new TagInfo("c:when", //$NON-NLS-1$
            197, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_199_6 = new TagInfo("c:when", //$NON-NLS-1$
            199, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_201_6 = new TagInfo("c:when", //$NON-NLS-1$
            201, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_203_6 = new TagInfo("c:when", //$NON-NLS-1$
            203, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_205_6 = new TagInfo("c:when", //$NON-NLS-1$
            205, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_207_6 = new TagInfo("c:when", //$NON-NLS-1$
            207, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_209_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            209, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_210_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            210, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_211_10 = new TagInfo("c:if", //$NON-NLS-1$
            211, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_220_2 = new TagInfo("c:if", //$NON-NLS-1$
            220, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_221_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            221, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_222_5 = new TagInfo("c:choose", //$NON-NLS-1$
            222, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_223_6 = new TagInfo("c:when", //$NON-NLS-1$
            223, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_225_6 = new TagInfo("c:when", //$NON-NLS-1$
            225, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_227_6 = new TagInfo("c:when", //$NON-NLS-1$
            227, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_229_6 = new TagInfo("c:when", //$NON-NLS-1$
            229, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_231_6 = new TagInfo("c:when", //$NON-NLS-1$
            231, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_233_6 = new TagInfo("c:when", //$NON-NLS-1$
            233, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_235_6 = new TagInfo("c:when", //$NON-NLS-1$
            235, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_237_6 = new TagInfo("c:when", //$NON-NLS-1$
            237, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_239_6 = new TagInfo("c:when", //$NON-NLS-1$
            239, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_241_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            241, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_242_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            242, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_243_10 = new TagInfo("c:if", //$NON-NLS-1$
            243, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_252_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            252, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_253_5 = new TagInfo("c:choose", //$NON-NLS-1$
            253, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_254_6 = new TagInfo("c:when", //$NON-NLS-1$
            254, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_256_6 = new TagInfo("c:when", //$NON-NLS-1$
            256, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_258_6 = new TagInfo("c:when", //$NON-NLS-1$
            258, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_260_6 = new TagInfo("c:when", //$NON-NLS-1$
            260, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_262_6 = new TagInfo("c:when", //$NON-NLS-1$
            262, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_264_6 = new TagInfo("c:when", //$NON-NLS-1$
            264, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_266_6 = new TagInfo("c:when", //$NON-NLS-1$
            266, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_268_6 = new TagInfo("c:when", //$NON-NLS-1$
            268, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_270_6 = new TagInfo("c:when", //$NON-NLS-1$
            270, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_272_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            272, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_273_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            273, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_274_10 = new TagInfo("c:if", //$NON-NLS-1$
            274, 10,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_283_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            283, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_284_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            284, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_285_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            285, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_286_7 = new TagInfo("c:setVariable", //$NON-NLS-1$
            286, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_288_9 = new TagInfo("c:if", //$NON-NLS-1$
            288, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_290_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            290, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_291_15 = new TagInfo("c:setVariable", //$NON-NLS-1$
            291, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_293_17 = new TagInfo("c:if", //$NON-NLS-1$
            293, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_295_18 = new TagInfo("c:iterate", //$NON-NLS-1$
            295, 18,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_296_19 = new TagInfo("c:if", //$NON-NLS-1$
            296, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_299_19 = new TagInfo("c:if", //$NON-NLS-1$
            299, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_300_21 = new TagInfo("c:if", //$NON-NLS-1$
            300, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_302_18 = new TagInfo("c:if", //$NON-NLS-1$
            302, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end2/@aggregation = 'composite')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_316_1 = new TagInfo("f:message", //$NON-NLS-1$
            316, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_321_1 = new TagInfo("f:message", //$NON-NLS-1$
            321, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_327_1 = new TagInfo("f:message", //$NON-NLS-1$
            327, 1,
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
                RuntimeTagElement _jettag_c_setVariable_6_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_6_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_6_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_setVariable_6_1.setTagInfo(_td_c_setVariable_6_1);
                _jettag_c_setVariable_6_1.doStart(context, out);
                _jettag_c_setVariable_6_1.doEnd();
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 7, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 7, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 7, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$webPackage}", 8, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 8, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.DockPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.ReadComposite;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.utils.Alignment;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.fields.DataType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.OptionsComposite.OptionsCompositeType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.DockPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_16_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_16_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_16_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_16_1.setTagInfo(_td_f_message_16_1);
                _jettag_f_message_16_1.doStart(context, out);
                JET2Writer _jettag_f_message_16_1_saved_out = out;
                while (_jettag_f_message_16_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_16_1.handleBodyContent(out);
                }
                out = _jettag_f_message_16_1_saved_out;
                _jettag_f_message_16_1.doEnd();
                out.write(NL);         
                out.write("public class Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 17, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel extends ReadComposite<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 17, 61)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> {");  //$NON-NLS-1$        
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
                out.write("private static Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 19, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 19, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel;");  //$NON-NLS-1$        
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
                out.write("\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 21, 2)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("OptionsPanel options = new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 21, 44)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("OptionsPanel(OptionsCompositeType.CRUD);");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_22_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_22_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_22_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_22_1.setTagInfo(_td_f_message_22_1);
                _jettag_f_message_22_1.doStart(context, out);
                JET2Writer _jettag_f_message_22_1_saved_out = out;
                while (_jettag_f_message_22_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_22_1.handleBodyContent(out);
                }
                out = _jettag_f_message_22_1_saved_out;
                _jettag_f_message_22_1.doEnd();
                out.write(NL);         
                out.write("\tpublic static Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 23, 20)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel instance() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 24, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_26_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_26_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_26_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_26_1.setTagInfo(_td_f_message_26_1);
                _jettag_f_message_26_1.doStart(context, out);
                JET2Writer _jettag_f_message_26_1_saved_out = out;
                while (_jettag_f_message_26_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_26_1.handleBodyContent(out);
                }
                out = _jettag_f_message_26_1_saved_out;
                _jettag_f_message_26_1.doEnd();
                out.write(NL);         
                out.write("\tpublic Read");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 27, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel(Long id) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tread");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 28, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Panel = this;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitReadComposite(id, ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 29, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class.getName(), ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 29, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.constants);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_31_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_31_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_31_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_31_1.setTagInfo(_td_f_message_31_1);
                _jettag_f_message_31_1.doStart(context, out);
                JET2Writer _jettag_f_message_31_1_saved_out = out;
                while (_jettag_f_message_31_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_31_1.handleBodyContent(out);
                }
                out = _jettag_f_message_31_1_saved_out;
                _jettag_f_message_31_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void readData(Long id) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$packageName}", 34, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 34, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 34, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Service.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 34, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("ServiceAsync.instance().read(id,");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\tnew ALAsyncCallback<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 35, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(">() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\tpublic void onResponse(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 37, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 37, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(") {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t\t\tentity = ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 38, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_40_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_40_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_40_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_40_4.setTagInfo(_td_c_if_40_4);
                _jettag_c_if_40_4.doStart(context, out);
                while (_jettag_c_if_40_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_41_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_41_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_41_4.setRuntimeParent(_jettag_c_if_40_4);
                    _jettag_c_iterate_41_4.setTagInfo(_td_c_iterate_41_4);
                    _jettag_c_iterate_41_4.doStart(context, out);
                    while (_jettag_c_iterate_41_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_42_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_42_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_42_5.setRuntimeParent(_jettag_c_iterate_41_4);
                        _jettag_c_choose_42_5.setTagInfo(_td_c_choose_42_5);
                        _jettag_c_choose_42_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_42_5_saved_out = out;
                        while (_jettag_c_choose_42_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_43_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_43_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_43_6.setRuntimeParent(_jettag_c_choose_42_5);
                            _jettag_c_when_43_6.setTagInfo(_td_c_when_43_6);
                            _jettag_c_when_43_6.doStart(context, out);
                            JET2Writer _jettag_c_when_43_6_saved_out = out;
                            while (_jettag_c_when_43_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 43, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 43, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 43, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_43_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_43_6_saved_out;
                            _jettag_c_when_43_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_45_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_45_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_45_6.setRuntimeParent(_jettag_c_choose_42_5);
                            _jettag_c_when_45_6.setTagInfo(_td_c_when_45_6);
                            _jettag_c_when_45_6.doStart(context, out);
                            JET2Writer _jettag_c_when_45_6_saved_out = out;
                            while (_jettag_c_when_45_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 45, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 45, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 45, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_45_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_45_6_saved_out;
                            _jettag_c_when_45_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_47_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_47_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_47_6.setRuntimeParent(_jettag_c_choose_42_5);
                            _jettag_c_when_47_6.setTagInfo(_td_c_when_47_6);
                            _jettag_c_when_47_6.doStart(context, out);
                            JET2Writer _jettag_c_when_47_6_saved_out = out;
                            while (_jettag_c_when_47_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 47, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 47, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 47, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_47_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_47_6_saved_out;
                            _jettag_c_when_47_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_49_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_49_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_49_6.setRuntimeParent(_jettag_c_choose_42_5);
                            _jettag_c_when_49_6.setTagInfo(_td_c_when_49_6);
                            _jettag_c_when_49_6.doStart(context, out);
                            JET2Writer _jettag_c_when_49_6_saved_out = out;
                            while (_jettag_c_when_49_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 49, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 49, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 49, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_49_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_49_6_saved_out;
                            _jettag_c_when_49_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_51_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_51_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_51_6.setRuntimeParent(_jettag_c_choose_42_5);
                            _jettag_c_when_51_6.setTagInfo(_td_c_when_51_6);
                            _jettag_c_when_51_6.doStart(context, out);
                            JET2Writer _jettag_c_when_51_6_saved_out = out;
                            while (_jettag_c_when_51_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 51, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 51, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 51, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_51_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_51_6_saved_out;
                            _jettag_c_when_51_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_53_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_53_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_53_6.setRuntimeParent(_jettag_c_choose_42_5);
                            _jettag_c_when_53_6.setTagInfo(_td_c_when_53_6);
                            _jettag_c_when_53_6.doStart(context, out);
                            JET2Writer _jettag_c_when_53_6_saved_out = out;
                            while (_jettag_c_when_53_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 53, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 53, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 53, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_53_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_53_6_saved_out;
                            _jettag_c_when_53_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_55_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_55_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_55_6.setRuntimeParent(_jettag_c_choose_42_5);
                            _jettag_c_when_55_6.setTagInfo(_td_c_when_55_6);
                            _jettag_c_when_55_6.doStart(context, out);
                            JET2Writer _jettag_c_when_55_6_saved_out = out;
                            while (_jettag_c_when_55_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 55, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 55, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 55, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),true); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_55_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_55_6_saved_out;
                            _jettag_c_when_55_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_57_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_57_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_57_6.setRuntimeParent(_jettag_c_choose_42_5);
                            _jettag_c_when_57_6.setTagInfo(_td_c_when_57_6);
                            _jettag_c_when_57_6.doStart(context, out);
                            JET2Writer _jettag_c_when_57_6_saved_out = out;
                            while (_jettag_c_when_57_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 57, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 57, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Welcome.constants");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\t\t\t\t\t.imagesTargetDirectory() + ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 58, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 58, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),400,400); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_57_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_57_6_saved_out;
                            _jettag_c_when_57_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_60_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_60_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_60_6.setRuntimeParent(_jettag_c_choose_42_5);
                            _jettag_c_when_60_6.setTagInfo(_td_c_when_60_6);
                            _jettag_c_when_60_6.doStart(context, out);
                            JET2Writer _jettag_c_when_60_6_saved_out = out;
                            while (_jettag_c_when_60_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" setRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 60, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 60, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 60, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_60_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_60_6_saved_out;
                            _jettag_c_when_60_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_62_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_62_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_62_7.setRuntimeParent(_jettag_c_choose_42_5);
                            _jettag_c_otherwise_62_7.setTagInfo(_td_c_otherwise_62_7);
                            _jettag_c_otherwise_62_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_62_7_saved_out = out;
                            while (_jettag_c_otherwise_62_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_63_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_63_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_63_8.setRuntimeParent(_jettag_c_otherwise_62_7);
                                _jettag_c_iterate_63_8.setTagInfo(_td_c_iterate_63_8);
                                _jettag_c_iterate_63_8.doStart(context, out);
                                while (_jettag_c_iterate_63_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_64_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_64_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_64_10.setRuntimeParent(_jettag_c_iterate_63_8);
                                    _jettag_c_if_64_10.setTagInfo(_td_c_if_64_10);
                                    _jettag_c_if_64_10.doStart(context, out);
                                    while (_jettag_c_if_64_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tsetEnumFeild(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 65, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 65, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".get");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 65, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("().toString());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_64_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_64_10.doEnd();
                                    _jettag_c_iterate_63_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_63_8.doEnd();
                                _jettag_c_otherwise_62_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_62_7_saved_out;
                            _jettag_c_otherwise_62_7.doEnd();
                            _jettag_c_choose_42_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_42_5_saved_out;
                        _jettag_c_choose_42_5.doEnd();
                        _jettag_c_iterate_41_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_41_4.doEnd();
                    _jettag_c_if_40_4.handleBodyContent(out);
                }
                _jettag_c_if_40_4.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_73_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_73_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_73_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_73_4.setTagInfo(_td_c_if_73_4);
                _jettag_c_if_73_4.doStart(context, out);
                while (_jettag_c_if_73_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_74_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_74_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_74_4.setRuntimeParent(_jettag_c_if_73_4);
                    _jettag_c_iterate_74_4.setTagInfo(_td_c_iterate_74_4);
                    _jettag_c_iterate_74_4.doStart(context, out);
                    while (_jettag_c_iterate_74_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_75_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_75_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_75_5.setRuntimeParent(_jettag_c_iterate_74_4);
                        _jettag_c_choose_75_5.setTagInfo(_td_c_choose_75_5);
                        _jettag_c_choose_75_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_75_5_saved_out = out;
                        while (_jettag_c_choose_75_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_76_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_76_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_76_6.setRuntimeParent(_jettag_c_choose_75_5);
                            _jettag_c_when_76_6.setTagInfo(_td_c_when_76_6);
                            _jettag_c_when_76_6.doStart(context, out);
                            JET2Writer _jettag_c_when_76_6_saved_out = out;
                            while (_jettag_c_when_76_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 76, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 76, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 76, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_76_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_76_6_saved_out;
                            _jettag_c_when_76_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_78_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_78_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_78_6.setRuntimeParent(_jettag_c_choose_75_5);
                            _jettag_c_when_78_6.setTagInfo(_td_c_when_78_6);
                            _jettag_c_when_78_6.doStart(context, out);
                            JET2Writer _jettag_c_when_78_6_saved_out = out;
                            while (_jettag_c_when_78_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 78, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 78, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 78, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_78_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_78_6_saved_out;
                            _jettag_c_when_78_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_80_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_80_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_80_6.setRuntimeParent(_jettag_c_choose_75_5);
                            _jettag_c_when_80_6.setTagInfo(_td_c_when_80_6);
                            _jettag_c_when_80_6.doStart(context, out);
                            JET2Writer _jettag_c_when_80_6_saved_out = out;
                            while (_jettag_c_when_80_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 80, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 80, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 80, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_80_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_80_6_saved_out;
                            _jettag_c_when_80_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_82_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_82_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_82_6.setRuntimeParent(_jettag_c_choose_75_5);
                            _jettag_c_when_82_6.setTagInfo(_td_c_when_82_6);
                            _jettag_c_when_82_6.doStart(context, out);
                            JET2Writer _jettag_c_when_82_6_saved_out = out;
                            while (_jettag_c_when_82_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 82, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 82, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 82, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_82_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_82_6_saved_out;
                            _jettag_c_when_82_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_84_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_84_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_84_6.setRuntimeParent(_jettag_c_choose_75_5);
                            _jettag_c_when_84_6.setTagInfo(_td_c_when_84_6);
                            _jettag_c_when_84_6.doStart(context, out);
                            JET2Writer _jettag_c_when_84_6_saved_out = out;
                            while (_jettag_c_when_84_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 84, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 84, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 84, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_84_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_84_6_saved_out;
                            _jettag_c_when_84_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_86_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_86_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_86_6.setRuntimeParent(_jettag_c_choose_75_5);
                            _jettag_c_when_86_6.setTagInfo(_td_c_when_86_6);
                            _jettag_c_when_86_6.doStart(context, out);
                            JET2Writer _jettag_c_when_86_6_saved_out = out;
                            while (_jettag_c_when_86_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 86, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 86, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 86, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_86_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_86_6_saved_out;
                            _jettag_c_when_86_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_88_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_88_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_88_6.setRuntimeParent(_jettag_c_choose_75_5);
                            _jettag_c_when_88_6.setTagInfo(_td_c_when_88_6);
                            _jettag_c_when_88_6.doStart(context, out);
                            JET2Writer _jettag_c_when_88_6_saved_out = out;
                            while (_jettag_c_when_88_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 88, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 88, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 88, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),true); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_88_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_88_6_saved_out;
                            _jettag_c_when_88_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_90_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_90_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_90_6.setRuntimeParent(_jettag_c_choose_75_5);
                            _jettag_c_when_90_6.setTagInfo(_td_c_when_90_6);
                            _jettag_c_when_90_6.doStart(context, out);
                            JET2Writer _jettag_c_when_90_6_saved_out = out;
                            while (_jettag_c_when_90_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("  setImageField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 90, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 90, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("Welcome.constants");  //$NON-NLS-1$        
                                out.write(NL);         
                                out.write("\t\t\t\t\t\t\t\t.imagesTargetDirectory() + ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 91, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 91, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(),400,400); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_90_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_90_6_saved_out;
                            _jettag_c_when_90_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_93_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_93_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_93_6.setRuntimeParent(_jettag_c_choose_75_5);
                            _jettag_c_when_93_6.setTagInfo(_td_c_when_93_6);
                            _jettag_c_when_93_6.doStart(context, out);
                            JET2Writer _jettag_c_when_93_6_saved_out = out;
                            while (_jettag_c_when_93_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" setRichTextField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 93, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\",");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 93, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".get");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 93, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_93_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_93_6_saved_out;
                            _jettag_c_when_93_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_95_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_95_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_95_7.setRuntimeParent(_jettag_c_choose_75_5);
                            _jettag_c_otherwise_95_7.setTagInfo(_td_c_otherwise_95_7);
                            _jettag_c_otherwise_95_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_95_7_saved_out = out;
                            while (_jettag_c_otherwise_95_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_96_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_96_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_96_8.setRuntimeParent(_jettag_c_otherwise_95_7);
                                _jettag_c_iterate_96_8.setTagInfo(_td_c_iterate_96_8);
                                _jettag_c_iterate_96_8.doStart(context, out);
                                while (_jettag_c_iterate_96_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_97_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_97_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_97_10.setRuntimeParent(_jettag_c_iterate_96_8);
                                    _jettag_c_if_97_10.setTagInfo(_td_c_if_97_10);
                                    _jettag_c_if_97_10.doStart(context, out);
                                    while (_jettag_c_if_97_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\tsetEnumFeild(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 98, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 98, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".get");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 98, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("().toString());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_97_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_97_10.doEnd();
                                    _jettag_c_iterate_96_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_96_8.doEnd();
                                _jettag_c_otherwise_95_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_95_7_saved_out;
                            _jettag_c_otherwise_95_7.doEnd();
                            _jettag_c_choose_75_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_75_5_saved_out;
                        _jettag_c_choose_75_5.doEnd();
                        _jettag_c_iterate_74_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_74_4.doEnd();
                    _jettag_c_if_73_4.handleBodyContent(out);
                }
                _jettag_c_if_73_4.doEnd();
                // process base class
                RuntimeTagElement _jettag_c_iterate_106_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_106_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_106_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_106_4.setTagInfo(_td_c_iterate_106_4);
                _jettag_c_iterate_106_4.doStart(context, out);
                while (_jettag_c_iterate_106_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_107_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_107_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_107_5.setRuntimeParent(_jettag_c_iterate_106_4);
                    _jettag_c_choose_107_5.setTagInfo(_td_c_choose_107_5);
                    _jettag_c_choose_107_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_107_5_saved_out = out;
                    while (_jettag_c_choose_107_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_108_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_108_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_108_6.setRuntimeParent(_jettag_c_choose_107_5);
                        _jettag_c_when_108_6.setTagInfo(_td_c_when_108_6);
                        _jettag_c_when_108_6.doStart(context, out);
                        JET2Writer _jettag_c_when_108_6_saved_out = out;
                        while (_jettag_c_when_108_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 108, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 108, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 108, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_108_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_108_6_saved_out;
                        _jettag_c_when_108_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_110_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_110_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_110_6.setRuntimeParent(_jettag_c_choose_107_5);
                        _jettag_c_when_110_6.setTagInfo(_td_c_when_110_6);
                        _jettag_c_when_110_6.doStart(context, out);
                        JET2Writer _jettag_c_when_110_6_saved_out = out;
                        while (_jettag_c_when_110_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 110, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 110, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 110, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_110_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_110_6_saved_out;
                        _jettag_c_when_110_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_112_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_112_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_112_6.setRuntimeParent(_jettag_c_choose_107_5);
                        _jettag_c_when_112_6.setTagInfo(_td_c_when_112_6);
                        _jettag_c_when_112_6.doStart(context, out);
                        JET2Writer _jettag_c_when_112_6_saved_out = out;
                        while (_jettag_c_when_112_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 112, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 112, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 112, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_112_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_112_6_saved_out;
                        _jettag_c_when_112_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_114_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_114_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_114_6.setRuntimeParent(_jettag_c_choose_107_5);
                        _jettag_c_when_114_6.setTagInfo(_td_c_when_114_6);
                        _jettag_c_when_114_6.doStart(context, out);
                        JET2Writer _jettag_c_when_114_6_saved_out = out;
                        while (_jettag_c_when_114_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 114, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 114, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 114, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_114_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_114_6_saved_out;
                        _jettag_c_when_114_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_116_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_116_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_116_6.setRuntimeParent(_jettag_c_choose_107_5);
                        _jettag_c_when_116_6.setTagInfo(_td_c_when_116_6);
                        _jettag_c_when_116_6.doStart(context, out);
                        JET2Writer _jettag_c_when_116_6_saved_out = out;
                        while (_jettag_c_when_116_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 116, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 116, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 116, 99)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_116_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_116_6_saved_out;
                        _jettag_c_when_116_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_118_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_118_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_118_6.setRuntimeParent(_jettag_c_choose_107_5);
                        _jettag_c_when_118_6.setTagInfo(_td_c_when_118_6);
                        _jettag_c_when_118_6.doStart(context, out);
                        JET2Writer _jettag_c_when_118_6_saved_out = out;
                        while (_jettag_c_when_118_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 118, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 118, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 118, 100)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_118_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_118_6_saved_out;
                        _jettag_c_when_118_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_120_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_120_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_120_6.setRuntimeParent(_jettag_c_choose_107_5);
                        _jettag_c_when_120_6.setTagInfo(_td_c_when_120_6);
                        _jettag_c_when_120_6.doStart(context, out);
                        JET2Writer _jettag_c_when_120_6_saved_out = out;
                        while (_jettag_c_when_120_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 120, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 120, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 120, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(),true); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_120_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_120_6_saved_out;
                        _jettag_c_when_120_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_122_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_122_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_122_6.setRuntimeParent(_jettag_c_choose_107_5);
                        _jettag_c_when_122_6.setTagInfo(_td_c_when_122_6);
                        _jettag_c_when_122_6.doStart(context, out);
                        JET2Writer _jettag_c_when_122_6_saved_out = out;
                        while (_jettag_c_when_122_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  setImageField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 122, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 122, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("Welcome.constants");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t.imagesTargetDirectory() + ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 123, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 123, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(),400,400); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_122_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_122_6_saved_out;
                        _jettag_c_when_122_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_125_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_125_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_125_6.setRuntimeParent(_jettag_c_choose_107_5);
                        _jettag_c_when_125_6.setTagInfo(_td_c_when_125_6);
                        _jettag_c_when_125_6.doStart(context, out);
                        JET2Writer _jettag_c_when_125_6_saved_out = out;
                        while (_jettag_c_when_125_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" setRichTextField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 125, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 125, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 125, 110)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_125_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_125_6_saved_out;
                        _jettag_c_when_125_6.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_127_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_127_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_127_7.setRuntimeParent(_jettag_c_choose_107_5);
                        _jettag_c_otherwise_127_7.setTagInfo(_td_c_otherwise_127_7);
                        _jettag_c_otherwise_127_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_127_7_saved_out = out;
                        while (_jettag_c_otherwise_127_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_128_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_128_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_128_8.setRuntimeParent(_jettag_c_otherwise_127_7);
                            _jettag_c_iterate_128_8.setTagInfo(_td_c_iterate_128_8);
                            _jettag_c_iterate_128_8.doStart(context, out);
                            while (_jettag_c_iterate_128_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_129_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_129_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_129_10.setRuntimeParent(_jettag_c_iterate_128_8);
                                _jettag_c_if_129_10.setTagInfo(_td_c_if_129_10);
                                _jettag_c_if_129_10.doStart(context, out);
                                while (_jettag_c_if_129_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\tsetEnumFeild(\"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 130, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 130, 45)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".get");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 130, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("().toString());");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_129_10.handleBodyContent(out);
                                }
                                _jettag_c_if_129_10.doEnd();
                                _jettag_c_iterate_128_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_128_8.doEnd();
                            _jettag_c_otherwise_127_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_127_7_saved_out;
                        _jettag_c_otherwise_127_7.doEnd();
                        _jettag_c_choose_107_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_107_5_saved_out;
                    _jettag_c_choose_107_5.doEnd();
                    _jettag_c_iterate_106_4.handleBodyContent(out);
                }
                _jettag_c_iterate_106_4.doEnd();
                // process dropdowns one to one and many to one unidirectional
                RuntimeTagElement _jettag_c_iterate_137_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_137_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_137_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_137_4.setTagInfo(_td_c_iterate_137_4);
                _jettag_c_iterate_137_4.doStart(context, out);
                while (_jettag_c_iterate_137_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_138_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_138_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_138_5.setRuntimeParent(_jettag_c_iterate_137_4);
                    _jettag_c_iterate_138_5.setTagInfo(_td_c_iterate_138_5);
                    _jettag_c_iterate_138_5.doStart(context, out);
                    while (_jettag_c_iterate_138_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_139_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_139_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_139_6.setRuntimeParent(_jettag_c_iterate_138_5);
                        _jettag_c_iterate_139_6.setTagInfo(_td_c_iterate_139_6);
                        _jettag_c_iterate_139_6.doStart(context, out);
                        while (_jettag_c_iterate_139_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_140_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_140_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_140_7.setRuntimeParent(_jettag_c_iterate_139_6);
                            _jettag_c_setVariable_140_7.setTagInfo(_td_c_setVariable_140_7);
                            _jettag_c_setVariable_140_7.doStart(context, out);
                            _jettag_c_setVariable_140_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_142_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_142_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_142_9.setRuntimeParent(_jettag_c_iterate_139_6);
                            _jettag_c_if_142_9.setTagInfo(_td_c_if_142_9);
                            _jettag_c_if_142_9.doStart(context, out);
                            while (_jettag_c_if_142_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_144_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_144_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_144_15.setRuntimeParent(_jettag_c_if_142_9);
                                _jettag_c_iterate_144_15.setTagInfo(_td_c_iterate_144_15);
                                _jettag_c_iterate_144_15.doStart(context, out);
                                while (_jettag_c_iterate_144_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_145_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_145_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_145_15.setRuntimeParent(_jettag_c_iterate_144_15);
                                    _jettag_c_setVariable_145_15.setTagInfo(_td_c_setVariable_145_15);
                                    _jettag_c_setVariable_145_15.doStart(context, out);
                                    _jettag_c_setVariable_145_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_147_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_147_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_147_17.setRuntimeParent(_jettag_c_iterate_144_15);
                                    _jettag_c_if_147_17.setTagInfo(_td_c_if_147_17);
                                    _jettag_c_if_147_17.doStart(context, out);
                                    while (_jettag_c_if_147_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_149_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_149_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_149_18.setRuntimeParent(_jettag_c_if_147_17);
                                        _jettag_c_iterate_149_18.setTagInfo(_td_c_iterate_149_18);
                                        _jettag_c_iterate_149_18.doStart(context, out);
                                        while (_jettag_c_iterate_149_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_150_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_150_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_150_19.setRuntimeParent(_jettag_c_iterate_149_18);
                                            _jettag_c_if_150_19.setTagInfo(_td_c_if_150_19);
                                            _jettag_c_if_150_19.doStart(context, out);
                                            while (_jettag_c_if_150_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_153_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_153_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_153_19.setRuntimeParent(_jettag_c_if_150_19);
                                                _jettag_c_if_153_19.setTagInfo(_td_c_if_153_19);
                                                _jettag_c_if_153_19.doStart(context, out);
                                                while (_jettag_c_if_153_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_154_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_154_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_154_21.setRuntimeParent(_jettag_c_if_153_19);
                                                    _jettag_c_if_154_21.setTagInfo(_td_c_if_154_21);
                                                    _jettag_c_if_154_21.doStart(context, out);
                                                    while (_jettag_c_if_154_21.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_156_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_156_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_156_18.setRuntimeParent(_jettag_c_if_154_21);
                                                        _jettag_c_if_156_18.setTagInfo(_td_c_if_156_18);
                                                        _jettag_c_if_156_18.doStart(context, out);
                                                        while (_jettag_c_if_156_18.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\tsetDropDownField(\"");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 157, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("\", ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 157, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 157, 102)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("());");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_156_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_156_18.doEnd();
                                                        _jettag_c_if_154_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_154_21.doEnd();
                                                    _jettag_c_if_153_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_153_19.doEnd();
                                                _jettag_c_if_150_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_150_19.doEnd();
                                            _jettag_c_iterate_149_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_149_18.doEnd();
                                        _jettag_c_if_147_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_147_17.doEnd();
                                    _jettag_c_iterate_144_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_144_15.doEnd();
                                _jettag_c_if_142_9.handleBodyContent(out);
                            }
                            _jettag_c_if_142_9.doEnd();
                            _jettag_c_iterate_139_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_139_6.doEnd();
                        _jettag_c_iterate_138_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_138_5.doEnd();
                    _jettag_c_iterate_137_4.handleBodyContent(out);
                }
                _jettag_c_iterate_137_4.doEnd();
                out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t});");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_172_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_172_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_172_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_172_1.setTagInfo(_td_f_message_172_1);
                _jettag_f_message_172_1.doStart(context, out);
                JET2Writer _jettag_f_message_172_1_saved_out = out;
                while (_jettag_f_message_172_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_172_1.handleBodyContent(out);
                }
                out = _jettag_f_message_172_1_saved_out;
                _jettag_f_message_172_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_178_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_178_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_178_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_178_1.setTagInfo(_td_f_message_178_1);
                _jettag_f_message_178_1.doStart(context, out);
                JET2Writer _jettag_f_message_178_1_saved_out = out;
                while (_jettag_f_message_178_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_178_1.handleBodyContent(out);
                }
                out = _jettag_f_message_178_1_saved_out;
                _jettag_f_message_178_1.doEnd();
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
                out.write("\tprotected void addWidgets() {");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_188_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_188_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_188_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_188_2.setTagInfo(_td_c_if_188_2);
                _jettag_c_if_188_2.doStart(context, out);
                while (_jettag_c_if_188_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_189_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_189_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_189_5.setRuntimeParent(_jettag_c_if_188_2);
                    _jettag_c_iterate_189_5.setTagInfo(_td_c_iterate_189_5);
                    _jettag_c_iterate_189_5.doStart(context, out);
                    while (_jettag_c_iterate_189_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_190_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_190_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_190_5.setRuntimeParent(_jettag_c_iterate_189_5);
                        _jettag_c_choose_190_5.setTagInfo(_td_c_choose_190_5);
                        _jettag_c_choose_190_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_190_5_saved_out = out;
                        while (_jettag_c_choose_190_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_191_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_191_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_191_6.setRuntimeParent(_jettag_c_choose_190_5);
                            _jettag_c_when_191_6.setTagInfo(_td_c_when_191_6);
                            _jettag_c_when_191_6.doStart(context, out);
                            JET2Writer _jettag_c_when_191_6_saved_out = out;
                            while (_jettag_c_when_191_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 191, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 191, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_191_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_191_6_saved_out;
                            _jettag_c_when_191_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_193_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_193_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_193_6.setRuntimeParent(_jettag_c_choose_190_5);
                            _jettag_c_when_193_6.setTagInfo(_td_c_when_193_6);
                            _jettag_c_when_193_6.doStart(context, out);
                            JET2Writer _jettag_c_when_193_6_saved_out = out;
                            while (_jettag_c_when_193_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 193, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 193, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_193_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_193_6_saved_out;
                            _jettag_c_when_193_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_195_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_195_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_195_6.setRuntimeParent(_jettag_c_choose_190_5);
                            _jettag_c_when_195_6.setTagInfo(_td_c_when_195_6);
                            _jettag_c_when_195_6.doStart(context, out);
                            JET2Writer _jettag_c_when_195_6_saved_out = out;
                            while (_jettag_c_when_195_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 195, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 195, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_195_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_195_6_saved_out;
                            _jettag_c_when_195_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_197_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_197_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_197_6.setRuntimeParent(_jettag_c_choose_190_5);
                            _jettag_c_when_197_6.setTagInfo(_td_c_when_197_6);
                            _jettag_c_when_197_6.doStart(context, out);
                            JET2Writer _jettag_c_when_197_6_saved_out = out;
                            while (_jettag_c_when_197_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 197, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 197, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_197_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_197_6_saved_out;
                            _jettag_c_when_197_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_199_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_199_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_199_6.setRuntimeParent(_jettag_c_choose_190_5);
                            _jettag_c_when_199_6.setTagInfo(_td_c_when_199_6);
                            _jettag_c_when_199_6.doStart(context, out);
                            JET2Writer _jettag_c_when_199_6_saved_out = out;
                            while (_jettag_c_when_199_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 199, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 199, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_199_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_199_6_saved_out;
                            _jettag_c_when_199_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_201_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_201_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_201_6.setRuntimeParent(_jettag_c_choose_190_5);
                            _jettag_c_when_201_6.setTagInfo(_td_c_when_201_6);
                            _jettag_c_when_201_6.doStart(context, out);
                            JET2Writer _jettag_c_when_201_6_saved_out = out;
                            while (_jettag_c_when_201_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 201, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 201, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_201_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_201_6_saved_out;
                            _jettag_c_when_201_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_203_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_203_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_203_6.setRuntimeParent(_jettag_c_choose_190_5);
                            _jettag_c_when_203_6.setTagInfo(_td_c_when_203_6);
                            _jettag_c_when_203_6.doStart(context, out);
                            JET2Writer _jettag_c_when_203_6_saved_out = out;
                            while (_jettag_c_when_203_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 203, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 203, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_203_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_203_6_saved_out;
                            _jettag_c_when_203_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_205_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_205_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_205_6.setRuntimeParent(_jettag_c_choose_190_5);
                            _jettag_c_when_205_6.setTagInfo(_td_c_when_205_6);
                            _jettag_c_when_205_6.doStart(context, out);
                            JET2Writer _jettag_c_when_205_6_saved_out = out;
                            while (_jettag_c_when_205_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 205, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 205, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_205_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_205_6_saved_out;
                            _jettag_c_when_205_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_207_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_207_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_207_6.setRuntimeParent(_jettag_c_choose_190_5);
                            _jettag_c_when_207_6.setTagInfo(_td_c_when_207_6);
                            _jettag_c_when_207_6.doStart(context, out);
                            JET2Writer _jettag_c_when_207_6_saved_out = out;
                            while (_jettag_c_when_207_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 207, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 207, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_207_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_207_6_saved_out;
                            _jettag_c_when_207_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_209_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_209_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_209_7.setRuntimeParent(_jettag_c_choose_190_5);
                            _jettag_c_otherwise_209_7.setTagInfo(_td_c_otherwise_209_7);
                            _jettag_c_otherwise_209_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_209_7_saved_out = out;
                            while (_jettag_c_otherwise_209_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_210_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_210_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_210_8.setRuntimeParent(_jettag_c_otherwise_209_7);
                                _jettag_c_iterate_210_8.setTagInfo(_td_c_iterate_210_8);
                                _jettag_c_iterate_210_8.doStart(context, out);
                                while (_jettag_c_iterate_210_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_211_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_211_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_211_10.setRuntimeParent(_jettag_c_iterate_210_8);
                                    _jettag_c_if_211_10.setTagInfo(_td_c_if_211_10);
                                    _jettag_c_if_211_10.doStart(context, out);
                                    while (_jettag_c_if_211_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 212, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", true, ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 212, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(", \"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 212, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 212, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".class.getName());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_211_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_211_10.doEnd();
                                    _jettag_c_iterate_210_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_210_8.doEnd();
                                _jettag_c_otherwise_209_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_209_7_saved_out;
                            _jettag_c_otherwise_209_7.doEnd();
                            _jettag_c_choose_190_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_190_5_saved_out;
                        _jettag_c_choose_190_5.doEnd();
                        _jettag_c_iterate_189_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_189_5.doEnd();
                    _jettag_c_if_188_2.handleBodyContent(out);
                }
                _jettag_c_if_188_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_220_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_220_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_220_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_220_2.setTagInfo(_td_c_if_220_2);
                _jettag_c_if_220_2.doStart(context, out);
                while (_jettag_c_if_220_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_221_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_221_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_221_5.setRuntimeParent(_jettag_c_if_220_2);
                    _jettag_c_iterate_221_5.setTagInfo(_td_c_iterate_221_5);
                    _jettag_c_iterate_221_5.doStart(context, out);
                    while (_jettag_c_iterate_221_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_222_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_222_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_222_5.setRuntimeParent(_jettag_c_iterate_221_5);
                        _jettag_c_choose_222_5.setTagInfo(_td_c_choose_222_5);
                        _jettag_c_choose_222_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_222_5_saved_out = out;
                        while (_jettag_c_choose_222_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_223_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_223_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_223_6.setRuntimeParent(_jettag_c_choose_222_5);
                            _jettag_c_when_223_6.setTagInfo(_td_c_when_223_6);
                            _jettag_c_when_223_6.doStart(context, out);
                            JET2Writer _jettag_c_when_223_6_saved_out = out;
                            while (_jettag_c_when_223_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 223, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 223, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_223_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_223_6_saved_out;
                            _jettag_c_when_223_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_225_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_225_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_225_6.setRuntimeParent(_jettag_c_choose_222_5);
                            _jettag_c_when_225_6.setTagInfo(_td_c_when_225_6);
                            _jettag_c_when_225_6.doStart(context, out);
                            JET2Writer _jettag_c_when_225_6_saved_out = out;
                            while (_jettag_c_when_225_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 225, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 225, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_225_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_225_6_saved_out;
                            _jettag_c_when_225_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_227_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_227_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_227_6.setRuntimeParent(_jettag_c_choose_222_5);
                            _jettag_c_when_227_6.setTagInfo(_td_c_when_227_6);
                            _jettag_c_when_227_6.doStart(context, out);
                            JET2Writer _jettag_c_when_227_6_saved_out = out;
                            while (_jettag_c_when_227_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 227, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 227, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_227_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_227_6_saved_out;
                            _jettag_c_when_227_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_229_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_229_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_229_6.setRuntimeParent(_jettag_c_choose_222_5);
                            _jettag_c_when_229_6.setTagInfo(_td_c_when_229_6);
                            _jettag_c_when_229_6.doStart(context, out);
                            JET2Writer _jettag_c_when_229_6_saved_out = out;
                            while (_jettag_c_when_229_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 229, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 229, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_229_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_229_6_saved_out;
                            _jettag_c_when_229_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_231_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_231_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_231_6.setRuntimeParent(_jettag_c_choose_222_5);
                            _jettag_c_when_231_6.setTagInfo(_td_c_when_231_6);
                            _jettag_c_when_231_6.doStart(context, out);
                            JET2Writer _jettag_c_when_231_6_saved_out = out;
                            while (_jettag_c_when_231_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 231, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 231, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_231_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_231_6_saved_out;
                            _jettag_c_when_231_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_233_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_233_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_233_6.setRuntimeParent(_jettag_c_choose_222_5);
                            _jettag_c_when_233_6.setTagInfo(_td_c_when_233_6);
                            _jettag_c_when_233_6.doStart(context, out);
                            JET2Writer _jettag_c_when_233_6_saved_out = out;
                            while (_jettag_c_when_233_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 233, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 233, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_233_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_233_6_saved_out;
                            _jettag_c_when_233_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_235_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_235_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_235_6.setRuntimeParent(_jettag_c_choose_222_5);
                            _jettag_c_when_235_6.setTagInfo(_td_c_when_235_6);
                            _jettag_c_when_235_6.doStart(context, out);
                            JET2Writer _jettag_c_when_235_6_saved_out = out;
                            while (_jettag_c_when_235_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 235, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 235, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_235_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_235_6_saved_out;
                            _jettag_c_when_235_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_237_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_237_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_237_6.setRuntimeParent(_jettag_c_choose_222_5);
                            _jettag_c_when_237_6.setTagInfo(_td_c_when_237_6);
                            _jettag_c_when_237_6.doStart(context, out);
                            JET2Writer _jettag_c_when_237_6_saved_out = out;
                            while (_jettag_c_when_237_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 237, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 237, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_237_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_237_6_saved_out;
                            _jettag_c_when_237_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_239_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_239_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_239_6.setRuntimeParent(_jettag_c_choose_222_5);
                            _jettag_c_when_239_6.setTagInfo(_td_c_when_239_6);
                            _jettag_c_when_239_6.doStart(context, out);
                            JET2Writer _jettag_c_when_239_6_saved_out = out;
                            while (_jettag_c_when_239_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 239, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", true, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 239, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_239_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_239_6_saved_out;
                            _jettag_c_when_239_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_241_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_241_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_241_7.setRuntimeParent(_jettag_c_choose_222_5);
                            _jettag_c_otherwise_241_7.setTagInfo(_td_c_otherwise_241_7);
                            _jettag_c_otherwise_241_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_241_7_saved_out = out;
                            while (_jettag_c_otherwise_241_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_242_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_242_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_242_8.setRuntimeParent(_jettag_c_otherwise_241_7);
                                _jettag_c_iterate_242_8.setTagInfo(_td_c_iterate_242_8);
                                _jettag_c_iterate_242_8.doStart(context, out);
                                while (_jettag_c_iterate_242_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_243_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_243_10); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_243_10.setRuntimeParent(_jettag_c_iterate_242_8);
                                    _jettag_c_if_243_10.setTagInfo(_td_c_if_243_10);
                                    _jettag_c_if_243_10.doStart(context, out);
                                    while (_jettag_c_if_243_10.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 244, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", true, ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 244, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(", \"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 244, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\", ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$class/@name}", 244, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".class.getName());");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_243_10.handleBodyContent(out);
                                    }
                                    _jettag_c_if_243_10.doEnd();
                                    _jettag_c_iterate_242_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_242_8.doEnd();
                                _jettag_c_otherwise_241_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_241_7_saved_out;
                            _jettag_c_otherwise_241_7.doEnd();
                            _jettag_c_choose_222_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_222_5_saved_out;
                        _jettag_c_choose_222_5.doEnd();
                        _jettag_c_iterate_221_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_221_5.doEnd();
                    _jettag_c_if_220_2.handleBodyContent(out);
                }
                _jettag_c_if_220_2.doEnd();
                // process baseClass
                RuntimeTagElement _jettag_c_iterate_252_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_252_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_252_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_252_4.setTagInfo(_td_c_iterate_252_4);
                _jettag_c_iterate_252_4.doStart(context, out);
                while (_jettag_c_iterate_252_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_253_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_253_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_253_5.setRuntimeParent(_jettag_c_iterate_252_4);
                    _jettag_c_choose_253_5.setTagInfo(_td_c_choose_253_5);
                    _jettag_c_choose_253_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_253_5_saved_out = out;
                    while (_jettag_c_choose_253_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_254_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_254_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_254_6.setRuntimeParent(_jettag_c_choose_253_5);
                        _jettag_c_when_254_6.setTagInfo(_td_c_when_254_6);
                        _jettag_c_when_254_6.doStart(context, out);
                        JET2Writer _jettag_c_when_254_6_saved_out = out;
                        while (_jettag_c_when_254_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 254, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 254, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_254_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_254_6_saved_out;
                        _jettag_c_when_254_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_256_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_256_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_256_6.setRuntimeParent(_jettag_c_choose_253_5);
                        _jettag_c_when_256_6.setTagInfo(_td_c_when_256_6);
                        _jettag_c_when_256_6.doStart(context, out);
                        JET2Writer _jettag_c_when_256_6_saved_out = out;
                        while (_jettag_c_when_256_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 256, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 256, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_256_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_256_6_saved_out;
                        _jettag_c_when_256_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_258_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_258_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_258_6.setRuntimeParent(_jettag_c_choose_253_5);
                        _jettag_c_when_258_6.setTagInfo(_td_c_when_258_6);
                        _jettag_c_when_258_6.doStart(context, out);
                        JET2Writer _jettag_c_when_258_6_saved_out = out;
                        while (_jettag_c_when_258_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 258, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 258, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_258_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_258_6_saved_out;
                        _jettag_c_when_258_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_260_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_260_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_260_6.setRuntimeParent(_jettag_c_choose_253_5);
                        _jettag_c_when_260_6.setTagInfo(_td_c_when_260_6);
                        _jettag_c_when_260_6.doStart(context, out);
                        JET2Writer _jettag_c_when_260_6_saved_out = out;
                        while (_jettag_c_when_260_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 260, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 260, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_260_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_260_6_saved_out;
                        _jettag_c_when_260_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_262_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_262_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_262_6.setRuntimeParent(_jettag_c_choose_253_5);
                        _jettag_c_when_262_6.setTagInfo(_td_c_when_262_6);
                        _jettag_c_when_262_6.doStart(context, out);
                        JET2Writer _jettag_c_when_262_6_saved_out = out;
                        while (_jettag_c_when_262_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 262, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 262, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_262_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_262_6_saved_out;
                        _jettag_c_when_262_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_264_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_264_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_264_6.setRuntimeParent(_jettag_c_choose_253_5);
                        _jettag_c_when_264_6.setTagInfo(_td_c_when_264_6);
                        _jettag_c_when_264_6.doStart(context, out);
                        JET2Writer _jettag_c_when_264_6_saved_out = out;
                        while (_jettag_c_when_264_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 264, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 264, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_264_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_264_6_saved_out;
                        _jettag_c_when_264_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_266_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_266_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_266_6.setRuntimeParent(_jettag_c_choose_253_5);
                        _jettag_c_when_266_6.setTagInfo(_td_c_when_266_6);
                        _jettag_c_when_266_6.doStart(context, out);
                        JET2Writer _jettag_c_when_266_6_saved_out = out;
                        while (_jettag_c_when_266_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 266, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 266, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.IMAGE_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_266_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_266_6_saved_out;
                        _jettag_c_when_266_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_268_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_268_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_268_6.setRuntimeParent(_jettag_c_choose_253_5);
                        _jettag_c_when_268_6.setTagInfo(_td_c_when_268_6);
                        _jettag_c_when_268_6.doStart(context, out);
                        JET2Writer _jettag_c_when_268_6_saved_out = out;
                        while (_jettag_c_when_268_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 268, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 268, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.RICH_TEXT_AREA); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_268_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_268_6_saved_out;
                        _jettag_c_when_268_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_270_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_270_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_270_6.setRuntimeParent(_jettag_c_choose_253_5);
                        _jettag_c_when_270_6.setTagInfo(_td_c_when_270_6);
                        _jettag_c_when_270_6.doStart(context, out);
                        JET2Writer _jettag_c_when_270_6_saved_out = out;
                        while (_jettag_c_when_270_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 270, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", true, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 270, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_270_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_270_6_saved_out;
                        _jettag_c_when_270_6.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_272_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_272_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_272_7.setRuntimeParent(_jettag_c_choose_253_5);
                        _jettag_c_otherwise_272_7.setTagInfo(_td_c_otherwise_272_7);
                        _jettag_c_otherwise_272_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_272_7_saved_out = out;
                        while (_jettag_c_otherwise_272_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_273_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_273_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_273_8.setRuntimeParent(_jettag_c_otherwise_272_7);
                            _jettag_c_iterate_273_8.setTagInfo(_td_c_iterate_273_8);
                            _jettag_c_iterate_273_8.doStart(context, out);
                            while (_jettag_c_iterate_273_8.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_274_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_274_10); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_274_10.setRuntimeParent(_jettag_c_iterate_273_8);
                                _jettag_c_if_274_10.setTagInfo(_td_c_if_274_10);
                                _jettag_c_if_274_10.doStart(context, out);
                                while (_jettag_c_if_274_10.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\t\t\taddEnumField(\"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 275, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", true, ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 275, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(", \"");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 275, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write("\", ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 275, 101)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".class.getName());");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_274_10.handleBodyContent(out);
                                }
                                _jettag_c_if_274_10.doEnd();
                                _jettag_c_iterate_273_8.handleBodyContent(out);
                            }
                            _jettag_c_iterate_273_8.doEnd();
                            _jettag_c_otherwise_272_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_272_7_saved_out;
                        _jettag_c_otherwise_272_7.doEnd();
                        _jettag_c_choose_253_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_253_5_saved_out;
                    _jettag_c_choose_253_5.doEnd();
                    _jettag_c_iterate_252_4.handleBodyContent(out);
                }
                _jettag_c_iterate_252_4.doEnd();
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process dropdowns one to one and many to one 
                RuntimeTagElement _jettag_c_iterate_283_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_283_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_283_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_283_4.setTagInfo(_td_c_iterate_283_4);
                _jettag_c_iterate_283_4.doStart(context, out);
                while (_jettag_c_iterate_283_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_284_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_284_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_284_5.setRuntimeParent(_jettag_c_iterate_283_4);
                    _jettag_c_iterate_284_5.setTagInfo(_td_c_iterate_284_5);
                    _jettag_c_iterate_284_5.doStart(context, out);
                    while (_jettag_c_iterate_284_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_285_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_285_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_285_6.setRuntimeParent(_jettag_c_iterate_284_5);
                        _jettag_c_iterate_285_6.setTagInfo(_td_c_iterate_285_6);
                        _jettag_c_iterate_285_6.doStart(context, out);
                        while (_jettag_c_iterate_285_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_286_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_286_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_286_7.setRuntimeParent(_jettag_c_iterate_285_6);
                            _jettag_c_setVariable_286_7.setTagInfo(_td_c_setVariable_286_7);
                            _jettag_c_setVariable_286_7.doStart(context, out);
                            _jettag_c_setVariable_286_7.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_288_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_288_9); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_288_9.setRuntimeParent(_jettag_c_iterate_285_6);
                            _jettag_c_if_288_9.setTagInfo(_td_c_if_288_9);
                            _jettag_c_if_288_9.doStart(context, out);
                            while (_jettag_c_if_288_9.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_290_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_290_15); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_290_15.setRuntimeParent(_jettag_c_if_288_9);
                                _jettag_c_iterate_290_15.setTagInfo(_td_c_iterate_290_15);
                                _jettag_c_iterate_290_15.doStart(context, out);
                                while (_jettag_c_iterate_290_15.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_291_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_291_15); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_291_15.setRuntimeParent(_jettag_c_iterate_290_15);
                                    _jettag_c_setVariable_291_15.setTagInfo(_td_c_setVariable_291_15);
                                    _jettag_c_setVariable_291_15.doStart(context, out);
                                    _jettag_c_setVariable_291_15.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_293_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_293_17); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_293_17.setRuntimeParent(_jettag_c_iterate_290_15);
                                    _jettag_c_if_293_17.setTagInfo(_td_c_if_293_17);
                                    _jettag_c_if_293_17.doStart(context, out);
                                    while (_jettag_c_if_293_17.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_295_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_295_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_295_18.setRuntimeParent(_jettag_c_if_293_17);
                                        _jettag_c_iterate_295_18.setTagInfo(_td_c_iterate_295_18);
                                        _jettag_c_iterate_295_18.doStart(context, out);
                                        while (_jettag_c_iterate_295_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_296_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_296_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_296_19.setRuntimeParent(_jettag_c_iterate_295_18);
                                            _jettag_c_if_296_19.setTagInfo(_td_c_if_296_19);
                                            _jettag_c_if_296_19.doStart(context, out);
                                            while (_jettag_c_if_296_19.okToProcessBody()) {
                                                // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                // check target is one side
                                                RuntimeTagElement _jettag_c_if_299_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_299_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_299_19.setRuntimeParent(_jettag_c_if_296_19);
                                                _jettag_c_if_299_19.setTagInfo(_td_c_if_299_19);
                                                _jettag_c_if_299_19.doStart(context, out);
                                                while (_jettag_c_if_299_19.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_300_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_300_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_300_21.setRuntimeParent(_jettag_c_if_299_19);
                                                    _jettag_c_if_300_21.setTagInfo(_td_c_if_300_21);
                                                    _jettag_c_if_300_21.doStart(context, out);
                                                    while (_jettag_c_if_300_21.okToProcessBody()) {
                                                        //process only non composites 
                                                        RuntimeTagElement _jettag_c_if_302_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_302_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_302_18.setRuntimeParent(_jettag_c_if_300_21);
                                                        _jettag_c_if_302_18.setTagInfo(_td_c_if_302_18);
                                                        _jettag_c_if_302_18.doStart(context, out);
                                                        while (_jettag_c_if_302_18.okToProcessBody()) {
                                                            out.write("\t\t\t  \t\t\t\t\t    \t\t\t\t\t\t\taddField(\"");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 303, 32)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("\", true, true , DataType.DROPDOWN_FIELD);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_302_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_302_18.doEnd();
                                                        _jettag_c_if_300_21.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_300_21.doEnd();
                                                    _jettag_c_if_299_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_299_19.doEnd();
                                                _jettag_c_if_296_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_296_19.doEnd();
                                            _jettag_c_iterate_295_18.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_295_18.doEnd();
                                        _jettag_c_if_293_17.handleBodyContent(out);
                                    }
                                    _jettag_c_if_293_17.doEnd();
                                    _jettag_c_iterate_290_15.handleBodyContent(out);
                                }
                                _jettag_c_iterate_290_15.doEnd();
                                _jettag_c_if_288_9.handleBodyContent(out);
                            }
                            _jettag_c_if_288_9.doEnd();
                            _jettag_c_iterate_285_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_285_6.doEnd();
                        _jettag_c_iterate_284_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_284_5.doEnd();
                    _jettag_c_iterate_283_4.handleBodyContent(out);
                }
                _jettag_c_iterate_283_4.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_316_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_316_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_316_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_316_1.setTagInfo(_td_f_message_316_1);
                _jettag_f_message_316_1.doStart(context, out);
                JET2Writer _jettag_f_message_316_1_saved_out = out;
                while (_jettag_f_message_316_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_316_1.handleBodyContent(out);
                }
                out = _jettag_f_message_316_1_saved_out;
                _jettag_f_message_316_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void configure() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_321_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_321_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_321_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_321_1.setTagInfo(_td_f_message_321_1);
                _jettag_f_message_321_1.doStart(context, out);
                JET2Writer _jettag_f_message_321_1_saved_out = out;
                while (_jettag_f_message_321_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_321_1.handleBodyContent(out);
                }
                out = _jettag_f_message_321_1_saved_out;
                _jettag_f_message_321_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void readData(");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 323, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" entity) {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t// TODO Auto-generated method stub");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_327_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_327_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_327_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_327_1.setTagInfo(_td_f_message_327_1);
                _jettag_f_message_327_1.doStart(context, out);
                JET2Writer _jettag_f_message_327_1_saved_out = out;
                while (_jettag_f_message_327_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_327_1.handleBodyContent(out);
                }
                out = _jettag_f_message_327_1_saved_out;
                _jettag_f_message_327_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void postValidate() {");  //$NON-NLS-1$        
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
