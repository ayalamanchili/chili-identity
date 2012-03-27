package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_read_entity_controllerm implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$

    public _jet_read_entity_controllerm() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_if_3_1 = new TagInfo("c:if", //$NON-NLS-1$
            3, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_4_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            4, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_6_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            6, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_7_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            7, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_8_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            8, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_9_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            9, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_11_13 = new TagInfo("c:if", //$NON-NLS-1$
            11, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_13_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            13, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_15_18 = new TagInfo("c:if", //$NON-NLS-1$
            15, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_16_18 = new TagInfo("c:if", //$NON-NLS-1$
            16, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_17_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            17, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_19_21 = new TagInfo("c:if", //$NON-NLS-1$
            19, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_21_19 = new TagInfo("c:if", //$NON-NLS-1$
            21, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_23_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            23, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_24_23 = new TagInfo("c:if", //$NON-NLS-1$
            24, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_40_1 = new TagInfo("c:if", //$NON-NLS-1$
            40, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_41_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            41, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_43_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            43, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_44_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            44, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_45_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            45, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_46_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            46, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_48_13 = new TagInfo("c:if", //$NON-NLS-1$
            48, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_50_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            50, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_52_18 = new TagInfo("c:if", //$NON-NLS-1$
            52, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_53_18 = new TagInfo("c:if", //$NON-NLS-1$
            53, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_54_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            54, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_56_21 = new TagInfo("c:if", //$NON-NLS-1$
            56, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_58_19 = new TagInfo("c:if", //$NON-NLS-1$
            58, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_60_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            60, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_61_23 = new TagInfo("c:if", //$NON-NLS-1$
            61, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_77_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            77, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_79_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            79, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_80_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            80, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_81_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            81, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_82_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            82, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_84_6 = new TagInfo("c:if", //$NON-NLS-1$
            84, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_86_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            86, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_88_12 = new TagInfo("c:if", //$NON-NLS-1$
            88, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_89_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            89, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_91_14 = new TagInfo("c:if", //$NON-NLS-1$
            91, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_93_14 = new TagInfo("c:if", //$NON-NLS-1$
            93, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_95_9 = new TagInfo("c:if", //$NON-NLS-1$
            95, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_96_11 = new TagInfo("c:if", //$NON-NLS-1$
            96, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_98_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            98, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_99_16 = new TagInfo("c:if", //$NON-NLS-1$
            99, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_141_2 = new TagInfo("c:if", //$NON-NLS-1$
            141, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_142_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            142, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_143_3 = new TagInfo("c:choose", //$NON-NLS-1$
            143, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_144_4 = new TagInfo("c:when", //$NON-NLS-1$
            144, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_154_4 = new TagInfo("c:when", //$NON-NLS-1$
            154, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_164_4 = new TagInfo("c:when", //$NON-NLS-1$
            164, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_167_4 = new TagInfo("c:when", //$NON-NLS-1$
            167, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_170_4 = new TagInfo("c:when", //$NON-NLS-1$
            170, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_180_4 = new TagInfo("c:when", //$NON-NLS-1$
            180, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_190_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            190, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_191_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            191, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_192_6 = new TagInfo("c:if", //$NON-NLS-1$
            192, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_201_2 = new TagInfo("c:if", //$NON-NLS-1$
            201, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_202_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            202, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_203_3 = new TagInfo("c:choose", //$NON-NLS-1$
            203, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_204_4 = new TagInfo("c:when", //$NON-NLS-1$
            204, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_214_4 = new TagInfo("c:when", //$NON-NLS-1$
            214, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_224_4 = new TagInfo("c:when", //$NON-NLS-1$
            224, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_227_4 = new TagInfo("c:when", //$NON-NLS-1$
            227, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_230_4 = new TagInfo("c:when", //$NON-NLS-1$
            230, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_240_4 = new TagInfo("c:when", //$NON-NLS-1$
            240, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_250_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            250, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_251_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            251, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_252_6 = new TagInfo("c:if", //$NON-NLS-1$
            252, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_261_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            261, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_262_3 = new TagInfo("c:choose", //$NON-NLS-1$
            262, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_263_4 = new TagInfo("c:when", //$NON-NLS-1$
            263, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_273_4 = new TagInfo("c:when", //$NON-NLS-1$
            273, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_283_4 = new TagInfo("c:when", //$NON-NLS-1$
            283, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_286_4 = new TagInfo("c:when", //$NON-NLS-1$
            286, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_289_4 = new TagInfo("c:when", //$NON-NLS-1$
            289, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_299_4 = new TagInfo("c:when", //$NON-NLS-1$
            299, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_309_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            309, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_310_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            310, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_311_6 = new TagInfo("c:if", //$NON-NLS-1$
            311, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_337_1 = new TagInfo("c:if", //$NON-NLS-1$
            337, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_338_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            338, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_340_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            340, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_341_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            341, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_342_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            342, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_343_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            343, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_345_13 = new TagInfo("c:if", //$NON-NLS-1$
            345, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_347_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            347, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_349_18 = new TagInfo("c:if", //$NON-NLS-1$
            349, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_350_18 = new TagInfo("c:if", //$NON-NLS-1$
            350, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_351_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            351, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_353_21 = new TagInfo("c:if", //$NON-NLS-1$
            353, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_355_19 = new TagInfo("c:if", //$NON-NLS-1$
            355, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_357_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            357, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_358_23 = new TagInfo("c:if", //$NON-NLS-1$
            358, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_374_1 = new TagInfo("c:if", //$NON-NLS-1$
            374, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_375_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            375, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_377_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            377, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_378_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            378, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_379_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            379, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_380_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            380, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_382_13 = new TagInfo("c:if", //$NON-NLS-1$
            382, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_384_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            384, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_386_18 = new TagInfo("c:if", //$NON-NLS-1$
            386, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_387_18 = new TagInfo("c:if", //$NON-NLS-1$
            387, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_388_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            388, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_390_21 = new TagInfo("c:if", //$NON-NLS-1$
            390, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_392_19 = new TagInfo("c:if", //$NON-NLS-1$
            392, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_394_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            394, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_395_23 = new TagInfo("c:if", //$NON-NLS-1$
            395, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_411_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            411, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_413_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            413, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_414_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            414, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_415_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            415, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_416_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            416, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_418_6 = new TagInfo("c:if", //$NON-NLS-1$
            418, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_420_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            420, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_422_12 = new TagInfo("c:if", //$NON-NLS-1$
            422, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_423_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            423, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_425_14 = new TagInfo("c:if", //$NON-NLS-1$
            425, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_427_14 = new TagInfo("c:if", //$NON-NLS-1$
            427, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_429_9 = new TagInfo("c:if", //$NON-NLS-1$
            429, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_430_11 = new TagInfo("c:if", //$NON-NLS-1$
            430, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_432_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            432, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_433_16 = new TagInfo("c:if", //$NON-NLS-1$
            433, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_452_1 = new TagInfo("c:if", //$NON-NLS-1$
            452, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_453_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            453, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_455_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            455, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_456_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            456, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_457_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            457, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_458_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            458, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_460_13 = new TagInfo("c:if", //$NON-NLS-1$
            460, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_462_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            462, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_464_18 = new TagInfo("c:if", //$NON-NLS-1$
            464, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_465_18 = new TagInfo("c:if", //$NON-NLS-1$
            465, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_466_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            466, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_468_21 = new TagInfo("c:if", //$NON-NLS-1$
            468, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_470_19 = new TagInfo("c:if", //$NON-NLS-1$
            470, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_472_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            472, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_473_23 = new TagInfo("c:if", //$NON-NLS-1$
            473, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_498_1 = new TagInfo("c:if", //$NON-NLS-1$
            498, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_499_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            499, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_501_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            501, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_502_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            502, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_503_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            503, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_504_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            504, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_506_13 = new TagInfo("c:if", //$NON-NLS-1$
            506, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_508_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            508, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_510_18 = new TagInfo("c:if", //$NON-NLS-1$
            510, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_511_18 = new TagInfo("c:if", //$NON-NLS-1$
            511, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_512_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            512, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_514_21 = new TagInfo("c:if", //$NON-NLS-1$
            514, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_516_19 = new TagInfo("c:if", //$NON-NLS-1$
            516, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_518_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            518, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_519_23 = new TagInfo("c:if", //$NON-NLS-1$
            519, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_544_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            544, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_546_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            546, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_547_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            547, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_548_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            548, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_549_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            549, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_551_6 = new TagInfo("c:if", //$NON-NLS-1$
            551, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_553_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            553, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_555_12 = new TagInfo("c:if", //$NON-NLS-1$
            555, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_556_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            556, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_558_14 = new TagInfo("c:if", //$NON-NLS-1$
            558, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_560_14 = new TagInfo("c:if", //$NON-NLS-1$
            560, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_562_9 = new TagInfo("c:if", //$NON-NLS-1$
            562, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_563_11 = new TagInfo("c:if", //$NON-NLS-1$
            563, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_565_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            565, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_566_16 = new TagInfo("c:if", //$NON-NLS-1$
            566, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_596_2 = new TagInfo("c:if", //$NON-NLS-1$
            596, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_597_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            597, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_598_3 = new TagInfo("c:choose", //$NON-NLS-1$
            598, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_599_4 = new TagInfo("c:when", //$NON-NLS-1$
            599, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_601_4 = new TagInfo("c:when", //$NON-NLS-1$
            601, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_603_4 = new TagInfo("c:when", //$NON-NLS-1$
            603, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_606_4 = new TagInfo("c:when", //$NON-NLS-1$
            606, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_609_4 = new TagInfo("c:when", //$NON-NLS-1$
            609, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_611_4 = new TagInfo("c:when", //$NON-NLS-1$
            611, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_613_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            613, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_614_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            614, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_615_6 = new TagInfo("c:if", //$NON-NLS-1$
            615, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_624_2 = new TagInfo("c:if", //$NON-NLS-1$
            624, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_625_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            625, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_626_3 = new TagInfo("c:choose", //$NON-NLS-1$
            626, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_627_4 = new TagInfo("c:when", //$NON-NLS-1$
            627, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_629_4 = new TagInfo("c:when", //$NON-NLS-1$
            629, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_631_4 = new TagInfo("c:when", //$NON-NLS-1$
            631, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_634_4 = new TagInfo("c:when", //$NON-NLS-1$
            634, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_637_4 = new TagInfo("c:when", //$NON-NLS-1$
            637, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_639_4 = new TagInfo("c:when", //$NON-NLS-1$
            639, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_641_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            641, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_642_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            642, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_643_6 = new TagInfo("c:if", //$NON-NLS-1$
            643, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_652_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            652, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_653_3 = new TagInfo("c:choose", //$NON-NLS-1$
            653, 3,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_654_4 = new TagInfo("c:when", //$NON-NLS-1$
            654, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_656_4 = new TagInfo("c:when", //$NON-NLS-1$
            656, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_658_4 = new TagInfo("c:when", //$NON-NLS-1$
            658, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_661_4 = new TagInfo("c:when", //$NON-NLS-1$
            661, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_664_4 = new TagInfo("c:when", //$NON-NLS-1$
            664, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_666_4 = new TagInfo("c:when", //$NON-NLS-1$
            666, 4,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_otherwise_668_3 = new TagInfo("c:otherwise", //$NON-NLS-1$
            668, 3,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_iterate_669_4 = new TagInfo("c:iterate", //$NON-NLS-1$
            669, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Enumeration", //$NON-NLS-1$
                "enumeration", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_670_6 = new TagInfo("c:if", //$NON-NLS-1$
            670, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/Enumeration/@xmi.idref = $enumeration/@xmi.id", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        out.write("#import \"Read");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 1, 14)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("ViewController.h\"");  //$NON-NLS-1$        
        out.write(NL);         
        //process level 1 generizations associatons 
        RuntimeTagElement _jettag_c_if_3_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_3_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_3_1.setRuntimeParent(null);
        _jettag_c_if_3_1.setTagInfo(_td_c_if_3_1);
        _jettag_c_if_3_1.doStart(context, out);
        while (_jettag_c_if_3_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_setVariable_4_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_4_6); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_4_6.setRuntimeParent(_jettag_c_if_3_1);
            _jettag_c_setVariable_4_6.setTagInfo(_td_c_setVariable_4_6);
            _jettag_c_setVariable_4_6.doStart(context, out);
            _jettag_c_setVariable_4_6.doEnd();
            // process the assocations for level 1 class 
            RuntimeTagElement _jettag_c_iterate_6_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_6_8); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_6_8.setRuntimeParent(_jettag_c_if_3_1);
            _jettag_c_iterate_6_8.setTagInfo(_td_c_iterate_6_8);
            _jettag_c_iterate_6_8.doStart(context, out);
            while (_jettag_c_iterate_6_8.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_7_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_7_9); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_7_9.setRuntimeParent(_jettag_c_iterate_6_8);
                _jettag_c_iterate_7_9.setTagInfo(_td_c_iterate_7_9);
                _jettag_c_iterate_7_9.doStart(context, out);
                while (_jettag_c_iterate_7_9.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_8_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_8_10); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_8_10.setRuntimeParent(_jettag_c_iterate_7_9);
                    _jettag_c_iterate_8_10.setTagInfo(_td_c_iterate_8_10);
                    _jettag_c_iterate_8_10.doStart(context, out);
                    while (_jettag_c_iterate_8_10.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_9_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_9_11); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_9_11.setRuntimeParent(_jettag_c_iterate_8_10);
                        _jettag_c_setVariable_9_11.setTagInfo(_td_c_setVariable_9_11);
                        _jettag_c_setVariable_9_11.doStart(context, out);
                        _jettag_c_setVariable_9_11.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_11_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_11_13); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_11_13.setRuntimeParent(_jettag_c_iterate_8_10);
                        _jettag_c_if_11_13.setTagInfo(_td_c_if_11_13);
                        _jettag_c_if_11_13.doStart(context, out);
                        while (_jettag_c_if_11_13.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_13_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_13_19); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_13_19.setRuntimeParent(_jettag_c_if_11_13);
                            _jettag_c_iterate_13_19.setTagInfo(_td_c_iterate_13_19);
                            _jettag_c_iterate_13_19.doStart(context, out);
                            while (_jettag_c_iterate_13_19.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_15_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_15_18); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_15_18.setRuntimeParent(_jettag_c_iterate_13_19);
                                _jettag_c_if_15_18.setTagInfo(_td_c_if_15_18);
                                _jettag_c_if_15_18.doStart(context, out);
                                while (_jettag_c_if_15_18.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_16_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_16_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_16_18.setRuntimeParent(_jettag_c_if_15_18);
                                    _jettag_c_if_16_18.setTagInfo(_td_c_if_16_18);
                                    _jettag_c_if_16_18.doStart(context, out);
                                    while (_jettag_c_if_16_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_17_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_17_19); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_17_19.setRuntimeParent(_jettag_c_if_16_18);
                                        _jettag_c_setVariable_17_19.setTagInfo(_td_c_setVariable_17_19);
                                        _jettag_c_setVariable_17_19.doStart(context, out);
                                        _jettag_c_setVariable_17_19.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_19_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_19_21); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_19_21.setRuntimeParent(_jettag_c_if_16_18);
                                        _jettag_c_if_19_21.setTagInfo(_td_c_if_19_21);
                                        _jettag_c_if_19_21.doStart(context, out);
                                        while (_jettag_c_if_19_21.okToProcessBody()) {
                                            // check to see if this is a navigable relation
                                            RuntimeTagElement _jettag_c_if_21_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_21_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_21_19.setRuntimeParent(_jettag_c_if_19_21);
                                            _jettag_c_if_21_19.setTagInfo(_td_c_if_21_19);
                                            _jettag_c_if_21_19.doStart(context, out);
                                            while (_jettag_c_if_21_19.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_23_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_23_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_23_22.setRuntimeParent(_jettag_c_if_21_19);
                                                _jettag_c_iterate_23_22.setTagInfo(_td_c_iterate_23_22);
                                                _jettag_c_iterate_23_22.doStart(context, out);
                                                while (_jettag_c_iterate_23_22.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_24_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_24_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_24_23.setRuntimeParent(_jettag_c_iterate_23_22);
                                                    _jettag_c_if_24_23.setTagInfo(_td_c_if_24_23);
                                                    _jettag_c_if_24_23.doStart(context, out);
                                                    while (_jettag_c_if_24_23.okToProcessBody()) {
                                                        out.write("#import \"ReadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 25, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController.h\"\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_24_23.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_24_23.doEnd();
                                                    _jettag_c_iterate_23_22.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_23_22.doEnd();
                                                _jettag_c_if_21_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_21_19.doEnd();
                                            _jettag_c_if_19_21.handleBodyContent(out);
                                        }
                                        _jettag_c_if_19_21.doEnd();
                                        _jettag_c_if_16_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_16_18.doEnd();
                                    _jettag_c_if_15_18.handleBodyContent(out);
                                }
                                _jettag_c_if_15_18.doEnd();
                                _jettag_c_iterate_13_19.handleBodyContent(out);
                            }
                            _jettag_c_iterate_13_19.doEnd();
                            out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_11_13.handleBodyContent(out);
                        }
                        _jettag_c_if_11_13.doEnd();
                        _jettag_c_iterate_8_10.handleBodyContent(out);
                    }
                    _jettag_c_iterate_8_10.doEnd();
                    _jettag_c_iterate_7_9.handleBodyContent(out);
                }
                _jettag_c_iterate_7_9.doEnd();
                _jettag_c_iterate_6_8.handleBodyContent(out);
            }
            _jettag_c_iterate_6_8.doEnd();
            _jettag_c_if_3_1.handleBodyContent(out);
        }
        _jettag_c_if_3_1.doEnd();
        //process level 2 generizations 
        RuntimeTagElement _jettag_c_if_40_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_40_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_40_1.setRuntimeParent(null);
        _jettag_c_if_40_1.setTagInfo(_td_c_if_40_1);
        _jettag_c_if_40_1.doStart(context, out);
        while (_jettag_c_if_40_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_setVariable_41_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_41_6); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_41_6.setRuntimeParent(_jettag_c_if_40_1);
            _jettag_c_setVariable_41_6.setTagInfo(_td_c_setVariable_41_6);
            _jettag_c_setVariable_41_6.doStart(context, out);
            _jettag_c_setVariable_41_6.doEnd();
            // process the assocations for level 1 class 
            RuntimeTagElement _jettag_c_iterate_43_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_43_8); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_43_8.setRuntimeParent(_jettag_c_if_40_1);
            _jettag_c_iterate_43_8.setTagInfo(_td_c_iterate_43_8);
            _jettag_c_iterate_43_8.doStart(context, out);
            while (_jettag_c_iterate_43_8.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_44_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_44_9); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_44_9.setRuntimeParent(_jettag_c_iterate_43_8);
                _jettag_c_iterate_44_9.setTagInfo(_td_c_iterate_44_9);
                _jettag_c_iterate_44_9.doStart(context, out);
                while (_jettag_c_iterate_44_9.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_45_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_45_10); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_45_10.setRuntimeParent(_jettag_c_iterate_44_9);
                    _jettag_c_iterate_45_10.setTagInfo(_td_c_iterate_45_10);
                    _jettag_c_iterate_45_10.doStart(context, out);
                    while (_jettag_c_iterate_45_10.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_46_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_46_11); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_46_11.setRuntimeParent(_jettag_c_iterate_45_10);
                        _jettag_c_setVariable_46_11.setTagInfo(_td_c_setVariable_46_11);
                        _jettag_c_setVariable_46_11.doStart(context, out);
                        _jettag_c_setVariable_46_11.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_48_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_48_13); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_48_13.setRuntimeParent(_jettag_c_iterate_45_10);
                        _jettag_c_if_48_13.setTagInfo(_td_c_if_48_13);
                        _jettag_c_if_48_13.doStart(context, out);
                        while (_jettag_c_if_48_13.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_50_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_50_19); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_50_19.setRuntimeParent(_jettag_c_if_48_13);
                            _jettag_c_iterate_50_19.setTagInfo(_td_c_iterate_50_19);
                            _jettag_c_iterate_50_19.doStart(context, out);
                            while (_jettag_c_iterate_50_19.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_52_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_52_18); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_52_18.setRuntimeParent(_jettag_c_iterate_50_19);
                                _jettag_c_if_52_18.setTagInfo(_td_c_if_52_18);
                                _jettag_c_if_52_18.doStart(context, out);
                                while (_jettag_c_if_52_18.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_53_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_53_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_53_18.setRuntimeParent(_jettag_c_if_52_18);
                                    _jettag_c_if_53_18.setTagInfo(_td_c_if_53_18);
                                    _jettag_c_if_53_18.doStart(context, out);
                                    while (_jettag_c_if_53_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_54_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_54_19); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_54_19.setRuntimeParent(_jettag_c_if_53_18);
                                        _jettag_c_setVariable_54_19.setTagInfo(_td_c_setVariable_54_19);
                                        _jettag_c_setVariable_54_19.doStart(context, out);
                                        _jettag_c_setVariable_54_19.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_56_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_56_21); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_56_21.setRuntimeParent(_jettag_c_if_53_18);
                                        _jettag_c_if_56_21.setTagInfo(_td_c_if_56_21);
                                        _jettag_c_if_56_21.doStart(context, out);
                                        while (_jettag_c_if_56_21.okToProcessBody()) {
                                            // check to see if this is a navigable relation
                                            RuntimeTagElement _jettag_c_if_58_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_58_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_58_19.setRuntimeParent(_jettag_c_if_56_21);
                                            _jettag_c_if_58_19.setTagInfo(_td_c_if_58_19);
                                            _jettag_c_if_58_19.doStart(context, out);
                                            while (_jettag_c_if_58_19.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_60_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_60_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_60_22.setRuntimeParent(_jettag_c_if_58_19);
                                                _jettag_c_iterate_60_22.setTagInfo(_td_c_iterate_60_22);
                                                _jettag_c_iterate_60_22.doStart(context, out);
                                                while (_jettag_c_iterate_60_22.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_61_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_61_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_61_23.setRuntimeParent(_jettag_c_iterate_60_22);
                                                    _jettag_c_if_61_23.setTagInfo(_td_c_if_61_23);
                                                    _jettag_c_if_61_23.doStart(context, out);
                                                    while (_jettag_c_if_61_23.okToProcessBody()) {
                                                        out.write("#import \"ReadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 62, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController.h\"");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_61_23.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_61_23.doEnd();
                                                    _jettag_c_iterate_60_22.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_60_22.doEnd();
                                                _jettag_c_if_58_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_58_19.doEnd();
                                            _jettag_c_if_56_21.handleBodyContent(out);
                                        }
                                        _jettag_c_if_56_21.doEnd();
                                        _jettag_c_if_53_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_53_18.doEnd();
                                    _jettag_c_if_52_18.handleBodyContent(out);
                                }
                                _jettag_c_if_52_18.doEnd();
                                _jettag_c_iterate_50_19.handleBodyContent(out);
                            }
                            _jettag_c_iterate_50_19.doEnd();
                            out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_48_13.handleBodyContent(out);
                        }
                        _jettag_c_if_48_13.doEnd();
                        _jettag_c_iterate_45_10.handleBodyContent(out);
                    }
                    _jettag_c_iterate_45_10.doEnd();
                    _jettag_c_iterate_44_9.handleBodyContent(out);
                }
                _jettag_c_iterate_44_9.doEnd();
                _jettag_c_iterate_43_8.handleBodyContent(out);
            }
            _jettag_c_iterate_43_8.doEnd();
            _jettag_c_if_40_1.handleBodyContent(out);
        }
        _jettag_c_if_40_1.doEnd();
        out.write(NL);         
        RuntimeTagElement _jettag_c_setVariable_77_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_77_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_77_1.setRuntimeParent(null);
        _jettag_c_setVariable_77_1.setTagInfo(_td_c_setVariable_77_1);
        _jettag_c_setVariable_77_1.doStart(context, out);
        _jettag_c_setVariable_77_1.doEnd();
        //process 0 level class relations 
        RuntimeTagElement _jettag_c_iterate_79_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_79_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_79_1.setRuntimeParent(null);
        _jettag_c_iterate_79_1.setTagInfo(_td_c_iterate_79_1);
        _jettag_c_iterate_79_1.doStart(context, out);
        while (_jettag_c_iterate_79_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_80_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_80_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_80_2.setRuntimeParent(_jettag_c_iterate_79_1);
            _jettag_c_iterate_80_2.setTagInfo(_td_c_iterate_80_2);
            _jettag_c_iterate_80_2.doStart(context, out);
            while (_jettag_c_iterate_80_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_81_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_81_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_81_3.setRuntimeParent(_jettag_c_iterate_80_2);
                _jettag_c_iterate_81_3.setTagInfo(_td_c_iterate_81_3);
                _jettag_c_iterate_81_3.doStart(context, out);
                while (_jettag_c_iterate_81_3.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_82_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_82_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_82_4.setRuntimeParent(_jettag_c_iterate_81_3);
                    _jettag_c_setVariable_82_4.setTagInfo(_td_c_setVariable_82_4);
                    _jettag_c_setVariable_82_4.doStart(context, out);
                    _jettag_c_setVariable_82_4.doEnd();
                    // check is the association is corresponding to the class  
                    RuntimeTagElement _jettag_c_if_84_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_84_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_84_6.setRuntimeParent(_jettag_c_iterate_81_3);
                    _jettag_c_if_84_6.setTagInfo(_td_c_if_84_6);
                    _jettag_c_if_84_6.doStart(context, out);
                    while (_jettag_c_if_84_6.okToProcessBody()) {
                        // iterate over the iterations ends  
                        RuntimeTagElement _jettag_c_iterate_86_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_86_12); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_86_12.setRuntimeParent(_jettag_c_if_84_6);
                        _jettag_c_iterate_86_12.setTagInfo(_td_c_iterate_86_12);
                        _jettag_c_iterate_86_12.doStart(context, out);
                        while (_jettag_c_iterate_86_12.okToProcessBody()) {
                            // process only non composits or non aggregations and 
                            RuntimeTagElement _jettag_c_if_88_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_88_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_88_12.setRuntimeParent(_jettag_c_iterate_86_12);
                            _jettag_c_if_88_12.setTagInfo(_td_c_if_88_12);
                            _jettag_c_if_88_12.doStart(context, out);
                            while (_jettag_c_if_88_12.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_89_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_89_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_89_12.setRuntimeParent(_jettag_c_if_88_12);
                                _jettag_c_setVariable_89_12.setTagInfo(_td_c_setVariable_89_12);
                                _jettag_c_setVariable_89_12.doStart(context, out);
                                _jettag_c_setVariable_89_12.doEnd();
                                // get the end secondary end with other class  
                                RuntimeTagElement _jettag_c_if_91_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_91_14); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_91_14.setRuntimeParent(_jettag_c_if_88_12);
                                _jettag_c_if_91_14.setTagInfo(_td_c_if_91_14);
                                _jettag_c_if_91_14.doStart(context, out);
                                while (_jettag_c_if_91_14.okToProcessBody()) {
                                    // check to see if this is a navigable relation
                                    RuntimeTagElement _jettag_c_if_93_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_93_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_93_14.setRuntimeParent(_jettag_c_if_91_14);
                                    _jettag_c_if_93_14.setTagInfo(_td_c_if_93_14);
                                    _jettag_c_if_93_14.doStart(context, out);
                                    while (_jettag_c_if_93_14.okToProcessBody()) {
                                        // process many on target
                                        RuntimeTagElement _jettag_c_if_95_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_95_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_95_9.setRuntimeParent(_jettag_c_if_93_14);
                                        _jettag_c_if_95_9.setTagInfo(_td_c_if_95_9);
                                        _jettag_c_if_95_9.doStart(context, out);
                                        while (_jettag_c_if_95_9.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_96_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_96_11); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_96_11.setRuntimeParent(_jettag_c_if_95_9);
                                            _jettag_c_if_96_11.setTagInfo(_td_c_if_96_11);
                                            _jettag_c_if_96_11.doStart(context, out);
                                            while (_jettag_c_if_96_11.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_98_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_98_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_98_15.setRuntimeParent(_jettag_c_if_96_11);
                                                _jettag_c_iterate_98_15.setTagInfo(_td_c_iterate_98_15);
                                                _jettag_c_iterate_98_15.doStart(context, out);
                                                while (_jettag_c_iterate_98_15.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_99_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_99_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_99_16.setRuntimeParent(_jettag_c_iterate_98_15);
                                                    _jettag_c_if_99_16.setTagInfo(_td_c_if_99_16);
                                                    _jettag_c_if_99_16.doStart(context, out);
                                                    while (_jettag_c_if_99_16.okToProcessBody()) {
                                                        out.write("#import \"ReadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 100, 17)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController.h\"");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_99_16.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_99_16.doEnd();
                                                    _jettag_c_iterate_98_15.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_98_15.doEnd();
                                                _jettag_c_if_96_11.handleBodyContent(out);
                                            }
                                            _jettag_c_if_96_11.doEnd();
                                            _jettag_c_if_95_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_95_9.doEnd();
                                        _jettag_c_if_93_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_93_14.doEnd();
                                    _jettag_c_if_91_14.handleBodyContent(out);
                                }
                                _jettag_c_if_91_14.doEnd();
                                _jettag_c_if_88_12.handleBodyContent(out);
                            }
                            _jettag_c_if_88_12.doEnd();
                            _jettag_c_iterate_86_12.handleBodyContent(out);
                        }
                        _jettag_c_iterate_86_12.doEnd();
                        _jettag_c_if_84_6.handleBodyContent(out);
                    }
                    _jettag_c_if_84_6.doEnd();
                    _jettag_c_iterate_81_3.handleBodyContent(out);
                }
                _jettag_c_iterate_81_3.doEnd();
                _jettag_c_iterate_80_2.handleBodyContent(out);
            }
            _jettag_c_iterate_80_2.doEnd();
            _jettag_c_iterate_79_1.handleBodyContent(out);
        }
        _jettag_c_iterate_79_1.doEnd();

Integer pageSize = 30;
Integer pos=0;

        out.write(NL);         
        out.write("@implementation Read");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 118, 21)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("ViewController");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("@synthesize ");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 119, 13)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write(";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
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
        out.write("\tread");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 134, 6)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("View= [[UIView alloc] initWithFrame:cgRct]; ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tread");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 135, 6)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("View.autoresizesSubviews = YES;  ");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tread");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 136, 6)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("View.backgroundColor=[UIColor whiteColor];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tself.view = read");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 137, 18)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("View;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[self configureOptionsView];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[read");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 139, 7)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("View addSubview:optionsBarView];   ");  //$NON-NLS-1$        
        out.write(NL);         
        // process parent class level 2 attributes
        RuntimeTagElement _jettag_c_if_141_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_141_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_141_2.setRuntimeParent(null);
        _jettag_c_if_141_2.setTagInfo(_td_c_if_141_2);
        _jettag_c_if_141_2.doStart(context, out);
        while (_jettag_c_if_141_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_142_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_142_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_142_3.setRuntimeParent(_jettag_c_if_141_2);
            _jettag_c_iterate_142_3.setTagInfo(_td_c_iterate_142_3);
            _jettag_c_iterate_142_3.doStart(context, out);
            while (_jettag_c_iterate_142_3.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_143_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_143_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_143_3.setRuntimeParent(_jettag_c_iterate_142_3);
                _jettag_c_choose_143_3.setTagInfo(_td_c_choose_143_3);
                _jettag_c_choose_143_3.doStart(context, out);
                JET2Writer _jettag_c_choose_143_3_saved_out = out;
                while (_jettag_c_choose_143_3.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_144_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_144_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_144_4.setRuntimeParent(_jettag_c_choose_143_3);
                    _jettag_c_when_144_4.setTagInfo(_td_c_when_144_4);
                    _jettag_c_when_144_4.doStart(context, out);
                    JET2Writer _jettag_c_when_144_4_saved_out = out;
                    while (_jettag_c_when_144_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 145, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 146, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 146, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 147, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 148, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 149, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 150, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 151, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 152, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_144_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_144_4_saved_out;
                    _jettag_c_when_144_4.doEnd();
                    RuntimeTagElement _jettag_c_when_154_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_154_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_154_4.setRuntimeParent(_jettag_c_choose_143_3);
                    _jettag_c_when_154_4.setTagInfo(_td_c_when_154_4);
                    _jettag_c_when_154_4.doStart(context, out);
                    JET2Writer _jettag_c_when_154_4_saved_out = out;
                    while (_jettag_c_when_154_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 155, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 156, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 156, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 157, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 158, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 159, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 160, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 161, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 162, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_154_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_154_4_saved_out;
                    _jettag_c_when_154_4.doEnd();
                    RuntimeTagElement _jettag_c_when_164_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_164_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_164_4.setRuntimeParent(_jettag_c_choose_143_3);
                    _jettag_c_when_164_4.setTagInfo(_td_c_when_164_4);
                    _jettag_c_when_164_4.doStart(context, out);
                    JET2Writer _jettag_c_when_164_4_saved_out = out;
                    while (_jettag_c_when_164_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_164_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_164_4_saved_out;
                    _jettag_c_when_164_4.doEnd();
                    RuntimeTagElement _jettag_c_when_167_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_167_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_167_4.setRuntimeParent(_jettag_c_choose_143_3);
                    _jettag_c_when_167_4.setTagInfo(_td_c_when_167_4);
                    _jettag_c_when_167_4.doStart(context, out);
                    JET2Writer _jettag_c_when_167_4_saved_out = out;
                    while (_jettag_c_when_167_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_167_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_167_4_saved_out;
                    _jettag_c_when_167_4.doEnd();
                    RuntimeTagElement _jettag_c_when_170_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_170_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_170_4.setRuntimeParent(_jettag_c_choose_143_3);
                    _jettag_c_when_170_4.setTagInfo(_td_c_when_170_4);
                    _jettag_c_when_170_4.doStart(context, out);
                    JET2Writer _jettag_c_when_170_4_saved_out = out;
                    while (_jettag_c_when_170_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 171, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 172, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 172, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 173, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 174, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 175, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 176, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 177, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 178, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_170_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_170_4_saved_out;
                    _jettag_c_when_170_4.doEnd();
                    RuntimeTagElement _jettag_c_when_180_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_180_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_180_4.setRuntimeParent(_jettag_c_choose_143_3);
                    _jettag_c_when_180_4.setTagInfo(_td_c_when_180_4);
                    _jettag_c_when_180_4.doStart(context, out);
                    JET2Writer _jettag_c_when_180_4_saved_out = out;
                    while (_jettag_c_when_180_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 181, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 182, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 182, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 183, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 184, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 185, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 186, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 187, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 188, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_180_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_180_4_saved_out;
                    _jettag_c_when_180_4.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_190_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_190_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_190_3.setRuntimeParent(_jettag_c_choose_143_3);
                    _jettag_c_otherwise_190_3.setTagInfo(_td_c_otherwise_190_3);
                    _jettag_c_otherwise_190_3.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_190_3_saved_out = out;
                    while (_jettag_c_otherwise_190_3.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_iterate_191_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_191_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_191_4.setRuntimeParent(_jettag_c_otherwise_190_3);
                        _jettag_c_iterate_191_4.setTagInfo(_td_c_iterate_191_4);
                        _jettag_c_iterate_191_4.doStart(context, out);
                        while (_jettag_c_iterate_191_4.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_192_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_192_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_192_6.setRuntimeParent(_jettag_c_iterate_191_4);
                            _jettag_c_if_192_6.setTagInfo(_td_c_if_192_6);
                            _jettag_c_if_192_6.doStart(context, out);
                            while (_jettag_c_if_192_6.okToProcessBody()) {
                                // add  enums support
                                _jettag_c_if_192_6.handleBodyContent(out);
                            }
                            _jettag_c_if_192_6.doEnd();
                            _jettag_c_iterate_191_4.handleBodyContent(out);
                        }
                        _jettag_c_iterate_191_4.doEnd();
                        _jettag_c_otherwise_190_3.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_190_3_saved_out;
                    _jettag_c_otherwise_190_3.doEnd();
                    _jettag_c_choose_143_3.handleBodyContent(out);
                }
                out = _jettag_c_choose_143_3_saved_out;
                _jettag_c_choose_143_3.doEnd();
                _jettag_c_iterate_142_3.handleBodyContent(out);
            }
            _jettag_c_iterate_142_3.doEnd();
            _jettag_c_if_141_2.handleBodyContent(out);
        }
        _jettag_c_if_141_2.doEnd();
        // process parent class level 1 attributes
        RuntimeTagElement _jettag_c_if_201_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_201_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_201_2.setRuntimeParent(null);
        _jettag_c_if_201_2.setTagInfo(_td_c_if_201_2);
        _jettag_c_if_201_2.doStart(context, out);
        while (_jettag_c_if_201_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_202_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_202_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_202_3.setRuntimeParent(_jettag_c_if_201_2);
            _jettag_c_iterate_202_3.setTagInfo(_td_c_iterate_202_3);
            _jettag_c_iterate_202_3.doStart(context, out);
            while (_jettag_c_iterate_202_3.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_203_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_203_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_203_3.setRuntimeParent(_jettag_c_iterate_202_3);
                _jettag_c_choose_203_3.setTagInfo(_td_c_choose_203_3);
                _jettag_c_choose_203_3.doStart(context, out);
                JET2Writer _jettag_c_choose_203_3_saved_out = out;
                while (_jettag_c_choose_203_3.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_204_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_204_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_204_4.setRuntimeParent(_jettag_c_choose_203_3);
                    _jettag_c_when_204_4.setTagInfo(_td_c_when_204_4);
                    _jettag_c_when_204_4.doStart(context, out);
                    JET2Writer _jettag_c_when_204_4_saved_out = out;
                    while (_jettag_c_when_204_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 205, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 206, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 206, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 207, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 208, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 209, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 210, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 211, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 212, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_204_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_204_4_saved_out;
                    _jettag_c_when_204_4.doEnd();
                    RuntimeTagElement _jettag_c_when_214_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_214_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_214_4.setRuntimeParent(_jettag_c_choose_203_3);
                    _jettag_c_when_214_4.setTagInfo(_td_c_when_214_4);
                    _jettag_c_when_214_4.doStart(context, out);
                    JET2Writer _jettag_c_when_214_4_saved_out = out;
                    while (_jettag_c_when_214_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 215, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 216, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 216, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 217, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 218, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 219, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 220, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 221, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 222, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_214_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_214_4_saved_out;
                    _jettag_c_when_214_4.doEnd();
                    RuntimeTagElement _jettag_c_when_224_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_224_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_224_4.setRuntimeParent(_jettag_c_choose_203_3);
                    _jettag_c_when_224_4.setTagInfo(_td_c_when_224_4);
                    _jettag_c_when_224_4.doStart(context, out);
                    JET2Writer _jettag_c_when_224_4_saved_out = out;
                    while (_jettag_c_when_224_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_224_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_224_4_saved_out;
                    _jettag_c_when_224_4.doEnd();
                    RuntimeTagElement _jettag_c_when_227_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_227_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_227_4.setRuntimeParent(_jettag_c_choose_203_3);
                    _jettag_c_when_227_4.setTagInfo(_td_c_when_227_4);
                    _jettag_c_when_227_4.doStart(context, out);
                    JET2Writer _jettag_c_when_227_4_saved_out = out;
                    while (_jettag_c_when_227_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_227_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_227_4_saved_out;
                    _jettag_c_when_227_4.doEnd();
                    RuntimeTagElement _jettag_c_when_230_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_230_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_230_4.setRuntimeParent(_jettag_c_choose_203_3);
                    _jettag_c_when_230_4.setTagInfo(_td_c_when_230_4);
                    _jettag_c_when_230_4.doStart(context, out);
                    JET2Writer _jettag_c_when_230_4_saved_out = out;
                    while (_jettag_c_when_230_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 231, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 232, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 232, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 233, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 234, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 235, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 236, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 237, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 238, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_230_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_230_4_saved_out;
                    _jettag_c_when_230_4.doEnd();
                    RuntimeTagElement _jettag_c_when_240_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_240_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_240_4.setRuntimeParent(_jettag_c_choose_203_3);
                    _jettag_c_when_240_4.setTagInfo(_td_c_when_240_4);
                    _jettag_c_when_240_4.doStart(context, out);
                    JET2Writer _jettag_c_when_240_4_saved_out = out;
                    while (_jettag_c_when_240_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\tUILabel *");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 241, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 242, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L setText:@\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 242, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\"];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 243, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("L];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 244, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
                 pos=pos+pageSize; 
                        out.write( pos.toString() );
                        out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 245, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 246, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 247, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                        out.write(NL);         
                        out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 248, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_240_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_240_4_saved_out;
                    _jettag_c_when_240_4.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_250_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_250_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_250_3.setRuntimeParent(_jettag_c_choose_203_3);
                    _jettag_c_otherwise_250_3.setTagInfo(_td_c_otherwise_250_3);
                    _jettag_c_otherwise_250_3.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_250_3_saved_out = out;
                    while (_jettag_c_otherwise_250_3.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_iterate_251_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_251_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_251_4.setRuntimeParent(_jettag_c_otherwise_250_3);
                        _jettag_c_iterate_251_4.setTagInfo(_td_c_iterate_251_4);
                        _jettag_c_iterate_251_4.doStart(context, out);
                        while (_jettag_c_iterate_251_4.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_252_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_252_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_252_6.setRuntimeParent(_jettag_c_iterate_251_4);
                            _jettag_c_if_252_6.setTagInfo(_td_c_if_252_6);
                            _jettag_c_if_252_6.doStart(context, out);
                            while (_jettag_c_if_252_6.okToProcessBody()) {
                                // add  enums support
                                _jettag_c_if_252_6.handleBodyContent(out);
                            }
                            _jettag_c_if_252_6.doEnd();
                            _jettag_c_iterate_251_4.handleBodyContent(out);
                        }
                        _jettag_c_iterate_251_4.doEnd();
                        _jettag_c_otherwise_250_3.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_250_3_saved_out;
                    _jettag_c_otherwise_250_3.doEnd();
                    _jettag_c_choose_203_3.handleBodyContent(out);
                }
                out = _jettag_c_choose_203_3_saved_out;
                _jettag_c_choose_203_3.doEnd();
                _jettag_c_iterate_202_3.handleBodyContent(out);
            }
            _jettag_c_iterate_202_3.doEnd();
            _jettag_c_if_201_2.handleBodyContent(out);
        }
        _jettag_c_if_201_2.doEnd();
        // process parent class level 0 attributes
        RuntimeTagElement _jettag_c_iterate_261_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_261_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_261_2.setRuntimeParent(null);
        _jettag_c_iterate_261_2.setTagInfo(_td_c_iterate_261_2);
        _jettag_c_iterate_261_2.doStart(context, out);
        while (_jettag_c_iterate_261_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_choose_262_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_262_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_choose_262_3.setRuntimeParent(_jettag_c_iterate_261_2);
            _jettag_c_choose_262_3.setTagInfo(_td_c_choose_262_3);
            _jettag_c_choose_262_3.doStart(context, out);
            JET2Writer _jettag_c_choose_262_3_saved_out = out;
            while (_jettag_c_choose_262_3.okToProcessBody()) {
                out = out.newNestedContentWriter();
                RuntimeTagElement _jettag_c_when_263_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_263_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_263_4.setRuntimeParent(_jettag_c_choose_262_3);
                _jettag_c_when_263_4.setTagInfo(_td_c_when_263_4);
                _jettag_c_when_263_4.doStart(context, out);
                JET2Writer _jettag_c_when_263_4_saved_out = out;
                while (_jettag_c_when_263_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\tUILabel *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 264, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 265, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L setText:@\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 265, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 266, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 267, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 268, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 269, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 270, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 271, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF];");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_263_4.handleBodyContent(out);
                }
                out = _jettag_c_when_263_4_saved_out;
                _jettag_c_when_263_4.doEnd();
                RuntimeTagElement _jettag_c_when_273_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_273_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_273_4.setRuntimeParent(_jettag_c_choose_262_3);
                _jettag_c_when_273_4.setTagInfo(_td_c_when_273_4);
                _jettag_c_when_273_4.doStart(context, out);
                JET2Writer _jettag_c_when_273_4_saved_out = out;
                while (_jettag_c_when_273_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\tUILabel *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 274, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 275, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L setText:@\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 275, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 276, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 277, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 278, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 279, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 280, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 281, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF];");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_273_4.handleBodyContent(out);
                }
                out = _jettag_c_when_273_4_saved_out;
                _jettag_c_when_273_4.doEnd();
                RuntimeTagElement _jettag_c_when_283_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_283_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_283_4.setRuntimeParent(_jettag_c_choose_262_3);
                _jettag_c_when_283_4.setTagInfo(_td_c_when_283_4);
                _jettag_c_when_283_4.doStart(context, out);
                JET2Writer _jettag_c_when_283_4_saved_out = out;
                while (_jettag_c_when_283_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_283_4.handleBodyContent(out);
                }
                out = _jettag_c_when_283_4_saved_out;
                _jettag_c_when_283_4.doEnd();
                RuntimeTagElement _jettag_c_when_286_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_286_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_286_4.setRuntimeParent(_jettag_c_choose_262_3);
                _jettag_c_when_286_4.setTagInfo(_td_c_when_286_4);
                _jettag_c_when_286_4.doStart(context, out);
                JET2Writer _jettag_c_when_286_4_saved_out = out;
                while (_jettag_c_when_286_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_286_4.handleBodyContent(out);
                }
                out = _jettag_c_when_286_4_saved_out;
                _jettag_c_when_286_4.doEnd();
                RuntimeTagElement _jettag_c_when_289_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_289_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_289_4.setRuntimeParent(_jettag_c_choose_262_3);
                _jettag_c_when_289_4.setTagInfo(_td_c_when_289_4);
                _jettag_c_when_289_4.doStart(context, out);
                JET2Writer _jettag_c_when_289_4_saved_out = out;
                while (_jettag_c_when_289_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\tUILabel *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 290, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 291, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L setText:@\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 291, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 292, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 293, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 294, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 295, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 296, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 297, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF];");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_289_4.handleBodyContent(out);
                }
                out = _jettag_c_when_289_4_saved_out;
                _jettag_c_when_289_4.doEnd();
                RuntimeTagElement _jettag_c_when_299_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_299_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_299_4.setRuntimeParent(_jettag_c_choose_262_3);
                _jettag_c_when_299_4.setTagInfo(_td_c_when_299_4);
                _jettag_c_when_299_4.doStart(context, out);
                JET2Writer _jettag_c_when_299_4_saved_out = out;
                while (_jettag_c_when_299_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t\tUILabel *");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 300, 12)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L=[[[UILabel alloc] initWithFrame:CGRectMake(12,");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(",260,25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 301, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L setText:@\"");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 301, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("\"];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 302, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("L];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 303, 3)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF= [[[UITextField alloc] initWithFrame:CGRectMake(12, ");  //$NON-NLS-1$        
             pos=pos+pageSize; 
                    out.write( pos.toString() );
                    out.write(", 260, 25)] autorelease];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 304, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setBorderStyle:UITextBorderStyleLine];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 305, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF setFont:[UIFont fontWithName:@\"Times New Roman\" size:14]];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 306, 4)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF addTarget:self action:@selector(textFieldDoneEditing:) forControlEvents:UIControlEventEditingDidEndOnExit];");  //$NON-NLS-1$        
                    out.write(NL);         
                    out.write("\t\t[self.view addSubview:");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 307, 25)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF];");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_299_4.handleBodyContent(out);
                }
                out = _jettag_c_when_299_4_saved_out;
                _jettag_c_when_299_4.doEnd();
                RuntimeTagElement _jettag_c_otherwise_309_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_309_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_otherwise_309_3.setRuntimeParent(_jettag_c_choose_262_3);
                _jettag_c_otherwise_309_3.setTagInfo(_td_c_otherwise_309_3);
                _jettag_c_otherwise_309_3.doStart(context, out);
                JET2Writer _jettag_c_otherwise_309_3_saved_out = out;
                while (_jettag_c_otherwise_309_3.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_iterate_310_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_310_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_310_4.setRuntimeParent(_jettag_c_otherwise_309_3);
                    _jettag_c_iterate_310_4.setTagInfo(_td_c_iterate_310_4);
                    _jettag_c_iterate_310_4.doStart(context, out);
                    while (_jettag_c_iterate_310_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_311_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_311_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_311_6.setRuntimeParent(_jettag_c_iterate_310_4);
                        _jettag_c_if_311_6.setTagInfo(_td_c_if_311_6);
                        _jettag_c_if_311_6.doStart(context, out);
                        while (_jettag_c_if_311_6.okToProcessBody()) {
                            // add  enums support
                            _jettag_c_if_311_6.handleBodyContent(out);
                        }
                        _jettag_c_if_311_6.doEnd();
                        _jettag_c_iterate_310_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_310_4.doEnd();
                    _jettag_c_otherwise_309_3.handleBodyContent(out);
                }
                out = _jettag_c_otherwise_309_3_saved_out;
                _jettag_c_otherwise_309_3.doEnd();
                _jettag_c_choose_262_3.handleBodyContent(out);
            }
            out = _jettag_c_choose_262_3_saved_out;
            _jettag_c_choose_262_3.doEnd();
            _jettag_c_iterate_261_2.handleBodyContent(out);
        }
        _jettag_c_iterate_261_2.doEnd();
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void) configureOptionsView {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tCGRect optionsBarCanvas= CGRectMake(0.0, 385, 320, 30);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\toptionsBarView = [[[UIView alloc] initWithFrame:optionsBarCanvas] autorelease];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\toptionsBarView.backgroundColor=UIColor.redColor;");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\toptionsButton= [[UIButton buttonWithType:UIButtonTypeRoundedRect] retain];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\toptionsButton.frame = CGRectMake(0,0, 320, 30.0);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[optionsButton setTitle:@\"Options\" forState:UIControlStateNormal];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[optionsButton setTitleColor:[UIColor grayColor] forState:UIControlStateNormal ];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[optionsButton addTarget:self action:@selector(optionsClicked:) forControlEvents:UIControlEventTouchUpInside];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t[optionsBarView addSubview:optionsButton];\t");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("- (void) optionsClicked: (id) sender{");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tmenu = [[[UIActionSheet alloc] initWithTitle:@\"options\" delegate:self cancelButtonTitle:@\"cancel\" destructiveButtonTitle:nil otherButtonTitles:nil] autorelease];");  //$NON-NLS-1$        
        out.write(NL);         
        //process level 1 generizations associatons 
        RuntimeTagElement _jettag_c_if_337_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_337_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_337_1.setRuntimeParent(null);
        _jettag_c_if_337_1.setTagInfo(_td_c_if_337_1);
        _jettag_c_if_337_1.doStart(context, out);
        while (_jettag_c_if_337_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_setVariable_338_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_338_6); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_338_6.setRuntimeParent(_jettag_c_if_337_1);
            _jettag_c_setVariable_338_6.setTagInfo(_td_c_setVariable_338_6);
            _jettag_c_setVariable_338_6.doStart(context, out);
            _jettag_c_setVariable_338_6.doEnd();
            // process the assocations for level 1 class 
            RuntimeTagElement _jettag_c_iterate_340_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_340_8); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_340_8.setRuntimeParent(_jettag_c_if_337_1);
            _jettag_c_iterate_340_8.setTagInfo(_td_c_iterate_340_8);
            _jettag_c_iterate_340_8.doStart(context, out);
            while (_jettag_c_iterate_340_8.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_341_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_341_9); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_341_9.setRuntimeParent(_jettag_c_iterate_340_8);
                _jettag_c_iterate_341_9.setTagInfo(_td_c_iterate_341_9);
                _jettag_c_iterate_341_9.doStart(context, out);
                while (_jettag_c_iterate_341_9.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_342_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_342_10); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_342_10.setRuntimeParent(_jettag_c_iterate_341_9);
                    _jettag_c_iterate_342_10.setTagInfo(_td_c_iterate_342_10);
                    _jettag_c_iterate_342_10.doStart(context, out);
                    while (_jettag_c_iterate_342_10.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_343_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_343_11); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_343_11.setRuntimeParent(_jettag_c_iterate_342_10);
                        _jettag_c_setVariable_343_11.setTagInfo(_td_c_setVariable_343_11);
                        _jettag_c_setVariable_343_11.doStart(context, out);
                        _jettag_c_setVariable_343_11.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_345_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_345_13); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_345_13.setRuntimeParent(_jettag_c_iterate_342_10);
                        _jettag_c_if_345_13.setTagInfo(_td_c_if_345_13);
                        _jettag_c_if_345_13.doStart(context, out);
                        while (_jettag_c_if_345_13.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_347_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_347_19); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_347_19.setRuntimeParent(_jettag_c_if_345_13);
                            _jettag_c_iterate_347_19.setTagInfo(_td_c_iterate_347_19);
                            _jettag_c_iterate_347_19.doStart(context, out);
                            while (_jettag_c_iterate_347_19.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_349_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_349_18); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_349_18.setRuntimeParent(_jettag_c_iterate_347_19);
                                _jettag_c_if_349_18.setTagInfo(_td_c_if_349_18);
                                _jettag_c_if_349_18.doStart(context, out);
                                while (_jettag_c_if_349_18.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_350_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_350_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_350_18.setRuntimeParent(_jettag_c_if_349_18);
                                    _jettag_c_if_350_18.setTagInfo(_td_c_if_350_18);
                                    _jettag_c_if_350_18.doStart(context, out);
                                    while (_jettag_c_if_350_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_351_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_351_19); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_351_19.setRuntimeParent(_jettag_c_if_350_18);
                                        _jettag_c_setVariable_351_19.setTagInfo(_td_c_setVariable_351_19);
                                        _jettag_c_setVariable_351_19.doStart(context, out);
                                        _jettag_c_setVariable_351_19.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_353_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_353_21); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_353_21.setRuntimeParent(_jettag_c_if_350_18);
                                        _jettag_c_if_353_21.setTagInfo(_td_c_if_353_21);
                                        _jettag_c_if_353_21.doStart(context, out);
                                        while (_jettag_c_if_353_21.okToProcessBody()) {
                                            // check to see if this is a navigable relation
                                            RuntimeTagElement _jettag_c_if_355_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_355_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_355_19.setRuntimeParent(_jettag_c_if_353_21);
                                            _jettag_c_if_355_19.setTagInfo(_td_c_if_355_19);
                                            _jettag_c_if_355_19.doStart(context, out);
                                            while (_jettag_c_if_355_19.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_357_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_357_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_357_22.setRuntimeParent(_jettag_c_if_355_19);
                                                _jettag_c_iterate_357_22.setTagInfo(_td_c_iterate_357_22);
                                                _jettag_c_iterate_357_22.doStart(context, out);
                                                while (_jettag_c_iterate_357_22.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_358_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_358_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_358_23.setRuntimeParent(_jettag_c_iterate_357_22);
                                                    _jettag_c_if_358_23.setTagInfo(_td_c_if_358_23);
                                                    _jettag_c_if_358_23.doStart(context, out);
                                                    while (_jettag_c_if_358_23.okToProcessBody()) {
                                                        out.write("\t[menu addButtonWithTitle:@\"");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 359, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s\"];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_358_23.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_358_23.doEnd();
                                                    _jettag_c_iterate_357_22.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_357_22.doEnd();
                                                _jettag_c_if_355_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_355_19.doEnd();
                                            _jettag_c_if_353_21.handleBodyContent(out);
                                        }
                                        _jettag_c_if_353_21.doEnd();
                                        _jettag_c_if_350_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_350_18.doEnd();
                                    _jettag_c_if_349_18.handleBodyContent(out);
                                }
                                _jettag_c_if_349_18.doEnd();
                                _jettag_c_iterate_347_19.handleBodyContent(out);
                            }
                            _jettag_c_iterate_347_19.doEnd();
                            out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_345_13.handleBodyContent(out);
                        }
                        _jettag_c_if_345_13.doEnd();
                        _jettag_c_iterate_342_10.handleBodyContent(out);
                    }
                    _jettag_c_iterate_342_10.doEnd();
                    _jettag_c_iterate_341_9.handleBodyContent(out);
                }
                _jettag_c_iterate_341_9.doEnd();
                _jettag_c_iterate_340_8.handleBodyContent(out);
            }
            _jettag_c_iterate_340_8.doEnd();
            _jettag_c_if_337_1.handleBodyContent(out);
        }
        _jettag_c_if_337_1.doEnd();
        //process level 2 generizations 
        RuntimeTagElement _jettag_c_if_374_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_374_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_374_1.setRuntimeParent(null);
        _jettag_c_if_374_1.setTagInfo(_td_c_if_374_1);
        _jettag_c_if_374_1.doStart(context, out);
        while (_jettag_c_if_374_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_setVariable_375_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_375_6); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_375_6.setRuntimeParent(_jettag_c_if_374_1);
            _jettag_c_setVariable_375_6.setTagInfo(_td_c_setVariable_375_6);
            _jettag_c_setVariable_375_6.doStart(context, out);
            _jettag_c_setVariable_375_6.doEnd();
            // process the assocations for level 1 class 
            RuntimeTagElement _jettag_c_iterate_377_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_377_8); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_377_8.setRuntimeParent(_jettag_c_if_374_1);
            _jettag_c_iterate_377_8.setTagInfo(_td_c_iterate_377_8);
            _jettag_c_iterate_377_8.doStart(context, out);
            while (_jettag_c_iterate_377_8.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_378_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_378_9); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_378_9.setRuntimeParent(_jettag_c_iterate_377_8);
                _jettag_c_iterate_378_9.setTagInfo(_td_c_iterate_378_9);
                _jettag_c_iterate_378_9.doStart(context, out);
                while (_jettag_c_iterate_378_9.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_379_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_379_10); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_379_10.setRuntimeParent(_jettag_c_iterate_378_9);
                    _jettag_c_iterate_379_10.setTagInfo(_td_c_iterate_379_10);
                    _jettag_c_iterate_379_10.doStart(context, out);
                    while (_jettag_c_iterate_379_10.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_380_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_380_11); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_380_11.setRuntimeParent(_jettag_c_iterate_379_10);
                        _jettag_c_setVariable_380_11.setTagInfo(_td_c_setVariable_380_11);
                        _jettag_c_setVariable_380_11.doStart(context, out);
                        _jettag_c_setVariable_380_11.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_382_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_382_13); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_382_13.setRuntimeParent(_jettag_c_iterate_379_10);
                        _jettag_c_if_382_13.setTagInfo(_td_c_if_382_13);
                        _jettag_c_if_382_13.doStart(context, out);
                        while (_jettag_c_if_382_13.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_384_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_384_19); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_384_19.setRuntimeParent(_jettag_c_if_382_13);
                            _jettag_c_iterate_384_19.setTagInfo(_td_c_iterate_384_19);
                            _jettag_c_iterate_384_19.doStart(context, out);
                            while (_jettag_c_iterate_384_19.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_386_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_386_18); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_386_18.setRuntimeParent(_jettag_c_iterate_384_19);
                                _jettag_c_if_386_18.setTagInfo(_td_c_if_386_18);
                                _jettag_c_if_386_18.doStart(context, out);
                                while (_jettag_c_if_386_18.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_387_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_387_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_387_18.setRuntimeParent(_jettag_c_if_386_18);
                                    _jettag_c_if_387_18.setTagInfo(_td_c_if_387_18);
                                    _jettag_c_if_387_18.doStart(context, out);
                                    while (_jettag_c_if_387_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_388_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_388_19); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_388_19.setRuntimeParent(_jettag_c_if_387_18);
                                        _jettag_c_setVariable_388_19.setTagInfo(_td_c_setVariable_388_19);
                                        _jettag_c_setVariable_388_19.doStart(context, out);
                                        _jettag_c_setVariable_388_19.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_390_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_390_21); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_390_21.setRuntimeParent(_jettag_c_if_387_18);
                                        _jettag_c_if_390_21.setTagInfo(_td_c_if_390_21);
                                        _jettag_c_if_390_21.doStart(context, out);
                                        while (_jettag_c_if_390_21.okToProcessBody()) {
                                            // check to see if this is a navigable relation
                                            RuntimeTagElement _jettag_c_if_392_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_392_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_392_19.setRuntimeParent(_jettag_c_if_390_21);
                                            _jettag_c_if_392_19.setTagInfo(_td_c_if_392_19);
                                            _jettag_c_if_392_19.doStart(context, out);
                                            while (_jettag_c_if_392_19.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_394_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_394_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_394_22.setRuntimeParent(_jettag_c_if_392_19);
                                                _jettag_c_iterate_394_22.setTagInfo(_td_c_iterate_394_22);
                                                _jettag_c_iterate_394_22.doStart(context, out);
                                                while (_jettag_c_iterate_394_22.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_395_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_395_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_395_23.setRuntimeParent(_jettag_c_iterate_394_22);
                                                    _jettag_c_if_395_23.setTagInfo(_td_c_if_395_23);
                                                    _jettag_c_if_395_23.doStart(context, out);
                                                    while (_jettag_c_if_395_23.okToProcessBody()) {
                                                        out.write("\t[menu addButtonWithTitle:@\"");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 396, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s\"];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_395_23.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_395_23.doEnd();
                                                    _jettag_c_iterate_394_22.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_394_22.doEnd();
                                                _jettag_c_if_392_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_392_19.doEnd();
                                            _jettag_c_if_390_21.handleBodyContent(out);
                                        }
                                        _jettag_c_if_390_21.doEnd();
                                        _jettag_c_if_387_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_387_18.doEnd();
                                    _jettag_c_if_386_18.handleBodyContent(out);
                                }
                                _jettag_c_if_386_18.doEnd();
                                _jettag_c_iterate_384_19.handleBodyContent(out);
                            }
                            _jettag_c_iterate_384_19.doEnd();
                            out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_382_13.handleBodyContent(out);
                        }
                        _jettag_c_if_382_13.doEnd();
                        _jettag_c_iterate_379_10.handleBodyContent(out);
                    }
                    _jettag_c_iterate_379_10.doEnd();
                    _jettag_c_iterate_378_9.handleBodyContent(out);
                }
                _jettag_c_iterate_378_9.doEnd();
                _jettag_c_iterate_377_8.handleBodyContent(out);
            }
            _jettag_c_iterate_377_8.doEnd();
            _jettag_c_if_374_1.handleBodyContent(out);
        }
        _jettag_c_if_374_1.doEnd();
        out.write(NL);         
        RuntimeTagElement _jettag_c_setVariable_411_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_411_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_411_1.setRuntimeParent(null);
        _jettag_c_setVariable_411_1.setTagInfo(_td_c_setVariable_411_1);
        _jettag_c_setVariable_411_1.doStart(context, out);
        _jettag_c_setVariable_411_1.doEnd();
        //process 0 level class relations 
        RuntimeTagElement _jettag_c_iterate_413_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_413_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_413_1.setRuntimeParent(null);
        _jettag_c_iterate_413_1.setTagInfo(_td_c_iterate_413_1);
        _jettag_c_iterate_413_1.doStart(context, out);
        while (_jettag_c_iterate_413_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_414_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_414_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_414_2.setRuntimeParent(_jettag_c_iterate_413_1);
            _jettag_c_iterate_414_2.setTagInfo(_td_c_iterate_414_2);
            _jettag_c_iterate_414_2.doStart(context, out);
            while (_jettag_c_iterate_414_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_415_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_415_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_415_3.setRuntimeParent(_jettag_c_iterate_414_2);
                _jettag_c_iterate_415_3.setTagInfo(_td_c_iterate_415_3);
                _jettag_c_iterate_415_3.doStart(context, out);
                while (_jettag_c_iterate_415_3.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_416_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_416_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_416_4.setRuntimeParent(_jettag_c_iterate_415_3);
                    _jettag_c_setVariable_416_4.setTagInfo(_td_c_setVariable_416_4);
                    _jettag_c_setVariable_416_4.doStart(context, out);
                    _jettag_c_setVariable_416_4.doEnd();
                    // check is the association is corresponding to the class  
                    RuntimeTagElement _jettag_c_if_418_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_418_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_418_6.setRuntimeParent(_jettag_c_iterate_415_3);
                    _jettag_c_if_418_6.setTagInfo(_td_c_if_418_6);
                    _jettag_c_if_418_6.doStart(context, out);
                    while (_jettag_c_if_418_6.okToProcessBody()) {
                        // iterate over the iterations ends  
                        RuntimeTagElement _jettag_c_iterate_420_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_420_12); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_420_12.setRuntimeParent(_jettag_c_if_418_6);
                        _jettag_c_iterate_420_12.setTagInfo(_td_c_iterate_420_12);
                        _jettag_c_iterate_420_12.doStart(context, out);
                        while (_jettag_c_iterate_420_12.okToProcessBody()) {
                            // process only non composits or non aggregations and 
                            RuntimeTagElement _jettag_c_if_422_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_422_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_422_12.setRuntimeParent(_jettag_c_iterate_420_12);
                            _jettag_c_if_422_12.setTagInfo(_td_c_if_422_12);
                            _jettag_c_if_422_12.doStart(context, out);
                            while (_jettag_c_if_422_12.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_423_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_423_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_423_12.setRuntimeParent(_jettag_c_if_422_12);
                                _jettag_c_setVariable_423_12.setTagInfo(_td_c_setVariable_423_12);
                                _jettag_c_setVariable_423_12.doStart(context, out);
                                _jettag_c_setVariable_423_12.doEnd();
                                // get the end secondary end with other class  
                                RuntimeTagElement _jettag_c_if_425_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_425_14); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_425_14.setRuntimeParent(_jettag_c_if_422_12);
                                _jettag_c_if_425_14.setTagInfo(_td_c_if_425_14);
                                _jettag_c_if_425_14.doStart(context, out);
                                while (_jettag_c_if_425_14.okToProcessBody()) {
                                    // check to see if this is a navigable relation
                                    RuntimeTagElement _jettag_c_if_427_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_427_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_427_14.setRuntimeParent(_jettag_c_if_425_14);
                                    _jettag_c_if_427_14.setTagInfo(_td_c_if_427_14);
                                    _jettag_c_if_427_14.doStart(context, out);
                                    while (_jettag_c_if_427_14.okToProcessBody()) {
                                        // process many on target
                                        RuntimeTagElement _jettag_c_if_429_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_429_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_429_9.setRuntimeParent(_jettag_c_if_427_14);
                                        _jettag_c_if_429_9.setTagInfo(_td_c_if_429_9);
                                        _jettag_c_if_429_9.doStart(context, out);
                                        while (_jettag_c_if_429_9.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_430_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_430_11); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_430_11.setRuntimeParent(_jettag_c_if_429_9);
                                            _jettag_c_if_430_11.setTagInfo(_td_c_if_430_11);
                                            _jettag_c_if_430_11.doStart(context, out);
                                            while (_jettag_c_if_430_11.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_432_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_432_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_432_15.setRuntimeParent(_jettag_c_if_430_11);
                                                _jettag_c_iterate_432_15.setTagInfo(_td_c_iterate_432_15);
                                                _jettag_c_iterate_432_15.doStart(context, out);
                                                while (_jettag_c_iterate_432_15.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_433_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_433_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_433_16.setRuntimeParent(_jettag_c_iterate_432_15);
                                                    _jettag_c_if_433_16.setTagInfo(_td_c_if_433_16);
                                                    _jettag_c_if_433_16.doStart(context, out);
                                                    while (_jettag_c_if_433_16.okToProcessBody()) {
                                                        out.write("\t[menu addButtonWithTitle:@\"");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 434, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s\"];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_433_16.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_433_16.doEnd();
                                                    _jettag_c_iterate_432_15.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_432_15.doEnd();
                                                _jettag_c_if_430_11.handleBodyContent(out);
                                            }
                                            _jettag_c_if_430_11.doEnd();
                                            _jettag_c_if_429_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_429_9.doEnd();
                                        _jettag_c_if_427_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_427_14.doEnd();
                                    _jettag_c_if_425_14.handleBodyContent(out);
                                }
                                _jettag_c_if_425_14.doEnd();
                                _jettag_c_if_422_12.handleBodyContent(out);
                            }
                            _jettag_c_if_422_12.doEnd();
                            _jettag_c_iterate_420_12.handleBodyContent(out);
                        }
                        _jettag_c_iterate_420_12.doEnd();
                        _jettag_c_if_418_6.handleBodyContent(out);
                    }
                    _jettag_c_if_418_6.doEnd();
                    _jettag_c_iterate_415_3.handleBodyContent(out);
                }
                _jettag_c_iterate_415_3.doEnd();
                _jettag_c_iterate_414_2.handleBodyContent(out);
            }
            _jettag_c_iterate_414_2.doEnd();
            _jettag_c_iterate_413_1.handleBodyContent(out);
        }
        _jettag_c_iterate_413_1.doEnd();
        out.write("\t[menu showInView:self.view];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("-(void)actionSheet:(UIActionSheet *)actionSheet clickedButtonAtIndex:(NSInteger)buttonIndex {");  //$NON-NLS-1$        
        out.write(NL);         
        //process level 1 generizations associatons 
        RuntimeTagElement _jettag_c_if_452_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_452_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_452_1.setRuntimeParent(null);
        _jettag_c_if_452_1.setTagInfo(_td_c_if_452_1);
        _jettag_c_if_452_1.doStart(context, out);
        while (_jettag_c_if_452_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_setVariable_453_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_453_6); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_453_6.setRuntimeParent(_jettag_c_if_452_1);
            _jettag_c_setVariable_453_6.setTagInfo(_td_c_setVariable_453_6);
            _jettag_c_setVariable_453_6.doStart(context, out);
            _jettag_c_setVariable_453_6.doEnd();
            // process the assocations for level 1 class 
            RuntimeTagElement _jettag_c_iterate_455_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_455_8); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_455_8.setRuntimeParent(_jettag_c_if_452_1);
            _jettag_c_iterate_455_8.setTagInfo(_td_c_iterate_455_8);
            _jettag_c_iterate_455_8.doStart(context, out);
            while (_jettag_c_iterate_455_8.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_456_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_456_9); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_456_9.setRuntimeParent(_jettag_c_iterate_455_8);
                _jettag_c_iterate_456_9.setTagInfo(_td_c_iterate_456_9);
                _jettag_c_iterate_456_9.doStart(context, out);
                while (_jettag_c_iterate_456_9.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_457_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_457_10); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_457_10.setRuntimeParent(_jettag_c_iterate_456_9);
                    _jettag_c_iterate_457_10.setTagInfo(_td_c_iterate_457_10);
                    _jettag_c_iterate_457_10.doStart(context, out);
                    while (_jettag_c_iterate_457_10.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_458_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_458_11); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_458_11.setRuntimeParent(_jettag_c_iterate_457_10);
                        _jettag_c_setVariable_458_11.setTagInfo(_td_c_setVariable_458_11);
                        _jettag_c_setVariable_458_11.doStart(context, out);
                        _jettag_c_setVariable_458_11.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_460_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_460_13); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_460_13.setRuntimeParent(_jettag_c_iterate_457_10);
                        _jettag_c_if_460_13.setTagInfo(_td_c_if_460_13);
                        _jettag_c_if_460_13.doStart(context, out);
                        while (_jettag_c_if_460_13.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_462_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_462_19); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_462_19.setRuntimeParent(_jettag_c_if_460_13);
                            _jettag_c_iterate_462_19.setTagInfo(_td_c_iterate_462_19);
                            _jettag_c_iterate_462_19.doStart(context, out);
                            while (_jettag_c_iterate_462_19.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_464_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_464_18); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_464_18.setRuntimeParent(_jettag_c_iterate_462_19);
                                _jettag_c_if_464_18.setTagInfo(_td_c_if_464_18);
                                _jettag_c_if_464_18.doStart(context, out);
                                while (_jettag_c_if_464_18.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_465_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_465_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_465_18.setRuntimeParent(_jettag_c_if_464_18);
                                    _jettag_c_if_465_18.setTagInfo(_td_c_if_465_18);
                                    _jettag_c_if_465_18.doStart(context, out);
                                    while (_jettag_c_if_465_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_466_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_466_19); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_466_19.setRuntimeParent(_jettag_c_if_465_18);
                                        _jettag_c_setVariable_466_19.setTagInfo(_td_c_setVariable_466_19);
                                        _jettag_c_setVariable_466_19.doStart(context, out);
                                        _jettag_c_setVariable_466_19.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_468_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_468_21); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_468_21.setRuntimeParent(_jettag_c_if_465_18);
                                        _jettag_c_if_468_21.setTagInfo(_td_c_if_468_21);
                                        _jettag_c_if_468_21.doStart(context, out);
                                        while (_jettag_c_if_468_21.okToProcessBody()) {
                                            // check to see if this is a navigable relation
                                            RuntimeTagElement _jettag_c_if_470_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_470_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_470_19.setRuntimeParent(_jettag_c_if_468_21);
                                            _jettag_c_if_470_19.setTagInfo(_td_c_if_470_19);
                                            _jettag_c_if_470_19.doStart(context, out);
                                            while (_jettag_c_if_470_19.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_472_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_472_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_472_22.setRuntimeParent(_jettag_c_if_470_19);
                                                _jettag_c_iterate_472_22.setTagInfo(_td_c_iterate_472_22);
                                                _jettag_c_iterate_472_22.doStart(context, out);
                                                while (_jettag_c_iterate_472_22.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_473_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_473_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_473_23.setRuntimeParent(_jettag_c_iterate_472_22);
                                                    _jettag_c_if_473_23.setTagInfo(_td_c_if_473_23);
                                                    _jettag_c_if_473_23.doStart(context, out);
                                                    while (_jettag_c_if_473_23.okToProcessBody()) {
                                                        out.write("\tif([[menu buttonTitleAtIndex:buttonIndex] isEqualToString:@\"");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 474, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s\"]){");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\tNSLog(@\"");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 475, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s clicked\");");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\tReadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 476, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController *readAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 476, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController = [[ReadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 476, 93)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController alloc] initWithNibName:nil bundle:nil];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\treadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 477, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController.parent=");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 477, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\tint ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 478, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Id=[");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 478, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entityID intValue];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\treadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 479, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController.parentResource=[[self getReadURLWithID:");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 479, 81)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Id] stringByAppendingFormat:@\"/");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 479, 139)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s\"];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t[self.navigationController pushViewController:readAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 480, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController animated:YES];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t[readAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 481, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController release];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\treadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 482, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController = nil;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t}\t\t\t\t\t\t  \t\t\t\t\t  \t\t \t\t\t ");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_473_23.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_473_23.doEnd();
                                                    _jettag_c_iterate_472_22.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_472_22.doEnd();
                                                _jettag_c_if_470_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_470_19.doEnd();
                                            _jettag_c_if_468_21.handleBodyContent(out);
                                        }
                                        _jettag_c_if_468_21.doEnd();
                                        _jettag_c_if_465_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_465_18.doEnd();
                                    _jettag_c_if_464_18.handleBodyContent(out);
                                }
                                _jettag_c_if_464_18.doEnd();
                                _jettag_c_iterate_462_19.handleBodyContent(out);
                            }
                            _jettag_c_iterate_462_19.doEnd();
                            out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_460_13.handleBodyContent(out);
                        }
                        _jettag_c_if_460_13.doEnd();
                        _jettag_c_iterate_457_10.handleBodyContent(out);
                    }
                    _jettag_c_iterate_457_10.doEnd();
                    _jettag_c_iterate_456_9.handleBodyContent(out);
                }
                _jettag_c_iterate_456_9.doEnd();
                _jettag_c_iterate_455_8.handleBodyContent(out);
            }
            _jettag_c_iterate_455_8.doEnd();
            _jettag_c_if_452_1.handleBodyContent(out);
        }
        _jettag_c_if_452_1.doEnd();
        //process level 2 generizations 
        RuntimeTagElement _jettag_c_if_498_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_498_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_498_1.setRuntimeParent(null);
        _jettag_c_if_498_1.setTagInfo(_td_c_if_498_1);
        _jettag_c_if_498_1.doStart(context, out);
        while (_jettag_c_if_498_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_setVariable_499_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_499_6); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_499_6.setRuntimeParent(_jettag_c_if_498_1);
            _jettag_c_setVariable_499_6.setTagInfo(_td_c_setVariable_499_6);
            _jettag_c_setVariable_499_6.doStart(context, out);
            _jettag_c_setVariable_499_6.doEnd();
            // process the assocations for level 1 class 
            RuntimeTagElement _jettag_c_iterate_501_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_501_8); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_501_8.setRuntimeParent(_jettag_c_if_498_1);
            _jettag_c_iterate_501_8.setTagInfo(_td_c_iterate_501_8);
            _jettag_c_iterate_501_8.doStart(context, out);
            while (_jettag_c_iterate_501_8.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_502_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_502_9); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_502_9.setRuntimeParent(_jettag_c_iterate_501_8);
                _jettag_c_iterate_502_9.setTagInfo(_td_c_iterate_502_9);
                _jettag_c_iterate_502_9.doStart(context, out);
                while (_jettag_c_iterate_502_9.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_503_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_503_10); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_503_10.setRuntimeParent(_jettag_c_iterate_502_9);
                    _jettag_c_iterate_503_10.setTagInfo(_td_c_iterate_503_10);
                    _jettag_c_iterate_503_10.doStart(context, out);
                    while (_jettag_c_iterate_503_10.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_504_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_504_11); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_504_11.setRuntimeParent(_jettag_c_iterate_503_10);
                        _jettag_c_setVariable_504_11.setTagInfo(_td_c_setVariable_504_11);
                        _jettag_c_setVariable_504_11.doStart(context, out);
                        _jettag_c_setVariable_504_11.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_506_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_506_13); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_506_13.setRuntimeParent(_jettag_c_iterate_503_10);
                        _jettag_c_if_506_13.setTagInfo(_td_c_if_506_13);
                        _jettag_c_if_506_13.doStart(context, out);
                        while (_jettag_c_if_506_13.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_508_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_508_19); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_508_19.setRuntimeParent(_jettag_c_if_506_13);
                            _jettag_c_iterate_508_19.setTagInfo(_td_c_iterate_508_19);
                            _jettag_c_iterate_508_19.doStart(context, out);
                            while (_jettag_c_iterate_508_19.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_510_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_510_18); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_510_18.setRuntimeParent(_jettag_c_iterate_508_19);
                                _jettag_c_if_510_18.setTagInfo(_td_c_if_510_18);
                                _jettag_c_if_510_18.doStart(context, out);
                                while (_jettag_c_if_510_18.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_if_511_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_511_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_511_18.setRuntimeParent(_jettag_c_if_510_18);
                                    _jettag_c_if_511_18.setTagInfo(_td_c_if_511_18);
                                    _jettag_c_if_511_18.doStart(context, out);
                                    while (_jettag_c_if_511_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_setVariable_512_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_512_19); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_setVariable_512_19.setRuntimeParent(_jettag_c_if_511_18);
                                        _jettag_c_setVariable_512_19.setTagInfo(_td_c_setVariable_512_19);
                                        _jettag_c_setVariable_512_19.doStart(context, out);
                                        _jettag_c_setVariable_512_19.doEnd();
                                        // get the end secondary end with other class  
                                        RuntimeTagElement _jettag_c_if_514_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_514_21); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_514_21.setRuntimeParent(_jettag_c_if_511_18);
                                        _jettag_c_if_514_21.setTagInfo(_td_c_if_514_21);
                                        _jettag_c_if_514_21.doStart(context, out);
                                        while (_jettag_c_if_514_21.okToProcessBody()) {
                                            // check to see if this is a navigable relation
                                            RuntimeTagElement _jettag_c_if_516_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_516_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_516_19.setRuntimeParent(_jettag_c_if_514_21);
                                            _jettag_c_if_516_19.setTagInfo(_td_c_if_516_19);
                                            _jettag_c_if_516_19.doStart(context, out);
                                            while (_jettag_c_if_516_19.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_518_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_518_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_518_22.setRuntimeParent(_jettag_c_if_516_19);
                                                _jettag_c_iterate_518_22.setTagInfo(_td_c_iterate_518_22);
                                                _jettag_c_iterate_518_22.doStart(context, out);
                                                while (_jettag_c_iterate_518_22.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_519_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_519_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_519_23.setRuntimeParent(_jettag_c_iterate_518_22);
                                                    _jettag_c_if_519_23.setTagInfo(_td_c_if_519_23);
                                                    _jettag_c_if_519_23.doStart(context, out);
                                                    while (_jettag_c_if_519_23.okToProcessBody()) {
                                                        out.write("\tif([[menu buttonTitleAtIndex:buttonIndex] isEqualToString:@\"");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 520, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s\"]){");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\tNSLog(@\"");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 521, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s clicked\");");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\tReadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 522, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController *readAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 522, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController = [[ReadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 522, 93)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController alloc] initWithNibName:nil bundle:nil];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\treadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 523, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController.parent=");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 523, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\tint ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 524, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Id=[");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 524, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entityID intValue];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\treadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 525, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController.parentResource=[[self getReadURLWithID:");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 525, 81)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Id] stringByAppendingFormat:@\"/");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 525, 139)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s\"];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t[self.navigationController pushViewController:readAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 526, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController animated:YES];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t[readAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 527, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController release];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\treadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 528, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController = nil;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t}");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_519_23.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_519_23.doEnd();
                                                    _jettag_c_iterate_518_22.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_518_22.doEnd();
                                                _jettag_c_if_516_19.handleBodyContent(out);
                                            }
                                            _jettag_c_if_516_19.doEnd();
                                            _jettag_c_if_514_21.handleBodyContent(out);
                                        }
                                        _jettag_c_if_514_21.doEnd();
                                        _jettag_c_if_511_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_511_18.doEnd();
                                    _jettag_c_if_510_18.handleBodyContent(out);
                                }
                                _jettag_c_if_510_18.doEnd();
                                _jettag_c_iterate_508_19.handleBodyContent(out);
                            }
                            _jettag_c_iterate_508_19.doEnd();
                            out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_if_506_13.handleBodyContent(out);
                        }
                        _jettag_c_if_506_13.doEnd();
                        _jettag_c_iterate_503_10.handleBodyContent(out);
                    }
                    _jettag_c_iterate_503_10.doEnd();
                    _jettag_c_iterate_502_9.handleBodyContent(out);
                }
                _jettag_c_iterate_502_9.doEnd();
                _jettag_c_iterate_501_8.handleBodyContent(out);
            }
            _jettag_c_iterate_501_8.doEnd();
            _jettag_c_if_498_1.handleBodyContent(out);
        }
        _jettag_c_if_498_1.doEnd();
        out.write(NL);         
        RuntimeTagElement _jettag_c_setVariable_544_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_544_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_544_1.setRuntimeParent(null);
        _jettag_c_setVariable_544_1.setTagInfo(_td_c_setVariable_544_1);
        _jettag_c_setVariable_544_1.doStart(context, out);
        _jettag_c_setVariable_544_1.doEnd();
        //process 0 level class relations 
        RuntimeTagElement _jettag_c_iterate_546_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_546_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_546_1.setRuntimeParent(null);
        _jettag_c_iterate_546_1.setTagInfo(_td_c_iterate_546_1);
        _jettag_c_iterate_546_1.doStart(context, out);
        while (_jettag_c_iterate_546_1.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_547_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_547_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_547_2.setRuntimeParent(_jettag_c_iterate_546_1);
            _jettag_c_iterate_547_2.setTagInfo(_td_c_iterate_547_2);
            _jettag_c_iterate_547_2.doStart(context, out);
            while (_jettag_c_iterate_547_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_548_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_548_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_548_3.setRuntimeParent(_jettag_c_iterate_547_2);
                _jettag_c_iterate_548_3.setTagInfo(_td_c_iterate_548_3);
                _jettag_c_iterate_548_3.doStart(context, out);
                while (_jettag_c_iterate_548_3.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_setVariable_549_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_549_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_setVariable_549_4.setRuntimeParent(_jettag_c_iterate_548_3);
                    _jettag_c_setVariable_549_4.setTagInfo(_td_c_setVariable_549_4);
                    _jettag_c_setVariable_549_4.doStart(context, out);
                    _jettag_c_setVariable_549_4.doEnd();
                    // check is the association is corresponding to the class  
                    RuntimeTagElement _jettag_c_if_551_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_551_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_if_551_6.setRuntimeParent(_jettag_c_iterate_548_3);
                    _jettag_c_if_551_6.setTagInfo(_td_c_if_551_6);
                    _jettag_c_if_551_6.doStart(context, out);
                    while (_jettag_c_if_551_6.okToProcessBody()) {
                        // iterate over the iterations ends  
                        RuntimeTagElement _jettag_c_iterate_553_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_553_12); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_553_12.setRuntimeParent(_jettag_c_if_551_6);
                        _jettag_c_iterate_553_12.setTagInfo(_td_c_iterate_553_12);
                        _jettag_c_iterate_553_12.doStart(context, out);
                        while (_jettag_c_iterate_553_12.okToProcessBody()) {
                            // process only non composits or non aggregations and 
                            RuntimeTagElement _jettag_c_if_555_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_555_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_555_12.setRuntimeParent(_jettag_c_iterate_553_12);
                            _jettag_c_if_555_12.setTagInfo(_td_c_if_555_12);
                            _jettag_c_if_555_12.doStart(context, out);
                            while (_jettag_c_if_555_12.okToProcessBody()) {
                                RuntimeTagElement _jettag_c_setVariable_556_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_556_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_setVariable_556_12.setRuntimeParent(_jettag_c_if_555_12);
                                _jettag_c_setVariable_556_12.setTagInfo(_td_c_setVariable_556_12);
                                _jettag_c_setVariable_556_12.doStart(context, out);
                                _jettag_c_setVariable_556_12.doEnd();
                                // get the end secondary end with other class  
                                RuntimeTagElement _jettag_c_if_558_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_558_14); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_558_14.setRuntimeParent(_jettag_c_if_555_12);
                                _jettag_c_if_558_14.setTagInfo(_td_c_if_558_14);
                                _jettag_c_if_558_14.doStart(context, out);
                                while (_jettag_c_if_558_14.okToProcessBody()) {
                                    // check to see if this is a navigable relation
                                    RuntimeTagElement _jettag_c_if_560_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_560_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_560_14.setRuntimeParent(_jettag_c_if_558_14);
                                    _jettag_c_if_560_14.setTagInfo(_td_c_if_560_14);
                                    _jettag_c_if_560_14.doStart(context, out);
                                    while (_jettag_c_if_560_14.okToProcessBody()) {
                                        // process many on target
                                        RuntimeTagElement _jettag_c_if_562_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_562_9); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_562_9.setRuntimeParent(_jettag_c_if_560_14);
                                        _jettag_c_if_562_9.setTagInfo(_td_c_if_562_9);
                                        _jettag_c_if_562_9.doStart(context, out);
                                        while (_jettag_c_if_562_9.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_if_563_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_563_11); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_563_11.setRuntimeParent(_jettag_c_if_562_9);
                                            _jettag_c_if_563_11.setTagInfo(_td_c_if_563_11);
                                            _jettag_c_if_563_11.doStart(context, out);
                                            while (_jettag_c_if_563_11.okToProcessBody()) {
                                                // iterate throught all the classes to get the other class on the association
                                                RuntimeTagElement _jettag_c_iterate_565_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_565_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_iterate_565_15.setRuntimeParent(_jettag_c_if_563_11);
                                                _jettag_c_iterate_565_15.setTagInfo(_td_c_iterate_565_15);
                                                _jettag_c_iterate_565_15.doStart(context, out);
                                                while (_jettag_c_iterate_565_15.okToProcessBody()) {
                                                    RuntimeTagElement _jettag_c_if_566_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_566_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_if_566_16.setRuntimeParent(_jettag_c_iterate_565_15);
                                                    _jettag_c_if_566_16.setTagInfo(_td_c_if_566_16);
                                                    _jettag_c_if_566_16.doStart(context, out);
                                                    while (_jettag_c_if_566_16.okToProcessBody()) {
                                                        out.write("\tif([[menu buttonTitleAtIndex:buttonIndex] isEqualToString:@\"");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 567, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s\"]){");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\tNSLog(@\"");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 568, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s clicked\");");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\tReadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 569, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController *readAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 569, 50)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController = [[ReadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 569, 93)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController alloc] initWithNibName:nil bundle:nil];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\treadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 570, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController.parent=");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 570, 49)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(";");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\tint ");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 571, 7)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Id=[");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 571, 38)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write(".entityID intValue];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\treadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 572, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController.parentResource=[[self getReadURLWithID:");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 572, 81)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("Id] stringByAppendingFormat:@\"/");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 572, 139)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("s\"];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t[self.navigationController pushViewController:readAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 573, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController animated:YES];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\t[readAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 574, 11)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController release];");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t\treadAll");  //$NON-NLS-1$        
                                                        out.write(context.embeddedExpressionAsString("${$class2/@name}", 575, 10)); //$NON-NLS-1$ //$NON-NLS-2$
                                                        out.write("sViewController = nil;");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        out.write("\t}");  //$NON-NLS-1$        
                                                        out.write(NL);         
                                                        _jettag_c_if_566_16.handleBodyContent(out);
                                                    }
                                                    _jettag_c_if_566_16.doEnd();
                                                    _jettag_c_iterate_565_15.handleBodyContent(out);
                                                }
                                                _jettag_c_iterate_565_15.doEnd();
                                                _jettag_c_if_563_11.handleBodyContent(out);
                                            }
                                            _jettag_c_if_563_11.doEnd();
                                            _jettag_c_if_562_9.handleBodyContent(out);
                                        }
                                        _jettag_c_if_562_9.doEnd();
                                        _jettag_c_if_560_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_560_14.doEnd();
                                    _jettag_c_if_558_14.handleBodyContent(out);
                                }
                                _jettag_c_if_558_14.doEnd();
                                _jettag_c_if_555_12.handleBodyContent(out);
                            }
                            _jettag_c_if_555_12.doEnd();
                            _jettag_c_iterate_553_12.handleBodyContent(out);
                        }
                        _jettag_c_iterate_553_12.doEnd();
                        _jettag_c_if_551_6.handleBodyContent(out);
                    }
                    _jettag_c_if_551_6.doEnd();
                    _jettag_c_iterate_548_3.handleBodyContent(out);
                }
                _jettag_c_iterate_548_3.doEnd();
                _jettag_c_iterate_547_2.handleBodyContent(out);
            }
            _jettag_c_iterate_547_2.doEnd();
            _jettag_c_iterate_546_1.handleBodyContent(out);
        }
        _jettag_c_iterate_546_1.doEnd();
        out.write("}");  //$NON-NLS-1$        
        out.write(NL);         
        out.write(NL);         
        out.write("// Implement viewDidLoad to do additional setup after loading the view, typically from a nib.");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("- (void)viewDidLoad {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tself.navigationItem.title=@\"Read ");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${$class/@name}", 593, 35)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("\";");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\t");  //$NON-NLS-1$        
        out.write(NL);         
        // process parent class level 2 attributes
        RuntimeTagElement _jettag_c_if_596_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_596_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_596_2.setRuntimeParent(null);
        _jettag_c_if_596_2.setTagInfo(_td_c_if_596_2);
        _jettag_c_if_596_2.doStart(context, out);
        while (_jettag_c_if_596_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_597_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_597_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_597_3.setRuntimeParent(_jettag_c_if_596_2);
            _jettag_c_iterate_597_3.setTagInfo(_td_c_iterate_597_3);
            _jettag_c_iterate_597_3.doStart(context, out);
            while (_jettag_c_iterate_597_3.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_598_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_598_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_598_3.setRuntimeParent(_jettag_c_iterate_597_3);
                _jettag_c_choose_598_3.setTagInfo(_td_c_choose_598_3);
                _jettag_c_choose_598_3.doStart(context, out);
                JET2Writer _jettag_c_choose_598_3_saved_out = out;
                while (_jettag_c_choose_598_3.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_599_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_599_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_599_4.setRuntimeParent(_jettag_c_choose_598_3);
                    _jettag_c_when_599_4.setTagInfo(_td_c_when_599_4);
                    _jettag_c_when_599_4.doStart(context, out);
                    JET2Writer _jettag_c_when_599_4_saved_out = out;
                    while (_jettag_c_when_599_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 599, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.text=[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 599, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(" ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 599, 92)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_599_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_599_4_saved_out;
                    _jettag_c_when_599_4.doEnd();
                    RuntimeTagElement _jettag_c_when_601_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_601_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_601_4.setRuntimeParent(_jettag_c_choose_598_3);
                    _jettag_c_when_601_4.setTagInfo(_td_c_when_601_4);
                    _jettag_c_when_601_4.doStart(context, out);
                    JET2Writer _jettag_c_when_601_4_saved_out = out;
                    while (_jettag_c_when_601_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_601_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_601_4_saved_out;
                    _jettag_c_when_601_4.doEnd();
                    RuntimeTagElement _jettag_c_when_603_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_603_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_603_4.setRuntimeParent(_jettag_c_choose_598_3);
                    _jettag_c_when_603_4.setTagInfo(_td_c_when_603_4);
                    _jettag_c_when_603_4.doStart(context, out);
                    JET2Writer _jettag_c_when_603_4_saved_out = out;
                    while (_jettag_c_when_603_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_603_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_603_4_saved_out;
                    _jettag_c_when_603_4.doEnd();
                    RuntimeTagElement _jettag_c_when_606_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_606_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_606_4.setRuntimeParent(_jettag_c_choose_598_3);
                    _jettag_c_when_606_4.setTagInfo(_td_c_when_606_4);
                    _jettag_c_when_606_4.doStart(context, out);
                    JET2Writer _jettag_c_when_606_4_saved_out = out;
                    while (_jettag_c_when_606_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_606_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_606_4_saved_out;
                    _jettag_c_when_606_4.doEnd();
                    RuntimeTagElement _jettag_c_when_609_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_609_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_609_4.setRuntimeParent(_jettag_c_choose_598_3);
                    _jettag_c_when_609_4.setTagInfo(_td_c_when_609_4);
                    _jettag_c_when_609_4.doStart(context, out);
                    JET2Writer _jettag_c_when_609_4_saved_out = out;
                    while (_jettag_c_when_609_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_609_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_609_4_saved_out;
                    _jettag_c_when_609_4.doEnd();
                    RuntimeTagElement _jettag_c_when_611_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_611_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_611_4.setRuntimeParent(_jettag_c_choose_598_3);
                    _jettag_c_when_611_4.setTagInfo(_td_c_when_611_4);
                    _jettag_c_when_611_4.doStart(context, out);
                    JET2Writer _jettag_c_when_611_4_saved_out = out;
                    while (_jettag_c_when_611_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_611_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_611_4_saved_out;
                    _jettag_c_when_611_4.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_613_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_613_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_613_3.setRuntimeParent(_jettag_c_choose_598_3);
                    _jettag_c_otherwise_613_3.setTagInfo(_td_c_otherwise_613_3);
                    _jettag_c_otherwise_613_3.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_613_3_saved_out = out;
                    while (_jettag_c_otherwise_613_3.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_iterate_614_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_614_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_614_4.setRuntimeParent(_jettag_c_otherwise_613_3);
                        _jettag_c_iterate_614_4.setTagInfo(_td_c_iterate_614_4);
                        _jettag_c_iterate_614_4.doStart(context, out);
                        while (_jettag_c_iterate_614_4.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_615_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_615_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_615_6.setRuntimeParent(_jettag_c_iterate_614_4);
                            _jettag_c_if_615_6.setTagInfo(_td_c_if_615_6);
                            _jettag_c_if_615_6.doStart(context, out);
                            while (_jettag_c_if_615_6.okToProcessBody()) {
                                // add  enums support
                                _jettag_c_if_615_6.handleBodyContent(out);
                            }
                            _jettag_c_if_615_6.doEnd();
                            _jettag_c_iterate_614_4.handleBodyContent(out);
                        }
                        _jettag_c_iterate_614_4.doEnd();
                        _jettag_c_otherwise_613_3.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_613_3_saved_out;
                    _jettag_c_otherwise_613_3.doEnd();
                    _jettag_c_choose_598_3.handleBodyContent(out);
                }
                out = _jettag_c_choose_598_3_saved_out;
                _jettag_c_choose_598_3.doEnd();
                _jettag_c_iterate_597_3.handleBodyContent(out);
            }
            _jettag_c_iterate_597_3.doEnd();
            _jettag_c_if_596_2.handleBodyContent(out);
        }
        _jettag_c_if_596_2.doEnd();
        // process parent class level 1 attributes
        RuntimeTagElement _jettag_c_if_624_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_624_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_if_624_2.setRuntimeParent(null);
        _jettag_c_if_624_2.setTagInfo(_td_c_if_624_2);
        _jettag_c_if_624_2.doStart(context, out);
        while (_jettag_c_if_624_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_iterate_625_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_625_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_625_3.setRuntimeParent(_jettag_c_if_624_2);
            _jettag_c_iterate_625_3.setTagInfo(_td_c_iterate_625_3);
            _jettag_c_iterate_625_3.doStart(context, out);
            while (_jettag_c_iterate_625_3.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_626_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_626_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_626_3.setRuntimeParent(_jettag_c_iterate_625_3);
                _jettag_c_choose_626_3.setTagInfo(_td_c_choose_626_3);
                _jettag_c_choose_626_3.doStart(context, out);
                JET2Writer _jettag_c_choose_626_3_saved_out = out;
                while (_jettag_c_choose_626_3.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t  ");  //$NON-NLS-1$        
                    RuntimeTagElement _jettag_c_when_627_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_627_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_627_4.setRuntimeParent(_jettag_c_choose_626_3);
                    _jettag_c_when_627_4.setTagInfo(_td_c_when_627_4);
                    _jettag_c_when_627_4.doStart(context, out);
                    JET2Writer _jettag_c_when_627_4_saved_out = out;
                    while (_jettag_c_when_627_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write(" ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 627, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("TF.text=[");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 627, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(" ");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 627, 92)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("];");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_627_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_627_4_saved_out;
                    _jettag_c_when_627_4.doEnd();
                    RuntimeTagElement _jettag_c_when_629_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_629_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_629_4.setRuntimeParent(_jettag_c_choose_626_3);
                    _jettag_c_when_629_4.setTagInfo(_td_c_when_629_4);
                    _jettag_c_when_629_4.doStart(context, out);
                    JET2Writer _jettag_c_when_629_4_saved_out = out;
                    while (_jettag_c_when_629_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_629_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_629_4_saved_out;
                    _jettag_c_when_629_4.doEnd();
                    RuntimeTagElement _jettag_c_when_631_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_631_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_631_4.setRuntimeParent(_jettag_c_choose_626_3);
                    _jettag_c_when_631_4.setTagInfo(_td_c_when_631_4);
                    _jettag_c_when_631_4.doStart(context, out);
                    JET2Writer _jettag_c_when_631_4_saved_out = out;
                    while (_jettag_c_when_631_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_631_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_631_4_saved_out;
                    _jettag_c_when_631_4.doEnd();
                    RuntimeTagElement _jettag_c_when_634_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_634_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_634_4.setRuntimeParent(_jettag_c_choose_626_3);
                    _jettag_c_when_634_4.setTagInfo(_td_c_when_634_4);
                    _jettag_c_when_634_4.doStart(context, out);
                    JET2Writer _jettag_c_when_634_4_saved_out = out;
                    while (_jettag_c_when_634_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_634_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_634_4_saved_out;
                    _jettag_c_when_634_4.doEnd();
                    RuntimeTagElement _jettag_c_when_637_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_637_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_637_4.setRuntimeParent(_jettag_c_choose_626_3);
                    _jettag_c_when_637_4.setTagInfo(_td_c_when_637_4);
                    _jettag_c_when_637_4.doStart(context, out);
                    JET2Writer _jettag_c_when_637_4_saved_out = out;
                    while (_jettag_c_when_637_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_637_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_637_4_saved_out;
                    _jettag_c_when_637_4.doEnd();
                    RuntimeTagElement _jettag_c_when_639_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_639_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_639_4.setRuntimeParent(_jettag_c_choose_626_3);
                    _jettag_c_when_639_4.setTagInfo(_td_c_when_639_4);
                    _jettag_c_when_639_4.doStart(context, out);
                    JET2Writer _jettag_c_when_639_4_saved_out = out;
                    while (_jettag_c_when_639_4.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        _jettag_c_when_639_4.handleBodyContent(out);
                    }
                    out = _jettag_c_when_639_4_saved_out;
                    _jettag_c_when_639_4.doEnd();
                    RuntimeTagElement _jettag_c_otherwise_641_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_641_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_otherwise_641_3.setRuntimeParent(_jettag_c_choose_626_3);
                    _jettag_c_otherwise_641_3.setTagInfo(_td_c_otherwise_641_3);
                    _jettag_c_otherwise_641_3.doStart(context, out);
                    JET2Writer _jettag_c_otherwise_641_3_saved_out = out;
                    while (_jettag_c_otherwise_641_3.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_iterate_642_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_642_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_642_4.setRuntimeParent(_jettag_c_otherwise_641_3);
                        _jettag_c_iterate_642_4.setTagInfo(_td_c_iterate_642_4);
                        _jettag_c_iterate_642_4.doStart(context, out);
                        while (_jettag_c_iterate_642_4.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_if_643_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_643_6); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_643_6.setRuntimeParent(_jettag_c_iterate_642_4);
                            _jettag_c_if_643_6.setTagInfo(_td_c_if_643_6);
                            _jettag_c_if_643_6.doStart(context, out);
                            while (_jettag_c_if_643_6.okToProcessBody()) {
                                // add  enums support
                                _jettag_c_if_643_6.handleBodyContent(out);
                            }
                            _jettag_c_if_643_6.doEnd();
                            _jettag_c_iterate_642_4.handleBodyContent(out);
                        }
                        _jettag_c_iterate_642_4.doEnd();
                        _jettag_c_otherwise_641_3.handleBodyContent(out);
                    }
                    out = _jettag_c_otherwise_641_3_saved_out;
                    _jettag_c_otherwise_641_3.doEnd();
                    _jettag_c_choose_626_3.handleBodyContent(out);
                }
                out = _jettag_c_choose_626_3_saved_out;
                _jettag_c_choose_626_3.doEnd();
                _jettag_c_iterate_625_3.handleBodyContent(out);
            }
            _jettag_c_iterate_625_3.doEnd();
            _jettag_c_if_624_2.handleBodyContent(out);
        }
        _jettag_c_if_624_2.doEnd();
        // process parent class level 0 attributes
        RuntimeTagElement _jettag_c_iterate_652_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_652_2); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_iterate_652_2.setRuntimeParent(null);
        _jettag_c_iterate_652_2.setTagInfo(_td_c_iterate_652_2);
        _jettag_c_iterate_652_2.doStart(context, out);
        while (_jettag_c_iterate_652_2.okToProcessBody()) {
            RuntimeTagElement _jettag_c_choose_653_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_653_3); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_choose_653_3.setRuntimeParent(_jettag_c_iterate_652_2);
            _jettag_c_choose_653_3.setTagInfo(_td_c_choose_653_3);
            _jettag_c_choose_653_3.doStart(context, out);
            JET2Writer _jettag_c_choose_653_3_saved_out = out;
            while (_jettag_c_choose_653_3.okToProcessBody()) {
                out = out.newNestedContentWriter();
                out.write("\t  ");  //$NON-NLS-1$        
                RuntimeTagElement _jettag_c_when_654_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_654_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_654_4.setRuntimeParent(_jettag_c_choose_653_3);
                _jettag_c_when_654_4.setTagInfo(_td_c_when_654_4);
                _jettag_c_when_654_4.doStart(context, out);
                JET2Writer _jettag_c_when_654_4_saved_out = out;
                while (_jettag_c_when_654_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write(" ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 654, 36)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("TF.text=[");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 654, 64)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write(" ");  //$NON-NLS-1$        
                    out.write(context.embeddedExpressionAsString("${$attribute/@name}", 654, 92)); //$NON-NLS-1$ //$NON-NLS-2$
                    out.write("];");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_654_4.handleBodyContent(out);
                }
                out = _jettag_c_when_654_4_saved_out;
                _jettag_c_when_654_4.doEnd();
                RuntimeTagElement _jettag_c_when_656_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_656_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_656_4.setRuntimeParent(_jettag_c_choose_653_3);
                _jettag_c_when_656_4.setTagInfo(_td_c_when_656_4);
                _jettag_c_when_656_4.doStart(context, out);
                JET2Writer _jettag_c_when_656_4_saved_out = out;
                while (_jettag_c_when_656_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    _jettag_c_when_656_4.handleBodyContent(out);
                }
                out = _jettag_c_when_656_4_saved_out;
                _jettag_c_when_656_4.doEnd();
                RuntimeTagElement _jettag_c_when_658_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_658_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_658_4.setRuntimeParent(_jettag_c_choose_653_3);
                _jettag_c_when_658_4.setTagInfo(_td_c_when_658_4);
                _jettag_c_when_658_4.doStart(context, out);
                JET2Writer _jettag_c_when_658_4_saved_out = out;
                while (_jettag_c_when_658_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_658_4.handleBodyContent(out);
                }
                out = _jettag_c_when_658_4_saved_out;
                _jettag_c_when_658_4.doEnd();
                RuntimeTagElement _jettag_c_when_661_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_661_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_661_4.setRuntimeParent(_jettag_c_choose_653_3);
                _jettag_c_when_661_4.setTagInfo(_td_c_when_661_4);
                _jettag_c_when_661_4.doStart(context, out);
                JET2Writer _jettag_c_when_661_4_saved_out = out;
                while (_jettag_c_when_661_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    out.write("\t");  //$NON-NLS-1$        
                    out.write(NL);         
                    _jettag_c_when_661_4.handleBodyContent(out);
                }
                out = _jettag_c_when_661_4_saved_out;
                _jettag_c_when_661_4.doEnd();
                RuntimeTagElement _jettag_c_when_664_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_664_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_664_4.setRuntimeParent(_jettag_c_choose_653_3);
                _jettag_c_when_664_4.setTagInfo(_td_c_when_664_4);
                _jettag_c_when_664_4.doStart(context, out);
                JET2Writer _jettag_c_when_664_4_saved_out = out;
                while (_jettag_c_when_664_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    _jettag_c_when_664_4.handleBodyContent(out);
                }
                out = _jettag_c_when_664_4_saved_out;
                _jettag_c_when_664_4.doEnd();
                RuntimeTagElement _jettag_c_when_666_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_666_4); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_when_666_4.setRuntimeParent(_jettag_c_choose_653_3);
                _jettag_c_when_666_4.setTagInfo(_td_c_when_666_4);
                _jettag_c_when_666_4.doStart(context, out);
                JET2Writer _jettag_c_when_666_4_saved_out = out;
                while (_jettag_c_when_666_4.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    _jettag_c_when_666_4.handleBodyContent(out);
                }
                out = _jettag_c_when_666_4_saved_out;
                _jettag_c_when_666_4.doEnd();
                RuntimeTagElement _jettag_c_otherwise_668_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "otherwise", "c:otherwise", _td_c_otherwise_668_3); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_otherwise_668_3.setRuntimeParent(_jettag_c_choose_653_3);
                _jettag_c_otherwise_668_3.setTagInfo(_td_c_otherwise_668_3);
                _jettag_c_otherwise_668_3.doStart(context, out);
                JET2Writer _jettag_c_otherwise_668_3_saved_out = out;
                while (_jettag_c_otherwise_668_3.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_iterate_669_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_669_4); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_669_4.setRuntimeParent(_jettag_c_otherwise_668_3);
                    _jettag_c_iterate_669_4.setTagInfo(_td_c_iterate_669_4);
                    _jettag_c_iterate_669_4.doStart(context, out);
                    while (_jettag_c_iterate_669_4.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_if_670_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_670_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_670_6.setRuntimeParent(_jettag_c_iterate_669_4);
                        _jettag_c_if_670_6.setTagInfo(_td_c_if_670_6);
                        _jettag_c_if_670_6.doStart(context, out);
                        while (_jettag_c_if_670_6.okToProcessBody()) {
                            // add  enums support
                            _jettag_c_if_670_6.handleBodyContent(out);
                        }
                        _jettag_c_if_670_6.doEnd();
                        _jettag_c_iterate_669_4.handleBodyContent(out);
                    }
                    _jettag_c_iterate_669_4.doEnd();
                    _jettag_c_otherwise_668_3.handleBodyContent(out);
                }
                out = _jettag_c_otherwise_668_3_saved_out;
                _jettag_c_otherwise_668_3.doEnd();
                _jettag_c_choose_653_3.handleBodyContent(out);
            }
            out = _jettag_c_choose_653_3_saved_out;
            _jettag_c_choose_653_3.doEnd();
            _jettag_c_iterate_652_2.handleBodyContent(out);
        }
        _jettag_c_iterate_652_2.doEnd();
        out.write("    [super viewDidLoad];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("}");  //$NON-NLS-1$        
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
        out.write("- (NSString*) getReadURLWithID: (int) key {");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSString* keyStr = [NSString stringWithFormat:@\"%d\", key];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSString *str=[NSString stringWithFormat:@\"");  //$NON-NLS-1$        
        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 703, 45)); //$NON-NLS-1$ //$NON-NLS-2$
        out.write("/read/%@\", keyStr];");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\tNSLog(@\"read url:%@\",str);");  //$NON-NLS-1$        
        out.write(NL);         
        out.write("\treturn [[HttpUtils crudURL] stringByAppendingString:str];");  //$NON-NLS-1$        
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
