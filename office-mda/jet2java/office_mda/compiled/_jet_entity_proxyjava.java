package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_entity_proxyjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_entity_proxyjava() {
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
    private static final TagInfo _td_c_iterate_16_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            16, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_17_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            17, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_18_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            18, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_19_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            19, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_21_5 = new TagInfo("c:if", //$NON-NLS-1$
            21, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_23_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            23, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_24_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            24, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_26_14 = new TagInfo("c:if", //$NON-NLS-1$
            26, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_28_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            28, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_29_16 = new TagInfo("c:if", //$NON-NLS-1$
            29, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_31_14 = new TagInfo("c:if", //$NON-NLS-1$
            31, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_44_2 = new TagInfo("c:if", //$NON-NLS-1$
            44, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_45_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            45, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_46_4 = new TagInfo("c:choose", //$NON-NLS-1$
            46, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_47_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            47, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_48_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            48, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_49_9 = new TagInfo("c:if", //$NON-NLS-1$
            49, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_58_2 = new TagInfo("c:if", //$NON-NLS-1$
            58, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_59_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            59, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_60_4 = new TagInfo("c:choose", //$NON-NLS-1$
            60, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_61_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            61, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_62_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            62, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_63_8 = new TagInfo("c:if", //$NON-NLS-1$
            63, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_72_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            72, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_73_3 = new TagInfo("c:choose", //$NON-NLS-1$
            73, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_74_5 = new TagInfo("c:otherwise", //$NON-NLS-1$
            74, 5,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_75_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            75, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_76_7 = new TagInfo("c:if", //$NON-NLS-1$
            76, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_84_1 = new TagInfo("c:if", //$NON-NLS-1$
            84, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_88_1 = new TagInfo("c:if", //$NON-NLS-1$
            88, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_98_8 = new TagInfo("c:if", //$NON-NLS-1$
            98, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isAbstract = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_98_104 = new TagInfo("c:if", //$NON-NLS-1$
            98, 104,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@parentClass1Name = $class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_98_179 = new TagInfo("c:if", //$NON-NLS-1$
            98, 179,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@parentClass1Name = $class/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_100_1 = new TagInfo("c:if", //$NON-NLS-1$
            100, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@parentClass1Name = $class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_101_1 = new TagInfo("f:message", //$NON-NLS-1$
            101, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_103_1 = new TagInfo("f:message", //$NON-NLS-1$
            103, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_108_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            108, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_110_2 = new TagInfo("f:message", //$NON-NLS-1$
            110, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_choose_111_10 = new TagInfo("c:choose", //$NON-NLS-1$
            111, 10,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_81 = new TagInfo("c:when", //$NON-NLS-1$
            111, 81,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_128 = new TagInfo("c:when", //$NON-NLS-1$
            111, 128,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_176 = new TagInfo("c:when", //$NON-NLS-1$
            111, 176,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_218 = new TagInfo("c:when", //$NON-NLS-1$
            111, 218,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_266 = new TagInfo("c:when", //$NON-NLS-1$
            111, 266,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_310 = new TagInfo("c:when", //$NON-NLS-1$
            111, 310,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_355 = new TagInfo("c:when", //$NON-NLS-1$
            111, 355,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_401 = new TagInfo("c:when", //$NON-NLS-1$
            111, 401,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_450 = new TagInfo("c:when", //$NON-NLS-1$
            111, 450,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_111_503 = new TagInfo("c:otherwise", //$NON-NLS-1$
            111, 503,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_112_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            112, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_113_6 = new TagInfo("c:if", //$NON-NLS-1$
            113, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_118_2 = new TagInfo("f:message", //$NON-NLS-1$
            118, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_choose_119_53 = new TagInfo("c:choose", //$NON-NLS-1$
            119, 53,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_119_123 = new TagInfo("c:when", //$NON-NLS-1$
            119, 123,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_119_170 = new TagInfo("c:when", //$NON-NLS-1$
            119, 170,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_119_218 = new TagInfo("c:when", //$NON-NLS-1$
            119, 218,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_119_260 = new TagInfo("c:when", //$NON-NLS-1$
            119, 260,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_119_308 = new TagInfo("c:when", //$NON-NLS-1$
            119, 308,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_119_352 = new TagInfo("c:when", //$NON-NLS-1$
            119, 352,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_119_397 = new TagInfo("c:when", //$NON-NLS-1$
            119, 397,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_119_443 = new TagInfo("c:when", //$NON-NLS-1$
            119, 443,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_119_492 = new TagInfo("c:when", //$NON-NLS-1$
            119, 492,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_119_545 = new TagInfo("c:otherwise", //$NON-NLS-1$
            119, 545,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_120_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            120, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_121_6 = new TagInfo("c:if", //$NON-NLS-1$
            121, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_get_125_33 = new TagInfo("c:get", //$NON-NLS-1$
            125, 33,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_130_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            130, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_131_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            131, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_133_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            133, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_134_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            134, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_136_6 = new TagInfo("c:if", //$NON-NLS-1$
            136, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_138_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            138, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_139_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            139, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_141_14 = new TagInfo("c:if", //$NON-NLS-1$
            141, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_143_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            143, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_144_16 = new TagInfo("c:if", //$NON-NLS-1$
            144, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_147_13 = new TagInfo("c:if", //$NON-NLS-1$
            147, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_150_16 = new TagInfo("c:if", //$NON-NLS-1$
            150, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_151_18 = new TagInfo("c:if", //$NON-NLS-1$
            151, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_153_2 = new TagInfo("f:message", //$NON-NLS-1$
            153, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_156_1 = new TagInfo("f:message", //$NON-NLS-1$
            156, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_163_17 = new TagInfo("c:if", //$NON-NLS-1$
            163, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_164_18 = new TagInfo("c:if", //$NON-NLS-1$
            164, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_168_13 = new TagInfo("c:if", //$NON-NLS-1$
            168, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_169_19 = new TagInfo("c:if", //$NON-NLS-1$
            169, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_171_19 = new TagInfo("f:message", //$NON-NLS-1$
            171, 19,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_174_15 = new TagInfo("f:message", //$NON-NLS-1$
            174, 15,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_180_17 = new TagInfo("c:if", //$NON-NLS-1$
            180, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_181_19 = new TagInfo("c:if", //$NON-NLS-1$
            181, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_183_20 = new TagInfo("f:message", //$NON-NLS-1$
            183, 20,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_186_15 = new TagInfo("f:message", //$NON-NLS-1$
            186, 15,
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
                out.write("import java.io.Serializable;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Date;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.Set;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.HashSet;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.ArrayList;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.math.BigDecimal;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                // related classes import
                RuntimeTagElement _jettag_c_iterate_16_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_16_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_16_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_16_1.setTagInfo(_td_c_iterate_16_1);
                _jettag_c_iterate_16_1.doStart(context, out);
                while (_jettag_c_iterate_16_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_17_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_17_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_17_2.setRuntimeParent(_jettag_c_iterate_16_1);
                    _jettag_c_iterate_17_2.setTagInfo(_td_c_iterate_17_2);
                    _jettag_c_iterate_17_2.doStart(context, out);
                    while (_jettag_c_iterate_17_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_18_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_18_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_18_3.setRuntimeParent(_jettag_c_iterate_17_2);
                        _jettag_c_iterate_18_3.setTagInfo(_td_c_iterate_18_3);
                        _jettag_c_iterate_18_3.doStart(context, out);
                        while (_jettag_c_iterate_18_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_19_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_19_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_19_4.setRuntimeParent(_jettag_c_iterate_18_3);
                            _jettag_c_setVariable_19_4.setTagInfo(_td_c_setVariable_19_4);
                            _jettag_c_setVariable_19_4.doStart(context, out);
                            _jettag_c_setVariable_19_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_21_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_21_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_21_5.setRuntimeParent(_jettag_c_iterate_18_3);
                            _jettag_c_if_21_5.setTagInfo(_td_c_if_21_5);
                            _jettag_c_if_21_5.doStart(context, out);
                            while (_jettag_c_if_21_5.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_23_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_23_8); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_23_8.setRuntimeParent(_jettag_c_if_21_5);
                                _jettag_c_iterate_23_8.setTagInfo(_td_c_iterate_23_8);
                                _jettag_c_iterate_23_8.doStart(context, out);
                                while (_jettag_c_iterate_23_8.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_24_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_24_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_24_12.setRuntimeParent(_jettag_c_iterate_23_8);
                                    _jettag_c_setVariable_24_12.setTagInfo(_td_c_setVariable_24_12);
                                    _jettag_c_setVariable_24_12.doStart(context, out);
                                    _jettag_c_setVariable_24_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_26_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_26_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_26_14.setRuntimeParent(_jettag_c_iterate_23_8);
                                    _jettag_c_if_26_14.setTagInfo(_td_c_if_26_14);
                                    _jettag_c_if_26_14.doStart(context, out);
                                    while (_jettag_c_if_26_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_28_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_28_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_28_15.setRuntimeParent(_jettag_c_if_26_14);
                                        _jettag_c_iterate_28_15.setTagInfo(_td_c_iterate_28_15);
                                        _jettag_c_iterate_28_15.doStart(context, out);
                                        while (_jettag_c_iterate_28_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_29_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_29_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_29_16.setRuntimeParent(_jettag_c_iterate_28_15);
                                            _jettag_c_if_29_16.setTagInfo(_td_c_if_29_16);
                                            _jettag_c_if_29_16.doStart(context, out);
                                            while (_jettag_c_if_29_16.okToProcessBody()) {
                                                // check to see the association is navigable in the first case
                                                RuntimeTagElement _jettag_c_if_31_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_31_14); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_31_14.setRuntimeParent(_jettag_c_if_29_16);
                                                _jettag_c_if_31_14.setTagInfo(_td_c_if_31_14);
                                                _jettag_c_if_31_14.doStart(context, out);
                                                while (_jettag_c_if_31_14.okToProcessBody()) {
                                                    out.write("import ");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$packageName}", 32, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 32, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write(".");  //$NON-NLS-1$        
                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 32, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    out.write("Proxy;\t\t\t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_31_14.handleBodyContent(out);
                                                }
                                                _jettag_c_if_31_14.doEnd();
                                                _jettag_c_if_29_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_29_16.doEnd();
                                            _jettag_c_iterate_28_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_28_15.doEnd();
                                        _jettag_c_if_26_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_26_14.doEnd();
                                    _jettag_c_iterate_23_8.handleBodyContent(out);
                                }
                                _jettag_c_iterate_23_8.doEnd();
                                _jettag_c_if_21_5.handleBodyContent(out);
                            }
                            _jettag_c_if_21_5.doEnd();
                            _jettag_c_iterate_18_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_18_3.doEnd();
                        _jettag_c_iterate_17_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_17_2.doEnd();
                    _jettag_c_iterate_16_1.handleBodyContent(out);
                }
                _jettag_c_iterate_16_1.doEnd();
                //process enums from base and lavel1,2 parents 
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_44_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_44_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_44_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_44_2.setTagInfo(_td_c_if_44_2);
                _jettag_c_if_44_2.doStart(context, out);
                while (_jettag_c_if_44_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_45_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_45_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_45_3.setRuntimeParent(_jettag_c_if_44_2);
                    _jettag_c_iterate_45_3.setTagInfo(_td_c_iterate_45_3);
                    _jettag_c_iterate_45_3.doStart(context, out);
                    while (_jettag_c_iterate_45_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_46_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_46_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_46_4.setRuntimeParent(_jettag_c_iterate_45_3);
                        _jettag_c_choose_46_4.setTagInfo(_td_c_choose_46_4);
                        _jettag_c_choose_46_4.doStart(context, out);
                        JET2Writer _jettag_c_choose_46_4_saved_out = out;
                        while (_jettag_c_choose_46_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_otherwise_47_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_47_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_47_6.setRuntimeParent(_jettag_c_choose_46_4);
                            _jettag_c_otherwise_47_6.setTagInfo(_td_c_otherwise_47_6);
                            _jettag_c_otherwise_47_6.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_47_6_saved_out = out;
                            while (_jettag_c_otherwise_47_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_48_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_48_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_48_6.setRuntimeParent(_jettag_c_otherwise_47_6);
                                _jettag_c_iterate_48_6.setTagInfo(_td_c_iterate_48_6);
                                _jettag_c_iterate_48_6.doStart(context, out);
                                while (_jettag_c_iterate_48_6.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_49_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_49_9); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_49_9.setRuntimeParent(_jettag_c_iterate_48_6);
                                    _jettag_c_if_49_9.setTagInfo(_td_c_if_49_9);
                                    _jettag_c_if_49_9.doStart(context, out);
                                    while (_jettag_c_if_49_9.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$groupID}", 50, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".entity.");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 50, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 50, 65)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(";");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_49_9.handleBodyContent(out);
                                    }
                                    _jettag_c_if_49_9.doEnd();
                                    _jettag_c_iterate_48_6.handleBodyContent(out);
                                }
                                _jettag_c_iterate_48_6.doEnd();
                                _jettag_c_otherwise_47_6.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_47_6_saved_out;
                            _jettag_c_otherwise_47_6.doEnd();
                            _jettag_c_choose_46_4.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_46_4_saved_out;
                        _jettag_c_choose_46_4.doEnd();
                        _jettag_c_iterate_45_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_45_3.doEnd();
                    _jettag_c_if_44_2.handleBodyContent(out);
                }
                _jettag_c_if_44_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_58_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_58_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_58_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_58_2.setTagInfo(_td_c_if_58_2);
                _jettag_c_if_58_2.doStart(context, out);
                while (_jettag_c_if_58_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_59_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_59_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_59_3.setRuntimeParent(_jettag_c_if_58_2);
                    _jettag_c_iterate_59_3.setTagInfo(_td_c_iterate_59_3);
                    _jettag_c_iterate_59_3.doStart(context, out);
                    while (_jettag_c_iterate_59_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_60_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_60_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_60_4.setRuntimeParent(_jettag_c_iterate_59_3);
                        _jettag_c_choose_60_4.setTagInfo(_td_c_choose_60_4);
                        _jettag_c_choose_60_4.doStart(context, out);
                        JET2Writer _jettag_c_choose_60_4_saved_out = out;
                        while (_jettag_c_choose_60_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_otherwise_61_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_61_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_61_6.setRuntimeParent(_jettag_c_choose_60_4);
                            _jettag_c_otherwise_61_6.setTagInfo(_td_c_otherwise_61_6);
                            _jettag_c_otherwise_61_6.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_61_6_saved_out = out;
                            while (_jettag_c_otherwise_61_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                RuntimeTagElement _jettag_c_iterate_62_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_62_7); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_62_7.setRuntimeParent(_jettag_c_otherwise_61_6);
                                _jettag_c_iterate_62_7.setTagInfo(_td_c_iterate_62_7);
                                _jettag_c_iterate_62_7.doStart(context, out);
                                while (_jettag_c_iterate_62_7.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_63_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_63_8); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_63_8.setRuntimeParent(_jettag_c_iterate_62_7);
                                    _jettag_c_if_63_8.setTagInfo(_td_c_if_63_8);
                                    _jettag_c_if_63_8.doStart(context, out);
                                    while (_jettag_c_if_63_8.okToProcessBody()) {
                                        out.write("\t\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$groupID}", 64, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".entity.");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 64, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(".");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 64, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(";");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_63_8.handleBodyContent(out);
                                    }
                                    _jettag_c_if_63_8.doEnd();
                                    _jettag_c_iterate_62_7.handleBodyContent(out);
                                }
                                _jettag_c_iterate_62_7.doEnd();
                                _jettag_c_otherwise_61_6.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_61_6_saved_out;
                            _jettag_c_otherwise_61_6.doEnd();
                            _jettag_c_choose_60_4.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_60_4_saved_out;
                        _jettag_c_choose_60_4.doEnd();
                        _jettag_c_iterate_59_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_59_3.doEnd();
                    _jettag_c_if_58_2.handleBodyContent(out);
                }
                _jettag_c_if_58_2.doEnd();
                //process premitive data types of base current class 
                RuntimeTagElement _jettag_c_iterate_72_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_72_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_72_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_72_2.setTagInfo(_td_c_iterate_72_2);
                _jettag_c_iterate_72_2.doStart(context, out);
                while (_jettag_c_iterate_72_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_73_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_73_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_73_3.setRuntimeParent(_jettag_c_iterate_72_2);
                    _jettag_c_choose_73_3.setTagInfo(_td_c_choose_73_3);
                    _jettag_c_choose_73_3.doStart(context, out);
                    JET2Writer _jettag_c_choose_73_3_saved_out = out;
                    while (_jettag_c_choose_73_3.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_otherwise_74_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_74_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_74_5.setRuntimeParent(_jettag_c_choose_73_3);
                        _jettag_c_otherwise_74_5.setTagInfo(_td_c_otherwise_74_5);
                        _jettag_c_otherwise_74_5.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_74_5_saved_out = out;
                        while (_jettag_c_otherwise_74_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_75_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_75_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_75_5.setRuntimeParent(_jettag_c_otherwise_74_5);
                            _jettag_c_iterate_75_5.setTagInfo(_td_c_iterate_75_5);
                            _jettag_c_iterate_75_5.doStart(context, out);
                            while (_jettag_c_iterate_75_5.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_76_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_76_7); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_76_7.setRuntimeParent(_jettag_c_iterate_75_5);
                                _jettag_c_if_76_7.setTagInfo(_td_c_if_76_7);
                                _jettag_c_if_76_7.doStart(context, out);
                                while (_jettag_c_if_76_7.okToProcessBody()) {
                                    out.write("\t\t\t\t\t\timport ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$groupID}", 77, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".entity.");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 77, 33)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(".");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${ uppercaseFirst($enumeration/@name)}", 77, 63)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(";");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_76_7.handleBodyContent(out);
                                }
                                _jettag_c_if_76_7.doEnd();
                                _jettag_c_iterate_75_5.handleBodyContent(out);
                            }
                            _jettag_c_iterate_75_5.doEnd();
                            _jettag_c_otherwise_74_5.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_74_5_saved_out;
                        _jettag_c_otherwise_74_5.doEnd();
                        _jettag_c_choose_73_3.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_73_3_saved_out;
                    _jettag_c_choose_73_3.doEnd();
                    _jettag_c_iterate_72_2.handleBodyContent(out);
                }
                _jettag_c_iterate_72_2.doEnd();
                //process level 1 generizations for parent class proxy imports
                RuntimeTagElement _jettag_c_if_84_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_84_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_84_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_84_1.setTagInfo(_td_c_if_84_1);
                _jettag_c_if_84_1.doStart(context, out);
                while (_jettag_c_if_84_1.okToProcessBody()) {
                    out.write(" import ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$groupID}", 85, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".client.");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 85, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($parentClass1/@name)}", 85, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$parentClass1/@name}", 85, 93)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Proxy;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_84_1.handleBodyContent(out);
                }
                _jettag_c_if_84_1.doEnd();
                //process level 2 generizations 
                RuntimeTagElement _jettag_c_if_88_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_88_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_88_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_88_1.setTagInfo(_td_c_if_88_1);
                _jettag_c_if_88_1.doStart(context, out);
                while (_jettag_c_if_88_1.okToProcessBody()) {
                    out.write(" import ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$groupID}", 89, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".client.");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 89, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($parentClass2/@name)}", 89, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$parentClass2/@name}", 89, 93)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Proxy;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_88_1.handleBodyContent(out);
                }
                _jettag_c_if_88_1.doEnd();
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 92, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 92, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 92, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 93, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".server.rf.GenericEntityLocator;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.web.bindery.requestfactory.shared.EntityProxy;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.web.bindery.requestfactory.shared.ProxyFor;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("@ProxyFor(value = ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 97, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".class, locator = GenericEntityLocator.class)");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_if_98_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_98_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_98_8.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_98_8.setTagInfo(_td_c_if_98_8);
                _jettag_c_if_98_8.doStart(context, out);
                while (_jettag_c_if_98_8.okToProcessBody()) {
                    out.write("abstract");  //$NON-NLS-1$        
                    _jettag_c_if_98_8.handleBodyContent(out);
                }
                _jettag_c_if_98_8.doEnd();
                out.write(" interface ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 98, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Proxy extends ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_if_98_104 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_98_104); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_98_104.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_98_104.setTagInfo(_td_c_if_98_104);
                _jettag_c_if_98_104.doStart(context, out);
                while (_jettag_c_if_98_104.okToProcessBody()) {
                    out.write("  EntityProxy ");  //$NON-NLS-1$        
                    _jettag_c_if_98_104.handleBodyContent(out);
                }
                _jettag_c_if_98_104.doEnd();
                out.write(" ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_if_98_179 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_98_179); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_98_179.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_98_179.setTagInfo(_td_c_if_98_179);
                _jettag_c_if_98_179.doStart(context, out);
                while (_jettag_c_if_98_179.okToProcessBody()) {
                    out.write("  ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@parentClass1Name}", 98, 239)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("Proxy ");  //$NON-NLS-1$        
                    _jettag_c_if_98_179.handleBodyContent(out);
                }
                _jettag_c_if_98_179.doEnd();
                out.write(" {");  //$NON-NLS-1$        
                out.write(NL);         
                //getter and seeter for id attribute 
                RuntimeTagElement _jettag_c_if_100_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_100_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_100_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_100_1.setTagInfo(_td_c_if_100_1);
                _jettag_c_if_100_1.doStart(context, out);
                while (_jettag_c_if_100_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_f_message_101_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_101_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_101_1.setRuntimeParent(_jettag_c_if_100_1);
                    _jettag_f_message_101_1.setTagInfo(_td_f_message_101_1);
                    _jettag_f_message_101_1.doStart(context, out);
                    JET2Writer _jettag_f_message_101_1_saved_out = out;
                    while (_jettag_f_message_101_1.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_101_1.handleBodyContent(out);
                    }
                    out = _jettag_f_message_101_1_saved_out;
                    _jettag_f_message_101_1.doEnd();
                    out.write(NL);         
                    out.write("  public Long getId();");  //$NON-NLS-1$        
                    out.write(NL);         
                    RuntimeTagElement _jettag_f_message_103_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_103_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_103_1.setRuntimeParent(_jettag_c_if_100_1);
                    _jettag_f_message_103_1.setTagInfo(_td_f_message_103_1);
                    _jettag_f_message_103_1.doStart(context, out);
                    JET2Writer _jettag_f_message_103_1_saved_out = out;
                    while (_jettag_f_message_103_1.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_103_1.handleBodyContent(out);
                    }
                    out = _jettag_f_message_103_1_saved_out;
                    _jettag_f_message_103_1.doEnd();
                    out.write("  ");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("  public void setId(Long id);");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_100_1.handleBodyContent(out);
                }
                _jettag_c_if_100_1.doEnd();
                out.write(NL);         
                // getters and setters 
                RuntimeTagElement _jettag_c_iterate_108_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_108_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_108_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_108_1.setTagInfo(_td_c_iterate_108_1);
                _jettag_c_iterate_108_1.doStart(context, out);
                while (_jettag_c_iterate_108_1.okToProcessBody()) {
                    //getters for basic attributes 
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_f_message_110_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_110_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_110_2.setRuntimeParent(_jettag_c_iterate_108_1);
                    _jettag_f_message_110_2.setTagInfo(_td_f_message_110_2);
                    _jettag_f_message_110_2.doStart(context, out);
                    JET2Writer _jettag_f_message_110_2_saved_out = out;
                    while (_jettag_f_message_110_2.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_110_2.handleBodyContent(out);
                    }
                    out = _jettag_f_message_110_2_saved_out;
                    _jettag_f_message_110_2.doEnd();
                    out.write(NL);         
                    out.write("\tpublic  ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_choose_111_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_111_10); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_111_10.setRuntimeParent(_jettag_c_iterate_108_1);
                    _jettag_c_choose_111_10.setTagInfo(_td_c_choose_111_10);
                    _jettag_c_choose_111_10.doStart(context, out);
                    JET2Writer _jettag_c_choose_111_10_saved_out = out;
                    while (_jettag_c_choose_111_10.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("  ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_111_81 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_81); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_111_81.setRuntimeParent(_jettag_c_choose_111_10);
                        _jettag_c_when_111_81.setTagInfo(_td_c_when_111_81);
                        _jettag_c_when_111_81.doStart(context, out);
                        JET2Writer _jettag_c_when_111_81_saved_out = out;
                        while (_jettag_c_when_111_81.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_111_81.handleBodyContent(out);
                        }
                        out = _jettag_c_when_111_81_saved_out;
                        _jettag_c_when_111_81.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_111_128 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_128); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_111_128.setRuntimeParent(_jettag_c_choose_111_10);
                        _jettag_c_when_111_128.setTagInfo(_td_c_when_111_128);
                        _jettag_c_when_111_128.doStart(context, out);
                        JET2Writer _jettag_c_when_111_128_saved_out = out;
                        while (_jettag_c_when_111_128.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Integer");  //$NON-NLS-1$        
                            _jettag_c_when_111_128.handleBodyContent(out);
                        }
                        out = _jettag_c_when_111_128_saved_out;
                        _jettag_c_when_111_128.doEnd();
                        RuntimeTagElement _jettag_c_when_111_176 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_176); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_111_176.setRuntimeParent(_jettag_c_choose_111_10);
                        _jettag_c_when_111_176.setTagInfo(_td_c_when_111_176);
                        _jettag_c_when_111_176.doStart(context, out);
                        JET2Writer _jettag_c_when_111_176_saved_out = out;
                        while (_jettag_c_when_111_176.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Date");  //$NON-NLS-1$        
                            _jettag_c_when_111_176.handleBodyContent(out);
                        }
                        out = _jettag_c_when_111_176_saved_out;
                        _jettag_c_when_111_176.doEnd();
                        RuntimeTagElement _jettag_c_when_111_218 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_218); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_111_218.setRuntimeParent(_jettag_c_choose_111_10);
                        _jettag_c_when_111_218.setTagInfo(_td_c_when_111_218);
                        _jettag_c_when_111_218.doStart(context, out);
                        JET2Writer _jettag_c_when_111_218_saved_out = out;
                        while (_jettag_c_when_111_218.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Boolean");  //$NON-NLS-1$        
                            _jettag_c_when_111_218.handleBodyContent(out);
                        }
                        out = _jettag_c_when_111_218_saved_out;
                        _jettag_c_when_111_218.doEnd();
                        RuntimeTagElement _jettag_c_when_111_266 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_266); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_111_266.setRuntimeParent(_jettag_c_choose_111_10);
                        _jettag_c_when_111_266.setTagInfo(_td_c_when_111_266);
                        _jettag_c_when_111_266.doStart(context, out);
                        JET2Writer _jettag_c_when_111_266_saved_out = out;
                        while (_jettag_c_when_111_266.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" Long ");  //$NON-NLS-1$        
                            _jettag_c_when_111_266.handleBodyContent(out);
                        }
                        out = _jettag_c_when_111_266_saved_out;
                        _jettag_c_when_111_266.doEnd();
                        RuntimeTagElement _jettag_c_when_111_310 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_310); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_111_310.setRuntimeParent(_jettag_c_choose_111_10);
                        _jettag_c_when_111_310.setTagInfo(_td_c_when_111_310);
                        _jettag_c_when_111_310.doStart(context, out);
                        JET2Writer _jettag_c_when_111_310_saved_out = out;
                        while (_jettag_c_when_111_310.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Float");  //$NON-NLS-1$        
                            _jettag_c_when_111_310.handleBodyContent(out);
                        }
                        out = _jettag_c_when_111_310_saved_out;
                        _jettag_c_when_111_310.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_111_355 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_355); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_111_355.setRuntimeParent(_jettag_c_choose_111_10);
                        _jettag_c_when_111_355.setTagInfo(_td_c_when_111_355);
                        _jettag_c_when_111_355.doStart(context, out);
                        JET2Writer _jettag_c_when_111_355_saved_out = out;
                        while (_jettag_c_when_111_355.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_111_355.handleBodyContent(out);
                        }
                        out = _jettag_c_when_111_355_saved_out;
                        _jettag_c_when_111_355.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_111_401 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_401); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_111_401.setRuntimeParent(_jettag_c_choose_111_10);
                        _jettag_c_when_111_401.setTagInfo(_td_c_when_111_401);
                        _jettag_c_when_111_401.doStart(context, out);
                        JET2Writer _jettag_c_when_111_401_saved_out = out;
                        while (_jettag_c_when_111_401.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_111_401.handleBodyContent(out);
                        }
                        out = _jettag_c_when_111_401_saved_out;
                        _jettag_c_when_111_401.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_111_450 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_450); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_111_450.setRuntimeParent(_jettag_c_choose_111_10);
                        _jettag_c_when_111_450.setTagInfo(_td_c_when_111_450);
                        _jettag_c_when_111_450.doStart(context, out);
                        JET2Writer _jettag_c_when_111_450_saved_out = out;
                        while (_jettag_c_when_111_450.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("BigDecimal");  //$NON-NLS-1$        
                            _jettag_c_when_111_450.handleBodyContent(out);
                        }
                        out = _jettag_c_when_111_450_saved_out;
                        _jettag_c_when_111_450.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_otherwise_111_503 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_111_503); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_111_503.setRuntimeParent(_jettag_c_choose_111_10);
                        _jettag_c_otherwise_111_503.setTagInfo(_td_c_otherwise_111_503);
                        _jettag_c_otherwise_111_503.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_111_503_saved_out = out;
                        while (_jettag_c_otherwise_111_503.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(NL);         
                            RuntimeTagElement _jettag_c_iterate_112_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_112_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_112_4.setRuntimeParent(_jettag_c_otherwise_111_503);
                            _jettag_c_iterate_112_4.setTagInfo(_td_c_iterate_112_4);
                            _jettag_c_iterate_112_4.doStart(context, out);
                            while (_jettag_c_iterate_112_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_113_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_113_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_113_6.setRuntimeParent(_jettag_c_iterate_112_4);
                                _jettag_c_if_113_6.setTagInfo(_td_c_if_113_6);
                                _jettag_c_if_113_6.doStart(context, out);
                                while (_jettag_c_if_113_6.okToProcessBody()) {
                                    out.write("\t \t\t\t ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$enumeration/@name}", 114, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(" ");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_113_6.handleBodyContent(out);
                                }
                                _jettag_c_if_113_6.doEnd();
                                _jettag_c_iterate_112_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_112_4.doEnd();
                            out.write("\t \t  ");  //$NON-NLS-1$        
                            _jettag_c_otherwise_111_503.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_111_503_saved_out;
                        _jettag_c_otherwise_111_503.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        _jettag_c_choose_111_10.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_111_10_saved_out;
                    _jettag_c_choose_111_10.doEnd();
                    out.write(" get");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 117, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("();");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_f_message_118_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_118_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_118_2.setRuntimeParent(_jettag_c_iterate_108_1);
                    _jettag_f_message_118_2.setTagInfo(_td_f_message_118_2);
                    _jettag_f_message_118_2.doStart(context, out);
                    JET2Writer _jettag_f_message_118_2_saved_out = out;
                    while (_jettag_f_message_118_2.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_118_2.handleBodyContent(out);
                    }
                    out = _jettag_f_message_118_2_saved_out;
                    _jettag_f_message_118_2.doEnd();
                    out.write(NL);         
                    out.write("\tpublic void set");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 119, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("(");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_choose_119_53 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_119_53); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_119_53.setRuntimeParent(_jettag_c_iterate_108_1);
                    _jettag_c_choose_119_53.setTagInfo(_td_c_choose_119_53);
                    _jettag_c_choose_119_53.doStart(context, out);
                    JET2Writer _jettag_c_choose_119_53_saved_out = out;
                    while (_jettag_c_choose_119_53.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_119_123 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_119_123); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_119_123.setRuntimeParent(_jettag_c_choose_119_53);
                        _jettag_c_when_119_123.setTagInfo(_td_c_when_119_123);
                        _jettag_c_when_119_123.doStart(context, out);
                        JET2Writer _jettag_c_when_119_123_saved_out = out;
                        while (_jettag_c_when_119_123.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_119_123.handleBodyContent(out);
                        }
                        out = _jettag_c_when_119_123_saved_out;
                        _jettag_c_when_119_123.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_119_170 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_119_170); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_119_170.setRuntimeParent(_jettag_c_choose_119_53);
                        _jettag_c_when_119_170.setTagInfo(_td_c_when_119_170);
                        _jettag_c_when_119_170.doStart(context, out);
                        JET2Writer _jettag_c_when_119_170_saved_out = out;
                        while (_jettag_c_when_119_170.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Integer");  //$NON-NLS-1$        
                            _jettag_c_when_119_170.handleBodyContent(out);
                        }
                        out = _jettag_c_when_119_170_saved_out;
                        _jettag_c_when_119_170.doEnd();
                        RuntimeTagElement _jettag_c_when_119_218 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_119_218); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_119_218.setRuntimeParent(_jettag_c_choose_119_53);
                        _jettag_c_when_119_218.setTagInfo(_td_c_when_119_218);
                        _jettag_c_when_119_218.doStart(context, out);
                        JET2Writer _jettag_c_when_119_218_saved_out = out;
                        while (_jettag_c_when_119_218.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Date");  //$NON-NLS-1$        
                            _jettag_c_when_119_218.handleBodyContent(out);
                        }
                        out = _jettag_c_when_119_218_saved_out;
                        _jettag_c_when_119_218.doEnd();
                        RuntimeTagElement _jettag_c_when_119_260 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_119_260); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_119_260.setRuntimeParent(_jettag_c_choose_119_53);
                        _jettag_c_when_119_260.setTagInfo(_td_c_when_119_260);
                        _jettag_c_when_119_260.doStart(context, out);
                        JET2Writer _jettag_c_when_119_260_saved_out = out;
                        while (_jettag_c_when_119_260.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Boolean");  //$NON-NLS-1$        
                            _jettag_c_when_119_260.handleBodyContent(out);
                        }
                        out = _jettag_c_when_119_260_saved_out;
                        _jettag_c_when_119_260.doEnd();
                        RuntimeTagElement _jettag_c_when_119_308 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_119_308); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_119_308.setRuntimeParent(_jettag_c_choose_119_53);
                        _jettag_c_when_119_308.setTagInfo(_td_c_when_119_308);
                        _jettag_c_when_119_308.doStart(context, out);
                        JET2Writer _jettag_c_when_119_308_saved_out = out;
                        while (_jettag_c_when_119_308.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" Long ");  //$NON-NLS-1$        
                            _jettag_c_when_119_308.handleBodyContent(out);
                        }
                        out = _jettag_c_when_119_308_saved_out;
                        _jettag_c_when_119_308.doEnd();
                        RuntimeTagElement _jettag_c_when_119_352 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_119_352); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_119_352.setRuntimeParent(_jettag_c_choose_119_53);
                        _jettag_c_when_119_352.setTagInfo(_td_c_when_119_352);
                        _jettag_c_when_119_352.doStart(context, out);
                        JET2Writer _jettag_c_when_119_352_saved_out = out;
                        while (_jettag_c_when_119_352.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Float");  //$NON-NLS-1$        
                            _jettag_c_when_119_352.handleBodyContent(out);
                        }
                        out = _jettag_c_when_119_352_saved_out;
                        _jettag_c_when_119_352.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_119_397 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_119_397); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_119_397.setRuntimeParent(_jettag_c_choose_119_53);
                        _jettag_c_when_119_397.setTagInfo(_td_c_when_119_397);
                        _jettag_c_when_119_397.doStart(context, out);
                        JET2Writer _jettag_c_when_119_397_saved_out = out;
                        while (_jettag_c_when_119_397.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_119_397.handleBodyContent(out);
                        }
                        out = _jettag_c_when_119_397_saved_out;
                        _jettag_c_when_119_397.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_119_443 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_119_443); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_119_443.setRuntimeParent(_jettag_c_choose_119_53);
                        _jettag_c_when_119_443.setTagInfo(_td_c_when_119_443);
                        _jettag_c_when_119_443.doStart(context, out);
                        JET2Writer _jettag_c_when_119_443_saved_out = out;
                        while (_jettag_c_when_119_443.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_119_443.handleBodyContent(out);
                        }
                        out = _jettag_c_when_119_443_saved_out;
                        _jettag_c_when_119_443.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_119_492 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_119_492); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_119_492.setRuntimeParent(_jettag_c_choose_119_53);
                        _jettag_c_when_119_492.setTagInfo(_td_c_when_119_492);
                        _jettag_c_when_119_492.doStart(context, out);
                        JET2Writer _jettag_c_when_119_492_saved_out = out;
                        while (_jettag_c_when_119_492.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("BigDecimal");  //$NON-NLS-1$        
                            _jettag_c_when_119_492.handleBodyContent(out);
                        }
                        out = _jettag_c_when_119_492_saved_out;
                        _jettag_c_when_119_492.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_otherwise_119_545 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_119_545); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_119_545.setRuntimeParent(_jettag_c_choose_119_53);
                        _jettag_c_otherwise_119_545.setTagInfo(_td_c_otherwise_119_545);
                        _jettag_c_otherwise_119_545.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_119_545_saved_out = out;
                        while (_jettag_c_otherwise_119_545.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(NL);         
                            RuntimeTagElement _jettag_c_iterate_120_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_120_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_120_4.setRuntimeParent(_jettag_c_otherwise_119_545);
                            _jettag_c_iterate_120_4.setTagInfo(_td_c_iterate_120_4);
                            _jettag_c_iterate_120_4.doStart(context, out);
                            while (_jettag_c_iterate_120_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_121_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_121_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_121_6.setRuntimeParent(_jettag_c_iterate_120_4);
                                _jettag_c_if_121_6.setTagInfo(_td_c_if_121_6);
                                _jettag_c_if_121_6.doStart(context, out);
                                while (_jettag_c_if_121_6.okToProcessBody()) {
                                    out.write("\t \t\t\t ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$enumeration/@name}", 122, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(" ");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_121_6.handleBodyContent(out);
                                }
                                _jettag_c_if_121_6.doEnd();
                                _jettag_c_iterate_120_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_120_4.doEnd();
                            out.write("\t \t  ");  //$NON-NLS-1$        
                            _jettag_c_otherwise_119_545.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_119_545_saved_out;
                        _jettag_c_otherwise_119_545.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        _jettag_c_choose_119_53.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_119_53_saved_out;
                    _jettag_c_choose_119_53.doEnd();
                    out.write(" ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_get_125_33 = context.getTagFactory().createRuntimeTag(_jetns_c, "get", "c:get", _td_c_get_125_33); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_get_125_33.setRuntimeParent(_jettag_c_iterate_108_1);
                    _jettag_c_get_125_33.setTagInfo(_td_c_get_125_33);
                    _jettag_c_get_125_33.doStart(context, out);
                    _jettag_c_get_125_33.doEnd();
                    out.write(");");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_iterate_108_1.handleBodyContent(out);
                }
                _jettag_c_iterate_108_1.doEnd();
                // user defined types getters and setters-->
                //<%--getters for collection attributes 
                RuntimeTagElement _jettag_c_iterate_130_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_130_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_130_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_130_2.setTagInfo(_td_c_iterate_130_2);
                _jettag_c_iterate_130_2.doStart(context, out);
                while (_jettag_c_iterate_130_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_131_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_131_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_131_2.setRuntimeParent(_jettag_c_iterate_130_2);
                    _jettag_c_iterate_131_2.setTagInfo(_td_c_iterate_131_2);
                    _jettag_c_iterate_131_2.doStart(context, out);
                    while (_jettag_c_iterate_131_2.okToProcessBody()) {
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        RuntimeTagElement _jettag_c_iterate_133_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_133_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_133_3.setRuntimeParent(_jettag_c_iterate_131_2);
                        _jettag_c_iterate_133_3.setTagInfo(_td_c_iterate_133_3);
                        _jettag_c_iterate_133_3.doStart(context, out);
                        while (_jettag_c_iterate_133_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_134_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_134_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_134_4.setRuntimeParent(_jettag_c_iterate_133_3);
                            _jettag_c_setVariable_134_4.setTagInfo(_td_c_setVariable_134_4);
                            _jettag_c_setVariable_134_4.doStart(context, out);
                            _jettag_c_setVariable_134_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_136_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_136_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_136_6.setRuntimeParent(_jettag_c_iterate_133_3);
                            _jettag_c_if_136_6.setTagInfo(_td_c_if_136_6);
                            _jettag_c_if_136_6.doStart(context, out);
                            while (_jettag_c_if_136_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_138_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_138_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_138_12.setRuntimeParent(_jettag_c_if_136_6);
                                _jettag_c_iterate_138_12.setTagInfo(_td_c_iterate_138_12);
                                _jettag_c_iterate_138_12.doStart(context, out);
                                while (_jettag_c_iterate_138_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_139_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_139_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_139_12.setRuntimeParent(_jettag_c_iterate_138_12);
                                    _jettag_c_setVariable_139_12.setTagInfo(_td_c_setVariable_139_12);
                                    _jettag_c_setVariable_139_12.doStart(context, out);
                                    _jettag_c_setVariable_139_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_141_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_141_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_141_14.setRuntimeParent(_jettag_c_iterate_138_12);
                                    _jettag_c_if_141_14.setTagInfo(_td_c_if_141_14);
                                    _jettag_c_if_141_14.doStart(context, out);
                                    while (_jettag_c_if_141_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_143_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_143_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_143_15.setRuntimeParent(_jettag_c_if_141_14);
                                        _jettag_c_iterate_143_15.setTagInfo(_td_c_iterate_143_15);
                                        _jettag_c_iterate_143_15.doStart(context, out);
                                        while (_jettag_c_iterate_143_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_144_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_144_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_144_16.setRuntimeParent(_jettag_c_iterate_143_15);
                                            _jettag_c_if_144_16.setTagInfo(_td_c_if_144_16);
                                            _jettag_c_if_144_16.doStart(context, out);
                                            while (_jettag_c_if_144_16.okToProcessBody()) {
                                                out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                // check to see the association is navigable in the first case
                                                RuntimeTagElement _jettag_c_if_147_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_147_13); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_147_13.setRuntimeParent(_jettag_c_if_144_16);
                                                _jettag_c_if_147_13.setTagInfo(_td_c_if_147_13);
                                                _jettag_c_if_147_13.doStart(context, out);
                                                while (_jettag_c_if_147_13.okToProcessBody()) {
                                                    // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                    // check if target is one side
                                                    RuntimeTagElement _jettag_c_if_150_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_150_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_150_16.setRuntimeParent(_jettag_c_if_147_13);
                                                    _jettag_c_if_150_16.setTagInfo(_td_c_if_150_16);
                                                    _jettag_c_if_150_16.doStart(context, out);
                                                    while (_jettag_c_if_150_16.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_151_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_151_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_151_18.setRuntimeParent(_jettag_c_if_150_16);
                                                        _jettag_c_if_151_18.setTagInfo(_td_c_if_151_18);
                                                        _jettag_c_if_151_18.doStart(context, out);
                                                        while (_jettag_c_if_151_18.okToProcessBody()) {
                                                            // gettter returning a non collection
                                                            out.write(" ");  //$NON-NLS-1$        
                                                            RuntimeTagElement _jettag_f_message_153_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_153_2); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_153_2.setRuntimeParent(_jettag_c_if_151_18);
                                                            _jettag_f_message_153_2.setTagInfo(_td_f_message_153_2);
                                                            _jettag_f_message_153_2.doStart(context, out);
                                                            JET2Writer _jettag_f_message_153_2_saved_out = out;
                                                            while (_jettag_f_message_153_2.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_153_2.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_153_2_saved_out;
                                                            _jettag_f_message_153_2.doEnd();
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write(" public \t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 154, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Proxy get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 154, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("();");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            // setter returning a non clooection
                                                            RuntimeTagElement _jettag_f_message_156_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_156_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_156_1.setRuntimeParent(_jettag_c_if_151_18);
                                                            _jettag_f_message_156_1.setTagInfo(_td_f_message_156_1);
                                                            _jettag_f_message_156_1.doStart(context, out);
                                                            JET2Writer _jettag_f_message_156_1_saved_out = out;
                                                            while (_jettag_f_message_156_1.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_156_1.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_156_1_saved_out;
                                                            _jettag_f_message_156_1.doEnd();
                                                            out.write(NL);         
                                                            out.write("  public \tvoid set");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 157, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("(");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 157, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("Proxy ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 157, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write(" ");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_151_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_151_18.doEnd();
                                                        _jettag_c_if_150_16.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_150_16.doEnd();
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    // check if target is many side
                                                    RuntimeTagElement _jettag_c_if_163_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_163_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_163_17.setRuntimeParent(_jettag_c_if_147_13);
                                                    _jettag_c_if_163_17.setTagInfo(_td_c_if_163_17);
                                                    _jettag_c_if_163_17.doStart(context, out);
                                                    while (_jettag_c_if_163_17.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_164_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_164_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_164_18.setRuntimeParent(_jettag_c_if_163_17);
                                                        _jettag_c_if_164_18.setTagInfo(_td_c_if_164_18);
                                                        _jettag_c_if_164_18.doStart(context, out);
                                                        while (_jettag_c_if_164_18.okToProcessBody()) {
                                                            out.write("   \t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            // check if source is many side
                                                            // this is a many to many
                                                            RuntimeTagElement _jettag_c_if_168_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_168_13); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_168_13.setRuntimeParent(_jettag_c_if_164_18);
                                                            _jettag_c_if_168_13.setTagInfo(_td_c_if_168_13);
                                                            _jettag_c_if_168_13.doStart(context, out);
                                                            while (_jettag_c_if_168_13.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_c_if_169_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_169_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_169_19.setRuntimeParent(_jettag_c_if_168_13);
                                                                _jettag_c_if_169_19.setTagInfo(_td_c_if_169_19);
                                                                _jettag_c_if_169_19.doStart(context, out);
                                                                while (_jettag_c_if_169_19.okToProcessBody()) {
                                                                    // gettter returning a collection
                                                                    out.write("\t  \t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_171_19 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_171_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_171_19.setRuntimeParent(_jettag_c_if_169_19);
                                                                    _jettag_f_message_171_19.setTagInfo(_td_f_message_171_19);
                                                                    _jettag_f_message_171_19.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_171_19_saved_out = out;
                                                                    while (_jettag_f_message_171_19.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_171_19.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_171_19_saved_out;
                                                                    _jettag_f_message_171_19.doEnd();
                                                                    out.write("\t\t\t    \t\t\t\t\t\t\t\t\t\t\t    \t\t\t\t\t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t public \tSet<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 172, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Proxy>  get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 172, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    // setter returning a collection
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_174_15 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_174_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_174_15.setRuntimeParent(_jettag_c_if_169_19);
                                                                    _jettag_f_message_174_15.setTagInfo(_td_f_message_174_15);
                                                                    _jettag_f_message_174_15.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_174_15_saved_out = out;
                                                                    while (_jettag_f_message_174_15.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_174_15.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_174_15_saved_out;
                                                                    _jettag_f_message_174_15.doEnd();
                                                                    out.write("\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t public \t  void set");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 175, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(Set<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 175, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Proxy> ");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 175, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_169_19.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_169_19.doEnd();
                                                                _jettag_c_if_168_13.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_168_13.doEnd();
                                                            // check if source is one side
                                                            // this is a one to many
                                                            RuntimeTagElement _jettag_c_if_180_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_180_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_180_17.setRuntimeParent(_jettag_c_if_164_18);
                                                            _jettag_c_if_180_17.setTagInfo(_td_c_if_180_17);
                                                            _jettag_c_if_180_17.doStart(context, out);
                                                            while (_jettag_c_if_180_17.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_c_if_181_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_181_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_181_19.setRuntimeParent(_jettag_c_if_180_17);
                                                                _jettag_c_if_181_19.setTagInfo(_td_c_if_181_19);
                                                                _jettag_c_if_181_19.doStart(context, out);
                                                                while (_jettag_c_if_181_19.okToProcessBody()) {
                                                                    // gettter returning a collection
                                                                    out.write("\t  \t\t\t\t\t    \t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_183_20 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_183_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_183_20.setRuntimeParent(_jettag_c_if_181_19);
                                                                    _jettag_f_message_183_20.setTagInfo(_td_f_message_183_20);
                                                                    _jettag_f_message_183_20.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_183_20_saved_out = out;
                                                                    while (_jettag_f_message_183_20.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_183_20.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_183_20_saved_out;
                                                                    _jettag_f_message_183_20.doEnd();
                                                                    out.write("\t\t\t    \t\t\t\t\t\t\t\t\t\t\t    \t\t\t\t\t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t public \tList<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 184, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Proxy>  get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 184, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    // setter returning a collection
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_186_15 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_186_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_186_15.setRuntimeParent(_jettag_c_if_181_19);
                                                                    _jettag_f_message_186_15.setTagInfo(_td_f_message_186_15);
                                                                    _jettag_f_message_186_15.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_186_15_saved_out = out;
                                                                    while (_jettag_f_message_186_15.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_186_15.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_186_15_saved_out;
                                                                    _jettag_f_message_186_15.doEnd();
                                                                    out.write("\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t public \t  void set");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 187, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(List<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 187, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("Proxy> ");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 187, 80)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_181_19.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_181_19.doEnd();
                                                                _jettag_c_if_180_17.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_180_17.doEnd();
                                                            out.write("  \t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_164_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_164_18.doEnd();
                                                        _jettag_c_if_163_17.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_163_17.doEnd();
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_147_13.handleBodyContent(out);
                                                }
                                                _jettag_c_if_147_13.doEnd();
                                                _jettag_c_if_144_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_144_16.doEnd();
                                            _jettag_c_iterate_143_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_143_15.doEnd();
                                        _jettag_c_if_141_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_141_14.doEnd();
                                    _jettag_c_iterate_138_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_138_12.doEnd();
                                _jettag_c_if_136_6.handleBodyContent(out);
                            }
                            _jettag_c_if_136_6.doEnd();
                            _jettag_c_iterate_133_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_133_3.doEnd();
                        _jettag_c_iterate_131_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_131_2.doEnd();
                    _jettag_c_iterate_130_2.handleBodyContent(out);
                }
                _jettag_c_iterate_130_2.doEnd();
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
