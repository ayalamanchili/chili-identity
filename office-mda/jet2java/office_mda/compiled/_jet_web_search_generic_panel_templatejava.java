package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_web_search_generic_panel_templatejava implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_f = "org.eclipse.jet.formatTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_web_search_generic_panel_templatejava() {
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
    private static final TagInfo _td_f_message_17_1 = new TagInfo("f:message", //$NON-NLS-1$
            17, 1,
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
    private static final TagInfo _td_f_message_32_1 = new TagInfo("f:message", //$NON-NLS-1$
            32, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_38_1 = new TagInfo("f:message", //$NON-NLS-1$
            38, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_44_1 = new TagInfo("f:message", //$NON-NLS-1$
            44, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_48_2 = new TagInfo("c:if", //$NON-NLS-1$
            48, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_49_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            49, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_50_5 = new TagInfo("c:choose", //$NON-NLS-1$
            50, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_51_6 = new TagInfo("c:when", //$NON-NLS-1$
            51, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_53_6 = new TagInfo("c:when", //$NON-NLS-1$
            53, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_55_6 = new TagInfo("c:when", //$NON-NLS-1$
            55, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_57_6 = new TagInfo("c:when", //$NON-NLS-1$
            57, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_59_6 = new TagInfo("c:when", //$NON-NLS-1$
            59, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_61_6 = new TagInfo("c:when", //$NON-NLS-1$
            61, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_63_6 = new TagInfo("c:when", //$NON-NLS-1$
            63, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_65_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            65, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_71_2 = new TagInfo("c:if", //$NON-NLS-1$
            71, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_72_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            72, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_73_5 = new TagInfo("c:choose", //$NON-NLS-1$
            73, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_74_6 = new TagInfo("c:when", //$NON-NLS-1$
            74, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_76_6 = new TagInfo("c:when", //$NON-NLS-1$
            76, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_78_6 = new TagInfo("c:when", //$NON-NLS-1$
            78, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_80_6 = new TagInfo("c:when", //$NON-NLS-1$
            80, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_82_6 = new TagInfo("c:when", //$NON-NLS-1$
            82, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_84_6 = new TagInfo("c:when", //$NON-NLS-1$
            84, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_86_6 = new TagInfo("c:when", //$NON-NLS-1$
            86, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_88_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            88, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_94_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            94, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_95_5 = new TagInfo("c:choose", //$NON-NLS-1$
            95, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_96_6 = new TagInfo("c:when", //$NON-NLS-1$
            96, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_98_6 = new TagInfo("c:when", //$NON-NLS-1$
            98, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_100_6 = new TagInfo("c:when", //$NON-NLS-1$
            100, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_102_6 = new TagInfo("c:when", //$NON-NLS-1$
            102, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_104_6 = new TagInfo("c:when", //$NON-NLS-1$
            104, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_106_6 = new TagInfo("c:when", //$NON-NLS-1$
            106, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_108_6 = new TagInfo("c:when", //$NON-NLS-1$
            108, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_110_7 = new TagInfo("c:otherwise", //$NON-NLS-1$
            110, 7,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_116_4 = new TagInfo("c:if", //$NON-NLS-1$
            116, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_117_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            117, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_118_5 = new TagInfo("c:if", //$NON-NLS-1$
            118, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href = $StringID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_133_4 = new TagInfo("c:if", //$NON-NLS-1$
            133, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_134_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            134, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_135_5 = new TagInfo("c:if", //$NON-NLS-1$
            135, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href = $StringID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_149_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            149, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_150_5 = new TagInfo("c:if", //$NON-NLS-1$
            150, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href = $StringID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_f_message_164_1 = new TagInfo("f:message", //$NON-NLS-1$
            164, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_169_1 = new TagInfo("f:message", //$NON-NLS-1$
            169, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_177_1 = new TagInfo("f:message", //$NON-NLS-1$
            177, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_182_2 = new TagInfo("c:if", //$NON-NLS-1$
            182, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_183_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            183, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_184_4 = new TagInfo("c:choose", //$NON-NLS-1$
            184, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_185_5 = new TagInfo("c:when", //$NON-NLS-1$
            185, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_187_5 = new TagInfo("c:when", //$NON-NLS-1$
            187, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_189_5 = new TagInfo("c:when", //$NON-NLS-1$
            189, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_191_5 = new TagInfo("c:when", //$NON-NLS-1$
            191, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_193_5 = new TagInfo("c:when", //$NON-NLS-1$
            193, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_195_5 = new TagInfo("c:when", //$NON-NLS-1$
            195, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_197_5 = new TagInfo("c:when", //$NON-NLS-1$
            197, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_199_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            199, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_205_2 = new TagInfo("c:if", //$NON-NLS-1$
            205, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_206_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            206, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_207_4 = new TagInfo("c:choose", //$NON-NLS-1$
            207, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_208_5 = new TagInfo("c:when", //$NON-NLS-1$
            208, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_210_5 = new TagInfo("c:when", //$NON-NLS-1$
            210, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_212_5 = new TagInfo("c:when", //$NON-NLS-1$
            212, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_214_5 = new TagInfo("c:when", //$NON-NLS-1$
            214, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_216_5 = new TagInfo("c:when", //$NON-NLS-1$
            216, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_218_5 = new TagInfo("c:when", //$NON-NLS-1$
            218, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_220_5 = new TagInfo("c:when", //$NON-NLS-1$
            220, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_222_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            222, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_227_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            227, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_228_4 = new TagInfo("c:choose", //$NON-NLS-1$
            228, 4,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_229_5 = new TagInfo("c:when", //$NON-NLS-1$
            229, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_231_5 = new TagInfo("c:when", //$NON-NLS-1$
            231, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_233_5 = new TagInfo("c:when", //$NON-NLS-1$
            233, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_235_5 = new TagInfo("c:when", //$NON-NLS-1$
            235, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_237_5 = new TagInfo("c:when", //$NON-NLS-1$
            237, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_239_5 = new TagInfo("c:when", //$NON-NLS-1$
            239, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_241_5 = new TagInfo("c:when", //$NON-NLS-1$
            241, 5,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_243_6 = new TagInfo("c:otherwise", //$NON-NLS-1$
            243, 6,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_f_message_249_1 = new TagInfo("f:message", //$NON-NLS-1$
            249, 1,
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
                out.write(NL);         
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
                out.write("import info.yalamanchili.gwt.composite.ReadAllCompositey.ReadAllTableType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.callback.ALAsyncCallback;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.composite.SearchPanelCompositeGeneric;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import com.google.gwt.user.client.ui.DockPanel;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import java.util.List;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.fields.DataType;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("import info.yalamanchili.gwt.widgets.ALSuggestBox;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_17_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_17_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_17_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_17_1.setTagInfo(_td_f_message_17_1);
                _jettag_f_message_17_1.doStart(context, out);
                JET2Writer _jettag_f_message_17_1_saved_out = out;
                while (_jettag_f_message_17_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.class.comment");  //$NON-NLS-1$        
                    _jettag_f_message_17_1.handleBodyContent(out);
                }
                out = _jettag_f_message_17_1_saved_out;
                _jettag_f_message_17_1.doEnd();
                out.write(NL);         
                out.write("public class ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 18, 14)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SearchPanelGeneric extends");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tSearchPanelCompositeGeneric<");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 19, 31)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("> {");  //$NON-NLS-1$        
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
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprivate static ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 21, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SearchPanelGeneric instance;");  //$NON-NLS-1$        
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
                out.write("\tpublic static ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 23, 16)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SearchPanelGeneric instance() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\treturn instance;");  //$NON-NLS-1$        
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
                out.write("\tpublic ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 27, 9)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("SearchPanelGeneric() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinstance = this;");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\tinitSearchPanelCompositeGeneric(\"");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 29, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("\",");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 30, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.constants);");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_32_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_32_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_32_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_32_1.setTagInfo(_td_f_message_32_1);
                _jettag_f_message_32_1.doStart(context, out);
                JET2Writer _jettag_f_message_32_1_saved_out = out;
                while (_jettag_f_message_32_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_32_1.handleBodyContent(out);
                }
                out = _jettag_f_message_32_1_saved_out;
                _jettag_f_message_32_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_38_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_38_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_38_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_38_1.setTagInfo(_td_f_message_38_1);
                _jettag_f_message_38_1.doStart(context, out);
                JET2Writer _jettag_f_message_38_1_saved_out = out;
                while (_jettag_f_message_38_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_38_1.handleBodyContent(out);
                }
                out = _jettag_f_message_38_1_saved_out;
                _jettag_f_message_38_1.doEnd();
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
                RuntimeTagElement _jettag_f_message_44_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_44_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_44_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_44_1.setTagInfo(_td_f_message_44_1);
                _jettag_f_message_44_1.doStart(context, out);
                JET2Writer _jettag_f_message_44_1_saved_out = out;
                while (_jettag_f_message_44_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_44_1.handleBodyContent(out);
                }
                out = _jettag_f_message_44_1_saved_out;
                _jettag_f_message_44_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void addWidgets() {");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_48_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_48_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_48_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_48_2.setTagInfo(_td_c_if_48_2);
                _jettag_c_if_48_2.doStart(context, out);
                while (_jettag_c_if_48_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_49_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_49_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_49_5.setRuntimeParent(_jettag_c_if_48_2);
                    _jettag_c_iterate_49_5.setTagInfo(_td_c_iterate_49_5);
                    _jettag_c_iterate_49_5.doStart(context, out);
                    while (_jettag_c_iterate_49_5.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_50_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_50_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_50_5.setRuntimeParent(_jettag_c_iterate_49_5);
                        _jettag_c_choose_50_5.setTagInfo(_td_c_choose_50_5);
                        _jettag_c_choose_50_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_50_5_saved_out = out;
                        while (_jettag_c_choose_50_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_51_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_51_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_51_6.setRuntimeParent(_jettag_c_choose_50_5);
                            _jettag_c_when_51_6.setTagInfo(_td_c_when_51_6);
                            _jettag_c_when_51_6.doStart(context, out);
                            JET2Writer _jettag_c_when_51_6_saved_out = out;
                            while (_jettag_c_when_51_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 51, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 51, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_51_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_51_6_saved_out;
                            _jettag_c_when_51_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_53_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_53_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_53_6.setRuntimeParent(_jettag_c_choose_50_5);
                            _jettag_c_when_53_6.setTagInfo(_td_c_when_53_6);
                            _jettag_c_when_53_6.doStart(context, out);
                            JET2Writer _jettag_c_when_53_6_saved_out = out;
                            while (_jettag_c_when_53_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 53, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 53, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_53_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_53_6_saved_out;
                            _jettag_c_when_53_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_55_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_55_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_55_6.setRuntimeParent(_jettag_c_choose_50_5);
                            _jettag_c_when_55_6.setTagInfo(_td_c_when_55_6);
                            _jettag_c_when_55_6.doStart(context, out);
                            JET2Writer _jettag_c_when_55_6_saved_out = out;
                            while (_jettag_c_when_55_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 55, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 55, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_55_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_55_6_saved_out;
                            _jettag_c_when_55_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_57_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_57_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_57_6.setRuntimeParent(_jettag_c_choose_50_5);
                            _jettag_c_when_57_6.setTagInfo(_td_c_when_57_6);
                            _jettag_c_when_57_6.doStart(context, out);
                            JET2Writer _jettag_c_when_57_6_saved_out = out;
                            while (_jettag_c_when_57_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 57, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 57, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_57_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_57_6_saved_out;
                            _jettag_c_when_57_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_59_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_59_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_59_6.setRuntimeParent(_jettag_c_choose_50_5);
                            _jettag_c_when_59_6.setTagInfo(_td_c_when_59_6);
                            _jettag_c_when_59_6.doStart(context, out);
                            JET2Writer _jettag_c_when_59_6_saved_out = out;
                            while (_jettag_c_when_59_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 59, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 59, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_59_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_59_6_saved_out;
                            _jettag_c_when_59_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_61_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_61_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_61_6.setRuntimeParent(_jettag_c_choose_50_5);
                            _jettag_c_when_61_6.setTagInfo(_td_c_when_61_6);
                            _jettag_c_when_61_6.doStart(context, out);
                            JET2Writer _jettag_c_when_61_6_saved_out = out;
                            while (_jettag_c_when_61_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 61, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 61, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_61_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_61_6_saved_out;
                            _jettag_c_when_61_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_63_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_63_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_63_6.setRuntimeParent(_jettag_c_choose_50_5);
                            _jettag_c_when_63_6.setTagInfo(_td_c_when_63_6);
                            _jettag_c_when_63_6.doStart(context, out);
                            JET2Writer _jettag_c_when_63_6_saved_out = out;
                            while (_jettag_c_when_63_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 63, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 63, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_63_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_63_6_saved_out;
                            _jettag_c_when_63_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_65_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_65_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_65_7.setRuntimeParent(_jettag_c_choose_50_5);
                            _jettag_c_otherwise_65_7.setTagInfo(_td_c_otherwise_65_7);
                            _jettag_c_otherwise_65_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_65_7_saved_out = out;
                            while (_jettag_c_otherwise_65_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                _jettag_c_otherwise_65_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_65_7_saved_out;
                            _jettag_c_otherwise_65_7.doEnd();
                            _jettag_c_choose_50_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_50_5_saved_out;
                        _jettag_c_choose_50_5.doEnd();
                        _jettag_c_iterate_49_5.handleBodyContent(out);
                    }
                    _jettag_c_iterate_49_5.doEnd();
                    _jettag_c_if_48_2.handleBodyContent(out);
                }
                _jettag_c_if_48_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_71_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_71_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_71_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_71_2.setTagInfo(_td_c_if_71_2);
                _jettag_c_if_71_2.doStart(context, out);
                while (_jettag_c_if_71_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_72_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_72_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_72_4.setRuntimeParent(_jettag_c_if_71_2);
                    _jettag_c_iterate_72_4.setTagInfo(_td_c_iterate_72_4);
                    _jettag_c_iterate_72_4.doStart(context, out);
                    while (_jettag_c_iterate_72_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_73_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_73_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_73_5.setRuntimeParent(_jettag_c_iterate_72_4);
                        _jettag_c_choose_73_5.setTagInfo(_td_c_choose_73_5);
                        _jettag_c_choose_73_5.doStart(context, out);
                        JET2Writer _jettag_c_choose_73_5_saved_out = out;
                        while (_jettag_c_choose_73_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_74_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_74_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_74_6.setRuntimeParent(_jettag_c_choose_73_5);
                            _jettag_c_when_74_6.setTagInfo(_td_c_when_74_6);
                            _jettag_c_when_74_6.doStart(context, out);
                            JET2Writer _jettag_c_when_74_6_saved_out = out;
                            while (_jettag_c_when_74_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 74, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 74, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_74_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_74_6_saved_out;
                            _jettag_c_when_74_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_76_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_76_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_76_6.setRuntimeParent(_jettag_c_choose_73_5);
                            _jettag_c_when_76_6.setTagInfo(_td_c_when_76_6);
                            _jettag_c_when_76_6.doStart(context, out);
                            JET2Writer _jettag_c_when_76_6_saved_out = out;
                            while (_jettag_c_when_76_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 76, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 76, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_76_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_76_6_saved_out;
                            _jettag_c_when_76_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_78_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_78_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_78_6.setRuntimeParent(_jettag_c_choose_73_5);
                            _jettag_c_when_78_6.setTagInfo(_td_c_when_78_6);
                            _jettag_c_when_78_6.doStart(context, out);
                            JET2Writer _jettag_c_when_78_6_saved_out = out;
                            while (_jettag_c_when_78_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 78, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 78, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_78_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_78_6_saved_out;
                            _jettag_c_when_78_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_80_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_80_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_80_6.setRuntimeParent(_jettag_c_choose_73_5);
                            _jettag_c_when_80_6.setTagInfo(_td_c_when_80_6);
                            _jettag_c_when_80_6.doStart(context, out);
                            JET2Writer _jettag_c_when_80_6_saved_out = out;
                            while (_jettag_c_when_80_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 80, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 80, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_80_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_80_6_saved_out;
                            _jettag_c_when_80_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_82_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_82_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_82_6.setRuntimeParent(_jettag_c_choose_73_5);
                            _jettag_c_when_82_6.setTagInfo(_td_c_when_82_6);
                            _jettag_c_when_82_6.doStart(context, out);
                            JET2Writer _jettag_c_when_82_6_saved_out = out;
                            while (_jettag_c_when_82_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 82, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 82, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_82_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_82_6_saved_out;
                            _jettag_c_when_82_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_84_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_84_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_84_6.setRuntimeParent(_jettag_c_choose_73_5);
                            _jettag_c_when_84_6.setTagInfo(_td_c_when_84_6);
                            _jettag_c_when_84_6.doStart(context, out);
                            JET2Writer _jettag_c_when_84_6_saved_out = out;
                            while (_jettag_c_when_84_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 84, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 84, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_84_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_84_6_saved_out;
                            _jettag_c_when_84_6.doEnd();
                            out.write("\t\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_86_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_86_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_86_6.setRuntimeParent(_jettag_c_choose_73_5);
                            _jettag_c_when_86_6.setTagInfo(_td_c_when_86_6);
                            _jettag_c_when_86_6.doStart(context, out);
                            JET2Writer _jettag_c_when_86_6_saved_out = out;
                            while (_jettag_c_when_86_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" addField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 86, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\", false, ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 86, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_86_6.handleBodyContent(out);
                            }
                            out = _jettag_c_when_86_6_saved_out;
                            _jettag_c_when_86_6.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_88_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_88_7); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_88_7.setRuntimeParent(_jettag_c_choose_73_5);
                            _jettag_c_otherwise_88_7.setTagInfo(_td_c_otherwise_88_7);
                            _jettag_c_otherwise_88_7.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_88_7_saved_out = out;
                            while (_jettag_c_otherwise_88_7.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                _jettag_c_otherwise_88_7.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_88_7_saved_out;
                            _jettag_c_otherwise_88_7.doEnd();
                            _jettag_c_choose_73_5.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_73_5_saved_out;
                        _jettag_c_choose_73_5.doEnd();
                        _jettag_c_iterate_72_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_72_4.doEnd();
                    _jettag_c_if_71_2.handleBodyContent(out);
                }
                _jettag_c_if_71_2.doEnd();
                // process base class attributes
                RuntimeTagElement _jettag_c_iterate_94_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_94_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_94_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_94_4.setTagInfo(_td_c_iterate_94_4);
                _jettag_c_iterate_94_4.doStart(context, out);
                while (_jettag_c_iterate_94_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_95_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_95_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_95_5.setRuntimeParent(_jettag_c_iterate_94_4);
                    _jettag_c_choose_95_5.setTagInfo(_td_c_choose_95_5);
                    _jettag_c_choose_95_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_95_5_saved_out = out;
                    while (_jettag_c_choose_95_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_96_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_96_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_96_6.setRuntimeParent(_jettag_c_choose_95_5);
                        _jettag_c_when_96_6.setTagInfo(_td_c_when_96_6);
                        _jettag_c_when_96_6.doStart(context, out);
                        JET2Writer _jettag_c_when_96_6_saved_out = out;
                        while (_jettag_c_when_96_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 96, 48)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 96, 77)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.STRING_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_96_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_96_6_saved_out;
                        _jettag_c_when_96_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_98_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_98_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_98_6.setRuntimeParent(_jettag_c_choose_95_5);
                        _jettag_c_when_98_6.setTagInfo(_td_c_when_98_6);
                        _jettag_c_when_98_6.doStart(context, out);
                        JET2Writer _jettag_c_when_98_6_saved_out = out;
                        while (_jettag_c_when_98_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 98, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 98, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.INTEGER_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_98_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_98_6_saved_out;
                        _jettag_c_when_98_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_100_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_100_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_100_6.setRuntimeParent(_jettag_c_choose_95_5);
                        _jettag_c_when_100_6.setTagInfo(_td_c_when_100_6);
                        _jettag_c_when_100_6.doStart(context, out);
                        JET2Writer _jettag_c_when_100_6_saved_out = out;
                        while (_jettag_c_when_100_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 100, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 100, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.DATE_FIELD);  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_100_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_100_6_saved_out;
                        _jettag_c_when_100_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_102_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_102_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_102_6.setRuntimeParent(_jettag_c_choose_95_5);
                        _jettag_c_when_102_6.setTagInfo(_td_c_when_102_6);
                        _jettag_c_when_102_6.doStart(context, out);
                        JET2Writer _jettag_c_when_102_6_saved_out = out;
                        while (_jettag_c_when_102_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 102, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 102, 78)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.BOOLEAN_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_102_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_102_6_saved_out;
                        _jettag_c_when_102_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_104_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_104_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_104_6.setRuntimeParent(_jettag_c_choose_95_5);
                        _jettag_c_when_104_6.setTagInfo(_td_c_when_104_6);
                        _jettag_c_when_104_6.doStart(context, out);
                        JET2Writer _jettag_c_when_104_6_saved_out = out;
                        while (_jettag_c_when_104_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 104, 46)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 104, 75)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.LONG_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_104_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_104_6_saved_out;
                        _jettag_c_when_104_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_106_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_106_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_106_6.setRuntimeParent(_jettag_c_choose_95_5);
                        _jettag_c_when_106_6.setTagInfo(_td_c_when_106_6);
                        _jettag_c_when_106_6.doStart(context, out);
                        JET2Writer _jettag_c_when_106_6_saved_out = out;
                        while (_jettag_c_when_106_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 106, 47)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 106, 76)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.FLOAT_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_106_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_106_6_saved_out;
                        _jettag_c_when_106_6.doEnd();
                        out.write("\t\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_108_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_108_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_108_6.setRuntimeParent(_jettag_c_choose_95_5);
                        _jettag_c_when_108_6.setTagInfo(_td_c_when_108_6);
                        _jettag_c_when_108_6.doStart(context, out);
                        JET2Writer _jettag_c_when_108_6_saved_out = out;
                        while (_jettag_c_when_108_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" addField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 108, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", false, ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@isRequired}", 108, 79)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", DataType.CURRENCY_FIELD); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_108_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_108_6_saved_out;
                        _jettag_c_when_108_6.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_110_7 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_110_7); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_110_7.setRuntimeParent(_jettag_c_choose_95_5);
                        _jettag_c_otherwise_110_7.setTagInfo(_td_c_otherwise_110_7);
                        _jettag_c_otherwise_110_7.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_110_7_saved_out = out;
                        while (_jettag_c_otherwise_110_7.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_otherwise_110_7.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_110_7_saved_out;
                        _jettag_c_otherwise_110_7.doEnd();
                        _jettag_c_choose_95_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_95_5_saved_out;
                    _jettag_c_choose_95_5.doEnd();
                    _jettag_c_iterate_94_4.handleBodyContent(out);
                }
                _jettag_c_iterate_94_4.doEnd();
                out.write("\t\t\t");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_116_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_116_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_116_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_116_4.setTagInfo(_td_c_if_116_4);
                _jettag_c_if_116_4.doStart(context, out);
                while (_jettag_c_if_116_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_117_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_117_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_117_4.setRuntimeParent(_jettag_c_if_116_4);
                    _jettag_c_iterate_117_4.setTagInfo(_td_c_iterate_117_4);
                    _jettag_c_iterate_117_4.doStart(context, out);
                    while (_jettag_c_iterate_117_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_118_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_118_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_118_5.setRuntimeParent(_jettag_c_iterate_117_4);
                        _jettag_c_if_118_5.setTagInfo(_td_c_if_118_5);
                        _jettag_c_if_118_5.doStart(context, out);
                        while (_jettag_c_if_118_5.okToProcessBody()) {
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$packageName}", 119, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 119, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$class/@name}", 119, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("Service.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$class/@name}", 119, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("ServiceAsync.instance().getSuggestionsForName(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 119, 134)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\tnew ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$class/@name}", 120, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(), new ALAsyncCallback<List<String>>() {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write(NL);         
                            out.write("\t\t\t\t\t@Override");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\tpublic void onResponse(List<String> values) {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\taddSuggestBox(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 124, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", values);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write(NL);         
                            out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write(NL);         
                            out.write("\t\t\t\t\t});");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_118_5.handleBodyContent(out);
                        }
                        _jettag_c_if_118_5.doEnd();
                        _jettag_c_iterate_117_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_117_4.doEnd();
                    _jettag_c_if_116_4.handleBodyContent(out);
                }
                _jettag_c_if_116_4.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_133_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_133_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_133_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_133_4.setTagInfo(_td_c_if_133_4);
                _jettag_c_if_133_4.doStart(context, out);
                while (_jettag_c_if_133_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_134_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_134_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_134_4.setRuntimeParent(_jettag_c_if_133_4);
                    _jettag_c_iterate_134_4.setTagInfo(_td_c_iterate_134_4);
                    _jettag_c_iterate_134_4.doStart(context, out);
                    while (_jettag_c_iterate_134_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_135_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_135_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_135_5.setRuntimeParent(_jettag_c_iterate_134_4);
                        _jettag_c_if_135_5.setTagInfo(_td_c_if_135_5);
                        _jettag_c_if_135_5.doStart(context, out);
                        while (_jettag_c_if_135_5.okToProcessBody()) {
                            out.write("\t\t\t\t");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$packageName}", 136, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 136, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$class/@name}", 136, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("Service.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$class/@name}", 136, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("ServiceAsync.instance().getSuggestionsForName(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 136, 134)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\tnew ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$class/@name}", 137, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(), new ALAsyncCallback<List<String>>() {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write(NL);         
                            out.write("\t\t\t\t\t@Override");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\tpublic void onResponse(List<String> values) {");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write("\t\t\t\t\t\taddSuggestBox(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 141, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", values);");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write(NL);         
                            out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
                            out.write(NL);         
                            out.write(NL);         
                            out.write("\t\t\t\t\t});");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_135_5.handleBodyContent(out);
                        }
                        _jettag_c_if_135_5.doEnd();
                        _jettag_c_iterate_134_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_134_4.doEnd();
                    _jettag_c_if_133_4.handleBodyContent(out);
                }
                _jettag_c_if_133_4.doEnd();
                RuntimeTagElement _jettag_c_iterate_149_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_149_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_149_4.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_149_4.setTagInfo(_td_c_iterate_149_4);
                _jettag_c_iterate_149_4.doStart(context, out);
                while (_jettag_c_iterate_149_4.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_if_150_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_150_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_150_5.setRuntimeParent(_jettag_c_iterate_149_4);
                    _jettag_c_if_150_5.setTagInfo(_td_c_if_150_5);
                    _jettag_c_if_150_5.doStart(context, out);
                    while (_jettag_c_if_150_5.okToProcessBody()) {
                        out.write("\t\t\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$packageName}", 151, 5)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 151, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$class/@name}", 151, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("Service.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$class/@name}", 151, 72)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("ServiceAsync.instance().getSuggestionsForName(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 151, 134)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\tnew ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$class/@name}", 152, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("(), new ALAsyncCallback<List<String>>() {");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write(NL);         
                        out.write("\t\t\t\t\t@Override");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\tpublic void onResponse(List<String> values) {");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t\t\t\t\taddSuggestBox(\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 156, 22)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", values);");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write(NL);         
                        out.write("\t\t\t\t\t}");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write(NL);         
                        out.write("\t\t\t\t\t});");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_if_150_5.handleBodyContent(out);
                    }
                    _jettag_c_if_150_5.doEnd();
                    _jettag_c_iterate_149_4.handleBodyContent(out);
                }
                _jettag_c_iterate_149_4.doEnd();
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_164_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_164_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_164_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_164_1.setTagInfo(_td_f_message_164_1);
                _jettag_f_message_164_1.doStart(context, out);
                JET2Writer _jettag_f_message_164_1_saved_out = out;
                while (_jettag_f_message_164_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_164_1.handleBodyContent(out);
                }
                out = _jettag_f_message_164_1_saved_out;
                _jettag_f_message_164_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected void configure() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
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
                out.write("\tprotected void searchButtonClicked() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 172, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().clear();");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 173, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("Welcome.instance().getEntityPanel().add(");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t\t\t(new ReadAll");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 174, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("sPanely(ReadAllTableType.READALL_SEARCH)));");  //$NON-NLS-1$        
                out.write(NL);         
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_177_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_177_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_177_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_177_1.setTagInfo(_td_f_message_177_1);
                _jettag_f_message_177_1.doStart(context, out);
                JET2Writer _jettag_f_message_177_1_saved_out = out;
                while (_jettag_f_message_177_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_177_1.handleBodyContent(out);
                }
                out = _jettag_f_message_177_1_saved_out;
                _jettag_f_message_177_1.doEnd();
                out.write(NL);         
                out.write("\t@Override");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\tprotected ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 179, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" populateEntity() {");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t\t");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 180, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 180, 19)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(" = new ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${$class/@name}", 180, 53)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write("();");  //$NON-NLS-1$        
                out.write(NL);         
                // process parent class level 2 attributes
                RuntimeTagElement _jettag_c_if_182_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_182_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_182_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_182_2.setTagInfo(_td_c_if_182_2);
                _jettag_c_if_182_2.doStart(context, out);
                while (_jettag_c_if_182_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_183_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_183_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_183_3.setRuntimeParent(_jettag_c_if_182_2);
                    _jettag_c_iterate_183_3.setTagInfo(_td_c_iterate_183_3);
                    _jettag_c_iterate_183_3.doStart(context, out);
                    while (_jettag_c_iterate_183_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_184_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_184_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_184_4.setRuntimeParent(_jettag_c_iterate_183_3);
                        _jettag_c_choose_184_4.setTagInfo(_td_c_choose_184_4);
                        _jettag_c_choose_184_4.doStart(context, out);
                        JET2Writer _jettag_c_choose_184_4_saved_out = out;
                        while (_jettag_c_choose_184_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_185_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_185_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_185_5.setRuntimeParent(_jettag_c_choose_184_4);
                            _jettag_c_when_185_5.setTagInfo(_td_c_when_185_5);
                            _jettag_c_when_185_5.doStart(context, out);
                            JET2Writer _jettag_c_when_185_5_saved_out = out;
                            while (_jettag_c_when_185_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 185, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 185, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(((ALSuggestBox) fields.get(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 185, 133)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")).getText()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_185_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_185_5_saved_out;
                            _jettag_c_when_185_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_187_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_187_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_187_5.setRuntimeParent(_jettag_c_choose_184_4);
                            _jettag_c_when_187_5.setTagInfo(_td_c_when_187_5);
                            _jettag_c_when_187_5.doStart(context, out);
                            JET2Writer _jettag_c_when_187_5_saved_out = out;
                            while (_jettag_c_when_187_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 187, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 187, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 187, 123)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_187_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_187_5_saved_out;
                            _jettag_c_when_187_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_189_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_189_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_189_5.setRuntimeParent(_jettag_c_choose_184_4);
                            _jettag_c_when_189_5.setTagInfo(_td_c_when_189_5);
                            _jettag_c_when_189_5.doStart(context, out);
                            JET2Writer _jettag_c_when_189_5_saved_out = out;
                            while (_jettag_c_when_189_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 189, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 189, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getDateField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 189, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_189_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_189_5_saved_out;
                            _jettag_c_when_189_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_191_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_191_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_191_5.setRuntimeParent(_jettag_c_choose_184_4);
                            _jettag_c_when_191_5.setTagInfo(_td_c_when_191_5);
                            _jettag_c_when_191_5.doStart(context, out);
                            JET2Writer _jettag_c_when_191_5_saved_out = out;
                            while (_jettag_c_when_191_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 191, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 191, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 191, 122)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_191_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_191_5_saved_out;
                            _jettag_c_when_191_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_193_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_193_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_193_5.setRuntimeParent(_jettag_c_choose_184_4);
                            _jettag_c_when_193_5.setTagInfo(_td_c_when_193_5);
                            _jettag_c_when_193_5.doStart(context, out);
                            JET2Writer _jettag_c_when_193_5_saved_out = out;
                            while (_jettag_c_when_193_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 193, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 193, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getLongField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 193, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_193_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_193_5_saved_out;
                            _jettag_c_when_193_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_195_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_195_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_195_5.setRuntimeParent(_jettag_c_choose_184_4);
                            _jettag_c_when_195_5.setTagInfo(_td_c_when_195_5);
                            _jettag_c_when_195_5.doStart(context, out);
                            JET2Writer _jettag_c_when_195_5_saved_out = out;
                            while (_jettag_c_when_195_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 195, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 195, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getFloatField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 195, 119)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_195_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_195_5_saved_out;
                            _jettag_c_when_195_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_197_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_197_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_197_5.setRuntimeParent(_jettag_c_choose_184_4);
                            _jettag_c_when_197_5.setTagInfo(_td_c_when_197_5);
                            _jettag_c_when_197_5.doStart(context, out);
                            JET2Writer _jettag_c_when_197_5_saved_out = out;
                            while (_jettag_c_when_197_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 197, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 197, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 197, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_197_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_197_5_saved_out;
                            _jettag_c_when_197_5.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_199_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_199_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_199_6.setRuntimeParent(_jettag_c_choose_184_4);
                            _jettag_c_otherwise_199_6.setTagInfo(_td_c_otherwise_199_6);
                            _jettag_c_otherwise_199_6.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_199_6_saved_out = out;
                            while (_jettag_c_otherwise_199_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                _jettag_c_otherwise_199_6.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_199_6_saved_out;
                            _jettag_c_otherwise_199_6.doEnd();
                            _jettag_c_choose_184_4.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_184_4_saved_out;
                        _jettag_c_choose_184_4.doEnd();
                        _jettag_c_iterate_183_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_183_3.doEnd();
                    _jettag_c_if_182_2.handleBodyContent(out);
                }
                _jettag_c_if_182_2.doEnd();
                // process parent class level 1 attributes
                RuntimeTagElement _jettag_c_if_205_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_205_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_if_205_2.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_if_205_2.setTagInfo(_td_c_if_205_2);
                _jettag_c_if_205_2.doStart(context, out);
                while (_jettag_c_if_205_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_206_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_206_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_206_3.setRuntimeParent(_jettag_c_if_205_2);
                    _jettag_c_iterate_206_3.setTagInfo(_td_c_iterate_206_3);
                    _jettag_c_iterate_206_3.doStart(context, out);
                    while (_jettag_c_iterate_206_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_choose_207_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_207_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_choose_207_4.setRuntimeParent(_jettag_c_iterate_206_3);
                        _jettag_c_choose_207_4.setTagInfo(_td_c_choose_207_4);
                        _jettag_c_choose_207_4.doStart(context, out);
                        JET2Writer _jettag_c_choose_207_4_saved_out = out;
                        while (_jettag_c_choose_207_4.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_208_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_208_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_208_5.setRuntimeParent(_jettag_c_choose_207_4);
                            _jettag_c_when_208_5.setTagInfo(_td_c_when_208_5);
                            _jettag_c_when_208_5.doStart(context, out);
                            JET2Writer _jettag_c_when_208_5_saved_out = out;
                            while (_jettag_c_when_208_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 208, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 208, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(((ALSuggestBox) fields.get(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 208, 133)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")).getText()); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_208_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_208_5_saved_out;
                            _jettag_c_when_208_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_210_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_210_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_210_5.setRuntimeParent(_jettag_c_choose_207_4);
                            _jettag_c_when_210_5.setTagInfo(_td_c_when_210_5);
                            _jettag_c_when_210_5.doStart(context, out);
                            JET2Writer _jettag_c_when_210_5_saved_out = out;
                            while (_jettag_c_when_210_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 210, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 210, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 210, 123)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_210_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_210_5_saved_out;
                            _jettag_c_when_210_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_212_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_212_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_212_5.setRuntimeParent(_jettag_c_choose_207_4);
                            _jettag_c_when_212_5.setTagInfo(_td_c_when_212_5);
                            _jettag_c_when_212_5.doStart(context, out);
                            JET2Writer _jettag_c_when_212_5_saved_out = out;
                            while (_jettag_c_when_212_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 212, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 212, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getDateField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 212, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_212_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_212_5_saved_out;
                            _jettag_c_when_212_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_214_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_214_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_214_5.setRuntimeParent(_jettag_c_choose_207_4);
                            _jettag_c_when_214_5.setTagInfo(_td_c_when_214_5);
                            _jettag_c_when_214_5.doStart(context, out);
                            JET2Writer _jettag_c_when_214_5_saved_out = out;
                            while (_jettag_c_when_214_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 214, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 214, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 214, 122)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_214_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_214_5_saved_out;
                            _jettag_c_when_214_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_216_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_216_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_216_5.setRuntimeParent(_jettag_c_choose_207_4);
                            _jettag_c_when_216_5.setTagInfo(_td_c_when_216_5);
                            _jettag_c_when_216_5.doStart(context, out);
                            JET2Writer _jettag_c_when_216_5_saved_out = out;
                            while (_jettag_c_when_216_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 216, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 216, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getLongField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 216, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_216_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_216_5_saved_out;
                            _jettag_c_when_216_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_218_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_218_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_218_5.setRuntimeParent(_jettag_c_choose_207_4);
                            _jettag_c_when_218_5.setTagInfo(_td_c_when_218_5);
                            _jettag_c_when_218_5.doStart(context, out);
                            JET2Writer _jettag_c_when_218_5_saved_out = out;
                            while (_jettag_c_when_218_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 218, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 218, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getFloatField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 218, 119)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_218_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_218_5_saved_out;
                            _jettag_c_when_218_5.doEnd();
                            out.write("\t\t\t ");  //$NON-NLS-1$        
                            RuntimeTagElement _jettag_c_when_220_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_220_5); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_when_220_5.setRuntimeParent(_jettag_c_choose_207_4);
                            _jettag_c_when_220_5.setTagInfo(_td_c_when_220_5);
                            _jettag_c_when_220_5.doStart(context, out);
                            JET2Writer _jettag_c_when_220_5_saved_out = out;
                            while (_jettag_c_when_220_5.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                out.write(" ");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 220, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write(".set");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 220, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                                out.write(context.embeddedExpressionAsString("${$attribute/@name}", 220, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                                out.write("\")); ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_when_220_5.handleBodyContent(out);
                            }
                            out = _jettag_c_when_220_5_saved_out;
                            _jettag_c_when_220_5.doEnd();
                            RuntimeTagElement _jettag_c_otherwise_222_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_222_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_otherwise_222_6.setRuntimeParent(_jettag_c_choose_207_4);
                            _jettag_c_otherwise_222_6.setTagInfo(_td_c_otherwise_222_6);
                            _jettag_c_otherwise_222_6.doStart(context, out);
                            JET2Writer _jettag_c_otherwise_222_6_saved_out = out;
                            while (_jettag_c_otherwise_222_6.okToProcessBody()) {
                                out = out.newNestedContentWriter();
                                _jettag_c_otherwise_222_6.handleBodyContent(out);
                            }
                            out = _jettag_c_otherwise_222_6_saved_out;
                            _jettag_c_otherwise_222_6.doEnd();
                            _jettag_c_choose_207_4.handleBodyContent(out);
                        }
                        out = _jettag_c_choose_207_4_saved_out;
                        _jettag_c_choose_207_4.doEnd();
                        _jettag_c_iterate_206_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_206_3.doEnd();
                    _jettag_c_if_205_2.handleBodyContent(out);
                }
                _jettag_c_if_205_2.doEnd();
                RuntimeTagElement _jettag_c_iterate_227_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_227_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_227_3.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_c_iterate_227_3.setTagInfo(_td_c_iterate_227_3);
                _jettag_c_iterate_227_3.doStart(context, out);
                while (_jettag_c_iterate_227_3.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_228_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_228_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_228_4.setRuntimeParent(_jettag_c_iterate_227_3);
                    _jettag_c_choose_228_4.setTagInfo(_td_c_choose_228_4);
                    _jettag_c_choose_228_4.doStart(context, out);
                    JET2Writer _jettag_c_choose_228_4_saved_out = out;
                    while (_jettag_c_choose_228_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_229_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_229_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_229_5.setRuntimeParent(_jettag_c_choose_228_4);
                        _jettag_c_when_229_5.setTagInfo(_td_c_when_229_5);
                        _jettag_c_when_229_5.doStart(context, out);
                        JET2Writer _jettag_c_when_229_5_saved_out = out;
                        while (_jettag_c_when_229_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 229, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 229, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(((ALSuggestBox) fields.get(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 229, 133)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")).getText()); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_229_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_229_5_saved_out;
                        _jettag_c_when_229_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_231_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_231_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_231_5.setRuntimeParent(_jettag_c_choose_228_4);
                        _jettag_c_when_231_5.setTagInfo(_td_c_when_231_5);
                        _jettag_c_when_231_5.doStart(context, out);
                        JET2Writer _jettag_c_when_231_5_saved_out = out;
                        while (_jettag_c_when_231_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 231, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 231, 69)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getIntegerField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 231, 123)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_231_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_231_5_saved_out;
                        _jettag_c_when_231_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_233_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_233_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_233_5.setRuntimeParent(_jettag_c_choose_228_4);
                        _jettag_c_when_233_5.setTagInfo(_td_c_when_233_5);
                        _jettag_c_when_233_5.doStart(context, out);
                        JET2Writer _jettag_c_when_233_5_saved_out = out;
                        while (_jettag_c_when_233_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 233, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 233, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getDateField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 233, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_233_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_233_5_saved_out;
                        _jettag_c_when_233_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_235_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_235_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_235_5.setRuntimeParent(_jettag_c_choose_228_4);
                        _jettag_c_when_235_5.setTagInfo(_td_c_when_235_5);
                        _jettag_c_when_235_5.doStart(context, out);
                        JET2Writer _jettag_c_when_235_5_saved_out = out;
                        while (_jettag_c_when_235_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 235, 37)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 235, 68)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getBooleanField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 235, 122)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_235_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_235_5_saved_out;
                        _jettag_c_when_235_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_237_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_237_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_237_5.setRuntimeParent(_jettag_c_choose_228_4);
                        _jettag_c_when_237_5.setTagInfo(_td_c_when_237_5);
                        _jettag_c_when_237_5.doStart(context, out);
                        JET2Writer _jettag_c_when_237_5_saved_out = out;
                        while (_jettag_c_when_237_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 237, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 237, 66)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getLongField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 237, 117)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_237_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_237_5_saved_out;
                        _jettag_c_when_237_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_239_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_239_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_239_5.setRuntimeParent(_jettag_c_choose_228_4);
                        _jettag_c_when_239_5.setTagInfo(_td_c_when_239_5);
                        _jettag_c_when_239_5.doStart(context, out);
                        JET2Writer _jettag_c_when_239_5_saved_out = out;
                        while (_jettag_c_when_239_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 239, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 239, 67)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getFloatField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 239, 119)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_239_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_239_5_saved_out;
                        _jettag_c_when_239_5.doEnd();
                        out.write("\t\t\t ");  //$NON-NLS-1$        
                        RuntimeTagElement _jettag_c_when_241_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_241_5); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_241_5.setRuntimeParent(_jettag_c_choose_228_4);
                        _jettag_c_when_241_5.setTagInfo(_td_c_when_241_5);
                        _jettag_c_when_241_5.doStart(context, out);
                        JET2Writer _jettag_c_when_241_5_saved_out = out;
                        while (_jettag_c_when_241_5.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write(" ");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 241, 39)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(".set");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${ uppercaseFirst($attribute/@name)}", 241, 70)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("(getCurrencyField(\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 241, 125)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\")); ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_241_5.handleBodyContent(out);
                        }
                        out = _jettag_c_when_241_5_saved_out;
                        _jettag_c_when_241_5.doEnd();
                        RuntimeTagElement _jettag_c_otherwise_243_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_243_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_otherwise_243_6.setRuntimeParent(_jettag_c_choose_228_4);
                        _jettag_c_otherwise_243_6.setTagInfo(_td_c_otherwise_243_6);
                        _jettag_c_otherwise_243_6.doStart(context, out);
                        JET2Writer _jettag_c_otherwise_243_6_saved_out = out;
                        while (_jettag_c_otherwise_243_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            _jettag_c_otherwise_243_6.handleBodyContent(out);
                        }
                        out = _jettag_c_otherwise_243_6_saved_out;
                        _jettag_c_otherwise_243_6.doEnd();
                        _jettag_c_choose_228_4.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_228_4_saved_out;
                    _jettag_c_choose_228_4.doEnd();
                    _jettag_c_iterate_227_3.handleBodyContent(out);
                }
                _jettag_c_iterate_227_3.doEnd();
                out.write("\t\treturn ");  //$NON-NLS-1$        
                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 247, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                out.write(";");  //$NON-NLS-1$        
                out.write(NL);         
                out.write("\t}");  //$NON-NLS-1$        
                out.write(NL);         
                RuntimeTagElement _jettag_f_message_249_1 = context.getTagFactory().createRuntimeTag(_jetns_f, "message", "f:message", _td_f_message_249_1); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_f_message_249_1.setRuntimeParent(_jettag_f_bundle_3_1);
                _jettag_f_message_249_1.setTagInfo(_td_f_message_249_1);
                _jettag_f_message_249_1.doStart(context, out);
                JET2Writer _jettag_f_message_249_1_saved_out = out;
                while (_jettag_f_message_249_1.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("generated.comment");  //$NON-NLS-1$        
                    _jettag_f_message_249_1.handleBodyContent(out);
                }
                out = _jettag_f_message_249_1_saved_out;
                _jettag_f_message_249_1.doEnd();
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
