package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_create_entity_controllerm implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_create_entity_controllerm() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_if_28_2 = new TagInfo("c:if", //$NON-NLS-1$
            28, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_29_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            29, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_30_3 = new TagInfo("c:choose", //$NON-NLS-1$
            30, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_31_4 = new TagInfo("c:when", //$NON-NLS-1$
            31, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_41_4 = new TagInfo("c:when", //$NON-NLS-1$
            41, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_51_4 = new TagInfo("c:when", //$NON-NLS-1$
            51, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_54_4 = new TagInfo("c:when", //$NON-NLS-1$
            54, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_57_4 = new TagInfo("c:when", //$NON-NLS-1$
            57, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_67_4 = new TagInfo("c:when", //$NON-NLS-1$
            67, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_77_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            77, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_78_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            78, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_79_6 = new TagInfo("c:if", //$NON-NLS-1$
            79, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_88_2 = new TagInfo("c:if", //$NON-NLS-1$
            88, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_89_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            89, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_90_3 = new TagInfo("c:choose", //$NON-NLS-1$
            90, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_91_4 = new TagInfo("c:when", //$NON-NLS-1$
            91, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_101_4 = new TagInfo("c:when", //$NON-NLS-1$
            101, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_111_4 = new TagInfo("c:when", //$NON-NLS-1$
            111, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_114_4 = new TagInfo("c:when", //$NON-NLS-1$
            114, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_117_4 = new TagInfo("c:when", //$NON-NLS-1$
            117, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_127_4 = new TagInfo("c:when", //$NON-NLS-1$
            127, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_137_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            137, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_138_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            138, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_139_6 = new TagInfo("c:if", //$NON-NLS-1$
            139, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_148_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            148, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_149_3 = new TagInfo("c:choose", //$NON-NLS-1$
            149, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_150_4 = new TagInfo("c:when", //$NON-NLS-1$
            150, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_160_4 = new TagInfo("c:when", //$NON-NLS-1$
            160, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_170_4 = new TagInfo("c:when", //$NON-NLS-1$
            170, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_173_4 = new TagInfo("c:when", //$NON-NLS-1$
            173, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_176_4 = new TagInfo("c:when", //$NON-NLS-1$
            176, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_186_4 = new TagInfo("c:when", //$NON-NLS-1$
            186, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_196_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            196, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_197_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            197, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_198_6 = new TagInfo("c:if", //$NON-NLS-1$
            198, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_244_1 = new TagInfo("c:if", //$NON-NLS-1$
            244, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_246_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            246, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_247_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            247, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_248_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            248, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_249_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            249, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_251_6 = new TagInfo("c:if", //$NON-NLS-1$
            251, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_254_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            254, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_255_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            255, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_257_14 = new TagInfo("c:if", //$NON-NLS-1$
            257, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_259_14 = new TagInfo("c:if", //$NON-NLS-1$
            259, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'composite'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_261_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            261, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_262_16 = new TagInfo("c:if", //$NON-NLS-1$
            262, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_replaceStrings_267_35 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            267, 35,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_279_1 = new TagInfo("c:if", //$NON-NLS-1$
            279, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class/@isDependent = 'false'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_replaceStrings_280_35 = new TagInfo("c:replaceStrings", //$NON-NLS-1$
            280, 35,
            new String[] {
                "replace", //$NON-NLS-1$
                "with", //$NON-NLS-1$
            },
            new String[] {
                ".", //$NON-NLS-1$
                "_", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_283_2 = new TagInfo("c:if", //$NON-NLS-1$
            283, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_284_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            284, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_285_5 = new TagInfo("c:choose", //$NON-NLS-1$
            285, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_286_6 = new TagInfo("c:when", //$NON-NLS-1$
            286, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_289_6 = new TagInfo("c:when", //$NON-NLS-1$
            289, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_291_6 = new TagInfo("c:when", //$NON-NLS-1$
            291, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_293_6 = new TagInfo("c:when", //$NON-NLS-1$
            293, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_295_6 = new TagInfo("c:when", //$NON-NLS-1$
            295, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_297_6 = new TagInfo("c:when", //$NON-NLS-1$
            297, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_299_5 = new TagInfo("c:otherwise", //$NON-NLS-1$
            299, 5,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_300_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            300, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_301_8 = new TagInfo("c:if", //$NON-NLS-1$
            301, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_310_2 = new TagInfo("c:if", //$NON-NLS-1$
            310, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_311_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            311, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_312_5 = new TagInfo("c:choose", //$NON-NLS-1$
            312, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_313_6 = new TagInfo("c:when", //$NON-NLS-1$
            313, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_316_6 = new TagInfo("c:when", //$NON-NLS-1$
            316, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_318_6 = new TagInfo("c:when", //$NON-NLS-1$
            318, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_320_6 = new TagInfo("c:when", //$NON-NLS-1$
            320, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_322_6 = new TagInfo("c:when", //$NON-NLS-1$
            322, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_324_6 = new TagInfo("c:when", //$NON-NLS-1$
            324, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_326_5 = new TagInfo("c:otherwise", //$NON-NLS-1$
            326, 5,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_327_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            327, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_328_8 = new TagInfo("c:if", //$NON-NLS-1$
            328, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_337_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            337, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_338_5 = new TagInfo("c:choose", //$NON-NLS-1$
            338, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_339_6 = new TagInfo("c:when", //$NON-NLS-1$
            339, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_342_6 = new TagInfo("c:when", //$NON-NLS-1$
            342, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_344_6 = new TagInfo("c:when", //$NON-NLS-1$
            344, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_346_6 = new TagInfo("c:when", //$NON-NLS-1$
            346, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_348_6 = new TagInfo("c:when", //$NON-NLS-1$
            348, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_350_6 = new TagInfo("c:when", //$NON-NLS-1$
            350, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_352_5 = new TagInfo("c:otherwise", //$NON-NLS-1$
            352, 5,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_353_6 = new TagInfo("c:iterate", //$NON-NLS-1$
            353, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_354_8 = new TagInfo("c:if", //$NON-NLS-1$
            354, 8,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("#import \"Create");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 1, 16)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("ViewController.h\"");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("@implementation Create");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 3, 23)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("ViewController");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@synthesize ");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 4, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(";");  //$NON-NLS-1$        
        out.write(NL);         

Integer pageSize = 30;
Integer pos=0;

        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(" // The designated initializer.  Override if you create the controller programmatically and want to perform customization that is not appropriate for viewDidLoad.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    if ((self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil])) {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("        // Custom initialization");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    }");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    return self;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("*/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("// Implement loadView to create a view hierarchy programmatically, without using a nib.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void)loadView {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tCGRect cgRct = CGRectMake(0.0, 0.0, 480, 320); ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tcreate");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 22, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("View= [[UIView alloc] initWithFrame:cgRct]; ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tcreate");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 23, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("View.autoresizesSubviews = YES;  ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tcreate");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 24, 8)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("View.backgroundColor=[UIColor whiteColor];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tself.view = create");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 25, 20)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("View;   ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        // process parent class level 2 attributes
        RuntimeTagElement _jettag_c_if_28_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_28_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_28_2.setRuntimeParent(null);
        _jettag_c_if_28_2.setTagInfo(_td_c_if_28_2);
        _jettag_c_if_28_2.doStart(context, out);
        while (_jettag_c_if_28_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_29_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_29_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_29_3.setRuntimeParent(_jettag_c_if_28_2);
            _jettag_c_iterate_29_3.setTagInfo(_td_c_iterate_29_3);
            _jettag_c_iterate_29_3.doStart(context, out);
            while (_jettag_c_iterate_29_3.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_30_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_30_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_30_3.setRuntimeParent(_jettag_c_iterate_29_3);
                _jettag_c_choose_30_3.setTagInfo(_td_c_choose_30_3);
                _jettag_c_choose_30_3.doStart(context, out);
                JET2Writer _jettag_c_choose_30_3_saved_out = out;
                while (_jettag_c_choose_30_3.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_31_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_31_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_31_4.setRuntimeParent(_jettag_c_choose_30_3);
                    _jettag_c_when_31_4.setTagInfo(_td_c_when_31_4);
                    _jettag_c_when_31_4.doStart(context, out);
                    JET2Writer _jettag_c_when_31_4_saved_out = out;
                    while (_jettag_c_when_31_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 32, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 33, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 33, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 34, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 35, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 36, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 37, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 38, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 39, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_31_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_31_4_saved_out;
                    _jettag_c_when_31_4.doEnd();
                    RuntimeTagElement _jettag_c_when_41_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_41_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_41_4.setRuntimeParent(_jettag_c_choose_30_3);
                    _jettag_c_when_41_4.setTagInfo(_td_c_when_41_4);
                    _jettag_c_when_41_4.doStart(context, out);
                    JET2Writer _jettag_c_when_41_4_saved_out = out;
                    while (_jettag_c_when_41_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 42, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 43, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 43, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 44, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 45, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 46, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 47, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 48, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 49, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_41_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_41_4_saved_out;
                    _jettag_c_when_41_4.doEnd();
                    RuntimeTagElement _jettag_c_when_51_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_51_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_51_4.setRuntimeParent(_jettag_c_choose_30_3);
                    _jettag_c_when_51_4.setTagInfo(_td_c_when_51_4);
                    _jettag_c_when_51_4.doStart(context, out);
                    JET2Writer _jettag_c_when_51_4_saved_out = out;
                    while (_jettag_c_when_51_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_51_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_51_4_saved_out;
                    _jettag_c_when_51_4.doEnd();
                    RuntimeTagElement _jettag_c_when_54_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_54_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_54_4.setRuntimeParent(_jettag_c_choose_30_3);
                    _jettag_c_when_54_4.setTagInfo(_td_c_when_54_4);
                    _jettag_c_when_54_4.doStart(context, out);
                    JET2Writer _jettag_c_when_54_4_saved_out = out;
                    while (_jettag_c_when_54_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_54_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_54_4_saved_out;
                    _jettag_c_when_54_4.doEnd();
                    RuntimeTagElement _jettag_c_when_57_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_57_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_57_4.setRuntimeParent(_jettag_c_choose_30_3);
                    _jettag_c_when_57_4.setTagInfo(_td_c_when_57_4);
                    _jettag_c_when_57_4.doStart(context, out);
                    JET2Writer _jettag_c_when_57_4_saved_out = out;
                    while (_jettag_c_when_57_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 58, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 59, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 59, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 60, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 61, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 62, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 63, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 64, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 65, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_57_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_57_4_saved_out;
                    _jettag_c_when_57_4.doEnd();
                    RuntimeTagElement _jettag_c_when_67_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_67_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_67_4.setRuntimeParent(_jettag_c_choose_30_3);
                    _jettag_c_when_67_4.setTagInfo(_td_c_when_67_4);
                    _jettag_c_when_67_4.doStart(context, out);
                    JET2Writer _jettag_c_when_67_4_saved_out = out;
                    while (_jettag_c_when_67_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 68, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 69, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 69, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 70, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 71, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 72, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 73, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 74, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 75, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_67_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_67_4_saved_out;
                    _jettag_c_when_67_4.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_77_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_77_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_77_3.setRuntimeParent(_jettag_c_choose_30_3);
                    _jettag_c_otherwise_77_3.setTagInfo(_td_c_otherwise_77_3);
                    _jettag_c_otherwise_77_3.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_77_3_saved_out = out;
                    while (_jettag_c_otherwise_77_3.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_iterate_78_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_78_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_78_4.setRuntimeParent(_jettag_c_otherwise_77_3);
                        _jettag_c_iterate_78_4.setTagInfo(_td_c_iterate_78_4);
                        _jettag_c_iterate_78_4.doStart(context, out);
                        while (_jettag_c_iterate_78_4.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_79_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_79_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_79_6.setRuntimeParent(_jettag_c_iterate_78_4);
                            _jettag_c_if_79_6.setTagInfo(_td_c_if_79_6);
                            _jettag_c_if_79_6.doStart(context, out);
                            while (_jettag_c_if_79_6.okToProcessBody()) {
                                // add  enums support
                                _jettag_c_if_79_6.handleBodyContent(out);
                            }
                            _jettag_c_if_79_6.doEnd();
                            _jettag_c_iterate_78_4.handleBodyContent(out);
                        }
                        _jettag_c_iterate_78_4.doEnd();
                        _jettag_c_otherwise_77_3.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_77_3_saved_out;
                    _jettag_c_otherwise_77_3.doEnd();
                    _jettag_c_choose_30_3.handleBodyContent(out);
                }
                out = _jettag_c_choose_30_3_saved_out;
                _jettag_c_choose_30_3.doEnd();
                _jettag_c_iterate_29_3.handleBodyContent(out);
            }
            _jettag_c_iterate_29_3.doEnd();
            _jettag_c_if_28_2.handleBodyContent(out);
        }
        _jettag_c_if_28_2.doEnd();
        // process parent class level 1 attributes
        RuntimeTagElement _jettag_c_if_88_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_88_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_88_2.setRuntimeParent(null);
        _jettag_c_if_88_2.setTagInfo(_td_c_if_88_2);
        _jettag_c_if_88_2.doStart(context, out);
        while (_jettag_c_if_88_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_89_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_89_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_89_3.setRuntimeParent(_jettag_c_if_88_2);
            _jettag_c_iterate_89_3.setTagInfo(_td_c_iterate_89_3);
            _jettag_c_iterate_89_3.doStart(context, out);
            while (_jettag_c_iterate_89_3.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_90_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_90_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_90_3.setRuntimeParent(_jettag_c_iterate_89_3);
                _jettag_c_choose_90_3.setTagInfo(_td_c_choose_90_3);
                _jettag_c_choose_90_3.doStart(context, out);
                JET2Writer _jettag_c_choose_90_3_saved_out = out;
                while (_jettag_c_choose_90_3.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_91_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_91_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_91_4.setRuntimeParent(_jettag_c_choose_90_3);
                    _jettag_c_when_91_4.setTagInfo(_td_c_when_91_4);
                    _jettag_c_when_91_4.doStart(context, out);
                    JET2Writer _jettag_c_when_91_4_saved_out = out;
                    while (_jettag_c_when_91_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 92, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 93, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 93, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 94, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 95, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 96, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 97, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 98, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 99, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_91_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_91_4_saved_out;
                    _jettag_c_when_91_4.doEnd();
                    RuntimeTagElement _jettag_c_when_101_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_101_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_101_4.setRuntimeParent(_jettag_c_choose_90_3);
                    _jettag_c_when_101_4.setTagInfo(_td_c_when_101_4);
                    _jettag_c_when_101_4.doStart(context, out);
                    JET2Writer _jettag_c_when_101_4_saved_out = out;
                    while (_jettag_c_when_101_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 102, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 103, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 103, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 104, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 105, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 106, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 107, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 108, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 109, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_101_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_101_4_saved_out;
                    _jettag_c_when_101_4.doEnd();
                    RuntimeTagElement _jettag_c_when_111_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_111_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_111_4.setRuntimeParent(_jettag_c_choose_90_3);
                    _jettag_c_when_111_4.setTagInfo(_td_c_when_111_4);
                    _jettag_c_when_111_4.doStart(context, out);
                    JET2Writer _jettag_c_when_111_4_saved_out = out;
                    while (_jettag_c_when_111_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_111_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_111_4_saved_out;
                    _jettag_c_when_111_4.doEnd();
                    RuntimeTagElement _jettag_c_when_114_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_114_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_114_4.setRuntimeParent(_jettag_c_choose_90_3);
                    _jettag_c_when_114_4.setTagInfo(_td_c_when_114_4);
                    _jettag_c_when_114_4.doStart(context, out);
                    JET2Writer _jettag_c_when_114_4_saved_out = out;
                    while (_jettag_c_when_114_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_114_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_114_4_saved_out;
                    _jettag_c_when_114_4.doEnd();
                    RuntimeTagElement _jettag_c_when_117_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_117_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_117_4.setRuntimeParent(_jettag_c_choose_90_3);
                    _jettag_c_when_117_4.setTagInfo(_td_c_when_117_4);
                    _jettag_c_when_117_4.doStart(context, out);
                    JET2Writer _jettag_c_when_117_4_saved_out = out;
                    while (_jettag_c_when_117_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 118, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 119, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 119, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 120, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 121, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 122, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 123, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 124, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 125, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_117_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_117_4_saved_out;
                    _jettag_c_when_117_4.doEnd();
                    RuntimeTagElement _jettag_c_when_127_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_127_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_127_4.setRuntimeParent(_jettag_c_choose_90_3);
                    _jettag_c_when_127_4.setTagInfo(_td_c_when_127_4);
                    _jettag_c_when_127_4.doStart(context, out);
                    JET2Writer _jettag_c_when_127_4_saved_out = out;
                    while (_jettag_c_when_127_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 128, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 129, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 129, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 130, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 131, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 132, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 133, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 134, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 135, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_127_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_127_4_saved_out;
                    _jettag_c_when_127_4.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_137_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_137_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_137_3.setRuntimeParent(_jettag_c_choose_90_3);
                    _jettag_c_otherwise_137_3.setTagInfo(_td_c_otherwise_137_3);
                    _jettag_c_otherwise_137_3.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_137_3_saved_out = out;
                    while (_jettag_c_otherwise_137_3.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_iterate_138_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_138_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_138_4.setRuntimeParent(_jettag_c_otherwise_137_3);
                        _jettag_c_iterate_138_4.setTagInfo(_td_c_iterate_138_4);
                        _jettag_c_iterate_138_4.doStart(context, out);
                        while (_jettag_c_iterate_138_4.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_139_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_139_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_139_6.setRuntimeParent(_jettag_c_iterate_138_4);
                            _jettag_c_if_139_6.setTagInfo(_td_c_if_139_6);
                            _jettag_c_if_139_6.doStart(context, out);
                            while (_jettag_c_if_139_6.okToProcessBody()) {
                                // add  enums support
                                _jettag_c_if_139_6.handleBodyContent(out);
                            }
                            _jettag_c_if_139_6.doEnd();
                            _jettag_c_iterate_138_4.handleBodyContent(out);
                        }
                        _jettag_c_iterate_138_4.doEnd();
                        _jettag_c_otherwise_137_3.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_137_3_saved_out;
                    _jettag_c_otherwise_137_3.doEnd();
                    _jettag_c_choose_90_3.handleBodyContent(out);
                }
                out = _jettag_c_choose_90_3_saved_out;
                _jettag_c_choose_90_3.doEnd();
                _jettag_c_iterate_89_3.handleBodyContent(out);
            }
            _jettag_c_iterate_89_3.doEnd();
            _jettag_c_if_88_2.handleBodyContent(out);
        }
        _jettag_c_if_88_2.doEnd();
        // process parent class level 0 attributes
        RuntimeTagElement _jettag_c_iterate_148_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_148_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_148_2.setRuntimeParent(null);
        _jettag_c_iterate_148_2.setTagInfo(_td_c_iterate_148_2);
        _jettag_c_iterate_148_2.doStart(context, out);
        while (_jettag_c_iterate_148_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_choose_149_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_149_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_choose_149_3.setRuntimeParent(_jettag_c_iterate_148_2);
            _jettag_c_choose_149_3.setTagInfo(_td_c_choose_149_3);
            _jettag_c_choose_149_3.doStart(context, out);
            JET2Writer _jettag_c_choose_149_3_saved_out = out;
            while (_jettag_c_choose_149_3.okToProcessBody()) {
                out = out.newNestedContentWriter();
                RuntimeTagElement _jettag_c_when_150_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_150_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_150_4.setRuntimeParent(_jettag_c_choose_149_3);
                _jettag_c_when_150_4.setTagInfo(_td_c_when_150_4);
                _jettag_c_when_150_4.doStart(context, out);
                JET2Writer _jettag_c_when_150_4_saved_out = out;
                while (_jettag_c_when_150_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\tUILabel *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 151, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 152, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L setText:@\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 152, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 153, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 154, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 155, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 156, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 157, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 158, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF];");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_150_4.handleBodyContent(out);
                }
                out = _jettag_c_when_150_4_saved_out;
                _jettag_c_when_150_4.doEnd();
                RuntimeTagElement _jettag_c_when_160_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_160_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_160_4.setRuntimeParent(_jettag_c_choose_149_3);
                _jettag_c_when_160_4.setTagInfo(_td_c_when_160_4);
                _jettag_c_when_160_4.doStart(context, out);
                JET2Writer _jettag_c_when_160_4_saved_out = out;
                while (_jettag_c_when_160_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\tUILabel *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 161, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 162, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L setText:@\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 162, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 163, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 164, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 165, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 166, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 167, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 168, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF];");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_160_4.handleBodyContent(out);
                }
                out = _jettag_c_when_160_4_saved_out;
                _jettag_c_when_160_4.doEnd();
                RuntimeTagElement _jettag_c_when_170_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_170_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_170_4.setRuntimeParent(_jettag_c_choose_149_3);
                _jettag_c_when_170_4.setTagInfo(_td_c_when_170_4);
                _jettag_c_when_170_4.doStart(context, out);
                JET2Writer _jettag_c_when_170_4_saved_out = out;
                while (_jettag_c_when_170_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_170_4.handleBodyContent(out);
                }
                out = _jettag_c_when_170_4_saved_out;
                _jettag_c_when_170_4.doEnd();
                RuntimeTagElement _jettag_c_when_173_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_173_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_173_4.setRuntimeParent(_jettag_c_choose_149_3);
                _jettag_c_when_173_4.setTagInfo(_td_c_when_173_4);
                _jettag_c_when_173_4.doStart(context, out);
                JET2Writer _jettag_c_when_173_4_saved_out = out;
                while (_jettag_c_when_173_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_173_4.handleBodyContent(out);
                }
                out = _jettag_c_when_173_4_saved_out;
                _jettag_c_when_173_4.doEnd();
                RuntimeTagElement _jettag_c_when_176_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_176_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_176_4.setRuntimeParent(_jettag_c_choose_149_3);
                _jettag_c_when_176_4.setTagInfo(_td_c_when_176_4);
                _jettag_c_when_176_4.doStart(context, out);
                JET2Writer _jettag_c_when_176_4_saved_out = out;
                while (_jettag_c_when_176_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\tUILabel *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 177, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 178, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L setText:@\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 178, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 179, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 180, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 181, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 182, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 183, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 184, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF];");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_176_4.handleBodyContent(out);
                }
                out = _jettag_c_when_176_4_saved_out;
                _jettag_c_when_176_4.doEnd();
                RuntimeTagElement _jettag_c_when_186_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_186_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_186_4.setRuntimeParent(_jettag_c_choose_149_3);
                _jettag_c_when_186_4.setTagInfo(_td_c_when_186_4);
                _jettag_c_when_186_4.doStart(context, out);
                JET2Writer _jettag_c_when_186_4_saved_out = out;
                while (_jettag_c_when_186_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\tUILabel *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 187, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 188, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L setText:@\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 188, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 189, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 190, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 191, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 192, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 193, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 194, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF];");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_186_4.handleBodyContent(out);
                }
                out = _jettag_c_when_186_4_saved_out;
                _jettag_c_when_186_4.doEnd();
                RuntimeTagElement _jettag_c_otherwise_196_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_196_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_otherwise_196_3.setRuntimeParent(_jettag_c_choose_149_3);
                _jettag_c_otherwise_196_3.setTagInfo(_td_c_otherwise_196_3);
                _jettag_c_otherwise_196_3.doStart(context, out);
                JET2Writer _jettag_c_otherwise_196_3_saved_out = out;
                while (_jettag_c_otherwise_196_3.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_iterate_197_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_197_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_197_4.setRuntimeParent(_jettag_c_otherwise_196_3);
                    _jettag_c_iterate_197_4.setTagInfo(_td_c_iterate_197_4);
                    _jettag_c_iterate_197_4.doStart(context, out);
                    while (_jettag_c_iterate_197_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_198_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_198_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_198_6.setRuntimeParent(_jettag_c_iterate_197_4);
                        _jettag_c_if_198_6.setTagInfo(_td_c_if_198_6);
                        _jettag_c_if_198_6.doStart(context, out);
                        while (_jettag_c_if_198_6.okToProcessBody()) {
                            // add  enums support
                            _jettag_c_if_198_6.handleBodyContent(out);
                        }
                        _jettag_c_if_198_6.doEnd();
                        _jettag_c_iterate_197_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_197_4.doEnd();
                    _jettag_c_otherwise_196_3.handleBodyContent(out);
                }
                out = _jettag_c_otherwise_196_3_saved_out;
                _jettag_c_otherwise_196_3.doEnd();
                _jettag_c_choose_149_3.handleBodyContent(out);
            }
            out = _jettag_c_choose_149_3_saved_out;
            _jettag_c_choose_149_3.doEnd();
            _jettag_c_iterate_148_2.handleBodyContent(out);
        }
        _jettag_c_iterate_148_2.doEnd();
        out.write(NL);         
        out.write("\tcreateButton= [[UIButton buttonWithType:UIButtonTypeRoundedRect] retain];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tcreateButton.frame = CGRectMake(5,5, 100.0, 30.0);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[createButton setTitle:@\"Create\" forState:UIControlStateNormal];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[createButton setTitleColor:[UIColor grayColor] forState:UIControlStateNormal ];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[createButton addTarget:self action:@selector(createClicked:) forControlEvents:UIControlEventTouchUpInside];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[self.view addSubview:createButton];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void)viewDidLoad {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    [super viewDidLoad];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("*/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("/*");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("// Override to allow orientations other than the default portrait orientation.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // Return YES for supported orientations");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    return (interfaceOrientation == UIInterfaceOrientationPortrait);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("*/");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void)didReceiveMemoryWarning {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // Releases the view if it doesn't have a superview.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    [super didReceiveMemoryWarning];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // Release any cached data, images, etc that aren't in use.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void)viewDidUnload {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    [super viewDidUnload];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // Release any retained subviews of the main view.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    // e.g. self.myOutlet = nil;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (IBAction) createClicked:(id) sender{\t");  //$NON-NLS-1$        
        out.write(NL);         
        RuntimeTagElement _jettag_c_if_244_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_244_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_244_1.setRuntimeParent(null);
        _jettag_c_if_244_1.setTagInfo(_td_c_if_244_1);
        _jettag_c_if_244_1.doStart(context, out);
        while (_jettag_c_if_244_1.okToProcessBody()) {
            // process compsition associations
            RuntimeTagElement _jettag_c_iterate_246_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_246_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_246_2.setRuntimeParent(_jettag_c_if_244_1);
            _jettag_c_iterate_246_2.setTagInfo(_td_c_iterate_246_2);
            _jettag_c_iterate_246_2.doStart(context, out);
            while (_jettag_c_iterate_246_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_247_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_247_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_247_2.setRuntimeParent(_jettag_c_iterate_246_2);
                _jettag_c_iterate_247_2.setTagInfo(_td_c_iterate_247_2);
                _jettag_c_iterate_247_2.doStart(context, out);
                while (_jettag_c_iterate_247_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_248_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_248_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_248_3.setRuntimeParent(_jettag_c_iterate_247_2);
                    _jettag_c_iterate_248_3.setTagInfo(_td_c_iterate_248_3);
                    _jettag_c_iterate_248_3.doStart(context, out);
                    while (_jettag_c_iterate_248_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_249_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_249_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_249_4.setRuntimeParent(_jettag_c_iterate_248_3);
                        _jettag_c_setVariable_249_4.setTagInfo(_td_c_setVariable_249_4);
                        _jettag_c_setVariable_249_4.doStart(context, out);
                        _jettag_c_setVariable_249_4.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_251_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_251_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_251_6.setRuntimeParent(_jettag_c_iterate_248_3);
                        _jettag_c_if_251_6.setTagInfo(_td_c_if_251_6);
                        _jettag_c_if_251_6.doStart(context, out);
                        while (_jettag_c_if_251_6.okToProcessBody()) {
                            // process only compositions
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_254_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_254_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_254_12.setRuntimeParent(_jettag_c_if_251_6);
                            _jettag_c_iterate_254_12.setTagInfo(_td_c_iterate_254_12);
                            _jettag_c_iterate_254_12.doStart(context, out);
                            while (_jettag_c_iterate_254_12.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_255_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_255_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_255_12.setRuntimeParent(_jettag_c_iterate_254_12);
                                _jettag_c_setVariable_255_12.setTagInfo(_td_c_setVariable_255_12);
                                _jettag_c_setVariable_255_12.doStart(context, out);
                                _jettag_c_setVariable_255_12.doEnd();
                                // get the end secondary end with other class  
                                RuntimeTagElement _jettag_c_if_257_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_257_14); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_257_14.setRuntimeParent(_jettag_c_iterate_254_12);
                                _jettag_c_if_257_14.setTagInfo(_td_c_if_257_14);
                                _jettag_c_if_257_14.doStart(context, out);
                                while (_jettag_c_if_257_14.okToProcessBody()) {
                                    // check if this is a comp
                                    RuntimeTagElement _jettag_c_if_259_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_259_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_259_14.setRuntimeParent(_jettag_c_if_257_14);
                                    _jettag_c_if_259_14.setTagInfo(_td_c_if_259_14);
                                    _jettag_c_if_259_14.doStart(context, out);
                                    while (_jettag_c_if_259_14.okToProcessBody()) {
                                        // iterate throught all the classes to get the other class on the association
                                        RuntimeTagElement _jettag_c_iterate_261_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_261_15); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_iterate_261_15.setRuntimeParent(_jettag_c_if_259_14);
                                        _jettag_c_iterate_261_15.setTagInfo(_td_c_iterate_261_15);
                                        _jettag_c_iterate_261_15.doStart(context, out);
                                        while (_jettag_c_iterate_261_15.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_262_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_262_16); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_262_16.setRuntimeParent(_jettag_c_iterate_261_15);
                                            _jettag_c_if_262_16.setTagInfo(_td_c_if_262_16);
                                            _jettag_c_if_262_16.doStart(context, out);
                                            while (_jettag_c_if_262_16.okToProcessBody()) {
                                                // check to see if class2 is parent and child
                                                out.write("\tif (");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 264, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write(".");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${lowercaseFirst($class2/@name)}", 264, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write("!=nil) {");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                out.write("\t}");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                out.write("\telse {");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                out.write("\t\t");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 267, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write(" =[[[");  //$NON-NLS-1$        
                                                RuntimeTagElement _jettag_c_replaceStrings_267_35 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_267_35); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_replaceStrings_267_35.setRuntimeParent(_jettag_c_if_262_16);
                                                _jettag_c_replaceStrings_267_35.setTagInfo(_td_c_replaceStrings_267_35);
                                                _jettag_c_replaceStrings_267_35.doStart(context, out);
                                                JET2Writer _jettag_c_replaceStrings_267_35_saved_out = out;
                                                while (_jettag_c_replaceStrings_267_35.okToProcessBody()) {
                                                    out = out.newNestedContentWriter();
                                                    out.write(context.embeddedExpressionAsString("${$groupID}", 267, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_replaceStrings_267_35.handleBodyContent(out);
                                                }
                                                out = _jettag_c_replaceStrings_267_35_saved_out;
                                                _jettag_c_replaceStrings_267_35.doEnd();
                                                out.write("_entity_");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 267, 112)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write("_");  //$NON-NLS-1$        
                                                out.write(context.embeddedExpressionAsString("${$class/@name}", 267, 142)); //$NON-NLS-1$ //$NON-NLS-2$
                                                out.write(" alloc]init] autorelease];");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                out.write("\t}");  //$NON-NLS-1$        
                                                out.write(NL);         
                                                _jettag_c_if_262_16.handleBodyContent(out);
                                            }
                                            _jettag_c_if_262_16.doEnd();
                                            _jettag_c_iterate_261_15.handleBodyContent(out);
                                        }
                                        _jettag_c_iterate_261_15.doEnd();
                                        _jettag_c_if_259_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_259_14.doEnd();
                                    _jettag_c_if_257_14.handleBodyContent(out);
                                }
                                _jettag_c_if_257_14.doEnd();
                                _jettag_c_iterate_254_12.handleBodyContent(out);
                            }
                            _jettag_c_iterate_254_12.doEnd();
                            _jettag_c_if_251_6.handleBodyContent(out);
                        }
                        _jettag_c_if_251_6.doEnd();
                        _jettag_c_iterate_248_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_248_3.doEnd();
                    _jettag_c_iterate_247_2.handleBodyContent(out);
                }
                _jettag_c_iterate_247_2.doEnd();
                _jettag_c_iterate_246_2.handleBodyContent(out);
            }
            _jettag_c_iterate_246_2.doEnd();
            _jettag_c_if_244_1.handleBodyContent(out);
        }
        _jettag_c_if_244_1.doEnd();
        RuntimeTagElement _jettag_c_if_279_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_279_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_279_1.setRuntimeParent(null);
        _jettag_c_if_279_1.setTagInfo(_td_c_if_279_1);
        _jettag_c_if_279_1.doStart(context, out);
        while (_jettag_c_if_279_1.okToProcessBody()) {
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 280, 3)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" =[[[");  //$NON-NLS-1$        
            RuntimeTagElement _jettag_c_replaceStrings_280_35 = context.getTagFactory().createRuntimeTag(_jetns_c, "replaceStrings", "c:replaceStrings", _td_c_replaceStrings_280_35); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_replaceStrings_280_35.setRuntimeParent(_jettag_c_if_279_1);
            _jettag_c_replaceStrings_280_35.setTagInfo(_td_c_replaceStrings_280_35);
            _jettag_c_replaceStrings_280_35.doStart(context, out);
            JET2Writer _jettag_c_replaceStrings_280_35_saved_out = out;
            while (_jettag_c_replaceStrings_280_35.okToProcessBody()) {
                out = out.newNestedContentWriter();
                out.write(context.embeddedExpressionAsString("${$groupID}", 280, 74)); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_replaceStrings_280_35.handleBodyContent(out);
            }
            out = _jettag_c_replaceStrings_280_35_saved_out;
            _jettag_c_replaceStrings_280_35.doEnd();
            out.write("_entity_");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 280, 112)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 280, 142)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" alloc]init] autorelease];");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_c_if_279_1.handleBodyContent(out);
        }
        _jettag_c_if_279_1.doEnd();
        // process parent class level 2 attributes
        RuntimeTagElement _jettag_c_if_283_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_283_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_283_2.setRuntimeParent(null);
        _jettag_c_if_283_2.setTagInfo(_td_c_if_283_2);
        _jettag_c_if_283_2.doStart(context, out);
        while (_jettag_c_if_283_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_284_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_284_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_284_3.setRuntimeParent(_jettag_c_if_283_2);
            _jettag_c_iterate_284_3.setTagInfo(_td_c_iterate_284_3);
            _jettag_c_iterate_284_3.doStart(context, out);
            while (_jettag_c_iterate_284_3.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_285_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_285_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_285_5.setRuntimeParent(_jettag_c_iterate_284_3);
                _jettag_c_choose_285_5.setTagInfo(_td_c_choose_285_5);
                _jettag_c_choose_285_5.doStart(context, out);
                JET2Writer _jettag_c_choose_285_5_saved_out = out;
                while (_jettag_c_choose_285_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_286_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_286_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_286_6.setRuntimeParent(_jettag_c_choose_285_5);
                    _jettag_c_when_286_6.setTagInfo(_td_c_when_286_6);
                    _jettag_c_when_286_6.doStart(context, out);
                    JET2Writer _jettag_c_when_286_6_saved_out = out;
                    while (_jettag_c_when_286_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t  ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 287, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 287, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("=");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 287, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.text;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_286_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_286_6_saved_out;
                    _jettag_c_when_286_6.doEnd();
                    RuntimeTagElement _jettag_c_when_289_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_289_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_289_6.setRuntimeParent(_jettag_c_choose_285_5);
                    _jettag_c_when_289_6.setTagInfo(_td_c_when_289_6);
                    _jettag_c_when_289_6.doStart(context, out);
                    JET2Writer _jettag_c_when_289_6_saved_out = out;
                    while (_jettag_c_when_289_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_289_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_289_6_saved_out;
                    _jettag_c_when_289_6.doEnd();
                    RuntimeTagElement _jettag_c_when_291_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_291_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_291_6.setRuntimeParent(_jettag_c_choose_285_5);
                    _jettag_c_when_291_6.setTagInfo(_td_c_when_291_6);
                    _jettag_c_when_291_6.doStart(context, out);
                    JET2Writer _jettag_c_when_291_6_saved_out = out;
                    while (_jettag_c_when_291_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_291_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_291_6_saved_out;
                    _jettag_c_when_291_6.doEnd();
                    RuntimeTagElement _jettag_c_when_293_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_293_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_293_6.setRuntimeParent(_jettag_c_choose_285_5);
                    _jettag_c_when_293_6.setTagInfo(_td_c_when_293_6);
                    _jettag_c_when_293_6.doStart(context, out);
                    JET2Writer _jettag_c_when_293_6_saved_out = out;
                    while (_jettag_c_when_293_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_293_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_293_6_saved_out;
                    _jettag_c_when_293_6.doEnd();
                    RuntimeTagElement _jettag_c_when_295_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_295_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_295_6.setRuntimeParent(_jettag_c_choose_285_5);
                    _jettag_c_when_295_6.setTagInfo(_td_c_when_295_6);
                    _jettag_c_when_295_6.doStart(context, out);
                    JET2Writer _jettag_c_when_295_6_saved_out = out;
                    while (_jettag_c_when_295_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_295_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_295_6_saved_out;
                    _jettag_c_when_295_6.doEnd();
                    RuntimeTagElement _jettag_c_when_297_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_297_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_297_6.setRuntimeParent(_jettag_c_choose_285_5);
                    _jettag_c_when_297_6.setTagInfo(_td_c_when_297_6);
                    _jettag_c_when_297_6.doStart(context, out);
                    JET2Writer _jettag_c_when_297_6_saved_out = out;
                    while (_jettag_c_when_297_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_297_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_297_6_saved_out;
                    _jettag_c_when_297_6.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_299_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_299_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_299_5.setRuntimeParent(_jettag_c_choose_285_5);
                    _jettag_c_otherwise_299_5.setTagInfo(_td_c_otherwise_299_5);
                    _jettag_c_otherwise_299_5.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_299_5_saved_out = out;
                    while (_jettag_c_otherwise_299_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_iterate_300_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_300_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_300_6.setRuntimeParent(_jettag_c_otherwise_299_5);
                        _jettag_c_iterate_300_6.setTagInfo(_td_c_iterate_300_6);
                        _jettag_c_iterate_300_6.doStart(context, out);
                        while (_jettag_c_iterate_300_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_301_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_301_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_301_8.setRuntimeParent(_jettag_c_iterate_300_6);
                            _jettag_c_if_301_8.setTagInfo(_td_c_if_301_8);
                            _jettag_c_if_301_8.doStart(context, out);
                            while (_jettag_c_if_301_8.okToProcessBody()) {
                                // add  enums support
                                _jettag_c_if_301_8.handleBodyContent(out);
                            }
                            _jettag_c_if_301_8.doEnd();
                            _jettag_c_iterate_300_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_300_6.doEnd();
                        _jettag_c_otherwise_299_5.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_299_5_saved_out;
                    _jettag_c_otherwise_299_5.doEnd();
                    _jettag_c_choose_285_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_285_5_saved_out;
                _jettag_c_choose_285_5.doEnd();
                _jettag_c_iterate_284_3.handleBodyContent(out);
            }
            _jettag_c_iterate_284_3.doEnd();
            _jettag_c_if_283_2.handleBodyContent(out);
        }
        _jettag_c_if_283_2.doEnd();
        // process parent class level 1 attributes
        RuntimeTagElement _jettag_c_if_310_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_310_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_310_2.setRuntimeParent(null);
        _jettag_c_if_310_2.setTagInfo(_td_c_if_310_2);
        _jettag_c_if_310_2.doStart(context, out);
        while (_jettag_c_if_310_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_311_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_311_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_311_3.setRuntimeParent(_jettag_c_if_310_2);
            _jettag_c_iterate_311_3.setTagInfo(_td_c_iterate_311_3);
            _jettag_c_iterate_311_3.doStart(context, out);
            while (_jettag_c_iterate_311_3.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_312_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_312_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_312_5.setRuntimeParent(_jettag_c_iterate_311_3);
                _jettag_c_choose_312_5.setTagInfo(_td_c_choose_312_5);
                _jettag_c_choose_312_5.doStart(context, out);
                JET2Writer _jettag_c_choose_312_5_saved_out = out;
                while (_jettag_c_choose_312_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_313_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_313_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_313_6.setRuntimeParent(_jettag_c_choose_312_5);
                    _jettag_c_when_313_6.setTagInfo(_td_c_when_313_6);
                    _jettag_c_when_313_6.doStart(context, out);
                    JET2Writer _jettag_c_when_313_6_saved_out = out;
                    while (_jettag_c_when_313_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t  ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 314, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(".");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 314, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("=");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 314, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.text;");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_313_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_313_6_saved_out;
                    _jettag_c_when_313_6.doEnd();
                    RuntimeTagElement _jettag_c_when_316_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_316_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_316_6.setRuntimeParent(_jettag_c_choose_312_5);
                    _jettag_c_when_316_6.setTagInfo(_td_c_when_316_6);
                    _jettag_c_when_316_6.doStart(context, out);
                    JET2Writer _jettag_c_when_316_6_saved_out = out;
                    while (_jettag_c_when_316_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_316_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_316_6_saved_out;
                    _jettag_c_when_316_6.doEnd();
                    RuntimeTagElement _jettag_c_when_318_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_318_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_318_6.setRuntimeParent(_jettag_c_choose_312_5);
                    _jettag_c_when_318_6.setTagInfo(_td_c_when_318_6);
                    _jettag_c_when_318_6.doStart(context, out);
                    JET2Writer _jettag_c_when_318_6_saved_out = out;
                    while (_jettag_c_when_318_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_318_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_318_6_saved_out;
                    _jettag_c_when_318_6.doEnd();
                    RuntimeTagElement _jettag_c_when_320_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_320_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_320_6.setRuntimeParent(_jettag_c_choose_312_5);
                    _jettag_c_when_320_6.setTagInfo(_td_c_when_320_6);
                    _jettag_c_when_320_6.doStart(context, out);
                    JET2Writer _jettag_c_when_320_6_saved_out = out;
                    while (_jettag_c_when_320_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_320_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_320_6_saved_out;
                    _jettag_c_when_320_6.doEnd();
                    RuntimeTagElement _jettag_c_when_322_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_322_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_322_6.setRuntimeParent(_jettag_c_choose_312_5);
                    _jettag_c_when_322_6.setTagInfo(_td_c_when_322_6);
                    _jettag_c_when_322_6.doStart(context, out);
                    JET2Writer _jettag_c_when_322_6_saved_out = out;
                    while (_jettag_c_when_322_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_322_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_322_6_saved_out;
                    _jettag_c_when_322_6.doEnd();
                    RuntimeTagElement _jettag_c_when_324_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_324_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_324_6.setRuntimeParent(_jettag_c_choose_312_5);
                    _jettag_c_when_324_6.setTagInfo(_td_c_when_324_6);
                    _jettag_c_when_324_6.doStart(context, out);
                    JET2Writer _jettag_c_when_324_6_saved_out = out;
                    while (_jettag_c_when_324_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_324_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_324_6_saved_out;
                    _jettag_c_when_324_6.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_326_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_326_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_326_5.setRuntimeParent(_jettag_c_choose_312_5);
                    _jettag_c_otherwise_326_5.setTagInfo(_td_c_otherwise_326_5);
                    _jettag_c_otherwise_326_5.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_326_5_saved_out = out;
                    while (_jettag_c_otherwise_326_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_iterate_327_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_327_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_327_6.setRuntimeParent(_jettag_c_otherwise_326_5);
                        _jettag_c_iterate_327_6.setTagInfo(_td_c_iterate_327_6);
                        _jettag_c_iterate_327_6.doStart(context, out);
                        while (_jettag_c_iterate_327_6.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_328_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_328_8); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_328_8.setRuntimeParent(_jettag_c_iterate_327_6);
                            _jettag_c_if_328_8.setTagInfo(_td_c_if_328_8);
                            _jettag_c_if_328_8.doStart(context, out);
                            while (_jettag_c_if_328_8.okToProcessBody()) {
                                // add  enums support
                                _jettag_c_if_328_8.handleBodyContent(out);
                            }
                            _jettag_c_if_328_8.doEnd();
                            _jettag_c_iterate_327_6.handleBodyContent(out);
                        }
                        _jettag_c_iterate_327_6.doEnd();
                        _jettag_c_otherwise_326_5.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_326_5_saved_out;
                    _jettag_c_otherwise_326_5.doEnd();
                    _jettag_c_choose_312_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_312_5_saved_out;
                _jettag_c_choose_312_5.doEnd();
                _jettag_c_iterate_311_3.handleBodyContent(out);
            }
            _jettag_c_iterate_311_3.doEnd();
            _jettag_c_if_310_2.handleBodyContent(out);
        }
        _jettag_c_if_310_2.doEnd();
        // process parent class level 0 attributes
        RuntimeTagElement _jettag_c_iterate_337_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_337_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_337_2.setRuntimeParent(null);
        _jettag_c_iterate_337_2.setTagInfo(_td_c_iterate_337_2);
        _jettag_c_iterate_337_2.doStart(context, out);
        while (_jettag_c_iterate_337_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_choose_338_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_338_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_choose_338_5.setRuntimeParent(_jettag_c_iterate_337_2);
            _jettag_c_choose_338_5.setTagInfo(_td_c_choose_338_5);
            _jettag_c_choose_338_5.doStart(context, out);
            JET2Writer _jettag_c_choose_338_5_saved_out = out;
            while (_jettag_c_choose_338_5.okToProcessBody()) {
                out = out.newNestedContentWriter();
                RuntimeTagElement _jettag_c_when_339_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_339_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_339_6.setRuntimeParent(_jettag_c_choose_338_5);
                _jettag_c_when_339_6.setTagInfo(_td_c_when_339_6);
                _jettag_c_when_339_6.doStart(context, out);
                JET2Writer _jettag_c_when_339_6_saved_out = out;
                while (_jettag_c_when_339_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\t\t  ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 340, 6)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(".");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 340, 34)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("=");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 340, 54)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF.text;");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_339_6.handleBodyContent(out);
                }
                out = _jettag_c_when_339_6_saved_out;
                _jettag_c_when_339_6.doEnd();
                RuntimeTagElement _jettag_c_when_342_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_342_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_342_6.setRuntimeParent(_jettag_c_choose_338_5);
                _jettag_c_when_342_6.setTagInfo(_td_c_when_342_6);
                _jettag_c_when_342_6.doStart(context, out);
                JET2Writer _jettag_c_when_342_6_saved_out = out;
                while (_jettag_c_when_342_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    _jettag_c_when_342_6.handleBodyContent(out);
                }
                out = _jettag_c_when_342_6_saved_out;
                _jettag_c_when_342_6.doEnd();
                RuntimeTagElement _jettag_c_when_344_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_344_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_344_6.setRuntimeParent(_jettag_c_choose_338_5);
                _jettag_c_when_344_6.setTagInfo(_td_c_when_344_6);
                _jettag_c_when_344_6.doStart(context, out);
                JET2Writer _jettag_c_when_344_6_saved_out = out;
                while (_jettag_c_when_344_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    _jettag_c_when_344_6.handleBodyContent(out);
                }
                out = _jettag_c_when_344_6_saved_out;
                _jettag_c_when_344_6.doEnd();
                RuntimeTagElement _jettag_c_when_346_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_346_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_346_6.setRuntimeParent(_jettag_c_choose_338_5);
                _jettag_c_when_346_6.setTagInfo(_td_c_when_346_6);
                _jettag_c_when_346_6.doStart(context, out);
                JET2Writer _jettag_c_when_346_6_saved_out = out;
                while (_jettag_c_when_346_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    _jettag_c_when_346_6.handleBodyContent(out);
                }
                out = _jettag_c_when_346_6_saved_out;
                _jettag_c_when_346_6.doEnd();
                RuntimeTagElement _jettag_c_when_348_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_348_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_348_6.setRuntimeParent(_jettag_c_choose_338_5);
                _jettag_c_when_348_6.setTagInfo(_td_c_when_348_6);
                _jettag_c_when_348_6.doStart(context, out);
                JET2Writer _jettag_c_when_348_6_saved_out = out;
                while (_jettag_c_when_348_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    _jettag_c_when_348_6.handleBodyContent(out);
                }
                out = _jettag_c_when_348_6_saved_out;
                _jettag_c_when_348_6.doEnd();
                RuntimeTagElement _jettag_c_when_350_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_350_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_350_6.setRuntimeParent(_jettag_c_choose_338_5);
                _jettag_c_when_350_6.setTagInfo(_td_c_when_350_6);
                _jettag_c_when_350_6.doStart(context, out);
                JET2Writer _jettag_c_when_350_6_saved_out = out;
                while (_jettag_c_when_350_6.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    _jettag_c_when_350_6.handleBodyContent(out);
                }
                out = _jettag_c_when_350_6_saved_out;
                _jettag_c_when_350_6.doEnd();
                RuntimeTagElement _jettag_c_otherwise_352_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_352_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_otherwise_352_5.setRuntimeParent(_jettag_c_choose_338_5);
                _jettag_c_otherwise_352_5.setTagInfo(_td_c_otherwise_352_5);
                _jettag_c_otherwise_352_5.doStart(context, out);
                JET2Writer _jettag_c_otherwise_352_5_saved_out = out;
                while (_jettag_c_otherwise_352_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_iterate_353_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_353_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_353_6.setRuntimeParent(_jettag_c_otherwise_352_5);
                    _jettag_c_iterate_353_6.setTagInfo(_td_c_iterate_353_6);
                    _jettag_c_iterate_353_6.doStart(context, out);
                    while (_jettag_c_iterate_353_6.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_354_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_354_8); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_354_8.setRuntimeParent(_jettag_c_iterate_353_6);
                        _jettag_c_if_354_8.setTagInfo(_td_c_if_354_8);
                        _jettag_c_if_354_8.doStart(context, out);
                        while (_jettag_c_if_354_8.okToProcessBody()) {
                            // add  enums support
                            _jettag_c_if_354_8.handleBodyContent(out);
                        }
                        _jettag_c_if_354_8.doEnd();
                        _jettag_c_iterate_353_6.handleBodyContent(out);
                    }
                    _jettag_c_iterate_353_6.doEnd();
                    _jettag_c_otherwise_352_5.handleBodyContent(out);
                }
                out = _jettag_c_otherwise_352_5_saved_out;
                _jettag_c_otherwise_352_5.doEnd();
                _jettag_c_choose_338_5.handleBodyContent(out);
            }
            out = _jettag_c_choose_338_5_saved_out;
            _jettag_c_choose_338_5.doEnd();
            _jettag_c_iterate_337_2.handleBodyContent(out);
        }
        _jettag_c_iterate_337_2.doEnd();
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSString *xml=[XMLUtils convertObjectToXML:");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 362, 45)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSString *url=[self getCreate");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 363, 31)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("URL];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[HttpHelper asyncHttpPutData:xml withURL:url];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[[self navigationController] popViewControllerAnimated:YES];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void) textFieldDoneEditing:(id) sender{");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[sender resignFirstResponder];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (NSString*) getCreate");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 372, 24)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("URL{");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\treturn [[HttpUtils crudURL] stringByAppendingString:@\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 373, 56)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/create\"];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void)dealloc {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("    [super dealloc];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write(NL);         
        out.write("@end");  //$NON-NLS-1$        
        out.write(NL);         
    }
}
