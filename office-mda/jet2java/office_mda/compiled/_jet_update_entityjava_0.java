package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_update_entityjava_0 implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_update_entityjava_0() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_format_1_1 = new TagInfo("java:format", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_24_2 = new TagInfo("c:if", //$NON-NLS-1$
            24, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_25_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            25, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
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
    private static final TagInfo _td_c_when_27_6 = new TagInfo("c:when", //$NON-NLS-1$
            27, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_29_6 = new TagInfo("c:when", //$NON-NLS-1$
            29, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_31_6 = new TagInfo("c:when", //$NON-NLS-1$
            31, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_unique_34_67 = new TagInfo("f:unique", //$NON-NLS-1$
            34, 67,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_when_45_6 = new TagInfo("c:when", //$NON-NLS-1$
            45, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_47_6 = new TagInfo("c:when", //$NON-NLS-1$
            47, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_49_6 = new TagInfo("c:when", //$NON-NLS-1$
            49, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_55_2 = new TagInfo("c:if", //$NON-NLS-1$
            55, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_56_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            56, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_57_9 = new TagInfo("c:choose", //$NON-NLS-1$
            57, 9,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_58_6 = new TagInfo("c:when", //$NON-NLS-1$
            58, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_60_6 = new TagInfo("c:when", //$NON-NLS-1$
            60, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_62_6 = new TagInfo("c:when", //$NON-NLS-1$
            62, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_unique_65_68 = new TagInfo("f:unique", //$NON-NLS-1$
            65, 68,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_when_76_6 = new TagInfo("c:when", //$NON-NLS-1$
            76, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_78_6 = new TagInfo("c:when", //$NON-NLS-1$
            78, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_80_6 = new TagInfo("c:when", //$NON-NLS-1$
            80, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_86_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            86, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_87_8 = new TagInfo("c:choose", //$NON-NLS-1$
            87, 8,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_88_6 = new TagInfo("c:when", //$NON-NLS-1$
            88, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_90_6 = new TagInfo("c:when", //$NON-NLS-1$
            90, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_92_6 = new TagInfo("c:when", //$NON-NLS-1$
            92, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_unique_95_68 = new TagInfo("f:unique", //$NON-NLS-1$
            95, 68,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_when_106_6 = new TagInfo("c:when", //$NON-NLS-1$
            106, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_108_6 = new TagInfo("c:when", //$NON-NLS-1$
            108, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_110_6 = new TagInfo("c:when", //$NON-NLS-1$
            110, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_141_2 = new TagInfo("c:if", //$NON-NLS-1$
            141, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_142_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            142, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_143_5 = new TagInfo("c:choose", //$NON-NLS-1$
            143, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_144_6 = new TagInfo("c:when", //$NON-NLS-1$
            144, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_147_6 = new TagInfo("c:when", //$NON-NLS-1$
            147, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_150_6 = new TagInfo("c:when", //$NON-NLS-1$
            150, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_153_6 = new TagInfo("c:when", //$NON-NLS-1$
            153, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_155_6 = new TagInfo("c:when", //$NON-NLS-1$
            155, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_158_6 = new TagInfo("c:when", //$NON-NLS-1$
            158, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_165_2 = new TagInfo("c:if", //$NON-NLS-1$
            165, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_166_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            166, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_167_5 = new TagInfo("c:choose", //$NON-NLS-1$
            167, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_168_6 = new TagInfo("c:when", //$NON-NLS-1$
            168, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_171_6 = new TagInfo("c:when", //$NON-NLS-1$
            171, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_174_6 = new TagInfo("c:when", //$NON-NLS-1$
            174, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_177_6 = new TagInfo("c:when", //$NON-NLS-1$
            177, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_179_6 = new TagInfo("c:when", //$NON-NLS-1$
            179, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_182_6 = new TagInfo("c:when", //$NON-NLS-1$
            182, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_189_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            189, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
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
    private static final TagInfo _td_c_when_194_6 = new TagInfo("c:when", //$NON-NLS-1$
            194, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_197_6 = new TagInfo("c:when", //$NON-NLS-1$
            197, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_200_6 = new TagInfo("c:when", //$NON-NLS-1$
            200, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_202_6 = new TagInfo("c:when", //$NON-NLS-1$
            202, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_205_6 = new TagInfo("c:when", //$NON-NLS-1$
            205, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_214_2 = new TagInfo("c:if", //$NON-NLS-1$
            214, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_215_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            215, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_216_5 = new TagInfo("c:choose", //$NON-NLS-1$
            216, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_217_6 = new TagInfo("c:when", //$NON-NLS-1$
            217, 6,
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
    private static final TagInfo _td_c_when_225_6 = new TagInfo("c:when", //$NON-NLS-1$
            225, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_227_6 = new TagInfo("c:when", //$NON-NLS-1$
            227, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_229_6 = new TagInfo("c:when", //$NON-NLS-1$
            229, 6,
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
    private static final TagInfo _td_c_if_241_2 = new TagInfo("c:if", //$NON-NLS-1$
            241, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_242_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            242, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_243_5 = new TagInfo("c:choose", //$NON-NLS-1$
            243, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_244_6 = new TagInfo("c:when", //$NON-NLS-1$
            244, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_248_6 = new TagInfo("c:when", //$NON-NLS-1$
            248, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_252_6 = new TagInfo("c:when", //$NON-NLS-1$
            252, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_254_6 = new TagInfo("c:when", //$NON-NLS-1$
            254, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_256_6 = new TagInfo("c:when", //$NON-NLS-1$
            256, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_260_6 = new TagInfo("c:when", //$NON-NLS-1$
            260, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_268_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            268, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_269_5 = new TagInfo("c:choose", //$NON-NLS-1$
            269, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_270_6 = new TagInfo("c:when", //$NON-NLS-1$
            270, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_274_6 = new TagInfo("c:when", //$NON-NLS-1$
            274, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_278_6 = new TagInfo("c:when", //$NON-NLS-1$
            278, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_280_6 = new TagInfo("c:when", //$NON-NLS-1$
            280, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_282_6 = new TagInfo("c:when", //$NON-NLS-1$
            282, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_286_6 = new TagInfo("c:when", //$NON-NLS-1$
            286, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_java_format_1_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "format", "java:format", _td_java_format_1_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_format_1_1.setRuntimeParent(null);
        _jettag_java_format_1_1.setTagInfo(_td_java_format_1_1);
        _jettag_java_format_1_1.doStart(context, out);
        JET2Writer _jettag_java_format_1_1_saved_out = out;
        while (_jettag_java_format_1_1.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(NL);         
            out.write("package ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 2, 9)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$package/@name}", 2, 29)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 2, 47)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 3, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 3, 28)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Main;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 4, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.R;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 5, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".entity.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 5, 27)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 5, 57)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.app.Activity;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.os.Bundle;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.util.Log;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View.OnClickListener;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.Window;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.Button;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.TextView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.views.EditTextField;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.Date;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.DatePicker;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.app.DatePickerDialog;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("public class Update");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 19, 20)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" extends Activity implements OnClickListener {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 20, 12)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 20, 28)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected Button update;");  //$NON-NLS-1$        
            out.write(NL);         
            // fields
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_24_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_24_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_24_2.setRuntimeParent(_jettag_java_format_1_1);
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
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_27_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_27_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_27_6.setRuntimeParent(_jettag_c_choose_26_5);
                        _jettag_c_when_27_6.setTagInfo(_td_c_when_27_6);
                        _jettag_c_when_27_6.doStart(context, out);
                        JET2Writer _jettag_c_when_27_6_saved_out = out;
                        while (_jettag_c_when_27_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 27, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_27_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_27_6_saved_out;
                        _jettag_c_when_27_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_29_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_29_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_29_6.setRuntimeParent(_jettag_c_choose_26_5);
                        _jettag_c_when_29_6.setTagInfo(_td_c_when_29_6);
                        _jettag_c_when_29_6.doStart(context, out);
                        JET2Writer _jettag_c_when_29_6_saved_out = out;
                        while (_jettag_c_when_29_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 29, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("YF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_29_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_29_6_saved_out;
                        _jettag_c_when_29_6.doEnd();
                        RuntimeTagElement _jettag_c_when_31_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_31_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_31_6.setRuntimeParent(_jettag_c_choose_26_5);
                        _jettag_c_when_31_6.setTagInfo(_td_c_when_31_6);
                        _jettag_c_when_31_6.doStart(context, out);
                        JET2Writer _jettag_c_when_31_6_saved_out = out;
                        while (_jettag_c_when_31_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\tDate ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 32, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("= new Date();");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t \tButton ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 33, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B;");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\tstatic final int ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 34, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_ID = ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_f_unique_34_67 = context.getTagFactory().createRuntimeTag(_jetns_f, "unique", "f:unique", _td_f_unique_34_67); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_f_unique_34_67.setRuntimeParent(_jettag_c_when_31_6);
                            _jettag_f_unique_34_67.setTagInfo(_td_f_unique_34_67);
                            _jettag_f_unique_34_67.doStart(context, out);
                            _jettag_f_unique_34_67.doEnd();
                            out.write(";");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\tprivate DatePickerDialog.OnDateSetListener ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 35, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("DateSetListener = new DatePickerDialog.OnDateSetListener() {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onDateSet(DatePicker view, int year, int monthOfYear,");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tint dayOfMonth) {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 39, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".setDate(dayOfMonth);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 40, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".setMonth(monthOfYear + 1);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 41, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".setYear(year);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t};");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_31_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_31_6_saved_out;
                        _jettag_c_when_31_6.doEnd();
                        RuntimeTagElement _jettag_c_when_45_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_45_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_45_6.setRuntimeParent(_jettag_c_choose_26_5);
                        _jettag_c_when_45_6.setTagInfo(_td_c_when_45_6);
                        _jettag_c_when_45_6.doStart(context, out);
                        JET2Writer _jettag_c_when_45_6_saved_out = out;
                        while (_jettag_c_when_45_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_45_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_45_6_saved_out;
                        _jettag_c_when_45_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_47_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_47_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_47_6.setRuntimeParent(_jettag_c_choose_26_5);
                        _jettag_c_when_47_6.setTagInfo(_td_c_when_47_6);
                        _jettag_c_when_47_6.doStart(context, out);
                        JET2Writer _jettag_c_when_47_6_saved_out = out;
                        while (_jettag_c_when_47_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 47, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_47_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_47_6_saved_out;
                        _jettag_c_when_47_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_49_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_49_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_49_6.setRuntimeParent(_jettag_c_choose_26_5);
                        _jettag_c_when_49_6.setTagInfo(_td_c_when_49_6);
                        _jettag_c_when_49_6.doStart(context, out);
                        JET2Writer _jettag_c_when_49_6_saved_out = out;
                        while (_jettag_c_when_49_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 49, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_49_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_49_6_saved_out;
                        _jettag_c_when_49_6.doEnd();
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
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_55_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_55_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_55_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_55_2.setTagInfo(_td_c_if_55_2);
            _jettag_c_if_55_2.doStart(context, out);
            while (_jettag_c_if_55_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_56_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_56_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_56_5.setRuntimeParent(_jettag_c_if_55_2);
                _jettag_c_iterate_56_5.setTagInfo(_td_c_iterate_56_5);
                _jettag_c_iterate_56_5.doStart(context, out);
                while (_jettag_c_iterate_56_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_57_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_57_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_57_9.setRuntimeParent(_jettag_c_iterate_56_5);
                    _jettag_c_choose_57_9.setTagInfo(_td_c_choose_57_9);
                    _jettag_c_choose_57_9.doStart(context, out);
                    JET2Writer _jettag_c_choose_57_9_saved_out = out;
                    while (_jettag_c_choose_57_9.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_58_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_58_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_58_6.setRuntimeParent(_jettag_c_choose_57_9);
                        _jettag_c_when_58_6.setTagInfo(_td_c_when_58_6);
                        _jettag_c_when_58_6.doStart(context, out);
                        JET2Writer _jettag_c_when_58_6_saved_out = out;
                        while (_jettag_c_when_58_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 58, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_58_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_58_6_saved_out;
                        _jettag_c_when_58_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_60_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_60_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_60_6.setRuntimeParent(_jettag_c_choose_57_9);
                        _jettag_c_when_60_6.setTagInfo(_td_c_when_60_6);
                        _jettag_c_when_60_6.doStart(context, out);
                        JET2Writer _jettag_c_when_60_6_saved_out = out;
                        while (_jettag_c_when_60_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 60, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_60_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_60_6_saved_out;
                        _jettag_c_when_60_6.doEnd();
                        RuntimeTagElement _jettag_c_when_62_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_62_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_62_6.setRuntimeParent(_jettag_c_choose_57_9);
                        _jettag_c_when_62_6.setTagInfo(_td_c_when_62_6);
                        _jettag_c_when_62_6.doStart(context, out);
                        JET2Writer _jettag_c_when_62_6_saved_out = out;
                        while (_jettag_c_when_62_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\tDate ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 63, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("= new Date();\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t  \tButton ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 64, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B;");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\tstatic final int ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 65, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_ID =  ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_f_unique_65_68 = context.getTagFactory().createRuntimeTag(_jetns_f, "unique", "f:unique", _td_f_unique_65_68); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_f_unique_65_68.setRuntimeParent(_jettag_c_when_62_6);
                            _jettag_f_unique_65_68.setTagInfo(_td_f_unique_65_68);
                            _jettag_f_unique_65_68.doStart(context, out);
                            _jettag_f_unique_65_68.doEnd();
                            out.write(";");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\tprivate DatePickerDialog.OnDateSetListener ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 66, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("DateSetListener = new DatePickerDialog.OnDateSetListener() {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onDateSet(DatePicker view, int year, int monthOfYear,");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tint dayOfMonth) {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 70, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".setDate(dayOfMonth);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 71, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".setMonth(monthOfYear + 1);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 72, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".setYear(year);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t};");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_62_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_62_6_saved_out;
                        _jettag_c_when_62_6.doEnd();
                        RuntimeTagElement _jettag_c_when_76_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_76_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_76_6.setRuntimeParent(_jettag_c_choose_57_9);
                        _jettag_c_when_76_6.setTagInfo(_td_c_when_76_6);
                        _jettag_c_when_76_6.doStart(context, out);
                        JET2Writer _jettag_c_when_76_6_saved_out = out;
                        while (_jettag_c_when_76_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_76_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_76_6_saved_out;
                        _jettag_c_when_76_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_78_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_78_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_78_6.setRuntimeParent(_jettag_c_choose_57_9);
                        _jettag_c_when_78_6.setTagInfo(_td_c_when_78_6);
                        _jettag_c_when_78_6.doStart(context, out);
                        JET2Writer _jettag_c_when_78_6_saved_out = out;
                        while (_jettag_c_when_78_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 78, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_78_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_78_6_saved_out;
                        _jettag_c_when_78_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_80_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_80_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_80_6.setRuntimeParent(_jettag_c_choose_57_9);
                        _jettag_c_when_80_6.setTagInfo(_td_c_when_80_6);
                        _jettag_c_when_80_6.doStart(context, out);
                        JET2Writer _jettag_c_when_80_6_saved_out = out;
                        while (_jettag_c_when_80_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 80, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_80_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_80_6_saved_out;
                        _jettag_c_when_80_6.doEnd();
                        _jettag_c_choose_57_9.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_57_9_saved_out;
                    _jettag_c_choose_57_9.doEnd();
                    _jettag_c_iterate_56_5.handleBodyContent(out);
                }
                _jettag_c_iterate_56_5.doEnd();
                _jettag_c_if_55_2.handleBodyContent(out);
            }
            _jettag_c_if_55_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_86_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_86_4); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_86_4.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_86_4.setTagInfo(_td_c_iterate_86_4);
            _jettag_c_iterate_86_4.doStart(context, out);
            while (_jettag_c_iterate_86_4.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_87_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_87_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_87_8.setRuntimeParent(_jettag_c_iterate_86_4);
                _jettag_c_choose_87_8.setTagInfo(_td_c_choose_87_8);
                _jettag_c_choose_87_8.doStart(context, out);
                JET2Writer _jettag_c_choose_87_8_saved_out = out;
                while (_jettag_c_choose_87_8.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_88_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_88_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_88_6.setRuntimeParent(_jettag_c_choose_87_8);
                    _jettag_c_when_88_6.setTagInfo(_td_c_when_88_6);
                    _jettag_c_when_88_6.doStart(context, out);
                    JET2Writer _jettag_c_when_88_6_saved_out = out;
                    while (_jettag_c_when_88_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" EditTextField ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 88, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_88_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_88_6_saved_out;
                    _jettag_c_when_88_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_90_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_90_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_90_6.setRuntimeParent(_jettag_c_choose_87_8);
                    _jettag_c_when_90_6.setTagInfo(_td_c_when_90_6);
                    _jettag_c_when_90_6.doStart(context, out);
                    JET2Writer _jettag_c_when_90_6_saved_out = out;
                    while (_jettag_c_when_90_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" EditTextField ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 90, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_90_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_90_6_saved_out;
                    _jettag_c_when_90_6.doEnd();
                    RuntimeTagElement _jettag_c_when_92_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_92_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_92_6.setRuntimeParent(_jettag_c_choose_87_8);
                    _jettag_c_when_92_6.setTagInfo(_td_c_when_92_6);
                    _jettag_c_when_92_6.doStart(context, out);
                    JET2Writer _jettag_c_when_92_6_saved_out = out;
                    while (_jettag_c_when_92_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t Date ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 93, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("= new Date(); \t");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t Button ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 94, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("B;");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\tstatic final int ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 95, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_ID =  ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_f_unique_95_68 = context.getTagFactory().createRuntimeTag(_jetns_f, "unique", "f:unique", _td_f_unique_95_68); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_f_unique_95_68.setRuntimeParent(_jettag_c_when_92_6);
                        _jettag_f_unique_95_68.setTagInfo(_td_f_unique_95_68);
                        _jettag_f_unique_95_68.doStart(context, out);
                        _jettag_f_unique_95_68.doEnd();
                        out.write(";");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\tprivate DatePickerDialog.OnDateSetListener ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 96, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("DateSetListener = new DatePickerDialog.OnDateSetListener() {");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onDateSet(DatePicker view, int year, int monthOfYear,");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tint dayOfMonth) {");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 100, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".setDate(dayOfMonth);");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 101, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".setMonth(monthOfYear + 1);");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 102, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".setYear(year);");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t};");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_92_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_92_6_saved_out;
                    _jettag_c_when_92_6.doEnd();
                    RuntimeTagElement _jettag_c_when_106_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_106_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_106_6.setRuntimeParent(_jettag_c_choose_87_8);
                    _jettag_c_when_106_6.setTagInfo(_td_c_when_106_6);
                    _jettag_c_when_106_6.doStart(context, out);
                    JET2Writer _jettag_c_when_106_6_saved_out = out;
                    while (_jettag_c_when_106_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_106_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_106_6_saved_out;
                    _jettag_c_when_106_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_108_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_108_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_108_6.setRuntimeParent(_jettag_c_choose_87_8);
                    _jettag_c_when_108_6.setTagInfo(_td_c_when_108_6);
                    _jettag_c_when_108_6.doStart(context, out);
                    JET2Writer _jettag_c_when_108_6_saved_out = out;
                    while (_jettag_c_when_108_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" EditTextField ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 108, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_108_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_108_6_saved_out;
                    _jettag_c_when_108_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_110_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_110_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_110_6.setRuntimeParent(_jettag_c_choose_87_8);
                    _jettag_c_when_110_6.setTagInfo(_td_c_when_110_6);
                    _jettag_c_when_110_6.doStart(context, out);
                    JET2Writer _jettag_c_when_110_6_saved_out = out;
                    while (_jettag_c_when_110_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" EditTextField ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 110, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_110_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_110_6_saved_out;
                    _jettag_c_when_110_6.doEnd();
                    _jettag_c_choose_87_8.handleBodyContent(out);
                }
                out = _jettag_c_choose_87_8_saved_out;
                _jettag_c_choose_87_8.doEnd();
                out.write(NL);         
                _jettag_c_iterate_86_4.handleBodyContent(out);
            }
            _jettag_c_iterate_86_4.doEnd();
            out.write("\t\t\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onCreate(Bundle savedInstanceState) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsuper.onCreate(savedInstanceState);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\trequestWindowFeature(Window.FEATURE_CUSTOM_TITLE);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsetContentView(R.layout.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 120, 27)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_create);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcustomizeTitle();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tupdate = (Button) findViewById(R.id.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 122, 39)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_create);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tupdate.setOnClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tassignFields();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic void customizeTitle() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tgetWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tR.layout.automanage_title_bar);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tTextView mytitletext = (TextView) findViewById(R.id.automanage_title_text);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tmytitletext.setText(\"Update ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 131, 31)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" Activity\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tpublic void onClick(View arg0) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tLog.d(\"info.yalamanchili.project\", \"update ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 135, 46)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" clicked\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void assignFields() {");  //$NON-NLS-1$        
            out.write(NL);         
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_141_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_141_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_141_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_141_2.setTagInfo(_td_c_if_141_2);
            _jettag_c_if_141_2.doStart(context, out);
            while (_jettag_c_if_141_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_142_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_142_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_142_5.setRuntimeParent(_jettag_c_if_141_2);
                _jettag_c_iterate_142_5.setTagInfo(_td_c_iterate_142_5);
                _jettag_c_iterate_142_5.doStart(context, out);
                while (_jettag_c_iterate_142_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_143_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_143_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_143_5.setRuntimeParent(_jettag_c_iterate_142_5);
                    _jettag_c_choose_143_5.setTagInfo(_td_c_choose_143_5);
                    _jettag_c_choose_143_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_143_5_saved_out = out;
                    while (_jettag_c_choose_143_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_144_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_144_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_144_6.setRuntimeParent(_jettag_c_choose_143_5);
                        _jettag_c_when_144_6.setTagInfo(_td_c_when_144_6);
                        _jettag_c_when_144_6.doStart(context, out);
                        JET2Writer _jettag_c_when_144_6_saved_out = out;
                        while (_jettag_c_when_144_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 144, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 144, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 144, 132)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 145, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 145, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_144_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_144_6_saved_out;
                        _jettag_c_when_144_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_147_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_147_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_147_6.setRuntimeParent(_jettag_c_choose_143_5);
                        _jettag_c_when_147_6.setTagInfo(_td_c_when_147_6);
                        _jettag_c_when_147_6.doStart(context, out);
                        JET2Writer _jettag_c_when_147_6_saved_out = out;
                        while (_jettag_c_when_147_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 147, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 147, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 147, 133)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 148, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 148, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_147_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_147_6_saved_out;
                        _jettag_c_when_147_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_150_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_150_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_150_6.setRuntimeParent(_jettag_c_choose_143_5);
                        _jettag_c_when_150_6.setTagInfo(_td_c_when_150_6);
                        _jettag_c_when_150_6.doStart(context, out);
                        JET2Writer _jettag_c_when_150_6_saved_out = out;
                        while (_jettag_c_when_150_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 150, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B= (Button) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 150, 86)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 150, 121)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 151, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B.setOnClickListener(this);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_150_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_150_6_saved_out;
                        _jettag_c_when_150_6.doEnd();
                        RuntimeTagElement _jettag_c_when_153_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_153_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_153_6.setRuntimeParent(_jettag_c_choose_143_5);
                        _jettag_c_when_153_6.setTagInfo(_td_c_when_153_6);
                        _jettag_c_when_153_6.doStart(context, out);
                        JET2Writer _jettag_c_when_153_6_saved_out = out;
                        while (_jettag_c_when_153_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_153_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_153_6_saved_out;
                        _jettag_c_when_153_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_155_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_155_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_155_6.setRuntimeParent(_jettag_c_choose_143_5);
                        _jettag_c_when_155_6.setTagInfo(_td_c_when_155_6);
                        _jettag_c_when_155_6.doStart(context, out);
                        JET2Writer _jettag_c_when_155_6_saved_out = out;
                        while (_jettag_c_when_155_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 155, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 155, 94)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 155, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 156, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 156, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_155_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_155_6_saved_out;
                        _jettag_c_when_155_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_158_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_158_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_158_6.setRuntimeParent(_jettag_c_choose_143_5);
                        _jettag_c_when_158_6.setTagInfo(_td_c_when_158_6);
                        _jettag_c_when_158_6.doStart(context, out);
                        JET2Writer _jettag_c_when_158_6_saved_out = out;
                        while (_jettag_c_when_158_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 158, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 158, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 158, 131)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 159, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 159, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_158_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_158_6_saved_out;
                        _jettag_c_when_158_6.doEnd();
                        _jettag_c_choose_143_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_143_5_saved_out;
                    _jettag_c_choose_143_5.doEnd();
                    _jettag_c_iterate_142_5.handleBodyContent(out);
                }
                _jettag_c_iterate_142_5.doEnd();
                _jettag_c_if_141_2.handleBodyContent(out);
            }
            _jettag_c_if_141_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_165_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_165_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_165_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_165_2.setTagInfo(_td_c_if_165_2);
            _jettag_c_if_165_2.doStart(context, out);
            while (_jettag_c_if_165_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_166_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_166_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_166_5.setRuntimeParent(_jettag_c_if_165_2);
                _jettag_c_iterate_166_5.setTagInfo(_td_c_iterate_166_5);
                _jettag_c_iterate_166_5.doStart(context, out);
                while (_jettag_c_iterate_166_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_167_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_167_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_167_5.setRuntimeParent(_jettag_c_iterate_166_5);
                    _jettag_c_choose_167_5.setTagInfo(_td_c_choose_167_5);
                    _jettag_c_choose_167_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_167_5_saved_out = out;
                    while (_jettag_c_choose_167_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_168_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_168_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_168_6.setRuntimeParent(_jettag_c_choose_167_5);
                        _jettag_c_when_168_6.setTagInfo(_td_c_when_168_6);
                        _jettag_c_when_168_6.doStart(context, out);
                        JET2Writer _jettag_c_when_168_6_saved_out = out;
                        while (_jettag_c_when_168_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 168, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 168, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 168, 132)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 169, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 169, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_168_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_168_6_saved_out;
                        _jettag_c_when_168_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_171_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_171_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_171_6.setRuntimeParent(_jettag_c_choose_167_5);
                        _jettag_c_when_171_6.setTagInfo(_td_c_when_171_6);
                        _jettag_c_when_171_6.doStart(context, out);
                        JET2Writer _jettag_c_when_171_6_saved_out = out;
                        while (_jettag_c_when_171_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 171, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 171, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 171, 133)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 172, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 172, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_171_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_171_6_saved_out;
                        _jettag_c_when_171_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_174_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_174_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_174_6.setRuntimeParent(_jettag_c_choose_167_5);
                        _jettag_c_when_174_6.setTagInfo(_td_c_when_174_6);
                        _jettag_c_when_174_6.doStart(context, out);
                        JET2Writer _jettag_c_when_174_6_saved_out = out;
                        while (_jettag_c_when_174_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 174, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B= (Button) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 174, 86)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 174, 121)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 175, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B.setOnClickListener(this);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_174_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_174_6_saved_out;
                        _jettag_c_when_174_6.doEnd();
                        RuntimeTagElement _jettag_c_when_177_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_177_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_177_6.setRuntimeParent(_jettag_c_choose_167_5);
                        _jettag_c_when_177_6.setTagInfo(_td_c_when_177_6);
                        _jettag_c_when_177_6.doStart(context, out);
                        JET2Writer _jettag_c_when_177_6_saved_out = out;
                        while (_jettag_c_when_177_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_177_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_177_6_saved_out;
                        _jettag_c_when_177_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_179_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_179_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_179_6.setRuntimeParent(_jettag_c_choose_167_5);
                        _jettag_c_when_179_6.setTagInfo(_td_c_when_179_6);
                        _jettag_c_when_179_6.doStart(context, out);
                        JET2Writer _jettag_c_when_179_6_saved_out = out;
                        while (_jettag_c_when_179_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 179, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 179, 94)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 179, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 180, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 180, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_179_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_179_6_saved_out;
                        _jettag_c_when_179_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_182_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_182_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_182_6.setRuntimeParent(_jettag_c_choose_167_5);
                        _jettag_c_when_182_6.setTagInfo(_td_c_when_182_6);
                        _jettag_c_when_182_6.doStart(context, out);
                        JET2Writer _jettag_c_when_182_6_saved_out = out;
                        while (_jettag_c_when_182_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 182, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 182, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 182, 131)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 183, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 183, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_182_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_182_6_saved_out;
                        _jettag_c_when_182_6.doEnd();
                        _jettag_c_choose_167_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_167_5_saved_out;
                    _jettag_c_choose_167_5.doEnd();
                    _jettag_c_iterate_166_5.handleBodyContent(out);
                }
                _jettag_c_iterate_166_5.doEnd();
                _jettag_c_if_165_2.handleBodyContent(out);
            }
            _jettag_c_if_165_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_189_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_189_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_189_5.setRuntimeParent(_jettag_java_format_1_1);
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
                        out.write("  ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 191, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 191, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 191, 132)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(");");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 192, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 192, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\");");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_191_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_191_6_saved_out;
                    _jettag_c_when_191_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_194_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_194_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_194_6.setRuntimeParent(_jettag_c_choose_190_5);
                    _jettag_c_when_194_6.setTagInfo(_td_c_when_194_6);
                    _jettag_c_when_194_6.doStart(context, out);
                    JET2Writer _jettag_c_when_194_6_saved_out = out;
                    while (_jettag_c_when_194_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("  ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 194, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 194, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 194, 133)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(");");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 195, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 195, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\");");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_194_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_194_6_saved_out;
                    _jettag_c_when_194_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_197_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_197_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_197_6.setRuntimeParent(_jettag_c_choose_190_5);
                    _jettag_c_when_197_6.setTagInfo(_td_c_when_197_6);
                    _jettag_c_when_197_6.doStart(context, out);
                    JET2Writer _jettag_c_when_197_6_saved_out = out;
                    while (_jettag_c_when_197_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("  ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 197, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("B= (Button) findViewById(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 197, 86)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 197, 121)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(");");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 198, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("B.setOnClickListener(this);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_197_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_197_6_saved_out;
                    _jettag_c_when_197_6.doEnd();
                    RuntimeTagElement _jettag_c_when_200_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_200_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_200_6.setRuntimeParent(_jettag_c_choose_190_5);
                    _jettag_c_when_200_6.setTagInfo(_td_c_when_200_6);
                    _jettag_c_when_200_6.doStart(context, out);
                    JET2Writer _jettag_c_when_200_6_saved_out = out;
                    while (_jettag_c_when_200_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_200_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_200_6_saved_out;
                    _jettag_c_when_200_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_202_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_202_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_202_6.setRuntimeParent(_jettag_c_choose_190_5);
                    _jettag_c_when_202_6.setTagInfo(_td_c_when_202_6);
                    _jettag_c_when_202_6.doStart(context, out);
                    JET2Writer _jettag_c_when_202_6_saved_out = out;
                    while (_jettag_c_when_202_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 202, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 202, 94)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 202, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(");");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 203, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 203, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\");");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_202_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_202_6_saved_out;
                    _jettag_c_when_202_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_205_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_205_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_205_6.setRuntimeParent(_jettag_c_choose_190_5);
                    _jettag_c_when_205_6.setTagInfo(_td_c_when_205_6);
                    _jettag_c_when_205_6.doStart(context, out);
                    JET2Writer _jettag_c_when_205_6_saved_out = out;
                    while (_jettag_c_when_205_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("  ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 205, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 205, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 205, 131)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(");");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 206, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 206, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\");");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_205_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_205_6_saved_out;
                    _jettag_c_when_205_6.doEnd();
                    _jettag_c_choose_190_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_190_5_saved_out;
                _jettag_c_choose_190_5.doEnd();
                _jettag_c_iterate_189_5.handleBodyContent(out);
            }
            _jettag_c_iterate_189_5.doEnd();
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected void populateFields(){");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 212, 2)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" = (");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 212, 33)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(") getIntent().getSerializableExtra(\"entity\");");  //$NON-NLS-1$        
            out.write(NL);         
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_214_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_214_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_214_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_214_2.setTagInfo(_td_c_if_214_2);
            _jettag_c_if_214_2.doStart(context, out);
            while (_jettag_c_if_214_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_215_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_215_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_215_5.setRuntimeParent(_jettag_c_if_214_2);
                _jettag_c_iterate_215_5.setTagInfo(_td_c_iterate_215_5);
                _jettag_c_iterate_215_5.doStart(context, out);
                while (_jettag_c_iterate_215_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_216_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_216_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_216_5.setRuntimeParent(_jettag_c_iterate_215_5);
                    _jettag_c_choose_216_5.setTagInfo(_td_c_choose_216_5);
                    _jettag_c_choose_216_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_216_5_saved_out = out;
                    while (_jettag_c_choose_216_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_217_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_217_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_217_6.setRuntimeParent(_jettag_c_choose_216_5);
                        _jettag_c_when_217_6.setTagInfo(_td_c_when_217_6);
                        _jettag_c_when_217_6.doStart(context, out);
                        JET2Writer _jettag_c_when_217_6_saved_out = out;
                        while (_jettag_c_when_217_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t if (");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 218, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 218, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("() != null)");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 219, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setValue(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 219, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 219, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("().toString());");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_217_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_217_6_saved_out;
                        _jettag_c_when_217_6.doEnd();
                        RuntimeTagElement _jettag_c_when_221_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_221_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_221_6.setRuntimeParent(_jettag_c_choose_216_5);
                        _jettag_c_when_221_6.setTagInfo(_td_c_when_221_6);
                        _jettag_c_when_221_6.doStart(context, out);
                        JET2Writer _jettag_c_when_221_6_saved_out = out;
                        while (_jettag_c_when_221_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t if (");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 222, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 222, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("() != null)");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 223, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setValue(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 223, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 223, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("().toString());\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_221_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_221_6_saved_out;
                        _jettag_c_when_221_6.doEnd();
                        RuntimeTagElement _jettag_c_when_225_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_225_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_225_6.setRuntimeParent(_jettag_c_choose_216_5);
                        _jettag_c_when_225_6.setTagInfo(_td_c_when_225_6);
                        _jettag_c_when_225_6.doStart(context, out);
                        JET2Writer _jettag_c_when_225_6_saved_out = out;
                        while (_jettag_c_when_225_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_225_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_225_6_saved_out;
                        _jettag_c_when_225_6.doEnd();
                        RuntimeTagElement _jettag_c_when_227_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_227_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_227_6.setRuntimeParent(_jettag_c_choose_216_5);
                        _jettag_c_when_227_6.setTagInfo(_td_c_when_227_6);
                        _jettag_c_when_227_6.doStart(context, out);
                        JET2Writer _jettag_c_when_227_6_saved_out = out;
                        while (_jettag_c_when_227_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_227_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_227_6_saved_out;
                        _jettag_c_when_227_6.doEnd();
                        RuntimeTagElement _jettag_c_when_229_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_229_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_229_6.setRuntimeParent(_jettag_c_choose_216_5);
                        _jettag_c_when_229_6.setTagInfo(_td_c_when_229_6);
                        _jettag_c_when_229_6.doStart(context, out);
                        JET2Writer _jettag_c_when_229_6_saved_out = out;
                        while (_jettag_c_when_229_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t if (");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 230, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 230, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("() != null)");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 231, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setValue(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 231, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 231, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("().toString());\t\t\t\t  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_229_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_229_6_saved_out;
                        _jettag_c_when_229_6.doEnd();
                        RuntimeTagElement _jettag_c_when_233_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_233_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_233_6.setRuntimeParent(_jettag_c_choose_216_5);
                        _jettag_c_when_233_6.setTagInfo(_td_c_when_233_6);
                        _jettag_c_when_233_6.doStart(context, out);
                        JET2Writer _jettag_c_when_233_6_saved_out = out;
                        while (_jettag_c_when_233_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t if (");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 234, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 234, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("() != null)");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 235, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setValue(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 235, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 235, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("().toString());");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_233_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_233_6_saved_out;
                        _jettag_c_when_233_6.doEnd();
                        _jettag_c_choose_216_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_216_5_saved_out;
                    _jettag_c_choose_216_5.doEnd();
                    _jettag_c_iterate_215_5.handleBodyContent(out);
                }
                _jettag_c_iterate_215_5.doEnd();
                _jettag_c_if_214_2.handleBodyContent(out);
            }
            _jettag_c_if_214_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_241_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_241_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_241_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_241_2.setTagInfo(_td_c_if_241_2);
            _jettag_c_if_241_2.doStart(context, out);
            while (_jettag_c_if_241_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_242_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_242_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_242_5.setRuntimeParent(_jettag_c_if_241_2);
                _jettag_c_iterate_242_5.setTagInfo(_td_c_iterate_242_5);
                _jettag_c_iterate_242_5.doStart(context, out);
                while (_jettag_c_iterate_242_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_243_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_243_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_243_5.setRuntimeParent(_jettag_c_iterate_242_5);
                    _jettag_c_choose_243_5.setTagInfo(_td_c_choose_243_5);
                    _jettag_c_choose_243_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_243_5_saved_out = out;
                    while (_jettag_c_choose_243_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_244_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_244_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_244_6.setRuntimeParent(_jettag_c_choose_243_5);
                        _jettag_c_when_244_6.setTagInfo(_td_c_when_244_6);
                        _jettag_c_when_244_6.doStart(context, out);
                        JET2Writer _jettag_c_when_244_6_saved_out = out;
                        while (_jettag_c_when_244_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t if (");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 245, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 245, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("() != null)");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 246, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setValue(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 246, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 246, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("().toString());");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_244_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_244_6_saved_out;
                        _jettag_c_when_244_6.doEnd();
                        RuntimeTagElement _jettag_c_when_248_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_248_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_248_6.setRuntimeParent(_jettag_c_choose_243_5);
                        _jettag_c_when_248_6.setTagInfo(_td_c_when_248_6);
                        _jettag_c_when_248_6.doStart(context, out);
                        JET2Writer _jettag_c_when_248_6_saved_out = out;
                        while (_jettag_c_when_248_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t if (");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 249, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 249, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("() != null)");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 250, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setValue(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 250, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 250, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("().toString());\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_248_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_248_6_saved_out;
                        _jettag_c_when_248_6.doEnd();
                        RuntimeTagElement _jettag_c_when_252_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_252_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_252_6.setRuntimeParent(_jettag_c_choose_243_5);
                        _jettag_c_when_252_6.setTagInfo(_td_c_when_252_6);
                        _jettag_c_when_252_6.doStart(context, out);
                        JET2Writer _jettag_c_when_252_6_saved_out = out;
                        while (_jettag_c_when_252_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_252_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_252_6_saved_out;
                        _jettag_c_when_252_6.doEnd();
                        RuntimeTagElement _jettag_c_when_254_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_254_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_254_6.setRuntimeParent(_jettag_c_choose_243_5);
                        _jettag_c_when_254_6.setTagInfo(_td_c_when_254_6);
                        _jettag_c_when_254_6.doStart(context, out);
                        JET2Writer _jettag_c_when_254_6_saved_out = out;
                        while (_jettag_c_when_254_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_254_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_254_6_saved_out;
                        _jettag_c_when_254_6.doEnd();
                        RuntimeTagElement _jettag_c_when_256_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_256_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_256_6.setRuntimeParent(_jettag_c_choose_243_5);
                        _jettag_c_when_256_6.setTagInfo(_td_c_when_256_6);
                        _jettag_c_when_256_6.doStart(context, out);
                        JET2Writer _jettag_c_when_256_6_saved_out = out;
                        while (_jettag_c_when_256_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t if (");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 257, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 257, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("() != null)");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 258, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setValue(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 258, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 258, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("().toString());\t\t\t\t  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_256_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_256_6_saved_out;
                        _jettag_c_when_256_6.doEnd();
                        RuntimeTagElement _jettag_c_when_260_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_260_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_260_6.setRuntimeParent(_jettag_c_choose_243_5);
                        _jettag_c_when_260_6.setTagInfo(_td_c_when_260_6);
                        _jettag_c_when_260_6.doStart(context, out);
                        JET2Writer _jettag_c_when_260_6_saved_out = out;
                        while (_jettag_c_when_260_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t if (");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 261, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 261, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("() != null)");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 262, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setValue(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 262, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".get");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 262, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("().toString());");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_260_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_260_6_saved_out;
                        _jettag_c_when_260_6.doEnd();
                        _jettag_c_choose_243_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_243_5_saved_out;
                    _jettag_c_choose_243_5.doEnd();
                    _jettag_c_iterate_242_5.handleBodyContent(out);
                }
                _jettag_c_iterate_242_5.doEnd();
                _jettag_c_if_241_2.handleBodyContent(out);
            }
            _jettag_c_if_241_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_268_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_268_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_268_5.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_268_5.setTagInfo(_td_c_iterate_268_5);
            _jettag_c_iterate_268_5.doStart(context, out);
            while (_jettag_c_iterate_268_5.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_269_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_269_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_269_5.setRuntimeParent(_jettag_c_iterate_268_5);
                _jettag_c_choose_269_5.setTagInfo(_td_c_choose_269_5);
                _jettag_c_choose_269_5.doStart(context, out);
                JET2Writer _jettag_c_choose_269_5_saved_out = out;
                while (_jettag_c_choose_269_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_270_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_270_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_270_6.setRuntimeParent(_jettag_c_choose_269_5);
                    _jettag_c_when_270_6.setTagInfo(_td_c_when_270_6);
                    _jettag_c_when_270_6.doStart(context, out);
                    JET2Writer _jettag_c_when_270_6_saved_out = out;
                    while (_jettag_c_when_270_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t if (");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 271, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".get");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 271, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("() != null)");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 272, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.setValue(");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 272, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".get");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 272, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("().toString());");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_270_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_270_6_saved_out;
                    _jettag_c_when_270_6.doEnd();
                    RuntimeTagElement _jettag_c_when_274_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_274_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_274_6.setRuntimeParent(_jettag_c_choose_269_5);
                    _jettag_c_when_274_6.setTagInfo(_td_c_when_274_6);
                    _jettag_c_when_274_6.doStart(context, out);
                    JET2Writer _jettag_c_when_274_6_saved_out = out;
                    while (_jettag_c_when_274_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t if (");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 275, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".get");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 275, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("() != null)");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 276, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.setValue(");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 276, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".get");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 276, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("().toString());\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_274_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_274_6_saved_out;
                    _jettag_c_when_274_6.doEnd();
                    RuntimeTagElement _jettag_c_when_278_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_278_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_278_6.setRuntimeParent(_jettag_c_choose_269_5);
                    _jettag_c_when_278_6.setTagInfo(_td_c_when_278_6);
                    _jettag_c_when_278_6.doStart(context, out);
                    JET2Writer _jettag_c_when_278_6_saved_out = out;
                    while (_jettag_c_when_278_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_278_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_278_6_saved_out;
                    _jettag_c_when_278_6.doEnd();
                    RuntimeTagElement _jettag_c_when_280_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_280_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_280_6.setRuntimeParent(_jettag_c_choose_269_5);
                    _jettag_c_when_280_6.setTagInfo(_td_c_when_280_6);
                    _jettag_c_when_280_6.doStart(context, out);
                    JET2Writer _jettag_c_when_280_6_saved_out = out;
                    while (_jettag_c_when_280_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_280_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_280_6_saved_out;
                    _jettag_c_when_280_6.doEnd();
                    RuntimeTagElement _jettag_c_when_282_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_282_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_282_6.setRuntimeParent(_jettag_c_choose_269_5);
                    _jettag_c_when_282_6.setTagInfo(_td_c_when_282_6);
                    _jettag_c_when_282_6.doStart(context, out);
                    JET2Writer _jettag_c_when_282_6_saved_out = out;
                    while (_jettag_c_when_282_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t if (");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 283, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".get");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 283, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("() != null)");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 284, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.setValue(");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 284, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".get");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 284, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("().toString());\t\t\t\t  ");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_282_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_282_6_saved_out;
                    _jettag_c_when_282_6.doEnd();
                    RuntimeTagElement _jettag_c_when_286_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_286_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_286_6.setRuntimeParent(_jettag_c_choose_269_5);
                    _jettag_c_when_286_6.setTagInfo(_td_c_when_286_6);
                    _jettag_c_when_286_6.doStart(context, out);
                    JET2Writer _jettag_c_when_286_6_saved_out = out;
                    while (_jettag_c_when_286_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t if (");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 287, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".get");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 287, 41)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("() != null)");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 288, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.setValue(");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 288, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".get");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 288, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("().toString());");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_286_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_286_6_saved_out;
                    _jettag_c_when_286_6.doEnd();
                    _jettag_c_choose_269_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_269_5_saved_out;
                _jettag_c_choose_269_5.doEnd();
                _jettag_c_iterate_268_5.handleBodyContent(out);
            }
            _jettag_c_iterate_268_5.doEnd();
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onStart() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tsuper.onStart();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tLog.d(\"info.yalamacnhili.android\", \"in ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 297, 42)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" start\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tpopulateFields();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
