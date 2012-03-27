package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_jpa_class_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_jpa_class_templatejava() {
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
    private static final TagInfo _td_c_if_34_1 = new TagInfo("c:if", //$NON-NLS-1$
            34, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$supportJAXB = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_39_1 = new TagInfo("c:if", //$NON-NLS-1$
            39, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_49_1 = new TagInfo("f:message", //$NON-NLS-1$
            49, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_51_1 = new TagInfo("c:if", //$NON-NLS-1$
            51, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_52_1 = new TagInfo("c:if", //$NON-NLS-1$
            52, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@hasChildren = $class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_57_1 = new TagInfo("c:if", //$NON-NLS-1$
            57, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@parentClass1Name = $class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_58_1 = new TagInfo("c:if", //$NON-NLS-1$
            58, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@hasChildren = $class/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_62_1 = new TagInfo("c:if", //$NON-NLS-1$
            62, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$supportJAXB = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_66_8 = new TagInfo("c:if", //$NON-NLS-1$
            66, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isAbstract = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_66_95 = new TagInfo("c:if", //$NON-NLS-1$
            66, 95,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@parentClass1Name = $class/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_66_173 = new TagInfo("c:if", //$NON-NLS-1$
            66, 173,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@parentClass1Name = $class/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_67_1 = new TagInfo("f:message", //$NON-NLS-1$
            67, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_68_1 = new TagInfo("c:if", //$NON-NLS-1$
            68, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$supportJAXB = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_unique_71_46 = new TagInfo("f:unique", //$NON-NLS-1$
            71, 46,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_74_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            74, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_75_1 = new TagInfo("f:message", //$NON-NLS-1$
            75, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_76_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            76, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/ModelElement.stereotype/Stereotype", //$NON-NLS-1$
                "stereotype", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_77_3 = new TagInfo("c:if", //$NON-NLS-1$
            77, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$SizeID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_78_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            78, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/ModelElement.taggedValue", //$NON-NLS-1$
                "taggedvalue", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_79_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            79, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$taggedvalue/TaggedValue", //$NON-NLS-1$
                "subtag1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_81_6 = new TagInfo("c:if", //$NON-NLS-1$
            81, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$subtag1/TaggedValue.type/TagDefinition/@href = ${'$minID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_82_7 = new TagInfo("c:iterate", //$NON-NLS-1$
            82, 7,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$taggedvalue/TaggedValue", //$NON-NLS-1$
                "subtag2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_84_8 = new TagInfo("c:if", //$NON-NLS-1$
            84, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$subtag2/TaggedValue.type/TagDefinition/@href = ${'$maxID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_93_3 = new TagInfo("c:if", //$NON-NLS-1$
            93, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$MinID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_94_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            94, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/ModelElement.taggedValue", //$NON-NLS-1$
                "taggedvalue", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_95_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            95, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$taggedvalue/TaggedValue", //$NON-NLS-1$
                "subtag", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_97_6 = new TagInfo("c:if", //$NON-NLS-1$
            97, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$subtag/TaggedValue.type/TagDefinition/@href = ${'$minID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_103_3 = new TagInfo("c:if", //$NON-NLS-1$
            103, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$MaxID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_104_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            104, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/ModelElement.taggedValue", //$NON-NLS-1$
                "taggedvalue", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_105_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            105, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$taggedvalue/TaggedValue", //$NON-NLS-1$
                "subtag", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_107_6 = new TagInfo("c:if", //$NON-NLS-1$
            107, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$subtag/TaggedValue.type/TagDefinition/@href = ${'$maxID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_113_3 = new TagInfo("c:if", //$NON-NLS-1$
            113, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$DecimalMinID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_114_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            114, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/ModelElement.taggedValue", //$NON-NLS-1$
                "taggedvalue", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_115_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            115, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$taggedvalue/TaggedValue", //$NON-NLS-1$
                "subtag", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_117_6 = new TagInfo("c:if", //$NON-NLS-1$
            117, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$subtag/TaggedValue.type/TagDefinition/@href = ${'$minID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_123_3 = new TagInfo("c:if", //$NON-NLS-1$
            123, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$DecimalMaxID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_124_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            124, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/ModelElement.taggedValue", //$NON-NLS-1$
                "taggedvalue", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_125_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            125, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$taggedvalue/TaggedValue", //$NON-NLS-1$
                "subtag", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_127_6 = new TagInfo("c:if", //$NON-NLS-1$
            127, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$subtag/TaggedValue.type/TagDefinition/@href = ${'$maxID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_133_3 = new TagInfo("c:if", //$NON-NLS-1$
            133, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$NotNullID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_136_3 = new TagInfo("c:if", //$NON-NLS-1$
            136, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$NotEmptyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_139_3 = new TagInfo("c:if", //$NON-NLS-1$
            139, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$PastID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_142_3 = new TagInfo("c:if", //$NON-NLS-1$
            142, 3,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$stereotype/@href = ${'$FutureID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_147_1 = new TagInfo("c:if", //$NON-NLS-1$
            147, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_148_3 = new TagInfo("c:choose", //$NON-NLS-1$
            148, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_148_73 = new TagInfo("c:when", //$NON-NLS-1$
            148, 73,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_148_122 = new TagInfo("c:when", //$NON-NLS-1$
            148, 122,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_148_198 = new TagInfo("c:when", //$NON-NLS-1$
            148, 198,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_148_270 = new TagInfo("c:when", //$NON-NLS-1$
            148, 270,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_148_344 = new TagInfo("c:when", //$NON-NLS-1$
            148, 344,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_148_416 = new TagInfo("c:when", //$NON-NLS-1$
            148, 416,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_148_490 = new TagInfo("c:when", //$NON-NLS-1$
            148, 490,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_148_538 = new TagInfo("c:when", //$NON-NLS-1$
            148, 538,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_148_588 = new TagInfo("c:when", //$NON-NLS-1$
            148, 588,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_152_3 = new TagInfo("c:choose", //$NON-NLS-1$
            152, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_152_73 = new TagInfo("c:when", //$NON-NLS-1$
            152, 73,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_152_132 = new TagInfo("c:when", //$NON-NLS-1$
            152, 132,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_152_192 = new TagInfo("c:when", //$NON-NLS-1$
            152, 192,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_152_246 = new TagInfo("c:when", //$NON-NLS-1$
            152, 246,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_152_306 = new TagInfo("c:when", //$NON-NLS-1$
            152, 306,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_152_360 = new TagInfo("c:when", //$NON-NLS-1$
            152, 360,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_152_417 = new TagInfo("c:when", //$NON-NLS-1$
            152, 417,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_152_475 = new TagInfo("c:when", //$NON-NLS-1$
            152, 475,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_152_535 = new TagInfo("c:when", //$NON-NLS-1$
            152, 535,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_153_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            153, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_154_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            154, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_155_6 = new TagInfo("c:if", //$NON-NLS-1$
            155, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_157_5 = new TagInfo("c:if", //$NON-NLS-1$
            157, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$enableHibernateSearch = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_172_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            172, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_174_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            174, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_176_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            176, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_177_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            177, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_179_6 = new TagInfo("c:if", //$NON-NLS-1$
            179, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_181_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            181, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_182_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            182, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_184_14 = new TagInfo("c:if", //$NON-NLS-1$
            184, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_186_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            186, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_187_16 = new TagInfo("c:if", //$NON-NLS-1$
            187, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_188_3 = new TagInfo("f:message", //$NON-NLS-1$
            188, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_190_13 = new TagInfo("c:if", //$NON-NLS-1$
            190, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_193_16 = new TagInfo("c:if", //$NON-NLS-1$
            193, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_194_18 = new TagInfo("c:if", //$NON-NLS-1$
            194, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_197_19 = new TagInfo("c:if", //$NON-NLS-1$
            197, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_202_19 = new TagInfo("c:if", //$NON-NLS-1$
            202, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'aggregate'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_207_20 = new TagInfo("c:if", //$NON-NLS-1$
            207, 20,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_209_20 = new TagInfo("c:if", //$NON-NLS-1$
            209, 20,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_210_21 = new TagInfo("c:if", //$NON-NLS-1$
            210, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_215_20 = new TagInfo("c:if", //$NON-NLS-1$
            215, 20,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_216_21 = new TagInfo("c:if", //$NON-NLS-1$
            216, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_226_17 = new TagInfo("c:if", //$NON-NLS-1$
            226, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_227_18 = new TagInfo("c:if", //$NON-NLS-1$
            227, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_230_19 = new TagInfo("c:if", //$NON-NLS-1$
            230, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_236_19 = new TagInfo("c:if", //$NON-NLS-1$
            236, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@aggregation = 'aggregate'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_242_20 = new TagInfo("c:if", //$NON-NLS-1$
            242, 20,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_244_20 = new TagInfo("c:if", //$NON-NLS-1$
            244, 20,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_245_21 = new TagInfo("c:if", //$NON-NLS-1$
            245, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_251_20 = new TagInfo("c:if", //$NON-NLS-1$
            251, 20,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_252_21 = new TagInfo("c:if", //$NON-NLS-1$
            252, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_274_1 = new TagInfo("c:if", //$NON-NLS-1$
            274, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isAbstract = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_275_1 = new TagInfo("f:message", //$NON-NLS-1$
            275, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_282_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            282, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_284_2 = new TagInfo("f:message", //$NON-NLS-1$
            284, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_choose_285_10 = new TagInfo("c:choose", //$NON-NLS-1$
            285, 10,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_285_81 = new TagInfo("c:when", //$NON-NLS-1$
            285, 81,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_285_128 = new TagInfo("c:when", //$NON-NLS-1$
            285, 128,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_285_176 = new TagInfo("c:when", //$NON-NLS-1$
            285, 176,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_285_218 = new TagInfo("c:when", //$NON-NLS-1$
            285, 218,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_285_266 = new TagInfo("c:when", //$NON-NLS-1$
            285, 266,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_285_310 = new TagInfo("c:when", //$NON-NLS-1$
            285, 310,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_285_355 = new TagInfo("c:when", //$NON-NLS-1$
            285, 355,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_285_401 = new TagInfo("c:when", //$NON-NLS-1$
            285, 401,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_285_450 = new TagInfo("c:when", //$NON-NLS-1$
            285, 450,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_285_503 = new TagInfo("c:otherwise", //$NON-NLS-1$
            285, 503,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_286_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            286, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_287_6 = new TagInfo("c:if", //$NON-NLS-1$
            287, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_294_2 = new TagInfo("f:message", //$NON-NLS-1$
            294, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_choose_295_53 = new TagInfo("c:choose", //$NON-NLS-1$
            295, 53,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_295_123 = new TagInfo("c:when", //$NON-NLS-1$
            295, 123,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_295_170 = new TagInfo("c:when", //$NON-NLS-1$
            295, 170,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_295_218 = new TagInfo("c:when", //$NON-NLS-1$
            295, 218,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_295_260 = new TagInfo("c:when", //$NON-NLS-1$
            295, 260,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_295_308 = new TagInfo("c:when", //$NON-NLS-1$
            295, 308,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_295_352 = new TagInfo("c:when", //$NON-NLS-1$
            295, 352,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_295_397 = new TagInfo("c:when", //$NON-NLS-1$
            295, 397,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$ImageID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_295_443 = new TagInfo("c:when", //$NON-NLS-1$
            295, 443,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$RichTextID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_295_492 = new TagInfo("c:when", //$NON-NLS-1$
            295, 492,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_295_545 = new TagInfo("c:otherwise", //$NON-NLS-1$
            295, 545,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_296_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            296, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_297_6 = new TagInfo("c:if", //$NON-NLS-1$
            297, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_get_301_33 = new TagInfo("c:get", //$NON-NLS-1$
            301, 33,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/@name", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_308_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            308, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_309_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            309, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_311_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            311, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_312_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            312, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_314_6 = new TagInfo("c:if", //$NON-NLS-1$
            314, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_316_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            316, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_317_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            317, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_319_14 = new TagInfo("c:if", //$NON-NLS-1$
            319, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@xmi.id = $association_connection_end2/@xmi.id)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_321_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            321, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_322_16 = new TagInfo("c:if", //$NON-NLS-1$
            322, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_325_13 = new TagInfo("c:if", //$NON-NLS-1$
            325, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_328_16 = new TagInfo("c:if", //$NON-NLS-1$
            328, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_329_18 = new TagInfo("c:if", //$NON-NLS-1$
            329, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_331_2 = new TagInfo("f:message", //$NON-NLS-1$
            331, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_332_1 = new TagInfo("c:if", //$NON-NLS-1$
            332, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$supportJAXB = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_339_1 = new TagInfo("f:message", //$NON-NLS-1$
            339, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_348_17 = new TagInfo("c:if", //$NON-NLS-1$
            348, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_349_18 = new TagInfo("c:if", //$NON-NLS-1$
            349, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_353_13 = new TagInfo("c:if", //$NON-NLS-1$
            353, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_354_19 = new TagInfo("c:if", //$NON-NLS-1$
            354, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_356_19 = new TagInfo("f:message", //$NON-NLS-1$
            356, 19,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_357_20 = new TagInfo("c:if", //$NON-NLS-1$
            357, 20,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$supportJAXB = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_370_15 = new TagInfo("f:message", //$NON-NLS-1$
            370, 15,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_375_16 = new TagInfo("f:message", //$NON-NLS-1$
            375, 16,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_386_17 = new TagInfo("c:if", //$NON-NLS-1$
            386, 17,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_387_19 = new TagInfo("c:if", //$NON-NLS-1$
            387, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = 1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_389_20 = new TagInfo("f:message", //$NON-NLS-1$
            389, 20,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_390_20 = new TagInfo("c:if", //$NON-NLS-1$
            390, 20,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$supportJAXB = 'TRUE'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_402_15 = new TagInfo("f:message", //$NON-NLS-1$
            402, 15,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_407_21 = new TagInfo("f:message", //$NON-NLS-1$
            407, 21,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_431_2 = new TagInfo("f:message", //$NON-NLS-1$
            431, 2,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_434_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            434, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_435_3 = new TagInfo("c:choose", //$NON-NLS-1$
            435, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_435_73 = new TagInfo("c:when", //$NON-NLS-1$
            435, 73,
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
                out.write(".entity.");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$package/@name}", 7, 28)); //$NON-NLS-1$ //$NON-NLS-2$
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
                out.write("import javax.persistence.CascadeType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.Entity;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.EnumType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.Enumerated;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.FetchType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.GeneratedValue;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.Id;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.JoinColumn;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.JoinTable;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.OneToMany;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.ManyToMany;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.OneToOne;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.ManyToOne;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.Inheritance;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.InheritanceType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import javax.persistence.Transient;");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_if_34_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_34_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_34_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_34_1.setTagInfo(_td_c_if_34_1);
                _jettag_c_if_34_1.doStart(context, out);
                while (_jettag_c_if_34_1.okToProcessBody()) {
                    out.write("import javax.xml.bind.annotation.XmlRootElement;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import javax.xml.bind.annotation.XmlElement;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import javax.xml.bind.annotation.XmlTransient;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_34_1.handleBodyContent(out);
                }
                _jettag_c_if_34_1.doEnd();
                RuntimeTagElement _jettag_c_if_39_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_39_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_39_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_39_1.setTagInfo(_td_c_if_39_1);
                _jettag_c_if_39_1.doStart(context, out);
                while (_jettag_c_if_39_1.okToProcessBody()) {
                    out.write("import org.hibernate.search.annotations.DocumentId;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import org.hibernate.search.annotations.Field;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import org.hibernate.search.annotations.Indexed;");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("import org.hibernate.search.annotations.Index;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_39_1.handleBodyContent(out);
                }
                _jettag_c_if_39_1.doEnd();
                out.write("import javax.validation.constraints.*;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("import info.yalamanchili.jpa.AbstractEntity;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_49_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_49_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_49_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_49_1.setTagInfo(_td_f_message_49_1);
                _jettag_f_message_49_1.doStart(context, out);
                JET2Writer _jettag_f_message_49_1_saved_out = out;
                while (_jettag_f_message_49_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_49_1.handleBodyContent(out);
                }
                out = _jettag_f_message_49_1_saved_out;
                _jettag_f_message_49_1.doEnd();
                out.write(NL);         
                // check and add hibernate search 
                RuntimeTagElement _jettag_c_if_51_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_51_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_51_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_51_1.setTagInfo(_td_c_if_51_1);
                _jettag_c_if_51_1.doStart(context, out);
                while (_jettag_c_if_51_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_if_52_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_52_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_52_1.setRuntimeParent(_jettag_c_if_51_1);
                    _jettag_c_if_52_1.setTagInfo(_td_c_if_52_1);
                    _jettag_c_if_52_1.doStart(context, out);
                    while (_jettag_c_if_52_1.okToProcessBody()) {
                        out.write("@Indexed");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_if_52_1.handleBodyContent(out);
                    }
                    _jettag_c_if_52_1.doEnd();
                    _jettag_c_if_51_1.handleBodyContent(out);
                }
                _jettag_c_if_51_1.doEnd();
                // annotations for inheritance single_table
                RuntimeTagElement _jettag_c_if_57_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_57_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_57_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_57_1.setTagInfo(_td_c_if_57_1);
                _jettag_c_if_57_1.doStart(context, out);
                while (_jettag_c_if_57_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_if_58_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_58_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_58_1.setRuntimeParent(_jettag_c_if_57_1);
                    _jettag_c_if_58_1.setTagInfo(_td_c_if_58_1);
                    _jettag_c_if_58_1.doStart(context, out);
                    while (_jettag_c_if_58_1.okToProcessBody()) {
                        out.write("@Inheritance(strategy=InheritanceType.SINGLE_TABLE)");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_if_58_1.handleBodyContent(out);
                    }
                    _jettag_c_if_58_1.doEnd();
                    _jettag_c_if_57_1.handleBodyContent(out);
                }
                _jettag_c_if_57_1.doEnd();
                RuntimeTagElement _jettag_c_if_62_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_62_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_62_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_62_1.setTagInfo(_td_c_if_62_1);
                _jettag_c_if_62_1.doStart(context, out);
                while (_jettag_c_if_62_1.okToProcessBody()) {
                    out.write("@XmlRootElement");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_62_1.handleBodyContent(out);
                }
                _jettag_c_if_62_1.doEnd();
                out.write("@Entity");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("public ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_if_66_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_66_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_66_8.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_66_8.setTagInfo(_td_c_if_66_8);
                _jettag_c_if_66_8.doStart(context, out);
                while (_jettag_c_if_66_8.okToProcessBody()) {
                    out.write("abstract");  //$NON-NLS-1$        
                    _jettag_c_if_66_8.handleBodyContent(out);
                }
                _jettag_c_if_66_8.doEnd();
                out.write(" class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 66, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" extends ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_if_66_95 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_66_95); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_66_95.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_66_95.setTagInfo(_td_c_if_66_95);
                _jettag_c_if_66_95.doStart(context, out);
                while (_jettag_c_if_66_95.okToProcessBody()) {
                    out.write("  AbstractEntity ");  //$NON-NLS-1$        
                    _jettag_c_if_66_95.handleBodyContent(out);
                }
                _jettag_c_if_66_95.doEnd();
                out.write(" ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_if_66_173 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_66_173); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_66_173.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_66_173.setTagInfo(_td_c_if_66_173);
                _jettag_c_if_66_173.doStart(context, out);
                while (_jettag_c_if_66_173.okToProcessBody()) {
                    out.write("  ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@parentClass1Name}", 66, 233)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(" ");  //$NON-NLS-1$        
                    _jettag_c_if_66_173.handleBodyContent(out);
                }
                _jettag_c_if_66_173.doEnd();
                out.write(" {");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_67_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_67_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_67_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_67_1.setTagInfo(_td_f_message_67_1);
                _jettag_f_message_67_1.doStart(context, out);
                JET2Writer _jettag_f_message_67_1_saved_out = out;
                while (_jettag_f_message_67_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_67_1.handleBodyContent(out);
                }
                out = _jettag_f_message_67_1_saved_out;
                _jettag_f_message_67_1.doEnd();
                out.write(NL);         
                RuntimeTagElement _jettag_c_if_68_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_68_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_68_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_68_1.setTagInfo(_td_c_if_68_1);
                _jettag_c_if_68_1.doStart(context, out);
                while (_jettag_c_if_68_1.okToProcessBody()) {
                    out.write("@Transient ");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_68_1.handleBodyContent(out);
                }
                _jettag_c_if_68_1.doEnd();
                out.write("private static final long serialVersionUID = ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_unique_71_46 = context.getTagFactory().createRuntimeTag(_jetns_f, "unique", "f:unique", _td_f_unique_71_46); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_unique_71_46.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_unique_71_46.setTagInfo(_td_f_unique_71_46);
                _jettag_f_unique_71_46.doStart(context, out);
                _jettag_f_unique_71_46.doEnd();
                out.write("L;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                // Process annotations on the primitive datatypes
                RuntimeTagElement _jettag_c_iterate_74_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_74_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_74_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_74_1.setTagInfo(_td_c_iterate_74_1);
                _jettag_c_iterate_74_1.doStart(context, out);
                while (_jettag_c_iterate_74_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_f_message_75_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_75_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_75_1.setRuntimeParent(_jettag_c_iterate_74_1);
                    _jettag_f_message_75_1.setTagInfo(_td_f_message_75_1);
                    _jettag_f_message_75_1.doStart(context, out);
                    JET2Writer _jettag_f_message_75_1_saved_out = out;
                    while (_jettag_f_message_75_1.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_75_1.handleBodyContent(out);
                    }
                    out = _jettag_f_message_75_1_saved_out;
                    _jettag_f_message_75_1.doEnd();
                    out.write(NL);         
                    RuntimeTagElement _jettag_c_iterate_76_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_76_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_76_2.setRuntimeParent(_jettag_c_iterate_74_1);
                    _jettag_c_iterate_76_2.setTagInfo(_td_c_iterate_76_2);
                    _jettag_c_iterate_76_2.doStart(context, out);
                    while (_jettag_c_iterate_76_2.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_77_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_77_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_77_3.setRuntimeParent(_jettag_c_iterate_76_2);
                        _jettag_c_if_77_3.setTagInfo(_td_c_if_77_3);
                        _jettag_c_if_77_3.doStart(context, out);
                        while (_jettag_c_if_77_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_78_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_78_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_78_4.setRuntimeParent(_jettag_c_if_77_3);
                            _jettag_c_iterate_78_4.setTagInfo(_td_c_iterate_78_4);
                            _jettag_c_iterate_78_4.doStart(context, out);
                            while (_jettag_c_iterate_78_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_79_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_79_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_79_5.setRuntimeParent(_jettag_c_iterate_78_4);
                                _jettag_c_iterate_79_5.setTagInfo(_td_c_iterate_79_5);
                                _jettag_c_iterate_79_5.doStart(context, out);
                                while (_jettag_c_iterate_79_5.okToProcessBody()) {
                                    // If MIN length TAG
                                    RuntimeTagElement _jettag_c_if_81_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_81_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_81_6.setRuntimeParent(_jettag_c_iterate_79_5);
                                    _jettag_c_if_81_6.setTagInfo(_td_c_if_81_6);
                                    _jettag_c_if_81_6.doStart(context, out);
                                    while (_jettag_c_if_81_6.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_iterate_82_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_82_7); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_82_7.setRuntimeParent(_jettag_c_if_81_6);
                                        _jettag_c_iterate_82_7.setTagInfo(_td_c_iterate_82_7);
                                        _jettag_c_iterate_82_7.doStart(context, out);
                                        while (_jettag_c_iterate_82_7.okToProcessBody()) {
                                            // If MAX length TAG
                                            RuntimeTagElement _jettag_c_if_84_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_84_8); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_84_8.setRuntimeParent(_jettag_c_iterate_82_7);
                                            _jettag_c_if_84_8.setTagInfo(_td_c_if_84_8);
                                            _jettag_c_if_84_8.doStart(context, out);
                                            while (_jettag_c_if_84_8.okToProcessBody()) {
                                                out.write("@Size(min=");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$subtag1/TaggedValue.dataValue}", 85, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write(",max=");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$subtag2/TaggedValue.dataValue}", 85, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write(")\t");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                _jettag_c_if_84_8.handleBodyContent(out);
                                            }
                                            _jettag_c_if_84_8.doEnd();
                                            _jettag_c_iterate_82_7.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_82_7.doEnd();
                                        out.write("\t\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_81_6.handleBodyContent(out);
                                    }
                                    _jettag_c_if_81_6.doEnd();
                                    _jettag_c_iterate_79_5.handleBodyContent(out);
                                }
                                _jettag_c_iterate_79_5.doEnd();
                                _jettag_c_iterate_78_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_78_4.doEnd();
                            _jettag_c_if_77_3.handleBodyContent(out);
                        }
                        _jettag_c_if_77_3.doEnd();
                        RuntimeTagElement _jettag_c_if_93_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_93_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_93_3.setRuntimeParent(_jettag_c_iterate_76_2);
                        _jettag_c_if_93_3.setTagInfo(_td_c_if_93_3);
                        _jettag_c_if_93_3.doStart(context, out);
                        while (_jettag_c_if_93_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_94_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_94_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_94_4.setRuntimeParent(_jettag_c_if_93_3);
                            _jettag_c_iterate_94_4.setTagInfo(_td_c_iterate_94_4);
                            _jettag_c_iterate_94_4.doStart(context, out);
                            while (_jettag_c_iterate_94_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_95_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_95_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_95_5.setRuntimeParent(_jettag_c_iterate_94_4);
                                _jettag_c_iterate_95_5.setTagInfo(_td_c_iterate_95_5);
                                _jettag_c_iterate_95_5.doStart(context, out);
                                while (_jettag_c_iterate_95_5.okToProcessBody()) {
                                    // If MIN length TAG
                                    RuntimeTagElement _jettag_c_if_97_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_97_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_97_6.setRuntimeParent(_jettag_c_iterate_95_5);
                                    _jettag_c_if_97_6.setTagInfo(_td_c_if_97_6);
                                    _jettag_c_if_97_6.doStart(context, out);
                                    while (_jettag_c_if_97_6.okToProcessBody()) {
                                        out.write("@Min(");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$subtag/TaggedValue.dataValue}", 98, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(")\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_97_6.handleBodyContent(out);
                                    }
                                    _jettag_c_if_97_6.doEnd();
                                    _jettag_c_iterate_95_5.handleBodyContent(out);
                                }
                                _jettag_c_iterate_95_5.doEnd();
                                _jettag_c_iterate_94_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_94_4.doEnd();
                            _jettag_c_if_93_3.handleBodyContent(out);
                        }
                        _jettag_c_if_93_3.doEnd();
                        RuntimeTagElement _jettag_c_if_103_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_103_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_103_3.setRuntimeParent(_jettag_c_iterate_76_2);
                        _jettag_c_if_103_3.setTagInfo(_td_c_if_103_3);
                        _jettag_c_if_103_3.doStart(context, out);
                        while (_jettag_c_if_103_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_104_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_104_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_104_4.setRuntimeParent(_jettag_c_if_103_3);
                            _jettag_c_iterate_104_4.setTagInfo(_td_c_iterate_104_4);
                            _jettag_c_iterate_104_4.doStart(context, out);
                            while (_jettag_c_iterate_104_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_105_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_105_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_105_5.setRuntimeParent(_jettag_c_iterate_104_4);
                                _jettag_c_iterate_105_5.setTagInfo(_td_c_iterate_105_5);
                                _jettag_c_iterate_105_5.doStart(context, out);
                                while (_jettag_c_iterate_105_5.okToProcessBody()) {
                                    // If MIN length TAG
                                    RuntimeTagElement _jettag_c_if_107_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_107_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_107_6.setRuntimeParent(_jettag_c_iterate_105_5);
                                    _jettag_c_if_107_6.setTagInfo(_td_c_if_107_6);
                                    _jettag_c_if_107_6.doStart(context, out);
                                    while (_jettag_c_if_107_6.okToProcessBody()) {
                                        out.write("@Max(");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$subtag/TaggedValue.dataValue}", 108, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write(")\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_107_6.handleBodyContent(out);
                                    }
                                    _jettag_c_if_107_6.doEnd();
                                    _jettag_c_iterate_105_5.handleBodyContent(out);
                                }
                                _jettag_c_iterate_105_5.doEnd();
                                _jettag_c_iterate_104_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_104_4.doEnd();
                            _jettag_c_if_103_3.handleBodyContent(out);
                        }
                        _jettag_c_if_103_3.doEnd();
                        RuntimeTagElement _jettag_c_if_113_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_113_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_113_3.setRuntimeParent(_jettag_c_iterate_76_2);
                        _jettag_c_if_113_3.setTagInfo(_td_c_if_113_3);
                        _jettag_c_if_113_3.doStart(context, out);
                        while (_jettag_c_if_113_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_114_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_114_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_114_4.setRuntimeParent(_jettag_c_if_113_3);
                            _jettag_c_iterate_114_4.setTagInfo(_td_c_iterate_114_4);
                            _jettag_c_iterate_114_4.doStart(context, out);
                            while (_jettag_c_iterate_114_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_115_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_115_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_115_5.setRuntimeParent(_jettag_c_iterate_114_4);
                                _jettag_c_iterate_115_5.setTagInfo(_td_c_iterate_115_5);
                                _jettag_c_iterate_115_5.doStart(context, out);
                                while (_jettag_c_iterate_115_5.okToProcessBody()) {
                                    // If MIN length TAG
                                    RuntimeTagElement _jettag_c_if_117_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_117_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_117_6.setRuntimeParent(_jettag_c_iterate_115_5);
                                    _jettag_c_if_117_6.setTagInfo(_td_c_if_117_6);
                                    _jettag_c_if_117_6.doStart(context, out);
                                    while (_jettag_c_if_117_6.okToProcessBody()) {
                                        out.write("@DecimalMin(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$subtag/TaggedValue.dataValue}", 118, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\")\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_117_6.handleBodyContent(out);
                                    }
                                    _jettag_c_if_117_6.doEnd();
                                    _jettag_c_iterate_115_5.handleBodyContent(out);
                                }
                                _jettag_c_iterate_115_5.doEnd();
                                _jettag_c_iterate_114_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_114_4.doEnd();
                            _jettag_c_if_113_3.handleBodyContent(out);
                        }
                        _jettag_c_if_113_3.doEnd();
                        RuntimeTagElement _jettag_c_if_123_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_123_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_123_3.setRuntimeParent(_jettag_c_iterate_76_2);
                        _jettag_c_if_123_3.setTagInfo(_td_c_if_123_3);
                        _jettag_c_if_123_3.doStart(context, out);
                        while (_jettag_c_if_123_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_iterate_124_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_124_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_124_4.setRuntimeParent(_jettag_c_if_123_3);
                            _jettag_c_iterate_124_4.setTagInfo(_td_c_iterate_124_4);
                            _jettag_c_iterate_124_4.doStart(context, out);
                            while (_jettag_c_iterate_124_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_iterate_125_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_125_5); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_125_5.setRuntimeParent(_jettag_c_iterate_124_4);
                                _jettag_c_iterate_125_5.setTagInfo(_td_c_iterate_125_5);
                                _jettag_c_iterate_125_5.doStart(context, out);
                                while (_jettag_c_iterate_125_5.okToProcessBody()) {
                                    // If MIN length TAG
                                    RuntimeTagElement _jettag_c_if_127_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_127_6); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_127_6.setRuntimeParent(_jettag_c_iterate_125_5);
                                    _jettag_c_if_127_6.setTagInfo(_td_c_if_127_6);
                                    _jettag_c_if_127_6.doStart(context, out);
                                    while (_jettag_c_if_127_6.okToProcessBody()) {
                                        out.write("@DecimalMax(\"");  //$NON-NLS-1$        
                                        out.write(context.embeddedExpressionAsString("${$subtag/TaggedValue.dataValue}", 128, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                                        out.write("\")\t");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_127_6.handleBodyContent(out);
                                    }
                                    _jettag_c_if_127_6.doEnd();
                                    _jettag_c_iterate_125_5.handleBodyContent(out);
                                }
                                _jettag_c_iterate_125_5.doEnd();
                                _jettag_c_iterate_124_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_124_4.doEnd();
                            _jettag_c_if_123_3.handleBodyContent(out);
                        }
                        _jettag_c_if_123_3.doEnd();
                        RuntimeTagElement _jettag_c_if_133_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_133_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_133_3.setRuntimeParent(_jettag_c_iterate_76_2);
                        _jettag_c_if_133_3.setTagInfo(_td_c_if_133_3);
                        _jettag_c_if_133_3.doStart(context, out);
                        while (_jettag_c_if_133_3.okToProcessBody()) {
                            out.write("@NotNull");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_133_3.handleBodyContent(out);
                        }
                        _jettag_c_if_133_3.doEnd();
                        RuntimeTagElement _jettag_c_if_136_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_136_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_136_3.setRuntimeParent(_jettag_c_iterate_76_2);
                        _jettag_c_if_136_3.setTagInfo(_td_c_if_136_3);
                        _jettag_c_if_136_3.doStart(context, out);
                        while (_jettag_c_if_136_3.okToProcessBody()) {
                            out.write("@Size(min = 1)");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_136_3.handleBodyContent(out);
                        }
                        _jettag_c_if_136_3.doEnd();
                        RuntimeTagElement _jettag_c_if_139_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_139_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_139_3.setRuntimeParent(_jettag_c_iterate_76_2);
                        _jettag_c_if_139_3.setTagInfo(_td_c_if_139_3);
                        _jettag_c_if_139_3.doStart(context, out);
                        while (_jettag_c_if_139_3.okToProcessBody()) {
                            out.write("@Past");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_139_3.handleBodyContent(out);
                        }
                        _jettag_c_if_139_3.doEnd();
                        RuntimeTagElement _jettag_c_if_142_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_142_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_142_3.setRuntimeParent(_jettag_c_iterate_76_2);
                        _jettag_c_if_142_3.setTagInfo(_td_c_if_142_3);
                        _jettag_c_if_142_3.doStart(context, out);
                        while (_jettag_c_if_142_3.okToProcessBody()) {
                            out.write("@Future");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_142_3.handleBodyContent(out);
                        }
                        _jettag_c_if_142_3.doEnd();
                        _jettag_c_iterate_76_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_76_2.doEnd();
                    // hibernate search field annatations 
                    RuntimeTagElement _jettag_c_if_147_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_147_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_147_1.setRuntimeParent(_jettag_c_iterate_74_1);
                    _jettag_c_if_147_1.setTagInfo(_td_c_if_147_1);
                    _jettag_c_if_147_1.doStart(context, out);
                    while (_jettag_c_if_147_1.okToProcessBody()) {
                        out.write("\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_choose_148_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_148_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_148_3.setRuntimeParent(_jettag_c_if_147_1);
                        _jettag_c_choose_148_3.setTagInfo(_td_c_choose_148_3);
                        _jettag_c_choose_148_3.doStart(context, out);
                        JET2Writer _jettag_c_choose_148_3_saved_out = out;
                        while (_jettag_c_choose_148_3.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_148_73 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_148_73); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_148_73.setRuntimeParent(_jettag_c_choose_148_3);
                            _jettag_c_when_148_73.setTagInfo(_td_c_when_148_73);
                            _jettag_c_when_148_73.doStart(context, out);
                            JET2Writer _jettag_c_when_148_73_saved_out = out;
                            while (_jettag_c_when_148_73.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" @Field ");  //$NON-NLS-1$        
                                _jettag_c_when_148_73.handleBodyContent(out);
                            }
                            out = _jettag_c_when_148_73_saved_out;
                            _jettag_c_when_148_73.doEnd();
                            out.write(" ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_148_122 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_148_122); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_148_122.setRuntimeParent(_jettag_c_choose_148_3);
                            _jettag_c_when_148_122.setTagInfo(_td_c_when_148_122);
                            _jettag_c_when_148_122.doStart(context, out);
                            JET2Writer _jettag_c_when_148_122_saved_out = out;
                            while (_jettag_c_when_148_122.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" @Field(index=Index.UN_TOKENIZED) \t");  //$NON-NLS-1$        
                                _jettag_c_when_148_122.handleBodyContent(out);
                            }
                            out = _jettag_c_when_148_122_saved_out;
                            _jettag_c_when_148_122.doEnd();
                            RuntimeTagElement _jettag_c_when_148_198 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_148_198); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_148_198.setRuntimeParent(_jettag_c_choose_148_3);
                            _jettag_c_when_148_198.setTagInfo(_td_c_when_148_198);
                            _jettag_c_when_148_198.doStart(context, out);
                            JET2Writer _jettag_c_when_148_198_saved_out = out;
                            while (_jettag_c_when_148_198.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" @Field(index=Index.UN_TOKENIZED) ");  //$NON-NLS-1$        
                                _jettag_c_when_148_198.handleBodyContent(out);
                            }
                            out = _jettag_c_when_148_198_saved_out;
                            _jettag_c_when_148_198.doEnd();
                            RuntimeTagElement _jettag_c_when_148_270 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_148_270); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_148_270.setRuntimeParent(_jettag_c_choose_148_3);
                            _jettag_c_when_148_270.setTagInfo(_td_c_when_148_270);
                            _jettag_c_when_148_270.doStart(context, out);
                            JET2Writer _jettag_c_when_148_270_saved_out = out;
                            while (_jettag_c_when_148_270.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write("@Field(index=Index.UN_TOKENIZED) ");  //$NON-NLS-1$        
                                _jettag_c_when_148_270.handleBodyContent(out);
                            }
                            out = _jettag_c_when_148_270_saved_out;
                            _jettag_c_when_148_270.doEnd();
                            RuntimeTagElement _jettag_c_when_148_344 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_148_344); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_148_344.setRuntimeParent(_jettag_c_choose_148_3);
                            _jettag_c_when_148_344.setTagInfo(_td_c_when_148_344);
                            _jettag_c_when_148_344.doStart(context, out);
                            JET2Writer _jettag_c_when_148_344_saved_out = out;
                            while (_jettag_c_when_148_344.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" @Field(index=Index.UN_TOKENIZED) ");  //$NON-NLS-1$        
                                _jettag_c_when_148_344.handleBodyContent(out);
                            }
                            out = _jettag_c_when_148_344_saved_out;
                            _jettag_c_when_148_344.doEnd();
                            RuntimeTagElement _jettag_c_when_148_416 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_148_416); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_148_416.setRuntimeParent(_jettag_c_choose_148_3);
                            _jettag_c_when_148_416.setTagInfo(_td_c_when_148_416);
                            _jettag_c_when_148_416.doStart(context, out);
                            JET2Writer _jettag_c_when_148_416_saved_out = out;
                            while (_jettag_c_when_148_416.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" @Field(index=Index.UN_TOKENIZED) ");  //$NON-NLS-1$        
                                _jettag_c_when_148_416.handleBodyContent(out);
                            }
                            out = _jettag_c_when_148_416_saved_out;
                            _jettag_c_when_148_416.doEnd();
                            out.write(" ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_148_490 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_148_490); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_148_490.setRuntimeParent(_jettag_c_choose_148_3);
                            _jettag_c_when_148_490.setTagInfo(_td_c_when_148_490);
                            _jettag_c_when_148_490.doStart(context, out);
                            JET2Writer _jettag_c_when_148_490_saved_out = out;
                            while (_jettag_c_when_148_490.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" @Field ");  //$NON-NLS-1$        
                                _jettag_c_when_148_490.handleBodyContent(out);
                            }
                            out = _jettag_c_when_148_490_saved_out;
                            _jettag_c_when_148_490.doEnd();
                            out.write(" ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_148_538 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_148_538); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_148_538.setRuntimeParent(_jettag_c_choose_148_3);
                            _jettag_c_when_148_538.setTagInfo(_td_c_when_148_538);
                            _jettag_c_when_148_538.doStart(context, out);
                            JET2Writer _jettag_c_when_148_538_saved_out = out;
                            while (_jettag_c_when_148_538.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" @Field ");  //$NON-NLS-1$        
                                _jettag_c_when_148_538.handleBodyContent(out);
                            }
                            out = _jettag_c_when_148_538_saved_out;
                            _jettag_c_when_148_538.doEnd();
                            RuntimeTagElement _jettag_c_when_148_588 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_148_588); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_148_588.setRuntimeParent(_jettag_c_choose_148_3);
                            _jettag_c_when_148_588.setTagInfo(_td_c_when_148_588);
                            _jettag_c_when_148_588.doStart(context, out);
                            JET2Writer _jettag_c_when_148_588_saved_out = out;
                            while (_jettag_c_when_148_588.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" @Field(index=Index.UN_TOKENIZED) ");  //$NON-NLS-1$        
                                _jettag_c_when_148_588.handleBodyContent(out);
                            }
                            out = _jettag_c_when_148_588_saved_out;
                            _jettag_c_when_148_588.doEnd();
                            out.write(NL);         
                            _jettag_c_choose_148_3.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_148_3_saved_out;
                        _jettag_c_choose_148_3.doEnd();
                        _jettag_c_if_147_1.handleBodyContent(out);
                    }
                    _jettag_c_if_147_1.doEnd();
                    // processes the premitive Datatypes and enums
                    out.write("\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_choose_152_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_152_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_152_3.setRuntimeParent(_jettag_c_iterate_74_1);
                    _jettag_c_choose_152_3.setTagInfo(_td_c_choose_152_3);
                    _jettag_c_choose_152_3.doStart(context, out);
                    JET2Writer _jettag_c_choose_152_3_saved_out = out;
                    while (_jettag_c_choose_152_3.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_152_73 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_152_73); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_152_73.setRuntimeParent(_jettag_c_choose_152_3);
                        _jettag_c_when_152_73.setTagInfo(_td_c_when_152_73);
                        _jettag_c_when_152_73.doStart(context, out);
                        JET2Writer _jettag_c_when_152_73_saved_out = out;
                        while (_jettag_c_when_152_73.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected String ");  //$NON-NLS-1$        
                            _jettag_c_when_152_73.handleBodyContent(out);
                        }
                        out = _jettag_c_when_152_73_saved_out;
                        _jettag_c_when_152_73.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_152_132 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_152_132); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_152_132.setRuntimeParent(_jettag_c_choose_152_3);
                        _jettag_c_when_152_132.setTagInfo(_td_c_when_152_132);
                        _jettag_c_when_152_132.doStart(context, out);
                        JET2Writer _jettag_c_when_152_132_saved_out = out;
                        while (_jettag_c_when_152_132.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected Integer ");  //$NON-NLS-1$        
                            _jettag_c_when_152_132.handleBodyContent(out);
                        }
                        out = _jettag_c_when_152_132_saved_out;
                        _jettag_c_when_152_132.doEnd();
                        RuntimeTagElement _jettag_c_when_152_192 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_152_192); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_152_192.setRuntimeParent(_jettag_c_choose_152_3);
                        _jettag_c_when_152_192.setTagInfo(_td_c_when_152_192);
                        _jettag_c_when_152_192.doStart(context, out);
                        JET2Writer _jettag_c_when_152_192_saved_out = out;
                        while (_jettag_c_when_152_192.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected Date ");  //$NON-NLS-1$        
                            _jettag_c_when_152_192.handleBodyContent(out);
                        }
                        out = _jettag_c_when_152_192_saved_out;
                        _jettag_c_when_152_192.doEnd();
                        RuntimeTagElement _jettag_c_when_152_246 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_152_246); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_152_246.setRuntimeParent(_jettag_c_choose_152_3);
                        _jettag_c_when_152_246.setTagInfo(_td_c_when_152_246);
                        _jettag_c_when_152_246.doStart(context, out);
                        JET2Writer _jettag_c_when_152_246_saved_out = out;
                        while (_jettag_c_when_152_246.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("protected  Boolean ");  //$NON-NLS-1$        
                            _jettag_c_when_152_246.handleBodyContent(out);
                        }
                        out = _jettag_c_when_152_246_saved_out;
                        _jettag_c_when_152_246.doEnd();
                        RuntimeTagElement _jettag_c_when_152_306 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_152_306); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_152_306.setRuntimeParent(_jettag_c_choose_152_3);
                        _jettag_c_when_152_306.setTagInfo(_td_c_when_152_306);
                        _jettag_c_when_152_306.doStart(context, out);
                        JET2Writer _jettag_c_when_152_306_saved_out = out;
                        while (_jettag_c_when_152_306.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected Long ");  //$NON-NLS-1$        
                            _jettag_c_when_152_306.handleBodyContent(out);
                        }
                        out = _jettag_c_when_152_306_saved_out;
                        _jettag_c_when_152_306.doEnd();
                        RuntimeTagElement _jettag_c_when_152_360 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_152_360); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_152_360.setRuntimeParent(_jettag_c_choose_152_3);
                        _jettag_c_when_152_360.setTagInfo(_td_c_when_152_360);
                        _jettag_c_when_152_360.doStart(context, out);
                        JET2Writer _jettag_c_when_152_360_saved_out = out;
                        while (_jettag_c_when_152_360.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected Float ");  //$NON-NLS-1$        
                            _jettag_c_when_152_360.handleBodyContent(out);
                        }
                        out = _jettag_c_when_152_360_saved_out;
                        _jettag_c_when_152_360.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_152_417 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_152_417); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_152_417.setRuntimeParent(_jettag_c_choose_152_3);
                        _jettag_c_when_152_417.setTagInfo(_td_c_when_152_417);
                        _jettag_c_when_152_417.doStart(context, out);
                        JET2Writer _jettag_c_when_152_417_saved_out = out;
                        while (_jettag_c_when_152_417.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected String ");  //$NON-NLS-1$        
                            _jettag_c_when_152_417.handleBodyContent(out);
                        }
                        out = _jettag_c_when_152_417_saved_out;
                        _jettag_c_when_152_417.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_152_475 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_152_475); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_152_475.setRuntimeParent(_jettag_c_choose_152_3);
                        _jettag_c_when_152_475.setTagInfo(_td_c_when_152_475);
                        _jettag_c_when_152_475.doStart(context, out);
                        JET2Writer _jettag_c_when_152_475_saved_out = out;
                        while (_jettag_c_when_152_475.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" protected String ");  //$NON-NLS-1$        
                            _jettag_c_when_152_475.handleBodyContent(out);
                        }
                        out = _jettag_c_when_152_475_saved_out;
                        _jettag_c_when_152_475.doEnd();
                        RuntimeTagElement _jettag_c_when_152_535 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_152_535); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_152_535.setRuntimeParent(_jettag_c_choose_152_3);
                        _jettag_c_when_152_535.setTagInfo(_td_c_when_152_535);
                        _jettag_c_when_152_535.doStart(context, out);
                        JET2Writer _jettag_c_when_152_535_saved_out = out;
                        while (_jettag_c_when_152_535.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" @Digits(fraction = 2, integer = 10) protected BigDecimal ");  //$NON-NLS-1$        
                            _jettag_c_when_152_535.handleBodyContent(out);
                        }
                        out = _jettag_c_when_152_535_saved_out;
                        _jettag_c_when_152_535.doEnd();
                        out.write(NL);         
                        RuntimeTagElement _jettag_c_otherwise_153_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_153_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_153_3.setRuntimeParent(_jettag_c_choose_152_3);
                        _jettag_c_otherwise_153_3.setTagInfo(_td_c_otherwise_153_3);
                        _jettag_c_otherwise_153_3.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_153_3_saved_out = out;
                        while (_jettag_c_otherwise_153_3.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            RuntimeTagElement _jettag_c_iterate_154_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_154_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_154_4.setRuntimeParent(_jettag_c_otherwise_153_3);
                            _jettag_c_iterate_154_4.setTagInfo(_td_c_iterate_154_4);
                            _jettag_c_iterate_154_4.doStart(context, out);
                            while (_jettag_c_iterate_154_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_155_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_155_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_155_6.setRuntimeParent(_jettag_c_iterate_154_4);
                                _jettag_c_if_155_6.setTagInfo(_td_c_if_155_6);
                                _jettag_c_if_155_6.doStart(context, out);
                                while (_jettag_c_if_155_6.okToProcessBody()) {
                                    out.write("\t \t\t\t@Enumerated(EnumType.STRING)");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    RuntimeTagElement _jettag_c_if_157_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_157_5); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_157_5.setRuntimeParent(_jettag_c_if_155_6);
                                    _jettag_c_if_157_5.setTagInfo(_td_c_if_157_5);
                                    _jettag_c_if_157_5.doStart(context, out);
                                    while (_jettag_c_if_157_5.okToProcessBody()) {
                                        out.write("\t\t\t\t@Field");  //$NON-NLS-1$        
                                        out.write(NL);         
                                        _jettag_c_if_157_5.handleBodyContent(out);
                                    }
                                    _jettag_c_if_157_5.doEnd();
                                    out.write("\t \t\t\tprotected  ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$enumeration/@name}", 160, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(" ");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_155_6.handleBodyContent(out);
                                }
                                _jettag_c_if_155_6.doEnd();
                                _jettag_c_iterate_154_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_154_4.doEnd();
                            _jettag_c_otherwise_153_3.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_153_3_saved_out;
                        _jettag_c_otherwise_153_3.doEnd();
                        _jettag_c_choose_152_3.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_152_3_saved_out;
                    _jettag_c_choose_152_3.doEnd();
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 165, 1)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write(NL);         
                    _jettag_c_iterate_74_1.handleBodyContent(out);
                }
                _jettag_c_iterate_74_1.doEnd();
                out.write(NL);         
                out.write(NL);         
                out.write(NL);         
                // collections and user defined Datatypes 
                RuntimeTagElement _jettag_c_iterate_172_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_172_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_172_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_172_1.setTagInfo(_td_c_iterate_172_1);
                _jettag_c_iterate_172_1.doStart(context, out);
                while (_jettag_c_iterate_172_1.okToProcessBody()) {
                    out.write(NL);         
                    RuntimeTagElement _jettag_c_iterate_174_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_174_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_174_2.setRuntimeParent(_jettag_c_iterate_172_1);
                    _jettag_c_iterate_174_2.setTagInfo(_td_c_iterate_174_2);
                    _jettag_c_iterate_174_2.doStart(context, out);
                    while (_jettag_c_iterate_174_2.okToProcessBody()) {
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        RuntimeTagElement _jettag_c_iterate_176_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_176_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_176_3.setRuntimeParent(_jettag_c_iterate_174_2);
                        _jettag_c_iterate_176_3.setTagInfo(_td_c_iterate_176_3);
                        _jettag_c_iterate_176_3.doStart(context, out);
                        while (_jettag_c_iterate_176_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_177_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_177_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_177_4.setRuntimeParent(_jettag_c_iterate_176_3);
                            _jettag_c_setVariable_177_4.setTagInfo(_td_c_setVariable_177_4);
                            _jettag_c_setVariable_177_4.doStart(context, out);
                            _jettag_c_setVariable_177_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_179_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_179_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_179_6.setRuntimeParent(_jettag_c_iterate_176_3);
                            _jettag_c_if_179_6.setTagInfo(_td_c_if_179_6);
                            _jettag_c_if_179_6.doStart(context, out);
                            while (_jettag_c_if_179_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_181_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_181_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_181_12.setRuntimeParent(_jettag_c_if_179_6);
                                _jettag_c_iterate_181_12.setTagInfo(_td_c_iterate_181_12);
                                _jettag_c_iterate_181_12.doStart(context, out);
                                while (_jettag_c_iterate_181_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_182_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_182_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_182_12.setRuntimeParent(_jettag_c_iterate_181_12);
                                    _jettag_c_setVariable_182_12.setTagInfo(_td_c_setVariable_182_12);
                                    _jettag_c_setVariable_182_12.doStart(context, out);
                                    _jettag_c_setVariable_182_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_184_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_184_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_184_14.setRuntimeParent(_jettag_c_iterate_181_12);
                                    _jettag_c_if_184_14.setTagInfo(_td_c_if_184_14);
                                    _jettag_c_if_184_14.doStart(context, out);
                                    while (_jettag_c_if_184_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_186_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_186_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_186_15.setRuntimeParent(_jettag_c_if_184_14);
                                        _jettag_c_iterate_186_15.setTagInfo(_td_c_iterate_186_15);
                                        _jettag_c_iterate_186_15.doStart(context, out);
                                        while (_jettag_c_iterate_186_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_187_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_187_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_187_16.setRuntimeParent(_jettag_c_iterate_186_15);
                                            _jettag_c_if_187_16.setTagInfo(_td_c_if_187_16);
                                            _jettag_c_if_187_16.doStart(context, out);
                                            while (_jettag_c_if_187_16.okToProcessBody()) {
                                                out.write("  ");  //$NON-NLS-1$        
                                                RuntimeTagElement _jettag_f_message_188_3 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_188_3); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_f_message_188_3.setRuntimeParent(_jettag_c_if_187_16);
                                                _jettag_f_message_188_3.setTagInfo(_td_f_message_188_3);
                                                _jettag_f_message_188_3.doStart(context, out);
                                                JET2Writer _jettag_f_message_188_3_saved_out = out;
                                                while (_jettag_f_message_188_3.okToProcessBody()) {
                                                    out = out.newNestedContentWriter();
                                                    out.write("generated.comment");  //$NON-NLS-1$        
                                                    _jettag_f_message_188_3.handleBodyContent(out);
                                                }
                                                out = _jettag_f_message_188_3_saved_out;
                                                _jettag_f_message_188_3.doEnd();
                                                out.write("\t\t");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                // check to see the association is navigable in the first case
                                                RuntimeTagElement _jettag_c_if_190_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_190_13); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_190_13.setRuntimeParent(_jettag_c_if_187_16);
                                                _jettag_c_if_190_13.setTagInfo(_td_c_if_190_13);
                                                _jettag_c_if_190_13.doStart(context, out);
                                                while (_jettag_c_if_190_13.okToProcessBody()) {
                                                    // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                    // check if the multiplicityis one to one
                                                    RuntimeTagElement _jettag_c_if_193_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_193_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_193_16.setRuntimeParent(_jettag_c_if_190_13);
                                                    _jettag_c_if_193_16.setTagInfo(_td_c_if_193_16);
                                                    _jettag_c_if_193_16.doStart(context, out);
                                                    while (_jettag_c_if_193_16.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_194_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_194_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_194_18.setRuntimeParent(_jettag_c_if_193_16);
                                                        _jettag_c_if_194_18.setTagInfo(_td_c_if_194_18);
                                                        _jettag_c_if_194_18.doStart(context, out);
                                                        while (_jettag_c_if_194_18.okToProcessBody()) {
                                                            //check the relations
                                                            // Composite @ManyToOne
                                                            RuntimeTagElement _jettag_c_if_197_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_197_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_197_19.setRuntimeParent(_jettag_c_if_194_18);
                                                            _jettag_c_if_197_19.setTagInfo(_td_c_if_197_19);
                                                            _jettag_c_if_197_19.doStart(context, out);
                                                            while (_jettag_c_if_197_19.okToProcessBody()) {
                                                                out.write("  \t\t\t\t\t    \t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("@ManyToOne(cascade = CascadeType.MERGE)\t\t\t    \t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_197_19.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_197_19.doEnd();
                                                            // Aggregate @ManyToOne
                                                            RuntimeTagElement _jettag_c_if_202_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_202_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_202_19.setRuntimeParent(_jettag_c_if_194_18);
                                                            _jettag_c_if_202_19.setTagInfo(_td_c_if_202_19);
                                                            _jettag_c_if_202_19.doStart(context, out);
                                                            while (_jettag_c_if_202_19.okToProcessBody()) {
                                                                out.write(" \t\t\t\t\t    \t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write(" @ManyToOne(cascade = CascadeType.MERGE) \t\t\t\t\t    \t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_202_19.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_202_19.doEnd();
                                                            // Association OneToOne or OneToMany
                                                            RuntimeTagElement _jettag_c_if_207_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_207_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_207_20.setRuntimeParent(_jettag_c_if_194_18);
                                                            _jettag_c_if_207_20.setTagInfo(_td_c_if_207_20);
                                                            _jettag_c_if_207_20.doStart(context, out);
                                                            while (_jettag_c_if_207_20.okToProcessBody()) {
                                                                // check for one or many realations
                                                                RuntimeTagElement _jettag_c_if_209_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_209_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_209_20.setRuntimeParent(_jettag_c_if_207_20);
                                                                _jettag_c_if_209_20.setTagInfo(_td_c_if_209_20);
                                                                _jettag_c_if_209_20.doStart(context, out);
                                                                while (_jettag_c_if_209_20.okToProcessBody()) {
                                                                    RuntimeTagElement _jettag_c_if_210_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_210_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_c_if_210_21.setRuntimeParent(_jettag_c_if_209_20);
                                                                    _jettag_c_if_210_21.setTagInfo(_td_c_if_210_21);
                                                                    _jettag_c_if_210_21.doStart(context, out);
                                                                    while (_jettag_c_if_210_21.okToProcessBody()) {
                                                                        out.write("  \t\t\t\t\t    \t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        out.write("@OneToOne \t(cascade = CascadeType.ALL)\t\t\t\t    \t\t\t\t");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        _jettag_c_if_210_21.handleBodyContent(out);
                                                                    }
                                                                    _jettag_c_if_210_21.doEnd();
                                                                    _jettag_c_if_209_20.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_209_20.doEnd();
                                                                RuntimeTagElement _jettag_c_if_215_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_215_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_215_20.setRuntimeParent(_jettag_c_if_207_20);
                                                                _jettag_c_if_215_20.setTagInfo(_td_c_if_215_20);
                                                                _jettag_c_if_215_20.doStart(context, out);
                                                                while (_jettag_c_if_215_20.okToProcessBody()) {
                                                                    RuntimeTagElement _jettag_c_if_216_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_216_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_c_if_216_21.setRuntimeParent(_jettag_c_if_215_20);
                                                                    _jettag_c_if_216_21.setTagInfo(_td_c_if_216_21);
                                                                    _jettag_c_if_216_21.doStart(context, out);
                                                                    while (_jettag_c_if_216_21.okToProcessBody()) {
                                                                        out.write("  \t\t\t\t\t    \t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        out.write(" @ManyToOne \t\t\t\t\t    \t\t\t\t");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        _jettag_c_if_216_21.handleBodyContent(out);
                                                                    }
                                                                    _jettag_c_if_216_21.doEnd();
                                                                    _jettag_c_if_215_20.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_215_20.doEnd();
                                                                _jettag_c_if_207_20.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_207_20.doEnd();
                                                            out.write(" protected \t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 222, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("  ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 222, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_194_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_194_18.doEnd();
                                                        _jettag_c_if_193_16.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_193_16.doEnd();
                                                    // check if the multiplicityis one to many
                                                    RuntimeTagElement _jettag_c_if_226_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_226_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_226_17.setRuntimeParent(_jettag_c_if_190_13);
                                                    _jettag_c_if_226_17.setTagInfo(_td_c_if_226_17);
                                                    _jettag_c_if_226_17.doStart(context, out);
                                                    while (_jettag_c_if_226_17.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_227_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_227_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_227_18.setRuntimeParent(_jettag_c_if_226_17);
                                                        _jettag_c_if_227_18.setTagInfo(_td_c_if_227_18);
                                                        _jettag_c_if_227_18.doStart(context, out);
                                                        while (_jettag_c_if_227_18.okToProcessBody()) {
                                                            //check the relations
                                                            // Composite @ManyToOne
                                                            RuntimeTagElement _jettag_c_if_230_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_230_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_230_19.setRuntimeParent(_jettag_c_if_227_18);
                                                            _jettag_c_if_230_19.setTagInfo(_td_c_if_230_19);
                                                            _jettag_c_if_230_19.doStart(context, out);
                                                            while (_jettag_c_if_230_19.okToProcessBody()) {
                                                                out.write("    \t\t\t\t\t    \t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write(" @OneToMany(mappedBy=\"");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lowercaseFirst($class/@name)}", 232, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("\", cascade = CascadeType.ALL)\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("  protected \tList<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 233, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(">  ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 233, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s;\t\t\t\t    \t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_230_19.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_230_19.doEnd();
                                                            // Aggregate @ManyToOne
                                                            RuntimeTagElement _jettag_c_if_236_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_236_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_236_19.setRuntimeParent(_jettag_c_if_227_18);
                                                            _jettag_c_if_236_19.setTagInfo(_td_c_if_236_19);
                                                            _jettag_c_if_236_19.doStart(context, out);
                                                            while (_jettag_c_if_236_19.okToProcessBody()) {
                                                                out.write("   \t\t\t\t\t    \t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write(" @OneToMany(mappedBy=\"");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lowercaseFirst($class/@name)}", 238, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("\", cascade = CascadeType.MERGE)\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                out.write("  protected \tList<");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${$class2/@name}", 239, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write(">  ");  //$NON-NLS-1$        
                                                                out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 239, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                out.write("s;\t\t    \t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_236_19.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_236_19.doEnd();
                                                            // Association OneToOne or OneToMany
                                                            RuntimeTagElement _jettag_c_if_242_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_242_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_242_20.setRuntimeParent(_jettag_c_if_227_18);
                                                            _jettag_c_if_242_20.setTagInfo(_td_c_if_242_20);
                                                            _jettag_c_if_242_20.doStart(context, out);
                                                            while (_jettag_c_if_242_20.okToProcessBody()) {
                                                                // check for one or many realations
                                                                RuntimeTagElement _jettag_c_if_244_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_244_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_244_20.setRuntimeParent(_jettag_c_if_242_20);
                                                                _jettag_c_if_244_20.setTagInfo(_td_c_if_244_20);
                                                                _jettag_c_if_244_20.doStart(context, out);
                                                                while (_jettag_c_if_244_20.okToProcessBody()) {
                                                                    RuntimeTagElement _jettag_c_if_245_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_245_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_c_if_245_21.setRuntimeParent(_jettag_c_if_244_20);
                                                                    _jettag_c_if_245_21.setTagInfo(_td_c_if_245_21);
                                                                    _jettag_c_if_245_21.doStart(context, out);
                                                                    while (_jettag_c_if_245_21.okToProcessBody()) {
                                                                        out.write("  \t\t\t\t\t    \t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        out.write(" @OneToMany (mappedBy=\"");  //$NON-NLS-1$        
                                                                        out.write(context.embeddedExpressionAsString("${lowercaseFirst($class/@name)}", 247, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                        out.write("\")\t");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        out.write("  protected \tList<");  //$NON-NLS-1$        
                                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 248, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                        out.write(">  ");  //$NON-NLS-1$        
                                                                        out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 248, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                        out.write("s;\t\t\t    \t\t\t\t");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        _jettag_c_if_245_21.handleBodyContent(out);
                                                                    }
                                                                    _jettag_c_if_245_21.doEnd();
                                                                    _jettag_c_if_244_20.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_244_20.doEnd();
                                                                RuntimeTagElement _jettag_c_if_251_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_251_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_251_20.setRuntimeParent(_jettag_c_if_242_20);
                                                                _jettag_c_if_251_20.setTagInfo(_td_c_if_251_20);
                                                                _jettag_c_if_251_20.doStart(context, out);
                                                                while (_jettag_c_if_251_20.okToProcessBody()) {
                                                                    RuntimeTagElement _jettag_c_if_252_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_252_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_c_if_252_21.setRuntimeParent(_jettag_c_if_251_20);
                                                                    _jettag_c_if_252_21.setTagInfo(_td_c_if_252_21);
                                                                    _jettag_c_if_252_21.doStart(context, out);
                                                                    while (_jettag_c_if_252_21.okToProcessBody()) {
                                                                        out.write("  \t\t\t\t\t    \t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        out.write(" @ManyToMany \t");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        out.write("  protected \tSet<");  //$NON-NLS-1$        
                                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 255, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                        out.write(">  ");  //$NON-NLS-1$        
                                                                        out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 255, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                        out.write("s;\t\t\t\t    \t\t\t\t");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        _jettag_c_if_252_21.handleBodyContent(out);
                                                                    }
                                                                    _jettag_c_if_252_21.doEnd();
                                                                    _jettag_c_if_251_20.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_251_20.doEnd();
                                                                _jettag_c_if_242_20.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_242_20.doEnd();
                                                            _jettag_c_if_227_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_227_18.doEnd();
                                                        _jettag_c_if_226_17.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_226_17.doEnd();
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_190_13.handleBodyContent(out);
                                                }
                                                _jettag_c_if_190_13.doEnd();
                                                _jettag_c_if_187_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_187_16.doEnd();
                                            _jettag_c_iterate_186_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_186_15.doEnd();
                                        _jettag_c_if_184_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_184_14.doEnd();
                                    _jettag_c_iterate_181_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_181_12.doEnd();
                                _jettag_c_if_179_6.handleBodyContent(out);
                            }
                            _jettag_c_if_179_6.doEnd();
                            _jettag_c_iterate_176_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_176_3.doEnd();
                        _jettag_c_iterate_174_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_174_2.doEnd();
                    _jettag_c_iterate_172_1.handleBodyContent(out);
                }
                _jettag_c_iterate_172_1.doEnd();
                out.write(NL);         
                // constructor 
                RuntimeTagElement _jettag_c_if_274_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_274_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_274_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_274_1.setTagInfo(_td_c_if_274_1);
                _jettag_c_if_274_1.doStart(context, out);
                while (_jettag_c_if_274_1.okToProcessBody()) {
                    RuntimeTagElement _jettag_f_message_275_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_275_1); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_275_1.setRuntimeParent(_jettag_c_if_274_1);
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
                    out.write("public ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$class/@name}", 276, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("() {");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("super();   ");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("}");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_if_274_1.handleBodyContent(out);
                }
                _jettag_c_if_274_1.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                out.write(NL);         
                // getters and setters 
                RuntimeTagElement _jettag_c_iterate_282_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_282_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_282_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_282_1.setTagInfo(_td_c_iterate_282_1);
                _jettag_c_iterate_282_1.doStart(context, out);
                while (_jettag_c_iterate_282_1.okToProcessBody()) {
                    //getters for basic attributes 
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_f_message_284_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_284_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_284_2.setRuntimeParent(_jettag_c_iterate_282_1);
                    _jettag_f_message_284_2.setTagInfo(_td_f_message_284_2);
                    _jettag_f_message_284_2.doStart(context, out);
                    JET2Writer _jettag_f_message_284_2_saved_out = out;
                    while (_jettag_f_message_284_2.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_284_2.handleBodyContent(out);
                    }
                    out = _jettag_f_message_284_2_saved_out;
                    _jettag_f_message_284_2.doEnd();
                    out.write(NL);         
                    out.write("\tpublic  ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_choose_285_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_285_10); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_285_10.setRuntimeParent(_jettag_c_iterate_282_1);
                    _jettag_c_choose_285_10.setTagInfo(_td_c_choose_285_10);
                    _jettag_c_choose_285_10.doStart(context, out);
                    JET2Writer _jettag_c_choose_285_10_saved_out = out;
                    while (_jettag_c_choose_285_10.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("  ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_285_81 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_285_81); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_285_81.setRuntimeParent(_jettag_c_choose_285_10);
                        _jettag_c_when_285_81.setTagInfo(_td_c_when_285_81);
                        _jettag_c_when_285_81.doStart(context, out);
                        JET2Writer _jettag_c_when_285_81_saved_out = out;
                        while (_jettag_c_when_285_81.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_285_81.handleBodyContent(out);
                        }
                        out = _jettag_c_when_285_81_saved_out;
                        _jettag_c_when_285_81.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_285_128 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_285_128); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_285_128.setRuntimeParent(_jettag_c_choose_285_10);
                        _jettag_c_when_285_128.setTagInfo(_td_c_when_285_128);
                        _jettag_c_when_285_128.doStart(context, out);
                        JET2Writer _jettag_c_when_285_128_saved_out = out;
                        while (_jettag_c_when_285_128.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Integer");  //$NON-NLS-1$        
                            _jettag_c_when_285_128.handleBodyContent(out);
                        }
                        out = _jettag_c_when_285_128_saved_out;
                        _jettag_c_when_285_128.doEnd();
                        RuntimeTagElement _jettag_c_when_285_176 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_285_176); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_285_176.setRuntimeParent(_jettag_c_choose_285_10);
                        _jettag_c_when_285_176.setTagInfo(_td_c_when_285_176);
                        _jettag_c_when_285_176.doStart(context, out);
                        JET2Writer _jettag_c_when_285_176_saved_out = out;
                        while (_jettag_c_when_285_176.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Date");  //$NON-NLS-1$        
                            _jettag_c_when_285_176.handleBodyContent(out);
                        }
                        out = _jettag_c_when_285_176_saved_out;
                        _jettag_c_when_285_176.doEnd();
                        RuntimeTagElement _jettag_c_when_285_218 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_285_218); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_285_218.setRuntimeParent(_jettag_c_choose_285_10);
                        _jettag_c_when_285_218.setTagInfo(_td_c_when_285_218);
                        _jettag_c_when_285_218.doStart(context, out);
                        JET2Writer _jettag_c_when_285_218_saved_out = out;
                        while (_jettag_c_when_285_218.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Boolean");  //$NON-NLS-1$        
                            _jettag_c_when_285_218.handleBodyContent(out);
                        }
                        out = _jettag_c_when_285_218_saved_out;
                        _jettag_c_when_285_218.doEnd();
                        RuntimeTagElement _jettag_c_when_285_266 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_285_266); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_285_266.setRuntimeParent(_jettag_c_choose_285_10);
                        _jettag_c_when_285_266.setTagInfo(_td_c_when_285_266);
                        _jettag_c_when_285_266.doStart(context, out);
                        JET2Writer _jettag_c_when_285_266_saved_out = out;
                        while (_jettag_c_when_285_266.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" Long ");  //$NON-NLS-1$        
                            _jettag_c_when_285_266.handleBodyContent(out);
                        }
                        out = _jettag_c_when_285_266_saved_out;
                        _jettag_c_when_285_266.doEnd();
                        RuntimeTagElement _jettag_c_when_285_310 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_285_310); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_285_310.setRuntimeParent(_jettag_c_choose_285_10);
                        _jettag_c_when_285_310.setTagInfo(_td_c_when_285_310);
                        _jettag_c_when_285_310.doStart(context, out);
                        JET2Writer _jettag_c_when_285_310_saved_out = out;
                        while (_jettag_c_when_285_310.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Float");  //$NON-NLS-1$        
                            _jettag_c_when_285_310.handleBodyContent(out);
                        }
                        out = _jettag_c_when_285_310_saved_out;
                        _jettag_c_when_285_310.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_285_355 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_285_355); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_285_355.setRuntimeParent(_jettag_c_choose_285_10);
                        _jettag_c_when_285_355.setTagInfo(_td_c_when_285_355);
                        _jettag_c_when_285_355.doStart(context, out);
                        JET2Writer _jettag_c_when_285_355_saved_out = out;
                        while (_jettag_c_when_285_355.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_285_355.handleBodyContent(out);
                        }
                        out = _jettag_c_when_285_355_saved_out;
                        _jettag_c_when_285_355.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_285_401 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_285_401); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_285_401.setRuntimeParent(_jettag_c_choose_285_10);
                        _jettag_c_when_285_401.setTagInfo(_td_c_when_285_401);
                        _jettag_c_when_285_401.doStart(context, out);
                        JET2Writer _jettag_c_when_285_401_saved_out = out;
                        while (_jettag_c_when_285_401.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_285_401.handleBodyContent(out);
                        }
                        out = _jettag_c_when_285_401_saved_out;
                        _jettag_c_when_285_401.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_285_450 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_285_450); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_285_450.setRuntimeParent(_jettag_c_choose_285_10);
                        _jettag_c_when_285_450.setTagInfo(_td_c_when_285_450);
                        _jettag_c_when_285_450.doStart(context, out);
                        JET2Writer _jettag_c_when_285_450_saved_out = out;
                        while (_jettag_c_when_285_450.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("BigDecimal");  //$NON-NLS-1$        
                            _jettag_c_when_285_450.handleBodyContent(out);
                        }
                        out = _jettag_c_when_285_450_saved_out;
                        _jettag_c_when_285_450.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_otherwise_285_503 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_285_503); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_285_503.setRuntimeParent(_jettag_c_choose_285_10);
                        _jettag_c_otherwise_285_503.setTagInfo(_td_c_otherwise_285_503);
                        _jettag_c_otherwise_285_503.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_285_503_saved_out = out;
                        while (_jettag_c_otherwise_285_503.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(NL);         
                            RuntimeTagElement _jettag_c_iterate_286_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_286_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_286_4.setRuntimeParent(_jettag_c_otherwise_285_503);
                            _jettag_c_iterate_286_4.setTagInfo(_td_c_iterate_286_4);
                            _jettag_c_iterate_286_4.doStart(context, out);
                            while (_jettag_c_iterate_286_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_287_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_287_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_287_6.setRuntimeParent(_jettag_c_iterate_286_4);
                                _jettag_c_if_287_6.setTagInfo(_td_c_if_287_6);
                                _jettag_c_if_287_6.doStart(context, out);
                                while (_jettag_c_if_287_6.okToProcessBody()) {
                                    out.write("\t \t\t\t ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$enumeration/@name}", 288, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(" ");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_287_6.handleBodyContent(out);
                                }
                                _jettag_c_if_287_6.doEnd();
                                _jettag_c_iterate_286_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_286_4.doEnd();
                            out.write("\t \t  ");  //$NON-NLS-1$        
                            _jettag_c_otherwise_285_503.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_285_503_saved_out;
                        _jettag_c_otherwise_285_503.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        _jettag_c_choose_285_10.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_285_10_saved_out;
                    _jettag_c_choose_285_10.doEnd();
                    out.write(" get");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 291, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("(){");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\treturn ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 292, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t}");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_f_message_294_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_294_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_f_message_294_2.setRuntimeParent(_jettag_c_iterate_282_1);
                    _jettag_f_message_294_2.setTagInfo(_td_f_message_294_2);
                    _jettag_f_message_294_2.doStart(context, out);
                    JET2Writer _jettag_f_message_294_2_saved_out = out;
                    while (_jettag_f_message_294_2.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("generated.comment");  //$NON-NLS-1$        
                        _jettag_f_message_294_2.handleBodyContent(out);
                    }
                    out = _jettag_f_message_294_2_saved_out;
                    _jettag_f_message_294_2.doEnd();
                    out.write(NL);         
                    out.write("\tpublic void set");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 295, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("(");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_choose_295_53 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_295_53); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_295_53.setRuntimeParent(_jettag_c_iterate_282_1);
                    _jettag_c_choose_295_53.setTagInfo(_td_c_choose_295_53);
                    _jettag_c_choose_295_53.doStart(context, out);
                    JET2Writer _jettag_c_choose_295_53_saved_out = out;
                    while (_jettag_c_choose_295_53.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_295_123 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_295_123); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_295_123.setRuntimeParent(_jettag_c_choose_295_53);
                        _jettag_c_when_295_123.setTagInfo(_td_c_when_295_123);
                        _jettag_c_when_295_123.doStart(context, out);
                        JET2Writer _jettag_c_when_295_123_saved_out = out;
                        while (_jettag_c_when_295_123.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_295_123.handleBodyContent(out);
                        }
                        out = _jettag_c_when_295_123_saved_out;
                        _jettag_c_when_295_123.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_295_170 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_295_170); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_295_170.setRuntimeParent(_jettag_c_choose_295_53);
                        _jettag_c_when_295_170.setTagInfo(_td_c_when_295_170);
                        _jettag_c_when_295_170.doStart(context, out);
                        JET2Writer _jettag_c_when_295_170_saved_out = out;
                        while (_jettag_c_when_295_170.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Integer");  //$NON-NLS-1$        
                            _jettag_c_when_295_170.handleBodyContent(out);
                        }
                        out = _jettag_c_when_295_170_saved_out;
                        _jettag_c_when_295_170.doEnd();
                        RuntimeTagElement _jettag_c_when_295_218 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_295_218); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_295_218.setRuntimeParent(_jettag_c_choose_295_53);
                        _jettag_c_when_295_218.setTagInfo(_td_c_when_295_218);
                        _jettag_c_when_295_218.doStart(context, out);
                        JET2Writer _jettag_c_when_295_218_saved_out = out;
                        while (_jettag_c_when_295_218.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Date");  //$NON-NLS-1$        
                            _jettag_c_when_295_218.handleBodyContent(out);
                        }
                        out = _jettag_c_when_295_218_saved_out;
                        _jettag_c_when_295_218.doEnd();
                        RuntimeTagElement _jettag_c_when_295_260 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_295_260); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_295_260.setRuntimeParent(_jettag_c_choose_295_53);
                        _jettag_c_when_295_260.setTagInfo(_td_c_when_295_260);
                        _jettag_c_when_295_260.doStart(context, out);
                        JET2Writer _jettag_c_when_295_260_saved_out = out;
                        while (_jettag_c_when_295_260.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Boolean");  //$NON-NLS-1$        
                            _jettag_c_when_295_260.handleBodyContent(out);
                        }
                        out = _jettag_c_when_295_260_saved_out;
                        _jettag_c_when_295_260.doEnd();
                        RuntimeTagElement _jettag_c_when_295_308 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_295_308); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_295_308.setRuntimeParent(_jettag_c_choose_295_53);
                        _jettag_c_when_295_308.setTagInfo(_td_c_when_295_308);
                        _jettag_c_when_295_308.doStart(context, out);
                        JET2Writer _jettag_c_when_295_308_saved_out = out;
                        while (_jettag_c_when_295_308.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" Long ");  //$NON-NLS-1$        
                            _jettag_c_when_295_308.handleBodyContent(out);
                        }
                        out = _jettag_c_when_295_308_saved_out;
                        _jettag_c_when_295_308.doEnd();
                        RuntimeTagElement _jettag_c_when_295_352 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_295_352); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_295_352.setRuntimeParent(_jettag_c_choose_295_53);
                        _jettag_c_when_295_352.setTagInfo(_td_c_when_295_352);
                        _jettag_c_when_295_352.doStart(context, out);
                        JET2Writer _jettag_c_when_295_352_saved_out = out;
                        while (_jettag_c_when_295_352.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("Float");  //$NON-NLS-1$        
                            _jettag_c_when_295_352.handleBodyContent(out);
                        }
                        out = _jettag_c_when_295_352_saved_out;
                        _jettag_c_when_295_352.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_295_397 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_295_397); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_295_397.setRuntimeParent(_jettag_c_choose_295_53);
                        _jettag_c_when_295_397.setTagInfo(_td_c_when_295_397);
                        _jettag_c_when_295_397.doStart(context, out);
                        JET2Writer _jettag_c_when_295_397_saved_out = out;
                        while (_jettag_c_when_295_397.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_295_397.handleBodyContent(out);
                        }
                        out = _jettag_c_when_295_397_saved_out;
                        _jettag_c_when_295_397.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_295_443 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_295_443); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_295_443.setRuntimeParent(_jettag_c_choose_295_53);
                        _jettag_c_when_295_443.setTagInfo(_td_c_when_295_443);
                        _jettag_c_when_295_443.doStart(context, out);
                        JET2Writer _jettag_c_when_295_443_saved_out = out;
                        while (_jettag_c_when_295_443.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("String");  //$NON-NLS-1$        
                            _jettag_c_when_295_443.handleBodyContent(out);
                        }
                        out = _jettag_c_when_295_443_saved_out;
                        _jettag_c_when_295_443.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_295_492 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_295_492); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_295_492.setRuntimeParent(_jettag_c_choose_295_53);
                        _jettag_c_when_295_492.setTagInfo(_td_c_when_295_492);
                        _jettag_c_when_295_492.doStart(context, out);
                        JET2Writer _jettag_c_when_295_492_saved_out = out;
                        while (_jettag_c_when_295_492.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("BigDecimal");  //$NON-NLS-1$        
                            _jettag_c_when_295_492.handleBodyContent(out);
                        }
                        out = _jettag_c_when_295_492_saved_out;
                        _jettag_c_when_295_492.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_otherwise_295_545 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_295_545); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_295_545.setRuntimeParent(_jettag_c_choose_295_53);
                        _jettag_c_otherwise_295_545.setTagInfo(_td_c_otherwise_295_545);
                        _jettag_c_otherwise_295_545.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_295_545_saved_out = out;
                        while (_jettag_c_otherwise_295_545.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(NL);         
                            RuntimeTagElement _jettag_c_iterate_296_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_296_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_296_4.setRuntimeParent(_jettag_c_otherwise_295_545);
                            _jettag_c_iterate_296_4.setTagInfo(_td_c_iterate_296_4);
                            _jettag_c_iterate_296_4.doStart(context, out);
                            while (_jettag_c_iterate_296_4.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_if_297_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_297_6); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_297_6.setRuntimeParent(_jettag_c_iterate_296_4);
                                _jettag_c_if_297_6.setTagInfo(_td_c_if_297_6);
                                _jettag_c_if_297_6.doStart(context, out);
                                while (_jettag_c_if_297_6.okToProcessBody()) {
                                    out.write("\t \t\t\t ");  //$NON-NLS-1$        
                                    out.write(context.embeddedExpressionAsString("${$enumeration/@name}", 298, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                                    out.write(" ");  //$NON-NLS-1$        
                                    out.write(NL);         
                                    _jettag_c_if_297_6.handleBodyContent(out);
                                }
                                _jettag_c_if_297_6.doEnd();
                                _jettag_c_iterate_296_4.handleBodyContent(out);
                            }
                            _jettag_c_iterate_296_4.doEnd();
                            out.write("\t \t  ");  //$NON-NLS-1$        
                            _jettag_c_otherwise_295_545.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_295_545_saved_out;
                        _jettag_c_otherwise_295_545.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        _jettag_c_choose_295_53.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_295_53_saved_out;
                    _jettag_c_choose_295_53.doEnd();
                    out.write(" ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_get_301_33 = context.getTagFactory().createRuntimeTag(_jetns_c, "get", "c:get", _td_c_get_301_33); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_get_301_33.setRuntimeParent(_jettag_c_iterate_282_1);
                    _jettag_c_get_301_33.setTagInfo(_td_c_get_301_33);
                    _jettag_c_get_301_33.doStart(context, out);
                    _jettag_c_get_301_33.doEnd();
                    out.write("){");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\tthis.");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 302, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("=");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 302, 27)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(";");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t}");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_iterate_282_1.handleBodyContent(out);
                }
                _jettag_c_iterate_282_1.doEnd();
                // colletions getters and setters-->
                //<%--getters for collection attributes 
                RuntimeTagElement _jettag_c_iterate_308_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_308_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_308_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_308_2.setTagInfo(_td_c_iterate_308_2);
                _jettag_c_iterate_308_2.doStart(context, out);
                while (_jettag_c_iterate_308_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_309_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_309_2); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_309_2.setRuntimeParent(_jettag_c_iterate_308_2);
                    _jettag_c_iterate_309_2.setTagInfo(_td_c_iterate_309_2);
                    _jettag_c_iterate_309_2.doStart(context, out);
                    while (_jettag_c_iterate_309_2.okToProcessBody()) {
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        RuntimeTagElement _jettag_c_iterate_311_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_311_3); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_311_3.setRuntimeParent(_jettag_c_iterate_309_2);
                        _jettag_c_iterate_311_3.setTagInfo(_td_c_iterate_311_3);
                        _jettag_c_iterate_311_3.doStart(context, out);
                        while (_jettag_c_iterate_311_3.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_312_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_312_4); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_312_4.setRuntimeParent(_jettag_c_iterate_311_3);
                            _jettag_c_setVariable_312_4.setTagInfo(_td_c_setVariable_312_4);
                            _jettag_c_setVariable_312_4.doStart(context, out);
                            _jettag_c_setVariable_312_4.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_314_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_314_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_314_6.setRuntimeParent(_jettag_c_iterate_311_3);
                            _jettag_c_if_314_6.setTagInfo(_td_c_if_314_6);
                            _jettag_c_if_314_6.doStart(context, out);
                            while (_jettag_c_if_314_6.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_316_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_316_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_316_12.setRuntimeParent(_jettag_c_if_314_6);
                                _jettag_c_iterate_316_12.setTagInfo(_td_c_iterate_316_12);
                                _jettag_c_iterate_316_12.doStart(context, out);
                                while (_jettag_c_iterate_316_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_317_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_317_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_317_12.setRuntimeParent(_jettag_c_iterate_316_12);
                                    _jettag_c_setVariable_317_12.setTagInfo(_td_c_setVariable_317_12);
                                    _jettag_c_setVariable_317_12.doStart(context, out);
                                    _jettag_c_setVariable_317_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_319_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_319_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_319_14.setRuntimeParent(_jettag_c_iterate_316_12);
                                    _jettag_c_if_319_14.setTagInfo(_td_c_if_319_14);
                                    _jettag_c_if_319_14.doStart(context, out);
                                    while (_jettag_c_if_319_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_321_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_321_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_321_15.setRuntimeParent(_jettag_c_if_319_14);
                                        _jettag_c_iterate_321_15.setTagInfo(_td_c_iterate_321_15);
                                        _jettag_c_iterate_321_15.doStart(context, out);
                                        while (_jettag_c_iterate_321_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_322_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_322_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_322_16.setRuntimeParent(_jettag_c_iterate_321_15);
                                            _jettag_c_if_322_16.setTagInfo(_td_c_if_322_16);
                                            _jettag_c_if_322_16.doStart(context, out);
                                            while (_jettag_c_if_322_16.okToProcessBody()) {
                                                out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                // check to see the association is navigable in the first case
                                                RuntimeTagElement _jettag_c_if_325_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_325_13); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_325_13.setRuntimeParent(_jettag_c_if_322_16);
                                                _jettag_c_if_325_13.setTagInfo(_td_c_if_325_13);
                                                _jettag_c_if_325_13.doStart(context, out);
                                                while (_jettag_c_if_325_13.okToProcessBody()) {
                                                    // This processes the JPA realations @OneToMany, @ManyToMany, @OneToOne etc
                                                    // check if target is one side
                                                    RuntimeTagElement _jettag_c_if_328_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_328_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_328_16.setRuntimeParent(_jettag_c_if_325_13);
                                                    _jettag_c_if_328_16.setTagInfo(_td_c_if_328_16);
                                                    _jettag_c_if_328_16.doStart(context, out);
                                                    while (_jettag_c_if_328_16.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_329_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_329_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_329_18.setRuntimeParent(_jettag_c_if_328_16);
                                                        _jettag_c_if_329_18.setTagInfo(_td_c_if_329_18);
                                                        _jettag_c_if_329_18.doStart(context, out);
                                                        while (_jettag_c_if_329_18.okToProcessBody()) {
                                                            // gettter returning a non collection
                                                            out.write(" ");  //$NON-NLS-1$        
                                                            RuntimeTagElement _jettag_f_message_331_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_331_2); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_331_2.setRuntimeParent(_jettag_c_if_329_18);
                                                            _jettag_f_message_331_2.setTagInfo(_td_f_message_331_2);
                                                            _jettag_f_message_331_2.doStart(context, out);
                                                            JET2Writer _jettag_f_message_331_2_saved_out = out;
                                                            while (_jettag_f_message_331_2.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_331_2.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_331_2_saved_out;
                                                            _jettag_f_message_331_2.doEnd();
                                                            out.write("\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            RuntimeTagElement _jettag_c_if_332_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_332_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_332_1.setRuntimeParent(_jettag_c_if_329_18);
                                                            _jettag_c_if_332_1.setTagInfo(_td_c_if_332_1);
                                                            _jettag_c_if_332_1.doStart(context, out);
                                                            while (_jettag_c_if_332_1.okToProcessBody()) {
                                                                out.write("@XmlElement ");  //$NON-NLS-1$        
                                                                out.write(NL);         
                                                                _jettag_c_if_332_1.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_332_1.doEnd();
                                                            out.write(" public \t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 335, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(" get");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 335, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("() {");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write(" return  this.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 336, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write(" }");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            // setter returning a non clooection
                                                            RuntimeTagElement _jettag_f_message_339_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_339_1); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_f_message_339_1.setRuntimeParent(_jettag_c_if_329_18);
                                                            _jettag_f_message_339_1.setTagInfo(_td_f_message_339_1);
                                                            _jettag_f_message_339_1.doStart(context, out);
                                                            JET2Writer _jettag_f_message_339_1_saved_out = out;
                                                            while (_jettag_f_message_339_1.okToProcessBody()) {
                                                                out = out.newNestedContentWriter();
                                                                out.write("generated.comment");  //$NON-NLS-1$        
                                                                _jettag_f_message_339_1.handleBodyContent(out);
                                                            }
                                                            out = _jettag_f_message_339_1_saved_out;
                                                            _jettag_f_message_339_1.doEnd();
                                                            out.write(NL);         
                                                            out.write("  public \tvoid set");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 340, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("(");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 340, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(" ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 340, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(") {");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("   this.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 341, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("=");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 341, 42)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(";");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write(" }");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write(" ");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_329_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_329_18.doEnd();
                                                        _jettag_c_if_328_16.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_328_16.doEnd();
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    // check if target is many side
                                                    RuntimeTagElement _jettag_c_if_348_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_348_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_348_17.setRuntimeParent(_jettag_c_if_325_13);
                                                    _jettag_c_if_348_17.setTagInfo(_td_c_if_348_17);
                                                    _jettag_c_if_348_17.doStart(context, out);
                                                    while (_jettag_c_if_348_17.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_349_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_349_18); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_349_18.setRuntimeParent(_jettag_c_if_348_17);
                                                        _jettag_c_if_349_18.setTagInfo(_td_c_if_349_18);
                                                        _jettag_c_if_349_18.doStart(context, out);
                                                        while (_jettag_c_if_349_18.okToProcessBody()) {
                                                            out.write("   \t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            // check if source is many side
                                                            // this is a many to many
                                                            RuntimeTagElement _jettag_c_if_353_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_353_13); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_353_13.setRuntimeParent(_jettag_c_if_349_18);
                                                            _jettag_c_if_353_13.setTagInfo(_td_c_if_353_13);
                                                            _jettag_c_if_353_13.doStart(context, out);
                                                            while (_jettag_c_if_353_13.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_c_if_354_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_354_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_354_19.setRuntimeParent(_jettag_c_if_353_13);
                                                                _jettag_c_if_354_19.setTagInfo(_td_c_if_354_19);
                                                                _jettag_c_if_354_19.doStart(context, out);
                                                                while (_jettag_c_if_354_19.okToProcessBody()) {
                                                                    // gettter returning a collection
                                                                    out.write("\t  \t\t\t\t\t    \t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_356_19 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_356_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_356_19.setRuntimeParent(_jettag_c_if_354_19);
                                                                    _jettag_f_message_356_19.setTagInfo(_td_f_message_356_19);
                                                                    _jettag_f_message_356_19.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_356_19_saved_out = out;
                                                                    while (_jettag_f_message_356_19.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_356_19.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_356_19_saved_out;
                                                                    _jettag_f_message_356_19.doEnd();
                                                                    out.write("\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    RuntimeTagElement _jettag_c_if_357_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_357_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_c_if_357_20.setRuntimeParent(_jettag_c_if_354_19);
                                                                    _jettag_c_if_357_20.setTagInfo(_td_c_if_357_20);
                                                                    _jettag_c_if_357_20.doStart(context, out);
                                                                    while (_jettag_c_if_357_20.okToProcessBody()) {
                                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t@XmlTransient ");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        _jettag_c_if_357_20.handleBodyContent(out);
                                                                    }
                                                                    _jettag_c_if_357_20.doEnd();
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t public \tSet<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 360, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">  get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 360, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t if(this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 361, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s==null){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t ");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t //TODO actual");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t //this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 364, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s=new HashSet<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 364, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t return new HashSet<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 365, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t return this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 367, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    // setter returning a collection
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_370_15 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_370_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_370_15.setRuntimeParent(_jettag_c_if_354_19);
                                                                    _jettag_f_message_370_15.setTagInfo(_td_f_message_370_15);
                                                                    _jettag_f_message_370_15.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_370_15_saved_out = out;
                                                                    while (_jettag_f_message_370_15.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_370_15.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_370_15_saved_out;
                                                                    _jettag_f_message_370_15.doEnd();
                                                                    out.write("\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t public \t  void set");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 371, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(Set<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 371, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("> ");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 371, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 372, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s=");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 372, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t }\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    // addEntity methods
                                                                    out.write("\t \t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_375_16 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_375_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_375_16.setRuntimeParent(_jettag_c_if_354_19);
                                                                    _jettag_f_message_375_16.setTagInfo(_td_f_message_375_16);
                                                                    _jettag_f_message_375_16.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_375_16_saved_out = out;
                                                                    while (_jettag_f_message_375_16.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_375_16.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_375_16_saved_out;
                                                                    _jettag_f_message_375_16.doEnd();
                                                                    out.write(NL);         
                                                                    out.write("\t  \t\t\t\t\t    \t\t\t\t\t\t public \t  void add");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 376, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("(");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 376, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(" entity){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  if(entity== null){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  return;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 380, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s().add(entity);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_354_19.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_354_19.doEnd();
                                                                _jettag_c_if_353_13.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_353_13.doEnd();
                                                            // check if source is one side
                                                            // this is a one to many
                                                            RuntimeTagElement _jettag_c_if_386_17 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_386_17); //$NON-NLS-1$ //$NON-NLS-2$
                                                            _jettag_c_if_386_17.setRuntimeParent(_jettag_c_if_349_18);
                                                            _jettag_c_if_386_17.setTagInfo(_td_c_if_386_17);
                                                            _jettag_c_if_386_17.doStart(context, out);
                                                            while (_jettag_c_if_386_17.okToProcessBody()) {
                                                                RuntimeTagElement _jettag_c_if_387_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_387_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                                _jettag_c_if_387_19.setRuntimeParent(_jettag_c_if_386_17);
                                                                _jettag_c_if_387_19.setTagInfo(_td_c_if_387_19);
                                                                _jettag_c_if_387_19.doStart(context, out);
                                                                while (_jettag_c_if_387_19.okToProcessBody()) {
                                                                    // gettter returning a collection
                                                                    out.write("\t  \t\t\t\t\t    \t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_389_20 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_389_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_389_20.setRuntimeParent(_jettag_c_if_387_19);
                                                                    _jettag_f_message_389_20.setTagInfo(_td_f_message_389_20);
                                                                    _jettag_f_message_389_20.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_389_20_saved_out = out;
                                                                    while (_jettag_f_message_389_20.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_389_20.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_389_20_saved_out;
                                                                    _jettag_f_message_389_20.doEnd();
                                                                    out.write("\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    RuntimeTagElement _jettag_c_if_390_20 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_390_20); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_c_if_390_20.setRuntimeParent(_jettag_c_if_387_19);
                                                                    _jettag_c_if_390_20.setTagInfo(_td_c_if_390_20);
                                                                    _jettag_c_if_390_20.doStart(context, out);
                                                                    while (_jettag_c_if_390_20.okToProcessBody()) {
                                                                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t@XmlTransient ");  //$NON-NLS-1$        
                                                                        out.write(NL);         
                                                                        _jettag_c_if_390_20.handleBodyContent(out);
                                                                    }
                                                                    _jettag_c_if_390_20.doEnd();
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t public \tList<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 393, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">  get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 393, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t if(this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 394, 24)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s==null){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  //TODO actual");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t //this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 396, 23)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s=new ArrayList<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 396, 71)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t return new ArrayList<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 397, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(">();");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t return this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 399, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    // setter returning a collection
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_402_15 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_402_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_402_15.setRuntimeParent(_jettag_c_if_387_19);
                                                                    _jettag_f_message_402_15.setTagInfo(_td_f_message_402_15);
                                                                    _jettag_f_message_402_15.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_402_15_saved_out = out;
                                                                    while (_jettag_f_message_402_15.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_402_15.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_402_15_saved_out;
                                                                    _jettag_f_message_402_15.doEnd();
                                                                    out.write("\t");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t public \t  void set");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 403, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s(List<");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 403, 57)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("> ");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 403, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t this.");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 404, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s=");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 404, 55)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    // addEntity methods
                                                                    out.write("\t  \t\t\t\t\t    \t\t\t\t\t\t \t");  //$NON-NLS-1$        
                                                                    RuntimeTagElement _jettag_f_message_407_21 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_407_21); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    _jettag_f_message_407_21.setRuntimeParent(_jettag_c_if_387_19);
                                                                    _jettag_f_message_407_21.setTagInfo(_td_f_message_407_21);
                                                                    _jettag_f_message_407_21.doStart(context, out);
                                                                    JET2Writer _jettag_f_message_407_21_saved_out = out;
                                                                    while (_jettag_f_message_407_21.okToProcessBody()) {
                                                                        out = out.newNestedContentWriter();
                                                                        out.write("generated.comment");  //$NON-NLS-1$        
                                                                        _jettag_f_message_407_21.handleBodyContent(out);
                                                                    }
                                                                    out = _jettag_f_message_407_21_saved_out;
                                                                    _jettag_f_message_407_21.doEnd();
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  public \t  void add");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 408, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("(");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 408, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write(" entity){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t   if(entity== null){");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  return;");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t  }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t get");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class2/@name}", 412, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("s().add(entity);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t entity.set");  //$NON-NLS-1$        
                                                                    out.write(context.embeddedExpressionAsString("${$class/@name}", 413, 26)); //$NON-NLS-1$ //$NON-NLS-2$
                                                                    out.write("(this);");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t }");  //$NON-NLS-1$        
                                                                    out.write(NL);         
                                                                    _jettag_c_if_387_19.handleBodyContent(out);
                                                                }
                                                                _jettag_c_if_387_19.doEnd();
                                                                _jettag_c_if_386_17.handleBodyContent(out);
                                                            }
                                                            _jettag_c_if_386_17.doEnd();
                                                            out.write("  \t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_349_18.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_349_18.doEnd();
                                                        _jettag_c_if_348_17.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_348_17.doEnd();
                                                    out.write("  \t\t\t\t\t  \t\t \t\t\t");  //$NON-NLS-1$        
                                                    out.write(NL);         
                                                    _jettag_c_if_325_13.handleBodyContent(out);
                                                }
                                                _jettag_c_if_325_13.doEnd();
                                                _jettag_c_if_322_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_322_16.doEnd();
                                            _jettag_c_iterate_321_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_321_15.doEnd();
                                        _jettag_c_if_319_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_319_14.doEnd();
                                    _jettag_c_iterate_316_12.handleBodyContent(out);
                                }
                                _jettag_c_iterate_316_12.doEnd();
                                _jettag_c_if_314_6.handleBodyContent(out);
                            }
                            _jettag_c_if_314_6.doEnd();
                            _jettag_c_iterate_311_3.handleBodyContent(out);
                        }
                        _jettag_c_iterate_311_3.doEnd();
                        _jettag_c_iterate_309_2.handleBodyContent(out);
                    }
                    _jettag_c_iterate_309_2.doEnd();
                    out.write(NL);         
                    _jettag_c_iterate_308_2.handleBodyContent(out);
                }
                _jettag_c_iterate_308_2.doEnd();
                out.write("\t");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_f_message_431_2 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_431_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_431_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_431_2.setTagInfo(_td_f_message_431_2);
                _jettag_f_message_431_2.doStart(context, out);
                JET2Writer _jettag_f_message_431_2_saved_out = out;
                while (_jettag_f_message_431_2.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_431_2.handleBodyContent(out);
                }
                out = _jettag_f_message_431_2_saved_out;
                _jettag_f_message_431_2.doEnd();
                out.write(NL);         
                out.write("\tpublic String toString(){");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tStringBuilder sb= new StringBuilder();");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_c_iterate_434_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_434_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_434_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_434_1.setTagInfo(_td_c_iterate_434_1);
                _jettag_c_iterate_434_1.doStart(context, out);
                while (_jettag_c_iterate_434_1.okToProcessBody()) {
                    out.write("\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_choose_435_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_435_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_435_3.setRuntimeParent(_jettag_c_iterate_434_1);
                    _jettag_c_choose_435_3.setTagInfo(_td_c_choose_435_3);
                    _jettag_c_choose_435_3.doStart(context, out);
                    JET2Writer _jettag_c_choose_435_3_saved_out = out;
                    while (_jettag_c_choose_435_3.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_435_73 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_435_73); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_435_73.setRuntimeParent(_jettag_c_choose_435_3);
                        _jettag_c_when_435_73.setTagInfo(_td_c_when_435_73);
                        _jettag_c_when_435_73.doStart(context, out);
                        JET2Writer _jettag_c_when_435_73_saved_out = out;
                        while (_jettag_c_when_435_73.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" sb.append(get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 435, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("());  sb.append(\":\");");  //$NON-NLS-1$        
                            _jettag_c_when_435_73.handleBodyContent(out);
                        }
                        out = _jettag_c_when_435_73_saved_out;
                        _jettag_c_when_435_73.doEnd();
                        out.write(" ");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_choose_435_3.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_435_3_saved_out;
                    _jettag_c_choose_435_3.doEnd();
                    _jettag_c_iterate_434_1.handleBodyContent(out);
                }
                _jettag_c_iterate_434_1.doEnd();
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
