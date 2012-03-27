package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_jaxbjava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_jaxbjava() {
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
    private static final TagInfo _td_java_importsLocation_9_1 = new TagInfo("java:importsLocation", //$NON-NLS-1$
            9, 1,
            new String[] {
                "package", //$NON-NLS-1$
            },
            new String[] {
                "{$package/@name}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_24_1 = new TagInfo("f:message", //$NON-NLS-1$
            24, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_26_8 = new TagInfo("c:if", //$NON-NLS-1$
            26, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isAbstract = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_26_87 = new TagInfo("c:if", //$NON-NLS-1$
            26, 87,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@parentClass1Name = $class/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_27_1 = new TagInfo("f:message", //$NON-NLS-1$
            27, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_30_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            30, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_31_1 = new TagInfo("f:message", //$NON-NLS-1$
            31, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_32_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            32, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/ModelElement.stereotype/Stereotype", //$NON-NLS-1$
                "stereotype", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_33_3 = new TagInfo("c:if", //$NON-NLS-1$
            33, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$SizeID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_34_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            34, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/ModelElement.taggedValue", //$NON-NLS-1$
                "taggedvalue", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_35_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            35, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$taggedvalue/TaggedValue", //$NON-NLS-1$
                "subtag1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_37_6 = new TagInfo("c:if", //$NON-NLS-1$
            37, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$subtag1/TaggedValue.type/TagDefinition/@href = ${'$minID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_38_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            38, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$taggedvalue/TaggedValue", //$NON-NLS-1$
                "subtag2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_40_8 = new TagInfo("c:if", //$NON-NLS-1$
            40, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$subtag2/TaggedValue.type/TagDefinition/@href = ${'$maxID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_49_3 = new TagInfo("c:if", //$NON-NLS-1$
            49, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$MinID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_50_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            50, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/ModelElement.taggedValue", //$NON-NLS-1$
                "taggedvalue", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_51_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            51, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$taggedvalue/TaggedValue", //$NON-NLS-1$
                "subtag", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_53_6 = new TagInfo("c:if", //$NON-NLS-1$
            53, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$subtag/TaggedValue.type/TagDefinition/@href = ${'$minID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_59_3 = new TagInfo("c:if", //$NON-NLS-1$
            59, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$MaxID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_60_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            60, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/ModelElement.taggedValue", //$NON-NLS-1$
                "taggedvalue", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_61_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            61, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$taggedvalue/TaggedValue", //$NON-NLS-1$
                "subtag", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_63_6 = new TagInfo("c:if", //$NON-NLS-1$
            63, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$subtag/TaggedValue.type/TagDefinition/@href = ${'$maxID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_69_3 = new TagInfo("c:if", //$NON-NLS-1$
            69, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$DecimalMinID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_70_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            70, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/ModelElement.taggedValue", //$NON-NLS-1$
                "taggedvalue", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_71_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            71, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$taggedvalue/TaggedValue", //$NON-NLS-1$
                "subtag", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_73_6 = new TagInfo("c:if", //$NON-NLS-1$
            73, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$subtag/TaggedValue.type/TagDefinition/@href = ${'$minID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_79_3 = new TagInfo("c:if", //$NON-NLS-1$
            79, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$DecimalMaxID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_80_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            80, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/ModelElement.taggedValue", //$NON-NLS-1$
                "taggedvalue", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_81_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            81, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$taggedvalue/TaggedValue", //$NON-NLS-1$
                "subtag", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_83_6 = new TagInfo("c:if", //$NON-NLS-1$
            83, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$subtag/TaggedValue.type/TagDefinition/@href = ${'$maxID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_89_3 = new TagInfo("c:if", //$NON-NLS-1$
            89, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$NotNullID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_92_3 = new TagInfo("c:if", //$NON-NLS-1$
            92, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$NotEmptyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_95_3 = new TagInfo("c:if", //$NON-NLS-1$
            95, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$PastID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_98_3 = new TagInfo("c:if", //$NON-NLS-1$
            98, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$FutureID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_103_3 = new TagInfo("c:choose", //$NON-NLS-1$
            103, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_103_73 = new TagInfo("c:when", //$NON-NLS-1$
            103, 73,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_103_132 = new TagInfo("c:when", //$NON-NLS-1$
            103, 132,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_103_192 = new TagInfo("c:when", //$NON-NLS-1$
            103, 192,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_103_246 = new TagInfo("c:when", //$NON-NLS-1$
            103, 246,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_103_306 = new TagInfo("c:when", //$NON-NLS-1$
            103, 306,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_103_360 = new TagInfo("c:when", //$NON-NLS-1$
            103, 360,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_103_417 = new TagInfo("c:when", //$NON-NLS-1$
            103, 417,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_103_475 = new TagInfo("c:when", //$NON-NLS-1$
            103, 475,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_103_535 = new TagInfo("c:when", //$NON-NLS-1$
            103, 535,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_104_4 = new TagInfo("c:otherwise", //$NON-NLS-1$
            104, 4,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_105_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            105, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_106_7 = new TagInfo("c:if", //$NON-NLS-1$
            106, 7,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_117_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            117, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_119_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            119, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_121_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            121, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_122_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            122, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_124_6 = new TagInfo("c:if", //$NON-NLS-1$
            124, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_126_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            126, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_127_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            127, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_129_14 = new TagInfo("c:if", //$NON-NLS-1$
            129, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_131_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            131, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_132_16 = new TagInfo("c:if", //$NON-NLS-1$
            132, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_133_3 = new TagInfo("f:message", //$NON-NLS-1$
            133, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_135_13 = new TagInfo("c:if", //$NON-NLS-1$
            135, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_138_16 = new TagInfo("c:if", //$NON-NLS-1$
            138, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_139_18 = new TagInfo("c:if", //$NON-NLS-1$
            139, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_144_17 = new TagInfo("c:if", //$NON-NLS-1$
            144, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_145_18 = new TagInfo("c:if", //$NON-NLS-1$
            145, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_160_1 = new TagInfo("c:if", //$NON-NLS-1$
            160, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isAbstract = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_161_1 = new TagInfo("f:message", //$NON-NLS-1$
            161, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_168_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            168, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_170_2 = new TagInfo("f:message", //$NON-NLS-1$
            170, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_choose_171_10 = new TagInfo("c:choose", //$NON-NLS-1$
            171, 10,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_171_81 = new TagInfo("c:when", //$NON-NLS-1$
            171, 81,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_171_128 = new TagInfo("c:when", //$NON-NLS-1$
            171, 128,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_171_176 = new TagInfo("c:when", //$NON-NLS-1$
            171, 176,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_171_218 = new TagInfo("c:when", //$NON-NLS-1$
            171, 218,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_171_266 = new TagInfo("c:when", //$NON-NLS-1$
            171, 266,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_171_310 = new TagInfo("c:when", //$NON-NLS-1$
            171, 310,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_171_355 = new TagInfo("c:when", //$NON-NLS-1$
            171, 355,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_171_401 = new TagInfo("c:when", //$NON-NLS-1$
            171, 401,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_171_450 = new TagInfo("c:when", //$NON-NLS-1$
            171, 450,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_171_503 = new TagInfo("c:otherwise", //$NON-NLS-1$
            171, 503,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_172_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            172, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_173_6 = new TagInfo("c:if", //$NON-NLS-1$
            173, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_180_2 = new TagInfo("f:message", //$NON-NLS-1$
            180, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_choose_181_53 = new TagInfo("c:choose", //$NON-NLS-1$
            181, 53,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_181_123 = new TagInfo("c:when", //$NON-NLS-1$
            181, 123,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_181_170 = new TagInfo("c:when", //$NON-NLS-1$
            181, 170,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_181_218 = new TagInfo("c:when", //$NON-NLS-1$
            181, 218,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_181_260 = new TagInfo("c:when", //$NON-NLS-1$
            181, 260,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_181_308 = new TagInfo("c:when", //$NON-NLS-1$
            181, 308,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_181_352 = new TagInfo("c:when", //$NON-NLS-1$
            181, 352,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_181_397 = new TagInfo("c:when", //$NON-NLS-1$
            181, 397,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_181_443 = new TagInfo("c:when", //$NON-NLS-1$
            181, 443,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_181_492 = new TagInfo("c:when", //$NON-NLS-1$
            181, 492,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_181_545 = new TagInfo("c:otherwise", //$NON-NLS-1$
            181, 545,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_182_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            182, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_183_6 = new TagInfo("c:if", //$NON-NLS-1$
            183, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_get_187_33 = new TagInfo("c:get", //$NON-NLS-1$
            187, 33,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_194_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            194, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_195_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            195, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_197_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            197, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_198_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            198, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_200_6 = new TagInfo("c:if", //$NON-NLS-1$
            200, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_202_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            202, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_203_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            203, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_205_14 = new TagInfo("c:if", //$NON-NLS-1$
            205, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_207_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            207, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_208_16 = new TagInfo("c:if", //$NON-NLS-1$
            208, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_211_13 = new TagInfo("c:if", //$NON-NLS-1$
            211, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_214_16 = new TagInfo("c:if", //$NON-NLS-1$
            214, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_215_18 = new TagInfo("c:if", //$NON-NLS-1$
            215, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_217_2 = new TagInfo("f:message", //$NON-NLS-1$
            217, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_223_1 = new TagInfo("f:message", //$NON-NLS-1$
            223, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_232_17 = new TagInfo("c:if", //$NON-NLS-1$
            232, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_233_18 = new TagInfo("c:if", //$NON-NLS-1$
            233, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_237_13 = new TagInfo("c:if", //$NON-NLS-1$
            237, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_238_19 = new TagInfo("c:if", //$NON-NLS-1$
            238, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_240_19 = new TagInfo("f:message", //$NON-NLS-1$
            240, 19,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_252_15 = new TagInfo("f:message", //$NON-NLS-1$
            252, 15,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_257_16 = new TagInfo("f:message", //$NON-NLS-1$
            257, 16,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_268_17 = new TagInfo("c:if", //$NON-NLS-1$
            268, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_269_19 = new TagInfo("c:if", //$NON-NLS-1$
            269, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_271_20 = new TagInfo("f:message", //$NON-NLS-1$
            271, 20,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_282_15 = new TagInfo("f:message", //$NON-NLS-1$
            282, 15,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_287_21 = new TagInfo("f:message", //$NON-NLS-1$
            287, 21,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_311_2 = new TagInfo("f:message", //$NON-NLS-1$
            311, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_314_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            314, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_315_3 = new TagInfo("c:choose", //$NON-NLS-1$
            315, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_315_73 = new TagInfo("c:when", //$NON-NLS-1$
            315, 73,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
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
                out.write(NL);         
                out.write("package ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$groupID}", 7, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(".");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 7, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(" ");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_java_importsLocation_9_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "importsLocation", "java:importsLocation", _td_java_importsLocation_9_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_java_importsLocation_9_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_java_importsLocation_9_1.setTagInfo(_td_java_importsLocation_9_1);
                _jettag_java_importsLocation_9_1.doStart(context, out);
                _jettag_java_importsLocation_9_1.doEnd();
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
                out.write("import javax.xml.bind.annotation.XmlRootElement;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.xml.bind.annotation.XmlElement;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.xml.bind.annotation.XmlTransient;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import javax.validation.constraints.*;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_24_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_24_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_24_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_24_1.setTagInfo(_td_f_message_24_1);
                _jettag_f_message_24_1.doStart(context, out);
                JET2Writer _jettag_f_message_24_1_saved_out = out;
                while (_jettag_f_message_24_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_24_1.handleBodyContent(out);
                }
                out = _jettag_f_message_24_1_saved_out;
                _jettag_f_message_24_1.doEnd();
                out.write(NL);         
                out.write("@XmlRootElement");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_if_26_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_26_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_26_8.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_26_8.setTagInfo(_td_c_if_26_8);
                _jettag_c_if_26_8.doStart(context, out);
                while (_jettag_c_if_26_8.okToProcessBody()) {
                    out.write("abstract");  //$NON-NLS-1$        
                    _jettag_c_if_26_8.handleBodyContent(out);
                }
                _jettag_c_if_26_8.doEnd();
                out.write(" class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 26, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_if_26_87 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_26_87); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_26_87.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_26_87.setTagInfo(_td_c_if_26_87);
                _jettag_c_if_26_87.doStart(context, out);
                while (_jettag_c_if_26_87.okToProcessBody()) {
                    out.write(" extends ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@parentClass1Name}", 26, 154)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(" ");  //$NON-NLS-1$        
                    _jettag_c_if_26_87.handleBodyContent(out);
                }
                _jettag_c_if_26_87.doEnd();
                out.write(" {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_27_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_27_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_27_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_27_1.setTagInfo(_td_f_message_27_1);
                _jettag_f_message_27_1.doStart(context, out);
                JET2Writer _jettag_f_message_27_1_saved_out = out;
                while (_jettag_f_message_27_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_27_1.handleBodyContent(out);
                }
                out = _jettag_f_message_27_1_saved_out;
                _jettag_f_message_27_1.doEnd();
                out.write(NL);         
                out.write(NL);         
                // Process annotations on the primitive datatypes
                RuntimeTagElement _jettag_c_iterate_30_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_30_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_30_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_30_1.setTagInfo(_td_c_iterate_30_1);
                _jettag_c_iterate_30_1.doStart(context, out);
                while (_jettag_c_iterate_30_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_f_message_31_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_31_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_31_1.setRuntimeParent(_jettag_c_iterate_30_1);
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
                    RuntimeTagElement _jettag_c_iterate_32_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_32_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_32_2.setRuntimeParent(_jettag_c_iterate_30_1);
                    _jettag_c_iterate_32_2.setTagInfo(_td_c_iterate_32_2);
                    _jettag_c_iterate_32_2.doStart(context, out);
                    while (_jettag_c_iterate_32_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_33_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_33_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_33_3.setRuntimeParent(_jettag_c_iterate_32_2);
                        _jettag_c_if_33_3.setTagInfo(_td_c_if_33_3);
                        _jettag_c_if_33_3.doStart(context, out);
                        while (_jettag_c_if_33_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_34_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_34_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_34_4.setRuntimeParent(_jettag_c_if_33_3);
                            _jettag_c_iterate_34_4.setTagInfo(_td_c_iterate_34_4);
                            _jettag_c_iterate_34_4.doStart(context, out);
                            while (_jettag_c_iterate_34_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_35_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_35_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_35_5.setRuntimeParent(_jettag_c_iterate_34_4);
                                _jettag_c_iterate_35_5.setTagInfo(_td_c_iterate_35_5);
                                _jettag_c_iterate_35_5.doStart(context, out);
                                while (_jettag_c_iterate_35_5.okToProcessBody()) {
                                    // If MIN length TAG
                                    RuntimeTagElement _jettag_c_if_37_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_37_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_37_6.setRuntimeParent(_jettag_c_iterate_35_5);
                                    _jettag_c_if_37_6.setTagInfo(_td_c_if_37_6);
                                    _jettag_c_if_37_6.doStart(context, out);
                                    while (_jettag_c_if_37_6.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_iterate_38_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_38_7); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_38_7.setRuntimeParent(_jettag_c_if_37_6);
                                        _jettag_c_iterate_38_7.setTagInfo(_td_c_iterate_38_7);
                                        _jettag_c_iterate_38_7.doStart(context, out);
                                        while (_jettag_c_iterate_38_7.okToProcessBody()) {
                                            // If MAX length TAG
                                            RuntimeTagElement _jettag_c_if_40_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_40_8); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_40_8.setRuntimeParent(_jettag_c_iterate_38_7);
                                            _jettag_c_if_40_8.setTagInfo(_td_c_if_40_8);
                                            _jettag_c_if_40_8.doStart(context, out);
                                            while (_jettag_c_if_40_8.okToProcessBody()) {
                                                out.write("@Size(min=");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$subtag1/TaggedValue.dataValue}", 41, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write(",max=");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$subtag2/TaggedValue.dataValue}", 41, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write(")\t");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                _jettag_c_if_40_8.handleBodyContent(out);
                                            }
                                            _jettag_c_if_40_8.doEnd();
                                            _jettag_c_iterate_38_7.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_38_7.doEnd();
                                        out.write("\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_37_6.handleBodyContent(out);
                                    }
                                    _jettag_c_if_37_6.doEnd();
                                    _jettag_c_iterate_35_5.handleBodyContent(out);
                                }
                                _jettag_c_iterate_35_5.doEnd();
                                _jettag_c_iterate_34_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_34_4.doEnd();
                            _jettag_c_if_33_3.handleBodyContent(out);
                        }
                        _jettag_c_if_33_3.doEnd();
                        RuntimeTagElement _jettag_c_if_49_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_49_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_49_3.setRuntimeParent(_jettag_c_iterate_32_2);
                        _jettag_c_if_49_3.setTagInfo(_td_c_if_49_3);
                        _jettag_c_if_49_3.doStart(context, out);
                        while (_jettag_c_if_49_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_50_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_50_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_50_4.setRuntimeParent(_jettag_c_if_49_3);
                            _jettag_c_iterate_50_4.setTagInfo(_td_c_iterate_50_4);
                            _jettag_c_iterate_50_4.doStart(context, out);
                            while (_jettag_c_iterate_50_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_51_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_51_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_51_5.setRuntimeParent(_jettag_c_iterate_50_4);
                                _jettag_c_iterate_51_5.setTagInfo(_td_c_iterate_51_5);
                                _jettag_c_iterate_51_5.doStart(context, out);
                                while (_jettag_c_iterate_51_5.okToProcessBody()) {
                                    // If MIN length TAG
                                    RuntimeTagElement _jettag_c_if_53_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_53_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_53_6.setRuntimeParent(_jettag_c_iterate_51_5);
                                    _jettag_c_if_53_6.setTagInfo(_td_c_if_53_6);
                                    _jettag_c_if_53_6.doStart(context, out);
                                    while (_jettag_c_if_53_6.okToProcessBody()) {
                                        out.write("@Min(");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$subtag/TaggedValue.dataValue}", 54, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(")\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_53_6.handleBodyContent(out);
                                    }
                                    _jettag_c_if_53_6.doEnd();
                                    _jettag_c_iterate_51_5.handleBodyContent(out);
                                }
                                _jettag_c_iterate_51_5.doEnd();
                                _jettag_c_iterate_50_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_50_4.doEnd();
                            _jettag_c_if_49_3.handleBodyContent(out);
                        }
                        _jettag_c_if_49_3.doEnd();
                        RuntimeTagElement _jettag_c_if_59_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_59_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_59_3.setRuntimeParent(_jettag_c_iterate_32_2);
                        _jettag_c_if_59_3.setTagInfo(_td_c_if_59_3);
                        _jettag_c_if_59_3.doStart(context, out);
                        while (_jettag_c_if_59_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_60_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_60_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_60_4.setRuntimeParent(_jettag_c_if_59_3);
                            _jettag_c_iterate_60_4.setTagInfo(_td_c_iterate_60_4);
                            _jettag_c_iterate_60_4.doStart(context, out);
                            while (_jettag_c_iterate_60_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_61_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_61_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_61_5.setRuntimeParent(_jettag_c_iterate_60_4);
                                _jettag_c_iterate_61_5.setTagInfo(_td_c_iterate_61_5);
                                _jettag_c_iterate_61_5.doStart(context, out);
                                while (_jettag_c_iterate_61_5.okToProcessBody()) {
                                    // If MIN length TAG
                                    RuntimeTagElement _jettag_c_if_63_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_63_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_63_6.setRuntimeParent(_jettag_c_iterate_61_5);
                                    _jettag_c_if_63_6.setTagInfo(_td_c_if_63_6);
                                    _jettag_c_if_63_6.doStart(context, out);
                                    while (_jettag_c_if_63_6.okToProcessBody()) {
                                        out.write("@Max(");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$subtag/TaggedValue.dataValue}", 64, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(")\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_63_6.handleBodyContent(out);
                                    }
                                    _jettag_c_if_63_6.doEnd();
                                    _jettag_c_iterate_61_5.handleBodyContent(out);
                                }
                                _jettag_c_iterate_61_5.doEnd();
                                _jettag_c_iterate_60_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_60_4.doEnd();
                            _jettag_c_if_59_3.handleBodyContent(out);
                        }
                        _jettag_c_if_59_3.doEnd();
                        RuntimeTagElement _jettag_c_if_69_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_69_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_69_3.setRuntimeParent(_jettag_c_iterate_32_2);
                        _jettag_c_if_69_3.setTagInfo(_td_c_if_69_3);
                        _jettag_c_if_69_3.doStart(context, out);
                        while (_jettag_c_if_69_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_70_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_70_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_70_4.setRuntimeParent(_jettag_c_if_69_3);
                            _jettag_c_iterate_70_4.setTagInfo(_td_c_iterate_70_4);
                            _jettag_c_iterate_70_4.doStart(context, out);
                            while (_jettag_c_iterate_70_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_71_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_71_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_71_5.setRuntimeParent(_jettag_c_iterate_70_4);
                                _jettag_c_iterate_71_5.setTagInfo(_td_c_iterate_71_5);
                                _jettag_c_iterate_71_5.doStart(context, out);
                                while (_jettag_c_iterate_71_5.okToProcessBody()) {
                                    // If MIN length TAG
                                    RuntimeTagElement _jettag_c_if_73_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_73_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_73_6.setRuntimeParent(_jettag_c_iterate_71_5);
                                    _jettag_c_if_73_6.setTagInfo(_td_c_if_73_6);
                                    _jettag_c_if_73_6.doStart(context, out);
                                    while (_jettag_c_if_73_6.okToProcessBody()) {
                                        out.write("@DecimalMin(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$subtag/TaggedValue.dataValue}", 74, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\")\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_73_6.handleBodyContent(out);
                                    }
                                    _jettag_c_if_73_6.doEnd();
                                    _jettag_c_iterate_71_5.handleBodyContent(out);
                                }
                                _jettag_c_iterate_71_5.doEnd();
                                _jettag_c_iterate_70_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_70_4.doEnd();
                            _jettag_c_if_69_3.handleBodyContent(out);
                        }
                        _jettag_c_if_69_3.doEnd();
                        RuntimeTagElement _jettag_c_if_79_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_79_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_79_3.setRuntimeParent(_jettag_c_iterate_32_2);
                        _jettag_c_if_79_3.setTagInfo(_td_c_if_79_3);
                        _jettag_c_if_79_3.doStart(context, out);
                        while (_jettag_c_if_79_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_80_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_80_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_80_4.setRuntimeParent(_jettag_c_if_79_3);
                            _jettag_c_iterate_80_4.setTagInfo(_td_c_iterate_80_4);
                            _jettag_c_iterate_80_4.doStart(context, out);
                            while (_jettag_c_iterate_80_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_81_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_81_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_81_5.setRuntimeParent(_jettag_c_iterate_80_4);
                                _jettag_c_iterate_81_5.setTagInfo(_td_c_iterate_81_5);
                                _jettag_c_iterate_81_5.doStart(context, out);
                                while (_jettag_c_iterate_81_5.okToProcessBody()) {
                                    // If MIN length TAG
                                    RuntimeTagElement _jettag_c_if_83_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_83_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_83_6.setRuntimeParent(_jettag_c_iterate_81_5);
                                    _jettag_c_if_83_6.setTagInfo(_td_c_if_83_6);
                                    _jettag_c_if_83_6.doStart(context, out);
                                    while (_jettag_c_if_83_6.okToProcessBody()) {
                                        out.write("@DecimalMax(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$subtag/TaggedValue.dataValue}", 84, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\")\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_83_6.handleBodyContent(out);
                                    }
                                    _jettag_c_if_83_6.doEnd();
                                    _jettag_c_iterate_81_5.handleBodyContent(out);
                                }
                                _jettag_c_iterate_81_5.doEnd();
                                _jettag_c_iterate_80_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_80_4.doEnd();
                            _jettag_c_if_79_3.handleBodyContent(out);
                        }
                        _jettag_c_if_79_3.doEnd();
                        RuntimeTagElement _jettag_c_if_89_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_89_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_89_3.setRuntimeParent(_jettag_c_iterate_32_2);
                        _jettag_c_if_89_3.setTagInfo(_td_c_if_89_3);
                        _jettag_c_if_89_3.doStart(context, out);
                        while (_jettag_c_if_89_3.okToProcessBody()) {
                            out.write("@NotNull");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_89_3.handleBodyContent(out);
                        }
                        _jettag_c_if_89_3.doEnd();
                        RuntimeTagElement _jettag_c_if_92_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_92_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_92_3.setRuntimeParent(_jettag_c_iterate_32_2);
                        _jettag_c_if_92_3.setTagInfo(_td_c_if_92_3);
                        _jettag_c_if_92_3.doStart(context, out);
                        while (_jettag_c_if_92_3.okToProcessBody()) {
                            out.write("@Size(min = 1)");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_92_3.handleBodyContent(out);
                        }
                        _jettag_c_if_92_3.doEnd();
                        RuntimeTagElement _jettag_c_if_95_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_95_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_95_3.setRuntimeParent(_jettag_c_iterate_32_2);
                        _jettag_c_if_95_3.setTagInfo(_td_c_if_95_3);
                        _jettag_c_if_95_3.doStart(context, out);
                        while (_jettag_c_if_95_3.okToProcessBody()) {
                            out.write("@Past");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_95_3.handleBodyContent(out);
                        }
                        _jettag_c_if_95_3.doEnd();
                        RuntimeTagElement _jettag_c_if_98_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_98_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_98_3.setRuntimeParent(_jettag_c_iterate_32_2);
                        _jettag_c_if_98_3.setTagInfo(_td_c_if_98_3);
                        _jettag_c_if_98_3.doStart(context, out);
                        while (_jettag_c_if_98_3.okToProcessBody()) {
                            out.write("@Future");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_98_3.handleBodyContent(out);
                        }
                        _jettag_c_if_98_3.doEnd();
                        _jettag_c_iterate_32_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_32_2.doEnd();
                    // processes the premitive Datatypes and enums
                    out.write("\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_choose_103_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_103_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_103_3.setRuntimeParent(_jettag_c_iterate_30_1);
                    _jettag_c_choose_103_3.setTagInfo(_td_c_choose_103_3);
                    _jettag_c_choose_103_3.doStart(context, out);
                    JET2Writer _jettag_c_choose_103_3_saved_out = out;
                    while (_jettag_c_choose_103_3.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_103_73 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_103_73); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_103_73.setRuntimeParent(_jettag_c_choose_103_3);
                        _jettag_c_when_103_73.setTagInfo(_td_c_when_103_73);
                        _jettag_c_when_103_73.doStart(context, out);
                        JET2Writer _jettag_c_when_103_73_saved_out = out;
                        while (_jettag_c_when_103_73.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected String ");  //$NON-NLS-1$        
                            _jettag_c_when_103_73.handleBodyContent(out);
                        }
                        out = _jettag_c_when_103_73_saved_out;
                        _jettag_c_when_103_73.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_103_132 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_103_132); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_103_132.setRuntimeParent(_jettag_c_choose_103_3);
                        _jettag_c_when_103_132.setTagInfo(_td_c_when_103_132);
                        _jettag_c_when_103_132.doStart(context, out);
                        JET2Writer _jettag_c_when_103_132_saved_out = out;
                        while (_jettag_c_when_103_132.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected Integer ");  //$NON-NLS-1$        
                            _jettag_c_when_103_132.handleBodyContent(out);
                        }
                        out = _jettag_c_when_103_132_saved_out;
                        _jettag_c_when_103_132.doEnd();
                        RuntimeTagElement _jettag_c_when_103_192 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_103_192); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_103_192.setRuntimeParent(_jettag_c_choose_103_3);
                        _jettag_c_when_103_192.setTagInfo(_td_c_when_103_192);
                        _jettag_c_when_103_192.doStart(context, out);
                        JET2Writer _jettag_c_when_103_192_saved_out = out;
                        while (_jettag_c_when_103_192.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected Date ");  //$NON-NLS-1$        
                            _jettag_c_when_103_192.handleBodyContent(out);
                        }
                        out = _jettag_c_when_103_192_saved_out;
                        _jettag_c_when_103_192.doEnd();
                        RuntimeTagElement _jettag_c_when_103_246 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_103_246); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_103_246.setRuntimeParent(_jettag_c_choose_103_3);
                        _jettag_c_when_103_246.setTagInfo(_td_c_when_103_246);
                        _jettag_c_when_103_246.doStart(context, out);
                        JET2Writer _jettag_c_when_103_246_saved_out = out;
                        while (_jettag_c_when_103_246.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("protected  Boolean ");  //$NON-NLS-1$        
                            _jettag_c_when_103_246.handleBodyContent(out);
                        }
                        out = _jettag_c_when_103_246_saved_out;
                        _jettag_c_when_103_246.doEnd();
                        RuntimeTagElement _jettag_c_when_103_306 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_103_306); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_103_306.setRuntimeParent(_jettag_c_choose_103_3);
                        _jettag_c_when_103_306.setTagInfo(_td_c_when_103_306);
                        _jettag_c_when_103_306.doStart(context, out);
                        JET2Writer _jettag_c_when_103_306_saved_out = out;
                        while (_jettag_c_when_103_306.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected Long ");  //$NON-NLS-1$        
                            _jettag_c_when_103_306.handleBodyContent(out);
                        }
                        out = _jettag_c_when_103_306_saved_out;
                        _jettag_c_when_103_306.doEnd();
                        RuntimeTagElement _jettag_c_when_103_360 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_103_360); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_103_360.setRuntimeParent(_jettag_c_choose_103_3);
                        _jettag_c_when_103_360.setTagInfo(_td_c_when_103_360);
                        _jettag_c_when_103_360.doStart(context, out);
                        JET2Writer _jettag_c_when_103_360_saved_out = out;
                        while (_jettag_c_when_103_360.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected Float ");  //$NON-NLS-1$        
                            _jettag_c_when_103_360.handleBodyContent(out);
                        }
                        out = _jettag_c_when_103_360_saved_out;
                        _jettag_c_when_103_360.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_103_417 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_103_417); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_103_417.setRuntimeParent(_jettag_c_choose_103_3);
                        _jettag_c_when_103_417.setTagInfo(_td_c_when_103_417);
                        _jettag_c_when_103_417.doStart(context, out);
                        JET2Writer _jettag_c_when_103_417_saved_out = out;
                        while (_jettag_c_when_103_417.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected String ");  //$NON-NLS-1$        
                            _jettag_c_when_103_417.handleBodyContent(out);
                        }
                        out = _jettag_c_when_103_417_saved_out;
                        _jettag_c_when_103_417.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_103_475 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_103_475); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_103_475.setRuntimeParent(_jettag_c_choose_103_3);
                        _jettag_c_when_103_475.setTagInfo(_td_c_when_103_475);
                        _jettag_c_when_103_475.doStart(context, out);
                        JET2Writer _jettag_c_when_103_475_saved_out = out;
                        while (_jettag_c_when_103_475.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected String ");  //$NON-NLS-1$        
                            _jettag_c_when_103_475.handleBodyContent(out);
                        }
                        out = _jettag_c_when_103_475_saved_out;
                        _jettag_c_when_103_475.doEnd();
                        RuntimeTagElement _jettag_c_when_103_535 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_103_535); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_103_535.setRuntimeParent(_jettag_c_choose_103_3);
                        _jettag_c_when_103_535.setTagInfo(_td_c_when_103_535);
                        _jettag_c_when_103_535.doStart(context, out);
                        JET2Writer _jettag_c_when_103_535_saved_out = out;
                        while (_jettag_c_when_103_535.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" @Digits(fraction = 2, integer = 10) protected BigDecimal ");  //$NON-NLS-1$        
                            _jettag_c_when_103_535.handleBodyContent(out);
                        }
                        out = _jettag_c_when_103_535_saved_out;
                        _jettag_c_when_103_535.doEnd();
                        out.write(NL);         
                        RuntimeTagElement _jettag_c_otherwise_104_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_104_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_104_4.setRuntimeParent(_jettag_c_choose_103_3);
                        _jettag_c_otherwise_104_4.setTagInfo(_td_c_otherwise_104_4);
                        _jettag_c_otherwise_104_4.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_104_4_saved_out = out;
                        while (_jettag_c_otherwise_104_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_105_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_105_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_105_5.setRuntimeParent(_jettag_c_otherwise_104_4);
                            _jettag_c_iterate_105_5.setTagInfo(_td_c_iterate_105_5);
                            _jettag_c_iterate_105_5.doStart(context, out);
                            while (_jettag_c_iterate_105_5.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_106_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_106_7); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_106_7.setRuntimeParent(_jettag_c_iterate_105_5);
                                _jettag_c_if_106_7.setTagInfo(_td_c_if_106_7);
                                _jettag_c_if_106_7.doStart(context, out);
                                while (_jettag_c_if_106_7.okToProcessBody()) {
                                    out.write("\t\t \t\t\tprotected  ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$enumeration/@name}", 107, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(" ");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_106_7.handleBodyContent(out);
                                }
                                _jettag_c_if_106_7.doEnd();
                                _jettag_c_iterate_105_5.handleBodyContent(out);
                            }
                            _jettag_c_iterate_105_5.doEnd();
                            _jettag_c_otherwise_104_4.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_104_4_saved_out;
                        _jettag_c_otherwise_104_4.doEnd();
                        _jettag_c_choose_103_3.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_103_3_saved_out;
                    _jettag_c_choose_103_3.doEnd();
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 112, 1)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write(NL);         
                    _jettag_c_iterate_30_1.handleBodyContent(out);
                }
                _jettag_c_iterate_30_1.doEnd();
                out.write(NL);         
                // collections and user defined Datatypes 
                RuntimeTagElement _jettag_c_iterate_117_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_117_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_117_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_117_1.setTagInfo(_td_c_iterate_117_1);
                _jettag_c_iterate_117_1.doStart(context, out);
                while (_jettag_c_iterate_117_1.okToProcessBody()) {
                    out.write(NL);         
                    RuntimeTagElement _jettag_c_iterate_119_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_119_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_119_2.setRuntimeParent(_jettag_c_iterate_117_1);
                    _jettag_c_iterate_119_2.setTagInfo(_td_c_iterate_119_2);
                    _jettag_c_iterate_119_2.doStart(context, out);
                    while (_jettag_c_iterate_119_2.okToProcessBody()) {
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        RuntimeTagElement _jettag_c_iterate_121_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_121_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_121_3.setRuntimeParent(_jettag_c_iterate_119_2);
                        _jettag_c_iterate_121_3.setTagInfo(_td_c_iterate_121_3);
                        _jettag_c_iterate_121_3.doStart(context, out);
                        while (_jettag_c_iterate_121_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_122_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_122_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_122_4.setRuntimeParent(_jettag_c_iterate_121_3);
                            _jettag_c_setVariable_122_4.setTagInfo(_td_c_setVariable_122_4);
                            _jettag_c_setVariable_122_4.doStart(context, out);
                            _jettag_c_setVariable_122_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_124_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_124_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_124_6.setRuntimeParent(_jettag_c_iterate_121_3);
                            _jettag_c_if_124_6.setTagInfo(_td_c_if_124_6);
                            _jettag_c_if_124_6.doStart(context, out);
                            while (_jettag_c_if_124_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_126_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_126_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_126_12.setRuntimeParent(_jettag_c_if_124_6);
                                _jettag_c_iterate_126_12.setTagInfo(_td_c_iterate_126_12);
                                _jettag_c_iterate_126_12.doStart(context, out);
                                while (_jettag_c_iterate_126_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_127_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_127_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_127_12.setRuntimeParent(_jettag_c_iterate_126_12);
                                    _jettag_c_setVariable_127_12.setTagInfo(_td_c_setVariable_127_12);
                                    _jettag_c_setVariable_127_12.doStart(context, out);
                                    _jettag_c_setVariable_127_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_129_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_129_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_129_14.setRuntimeParent(_jettag_c_iterate_126_12);
                                    _jettag_c_if_129_14.setTagInfo(_td_c_if_129_14);
                                    _jettag_c_if_129_14.doStart(context, out);
                                    while (_jettag_c_if_129_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_131_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_131_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_131_15.setRuntimeParent(_jettag_c_if_129_14);
                                        _jettag_c_iterate_131_15.setTagInfo(_td_c_iterate_131_15);
                                        _jettag_c_iterate_131_15.doStart(context, out);
                                        while (_jettag_c_iterate_131_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_132_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_132_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_132_16.setRuntimeParent(_jettag_c_iterate_131_15);
                                            _jettag_c_if_132_16.setTagInfo(_td_c_if_132_16);
                                            _jettag_c_if_132_16.doStart(context, out);
                                            while (_jettag_c_if_132_16.okToProcessBody()) {
                                                out.write("  ");  //$NON-NLS-1$        
                                                RuntimeTagElement _jettag_f_message_133_3 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_133_3); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_f_message_133_3.setRuntimeParent(_jettag_c_if_132_16);
                                                _jettag_f_message_133_3.setTagInfo(_td_f_message_133_3);
                                                _jettag_f_message_133_3.doStart(context, out);
                                                JET2Writer _jettag_f_message_133_3_saved_out = out;
                                                while (_jettag_f_message_133_3.okToProcessBody()) {
                                                    out = out.newNestedContentWriter();
                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                    _jettag_f_message_133_3.handleBodyContent(out);
                                                }
                                                out = _jettag_f_message_133_3_saved_out;
                                                _jettag_f_message_133_3.doEnd();
                                                out.write("\t\t");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                // check to see the association is navigable in the first case
                                                RuntimeTagElement _jettag_c_if_135_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_135_13); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_135_13.setRuntimeParent(_jettag_c_if_132_16);
                                                _jettag_c_if_135_13.setTagInfo(_td_c_if_135_13);
                                                _jettag_c_if_135_13.doStart(context, out);
                                                while (_jettag_c_if_135_13.okToProcessBody()) {
                                                    // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                    // check if the multiplicityis one to one
                                                    RuntimeTagElement _jettag_c_if_138_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_138_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_138_16.setRuntimeParent(_jettag_c_if_135_13);
                                                    _jettag_c_if_138_16.setTagInfo(_td_c_if_138_16);
                                                    _jettag_c_if_138_16.doStart(context, out);
                                                    while (_jettag_c_if_138_16.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_139_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_139_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_139_18.setRuntimeParent(_jettag_c_if_138_16);
                                                        _jettag_c_if_139_18.setTagInfo(_td_c_if_139_18);
                                                        _jettag_c_if_139_18.doStart(context, out);
                                                        while (_jettag_c_if_139_18.okToProcessBody()) {
                                                            out.write(" protected \t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 140, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("  ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 140, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_139_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_139_18.doEnd();
                                                        _jettag_c_if_138_16.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_138_16.doEnd();
                                                    // check if the multiplicityis one to many
                                                    RuntimeTagElement _jettag_c_if_144_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_144_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_144_17.setRuntimeParent(_jettag_c_if_135_13);
                                                    _jettag_c_if_144_17.setTagInfo(_td_c_if_144_17);
                                                    _jettag_c_if_144_17.doStart(context, out);
                                                    while (_jettag_c_if_144_17.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_145_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_145_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_145_18.setRuntimeParent(_jettag_c_if_144_17);
                                                        _jettag_c_if_145_18.setTagInfo(_td_c_if_145_18);
                                                        _jettag_c_if_145_18.doStart(context, out);
                                                        while (_jettag_c_if_145_18.okToProcessBody()) {
                                                            out.write("  protected List<");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 146, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(">  ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 146, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s;\t\t\t\t\t    \t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_145_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_145_18.doEnd();
                                                        _jettag_c_if_144_17.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_144_17.doEnd();
                                                    _jettag_c_if_135_13.handleBodyContent(out);
                                                }
                                                _jettag_c_if_135_13.doEnd();
                                                _jettag_c_if_132_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_132_16.doEnd();
                                            _jettag_c_iterate_131_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_131_15.doEnd();
                                        _jettag_c_if_129_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_129_14.doEnd();
                                    _jettag_c_iterate_126_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_126_12.doEnd();
                                _jettag_c_if_124_6.handleBodyContent(out);
                            }
                            _jettag_c_if_124_6.doEnd();
                            _jettag_c_iterate_121_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_121_3.doEnd();
                        _jettag_c_iterate_119_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_119_2.doEnd();
                    _jettag_c_iterate_117_1.handleBodyContent(out);
                }
                _jettag_c_iterate_117_1.doEnd();
                out.write(NL);         
                // constructor 
                RuntimeTagElement _jettag_c_if_160_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_160_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_160_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_160_1.setTagInfo(_td_c_if_160_1);
                _jettag_c_if_160_1.doStart(context, out);
                while (_jettag_c_if_160_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_f_message_161_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_161_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_161_1.setRuntimeParent(_jettag_c_if_160_1);
                    _jettag_f_message_161_1.setTagInfo(_td_f_message_161_1);
                    _jettag_f_message_161_1.doStart(context, out);
                    JET2Writer _jettag_f_message_161_1_saved_out = out;
                    while (_jettag_f_message_161_1.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_161_1.handleBodyContent(out);
                    }
                    out = _jettag_f_message_161_1_saved_out;
                    _jettag_f_message_161_1.doEnd();
                    out.write(NL);         
                    out.write("public ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 162, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("() {");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("super();   ");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("}");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_160_1.handleBodyContent(out);
                }
                _jettag_c_if_160_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                // getters and setters 
                RuntimeTagElement _jettag_c_iterate_168_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_168_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_168_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_168_1.setTagInfo(_td_c_iterate_168_1);
                _jettag_c_iterate_168_1.doStart(context, out);
                while (_jettag_c_iterate_168_1.okToProcessBody()) {
                    //getters for basic attributes 
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_f_message_170_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_170_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_170_2.setRuntimeParent(_jettag_c_iterate_168_1);
                    _jettag_f_message_170_2.setTagInfo(_td_f_message_170_2);
                    _jettag_f_message_170_2.doStart(context, out);
                    JET2Writer _jettag_f_message_170_2_saved_out = out;
                    while (_jettag_f_message_170_2.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_170_2.handleBodyContent(out);
                    }
                    out = _jettag_f_message_170_2_saved_out;
                    _jettag_f_message_170_2.doEnd();
                    out.write(NL);         
                    out.write("\tpublic  ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_choose_171_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_171_10); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_171_10.setRuntimeParent(_jettag_c_iterate_168_1);
                    _jettag_c_choose_171_10.setTagInfo(_td_c_choose_171_10);
                    _jettag_c_choose_171_10.doStart(context, out);
                    JET2Writer _jettag_c_choose_171_10_saved_out = out;
                    while (_jettag_c_choose_171_10.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("  ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_171_81 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_171_81); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_171_81.setRuntimeParent(_jettag_c_choose_171_10);
                        _jettag_c_when_171_81.setTagInfo(_td_c_when_171_81);
                        _jettag_c_when_171_81.doStart(context, out);
                        JET2Writer _jettag_c_when_171_81_saved_out = out;
                        while (_jettag_c_when_171_81.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_171_81.handleBodyContent(out);
                        }
                        out = _jettag_c_when_171_81_saved_out;
                        _jettag_c_when_171_81.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_171_128 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_171_128); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_171_128.setRuntimeParent(_jettag_c_choose_171_10);
                        _jettag_c_when_171_128.setTagInfo(_td_c_when_171_128);
                        _jettag_c_when_171_128.doStart(context, out);
                        JET2Writer _jettag_c_when_171_128_saved_out = out;
                        while (_jettag_c_when_171_128.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Integer");  //$NON-NLS-1$        
                            _jettag_c_when_171_128.handleBodyContent(out);
                        }
                        out = _jettag_c_when_171_128_saved_out;
                        _jettag_c_when_171_128.doEnd();
                        RuntimeTagElement _jettag_c_when_171_176 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_171_176); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_171_176.setRuntimeParent(_jettag_c_choose_171_10);
                        _jettag_c_when_171_176.setTagInfo(_td_c_when_171_176);
                        _jettag_c_when_171_176.doStart(context, out);
                        JET2Writer _jettag_c_when_171_176_saved_out = out;
                        while (_jettag_c_when_171_176.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Date");  //$NON-NLS-1$        
                            _jettag_c_when_171_176.handleBodyContent(out);
                        }
                        out = _jettag_c_when_171_176_saved_out;
                        _jettag_c_when_171_176.doEnd();
                        RuntimeTagElement _jettag_c_when_171_218 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_171_218); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_171_218.setRuntimeParent(_jettag_c_choose_171_10);
                        _jettag_c_when_171_218.setTagInfo(_td_c_when_171_218);
                        _jettag_c_when_171_218.doStart(context, out);
                        JET2Writer _jettag_c_when_171_218_saved_out = out;
                        while (_jettag_c_when_171_218.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Boolean");  //$NON-NLS-1$        
                            _jettag_c_when_171_218.handleBodyContent(out);
                        }
                        out = _jettag_c_when_171_218_saved_out;
                        _jettag_c_when_171_218.doEnd();
                        RuntimeTagElement _jettag_c_when_171_266 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_171_266); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_171_266.setRuntimeParent(_jettag_c_choose_171_10);
                        _jettag_c_when_171_266.setTagInfo(_td_c_when_171_266);
                        _jettag_c_when_171_266.doStart(context, out);
                        JET2Writer _jettag_c_when_171_266_saved_out = out;
                        while (_jettag_c_when_171_266.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" Long ");  //$NON-NLS-1$        
                            _jettag_c_when_171_266.handleBodyContent(out);
                        }
                        out = _jettag_c_when_171_266_saved_out;
                        _jettag_c_when_171_266.doEnd();
                        RuntimeTagElement _jettag_c_when_171_310 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_171_310); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_171_310.setRuntimeParent(_jettag_c_choose_171_10);
                        _jettag_c_when_171_310.setTagInfo(_td_c_when_171_310);
                        _jettag_c_when_171_310.doStart(context, out);
                        JET2Writer _jettag_c_when_171_310_saved_out = out;
                        while (_jettag_c_when_171_310.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Float");  //$NON-NLS-1$        
                            _jettag_c_when_171_310.handleBodyContent(out);
                        }
                        out = _jettag_c_when_171_310_saved_out;
                        _jettag_c_when_171_310.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_171_355 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_171_355); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_171_355.setRuntimeParent(_jettag_c_choose_171_10);
                        _jettag_c_when_171_355.setTagInfo(_td_c_when_171_355);
                        _jettag_c_when_171_355.doStart(context, out);
                        JET2Writer _jettag_c_when_171_355_saved_out = out;
                        while (_jettag_c_when_171_355.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_171_355.handleBodyContent(out);
                        }
                        out = _jettag_c_when_171_355_saved_out;
                        _jettag_c_when_171_355.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_171_401 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_171_401); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_171_401.setRuntimeParent(_jettag_c_choose_171_10);
                        _jettag_c_when_171_401.setTagInfo(_td_c_when_171_401);
                        _jettag_c_when_171_401.doStart(context, out);
                        JET2Writer _jettag_c_when_171_401_saved_out = out;
                        while (_jettag_c_when_171_401.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_171_401.handleBodyContent(out);
                        }
                        out = _jettag_c_when_171_401_saved_out;
                        _jettag_c_when_171_401.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_171_450 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_171_450); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_171_450.setRuntimeParent(_jettag_c_choose_171_10);
                        _jettag_c_when_171_450.setTagInfo(_td_c_when_171_450);
                        _jettag_c_when_171_450.doStart(context, out);
                        JET2Writer _jettag_c_when_171_450_saved_out = out;
                        while (_jettag_c_when_171_450.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("BigDecimal");  //$NON-NLS-1$        
                            _jettag_c_when_171_450.handleBodyContent(out);
                        }
                        out = _jettag_c_when_171_450_saved_out;
                        _jettag_c_when_171_450.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_otherwise_171_503 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_171_503); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_171_503.setRuntimeParent(_jettag_c_choose_171_10);
                        _jettag_c_otherwise_171_503.setTagInfo(_td_c_otherwise_171_503);
                        _jettag_c_otherwise_171_503.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_171_503_saved_out = out;
                        while (_jettag_c_otherwise_171_503.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(NL);         
                            RuntimeTagElement _jettag_c_iterate_172_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_172_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_172_4.setRuntimeParent(_jettag_c_otherwise_171_503);
                            _jettag_c_iterate_172_4.setTagInfo(_td_c_iterate_172_4);
                            _jettag_c_iterate_172_4.doStart(context, out);
                            while (_jettag_c_iterate_172_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_173_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_173_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_173_6.setRuntimeParent(_jettag_c_iterate_172_4);
                                _jettag_c_if_173_6.setTagInfo(_td_c_if_173_6);
                                _jettag_c_if_173_6.doStart(context, out);
                                while (_jettag_c_if_173_6.okToProcessBody()) {
                                    out.write("\t \t\t\t ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$enumeration/@name}", 174, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(" ");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_173_6.handleBodyContent(out);
                                }
                                _jettag_c_if_173_6.doEnd();
                                _jettag_c_iterate_172_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_172_4.doEnd();
                            out.write("\t \t  ");  //$NON-NLS-1$        
                            _jettag_c_otherwise_171_503.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_171_503_saved_out;
                        _jettag_c_otherwise_171_503.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        _jettag_c_choose_171_10.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_171_10_saved_out;
                    _jettag_c_choose_171_10.doEnd();
                    out.write(" get");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 177, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("(){");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\treturn ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 178, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t}");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_f_message_180_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_180_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_180_2.setRuntimeParent(_jettag_c_iterate_168_1);
                    _jettag_f_message_180_2.setTagInfo(_td_f_message_180_2);
                    _jettag_f_message_180_2.doStart(context, out);
                    JET2Writer _jettag_f_message_180_2_saved_out = out;
                    while (_jettag_f_message_180_2.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_180_2.handleBodyContent(out);
                    }
                    out = _jettag_f_message_180_2_saved_out;
                    _jettag_f_message_180_2.doEnd();
                    out.write(NL);         
                    out.write("\tpublic void set");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 181, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("(");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_choose_181_53 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_181_53); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_181_53.setRuntimeParent(_jettag_c_iterate_168_1);
                    _jettag_c_choose_181_53.setTagInfo(_td_c_choose_181_53);
                    _jettag_c_choose_181_53.doStart(context, out);
                    JET2Writer _jettag_c_choose_181_53_saved_out = out;
                    while (_jettag_c_choose_181_53.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_181_123 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_181_123); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_181_123.setRuntimeParent(_jettag_c_choose_181_53);
                        _jettag_c_when_181_123.setTagInfo(_td_c_when_181_123);
                        _jettag_c_when_181_123.doStart(context, out);
                        JET2Writer _jettag_c_when_181_123_saved_out = out;
                        while (_jettag_c_when_181_123.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_181_123.handleBodyContent(out);
                        }
                        out = _jettag_c_when_181_123_saved_out;
                        _jettag_c_when_181_123.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_181_170 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_181_170); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_181_170.setRuntimeParent(_jettag_c_choose_181_53);
                        _jettag_c_when_181_170.setTagInfo(_td_c_when_181_170);
                        _jettag_c_when_181_170.doStart(context, out);
                        JET2Writer _jettag_c_when_181_170_saved_out = out;
                        while (_jettag_c_when_181_170.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Integer");  //$NON-NLS-1$        
                            _jettag_c_when_181_170.handleBodyContent(out);
                        }
                        out = _jettag_c_when_181_170_saved_out;
                        _jettag_c_when_181_170.doEnd();
                        RuntimeTagElement _jettag_c_when_181_218 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_181_218); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_181_218.setRuntimeParent(_jettag_c_choose_181_53);
                        _jettag_c_when_181_218.setTagInfo(_td_c_when_181_218);
                        _jettag_c_when_181_218.doStart(context, out);
                        JET2Writer _jettag_c_when_181_218_saved_out = out;
                        while (_jettag_c_when_181_218.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Date");  //$NON-NLS-1$        
                            _jettag_c_when_181_218.handleBodyContent(out);
                        }
                        out = _jettag_c_when_181_218_saved_out;
                        _jettag_c_when_181_218.doEnd();
                        RuntimeTagElement _jettag_c_when_181_260 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_181_260); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_181_260.setRuntimeParent(_jettag_c_choose_181_53);
                        _jettag_c_when_181_260.setTagInfo(_td_c_when_181_260);
                        _jettag_c_when_181_260.doStart(context, out);
                        JET2Writer _jettag_c_when_181_260_saved_out = out;
                        while (_jettag_c_when_181_260.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Boolean");  //$NON-NLS-1$        
                            _jettag_c_when_181_260.handleBodyContent(out);
                        }
                        out = _jettag_c_when_181_260_saved_out;
                        _jettag_c_when_181_260.doEnd();
                        RuntimeTagElement _jettag_c_when_181_308 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_181_308); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_181_308.setRuntimeParent(_jettag_c_choose_181_53);
                        _jettag_c_when_181_308.setTagInfo(_td_c_when_181_308);
                        _jettag_c_when_181_308.doStart(context, out);
                        JET2Writer _jettag_c_when_181_308_saved_out = out;
                        while (_jettag_c_when_181_308.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" Long ");  //$NON-NLS-1$        
                            _jettag_c_when_181_308.handleBodyContent(out);
                        }
                        out = _jettag_c_when_181_308_saved_out;
                        _jettag_c_when_181_308.doEnd();
                        RuntimeTagElement _jettag_c_when_181_352 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_181_352); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_181_352.setRuntimeParent(_jettag_c_choose_181_53);
                        _jettag_c_when_181_352.setTagInfo(_td_c_when_181_352);
                        _jettag_c_when_181_352.doStart(context, out);
                        JET2Writer _jettag_c_when_181_352_saved_out = out;
                        while (_jettag_c_when_181_352.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Float");  //$NON-NLS-1$        
                            _jettag_c_when_181_352.handleBodyContent(out);
                        }
                        out = _jettag_c_when_181_352_saved_out;
                        _jettag_c_when_181_352.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_181_397 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_181_397); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_181_397.setRuntimeParent(_jettag_c_choose_181_53);
                        _jettag_c_when_181_397.setTagInfo(_td_c_when_181_397);
                        _jettag_c_when_181_397.doStart(context, out);
                        JET2Writer _jettag_c_when_181_397_saved_out = out;
                        while (_jettag_c_when_181_397.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_181_397.handleBodyContent(out);
                        }
                        out = _jettag_c_when_181_397_saved_out;
                        _jettag_c_when_181_397.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_181_443 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_181_443); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_181_443.setRuntimeParent(_jettag_c_choose_181_53);
                        _jettag_c_when_181_443.setTagInfo(_td_c_when_181_443);
                        _jettag_c_when_181_443.doStart(context, out);
                        JET2Writer _jettag_c_when_181_443_saved_out = out;
                        while (_jettag_c_when_181_443.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_181_443.handleBodyContent(out);
                        }
                        out = _jettag_c_when_181_443_saved_out;
                        _jettag_c_when_181_443.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_181_492 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_181_492); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_181_492.setRuntimeParent(_jettag_c_choose_181_53);
                        _jettag_c_when_181_492.setTagInfo(_td_c_when_181_492);
                        _jettag_c_when_181_492.doStart(context, out);
                        JET2Writer _jettag_c_when_181_492_saved_out = out;
                        while (_jettag_c_when_181_492.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("BigDecimal");  //$NON-NLS-1$        
                            _jettag_c_when_181_492.handleBodyContent(out);
                        }
                        out = _jettag_c_when_181_492_saved_out;
                        _jettag_c_when_181_492.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_otherwise_181_545 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_181_545); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_181_545.setRuntimeParent(_jettag_c_choose_181_53);
                        _jettag_c_otherwise_181_545.setTagInfo(_td_c_otherwise_181_545);
                        _jettag_c_otherwise_181_545.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_181_545_saved_out = out;
                        while (_jettag_c_otherwise_181_545.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(NL);         
                            RuntimeTagElement _jettag_c_iterate_182_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_182_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_182_4.setRuntimeParent(_jettag_c_otherwise_181_545);
                            _jettag_c_iterate_182_4.setTagInfo(_td_c_iterate_182_4);
                            _jettag_c_iterate_182_4.doStart(context, out);
                            while (_jettag_c_iterate_182_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_183_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_183_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_183_6.setRuntimeParent(_jettag_c_iterate_182_4);
                                _jettag_c_if_183_6.setTagInfo(_td_c_if_183_6);
                                _jettag_c_if_183_6.doStart(context, out);
                                while (_jettag_c_if_183_6.okToProcessBody()) {
                                    out.write("\t \t\t\t ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$enumeration/@name}", 184, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(" ");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_183_6.handleBodyContent(out);
                                }
                                _jettag_c_if_183_6.doEnd();
                                _jettag_c_iterate_182_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_182_4.doEnd();
                            out.write("\t \t  ");  //$NON-NLS-1$        
                            _jettag_c_otherwise_181_545.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_181_545_saved_out;
                        _jettag_c_otherwise_181_545.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        _jettag_c_choose_181_53.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_181_53_saved_out;
                    _jettag_c_choose_181_53.doEnd();
                    out.write(" ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_get_187_33 = context.getTagFactory().createRuntimeTag(_jetns_c, "get", "c:get", _td_c_get_187_33); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_get_187_33.setRuntimeParent(_jettag_c_iterate_168_1);
                    _jettag_c_get_187_33.setTagInfo(_td_c_get_187_33);
                    _jettag_c_get_187_33.doStart(context, out);
                    _jettag_c_get_187_33.doEnd();
                    out.write("){");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\tthis.");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 188, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("=");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 188, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t}");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_iterate_168_1.handleBodyContent(out);
                }
                _jettag_c_iterate_168_1.doEnd();
                // colletions getters and setters-->
                //<%--getters for collection attributes 
                RuntimeTagElement _jettag_c_iterate_194_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_194_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_194_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_194_2.setTagInfo(_td_c_iterate_194_2);
                _jettag_c_iterate_194_2.doStart(context, out);
                while (_jettag_c_iterate_194_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_195_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_195_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_195_2.setRuntimeParent(_jettag_c_iterate_194_2);
                    _jettag_c_iterate_195_2.setTagInfo(_td_c_iterate_195_2);
                    _jettag_c_iterate_195_2.doStart(context, out);
                    while (_jettag_c_iterate_195_2.okToProcessBody()) {
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        RuntimeTagElement _jettag_c_iterate_197_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_197_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_197_3.setRuntimeParent(_jettag_c_iterate_195_2);
                        _jettag_c_iterate_197_3.setTagInfo(_td_c_iterate_197_3);
                        _jettag_c_iterate_197_3.doStart(context, out);
                        while (_jettag_c_iterate_197_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_198_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_198_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_198_4.setRuntimeParent(_jettag_c_iterate_197_3);
                            _jettag_c_setVariable_198_4.setTagInfo(_td_c_setVariable_198_4);
                            _jettag_c_setVariable_198_4.doStart(context, out);
                            _jettag_c_setVariable_198_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_200_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_200_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_200_6.setRuntimeParent(_jettag_c_iterate_197_3);
                            _jettag_c_if_200_6.setTagInfo(_td_c_if_200_6);
                            _jettag_c_if_200_6.doStart(context, out);
                            while (_jettag_c_if_200_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_202_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_202_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_202_12.setRuntimeParent(_jettag_c_if_200_6);
                                _jettag_c_iterate_202_12.setTagInfo(_td_c_iterate_202_12);
                                _jettag_c_iterate_202_12.doStart(context, out);
                                while (_jettag_c_iterate_202_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_203_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_203_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_203_12.setRuntimeParent(_jettag_c_iterate_202_12);
                                    _jettag_c_setVariable_203_12.setTagInfo(_td_c_setVariable_203_12);
                                    _jettag_c_setVariable_203_12.doStart(context, out);
                                    _jettag_c_setVariable_203_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_205_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_205_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_205_14.setRuntimeParent(_jettag_c_iterate_202_12);
                                    _jettag_c_if_205_14.setTagInfo(_td_c_if_205_14);
                                    _jettag_c_if_205_14.doStart(context, out);
                                    while (_jettag_c_if_205_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_207_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_207_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_207_15.setRuntimeParent(_jettag_c_if_205_14);
                                        _jettag_c_iterate_207_15.setTagInfo(_td_c_iterate_207_15);
                                        _jettag_c_iterate_207_15.doStart(context, out);
                                        while (_jettag_c_iterate_207_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_208_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_208_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_208_16.setRuntimeParent(_jettag_c_iterate_207_15);
                                            _jettag_c_if_208_16.setTagInfo(_td_c_if_208_16);
                                            _jettag_c_if_208_16.doStart(context, out);
                                            while (_jettag_c_if_208_16.okToProcessBody()) {
                                                out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                // check to see the association is navigable in the first case
                                                RuntimeTagElement _jettag_c_if_211_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_211_13); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_211_13.setRuntimeParent(_jettag_c_if_208_16);
                                                _jettag_c_if_211_13.setTagInfo(_td_c_if_211_13);
                                                _jettag_c_if_211_13.doStart(context, out);
                                                while (_jettag_c_if_211_13.okToProcessBody()) {
                                                    // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                    // check if target is one side
                                                    RuntimeTagElement _jettag_c_if_214_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_214_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_214_16.setRuntimeParent(_jettag_c_if_211_13);
                                                    _jettag_c_if_214_16.setTagInfo(_td_c_if_214_16);
                                                    _jettag_c_if_214_16.doStart(context, out);
                                                    while (_jettag_c_if_214_16.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_215_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_215_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_215_18.setRuntimeParent(_jettag_c_if_214_16);
                                                        _jettag_c_if_215_18.setTagInfo(_td_c_if_215_18);
                                                        _jettag_c_if_215_18.doStart(context, out);
                                                        while (_jettag_c_if_215_18.okToProcessBody()) {
                                                            // gettter returning a non collection
                                                            out.write(" ");  //$NON-NLS-1$        
                                                            RuntimeTagElement _jettag_f_message_217_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_217_2); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_217_2.setRuntimeParent(_jettag_c_if_215_18);
                                                            _jettag_f_message_217_2.setTagInfo(_td_f_message_217_2);
                                                            _jettag_f_message_217_2.doStart(context, out);
                                                            JET2Writer _jettag_f_message_217_2_saved_out = out;
                                                            while (_jettag_f_message_217_2.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_217_2.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_217_2_saved_out;
                                                            _jettag_f_message_217_2.doEnd();
                                                            out.write("\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("@XmlElement \t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write(" public \t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 219, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(" get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 219, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("() {");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write(" return  this.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 220, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write(" }");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            // setter returning a non clooection
                                                            RuntimeTagElement _jettag_f_message_223_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_223_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_223_1.setRuntimeParent(_jettag_c_if_215_18);
                                                            _jettag_f_message_223_1.setTagInfo(_td_f_message_223_1);
                                                            _jettag_f_message_223_1.doStart(context, out);
                                                            JET2Writer _jettag_f_message_223_1_saved_out = out;
                                                            while (_jettag_f_message_223_1.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_223_1.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_223_1_saved_out;
                                                            _jettag_f_message_223_1.doEnd();
                                                            out.write(NL);         
                                                            out.write("  public \tvoid set");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 224, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("(");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 224, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(" ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 224, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(") {");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("   this.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 225, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("=");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 225, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write(" }");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write(" ");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_215_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_215_18.doEnd();
                                                        _jettag_c_if_214_16.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_214_16.doEnd();
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    // check if target is many side
                                                    RuntimeTagElement _jettag_c_if_232_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_232_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_232_17.setRuntimeParent(_jettag_c_if_211_13);
                                                    _jettag_c_if_232_17.setTagInfo(_td_c_if_232_17);
                                                    _jettag_c_if_232_17.doStart(context, out);
                                                    while (_jettag_c_if_232_17.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_233_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_233_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_233_18.setRuntimeParent(_jettag_c_if_232_17);
                                                        _jettag_c_if_233_18.setTagInfo(_td_c_if_233_18);
                                                        _jettag_c_if_233_18.doStart(context, out);
                                                        while (_jettag_c_if_233_18.okToProcessBody()) {
                                                            out.write("   \t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            // check if source is many side
                                                            // this is a many to many
                                                            RuntimeTagElement _jettag_c_if_237_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_237_13); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_237_13.setRuntimeParent(_jettag_c_if_233_18);
                                                            _jettag_c_if_237_13.setTagInfo(_td_c_if_237_13);
                                                            _jettag_c_if_237_13.doStart(context, out);
                                                            while (_jettag_c_if_237_13.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_c_if_238_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_238_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_238_19.setRuntimeParent(_jettag_c_if_237_13);
                                                                _jettag_c_if_238_19.setTagInfo(_td_c_if_238_19);
                                                                _jettag_c_if_238_19.doStart(context, out);
                                                                while (_jettag_c_if_238_19.okToProcessBody()) {
                                                                    // gettter returning a collection
                                                                    out.write("\t  \t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_240_19 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_240_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_240_19.setRuntimeParent(_jettag_c_if_238_19);
                                                                    _jettag_f_message_240_19.setTagInfo(_td_f_message_240_19);
                                                                    _jettag_f_message_240_19.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_240_19_saved_out = out;
                                                                    while (_jettag_f_message_240_19.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_240_19.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_240_19_saved_out;
                                                                    _jettag_f_message_240_19.doEnd();
                                                                    out.write("\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t@XmlTransient \t\t    \t\t\t\t\t\t\t\t\t\t\t    \t\t\t\t\t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t public \tSet<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 242, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">  get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 242, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t if(this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 243, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s==null){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t ");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t //TODO actual");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t //this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 246, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s=new HashSet<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 246, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t return new HashSet<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 247, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t return this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 249, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    // setter returning a collection
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_252_15 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_252_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_252_15.setRuntimeParent(_jettag_c_if_238_19);
                                                                    _jettag_f_message_252_15.setTagInfo(_td_f_message_252_15);
                                                                    _jettag_f_message_252_15.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_252_15_saved_out = out;
                                                                    while (_jettag_f_message_252_15.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_252_15.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_252_15_saved_out;
                                                                    _jettag_f_message_252_15.doEnd();
                                                                    out.write("\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t public \t  void set");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 253, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(Set<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 253, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("> ");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 253, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 254, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s=");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 254, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t }\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    // addEntity methods
                                                                    out.write("\t \t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_257_16 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_257_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_257_16.setRuntimeParent(_jettag_c_if_238_19);
                                                                    _jettag_f_message_257_16.setTagInfo(_td_f_message_257_16);
                                                                    _jettag_f_message_257_16.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_257_16_saved_out = out;
                                                                    while (_jettag_f_message_257_16.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_257_16.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_257_16_saved_out;
                                                                    _jettag_f_message_257_16.doEnd();
                                                                    out.write(NL);         
                                                                    out.write("\t  \t\t\t\t\t    \t\t\t\t\t\t public \t  void add");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 258, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("(");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 258, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(" entity){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  if(entity== null){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  return;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 262, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s().add(entity);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_238_19.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_238_19.doEnd();
                                                                _jettag_c_if_237_13.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_237_13.doEnd();
                                                            // check if source is one side
                                                            // this is a one to many
                                                            RuntimeTagElement _jettag_c_if_268_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_268_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_268_17.setRuntimeParent(_jettag_c_if_233_18);
                                                            _jettag_c_if_268_17.setTagInfo(_td_c_if_268_17);
                                                            _jettag_c_if_268_17.doStart(context, out);
                                                            while (_jettag_c_if_268_17.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_c_if_269_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_269_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_269_19.setRuntimeParent(_jettag_c_if_268_17);
                                                                _jettag_c_if_269_19.setTagInfo(_td_c_if_269_19);
                                                                _jettag_c_if_269_19.doStart(context, out);
                                                                while (_jettag_c_if_269_19.okToProcessBody()) {
                                                                    // gettter returning a collection
                                                                    out.write("\t  \t\t\t\t\t    \t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_271_20 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_271_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_271_20.setRuntimeParent(_jettag_c_if_269_19);
                                                                    _jettag_f_message_271_20.setTagInfo(_td_f_message_271_20);
                                                                    _jettag_f_message_271_20.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_271_20_saved_out = out;
                                                                    while (_jettag_f_message_271_20.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_271_20.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_271_20_saved_out;
                                                                    _jettag_f_message_271_20.doEnd();
                                                                    out.write("\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t@XmlTransient \t    \t\t\t\t\t\t\t\t\t\t\t    \t\t\t\t\t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t public \tList<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 273, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">  get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 273, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t if(this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 274, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s==null){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  //TODO actual");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t //this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 276, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s=new ArrayList<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 276, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t return new ArrayList<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 277, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t return this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 279, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    // setter returning a collection
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_282_15 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_282_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_282_15.setRuntimeParent(_jettag_c_if_269_19);
                                                                    _jettag_f_message_282_15.setTagInfo(_td_f_message_282_15);
                                                                    _jettag_f_message_282_15.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_282_15_saved_out = out;
                                                                    while (_jettag_f_message_282_15.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_282_15.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_282_15_saved_out;
                                                                    _jettag_f_message_282_15.doEnd();
                                                                    out.write("\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t public \t  void set");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 283, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(List<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 283, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("> ");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 283, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 284, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s=");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 284, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    // addEntity methods
                                                                    out.write("\t  \t\t\t\t\t    \t\t\t\t\t\t \t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_287_21 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_287_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_287_21.setRuntimeParent(_jettag_c_if_269_19);
                                                                    _jettag_f_message_287_21.setTagInfo(_td_f_message_287_21);
                                                                    _jettag_f_message_287_21.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_287_21_saved_out = out;
                                                                    while (_jettag_f_message_287_21.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_287_21.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_287_21_saved_out;
                                                                    _jettag_f_message_287_21.doEnd();
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  public \t  void add");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 288, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("(");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 288, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(" entity){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   if(entity== null){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  return;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 292, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s().add(entity);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t entity.set");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 293, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("(this);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_269_19.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_269_19.doEnd();
                                                                _jettag_c_if_268_17.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_268_17.doEnd();
                                                            out.write("  \t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_233_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_233_18.doEnd();
                                                        _jettag_c_if_232_17.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_232_17.doEnd();
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_211_13.handleBodyContent(out);
                                                }
                                                _jettag_c_if_211_13.doEnd();
                                                _jettag_c_if_208_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_208_16.doEnd();
                                            _jettag_c_iterate_207_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_207_15.doEnd();
                                        _jettag_c_if_205_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_205_14.doEnd();
                                    _jettag_c_iterate_202_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_202_12.doEnd();
                                _jettag_c_if_200_6.handleBodyContent(out);
                            }
                            _jettag_c_if_200_6.doEnd();
                            _jettag_c_iterate_197_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_197_3.doEnd();
                        _jettag_c_iterate_195_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_195_2.doEnd();
                    out.write(NL);         
                    _jettag_c_iterate_194_2.handleBodyContent(out);
                }
                _jettag_c_iterate_194_2.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_311_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_311_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_311_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_311_2.setTagInfo(_td_f_message_311_2);
                _jettag_f_message_311_2.doStart(context, out);
                JET2Writer _jettag_f_message_311_2_saved_out = out;
                while (_jettag_f_message_311_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_311_2.handleBodyContent(out);
                }
                out = _jettag_f_message_311_2_saved_out;
                _jettag_f_message_311_2.doEnd();
                out.write(NL);         
                out.write("\tpublic String toString(){");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tStringBuilder sb= new StringBuilder();");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_iterate_314_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_314_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_314_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_314_1.setTagInfo(_td_c_iterate_314_1);
                _jettag_c_iterate_314_1.doStart(context, out);
                while (_jettag_c_iterate_314_1.okToProcessBody()) {
                    out.write("\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_choose_315_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_315_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_315_3.setRuntimeParent(_jettag_c_iterate_314_1);
                    _jettag_c_choose_315_3.setTagInfo(_td_c_choose_315_3);
                    _jettag_c_choose_315_3.doStart(context, out);
                    JET2Writer _jettag_c_choose_315_3_saved_out = out;
                    while (_jettag_c_choose_315_3.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_315_73 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_315_73); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_315_73.setRuntimeParent(_jettag_c_choose_315_3);
                        _jettag_c_when_315_73.setTagInfo(_td_c_when_315_73);
                        _jettag_c_when_315_73.doStart(context, out);
                        JET2Writer _jettag_c_when_315_73_saved_out = out;
                        while (_jettag_c_when_315_73.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" sb.append(get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 315, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("());  sb.append(\":\");");  //$NON-NLS-1$        
                            _jettag_c_when_315_73.handleBodyContent(out);
                        }
                        out = _jettag_c_when_315_73_saved_out;
                        _jettag_c_when_315_73.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_choose_315_3.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_315_3_saved_out;
                    _jettag_c_choose_315_3.doEnd();
                    _jettag_c_iterate_314_1.handleBodyContent(out);
                }
                _jettag_c_iterate_314_1.doEnd();
                out.write("\treturn sb.toString();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
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
