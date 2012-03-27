package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_create_entityjava_0 implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_create_entityjava_0() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_java_format_1_1 = new TagInfo("java:format", //$NON-NLS-1$
            1, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_29_2 = new TagInfo("c:if", //$NON-NLS-1$
            29, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_30_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            30, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_31_5 = new TagInfo("c:choose", //$NON-NLS-1$
            31, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_32_6 = new TagInfo("c:when", //$NON-NLS-1$
            32, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_34_6 = new TagInfo("c:when", //$NON-NLS-1$
            34, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_36_6 = new TagInfo("c:when", //$NON-NLS-1$
            36, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_unique_39_67 = new TagInfo("f:unique", //$NON-NLS-1$
            39, 67,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_when_50_6 = new TagInfo("c:when", //$NON-NLS-1$
            50, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_52_6 = new TagInfo("c:when", //$NON-NLS-1$
            52, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_54_6 = new TagInfo("c:when", //$NON-NLS-1$
            54, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_60_2 = new TagInfo("c:if", //$NON-NLS-1$
            60, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_61_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            61, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_62_9 = new TagInfo("c:choose", //$NON-NLS-1$
            62, 9,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_63_6 = new TagInfo("c:when", //$NON-NLS-1$
            63, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_65_6 = new TagInfo("c:when", //$NON-NLS-1$
            65, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_67_6 = new TagInfo("c:when", //$NON-NLS-1$
            67, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_unique_70_68 = new TagInfo("f:unique", //$NON-NLS-1$
            70, 68,
            new String[] {
            },
            new String[] {
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
    private static final TagInfo _td_c_iterate_91_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            91, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_92_8 = new TagInfo("c:choose", //$NON-NLS-1$
            92, 8,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_93_6 = new TagInfo("c:when", //$NON-NLS-1$
            93, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_95_6 = new TagInfo("c:when", //$NON-NLS-1$
            95, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_97_6 = new TagInfo("c:when", //$NON-NLS-1$
            97, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_unique_100_68 = new TagInfo("f:unique", //$NON-NLS-1$
            100, 68,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_when_111_6 = new TagInfo("c:when", //$NON-NLS-1$
            111, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_113_6 = new TagInfo("c:when", //$NON-NLS-1$
            113, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_115_6 = new TagInfo("c:when", //$NON-NLS-1$
            115, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_140_2 = new TagInfo("c:if", //$NON-NLS-1$
            140, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_141_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            141, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_142_5 = new TagInfo("c:choose", //$NON-NLS-1$
            142, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_143_6 = new TagInfo("c:when", //$NON-NLS-1$
            143, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_146_6 = new TagInfo("c:when", //$NON-NLS-1$
            146, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_149_6 = new TagInfo("c:when", //$NON-NLS-1$
            149, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_152_6 = new TagInfo("c:when", //$NON-NLS-1$
            152, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_154_6 = new TagInfo("c:when", //$NON-NLS-1$
            154, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_157_6 = new TagInfo("c:when", //$NON-NLS-1$
            157, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_164_2 = new TagInfo("c:if", //$NON-NLS-1$
            164, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_165_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            165, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_166_5 = new TagInfo("c:choose", //$NON-NLS-1$
            166, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_167_6 = new TagInfo("c:when", //$NON-NLS-1$
            167, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_170_6 = new TagInfo("c:when", //$NON-NLS-1$
            170, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_173_6 = new TagInfo("c:when", //$NON-NLS-1$
            173, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_176_6 = new TagInfo("c:when", //$NON-NLS-1$
            176, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_178_6 = new TagInfo("c:when", //$NON-NLS-1$
            178, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_181_6 = new TagInfo("c:when", //$NON-NLS-1$
            181, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_188_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            188, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_189_5 = new TagInfo("c:choose", //$NON-NLS-1$
            189, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_190_6 = new TagInfo("c:when", //$NON-NLS-1$
            190, 6,
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
    private static final TagInfo _td_c_when_196_6 = new TagInfo("c:when", //$NON-NLS-1$
            196, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_199_6 = new TagInfo("c:when", //$NON-NLS-1$
            199, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_201_6 = new TagInfo("c:when", //$NON-NLS-1$
            201, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_204_6 = new TagInfo("c:when", //$NON-NLS-1$
            204, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_222_2 = new TagInfo("c:if", //$NON-NLS-1$
            222, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_223_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            223, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_224_5 = new TagInfo("c:choose", //$NON-NLS-1$
            224, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_225_6 = new TagInfo("c:when", //$NON-NLS-1$
            225, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_227_6 = new TagInfo("c:when", //$NON-NLS-1$
            227, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_229_6 = new TagInfo("c:when", //$NON-NLS-1$
            229, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_231_6 = new TagInfo("c:when", //$NON-NLS-1$
            231, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_233_6 = new TagInfo("c:when", //$NON-NLS-1$
            233, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_235_6 = new TagInfo("c:when", //$NON-NLS-1$
            235, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_237_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            237, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_243_2 = new TagInfo("c:if", //$NON-NLS-1$
            243, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_244_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            244, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_245_5 = new TagInfo("c:choose", //$NON-NLS-1$
            245, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_246_6 = new TagInfo("c:when", //$NON-NLS-1$
            246, 6,
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
    private static final TagInfo _td_c_when_250_6 = new TagInfo("c:when", //$NON-NLS-1$
            250, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_252_6 = new TagInfo("c:when", //$NON-NLS-1$
            252, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_254_6 = new TagInfo("c:when", //$NON-NLS-1$
            254, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_256_6 = new TagInfo("c:when", //$NON-NLS-1$
            256, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_258_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            258, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_264_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            264, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_265_5 = new TagInfo("c:choose", //$NON-NLS-1$
            265, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_266_6 = new TagInfo("c:when", //$NON-NLS-1$
            266, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_268_6 = new TagInfo("c:when", //$NON-NLS-1$
            268, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_270_6 = new TagInfo("c:when", //$NON-NLS-1$
            270, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_272_6 = new TagInfo("c:when", //$NON-NLS-1$
            272, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_274_6 = new TagInfo("c:when", //$NON-NLS-1$
            274, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_276_6 = new TagInfo("c:when", //$NON-NLS-1$
            276, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_278_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            278, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_294_2 = new TagInfo("c:if", //$NON-NLS-1$
            294, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_295_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            295, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_296_5 = new TagInfo("c:choose", //$NON-NLS-1$
            296, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_297_6 = new TagInfo("c:when", //$NON-NLS-1$
            297, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_306_2 = new TagInfo("c:if", //$NON-NLS-1$
            306, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_307_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            307, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_308_5 = new TagInfo("c:choose", //$NON-NLS-1$
            308, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_309_6 = new TagInfo("c:when", //$NON-NLS-1$
            309, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_318_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            318, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_319_5 = new TagInfo("c:choose", //$NON-NLS-1$
            319, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_320_6 = new TagInfo("c:when", //$NON-NLS-1$
            320, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_337_2 = new TagInfo("c:if", //$NON-NLS-1$
            337, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_338_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            338, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_339_5 = new TagInfo("c:choose", //$NON-NLS-1$
            339, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_340_6 = new TagInfo("c:when", //$NON-NLS-1$
            340, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_349_2 = new TagInfo("c:if", //$NON-NLS-1$
            349, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_350_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            350, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_351_5 = new TagInfo("c:choose", //$NON-NLS-1$
            351, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_352_6 = new TagInfo("c:when", //$NON-NLS-1$
            352, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_361_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            361, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_362_5 = new TagInfo("c:choose", //$NON-NLS-1$
            362, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_363_6 = new TagInfo("c:when", //$NON-NLS-1$
            363, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
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
            out.write("import info.yalamanchili.android.views.EditTextField;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.http.AsyncHttpPut;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.http.HttpHelper;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.app.Activity;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.os.Bundle;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 9, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.R;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.View.OnClickListener;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.Button;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.app.DatePickerDialog;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.app.Dialog;import android.widget.DatePicker;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.Date;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.content.Intent;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.Toast;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.Window;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.widget.TextView;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import java.util.Calendar;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 22, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".entity.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 22, 27)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 22, 57)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("public class Create");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 24, 20)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" extends Activity implements OnClickListener {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\tButton create;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_29_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_29_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_29_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_29_2.setTagInfo(_td_c_if_29_2);
            _jettag_c_if_29_2.doStart(context, out);
            while (_jettag_c_if_29_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_30_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_30_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_30_5.setRuntimeParent(_jettag_c_if_29_2);
                _jettag_c_iterate_30_5.setTagInfo(_td_c_iterate_30_5);
                _jettag_c_iterate_30_5.doStart(context, out);
                while (_jettag_c_iterate_30_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_31_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_31_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_31_5.setRuntimeParent(_jettag_c_iterate_30_5);
                    _jettag_c_choose_31_5.setTagInfo(_td_c_choose_31_5);
                    _jettag_c_choose_31_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_31_5_saved_out = out;
                    while (_jettag_c_choose_31_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_32_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_32_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_32_6.setRuntimeParent(_jettag_c_choose_31_5);
                        _jettag_c_when_32_6.setTagInfo(_td_c_when_32_6);
                        _jettag_c_when_32_6.doStart(context, out);
                        JET2Writer _jettag_c_when_32_6_saved_out = out;
                        while (_jettag_c_when_32_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 32, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_32_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_32_6_saved_out;
                        _jettag_c_when_32_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_34_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_34_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_34_6.setRuntimeParent(_jettag_c_choose_31_5);
                        _jettag_c_when_34_6.setTagInfo(_td_c_when_34_6);
                        _jettag_c_when_34_6.doStart(context, out);
                        JET2Writer _jettag_c_when_34_6_saved_out = out;
                        while (_jettag_c_when_34_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 34, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("YF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_34_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_34_6_saved_out;
                        _jettag_c_when_34_6.doEnd();
                        RuntimeTagElement _jettag_c_when_36_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_36_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_36_6.setRuntimeParent(_jettag_c_choose_31_5);
                        _jettag_c_when_36_6.setTagInfo(_td_c_when_36_6);
                        _jettag_c_when_36_6.doStart(context, out);
                        JET2Writer _jettag_c_when_36_6_saved_out = out;
                        while (_jettag_c_when_36_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\tDate ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 37, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("= new Date();");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t \tButton ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 38, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B;");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\tstatic final int ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 39, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_ID = ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_f_unique_39_67 = context.getTagFactory().createRuntimeTag(_jetns_f, "unique", "f:unique", _td_f_unique_39_67); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_f_unique_39_67.setRuntimeParent(_jettag_c_when_36_6);
                            _jettag_f_unique_39_67.setTagInfo(_td_f_unique_39_67);
                            _jettag_f_unique_39_67.doStart(context, out);
                            _jettag_f_unique_39_67.doEnd();
                            out.write(";");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\tprivate DatePickerDialog.OnDateSetListener ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 40, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("DateSetListener = new DatePickerDialog.OnDateSetListener() {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onDateSet(DatePicker view, int year, int monthOfYear,");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tint dayOfMonth) {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 44, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".setDate(dayOfMonth);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 45, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".setMonth(monthOfYear + 1);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 46, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".setYear(year);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t};");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_36_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_36_6_saved_out;
                        _jettag_c_when_36_6.doEnd();
                        RuntimeTagElement _jettag_c_when_50_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_50_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_50_6.setRuntimeParent(_jettag_c_choose_31_5);
                        _jettag_c_when_50_6.setTagInfo(_td_c_when_50_6);
                        _jettag_c_when_50_6.doStart(context, out);
                        JET2Writer _jettag_c_when_50_6_saved_out = out;
                        while (_jettag_c_when_50_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_50_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_50_6_saved_out;
                        _jettag_c_when_50_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_52_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_52_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_52_6.setRuntimeParent(_jettag_c_choose_31_5);
                        _jettag_c_when_52_6.setTagInfo(_td_c_when_52_6);
                        _jettag_c_when_52_6.doStart(context, out);
                        JET2Writer _jettag_c_when_52_6_saved_out = out;
                        while (_jettag_c_when_52_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 52, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_52_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_52_6_saved_out;
                        _jettag_c_when_52_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_54_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_54_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_54_6.setRuntimeParent(_jettag_c_choose_31_5);
                        _jettag_c_when_54_6.setTagInfo(_td_c_when_54_6);
                        _jettag_c_when_54_6.doStart(context, out);
                        JET2Writer _jettag_c_when_54_6_saved_out = out;
                        while (_jettag_c_when_54_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 54, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_54_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_54_6_saved_out;
                        _jettag_c_when_54_6.doEnd();
                        _jettag_c_choose_31_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_31_5_saved_out;
                    _jettag_c_choose_31_5.doEnd();
                    _jettag_c_iterate_30_5.handleBodyContent(out);
                }
                _jettag_c_iterate_30_5.doEnd();
                _jettag_c_if_29_2.handleBodyContent(out);
            }
            _jettag_c_if_29_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_60_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_60_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_60_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_60_2.setTagInfo(_td_c_if_60_2);
            _jettag_c_if_60_2.doStart(context, out);
            while (_jettag_c_if_60_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_61_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_61_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_61_5.setRuntimeParent(_jettag_c_if_60_2);
                _jettag_c_iterate_61_5.setTagInfo(_td_c_iterate_61_5);
                _jettag_c_iterate_61_5.doStart(context, out);
                while (_jettag_c_iterate_61_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_62_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_62_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_62_9.setRuntimeParent(_jettag_c_iterate_61_5);
                    _jettag_c_choose_62_9.setTagInfo(_td_c_choose_62_9);
                    _jettag_c_choose_62_9.doStart(context, out);
                    JET2Writer _jettag_c_choose_62_9_saved_out = out;
                    while (_jettag_c_choose_62_9.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_63_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_63_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_63_6.setRuntimeParent(_jettag_c_choose_62_9);
                        _jettag_c_when_63_6.setTagInfo(_td_c_when_63_6);
                        _jettag_c_when_63_6.doStart(context, out);
                        JET2Writer _jettag_c_when_63_6_saved_out = out;
                        while (_jettag_c_when_63_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 63, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_63_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_63_6_saved_out;
                        _jettag_c_when_63_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_65_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_65_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_65_6.setRuntimeParent(_jettag_c_choose_62_9);
                        _jettag_c_when_65_6.setTagInfo(_td_c_when_65_6);
                        _jettag_c_when_65_6.doStart(context, out);
                        JET2Writer _jettag_c_when_65_6_saved_out = out;
                        while (_jettag_c_when_65_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 65, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_65_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_65_6_saved_out;
                        _jettag_c_when_65_6.doEnd();
                        RuntimeTagElement _jettag_c_when_67_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_67_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_67_6.setRuntimeParent(_jettag_c_choose_62_9);
                        _jettag_c_when_67_6.setTagInfo(_td_c_when_67_6);
                        _jettag_c_when_67_6.doStart(context, out);
                        JET2Writer _jettag_c_when_67_6_saved_out = out;
                        while (_jettag_c_when_67_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t\tDate ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 68, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("= new Date();\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t  \tButton ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 69, 15)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B;");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\tstatic final int ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 70, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_ID =  ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_f_unique_70_68 = context.getTagFactory().createRuntimeTag(_jetns_f, "unique", "f:unique", _td_f_unique_70_68); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_f_unique_70_68.setRuntimeParent(_jettag_c_when_67_6);
                            _jettag_f_unique_70_68.setTagInfo(_td_f_unique_70_68);
                            _jettag_f_unique_70_68.doStart(context, out);
                            _jettag_f_unique_70_68.doEnd();
                            out.write(";");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\tprivate DatePickerDialog.OnDateSetListener ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 71, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("DateSetListener = new DatePickerDialog.OnDateSetListener() {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onDateSet(DatePicker view, int year, int monthOfYear,");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tint dayOfMonth) {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 75, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".setDate(dayOfMonth);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 76, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".setMonth(monthOfYear + 1);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 77, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".setYear(year);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t};");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_67_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_67_6_saved_out;
                        _jettag_c_when_67_6.doEnd();
                        RuntimeTagElement _jettag_c_when_81_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_81_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_81_6.setRuntimeParent(_jettag_c_choose_62_9);
                        _jettag_c_when_81_6.setTagInfo(_td_c_when_81_6);
                        _jettag_c_when_81_6.doStart(context, out);
                        JET2Writer _jettag_c_when_81_6_saved_out = out;
                        while (_jettag_c_when_81_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_81_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_81_6_saved_out;
                        _jettag_c_when_81_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_83_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_83_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_83_6.setRuntimeParent(_jettag_c_choose_62_9);
                        _jettag_c_when_83_6.setTagInfo(_td_c_when_83_6);
                        _jettag_c_when_83_6.doStart(context, out);
                        JET2Writer _jettag_c_when_83_6_saved_out = out;
                        while (_jettag_c_when_83_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 83, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_83_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_83_6_saved_out;
                        _jettag_c_when_83_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_85_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_85_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_85_6.setRuntimeParent(_jettag_c_choose_62_9);
                        _jettag_c_when_85_6.setTagInfo(_td_c_when_85_6);
                        _jettag_c_when_85_6.doStart(context, out);
                        JET2Writer _jettag_c_when_85_6_saved_out = out;
                        while (_jettag_c_when_85_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" EditTextField ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 85, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF;");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_85_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_85_6_saved_out;
                        _jettag_c_when_85_6.doEnd();
                        _jettag_c_choose_62_9.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_62_9_saved_out;
                    _jettag_c_choose_62_9.doEnd();
                    _jettag_c_iterate_61_5.handleBodyContent(out);
                }
                _jettag_c_iterate_61_5.doEnd();
                _jettag_c_if_60_2.handleBodyContent(out);
            }
            _jettag_c_if_60_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_91_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_91_4); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_91_4.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_91_4.setTagInfo(_td_c_iterate_91_4);
            _jettag_c_iterate_91_4.doStart(context, out);
            while (_jettag_c_iterate_91_4.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_92_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_92_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_92_8.setRuntimeParent(_jettag_c_iterate_91_4);
                _jettag_c_choose_92_8.setTagInfo(_td_c_choose_92_8);
                _jettag_c_choose_92_8.doStart(context, out);
                JET2Writer _jettag_c_choose_92_8_saved_out = out;
                while (_jettag_c_choose_92_8.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_93_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_93_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_93_6.setRuntimeParent(_jettag_c_choose_92_8);
                    _jettag_c_when_93_6.setTagInfo(_td_c_when_93_6);
                    _jettag_c_when_93_6.doStart(context, out);
                    JET2Writer _jettag_c_when_93_6_saved_out = out;
                    while (_jettag_c_when_93_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" EditTextField ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 93, 52)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_93_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_93_6_saved_out;
                    _jettag_c_when_93_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_95_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_95_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_95_6.setRuntimeParent(_jettag_c_choose_92_8);
                    _jettag_c_when_95_6.setTagInfo(_td_c_when_95_6);
                    _jettag_c_when_95_6.doStart(context, out);
                    JET2Writer _jettag_c_when_95_6_saved_out = out;
                    while (_jettag_c_when_95_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" EditTextField ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 95, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_95_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_95_6_saved_out;
                    _jettag_c_when_95_6.doEnd();
                    RuntimeTagElement _jettag_c_when_97_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_97_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_97_6.setRuntimeParent(_jettag_c_choose_92_8);
                    _jettag_c_when_97_6.setTagInfo(_td_c_when_97_6);
                    _jettag_c_when_97_6.doStart(context, out);
                    JET2Writer _jettag_c_when_97_6_saved_out = out;
                    while (_jettag_c_when_97_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t Date ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 98, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("= new Date(); \t");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t Button ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 99, 13)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("B;");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\tstatic final int ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 100, 30)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_ID =  ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_f_unique_100_68 = context.getTagFactory().createRuntimeTag(_jetns_f, "unique", "f:unique", _td_f_unique_100_68); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_f_unique_100_68.setRuntimeParent(_jettag_c_when_97_6);
                        _jettag_f_unique_100_68.setTagInfo(_td_f_unique_100_68);
                        _jettag_f_unique_100_68.doStart(context, out);
                        _jettag_f_unique_100_68.doEnd();
                        out.write(";");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\tprivate DatePickerDialog.OnDateSetListener ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 101, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("DateSetListener = new DatePickerDialog.OnDateSetListener() {");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tpublic void onDateSet(DatePicker view, int year, int monthOfYear,");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tint dayOfMonth) {");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 105, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".setDate(dayOfMonth);");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 106, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".setMonth(monthOfYear + 1);");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 107, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".setYear(year);");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t}");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t};");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_97_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_97_6_saved_out;
                    _jettag_c_when_97_6.doEnd();
                    RuntimeTagElement _jettag_c_when_111_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_111_6.setRuntimeParent(_jettag_c_choose_92_8);
                    _jettag_c_when_111_6.setTagInfo(_td_c_when_111_6);
                    _jettag_c_when_111_6.doStart(context, out);
                    JET2Writer _jettag_c_when_111_6_saved_out = out;
                    while (_jettag_c_when_111_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_111_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_111_6_saved_out;
                    _jettag_c_when_111_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_113_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_113_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_113_6.setRuntimeParent(_jettag_c_choose_92_8);
                    _jettag_c_when_113_6.setTagInfo(_td_c_when_113_6);
                    _jettag_c_when_113_6.doStart(context, out);
                    JET2Writer _jettag_c_when_113_6_saved_out = out;
                    while (_jettag_c_when_113_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" EditTextField ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 113, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_113_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_113_6_saved_out;
                    _jettag_c_when_113_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_115_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_115_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_115_6.setRuntimeParent(_jettag_c_choose_92_8);
                    _jettag_c_when_115_6.setTagInfo(_td_c_when_115_6);
                    _jettag_c_when_115_6.doStart(context, out);
                    JET2Writer _jettag_c_when_115_6_saved_out = out;
                    while (_jettag_c_when_115_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" EditTextField ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 115, 51)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_115_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_115_6_saved_out;
                    _jettag_c_when_115_6.doEnd();
                    _jettag_c_choose_92_8.handleBodyContent(out);
                }
                out = _jettag_c_choose_92_8_saved_out;
                _jettag_c_choose_92_8.doEnd();
                out.write(NL);         
                _jettag_c_iterate_91_4.handleBodyContent(out);
            }
            _jettag_c_iterate_91_4.doEnd();
            out.write("\t");  //$NON-NLS-1$        
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
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 125, 27)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_create);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcustomizeTitle();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcreate = (Button) findViewById(R.id.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 127, 39)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_create);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcreate.setOnClickListener(this);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tassignFields();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void customizeTitle(){");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tgetWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 133, 67)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_title_bar);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t     TextView mytitletext = (TextView) findViewById(R.id.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($projectName)}", 134, 59)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_title_text);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t     mytitletext.setText(\"Read ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 135, 33)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" Activity\");\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void assignFields() {");  //$NON-NLS-1$        
            out.write(NL);         
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_140_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_140_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_140_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_140_2.setTagInfo(_td_c_if_140_2);
            _jettag_c_if_140_2.doStart(context, out);
            while (_jettag_c_if_140_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_141_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_141_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_141_5.setRuntimeParent(_jettag_c_if_140_2);
                _jettag_c_iterate_141_5.setTagInfo(_td_c_iterate_141_5);
                _jettag_c_iterate_141_5.doStart(context, out);
                while (_jettag_c_iterate_141_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_142_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_142_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_142_5.setRuntimeParent(_jettag_c_iterate_141_5);
                    _jettag_c_choose_142_5.setTagInfo(_td_c_choose_142_5);
                    _jettag_c_choose_142_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_142_5_saved_out = out;
                    while (_jettag_c_choose_142_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_143_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_143_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_143_6.setRuntimeParent(_jettag_c_choose_142_5);
                        _jettag_c_when_143_6.setTagInfo(_td_c_when_143_6);
                        _jettag_c_when_143_6.doStart(context, out);
                        JET2Writer _jettag_c_when_143_6_saved_out = out;
                        while (_jettag_c_when_143_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 143, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 143, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 143, 132)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 144, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 144, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_143_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_143_6_saved_out;
                        _jettag_c_when_143_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_146_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_146_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_146_6.setRuntimeParent(_jettag_c_choose_142_5);
                        _jettag_c_when_146_6.setTagInfo(_td_c_when_146_6);
                        _jettag_c_when_146_6.doStart(context, out);
                        JET2Writer _jettag_c_when_146_6_saved_out = out;
                        while (_jettag_c_when_146_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 146, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 146, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 146, 133)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 147, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 147, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_146_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_146_6_saved_out;
                        _jettag_c_when_146_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_149_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_149_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_149_6.setRuntimeParent(_jettag_c_choose_142_5);
                        _jettag_c_when_149_6.setTagInfo(_td_c_when_149_6);
                        _jettag_c_when_149_6.doStart(context, out);
                        JET2Writer _jettag_c_when_149_6_saved_out = out;
                        while (_jettag_c_when_149_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 149, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B= (Button) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 149, 86)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 149, 121)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 150, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B.setOnClickListener(this);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_149_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_149_6_saved_out;
                        _jettag_c_when_149_6.doEnd();
                        RuntimeTagElement _jettag_c_when_152_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_152_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_152_6.setRuntimeParent(_jettag_c_choose_142_5);
                        _jettag_c_when_152_6.setTagInfo(_td_c_when_152_6);
                        _jettag_c_when_152_6.doStart(context, out);
                        JET2Writer _jettag_c_when_152_6_saved_out = out;
                        while (_jettag_c_when_152_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_152_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_152_6_saved_out;
                        _jettag_c_when_152_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_154_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_154_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_154_6.setRuntimeParent(_jettag_c_choose_142_5);
                        _jettag_c_when_154_6.setTagInfo(_td_c_when_154_6);
                        _jettag_c_when_154_6.doStart(context, out);
                        JET2Writer _jettag_c_when_154_6_saved_out = out;
                        while (_jettag_c_when_154_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 154, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 154, 94)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 154, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 155, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 155, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_154_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_154_6_saved_out;
                        _jettag_c_when_154_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_157_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_157_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_157_6.setRuntimeParent(_jettag_c_choose_142_5);
                        _jettag_c_when_157_6.setTagInfo(_td_c_when_157_6);
                        _jettag_c_when_157_6.doStart(context, out);
                        JET2Writer _jettag_c_when_157_6_saved_out = out;
                        while (_jettag_c_when_157_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 157, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 157, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 157, 131)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 158, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 158, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_157_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_157_6_saved_out;
                        _jettag_c_when_157_6.doEnd();
                        _jettag_c_choose_142_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_142_5_saved_out;
                    _jettag_c_choose_142_5.doEnd();
                    _jettag_c_iterate_141_5.handleBodyContent(out);
                }
                _jettag_c_iterate_141_5.doEnd();
                _jettag_c_if_140_2.handleBodyContent(out);
            }
            _jettag_c_if_140_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_164_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_164_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_164_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_164_2.setTagInfo(_td_c_if_164_2);
            _jettag_c_if_164_2.doStart(context, out);
            while (_jettag_c_if_164_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_165_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_165_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_165_5.setRuntimeParent(_jettag_c_if_164_2);
                _jettag_c_iterate_165_5.setTagInfo(_td_c_iterate_165_5);
                _jettag_c_iterate_165_5.doStart(context, out);
                while (_jettag_c_iterate_165_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_166_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_166_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_166_5.setRuntimeParent(_jettag_c_iterate_165_5);
                    _jettag_c_choose_166_5.setTagInfo(_td_c_choose_166_5);
                    _jettag_c_choose_166_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_166_5_saved_out = out;
                    while (_jettag_c_choose_166_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_167_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_167_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_167_6.setRuntimeParent(_jettag_c_choose_166_5);
                        _jettag_c_when_167_6.setTagInfo(_td_c_when_167_6);
                        _jettag_c_when_167_6.doStart(context, out);
                        JET2Writer _jettag_c_when_167_6_saved_out = out;
                        while (_jettag_c_when_167_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 167, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 167, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 167, 132)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 168, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 168, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_167_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_167_6_saved_out;
                        _jettag_c_when_167_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_170_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_170_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_170_6.setRuntimeParent(_jettag_c_choose_166_5);
                        _jettag_c_when_170_6.setTagInfo(_td_c_when_170_6);
                        _jettag_c_when_170_6.doStart(context, out);
                        JET2Writer _jettag_c_when_170_6_saved_out = out;
                        while (_jettag_c_when_170_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 170, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 170, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 170, 133)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 171, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 171, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_170_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_170_6_saved_out;
                        _jettag_c_when_170_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_173_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_173_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_173_6.setRuntimeParent(_jettag_c_choose_166_5);
                        _jettag_c_when_173_6.setTagInfo(_td_c_when_173_6);
                        _jettag_c_when_173_6.doStart(context, out);
                        JET2Writer _jettag_c_when_173_6_saved_out = out;
                        while (_jettag_c_when_173_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 173, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B= (Button) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 173, 86)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 173, 121)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 174, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B.setOnClickListener(this);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_173_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_173_6_saved_out;
                        _jettag_c_when_173_6.doEnd();
                        RuntimeTagElement _jettag_c_when_176_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_176_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_176_6.setRuntimeParent(_jettag_c_choose_166_5);
                        _jettag_c_when_176_6.setTagInfo(_td_c_when_176_6);
                        _jettag_c_when_176_6.doStart(context, out);
                        JET2Writer _jettag_c_when_176_6_saved_out = out;
                        while (_jettag_c_when_176_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_176_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_176_6_saved_out;
                        _jettag_c_when_176_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_178_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_178_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_178_6.setRuntimeParent(_jettag_c_choose_166_5);
                        _jettag_c_when_178_6.setTagInfo(_td_c_when_178_6);
                        _jettag_c_when_178_6.doStart(context, out);
                        JET2Writer _jettag_c_when_178_6_saved_out = out;
                        while (_jettag_c_when_178_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 178, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 178, 94)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 178, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 179, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 179, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_178_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_178_6_saved_out;
                        _jettag_c_when_178_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_181_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_181_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_181_6.setRuntimeParent(_jettag_c_choose_166_5);
                        _jettag_c_when_181_6.setTagInfo(_td_c_when_181_6);
                        _jettag_c_when_181_6.doStart(context, out);
                        JET2Writer _jettag_c_when_181_6_saved_out = out;
                        while (_jettag_c_when_181_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("  ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 181, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 181, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_create_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 181, 131)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 182, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 182, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_181_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_181_6_saved_out;
                        _jettag_c_when_181_6.doEnd();
                        _jettag_c_choose_166_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_166_5_saved_out;
                    _jettag_c_choose_166_5.doEnd();
                    _jettag_c_iterate_165_5.handleBodyContent(out);
                }
                _jettag_c_iterate_165_5.doEnd();
                _jettag_c_if_164_2.handleBodyContent(out);
            }
            _jettag_c_if_164_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_188_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_188_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_188_5.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_188_5.setTagInfo(_td_c_iterate_188_5);
            _jettag_c_iterate_188_5.doStart(context, out);
            while (_jettag_c_iterate_188_5.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_189_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_189_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_189_5.setRuntimeParent(_jettag_c_iterate_188_5);
                _jettag_c_choose_189_5.setTagInfo(_td_c_choose_189_5);
                _jettag_c_choose_189_5.doStart(context, out);
                JET2Writer _jettag_c_choose_189_5_saved_out = out;
                while (_jettag_c_choose_189_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_190_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_190_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_190_6.setRuntimeParent(_jettag_c_choose_189_5);
                    _jettag_c_when_190_6.setTagInfo(_td_c_when_190_6);
                    _jettag_c_when_190_6.doStart(context, out);
                    JET2Writer _jettag_c_when_190_6_saved_out = out;
                    while (_jettag_c_when_190_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("  ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 190, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 190, 97)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 190, 132)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(");");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 191, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 191, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\");");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_190_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_190_6_saved_out;
                    _jettag_c_when_190_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_193_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_193_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_193_6.setRuntimeParent(_jettag_c_choose_189_5);
                    _jettag_c_when_193_6.setTagInfo(_td_c_when_193_6);
                    _jettag_c_when_193_6.doStart(context, out);
                    JET2Writer _jettag_c_when_193_6_saved_out = out;
                    while (_jettag_c_when_193_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("  ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 193, 40)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 193, 98)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 193, 133)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(");");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 194, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 194, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\");");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_193_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_193_6_saved_out;
                    _jettag_c_when_193_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_196_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_196_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_196_6.setRuntimeParent(_jettag_c_choose_189_5);
                    _jettag_c_when_196_6.setTagInfo(_td_c_when_196_6);
                    _jettag_c_when_196_6.doStart(context, out);
                    JET2Writer _jettag_c_when_196_6_saved_out = out;
                    while (_jettag_c_when_196_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("  ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 196, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("B= (Button) findViewById(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 196, 86)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 196, 121)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(");");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 197, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("B.setOnClickListener(this);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_196_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_196_6_saved_out;
                    _jettag_c_when_196_6.doEnd();
                    RuntimeTagElement _jettag_c_when_199_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_199_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_199_6.setRuntimeParent(_jettag_c_choose_189_5);
                    _jettag_c_when_199_6.setTagInfo(_td_c_when_199_6);
                    _jettag_c_when_199_6.doStart(context, out);
                    JET2Writer _jettag_c_when_199_6_saved_out = out;
                    while (_jettag_c_when_199_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_199_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_199_6_saved_out;
                    _jettag_c_when_199_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_201_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_201_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_201_6.setRuntimeParent(_jettag_c_choose_189_5);
                    _jettag_c_when_201_6.setTagInfo(_td_c_when_201_6);
                    _jettag_c_when_201_6.doStart(context, out);
                    JET2Writer _jettag_c_when_201_6_saved_out = out;
                    while (_jettag_c_when_201_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 201, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 201, 94)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 201, 129)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(");");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 202, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 202, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\");");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_201_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_201_6_saved_out;
                    _jettag_c_when_201_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_204_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_204_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_204_6.setRuntimeParent(_jettag_c_choose_189_5);
                    _jettag_c_when_204_6.setTagInfo(_td_c_when_204_6);
                    _jettag_c_when_204_6.doStart(context, out);
                    JET2Writer _jettag_c_when_204_6_saved_out = out;
                    while (_jettag_c_when_204_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("  ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 204, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF = (EditTextField) findViewById(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 204, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_create_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 204, 131)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(");");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 205, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.setLabel(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 205, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\");");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_204_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_204_6_saved_out;
                    _jettag_c_when_204_6.doEnd();
                    _jettag_c_choose_189_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_189_5_saved_out;
                _jettag_c_choose_189_5.doEnd();
                _jettag_c_iterate_188_5.handleBodyContent(out);
            }
            _jettag_c_iterate_188_5.doEnd();
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic void onClick(View arg0) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tif (arg0 == create) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tcreate.setEnabled(false);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 215, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 215, 19)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\tif (getIntent().getSerializableExtra(\"entity\") != null) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 217, 5)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" = (");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 217, 36)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(") getIntent().getSerializableExtra(\"entity\");");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t} else {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 219, 5)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" = new ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 219, 39)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_222_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_222_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_222_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_222_2.setTagInfo(_td_c_if_222_2);
            _jettag_c_if_222_2.doStart(context, out);
            while (_jettag_c_if_222_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_223_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_223_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_223_5.setRuntimeParent(_jettag_c_if_222_2);
                _jettag_c_iterate_223_5.setTagInfo(_td_c_iterate_223_5);
                _jettag_c_iterate_223_5.doStart(context, out);
                while (_jettag_c_iterate_223_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_224_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_224_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_224_5.setRuntimeParent(_jettag_c_iterate_223_5);
                    _jettag_c_choose_224_5.setTagInfo(_td_c_choose_224_5);
                    _jettag_c_choose_224_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_224_5_saved_out = out;
                    while (_jettag_c_choose_224_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_225_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_225_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_225_6.setRuntimeParent(_jettag_c_choose_224_5);
                        _jettag_c_when_225_6.setTagInfo(_td_c_when_225_6);
                        _jettag_c_when_225_6.doStart(context, out);
                        JET2Writer _jettag_c_when_225_6_saved_out = out;
                        while (_jettag_c_when_225_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 225, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 225, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 225, 105)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.getValue());");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_225_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_225_6_saved_out;
                        _jettag_c_when_225_6.doEnd();
                        RuntimeTagElement _jettag_c_when_227_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_227_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_227_6.setRuntimeParent(_jettag_c_choose_224_5);
                        _jettag_c_when_227_6.setTagInfo(_td_c_when_227_6);
                        _jettag_c_when_227_6.doStart(context, out);
                        JET2Writer _jettag_c_when_227_6_saved_out = out;
                        while (_jettag_c_when_227_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_227_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_227_6_saved_out;
                        _jettag_c_when_227_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_229_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_229_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_229_6.setRuntimeParent(_jettag_c_choose_224_5);
                        _jettag_c_when_229_6.setTagInfo(_td_c_when_229_6);
                        _jettag_c_when_229_6.doStart(context, out);
                        JET2Writer _jettag_c_when_229_6_saved_out = out;
                        while (_jettag_c_when_229_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 229, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 229, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 229, 103)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_229_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_229_6_saved_out;
                        _jettag_c_when_229_6.doEnd();
                        RuntimeTagElement _jettag_c_when_231_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_231_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_231_6.setRuntimeParent(_jettag_c_choose_224_5);
                        _jettag_c_when_231_6.setTagInfo(_td_c_when_231_6);
                        _jettag_c_when_231_6.doStart(context, out);
                        JET2Writer _jettag_c_when_231_6_saved_out = out;
                        while (_jettag_c_when_231_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_231_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_231_6_saved_out;
                        _jettag_c_when_231_6.doEnd();
                        RuntimeTagElement _jettag_c_when_233_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_233_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_233_6.setRuntimeParent(_jettag_c_choose_224_5);
                        _jettag_c_when_233_6.setTagInfo(_td_c_when_233_6);
                        _jettag_c_when_233_6.doStart(context, out);
                        JET2Writer _jettag_c_when_233_6_saved_out = out;
                        while (_jettag_c_when_233_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_233_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_233_6_saved_out;
                        _jettag_c_when_233_6.doEnd();
                        RuntimeTagElement _jettag_c_when_235_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_235_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_235_6.setRuntimeParent(_jettag_c_choose_224_5);
                        _jettag_c_when_235_6.setTagInfo(_td_c_when_235_6);
                        _jettag_c_when_235_6.doStart(context, out);
                        JET2Writer _jettag_c_when_235_6_saved_out = out;
                        while (_jettag_c_when_235_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_235_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_235_6_saved_out;
                        _jettag_c_when_235_6.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_237_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_237_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_237_7.setRuntimeParent(_jettag_c_choose_224_5);
                        _jettag_c_otherwise_237_7.setTagInfo(_td_c_otherwise_237_7);
                        _jettag_c_otherwise_237_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_237_7_saved_out = out;
                        while (_jettag_c_otherwise_237_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_otherwise_237_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_237_7_saved_out;
                        _jettag_c_otherwise_237_7.doEnd();
                        _jettag_c_choose_224_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_224_5_saved_out;
                    _jettag_c_choose_224_5.doEnd();
                    _jettag_c_iterate_223_5.handleBodyContent(out);
                }
                _jettag_c_iterate_223_5.doEnd();
                _jettag_c_if_222_2.handleBodyContent(out);
            }
            _jettag_c_if_222_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_243_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_243_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_243_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_243_2.setTagInfo(_td_c_if_243_2);
            _jettag_c_if_243_2.doStart(context, out);
            while (_jettag_c_if_243_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_244_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_244_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_244_5.setRuntimeParent(_jettag_c_if_243_2);
                _jettag_c_iterate_244_5.setTagInfo(_td_c_iterate_244_5);
                _jettag_c_iterate_244_5.doStart(context, out);
                while (_jettag_c_iterate_244_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_245_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_245_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_245_5.setRuntimeParent(_jettag_c_iterate_244_5);
                    _jettag_c_choose_245_5.setTagInfo(_td_c_choose_245_5);
                    _jettag_c_choose_245_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_245_5_saved_out = out;
                    while (_jettag_c_choose_245_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_246_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_246_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_246_6.setRuntimeParent(_jettag_c_choose_245_5);
                        _jettag_c_when_246_6.setTagInfo(_td_c_when_246_6);
                        _jettag_c_when_246_6.doStart(context, out);
                        JET2Writer _jettag_c_when_246_6_saved_out = out;
                        while (_jettag_c_when_246_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 246, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 246, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 246, 105)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("TF.getValue());");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_246_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_246_6_saved_out;
                        _jettag_c_when_246_6.doEnd();
                        RuntimeTagElement _jettag_c_when_248_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_248_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_248_6.setRuntimeParent(_jettag_c_choose_245_5);
                        _jettag_c_when_248_6.setTagInfo(_td_c_when_248_6);
                        _jettag_c_when_248_6.doStart(context, out);
                        JET2Writer _jettag_c_when_248_6_saved_out = out;
                        while (_jettag_c_when_248_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_248_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_248_6_saved_out;
                        _jettag_c_when_248_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_250_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_250_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_250_6.setRuntimeParent(_jettag_c_choose_245_5);
                        _jettag_c_when_250_6.setTagInfo(_td_c_when_250_6);
                        _jettag_c_when_250_6.doStart(context, out);
                        JET2Writer _jettag_c_when_250_6_saved_out = out;
                        while (_jettag_c_when_250_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("    ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 250, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 250, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 250, 106)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(");");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_250_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_250_6_saved_out;
                        _jettag_c_when_250_6.doEnd();
                        RuntimeTagElement _jettag_c_when_252_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_252_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_252_6.setRuntimeParent(_jettag_c_choose_245_5);
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
                        _jettag_c_when_254_6.setRuntimeParent(_jettag_c_choose_245_5);
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
                        _jettag_c_when_256_6.setRuntimeParent(_jettag_c_choose_245_5);
                        _jettag_c_when_256_6.setTagInfo(_td_c_when_256_6);
                        _jettag_c_when_256_6.doStart(context, out);
                        JET2Writer _jettag_c_when_256_6_saved_out = out;
                        while (_jettag_c_when_256_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_when_256_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_256_6_saved_out;
                        _jettag_c_when_256_6.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_258_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_258_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_258_7.setRuntimeParent(_jettag_c_choose_245_5);
                        _jettag_c_otherwise_258_7.setTagInfo(_td_c_otherwise_258_7);
                        _jettag_c_otherwise_258_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_258_7_saved_out = out;
                        while (_jettag_c_otherwise_258_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_otherwise_258_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_258_7_saved_out;
                        _jettag_c_otherwise_258_7.doEnd();
                        _jettag_c_choose_245_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_245_5_saved_out;
                    _jettag_c_choose_245_5.doEnd();
                    _jettag_c_iterate_244_5.handleBodyContent(out);
                }
                _jettag_c_iterate_244_5.doEnd();
                _jettag_c_if_243_2.handleBodyContent(out);
            }
            _jettag_c_if_243_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_264_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_264_4); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_264_4.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_264_4.setTagInfo(_td_c_iterate_264_4);
            _jettag_c_iterate_264_4.doStart(context, out);
            while (_jettag_c_iterate_264_4.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_265_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_265_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_265_5.setRuntimeParent(_jettag_c_iterate_264_4);
                _jettag_c_choose_265_5.setTagInfo(_td_c_choose_265_5);
                _jettag_c_choose_265_5.doStart(context, out);
                JET2Writer _jettag_c_choose_265_5_saved_out = out;
                while (_jettag_c_choose_265_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_266_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_266_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_266_6.setRuntimeParent(_jettag_c_choose_265_5);
                    _jettag_c_when_266_6.setTagInfo(_td_c_when_266_6);
                    _jettag_c_when_266_6.doStart(context, out);
                    JET2Writer _jettag_c_when_266_6_saved_out = out;
                    while (_jettag_c_when_266_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 266, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".set");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 266, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("(");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 266, 105)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.getValue());");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_266_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_266_6_saved_out;
                    _jettag_c_when_266_6.doEnd();
                    RuntimeTagElement _jettag_c_when_268_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_268_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_268_6.setRuntimeParent(_jettag_c_choose_265_5);
                    _jettag_c_when_268_6.setTagInfo(_td_c_when_268_6);
                    _jettag_c_when_268_6.doStart(context, out);
                    JET2Writer _jettag_c_when_268_6_saved_out = out;
                    while (_jettag_c_when_268_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_268_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_268_6_saved_out;
                    _jettag_c_when_268_6.doEnd();
                    out.write("\t\t\t\t ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_270_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_270_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_270_6.setRuntimeParent(_jettag_c_choose_265_5);
                    _jettag_c_when_270_6.setTagInfo(_td_c_when_270_6);
                    _jettag_c_when_270_6.doStart(context, out);
                    JET2Writer _jettag_c_when_270_6_saved_out = out;
                    while (_jettag_c_when_270_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("  ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 270, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".set");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${uppercaseFirst($attribute/@name)}", 270, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("(");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 270, 104)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(");");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_270_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_270_6_saved_out;
                    _jettag_c_when_270_6.doEnd();
                    RuntimeTagElement _jettag_c_when_272_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_272_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_272_6.setRuntimeParent(_jettag_c_choose_265_5);
                    _jettag_c_when_272_6.setTagInfo(_td_c_when_272_6);
                    _jettag_c_when_272_6.doStart(context, out);
                    JET2Writer _jettag_c_when_272_6_saved_out = out;
                    while (_jettag_c_when_272_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_272_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_272_6_saved_out;
                    _jettag_c_when_272_6.doEnd();
                    RuntimeTagElement _jettag_c_when_274_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_274_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_274_6.setRuntimeParent(_jettag_c_choose_265_5);
                    _jettag_c_when_274_6.setTagInfo(_td_c_when_274_6);
                    _jettag_c_when_274_6.doStart(context, out);
                    JET2Writer _jettag_c_when_274_6_saved_out = out;
                    while (_jettag_c_when_274_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_274_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_274_6_saved_out;
                    _jettag_c_when_274_6.doEnd();
                    RuntimeTagElement _jettag_c_when_276_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_276_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_276_6.setRuntimeParent(_jettag_c_choose_265_5);
                    _jettag_c_when_276_6.setTagInfo(_td_c_when_276_6);
                    _jettag_c_when_276_6.doStart(context, out);
                    JET2Writer _jettag_c_when_276_6_saved_out = out;
                    while (_jettag_c_when_276_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_276_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_276_6_saved_out;
                    _jettag_c_when_276_6.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_278_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_278_7); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_278_7.setRuntimeParent(_jettag_c_choose_265_5);
                    _jettag_c_otherwise_278_7.setTagInfo(_td_c_otherwise_278_7);
                    _jettag_c_otherwise_278_7.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_278_7_saved_out = out;
                    while (_jettag_c_otherwise_278_7.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_otherwise_278_7.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_278_7_saved_out;
                    _jettag_c_otherwise_278_7.doEnd();
                    _jettag_c_choose_265_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_265_5_saved_out;
                _jettag_c_choose_265_5.doEnd();
                _jettag_c_iterate_264_4.handleBodyContent(out);
            }
            _jettag_c_iterate_264_4.doEnd();
            out.write("\t\t\tnew AsyncHttpPut(this) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\tprotected void onResponse(String result) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\tToast");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\t\t.makeText(Create");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 286, 24)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".this, \"created\",");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\t\t\t\t\tToast.LENGTH_LONG);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t\t\tfinish();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t\t\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t\t}.execute(getCreateURL(), HttpHelper.xstream.toXML(");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 291, 55)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_294_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_294_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_294_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_294_2.setTagInfo(_td_c_if_294_2);
            _jettag_c_if_294_2.doStart(context, out);
            while (_jettag_c_if_294_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_295_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_295_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_295_5.setRuntimeParent(_jettag_c_if_294_2);
                _jettag_c_iterate_295_5.setTagInfo(_td_c_iterate_295_5);
                _jettag_c_iterate_295_5.doStart(context, out);
                while (_jettag_c_iterate_295_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_296_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_296_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_296_5.setRuntimeParent(_jettag_c_iterate_295_5);
                    _jettag_c_choose_296_5.setTagInfo(_td_c_choose_296_5);
                    _jettag_c_choose_296_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_296_5_saved_out = out;
                    while (_jettag_c_choose_296_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_297_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_297_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_297_6.setRuntimeParent(_jettag_c_choose_296_5);
                        _jettag_c_when_297_6.setTagInfo(_td_c_when_297_6);
                        _jettag_c_when_297_6.doStart(context, out);
                        JET2Writer _jettag_c_when_297_6_saved_out = out;
                        while (_jettag_c_when_297_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t if (arg0 == ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 298, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B) {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\tshowDialog(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 299, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_ID);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t}");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_297_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_297_6_saved_out;
                        _jettag_c_when_297_6.doEnd();
                        _jettag_c_choose_296_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_296_5_saved_out;
                    _jettag_c_choose_296_5.doEnd();
                    _jettag_c_iterate_295_5.handleBodyContent(out);
                }
                _jettag_c_iterate_295_5.doEnd();
                _jettag_c_if_294_2.handleBodyContent(out);
            }
            _jettag_c_if_294_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_306_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_306_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_306_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_306_2.setTagInfo(_td_c_if_306_2);
            _jettag_c_if_306_2.doStart(context, out);
            while (_jettag_c_if_306_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_307_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_307_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_307_5.setRuntimeParent(_jettag_c_if_306_2);
                _jettag_c_iterate_307_5.setTagInfo(_td_c_iterate_307_5);
                _jettag_c_iterate_307_5.doStart(context, out);
                while (_jettag_c_iterate_307_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_308_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_308_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_308_5.setRuntimeParent(_jettag_c_iterate_307_5);
                    _jettag_c_choose_308_5.setTagInfo(_td_c_choose_308_5);
                    _jettag_c_choose_308_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_308_5_saved_out = out;
                    while (_jettag_c_choose_308_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_309_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_309_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_309_6.setRuntimeParent(_jettag_c_choose_308_5);
                        _jettag_c_when_309_6.setTagInfo(_td_c_when_309_6);
                        _jettag_c_when_309_6.doStart(context, out);
                        JET2Writer _jettag_c_when_309_6_saved_out = out;
                        while (_jettag_c_when_309_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t if (arg0 == ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 310, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("B) {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\tshowDialog(");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 311, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_ID);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t} ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_309_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_309_6_saved_out;
                        _jettag_c_when_309_6.doEnd();
                        _jettag_c_choose_308_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_308_5_saved_out;
                    _jettag_c_choose_308_5.doEnd();
                    _jettag_c_iterate_307_5.handleBodyContent(out);
                }
                _jettag_c_iterate_307_5.doEnd();
                _jettag_c_if_306_2.handleBodyContent(out);
            }
            _jettag_c_if_306_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_318_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_318_4); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_318_4.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_318_4.setTagInfo(_td_c_iterate_318_4);
            _jettag_c_iterate_318_4.doStart(context, out);
            while (_jettag_c_iterate_318_4.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_319_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_319_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_319_5.setRuntimeParent(_jettag_c_iterate_318_4);
                _jettag_c_choose_319_5.setTagInfo(_td_c_choose_319_5);
                _jettag_c_choose_319_5.doStart(context, out);
                JET2Writer _jettag_c_choose_319_5_saved_out = out;
                while (_jettag_c_choose_319_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_320_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_320_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_320_6.setRuntimeParent(_jettag_c_choose_319_5);
                    _jettag_c_when_320_6.setTagInfo(_td_c_when_320_6);
                    _jettag_c_when_320_6.doStart(context, out);
                    JET2Writer _jettag_c_when_320_6_saved_out = out;
                    while (_jettag_c_when_320_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t if (arg0 == ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 321, 18)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("B) {");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\tshowDialog(");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 322, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_ID);");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t}");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_320_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_320_6_saved_out;
                    _jettag_c_when_320_6.doEnd();
                    _jettag_c_choose_319_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_319_5_saved_out;
                _jettag_c_choose_319_5.doEnd();
                _jettag_c_iterate_318_4.handleBodyContent(out);
            }
            _jettag_c_iterate_318_4.doEnd();
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected Dialog onCreateDialog(int id) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tCalendar c = Calendar.getInstance();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tint cyear = c.get(Calendar.YEAR);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tint cmonth = c.get(Calendar.MONTH);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tint cday = c.get(Calendar.DAY_OF_MONTH);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tswitch (id) {");  //$NON-NLS-1$        
            out.write(NL);         
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_337_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_337_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_337_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_337_2.setTagInfo(_td_c_if_337_2);
            _jettag_c_if_337_2.doStart(context, out);
            while (_jettag_c_if_337_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_338_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_338_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_338_5.setRuntimeParent(_jettag_c_if_337_2);
                _jettag_c_iterate_338_5.setTagInfo(_td_c_iterate_338_5);
                _jettag_c_iterate_338_5.doStart(context, out);
                while (_jettag_c_iterate_338_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_339_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_339_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_339_5.setRuntimeParent(_jettag_c_iterate_338_5);
                    _jettag_c_choose_339_5.setTagInfo(_td_c_choose_339_5);
                    _jettag_c_choose_339_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_339_5_saved_out = out;
                    while (_jettag_c_choose_339_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_340_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_340_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_340_6.setRuntimeParent(_jettag_c_choose_339_5);
                        _jettag_c_when_340_6.setTagInfo(_td_c_when_340_6);
                        _jettag_c_when_340_6.doStart(context, out);
                        JET2Writer _jettag_c_when_340_6_saved_out = out;
                        while (_jettag_c_when_340_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\tcase ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 341, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_ID:");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\treturn new DatePickerDialog(this, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 342, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("DateSetListener, cyear, cmonth,");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\tcday);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_340_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_340_6_saved_out;
                        _jettag_c_when_340_6.doEnd();
                        _jettag_c_choose_339_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_339_5_saved_out;
                    _jettag_c_choose_339_5.doEnd();
                    _jettag_c_iterate_338_5.handleBodyContent(out);
                }
                _jettag_c_iterate_338_5.doEnd();
                _jettag_c_if_337_2.handleBodyContent(out);
            }
            _jettag_c_if_337_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_349_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_349_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_349_2.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_if_349_2.setTagInfo(_td_c_if_349_2);
            _jettag_c_if_349_2.doStart(context, out);
            while (_jettag_c_if_349_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_350_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_350_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_350_5.setRuntimeParent(_jettag_c_if_349_2);
                _jettag_c_iterate_350_5.setTagInfo(_td_c_iterate_350_5);
                _jettag_c_iterate_350_5.doStart(context, out);
                while (_jettag_c_iterate_350_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_351_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_351_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_351_5.setRuntimeParent(_jettag_c_iterate_350_5);
                    _jettag_c_choose_351_5.setTagInfo(_td_c_choose_351_5);
                    _jettag_c_choose_351_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_351_5_saved_out = out;
                    while (_jettag_c_choose_351_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_352_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_352_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_352_6.setRuntimeParent(_jettag_c_choose_351_5);
                        _jettag_c_when_352_6.setTagInfo(_td_c_when_352_6);
                        _jettag_c_when_352_6.doStart(context, out);
                        JET2Writer _jettag_c_when_352_6_saved_out = out;
                        while (_jettag_c_when_352_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\tcase ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 353, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_ID:");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\treturn new DatePickerDialog(this, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 354, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("DateSetListener, cyear, cmonth,");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\tcday);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_352_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_352_6_saved_out;
                        _jettag_c_when_352_6.doEnd();
                        _jettag_c_choose_351_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_351_5_saved_out;
                    _jettag_c_choose_351_5.doEnd();
                    _jettag_c_iterate_350_5.handleBodyContent(out);
                }
                _jettag_c_iterate_350_5.doEnd();
                _jettag_c_if_349_2.handleBodyContent(out);
            }
            _jettag_c_if_349_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_361_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_361_4); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_361_4.setRuntimeParent(_jettag_java_format_1_1);
            _jettag_c_iterate_361_4.setTagInfo(_td_c_iterate_361_4);
            _jettag_c_iterate_361_4.doStart(context, out);
            while (_jettag_c_iterate_361_4.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_362_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_362_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_362_5.setRuntimeParent(_jettag_c_iterate_361_4);
                _jettag_c_choose_362_5.setTagInfo(_td_c_choose_362_5);
                _jettag_c_choose_362_5.doStart(context, out);
                JET2Writer _jettag_c_choose_362_5_saved_out = out;
                while (_jettag_c_choose_362_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_363_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_363_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_363_6.setRuntimeParent(_jettag_c_choose_362_5);
                    _jettag_c_when_363_6.setTagInfo(_td_c_when_363_6);
                    _jettag_c_when_363_6.doStart(context, out);
                    JET2Writer _jettag_c_when_363_6_saved_out = out;
                    while (_jettag_c_when_363_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\tcase ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 364, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_ID:");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\treturn new DatePickerDialog(this, ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 365, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("DateSetListener, cyear, cmonth,");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\tcday);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_363_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_363_6_saved_out;
                    _jettag_c_when_363_6.doEnd();
                    _jettag_c_choose_362_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_362_5_saved_out;
                _jettag_c_choose_362_5.doEnd();
                _jettag_c_iterate_361_4.handleBodyContent(out);
            }
            _jettag_c_iterate_361_4.doEnd();
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn null;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic String getCreateURL() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 375, 10)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Main.baseURL + \"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 375, 52)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("/create\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_1_1.handleBodyContent(out);
        }
        out = _jettag_java_format_1_1_saved_out;
        _jettag_java_format_1_1.doEnd();
    }
}
