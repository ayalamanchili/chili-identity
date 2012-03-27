package office_mda.compiled;

import org.eclipse.jet.JET2Context;
import org.eclipse.jet.JET2Template;
import org.eclipse.jet.JET2Writer;
import org.eclipse.jet.taglib.RuntimeTagElement;
import org.eclipse.jet.taglib.TagInfo;

public class _jet_read_entityjava_0 implements JET2Template {
    private static final String _jetns_c = "org.eclipse.jet.controlTags"; //$NON-NLS-1$
    private static final String _jetns_java = "org.eclipse.jet.javaTags"; //$NON-NLS-1$

    public _jet_read_entityjava_0() {
        super();
    }

    private static final String NL = System.getProperty("line.separator"); //$NON-NLS-1$
    
    private static final TagInfo _td_c_setVariable_1_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            1, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_java_format_2_1 = new TagInfo("java:format", //$NON-NLS-1$
            2, 1,
            new String[] {
            },
            new String[] {
            } );
    private static final TagInfo _td_c_if_13_1 = new TagInfo("c:if", //$NON-NLS-1$
            13, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_14_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            14, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_16_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            16, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_17_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            17, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_18_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            18, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_19_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            19, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_21_13 = new TagInfo("c:if", //$NON-NLS-1$
            21, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_23_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            23, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_25_18 = new TagInfo("c:if", //$NON-NLS-1$
            25, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_26_18 = new TagInfo("c:if", //$NON-NLS-1$
            26, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_27_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            27, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_29_21 = new TagInfo("c:if", //$NON-NLS-1$
            29, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_31_19 = new TagInfo("c:if", //$NON-NLS-1$
            31, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_33_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            33, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_34_23 = new TagInfo("c:if", //$NON-NLS-1$
            34, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_50_1 = new TagInfo("c:if", //$NON-NLS-1$
            50, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_51_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            51, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_53_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            53, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_54_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            54, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_55_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            55, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_56_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            56, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_58_13 = new TagInfo("c:if", //$NON-NLS-1$
            58, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_60_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            60, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_62_18 = new TagInfo("c:if", //$NON-NLS-1$
            62, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_63_18 = new TagInfo("c:if", //$NON-NLS-1$
            63, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_64_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            64, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_66_21 = new TagInfo("c:if", //$NON-NLS-1$
            66, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_68_19 = new TagInfo("c:if", //$NON-NLS-1$
            68, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_70_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            70, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_71_23 = new TagInfo("c:if", //$NON-NLS-1$
            71, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_87_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            87, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_89_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            89, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_90_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            90, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_91_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            91, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_92_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            92, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_94_6 = new TagInfo("c:if", //$NON-NLS-1$
            94, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_96_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            96, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_98_12 = new TagInfo("c:if", //$NON-NLS-1$
            98, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_99_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            99, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_101_14 = new TagInfo("c:if", //$NON-NLS-1$
            101, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_103_14 = new TagInfo("c:if", //$NON-NLS-1$
            103, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_105_9 = new TagInfo("c:if", //$NON-NLS-1$
            105, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_106_11 = new TagInfo("c:if", //$NON-NLS-1$
            106, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_108_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            108, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_109_16 = new TagInfo("c:if", //$NON-NLS-1$
            109, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_149_2 = new TagInfo("c:if", //$NON-NLS-1$
            149, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_150_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            150, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_151_5 = new TagInfo("c:choose", //$NON-NLS-1$
            151, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_152_6 = new TagInfo("c:when", //$NON-NLS-1$
            152, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_155_6 = new TagInfo("c:when", //$NON-NLS-1$
            155, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_158_6 = new TagInfo("c:when", //$NON-NLS-1$
            158, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_161_6 = new TagInfo("c:when", //$NON-NLS-1$
            161, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_164_6 = new TagInfo("c:when", //$NON-NLS-1$
            164, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_167_6 = new TagInfo("c:when", //$NON-NLS-1$
            167, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_170_6 = new TagInfo("c:when", //$NON-NLS-1$
            170, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_177_2 = new TagInfo("c:if", //$NON-NLS-1$
            177, 2,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_178_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            178, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_179_5 = new TagInfo("c:choose", //$NON-NLS-1$
            179, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_180_6 = new TagInfo("c:when", //$NON-NLS-1$
            180, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_183_6 = new TagInfo("c:when", //$NON-NLS-1$
            183, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_186_6 = new TagInfo("c:when", //$NON-NLS-1$
            186, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_189_6 = new TagInfo("c:when", //$NON-NLS-1$
            189, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_192_6 = new TagInfo("c:when", //$NON-NLS-1$
            192, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_195_6 = new TagInfo("c:when", //$NON-NLS-1$
            195, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_198_6 = new TagInfo("c:when", //$NON-NLS-1$
            198, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_205_5 = new TagInfo("c:iterate", //$NON-NLS-1$
            205, 5,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/Classifier.feature/Attribute", //$NON-NLS-1$
                "attribute", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_choose_206_5 = new TagInfo("c:choose", //$NON-NLS-1$
            206, 5,
            new String[] {
                "select", //$NON-NLS-1$
            },
            new String[] {
                "$attribute/StructuralFeature.type/DataType/@href", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_207_6 = new TagInfo("c:when", //$NON-NLS-1$
            207, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$StringID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_210_6 = new TagInfo("c:when", //$NON-NLS-1$
            210, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$IntegerID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_213_6 = new TagInfo("c:when", //$NON-NLS-1$
            213, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$DateID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_216_6 = new TagInfo("c:when", //$NON-NLS-1$
            216, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$BooleanID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_219_6 = new TagInfo("c:when", //$NON-NLS-1$
            219, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$LongID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_222_6 = new TagInfo("c:when", //$NON-NLS-1$
            222, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$FloatID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_when_225_6 = new TagInfo("c:when", //$NON-NLS-1$
            225, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "${'$CurrencyID'}", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_274_1 = new TagInfo("c:if", //$NON-NLS-1$
            274, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass1/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_275_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            275, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass1/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_277_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            277, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_278_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            278, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_279_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            279, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_280_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            280, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_282_13 = new TagInfo("c:if", //$NON-NLS-1$
            282, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_284_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            284, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_286_18 = new TagInfo("c:if", //$NON-NLS-1$
            286, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_287_18 = new TagInfo("c:if", //$NON-NLS-1$
            287, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_288_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            288, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_290_21 = new TagInfo("c:if", //$NON-NLS-1$
            290, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_292_19 = new TagInfo("c:if", //$NON-NLS-1$
            292, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_294_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            294, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_295_23 = new TagInfo("c:if", //$NON-NLS-1$
            295, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_316_1 = new TagInfo("c:if", //$NON-NLS-1$
            316, 1,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($class/@name = $parentClass2/@name)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_317_6 = new TagInfo("c:setVariable", //$NON-NLS-1$
            317, 6,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$parentClass2/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_319_8 = new TagInfo("c:iterate", //$NON-NLS-1$
            319, 8,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_320_9 = new TagInfo("c:iterate", //$NON-NLS-1$
            320, 9,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_321_10 = new TagInfo("c:iterate", //$NON-NLS-1$
            321, 10,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_322_11 = new TagInfo("c:setVariable", //$NON-NLS-1$
            322, 11,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_324_13 = new TagInfo("c:if", //$NON-NLS-1$
            324, 13,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_326_19 = new TagInfo("c:iterate", //$NON-NLS-1$
            326, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_328_18 = new TagInfo("c:if", //$NON-NLS-1$
            328, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_329_18 = new TagInfo("c:if", //$NON-NLS-1$
            329, 18,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end/@aggregation = 'none')", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_330_19 = new TagInfo("c:setVariable", //$NON-NLS-1$
            330, 19,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_332_21 = new TagInfo("c:if", //$NON-NLS-1$
            332, 21,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_334_19 = new TagInfo("c:if", //$NON-NLS-1$
            334, 19,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_336_22 = new TagInfo("c:iterate", //$NON-NLS-1$
            336, 22,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_337_23 = new TagInfo("c:if", //$NON-NLS-1$
            337, 23,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_358_1 = new TagInfo("c:setVariable", //$NON-NLS-1$
            358, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$class/@xmi.id", //$NON-NLS-1$
                "classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_360_1 = new TagInfo("c:iterate", //$NON-NLS-1$
            360, 1,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Association", //$NON-NLS-1$
                "association", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_361_2 = new TagInfo("c:iterate", //$NON-NLS-1$
            361, 2,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association/Association.connection", //$NON-NLS-1$
                "association_connection", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_362_3 = new TagInfo("c:iterate", //$NON-NLS-1$
            362, 3,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_363_4 = new TagInfo("c:setVariable", //$NON-NLS-1$
            363, 4,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_365_6 = new TagInfo("c:if", //$NON-NLS-1$
            365, 6,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end_classID = $classID", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_367_12 = new TagInfo("c:iterate", //$NON-NLS-1$
            367, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection/AssociationEnd", //$NON-NLS-1$
                "association_connection_end2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_369_12 = new TagInfo("c:if", //$NON-NLS-1$
            369, 12,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@aggregation = 'none'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_setVariable_370_12 = new TagInfo("c:setVariable", //$NON-NLS-1$
            370, 12,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.participant/Class/@xmi.idref", //$NON-NLS-1$
                "association_connection_end_classID2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_372_14 = new TagInfo("c:if", //$NON-NLS-1$
            372, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "not($association_connection_end_classID2 = $classID)", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_374_14 = new TagInfo("c:if", //$NON-NLS-1$
            374, 14,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/@isNavigable = 'true'", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_376_9 = new TagInfo("c:if", //$NON-NLS-1$
            376, 9,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@lower = 0", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_377_11 = new TagInfo("c:if", //$NON-NLS-1$
            377, 11,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$association_connection_end2/AssociationEnd.multiplicity/Multiplicity/Multiplicity.range/MultiplicityRange/@upper = -1", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_iterate_379_15 = new TagInfo("c:iterate", //$NON-NLS-1$
            379, 15,
            new String[] {
                "select", //$NON-NLS-1$
                "var", //$NON-NLS-1$
            },
            new String[] {
                "/XMI/XMI.content/Model/Namespace.ownedElement/Package/Namespace.ownedElement/Class", //$NON-NLS-1$
                "class2", //$NON-NLS-1$
            } );
    private static final TagInfo _td_c_if_380_16 = new TagInfo("c:if", //$NON-NLS-1$
            380, 16,
            new String[] {
                "test", //$NON-NLS-1$
            },
            new String[] {
                "$class2/@xmi.id = $association_connection_end_classID2", //$NON-NLS-1$
            } );

    public void generate(final JET2Context context, final JET2Writer __out) {
        JET2Writer out = __out;
        RuntimeTagElement _jettag_c_setVariable_1_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_1_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_c_setVariable_1_1.setRuntimeParent(null);
        _jettag_c_setVariable_1_1.setTagInfo(_td_c_setVariable_1_1);
        _jettag_c_setVariable_1_1.doStart(context, out);
        _jettag_c_setVariable_1_1.doEnd();
        RuntimeTagElement _jettag_java_format_2_1 = context.getTagFactory().createRuntimeTag(_jetns_java, "format", "java:format", _td_java_format_2_1); //$NON-NLS-1$ //$NON-NLS-2$
        _jettag_java_format_2_1.setRuntimeParent(null);
        _jettag_java_format_2_1.setTagInfo(_td_java_format_2_1);
        _jettag_java_format_2_1.doStart(context, out);
        JET2Writer _jettag_java_format_2_1_saved_out = out;
        while (_jettag_java_format_2_1.okToProcessBody()) {
            out = out.newNestedContentWriter();
            out.write(NL);         
            out.write("package ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 3, 9)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$package/@name}", 3, 29)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 3, 47)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 4, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".android.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 4, 28)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Welcome;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.crud.AbstractReadActivity;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import info.yalamanchili.android.views.Field;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.content.Intent;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.Menu;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.MenuInflater;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import android.view.MenuItem;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("import ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$groupID}", 11, 8)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".R;");  //$NON-NLS-1$        
            out.write(NL);         
            //process level 1 generizations 
            RuntimeTagElement _jettag_c_if_13_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_13_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_13_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_if_13_1.setTagInfo(_td_c_if_13_1);
            _jettag_c_if_13_1.doStart(context, out);
            while (_jettag_c_if_13_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_setVariable_14_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_14_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_14_6.setRuntimeParent(_jettag_c_if_13_1);
                _jettag_c_setVariable_14_6.setTagInfo(_td_c_setVariable_14_6);
                _jettag_c_setVariable_14_6.doStart(context, out);
                _jettag_c_setVariable_14_6.doEnd();
                // process the assocations for level 1 class 
                RuntimeTagElement _jettag_c_iterate_16_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_16_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_16_8.setRuntimeParent(_jettag_c_if_13_1);
                _jettag_c_iterate_16_8.setTagInfo(_td_c_iterate_16_8);
                _jettag_c_iterate_16_8.doStart(context, out);
                while (_jettag_c_iterate_16_8.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_17_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_17_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_17_9.setRuntimeParent(_jettag_c_iterate_16_8);
                    _jettag_c_iterate_17_9.setTagInfo(_td_c_iterate_17_9);
                    _jettag_c_iterate_17_9.doStart(context, out);
                    while (_jettag_c_iterate_17_9.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_18_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_18_10); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_18_10.setRuntimeParent(_jettag_c_iterate_17_9);
                        _jettag_c_iterate_18_10.setTagInfo(_td_c_iterate_18_10);
                        _jettag_c_iterate_18_10.doStart(context, out);
                        while (_jettag_c_iterate_18_10.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_19_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_19_11); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_19_11.setRuntimeParent(_jettag_c_iterate_18_10);
                            _jettag_c_setVariable_19_11.setTagInfo(_td_c_setVariable_19_11);
                            _jettag_c_setVariable_19_11.doStart(context, out);
                            _jettag_c_setVariable_19_11.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_21_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_21_13); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_21_13.setRuntimeParent(_jettag_c_iterate_18_10);
                            _jettag_c_if_21_13.setTagInfo(_td_c_if_21_13);
                            _jettag_c_if_21_13.doStart(context, out);
                            while (_jettag_c_if_21_13.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_23_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_23_19); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_23_19.setRuntimeParent(_jettag_c_if_21_13);
                                _jettag_c_iterate_23_19.setTagInfo(_td_c_iterate_23_19);
                                _jettag_c_iterate_23_19.doStart(context, out);
                                while (_jettag_c_iterate_23_19.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_25_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_25_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_25_18.setRuntimeParent(_jettag_c_iterate_23_19);
                                    _jettag_c_if_25_18.setTagInfo(_td_c_if_25_18);
                                    _jettag_c_if_25_18.doStart(context, out);
                                    while (_jettag_c_if_25_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_26_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_26_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_26_18.setRuntimeParent(_jettag_c_if_25_18);
                                        _jettag_c_if_26_18.setTagInfo(_td_c_if_26_18);
                                        _jettag_c_if_26_18.doStart(context, out);
                                        while (_jettag_c_if_26_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_27_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_27_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_27_19.setRuntimeParent(_jettag_c_if_26_18);
                                            _jettag_c_setVariable_27_19.setTagInfo(_td_c_setVariable_27_19);
                                            _jettag_c_setVariable_27_19.doStart(context, out);
                                            _jettag_c_setVariable_27_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_29_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_29_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_29_21.setRuntimeParent(_jettag_c_if_26_18);
                                            _jettag_c_if_29_21.setTagInfo(_td_c_if_29_21);
                                            _jettag_c_if_29_21.doStart(context, out);
                                            while (_jettag_c_if_29_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_31_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_31_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_31_19.setRuntimeParent(_jettag_c_if_29_21);
                                                _jettag_c_if_31_19.setTagInfo(_td_c_if_31_19);
                                                _jettag_c_if_31_19.doStart(context, out);
                                                while (_jettag_c_if_31_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_33_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_33_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_33_22.setRuntimeParent(_jettag_c_if_31_19);
                                                    _jettag_c_iterate_33_22.setTagInfo(_td_c_iterate_33_22);
                                                    _jettag_c_iterate_33_22.doStart(context, out);
                                                    while (_jettag_c_iterate_33_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_34_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_34_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_34_23.setRuntimeParent(_jettag_c_iterate_33_22);
                                                        _jettag_c_if_34_23.setTagInfo(_td_c_if_34_23);
                                                        _jettag_c_if_34_23.doStart(context, out);
                                                        while (_jettag_c_if_34_23.okToProcessBody()) {
                                                            out.write("import ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 35, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".android.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 35, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 35, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".ReadAll");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 35, 94)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s;");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_34_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_34_23.doEnd();
                                                        _jettag_c_iterate_33_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_33_22.doEnd();
                                                    _jettag_c_if_31_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_31_19.doEnd();
                                                _jettag_c_if_29_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_29_21.doEnd();
                                            _jettag_c_if_26_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_26_18.doEnd();
                                        _jettag_c_if_25_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_25_18.doEnd();
                                    _jettag_c_iterate_23_19.handleBodyContent(out);
                                }
                                _jettag_c_iterate_23_19.doEnd();
                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_21_13.handleBodyContent(out);
                            }
                            _jettag_c_if_21_13.doEnd();
                            _jettag_c_iterate_18_10.handleBodyContent(out);
                        }
                        _jettag_c_iterate_18_10.doEnd();
                        _jettag_c_iterate_17_9.handleBodyContent(out);
                    }
                    _jettag_c_iterate_17_9.doEnd();
                    _jettag_c_iterate_16_8.handleBodyContent(out);
                }
                _jettag_c_iterate_16_8.doEnd();
                _jettag_c_if_13_1.handleBodyContent(out);
            }
            _jettag_c_if_13_1.doEnd();
            //process level 2 generizations 
            RuntimeTagElement _jettag_c_if_50_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_50_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_50_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_if_50_1.setTagInfo(_td_c_if_50_1);
            _jettag_c_if_50_1.doStart(context, out);
            while (_jettag_c_if_50_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_setVariable_51_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_51_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_51_6.setRuntimeParent(_jettag_c_if_50_1);
                _jettag_c_setVariable_51_6.setTagInfo(_td_c_setVariable_51_6);
                _jettag_c_setVariable_51_6.doStart(context, out);
                _jettag_c_setVariable_51_6.doEnd();
                // process the assocations for level 1 class 
                RuntimeTagElement _jettag_c_iterate_53_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_53_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_53_8.setRuntimeParent(_jettag_c_if_50_1);
                _jettag_c_iterate_53_8.setTagInfo(_td_c_iterate_53_8);
                _jettag_c_iterate_53_8.doStart(context, out);
                while (_jettag_c_iterate_53_8.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_54_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_54_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_54_9.setRuntimeParent(_jettag_c_iterate_53_8);
                    _jettag_c_iterate_54_9.setTagInfo(_td_c_iterate_54_9);
                    _jettag_c_iterate_54_9.doStart(context, out);
                    while (_jettag_c_iterate_54_9.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_55_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_55_10); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_55_10.setRuntimeParent(_jettag_c_iterate_54_9);
                        _jettag_c_iterate_55_10.setTagInfo(_td_c_iterate_55_10);
                        _jettag_c_iterate_55_10.doStart(context, out);
                        while (_jettag_c_iterate_55_10.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_56_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_56_11); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_56_11.setRuntimeParent(_jettag_c_iterate_55_10);
                            _jettag_c_setVariable_56_11.setTagInfo(_td_c_setVariable_56_11);
                            _jettag_c_setVariable_56_11.doStart(context, out);
                            _jettag_c_setVariable_56_11.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_58_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_58_13); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_58_13.setRuntimeParent(_jettag_c_iterate_55_10);
                            _jettag_c_if_58_13.setTagInfo(_td_c_if_58_13);
                            _jettag_c_if_58_13.doStart(context, out);
                            while (_jettag_c_if_58_13.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_60_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_60_19); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_60_19.setRuntimeParent(_jettag_c_if_58_13);
                                _jettag_c_iterate_60_19.setTagInfo(_td_c_iterate_60_19);
                                _jettag_c_iterate_60_19.doStart(context, out);
                                while (_jettag_c_iterate_60_19.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_62_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_62_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_62_18.setRuntimeParent(_jettag_c_iterate_60_19);
                                    _jettag_c_if_62_18.setTagInfo(_td_c_if_62_18);
                                    _jettag_c_if_62_18.doStart(context, out);
                                    while (_jettag_c_if_62_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_63_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_63_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_63_18.setRuntimeParent(_jettag_c_if_62_18);
                                        _jettag_c_if_63_18.setTagInfo(_td_c_if_63_18);
                                        _jettag_c_if_63_18.doStart(context, out);
                                        while (_jettag_c_if_63_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_64_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_64_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_64_19.setRuntimeParent(_jettag_c_if_63_18);
                                            _jettag_c_setVariable_64_19.setTagInfo(_td_c_setVariable_64_19);
                                            _jettag_c_setVariable_64_19.doStart(context, out);
                                            _jettag_c_setVariable_64_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_66_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_66_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_66_21.setRuntimeParent(_jettag_c_if_63_18);
                                            _jettag_c_if_66_21.setTagInfo(_td_c_if_66_21);
                                            _jettag_c_if_66_21.doStart(context, out);
                                            while (_jettag_c_if_66_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_68_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_68_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_68_19.setRuntimeParent(_jettag_c_if_66_21);
                                                _jettag_c_if_68_19.setTagInfo(_td_c_if_68_19);
                                                _jettag_c_if_68_19.doStart(context, out);
                                                while (_jettag_c_if_68_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_70_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_70_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_70_22.setRuntimeParent(_jettag_c_if_68_19);
                                                    _jettag_c_iterate_70_22.setTagInfo(_td_c_iterate_70_22);
                                                    _jettag_c_iterate_70_22.doStart(context, out);
                                                    while (_jettag_c_iterate_70_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_71_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_71_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_71_23.setRuntimeParent(_jettag_c_iterate_70_22);
                                                        _jettag_c_if_71_23.setTagInfo(_td_c_if_71_23);
                                                        _jettag_c_if_71_23.doStart(context, out);
                                                        while (_jettag_c_if_71_23.okToProcessBody()) {
                                                            out.write("import ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 72, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".android.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 72, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 72, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".ReadAll");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 72, 94)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s;");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_71_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_71_23.doEnd();
                                                        _jettag_c_iterate_70_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_70_22.doEnd();
                                                    _jettag_c_if_68_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_68_19.doEnd();
                                                _jettag_c_if_66_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_66_21.doEnd();
                                            _jettag_c_if_63_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_63_18.doEnd();
                                        _jettag_c_if_62_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_62_18.doEnd();
                                    _jettag_c_iterate_60_19.handleBodyContent(out);
                                }
                                _jettag_c_iterate_60_19.doEnd();
                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_58_13.handleBodyContent(out);
                            }
                            _jettag_c_if_58_13.doEnd();
                            _jettag_c_iterate_55_10.handleBodyContent(out);
                        }
                        _jettag_c_iterate_55_10.doEnd();
                        _jettag_c_iterate_54_9.handleBodyContent(out);
                    }
                    _jettag_c_iterate_54_9.doEnd();
                    _jettag_c_iterate_53_8.handleBodyContent(out);
                }
                _jettag_c_iterate_53_8.doEnd();
                _jettag_c_if_50_1.handleBodyContent(out);
            }
            _jettag_c_if_50_1.doEnd();
            out.write(NL);         
            RuntimeTagElement _jettag_c_setVariable_87_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_87_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_87_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_setVariable_87_1.setTagInfo(_td_c_setVariable_87_1);
            _jettag_c_setVariable_87_1.doStart(context, out);
            _jettag_c_setVariable_87_1.doEnd();
            //process 0 level class relations 
            RuntimeTagElement _jettag_c_iterate_89_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_89_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_89_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_iterate_89_1.setTagInfo(_td_c_iterate_89_1);
            _jettag_c_iterate_89_1.doStart(context, out);
            while (_jettag_c_iterate_89_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_90_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_90_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_90_2.setRuntimeParent(_jettag_c_iterate_89_1);
                _jettag_c_iterate_90_2.setTagInfo(_td_c_iterate_90_2);
                _jettag_c_iterate_90_2.doStart(context, out);
                while (_jettag_c_iterate_90_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_91_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_91_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_91_3.setRuntimeParent(_jettag_c_iterate_90_2);
                    _jettag_c_iterate_91_3.setTagInfo(_td_c_iterate_91_3);
                    _jettag_c_iterate_91_3.doStart(context, out);
                    while (_jettag_c_iterate_91_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_92_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_92_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_92_4.setRuntimeParent(_jettag_c_iterate_91_3);
                        _jettag_c_setVariable_92_4.setTagInfo(_td_c_setVariable_92_4);
                        _jettag_c_setVariable_92_4.doStart(context, out);
                        _jettag_c_setVariable_92_4.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_94_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_94_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_94_6.setRuntimeParent(_jettag_c_iterate_91_3);
                        _jettag_c_if_94_6.setTagInfo(_td_c_if_94_6);
                        _jettag_c_if_94_6.doStart(context, out);
                        while (_jettag_c_if_94_6.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_96_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_96_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_96_12.setRuntimeParent(_jettag_c_if_94_6);
                            _jettag_c_iterate_96_12.setTagInfo(_td_c_iterate_96_12);
                            _jettag_c_iterate_96_12.doStart(context, out);
                            while (_jettag_c_iterate_96_12.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_98_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_98_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_98_12.setRuntimeParent(_jettag_c_iterate_96_12);
                                _jettag_c_if_98_12.setTagInfo(_td_c_if_98_12);
                                _jettag_c_if_98_12.doStart(context, out);
                                while (_jettag_c_if_98_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_99_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_99_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_99_12.setRuntimeParent(_jettag_c_if_98_12);
                                    _jettag_c_setVariable_99_12.setTagInfo(_td_c_setVariable_99_12);
                                    _jettag_c_setVariable_99_12.doStart(context, out);
                                    _jettag_c_setVariable_99_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_101_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_101_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_101_14.setRuntimeParent(_jettag_c_if_98_12);
                                    _jettag_c_if_101_14.setTagInfo(_td_c_if_101_14);
                                    _jettag_c_if_101_14.doStart(context, out);
                                    while (_jettag_c_if_101_14.okToProcessBody()) {
                                        // check to see if this is a navigable relation
                                        RuntimeTagElement _jettag_c_if_103_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_103_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_103_14.setRuntimeParent(_jettag_c_if_101_14);
                                        _jettag_c_if_103_14.setTagInfo(_td_c_if_103_14);
                                        _jettag_c_if_103_14.doStart(context, out);
                                        while (_jettag_c_if_103_14.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_105_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_105_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_105_9.setRuntimeParent(_jettag_c_if_103_14);
                                            _jettag_c_if_105_9.setTagInfo(_td_c_if_105_9);
                                            _jettag_c_if_105_9.doStart(context, out);
                                            while (_jettag_c_if_105_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_106_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_106_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_106_11.setRuntimeParent(_jettag_c_if_105_9);
                                                _jettag_c_if_106_11.setTagInfo(_td_c_if_106_11);
                                                _jettag_c_if_106_11.doStart(context, out);
                                                while (_jettag_c_if_106_11.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_108_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_108_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_108_15.setRuntimeParent(_jettag_c_if_106_11);
                                                    _jettag_c_iterate_108_15.setTagInfo(_td_c_iterate_108_15);
                                                    _jettag_c_iterate_108_15.doStart(context, out);
                                                    while (_jettag_c_iterate_108_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_109_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_109_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_109_16.setRuntimeParent(_jettag_c_iterate_108_15);
                                                        _jettag_c_if_109_16.setTagInfo(_td_c_if_109_16);
                                                        _jettag_c_if_109_16.doStart(context, out);
                                                        while (_jettag_c_if_109_16.okToProcessBody()) {
                                                            out.write("import ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$groupID}", 110, 8)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".android.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($package/@name)}", 110, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 110, 58)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write(".ReadAll");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 110, 94)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s;");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_109_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_109_16.doEnd();
                                                        _jettag_c_iterate_108_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_108_15.doEnd();
                                                    _jettag_c_if_106_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_106_11.doEnd();
                                                _jettag_c_if_105_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_105_9.doEnd();
                                            _jettag_c_if_103_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_103_14.doEnd();
                                        _jettag_c_if_101_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_101_14.doEnd();
                                    _jettag_c_if_98_12.handleBodyContent(out);
                                }
                                _jettag_c_if_98_12.doEnd();
                                _jettag_c_iterate_96_12.handleBodyContent(out);
                            }
                            _jettag_c_iterate_96_12.doEnd();
                            _jettag_c_if_94_6.handleBodyContent(out);
                        }
                        _jettag_c_if_94_6.doEnd();
                        _jettag_c_iterate_91_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_91_3.doEnd();
                    _jettag_c_iterate_90_2.handleBodyContent(out);
                }
                _jettag_c_iterate_90_2.doEnd();
                _jettag_c_iterate_89_1.handleBodyContent(out);
            }
            _jettag_c_iterate_89_1.doEnd();
            out.write(NL);         
            out.write("public class Read");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 124, 18)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" extends AbstractReadActivity {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected int contentViewId() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn R.layout.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 128, 19)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_read;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected int updateButtonId() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn R.id.read_update;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected int doneButtonId() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn R.id.read_update;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected int deleteButtonId() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn R.id.read_delete;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected void assignFields() {");  //$NON-NLS-1$        
            out.write(NL);         
            // process parent class level 2 attributes
            RuntimeTagElement _jettag_c_if_149_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_149_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_149_2.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_if_149_2.setTagInfo(_td_c_if_149_2);
            _jettag_c_if_149_2.doStart(context, out);
            while (_jettag_c_if_149_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_150_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_150_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_150_5.setRuntimeParent(_jettag_c_if_149_2);
                _jettag_c_iterate_150_5.setTagInfo(_td_c_iterate_150_5);
                _jettag_c_iterate_150_5.doStart(context, out);
                while (_jettag_c_iterate_150_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_151_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_151_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_151_5.setRuntimeParent(_jettag_c_iterate_150_5);
                    _jettag_c_choose_151_5.setTagInfo(_td_c_choose_151_5);
                    _jettag_c_choose_151_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_151_5_saved_out = out;
                    while (_jettag_c_choose_151_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_152_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_152_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_152_6.setRuntimeParent(_jettag_c_choose_151_5);
                        _jettag_c_when_152_6.setTagInfo(_td_c_when_152_6);
                        _jettag_c_when_152_6.doStart(context, out);
                        JET2Writer _jettag_c_when_152_6_saved_out = out;
                        while (_jettag_c_when_152_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 153, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 153, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 153, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 153, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.STRING_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_152_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_152_6_saved_out;
                        _jettag_c_when_152_6.doEnd();
                        RuntimeTagElement _jettag_c_when_155_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_155_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_155_6.setRuntimeParent(_jettag_c_choose_151_5);
                        _jettag_c_when_155_6.setTagInfo(_td_c_when_155_6);
                        _jettag_c_when_155_6.doStart(context, out);
                        JET2Writer _jettag_c_when_155_6_saved_out = out;
                        while (_jettag_c_when_155_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 156, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 156, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 156, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 156, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_155_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_155_6_saved_out;
                        _jettag_c_when_155_6.doEnd();
                        RuntimeTagElement _jettag_c_when_158_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_158_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_158_6.setRuntimeParent(_jettag_c_choose_151_5);
                        _jettag_c_when_158_6.setTagInfo(_td_c_when_158_6);
                        _jettag_c_when_158_6.doStart(context, out);
                        JET2Writer _jettag_c_when_158_6_saved_out = out;
                        while (_jettag_c_when_158_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 159, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 159, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 159, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 159, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.DATE_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_158_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_158_6_saved_out;
                        _jettag_c_when_158_6.doEnd();
                        RuntimeTagElement _jettag_c_when_161_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_161_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_161_6.setRuntimeParent(_jettag_c_choose_151_5);
                        _jettag_c_when_161_6.setTagInfo(_td_c_when_161_6);
                        _jettag_c_when_161_6.doStart(context, out);
                        JET2Writer _jettag_c_when_161_6_saved_out = out;
                        while (_jettag_c_when_161_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 162, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 162, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 162, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 162, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.BOOLEAN_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_161_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_161_6_saved_out;
                        _jettag_c_when_161_6.doEnd();
                        RuntimeTagElement _jettag_c_when_164_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_164_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_164_6.setRuntimeParent(_jettag_c_choose_151_5);
                        _jettag_c_when_164_6.setTagInfo(_td_c_when_164_6);
                        _jettag_c_when_164_6.doStart(context, out);
                        JET2Writer _jettag_c_when_164_6_saved_out = out;
                        while (_jettag_c_when_164_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 165, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 165, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 165, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 165, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_164_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_164_6_saved_out;
                        _jettag_c_when_164_6.doEnd();
                        RuntimeTagElement _jettag_c_when_167_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_167_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_167_6.setRuntimeParent(_jettag_c_choose_151_5);
                        _jettag_c_when_167_6.setTagInfo(_td_c_when_167_6);
                        _jettag_c_when_167_6.doStart(context, out);
                        JET2Writer _jettag_c_when_167_6_saved_out = out;
                        while (_jettag_c_when_167_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 168, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 168, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 168, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 168, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.DECIMAL_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_167_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_167_6_saved_out;
                        _jettag_c_when_167_6.doEnd();
                        RuntimeTagElement _jettag_c_when_170_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_170_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_170_6.setRuntimeParent(_jettag_c_choose_151_5);
                        _jettag_c_when_170_6.setTagInfo(_td_c_when_170_6);
                        _jettag_c_when_170_6.doStart(context, out);
                        JET2Writer _jettag_c_when_170_6_saved_out = out;
                        while (_jettag_c_when_170_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 171, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 171, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 171, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 171, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.CURRENCY_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_170_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_170_6_saved_out;
                        _jettag_c_when_170_6.doEnd();
                        _jettag_c_choose_151_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_151_5_saved_out;
                    _jettag_c_choose_151_5.doEnd();
                    _jettag_c_iterate_150_5.handleBodyContent(out);
                }
                _jettag_c_iterate_150_5.doEnd();
                _jettag_c_if_149_2.handleBodyContent(out);
            }
            _jettag_c_if_149_2.doEnd();
            // process parent class level 1 attributes
            RuntimeTagElement _jettag_c_if_177_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_177_2); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_177_2.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_if_177_2.setTagInfo(_td_c_if_177_2);
            _jettag_c_if_177_2.doStart(context, out);
            while (_jettag_c_if_177_2.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_178_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_178_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_178_5.setRuntimeParent(_jettag_c_if_177_2);
                _jettag_c_iterate_178_5.setTagInfo(_td_c_iterate_178_5);
                _jettag_c_iterate_178_5.doStart(context, out);
                while (_jettag_c_iterate_178_5.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_choose_179_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_179_5); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_choose_179_5.setRuntimeParent(_jettag_c_iterate_178_5);
                    _jettag_c_choose_179_5.setTagInfo(_td_c_choose_179_5);
                    _jettag_c_choose_179_5.doStart(context, out);
                    JET2Writer _jettag_c_choose_179_5_saved_out = out;
                    while (_jettag_c_choose_179_5.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        RuntimeTagElement _jettag_c_when_180_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_180_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_180_6.setRuntimeParent(_jettag_c_choose_179_5);
                        _jettag_c_when_180_6.setTagInfo(_td_c_when_180_6);
                        _jettag_c_when_180_6.doStart(context, out);
                        JET2Writer _jettag_c_when_180_6_saved_out = out;
                        while (_jettag_c_when_180_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 181, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 181, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 181, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 181, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.STRING_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_180_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_180_6_saved_out;
                        _jettag_c_when_180_6.doEnd();
                        RuntimeTagElement _jettag_c_when_183_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_183_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_183_6.setRuntimeParent(_jettag_c_choose_179_5);
                        _jettag_c_when_183_6.setTagInfo(_td_c_when_183_6);
                        _jettag_c_when_183_6.doStart(context, out);
                        JET2Writer _jettag_c_when_183_6_saved_out = out;
                        while (_jettag_c_when_183_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 184, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 184, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 184, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 184, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_183_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_183_6_saved_out;
                        _jettag_c_when_183_6.doEnd();
                        RuntimeTagElement _jettag_c_when_186_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_186_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_186_6.setRuntimeParent(_jettag_c_choose_179_5);
                        _jettag_c_when_186_6.setTagInfo(_td_c_when_186_6);
                        _jettag_c_when_186_6.doStart(context, out);
                        JET2Writer _jettag_c_when_186_6_saved_out = out;
                        while (_jettag_c_when_186_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 187, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 187, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 187, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 187, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.DATE_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_186_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_186_6_saved_out;
                        _jettag_c_when_186_6.doEnd();
                        RuntimeTagElement _jettag_c_when_189_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_189_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_189_6.setRuntimeParent(_jettag_c_choose_179_5);
                        _jettag_c_when_189_6.setTagInfo(_td_c_when_189_6);
                        _jettag_c_when_189_6.doStart(context, out);
                        JET2Writer _jettag_c_when_189_6_saved_out = out;
                        while (_jettag_c_when_189_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 190, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 190, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 190, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 190, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.BOOLEAN_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_189_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_189_6_saved_out;
                        _jettag_c_when_189_6.doEnd();
                        RuntimeTagElement _jettag_c_when_192_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_192_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_192_6.setRuntimeParent(_jettag_c_choose_179_5);
                        _jettag_c_when_192_6.setTagInfo(_td_c_when_192_6);
                        _jettag_c_when_192_6.doStart(context, out);
                        JET2Writer _jettag_c_when_192_6_saved_out = out;
                        while (_jettag_c_when_192_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 193, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 193, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 193, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 193, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_192_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_192_6_saved_out;
                        _jettag_c_when_192_6.doEnd();
                        RuntimeTagElement _jettag_c_when_195_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_195_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_195_6.setRuntimeParent(_jettag_c_choose_179_5);
                        _jettag_c_when_195_6.setTagInfo(_td_c_when_195_6);
                        _jettag_c_when_195_6.doStart(context, out);
                        JET2Writer _jettag_c_when_195_6_saved_out = out;
                        while (_jettag_c_when_195_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 196, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 196, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 196, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 196, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.DECIMAL_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_195_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_195_6_saved_out;
                        _jettag_c_when_195_6.doEnd();
                        RuntimeTagElement _jettag_c_when_198_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_198_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_when_198_6.setRuntimeParent(_jettag_c_choose_179_5);
                        _jettag_c_when_198_6.setTagInfo(_td_c_when_198_6);
                        _jettag_c_when_198_6.doStart(context, out);
                        JET2Writer _jettag_c_when_198_6_saved_out = out;
                        while (_jettag_c_when_198_6.okToProcessBody()) {
                            out = out.newNestedContentWriter();
                            out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 199, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("_read_");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 199, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write(", \"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${$attribute/@name}", 199, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\",\"");  //$NON-NLS-1$        
                            out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 199, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                            out.write("\", Field.CURRENCY_FIELD);");  //$NON-NLS-1$        
                            out.write(NL);         
                            _jettag_c_when_198_6.handleBodyContent(out);
                        }
                        out = _jettag_c_when_198_6_saved_out;
                        _jettag_c_when_198_6.doEnd();
                        _jettag_c_choose_179_5.handleBodyContent(out);
                    }
                    out = _jettag_c_choose_179_5_saved_out;
                    _jettag_c_choose_179_5.doEnd();
                    _jettag_c_iterate_178_5.handleBodyContent(out);
                }
                _jettag_c_iterate_178_5.doEnd();
                _jettag_c_if_177_2.handleBodyContent(out);
            }
            _jettag_c_if_177_2.doEnd();
            // process parent class level 0 attributes
            RuntimeTagElement _jettag_c_iterate_205_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_205_5); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_205_5.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_iterate_205_5.setTagInfo(_td_c_iterate_205_5);
            _jettag_c_iterate_205_5.doStart(context, out);
            while (_jettag_c_iterate_205_5.okToProcessBody()) {
                RuntimeTagElement _jettag_c_choose_206_5 = context.getTagFactory().createRuntimeTag(_jetns_c, "choose", "c:choose", _td_c_choose_206_5); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_choose_206_5.setRuntimeParent(_jettag_c_iterate_205_5);
                _jettag_c_choose_206_5.setTagInfo(_td_c_choose_206_5);
                _jettag_c_choose_206_5.doStart(context, out);
                JET2Writer _jettag_c_choose_206_5_saved_out = out;
                while (_jettag_c_choose_206_5.okToProcessBody()) {
                    out = out.newNestedContentWriter();
                    RuntimeTagElement _jettag_c_when_207_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_207_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_207_6.setRuntimeParent(_jettag_c_choose_206_5);
                    _jettag_c_when_207_6.setTagInfo(_td_c_when_207_6);
                    _jettag_c_when_207_6.doStart(context, out);
                    JET2Writer _jettag_c_when_207_6_saved_out = out;
                    while (_jettag_c_when_207_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 208, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 208, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 208, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 208, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.STRING_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_207_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_207_6_saved_out;
                    _jettag_c_when_207_6.doEnd();
                    RuntimeTagElement _jettag_c_when_210_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_210_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_210_6.setRuntimeParent(_jettag_c_choose_206_5);
                    _jettag_c_when_210_6.setTagInfo(_td_c_when_210_6);
                    _jettag_c_when_210_6.doStart(context, out);
                    JET2Writer _jettag_c_when_210_6_saved_out = out;
                    while (_jettag_c_when_210_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 211, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 211, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 211, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 211, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_210_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_210_6_saved_out;
                    _jettag_c_when_210_6.doEnd();
                    RuntimeTagElement _jettag_c_when_213_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_213_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_213_6.setRuntimeParent(_jettag_c_choose_206_5);
                    _jettag_c_when_213_6.setTagInfo(_td_c_when_213_6);
                    _jettag_c_when_213_6.doStart(context, out);
                    JET2Writer _jettag_c_when_213_6_saved_out = out;
                    while (_jettag_c_when_213_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 214, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 214, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 214, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 214, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.DATE_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_213_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_213_6_saved_out;
                    _jettag_c_when_213_6.doEnd();
                    RuntimeTagElement _jettag_c_when_216_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_216_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_216_6.setRuntimeParent(_jettag_c_choose_206_5);
                    _jettag_c_when_216_6.setTagInfo(_td_c_when_216_6);
                    _jettag_c_when_216_6.doStart(context, out);
                    JET2Writer _jettag_c_when_216_6_saved_out = out;
                    while (_jettag_c_when_216_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 217, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 217, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 217, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 217, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.BOOLEAN_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_216_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_216_6_saved_out;
                    _jettag_c_when_216_6.doEnd();
                    RuntimeTagElement _jettag_c_when_219_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_219_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_219_6.setRuntimeParent(_jettag_c_choose_206_5);
                    _jettag_c_when_219_6.setTagInfo(_td_c_when_219_6);
                    _jettag_c_when_219_6.doStart(context, out);
                    JET2Writer _jettag_c_when_219_6_saved_out = out;
                    while (_jettag_c_when_219_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 220, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 220, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 220, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 220, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.NUMERIC_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_219_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_219_6_saved_out;
                    _jettag_c_when_219_6.doEnd();
                    RuntimeTagElement _jettag_c_when_222_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_222_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_222_6.setRuntimeParent(_jettag_c_choose_206_5);
                    _jettag_c_when_222_6.setTagInfo(_td_c_when_222_6);
                    _jettag_c_when_222_6.doStart(context, out);
                    JET2Writer _jettag_c_when_222_6_saved_out = out;
                    while (_jettag_c_when_222_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 223, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 223, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 223, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 223, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.DECIMAL_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_222_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_222_6_saved_out;
                    _jettag_c_when_222_6.doEnd();
                    RuntimeTagElement _jettag_c_when_225_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "when", "c:when", _td_c_when_225_6); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_when_225_6.setRuntimeParent(_jettag_c_choose_206_5);
                    _jettag_c_when_225_6.setTagInfo(_td_c_when_225_6);
                    _jettag_c_when_225_6.doStart(context, out);
                    JET2Writer _jettag_c_when_225_6_saved_out = out;
                    while (_jettag_c_when_225_6.okToProcessBody()) {
                        out = out.newNestedContentWriter();
                        out.write("\t\t\t\t addAndAssignField(R.id.");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 226, 29)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("_read_");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${lower-case($attribute/@name)}", 226, 62)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write(", \"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${$attribute/@name}", 226, 96)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\",\"");  //$NON-NLS-1$        
                        out.write(context.embeddedExpressionAsString("${upper-case($attribute/@name)}", 226, 118)); //$NON-NLS-1$ //$NON-NLS-2$
                        out.write("\", Field.CURRENCY_FIELD);");  //$NON-NLS-1$        
                        out.write(NL);         
                        _jettag_c_when_225_6.handleBodyContent(out);
                    }
                    out = _jettag_c_when_225_6_saved_out;
                    _jettag_c_when_225_6.doEnd();
                    _jettag_c_choose_206_5.handleBodyContent(out);
                }
                out = _jettag_c_choose_206_5_saved_out;
                _jettag_c_choose_206_5.doEnd();
                _jettag_c_iterate_205_5.handleBodyContent(out);
            }
            _jettag_c_iterate_205_5.doEnd();
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected int appTitleBarId() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn R.layout.automanage_title_bar;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected int appTitleBArTextViewId() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn R.id.automanage_title_text;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected String titleText() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn \"Read ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 244, 16)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(" Activity\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tprotected String entityName() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn \"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 249, 11)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("\";");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic Class<?> updateClass() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn Update");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${$class/@name}", 254, 16)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write(".class;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic String getReadURL() {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tLong id = getIntent().getLongExtra(\"id\", new Long(1));");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn ");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${camelCase($projectName)}", 260, 10)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("Welcome.baseURL + \"");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 260, 55)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("/read/\" + id;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic boolean onCreateOptionsMenu(Menu menu) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tMenuInflater inflater = getMenuInflater();");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tinflater.inflate(R.menu.");  //$NON-NLS-1$        
            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 266, 27)); //$NON-NLS-1$ //$NON-NLS-2$
            out.write("_menu, menu);");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn true;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t@Override");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\tpublic boolean onOptionsItemSelected(MenuItem item) {");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\tswitch (item.getItemId()) {");  //$NON-NLS-1$        
            out.write(NL);         
            //process level 1 generizations 
            RuntimeTagElement _jettag_c_if_274_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_274_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_274_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_if_274_1.setTagInfo(_td_c_if_274_1);
            _jettag_c_if_274_1.doStart(context, out);
            while (_jettag_c_if_274_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_setVariable_275_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_275_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_275_6.setRuntimeParent(_jettag_c_if_274_1);
                _jettag_c_setVariable_275_6.setTagInfo(_td_c_setVariable_275_6);
                _jettag_c_setVariable_275_6.doStart(context, out);
                _jettag_c_setVariable_275_6.doEnd();
                // process the assocations for level 1 class 
                RuntimeTagElement _jettag_c_iterate_277_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_277_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_277_8.setRuntimeParent(_jettag_c_if_274_1);
                _jettag_c_iterate_277_8.setTagInfo(_td_c_iterate_277_8);
                _jettag_c_iterate_277_8.doStart(context, out);
                while (_jettag_c_iterate_277_8.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_278_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_278_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_278_9.setRuntimeParent(_jettag_c_iterate_277_8);
                    _jettag_c_iterate_278_9.setTagInfo(_td_c_iterate_278_9);
                    _jettag_c_iterate_278_9.doStart(context, out);
                    while (_jettag_c_iterate_278_9.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_279_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_279_10); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_279_10.setRuntimeParent(_jettag_c_iterate_278_9);
                        _jettag_c_iterate_279_10.setTagInfo(_td_c_iterate_279_10);
                        _jettag_c_iterate_279_10.doStart(context, out);
                        while (_jettag_c_iterate_279_10.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_280_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_280_11); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_280_11.setRuntimeParent(_jettag_c_iterate_279_10);
                            _jettag_c_setVariable_280_11.setTagInfo(_td_c_setVariable_280_11);
                            _jettag_c_setVariable_280_11.doStart(context, out);
                            _jettag_c_setVariable_280_11.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_282_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_282_13); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_282_13.setRuntimeParent(_jettag_c_iterate_279_10);
                            _jettag_c_if_282_13.setTagInfo(_td_c_if_282_13);
                            _jettag_c_if_282_13.doStart(context, out);
                            while (_jettag_c_if_282_13.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_284_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_284_19); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_284_19.setRuntimeParent(_jettag_c_if_282_13);
                                _jettag_c_iterate_284_19.setTagInfo(_td_c_iterate_284_19);
                                _jettag_c_iterate_284_19.doStart(context, out);
                                while (_jettag_c_iterate_284_19.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_286_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_286_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_286_18.setRuntimeParent(_jettag_c_iterate_284_19);
                                    _jettag_c_if_286_18.setTagInfo(_td_c_if_286_18);
                                    _jettag_c_if_286_18.doStart(context, out);
                                    while (_jettag_c_if_286_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_287_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_287_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_287_18.setRuntimeParent(_jettag_c_if_286_18);
                                        _jettag_c_if_287_18.setTagInfo(_td_c_if_287_18);
                                        _jettag_c_if_287_18.doStart(context, out);
                                        while (_jettag_c_if_287_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_288_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_288_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_288_19.setRuntimeParent(_jettag_c_if_287_18);
                                            _jettag_c_setVariable_288_19.setTagInfo(_td_c_setVariable_288_19);
                                            _jettag_c_setVariable_288_19.doStart(context, out);
                                            _jettag_c_setVariable_288_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_290_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_290_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_290_21.setRuntimeParent(_jettag_c_if_287_18);
                                            _jettag_c_if_290_21.setTagInfo(_td_c_if_290_21);
                                            _jettag_c_if_290_21.doStart(context, out);
                                            while (_jettag_c_if_290_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_292_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_292_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_292_19.setRuntimeParent(_jettag_c_if_290_21);
                                                _jettag_c_if_292_19.setTagInfo(_td_c_if_292_19);
                                                _jettag_c_if_292_19.doStart(context, out);
                                                while (_jettag_c_if_292_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_294_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_294_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_294_22.setRuntimeParent(_jettag_c_if_292_19);
                                                    _jettag_c_iterate_294_22.setTagInfo(_td_c_iterate_294_22);
                                                    _jettag_c_iterate_294_22.doStart(context, out);
                                                    while (_jettag_c_iterate_294_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_295_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_295_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_295_23.setRuntimeParent(_jettag_c_iterate_294_22);
                                                        _jettag_c_if_295_23.setTagInfo(_td_c_if_295_23);
                                                        _jettag_c_if_295_23.doStart(context, out);
                                                        while (_jettag_c_if_295_23.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcase R.id.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 296, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("_");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 296, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s_menu:");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIntent ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 297, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent = new Intent(this, ReadAll");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 297, 90)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s.class);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 298, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent.putExtra(\"resource\", getReadURL() + \"/");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 298, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s\");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 299, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent.putExtra(\"parent\",entity.toString());");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstartActivity(");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 300, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbreak;");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_295_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_295_23.doEnd();
                                                        _jettag_c_iterate_294_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_294_22.doEnd();
                                                    _jettag_c_if_292_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_292_19.doEnd();
                                                _jettag_c_if_290_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_290_21.doEnd();
                                            _jettag_c_if_287_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_287_18.doEnd();
                                        _jettag_c_if_286_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_286_18.doEnd();
                                    _jettag_c_iterate_284_19.handleBodyContent(out);
                                }
                                _jettag_c_iterate_284_19.doEnd();
                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_282_13.handleBodyContent(out);
                            }
                            _jettag_c_if_282_13.doEnd();
                            _jettag_c_iterate_279_10.handleBodyContent(out);
                        }
                        _jettag_c_iterate_279_10.doEnd();
                        _jettag_c_iterate_278_9.handleBodyContent(out);
                    }
                    _jettag_c_iterate_278_9.doEnd();
                    _jettag_c_iterate_277_8.handleBodyContent(out);
                }
                _jettag_c_iterate_277_8.doEnd();
                _jettag_c_if_274_1.handleBodyContent(out);
            }
            _jettag_c_if_274_1.doEnd();
            //process level 2 generizations 
            RuntimeTagElement _jettag_c_if_316_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_316_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_if_316_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_if_316_1.setTagInfo(_td_c_if_316_1);
            _jettag_c_if_316_1.doStart(context, out);
            while (_jettag_c_if_316_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_setVariable_317_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_317_6); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_setVariable_317_6.setRuntimeParent(_jettag_c_if_316_1);
                _jettag_c_setVariable_317_6.setTagInfo(_td_c_setVariable_317_6);
                _jettag_c_setVariable_317_6.doStart(context, out);
                _jettag_c_setVariable_317_6.doEnd();
                // process the assocations for level 1 class 
                RuntimeTagElement _jettag_c_iterate_319_8 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_319_8); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_319_8.setRuntimeParent(_jettag_c_if_316_1);
                _jettag_c_iterate_319_8.setTagInfo(_td_c_iterate_319_8);
                _jettag_c_iterate_319_8.doStart(context, out);
                while (_jettag_c_iterate_319_8.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_320_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_320_9); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_320_9.setRuntimeParent(_jettag_c_iterate_319_8);
                    _jettag_c_iterate_320_9.setTagInfo(_td_c_iterate_320_9);
                    _jettag_c_iterate_320_9.doStart(context, out);
                    while (_jettag_c_iterate_320_9.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_iterate_321_10 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_321_10); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_iterate_321_10.setRuntimeParent(_jettag_c_iterate_320_9);
                        _jettag_c_iterate_321_10.setTagInfo(_td_c_iterate_321_10);
                        _jettag_c_iterate_321_10.doStart(context, out);
                        while (_jettag_c_iterate_321_10.okToProcessBody()) {
                            RuntimeTagElement _jettag_c_setVariable_322_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_322_11); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_setVariable_322_11.setRuntimeParent(_jettag_c_iterate_321_10);
                            _jettag_c_setVariable_322_11.setTagInfo(_td_c_setVariable_322_11);
                            _jettag_c_setVariable_322_11.doStart(context, out);
                            _jettag_c_setVariable_322_11.doEnd();
                            // check is the association is corresponding to the class  
                            RuntimeTagElement _jettag_c_if_324_13 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_324_13); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_if_324_13.setRuntimeParent(_jettag_c_iterate_321_10);
                            _jettag_c_if_324_13.setTagInfo(_td_c_if_324_13);
                            _jettag_c_if_324_13.doStart(context, out);
                            while (_jettag_c_if_324_13.okToProcessBody()) {
                                // iterate over the iterations ends  
                                RuntimeTagElement _jettag_c_iterate_326_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_326_19); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_iterate_326_19.setRuntimeParent(_jettag_c_if_324_13);
                                _jettag_c_iterate_326_19.setTagInfo(_td_c_iterate_326_19);
                                _jettag_c_iterate_326_19.doStart(context, out);
                                while (_jettag_c_iterate_326_19.okToProcessBody()) {
                                    // process only non composits or non aggregations and 
                                    RuntimeTagElement _jettag_c_if_328_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_328_18); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_328_18.setRuntimeParent(_jettag_c_iterate_326_19);
                                    _jettag_c_if_328_18.setTagInfo(_td_c_if_328_18);
                                    _jettag_c_if_328_18.doStart(context, out);
                                    while (_jettag_c_if_328_18.okToProcessBody()) {
                                        RuntimeTagElement _jettag_c_if_329_18 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_329_18); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_329_18.setRuntimeParent(_jettag_c_if_328_18);
                                        _jettag_c_if_329_18.setTagInfo(_td_c_if_329_18);
                                        _jettag_c_if_329_18.doStart(context, out);
                                        while (_jettag_c_if_329_18.okToProcessBody()) {
                                            RuntimeTagElement _jettag_c_setVariable_330_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_330_19); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_setVariable_330_19.setRuntimeParent(_jettag_c_if_329_18);
                                            _jettag_c_setVariable_330_19.setTagInfo(_td_c_setVariable_330_19);
                                            _jettag_c_setVariable_330_19.doStart(context, out);
                                            _jettag_c_setVariable_330_19.doEnd();
                                            // get the end secondary end with other class  
                                            RuntimeTagElement _jettag_c_if_332_21 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_332_21); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_332_21.setRuntimeParent(_jettag_c_if_329_18);
                                            _jettag_c_if_332_21.setTagInfo(_td_c_if_332_21);
                                            _jettag_c_if_332_21.doStart(context, out);
                                            while (_jettag_c_if_332_21.okToProcessBody()) {
                                                // check to see if this is a navigable relation
                                                RuntimeTagElement _jettag_c_if_334_19 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_334_19); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_334_19.setRuntimeParent(_jettag_c_if_332_21);
                                                _jettag_c_if_334_19.setTagInfo(_td_c_if_334_19);
                                                _jettag_c_if_334_19.doStart(context, out);
                                                while (_jettag_c_if_334_19.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_336_22 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_336_22); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_336_22.setRuntimeParent(_jettag_c_if_334_19);
                                                    _jettag_c_iterate_336_22.setTagInfo(_td_c_iterate_336_22);
                                                    _jettag_c_iterate_336_22.doStart(context, out);
                                                    while (_jettag_c_iterate_336_22.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_337_23 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_337_23); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_337_23.setRuntimeParent(_jettag_c_iterate_336_22);
                                                        _jettag_c_if_337_23.setTagInfo(_td_c_if_337_23);
                                                        _jettag_c_if_337_23.doStart(context, out);
                                                        while (_jettag_c_if_337_23.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcase R.id.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 338, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("_");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 338, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s_menu:");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIntent ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 339, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent = new Intent(this, ReadAll");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 339, 90)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s.class);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 340, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent.putExtra(\"resource\", getReadURL() + \"/");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 340, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s\");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 341, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent.putExtra(\"parent\",entity.toString());");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstartActivity(");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 342, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbreak;");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_337_23.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_337_23.doEnd();
                                                        _jettag_c_iterate_336_22.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_336_22.doEnd();
                                                    _jettag_c_if_334_19.handleBodyContent(out);
                                                }
                                                _jettag_c_if_334_19.doEnd();
                                                _jettag_c_if_332_21.handleBodyContent(out);
                                            }
                                            _jettag_c_if_332_21.doEnd();
                                            _jettag_c_if_329_18.handleBodyContent(out);
                                        }
                                        _jettag_c_if_329_18.doEnd();
                                        _jettag_c_if_328_18.handleBodyContent(out);
                                    }
                                    _jettag_c_if_328_18.doEnd();
                                    _jettag_c_iterate_326_19.handleBodyContent(out);
                                }
                                _jettag_c_iterate_326_19.doEnd();
                                out.write("\t\t\t\t\t\t\t  \t\t\t\t\t \t\t\t\t\t\t \t \t\t\t\t \t  ");  //$NON-NLS-1$        
                                out.write(NL);         
                                _jettag_c_if_324_13.handleBodyContent(out);
                            }
                            _jettag_c_if_324_13.doEnd();
                            _jettag_c_iterate_321_10.handleBodyContent(out);
                        }
                        _jettag_c_iterate_321_10.doEnd();
                        _jettag_c_iterate_320_9.handleBodyContent(out);
                    }
                    _jettag_c_iterate_320_9.doEnd();
                    _jettag_c_iterate_319_8.handleBodyContent(out);
                }
                _jettag_c_iterate_319_8.doEnd();
                _jettag_c_if_316_1.handleBodyContent(out);
            }
            _jettag_c_if_316_1.doEnd();
            out.write(NL);         
            RuntimeTagElement _jettag_c_setVariable_358_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_358_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_setVariable_358_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_setVariable_358_1.setTagInfo(_td_c_setVariable_358_1);
            _jettag_c_setVariable_358_1.doStart(context, out);
            _jettag_c_setVariable_358_1.doEnd();
            //process 0 level class relations 
            RuntimeTagElement _jettag_c_iterate_360_1 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_360_1); //$NON-NLS-1$ //$NON-NLS-2$
            _jettag_c_iterate_360_1.setRuntimeParent(_jettag_java_format_2_1);
            _jettag_c_iterate_360_1.setTagInfo(_td_c_iterate_360_1);
            _jettag_c_iterate_360_1.doStart(context, out);
            while (_jettag_c_iterate_360_1.okToProcessBody()) {
                RuntimeTagElement _jettag_c_iterate_361_2 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_361_2); //$NON-NLS-1$ //$NON-NLS-2$
                _jettag_c_iterate_361_2.setRuntimeParent(_jettag_c_iterate_360_1);
                _jettag_c_iterate_361_2.setTagInfo(_td_c_iterate_361_2);
                _jettag_c_iterate_361_2.doStart(context, out);
                while (_jettag_c_iterate_361_2.okToProcessBody()) {
                    RuntimeTagElement _jettag_c_iterate_362_3 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_362_3); //$NON-NLS-1$ //$NON-NLS-2$
                    _jettag_c_iterate_362_3.setRuntimeParent(_jettag_c_iterate_361_2);
                    _jettag_c_iterate_362_3.setTagInfo(_td_c_iterate_362_3);
                    _jettag_c_iterate_362_3.doStart(context, out);
                    while (_jettag_c_iterate_362_3.okToProcessBody()) {
                        RuntimeTagElement _jettag_c_setVariable_363_4 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_363_4); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_setVariable_363_4.setRuntimeParent(_jettag_c_iterate_362_3);
                        _jettag_c_setVariable_363_4.setTagInfo(_td_c_setVariable_363_4);
                        _jettag_c_setVariable_363_4.doStart(context, out);
                        _jettag_c_setVariable_363_4.doEnd();
                        // check is the association is corresponding to the class  
                        RuntimeTagElement _jettag_c_if_365_6 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_365_6); //$NON-NLS-1$ //$NON-NLS-2$
                        _jettag_c_if_365_6.setRuntimeParent(_jettag_c_iterate_362_3);
                        _jettag_c_if_365_6.setTagInfo(_td_c_if_365_6);
                        _jettag_c_if_365_6.doStart(context, out);
                        while (_jettag_c_if_365_6.okToProcessBody()) {
                            // iterate over the iterations ends  
                            RuntimeTagElement _jettag_c_iterate_367_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_367_12); //$NON-NLS-1$ //$NON-NLS-2$
                            _jettag_c_iterate_367_12.setRuntimeParent(_jettag_c_if_365_6);
                            _jettag_c_iterate_367_12.setTagInfo(_td_c_iterate_367_12);
                            _jettag_c_iterate_367_12.doStart(context, out);
                            while (_jettag_c_iterate_367_12.okToProcessBody()) {
                                // process only non composits or non aggregations and 
                                RuntimeTagElement _jettag_c_if_369_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_369_12); //$NON-NLS-1$ //$NON-NLS-2$
                                _jettag_c_if_369_12.setRuntimeParent(_jettag_c_iterate_367_12);
                                _jettag_c_if_369_12.setTagInfo(_td_c_if_369_12);
                                _jettag_c_if_369_12.doStart(context, out);
                                while (_jettag_c_if_369_12.okToProcessBody()) {
                                    RuntimeTagElement _jettag_c_setVariable_370_12 = context.getTagFactory().createRuntimeTag(_jetns_c, "setVariable", "c:setVariable", _td_c_setVariable_370_12); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_setVariable_370_12.setRuntimeParent(_jettag_c_if_369_12);
                                    _jettag_c_setVariable_370_12.setTagInfo(_td_c_setVariable_370_12);
                                    _jettag_c_setVariable_370_12.doStart(context, out);
                                    _jettag_c_setVariable_370_12.doEnd();
                                    // get the end secondary end with other class  
                                    RuntimeTagElement _jettag_c_if_372_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_372_14); //$NON-NLS-1$ //$NON-NLS-2$
                                    _jettag_c_if_372_14.setRuntimeParent(_jettag_c_if_369_12);
                                    _jettag_c_if_372_14.setTagInfo(_td_c_if_372_14);
                                    _jettag_c_if_372_14.doStart(context, out);
                                    while (_jettag_c_if_372_14.okToProcessBody()) {
                                        // check to see if this is a navigable relation
                                        RuntimeTagElement _jettag_c_if_374_14 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_374_14); //$NON-NLS-1$ //$NON-NLS-2$
                                        _jettag_c_if_374_14.setRuntimeParent(_jettag_c_if_372_14);
                                        _jettag_c_if_374_14.setTagInfo(_td_c_if_374_14);
                                        _jettag_c_if_374_14.doStart(context, out);
                                        while (_jettag_c_if_374_14.okToProcessBody()) {
                                            // process many on target
                                            RuntimeTagElement _jettag_c_if_376_9 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_376_9); //$NON-NLS-1$ //$NON-NLS-2$
                                            _jettag_c_if_376_9.setRuntimeParent(_jettag_c_if_374_14);
                                            _jettag_c_if_376_9.setTagInfo(_td_c_if_376_9);
                                            _jettag_c_if_376_9.doStart(context, out);
                                            while (_jettag_c_if_376_9.okToProcessBody()) {
                                                RuntimeTagElement _jettag_c_if_377_11 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_377_11); //$NON-NLS-1$ //$NON-NLS-2$
                                                _jettag_c_if_377_11.setRuntimeParent(_jettag_c_if_376_9);
                                                _jettag_c_if_377_11.setTagInfo(_td_c_if_377_11);
                                                _jettag_c_if_377_11.doStart(context, out);
                                                while (_jettag_c_if_377_11.okToProcessBody()) {
                                                    // iterate throught all the classes to get the other class on the association
                                                    RuntimeTagElement _jettag_c_iterate_379_15 = context.getTagFactory().createRuntimeTag(_jetns_c, "iterate", "c:iterate", _td_c_iterate_379_15); //$NON-NLS-1$ //$NON-NLS-2$
                                                    _jettag_c_iterate_379_15.setRuntimeParent(_jettag_c_if_377_11);
                                                    _jettag_c_iterate_379_15.setTagInfo(_td_c_iterate_379_15);
                                                    _jettag_c_iterate_379_15.doStart(context, out);
                                                    while (_jettag_c_iterate_379_15.okToProcessBody()) {
                                                        RuntimeTagElement _jettag_c_if_380_16 = context.getTagFactory().createRuntimeTag(_jetns_c, "if", "c:if", _td_c_if_380_16); //$NON-NLS-1$ //$NON-NLS-2$
                                                        _jettag_c_if_380_16.setRuntimeParent(_jettag_c_iterate_379_15);
                                                        _jettag_c_if_380_16.setTagInfo(_td_c_if_380_16);
                                                        _jettag_c_if_380_16.doStart(context, out);
                                                        while (_jettag_c_if_380_16.okToProcessBody()) {
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tcase R.id.");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class/@name)}", 381, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("_");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 381, 56)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s_menu:");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tIntent ");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 382, 28)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent = new Intent(this, ReadAll");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${$class2/@name}", 382, 90)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s.class);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 383, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent.putExtra(\"resource\", getReadURL() + \"/");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 383, 95)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("s\");");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 384, 21)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent.putExtra(\"parent\",entity.toString());");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tstartActivity(");  //$NON-NLS-1$        
                                                            out.write(context.embeddedExpressionAsString("${lower-case($class2/@name)}", 385, 35)); //$NON-NLS-1$ //$NON-NLS-2$
                                                            out.write("sIntent);");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbreak;");  //$NON-NLS-1$        
                                                            out.write(NL);         
                                                            _jettag_c_if_380_16.handleBodyContent(out);
                                                        }
                                                        _jettag_c_if_380_16.doEnd();
                                                        _jettag_c_iterate_379_15.handleBodyContent(out);
                                                    }
                                                    _jettag_c_iterate_379_15.doEnd();
                                                    _jettag_c_if_377_11.handleBodyContent(out);
                                                }
                                                _jettag_c_if_377_11.doEnd();
                                                _jettag_c_if_376_9.handleBodyContent(out);
                                            }
                                            _jettag_c_if_376_9.doEnd();
                                            _jettag_c_if_374_14.handleBodyContent(out);
                                        }
                                        _jettag_c_if_374_14.doEnd();
                                        _jettag_c_if_372_14.handleBodyContent(out);
                                    }
                                    _jettag_c_if_372_14.doEnd();
                                    _jettag_c_if_369_12.handleBodyContent(out);
                                }
                                _jettag_c_if_369_12.doEnd();
                                _jettag_c_iterate_367_12.handleBodyContent(out);
                            }
                            _jettag_c_iterate_367_12.doEnd();
                            _jettag_c_if_365_6.handleBodyContent(out);
                        }
                        _jettag_c_if_365_6.doEnd();
                        _jettag_c_iterate_362_3.handleBodyContent(out);
                    }
                    _jettag_c_iterate_362_3.doEnd();
                    _jettag_c_iterate_361_2.handleBodyContent(out);
                }
                _jettag_c_iterate_361_2.doEnd();
                _jettag_c_iterate_360_1.handleBodyContent(out);
            }
            _jettag_c_iterate_360_1.doEnd();
            out.write("\t\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t\treturn true;");  //$NON-NLS-1$        
            out.write(NL);         
            out.write("\t}");  //$NON-NLS-1$        
            out.write(NL);         
            out.write(NL);         
            out.write("}");  //$NON-NLS-1$        
            out.write(NL);         
            _jettag_java_format_2_1.handleBodyContent(out);
        }
        out = _jettag_java_format_2_1_saved_out;
        _jettag_java_format_2_1.doEnd();
    }
}
